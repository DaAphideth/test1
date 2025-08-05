/*    */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*    */ 
/*    */ public class MedicCheckinTreatmentDetailBuilder {
/*    */   private int id;
/*    */   private Integer mdId;
/*    */   private Date createdDate;
/*    */   private String createdBy;
/*    */   private Integer createdId;
/*    */   private Date ngayYLenh;
/*    */   private String dienBienBenh;
/*    */   private String yLenh;
/*    */   private String createdDateView;
/*    */   
/* 14 */   public MedicCheckinTreatmentDetailBuilder id(int id) { this.id = id; return this; } public MedicCheckinTreatmentDetailBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinTreatmentDetailBuilder createdDate(Date createdDate) { this.createdDate = createdDate; return this; } public MedicCheckinTreatmentDetailBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicCheckinTreatmentDetailBuilder createdId(Integer createdId) { this.createdId = createdId; return this; } public MedicCheckinTreatmentDetailBuilder ngayYLenh(Date ngayYLenh) { this.ngayYLenh = ngayYLenh; return this; } public MedicCheckinTreatmentDetailBuilder dienBienBenh(String dienBienBenh) { this.dienBienBenh = dienBienBenh; return this; } public MedicCheckinTreatmentDetailBuilder yLenh(String yLenh) { this.yLenh = yLenh; return this; } public MedicCheckinTreatmentDetailBuilder createdDateView(String createdDateView) { this.createdDateView = createdDateView; return this; } public MedicCheckinTreatmentDetail build() { return new MedicCheckinTreatmentDetail(this.id, this.mdId, this.createdDate, this.createdBy, this.createdId, this.ngayYLenh, this.dienBienBenh, this.yLenh, this.createdDateView); } public String toString() { return "MedicCheckinTreatmentDetail.MedicCheckinTreatmentDetailBuilder(id=" + this.id + ", mdId=" + this.mdId + ", createdDate=" + this.createdDate + ", createdBy=" + this.createdBy + ", createdId=" + this.createdId + ", ngayYLenh=" + this.ngayYLenh + ", dienBienBenh=" + this.dienBienBenh + ", yLenh=" + this.yLenh + ", createdDateView=" + this.createdDateView + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinTreatmentDetail$MedicCheckinTreatmentDetailBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */