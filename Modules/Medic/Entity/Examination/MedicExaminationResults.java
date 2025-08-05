/*     */ package nencer.app.Modules.Medic.Entity.Examination;
/*     */ @Entity
/*     */ @Table(name = "medic_examination_results")
/*     */ public class MedicExaminationResults { private int id; @NotNull(message = "804")
/*     */   @Range(min = 1L, message = "303")
/*     */   private int doctorId; @NotNull(message = "804")
/*     */   private int mdId; private String examinationArray; private String diagnosticArray; private String diagnosticSubArray; private String advice;
/*     */   private String deliveryOfPrescription;
/*     */   private String switchClinic;
/*     */   private String hospitalization;
/*     */   private String uncheck;
/*     */   
/*  13 */   public static MedicExaminationResultsBuilder builder() { return new MedicExaminationResultsBuilder(); } private String offlineTreatmentEnds; private String transition; private String death; private String endOfExamination; private String resultArray; private String fromResultArray; private String reasonEdit; private Date createdResolve; private Date createdAt; private Date updatedAt; private Integer roomId; private Integer serviceId; public static class MedicExaminationResultsBuilder { private int id; private int doctorId; private int mdId; private String examinationArray; private String diagnosticArray; private String diagnosticSubArray; private String advice; private String deliveryOfPrescription; private String switchClinic; private String hospitalization; private String uncheck; private String offlineTreatmentEnds; private String transition; private String death; private String endOfExamination; private String resultArray; private String fromResultArray; private String reasonEdit; private Date createdResolve; private Date createdAt; private Date updatedAt; private Integer roomId; private Integer serviceId; public MedicExaminationResultsBuilder id(int id) { this.id = id; return this; } public MedicExaminationResultsBuilder doctorId(int doctorId) { this.doctorId = doctorId; return this; } public MedicExaminationResultsBuilder mdId(int mdId) { this.mdId = mdId; return this; } public MedicExaminationResultsBuilder examinationArray(String examinationArray) { this.examinationArray = examinationArray; return this; } public MedicExaminationResultsBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public MedicExaminationResultsBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public MedicExaminationResultsBuilder advice(String advice) { this.advice = advice; return this; } public MedicExaminationResultsBuilder deliveryOfPrescription(String deliveryOfPrescription) { this.deliveryOfPrescription = deliveryOfPrescription; return this; } public MedicExaminationResultsBuilder switchClinic(String switchClinic) { this.switchClinic = switchClinic; return this; } public MedicExaminationResultsBuilder hospitalization(String hospitalization) { this.hospitalization = hospitalization; return this; } public MedicExaminationResultsBuilder uncheck(String uncheck) { this.uncheck = uncheck; return this; } public MedicExaminationResultsBuilder offlineTreatmentEnds(String offlineTreatmentEnds) { this.offlineTreatmentEnds = offlineTreatmentEnds; return this; } public MedicExaminationResultsBuilder transition(String transition) { this.transition = transition; return this; } public MedicExaminationResultsBuilder death(String death) { this.death = death; return this; } public MedicExaminationResultsBuilder endOfExamination(String endOfExamination) { this.endOfExamination = endOfExamination; return this; } public MedicExaminationResultsBuilder resultArray(String resultArray) { this.resultArray = resultArray; return this; } public MedicExaminationResultsBuilder fromResultArray(String fromResultArray) { this.fromResultArray = fromResultArray; return this; } public MedicExaminationResultsBuilder reasonEdit(String reasonEdit) { this.reasonEdit = reasonEdit; return this; } public MedicExaminationResultsBuilder createdResolve(Date createdResolve) { this.createdResolve = createdResolve; return this; } public MedicExaminationResultsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicExaminationResultsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicExaminationResultsBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicExaminationResultsBuilder serviceId(Integer serviceId) { this.serviceId = serviceId; return this; } public MedicExaminationResults build() { return new MedicExaminationResults(this.id, this.doctorId, this.mdId, this.examinationArray, this.diagnosticArray, this.diagnosticSubArray, this.advice, this.deliveryOfPrescription, this.switchClinic, this.hospitalization, this.uncheck, this.offlineTreatmentEnds, this.transition, this.death, this.endOfExamination, this.resultArray, this.fromResultArray, this.reasonEdit, this.createdResolve, this.createdAt, this.updatedAt, this.roomId, this.serviceId); } public String toString() { return "MedicExaminationResults.MedicExaminationResultsBuilder(id=" + this.id + ", doctorId=" + this.doctorId + ", mdId=" + this.mdId + ", examinationArray=" + this.examinationArray + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", advice=" + this.advice + ", deliveryOfPrescription=" + this.deliveryOfPrescription + ", switchClinic=" + this.switchClinic + ", hospitalization=" + this.hospitalization + ", uncheck=" + this.uncheck + ", offlineTreatmentEnds=" + this.offlineTreatmentEnds + ", transition=" + this.transition + ", death=" + this.death + ", endOfExamination=" + this.endOfExamination + ", resultArray=" + this.resultArray + ", fromResultArray=" + this.fromResultArray + ", reasonEdit=" + this.reasonEdit + ", createdResolve=" + this.createdResolve + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", roomId=" + this.roomId + ", serviceId=" + this.serviceId + ")"; } } public MedicExaminationResults(int id, int doctorId, int mdId, String examinationArray, String diagnosticArray, String diagnosticSubArray, String advice, String deliveryOfPrescription, String switchClinic, String hospitalization, String uncheck, String offlineTreatmentEnds, String transition, String death, String endOfExamination, String resultArray, String fromResultArray, String reasonEdit, Date createdResolve, Date createdAt, Date updatedAt, Integer roomId, Integer serviceId) {
/*  14 */     this.id = id; this.doctorId = doctorId; this.mdId = mdId; this.examinationArray = examinationArray; this.diagnosticArray = diagnosticArray; this.diagnosticSubArray = diagnosticSubArray; this.advice = advice; this.deliveryOfPrescription = deliveryOfPrescription; this.switchClinic = switchClinic; this.hospitalization = hospitalization; this.uncheck = uncheck; this.offlineTreatmentEnds = offlineTreatmentEnds; this.transition = transition; this.death = death; this.endOfExamination = endOfExamination; this.resultArray = resultArray; this.fromResultArray = fromResultArray; this.reasonEdit = reasonEdit; this.createdResolve = createdResolve; this.createdAt = createdAt; this.updatedAt = updatedAt; this.roomId = roomId; this.serviceId = serviceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicExaminationResults() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  51 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  55 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason_edit")
/*     */   public String getReasonEdit() {
/*  61 */     return this.reasonEdit;
/*     */   }
/*     */   
/*     */   public void setReasonEdit(String reasonEdit) {
/*  65 */     this.reasonEdit = reasonEdit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_id")
/*     */   public int getDoctorId() {
/*  71 */     return this.doctorId;
/*     */   }
/*     */   
/*     */   public void setDoctorId(int doctorId) {
/*  75 */     this.doctorId = doctorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public int getMdId() {
/*  81 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(int mdId) {
/*  85 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "examination_array")
/*     */   public String getExaminationArray() {
/*  91 */     return this.examinationArray;
/*     */   }
/*     */   
/*     */   public void setExaminationArray(String examinationArray) {
/*  95 */     this.examinationArray = examinationArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_array")
/*     */   public String getDiagnosticArray() {
/* 101 */     return this.diagnosticArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticArray(String diagnosticArray) {
/* 105 */     this.diagnosticArray = diagnosticArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_sub_array")
/*     */   public String getDiagnosticSubArray() {
/* 111 */     return this.diagnosticSubArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticSubArray(String diagnosticSubArray) {
/* 115 */     this.diagnosticSubArray = diagnosticSubArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "advice")
/*     */   public String getAdvice() {
/* 121 */     return this.advice;
/*     */   }
/*     */   
/*     */   public void setAdvice(String advice) {
/* 125 */     this.advice = advice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "delivery_of_prescription")
/*     */   public String getDeliveryOfPrescription() {
/* 131 */     return this.deliveryOfPrescription;
/*     */   }
/*     */   
/*     */   public void setDeliveryOfPrescription(String deliveryOfPrescription) {
/* 135 */     this.deliveryOfPrescription = deliveryOfPrescription;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "switch_clinic")
/*     */   public String getSwitchClinic() {
/* 141 */     return this.switchClinic;
/*     */   }
/*     */   
/*     */   public void setSwitchClinic(String switchClinic) {
/* 145 */     this.switchClinic = switchClinic;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospitalization")
/*     */   public String getHospitalization() {
/* 151 */     return this.hospitalization;
/*     */   }
/*     */   
/*     */   public void setHospitalization(String hospitalization) {
/* 155 */     this.hospitalization = hospitalization;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "uncheck")
/*     */   public String getUncheck() {
/* 161 */     return this.uncheck;
/*     */   }
/*     */   
/*     */   public void setUncheck(String uncheck) {
/* 165 */     this.uncheck = uncheck;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "offline_treatment_ends")
/*     */   public String getOfflineTreatmentEnds() {
/* 171 */     return this.offlineTreatmentEnds;
/*     */   }
/*     */   
/*     */   public void setOfflineTreatmentEnds(String offlineTreatmentEnds) {
/* 175 */     this.offlineTreatmentEnds = offlineTreatmentEnds;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "transition")
/*     */   public String getTransition() {
/* 181 */     return this.transition;
/*     */   }
/*     */   
/*     */   public void setTransition(String transition) {
/* 185 */     this.transition = transition;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "death")
/*     */   public String getDeath() {
/* 191 */     return this.death;
/*     */   }
/*     */   
/*     */   public void setDeath(String death) {
/* 195 */     this.death = death;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "end_of_examination")
/*     */   public String getEndOfExamination() {
/* 201 */     return this.endOfExamination;
/*     */   }
/*     */   
/*     */   public void setEndOfExamination(String endOfExamination) {
/* 205 */     this.endOfExamination = endOfExamination;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "result_array")
/*     */   public String getResultArray() {
/* 211 */     return this.resultArray;
/*     */   }
/*     */   
/*     */   public void setResultArray(String resultArray) {
/* 215 */     this.resultArray = resultArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "from_result_array")
/*     */   public String getFromResultArray() {
/* 221 */     return this.fromResultArray;
/*     */   }
/*     */   
/*     */   public void setFromResultArray(String fromResultArray) {
/* 225 */     this.fromResultArray = fromResultArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_resolve")
/*     */   public Date getCreatedResolve() {
/* 231 */     return this.createdResolve;
/*     */   }
/*     */   
/*     */   public void setCreatedResolve(Date createdResolve) {
/* 235 */     this.createdResolve = createdResolve;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 241 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 245 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 251 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 255 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public Integer getRoomId() {
/* 260 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/* 264 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public Integer getServiceId() {
/* 269 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/* 273 */     this.serviceId = serviceId;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Examination\MedicExaminationResults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */