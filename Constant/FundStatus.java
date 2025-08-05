/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum FundStatus {
/*  4 */   PAID("PAID"),
/*  5 */   CANCEL("CANCEL");
/*    */   
/*    */   public String getFundStatus() {
/*  8 */     return this.FundStatus;
/*    */   }
/*    */   private String FundStatus;
/*    */   public void setFundStatus(String OrderStatus) {
/* 12 */     this.FundStatus = OrderStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   FundStatus(String action) {
/* 18 */     this.FundStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\FundStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */