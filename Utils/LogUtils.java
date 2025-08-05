/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class LogUtils {
/* 10 */   private final Logger logger = LoggerFactory.getLogger(LogUtils.class);
/*    */   
/*    */   public <T> String logRequest(T apiReq) {
/* 13 */     ObjectMapper mapper = new ObjectMapper();
/* 14 */     String logValue = "";
/*    */     try {
/* 16 */       logValue = mapper.writeValueAsString(apiReq);
/* 17 */     } catch (Exception var10) {
/* 18 */       this.logger.error(var10.toString());
/*    */     } 
/*    */     
/* 21 */     return logValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\LogUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */