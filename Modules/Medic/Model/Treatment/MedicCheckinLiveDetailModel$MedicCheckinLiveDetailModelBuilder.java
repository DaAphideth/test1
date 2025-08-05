/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ public class MedicCheckinLiveDetailModelBuilder
/*    */ {
/*    */   private int id;
/*    */   private Integer mdId;
/*    */   private String createdBy;
/*    */   private String thongTinChiSo;
/*    */   private String bloodPressure;
/*    */   private String circuit;
/*    */   private String temperature;
/*    */   private String breathing;
/*    */   private String weight;
/*    */   
/*    */   public MedicCheckinLiveDetailModelBuilder id(int id) {
/* 16 */     this.id = id; return this; } private String spo2; private String ventilator; private String balloon; private String ecmo; private String dbp; private String sbp; private Integer createdId; private String createdDate; private String createdByName; private String followDate; public MedicCheckinLiveDetailModelBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinLiveDetailModelBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicCheckinLiveDetailModelBuilder thongTinChiSo(String thongTinChiSo) { this.thongTinChiSo = thongTinChiSo; return this; } public MedicCheckinLiveDetailModelBuilder bloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; return this; } public MedicCheckinLiveDetailModelBuilder circuit(String circuit) { this.circuit = circuit; return this; } public MedicCheckinLiveDetailModelBuilder temperature(String temperature) { this.temperature = temperature; return this; } public MedicCheckinLiveDetailModelBuilder breathing(String breathing) { this.breathing = breathing; return this; } public MedicCheckinLiveDetailModelBuilder weight(String weight) { this.weight = weight; return this; } public MedicCheckinLiveDetailModelBuilder spo2(String spo2) { this.spo2 = spo2; return this; } public MedicCheckinLiveDetailModelBuilder ventilator(String ventilator) { this.ventilator = ventilator; return this; } public MedicCheckinLiveDetailModelBuilder balloon(String balloon) { this.balloon = balloon; return this; } public MedicCheckinLiveDetailModelBuilder ecmo(String ecmo) { this.ecmo = ecmo; return this; } public MedicCheckinLiveDetailModelBuilder dbp(String dbp) { this.dbp = dbp; return this; } public MedicCheckinLiveDetailModelBuilder sbp(String sbp) { this.sbp = sbp; return this; } public MedicCheckinLiveDetailModelBuilder createdId(Integer createdId) { this.createdId = createdId; return this; } public MedicCheckinLiveDetailModelBuilder createdDate(String createdDate) { this.createdDate = createdDate; return this; } public MedicCheckinLiveDetailModelBuilder createdByName(String createdByName) { this.createdByName = createdByName; return this; } public MedicCheckinLiveDetailModelBuilder followDate(String followDate) { this.followDate = followDate; return this; } public MedicCheckinLiveDetailModel build() { return new MedicCheckinLiveDetailModel(this.id, this.mdId, this.createdBy, this.thongTinChiSo, this.bloodPressure, this.circuit, this.temperature, this.breathing, this.weight, this.spo2, this.ventilator, this.balloon, this.ecmo, this.dbp, this.sbp, this.createdId, this.createdDate, this.createdByName, this.followDate); } public String toString() { return "MedicCheckinLiveDetailModel.MedicCheckinLiveDetailModelBuilder(id=" + this.id + ", mdId=" + this.mdId + ", createdBy=" + this.createdBy + ", thongTinChiSo=" + this.thongTinChiSo + ", bloodPressure=" + this.bloodPressure + ", circuit=" + this.circuit + ", temperature=" + this.temperature + ", breathing=" + this.breathing + ", weight=" + this.weight + ", spo2=" + this.spo2 + ", ventilator=" + this.ventilator + ", balloon=" + this.balloon + ", ecmo=" + this.ecmo + ", dbp=" + this.dbp + ", sbp=" + this.sbp + ", createdId=" + this.createdId + ", createdDate=" + this.createdDate + ", createdByName=" + this.createdByName + ", followDate=" + this.followDate + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLiveDetailModel$MedicCheckinLiveDetailModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */