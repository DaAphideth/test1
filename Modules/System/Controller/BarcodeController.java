/*    */ package nencer.app.Modules.System.Controller;
/*    */ import com.google.zxing.WriterException;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.util.Base64;
/*    */ import nencer.app.Modules.Report.Ultil.BarcodeHelper;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class BarcodeController {
/* 19 */   public static final Logger logger = LoggerFactory.getLogger(BarcodeController.class);
/*    */   
/*    */   @Autowired
/*    */   BarcodeHelper barcodeHelper;
/*    */   
/*    */   @GetMapping({"/generate-qr-code"})
/*    */   public String generateQRCode(@RequestParam String text, @RequestParam int width, @RequestParam int height) throws IOException {
/* 26 */     return Base64.getEncoder().encodeToString(BarcodeHelper.generateBarQRCode(text, width, height, false));
/*    */   }
/*    */   
/*    */   @GetMapping(value = {"/generate-qr-code2"}, produces = {"image/png"})
/*    */   public BufferedImage generateQRCode2(@RequestParam String text, @RequestParam int width, @RequestParam int height) throws IOException, WriterException {
/* 31 */     return BarcodeHelper.generateBarcode(text, width, height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Controller\BarcodeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */