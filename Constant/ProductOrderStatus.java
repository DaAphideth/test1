/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum ProductOrderStatus {
/*  4 */   DNK("DNK"),
/*  5 */   DXK("DXK"),
/*  6 */   CD("CD"),
/*  7 */   DD("DD"),
/*  8 */   PN("PN"),
/*  9 */   PH("PH"),
/* 10 */   DDDNKDXK("DDDNKDXK"),
/* 11 */   DNKDXK("DNKDXK"),
/* 12 */   PDTH("PDTH");
/*    */   
/*    */   public String getProductOrderStatus() {
/* 15 */     return this.ProductOrderStatus;
/*    */   }
/*    */   private String ProductOrderStatus;
/*    */   public void setProductOrderStatus(String OrderStatus) {
/* 19 */     this.ProductOrderStatus = OrderStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   ProductOrderStatus(String action) {
/* 25 */     this.ProductOrderStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\ProductOrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */