/*     */ package nencer.app.Modules.Upload.Controller;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import nencer.app.Modules.Upload.Model.FileInfo;
/*     */ import nencer.app.Modules.Upload.Model.FileModel;
/*     */ import nencer.app.Utils.BusinessException;
/*     */ import nencer.app.Utils.FileUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class DocumentController
/*     */ {
/*  35 */   private final Logger logger = LoggerFactory.getLogger(DocumentController.class);
/*     */   
/*     */   @Autowired
/*     */   ObjectMapper objectMapper;
/*     */   
/*     */   @Autowired
/*     */   private FileUtils fileUtils;
/*     */   
/*     */   @Value("${uploadfile-url}")
/*     */   private String uploadfileUrl;
/*     */   
/*     */   @PostMapping({"/upload"})
/*     */   public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
/*  48 */     String message = "";
/*     */     try {
/*  50 */       if (file == null || file.isEmpty()) {
/*  51 */         throw new Exception("File Upload không được trống");
/*     */       }
/*  53 */       String clientFileName = file.getOriginalFilename();
/*  54 */       if ("".equals(clientFileName)) {
/*  55 */         throw new Exception("Tên File Upload không được trống");
/*     */       }
/*     */       
/*  58 */       String serverFileName = UUID.randomUUID().toString() + "." + (String)FileUtils.getExtensionByFileName(clientFileName).get();
/*  59 */       this.fileUtils.saveFile(file, serverFileName, this.uploadfileUrl);
/*     */       
/*  61 */       message = "Tiếp nhận Upload file thành công: " + serverFileName;
/*  62 */       return ResponseEntity.status(HttpStatus.OK).body(message);
/*  63 */     } catch (BusinessException ex) {
/*  64 */       message = "Lỗi tiếp nhận upload file: " + ExceptionUtils.getStackTrace((Throwable)ex);
/*  65 */       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
/*  66 */     } catch (Exception e) {
/*  67 */       message = "Lỗi tiếp nhận upload file: " + ExceptionUtils.getStackTrace(e);
/*  68 */       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
/*     */     } 
/*     */   }
/*     */   
/*     */   private FileModel getFileName(String fileName) {
/*  73 */     FileModel f = new FileModel();
/*  74 */     f.setFileName(fileName);
/*  75 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/upload_multi"})
/*     */   public ResponseEntity<List<FileInfo>> uploadMultiFile(@RequestParam("file") MultipartFile[] lstFile, @RequestParam("file_info") String fileInfo) {
/*     */     try {
/*  83 */       if (lstFile == null || lstFile.length == 0) {
/*  84 */         throw new Exception("Danh sách file Upload không được trống");
/*     */       }
/*  86 */       if (lstFile.length == 1 && lstFile[0].isEmpty()) {
/*  87 */         throw new Exception("Danh sách file Upload không được trống");
/*     */       }
/*  89 */       List<FileInfo> lstFileInfo = new ArrayList<>();
/*  90 */       List<FileInfo> fileUploaded = new ArrayList<>();
/*     */       try {
/*  92 */         lstFileInfo = (List<FileInfo>)this.objectMapper.readValue(fileInfo, new TypeReference<List<FileInfo>>() {  }
/*     */           );
/*  94 */       } catch (Exception e) {
/*  95 */         throw new Exception("File info không hợp lệ" + e.getMessage());
/*     */       } 
/*     */       
/*  98 */       String currentBatchCode = UUID.randomUUID().toString();
/*     */       
/* 100 */       fileUploaded.addAll(lstFileInfo);
/*     */       
/* 102 */       for (MultipartFile itemFile : lstFile) {
/* 103 */         if (itemFile != null && !itemFile.isEmpty()) {
/*     */ 
/*     */           
/* 106 */           String clientFileName = itemFile.getOriginalFilename();
/* 107 */           if (!"".equals(clientFileName))
/*     */           {
/*     */ 
/*     */             
/* 111 */             for (FileInfo itemFileInfo : lstFileInfo) {
/* 112 */               if (clientFileName.equals(itemFileInfo.getFile_name()))
/*     */                 try {
/* 114 */                   String serverFileName = UUID.randomUUID().toString() + "." + (String)FileUtils.getExtensionByFileName(clientFileName).get();
/* 115 */                   this.logger.info("BAT DAU SAVE FILE: " + itemFileInfo.getFile_description());
/* 116 */                   String err = this.fileUtils.saveFile1(itemFile, serverFileName, this.uploadfileUrl);
/* 117 */                   if (err == null || err.equals("")) {
/* 118 */                     this.logger.info("SAVE TC");
/* 119 */                     itemFileInfo.setErr_msg("");
/*     */                   } else {
/* 121 */                     itemFileInfo.setErr_msg(err);
/*     */                   } 
/*     */                   
/* 124 */                   lstFileInfo.remove(itemFileInfo);
/*     */                   break;
/* 126 */                 } catch (Exception e) {
/* 127 */                   itemFileInfo.setErr_msg(e.getMessage());
/*     */                 }  
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 133 */       return ResponseEntity.status(HttpStatus.OK).body(fileUploaded);
/* 134 */     } catch (Exception e) {
/* 135 */       List<FileInfo> lstFileInfo = new ArrayList<>();
/* 136 */       lstFileInfo.add(FileInfo.builder().err_msg("Lỗi upload file: " + ExceptionUtils.getStackTrace(e)).build());
/* 137 */       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(lstFileInfo);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/delete_file"})
/*     */   public ResponseEntity<List<String>> deleteFile(@RequestBody List<String> fileCode) {
/* 144 */     List<String> lstFileInfo = new ArrayList<>();
/* 145 */     String message = "";
/*     */     
/*     */     try {
/* 148 */       for (String str : fileCode) {
/* 149 */         Path rootPath = Paths.get(this.uploadfileUrl + "/" + str, new String[0]);
/* 150 */         Files.deleteIfExists(rootPath);
/* 151 */         message = "Xóa file Upload file thành công: " + str;
/* 152 */         lstFileInfo.add(message);
/*     */       } 
/* 154 */       return ResponseEntity.status(HttpStatus.OK).body(lstFileInfo);
/* 155 */     } catch (Exception e) {
/* 156 */       message = "Lỗi xóa upload file: " + ExceptionUtils.getStackTrace(e);
/* 157 */       lstFileInfo.add(message);
/* 158 */       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(lstFileInfo);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Upload\Controller\DocumentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */