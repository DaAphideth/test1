/*     */ package nencer.app.Utils;
/*     */ import com.aspose.words.Document;
/*     */ import com.aspose.words.PdfSaveOptions;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.NoSuchFileException;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.Optional;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Component
/*     */ public class FileUtils {
/*  20 */   public static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
/*     */   
/*     */   @Value("${fontFolder}")
/*     */   public String fontsFolder;
/*     */   
/*     */   public byte[] convertFile(byte[] bytes) {
/*  26 */     ByteArrayInputStream is = new ByteArrayInputStream(bytes);
/*  27 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */     try {
/*  29 */       Document doc = new Document(is);
/*  30 */       FontSettings.getDefaultInstance().setFontsFolder(this.fontsFolder, true);
/*  31 */       PdfSaveOptions pdfOptions = new PdfSaveOptions();
/*  32 */       pdfOptions.setEmbedFullFonts(true);
/*  33 */       pdfOptions.setSaveFormat(40);
/*     */       
/*  35 */       doc.save(baos, (SaveOptions)pdfOptions);
/*  36 */     } catch (Exception e) {
/*  37 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  38 */       logger.error(exceptionAsString);
/*     */     } 
/*  40 */     return baos.toByteArray();
/*     */   }
/*     */   
/*     */   public void saveFile(MultipartFile file, String fileName, String url) {
/*     */     try {
/*  45 */       Path rootPath = Paths.get(url, new String[0]);
/*  46 */       Files.copy(file.getInputStream(), rootPath.resolve(fileName), new java.nio.file.CopyOption[0]);
/*  47 */     } catch (NoSuchFileException var9) {
/*  48 */       File directory = new File(String.valueOf(url));
/*  49 */       if (!directory.exists()) {
/*  50 */         directory.mkdir();
/*     */       }
/*  52 */       Path rootPath = Paths.get(url, new String[0]);
/*     */       try {
/*  54 */         Files.copy(file.getInputStream(), rootPath.resolve(fileName), new java.nio.file.CopyOption[0]);
/*  55 */       } catch (IOException var8) {
/*  56 */         throw new RuntimeException("Không thể lưu file trên AppServer. Error: " + var8.getMessage());
/*     */       } 
/*  58 */     } catch (Exception var10) {
/*  59 */       throw new RuntimeException("Không thể lưu file trên AppServer. Error: " + var10.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Optional<String> getExtensionByFileName(String fileName) {
/*  65 */     return Optional.<String>ofNullable(fileName)
/*  66 */       .filter(f -> f.contains("."))
/*  67 */       .map(f -> f.substring(fileName.lastIndexOf(".") + 1));
/*     */   }
/*     */   
/*     */   public String saveFile1(MultipartFile file, String fileName, String url) throws IOException {
/*  71 */     String err = "";
/*  72 */     InputStream inputStream = null;
/*     */     
/*     */     try {
/*  75 */       inputStream = file.getInputStream();
/*  76 */       Path rootPath = Paths.get(url, new String[0]);
/*  77 */       Files.copy(inputStream, rootPath.resolve(fileName), new java.nio.file.CopyOption[0]);
/*  78 */     } catch (NoSuchFileException var17) {
/*  79 */       File directory = new File(String.valueOf(url));
/*  80 */       if (!directory.exists()) {
/*  81 */         directory.mkdir();
/*     */       }
/*     */       
/*  84 */       Path rootPath = Paths.get(url, new String[0]);
/*     */       
/*     */       try {
/*  87 */         Files.copy(file.getInputStream(), rootPath.resolve(fileName), new java.nio.file.CopyOption[0]);
/*  88 */       } catch (IOException var16) {
/*  89 */         String exceptionAsString1 = ExceptionUtils.getStackTrace(var16);
/*  90 */         err = "1#" + exceptionAsString1;
/*     */       } 
/*  92 */     } catch (Exception var18) {
/*  93 */       String exceptionAsString = ExceptionUtils.getStackTrace(var18);
/*  94 */       err = "2#" + exceptionAsString;
/*     */     } finally {
/*  96 */       if (inputStream != null) {
/*  97 */         inputStream.close();
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return err;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\FileUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */