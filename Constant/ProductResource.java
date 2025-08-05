/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum ProductResource {
/*  4 */   NCC("NCC"),
/*  5 */   NK("NK"),
/*  6 */   KK("KK");
/*    */   
/*    */   public String getProductResource() {
/*  9 */     return this.ProductResource;
/*    */   }
/*    */   private String ProductResource;
/*    */   public void setProductResource(String OrderStatus) {
/* 13 */     this.ProductResource = OrderStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   ProductResource(String action) {
/* 19 */     this.ProductResource = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\ProductResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */