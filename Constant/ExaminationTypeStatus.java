/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum ExaminationTypeStatus {
/*  4 */   KT("KT"),
/*  5 */   CC("CC");
/*    */   
/*    */   public String getExaminationType() {
/*  8 */     return this.ExaminationType;
/*    */   }
/*    */   private String ExaminationType;
/*    */   public void setExaminationType(String examinationType) {
/* 12 */     this.ExaminationType = examinationType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   ExaminationTypeStatus(String examinationType) {
/* 18 */     this.ExaminationType = examinationType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\ExaminationTypeStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */