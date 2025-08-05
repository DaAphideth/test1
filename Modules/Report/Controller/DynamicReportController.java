/*     */ package nencer.app.Modules.Report.Controller;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.nio.file.FileSystems;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Base64;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReport;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReportHis;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReportVariable;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReportVariableHis;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.dynamic.DynamicReportModel;
/*     */ import nencer.app.Modules.Report.Model.dynamic.DynamicReportVariableModel;
/*     */ import nencer.app.Modules.Report.Repository.CommonReportRepo;
/*     */ import nencer.app.Modules.Report.Repository.DynamicReportHisRepository;
/*     */ import nencer.app.Modules.Report.Repository.DynamicReportRepository;
/*     */ import nencer.app.Modules.Report.Repository.DynamicReportVariableHisRepository;
/*     */ import nencer.app.Modules.Report.Repository.DynamicReportVariableRepository;
/*     */ import nencer.app.Modules.Report.Service.ReportService;
/*     */ import nencer.app.Modules.Report.Ultil.ReportUtil;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.ApiStatus;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class DynamicReportController
/*     */   extends BaseMedicController
/*     */ {
/*     */   @Value("${dynamic_report-file-url}")
/*     */   private String reportUrl;
/*     */   @Value("${response-uploadfile-url}")
/*     */   private String responseUploadfileUrl;
/*     */   @Autowired
/*     */   private DynamicReportRepository dynamicReportRepository;
/*     */   @Autowired
/*     */   private DynamicReportHisRepository dynamicReportHisRepository;
/*     */   
/*     */   @GetMapping({"/report/dynamicReport"})
/*     */   public ApiResponse getDynamicReport(@RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer userId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  75 */     ApiResponse rs = new ApiResponse();
/*  76 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  78 */       List<DynamicReport> dynamicReports = this.commonReportRepo.spGetDynamicReport(userId, searchValue, page, size);
/*     */       
/*  80 */       data.put("dataRes", dynamicReports);
/*  81 */       data.put("totalItems", Integer.valueOf((dynamicReports.size() > 0) ? ((DynamicReport)dynamicReports.get(0)).getTotalRecord().intValue() : 0));
/*  82 */       rs.put("status", "OK");
/*  83 */       rs.put("responseCode", "00");
/*  84 */       rs.put("data", data);
/*  85 */       return rs;
/*  86 */     } catch (Exception e) {
/*  87 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  88 */       logger.error(exceptionAsString);
/*  89 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  90 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     }  } @Autowired
/*     */   private DynamicReportVariableRepository dynamicReportVariableRepository; @Autowired
/*     */   private DynamicReportVariableHisRepository dynamicReportVariableHisRepository; @Autowired
/*     */   private ReportService reportService; @Autowired
/*     */   private CommonReportRepo commonReportRepo; @GetMapping({"/report/dynamicReport/{rpCode}"})
/*  96 */   public ApiResponse getDynamicReport(@PathVariable @Valid String rpCode) { ApiResponse rs = new ApiResponse();
/*  97 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  99 */       DynamicReport dynamicReport = this.dynamicReportRepository.findByRpCode(rpCode).orElse(null);
/* 100 */       if (Objects.isNull(dynamicReport)) {
/* 101 */         return this.apiError.getError("202", new String[] { "rpCode" });
/*     */       }
/*     */       
/* 104 */       List<DynamicReportVariable> dynamicReportVariables = this.dynamicReportVariableRepository.getAllByRpId(dynamicReport.getRpId());
/* 105 */       List<DynamicReportVariableModel> responVariables = new ArrayList<>();
/* 106 */       for (DynamicReportVariable dynamicReportVariable : dynamicReportVariables) {
/* 107 */         DynamicReportVariableModel dynamicReportVariableModel = (DynamicReportVariableModel)this.modelMapper.map(dynamicReportVariable, DynamicReportVariableModel.class);
/* 108 */         if (dynamicReportVariable.getRpVarType().equalsIgnoreCase("option")) {
/* 109 */           List<Map<String, Object>> dynamicData = this.commonReportRepo.getVariableData(dynamicReportVariable.getRpVarSql());
/* 110 */           dynamicReportVariableModel.setRpVarData(dynamicData);
/*     */         } 
/* 112 */         responVariables.add(dynamicReportVariableModel);
/*     */       } 
/* 114 */       DynamicReportModel dynamicReportModel = (DynamicReportModel)this.modelMapper.map(dynamicReport, DynamicReportModel.class);
/* 115 */       dynamicReportModel.setVariables(responVariables);
/*     */       
/* 117 */       data.put("dataRes", dynamicReportModel);
/*     */       
/* 119 */       rs.put("status", "OK");
/* 120 */       rs.put("responseCode", "00");
/* 121 */       rs.put("data", data);
/* 122 */       return rs;
/* 123 */     } catch (Exception e) {
/* 124 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 125 */       logger.error(exceptionAsString);
/* 126 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 127 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/dynamicReport"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse addDynamicReport(@RequestBody DynamicReportModel request) {
/* 137 */     ApiResponse rs = new ApiResponse();
/* 138 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 140 */       DynamicReport dynamicReport = this.dynamicReportRepository.findByRpCode(request.getRpCode()).orElse(null);
/* 141 */       if (Objects.nonNull(dynamicReport)) {
/* 142 */         return this.apiError.getError("203", new String[] { "rpCode" });
/*     */       }
/*     */       
/* 145 */       dynamicReport = (DynamicReport)this.modelMapper.map(request, DynamicReport.class);
/* 146 */       dynamicReport.setRpCreateDate(new Date());
/* 147 */       dynamicReport.setRpUpdateDate(new Date());
/* 148 */       dynamicReport.setRpCreatedBy(request.getRpUpdateBy());
/* 149 */       dynamicReport.setRpUpdateBy(request.getRpUpdateBy());
/* 150 */       dynamicReport.setRpFileStoreName(request.getRpCode() + "." + request.getRpFileType());
/* 151 */       dynamicReport = (DynamicReport)this.dynamicReportRepository.save(dynamicReport);
/*     */       
/* 153 */       saveReportTemplateFile(dynamicReport.getRpFileStoreName(), request.getRpFileStream());
/*     */       
/* 155 */       if (request.getVariables() != null && request.getVariables().size() > 0) {
/* 156 */         List<DynamicReportVariableModel> dynamicReportVariableModels = request.getVariables();
/* 157 */         for (DynamicReportVariableModel dynamicReportVariableModel : dynamicReportVariableModels) {
/* 158 */           dynamicReportVariableModel.setRpId(dynamicReport.getRpId());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 163 */         List<DynamicReportVariable> dynamicReportVariables = (List<DynamicReportVariable>)dynamicReportVariableModels.stream().map(e -> (DynamicReportVariable)this.modelMapper.map(e, DynamicReportVariable.class)).collect(Collectors.toList());
/*     */         
/* 165 */         this.dynamicReportVariableRepository.saveAll(dynamicReportVariables);
/*     */       } 
/*     */ 
/*     */       
/* 169 */       data.put("rpId", dynamicReport.getRpId());
/* 170 */       data.put("rpCode", dynamicReport.getRpCode());
/* 171 */       rs.put("status", "OK");
/* 172 */       rs.put("responseCode", "00");
/* 173 */       rs.put("data", data);
/* 174 */       return rs;
/* 175 */     } catch (Exception e) {
/* 176 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 177 */       logger.error(exceptionAsString);
/* 178 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 179 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PutMapping({"/report/dynamicReport/{rpCode}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse editDynamicReport(@PathVariable @Valid String rpCode, @RequestBody DynamicReportModel request) {
/* 191 */     ApiResponse rs = new ApiResponse();
/* 192 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 195 */       DynamicReport dynamicReportCheck = this.dynamicReportRepository.findByRpCode(rpCode).orElse(null);
/* 196 */       if (Objects.isNull(dynamicReportCheck)) {
/* 197 */         return this.apiError.getError("203", new String[] { "rpCode" });
/*     */       }
/*     */       
/* 200 */       DynamicReport dynamicReport = (DynamicReport)this.modelMapper.map(request, DynamicReport.class);
/* 201 */       dynamicReport.setRpId(dynamicReportCheck.getRpId());
/* 202 */       dynamicReport.setRpUpdateDate(new Date());
/* 203 */       dynamicReport.setRpUpdateBy(request.getRpUpdateBy());
/* 204 */       dynamicReport.setRpFileStoreName(request.getRpCode() + "." + request.getRpFileType());
/* 205 */       dynamicReport = (DynamicReport)this.dynamicReportRepository.save(dynamicReport);
/*     */ 
/*     */       
/* 208 */       DynamicReportHis dhis = (DynamicReportHis)this.modelMapper.map(dynamicReport, DynamicReportHis.class);
/* 209 */       dhis.setCreatedDate(new Date());
/* 210 */       this.dynamicReportHisRepository.save(dhis);
/*     */       
/* 212 */       if (StringUtils.isNotBlank(request.getRpFileStream())) {
/* 213 */         deleteReportTemplateFile(dynamicReportCheck.getRpFileStoreName());
/* 214 */         saveReportTemplateFile(dynamicReport.getRpFileStoreName(), request.getRpFileStream());
/*     */       } 
/*     */       
/* 217 */       if (request.getVariables() != null && request.getVariables().size() > 0) {
/* 218 */         List<DynamicReportVariableModel> dynamicReportVariableModels = request.getVariables();
/* 219 */         for (DynamicReportVariableModel dynamicReportVariableModel : dynamicReportVariableModels) {
/* 220 */           dynamicReportVariableModel.setRpVarId(null);
/* 221 */           dynamicReportVariableModel.setRpId(dynamicReport.getRpId());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 226 */         List<DynamicReportVariable> dynamicReportVariables = (List<DynamicReportVariable>)dynamicReportVariableModels.stream().map(e -> (DynamicReportVariable)this.modelMapper.map(e, DynamicReportVariable.class)).collect(Collectors.toList());
/*     */         
/* 228 */         List<DynamicReportVariable> vHis = this.dynamicReportVariableRepository.getAllByRpId(dynamicReport.getRpId());
/* 229 */         if (!vHis.isEmpty()) {
/*     */ 
/*     */           
/* 232 */           List<DynamicReportVariableHis> vaHIs = (List<DynamicReportVariableHis>)vHis.stream().map(e -> (DynamicReportVariableHis)this.modelMapper.map(e, DynamicReportVariableHis.class)).collect(Collectors.toList());
/* 233 */           this.dynamicReportVariableHisRepository.saveAll(vaHIs);
/*     */         } 
/*     */         
/* 236 */         this.dynamicReportVariableRepository.deleteAllByRpId(dynamicReport.getRpId());
/* 237 */         this.dynamicReportVariableRepository.saveAll(dynamicReportVariables);
/*     */       } 
/*     */ 
/*     */       
/* 241 */       data.put("id", dynamicReport.getRpId());
/* 242 */       data.put("rpCode", dynamicReport.getRpCode());
/* 243 */       rs.put("status", "OK");
/* 244 */       rs.put("responseCode", "00");
/* 245 */       rs.put("dataRes", data);
/* 246 */       return rs;
/* 247 */     } catch (Exception e) {
/* 248 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 249 */       logger.error(exceptionAsString);
/* 250 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 251 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/report/dynamicReport/{rpCode}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse deleteDynamicReport(@PathVariable @Valid String rpCode) {
/* 261 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 263 */       DynamicReport dynamicReport = this.dynamicReportRepository.findByRpCode(rpCode).orElse(null);
/* 264 */       if (Objects.isNull(dynamicReport)) {
/* 265 */         return this.apiError.getError("202", new String[] { String.valueOf(rpCode) });
/*     */       }
/*     */ 
/*     */       
/* 269 */       DynamicReportHis dhis = (DynamicReportHis)this.modelMapper.map(dynamicReport, DynamicReportHis.class);
/* 270 */       dhis.setCreatedDate(new Date());
/* 271 */       this.dynamicReportHisRepository.save(dhis);
/* 272 */       List<DynamicReportVariable> va = this.dynamicReportVariableRepository.getAllByRpId(dynamicReport.getRpId());
/* 273 */       if (va.size() > 0) {
/*     */ 
/*     */         
/* 276 */         List<DynamicReportVariableHis> dynamicReportVariables = (List<DynamicReportVariableHis>)va.stream().map(e -> (DynamicReportVariableHis)this.modelMapper.map(e, DynamicReportVariableHis.class)).collect(Collectors.toList());
/* 277 */         this.dynamicReportVariableHisRepository.saveAll(dynamicReportVariables);
/*     */       } 
/*     */ 
/*     */       
/* 281 */       this.dynamicReportRepository.deleteByRpCode(rpCode);
/* 282 */       this.dynamicReportVariableRepository.deleteAllByRpId(dynamicReport.getRpId());
/* 283 */       deleteReportTemplateFile(dynamicReport.getRpFileStoreName());
/*     */       
/* 285 */       rs.put("status", "OK");
/* 286 */       rs.put("responseCode", "00");
/* 287 */       return rs;
/* 288 */     } catch (Exception e) {
/* 289 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 290 */       logger.error(exceptionAsString);
/* 291 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 292 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/exportDynamicReport/{rpCode}"})
/*     */   public ApiResponse exportDynamicReport(@PathVariable @Valid String rpCode, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 303 */       return process(rpCode, exportModel, true);
/* 304 */     } catch (Exception e) {
/* 305 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 306 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/exportDynamicReportPrev/{file_code}"})
/*     */   public ApiResponse exportPrev(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 314 */       return process(file_code, exportModel, false);
/* 315 */     } catch (Exception e) {
/* 316 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 317 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ApiResponse process(String file_code, ExportModel exportModel, boolean download) {
/* 323 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 325 */       DynamicReport dynamicReport = this.dynamicReportRepository.findByRpCode(file_code).orElse(null);
/* 326 */       if (Objects.isNull(dynamicReport)) {
/* 327 */         return this.apiError.getError("202", new String[] { file_code });
/*     */       }
/*     */       
/* 330 */       List<DynamicReportVariable> dynamicReportVariables = this.dynamicReportVariableRepository.getAllByRpId(dynamicReport.getRpId());
/*     */       
/* 332 */       String inputFilePath = this.reportUrl + FileSystems.getDefault().getSeparator() + dynamicReport.getRpFileStoreName();
/* 333 */       String inputFileOut = this.responseUploadfileUrl + FileSystems.getDefault().getSeparator() + dynamicReport.getRpFileStoreName();
/*     */       
/* 335 */       ReportUtil reportUtil = new ReportUtil();
/* 336 */       FileOutputStream os = new FileOutputStream(inputFileOut);
/*     */ 
/*     */       
/* 339 */       Map<String, Object> data = this.reportService.getReportDynamicData(dynamicReport.getRpSql(), exportModel.getVariables(), dynamicReportVariables);
/* 340 */       if (data.size() == 0) {
/* 341 */         return this.apiError.getError("202", new String[] { "Dữ liệu" + file_code });
/*     */       }
/*     */       
/* 344 */       reportUtil.createDocument(os, inputFilePath, data);
/*     */       
/* 346 */       if (download) {
/* 347 */         Path rootPath = Paths.get(inputFileOut, new String[0]);
/* 348 */         if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/* 349 */           return this.apiError.getError("701", new String[] { file_code }); 
/* 350 */         byte[] bytes = Files.readAllBytes(rootPath);
/* 351 */         rs.put("data", bytes);
/* 352 */         rs.put("fileName", dynamicReport.getRpName());
/*     */       } else {
/*     */         
/* 355 */         String fileName = UUID.randomUUID() + ".pdf";
/* 356 */         String outputFilePath = this.responseUploadfileUrl + "/" + fileName;
/* 357 */         convertExcelToPdf(inputFileOut, outputFilePath);
/*     */         
/* 359 */         Path rootPath = Paths.get(outputFilePath, new String[0]);
/* 360 */         if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/* 361 */           return this.apiError.getError("701", new String[] { file_code }); 
/* 362 */         byte[] bytes = Files.readAllBytes(rootPath);
/*     */ 
/*     */         
/* 365 */         File deleteFile = new File(outputFilePath);
/* 366 */         if (deleteFile.exists()) {
/* 367 */           deleteFile.delete();
/*     */         }
/* 369 */         rs.put("data", bytes);
/* 370 */         rs.put("fileName", fileName);
/*     */       } 
/* 372 */       rs.put("status", ApiStatus.OK.name());
/* 373 */       rs.put("responseCode", "00");
/* 374 */     } catch (Exception e) {
/* 375 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 376 */       logger.error(exceptionAsString);
/* 377 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 379 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   private void saveReportTemplateFile(String rpFileStoreName, String rpFileStream) throws Exception {
/* 384 */     byte[] decodedBytes = Base64.getDecoder().decode(rpFileStream);
/* 385 */     ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
/* 386 */     bis.close();
/* 387 */     File file = new File(this.reportUrl + FileSystems.getDefault().getSeparator() + rpFileStoreName);
/*     */ 
/*     */ 
/*     */     
/* 391 */     FileOutputStream fop = new FileOutputStream(file);
/* 392 */     fop.write(decodedBytes);
/* 393 */     fop.flush();
/* 394 */     fop.close();
/*     */   }
/*     */ 
/*     */   
/*     */   private void deleteReportTemplateFile(String rpFileStoreName) {
/* 399 */     File file = new File(this.reportUrl + FileSystems.getDefault().getSeparator() + rpFileStoreName);
/* 400 */     file.deleteOnExit();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Controller\DynamicReportController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */