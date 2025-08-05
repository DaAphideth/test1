/*     */ package nencer.app.Modules.Report.Controller;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Service.ReportService;
/*     */ import nencer.app.Modules.Report.Ultil.ReportUtil;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.ApiStatus;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ReportTemplateController
/*     */   extends BaseMedicController
/*     */ {
/*     */   @Value("${report-file-url}")
/*     */   private String reportUrl;
/*     */   @Value("${response-uploadfile-url}")
/*     */   private String responseUploadfileUrl;
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   @Autowired
/*     */   private ReportService reportService;
/*     */   
/*     */   @PostMapping({"/report/exportExcelTemplate/{file_code}"})
/*     */   public ApiResponse exportToPdf(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/*  56 */       return process(file_code, exportModel, true);
/*  57 */     } catch (Exception e) {
/*  58 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  59 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/exportPrev/{file_code}"})
/*     */   public ApiResponse exportPrev(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/*  67 */       return process(file_code, exportModel, false);
/*  68 */     } catch (Exception e) {
/*  69 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  70 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ApiResponse process(String file_code, ExportModel exportModel, boolean download) {
/*  76 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  78 */       String lang = StringUtils.isEmpty(exportModel.getLanguage()) ? "VI" : exportModel.getLanguage().toUpperCase(Locale.ROOT);
/*  79 */       String filePath = this.reportUrl + "/" + file_code.toUpperCase(Locale.ROOT) + "_" + lang + ".xls";
/*  80 */       String inputFilePath = this.responseUploadfileUrl + "/" + file_code.toUpperCase(Locale.ROOT) + "_" + lang + ".xls";
/*     */       
/*  82 */       ReportUtil reportUtil = new ReportUtil();
/*  83 */       FileOutputStream os = new FileOutputStream(inputFilePath);
/*  84 */       Map<String, Object> data = new HashMap<>();
/*     */       
/*  86 */       switch (file_code) {
/*     */         case "BAO_CAO_KHAM_BENH":
/*  88 */           data = this.reportService.getMedicExaminationReportService(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_NHAP_XUAT_TON":
/*  91 */           data = this.reportService.getLogisticInvenReportService(exportModel.getStartDate(), exportModel.getEndDate(), exportModel.getStorehouseId());
/*     */           break;
/*     */         case "BAO_CAO_PHIEU_NHAP_NHA_CUNG_CAP":
/*  94 */           data = this.reportService.getSupplierReportService(exportModel.getStartDate(), exportModel.getEndDate(), exportModel.getStorehouseId());
/*     */           break;
/*     */         case "SO_KHAM_BENH":
/*  97 */           data = this.reportService.getExaminationReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "SO_XET_NGHIEM":
/* 100 */           data = this.reportService.spGetXNReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_TAI_CHINH":
/* 103 */           data = this.reportService.spGetPaymentReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "SO_CHUAN_DOAN_HINH_ANH":
/* 106 */           data = this.reportService.spGetCDHAReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_TIEP_DON":
/* 109 */           data = this.reportService.spGetCheckinReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "PHIEU_CHUC_NANG_SONG":
/* 112 */           data = this.reportService.getLiveFunction(exportModel.getMdId(), exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */       } 
/* 115 */       if (data.size() == 0) {
/* 116 */         return this.apiError.getError("202", new String[] { "Dữ liệu" + file_code });
/*     */       }
/* 118 */       reportUtil.createDocument(os, filePath, data);
/* 119 */       logger.info("Đường dẫn: " + inputFilePath);
/*     */       
/* 121 */       if (download) {
/* 122 */         Path rootPath = Paths.get(inputFilePath, new String[0]);
/* 123 */         if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/* 124 */           return this.apiError.getError("701", new String[] { file_code }); 
/* 125 */         byte[] bytes = Files.readAllBytes(rootPath);
/* 126 */         rs.put("data", bytes);
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 134 */         String outputFilePath = this.responseUploadfileUrl + "/" + UUID.randomUUID() + ".pdf";
/* 135 */         convertExcelToPdf(inputFilePath, outputFilePath);
/*     */         
/* 137 */         Path rootPath = Paths.get(outputFilePath, new String[0]);
/* 138 */         if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/* 139 */           return this.apiError.getError("701", new String[] { file_code }); 
/* 140 */         byte[] bytes = Files.readAllBytes(rootPath);
/*     */ 
/*     */         
/* 143 */         File deleteFile = new File(outputFilePath);
/* 144 */         if (deleteFile.exists()) {
/* 145 */           deleteFile.delete();
/*     */         }
/* 147 */         rs.put("data", bytes);
/*     */       } 
/*     */ 
/*     */       
/* 151 */       rs.put("status", ApiStatus.OK.name());
/* 152 */       rs.put("responseCode", "00");
/* 153 */     } catch (Exception e) {
/* 154 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 155 */       logger.error(exceptionAsString);
/* 156 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 158 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/report/getData/{file_code}"})
/*     */   public ApiResponse exportData(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 164 */       return getData(file_code, exportModel);
/* 165 */     } catch (Exception e) {
/* 166 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 167 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */   
/*     */   private ApiResponse getData(String file_code, ExportModel exportModel) {
/* 172 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 175 */       Map<String, Object> data = new HashMap<>();
/*     */       
/* 177 */       switch (file_code) {
/*     */         case "BAO_CAO_KHAM_BENH":
/* 179 */           data = this.reportService.getMedicExaminationReportService(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_NHAP_XUAT_TON":
/* 182 */           data = this.reportService.getLogisticInvenReportService(exportModel.getStartDate(), exportModel.getEndDate(), exportModel.getStorehouseId());
/*     */           break;
/*     */         case "BAO_CAO_PHIEU_NHAP_NHA_CUNG_CAP":
/* 185 */           data = this.reportService.getSupplierReportService(exportModel.getStartDate(), exportModel.getEndDate(), exportModel.getStorehouseId());
/*     */           break;
/*     */         case "SO_KHAM_BENH":
/* 188 */           data = this.reportService.getExaminationReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "SO_XET_NGHIEM":
/* 191 */           data = this.reportService.spGetXNReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_TAI_CHINH":
/* 194 */           data = this.reportService.spGetPaymentReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "SO_CHUAN_DOAN_HINH_ANH":
/* 197 */           data = this.reportService.spGetCDHAReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "BAO_CAO_TIEP_DON":
/* 200 */           data = this.reportService.spGetCheckinReport(exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */         case "PHIEU_CHUC_NANG_SONG":
/* 203 */           data = this.reportService.getLiveFunction(exportModel.getMdId(), exportModel.getStartDate(), exportModel.getEndDate());
/*     */           break;
/*     */       } 
/* 206 */       if (data.size() == 0) {
/* 207 */         return this.apiError.getError("202", new String[] { "Dữ liệu" + file_code });
/*     */       }
/*     */       
/* 210 */       rs.put("dataRes", data);
/* 211 */       rs.put("status", ApiStatus.OK.name());
/* 212 */       rs.put("responseCode", "00");
/* 213 */     } catch (Exception e) {
/* 214 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 215 */       logger.error(exceptionAsString);
/* 216 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 218 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Controller\ReportTemplateController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */