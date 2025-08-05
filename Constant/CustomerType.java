/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum CustomerType {
/*  4 */   request("request"),
/*  5 */   bhyt("bhyt"),
/*  6 */   free("free"),
/*  7 */   fee("fee");
/*    */   
/*    */   public String getCustomerType() {
/* 10 */     return this.customerType;
/*    */   }
/*    */   private String customerType;
/*    */   public void setCustomerType(String customerType) {
/* 14 */     this.customerType = customerType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   CustomerType(String type) {
/* 20 */     this.customerType = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\CustomerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */