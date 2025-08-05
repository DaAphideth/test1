/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum InvoiceStatus {
/*  4 */   UNPAID("UNPAID"),
/*  5 */   PAID("PAID");
/*    */   
/*    */   public String getInvoiceStatus() {
/*  8 */     return this.invoiceStatus;
/*    */   }
/*    */   private String invoiceStatus;
/*    */   public void setInvoiceStatus(String invoiceStatus) {
/* 12 */     this.invoiceStatus = invoiceStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   InvoiceStatus(String action) {
/* 18 */     this.invoiceStatus = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\InvoiceStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */