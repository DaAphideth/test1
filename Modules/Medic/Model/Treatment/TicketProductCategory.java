/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class TicketProductCategory {
/*    */   private String ticketType;
/*    */   private String ticketTypeName;
/*    */   private Integer totalRecord;
/*    */   
/* 11 */   public void setTicketType(String ticketType) { this.ticketType = ticketType; } public void setTicketTypeName(String ticketTypeName) { this.ticketTypeName = ticketTypeName; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public TicketProductCategory(String ticketType, String ticketTypeName, Integer totalRecord) {
/* 12 */     this.ticketType = ticketType; this.ticketTypeName = ticketTypeName; this.totalRecord = totalRecord;
/*    */   } public TicketProductCategory() {}
/* 14 */   public static TicketProductCategoryBuilder builder() { return new TicketProductCategoryBuilder(); } public static class TicketProductCategoryBuilder { private String ticketType; public TicketProductCategoryBuilder ticketType(String ticketType) { this.ticketType = ticketType; return this; } private String ticketTypeName; private Integer totalRecord; public TicketProductCategoryBuilder ticketTypeName(String ticketTypeName) { this.ticketTypeName = ticketTypeName; return this; } public TicketProductCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public TicketProductCategory build() { return new TicketProductCategory(this.ticketType, this.ticketTypeName, this.totalRecord); } public String toString() { return "TicketProductCategory.TicketProductCategoryBuilder(ticketType=" + this.ticketType + ", ticketTypeName=" + this.ticketTypeName + ", totalRecord=" + this.totalRecord + ")"; }
/*    */      }
/* 16 */   public String getTicketType() { return this.ticketType; }
/* 17 */   public String getTicketTypeName() { return this.ticketTypeName; } public Integer getTotalRecord() {
/* 18 */     return this.totalRecord;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\TicketProductCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */