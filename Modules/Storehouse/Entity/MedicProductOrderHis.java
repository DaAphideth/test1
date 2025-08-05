/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_product_order_his")
/*     */ @JsonIgnoreProperties(ignoreUnknown = true)
/*     */ public class MedicProductOrderHis
/*     */ {
/*     */   private Integer id;
/*     */   private Integer orderId;
/*     */   private String code;
/*     */   private Integer ticketId;
/*     */   private Integer supplierId;
/*     */   private Integer storehouseId;
/*     */   private Integer storehouseFromId;
/*     */   private Integer roomId;
/*     */   private Integer customerId;
/*     */   private String orderType;
/*     */   private String productSrc;
/*     */   private Date approvalDate;
/*     */   private Integer approvalId;
/*     */   private Date exportDate;
/*     */   private Date importDate;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  48 */     return this.id;
/*     */   }
/*     */   private String description; private String note; private String reason; private String orderStatus; private String status; private Integer creatorId; private String updaterId; private Date createdAt; private Date updatedAt; private String groupOrderType; private String receiver; private String deliver; private Date orderDate; private String productEvenSrc; private Integer fundLogId;
/*     */   public void setId(Integer id) {
/*  52 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_id")
/*     */   public Integer getOrderId() {
/*  58 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Integer orderId) {
/*  62 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  68 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  72 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_id")
/*     */   public Integer getTicketId() {
/*  78 */     return this.ticketId;
/*     */   }
/*     */   
/*     */   public void setTicketId(Integer ticketId) {
/*  82 */     this.ticketId = ticketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "supplier_id")
/*     */   public Integer getSupplierId() {
/*  88 */     return this.supplierId;
/*     */   }
/*     */   
/*     */   public void setSupplierId(Integer supplierId) {
/*  92 */     this.supplierId = supplierId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_id")
/*     */   public Integer getStorehouseId() {
/*  98 */     return this.storehouseId;
/*     */   }
/*     */   
/*     */   public void setStorehouseId(Integer storehouseId) {
/* 102 */     this.storehouseId = storehouseId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_from_id")
/*     */   public Integer getStorehouseFromId() {
/* 108 */     return this.storehouseFromId;
/*     */   }
/*     */   
/*     */   public void setStorehouseFromId(Integer storehouseFromId) {
/* 112 */     this.storehouseFromId = storehouseFromId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/* 118 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/* 122 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/* 128 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/* 132 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_type")
/*     */   public String getOrderType() {
/* 138 */     return this.orderType;
/*     */   }
/*     */   
/*     */   public void setOrderType(String orderType) {
/* 142 */     this.orderType = orderType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_src")
/*     */   public String getProductSrc() {
/* 148 */     return this.productSrc;
/*     */   }
/*     */   
/*     */   public void setProductSrc(String productSrc) {
/* 152 */     this.productSrc = productSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "approval_date")
/*     */   public Date getApprovalDate() {
/* 158 */     return this.approvalDate;
/*     */   }
/*     */   
/*     */   public void setApprovalDate(Date approvalDate) {
/* 162 */     this.approvalDate = approvalDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "export_date")
/*     */   public Date getExportDate() {
/* 168 */     return this.exportDate;
/*     */   }
/*     */   
/*     */   public void setExportDate(Date exportDate) {
/* 172 */     this.exportDate = exportDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "import_date")
/*     */   public Date getImportDate() {
/* 178 */     return this.importDate;
/*     */   }
/*     */   
/*     */   public void setImportDate(Date importDate) {
/* 182 */     this.importDate = importDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 188 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 192 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/* 198 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 202 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 208 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 212 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_status")
/*     */   public String getOrderStatus() {
/* 218 */     return this.orderStatus;
/*     */   }
/*     */   
/*     */   public void setOrderStatus(String orderStatus) {
/* 222 */     this.orderStatus = orderStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 228 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 232 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 238 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 242 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 248 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 252 */     this.updaterId = updaterId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 258 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 262 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 268 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 272 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "group_order_type")
/*     */   public String getGroupOrderType() {
/* 278 */     return this.groupOrderType;
/*     */   }
/*     */   
/*     */   public void setGroupOrderType(String groupOrderType) {
/* 282 */     this.groupOrderType = groupOrderType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "receiver")
/*     */   public String getReceiver() {
/* 288 */     return this.receiver;
/*     */   }
/*     */   
/*     */   public void setReceiver(String receiver) {
/* 292 */     this.receiver = receiver;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "deliver")
/*     */   public String getDeliver() {
/* 298 */     return this.deliver;
/*     */   }
/*     */   
/*     */   public void setDeliver(String deliver) {
/* 302 */     this.deliver = deliver;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_date")
/*     */   public Date getOrderDate() {
/* 308 */     return this.orderDate;
/*     */   }
/*     */   
/*     */   public void setOrderDate(Date orderDate) {
/* 312 */     this.orderDate = orderDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_even_src")
/*     */   public String getProductEvenSrc() {
/* 318 */     return this.productEvenSrc;
/*     */   }
/*     */   
/*     */   public void setProductEvenSrc(String productEvenSrc) {
/* 322 */     this.productEvenSrc = productEvenSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fund_log_id")
/*     */   public Integer getFundLogId() {
/* 328 */     return this.fundLogId;
/*     */   }
/*     */   
/*     */   public void setFundLogId(Integer fundLogId) {
/* 332 */     this.fundLogId = fundLogId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "approval_id")
/*     */   public Integer getApprovalId() {
/* 338 */     return this.approvalId;
/*     */   }
/*     */   
/*     */   public void setApprovalId(Integer approvalId) {
/* 342 */     this.approvalId = approvalId;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductOrderHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */