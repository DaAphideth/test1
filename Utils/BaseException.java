/*    */ package nencer.app.Utils;
/*    */ 
/*    */ 
/*    */ public class BaseException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 3386940316107363276L;
/*    */   private String errCode;
/*    */   private String errMsg;
/*    */   
/*    */   public String getErrCode() {
/* 12 */     return this.errCode;
/*    */   }
/*    */   
/*    */   public String getErrMsg() {
/* 16 */     return this.errMsg;
/*    */   }
/*    */   
/*    */   public void setErrCode(String errCode) {
/* 20 */     this.errCode = errCode;
/*    */   }
/*    */   
/*    */   public void setErrMsg(String errMsg) {
/* 24 */     this.errMsg = errMsg;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\BaseException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */