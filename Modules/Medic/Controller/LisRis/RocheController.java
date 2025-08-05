/*     */ package nencer.app.Modules.Medic.Controller.LisRis;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Roche.RocheData;
/*     */ import nencer.app.Modules.Medic.Model.Roche.RocheModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.scheduling.annotation.Scheduled;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class RocheController extends BaseMedicController {
/*     */   public void getResponeTask2() throws IOException {
/*     */     try {
/*  35 */       String res = "\\\\dc2nasfile01\\SBDATA\\Private\\HO\\Khoi CNTT\\ITDocuments\\Projects\\2. CRM 2020";
/*     */       
/*  37 */       File folder = new File(res);
/*  38 */       for (File file : (File[])Objects.<File[]>requireNonNull(folder.listFiles())) {
/*  39 */         if (file.isFile()) {
/*  40 */           String data = FileUtils.readFileToString(file, "UTF-8");
/*  41 */           System.out.println(data);
/*     */         } 
/*     */       } 
/*  44 */     } catch (Exception ex) {
/*  45 */       logger.error(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Scheduled(fixedRateString = "6000", initialDelayString = "0")
/*     */   public void getResponeTask() throws IOException {
/*     */     try {
/*  57 */       String res = this.env.getProperty("recho_res");
/*  58 */       File folder = new File(res);
/*     */       
/*  60 */       File[] files = folder.listFiles();
/*  61 */       if (files != null && files.length > 0) {
/*  62 */         for (File file : files) {
/*  63 */           if (file.isFile()) {
/*  64 */             logger.info("#START: " + new Date());
/*  65 */             if (file.getName().endsWith(".hl7")) {
/*  66 */               String data = FileUtils.readFileToString(file, "UTF-8");
/*  67 */               if (rocheProcess(file, data))
/*     */                 break; 
/*  69 */             }  if (file.getName().endsWith(".a100")) {
/*  70 */               String data = FileUtils.readFileToString(file, "UTF-8");
/*  71 */               if (auto100(file, data))
/*     */                 break; 
/*  73 */             }  if (file.getName().endsWith(".cobas")) {
/*  74 */               String data = FileUtils.readFileToString(file, "UTF-8");
/*  75 */               if (cobase411(file, data))
/*     */                 break; 
/*  77 */             }  if (file.getName().endsWith(".sys550")) {
/*  78 */               String data = FileUtils.readFileToString(file, "UTF-8");
/*  79 */               if (sysmex550(file, data))
/*     */                 break; 
/*  81 */             }  if (file.getName().endsWith(".a480")) {
/*  82 */               String data = FileUtils.readFileToString(file, "UTF-8");
/*  83 */               if (sysmex550(file, data))
/*     */                 break; 
/*     */             } 
/*  86 */             file.delete();
/*  87 */             logger.info("#FINISH: " + new Date());
/*     */           } 
/*     */         } 
/*     */       }
/*  91 */     } catch (Exception ex) {
/*  92 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  93 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean rocheProcess(File file, String data) {
/*     */     try {
/* 100 */       String[] lines = data.split(new String("\r\n|\\n|\\r|\\;"));
/*     */       
/* 102 */       String ticketId = lines[4].split("\\|", -1)[2];
/*     */       
/* 104 */       logger.info("#1. TICKET_IDroche: " + ticketId);
/* 105 */       Integer tk = this.ticketRepository.havingTicket(Integer.valueOf(Integer.parseInt(ticketId)));
/* 106 */       if (tk == null || tk.intValue() <= 0) return false; 
/*     */       try {
/* 108 */         if (file != null)
/* 109 */           this.rocheDataRepository.save(RocheData.builder()
/* 110 */               .fileName(file.getName())
/* 111 */               .ticketId(Integer.valueOf(Integer.parseInt(ticketId)))
/* 112 */               .filePath(file.getAbsolutePath())
/* 113 */               .fileData(data)
/* 114 */               .createdAt(new Date())
/* 115 */               .direction("IN")
/* 116 */               .build()); 
/* 117 */       } catch (Exception ex) {
/* 118 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 119 */         logger.error(exceptionAsString);
/* 120 */         return false;
/*     */       } 
/* 122 */       logger.info("#2. OBR: " + lines[4]);
/* 123 */       if (lines != null && lines.length > 5) {
/* 124 */         for (int j = 5; j < lines.length; j++) {
/*     */           
/* 126 */           String[] obx = lines[j].split("\\|", -1);
/* 127 */           if (obx != null && obx.length > 3) {
/*     */             
/* 129 */             String code = obx[3];
/* 130 */             String resultCode = obx[5];
/* 131 */             String resultOriginal = obx[7];
/* 132 */             if (updateResult(lines, Integer.valueOf(Integer.parseInt(ticketId)), j, code.split("\\^")[0], resultCode, resultOriginal, "#2. TICKET_IDroche: "))
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 137 */         return true;
/*     */       } 
/* 139 */       return false;
/* 140 */     } catch (Exception ex) {
/* 141 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 142 */       logger.error(exceptionAsString);
/* 143 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean auto100(File file, String data) {
/*     */     try {
/* 167 */       String[] lines = data.split(new String("\r\n|\\n|\\r|\\;"));
/* 168 */       String barCode = lines[1].split("\\:", -1)[1];
/* 169 */       logger.info("#1. barcodeauto100: " + barCode);
/* 170 */       Integer ticketId = this.ticketRepository.getByBarcode(barCode);
/* 171 */       if (ticketId == null || ticketId.intValue() <= 0) return false; 
/*     */       try {
/* 173 */         if (file != null)
/* 174 */           this.rocheDataRepository.save(RocheData.builder()
/* 175 */               .fileName(file.getName())
/* 176 */               .ticketId(ticketId)
/* 177 */               .filePath(file.getAbsolutePath())
/* 178 */               .fileData(data)
/* 179 */               .createdAt(new Date())
/* 180 */               .direction("IN")
/* 181 */               .build()); 
/* 182 */       } catch (Exception ex) {
/* 183 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 184 */         logger.error(exceptionAsString);
/* 185 */         return false;
/*     */       } 
/* 187 */       if (lines != null && lines.length > 5) {
/* 188 */         for (int j = 5; j < lines.length; j++) {
/*     */           
/* 190 */           String[] r = lines[j].split(new String(" "));
/* 191 */           if (r != null) {
/* 192 */             StringBuilder stringBuilder = new StringBuilder();
/*     */             
/* 194 */             for (String rx : r) {
/* 195 */               if (StringUtils.isNotBlank(rx)) {
/* 196 */                 stringBuilder.append(rx + "/");
/*     */               }
/*     */             } 
/* 199 */             String strFinal = StringUtils.chop(stringBuilder.toString());
/* 200 */             System.out.println(strFinal);
/* 201 */             if (StringUtils.isNotBlank(strFinal)) {
/* 202 */               String[] lineResult = strFinal.split("\\/", -1);
/* 203 */               String testCode = lineResult[0];
/* 204 */               String resultCode = lineResult[1];
/* 205 */               String resultOriginal = lineResult[2];
/*     */ 
/*     */               
/* 208 */               if (updateResult(lines, ticketId, j, testCode, resultCode, resultOriginal, "#2. barcodeauto100: ")) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */           } 
/* 213 */           if (lines[j].equalsIgnoreCase("\003")) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } else {
/* 218 */         return true;
/*     */       } 
/* 220 */       return false;
/* 221 */     } catch (Exception ex) {
/* 222 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 223 */       logger.error(exceptionAsString);
/* 224 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cobase411(File file, String data) {
/*     */     try {
/* 244 */       String[] lines = data.split(new String("\r\n|\\n|\\r|\\;"));
/* 245 */       String barcode = lines[2].split("\\|", -1)[2];
/* 246 */       logger.info("#1. barcode_cobase411: " + barcode);
/* 247 */       Integer ticketId = this.ticketRepository.getByBarcode(barcode);
/* 248 */       if (ticketId == null || ticketId.intValue() <= 0) return false; 
/*     */       try {
/* 250 */         if (file != null)
/* 251 */           this.rocheDataRepository.save(RocheData.builder()
/* 252 */               .fileName(file.getName())
/* 253 */               .ticketId(ticketId)
/* 254 */               .filePath(file.getAbsolutePath())
/* 255 */               .fileData(data)
/* 256 */               .createdAt(new Date())
/* 257 */               .direction("IN")
/* 258 */               .build()); 
/* 259 */       } catch (Exception ex) {
/* 260 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 261 */         logger.error(exceptionAsString);
/* 262 */         return false;
/*     */       } 
/* 264 */       if (lines != null && lines.length > 5) {
/* 265 */         for (int j = 5; j < lines.length; j++) {
/* 266 */           String[] r = lines[j].split("\\|", -1);
/* 267 */           if (r != null && r.length > 3 && r[0].equalsIgnoreCase("R")) {
/*     */             
/* 269 */             String code = r[2].replace("^", "");
/* 270 */             String testCode = code.split("\\/", -1)[0];
/* 271 */             String resultCode = r[3];
/* 272 */             String resultOriginal = "";
/*     */ 
/*     */             
/* 275 */             if (updateResult(lines, ticketId, j, testCode, resultCode, resultOriginal, "#2. barcode_cobase411: "))
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 280 */         return true;
/*     */       } 
/* 282 */       return false;
/* 283 */     } catch (Exception ex) {
/* 284 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 285 */       logger.error(exceptionAsString);
/* 286 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean sysmex550(File file, String data) {
/*     */     try {
/* 387 */       String[] lines = data.split(new String("\r\n|\\n|\\r|\\;"));
/* 388 */       String barCode = lines[2].split("\\|", -1)[4];
/* 389 */       logger.info("#1. sysmex550: " + barCode);
/* 390 */       Integer ticketId = this.ticketRepository.getByBarcode(barCode);
/* 391 */       if (ticketId == null || ticketId.intValue() <= 0) return false; 
/*     */       try {
/* 393 */         if (file != null)
/* 394 */           this.rocheDataRepository.save(RocheData.builder()
/* 395 */               .fileName(file.getName())
/* 396 */               .ticketId(ticketId)
/* 397 */               .filePath(file.getAbsolutePath())
/* 398 */               .fileData(data)
/* 399 */               .createdAt(new Date())
/* 400 */               .direction("IN")
/* 401 */               .build()); 
/* 402 */       } catch (Exception ex) {
/* 403 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 404 */         logger.error(exceptionAsString);
/* 405 */         return false;
/*     */       } 
/* 407 */       if (lines != null && lines.length > 10) {
/* 408 */         for (int j = 10; j < lines.length; j++) {
/* 409 */           if (lines[j].startsWith("\0020R") || lines[j]
/* 410 */             .startsWith("\0021R") || lines[j]
/* 411 */             .startsWith("\0022R") || lines[j]
/* 412 */             .startsWith("\0023R") || lines[j]
/* 413 */             .startsWith("\0024R") || lines[j]
/* 414 */             .startsWith("\0025R") || lines[j]
/* 415 */             .startsWith("\0026R") || lines[j]
/* 416 */             .startsWith("\0027R")) {
/*     */             
/* 418 */             String[] r = lines[j].split("\\|", -1);
/* 419 */             if (r != null && r.length > 4) {
/* 420 */               String code = r[2].replace("^1", "").replace("^", "");
/* 421 */               String testCode = code.split("\\/", -1)[0];
/* 422 */               String resultCode = r[3];
/* 423 */               String resultOriginal = r[4];
/*     */ 
/*     */               
/* 426 */               if (updateResult(lines, ticketId, j, testCode, resultCode, resultOriginal, "#2. sysmex550: ")) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */           } 
/* 431 */           if (lines[j].equalsIgnoreCase("\004")) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } else {
/* 436 */         return true;
/*     */       } 
/* 438 */       return false;
/* 439 */     } catch (Exception ex) {
/* 440 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 441 */       logger.error(exceptionAsString);
/* 442 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean updateResult(String[] lines, Integer ticketId, int j, String testCode, String resultCode, String resultOriginal, String s) {
/* 447 */     Integer serviceId = this.testCodeMappingRepository.findAllByTestCode2(testCode);
/* 448 */     if (serviceId == null || serviceId.intValue() <= 0) return true; 
/* 449 */     Integer msos = this.orderServiceRepository.findByServiceIdAndTicketId(serviceId, ticketId);
/* 450 */     if (msos != null && msos.intValue() > 0) {
/* 451 */       logger.info(s + j + "_" + lines[j]);
/*     */       
/* 453 */       this.orderServiceRepository.updateLisResultRoche(msos, resultCode, resultOriginal);
/*     */     } 
/*     */     
/* 456 */     Integer lmos = this.orderServiceExtRepository.getByServiceIdAndTicketId(serviceId, ticketId);
/* 457 */     if (lmos != null && lmos.intValue() > 0) {
/* 458 */       logger.info(s + j + "_" + lines[j]);
/* 459 */       this.orderServiceExtRepository.updateResultRoche(lmos, resultCode, resultOriginal);
/*     */     } 
/* 461 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/roche/updateManual/{ticketId}"})
/*     */   public ApiResponse create(@PathVariable @Valid Integer ticketId) {
/* 473 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 475 */       Integer omt = this.ticketRepository.havingTicket(ticketId);
/* 476 */       if (omt == null || omt.intValue() <= 0) {
/* 477 */         return this.apiError.getError("02");
/*     */       }
/* 479 */       List<RocheData> rocheData = this.rocheDataRepository.findByTicketId(ticketId);
/* 480 */       if (rocheData == null || rocheData.size() <= 0) {
/* 481 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 484 */       boolean x = rocheProcess((File)null, ((RocheData)rocheData.get(0)).getFileData());
/*     */       
/* 486 */       rs.put("status", "OK");
/* 487 */       rs.put("responseCode", "00");
/* 488 */       rs.put("data", Boolean.valueOf(!x));
/*     */     }
/* 490 */     catch (Exception e) {
/* 491 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 492 */       logger.error(exceptionAsString);
/* 493 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 494 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 496 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/roche/saveResult"})
/*     */   public ApiResponse saveRocheResult(@Valid @RequestBody RocheModel request) {
/* 508 */     ApiResponse rs = new ApiResponse();
/* 509 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 511 */       boolean x = rocheProcess((File)null, request.getData());
/*     */       
/* 513 */       rs.put("status", "OK");
/* 514 */       rs.put("responseCode", "00");
/* 515 */       rs.put("data", Boolean.valueOf(!x));
/*     */     }
/* 517 */     catch (Exception e) {
/* 518 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 519 */       logger.error(exceptionAsString);
/* 520 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 521 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 523 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 534 */     String data = "\005\0021H|\\^&|||    XN-550^00-12^12003^^^^BD634545||||||||E1394-97\n\003B4\n\0022P|1|||123456|^THU^NGUYEN|||U|||||^||||||||||||^^^\n\00364\n\0023C|1||\n\0032B\n\0024O|1||^^                NGUYET^M|^^^^WBC\\^^^^RBC\\^^^^HGB\\^^^^HCT\\^^^^MCV\\^^^^MCH\\^^^^MCHC\\^^^^PLT\\^^^^RDW-SD\\^^^^RDW-CV\\^^^^PDW\\^^^^MPV\\^^^^P-LCR\\^^^^PCT\\^^^^NEUT#\\^^^^LYMPH#\\^^^^MONO#\\^^^^EO#\\^^^^BASO#\\^^^^NEUT%\\^^^^LYMPH%\\^^^^MONO%\\^^^^EO%\\^^^^BASO%\\^^^^IG#\\^^^^IG%|||||||N||||||||||||||F\n\003D6\n\0025C|1||\n\0032D\n\0026R|1|^^^^WBC^1|5.23|10*3/uL||N||F||||20220916113243\n\0034A\n\0027R|2|^^^^RBC^1|4.34|10*6/uL||N||F||||20220916113243\n\0034B\n\0020R|3|^^^^HGB^1|12.6|g/dL||L||F||||20220916113243\n\003D0\n\0021R|4|^^^^HCT^1|38.1|%||N||F||||20220916113243\n\003C4\n\0022R|5|^^^^MCV^1|87.8|fL||N||F||||20220916113243\n\00365\n\0023R|6|^^^^MCH^1|29.0|pg||N||F||||20220916113243\n\00372\n\0024R|7|^^^^MCHC^1|33.1|g/dL||N||F||||20220916113243\n\00322\n\0025R|8|^^^^PLT^1|192|10*3/uL||N||F||||20220916113243\n\00338\n\0026R|9|^^^^NEUT%^1|55.6|%||W||F||||20220916113243\n\0035D\n\0027R|10|^^^^LYMPH%^1|29.1|%||W||F||||20220916113243\n\003D0\n\0020R|11|^^^^MONO%^1|13.2|%||W||F||||20220916113243\n\00373\n\0021R|12|^^^^EO%^1|1.5|%||N||F||||20220916113243\n\00397\n\0022R|13|^^^^BASO%^1|0.6|%||N||F||||20220916113243\n\0032A\n\0023R|14|^^^^NEUT#^1|2.91|10*3/uL||W||F||||20220916113243\n\00309\n\0024R|15|^^^^LYMPH#^1|1.52|10*3/uL||W||F||||20220916113243\n\00355\n\0025R|16|^^^^MONO#^1|0.69|10*3/uL||W||F||||20220916113243\n\0030D\n\0026R|17|^^^^EO#^1|0.08|10*3/uL||N||F||||20220916113243\n\0035A\n\0027R|18|^^^^BASO#^1|0.03|10*3/uL||N||F||||20220916113243\n\003E8\n\0020R|19|^^^^IG%^1|0.6|%||W||F||||20220916113243\n\003A2\n\0021R|20|^^^^IG#^1|0.03|10*3/uL||W||F||||20220916113243\n\0034F\n\0022R|21|^^^^RDW-SD^1|40.5|fL||N||F||||20220916113243\n\00350\n\0023R|22|^^^^RDW-CV^1|12.5|%||N||F||||20220916113243\n\003C6\n\0024R|23|^^^^PDW^1|9.6|fL||N||F||||20220916113243\n\00364\n\0025R|24|^^^^MPV^1|9.4|fL||N||F||||20220916113243\n\0036C\n\0026R|25|^^^^P-LCR^1|20.1|%||N||F||||20220916113243\n\00372\n\0027R|26|^^^^PCT^1|0.18|%||N||F||||20220916113243\n\00303\n\0020R|27|^^^^Left_Shift?|0|||||F||||20220916113243\n\003A4\n\0021R|28|^^^^Atypical_Lympho?|150|||A||F||||20220916113243\n\00374\n\0022R|29|^^^^NRBC?|20|||||F||||20220916113243\n\00317\n\0023R|30|^^^^RBC_Agglutination?|70|||||F||||20220916113243\n\0037C\n\0024R|31|^^^^Turbidity/HGB_Interference?|90|||||F||||20220916113243\n\003ED\n\0025R|32|^^^^Iron_Deficiency?|80|||||F||||20220916113243\n\003DF\n\0026R|33|^^^^HGB_Defect?|80|||||F||||20220916113243\n\00372\n\0027R|34|^^^^Fragments?|0|||||F||||20220916113243\n\00368\n\0020R|35|^^^^PLT_Clumps?|10|||||F||||20220916113243\n\003AF\n\0021R|36|^^^^Positive_Morph||||A||F||||20220916113243\n\00347\n\0022R|37|^^^^SCAT_WDF|PNG&R&20220916&R&2022_09_16_11_32_NGUYET_WDF.PNG|||N||F||||20220916113243\n\00327\n\0023R|38|^^^^SCAT_WDF-CBC|PNG&R&20220916&R&2022_09_16_11_32_NGUYET_WDF_CBC.PNG|||N||F||||20220916113243\n\00345\n\0024R|39|^^^^DIST_RBC|PNG&R&20220916&R&2022_09_16_11_32_NGUYET_RBC.PNG|||N||F||||20220916113243\n\00320\n\0025R|40|^^^^DIST_PLT|PNG&R&20220916&R&2022_09_16_11_32_NGUYET_PLT.PNG|||N||F||||20220916113243\n\0034B\n\0026C|1||\n\0032E\n\0027L|1|N\n\0030A\n\004";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 629 */     String[] lines = data.split(new String("\r\n|\\n|\\r|\\;"));
/* 630 */     String barCode = lines[2].split("\\|", -1)[4];
/* 631 */     System.out.println(barCode);
/* 632 */     if (lines != null && lines.length > 10) {
/* 633 */       for (int j = 10; j < lines.length; j++) {
/* 634 */         if (lines[j].startsWith("\0020R") || lines[j]
/* 635 */           .startsWith("\0021R") || lines[j]
/* 636 */           .startsWith("\0022R") || lines[j]
/* 637 */           .startsWith("\0023R") || lines[j]
/* 638 */           .startsWith("\0024R") || lines[j]
/* 639 */           .startsWith("\0025R") || lines[j]
/* 640 */           .startsWith("\0026R") || lines[j]
/* 641 */           .startsWith("\0027R")) {
/*     */           
/* 643 */           String[] r = lines[j].split("\\|", -1);
/* 644 */           if (r != null && r.length > 4) {
/* 645 */             System.out.println(r[2].replace("^1", "").replace("^", "") + "_" + r[3] + "_" + r[4]);
/*     */           }
/*     */         } 
/* 648 */         if (lines[j].equalsIgnoreCase("\004")) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } else {
/* 653 */       System.out.println("xxx");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\LisRis\RocheController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */