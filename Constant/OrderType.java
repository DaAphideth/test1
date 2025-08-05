/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum OrderType {
/*  4 */   TT("TT"),
/*  5 */   TU("TU"),
/*  6 */   HU("HU");
/*    */   
/*    */   public String getOrderType() {
/*  9 */     return this.orderType;
/*    */   }
/*    */   private String orderType;
/*    */   public void setOrderType(String orderType) {
/* 13 */     this.orderType = orderType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   OrderType(String type) {
/* 19 */     this.orderType = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\OrderType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */