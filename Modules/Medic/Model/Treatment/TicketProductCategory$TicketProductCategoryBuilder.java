/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TicketProductCategoryBuilder
/*    */ {
/*    */   private String ticketType;
/*    */   private String ticketTypeName;
/*    */   private Integer totalRecord;
/*    */   
/*    */   public TicketProductCategoryBuilder ticketType(String ticketType) {
/* 14 */     this.ticketType = ticketType; return this; } public TicketProductCategoryBuilder ticketTypeName(String ticketTypeName) { this.ticketTypeName = ticketTypeName; return this; } public TicketProductCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public TicketProductCategory build() { return new TicketProductCategory(this.ticketType, this.ticketTypeName, this.totalRecord); } public String toString() { return "TicketProductCategory.TicketProductCategoryBuilder(ticketType=" + this.ticketType + ", ticketTypeName=" + this.ticketTypeName + ", totalRecord=" + this.totalRecord + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\TicketProductCategory$TicketProductCategoryBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */