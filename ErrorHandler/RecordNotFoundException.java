/*    */ package nencer.app.ErrorHandler;
/*    */ 
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ 
/*    */ @ResponseStatus(HttpStatus.NOT_FOUND)
/*    */ public class RecordNotFoundException
/*    */   extends RuntimeException {
/*    */   public RecordNotFoundException(String exception) {
/* 10 */     super(exception);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\ErrorHandler\RecordNotFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */