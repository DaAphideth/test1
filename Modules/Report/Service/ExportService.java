/*     */ package nencer.app.Modules.Report.Service;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Ultil.BarcodeHelper;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.FileUtils;
/*     */ import nencer.app.Utils.MailMergeUtil;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFDocument;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFRun;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTable;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTableCell;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTableRow;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ @Service
/*     */ public class ExportService {
/*  31 */   public static final Logger logger = LoggerFactory.getLogger(ExportService.class);
/*     */   
/*     */   @Value("${uploadfile-url}")
/*     */   private String uploadfileUrl;
/*     */   
/*     */   @Value("${response-uploadfile-url}")
/*     */   private String responseUploadfileUrl;
/*     */   
/*     */   @Autowired
/*     */   public Environment env;
/*     */   
/*     */   @Autowired
/*     */   public ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ObjectMapper objectMapper;
/*     */   
/*     */   @Autowired
/*     */   PhieuInNhanThuocProcess phieuInNhanThuocProcess;
/*     */   
/*     */   @Autowired
/*     */   SoTiepDonProcess soTiepDonProcess;
/*     */   
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuDangKyKhamProcess phieuDangKyKhamProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuKhamVaoVienProcess phieuKhamVaoVienProcess;
/*     */   
/*     */   @Autowired
/*     */   HenGioTraKetQuaProcess henGioTraKetQuaProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuDieuTriProcess phieuDieuTriProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuBenhAnProcess phieuBenhAnProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuTuVongProcess phieuTuVongProcess;
/*     */   
/*     */   @Autowired
/*     */   DonThuocTheoKhoProcess donThuocTheoKhoProcess;
/*     */   
/*     */   @Autowired
/*     */   DonThuocMuaNgoaiProcess donThuocMuaNgoaiProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuCDDVProcess phieuCDDVProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuKetQuaProcess phieuKetQuaProcess;
/*     */   
/*     */   @Autowired
/*     */   GiayChuyenTuyenProcess giayChuyenTuyenProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuHenTaiKhamProcess phieuHenTaiKhamProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuHTUTTProcess phieuHTUTTProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuThuTienKhoProcess phieuThuTienKhoProcess;
/*     */   
/*     */   @Autowired
/*     */   BaoCaoTaiChinhProcess baoCaoTaiChinhProcess;
/*     */   
/*     */   @Autowired
/*     */   GiayRaVienProcess giayRaVienProcess;
/*     */   
/*     */   @Autowired
/*     */   PhieuThanhToanProcess phieuThanhToanProcess;
/*     */   
/*     */   @Autowired
/*     */   GiayChungNhanPTTTProcess giayChungNhanPTTTProcess;
/*     */   
/*     */   @Autowired
/*     */   BarcodeHelper barcodeHelper;
/*     */   
/*     */   @Autowired
/*     */   public InsertImageToWord insertImageToWord;
/*     */   
/*     */   private final FileUtils fileUtils;
/*     */   
/*     */   @Autowired
/*     */   private DonThuocKhachLeProcess donThuocKhachLeProcess;
/*     */   
/*     */   @Autowired
/*     */   private BangKeThanhToanProcess bangKeThanhToanProcess;
/*     */   
/*     */   public ExportService(FileUtils fileUtils) {
/* 126 */     this.fileUtils = fileUtils;
/*     */   }
/*     */   
/*     */   public ApiResponse process(String file_code, ExportModel exportModel, boolean isPdf) {
/* 130 */     ApiResponse rs = new ApiResponse(); try {
/*     */       Integer all, x; String p, sp[], pkq, spPkq[];
/* 132 */       if (file_code.equalsIgnoreCase("DON_THUOC")) {
/* 133 */         if (exportModel.getTicketId() != null) {
/* 134 */           file_code = "DON_THUOC_MUA_NGOAI";
/*     */         } else {
/* 136 */           file_code = "DON_THUOC_THEO_KHO";
/*     */         } 
/*     */       }
/* 139 */       String lang = StringUtils.isEmpty(exportModel.getLanguage()) ? "VI" : exportModel.getLanguage().toUpperCase(Locale.ROOT);
/* 140 */       String filePath = this.uploadfileUrl + File.separator + file_code + "_" + lang + ".docx";
/* 141 */       String contentQrCode = exportModel.getCheckinId() + "";
/* 142 */       String contentBarCode = exportModel.getCheckinId() + "";
/*     */       
/* 144 */       List<MergeFieldDTO> fieldData = new ArrayList<>();
/* 145 */       MergeFieldDTO mergeFieldDTO = new MergeFieldDTO();
/* 146 */       Calendar calendar = Calendar.getInstance();
/* 147 */       boolean hasInsImage = false;
/* 148 */       boolean hasInsBarcode = false;
/* 149 */       boolean hasInsQrcode = false;
/* 150 */       boolean loopBarCode = false;
/* 151 */       boolean loopNo = false;
/* 152 */       Set<Integer> pdId = new HashSet<>();
/*     */       
/* 154 */       switch (file_code) {
/*     */         case "IN_TAT_CA_NHAN_THUOC":
/* 156 */           all = this.phieuInNhanThuocProcess.getAllProcess(exportModel, fieldData, pdId);
/* 157 */           exportModel.setNumberOfBarCode(all);
/* 158 */           loopBarCode = true;
/* 159 */           loopNo = true;
/*     */           break;
/*     */         case "IN_NHAN_THUOC":
/* 162 */           loopBarCode = true;
/* 163 */           loopNo = true;
/* 164 */           x = this.phieuInNhanThuocProcess.getProcess(exportModel, fieldData, pdId);
/* 165 */           exportModel.setNumberOfBarCode(x);
/*     */           break;
/*     */         case "LAY_SO_TIEP_DON":
/* 168 */           hasInsImage = hasInsBarcode = hasInsQrcode = true;
/* 169 */           this.soTiepDonProcess.getProcess(exportModel, fieldData);
/*     */           break;
/*     */         case "PHIEU_DANG_KY_KHAM":
/* 172 */           contentBarCode = contentQrCode = String.valueOf(exportModel.getCheckinId());
/* 173 */           hasInsImage = hasInsBarcode = hasInsQrcode = true;
/* 174 */           this.phieuDangKyKhamProcess.getProcess(exportModel, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_KHAM_VAO_VIEN":
/* 177 */           this.phieuKhamVaoVienProcess.getProcess(exportModel, calendar, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "HEN_GIO_TRA_KET_QUA":
/*     */         case "MAU_BARCODE":
/* 181 */           hasInsImage = hasInsBarcode = true;
/* 182 */           contentBarCode = this.henGioTraKetQuaProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_DIEU_TRI":
/* 185 */           hasInsImage = hasInsBarcode = true;
/* 186 */           contentBarCode = this.phieuDieuTriProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_BENH_AN":
/* 189 */           this.phieuBenhAnProcess.getProcess(filePath, exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */ 
/*     */         
/*     */         case "GIAY_CHUNG_TU":
/* 194 */           this.phieuTuVongProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "DON_THUOC":
/*     */         case "DON_THUOC_MUA_NGOAI":
/* 198 */           this.donThuocMuaNgoaiProcess.getProcess(exportModel, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         
/*     */         case "DON_THUOC_THEO_KHO":
/* 202 */           hasInsQrcode = true;
/* 203 */           contentQrCode = String.valueOf(exportModel.getTicketId());
/* 204 */           this.donThuocTheoKhoProcess.getProcess(exportModel, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         
/*     */         case "PHIEU_CHI_DINH_DV":
/* 208 */           hasInsImage = hasInsBarcode = true;
/* 209 */           p = this.phieuCDDVProcess.getProcess(exportModel, contentBarCode, filePath, this.uploadfileUrl, lang, fieldData, mergeFieldDTO);
/* 210 */           sp = p.split("#");
/* 211 */           if (sp.length > 0) {
/* 212 */             contentBarCode = sp[0];
/* 213 */             filePath = sp[1];
/*     */           } 
/*     */           break;
/*     */         case "PHIEU_KET_QUA":
/* 217 */           hasInsBarcode = hasInsImage = true;
/* 218 */           pkq = this.phieuKetQuaProcess.getProcess(exportModel, contentBarCode, filePath, this.uploadfileUrl, calendar, lang, fieldData, mergeFieldDTO);
/* 219 */           spPkq = pkq.split("#");
/* 220 */           if (spPkq.length > 0) {
/* 221 */             contentBarCode = spPkq[0];
/* 222 */             filePath = spPkq[1];
/*     */           } 
/*     */           break;
/*     */         case "GIAY_CHUYEN_TUYEN":
/* 226 */           this.giayChuyenTuyenProcess.getProcess(exportModel, calendar, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_HEN_TAI_KHAM":
/* 229 */           hasInsBarcode = hasInsImage = true;
/* 230 */           this.phieuHenTaiKhamProcess.getProcess(exportModel, calendar, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_HOAN_UNG":
/* 233 */           hasInsBarcode = hasInsImage = true;
/* 234 */           this.phieuHTUTTProcess.getProcess(exportModel, contentBarCode, calendar, fieldData, mergeFieldDTO, "HU");
/*     */           break;
/*     */         case "PHIEU_TAM_UNG":
/* 237 */           hasInsBarcode = hasInsImage = true;
/* 238 */           this.phieuHTUTTProcess.getProcess(exportModel, contentBarCode, calendar, fieldData, mergeFieldDTO, "TU");
/*     */           break;
/*     */         case "PHIEU_THU_TIEN":
/* 241 */           hasInsBarcode = hasInsImage = true;
/* 242 */           this.phieuHTUTTProcess.getProcess(exportModel, contentBarCode, calendar, fieldData, mergeFieldDTO, "TT");
/*     */           break;
/*     */         case "PHIEU_THU_TIEN_KHO":
/* 245 */           hasInsBarcode = hasInsImage = true;
/* 246 */           this.phieuThuTienKhoProcess.getProcess(exportModel, contentBarCode, calendar, fieldData, mergeFieldDTO, "TT");
/*     */           break;
/*     */         case "BAO_CAO_TAI_CHINH_DOC":
/* 249 */           this.baoCaoTaiChinhProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "GIAY_RA_VIEN":
/* 252 */           this.giayRaVienProcess.getProcess(exportModel, calendar, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "PHIEU_THANH_TOAN":
/* 255 */           hasInsBarcode = hasInsImage = true;
/* 256 */           this.phieuThanhToanProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "GIAY_CHUNG_NHAN_PTTT":
/* 259 */           this.giayChungNhanPTTTProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         case "DON_THUOC_KHACH_LE":
/* 262 */           this.donThuocKhachLeProcess.getProcess(exportModel, fieldData, mergeFieldDTO);
/*     */           break;
/*     */         
/*     */         case "BANG_KE_THANH_TOAN":
/* 266 */           hasInsBarcode = hasInsImage = true;
/* 267 */           this.bangKeThanhToanProcess.getProcess(exportModel, contentBarCode, fieldData, mergeFieldDTO);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 272 */       String fileResponsePath = this.responseUploadfileUrl + File.separator + file_code + "_" + UUID.randomUUID() + "_" + lang + ".docx";
/*     */       
/* 274 */       Path rootPath = Paths.get(filePath, new String[0]);
/* 275 */       logger.info("Đường dẫn: " + fileResponsePath);
/* 276 */       if (!Files.exists(rootPath, new java.nio.file.LinkOption[0])) {
/* 277 */         return this.apiError.getError("701", new String[] { file_code });
/*     */       }
/* 279 */       List<String> fileDelete = new ArrayList<>();
/* 280 */       if (hasInsImage) {
/*     */         
/* 282 */         File file = new File(filePath);
/* 283 */         List<byte[]> files = (List)new ArrayList<>();
/* 284 */         if (hasInsBarcode && StringUtils.isNotBlank(contentBarCode)) {
/*     */ 
/*     */ 
/*     */           
/* 288 */           byte[] img = BarcodeHelper.generateBarQRCode(contentBarCode, 200, 60, false);
/* 289 */           for (int i = 0; i < exportModel.getNumberOfBarCode().intValue(); i++) {
/* 290 */             files.add(img);
/*     */           }
/*     */         } 
/* 293 */         if (hasInsQrcode && StringUtils.isNotBlank(contentBarCode)) {
/*     */ 
/*     */           
/* 296 */           byte[] img = BarcodeHelper.generateBarQRCode(contentQrCode, 200, 100, true);
/* 297 */           for (int i = 0; i < exportModel.getNumberOfBarCode().intValue(); i++) {
/* 298 */             files.add(img);
/*     */           }
/*     */         } 
/*     */         
/* 302 */         if (!files.isEmpty()) {
/*     */           
/* 304 */           String fN = this.uploadfileUrl + File.separator + UUID.randomUUID() + ".docx";
/* 305 */           fileDelete.add(fN);
/* 306 */           this.insertImageToWord.insertMutipleImageToWord2(file, files, fN);
/* 307 */           rootPath = Paths.get(fN, new String[0]);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 312 */       byte[] bytes = Files.readAllBytes(rootPath);
/*     */       
/* 314 */       Map<String, Object> fillMergeFieldRes = MailMergeUtil.fillMergeField(bytes, MailMergeUtil.prepareMergedField(fieldData));
/* 315 */       if (fillMergeFieldRes.get("exportStatus").equals("OK")) {
/* 316 */         byte[] filledBytesRes = (byte[])fillMergeFieldRes.get("bytes");
/* 317 */         if (isPdf && !loopNo) {
/* 318 */           byte[] pdfBytes = this.fileUtils.convertFile(filledBytesRes);
/* 319 */           rs.put("data", pdfBytes);
/*     */         } else {
/* 321 */           Throwable throwable; rs.put("data", filledBytesRes);
/* 322 */           FileOutputStream fos = new FileOutputStream(fileResponsePath); spPkq = null; 
/* 323 */           try { fos.write(filledBytesRes); } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; }
/* 324 */           finally { if (fos != null) if (throwable != null) { try { fos.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { fos.close(); }
/*     */                 }
/* 326 */            fileDelete.add(fileResponsePath);
/*     */         } 
/*     */         
/* 329 */         if (loopBarCode && !pdId.isEmpty()) {
/* 330 */           if (isPdf) {
/*     */             Throwable throwable;
/* 332 */             FileOutputStream fileOutputStream = new FileOutputStream(fileResponsePath); spPkq = null; 
/* 333 */             try { fileOutputStream.write(filledBytesRes); } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; }
/* 334 */             finally { if (fileOutputStream != null) if (throwable != null) { try { fileOutputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { fileOutputStream.close(); }
/*     */                   }
/* 336 */              fileDelete.add(fileResponsePath);
/*     */           } 
/*     */           
/* 339 */           FileInputStream templateStream = new FileInputStream(fileResponsePath);
/* 340 */           XWPFDocument doc = new XWPFDocument(templateStream);
/* 341 */           templateStream.close();
/*     */ 
/*     */           
/* 344 */           List<XWPFTable> table = doc.getTables();
/*     */           
/* 346 */           for (XWPFTable tb : table) {
/* 347 */             List<XWPFTableRow> rows = tb.getRows();
/*     */             
/* 349 */             for (XWPFTableRow r : rows) {
/* 350 */               List<XWPFTableCell> cells = r.getTableCells();
/*     */               
/* 352 */               for (XWPFTableCell c : cells) {
/* 353 */                 List<XWPFParagraph> pg = c.getParagraphs();
/* 354 */                 if (pg != null && !pg.isEmpty())
/* 355 */                   for (XWPFParagraph paragraph : pg) {
/* 356 */                     label327: for (XWPFRun run : paragraph.getRuns()) {
/*     */                       
/* 358 */                       String text = run.getText(0);
/* 359 */                       if (text != null)
/*     */                       {
/* 361 */                         for (Integer pid : pdId) {
/* 362 */                           if (text.contains(String.valueOf(pid))) {
/*     */                             InputStream imageStream;
/* 364 */                             run.setText("", 0);
/*     */                             
/* 366 */                             String str = this.uploadfileUrl + File.separator + pid + ".png";
/* 367 */                             byte[] newImageBytes = BarcodeHelper.generateBarQRCode(String.valueOf(pid), 200, 60, false);
/* 368 */                             FileOutputStream fileOutputStream = new FileOutputStream(str); Throwable throwable = null; 
/* 369 */                             try { fileOutputStream.write(newImageBytes);
/* 370 */                               if (fileOutputStream != null) { if (throwable != null) { try { fileOutputStream.close(); continue label327; } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { fileOutputStream.close(); }
/*     */                                 
/* 372 */                                 fileDelete.add(str);
/*     */ 
/*     */                                 
/* 375 */                                 imageStream = new FileInputStream(str);
/* 376 */                                 run.addPicture(imageStream, 5, str, Units.toEMU(100.0D), Units.toEMU(40.0D));
/* 377 */                                 imageStream.close(); continue; }  continue label327; } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { if (imageStream != null)
/*     */                                 if (throwable != null) { try { imageStream.close(); }
/*     */                                   catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */                                    }
/*     */                                 else { imageStream.close(); }
/*     */                                   }
/*     */                           
/*     */                           } 
/*     */                         }  } 
/*     */                     } 
/*     */                   }  
/*     */               } 
/*     */             } 
/* 390 */           }  String fN = this.uploadfileUrl + File.separator + UUID.randomUUID() + ".docx";
/* 391 */           fileDelete.add(fN);
/*     */ 
/*     */           
/* 394 */           try (FileOutputStream fos = new FileOutputStream(fN)) {
/* 395 */             doc.write(fos);
/*     */           } 
/*     */           
/* 398 */           Path rootPathOut = Paths.get(fN, new String[0]);
/* 399 */           byte[] bytesOut = Files.readAllBytes(rootPathOut);
/* 400 */           if (isPdf) {
/* 401 */             byte[] pdfBytes = this.fileUtils.convertFile(bytesOut);
/* 402 */             rs.put("data", pdfBytes);
/*     */           } else {
/* 404 */             rs.put("data", bytesOut);
/*     */           } 
/*     */         } 
/*     */         
/* 408 */         if (!fileDelete.isEmpty())
/*     */         {
/* 410 */           for (String f : fileDelete) {
/* 411 */             File deleteFile = new File(f);
/* 412 */             if (deleteFile.exists()) {
/* 413 */               deleteFile.delete();
/*     */             }
/*     */           } 
/*     */         }
/* 417 */         rs.put("status", ApiStatus.OK.name());
/* 418 */         rs.put("responseCode", "00");
/*     */       } else {
/* 420 */         return this.apiError.getError(fillMergeFieldRes.get("errorCode").toString(), new String[] { fillMergeFieldRes.get("errorMessage").toString() });
/*     */       }
/*     */     
/* 423 */     } catch (Exception e) {
/* 424 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 425 */       logger.error(exceptionAsString);
/* 426 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 428 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mappingAutoMerfield(String fileTemplate, Map<String, Object> model, List<MergeFieldDTO> fieldData) throws JsonProcessingException {
/*     */     try {
/* 434 */       Path rootPath = Paths.get(fileTemplate, new String[0]);
/* 435 */       byte[] bytes = Files.readAllBytes(rootPath);
/* 436 */       WordprocessingMLPackage document = MailMergeUtil.convertFileToDocument(bytes);
/* 437 */       List<String> mapRes = MailMergeUtil.getAllFieldsToListString(document);
/* 438 */       for (String str : mapRes) {
/* 439 */         MergeFieldDTO mergeFieldDTO = new MergeFieldDTO();
/* 440 */         if (model.containsKey(str)) {
/* 441 */           mergeFieldDTO.setCode(str);
/* 442 */           String value = (String)model.get(str);
/* 443 */           mergeFieldDTO.setValue(value);
/* 444 */           mergeFieldDTO.setMergeField(str);
/* 445 */           fieldData.add(mergeFieldDTO);
/*     */         } 
/*     */       } 
/* 448 */     } catch (Exception ex) {
/* 449 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 450 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Service\ExportService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */