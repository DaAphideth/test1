/*     */ package nencer.app.Modules.Medic.Entity.OrderService;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_order_services_his")
/*     */ public class MedicOrderServicesHis
/*     */ {
/*     */   private Integer id;
/*     */   private Integer orderServiceId;
/*     */   private Integer parentId;
/*     */   private String orderCode;
/*     */   private Integer ticketId;
/*     */   private Integer roomHandleId;
/*     */   private Integer roomSampleId;
/*     */   private Integer creatorId;
/*     */   private Integer mdId;
/*     */   private Integer customerId;
/*     */   private Integer fundLogId;
/*     */   private Integer serviceId;
/*     */   private Integer serviceGroupId;
/*     */   private String serviceCode;
/*     */   private String serviceName;
/*     */   private Integer qty;
/*     */   private String unit;
/*     */   private Integer unitId;
/*     */   private Double price;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  52 */     return this.id;
/*     */   }
/*     */   private Double payAmount; private Double totalAmount; private Double insurancePay; private String currencyCode; private String payment; private String status; private String paygateCode; private Integer payeeId; private Date createdAt; private Date updatedAt; private String lisHandlerResult; private String lisDeviceResult; private String risResult; private String risFinish; private String risResultBy; private String risDevice; private String risStatus; private Date risResultDate; private String machine;
/*     */   public void setId(Integer id) {
/*  56 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_service_id")
/*     */   public Integer getOrderServiceId() {
/*  62 */     return this.orderServiceId;
/*     */   }
/*     */   
/*     */   public void setOrderServiceId(Integer orderServiceId) {
/*  66 */     this.orderServiceId = orderServiceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "parent_id")
/*     */   public Integer getParentId() {
/*  72 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(Integer parentId) {
/*  76 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_code")
/*     */   public String getOrderCode() {
/*  82 */     return this.orderCode;
/*     */   }
/*     */   
/*     */   public void setOrderCode(String orderCode) {
/*  86 */     this.orderCode = orderCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_id")
/*     */   public Integer getTicketId() {
/*  92 */     return this.ticketId;
/*     */   }
/*     */   
/*     */   public void setTicketId(Integer ticketId) {
/*  96 */     this.ticketId = ticketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_id")
/*     */   public Integer getRoomHandleId() {
/* 102 */     return this.roomHandleId;
/*     */   }
/*     */   
/*     */   public void setRoomHandleId(Integer roomHandleId) {
/* 106 */     this.roomHandleId = roomHandleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_id")
/*     */   public Integer getRoomSampleId() {
/* 112 */     return this.roomSampleId;
/*     */   }
/*     */   
/*     */   public void setRoomSampleId(Integer roomSampleId) {
/* 116 */     this.roomSampleId = roomSampleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 122 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 126 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/* 132 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/* 136 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/* 142 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/* 146 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fund_log_id")
/*     */   public Integer getFundLogId() {
/* 152 */     return this.fundLogId;
/*     */   }
/*     */   
/*     */   public void setFundLogId(Integer fundLogId) {
/* 156 */     this.fundLogId = fundLogId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public Integer getServiceId() {
/* 162 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/* 166 */     this.serviceId = serviceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_id")
/*     */   public Integer getServiceGroupId() {
/* 172 */     return this.serviceGroupId;
/*     */   }
/*     */   
/*     */   public void setServiceGroupId(Integer serviceGroupId) {
/* 176 */     this.serviceGroupId = serviceGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_code")
/*     */   public String getServiceCode() {
/* 182 */     return this.serviceCode;
/*     */   }
/*     */   
/*     */   public void setServiceCode(String serviceCode) {
/* 186 */     this.serviceCode = serviceCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_name")
/*     */   public String getServiceName() {
/* 192 */     return this.serviceName;
/*     */   }
/*     */   
/*     */   public void setServiceName(String serviceName) {
/* 196 */     this.serviceName = serviceName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "qty")
/*     */   public Integer getQty() {
/* 202 */     return this.qty;
/*     */   }
/*     */   
/*     */   public void setQty(Integer qty) {
/* 206 */     this.qty = qty;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit")
/*     */   public String getUnit() {
/* 212 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/* 216 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/* 222 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/* 226 */     this.unitId = unitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public Double getPrice() {
/* 232 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 236 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "pay_amount")
/*     */   public Double getPayAmount() {
/* 242 */     return this.payAmount;
/*     */   }
/*     */   
/*     */   public void setPayAmount(Double payAmount) {
/* 246 */     this.payAmount = payAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "total_amount")
/*     */   public Double getTotalAmount() {
/* 252 */     return this.totalAmount;
/*     */   }
/*     */   
/*     */   public void setTotalAmount(Double totalAmount) {
/* 256 */     this.totalAmount = totalAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_pay")
/*     */   public Double getInsurancePay() {
/* 262 */     return this.insurancePay;
/*     */   }
/*     */   
/*     */   public void setInsurancePay(Double insurancePay) {
/* 266 */     this.insurancePay = insurancePay;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "currency_code")
/*     */   public String getCurrencyCode() {
/* 272 */     return this.currencyCode;
/*     */   }
/*     */   
/*     */   public void setCurrencyCode(String currencyCode) {
/* 276 */     this.currencyCode = currencyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment")
/*     */   public String getPayment() {
/* 282 */     return this.payment;
/*     */   }
/*     */   
/*     */   public void setPayment(String payment) {
/* 286 */     this.payment = payment;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 292 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 296 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "paygate_code")
/*     */   public String getPaygateCode() {
/* 302 */     return this.paygateCode;
/*     */   }
/*     */   
/*     */   public void setPaygateCode(String paygateCode) {
/* 306 */     this.paygateCode = paygateCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payee_id")
/*     */   public Integer getPayeeId() {
/* 312 */     return this.payeeId;
/*     */   }
/*     */   
/*     */   public void setPayeeId(Integer payeeId) {
/* 316 */     this.payeeId = payeeId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 322 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 326 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 332 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 336 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lis_handler_result")
/*     */   public String getLisHandlerResult() {
/* 342 */     return this.lisHandlerResult;
/*     */   }
/*     */   
/*     */   public void setLisHandlerResult(String lisHandlerResult) {
/* 346 */     this.lisHandlerResult = lisHandlerResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lis_device_result")
/*     */   public String getLisDeviceResult() {
/* 352 */     return this.lisDeviceResult;
/*     */   }
/*     */   
/*     */   public void setLisDeviceResult(String lisDeviceResult) {
/* 356 */     this.lisDeviceResult = lisDeviceResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result")
/*     */   public String getRisResult() {
/* 362 */     return this.risResult;
/*     */   }
/*     */   
/*     */   public void setRisResult(String risResult) {
/* 366 */     this.risResult = risResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_finish")
/*     */   public String getRisFinish() {
/* 372 */     return this.risFinish;
/*     */   }
/*     */   
/*     */   public void setRisFinish(String risFinish) {
/* 376 */     this.risFinish = risFinish;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result_by")
/*     */   public String getRisResultBy() {
/* 382 */     return this.risResultBy;
/*     */   }
/*     */   
/*     */   public void setRisResultBy(String risResultBy) {
/* 386 */     this.risResultBy = risResultBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_device")
/*     */   public String getRisDevice() {
/* 392 */     return this.risDevice;
/*     */   }
/*     */   
/*     */   public void setRisDevice(String risDevice) {
/* 396 */     this.risDevice = risDevice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_status")
/*     */   public String getRisStatus() {
/* 402 */     return this.risStatus;
/*     */   }
/*     */   
/*     */   public void setRisStatus(String risStatus) {
/* 406 */     this.risStatus = risStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result_date")
/*     */   public Date getRisResultDate() {
/* 412 */     return this.risResultDate;
/*     */   }
/*     */   
/*     */   public void setRisResultDate(Date risResultDate) {
/* 416 */     this.risResultDate = risResultDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "machine")
/*     */   public String getMachine() {
/* 422 */     return this.machine;
/*     */   }
/*     */   
/*     */   public void setMachine(String machine) {
/* 426 */     this.machine = machine;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderService\MedicOrderServicesHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */