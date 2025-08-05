/*    */ package nencer.app.ErrorHandler;
/*    */ 
/*    */ import java.text.MessageFormat;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.validation.FieldError;
/*    */ import org.springframework.validation.ObjectError;
/*    */ import org.springframework.web.bind.MethodArgumentNotValidException;
/*    */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ControllerAdvice
/*    */ public class CustomExceptionHandler
/*    */ {
/*    */   @Autowired
/*    */   Environment env;
/*    */   
/*    */   @ExceptionHandler({Exception.class})
/*    */   public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
/* 25 */     ErrorResponse error = new ErrorResponse("ERROR", "997", ex.getLocalizedMessage());
/* 26 */     return new ResponseEntity(error, HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @ExceptionHandler({RecordNotFoundException.class})
/*    */   public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex) {
/* 31 */     ErrorResponse error = new ErrorResponse("ERROR", "996", ex.getLocalizedMessage());
/* 32 */     return new ResponseEntity(error, HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @ExceptionHandler({MethodArgumentNotValidException.class})
/*    */   @ResponseBody
/*    */   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
/* 38 */     String detail = "";
/* 39 */     String code = "995";
/* 40 */     for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
/* 41 */       String fieldName = ((FieldError)objectError).getField();
/* 42 */       code = objectError.getDefaultMessage();
/* 43 */       detail = this.env.getProperty("nencerapi.error.err" + code);
/* 44 */       if (detail != null) {
/* 45 */         MessageFormat formater = new MessageFormat(detail);
/* 46 */         detail = formater.format(new String[] { fieldName }); continue;
/*    */       } 
/* 48 */       detail = code;
/*    */     } 
/*    */     
/* 51 */     ErrorResponse error = new ErrorResponse("ERROR", code, detail);
/* 52 */     return new ResponseEntity(error, HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\ErrorHandler\CustomExceptionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */