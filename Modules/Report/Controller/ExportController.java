/*     */ package nencer.app.Modules.Report.Controller;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.PrintFormCDHAResponse;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.TicketInfoModel;
/*     */ import nencer.app.Modules.Report.Repository.CommonReportRepo;
/*     */ import nencer.app.Modules.Report.Service.ExportService;
/*     */ import nencer.app.Modules.Report.Ultil.BarcodeHelper;
/*     */ import nencer.app.Modules.Report.Ultil.InsertImageToWord;
/*     */ import nencer.app.Modules.Report.Ultil.QRCodeHelper;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.MailMergeUtil;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
/*     */ import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExportController
/*     */   extends BaseMedicController
/*     */ {
/*     */   @Autowired
/*     */   public InsertImageToWord insertImageToWord;
/*     */   @Autowired
/*     */   public QRCodeHelper qrCodeHelper;
/*     */   @Value("${uploadfile-url}")
/*     */   private String uploadfileUrl;
/*     */   @Autowired
/*     */   BarcodeHelper barcodeHelper;
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   @Autowired
/*     */   Environment env;
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */   @Autowired
/*     */   private CommonReportRepo commonReportRepo;
/*     */   @Autowired
/*     */   private ObjectMapper objectMapper;
/*     */   @Autowired
/*     */   ExportService exportService;
/*     */   
/*     */   @GetMapping({"/report/getAllMergeFieldFromDocxFile/{file_code}"})
/*     */   public ApiResponse getAllMergeFieldFromDocxFile(@PathVariable @Valid String file_code) {
/*  84 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  86 */       Path rootPath = Paths.get(this.uploadfileUrl + "/" + file_code, new String[0]);
/*  87 */       if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/*  88 */         return this.apiError.getError("701", new String[] { file_code }); 
/*  89 */       byte[] bytes = Files.readAllBytes(rootPath);
/*     */       
/*  91 */       WordprocessingMLPackage document = MailMergeUtil.convertFileToDocument(bytes);
/*  92 */       Map<String, Object> mapRes = MailMergeUtil.getAllFields(document);
/*     */       
/*  94 */       rs.put("status", "OK");
/*  95 */       rs.put("responseCode", "00");
/*  96 */       rs.put("data", mapRes);
/*     */     }
/*  98 */     catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 102 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/pushFieldDataToDocxFile/{file_code}"})
/*     */   public ApiResponse pushFieldDataToDocxFile(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 109 */       return this.exportService.process(file_code, exportModel, false);
/* 110 */     } catch (Exception e) {
/* 111 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 113 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/exportPdf/{file_code}"})
/*     */   public ApiResponse exportPdf(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 121 */       return this.exportService.process(file_code, exportModel, true);
/*     */     }
/* 123 */     catch (Exception e) {
/* 124 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 126 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/report/exportPdf1/phieu_cdha"})
/*     */   public ApiResponse exportPdf1(@RequestBody ExportModel exportModel) {
/* 133 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 136 */       TicketInfoModel ticketInfo = this.commonReportRepo.getTicketInfo(exportModel.getTicketId());
/* 137 */       if (ticketInfo.getServiceGroupCode().equalsIgnoreCase("3")) {
/* 138 */         List<PrintFormCDHAResponse> kqCdha = this.commonReportRepo.sp_get_kq_cdha_response(exportModel.getTicketId().intValue());
/* 139 */         if (!kqCdha.isEmpty()) {
/*     */           
/* 141 */           for (PrintFormCDHAResponse cdha : kqCdha) {
/* 142 */             List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(cdha.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/* 145 */             String diagnostic = reExam.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */             
/* 147 */             List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(cdha.getDiagnosticSub(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/* 150 */             String diagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */             
/* 152 */             String diagnostics = Strings.isNotBlank(diagnosticSub) ? (diagnostic + "; " + diagnosticSub) : diagnostic;
/*     */             
/* 154 */             cdha.setDiagnostic(diagnostics);
/* 155 */             cdha.setDiagnosticSub(null);
/* 156 */             cdha.setAge((cdha.getYearBorn() != null) ? ApiHelper.getAge(cdha.getYearBorn()) : null);
/* 157 */             cdha.setYearBorn(((cdha.getDayBorn() != null) ? (cdha.getDayBorn() + "/ ") : "") + ((cdha.getMonthBorn() != null) ? (cdha.getMonthBorn() + "/ ") : "") + cdha.getYearBorn());
/* 158 */             cdha.setDateFormat((cdha.getCreatedDate() != null) ? ApiHelper.dateToString(cdha.getCreatedDate(), "HH:mm dd/MM/yyyy") : null);
/* 159 */             cdha.setGender(cdha.getGender());
/*     */           } 
/*     */           
/* 162 */           rs.put("status", "OK");
/* 163 */           rs.put("responseCode", "00");
/* 164 */           rs.put("dataRes", kqCdha);
/*     */         } 
/*     */       } 
/* 167 */     } catch (Exception e) {
/* 168 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 170 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 172 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Controller\ExportController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */