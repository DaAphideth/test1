/*     */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_live_detail")
/*     */ public class MedicCheckinLiveDetail
/*     */   implements Serializable
/*     */ {
/*     */   private int id;
/*     */   private Integer mdId;
/*     */   private String createdBy;
/*     */   private String thongTinChiSo;
/*     */   private String bloodPressure;
/*     */   private String bloodPressure1;
/*     */   private String circuit;
/*     */   private String temperature;
/*     */   private String breathing;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  37 */     return this.id;
/*     */   }
/*     */   private String weight; private String spo2; private String ventilator; private String balloon; private String ecmo; private String dbp; private String sbp; private Integer createdId; private Date createdDate; private String createdDateView;
/*     */   public void setId(int id) {
/*  41 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/*  47 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  51 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_by")
/*     */   public String getCreatedBy() {
/*  57 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  61 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "thong_tin_chi_so")
/*     */   public String getThongTinChiSo() {
/*  67 */     return this.thongTinChiSo;
/*     */   }
/*     */   
/*     */   public void setThongTinChiSo(String thongTinChiSo) {
/*  71 */     this.thongTinChiSo = thongTinChiSo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "blood_pressure")
/*     */   public String getBloodPressure() {
/*  77 */     return this.bloodPressure;
/*     */   }
/*     */   
/*     */   public void setBloodPressure(String bloodPressure) {
/*  81 */     this.bloodPressure = bloodPressure;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "circuit")
/*     */   public String getCircuit() {
/*  87 */     return this.circuit;
/*     */   }
/*     */   
/*     */   public void setCircuit(String circuit) {
/*  91 */     this.circuit = circuit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "temperature")
/*     */   public String getTemperature() {
/*  97 */     return this.temperature;
/*     */   }
/*     */   
/*     */   public void setTemperature(String temperature) {
/* 101 */     this.temperature = temperature;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "breathing")
/*     */   public String getBreathing() {
/* 107 */     return this.breathing;
/*     */   }
/*     */   
/*     */   public void setBreathing(String breathing) {
/* 111 */     this.breathing = breathing;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "weight")
/*     */   public String getWeight() {
/* 117 */     return this.weight;
/*     */   }
/*     */   
/*     */   public void setWeight(String weight) {
/* 121 */     this.weight = weight;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "spo2")
/*     */   public String getSpo2() {
/* 127 */     return this.spo2;
/*     */   }
/*     */   
/*     */   public void setSpo2(String spo2) {
/* 131 */     this.spo2 = spo2;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ventilator")
/*     */   public String getVentilator() {
/* 137 */     return this.ventilator;
/*     */   }
/*     */   
/*     */   public void setVentilator(String ventilator) {
/* 141 */     this.ventilator = ventilator;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "balloon")
/*     */   public String getBalloon() {
/* 147 */     return this.balloon;
/*     */   }
/*     */   
/*     */   public void setBalloon(String balloon) {
/* 151 */     this.balloon = balloon;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ecmo")
/*     */   public String getEcmo() {
/* 157 */     return this.ecmo;
/*     */   }
/*     */   
/*     */   public void setEcmo(String ecmo) {
/* 161 */     this.ecmo = ecmo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_id")
/*     */   public Integer getCreatedId() {
/* 167 */     return this.createdId;
/*     */   }
/*     */   
/*     */   public void setCreatedId(Integer createdId) {
/* 171 */     this.createdId = createdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_date")
/*     */   public Date getCreatedDate() {
/* 177 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Date createdDate) {
/* 181 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "dbp")
/*     */   public String getDbp() {
/* 187 */     return this.dbp;
/*     */   }
/*     */   
/*     */   public void setDbp(String dbp) {
/* 191 */     this.dbp = dbp;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sbp")
/*     */   public String getSbp() {
/* 197 */     return this.sbp;
/*     */   }
/*     */   
/*     */   public void setSbp(String sbp) {
/* 201 */     this.sbp = sbp;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "blood_pressure_1")
/*     */   public String getBloodPressure1() {
/* 207 */     return this.bloodPressure1;
/*     */   }
/*     */   
/*     */   public void setBloodPressure1(String bloodPressure1) {
/* 211 */     this.bloodPressure1 = bloodPressure1;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getCreatedDateView() {
/* 216 */     return this.createdDateView;
/*     */   }
/*     */   
/*     */   public void setCreatedDateView(String createdDateView) {
/* 220 */     this.createdDateView = createdDateView;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinLiveDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */