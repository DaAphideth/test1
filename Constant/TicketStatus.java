/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum TicketStatus {
/*  4 */   UNPAID("UNPAID"),
/*  5 */   PENDING("PENDING"),
/*  6 */   PROCESSING("PROCESSING"),
/*  7 */   DONE("DONE");
/*    */   
/*    */   public String getTicketStatus() {
/* 10 */     return this.ticketStatus;
/*    */   }
/*    */   private String ticketStatus;
/*    */   public void setTicketStatus(String ticketStatus) {
/* 14 */     this.ticketStatus = ticketStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   TicketStatus(String type) {
/* 20 */     this.ticketStatus = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\TicketStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */