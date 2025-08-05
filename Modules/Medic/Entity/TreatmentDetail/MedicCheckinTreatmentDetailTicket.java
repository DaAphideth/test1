/*    */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_checkin_treatment_detail_ticket")
/*    */ public class MedicCheckinTreatmentDetailTicket {
/*    */   private int treatmentId;
/*    */   private Integer ticketId;
/*    */   private String ticketType;
/*    */   private Integer serviceGroupId;
/*    */   
/* 11 */   public static MedicCheckinTreatmentDetailTicketBuilder builder() { return new MedicCheckinTreatmentDetailTicketBuilder(); } public static class MedicCheckinTreatmentDetailTicketBuilder { private int treatmentId; private Integer ticketId; public MedicCheckinTreatmentDetailTicketBuilder treatmentId(int treatmentId) { this.treatmentId = treatmentId; return this; } private String ticketType; private Integer serviceGroupId; public MedicCheckinTreatmentDetailTicketBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicCheckinTreatmentDetailTicketBuilder ticketType(String ticketType) { this.ticketType = ticketType; return this; } public MedicCheckinTreatmentDetailTicketBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public MedicCheckinTreatmentDetailTicket build() { return new MedicCheckinTreatmentDetailTicket(this.treatmentId, this.ticketId, this.ticketType, this.serviceGroupId); } public String toString() { return "MedicCheckinTreatmentDetailTicket.MedicCheckinTreatmentDetailTicketBuilder(treatmentId=" + this.treatmentId + ", ticketId=" + this.ticketId + ", ticketType=" + this.ticketType + ", serviceGroupId=" + this.serviceGroupId + ")"; } } public MedicCheckinTreatmentDetailTicket(int treatmentId, Integer ticketId, String ticketType, Integer serviceGroupId) {
/* 12 */     this.treatmentId = treatmentId; this.ticketId = ticketId; this.ticketType = ticketType; this.serviceGroupId = serviceGroupId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MedicCheckinTreatmentDetailTicket() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTreatmentId(int treatmentId) {
/* 22 */     this.treatmentId = treatmentId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "treatment_id")
/*    */   public int getTreatmentId() {
/* 28 */     return this.treatmentId;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "ticket_id")
/*    */   public Integer getTicketId() {
/* 34 */     return this.ticketId;
/*    */   }
/*    */   
/*    */   public void setTicketId(Integer ticketId) {
/* 38 */     this.ticketId = ticketId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "ticket_type")
/*    */   public String getTicketType() {
/* 44 */     return this.ticketType;
/*    */   }
/*    */   
/*    */   public void setTicketType(String ticketType) {
/* 48 */     this.ticketType = ticketType;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "service_group_id")
/*    */   public Integer getServiceGroupId() {
/* 53 */     return this.serviceGroupId;
/*    */   }
/*    */   
/*    */   public void setServiceGroupId(Integer serviceGroupId) {
/* 57 */     this.serviceGroupId = serviceGroupId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinTreatmentDetailTicket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */