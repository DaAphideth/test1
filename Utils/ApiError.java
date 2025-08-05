/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.text.MessageFormat;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class ApiError
/*    */ {
/*    */   @Autowired
/*    */   private Environment env;
/*    */   
/*    */   public ApiResponse buildMessageError(String err, String msg) {
/* 15 */     ApiResponse rs = new ApiResponse();
/* 16 */     rs.put("status", "FAILE");
/* 17 */     return rs;
/*    */   }
/*    */   
/*    */   public ApiResponse getError(String code) {
/* 21 */     String desc = this.env.getProperty("nencerapi.error.err" + code);
/* 22 */     ApiResponse rs = new ApiResponse();
/* 23 */     rs.put("status", "FAILE");
/* 24 */     rs.put("responseCode", code);
/* 25 */     rs.put("message", desc);
/* 26 */     return rs;
/*    */   }
/*    */   
/*    */   public ApiResponse getError(String code, String[] params) {
/* 30 */     String desc = this.env.getProperty("nencerapi.error.err" + code);
/* 31 */     if (params != null) {
/* 32 */       MessageFormat formater = new MessageFormat(desc);
/* 33 */       desc = formater.format(params);
/*    */     } 
/* 35 */     ApiResponse rs = new ApiResponse();
/* 36 */     rs.put("status", "FAILE");
/* 37 */     rs.put("responseCode", code);
/* 38 */     rs.put("message", desc);
/* 39 */     return rs;
/*    */   }
/*    */   
/*    */   public String getErrorSt(String code, String[] params) {
/* 43 */     String desc = this.env.getProperty("nencerapi.error.err" + code);
/* 44 */     if (params != null) {
/* 45 */       MessageFormat formater = new MessageFormat(desc);
/* 46 */       desc = formater.format(params);
/*    */     } 
/* 48 */     return desc;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ApiError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */