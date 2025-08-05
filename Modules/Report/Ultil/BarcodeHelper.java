/*     */ package nencer.app.Modules.Report.Ultil;
/*     */ import com.google.zxing.BarcodeFormat;
/*     */ import com.google.zxing.EncodeHintType;
/*     */ import com.google.zxing.WriterException;
/*     */ import com.google.zxing.client.j2se.MatrixToImageWriter;
/*     */ import com.google.zxing.common.BitMatrix;
/*     */ import com.google.zxing.oned.Code128Writer;
/*     */ import com.google.zxing.qrcode.QRCodeWriter;
/*     */ import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Base64;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.krysalis.barcode4j.impl.code39.Code39Bean;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class BarcodeHelper {
/*     */   public static byte[] generateBarQRCode(String text, int width, int height, boolean isQR) throws IOException {
/*     */     try {
/*  30 */       Code128Writer qrCodeWriter = new Code128Writer();
/*  31 */       BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.CODE_128, width, height);
/*  32 */       if (isQR) {
/*  33 */         QRCodeWriter qrCodeWriter1 = new QRCodeWriter();
/*  34 */         bitMatrix = qrCodeWriter1.encode(text, BarcodeFormat.QR_CODE, width, height);
/*     */       } 
/*  36 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  37 */       MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
/*  38 */       return byteArrayOutputStream.toByteArray();
/*  39 */     } catch (WriterException e) {
/*  40 */       throw new IOException("Failed to generate QR code", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getBarCodeToBase64(String text) throws IOException {
/*  46 */     Code39Bean bean = new Code39Bean();
/*     */     
/*  48 */     byte[] bc = generateBarQRCode(text, 200, 60, false);
/*  49 */     return Base64.getEncoder().encodeToString(bc);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws IOException, WriterException {
/*  53 */     String textToEncode = "112233";
/*  54 */     int barcodeWidth = 200;
/*  55 */     int barcodeHeight = 100;
/*     */ 
/*     */     
/*  58 */     BufferedImage barcodeImage = generateBarcode(textToEncode, barcodeWidth, barcodeHeight);
/*     */ 
/*     */     
/*  61 */     int combinedWidth = barcodeWidth;
/*  62 */     int combinedHeight = barcodeHeight + 50;
/*  63 */     BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, 1);
/*  64 */     Graphics2D graphics = combinedImage.createGraphics();
/*     */ 
/*     */     
/*  67 */     graphics.drawImage(barcodeImage, 0, 0, (ImageObserver)null);
/*     */ 
/*     */     
/*  70 */     graphics.setColor(Color.BLACK);
/*  71 */     graphics.setFont(new Font("Arial", 0, 14));
/*  72 */     String labelText = "112233";
/*  73 */     int textX = 20;
/*  74 */     int textY = barcodeHeight + 30;
/*  75 */     graphics.drawString(labelText, textX, textY);
/*     */     
/*  77 */     graphics.dispose();
/*     */ 
/*     */     
/*  80 */     File outputFile = new File("C:\\Users\\dap.dv\\Downloads\\" + UUID.randomUUID() + ".png");
/*     */     try {
/*  82 */       ImageIO.write(combinedImage, "png", outputFile);
/*  83 */       System.out.println("Combined barcode saved to " + outputFile.getAbsolutePath());
/*  84 */     } catch (IOException e) {
/*  85 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static BufferedImage generateBarcode(String text, int width, int height) throws WriterException, IOException {
/*  91 */     Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
/*  92 */     hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
/*  93 */     hints.put(EncodeHintType.MARGIN, Integer.valueOf(2));
/*     */     
/*  95 */     Code128Writer qrCodeWriter = new Code128Writer();
/*  96 */     BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.CODE_128, width, height, hints);
/*     */     
/*  98 */     BufferedImage image = new BufferedImage(width, height, 1);
/*  99 */     Graphics2D graphics = image.createGraphics();
/*     */     
/* 101 */     for (int x = 0; x < width; x++) {
/* 102 */       for (int y = 0; y < height; y++) {
/* 103 */         image.setRGB(x, y, bitMatrix.get(x, y) ? 0 : 16777215);
/*     */       }
/*     */     } 
/*     */     
/* 107 */     graphics.dispose();
/* 108 */     return image;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Ultil\BarcodeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */