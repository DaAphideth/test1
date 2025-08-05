/*     */ package nencer.app.Modules.Medic.Entity.Checkin;@Entity
/*     */ @Table(name = "medic_checkin_record_his")
/*     */ public class MedicCheckinRecordHis { private Integer mdId; private Integer checkinId; private Integer roomId; private Integer departmentId; private Integer doctorId; private Integer number; private String paymentStatus; private String reason; private String status; private Integer creatorId; private Date createdAt; private Integer updatedId; private Date updatedAt; private String mdType; private Integer chamberId;
/*     */   private Integer bedId;
/*     */   private Integer roomTreatmentId;
/*     */   private Integer mdIdBefore;
/*     */   private String patientInType;
/*     */   private String checkinInfo;
/*     */   private String doctorName;
/*     */   private String customerType;
/*     */   private String diagnosticArray;
/*     */   private String diagnosticSubArray;
/*     */   private String fromResultArray;
/*     */   
/*  15 */   public static MedicCheckinRecordHisBuilder builder() { return new MedicCheckinRecordHisBuilder(); } public static class MedicCheckinRecordHisBuilder { private Integer mdId; private Integer checkinId; private Integer roomId; private Integer departmentId; private Integer doctorId; private Integer number; private String paymentStatus; private String reason; private String status; private Integer creatorId; private Date createdAt; private Integer updatedId; public MedicCheckinRecordHisBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } private Date updatedAt; private String mdType; private Integer chamberId; private Integer bedId; private Integer roomTreatmentId; private Integer mdIdBefore; private String patientInType; private String checkinInfo; private String doctorName; private String customerType; private String diagnosticArray; private String diagnosticSubArray; private String fromResultArray; public MedicCheckinRecordHisBuilder checkinId(Integer checkinId) { this.checkinId = checkinId; return this; } public MedicCheckinRecordHisBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicCheckinRecordHisBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicCheckinRecordHisBuilder doctorId(Integer doctorId) { this.doctorId = doctorId; return this; } public MedicCheckinRecordHisBuilder number(Integer number) { this.number = number; return this; } public MedicCheckinRecordHisBuilder paymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; return this; } public MedicCheckinRecordHisBuilder reason(String reason) { this.reason = reason; return this; } public MedicCheckinRecordHisBuilder status(String status) { this.status = status; return this; } public MedicCheckinRecordHisBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public MedicCheckinRecordHisBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicCheckinRecordHisBuilder updatedId(Integer updatedId) { this.updatedId = updatedId; return this; } public MedicCheckinRecordHisBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicCheckinRecordHisBuilder mdType(String mdType) { this.mdType = mdType; return this; } public MedicCheckinRecordHisBuilder chamberId(Integer chamberId) { this.chamberId = chamberId; return this; } public MedicCheckinRecordHisBuilder bedId(Integer bedId) { this.bedId = bedId; return this; } public MedicCheckinRecordHisBuilder roomTreatmentId(Integer roomTreatmentId) { this.roomTreatmentId = roomTreatmentId; return this; } public MedicCheckinRecordHisBuilder mdIdBefore(Integer mdIdBefore) { this.mdIdBefore = mdIdBefore; return this; } public MedicCheckinRecordHisBuilder patientInType(String patientInType) { this.patientInType = patientInType; return this; } public MedicCheckinRecordHisBuilder checkinInfo(String checkinInfo) { this.checkinInfo = checkinInfo; return this; } public MedicCheckinRecordHisBuilder doctorName(String doctorName) { this.doctorName = doctorName; return this; } public MedicCheckinRecordHisBuilder customerType(String customerType) { this.customerType = customerType; return this; } public MedicCheckinRecordHisBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public MedicCheckinRecordHisBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public MedicCheckinRecordHisBuilder fromResultArray(String fromResultArray) { this.fromResultArray = fromResultArray; return this; } public MedicCheckinRecordHis build() { return new MedicCheckinRecordHis(this.mdId, this.checkinId, this.roomId, this.departmentId, this.doctorId, this.number, this.paymentStatus, this.reason, this.status, this.creatorId, this.createdAt, this.updatedId, this.updatedAt, this.mdType, this.chamberId, this.bedId, this.roomTreatmentId, this.mdIdBefore, this.patientInType, this.checkinInfo, this.doctorName, this.customerType, this.diagnosticArray, this.diagnosticSubArray, this.fromResultArray); } public String toString() { return "MedicCheckinRecordHis.MedicCheckinRecordHisBuilder(mdId=" + this.mdId + ", checkinId=" + this.checkinId + ", roomId=" + this.roomId + ", departmentId=" + this.departmentId + ", doctorId=" + this.doctorId + ", number=" + this.number + ", paymentStatus=" + this.paymentStatus + ", reason=" + this.reason + ", status=" + this.status + ", creatorId=" + this.creatorId + ", createdAt=" + this.createdAt + ", updatedId=" + this.updatedId + ", updatedAt=" + this.updatedAt + ", mdType=" + this.mdType + ", chamberId=" + this.chamberId + ", bedId=" + this.bedId + ", roomTreatmentId=" + this.roomTreatmentId + ", mdIdBefore=" + this.mdIdBefore + ", patientInType=" + this.patientInType + ", checkinInfo=" + this.checkinInfo + ", doctorName=" + this.doctorName + ", customerType=" + this.customerType + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", fromResultArray=" + this.fromResultArray + ")"; } } public MedicCheckinRecordHis() {} public MedicCheckinRecordHis(Integer mdId, Integer checkinId, Integer roomId, Integer departmentId, Integer doctorId, Integer number, String paymentStatus, String reason, String status, Integer creatorId, Date createdAt, Integer updatedId, Date updatedAt, String mdType, Integer chamberId, Integer bedId, Integer roomTreatmentId, Integer mdIdBefore, String patientInType, String checkinInfo, String doctorName, String customerType, String diagnosticArray, String diagnosticSubArray, String fromResultArray) {
/*  16 */     this.mdId = mdId; this.checkinId = checkinId; this.roomId = roomId; this.departmentId = departmentId; this.doctorId = doctorId; this.number = number; this.paymentStatus = paymentStatus; this.reason = reason; this.status = status; this.creatorId = creatorId; this.createdAt = createdAt; this.updatedId = updatedId; this.updatedAt = updatedAt; this.mdType = mdType; this.chamberId = chamberId; this.bedId = bedId; this.roomTreatmentId = roomTreatmentId; this.mdIdBefore = mdIdBefore; this.patientInType = patientInType; this.checkinInfo = checkinInfo; this.doctorName = doctorName; this.customerType = customerType; this.diagnosticArray = diagnosticArray; this.diagnosticSubArray = diagnosticSubArray; this.fromResultArray = fromResultArray;
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
/*     */   
/*     */   @Id
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/*  52 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  56 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_id")
/*     */   public Integer getCheckinId() {
/*  62 */     return this.checkinId;
/*     */   }
/*     */   
/*     */   public void setCheckinId(Integer checkinId) {
/*  66 */     this.checkinId = checkinId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  72 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/*  76 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_treatment_id")
/*     */   public Integer getRoomTreatmentId() {
/*  82 */     return this.roomTreatmentId;
/*     */   }
/*     */   
/*     */   public void setRoomTreatmentId(Integer roomTreatmentId) {
/*  86 */     this.roomTreatmentId = roomTreatmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "department_id")
/*     */   public Integer getDepartmentId() {
/*  92 */     return this.departmentId;
/*     */   }
/*     */   
/*     */   public void setDepartmentId(Integer departmentId) {
/*  96 */     this.departmentId = departmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_id")
/*     */   public Integer getDoctorId() {
/* 102 */     return this.doctorId;
/*     */   }
/*     */   
/*     */   public void setDoctorId(Integer doctorId) {
/* 106 */     this.doctorId = doctorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_name")
/*     */   public String getDoctorName() {
/* 112 */     return this.doctorName;
/*     */   }
/*     */   
/*     */   public void setDoctorName(String doctorName) {
/* 116 */     this.doctorName = doctorName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_type")
/*     */   public String getCustomerType() {
/* 122 */     return this.customerType;
/*     */   }
/*     */   
/*     */   public void setCustomerType(String customerType) {
/* 126 */     this.customerType = customerType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_info")
/*     */   public String getCheckinInfo() {
/* 132 */     return this.checkinInfo;
/*     */   }
/*     */   
/*     */   public void setCheckinInfo(String checkinInfo) {
/* 136 */     this.checkinInfo = checkinInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public Integer getNumber() {
/* 142 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/* 146 */     this.number = number;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment_status")
/*     */   public String getPaymentStatus() {
/* 152 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */   public void setPaymentStatus(String paymentStatus) {
/* 156 */     this.paymentStatus = paymentStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 162 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 166 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 172 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 176 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 182 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 186 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 192 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 196 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_id")
/*     */   public Integer getUpdatedId() {
/* 202 */     return this.updatedId;
/*     */   }
/*     */   
/*     */   public void setUpdatedId(Integer updatedId) {
/* 206 */     this.updatedId = updatedId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 212 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 216 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_type")
/*     */   public String getMdType() {
/* 222 */     return this.mdType;
/*     */   }
/*     */   
/*     */   public void setMdType(String mdType) {
/* 226 */     this.mdType = mdType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "chamber_id")
/*     */   public Integer getChamberId() {
/* 232 */     return this.chamberId;
/*     */   }
/*     */   
/*     */   public void setChamberId(Integer chamberId) {
/* 236 */     this.chamberId = chamberId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bed_id")
/*     */   public Integer getBedId() {
/* 242 */     return this.bedId;
/*     */   }
/*     */   
/*     */   public void setBedId(Integer bedId) {
/* 246 */     this.bedId = bedId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_in_type")
/*     */   public String getPatientInType() {
/* 252 */     return this.patientInType;
/*     */   }
/*     */   
/*     */   public void setPatientInType(String patientInType) {
/* 256 */     this.patientInType = patientInType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id_before")
/*     */   public Integer getMdIdBefore() {
/* 262 */     return this.mdIdBefore;
/*     */   }
/*     */   
/*     */   public void setMdIdBefore(Integer mdIdBefore) {
/* 266 */     this.mdIdBefore = mdIdBefore;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "from_result_array")
/*     */   public String getFromResultArray() {
/* 272 */     return this.fromResultArray;
/*     */   }
/*     */   
/*     */   public void setFromResultArray(String fromResultArray) {
/* 276 */     this.fromResultArray = fromResultArray;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckinRecordHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */