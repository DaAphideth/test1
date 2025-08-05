/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum CheckinSttStatus {
/*  4 */   WAITING("WAITING"),
/*  5 */   CALLED("CALLED");
/*    */   
/*    */   public String getCheckinSttStatus() {
/*  8 */     return this.checkinSttStatus;
/*    */   }
/*    */   private String checkinSttStatus;
/*    */   public void setCheckinSttStatus(String checkinSttStatus) {
/* 12 */     this.checkinSttStatus = checkinSttStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   CheckinSttStatus(String action) {
/* 18 */     this.checkinSttStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\CheckinSttStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */