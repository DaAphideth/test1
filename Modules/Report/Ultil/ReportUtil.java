/*    */ package nencer.app.Modules.Report.Ultil;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Map;
/*    */ import org.jxls.common.Context;
/*    */ import org.jxls.util.JxlsHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportUtil
/*    */ {
/*    */   public void createDocument(OutputStream outStream, String pathTemplateName, Map<String, Object> data) {
/* 21 */     try (InputStream input = new FileInputStream(pathTemplateName) {
/*    */         
/*    */         }) {
/* 24 */       Context context = new Context();
/*    */       
/* 26 */       for (Map.Entry<String, Object> element : data.entrySet()) {
/* 27 */         context.putVar(element.getKey(), element.getValue());
/*    */       }
/*    */       
/* 30 */       JxlsHelper.getInstance().processTemplate(input, outStream, context);
/*    */     }
/* 32 */     catch (Exception exception) {
/* 33 */       exception.printStackTrace();
/*    */     } finally {
/*    */       
/* 36 */       closeAndFlushOutput(outStream);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void closeAndFlushOutput(OutputStream outStream) {
/*    */     try {
/* 42 */       outStream.flush();
/* 43 */       outStream.close();
/* 44 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Ultil\ReportUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */