/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum RisStatus {
/*  4 */   DONE("DONE"),
/*  5 */   PROCESSING("PROCESSING"),
/*  6 */   PENDING("PENDING"),
/*  7 */   CANCEL("CANCEL");
/*    */   
/*    */   public String getRisStatus() {
/* 10 */     return this.RisStatus;
/*    */   }
/*    */   private String RisStatus;
/*    */   public void setRisStatus(String OrderStatus) {
/* 14 */     this.RisStatus = OrderStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   RisStatus(String action) {
/* 20 */     this.RisStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\RisStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */