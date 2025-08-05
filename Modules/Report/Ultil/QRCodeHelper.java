/*    */ package nencer.app.Modules.Report.Ultil;
/*    */ 
/*    */ import com.google.zxing.BarcodeFormat;
/*    */ import com.google.zxing.WriterException;
/*    */ import com.google.zxing.client.j2se.MatrixToImageWriter;
/*    */ import com.google.zxing.common.BitMatrix;
/*    */ import com.google.zxing.qrcode.QRCodeWriter;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Base64;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.krysalis.barcode4j.impl.code39.Code39Bean;
/*    */ import org.krysalis.barcode4j.output.CanvasProvider;
/*    */ import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
/*    */ import org.krysalis.barcode4j.tools.UnitConv;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class QRCodeHelper
/*    */ {
/* 26 */   private final Logger logger = LoggerFactory.getLogger(QRCodeHelper.class);
/*    */   
/*    */   public String generateQRCodeBase64(String qrCodeContent, int width, int height) {
/*    */     try {
/* 30 */       QRCodeWriter qrCodeWriter = new QRCodeWriter();
/* 31 */       BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, width, height);
/* 32 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 33 */       MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
/* 34 */       return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
/* 35 */     } catch (WriterException|IOException e) {
/* 36 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 37 */       this.logger.error(exceptionAsString);
/*    */       
/* 39 */       return null;
/*    */     } 
/*    */   }
/*    */   public byte[] getQRCodeImage(String text, int width, int height) {
/*    */     try {
/* 44 */       QRCodeWriter qrCodeWriter = new QRCodeWriter();
/* 45 */       BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
/* 46 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 47 */       MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
/* 48 */       return byteArrayOutputStream.toByteArray();
/* 49 */     } catch (Exception e) {
/* 50 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 51 */       this.logger.error(exceptionAsString);
/*    */       
/* 53 */       return null;
/*    */     } 
/*    */   }
/*    */   public void getQrCode(String text, String filePath, int width, int height) throws IOException {
/* 57 */     byte[] qrCImage = getQRCodeImage(text, width, height);
/* 58 */     try (FileOutputStream fos = new FileOutputStream(filePath)) {
/* 59 */       fos.write(qrCImage);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void getBarCode(String text, String filePath) throws IOException {
/* 65 */     Code39Bean bean = new Code39Bean();
/* 66 */     int dpi = 150;
/*    */     
/* 68 */     bean.setModuleWidth(UnitConv.in2mm(0.02500000037252903D));
/* 69 */     bean.setWideFactor(3.0D);
/* 70 */     bean.doQuietZone(false);
/* 71 */     bean.setFontSize(8.0D);
/*    */ 
/*    */     
/* 74 */     File outputFile = new File(filePath);
/* 75 */     OutputStream out = new FileOutputStream(outputFile);
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 80 */       BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", 150, 12, false, 0);
/*    */ 
/*    */ 
/*    */       
/* 84 */       bean.generateBarcode((CanvasProvider)canvas, text);
/*    */ 
/*    */       
/* 87 */       canvas.finish();
/*    */     } finally {
/* 89 */       out.close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Ultil\QRCodeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */