/*     */ package nencer.app.Modules.Medic.Entity.Examination;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_examination_results_his")
/*     */ public class MedicExaminationResultsHis
/*     */ {
/*     */   private int id;
/*     */   private int doctorId;
/*     */   private int mdId;
/*     */   private String examinationArray;
/*     */   private String diagnosticArray;
/*     */   private String diagnosticSubArray;
/*     */   private String advice;
/*     */   private String deliveryOfPrescription;
/*     */   private String switchClinic;
/*     */   private String hospitalization;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  35 */     return this.id;
/*     */   }
/*     */   private String uncheck; private String offlineTreatmentEnds; private String transition; private String death; private String endOfExamination; private String resultArray; private String fromResultArray; private Date createdResolve; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  39 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_id")
/*     */   public int getDoctorId() {
/*  45 */     return this.doctorId;
/*     */   }
/*     */   
/*     */   public void setDoctorId(int doctorId) {
/*  49 */     this.doctorId = doctorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public int getMdId() {
/*  55 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(int mdId) {
/*  59 */     this.mdId = mdId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "examination_array")
/*     */   public String getExaminationArray() {
/*  66 */     return this.examinationArray;
/*     */   }
/*     */   
/*     */   public void setExaminationArray(String examinationArray) {
/*  70 */     this.examinationArray = examinationArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_array")
/*     */   public String getDiagnosticArray() {
/*  76 */     return this.diagnosticArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticArray(String diagnosticArray) {
/*  80 */     this.diagnosticArray = diagnosticArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_sub_array")
/*     */   public String getDiagnosticSubArray() {
/*  86 */     return this.diagnosticSubArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticSubArray(String diagnosticSubArray) {
/*  90 */     this.diagnosticSubArray = diagnosticSubArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "advice")
/*     */   public String getAdvice() {
/*  96 */     return this.advice;
/*     */   }
/*     */   
/*     */   public void setAdvice(String advice) {
/* 100 */     this.advice = advice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "delivery_of_prescription")
/*     */   public String getDeliveryOfPrescription() {
/* 106 */     return this.deliveryOfPrescription;
/*     */   }
/*     */   
/*     */   public void setDeliveryOfPrescription(String deliveryOfPrescription) {
/* 110 */     this.deliveryOfPrescription = deliveryOfPrescription;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "switch_clinic")
/*     */   public String getSwitchClinic() {
/* 116 */     return this.switchClinic;
/*     */   }
/*     */   
/*     */   public void setSwitchClinic(String switchClinic) {
/* 120 */     this.switchClinic = switchClinic;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospitalization")
/*     */   public String getHospitalization() {
/* 126 */     return this.hospitalization;
/*     */   }
/*     */   
/*     */   public void setHospitalization(String hospitalization) {
/* 130 */     this.hospitalization = hospitalization;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "uncheck")
/*     */   public String getUncheck() {
/* 136 */     return this.uncheck;
/*     */   }
/*     */   
/*     */   public void setUncheck(String uncheck) {
/* 140 */     this.uncheck = uncheck;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "offline_treatment_ends")
/*     */   public String getOfflineTreatmentEnds() {
/* 146 */     return this.offlineTreatmentEnds;
/*     */   }
/*     */   
/*     */   public void setOfflineTreatmentEnds(String offlineTreatmentEnds) {
/* 150 */     this.offlineTreatmentEnds = offlineTreatmentEnds;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "transition")
/*     */   public String getTransition() {
/* 156 */     return this.transition;
/*     */   }
/*     */   
/*     */   public void setTransition(String transition) {
/* 160 */     this.transition = transition;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "death")
/*     */   public String getDeath() {
/* 166 */     return this.death;
/*     */   }
/*     */   
/*     */   public void setDeath(String death) {
/* 170 */     this.death = death;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "end_of_examination")
/*     */   public String getEndOfExamination() {
/* 176 */     return this.endOfExamination;
/*     */   }
/*     */   
/*     */   public void setEndOfExamination(String endOfExamination) {
/* 180 */     this.endOfExamination = endOfExamination;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "result_array")
/*     */   public String getResultArray() {
/* 186 */     return this.resultArray;
/*     */   }
/*     */   
/*     */   public void setResultArray(String resultArray) {
/* 190 */     this.resultArray = resultArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "from_result_array")
/*     */   public String getFromResultArray() {
/* 196 */     return this.fromResultArray;
/*     */   }
/*     */   
/*     */   public void setFromResultArray(String fromResultArray) {
/* 200 */     this.fromResultArray = fromResultArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_resolve")
/*     */   public Date getCreatedResolve() {
/* 206 */     return this.createdResolve;
/*     */   }
/*     */   
/*     */   public void setCreatedResolve(Date createdResolve) {
/* 210 */     this.createdResolve = createdResolve;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 216 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 220 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 226 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 230 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Examination\MedicExaminationResultsHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */