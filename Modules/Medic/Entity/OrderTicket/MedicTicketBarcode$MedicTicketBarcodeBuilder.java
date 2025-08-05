/*    */ package nencer.app.Modules.Medic.Entity.OrderTicket;
/*    */ 
/*    */ 
/*    */ public class MedicTicketBarcodeBuilder {
/*    */   private int id;
/*    */   private Integer number;
/*    */   private Integer mdId;
/*    */   private String dateTime;
/*    */   private Date createdAt;
/*    */   
/* 11 */   public MedicTicketBarcodeBuilder id(int id) { this.id = id; return this; } public MedicTicketBarcodeBuilder number(Integer number) { this.number = number; return this; } public MedicTicketBarcodeBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicTicketBarcodeBuilder dateTime(String dateTime) { this.dateTime = dateTime; return this; } public MedicTicketBarcodeBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicTicketBarcode build() { return new MedicTicketBarcode(this.id, this.number, this.mdId, this.dateTime, this.createdAt); } public String toString() { return "MedicTicketBarcode.MedicTicketBarcodeBuilder(id=" + this.id + ", number=" + this.number + ", mdId=" + this.mdId + ", dateTime=" + this.dateTime + ", createdAt=" + this.createdAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderTicket\MedicTicketBarcode$MedicTicketBarcodeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */