/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum CheckinStatus {
/*  4 */   WAITING("WAITING"),
/*    */   
/*  6 */   PROCESSING("PROCESSING"),
/*  7 */   DONE("DONE"),
/*    */   
/*  9 */   DELETE("DELETE");
/*    */   
/*    */   public String getCheckinStatus() {
/* 12 */     return this.checkinStatus;
/*    */   }
/*    */   private String checkinStatus;
/*    */   public void setCheckinStatus(String checkinStatus) {
/* 16 */     this.checkinStatus = checkinStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   CheckinStatus(String action) {
/* 22 */     this.checkinStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\CheckinStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */