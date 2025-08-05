/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum Seperator
/*    */ {
/* 61 */   space("space"),
/* 62 */   comma("comma"),
/* 63 */   dot("dot");
/*    */   private String code;
/*    */   
/*    */   Seperator(String code) {
/* 67 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 71 */     return this.code;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\ApiFwConstants$Seperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */