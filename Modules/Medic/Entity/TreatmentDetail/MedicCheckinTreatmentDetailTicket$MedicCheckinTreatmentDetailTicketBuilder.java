/*    */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*    */ 
/*    */ public class MedicCheckinTreatmentDetailTicketBuilder
/*    */ {
/*    */   private int treatmentId;
/*    */   private Integer ticketId;
/*    */   private String ticketType;
/*    */   private Integer serviceGroupId;
/*    */   
/*    */   public MedicCheckinTreatmentDetailTicketBuilder treatmentId(int treatmentId) {
/* 11 */     this.treatmentId = treatmentId; return this; } public MedicCheckinTreatmentDetailTicketBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicCheckinTreatmentDetailTicketBuilder ticketType(String ticketType) { this.ticketType = ticketType; return this; } public MedicCheckinTreatmentDetailTicketBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public MedicCheckinTreatmentDetailTicket build() { return new MedicCheckinTreatmentDetailTicket(this.treatmentId, this.ticketId, this.ticketType, this.serviceGroupId); } public String toString() { return "MedicCheckinTreatmentDetailTicket.MedicCheckinTreatmentDetailTicketBuilder(treatmentId=" + this.treatmentId + ", ticketId=" + this.ticketId + ", ticketType=" + this.ticketType + ", serviceGroupId=" + this.serviceGroupId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinTreatmentDetailTicket$MedicCheckinTreatmentDetailTicketBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */