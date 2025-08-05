/*   */ package nencer.app.Modules.Medic.Model.Response.MedicTreatment;
/*   */ public class TreatmentDetailModelBuilder {
/*   */   private Integer treatmentId;
/*   */   private Integer serviceGroupId;
/*   */   private String serviceGroupName;
/*   */   private Integer ticketId;
/*   */   private String title;
/*   */   
/* 9 */   public TreatmentDetailModelBuilder treatmentId(Integer treatmentId) { this.treatmentId = treatmentId; return this; } public TreatmentDetailModelBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public TreatmentDetailModelBuilder serviceGroupName(String serviceGroupName) { this.serviceGroupName = serviceGroupName; return this; } public TreatmentDetailModelBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public TreatmentDetailModelBuilder title(String title) { this.title = title; return this; } public TreatmentDetailModel build() { return new TreatmentDetailModel(this.treatmentId, this.serviceGroupId, this.serviceGroupName, this.ticketId, this.title); } public String toString() { return "TreatmentDetailModel.TreatmentDetailModelBuilder(treatmentId=" + this.treatmentId + ", serviceGroupId=" + this.serviceGroupId + ", serviceGroupName=" + this.serviceGroupName + ", ticketId=" + this.ticketId + ", title=" + this.title + ")"; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Response\MedicTreatment\TreatmentDetailModel$TreatmentDetailModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */