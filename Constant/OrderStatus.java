/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum OrderStatus {
/*  4 */   UNPAID("UNPAID"),
/*  5 */   BHYT("PAID"),
/*  6 */   PAID("PAID"),
/*  7 */   CANCEL("CANCEL");
/*    */   
/*    */   public String getOrderStatus() {
/* 10 */     return this.OrderStatus;
/*    */   }
/*    */   private String OrderStatus;
/*    */   public void setOrderStatus(String str) {
/* 14 */     this.OrderStatus = str;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   OrderStatus(String action) {
/* 20 */     this.OrderStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\OrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */