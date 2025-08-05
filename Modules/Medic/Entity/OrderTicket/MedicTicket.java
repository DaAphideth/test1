/*     */ package nencer.app.Modules.Medic.Entity.OrderTicket;@Entity
/*     */ @Table(name = "medic_ticket")
/*     */ public class MedicTicket { private Integer id; private Integer parentTicketId; private String createdBy; private String ticketType; private Integer createdId; private Integer mdId; @JsonIgnore
/*     */   private MedicCheckinRecord medicCheckinRecord; private Integer serviceGroupCode; private Integer roomId; private String checkinName;
/*     */   private Integer checkinPatientId;
/*     */   private Customers patient;
/*     */   private String code;
/*     */   private Date createdAt;
/*     */   private Date orderDate;
/*     */   private Date updatedAt;
/*     */   private String diagnosticArray;
/*     */   private String diagnosticSubArray;
/*     */   private String medicProductArray;
/*     */   private String barCode;
/*     */   private String roomSampleStatus;
/*     */   private String roomSampleBy;
/*     */   
/*     */   public MedicTicket(Integer id, Integer parentTicketId, String createdBy, String ticketType, Integer createdId, Integer mdId, MedicCheckinRecord medicCheckinRecord, Integer serviceGroupCode, Integer roomId, String checkinName, Integer checkinPatientId, Customers patient, String code, Date createdAt, Date orderDate, Date updatedAt, String diagnosticArray, String diagnosticSubArray, String medicProductArray, String barCode, String roomSampleStatus, String roomSampleBy, Date roomSampleDate, String roomHandleStatus, String roomHandleBy, Date roomHandleDate, Date roomHandleResultDate, String roomHandleResultBy, String status, String chkRadio, Integer roomHandleIds, Integer roomSampleIds, Integer isDeleteSample, Integer isDeleteHandle, Integer isShowSample, Integer isShowHandle, Date orderDateTo, Date orderDateFrom, Integer returnFromTicketId, MedicExamination medicExamination, MedicProductOrder medicProductOrder, MedicRooms medicRoomHandle, MedicRooms medicRoomSample, MedicRooms medicRoom) {
/*  19 */     this.id = id; this.parentTicketId = parentTicketId; this.createdBy = createdBy; this.ticketType = ticketType; this.createdId = createdId; this.mdId = mdId; this.medicCheckinRecord = medicCheckinRecord; this.serviceGroupCode = serviceGroupCode; this.roomId = roomId; this.checkinName = checkinName; this.checkinPatientId = checkinPatientId; this.patient = patient; this.code = code; this.createdAt = createdAt; this.orderDate = orderDate; this.updatedAt = updatedAt; this.diagnosticArray = diagnosticArray; this.diagnosticSubArray = diagnosticSubArray; this.medicProductArray = medicProductArray; this.barCode = barCode; this.roomSampleStatus = roomSampleStatus; this.roomSampleBy = roomSampleBy; this.roomSampleDate = roomSampleDate; this.roomHandleStatus = roomHandleStatus; this.roomHandleBy = roomHandleBy; this.roomHandleDate = roomHandleDate; this.roomHandleResultDate = roomHandleResultDate; this.roomHandleResultBy = roomHandleResultBy; this.status = status; this.chkRadio = chkRadio; this.roomHandleIds = roomHandleIds; this.roomSampleIds = roomSampleIds; this.isDeleteSample = isDeleteSample; this.isDeleteHandle = isDeleteHandle; this.isShowSample = isShowSample; this.isShowHandle = isShowHandle; this.orderDateTo = orderDateTo; this.orderDateFrom = orderDateFrom; this.returnFromTicketId = returnFromTicketId; this.medicExamination = medicExamination; this.medicProductOrder = medicProductOrder; this.medicRoomHandle = medicRoomHandle; this.medicRoomSample = medicRoomSample; this.medicRoom = medicRoom;
/*     */   } private Date roomSampleDate; private String roomHandleStatus; private String roomHandleBy; private Date roomHandleDate; private Date roomHandleResultDate; private String roomHandleResultBy; private String status; private String chkRadio; private Integer roomHandleIds; private Integer roomSampleIds; private Integer isDeleteSample; private Integer isDeleteHandle; private Integer isShowSample; private Integer isShowHandle; private Date orderDateTo; private Date orderDateFrom; private Integer returnFromTicketId; private MedicExamination medicExamination; private MedicProductOrder medicProductOrder; private MedicRooms medicRoomHandle; private MedicRooms medicRoomSample; private MedicRooms medicRoom; public MedicTicket() {} public static MedicTicketBuilder builder() {
/*  21 */     return new MedicTicketBuilder(); } public static class MedicTicketBuilder { private Integer id; private Integer parentTicketId; private String createdBy; private String ticketType; private Integer createdId; private Integer mdId; private MedicCheckinRecord medicCheckinRecord; private Integer serviceGroupCode; private Integer roomId; private String checkinName; private Integer checkinPatientId; private Customers patient; private String code; private Date createdAt; private Date orderDate; private Date updatedAt; private String diagnosticArray; private String diagnosticSubArray; private String medicProductArray; private String barCode; private String roomSampleStatus; private String roomSampleBy; private Date roomSampleDate; private String roomHandleStatus; private String roomHandleBy; private Date roomHandleDate; private Date roomHandleResultDate; private String roomHandleResultBy; private String status; private String chkRadio; private Integer roomHandleIds; private Integer roomSampleIds; private Integer isDeleteSample; private Integer isDeleteHandle; private Integer isShowSample; private Integer isShowHandle; private Date orderDateTo; private Date orderDateFrom; private Integer returnFromTicketId; private MedicExamination medicExamination; private MedicProductOrder medicProductOrder; private MedicRooms medicRoomHandle; private MedicRooms medicRoomSample; private MedicRooms medicRoom; public MedicTicketBuilder id(Integer id) { this.id = id; return this; } public MedicTicketBuilder parentTicketId(Integer parentTicketId) { this.parentTicketId = parentTicketId; return this; } public MedicTicketBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicTicketBuilder ticketType(String ticketType) { this.ticketType = ticketType; return this; } public MedicTicketBuilder createdId(Integer createdId) { this.createdId = createdId; return this; } public MedicTicketBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicTicketBuilder medicCheckinRecord(MedicCheckinRecord medicCheckinRecord) { this.medicCheckinRecord = medicCheckinRecord; return this; } public MedicTicketBuilder serviceGroupCode(Integer serviceGroupCode) { this.serviceGroupCode = serviceGroupCode; return this; } public MedicTicketBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicTicketBuilder checkinName(String checkinName) { this.checkinName = checkinName; return this; } public MedicTicketBuilder checkinPatientId(Integer checkinPatientId) { this.checkinPatientId = checkinPatientId; return this; } public MedicTicketBuilder patient(Customers patient) { this.patient = patient; return this; } public MedicTicketBuilder code(String code) { this.code = code; return this; } public MedicTicketBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicTicketBuilder orderDate(Date orderDate) { this.orderDate = orderDate; return this; } public MedicTicketBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicTicketBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public MedicTicketBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public MedicTicketBuilder medicProductArray(String medicProductArray) { this.medicProductArray = medicProductArray; return this; } public MedicTicketBuilder barCode(String barCode) { this.barCode = barCode; return this; } public MedicTicketBuilder roomSampleStatus(String roomSampleStatus) { this.roomSampleStatus = roomSampleStatus; return this; } public MedicTicketBuilder roomSampleBy(String roomSampleBy) { this.roomSampleBy = roomSampleBy; return this; } public MedicTicketBuilder roomSampleDate(Date roomSampleDate) { this.roomSampleDate = roomSampleDate; return this; } public MedicTicketBuilder roomHandleStatus(String roomHandleStatus) { this.roomHandleStatus = roomHandleStatus; return this; } public MedicTicketBuilder roomHandleBy(String roomHandleBy) { this.roomHandleBy = roomHandleBy; return this; } public MedicTicketBuilder roomHandleDate(Date roomHandleDate) { this.roomHandleDate = roomHandleDate; return this; } public MedicTicketBuilder roomHandleResultDate(Date roomHandleResultDate) { this.roomHandleResultDate = roomHandleResultDate; return this; } public MedicTicketBuilder roomHandleResultBy(String roomHandleResultBy) { this.roomHandleResultBy = roomHandleResultBy; return this; } public MedicTicketBuilder status(String status) { this.status = status; return this; } public MedicTicketBuilder chkRadio(String chkRadio) { this.chkRadio = chkRadio; return this; } public MedicTicketBuilder roomHandleIds(Integer roomHandleIds) { this.roomHandleIds = roomHandleIds; return this; } public MedicTicketBuilder roomSampleIds(Integer roomSampleIds) { this.roomSampleIds = roomSampleIds; return this; } public MedicTicketBuilder isDeleteSample(Integer isDeleteSample) { this.isDeleteSample = isDeleteSample; return this; } public MedicTicketBuilder isDeleteHandle(Integer isDeleteHandle) { this.isDeleteHandle = isDeleteHandle; return this; } public MedicTicketBuilder isShowSample(Integer isShowSample) { this.isShowSample = isShowSample; return this; } public MedicTicketBuilder isShowHandle(Integer isShowHandle) { this.isShowHandle = isShowHandle; return this; } public MedicTicketBuilder orderDateTo(Date orderDateTo) { this.orderDateTo = orderDateTo; return this; } public MedicTicketBuilder orderDateFrom(Date orderDateFrom) { this.orderDateFrom = orderDateFrom; return this; } public MedicTicketBuilder returnFromTicketId(Integer returnFromTicketId) { this.returnFromTicketId = returnFromTicketId; return this; } public MedicTicketBuilder medicExamination(MedicExamination medicExamination) { this.medicExamination = medicExamination; return this; } public MedicTicketBuilder medicProductOrder(MedicProductOrder medicProductOrder) { this.medicProductOrder = medicProductOrder; return this; } public MedicTicketBuilder medicRoomHandle(MedicRooms medicRoomHandle) { this.medicRoomHandle = medicRoomHandle; return this; } public MedicTicketBuilder medicRoomSample(MedicRooms medicRoomSample) { this.medicRoomSample = medicRoomSample; return this; } public MedicTicketBuilder medicRoom(MedicRooms medicRoom) { this.medicRoom = medicRoom; return this; } public MedicTicket build() { return new MedicTicket(this.id, this.parentTicketId, this.createdBy, this.ticketType, this.createdId, this.mdId, this.medicCheckinRecord, this.serviceGroupCode, this.roomId, this.checkinName, this.checkinPatientId, this.patient, this.code, this.createdAt, this.orderDate, this.updatedAt, this.diagnosticArray, this.diagnosticSubArray, this.medicProductArray, this.barCode, this.roomSampleStatus, this.roomSampleBy, this.roomSampleDate, this.roomHandleStatus, this.roomHandleBy, this.roomHandleDate, this.roomHandleResultDate, this.roomHandleResultBy, this.status, this.chkRadio, this.roomHandleIds, this.roomSampleIds, this.isDeleteSample, this.isDeleteHandle, this.isShowSample, this.isShowHandle, this.orderDateTo, this.orderDateFrom, this.returnFromTicketId, this.medicExamination, this.medicProductOrder, this.medicRoomHandle, this.medicRoomSample, this.medicRoom); } public String toString() { return "MedicTicket.MedicTicketBuilder(id=" + this.id + ", parentTicketId=" + this.parentTicketId + ", createdBy=" + this.createdBy + ", ticketType=" + this.ticketType + ", createdId=" + this.createdId + ", mdId=" + this.mdId + ", medicCheckinRecord=" + this.medicCheckinRecord + ", serviceGroupCode=" + this.serviceGroupCode + ", roomId=" + this.roomId + ", checkinName=" + this.checkinName + ", checkinPatientId=" + this.checkinPatientId + ", patient=" + this.patient + ", code=" + this.code + ", createdAt=" + this.createdAt + ", orderDate=" + this.orderDate + ", updatedAt=" + this.updatedAt + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", medicProductArray=" + this.medicProductArray + ", barCode=" + this.barCode + ", roomSampleStatus=" + this.roomSampleStatus + ", roomSampleBy=" + this.roomSampleBy + ", roomSampleDate=" + this.roomSampleDate + ", roomHandleStatus=" + this.roomHandleStatus + ", roomHandleBy=" + this.roomHandleBy + ", roomHandleDate=" + this.roomHandleDate + ", roomHandleResultDate=" + this.roomHandleResultDate + ", roomHandleResultBy=" + this.roomHandleResultBy + ", status=" + this.status + ", chkRadio=" + this.chkRadio + ", roomHandleIds=" + this.roomHandleIds + ", roomSampleIds=" + this.roomSampleIds + ", isDeleteSample=" + this.isDeleteSample + ", isDeleteHandle=" + this.isDeleteHandle + ", isShowSample=" + this.isShowSample + ", isShowHandle=" + this.isShowHandle + ", orderDateTo=" + this.orderDateTo + ", orderDateFrom=" + this.orderDateFrom + ", returnFromTicketId=" + this.returnFromTicketId + ", medicExamination=" + this.medicExamination + ", medicProductOrder=" + this.medicProductOrder + ", medicRoomHandle=" + this.medicRoomHandle + ", medicRoomSample=" + this.medicRoomSample + ", medicRoom=" + this.medicRoom + ")"; }
/*     */      }
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
/*     */   @Basic
/*     */   @Column(name = "is_delete_handle")
/*     */   public Integer getIsDeleteHandle() {
/*  77 */     return this.isDeleteHandle;
/*     */   }
/*     */   
/*     */   public void setIsDeleteHandle(Integer isDeleteHandle) {
/*  81 */     this.isDeleteHandle = isDeleteHandle;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_show_handle")
/*     */   public Integer getIsShowHandle() {
/*  87 */     return this.isShowHandle;
/*     */   }
/*     */   
/*     */   public void setIsShowHandle(Integer isShowHandle) {
/*  91 */     this.isShowHandle = isShowHandle;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_delete_sample")
/*     */   public Integer getIsDeleteSample() {
/*  97 */     return this.isDeleteSample;
/*     */   }
/*     */   
/*     */   public void setIsDeleteSample(Integer isDeleteSample) {
/* 101 */     this.isDeleteSample = isDeleteSample;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_show_sample")
/*     */   public Integer getIsShowSample() {
/* 107 */     return this.isShowSample;
/*     */   }
/*     */   
/*     */   public void setIsShowSample(Integer isShowSample) {
/* 111 */     this.isShowSample = isShowSample;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_patient_id")
/*     */   public Integer getCheckinPatientId() {
/* 117 */     return this.checkinPatientId;
/*     */   }
/*     */   
/*     */   public void setCheckinPatientId(Integer checkinPatientId) {
/* 121 */     this.checkinPatientId = checkinPatientId;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public MedicRooms getMedicRoom() {
/* 126 */     return this.medicRoom;
/*     */   }
/*     */   
/*     */   public void setMedicRoom(MedicRooms medicRoom) {
/* 130 */     this.medicRoom = medicRoom;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_ids")
/*     */   public Integer getRoomHandleIds() {
/* 136 */     return this.roomHandleIds;
/*     */   }
/*     */   
/*     */   public void setRoomHandleIds(Integer roomHandleIds) {
/* 140 */     this.roomHandleIds = roomHandleIds;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_ids")
/*     */   public Integer getRoomSampleIds() {
/* 146 */     return this.roomSampleIds;
/*     */   }
/*     */   
/*     */   public void setRoomSampleIds(Integer roomSampleIds) {
/* 150 */     this.roomSampleIds = roomSampleIds;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_by")
/*     */   public String getRoomHandleBy() {
/* 156 */     return this.roomHandleBy;
/*     */   }
/*     */   
/*     */   public void setRoomHandleBy(String roomHandleBy) {
/* 160 */     this.roomHandleBy = roomHandleBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_date")
/*     */   public Date getRoomHandleDate() {
/* 166 */     return this.roomHandleDate;
/*     */   }
/*     */   
/*     */   public void setRoomHandleDate(Date roomHandleDate) {
/* 170 */     this.roomHandleDate = roomHandleDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_by")
/*     */   public String getRoomSampleBy() {
/* 176 */     return this.roomSampleBy;
/*     */   }
/*     */   
/*     */   public void setRoomSampleBy(String roomSampleBy) {
/* 180 */     this.roomSampleBy = roomSampleBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_date")
/*     */   public Date getRoomSampleDate() {
/* 186 */     return this.roomSampleDate;
/*     */   }
/*     */   
/*     */   public void setRoomSampleDate(Date roomSampleDate) {
/* 190 */     this.roomSampleDate = roomSampleDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_result_date")
/*     */   public Date getRoomHandleResultDate() {
/* 196 */     return this.roomHandleResultDate;
/*     */   }
/*     */   
/*     */   public void setRoomHandleResultDate(Date roomHandleResultDate) {
/* 200 */     this.roomHandleResultDate = roomHandleResultDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_result_by")
/*     */   public String getRoomHandleResultBy() {
/* 206 */     return this.roomHandleResultBy;
/*     */   }
/*     */   
/*     */   public void setRoomHandleResultBy(String roomHandleResultBy) {
/* 210 */     this.roomHandleResultBy = roomHandleResultBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 216 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 220 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "chk_radio")
/*     */   public String getChkRadio() {
/* 226 */     return this.chkRadio;
/*     */   }
/*     */   
/*     */   public void setChkRadio(String chkRadio) {
/* 230 */     this.chkRadio = chkRadio;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_type")
/*     */   public String getTicketType() {
/* 236 */     return this.ticketType;
/*     */   }
/*     */   
/*     */   public void setTicketType(String ticketType) {
/* 240 */     this.ticketType = ticketType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_status")
/*     */   public String getRoomHandleStatus() {
/* 246 */     return this.roomHandleStatus;
/*     */   }
/*     */   
/*     */   public void setRoomHandleStatus(String roomHandleStatus) {
/* 250 */     this.roomHandleStatus = roomHandleStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_status")
/*     */   public String getRoomSampleStatus() {
/* 256 */     return this.roomSampleStatus;
/*     */   }
/*     */   
/*     */   public void setRoomSampleStatus(String roomSampleStatus) {
/* 260 */     this.roomSampleStatus = roomSampleStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bar_code")
/*     */   public String getBarCode() {
/* 266 */     return this.barCode;
/*     */   }
/*     */   
/*     */   public void setBarCode(String barCode) {
/* 270 */     this.barCode = barCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "medic_product_array")
/*     */   public String getMedicProductArray() {
/* 276 */     return this.medicProductArray;
/*     */   }
/*     */   
/*     */   public void setMedicProductArray(String medicProductArray) {
/* 280 */     this.medicProductArray = medicProductArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_name")
/*     */   public String getCheckinName() {
/* 286 */     return this.checkinName;
/*     */   }
/*     */   
/*     */   public void setCheckinName(String checkinName) {
/* 290 */     this.checkinName = checkinName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/* 296 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 300 */     this.code = code;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_code")
/*     */   public Integer getServiceGroupCode() {
/* 307 */     return this.serviceGroupCode;
/*     */   }
/*     */   
/*     */   public void setServiceGroupCode(Integer serviceGroupCode) {
/* 311 */     this.serviceGroupCode = serviceGroupCode;
/*     */   }
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/* 318 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/* 322 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/* 328 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/* 332 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_by")
/*     */   public String getCreatedBy() {
/* 338 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/* 342 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/* 348 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/* 352 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 358 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 362 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_date")
/*     */   public Date getOrderDate() {
/* 368 */     return this.orderDate;
/*     */   }
/*     */   
/*     */   public void setOrderDate(Date orderDate) {
/* 372 */     this.orderDate = orderDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 378 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 382 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_id")
/*     */   public Integer getCreatedId() {
/* 388 */     return this.createdId;
/*     */   }
/*     */   
/*     */   public void setCreatedId(Integer createdId) {
/* 392 */     this.createdId = createdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_array")
/*     */   public String getDiagnosticArray() {
/* 398 */     return this.diagnosticArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticArray(String diagnosticArray) {
/* 402 */     this.diagnosticArray = diagnosticArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_sub_array")
/*     */   public String getDiagnosticSubArray() {
/* 408 */     return this.diagnosticSubArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticSubArray(String diagnosticSubArray) {
/* 412 */     this.diagnosticSubArray = diagnosticSubArray;
/*     */   }
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id", referencedColumnName = "ticket_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicProductOrder getMedicProductOrder() {
/* 419 */     return this.medicProductOrder;
/*     */   }
/*     */   
/*     */   public void setMedicProductOrder(MedicProductOrder medicProductOrder) {
/* 423 */     this.medicProductOrder = medicProductOrder;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "md_id", updatable = false, insertable = false)
/*     */   public MedicCheckinRecord getMedicCheckinRecord() {
/* 429 */     return this.medicCheckinRecord;
/*     */   }
/*     */   
/*     */   public void setMedicCheckinRecord(MedicCheckinRecord medicCheckinRecord) {
/* 433 */     this.medicCheckinRecord = medicCheckinRecord;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "parent_ticket_id")
/*     */   public Integer getParentTicketId() {
/* 439 */     return this.parentTicketId;
/*     */   }
/*     */   
/*     */   public void setParentTicketId(Integer parentTicketId) {
/* 443 */     this.parentTicketId = parentTicketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_date_to")
/*     */   public Date getOrderDateTo() {
/* 449 */     return this.orderDateTo;
/*     */   }
/*     */   
/*     */   public void setOrderDateTo(Date orderDateTo) {
/* 453 */     this.orderDateTo = orderDateTo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_date_from")
/*     */   public Date getOrderDateFrom() {
/* 459 */     return this.orderDateFrom;
/*     */   }
/*     */   
/*     */   public void setOrderDateFrom(Date orderDateFrom) {
/* 463 */     this.orderDateFrom = orderDateFrom;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "checkin_patient_id", nullable = true, updatable = false, insertable = false)
/*     */   public Customers getPatient() {
/* 469 */     return this.patient;
/*     */   }
/*     */   
/*     */   public void setPatient(Customers patient) {
/* 473 */     this.patient = patient;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "md_id", referencedColumnName = "md_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicExamination getMedicExamination() {
/* 479 */     return this.medicExamination;
/*     */   }
/*     */   
/*     */   public void setMedicExamination(MedicExamination medicExamination) {
/* 483 */     this.medicExamination = medicExamination;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "room_handle_ids", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRoomHandle() {
/* 489 */     return this.medicRoomHandle;
/*     */   }
/*     */   
/*     */   public void setMedicRoomHandle(MedicRooms medicRoomHandle) {
/* 493 */     this.medicRoomHandle = medicRoomHandle;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "room_sample_ids", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRoomSample() {
/* 499 */     return this.medicRoomSample;
/*     */   }
/*     */   
/*     */   public void setMedicRoomSample(MedicRooms medicRoomSample) {
/* 503 */     this.medicRoomSample = medicRoomSample;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "return_from_ticket_id")
/*     */   public Integer getReturnFromTicketId() {
/* 509 */     return this.returnFromTicketId;
/*     */   }
/*     */   
/*     */   public void setReturnFromTicketId(Integer returnFromTicketId) {
/* 513 */     this.returnFromTicketId = returnFromTicketId;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderTicket\MedicTicket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */