/*    */ package nencer.app.Modules.Medic.Model.Treatment;@JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicCheckinLiveDetailModel { private int id; private Integer mdId; private String createdBy; private String thongTinChiSo; private String bloodPressure; private String circuit; private String temperature; private String breathing; private String weight; private String spo2;
/*    */   private String ventilator;
/*    */   private String balloon;
/*    */   private String ecmo;
/*    */   private String dbp;
/*    */   private String sbp;
/*    */   private Integer createdId;
/*    */   private String createdDate;
/*    */   private String createdByName;
/*    */   private String followDate;
/*    */   
/* 13 */   public void setId(int id) { this.id = id; } public void setMdId(Integer mdId) { this.mdId = mdId; } public void setCreatedBy(String createdBy) { this.createdBy = createdBy; } public void setThongTinChiSo(String thongTinChiSo) { this.thongTinChiSo = thongTinChiSo; } public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; } public void setCircuit(String circuit) { this.circuit = circuit; } public void setTemperature(String temperature) { this.temperature = temperature; } public void setBreathing(String breathing) { this.breathing = breathing; } public void setWeight(String weight) { this.weight = weight; } public void setSpo2(String spo2) { this.spo2 = spo2; } public void setVentilator(String ventilator) { this.ventilator = ventilator; } public void setBalloon(String balloon) { this.balloon = balloon; } public void setEcmo(String ecmo) { this.ecmo = ecmo; } public void setDbp(String dbp) { this.dbp = dbp; } public void setSbp(String sbp) { this.sbp = sbp; } public void setCreatedId(Integer createdId) { this.createdId = createdId; } public void setCreatedDate(String createdDate) { this.createdDate = createdDate; } public void setCreatedByName(String createdByName) { this.createdByName = createdByName; } public void setFollowDate(String followDate) { this.followDate = followDate; } public MedicCheckinLiveDetailModel(int id, Integer mdId, String createdBy, String thongTinChiSo, String bloodPressure, String circuit, String temperature, String breathing, String weight, String spo2, String ventilator, String balloon, String ecmo, String dbp, String sbp, Integer createdId, String createdDate, String createdByName, String followDate) {
/* 14 */     this.id = id; this.mdId = mdId; this.createdBy = createdBy; this.thongTinChiSo = thongTinChiSo; this.bloodPressure = bloodPressure; this.circuit = circuit; this.temperature = temperature; this.breathing = breathing; this.weight = weight; this.spo2 = spo2; this.ventilator = ventilator; this.balloon = balloon; this.ecmo = ecmo; this.dbp = dbp; this.sbp = sbp; this.createdId = createdId; this.createdDate = createdDate; this.createdByName = createdByName; this.followDate = followDate;
/*    */   } public MedicCheckinLiveDetailModel() {}
/* 16 */   public static MedicCheckinLiveDetailModelBuilder builder() { return new MedicCheckinLiveDetailModelBuilder(); } public static class MedicCheckinLiveDetailModelBuilder { private int id; private Integer mdId; private String createdBy; private String thongTinChiSo; private String bloodPressure; private String circuit; private String temperature; private String breathing; private String weight; public MedicCheckinLiveDetailModelBuilder id(int id) { this.id = id; return this; } private String spo2; private String ventilator; private String balloon; private String ecmo; private String dbp; private String sbp; private Integer createdId; private String createdDate; private String createdByName; private String followDate; public MedicCheckinLiveDetailModelBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinLiveDetailModelBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicCheckinLiveDetailModelBuilder thongTinChiSo(String thongTinChiSo) { this.thongTinChiSo = thongTinChiSo; return this; } public MedicCheckinLiveDetailModelBuilder bloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; return this; } public MedicCheckinLiveDetailModelBuilder circuit(String circuit) { this.circuit = circuit; return this; } public MedicCheckinLiveDetailModelBuilder temperature(String temperature) { this.temperature = temperature; return this; } public MedicCheckinLiveDetailModelBuilder breathing(String breathing) { this.breathing = breathing; return this; } public MedicCheckinLiveDetailModelBuilder weight(String weight) { this.weight = weight; return this; } public MedicCheckinLiveDetailModelBuilder spo2(String spo2) { this.spo2 = spo2; return this; } public MedicCheckinLiveDetailModelBuilder ventilator(String ventilator) { this.ventilator = ventilator; return this; } public MedicCheckinLiveDetailModelBuilder balloon(String balloon) { this.balloon = balloon; return this; } public MedicCheckinLiveDetailModelBuilder ecmo(String ecmo) { this.ecmo = ecmo; return this; } public MedicCheckinLiveDetailModelBuilder dbp(String dbp) { this.dbp = dbp; return this; } public MedicCheckinLiveDetailModelBuilder sbp(String sbp) { this.sbp = sbp; return this; } public MedicCheckinLiveDetailModelBuilder createdId(Integer createdId) { this.createdId = createdId; return this; } public MedicCheckinLiveDetailModelBuilder createdDate(String createdDate) { this.createdDate = createdDate; return this; } public MedicCheckinLiveDetailModelBuilder createdByName(String createdByName) { this.createdByName = createdByName; return this; } public MedicCheckinLiveDetailModelBuilder followDate(String followDate) { this.followDate = followDate; return this; } public MedicCheckinLiveDetailModel build() { return new MedicCheckinLiveDetailModel(this.id, this.mdId, this.createdBy, this.thongTinChiSo, this.bloodPressure, this.circuit, this.temperature, this.breathing, this.weight, this.spo2, this.ventilator, this.balloon, this.ecmo, this.dbp, this.sbp, this.createdId, this.createdDate, this.createdByName, this.followDate); } public String toString() { return "MedicCheckinLiveDetailModel.MedicCheckinLiveDetailModelBuilder(id=" + this.id + ", mdId=" + this.mdId + ", createdBy=" + this.createdBy + ", thongTinChiSo=" + this.thongTinChiSo + ", bloodPressure=" + this.bloodPressure + ", circuit=" + this.circuit + ", temperature=" + this.temperature + ", breathing=" + this.breathing + ", weight=" + this.weight + ", spo2=" + this.spo2 + ", ventilator=" + this.ventilator + ", balloon=" + this.balloon + ", ecmo=" + this.ecmo + ", dbp=" + this.dbp + ", sbp=" + this.sbp + ", createdId=" + this.createdId + ", createdDate=" + this.createdDate + ", createdByName=" + this.createdByName + ", followDate=" + this.followDate + ")"; }
/*    */      }
/* 18 */   public int getId() { return this.id; }
/* 19 */   public Integer getMdId() { return this.mdId; }
/* 20 */   public String getCreatedBy() { return this.createdBy; }
/* 21 */   public String getThongTinChiSo() { return this.thongTinChiSo; }
/* 22 */   public String getBloodPressure() { return this.bloodPressure; }
/* 23 */   public String getCircuit() { return this.circuit; }
/* 24 */   public String getTemperature() { return this.temperature; }
/* 25 */   public String getBreathing() { return this.breathing; }
/* 26 */   public String getWeight() { return this.weight; }
/* 27 */   public String getSpo2() { return this.spo2; }
/* 28 */   public String getVentilator() { return this.ventilator; }
/* 29 */   public String getBalloon() { return this.balloon; }
/* 30 */   public String getEcmo() { return this.ecmo; }
/* 31 */   public String getDbp() { return this.dbp; }
/* 32 */   public String getSbp() { return this.sbp; }
/* 33 */   public Integer getCreatedId() { return this.createdId; }
/* 34 */   public String getCreatedDate() { return this.createdDate; }
/* 35 */   public String getCreatedByName() { return this.createdByName; } public String getFollowDate() {
/* 36 */     return this.followDate;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLiveDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */