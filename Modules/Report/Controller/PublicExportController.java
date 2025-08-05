/*     */ package nencer.app.Modules.Report.Controller;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Ultil.InsertImageToWord;
/*     */ import nencer.app.Modules.Report.Ultil.QRCodeHelper;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.ApiStatus;
/*     */ import nencer.app.Utils.ErrorCode;
/*     */ import nencer.app.Utils.FileUtils;
/*     */ import nencer.app.Utils.MailMergeUtil;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class PublicExportController
/*     */ {
/*     */   @Autowired
/*     */   public InsertImageToWord insertImageToWord;
/*     */   @Autowired
/*     */   public QRCodeHelper qrCodeHelper;
/*     */   @Value("${uploadfile-url}")
/*     */   private String uploadfileUrl;
/*     */   @Value("${response-uploadfile-url}")
/*     */   private String responseUploadfileUrl;
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   private final FileUtils fileUtils;
/*     */   @Autowired
/*     */   Environment env;
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */   
/*     */   public PublicExportController(FileUtils fileUtils) {
/*  70 */     this.fileUtils = fileUtils;
/*     */   }
/*     */   
/*     */   @GetMapping({"/publicReport/getAllMergeFieldFromDocxFile/{file_code}"})
/*     */   public ApiResponse getAllMergeFieldFromDocxFile(@PathVariable @Valid String file_code) {
/*  75 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  77 */       Path rootPath = Paths.get(this.uploadfileUrl + "/" + file_code, new String[0]);
/*  78 */       if (!Files.exists(rootPath, new java.nio.file.LinkOption[0]))
/*  79 */         return this.apiError.getError("701", new String[] { file_code }); 
/*  80 */       byte[] bytes = Files.readAllBytes(rootPath);
/*  81 */       if (bytes == null) {
/*  82 */         return this.apiError.getError(ErrorCode.STORAGE_GET_FILE_FAILED.code, new String[] { ErrorCode.STORAGE_GET_FILE_FAILED.description });
/*     */       }
/*  84 */       WordprocessingMLPackage document = MailMergeUtil.convertFileToDocument(bytes);
/*  85 */       Map<String, Object> mapRes = MailMergeUtil.getAllFields(document);
/*     */       
/*  87 */       rs.put("status", "OK");
/*  88 */       rs.put("responseCode", "00");
/*  89 */       rs.put("data", mapRes);
/*     */     }
/*  91 */     catch (Exception e) {
/*  92 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  93 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  95 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/publicReport/pushFieldDataToDocxFile/{file_code}"})
/*     */   public ApiResponse pushFieldDataToDocxFile(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 102 */       return process(file_code, exportModel, false);
/* 103 */     } catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/publicReport/exportPdf/{file_code}"})
/*     */   public ApiResponse exportPdf(@PathVariable @Valid String file_code, @RequestBody ExportModel exportModel) {
/*     */     try {
/* 114 */       return process(file_code, exportModel, true);
/*     */     }
/* 116 */     catch (Exception e) {
/* 117 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 119 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */   
/*     */   private ApiResponse process(String file_code, ExportModel exportModel, boolean isPdf) {
/* 124 */     ApiResponse rs = new ApiResponse(); try {
/*     */       MergeFieldDTO mergeFieldDTONum, mergeFieldDTOCreate;
/* 126 */       String lang = StringUtils.isEmpty(exportModel.getLanguage()) ? "VI" : exportModel.getLanguage().toUpperCase(Locale.ROOT);
/* 127 */       String filePath = this.uploadfileUrl + File.separator + file_code + "_" + lang + ".docx";
/* 128 */       Path rootPath = Paths.get(filePath, new String[0]);
/* 129 */       if (!Files.exists(rootPath, new java.nio.file.LinkOption[0])) {
/* 130 */         return this.apiError.getError("701", new String[] { file_code });
/*     */       }
/* 132 */       List<MergeFieldDTO> fieldData = new ArrayList<>();
/* 133 */       MergeFieldDTO mergeFieldDTO = new MergeFieldDTO();
/* 134 */       Calendar calendar = Calendar.getInstance();
/* 135 */       boolean hasInsImage = false;
/* 136 */       boolean hasInsBarcode = false;
/* 137 */       boolean hasInsQrcode = false;
/*     */       
/* 139 */       switch (file_code) {
/*     */         case "LAY_SO_TIEP_DON":
/* 141 */           mergeFieldDTONum = new MergeFieldDTO();
/* 142 */           mergeFieldDTONum.setCode("num");
/* 143 */           mergeFieldDTONum.setValue(exportModel.getNumber() + "");
/* 144 */           mergeFieldDTONum.setMergeField("num");
/* 145 */           fieldData.add(mergeFieldDTONum);
/*     */           
/* 147 */           mergeFieldDTOCreate = new MergeFieldDTO();
/* 148 */           mergeFieldDTOCreate.setCode("createdDate");
/* 149 */           mergeFieldDTOCreate.setValue(ApiHelper.formatDate("HH:mm dd/MM/yyyy"));
/* 150 */           mergeFieldDTOCreate.setMergeField("createdDate");
/* 151 */           fieldData.add(mergeFieldDTOCreate);
/*     */           break;
/*     */       } 
/* 154 */       List<String> fileDelete = new ArrayList<>();
/* 155 */       if (hasInsImage);
/*     */ 
/*     */ 
/*     */       
/* 159 */       byte[] bytes = Files.readAllBytes(rootPath);
/*     */       
/* 161 */       if (!fileDelete.isEmpty())
/*     */       {
/* 163 */         for (String f : fileDelete) {
/* 164 */           File deleteFile = new File(f);
/* 165 */           if (deleteFile.exists()) {
/* 166 */             deleteFile.delete();
/*     */           }
/*     */         } 
/*     */       }
/* 170 */       Map<String, Object> fillMergeFieldRes = MailMergeUtil.fillMergeField(bytes, MailMergeUtil.prepareMergedField(fieldData));
/* 171 */       if (fillMergeFieldRes.get("exportStatus").equals("OK")) {
/* 172 */         byte[] filledBytesRes = (byte[])fillMergeFieldRes.get("bytes");
/* 173 */         if (isPdf) {
/* 174 */           byte[] pdfBytes = this.fileUtils.convertFile(filledBytesRes);
/* 175 */           rs.put("data", pdfBytes);
/*     */         } else {
/* 177 */           rs.put("data", filledBytesRes);
/*     */         } 
/* 179 */         rs.put("status", ApiStatus.OK.name());
/* 180 */         rs.put("responseCode", "00");
/*     */       } else {
/* 182 */         return this.apiError.getError(fillMergeFieldRes.get("errorCode").toString(), new String[] { fillMergeFieldRes.get("errorMessage").toString() });
/*     */       }
/*     */     
/* 185 */     } catch (Exception e) {
/* 186 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 188 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 190 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Controller\PublicExportController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */