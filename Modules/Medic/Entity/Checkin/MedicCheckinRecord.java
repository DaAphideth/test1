/*     */ package nencer.app.Modules.Medic.Entity.Checkin;
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_record")
/*     */ public class MedicCheckinRecord implements Serializable { private Integer mdId; private Integer checkinId; private Integer roomId; private Integer departmentId; private Integer doctorId;
/*     */   private Integer number;
/*     */   private String paymentStatus;
/*     */   private String reason;
/*     */   private String status;
/*     */   private Integer creatorId;
/*     */   private Date createdAt;
/*     */   private Integer updatedId;
/*     */   private Date updatedAt;
/*     */   private String mdType;
/*     */   
/*  15 */   public static MedicCheckinRecordBuilder builder() { return new MedicCheckinRecordBuilder(); } private Integer chamberId; private Integer bedId; private Integer roomTreatmentId; private Integer mdIdBefore; private String patientInType; private MedicCheckin medicCheckin; private MedicRooms medicRooms; private MedicRooms medicRoomsTreatment; private String checkinInfo; private String doctorName; private String customerType; private String diagnosticArray; private String diagnosticSubArray; private String fromResultArray; public static class MedicCheckinRecordBuilder { private Integer mdId; private Integer checkinId; private Integer roomId; private Integer departmentId; private Integer doctorId; private Integer number; private String paymentStatus; private String reason; private String status; private Integer creatorId; private Date createdAt; private Integer updatedId; private Date updatedAt; private String mdType; private Integer chamberId; private Integer bedId; private Integer roomTreatmentId; private Integer mdIdBefore; private String patientInType; private MedicCheckin medicCheckin; private MedicRooms medicRooms; private MedicRooms medicRoomsTreatment; private String checkinInfo; private String doctorName; private String customerType; private String diagnosticArray; private String diagnosticSubArray; private String fromResultArray; public MedicCheckinRecordBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinRecordBuilder checkinId(Integer checkinId) { this.checkinId = checkinId; return this; } public MedicCheckinRecordBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicCheckinRecordBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicCheckinRecordBuilder doctorId(Integer doctorId) { this.doctorId = doctorId; return this; } public MedicCheckinRecordBuilder number(Integer number) { this.number = number; return this; } public MedicCheckinRecordBuilder paymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; return this; } public MedicCheckinRecordBuilder reason(String reason) { this.reason = reason; return this; } public MedicCheckinRecordBuilder status(String status) { this.status = status; return this; } public MedicCheckinRecordBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public MedicCheckinRecordBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicCheckinRecordBuilder updatedId(Integer updatedId) { this.updatedId = updatedId; return this; } public MedicCheckinRecordBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicCheckinRecordBuilder mdType(String mdType) { this.mdType = mdType; return this; } public MedicCheckinRecordBuilder chamberId(Integer chamberId) { this.chamberId = chamberId; return this; } public MedicCheckinRecordBuilder bedId(Integer bedId) { this.bedId = bedId; return this; } public MedicCheckinRecordBuilder roomTreatmentId(Integer roomTreatmentId) { this.roomTreatmentId = roomTreatmentId; return this; } public MedicCheckinRecordBuilder mdIdBefore(Integer mdIdBefore) { this.mdIdBefore = mdIdBefore; return this; } public MedicCheckinRecordBuilder patientInType(String patientInType) { this.patientInType = patientInType; return this; } public MedicCheckinRecordBuilder medicCheckin(MedicCheckin medicCheckin) { this.medicCheckin = medicCheckin; return this; } public MedicCheckinRecordBuilder medicRooms(MedicRooms medicRooms) { this.medicRooms = medicRooms; return this; } public MedicCheckinRecordBuilder medicRoomsTreatment(MedicRooms medicRoomsTreatment) { this.medicRoomsTreatment = medicRoomsTreatment; return this; } public MedicCheckinRecordBuilder checkinInfo(String checkinInfo) { this.checkinInfo = checkinInfo; return this; } public MedicCheckinRecordBuilder doctorName(String doctorName) { this.doctorName = doctorName; return this; } public MedicCheckinRecordBuilder customerType(String customerType) { this.customerType = customerType; return this; } public MedicCheckinRecordBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public MedicCheckinRecordBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public MedicCheckinRecordBuilder fromResultArray(String fromResultArray) { this.fromResultArray = fromResultArray; return this; } public MedicCheckinRecord build() { return new MedicCheckinRecord(this.mdId, this.checkinId, this.roomId, this.departmentId, this.doctorId, this.number, this.paymentStatus, this.reason, this.status, this.creatorId, this.createdAt, this.updatedId, this.updatedAt, this.mdType, this.chamberId, this.bedId, this.roomTreatmentId, this.mdIdBefore, this.patientInType, this.medicCheckin, this.medicRooms, this.medicRoomsTreatment, this.checkinInfo, this.doctorName, this.customerType, this.diagnosticArray, this.diagnosticSubArray, this.fromResultArray); } public String toString() { return "MedicCheckinRecord.MedicCheckinRecordBuilder(mdId=" + this.mdId + ", checkinId=" + this.checkinId + ", roomId=" + this.roomId + ", departmentId=" + this.departmentId + ", doctorId=" + this.doctorId + ", number=" + this.number + ", paymentStatus=" + this.paymentStatus + ", reason=" + this.reason + ", status=" + this.status + ", creatorId=" + this.creatorId + ", createdAt=" + this.createdAt + ", updatedId=" + this.updatedId + ", updatedAt=" + this.updatedAt + ", mdType=" + this.mdType + ", chamberId=" + this.chamberId + ", bedId=" + this.bedId + ", roomTreatmentId=" + this.roomTreatmentId + ", mdIdBefore=" + this.mdIdBefore + ", patientInType=" + this.patientInType + ", medicCheckin=" + this.medicCheckin + ", medicRooms=" + this.medicRooms + ", medicRoomsTreatment=" + this.medicRoomsTreatment + ", checkinInfo=" + this.checkinInfo + ", doctorName=" + this.doctorName + ", customerType=" + this.customerType + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", fromResultArray=" + this.fromResultArray + ")"; } } public MedicCheckinRecord() {} public MedicCheckinRecord(Integer mdId, Integer checkinId, Integer roomId, Integer departmentId, Integer doctorId, Integer number, String paymentStatus, String reason, String status, Integer creatorId, Date createdAt, Integer updatedId, Date updatedAt, String mdType, Integer chamberId, Integer bedId, Integer roomTreatmentId, Integer mdIdBefore, String patientInType, MedicCheckin medicCheckin, MedicRooms medicRooms, MedicRooms medicRoomsTreatment, String checkinInfo, String doctorName, String customerType, String diagnosticArray, String diagnosticSubArray, String fromResultArray) {
/*  16 */     this.mdId = mdId; this.checkinId = checkinId; this.roomId = roomId; this.departmentId = departmentId; this.doctorId = doctorId; this.number = number; this.paymentStatus = paymentStatus; this.reason = reason; this.status = status; this.creatorId = creatorId; this.createdAt = createdAt; this.updatedId = updatedId; this.updatedAt = updatedAt; this.mdType = mdType; this.chamberId = chamberId; this.bedId = bedId; this.roomTreatmentId = roomTreatmentId; this.mdIdBefore = mdIdBefore; this.patientInType = patientInType; this.medicCheckin = medicCheckin; this.medicRooms = medicRooms; this.medicRoomsTreatment = medicRoomsTreatment; this.checkinInfo = checkinInfo; this.doctorName = doctorName; this.customerType = customerType; this.diagnosticArray = diagnosticArray; this.diagnosticSubArray = diagnosticSubArray; this.fromResultArray = fromResultArray;
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "md_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getMdId() {
/*  56 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  60 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_id")
/*     */   public Integer getCheckinId() {
/*  66 */     return this.checkinId;
/*     */   }
/*     */   
/*     */   public void setCheckinId(Integer checkinId) {
/*  70 */     this.checkinId = checkinId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  76 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/*  80 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_treatment_id")
/*     */   public Integer getRoomTreatmentId() {
/*  86 */     return this.roomTreatmentId;
/*     */   }
/*     */   
/*     */   public void setRoomTreatmentId(Integer roomTreatmentId) {
/*  90 */     this.roomTreatmentId = roomTreatmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "department_id")
/*     */   public Integer getDepartmentId() {
/*  96 */     return this.departmentId;
/*     */   }
/*     */   
/*     */   public void setDepartmentId(Integer departmentId) {
/* 100 */     this.departmentId = departmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_id")
/*     */   public Integer getDoctorId() {
/* 106 */     return this.doctorId;
/*     */   }
/*     */   
/*     */   public void setDoctorId(Integer doctorId) {
/* 110 */     this.doctorId = doctorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_name")
/*     */   public String getDoctorName() {
/* 116 */     return this.doctorName;
/*     */   }
/*     */   
/*     */   public void setDoctorName(String doctorName) {
/* 120 */     this.doctorName = doctorName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_type")
/*     */   public String getCustomerType() {
/* 126 */     return this.customerType;
/*     */   }
/*     */   
/*     */   public void setCustomerType(String customerType) {
/* 130 */     this.customerType = customerType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_info")
/*     */   public String getCheckinInfo() {
/* 136 */     return this.checkinInfo;
/*     */   }
/*     */   
/*     */   public void setCheckinInfo(String checkinInfo) {
/* 140 */     this.checkinInfo = checkinInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public Integer getNumber() {
/* 146 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/* 150 */     this.number = number;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment_status")
/*     */   public String getPaymentStatus() {
/* 156 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */   public void setPaymentStatus(String paymentStatus) {
/* 160 */     this.paymentStatus = paymentStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 166 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 170 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 176 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 180 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 186 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 190 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 196 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 200 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_id")
/*     */   public Integer getUpdatedId() {
/* 206 */     return this.updatedId;
/*     */   }
/*     */   
/*     */   public void setUpdatedId(Integer updatedId) {
/* 210 */     this.updatedId = updatedId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 216 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 220 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "checkin_id", updatable = false, insertable = false)
/*     */   public MedicCheckin getMedicCheckin() {
/* 226 */     return this.medicCheckin;
/*     */   }
/*     */   
/*     */   public void setMedicCheckin(MedicCheckin medicCheckin) {
/* 230 */     this.medicCheckin = medicCheckin;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "room_id", updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRooms() {
/* 236 */     return this.medicRooms;
/*     */   }
/*     */   
/*     */   public void setMedicRooms(MedicRooms medicRooms) {
/* 240 */     this.medicRooms = medicRooms;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "room_treatment_id", updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRoomsTreatment() {
/* 246 */     return this.medicRoomsTreatment;
/*     */   }
/*     */   
/*     */   public void setMedicRoomsTreatment(MedicRooms medicRoomsTreatment) {
/* 250 */     this.medicRoomsTreatment = medicRoomsTreatment;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_type")
/*     */   public String getMdType() {
/* 256 */     return this.mdType;
/*     */   }
/*     */   
/*     */   public void setMdType(String mdType) {
/* 260 */     this.mdType = mdType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "chamber_id")
/*     */   public Integer getChamberId() {
/* 266 */     return this.chamberId;
/*     */   }
/*     */   
/*     */   public void setChamberId(Integer chamberId) {
/* 270 */     this.chamberId = chamberId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bed_id")
/*     */   public Integer getBedId() {
/* 276 */     return this.bedId;
/*     */   }
/*     */   
/*     */   public void setBedId(Integer bedId) {
/* 280 */     this.bedId = bedId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_in_type")
/*     */   public String getPatientInType() {
/* 286 */     return this.patientInType;
/*     */   }
/*     */   
/*     */   public void setPatientInType(String patientInType) {
/* 290 */     this.patientInType = patientInType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id_before")
/*     */   public Integer getMdIdBefore() {
/* 296 */     return this.mdIdBefore;
/*     */   }
/*     */   
/*     */   public void setMdIdBefore(Integer mdIdBefore) {
/* 300 */     this.mdIdBefore = mdIdBefore;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getDiagnosticArray() {
/* 305 */     return this.diagnosticArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticArray(String diagnosticArray) {
/* 309 */     this.diagnosticArray = diagnosticArray;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getDiagnosticSubArray() {
/* 314 */     return this.diagnosticSubArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticSubArray(String diagnosticSubArray) {
/* 318 */     this.diagnosticSubArray = diagnosticSubArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "from_result_array")
/*     */   public String getFromResultArray() {
/* 324 */     return this.fromResultArray;
/*     */   }
/*     */   
/*     */   public void setFromResultArray(String fromResultArray) {
/* 328 */     this.fromResultArray = fromResultArray;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckinRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */