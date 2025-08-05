/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ @Entity
/*     */ @JsonIgnoreProperties(ignoreUnknown = true)
/*     */ @Table(name = "medic_product_order")
/*     */ public class MedicProductOrder implements Serializable { private Integer id; private String code; private Integer supplierId; @NotNull(message = "804")
/*     */   private Integer storehouseId; private Integer storehouseFromId; private Integer roomId; private Integer departmentId; private Integer customerId; @NotNull(message = "804")
/*     */   private String orderType;
/*     */   @Pattern(regexp = "XK|NK", message = "Nhom loai don khong hop le")
/*     */   private String groupOrderType;
/*     */   private String productSrc;
/*     */   private String productEvenSrc;
/*     */   private Date approvalDate;
/*     */   private Integer approvalId;
/*     */   private Date exportDate;
/*     */   private Date importDate;
/*     */   
/*  17 */   public static MedicProductOrderBuilder builder() { return new MedicProductOrderBuilder(); } private Date orderDate; private String description; private String note; private String reason; @Pattern(regexp = "DNK|DXK|CD|DD|PN|PH|PDTH", message = "Trang thai khong hop le") private String orderStatus; private String status; private Integer creatorId; private String updaterId; private Date createdAt; private Date updatedAt; private String deliver; private String receiver; private Integer fundLogId; private Integer ticketId; private Set<MedicProductOrderDetail> medicProductOrderDetails; private MedicProductStorehouse medicProductStorehouse; public static class MedicProductOrderBuilder { private Integer id; private String code; private Integer supplierId; private Integer storehouseId; private Integer storehouseFromId; private Integer roomId; private Integer departmentId; private Integer customerId; private String orderType; private String groupOrderType; private String productSrc; private String productEvenSrc; private Date approvalDate; private Integer approvalId; private Date exportDate; private Date importDate; private Date orderDate; private String description; private String note; private String reason; private String orderStatus; private String status; private Integer creatorId; private String updaterId; private Date createdAt; private Date updatedAt; private String deliver; private String receiver; private Integer fundLogId; private Integer ticketId; private Set<MedicProductOrderDetail> medicProductOrderDetails; private MedicProductStorehouse medicProductStorehouse; public MedicProductOrderBuilder id(Integer id) { this.id = id; return this; } public MedicProductOrderBuilder code(String code) { this.code = code; return this; } public MedicProductOrderBuilder supplierId(Integer supplierId) { this.supplierId = supplierId; return this; } public MedicProductOrderBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicProductOrderBuilder storehouseFromId(Integer storehouseFromId) { this.storehouseFromId = storehouseFromId; return this; } public MedicProductOrderBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicProductOrderBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicProductOrderBuilder customerId(Integer customerId) { this.customerId = customerId; return this; } public MedicProductOrderBuilder orderType(String orderType) { this.orderType = orderType; return this; } public MedicProductOrderBuilder groupOrderType(String groupOrderType) { this.groupOrderType = groupOrderType; return this; } public MedicProductOrderBuilder productSrc(String productSrc) { this.productSrc = productSrc; return this; } public MedicProductOrderBuilder productEvenSrc(String productEvenSrc) { this.productEvenSrc = productEvenSrc; return this; } public MedicProductOrderBuilder approvalDate(Date approvalDate) { this.approvalDate = approvalDate; return this; } public MedicProductOrderBuilder approvalId(Integer approvalId) { this.approvalId = approvalId; return this; } public MedicProductOrderBuilder exportDate(Date exportDate) { this.exportDate = exportDate; return this; } public MedicProductOrderBuilder importDate(Date importDate) { this.importDate = importDate; return this; } public MedicProductOrderBuilder orderDate(Date orderDate) { this.orderDate = orderDate; return this; } public MedicProductOrderBuilder description(String description) { this.description = description; return this; } public MedicProductOrderBuilder note(String note) { this.note = note; return this; } public MedicProductOrderBuilder reason(String reason) { this.reason = reason; return this; } public MedicProductOrderBuilder orderStatus(String orderStatus) { this.orderStatus = orderStatus; return this; } public MedicProductOrderBuilder status(String status) { this.status = status; return this; } public MedicProductOrderBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public MedicProductOrderBuilder updaterId(String updaterId) { this.updaterId = updaterId; return this; } public MedicProductOrderBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicProductOrderBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicProductOrderBuilder deliver(String deliver) { this.deliver = deliver; return this; } public MedicProductOrderBuilder receiver(String receiver) { this.receiver = receiver; return this; } public MedicProductOrderBuilder fundLogId(Integer fundLogId) { this.fundLogId = fundLogId; return this; } public MedicProductOrderBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicProductOrderBuilder medicProductOrderDetails(Set<MedicProductOrderDetail> medicProductOrderDetails) { this.medicProductOrderDetails = medicProductOrderDetails; return this; } public MedicProductOrderBuilder medicProductStorehouse(MedicProductStorehouse medicProductStorehouse) { this.medicProductStorehouse = medicProductStorehouse; return this; } public MedicProductOrder build() { return new MedicProductOrder(this.id, this.code, this.supplierId, this.storehouseId, this.storehouseFromId, this.roomId, this.departmentId, this.customerId, this.orderType, this.groupOrderType, this.productSrc, this.productEvenSrc, this.approvalDate, this.approvalId, this.exportDate, this.importDate, this.orderDate, this.description, this.note, this.reason, this.orderStatus, this.status, this.creatorId, this.updaterId, this.createdAt, this.updatedAt, this.deliver, this.receiver, this.fundLogId, this.ticketId, this.medicProductOrderDetails, this.medicProductStorehouse); } public String toString() { return "MedicProductOrder.MedicProductOrderBuilder(id=" + this.id + ", code=" + this.code + ", supplierId=" + this.supplierId + ", storehouseId=" + this.storehouseId + ", storehouseFromId=" + this.storehouseFromId + ", roomId=" + this.roomId + ", departmentId=" + this.departmentId + ", customerId=" + this.customerId + ", orderType=" + this.orderType + ", groupOrderType=" + this.groupOrderType + ", productSrc=" + this.productSrc + ", productEvenSrc=" + this.productEvenSrc + ", approvalDate=" + this.approvalDate + ", approvalId=" + this.approvalId + ", exportDate=" + this.exportDate + ", importDate=" + this.importDate + ", orderDate=" + this.orderDate + ", description=" + this.description + ", note=" + this.note + ", reason=" + this.reason + ", orderStatus=" + this.orderStatus + ", status=" + this.status + ", creatorId=" + this.creatorId + ", updaterId=" + this.updaterId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deliver=" + this.deliver + ", receiver=" + this.receiver + ", fundLogId=" + this.fundLogId + ", ticketId=" + this.ticketId + ", medicProductOrderDetails=" + this.medicProductOrderDetails + ", medicProductStorehouse=" + this.medicProductStorehouse + ")"; } } public MedicProductOrder(Integer id, String code, Integer supplierId, Integer storehouseId, Integer storehouseFromId, Integer roomId, Integer departmentId, Integer customerId, String orderType, String groupOrderType, String productSrc, String productEvenSrc, Date approvalDate, Integer approvalId, Date exportDate, Date importDate, Date orderDate, String description, String note, String reason, String orderStatus, String status, Integer creatorId, String updaterId, Date createdAt, Date updatedAt, String deliver, String receiver, Integer fundLogId, Integer ticketId, Set<MedicProductOrderDetail> medicProductOrderDetails, MedicProductStorehouse medicProductStorehouse) {
/*  18 */     this.id = id; this.code = code; this.supplierId = supplierId; this.storehouseId = storehouseId; this.storehouseFromId = storehouseFromId; this.roomId = roomId; this.departmentId = departmentId; this.customerId = customerId; this.orderType = orderType; this.groupOrderType = groupOrderType; this.productSrc = productSrc; this.productEvenSrc = productEvenSrc; this.approvalDate = approvalDate; this.approvalId = approvalId; this.exportDate = exportDate; this.importDate = importDate; this.orderDate = orderDate; this.description = description; this.note = note; this.reason = reason; this.orderStatus = orderStatus; this.status = status; this.creatorId = creatorId; this.updaterId = updaterId; this.createdAt = createdAt; this.updatedAt = updatedAt; this.deliver = deliver; this.receiver = receiver; this.fundLogId = fundLogId; this.ticketId = ticketId; this.medicProductOrderDetails = medicProductOrderDetails; this.medicProductStorehouse = medicProductStorehouse;
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
/*     */   public MedicProductOrder() {}
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
/*     */   @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
/*     */   @JoinColumn(name = "order_id")
/*     */   public Set<MedicProductOrderDetail> getMedicProductOrderDetails() {
/*  65 */     return this.medicProductOrderDetails;
/*     */   }
/*     */   
/*     */   public void setMedicProductOrderDetails(Set<MedicProductOrderDetail> medicProductOrderDetails) {
/*  69 */     this.medicProductOrderDetails = medicProductOrderDetails;
/*     */   }
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_id")
/*     */   public Integer getTicketId() {
/*  86 */     return this.ticketId;
/*     */   }
/*     */   
/*     */   public void setTicketId(Integer ticketId) {
/*  90 */     this.ticketId = ticketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   @ColumnDefault("random_uuid()")
/*     */   public String getCode() {
/*  97 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 101 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "supplier_id")
/*     */   public Integer getSupplierId() {
/* 107 */     return this.supplierId;
/*     */   }
/*     */   
/*     */   public void setSupplierId(Integer supplierId) {
/* 111 */     this.supplierId = supplierId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_id")
/*     */   public Integer getStorehouseId() {
/* 117 */     return this.storehouseId;
/*     */   }
/*     */   
/*     */   public void setStorehouseId(Integer storehouseId) {
/* 121 */     this.storehouseId = storehouseId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_from_id")
/*     */   public Integer getStorehouseFromId() {
/* 127 */     return this.storehouseFromId;
/*     */   }
/*     */   
/*     */   public void setStorehouseFromId(Integer storehouseFromId) {
/* 131 */     this.storehouseFromId = storehouseFromId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/* 137 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/* 141 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "department_id")
/*     */   public Integer getDepartmentId() {
/* 147 */     return this.departmentId;
/*     */   }
/*     */   
/*     */   public void setDepartmentId(Integer departmentId) {
/* 151 */     this.departmentId = departmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/* 157 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/* 161 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_type")
/*     */   public String getOrderType() {
/* 167 */     return this.orderType;
/*     */   }
/*     */   
/*     */   public void setOrderType(String orderType) {
/* 171 */     this.orderType = orderType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "group_order_type")
/*     */   public String getGroupOrderType() {
/* 177 */     return this.groupOrderType;
/*     */   }
/*     */   
/*     */   public void setGroupOrderType(String groupOrderType) {
/* 181 */     this.groupOrderType = groupOrderType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_src")
/*     */   public String getProductSrc() {
/* 187 */     return this.productSrc;
/*     */   }
/*     */   
/*     */   public void setProductSrc(String productSrc) {
/* 191 */     this.productSrc = productSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_even_src")
/*     */   public String getProductEvenSrc() {
/* 197 */     return this.productEvenSrc;
/*     */   }
/*     */   
/*     */   public void setProductEvenSrc(String productEvenSrc) {
/* 201 */     this.productEvenSrc = productEvenSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "approval_date")
/*     */   public Date getApprovalDate() {
/* 207 */     return this.approvalDate;
/*     */   }
/*     */   
/*     */   public void setApprovalDate(Date approvalDate) {
/* 211 */     this.approvalDate = approvalDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "approval_id")
/*     */   public Integer getApprovalId() {
/* 217 */     return this.approvalId;
/*     */   }
/*     */   
/*     */   public void setApprovalId(Integer approvalId) {
/* 221 */     this.approvalId = approvalId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "export_date")
/*     */   public Date getExportDate() {
/* 227 */     return this.exportDate;
/*     */   }
/*     */   
/*     */   public void setExportDate(Date exportDate) {
/* 231 */     this.exportDate = exportDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "import_date")
/*     */   public Date getImportDate() {
/* 237 */     return this.importDate;
/*     */   }
/*     */   
/*     */   public void setImportDate(Date importDate) {
/* 241 */     this.importDate = importDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 247 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 251 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/* 257 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 261 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 267 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 271 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_status")
/*     */   public String getOrderStatus() {
/* 277 */     return this.orderStatus;
/*     */   }
/*     */   
/*     */   public void setOrderStatus(String orderStatus) {
/* 281 */     this.orderStatus = orderStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status", columnDefinition = "UNPAID")
/*     */   public String getStatus() {
/* 287 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 291 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 297 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 301 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 307 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 311 */     this.updaterId = updaterId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 317 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 321 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 327 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 331 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_date")
/*     */   public Date getOrderDate() {
/* 337 */     return this.orderDate;
/*     */   }
/*     */   
/*     */   public void setOrderDate(Date orderDate) {
/* 341 */     this.orderDate = orderDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "deliver")
/*     */   public String getDeliver() {
/* 347 */     return this.deliver;
/*     */   }
/*     */   
/*     */   public void setDeliver(String deliver) {
/* 351 */     this.deliver = deliver;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "receiver")
/*     */   public String getReceiver() {
/* 358 */     return this.receiver;
/*     */   }
/*     */   
/*     */   public void setReceiver(String receiver) {
/* 362 */     this.receiver = receiver;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "storehouse_id", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicProductStorehouse getMedicProductStorehouse() {
/* 370 */     return this.medicProductStorehouse;
/*     */   }
/*     */   
/*     */   public void setMedicProductStorehouse(MedicProductStorehouse medicProductStorehouse) {
/* 374 */     this.medicProductStorehouse = medicProductStorehouse;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fund_log_id")
/*     */   public Integer getFundLogId() {
/* 380 */     return this.fundLogId;
/*     */   }
/*     */   
/*     */   public void setFundLogId(Integer fundLogId) {
/* 384 */     this.fundLogId = fundLogId;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */