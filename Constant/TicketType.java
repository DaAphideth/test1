/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum TicketType {
/*  4 */   SERVICE("SERVICE"),
/*  5 */   MEDIC("MEDIC"),
/*  6 */   MEDIC_("MEDIC_"),
/*  7 */   MEDIC_GET_TOTAL("MEDIC_GET_TOTAL"),
/*  8 */   MEDIC_RETURN_TOTAL("MEDIC_RETURN_TOTAL");
/*    */   
/*    */   public String getTicketType() {
/* 11 */     return this.ticketType;
/*    */   }
/*    */   private String ticketType;
/*    */   public void setTicketType(String ticketType) {
/* 15 */     this.ticketType = ticketType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   TicketType(String type) {
/* 21 */     this.ticketType = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\TicketType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */