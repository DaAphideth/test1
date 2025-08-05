/*      */ package nencer.app.Utils;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.bind.JAXBElement;
/*      */ import org.docx4j.TraversalUtil;
/*      */ import org.docx4j.XmlUtils;
/*      */ import org.docx4j.model.fields.ComplexFieldLocator;
/*      */ import org.docx4j.model.fields.FieldRef;
/*      */ import org.docx4j.model.fields.merge.DataFieldName;
/*      */ import org.docx4j.openpackaging.exceptions.Docx4JException;
/*      */ import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
/*      */ import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
/*      */ import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
/*      */ import org.docx4j.wml.Body;
/*      */ import org.docx4j.wml.BooleanDefaultTrue;
/*      */ import org.docx4j.wml.CTFFCheckBox;
/*      */ import org.docx4j.wml.CTFFData;
/*      */ import org.docx4j.wml.CTFFName;
/*      */ import org.docx4j.wml.CTSimpleField;
/*      */ import org.docx4j.wml.FldChar;
/*      */ import org.docx4j.wml.ObjectFactory;
/*      */ import org.docx4j.wml.P;
/*      */ import org.docx4j.wml.R;
/*      */ import org.docx4j.wml.Tbl;
/*      */ import org.docx4j.wml.Tc;
/*      */ import org.docx4j.wml.Text;
/*      */ import org.docx4j.wml.Tr;
/*      */ 
/*      */ public class MailMergeUtil extends MailMerger {
/*   37 */   private static Logger log = LoggerFactory.getLogger(MailMergeUtil.class);
/*      */   
/*      */   public static List<MergeField> getMergeFields(WordprocessingMLPackage input) throws Docx4JException {
/*   40 */     List<MergeField> mergeFields = new ArrayList<>();
/*   41 */     List<String> checkList = new ArrayList<>();
/*   42 */     FieldsPreprocessor.complexifyFields((JaxbXmlPart)input.getMainDocumentPart());
/*      */     
/*   44 */     Body shell = Context.getWmlObjectFactory().createBody();
/*   45 */     shell.getContent().addAll(input.getMainDocumentPart().getContent());
/*   46 */     Body shellClone = (Body)XmlUtils.deepCopy(shell);
/*   47 */     ComplexFieldLocator fl = new ComplexFieldLocator();
/*   48 */     new TraversalUtil(shellClone, (TraversalUtil.Callback)fl);
/*   49 */     log.info("Found " + fl.getStarts().size() + " fields ");
/*   50 */     List<FieldRef> fieldRefs = new ArrayList<>();
/*   51 */     canonicaliseStarts(fl, fieldRefs);
/*   52 */     Iterator<FieldRef> var8 = fieldRefs.iterator();
/*      */     
/*   54 */     String mergeFieldBeginning = "MERGEFIELD ";
/*   55 */     while (var8.hasNext()) {
/*   56 */       FieldRef fr = var8.next();
/*   57 */       if (fr.getFldName().equals("MERGEFIELD")) {
/*   58 */         String instr = extractInstr(fr.getInstructions());
/*   59 */         if (instr == null) {
/*   60 */           log.warn("No instructions found in this field"); continue;
/*      */         } 
/*   62 */         String fieldName = instr.substring(mergeFieldBeginning.length());
/*   63 */         fieldName = formatMergeField(fieldName);
/*   64 */         if (!fieldName.isEmpty() && !checkList.contains(fieldName)) {
/*   65 */           String mergeValue = getMergeValueFromFr(fr);
/*      */           
/*   67 */           MergeField mergeField = new MergeField();
/*   68 */           mergeField.setName(fieldName);
/*   69 */           mergeField.setFullName(instr);
/*   70 */           mergeField.setValue(mergeValue);
/*      */           
/*   72 */           mergeFields.add(mergeField);
/*   73 */           checkList.add(fieldName);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*   80 */     return mergeFields;
/*      */   }
/*      */   
/*      */   private static String getMergeValueFromFr(FieldRef fr) {
/*   84 */     String mergeValue = null;
/*   85 */     String mergeText = getMergeTextFromInstruction(fr.getInstructions());
/*   86 */     if (mergeText == null) return null; 
/*   87 */     if (fr.getParent() instanceof P) {
/*   88 */       P parent = (P)fr.getParent();
/*   89 */       if (parent.getPPr() != null) {
/*   90 */         P p = (P)parent.getPPr().getParent();
/*   91 */         List<Object> parentContent = p.getContent();
/*      */         
/*   93 */         if (parentContent != null && !parentContent.isEmpty()) {
/*   94 */           int startIndex = -1;
/*   95 */           startIndex = getTextMergeFromP(p.getContent(), mergeText);
/*   96 */           if (startIndex != -1) {
/*      */ 
/*      */ 
/*      */             
/*  100 */             int separateIndex = -1;
/*  101 */             int endIndex = -1;
/*  102 */             for (int i = startIndex; i < parentContent.size(); i++) {
/*  103 */               Object child = parentContent.get(i);
/*  104 */               if (child instanceof R) {
/*  105 */                 List<Object> rContent = ((R)child).getContent();
/*  106 */                 if (!rContent.isEmpty()) {
/*  107 */                   String charText = "";
/*  108 */                   for (Object o1 : rContent) {
/*  109 */                     if (o1 instanceof JAXBElement) {
/*  110 */                       JAXBElement<FldChar> element = (JAXBElement)o1;
/*  111 */                       if (element.getValue() instanceof FldChar) {
/*  112 */                         FldChar charType = element.getValue();
/*  113 */                         charText = charText + charType.getFldCharType().name();
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*  117 */                   if (charText.contains("SEPARATE") && 
/*  118 */                     separateIndex == -1) separateIndex = parentContent.indexOf(child);
/*      */                   
/*  120 */                   if (charText.contains("END") && 
/*  121 */                     separateIndex != -1 && endIndex == -1) {
/*  122 */                     endIndex = parentContent.indexOf(child);
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*  128 */             if (separateIndex >= 0 && endIndex >= 0 && endIndex > separateIndex) {
/*  129 */               List<Object> subList = subList(parentContent, separateIndex + 1, endIndex);
/*  130 */               for (Object rValue : subList) {
/*  131 */                 if (rValue instanceof R) {
/*  132 */                   R r = (R)rValue;
/*  133 */                   String s = getRowText(r);
/*  134 */                   if (mergeValue == null) {
/*  135 */                     mergeValue = s; continue;
/*      */                   } 
/*  137 */                   mergeValue = mergeValue + s;
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  148 */     return mergeValue;
/*      */   }
/*      */   
/*      */   private static int getTextMergeFromP(List<Object> list, String mergeText) {
/*  152 */     for (Object o : list) {
/*  153 */       List<Object> texts = getAllElementFromObject(o, Text.class);
/*  154 */       for (Object oT : texts) {
/*  155 */         if (oT instanceof Text) {
/*  156 */           String s = ((Text)oT).getValue();
/*  157 */           if (s.equals(mergeText)) {
/*  158 */             return list.indexOf(o);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  163 */     return -1;
/*      */   }
/*      */   
/*      */   private static String getMergeTextFromInstruction(List<Object> instructions) {
/*  167 */     if (instructions.size() != 1) {
/*  168 */       Iterator var2 = instructions.iterator();
/*      */       
/*  170 */       while (var2.hasNext()) {
/*  171 */         Object i = var2.next();
/*  172 */         i = XmlUtils.unwrap(i);
/*  173 */         if (i instanceof Text) {
/*  174 */           String t = ((Text)i).getValue();
/*  175 */           if (t.contains("MERGEFIELD")) {
/*  176 */             return t;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } else {
/*  181 */       Object o = XmlUtils.unwrap(instructions.get(0));
/*  182 */       if (o instanceof Text) {
/*  183 */         String t = ((Text)o).getValue();
/*  184 */         if (t.contains("MERGEFIELD")) {
/*  185 */           return t;
/*      */         }
/*      */       } else {
/*  188 */         return null;
/*      */       } 
/*      */     } 
/*  191 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Map<String, Object> fillMergeField(byte[] templateBytes, Map<String, String> fieldData) throws Docx4JException {
/*  196 */     WordprocessingMLPackage document = convertFileToDocument(templateBytes);
/*  197 */     if (document == null)
/*  198 */       return buildFillMergeFieldResponse(ApiStatus.FAILED.name(), ErrorCode.READ_DOCUMENT_FAILED.code, ErrorCode.READ_DOCUMENT_FAILED.description, templateBytes); 
/*  199 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*  200 */     List<Object> checkboxes = new ArrayList();
/*      */     try {
/*  202 */       checkboxes.addAll(document.getMainDocumentPart().getJAXBNodesViaXPath("//w:checkBox", false));
/*  203 */     } catch (JAXBException|org.docx4j.jaxb.XPathBinderAssociationIsPartialException e) {
/*  204 */       e.printStackTrace();
/*      */     } 
/*      */     
/*  207 */     Map<DataFieldName, String> dataFields = new HashMap<>();
/*      */ 
/*      */     
/*  210 */     List<String> existedStartEnd = new ArrayList<>();
/*  211 */     for (Map.Entry<String, String> entry : fieldData.entrySet()) {
/*  212 */       if (entry.getValue() != null) {
/*  213 */         String value = entry.getValue();
/*  214 */         if (((String)entry.getKey()).contains("DUPLICATE_")) {
/*      */           
/*  216 */           String[] values = value.split(";#;");
/*  217 */           String start = values[0];
/*  218 */           String end = values[1];
/*      */           
/*  220 */           String groupText = values[2];
/*  221 */           int checkValue = Integer.parseInt(values[3]);
/*  222 */           int amount = Integer.parseInt(values[4]);
/*  223 */           if (start != null && !start.equals("null") && end != null && !end.equals("null")) {
/*      */             
/*  225 */             String startEnd = start + "###" + end;
/*  226 */             if (!existedStartEnd.contains(startEnd)) {
/*  227 */               existedStartEnd.add(startEnd);
/*      */             }
/*  229 */             if (checkValue == 1) {
/*  230 */               duplicate(document, start, end, amount, fieldData, groupText); continue;
/*      */             } 
/*  232 */             deleteParagraphWithStartEnd(document, start, end, fieldData);
/*      */             
/*      */             continue;
/*      */           } 
/*  236 */           duplicateTable(document, groupText, amount, fieldData);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  243 */     for (Map.Entry<String, String> entry : fieldData.entrySet()) {
/*  244 */       if (entry.getValue() != null) {
/*  245 */         String value = entry.getValue();
/*  246 */         if (value.equals("delete")) {
/*  247 */           deleteParagraphByKey(document, entry.getKey());
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  253 */     getStartEndNotExistedInDeleteStartEnd(document, existedStartEnd);
/*      */ 
/*      */     
/*  256 */     deleteParagraphWithStartEnd(document, "START_DELETE", "END_DELETE", fieldData);
/*      */ 
/*      */     
/*  259 */     for (Object o : checkboxes) {
/*  260 */       o = XmlUtils.unwrap(o);
/*  261 */       CTFFCheckBox checkBox = (CTFFCheckBox)o;
/*  262 */       CTFFData data = (CTFFData)checkBox.getParent();
/*  263 */       CTFFName ctffName = ((JAXBElement<CTFFName>)data.getNameOrEnabledOrCalcOnExit().get(0)).getValue();
/*  264 */       String name = ctffName.getVal();
/*      */       
/*  266 */       if (fieldData.containsKey(name) && fieldData.get(name) != null) {
/*  267 */         BooleanDefaultTrue booleanDefaultTrue = new BooleanDefaultTrue();
/*  268 */         booleanDefaultTrue.setVal(Boolean.valueOf(false));
/*  269 */         booleanDefaultTrue.setVal(Boolean.valueOf(((String)fieldData.get(name)).trim().equalsIgnoreCase("true")));
/*  270 */         checkBox.setChecked(booleanDefaultTrue);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  275 */     int htmlIndex = 0;
/*  276 */     for (Map.Entry<String, String> entry : fieldData.entrySet()) {
/*  277 */       if (entry.getValue() != null) {
/*  278 */         String value = entry.getValue();
/*  279 */         if (value.contains("<html>") && value.contains("</html>")) {
/*  280 */           replaceTextByHtml(document, entry.getKey(), value, htmlIndex);
/*  281 */           htmlIndex++; continue;
/*  282 */         }  if (value.contains("\n")) {
/*  283 */           replaceTextByBullets(document, entry.getKey(), entry.getValue()); continue;
/*  284 */         }  if (value.equals("delete"))
/*      */           continue; 
/*  286 */         if (((String)entry.getKey()).contains("DUPLICATE_")) {
/*      */           continue;
/*      */         }
/*  289 */         dataFields.put(new DataFieldName(entry.getKey()), entry.getValue());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  294 */     MailMerger.setMERGEFIELDInOutput(MailMerger.OutputField.KEEP_MERGEFIELD);
/*      */     try {
/*  296 */       MailMerger.performMerge(document, dataFields, false);
/*  297 */       document.save(baos);
/*  298 */       return buildFillMergeFieldResponse(ApiStatus.OK.name(), (String)null, (String)null, baos.toByteArray());
/*  299 */     } catch (Exception e) {
/*  300 */       e.printStackTrace();
/*  301 */       return buildFillMergeFieldResponse(ApiStatus.FAILED.name(), ErrorCode.EXPORT_DOCUMENT_FAILED.code, ErrorCode.EXPORT_DOCUMENT_FAILED.description, templateBytes);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static Map<String, Object> buildFillMergeFieldResponse(String status, String errorCode, String errorMessage, byte[] bytes) {
/*  306 */     Map<String, Object> res = new HashMap<>();
/*  307 */     res.put("exportStatus", status);
/*  308 */     res.put("bytes", bytes);
/*  309 */     if (errorCode != null && !errorCode.isEmpty()) {
/*  310 */       res.put("errorCode", errorCode);
/*      */     }
/*  312 */     if (errorMessage != null && !errorMessage.isEmpty()) {
/*  313 */       res.put("errorMessage", errorMessage);
/*      */     }
/*  315 */     return res;
/*      */   }
/*      */   
/*      */   private static Map<String, Object> getTemplateTable(List<Object> tables, String templateKey) {
/*  319 */     String[] keys = templateKey.split("###");
/*  320 */     for (Object tbl : tables) {
/*  321 */       List<Object> rows = ((Tbl)tbl).getContent();
/*  322 */       for (Object row : rows) {
/*  323 */         int index = rows.indexOf(row);
/*  324 */         if (row instanceof Tr) {
/*  325 */           Tr tr = (Tr)row;
/*      */           
/*  327 */           String rowText = getTrText(tr);
/*  328 */           int sizeRow = tr.getContent().size();
/*  329 */           int match = 0;
/*  330 */           for (String s : keys) {
/*  331 */             if (rowText.contains(s)) {
/*  332 */               match++;
/*      */             }
/*      */           } 
/*  335 */           if ((match / sizeRow) > 0.6D) {
/*  336 */             Map<String, Object> res = new HashMap<>();
/*  337 */             res.put("rowIndex", Integer.valueOf(index));
/*  338 */             res.put("table", tbl);
/*  339 */             return res;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  344 */     return null;
/*      */   }
/*      */   
/*      */   private static void duplicateTable(WordprocessingMLPackage document, String groupText, int amount, Map<String, String> fieldData) {
/*  348 */     List<String> groupFields = new ArrayList<>(Arrays.asList(groupText.split("###")));
/*  349 */     List<Object> tables = getAllElementFromObject(document.getMainDocumentPart(), Tbl.class);
/*  350 */     Map<String, Object> tempTableMap = getTemplateTable(tables, groupText);
/*  351 */     if (tempTableMap == null)
/*  352 */       return;  Tbl tempTable = (Tbl)tempTableMap.get("table");
/*  353 */     int rowIndex = ((Integer)tempTableMap.get("rowIndex")).intValue();
/*      */     
/*  355 */     List<Object> rows = tempTable.getContent();
/*  356 */     Tr templateRow = (Tr)rows.get(rowIndex);
/*  357 */     for (int i = 1; i < amount; i++) {
/*  358 */       Map<String, Object> duplicatedMap = renameMergedFieldAndCheckBox(Collections.singletonList(templateRow), i, fieldData, groupFields, (String)null);
/*  359 */       List<Object> duplicatedTemplate = (List<Object>)duplicatedMap.get("duplicatedRes");
/*  360 */       Boolean checkboxValue = (Boolean)duplicatedMap.get("checkboxValue");
/*  361 */       if (Boolean.TRUE.equals(checkboxValue)) {
/*  362 */         tempTable.getContent().addAll(rowIndex + 1, duplicatedTemplate);
/*  363 */         rowIndex++;
/*      */       }
/*  365 */       else if (haveMergeFieldValue(duplicatedTemplate, fieldData)) {
/*  366 */         tempTable.getContent().addAll(rowIndex + 1, duplicatedTemplate);
/*  367 */         rowIndex++;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
/*  375 */     List<Object> result = new ArrayList();
/*  376 */     if (obj instanceof JAXBElement) obj = ((JAXBElement)obj).getValue();
/*      */     
/*  378 */     if (obj.getClass().equals(toSearch)) {
/*  379 */       result.add(obj);
/*      */     }
/*      */     
/*  382 */     if (obj instanceof ContentAccessor) {
/*  383 */       List<?> children = ((ContentAccessor)obj).getContent();
/*  384 */       for (Object child : children) {
/*  385 */         result.addAll(getAllElementFromObject(child, toSearch));
/*      */       }
/*      */     } 
/*  388 */     return result;
/*      */   }
/*      */   
/*      */   public static Map<String, Object> getAllFields(WordprocessingMLPackage document) {
/*  392 */     List<String> res = new ArrayList<>();
/*  393 */     Object errorTexts = new ArrayList();
/*  394 */     if (document != null) {
/*  395 */       List<MergeField> fields = new ArrayList<>();
/*      */       
/*  397 */       Map<String, Object> mergeFieldMap = getFieldFromTextFields(document);
/*  398 */       errorTexts = mergeFieldMap.get("errorTexts");
/*  399 */       fields.addAll((Collection<? extends MergeField>)mergeFieldMap.get("mergeFields"));
/*      */       
/*  401 */       List<Object> list = getAllElementFromObject(document.getMainDocumentPart(), P.class);
/*  402 */       String text = "";
/*  403 */       for (Object o : list) {
/*  404 */         P p = (P)o;
/*  405 */         String s = getPText(p);
/*  406 */         text = text + s;
/*      */       } 
/*      */       
/*  409 */       List<MergeField> mergeFields = (List<MergeField>)fields.parallelStream().filter(s -> !s.getName().isEmpty()).sorted(Comparator.comparing(MergeField::getLengthFullName).reversed()).collect(Collectors.toList());
/*  410 */       for (MergeField mergeField : mergeFields) {
/*  411 */         mergeField.setIndex(Integer.valueOf(text.indexOf(mergeField.getFullName())));
/*      */         try {
/*  413 */           text = text.replaceAll(mergeField.getFullName(), StringUtils.repeat("#", mergeField.getLengthFullName().intValue()));
/*  414 */         } catch (Exception e) {
/*  415 */           e.printStackTrace();
/*      */         } 
/*      */       } 
/*  418 */       mergeFields.sort(Comparator.comparing(MergeField::getIndex));
/*  419 */       for (MergeField mergeField : mergeFields) {
/*  420 */         if (mergeField.getName().equals("START_DELETE") || mergeField.getName().equals("END_DELETE"))
/*  421 */           continue;  res.add(mergeField.getName());
/*      */       } 
/*      */     } 
/*  424 */     Map<String, Object> mapRes = new HashMap<>();
/*  425 */     mapRes.put("mergeFields", res);
/*  426 */     mapRes.put("errorTexts", errorTexts);
/*  427 */     return mapRes;
/*      */   }
/*      */   
/*      */   public static List<String> getAllFieldsToListString(WordprocessingMLPackage document) {
/*  431 */     List<String> res = new ArrayList<>();
/*      */     try {
/*  433 */       Object errorTexts = new ArrayList();
/*  434 */       if (document != null) {
/*  435 */         List<MergeField> fields = new ArrayList<>();
/*      */         
/*  437 */         Map<String, Object> mergeFieldMap = getFieldFromTextFields(document);
/*  438 */         errorTexts = mergeFieldMap.get("errorTexts");
/*  439 */         fields.addAll((Collection<? extends MergeField>)mergeFieldMap.get("mergeFields"));
/*      */         
/*  441 */         List<Object> list = getAllElementFromObject(document.getMainDocumentPart(), P.class);
/*  442 */         String text = "";
/*  443 */         for (Object o : list) {
/*  444 */           P p = (P)o;
/*  445 */           String s = getPText(p);
/*  446 */           text = text + s;
/*      */         } 
/*      */         
/*  449 */         List<MergeField> mergeFields = (List<MergeField>)fields.parallelStream().filter(s -> !s.getName().isEmpty()).sorted(Comparator.comparing(MergeField::getLengthFullName).reversed()).collect(Collectors.toList());
/*  450 */         for (MergeField mergeField : mergeFields) {
/*  451 */           mergeField.setIndex(Integer.valueOf(text.indexOf(mergeField.getFullName())));
/*      */           try {
/*  453 */             text = text.replaceAll(mergeField.getFullName(), StringUtils.repeat("#", mergeField.getLengthFullName().intValue()));
/*  454 */           } catch (Exception e) {
/*  455 */             e.printStackTrace();
/*      */           } 
/*      */         } 
/*  458 */         mergeFields.sort(Comparator.comparing(MergeField::getIndex));
/*  459 */         for (MergeField mergeField : mergeFields) {
/*  460 */           if (mergeField.getName().equals("START_DELETE") || mergeField.getName().equals("END_DELETE"))
/*      */             continue; 
/*  462 */           res.add(mergeField.getName());
/*      */         } 
/*      */       } 
/*  465 */     } catch (Exception ex) {
/*  466 */       return new ArrayList<>();
/*      */     } 
/*  468 */     return res;
/*      */   }
/*      */   
/*      */   public static List<Map<String, String>> getAllFieldValues(WordprocessingMLPackage document) {
/*  472 */     List<Map<String, String>> res = new ArrayList<>();
/*  473 */     if (document != null) {
/*  474 */       List<MergeField> fields = new ArrayList<>();
/*      */       
/*  476 */       fields.addAll((Collection<? extends MergeField>)getFieldFromTextFields(document).get("mergeFields"));
/*      */       
/*  478 */       List<Object> list = getAllElementFromObject(document.getMainDocumentPart(), P.class);
/*  479 */       String text = "";
/*  480 */       for (Object o : list) {
/*  481 */         P p = (P)o;
/*  482 */         String s = getPText(p);
/*  483 */         text = text + s;
/*      */       } 
/*      */       
/*  486 */       List<MergeField> mergeFields = (List<MergeField>)fields.parallelStream().filter(s -> !s.getName().isEmpty()).sorted(Comparator.comparing(MergeField::getLengthFullName).reversed()).collect(Collectors.toList());
/*  487 */       for (MergeField mergeField : mergeFields) {
/*  488 */         mergeField.setIndex(Integer.valueOf(text.indexOf(mergeField.getFullName())));
/*  489 */         text = text.replaceAll(mergeField.getFullName(), StringUtils.repeat("#", mergeField.getLengthFullName().intValue()));
/*      */       } 
/*  491 */       mergeFields.sort(Comparator.comparing(MergeField::getIndex));
/*  492 */       for (MergeField mergeField : mergeFields) {
/*  493 */         if (!mergeField.getName().equals("START_DELETE") && !mergeField.getName().equals("END_DELETE") && 
/*  494 */           mergeField.getValue() != null && !mergeField.getValue().isEmpty()) {
/*  495 */           Map<String, String> map = new HashMap<>();
/*  496 */           map.put("mergeField", mergeField.getName());
/*  497 */           map.put("value", mergeField.getValue());
/*  498 */           res.add(map);
/*      */         } 
/*      */       } 
/*      */     } 
/*  502 */     return res;
/*      */   }
/*      */   
/*      */   private static String getRowText(Object row) {
/*  506 */     List<?> textElements = getAllElementFromObject(row, Text.class);
/*  507 */     StringBuilder s = new StringBuilder();
/*  508 */     for (Object text : textElements) {
/*  509 */       Text textElement = (Text)text;
/*  510 */       s.append(textElement.getValue());
/*      */     } 
/*  512 */     return s.toString();
/*      */   }
/*      */   
/*      */   private static String getTrText(Tr tr) {
/*  516 */     List<?> textElements = getAllElementFromObject(tr, Text.class);
/*  517 */     List<?> ctSimpleFields = getAllElementFromObject(tr, CTSimpleField.class);
/*  518 */     List<String> s = new ArrayList<>();
/*  519 */     for (Object text : textElements) {
/*  520 */       Text textElement = (Text)text;
/*  521 */       s.add(textElement.getValue());
/*      */     } 
/*  523 */     for (Object text : ctSimpleFields) {
/*  524 */       CTSimpleField simpleField = (CTSimpleField)text;
/*  525 */       s.add(simpleField.getInstr());
/*      */     } 
/*  527 */     return String.join("###", (Iterable)s);
/*      */   }
/*      */   
/*      */   private static String getPText(P p) {
/*  531 */     StringBuilder s = new StringBuilder();
/*  532 */     for (Object o : p.getContent()) {
/*  533 */       o = XmlUtils.unwrap(o);
/*  534 */       String value = "";
/*  535 */       if (o instanceof Text) {
/*  536 */         Text text = (Text)o;
/*  537 */         value = text.getValue();
/*  538 */       } else if (o instanceof CTSimpleField) {
/*  539 */         CTSimpleField text = (CTSimpleField)o;
/*  540 */         value = text.getInstr();
/*  541 */       } else if (o instanceof R) {
/*  542 */         value = getRowText(o);
/*      */       } 
/*      */ 
/*      */       
/*  546 */       s.append(value);
/*      */     } 
/*  548 */     return s.toString();
/*      */   }
/*      */   
/*      */   private static String getPTextAsNormal(P p) {
/*  552 */     List<?> textElements = getAllElementFromObject(p, Text.class);
/*  553 */     StringBuilder s = new StringBuilder();
/*  554 */     for (Object text : textElements) {
/*  555 */       Text textElement = (Text)text;
/*  556 */       String value = textElement.getValue();
/*  557 */       if (value.contains("MERGEFORMAT") || value.contains("MERGEFIELD") || value
/*  558 */         .contains("FORMCHECKBOX") || value.contains("FORMTEXT")) {
/*      */         continue;
/*      */       }
/*  561 */       s.append(value);
/*      */     } 
/*  563 */     return s.toString();
/*      */   }
/*      */   
/*      */   public static Map<String, String> prepareMergedField(List<MergeFieldDTO> fields) {
/*  567 */     Map<String, String> mergeFields = new HashMap<>();
/*  568 */     Map<String, Integer> counter = new HashMap<>();
/*  569 */     Map<String, Integer> checkValue = new HashMap<>();
/*  570 */     Map<String, List<String>> groupTexts = new HashMap<>();
/*  571 */     for (MergeFieldDTO field : fields) {
/*  572 */       if (field == null) {
/*      */         continue;
/*      */       }
/*      */       
/*  576 */       if (field.getIsGroup() != null && Boolean.TRUE.equals(field.getIsGroup())) {
/*  577 */         String code = field.getCode();
/*  578 */         if (!checkValue.containsKey(code)) {
/*  579 */           checkValue.put(code, Integer.valueOf(0));
/*      */         }
/*  581 */         if (!groupTexts.containsKey(code)) {
/*  582 */           groupTexts.put(code, new ArrayList<>());
/*      */         }
/*  584 */         String groupStartName = getGroupStartName(field.getStartGroup());
/*  585 */         Integer index = counter.get(code);
/*      */ 
/*      */         
/*  588 */         for (MergeFieldDTO dcField : field.getChildren()) {
/*  589 */           String value = dcField.getValue();
/*  590 */           if (value != null && !value.isEmpty() && (
/*  591 */             (Integer)checkValue.get(code)).equals(Integer.valueOf(0))) {
/*  592 */             checkValue.put(code, Integer.valueOf(1));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  597 */           computeSum(value, mergeFields, field, dcField);
/*  598 */           if (groupStartName != null && !groupStartName.isEmpty()) {
/*  599 */             if (!((List)groupTexts.get(code)).contains(groupStartName + "_" + dcField.getMergeField())) {
/*  600 */               ((List<String>)groupTexts.get(code)).add(groupStartName + "_" + dcField.getMergeField());
/*      */             }
/*  602 */             if (index == null) {
/*  603 */               mergeFields.put(groupStartName + "_" + dcField.getMergeField(), formatValue(value));
/*      */             } else {
/*  605 */               String str = (new StringBuilder()).append(counter.get(code)).append("_").append(groupStartName).append("_").append(dcField.getMergeField()).toString();
/*  606 */               mergeFields.put(str, formatValue(value));
/*      */             } 
/*      */           } 
/*  609 */           if (!((List)groupTexts.get(code)).contains(dcField.getMergeField())) {
/*  610 */             ((List<String>)groupTexts.get(code)).add(dcField.getMergeField());
/*      */           }
/*  612 */           if (index == null) {
/*  613 */             mergeFields.put(dcField.getMergeField(), formatValue(value)); continue;
/*      */           } 
/*  615 */           String key = (new StringBuilder()).append(counter.get(code)).append("_").append(dcField.getMergeField()).toString();
/*  616 */           mergeFields.put(key, formatValue(value));
/*      */         } 
/*      */         
/*  619 */         String startEnd = field.getStartGroup() + ";#;" + field.getEndGroup() + ";#;" + String.join("###", (Iterable<? extends CharSequence>)groupTexts.get(code)) + ";#;" + checkValue.get(code);
/*  620 */         String keyDuplicate = "DUPLICATE_" + code;
/*  621 */         if (index == null) {
/*  622 */           counter.put(code, Integer.valueOf(1));
/*  623 */           mergeFields.put(keyDuplicate, startEnd + ";#;" + counter.get(code));
/*      */         } else {
/*  625 */           counter.replace(code, Integer.valueOf(((Integer)counter.get(code)).intValue() + 1));
/*  626 */           mergeFields.replace(keyDuplicate, startEnd + ";#;" + counter.get(code));
/*      */         } 
/*      */         
/*  629 */         String keyCount = "COUNT_" + field.getMergeField();
/*  630 */         if (!mergeFields.containsKey(keyCount)) {
/*  631 */           mergeFields.put(keyCount, String.valueOf(1)); continue;
/*      */         } 
/*  633 */         mergeFields.put(keyCount, String.valueOf(Integer.parseInt(mergeFields.get(keyCount)) + 1));
/*      */         
/*      */         continue;
/*      */       } 
/*  637 */       if (field.getMergeField() != null && !field.getMergeField().isEmpty()) {
/*  638 */         mergeFields.put(field.getMergeField(), formatValue(field.getValue()));
/*      */       }
/*      */     } 
/*      */     
/*  642 */     for (String key : mergeFields.keySet()) {
/*  643 */       mergeFields.put(key, formatValue(mergeFields.get(key)));
/*      */     }
/*  645 */     return mergeFields;
/*      */   }
/*      */   
/*      */   private static String getGroupStartName(String start) {
/*  649 */     if (start != null && start.contains("START_")) {
/*  650 */       return start.split("START_")[1];
/*      */     }
/*  652 */     return start;
/*      */   }
/*      */   
/*      */   private static String checkIfMoneyValue(String value) {
/*  656 */     if (value == null) return null; 
/*  657 */     if (value.contains(MoneyUtil.money)) {
/*  658 */       String removedValue = value.replace(MoneyUtil.money, "");
/*  659 */       if (NumberUtils.isDigits(removedValue)) {
/*  660 */         return removedValue;
/*      */       }
/*      */     } 
/*  663 */     return null;
/*      */   }
/*      */   
/*      */   private static String checkIfPercentValue(String value) {
/*  667 */     if (value == null) return null; 
/*  668 */     if (value.contains(NumberFormatUtil.percent)) {
/*  669 */       String removedValue = value.replace(NumberFormatUtil.percent, "");
/*  670 */       if (NumberUtils.isParsable(removedValue)) {
/*  671 */         return removedValue;
/*      */       }
/*      */     } 
/*  674 */     return null;
/*      */   }
/*      */   
/*      */   private static String formatValue(String value) {
/*  678 */     if (value == null) return ""; 
/*  679 */     String moneyValue = checkIfMoneyValue(value);
/*  680 */     if (moneyValue != null) {
/*  681 */       return MoneyUtil.format(Long.valueOf(Long.parseLong(moneyValue)));
/*      */     }
/*  683 */     String percentValue = checkIfPercentValue(value);
/*  684 */     if (percentValue != null) {
/*  685 */       return NumberFormatUtil.formatPercentNumber(Double.valueOf(Double.parseDouble(percentValue)));
/*      */     }
/*  687 */     return value;
/*      */   }
/*      */   
/*      */   private static void computeSum(String value, Map<String, String> mergeFields, MergeFieldDTO field, MergeFieldDTO dcField) {
/*  691 */     if (NumberUtils.isDigits(value)) {
/*  692 */       computeSumValues(value, mergeFields, field, dcField);
/*      */     } else {
/*  694 */       String moneyValue = checkIfMoneyValue(value);
/*  695 */       if (moneyValue != null) {
/*  696 */         computeSumMoneyValues(moneyValue, mergeFields, field, dcField);
/*      */       }
/*  698 */       String percentValue = checkIfPercentValue(value);
/*  699 */       if (percentValue != null) {
/*  700 */         computeSumPercentValues(percentValue, mergeFields, field, dcField);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void computeSumValues(String value, Map<String, String> mergeFields, MergeFieldDTO field, MergeFieldDTO dcField) {
/*      */     try {
/*  707 */       long longValue = Long.parseLong(value);
/*  708 */       String keySum = "SUM_" + field.getMergeField() + "_" + dcField.getMergeField();
/*  709 */       if (!mergeFields.containsKey(keySum)) {
/*  710 */         mergeFields.put(keySum, value);
/*      */       } else {
/*  712 */         mergeFields.put(keySum, String.valueOf(Long.parseLong(mergeFields.get(keySum)) + longValue));
/*      */       } 
/*  714 */     } catch (Exception e) {
/*  715 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void computeSumMoneyValues(String value, Map<String, String> mergeFields, MergeFieldDTO field, MergeFieldDTO dcField) {
/*      */     try {
/*  721 */       long longValue = Long.parseLong(value);
/*  722 */       String keySum = "SUM_" + field.getMergeField() + "_" + dcField.getMergeField();
/*  723 */       if (!mergeFields.containsKey(keySum)) {
/*  724 */         mergeFields.put(keySum, MoneyUtil.money + value);
/*      */       } else {
/*  726 */         String digitValue = checkIfMoneyValue(mergeFields.get(keySum));
/*  727 */         mergeFields.put(keySum, MoneyUtil.money + (Long.parseLong(digitValue) + longValue));
/*      */       } 
/*  729 */     } catch (Exception e) {
/*  730 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void computeSumPercentValues(String value, Map<String, String> mergeFields, MergeFieldDTO field, MergeFieldDTO dcField) {
/*      */     try {
/*  736 */       double doubleValue = Double.parseDouble(value);
/*  737 */       String keySum = "SUM_" + field.getMergeField() + "_" + dcField.getMergeField();
/*  738 */       if (!mergeFields.containsKey(keySum)) {
/*  739 */         mergeFields.put(keySum, NumberFormatUtil.percent + value);
/*      */       } else {
/*  741 */         String digitValue = checkIfPercentValue(mergeFields.get(keySum));
/*  742 */         mergeFields.put(keySum, NumberFormatUtil.percent + (Double.parseDouble(digitValue) + doubleValue));
/*      */       } 
/*  744 */     } catch (Exception e) {
/*  745 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static Map<String, Object> getFieldFromTextFields(List<Object> textFields) {
/*  750 */     List<MergeField> mergeFields = new ArrayList<>();
/*  751 */     List<Map<String, String>> errorTexts = new ArrayList<>();
/*  752 */     List<String> errorCheckList = new ArrayList<>();
/*  753 */     List<String> checkList = new ArrayList<>();
/*  754 */     for (Object o : textFields) {
/*  755 */       o = XmlUtils.unwrap(o);
/*  756 */       String value = "";
/*  757 */       List<Object> parentContent = null;
/*  758 */       P parent = null;
/*  759 */       int startIndex = -1;
/*  760 */       if (o instanceof Text) {
/*  761 */         Text text = (Text)o;
/*  762 */         value = text.getValue();
/*  763 */         if (text.getParent() instanceof R) {
/*  764 */           R rParent = (R)text.getParent();
/*  765 */           if (rParent.getParent() instanceof P) {
/*  766 */             parent = (P)rParent.getParent();
/*  767 */             parentContent = parent.getContent();
/*  768 */             startIndex = parentContent.indexOf(rParent);
/*      */           } 
/*      */         } 
/*  771 */       } else if (o instanceof CTSimpleField) {
/*  772 */         CTSimpleField text = (CTSimpleField)o;
/*  773 */         value = text.getInstr();
/*  774 */         if (text.getParent() instanceof P) {
/*  775 */           parent = (P)text.getParent();
/*  776 */           parentContent = parent.getContent();
/*  777 */           startIndex = parentContent.indexOf(text);
/*      */         } 
/*      */       } 
/*  780 */       String pText = getPTextAsNormal(parent);
/*      */       
/*  782 */       String mergeFieldBeginning = "MERGEFIELD ";
/*  783 */       if (value.contains(mergeFieldBeginning)) {
/*  784 */         String mergeValue = null;
/*  785 */         if (parentContent != null && !parentContent.isEmpty()) {
/*      */           
/*  787 */           int separateIndex = -1;
/*  788 */           int endIndex = -1;
/*  789 */           for (int i = startIndex; i < parentContent.size(); i++) {
/*  790 */             Object child = parentContent.get(i);
/*  791 */             if (child instanceof R) {
/*  792 */               List<Object> rContent = ((R)child).getContent();
/*  793 */               if (!rContent.isEmpty()) {
/*  794 */                 String charText = "";
/*  795 */                 for (Object o1 : rContent) {
/*  796 */                   if (o1 instanceof JAXBElement) {
/*  797 */                     JAXBElement<FldChar> element = (JAXBElement)o1;
/*  798 */                     if (element.getValue() instanceof FldChar) {
/*  799 */                       FldChar charType = element.getValue();
/*  800 */                       charText = charText + charType.getFldCharType().name();
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*  804 */                 if (charText.contains("SEPARATE") && 
/*  805 */                   separateIndex == -1) separateIndex = parentContent.indexOf(child);
/*      */                 
/*  807 */                 if (charText.contains("END") && 
/*  808 */                   separateIndex != -1 && endIndex == -1) {
/*  809 */                   endIndex = parentContent.indexOf(child);
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  819 */           if (separateIndex >= 0 && endIndex >= 0 && endIndex > separateIndex) {
/*  820 */             List<Object> subList = subList(parentContent, separateIndex + 1, endIndex);
/*  821 */             for (Object rValue : subList) {
/*  822 */               if (rValue instanceof R) {
/*  823 */                 R r = (R)rValue;
/*  824 */                 String s = getRowText(r);
/*  825 */                 if (mergeValue == null) {
/*  826 */                   mergeValue = s; continue;
/*      */                 } 
/*  828 */                 mergeValue = mergeValue + s;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  834 */         String fieldName = value.substring(mergeFieldBeginning.length());
/*  835 */         fieldName = formatMergeField(fieldName);
/*  836 */         if (!fieldName.isEmpty() && !checkList.contains(fieldName)) {
/*  837 */           MergeField mergeField = new MergeField();
/*  838 */           mergeField.setName(fieldName);
/*  839 */           mergeField.setFullName(value);
/*  840 */           mergeFields.add(mergeField);
/*  841 */           mergeField.setValue(mergeValue);
/*  842 */           checkList.add(fieldName);
/*      */         }  continue;
/*      */       } 
/*  845 */       if (Boolean.TRUE.equals(checkIfMergeFieldError(value, parentContent, startIndex, errorTexts, pText, errorCheckList))) {
/*  846 */         Map<String, String> errorMap = new HashMap<>();
/*  847 */         errorMap.put("error", value);
/*  848 */         errorMap.put("paragraph", pText);
/*      */         
/*  850 */         String errorTextKey = value + "###" + pText;
/*  851 */         if (!errorCheckList.contains(errorTextKey)) {
/*  852 */           errorCheckList.add(errorTextKey);
/*  853 */           errorTexts.add(errorMap);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  859 */     Map<String, Object> res = new HashMap<>();
/*  860 */     res.put("mergeFields", mergeFields);
/*  861 */     res.put("errorTexts", errorTexts);
/*  862 */     return res;
/*      */   }
/*      */   
/*      */   private static Map<String, Object> getFieldFromTextFields(WordprocessingMLPackage input) {
/*  866 */     List<MergeField> mergeFields = new ArrayList<>();
/*  867 */     List<Map<String, String>> errorTexts = new ArrayList<>();
/*      */     try {
/*  869 */       mergeFields = getMergeFields(input);
/*  870 */     } catch (Exception e) {
/*  871 */       e.printStackTrace();
/*      */     } 
/*      */     
/*  874 */     Map<String, Object> res = new HashMap<>();
/*  875 */     res.put("mergeFields", mergeFields);
/*  876 */     res.put("errorTexts", errorTexts);
/*  877 */     return res;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Boolean checkIfMergeFieldError(String value, List<Object> parentContent, int startIndex, List<Map<String, String>> errorTexts, String pText, List<String> errorCheckList) {
/*  882 */     if (value.contains("FORMTEXT") || value
/*  883 */       .contains("FORMCHECKBOX"))
/*  884 */       return Boolean.valueOf(false); 
/*  885 */     if (value.contains("REF")) {
/*  886 */       String refValue = value.trim();
/*  887 */       if (refValue.startsWith("REF")) {
/*  888 */         return Boolean.valueOf(false);
/*      */       }
/*  890 */     } else if (value.contains("\\* MERGEFORMAT") || value
/*  891 */       .contains("MERGEFORMAT")) {
/*  892 */       String refValue = value.trim();
/*  893 */       if ((refValue.equals("\\* MERGEFORMAT") || refValue
/*  894 */         .equals("MERGEFORMAT")) && 
/*  895 */         parentContent != null && !parentContent.isEmpty()) {
/*  896 */         Object previousO = parentContent.get(startIndex - 1);
/*  897 */         if (previousO != null) {
/*  898 */           String textO = getRowText(previousO).trim();
/*  899 */           if (!textO.startsWith("REF") && !textO.isEmpty()) {
/*      */ 
/*      */             
/*  902 */             Map<String, String> errorMap = new HashMap<>();
/*  903 */             errorMap.put("error", textO);
/*  904 */             errorMap.put("paragraph", pText);
/*      */             
/*  906 */             String errorTextKey = textO + "###" + pText;
/*  907 */             if (!errorCheckList.contains(errorTextKey)) {
/*  908 */               errorCheckList.add(errorTextKey);
/*  909 */               errorTexts.add(errorMap);
/*      */             } 
/*      */           } 
/*  912 */           return Boolean.valueOf(false);
/*      */         }
/*      */       
/*      */       } 
/*  916 */     } else if (!value.isEmpty() && value.trim().isEmpty()) {
/*  917 */       String textTillLatestEnd = null;
/*  918 */       if (parentContent != null && !parentContent.isEmpty()) {
/*      */         
/*  920 */         int foundNextStart = -1;
/*  921 */         int endIndex = -1;
/*  922 */         for (int i = startIndex; i < parentContent.size(); i++) {
/*  923 */           Object child = parentContent.get(i);
/*  924 */           if (child instanceof R) {
/*  925 */             List<Object> rContent = ((R)child).getContent();
/*  926 */             if (!rContent.isEmpty()) {
/*  927 */               String charText = "";
/*  928 */               for (Object o1 : rContent) {
/*  929 */                 if (o1 instanceof JAXBElement) {
/*  930 */                   JAXBElement<FldChar> element = (JAXBElement)o1;
/*  931 */                   if (element.getValue() instanceof FldChar) {
/*  932 */                     FldChar charType = element.getValue();
/*  933 */                     charText = charText + charType.getFldCharType().name();
/*      */                   } 
/*      */                 } 
/*      */               } 
/*  937 */               if (charText.contains("BEGIN") && 
/*  938 */                 endIndex == -1) {
/*  939 */                 foundNextStart = parentContent.indexOf(child);
/*      */                 
/*      */                 break;
/*      */               } 
/*  943 */               if (charText.contains("END") && 
/*  944 */                 endIndex == -1) {
/*  945 */                 endIndex = parentContent.indexOf(child);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  951 */         if (foundNextStart == -1 && endIndex >= 0 && endIndex > startIndex) {
/*  952 */           List<Object> subList = subList(parentContent, startIndex + 1, endIndex);
/*  953 */           for (Object rValue : subList) {
/*  954 */             String s = getRowText(rValue);
/*  955 */             if (textTillLatestEnd == null) {
/*  956 */               textTillLatestEnd = s; continue;
/*      */             } 
/*  958 */             textTillLatestEnd = textTillLatestEnd + s;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  965 */       if (textTillLatestEnd == null) return Boolean.valueOf(false); 
/*  966 */       if (textTillLatestEnd.contains("FORMCHECKBOX") || textTillLatestEnd
/*  967 */         .contains("FORMTEXT") || textTillLatestEnd
/*  968 */         .contains("REF")) {
/*  969 */         return Boolean.valueOf(false);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  974 */     return Boolean.valueOf(true);
/*      */   }
/*      */   
/*      */   public static String formatMergeField(String field) {
/*  978 */     String mergeFormat = "\\* MERGEFORMAT";
/*  979 */     StringBuilder sb = new StringBuilder();
/*  980 */     if (field.lastIndexOf(mergeFormat) != -1)
/*  981 */       field = field.substring(0, field.lastIndexOf(mergeFormat)); 
/*  982 */     for (int i = 0; i < field.length(); i++) {
/*  983 */       char c = field.charAt(i);
/*  984 */       if (c != '"')
/*  985 */         sb.append(c); 
/*      */     } 
/*  987 */     return sb.toString().trim();
/*      */   }
/*      */   
/*      */   public static WordprocessingMLPackage convertFileToDocument(byte[] file) {
/*  991 */     WordprocessingMLPackage document = null;
/*      */     try {
/*  993 */       InputStream is = new ByteArrayInputStream(file);
/*  994 */       document = WordprocessingMLPackage.load(is);
/*  995 */     } catch (Docx4JException e) {
/*  996 */       e.printStackTrace();
/*      */     } 
/*  998 */     return document;
/*      */   }
/*      */   
/*      */   private static void replaceTextByHtml(WordprocessingMLPackage wordPackage, String key, String html, int htmlIndex) throws Docx4JException {
/* 1002 */     MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
/* 1003 */     List<P> paragraphs = getAllParagraphs(mainDocumentPart);
/* 1004 */     for (P paragraph : paragraphs) {
/* 1005 */       String identifier = getPText(paragraph);
/* 1006 */       if (identifier.contains(key)) {
/* 1007 */         List<Object> listToModify = getListToModify(paragraph, mainDocumentPart);
/* 1008 */         if (listToModify != null && 
/* 1009 */           Boolean.TRUE.equals(Boolean.valueOf(existMergeFieldsInObject(Collections.singletonList(paragraph), key)))) {
/* 1010 */           ObjectFactory factory = new ObjectFactory();
/* 1011 */           AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(new PartName("/hw" + htmlIndex + ".html"));
/* 1012 */           afiPart.setBinaryData(html.getBytes());
/* 1013 */           afiPart.setContentType(new ContentType("text/html"));
/* 1014 */           Relationship altChunkRel = wordPackage.getMainDocumentPart().addTargetPart((Part)afiPart);
/* 1015 */           CTAltChunk ac = Context.getWmlObjectFactory().createCTAltChunk();
/* 1016 */           ac.setId(altChunkRel.getId());
/*      */           
/* 1018 */           int index = listToModify.indexOf(paragraph);
/*      */           
/* 1020 */           listToModify.remove(index);
/*      */           
/* 1022 */           listToModify.add(index, ac);
/* 1023 */           if (paragraph.getParent() instanceof Tc) {
/* 1024 */             List<Object> subList = subList(listToModify, index + 1, listToModify.size());
/* 1025 */             if (Boolean.FALSE.equals(Boolean.valueOf(checkPInObject(subList))) && 
/* 1026 */               checkTableAtTheEndOfHtml(html)) {
/* 1027 */               P p = factory.createP();
/* 1028 */               listToModify.add(p);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean checkTableAtTheEndOfHtml(String text) {
/* 1039 */     List<String> tablePatterns = new ArrayList<>(Arrays.asList(new String[] { "<table>", "</table>", "<table/>" }));
/* 1040 */     List<String> pPatterns = new ArrayList<>(Arrays.asList(new String[] { "<p>", "</p>", "<p/>" }));
/*      */     
/* 1042 */     Pattern pattern = Pattern.compile("<[a-z/]*>");
/* 1043 */     Matcher matcher = pattern.matcher(text);
/* 1044 */     List<String> res = new ArrayList<>();
/* 1045 */     while (matcher.find()) {
/* 1046 */       String s = matcher.group();
/* 1047 */       res.add(s);
/*      */     } 
/*      */     
/* 1050 */     int lastTableIndex = -1;
/* 1051 */     int lastPIndex = -1;
/*      */     
/* 1053 */     for (int i = res.size() - 1; i >= 0; i--) {
/* 1054 */       if (tablePatterns.contains(res.get(i)) && lastTableIndex == -1) {
/* 1055 */         lastTableIndex = i;
/*      */       }
/* 1057 */       if (pPatterns.contains(res.get(i)) && lastPIndex == -1) {
/* 1058 */         lastPIndex = i;
/*      */       }
/* 1060 */       if (lastTableIndex != -1 && lastPIndex != -1)
/*      */         break; 
/*      */     } 
/* 1063 */     if (lastTableIndex > lastPIndex) {
/* 1064 */       return true;
/*      */     }
/* 1066 */     return false;
/*      */   }
/*      */   
/*      */   private static boolean checkPInObject(List<Object> list) {
/* 1070 */     if (list == null || list.isEmpty()) return false; 
/* 1071 */     Object lastObject = list.get(list.size() - 1);
/* 1072 */     if (lastObject instanceof P) {
/* 1073 */       return true;
/*      */     }
/* 1075 */     return false;
/*      */   }
/*      */   
/*      */   private static void replaceTextByBullets(WordprocessingMLPackage document, String key, String text) {
/* 1079 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/* 1080 */     List<P> paragraphs = getAllParagraphs(mainPart);
/* 1081 */     for (P paragraph : paragraphs) {
/* 1082 */       String identifier = getPText(paragraph);
/* 1083 */       if (identifier.contains(key)) {
/* 1084 */         String prefix = "";
/* 1085 */         if (identifier.lastIndexOf("MERGEFIELD") != -1)
/* 1086 */           prefix = identifier.substring(0, identifier.lastIndexOf("MERGEFIELD")); 
/* 1087 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1088 */         if (listToModify != null && 
/* 1089 */           Boolean.TRUE.equals(Boolean.valueOf(existMergeFieldsInObject(Collections.singletonList(paragraph), key)))) {
/* 1090 */           int index = listToModify.indexOf(paragraph);
/*      */           
/* 1092 */           listToModify.remove(index);
/* 1093 */           listToModify.addAll(index, createBullets(prefix, text, paragraph));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void deleteParagraphByKey(WordprocessingMLPackage document, String key) {
/* 1101 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/* 1102 */     List<P> paragraphs = getAllParagraphs(mainPart);
/* 1103 */     for (P paragraph : paragraphs) {
/* 1104 */       String identifier = getPText(paragraph);
/* 1105 */       if (identifier.contains(key)) {
/* 1106 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1107 */         if (listToModify != null && 
/* 1108 */           Boolean.TRUE.equals(Boolean.valueOf(existMergeFieldsInObject(Collections.singletonList(paragraph), key)))) {
/*      */           
/* 1110 */           listToModify.remove(paragraph);
/* 1111 */           if (paragraph.getParent() instanceof Tc) {
/* 1112 */             handleTcInRemove(listToModify, paragraph);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void removeRowFromTable(P paragraph) {
/* 1121 */     Tc tc = (Tc)paragraph.getParent();
/* 1122 */     if (tc.getParent() instanceof Tr) {
/* 1123 */       Tr tr = (Tr)tc.getParent();
/* 1124 */       if (tr.getParent() instanceof Tbl) {
/* 1125 */         Tbl tbl = (Tbl)tr.getParent();
/* 1126 */         tbl.getContent().remove(tr);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void deleteParagraphWithStartEnd(WordprocessingMLPackage document, String start, String end, Map<String, String> fieldData) {
/* 1132 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/* 1133 */     List<Map<String, Object>> tableSearchRes = startEndInTable(start, end, mainPart);
/* 1134 */     if (!tableSearchRes.isEmpty()) {
/* 1135 */       for (Map<String, Object> tableSearch : tableSearchRes) {
/* 1136 */         List<Object> template = (List<Object>)tableSearch.get("template");
/* 1137 */         Tbl table = (Tbl)tableSearch.get("table");
/* 1138 */         int startIndex = ((Integer)tableSearch.get("startIndex")).intValue();
/* 1139 */         int endIndex = ((Integer)tableSearch.get("endIndex")).intValue();
/* 1140 */         table.getContent().remove(endIndex);
/* 1141 */         table.getContent().remove(startIndex);
/* 1142 */         if (!haveMergeFieldValue(template, fieldData))
/*      */         {
/* 1144 */           table.getContent().removeAll(template);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1150 */     List<P> paragraphs = getAllParagraphs(mainPart); int i;
/* 1151 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1152 */       P paragraph = paragraphs.get(i);
/* 1153 */       String identifier = getPText(paragraph);
/* 1154 */       if (identifier.contains(start) && identifier.contains(end)) {
/*      */         
/* 1156 */         List<Object> rows = paragraph.getContent();
/* 1157 */         List<String> startEndFounds = new ArrayList<>();
/* 1158 */         int k = 0;
/* 1159 */         while (k < rows.size()) {
/* 1160 */           Object o = rows.get(k);
/* 1161 */           String rowT = getRowText(o);
/* 1162 */           if (rowT.contains(start)) {
/*      */             int startIndex;
/* 1164 */             if (o instanceof R) {
/* 1165 */               startIndex = rows.indexOf(o) - 1;
/* 1166 */               for (int m = startIndex; m > 0; m--) {
/* 1167 */                 if (rows.get(m) instanceof R) {
/* 1168 */                   R r = (R)rows.get(m);
/* 1169 */                   String charText = "";
/* 1170 */                   for (Object o1 : r.getContent()) {
/* 1171 */                     if (o1 instanceof JAXBElement) {
/* 1172 */                       JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1173 */                       if (element.getValue() instanceof FldChar) {
/* 1174 */                         FldChar charType = element.getValue();
/* 1175 */                         charText = charText + charType.getFldCharType().name();
/*      */                       } 
/*      */                     } 
/*      */                   } 
/* 1179 */                   if (charText.contains("BEGIN")) {
/* 1180 */                     startIndex = m;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } else {
/* 1186 */               startIndex = rows.indexOf(o);
/*      */             } 
/* 1188 */             for (int j = rows.indexOf(o) + 1; j < rows.size(); j++) {
/* 1189 */               Object endRow = rows.get(j);
/* 1190 */               String endT = getRowText(endRow);
/* 1191 */               if (endT.contains(end)) {
/*      */                 
/* 1193 */                 int endIndex = rows.indexOf(rows.get(j));
/* 1194 */                 if (endRow instanceof R) {
/* 1195 */                   int foundEndChar = 0;
/* 1196 */                   for (int z = endIndex; z < rows.size(); z++) {
/* 1197 */                     if (rows.get(z) instanceof R) {
/* 1198 */                       R r = (R)rows.get(z);
/* 1199 */                       String charText = "";
/* 1200 */                       for (Object o1 : r.getContent()) {
/* 1201 */                         if (o1 instanceof JAXBElement) {
/* 1202 */                           JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1203 */                           if (element.getValue() instanceof FldChar) {
/* 1204 */                             FldChar charType = element.getValue();
/* 1205 */                             charText = charText + charType.getFldCharType().name();
/*      */                           } 
/*      */                         } 
/*      */                       } 
/* 1209 */                       if (charText.contains("END") && foundEndChar == 0) {
/* 1210 */                         endIndex = z;
/* 1211 */                         foundEndChar = 1;
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/* 1216 */                 String startEndRes = startIndex + "###" + (endIndex + 1);
/* 1217 */                 if (!startEndFounds.contains(startEndRes)) {
/* 1218 */                   startEndFounds.add(startEndRes);
/*      */                 }
/* 1220 */                 k = endIndex;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/* 1226 */           k++;
/*      */         } 
/*      */         
/* 1229 */         for (int d = startEndFounds.size() - 1; d >= 0; d--) {
/* 1230 */           String s = startEndFounds.get(d);
/* 1231 */           int startIndex = Integer.parseInt(s.split("###")[0]);
/* 1232 */           int endIndex = Integer.parseInt(s.split("###")[1]);
/* 1233 */           if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */             
/* 1235 */             List<Object> templateR = new ArrayList(subList(rows, startIndex, endIndex));
/*      */             
/* 1237 */             if (!haveMergeFieldValue(templateR, fieldData)) {
/* 1238 */               rows.removeAll(templateR);
/* 1239 */               if (rows.isEmpty() || getPText(paragraph).trim().isEmpty()) {
/* 1240 */                 List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1241 */                 listToModify.remove(paragraph);
/* 1242 */                 if (paragraph.getParent() instanceof Tc) {
/* 1243 */                   handleTcInRemove(listToModify, paragraph);
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1253 */     paragraphs = getAllParagraphs(mainPart);
/* 1254 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1255 */       P paragraph = paragraphs.get(i);
/* 1256 */       String identifier = getPText(paragraph);
/* 1257 */       if (identifier.contains(start) && !identifier.contains(end)) {
/* 1258 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1259 */         int startIndex = listToModify.indexOf(paragraph);
/*      */ 
/*      */         
/* 1262 */         List<Object> template = new ArrayList();
/* 1263 */         for (int j = i + 1; j < paragraphs.size(); j++) {
/* 1264 */           P currentP = paragraphs.get(j);
/* 1265 */           String text = getPText(currentP);
/* 1266 */           if (text.contains(end) && !text.contains(start)) {
/* 1267 */             int endIndex = listToModify.indexOf(currentP);
/* 1268 */             if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */               
/* 1270 */               template.add(currentP);
/*      */               
/* 1272 */               if (!haveMergeFieldValue(template, fieldData)) {
/* 1273 */                 List<Object> removedList = subList(listToModify, startIndex, endIndex + 1);
/* 1274 */                 listToModify.removeAll(removedList);
/*      */               } else {
/* 1276 */                 listToModify.remove(paragraph);
/* 1277 */                 listToModify.remove(currentP);
/*      */               } 
/* 1279 */               if (paragraph.getParent() instanceof Tc) {
/* 1280 */                 handleTcInRemove(listToModify, paragraph);
/*      */               }
/*      */             } 
/*      */             break;
/*      */           } 
/* 1285 */           template.add(currentP);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void handleTcInRemove(List<Object> listToModify, P paragraph) {
/* 1293 */     if (listToModify.isEmpty()) {
/* 1294 */       removeRowFromTable(paragraph);
/*      */     }
/* 1296 */     else if (Boolean.FALSE.equals(Boolean.valueOf(checkPInObject(listToModify)))) {
/* 1297 */       ObjectFactory factory = new ObjectFactory();
/* 1298 */       P p = factory.createP();
/* 1299 */       listToModify.add(p);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void getStartEndNotExistedInDeleteStartEnd(WordprocessingMLPackage document, List<String> existedStartEnd) {
/* 1305 */     String start = "START_DELETE";
/* 1306 */     String end = "END_DELETE";
/* 1307 */     List<String> notExistedStartEnd = new ArrayList<>();
/* 1308 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/*      */     
/* 1310 */     List<Map<String, Object>> tableSearchRes = startEndInTable(start, end, mainPart);
/* 1311 */     if (!tableSearchRes.isEmpty()) {
/* 1312 */       for (Map<String, Object> tableSearch : tableSearchRes) {
/* 1313 */         List<Object> template = (List<Object>)tableSearch.get("template");
/* 1314 */         Tbl table = (Tbl)tableSearch.get("table");
/* 1315 */         int startIndex = ((Integer)tableSearch.get("startIndex")).intValue();
/* 1316 */         int endIndex = ((Integer)tableSearch.get("endIndex")).intValue();
/*      */         
/* 1318 */         getNotExistedStartEndInObject(template, existedStartEnd, notExistedStartEnd);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1323 */     List<P> paragraphs = getAllParagraphs(mainPart); int i;
/* 1324 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1325 */       P paragraph = paragraphs.get(i);
/* 1326 */       String identifier = getPText(paragraph);
/* 1327 */       if (identifier.contains(start) && identifier.contains(end)) {
/*      */         
/* 1329 */         List<Object> rows = paragraph.getContent();
/* 1330 */         List<String> startEndFounds = new ArrayList<>();
/* 1331 */         int k = 0;
/* 1332 */         while (k < rows.size()) {
/* 1333 */           Object o = rows.get(k);
/* 1334 */           String rowT = getRowText(o);
/* 1335 */           if (rowT.contains(start)) {
/*      */             int startIndex;
/* 1337 */             if (o instanceof R) {
/* 1338 */               startIndex = rows.indexOf(o) - 1;
/* 1339 */               for (int m = startIndex; m > 0; m--) {
/* 1340 */                 if (rows.get(m) instanceof R) {
/* 1341 */                   R r = (R)rows.get(m);
/* 1342 */                   String charText = "";
/* 1343 */                   for (Object o1 : r.getContent()) {
/* 1344 */                     if (o1 instanceof JAXBElement) {
/* 1345 */                       JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1346 */                       if (element.getValue() instanceof FldChar) {
/* 1347 */                         FldChar charType = element.getValue();
/* 1348 */                         charText = charText + charType.getFldCharType().name();
/*      */                       } 
/*      */                     } 
/*      */                   } 
/* 1352 */                   if (charText.contains("BEGIN")) {
/* 1353 */                     startIndex = m;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } else {
/* 1359 */               startIndex = rows.indexOf(o);
/*      */             } 
/* 1361 */             for (int j = rows.indexOf(o) + 1; j < rows.size(); j++) {
/* 1362 */               Object endRow = rows.get(j);
/* 1363 */               String endT = getRowText(endRow);
/* 1364 */               if (endT.contains(end)) {
/*      */                 
/* 1366 */                 int endIndex = rows.indexOf(rows.get(j));
/* 1367 */                 if (endRow instanceof R) {
/* 1368 */                   int foundEndChar = 0;
/* 1369 */                   for (int z = endIndex; z < rows.size(); z++) {
/* 1370 */                     if (rows.get(z) instanceof R) {
/* 1371 */                       R r = (R)rows.get(z);
/* 1372 */                       String charText = "";
/* 1373 */                       for (Object o1 : r.getContent()) {
/* 1374 */                         if (o1 instanceof JAXBElement) {
/* 1375 */                           JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1376 */                           if (element.getValue() instanceof FldChar) {
/* 1377 */                             FldChar charType = element.getValue();
/* 1378 */                             charText = charText + charType.getFldCharType().name();
/*      */                           } 
/*      */                         } 
/*      */                       } 
/* 1382 */                       if (charText.contains("END") && foundEndChar == 0) {
/* 1383 */                         endIndex = z;
/* 1384 */                         foundEndChar = 1;
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/* 1389 */                 String startEndRes = startIndex + "###" + (endIndex + 1);
/* 1390 */                 if (!startEndFounds.contains(startEndRes)) {
/* 1391 */                   startEndFounds.add(startEndRes);
/*      */                 }
/* 1393 */                 k = endIndex;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/* 1399 */           k++;
/*      */         } 
/*      */         
/* 1402 */         for (int d = startEndFounds.size() - 1; d >= 0; d--) {
/* 1403 */           String s = startEndFounds.get(d);
/* 1404 */           int startIndex = Integer.parseInt(s.split("###")[0]);
/* 1405 */           int endIndex = Integer.parseInt(s.split("###")[1]);
/* 1406 */           if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */             
/* 1408 */             List<Object> templateR = new ArrayList(subList(rows, startIndex, endIndex));
/*      */             
/* 1410 */             getNotExistedStartEndInObject(templateR, existedStartEnd, notExistedStartEnd);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1417 */     paragraphs = getAllParagraphs(mainPart);
/* 1418 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1419 */       P paragraph = paragraphs.get(i);
/* 1420 */       String identifier = getPText(paragraph);
/* 1421 */       if (identifier.contains(start) && !identifier.contains(end)) {
/* 1422 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1423 */         int startIndex = listToModify.indexOf(paragraph);
/*      */ 
/*      */         
/* 1426 */         List<Object> template = new ArrayList();
/* 1427 */         for (int j = i + 1; j < paragraphs.size(); j++) {
/* 1428 */           P currentP = paragraphs.get(j);
/* 1429 */           String text = getPText(currentP);
/* 1430 */           if (text.contains(end) && !text.contains(start)) {
/* 1431 */             int endIndex = listToModify.indexOf(currentP);
/* 1432 */             if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */               
/* 1434 */               template.add(currentP);
/*      */               
/* 1436 */               getNotExistedStartEndInObject(template, existedStartEnd, notExistedStartEnd);
/*      */             } 
/*      */             break;
/*      */           } 
/* 1440 */           template.add(currentP);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1447 */     for (String startEnd : notExistedStartEnd) {
/* 1448 */       String startMergeField = "";
/* 1449 */       String endMergeField = "";
/* 1450 */       String[] strings = startEnd.split("###");
/* 1451 */       int delete = 0;
/* 1452 */       for (int j = 0; j < strings.length; j++) {
/* 1453 */         if (strings[j].startsWith("START_")) {
/* 1454 */           startMergeField = strings[j];
/* 1455 */           delete++;
/*      */         } 
/* 1457 */         if (strings[j].startsWith("END_")) {
/* 1458 */           endMergeField = strings[j];
/* 1459 */           delete++;
/*      */         } 
/*      */       } 
/* 1462 */       if (delete == 2) {
/* 1463 */         deleteParagraphWithStartEndNotExisted(document, startMergeField, endMergeField);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void getNotExistedStartEndInObject(List<Object> template, List<String> existedStartEnd, List<String> notExistedStartEnd) {
/* 1469 */     List<String> mergeFields = getMergeFieldsInObject(template);
/* 1470 */     Map<String, String> map = new HashMap<>();
/* 1471 */     for (String mergeField : mergeFields) {
/* 1472 */       if (mergeField.startsWith("START_") && !mergeField.equals("START_DELETE")) {
/* 1473 */         String name = mergeField.replace("START_", "");
/* 1474 */         if (!map.containsKey(name)) {
/* 1475 */           map.put(name, mergeField);
/*      */         }
/* 1477 */         else if (!((String)map.get(name)).contains("START_") || !((String)map.get(name)).contains("END_")) {
/* 1478 */           map.put(name, (String)map.get(name) + "###" + mergeField);
/*      */         } 
/*      */       } 
/*      */       
/* 1482 */       if (mergeField.startsWith("END_") && !mergeField.equals("END_DELETE")) {
/* 1483 */         String name = mergeField.replace("END_", "");
/* 1484 */         if (!map.containsKey(name)) {
/* 1485 */           map.put(name, mergeField); continue;
/*      */         } 
/* 1487 */         if (!((String)map.get(name)).contains("START_") || !((String)map.get(name)).contains("END_")) {
/* 1488 */           map.put(name, (String)map.get(name) + "###" + mergeField);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1493 */     if (!map.isEmpty()) {
/* 1494 */       for (String key : map.keySet()) {
/* 1495 */         if (!existedStartEnd.contains(map.get(key)) && 
/* 1496 */           !notExistedStartEnd.contains(map.get(key))) {
/* 1497 */           notExistedStartEnd.add(map.get(key));
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static void deleteParagraphWithStartEndNotExisted(WordprocessingMLPackage document, String start, String end) {
/* 1505 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/* 1506 */     ObjectFactory factory = new ObjectFactory();
/* 1507 */     List<Map<String, Object>> tableSearchRes = startEndInTable(start, end, mainPart);
/* 1508 */     if (!tableSearchRes.isEmpty()) {
/* 1509 */       for (Map<String, Object> tableSearch : tableSearchRes) {
/* 1510 */         List<Object> template = (List<Object>)tableSearch.get("template");
/* 1511 */         Tbl table = (Tbl)tableSearch.get("table");
/* 1512 */         int startIndex = ((Integer)tableSearch.get("startIndex")).intValue();
/* 1513 */         int endIndex = ((Integer)tableSearch.get("endIndex")).intValue();
/* 1514 */         table.getContent().remove(endIndex);
/* 1515 */         table.getContent().remove(startIndex);
/*      */         
/* 1517 */         table.getContent().removeAll(template);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1522 */     List<P> paragraphs = getAllParagraphs(mainPart); int i;
/* 1523 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1524 */       P paragraph = paragraphs.get(i);
/* 1525 */       String identifier = getPText(paragraph);
/* 1526 */       if (identifier.contains(start) && identifier.contains(end)) {
/*      */         
/* 1528 */         List<Object> rows = paragraph.getContent();
/* 1529 */         List<String> startEndFounds = new ArrayList<>();
/* 1530 */         int k = 0;
/* 1531 */         while (k < rows.size()) {
/* 1532 */           Object o = rows.get(k);
/* 1533 */           String rowT = getRowText(o);
/* 1534 */           if (rowT.contains(start)) {
/*      */             int startIndex;
/* 1536 */             if (o instanceof R) {
/* 1537 */               startIndex = rows.indexOf(o) - 1;
/* 1538 */               for (int m = startIndex; m > 0; m--) {
/* 1539 */                 if (rows.get(m) instanceof R) {
/* 1540 */                   R r = (R)rows.get(m);
/* 1541 */                   String charText = "";
/* 1542 */                   for (Object o1 : r.getContent()) {
/* 1543 */                     if (o1 instanceof JAXBElement) {
/* 1544 */                       JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1545 */                       if (element.getValue() instanceof FldChar) {
/* 1546 */                         FldChar charType = element.getValue();
/* 1547 */                         charText = charText + charType.getFldCharType().name();
/*      */                       } 
/*      */                     } 
/*      */                   } 
/* 1551 */                   if (charText.contains("BEGIN")) {
/* 1552 */                     startIndex = m;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } else {
/* 1558 */               startIndex = rows.indexOf(o);
/*      */             } 
/* 1560 */             for (int j = rows.indexOf(o) + 1; j < rows.size(); j++) {
/* 1561 */               Object endRow = rows.get(j);
/* 1562 */               String endT = getRowText(endRow);
/* 1563 */               if (endT.contains(end)) {
/*      */                 
/* 1565 */                 int endIndex = rows.indexOf(rows.get(j));
/* 1566 */                 if (endRow instanceof R) {
/* 1567 */                   int foundEndChar = 0;
/* 1568 */                   for (int z = endIndex; z < rows.size(); z++) {
/* 1569 */                     if (rows.get(z) instanceof R) {
/* 1570 */                       R r = (R)rows.get(z);
/* 1571 */                       String charText = "";
/* 1572 */                       for (Object o1 : r.getContent()) {
/* 1573 */                         if (o1 instanceof JAXBElement) {
/* 1574 */                           JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1575 */                           if (element.getValue() instanceof FldChar) {
/* 1576 */                             FldChar charType = element.getValue();
/* 1577 */                             charText = charText + charType.getFldCharType().name();
/*      */                           } 
/*      */                         } 
/*      */                       } 
/* 1581 */                       if (charText.contains("END") && foundEndChar == 0) {
/* 1582 */                         endIndex = z;
/* 1583 */                         foundEndChar = 1;
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/* 1588 */                 String startEndRes = startIndex + "###" + (endIndex + 1);
/* 1589 */                 if (!startEndFounds.contains(startEndRes)) {
/* 1590 */                   startEndFounds.add(startEndRes);
/*      */                 }
/* 1592 */                 k = endIndex;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/* 1598 */           k++;
/*      */         } 
/*      */         
/* 1601 */         for (int d = startEndFounds.size() - 1; d >= 0; d--) {
/* 1602 */           String s = startEndFounds.get(d);
/* 1603 */           int startIndex = Integer.parseInt(s.split("###")[0]);
/* 1604 */           int endIndex = Integer.parseInt(s.split("###")[1]);
/* 1605 */           if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */             
/* 1607 */             List<Object> templateR = new ArrayList(subList(rows, startIndex, endIndex));
/* 1608 */             rows.removeAll(templateR);
/* 1609 */             if (rows.isEmpty() || getPText(paragraph).trim().isEmpty()) {
/* 1610 */               List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1611 */               listToModify.remove(paragraph);
/* 1612 */               if (paragraph.getParent() instanceof Tc) {
/* 1613 */                 handleTcInRemove(listToModify, paragraph);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1622 */     paragraphs = getAllParagraphs(mainPart);
/* 1623 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1624 */       P paragraph = paragraphs.get(i);
/* 1625 */       String identifier = getPText(paragraph);
/* 1626 */       if (identifier.contains(start) && !identifier.contains(end)) {
/* 1627 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1628 */         int startIndex = listToModify.indexOf(paragraph);
/* 1629 */         int endIndex = 0;
/*      */         
/* 1631 */         List<Object> template = new ArrayList();
/* 1632 */         for (int j = i + 1; j < paragraphs.size(); j++) {
/* 1633 */           P currentP = paragraphs.get(j);
/* 1634 */           String text = getPText(currentP);
/* 1635 */           if (text.contains(end) && !text.contains(start)) {
/* 1636 */             endIndex = listToModify.indexOf(currentP);
/* 1637 */             if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/*      */               
/* 1639 */               template.add(currentP);
/*      */ 
/*      */               
/* 1642 */               List<Object> removedList = subList(listToModify, startIndex, endIndex + 1);
/* 1643 */               listToModify.removeAll(removedList);
/*      */               
/* 1645 */               if (paragraph.getParent() instanceof Tc) {
/* 1646 */                 handleTcInRemove(listToModify, paragraph);
/*      */               }
/*      */             } 
/*      */             break;
/*      */           } 
/* 1651 */           template.add(currentP);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean haveMergeFieldValue(List<Object> template, Map<String, String> fieldData) {
/* 1659 */     String mergeFieldBeginning = "MERGEFIELD ";
/* 1660 */     for (Object object : template) {
/* 1661 */       List<?> textElements = getAllElementFromObject(object, Text.class);
/* 1662 */       List<?> ctSimpleFields = getAllElementFromObject(object, CTSimpleField.class);
/* 1663 */       for (Object o : textElements) {
/* 1664 */         Text text = (Text)o;
/* 1665 */         String value = text.getValue();
/* 1666 */         if (value.contains(mergeFieldBeginning)) {
/* 1667 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1668 */           String mergeField = formatMergeField(fieldName);
/* 1669 */           String mergeFieldData = fieldData.get(mergeField);
/* 1670 */           if (mergeFieldData != null && !mergeFieldData.isEmpty() && !mergeFieldData.equals("delete")) {
/* 1671 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1676 */       for (Object o : ctSimpleFields) {
/* 1677 */         CTSimpleField simpleField = (CTSimpleField)o;
/* 1678 */         String value = simpleField.getInstr();
/* 1679 */         if (value.contains(mergeFieldBeginning)) {
/* 1680 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1681 */           String mergeField = formatMergeField(fieldName);
/* 1682 */           String mergeFieldData = fieldData.get(mergeField);
/* 1683 */           if (mergeFieldData != null && !mergeFieldData.isEmpty() && !mergeFieldData.equals("delete")) {
/* 1684 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/* 1688 */       List<?> rows = getAllElementFromObject(object, R.class);
/* 1689 */       for (Object o : rows) {
/* 1690 */         R r = (R)o;
/* 1691 */         if (r.getContent() != null) {
/* 1692 */           for (Object o1 : r.getContent()) {
/* 1693 */             if (o1 instanceof JAXBElement) {
/* 1694 */               JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1695 */               if (element.getValue() instanceof FldChar) {
/* 1696 */                 CTFFData data = ((FldChar)element.getValue()).getFfData();
/* 1697 */                 if (data != null && data.getNameOrEnabledOrCalcOnExit() != null) {
/* 1698 */                   List<JAXBElement<?>> elements = data.getNameOrEnabledOrCalcOnExit();
/* 1699 */                   CTFFName ctffName = ((JAXBElement<CTFFName>)elements.get(0)).getValue();
/*      */                   
/* 1701 */                   String oldName = ctffName.getVal();
/* 1702 */                   String mergeFieldData = fieldData.get(oldName);
/* 1703 */                   if (mergeFieldData != null && !mergeFieldData.isEmpty() && mergeFieldData
/* 1704 */                     .equalsIgnoreCase("true")) {
/* 1705 */                     return true;
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1714 */     return false;
/*      */   }
/*      */   
/*      */   private static boolean existMergeFieldsInObject(List<Object> template, String key) {
/* 1718 */     String mergeFieldBeginning = "MERGEFIELD ";
/* 1719 */     for (Object tObject : template) {
/* 1720 */       List<?> textElements = getAllElementFromObject(tObject, Text.class);
/* 1721 */       List<?> ctSimpleFields = getAllElementFromObject(tObject, CTSimpleField.class);
/* 1722 */       for (Object o : textElements) {
/* 1723 */         Text text = (Text)o;
/* 1724 */         String value = text.getValue();
/* 1725 */         if (value.contains(mergeFieldBeginning)) {
/* 1726 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1727 */           String mergeField = formatMergeField(fieldName);
/* 1728 */           if (mergeField.equals(key)) {
/* 1729 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1734 */       for (Object o : ctSimpleFields) {
/* 1735 */         CTSimpleField simpleField = (CTSimpleField)o;
/* 1736 */         String value = simpleField.getInstr();
/* 1737 */         if (value.contains(mergeFieldBeginning)) {
/* 1738 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1739 */           String mergeField = formatMergeField(fieldName);
/* 1740 */           if (mergeField.equals(key)) {
/* 1741 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 1746 */     return false;
/*      */   }
/*      */   
/*      */   private static List<String> getMergeFieldsInObject(List<Object> template) {
/* 1750 */     String mergeFieldBeginning = "MERGEFIELD ";
/* 1751 */     List<String> res = new ArrayList<>();
/* 1752 */     for (Object tObject : template) {
/* 1753 */       List<?> textElements = getAllElementFromObject(tObject, Text.class);
/* 1754 */       List<?> ctSimpleFields = getAllElementFromObject(tObject, CTSimpleField.class);
/* 1755 */       for (Object o : textElements) {
/* 1756 */         Text text = (Text)o;
/* 1757 */         String value = text.getValue();
/* 1758 */         if (value.contains(mergeFieldBeginning)) {
/* 1759 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1760 */           String mergeField = formatMergeField(fieldName);
/* 1761 */           res.add(mergeField);
/*      */         } 
/*      */       } 
/*      */       
/* 1765 */       for (Object o : ctSimpleFields) {
/* 1766 */         CTSimpleField simpleField = (CTSimpleField)o;
/* 1767 */         String value = simpleField.getInstr();
/* 1768 */         if (value.contains(mergeFieldBeginning)) {
/* 1769 */           String fieldName = value.substring(mergeFieldBeginning.length());
/* 1770 */           String mergeField = formatMergeField(fieldName);
/* 1771 */           res.add(mergeField);
/*      */         } 
/*      */       } 
/*      */     } 
/* 1775 */     return res;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void duplicate(WordprocessingMLPackage document, String start, String end, int amount, Map<String, String> fieldData, String groupText) {
/* 1780 */     List<String> groupFields = new ArrayList<>(Arrays.asList(groupText.split("###")));
/* 1781 */     MainDocumentPart mainPart = document.getMainDocumentPart();
/* 1782 */     List<Map<String, Object>> tableSearchRes = startEndInTable(start, end, mainPart);
/* 1783 */     if (!tableSearchRes.isEmpty()) {
/* 1784 */       for (Map<String, Object> tableSearch : tableSearchRes) {
/* 1785 */         List<Object> template = (List<Object>)tableSearch.get("template");
/* 1786 */         renameMergedTemplate(template, fieldData, groupFields, start);
/* 1787 */         Tbl table = (Tbl)tableSearch.get("table");
/* 1788 */         int index = 1;
/* 1789 */         int startIndex = ((Integer)tableSearch.get("startIndex")).intValue();
/* 1790 */         int endIndex = ((Integer)tableSearch.get("endIndex")).intValue();
/* 1791 */         table.getContent().remove(endIndex);
/* 1792 */         table.getContent().remove(startIndex);
/* 1793 */         int endTemplateIndex = table.getContent().indexOf(template.get(template.size() - 1));
/* 1794 */         while (index < amount) {
/* 1795 */           Map<String, Object> duplicatedMap = renameMergedFieldAndCheckBox(template, index, fieldData, groupFields, start);
/* 1796 */           List<Object> duplicatedTemplate = (List<Object>)duplicatedMap.get("duplicatedRes");
/* 1797 */           Boolean checkboxValue = (Boolean)duplicatedMap.get("checkboxValue");
/* 1798 */           if (Boolean.TRUE.equals(checkboxValue)) {
/* 1799 */             table.getContent().addAll(endTemplateIndex + 1, duplicatedTemplate);
/* 1800 */             endTemplateIndex += duplicatedTemplate.size();
/*      */           }
/* 1802 */           else if (haveMergeFieldValue(duplicatedTemplate, fieldData)) {
/* 1803 */             table.getContent().addAll(endTemplateIndex + 1, duplicatedTemplate);
/* 1804 */             endTemplateIndex += duplicatedTemplate.size();
/*      */           } 
/*      */           
/* 1807 */           index++;
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1812 */     List<P> paragraphs = getAllParagraphs(mainPart);
/*      */     
/*      */     int i;
/* 1815 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1816 */       P paragraph = paragraphs.get(i);
/* 1817 */       String identifier = getPText(paragraph);
/* 1818 */       if (identifier.contains(start) && identifier.contains(end)) {
/*      */         
/* 1820 */         List<Object> rows = paragraph.getContent();
/* 1821 */         List<String> startEndFounds = new ArrayList<>();
/*      */         
/* 1823 */         for (int k = 0; k < rows.size(); k++) {
/* 1824 */           Object o = rows.get(k);
/* 1825 */           String rowT = getRowText(o);
/* 1826 */           if (rowT.contains(start)) {
/* 1827 */             int startIndex = rows.indexOf(o);
/* 1828 */             int foundNextStart = 0;
/* 1829 */             if (o instanceof JAXBElement) {
/* 1830 */               JAXBElement element = (JAXBElement)o;
/* 1831 */               if (element.getValue() instanceof CTSimpleField) {
/* 1832 */                 foundNextStart = 1;
/*      */               }
/*      */             } 
/* 1835 */             for (int j = rows.indexOf(o) + 1; j < rows.size(); j++) {
/* 1836 */               String endT = getRowText(rows.get(j));
/* 1837 */               if (endT.contains(end)) {
/* 1838 */                 int endIndex = rows.indexOf(rows.get(j)) - 1;
/* 1839 */                 if (rows.get(j) instanceof JAXBElement) {
/* 1840 */                   JAXBElement element = (JAXBElement)rows.get(j);
/* 1841 */                   if (element.getValue() instanceof CTSimpleField) {
/* 1842 */                     endIndex = rows.indexOf(rows.get(j));
/*      */                   }
/*      */                 } 
/* 1845 */                 if (startIndex < endIndex) {
/* 1846 */                   String startEndRes = startIndex + "###" + endIndex;
/* 1847 */                   startEndFounds.add(startEndRes);
/*      */                 } 
/* 1849 */                 k = endIndex;
/*      */                 break;
/*      */               } 
/* 1852 */               String charText = "";
/* 1853 */               if (rows.get(j) instanceof R) {
/* 1854 */                 R r = (R)rows.get(j);
/* 1855 */                 for (Object o1 : r.getContent()) {
/* 1856 */                   if (o1 instanceof JAXBElement) {
/* 1857 */                     JAXBElement<FldChar> element = (JAXBElement)o1;
/* 1858 */                     if (element.getValue() instanceof FldChar) {
/* 1859 */                       FldChar charType = element.getValue();
/* 1860 */                       charText = charText + charType.getFldCharType().name();
/*      */                     } 
/*      */                   } 
/*      */                 } 
/* 1864 */                 if (charText.contains("END") && foundNextStart == 0) {
/* 1865 */                   startIndex = j;
/* 1866 */                   foundNextStart = 1;
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 1873 */         for (int d = startEndFounds.size() - 1; d >= 0; d--) {
/* 1874 */           String s = startEndFounds.get(d);
/* 1875 */           int startIndex = Integer.parseInt(s.split("###")[0]);
/* 1876 */           int endIndex = Integer.parseInt(s.split("###")[1]);
/*      */           
/* 1878 */           renameMergedTemplate(rows.subList(startIndex + 1, endIndex), fieldData, groupFields, start);
/* 1879 */           List<Object> templateR = new ArrayList();
/* 1880 */           for (Object temp : subList(rows, startIndex + 1, endIndex)) {
/* 1881 */             templateR.add(XmlUtils.deepCopy(temp));
/*      */           }
/* 1883 */           int templateSize = templateR.size();
/* 1884 */           int indexOfEnd = endIndex;
/* 1885 */           int index = 1;
/* 1886 */           while (index < amount) {
/*      */             
/* 1888 */             Map<String, Object> duplicatedMap = renameMergedFieldAndCheckBox(templateR, index, fieldData, groupFields, start);
/* 1889 */             List<Object> duplicatedTemplate = (List<Object>)duplicatedMap.get("duplicatedRes");
/* 1890 */             Boolean checkboxValue = (Boolean)duplicatedMap.get("checkboxValue");
/* 1891 */             if (Boolean.TRUE.equals(checkboxValue)) {
/* 1892 */               rows.addAll(indexOfEnd, duplicatedTemplate);
/* 1893 */               indexOfEnd += templateSize;
/*      */             }
/* 1895 */             else if (haveMergeFieldValue(duplicatedTemplate, fieldData)) {
/* 1896 */               rows.addAll(indexOfEnd, duplicatedTemplate);
/* 1897 */               indexOfEnd += templateSize;
/*      */             } 
/*      */             
/* 1900 */             index++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1907 */     paragraphs = getAllParagraphs(mainPart);
/*      */     
/* 1909 */     for (i = 0; i < paragraphs.size(); i++) {
/* 1910 */       P paragraph = paragraphs.get(i);
/* 1911 */       String identifier = getPText(paragraph);
/* 1912 */       if (identifier.contains(start) && !identifier.contains(end)) {
/* 1913 */         List<Object> listToModify = getListToModify(paragraph, mainPart);
/* 1914 */         int startIndex = listToModify.indexOf(paragraph);
/*      */ 
/*      */         
/* 1917 */         List<P> pList = new ArrayList<>();
/* 1918 */         for (int j = i + 1; j < paragraphs.size(); j++) {
/* 1919 */           P currentP = paragraphs.get(j);
/* 1920 */           String text = getPText(currentP);
/* 1921 */           if (text.contains(end) && !text.contains(start)) {
/* 1922 */             int endIndex = listToModify.indexOf(currentP);
/* 1923 */             if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
/* 1924 */               List<Object> template = subList(listToModify, startIndex + 1, endIndex);
/* 1925 */               renameMergedTemplate(template, fieldData, groupFields, start);
/* 1926 */               int index = 1;
/* 1927 */               while (index < amount) {
/*      */                 
/* 1929 */                 Map<String, Object> duplicatedMap = renameMergedFieldAndCheckBox(template, index, fieldData, groupFields, start);
/* 1930 */                 List<Object> duplicatedTemplate = (List<Object>)duplicatedMap.get("duplicatedRes");
/* 1931 */                 Boolean checkboxValue = (Boolean)duplicatedMap.get("checkboxValue");
/* 1932 */                 if (Boolean.TRUE.equals(checkboxValue)) {
/* 1933 */                   listToModify.addAll(endIndex, duplicatedTemplate);
/* 1934 */                   endIndex += duplicatedTemplate.size();
/*      */                 }
/* 1936 */                 else if (haveMergeFieldValue(duplicatedTemplate, fieldData)) {
/* 1937 */                   listToModify.addAll(endIndex, duplicatedTemplate);
/* 1938 */                   endIndex += duplicatedTemplate.size();
/*      */                 } 
/*      */                 
/* 1941 */                 index++;
/*      */               } 
/* 1943 */               listToModify.remove(paragraph);
/* 1944 */               listToModify.remove(currentP);
/*      */             } 
/*      */             break;
/*      */           } 
/* 1948 */           pList.add(currentP);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static List<Map<String, Object>> startEndInTable(String start, String end, MainDocumentPart documentPart) {
/* 1956 */     List<Map<String, Object>> res = new ArrayList<>();
/*      */     
/* 1958 */     List<Object> tables = getAllElementFromObject(documentPart, Tbl.class);
/* 1959 */     for (Object tbl : tables) {
/*      */       
/* 1961 */       List<Object> rows = ((Tbl)tbl).getContent();
/* 1962 */       label27: for (Object row : rows) {
/* 1963 */         int index = rows.indexOf(row);
/* 1964 */         if (row instanceof Tr) {
/* 1965 */           Tr tr = (Tr)row;
/* 1966 */           String rowText = getTrText(tr);
/* 1967 */           if (rowText.contains(start) && rowText.contains(end)) {
/*      */             continue;
/*      */           }
/* 1970 */           if (rowText.contains(start)) {
/* 1971 */             int i = index + 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             break label27;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1998 */     return res;
/*      */   }
/*      */   
/*      */   private static List<Object> subList(List<Object> list, int startIndex, int endIndex) {
/* 2002 */     List<Object> res = new ArrayList();
/* 2003 */     for (int i = startIndex; i < endIndex; i++) {
/* 2004 */       res.add(list.get(i));
/*      */     }
/* 2006 */     return res;
/*      */   }
/*      */   
/*      */   private static Map<String, Object> renameMergedFieldAndCheckBox(List<Object> template, int index, Map<String, String> fieldData, List<String> groupFields, String start) {
/* 2010 */     Map<String, Object> resMap = new HashMap<>();
/* 2011 */     String groupStartName = getGroupStartName(start);
/* 2012 */     String mergeFieldBeginning = "MERGEFIELD ";
/* 2013 */     List<Object> res = new ArrayList();
/* 2014 */     for (Object temp : template) {
/* 2015 */       res.add(XmlUtils.deepCopy(temp));
/*      */     }
/* 2017 */     for (Object dObject : res) {
/* 2018 */       List<?> textElements = getAllElementFromObject(dObject, Text.class);
/* 2019 */       List<?> simpleFieldElements = getAllElementFromObject(dObject, CTSimpleField.class);
/*      */       
/* 2021 */       for (Object object : textElements) {
/* 2022 */         Text text = (Text)object;
/* 2023 */         String s = text.getValue();
/* 2024 */         if (s.contains(mergeFieldBeginning)) {
/* 2025 */           String fieldName = s.substring(mergeFieldBeginning.length());
/* 2026 */           String mergeField = formatMergeField(fieldName);
/* 2027 */           if (groupFields.contains(mergeField)) {
/* 2028 */             if (s.contains("MERGEFIELD") && s.contains("\\* MERGEFORMAT")) {
/*      */               
/* 2030 */               String end = s.split("MERGEFIELD")[1];
/* 2031 */               String key = end.split("\\* MERGEFORMAT")[0].trim();
/* 2032 */               if (key.contains("\"")) {
/* 2033 */                 text.setValue(text.getValue().replaceFirst("\"", "\"" + index + "_")); continue;
/*      */               } 
/* 2035 */               text.setValue(text.getValue().replace(key, index + "_" + key)); continue;
/*      */             } 
/* 2037 */             if (s.contains("MERGEFIELD")) {
/* 2038 */               String key = s.split("MERGEFIELD")[1].trim();
/* 2039 */               if (key.contains("\"")) {
/* 2040 */                 text.setValue(text.getValue().replaceFirst("\"", "\"" + index + "_")); continue;
/*      */               } 
/* 2042 */               text.setValue(text.getValue().replace(key, index + "_" + key));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2048 */       for (Object object : simpleFieldElements) {
/* 2049 */         CTSimpleField text = (CTSimpleField)object;
/* 2050 */         String s = text.getInstr();
/* 2051 */         if (s.contains(mergeFieldBeginning)) {
/* 2052 */           String fieldName = s.substring(mergeFieldBeginning.length());
/* 2053 */           String mergeField = formatMergeField(fieldName);
/* 2054 */           if (groupFields.contains(mergeField)) {
/* 2055 */             if (s.contains("MERGEFIELD") && s.contains("\\* MERGEFORMAT")) {
/*      */               
/* 2057 */               String end = s.split("MERGEFIELD")[1];
/* 2058 */               String key = end.split("\\* MERGEFORMAT")[0].trim();
/* 2059 */               if (key.contains("\"")) {
/* 2060 */                 text.setInstr(text.getInstr().replaceFirst("\"", "\"" + index + "_")); continue;
/*      */               } 
/* 2062 */               text.setInstr(text.getInstr().replace(key, index + "_" + key)); continue;
/*      */             } 
/* 2064 */             if (s.contains("MERGEFIELD")) {
/* 2065 */               String key = s.split("MERGEFIELD")[1].trim();
/* 2066 */               if (key.contains("\"")) {
/* 2067 */                 text.setInstr(text.getInstr().replaceFirst("\"", "\"" + index + "_")); continue;
/*      */               } 
/* 2069 */               text.setInstr(text.getInstr().replace(key, index + "_" + key));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2076 */       List<?> rows = getAllElementFromObject(dObject, R.class);
/* 2077 */       for (Object o : rows) {
/* 2078 */         R r = (R)o;
/* 2079 */         if (r.getContent() != null) {
/* 2080 */           for (Object o1 : r.getContent()) {
/* 2081 */             if (o1 instanceof JAXBElement) {
/* 2082 */               JAXBElement<FldChar> element = (JAXBElement)o1;
/* 2083 */               if (element.getValue() instanceof FldChar) {
/* 2084 */                 CTFFData data = ((FldChar)element.getValue()).getFfData();
/* 2085 */                 if (data != null && data.getNameOrEnabledOrCalcOnExit() != null) {
/* 2086 */                   List<JAXBElement<?>> elements = data.getNameOrEnabledOrCalcOnExit();
/* 2087 */                   CTFFName ctffName = ((JAXBElement<CTFFName>)elements.get(0)).getValue();
/*      */                   
/* 2089 */                   String oldName = ctffName.getVal();
/* 2090 */                   String newName = (groupStartName != null && !groupStartName.isEmpty()) ? (index + "_" + groupStartName + "_" + oldName) : (index + "_" + oldName);
/*      */                   
/* 2092 */                   CTFFCheckBox checkBox = ((JAXBElement<CTFFCheckBox>)elements.get(elements.size() - 1)).getValue();
/*      */                   
/* 2094 */                   BooleanDefaultTrue booleanDefaultTrue = new BooleanDefaultTrue();
/* 2095 */                   booleanDefaultTrue.setVal(Boolean.valueOf(false));
/* 2096 */                   if (fieldData.containsKey(newName) && fieldData.get(newName) != null && ((String)fieldData
/* 2097 */                     .get(newName)).trim().equalsIgnoreCase("true")) {
/* 2098 */                     booleanDefaultTrue.setVal(Boolean.valueOf(true));
/* 2099 */                     resMap.put("checkboxValue", Boolean.valueOf(true));
/*      */                   } 
/* 2101 */                   checkBox.setChecked(booleanDefaultTrue);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 2109 */     resMap.put("duplicatedRes", res);
/* 2110 */     return resMap;
/*      */   }
/*      */   
/*      */   private static void renameMergedTemplate(List<Object> template, Map<String, String> fieldData, List<String> groupFields, String start) {
/* 2114 */     String mergeFieldBeginning = "MERGEFIELD ";
/*      */     
/* 2116 */     String groupStartName = getGroupStartName(start);
/* 2117 */     for (Object dObject : template) {
/* 2118 */       List<?> textElements = getAllElementFromObject(dObject, Text.class);
/* 2119 */       List<?> simpleFieldElements = getAllElementFromObject(dObject, CTSimpleField.class);
/*      */       
/* 2121 */       for (Object object : textElements) {
/* 2122 */         Text text = (Text)object;
/* 2123 */         String s = text.getValue();
/* 2124 */         if (s.contains(mergeFieldBeginning)) {
/* 2125 */           String fieldName = s.substring(mergeFieldBeginning.length());
/* 2126 */           String mergeField = groupStartName + "_" + formatMergeField(fieldName);
/* 2127 */           if (groupFields.contains(mergeField)) {
/* 2128 */             if (s.contains("MERGEFIELD") && s.contains("\\* MERGEFORMAT")) {
/*      */               
/* 2130 */               String end = s.split("MERGEFIELD")[1];
/* 2131 */               String key = end.split("\\* MERGEFORMAT")[0].trim();
/* 2132 */               if (key.contains("\"")) {
/* 2133 */                 text.setValue(text.getValue().replaceFirst("\"", getNewMergeFieldNameForTemplate(groupStartName, key, 0))); continue;
/*      */               } 
/* 2135 */               text.setValue(text.getValue().replace(key, getNewMergeFieldNameForTemplate(groupStartName, key, 1)));
/*      */               continue;
/*      */             } 
/* 2138 */             if (s.contains("MERGEFIELD")) {
/* 2139 */               String key = s.split("MERGEFIELD")[1].trim();
/* 2140 */               if (key.contains("\"")) {
/* 2141 */                 text.setValue(text.getValue().replaceFirst("\"", getNewMergeFieldNameForTemplate(groupStartName, key, 0))); continue;
/*      */               } 
/* 2143 */               text.setValue(text.getValue().replace(key, getNewMergeFieldNameForTemplate(groupStartName, key, 1)));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2149 */       for (Object object : simpleFieldElements) {
/* 2150 */         CTSimpleField text = (CTSimpleField)object;
/* 2151 */         String s = text.getInstr();
/* 2152 */         if (s.contains(mergeFieldBeginning)) {
/* 2153 */           String fieldName = s.substring(mergeFieldBeginning.length());
/* 2154 */           String mergeField = groupStartName + "_" + formatMergeField(fieldName);
/* 2155 */           if (groupFields.contains(mergeField)) {
/* 2156 */             if (s.contains("MERGEFIELD") && s.contains("\\* MERGEFORMAT")) {
/*      */               
/* 2158 */               String end = s.split("MERGEFIELD")[1];
/* 2159 */               String key = end.split("\\* MERGEFORMAT")[0].trim();
/* 2160 */               if (key.contains("\"")) {
/* 2161 */                 text.setInstr(text.getInstr().replaceFirst("\"", getNewMergeFieldNameForTemplate(groupStartName, key, 0))); continue;
/*      */               } 
/* 2163 */               text.setInstr(text.getInstr().replace(key, getNewMergeFieldNameForTemplate(groupStartName, key, 1))); continue;
/*      */             } 
/* 2165 */             if (s.contains("MERGEFIELD")) {
/* 2166 */               String key = s.split("MERGEFIELD")[1].trim();
/* 2167 */               if (key.contains("\"")) {
/* 2168 */                 text.setInstr(text.getInstr().replaceFirst("\"", getNewMergeFieldNameForTemplate(groupStartName, key, 0))); continue;
/*      */               } 
/* 2170 */               text.setInstr(text.getInstr().replace(key, getNewMergeFieldNameForTemplate(groupStartName, key, 1)));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2177 */       List<?> rows = getAllElementFromObject(dObject, R.class);
/* 2178 */       for (Object o : rows) {
/* 2179 */         R r = (R)o;
/* 2180 */         if (r.getContent() != null) {
/* 2181 */           for (Object o1 : r.getContent()) {
/* 2182 */             if (o1 instanceof JAXBElement) {
/* 2183 */               JAXBElement<FldChar> element = (JAXBElement)o1;
/* 2184 */               if (element.getValue() instanceof FldChar) {
/* 2185 */                 CTFFData data = ((FldChar)element.getValue()).getFfData();
/* 2186 */                 if (data != null && data.getNameOrEnabledOrCalcOnExit() != null) {
/* 2187 */                   List<JAXBElement<?>> elements = data.getNameOrEnabledOrCalcOnExit();
/* 2188 */                   CTFFName ctffName = ((JAXBElement<CTFFName>)elements.get(0)).getValue();
/*      */                   
/* 2190 */                   String oldName = ctffName.getVal();
/* 2191 */                   String newName = (groupStartName != null && !groupStartName.isEmpty()) ? (groupStartName + "_" + oldName) : oldName;
/*      */                   
/* 2193 */                   CTFFCheckBox checkBox = ((JAXBElement<CTFFCheckBox>)elements.get(elements.size() - 1)).getValue();
/*      */                   
/* 2195 */                   BooleanDefaultTrue booleanDefaultTrue = new BooleanDefaultTrue();
/* 2196 */                   booleanDefaultTrue.setVal(Boolean.valueOf(false));
/* 2197 */                   if (fieldData.containsKey(newName) && fieldData.get(newName) != null && ((String)fieldData
/* 2198 */                     .get(newName)).trim().equalsIgnoreCase("true")) {
/* 2199 */                     booleanDefaultTrue.setVal(Boolean.valueOf(true));
/*      */                   }
/* 2201 */                   checkBox.setChecked(booleanDefaultTrue);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String getNewMergeFieldNameForTemplate(String start, String key, int type) {
/* 2220 */     if (type == 0) {
/* 2221 */       return (start != null && !start.isEmpty()) ? ("\"" + start + "_") : "\"";
/*      */     }
/* 2223 */     return (start != null && !start.isEmpty()) ? (start + "_" + key) : key;
/*      */   }
/*      */ 
/*      */   
/*      */   private static List<P> createBullets(String prefix, String text, P template) {
/* 2228 */     List<P> result = new ArrayList<>();
/* 2229 */     String[] values = text.trim().split("\n");
/* 2230 */     ObjectFactory factory = new ObjectFactory();
/* 2231 */     R rTemplate = template.getContent().get(0);
/* 2232 */     int index = 1;
/* 2233 */     if (!prefix.isEmpty()) {
/* 2234 */       P p = factory.createP();
/* 2235 */       Text t = factory.createText();
/* 2236 */       t.setValue(prefix + " " + values[0]);
/* 2237 */       R run = factory.createR();
/* 2238 */       run.getContent().add(t);
/* 2239 */       run.setRPr(rTemplate.getRPr());
/* 2240 */       p.getContent().add(run);
/* 2241 */       p.setPPr(template.getPPr());
/* 2242 */       result.add(p);
/*      */     } else {
/* 2244 */       index = 0;
/*      */     } 
/*      */     
/* 2247 */     for (int i = index; i < values.length; i++) {
/* 2248 */       P p = factory.createP();
/* 2249 */       Text t = factory.createText();
/* 2250 */       t.setValue(values[i]);
/* 2251 */       R run = factory.createR();
/* 2252 */       run.setRPr(rTemplate.getRPr());
/* 2253 */       run.getContent().add(t);
/* 2254 */       p.getContent().add(run);
/* 2255 */       p.setPPr(template.getPPr());
/* 2256 */       result.add(p);
/*      */     } 
/* 2258 */     return result;
/*      */   }
/*      */   
/*      */   private static List<P> getAllParagraphs(MainDocumentPart mainPart) {
/* 2262 */     final List<P> paragraphs = new ArrayList<>();
/* 2263 */     new TraversalUtil(mainPart, (TraversalUtil.Callback)new TraversalUtil.CallbackImpl()
/*      */         {
/*      */           public List<Object> apply(Object o) {
/* 2266 */             if (o instanceof P) {
/* 2267 */               paragraphs.add((P)o);
/*      */             }
/* 2269 */             return null;
/*      */           }
/*      */         });
/* 2272 */     return paragraphs;
/*      */   }
/*      */   
/*      */   private static List<Object> getListToModify(P paragraph, MainDocumentPart mainPart) {
/*      */     List<Object> listToModify;
/* 2277 */     if (paragraph.getParent() instanceof Tc) {
/*      */       
/* 2279 */       Tc parent = (Tc)paragraph.getParent();
/* 2280 */       listToModify = parent.getContent();
/*      */     } else {
/*      */       
/* 2283 */       listToModify = mainPart.getContent();
/*      */     } 
/* 2285 */     return listToModify;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\MailMergeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */