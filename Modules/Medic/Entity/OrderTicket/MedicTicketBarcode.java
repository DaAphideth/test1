/*    */ package nencer.app.Modules.Medic.Entity.OrderTicket;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_ticket_barcode")
/*    */ public class MedicTicketBarcode {
/*    */   private int id;
/*    */   private Integer number;
/*    */   
/* 11 */   public static MedicTicketBarcodeBuilder builder() { return new MedicTicketBarcodeBuilder(); } private Integer mdId; private String dateTime; private Date createdAt; public static class MedicTicketBarcodeBuilder { private int id; private Integer number; private Integer mdId; private String dateTime; private Date createdAt; public MedicTicketBarcodeBuilder id(int id) { this.id = id; return this; } public MedicTicketBarcodeBuilder number(Integer number) { this.number = number; return this; } public MedicTicketBarcodeBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicTicketBarcodeBuilder dateTime(String dateTime) { this.dateTime = dateTime; return this; } public MedicTicketBarcodeBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicTicketBarcode build() { return new MedicTicketBarcode(this.id, this.number, this.mdId, this.dateTime, this.createdAt); } public String toString() { return "MedicTicketBarcode.MedicTicketBarcodeBuilder(id=" + this.id + ", number=" + this.number + ", mdId=" + this.mdId + ", dateTime=" + this.dateTime + ", createdAt=" + this.createdAt + ")"; } } public MedicTicketBarcode(int id, Integer number, Integer mdId, String dateTime, Date createdAt) {
/* 12 */     this.id = id; this.number = number; this.mdId = mdId; this.dateTime = dateTime; this.createdAt = createdAt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MedicTicketBarcode() {}
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 26 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 30 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "number")
/*    */   public Integer getNumber() {
/* 36 */     return this.number;
/*    */   }
/*    */   
/*    */   public void setNumber(Integer number) {
/* 40 */     this.number = number;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "md_id")
/*    */   public Integer getMdId() {
/* 46 */     return this.mdId;
/*    */   }
/*    */   
/*    */   public void setMdId(Integer mdId) {
/* 50 */     this.mdId = mdId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "date_time")
/*    */   public String getDateTime() {
/* 56 */     return this.dateTime;
/*    */   }
/*    */   
/*    */   public void setDateTime(String dateTime) {
/* 60 */     this.dateTime = dateTime;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 66 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 70 */     this.createdAt = createdAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderTicket\MedicTicketBarcode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */