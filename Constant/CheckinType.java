/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum CheckinType {
/*  4 */   OUT_PATIENT("OUT_PATIENT"),
/*  5 */   IN_PATIENT("IN_PATIENT");
/*    */   
/*    */   public String getCheckinType() {
/*  8 */     return this.checkinType;
/*    */   }
/*    */   private String checkinType;
/*    */   public void setCheckinType(String checkinType) {
/* 12 */     this.checkinType = checkinType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   CheckinType(String type) {
/* 18 */     this.checkinType = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\CheckinType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */