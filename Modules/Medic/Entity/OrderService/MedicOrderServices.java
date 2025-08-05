/*     */ package nencer.app.Modules.Medic.Entity.OrderService;
/*     */ @Entity
/*     */ @Table(name = "medic_order_services")
/*     */ public class MedicOrderServices { private int id; private Integer fundLogId; private Integer ticketId; private String orderCode; private Integer mdId; private Integer customerId; private Integer serviceId; private Integer serviceGroupId; private String serviceCode; private String serviceName; private Integer qty;
/*     */   private String unit;
/*     */   private Integer unitId;
/*     */   private Double price;
/*     */   private Double totalAmount;
/*     */   private Double insurancePay;
/*     */   private Double payAmount;
/*     */   private String currencyCode;
/*     */   private String payment;
/*     */   private String status;
/*     */   private String paygateCode;
/*     */   private Integer payeeId;
/*     */   private Integer creatorId;
/*     */   private String creatorName;
/*     */   
/*  19 */   public MedicOrderServices(int id, Integer fundLogId, Integer ticketId, String orderCode, Integer mdId, Integer customerId, Integer serviceId, Integer serviceGroupId, String serviceCode, String serviceName, Integer qty, String unit, Integer unitId, Double price, Double totalAmount, Double insurancePay, Double payAmount, String currencyCode, String payment, String status, String paygateCode, Integer payeeId, Integer creatorId, String creatorName, Integer roomHandleId, Integer roomSampleId, String lisHandlerResult, String lisDeviceResult, String lisOriginal, String risResult, String risFinish, String machine, Date risResultDate, String risDevice, String risResultBy, String risStatus, String serviceObject, Integer benefitRate, Double copayPatient, Double patientsPaid, Double patientsInDebt, MedicServiceGroups serviceGroups, Date createdAt, Date updatedAt, MedicUnit medicUnit, MedicRooms medicRoomHandle, MedicRooms medicRoomSample, Set<MedicOrderServicesExt> medicOrderServicesExts, Set<MedicOrderServicesPttt> medicOrderServicesPttts) { this.id = id; this.fundLogId = fundLogId; this.ticketId = ticketId; this.orderCode = orderCode; this.mdId = mdId; this.customerId = customerId; this.serviceId = serviceId; this.serviceGroupId = serviceGroupId; this.serviceCode = serviceCode; this.serviceName = serviceName; this.qty = qty; this.unit = unit; this.unitId = unitId; this.price = price; this.totalAmount = totalAmount; this.insurancePay = insurancePay; this.payAmount = payAmount; this.currencyCode = currencyCode; this.payment = payment; this.status = status; this.paygateCode = paygateCode; this.payeeId = payeeId; this.creatorId = creatorId; this.creatorName = creatorName; this.roomHandleId = roomHandleId; this.roomSampleId = roomSampleId; this.lisHandlerResult = lisHandlerResult; this.lisDeviceResult = lisDeviceResult; this.lisOriginal = lisOriginal; this.risResult = risResult; this.risFinish = risFinish; this.machine = machine; this.risResultDate = risResultDate; this.risDevice = risDevice; this.risResultBy = risResultBy; this.risStatus = risStatus; this.serviceObject = serviceObject; this.benefitRate = benefitRate; this.copayPatient = copayPatient; this.patientsPaid = patientsPaid; this.patientsInDebt = patientsInDebt; this.serviceGroups = serviceGroups; this.createdAt = createdAt; this.updatedAt = updatedAt; this.medicUnit = medicUnit; this.medicRoomHandle = medicRoomHandle; this.medicRoomSample = medicRoomSample; this.medicOrderServicesExts = medicOrderServicesExts; this.medicOrderServicesPttts = medicOrderServicesPttts; } private Integer roomHandleId; private Integer roomSampleId; private String lisHandlerResult; private String lisDeviceResult; private String lisOriginal; private String risResult; private String risFinish; private String machine; private Date risResultDate; private String risDevice; private String risResultBy; private String risStatus; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; private MedicServiceGroups serviceGroups; @CreatedDate
/*     */   private Date createdAt; @LastModifiedBy
/*  21 */   private Date updatedAt; private MedicUnit medicUnit; private MedicRooms medicRoomHandle; private MedicRooms medicRoomSample; private Set<MedicOrderServicesExt> medicOrderServicesExts; private Set<MedicOrderServicesPttt> medicOrderServicesPttts; public MedicOrderServices() {} public static MedicOrderServicesBuilder builder() { return new MedicOrderServicesBuilder(); } public static class MedicOrderServicesBuilder { private int id; private Integer fundLogId; private Integer ticketId; private String orderCode; private Integer mdId; private Integer customerId; private Integer serviceId; private Integer serviceGroupId; private String serviceCode; private String serviceName; private Integer qty; private String unit; private Integer unitId; private Double price; private Double totalAmount; private Double insurancePay; private Double payAmount; private String currencyCode; private String payment; private String status; private String paygateCode; private Integer payeeId; private Integer creatorId; private String creatorName; private Integer roomHandleId; private Integer roomSampleId; private String lisHandlerResult; private String lisDeviceResult; private String lisOriginal; private String risResult; private String risFinish; private String machine; private Date risResultDate; private String risDevice; private String risResultBy; private String risStatus; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; private MedicServiceGroups serviceGroups; private Date createdAt; private Date updatedAt; private MedicUnit medicUnit; private MedicRooms medicRoomHandle; private MedicRooms medicRoomSample; private Set<MedicOrderServicesExt> medicOrderServicesExts; private Set<MedicOrderServicesPttt> medicOrderServicesPttts; public MedicOrderServicesBuilder id(int id) { this.id = id; return this; } public MedicOrderServicesBuilder fundLogId(Integer fundLogId) { this.fundLogId = fundLogId; return this; } public MedicOrderServicesBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicOrderServicesBuilder orderCode(String orderCode) { this.orderCode = orderCode; return this; } public MedicOrderServicesBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicOrderServicesBuilder customerId(Integer customerId) { this.customerId = customerId; return this; } public MedicOrderServicesBuilder serviceId(Integer serviceId) { this.serviceId = serviceId; return this; } public MedicOrderServicesBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public MedicOrderServicesBuilder serviceCode(String serviceCode) { this.serviceCode = serviceCode; return this; } public MedicOrderServicesBuilder serviceName(String serviceName) { this.serviceName = serviceName; return this; } public MedicOrderServicesBuilder qty(Integer qty) { this.qty = qty; return this; } public MedicOrderServicesBuilder unit(String unit) { this.unit = unit; return this; } public MedicOrderServicesBuilder unitId(Integer unitId) { this.unitId = unitId; return this; } public MedicOrderServicesBuilder price(Double price) { this.price = price; return this; } public MedicOrderServicesBuilder totalAmount(Double totalAmount) { this.totalAmount = totalAmount; return this; } public MedicOrderServicesBuilder insurancePay(Double insurancePay) { this.insurancePay = insurancePay; return this; } public MedicOrderServicesBuilder payAmount(Double payAmount) { this.payAmount = payAmount; return this; } public MedicOrderServicesBuilder currencyCode(String currencyCode) { this.currencyCode = currencyCode; return this; } public MedicOrderServicesBuilder payment(String payment) { this.payment = payment; return this; } public MedicOrderServicesBuilder status(String status) { this.status = status; return this; } public MedicOrderServicesBuilder paygateCode(String paygateCode) { this.paygateCode = paygateCode; return this; } public MedicOrderServicesBuilder payeeId(Integer payeeId) { this.payeeId = payeeId; return this; } public MedicOrderServicesBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public MedicOrderServicesBuilder creatorName(String creatorName) { this.creatorName = creatorName; return this; } public MedicOrderServicesBuilder roomHandleId(Integer roomHandleId) { this.roomHandleId = roomHandleId; return this; } public MedicOrderServicesBuilder roomSampleId(Integer roomSampleId) { this.roomSampleId = roomSampleId; return this; } public MedicOrderServicesBuilder lisHandlerResult(String lisHandlerResult) { this.lisHandlerResult = lisHandlerResult; return this; } public MedicOrderServicesBuilder lisDeviceResult(String lisDeviceResult) { this.lisDeviceResult = lisDeviceResult; return this; } public MedicOrderServicesBuilder lisOriginal(String lisOriginal) { this.lisOriginal = lisOriginal; return this; } public MedicOrderServicesBuilder risResult(String risResult) { this.risResult = risResult; return this; } public MedicOrderServicesBuilder risFinish(String risFinish) { this.risFinish = risFinish; return this; } public MedicOrderServicesBuilder machine(String machine) { this.machine = machine; return this; } public MedicOrderServicesBuilder risResultDate(Date risResultDate) { this.risResultDate = risResultDate; return this; } public MedicOrderServicesBuilder risDevice(String risDevice) { this.risDevice = risDevice; return this; } public MedicOrderServicesBuilder risResultBy(String risResultBy) { this.risResultBy = risResultBy; return this; } public MedicOrderServicesBuilder risStatus(String risStatus) { this.risStatus = risStatus; return this; } public MedicOrderServicesBuilder serviceObject(String serviceObject) { this.serviceObject = serviceObject; return this; } public MedicOrderServicesBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public MedicOrderServicesBuilder copayPatient(Double copayPatient) { this.copayPatient = copayPatient; return this; } public MedicOrderServicesBuilder patientsPaid(Double patientsPaid) { this.patientsPaid = patientsPaid; return this; } public MedicOrderServicesBuilder patientsInDebt(Double patientsInDebt) { this.patientsInDebt = patientsInDebt; return this; } public MedicOrderServicesBuilder serviceGroups(MedicServiceGroups serviceGroups) { this.serviceGroups = serviceGroups; return this; } public MedicOrderServicesBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicOrderServicesBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicOrderServicesBuilder medicUnit(MedicUnit medicUnit) { this.medicUnit = medicUnit; return this; } public MedicOrderServicesBuilder medicRoomHandle(MedicRooms medicRoomHandle) { this.medicRoomHandle = medicRoomHandle; return this; } public MedicOrderServicesBuilder medicRoomSample(MedicRooms medicRoomSample) { this.medicRoomSample = medicRoomSample; return this; } public MedicOrderServicesBuilder medicOrderServicesExts(Set<MedicOrderServicesExt> medicOrderServicesExts) { this.medicOrderServicesExts = medicOrderServicesExts; return this; } public MedicOrderServicesBuilder medicOrderServicesPttts(Set<MedicOrderServicesPttt> medicOrderServicesPttts) { this.medicOrderServicesPttts = medicOrderServicesPttts; return this; } public MedicOrderServices build() { return new MedicOrderServices(this.id, this.fundLogId, this.ticketId, this.orderCode, this.mdId, this.customerId, this.serviceId, this.serviceGroupId, this.serviceCode, this.serviceName, this.qty, this.unit, this.unitId, this.price, this.totalAmount, this.insurancePay, this.payAmount, this.currencyCode, this.payment, this.status, this.paygateCode, this.payeeId, this.creatorId, this.creatorName, this.roomHandleId, this.roomSampleId, this.lisHandlerResult, this.lisDeviceResult, this.lisOriginal, this.risResult, this.risFinish, this.machine, this.risResultDate, this.risDevice, this.risResultBy, this.risStatus, this.serviceObject, this.benefitRate, this.copayPatient, this.patientsPaid, this.patientsInDebt, this.serviceGroups, this.createdAt, this.updatedAt, this.medicUnit, this.medicRoomHandle, this.medicRoomSample, this.medicOrderServicesExts, this.medicOrderServicesPttts); } public String toString() { return "MedicOrderServices.MedicOrderServicesBuilder(id=" + this.id + ", fundLogId=" + this.fundLogId + ", ticketId=" + this.ticketId + ", orderCode=" + this.orderCode + ", mdId=" + this.mdId + ", customerId=" + this.customerId + ", serviceId=" + this.serviceId + ", serviceGroupId=" + this.serviceGroupId + ", serviceCode=" + this.serviceCode + ", serviceName=" + this.serviceName + ", qty=" + this.qty + ", unit=" + this.unit + ", unitId=" + this.unitId + ", price=" + this.price + ", totalAmount=" + this.totalAmount + ", insurancePay=" + this.insurancePay + ", payAmount=" + this.payAmount + ", currencyCode=" + this.currencyCode + ", payment=" + this.payment + ", status=" + this.status + ", paygateCode=" + this.paygateCode + ", payeeId=" + this.payeeId + ", creatorId=" + this.creatorId + ", creatorName=" + this.creatorName + ", roomHandleId=" + this.roomHandleId + ", roomSampleId=" + this.roomSampleId + ", lisHandlerResult=" + this.lisHandlerResult + ", lisDeviceResult=" + this.lisDeviceResult + ", lisOriginal=" + this.lisOriginal + ", risResult=" + this.risResult + ", risFinish=" + this.risFinish + ", machine=" + this.machine + ", risResultDate=" + this.risResultDate + ", risDevice=" + this.risDevice + ", risResultBy=" + this.risResultBy + ", risStatus=" + this.risStatus + ", serviceObject=" + this.serviceObject + ", benefitRate=" + this.benefitRate + ", copayPatient=" + this.copayPatient + ", patientsPaid=" + this.patientsPaid + ", patientsInDebt=" + this.patientsInDebt + ", serviceGroups=" + this.serviceGroups + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", medicUnit=" + this.medicUnit + ", medicRoomHandle=" + this.medicRoomHandle + ", medicRoomSample=" + this.medicRoomSample + ", medicOrderServicesExts=" + this.medicOrderServicesExts + ", medicOrderServicesPttts=" + this.medicOrderServicesPttts + ")"; }
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
/*     */   @Column(name = "lis_original")
/*     */   public String getLisOriginal() {
/*  94 */     return this.lisOriginal;
/*     */   }
/*     */   
/*     */   public void setLisOriginal(String lisOriginal) {
/*  98 */     this.lisOriginal = lisOriginal;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_status")
/*     */   public String getRisStatus() {
/* 104 */     return this.risStatus;
/*     */   }
/*     */   
/*     */   public void setRisStatus(String risStatus) {
/* 108 */     this.risStatus = risStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result_date")
/*     */   public Date getRisResultDate() {
/* 114 */     return this.risResultDate;
/*     */   }
/*     */   
/*     */   public void setRisResultDate(Date risResultDate) {
/* 118 */     this.risResultDate = risResultDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_device")
/*     */   public String getRisDevice() {
/* 124 */     return this.risDevice;
/*     */   }
/*     */   
/*     */   public void setRisDevice(String risDevice) {
/* 128 */     this.risDevice = risDevice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result_by")
/*     */   public String getRisResultBy() {
/* 134 */     return this.risResultBy;
/*     */   }
/*     */   
/*     */   public void setRisResultBy(String risResultBy) {
/* 138 */     this.risResultBy = risResultBy;
/*     */   }
/*     */ 
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id")
/*     */   public int getId() {
/* 146 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/* 150 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_result")
/*     */   public String getRisResult() {
/* 156 */     return this.risResult;
/*     */   }
/*     */   
/*     */   public void setRisResult(String risResult) {
/* 160 */     this.risResult = risResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_finish")
/*     */   public String getRisFinish() {
/* 166 */     return this.risFinish;
/*     */   }
/*     */   
/*     */   public void setRisFinish(String risFinish) {
/* 170 */     this.risFinish = risFinish;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "machine")
/*     */   public String getMachine() {
/* 176 */     return this.machine;
/*     */   }
/*     */   
/*     */   public void setMachine(String machine) {
/* 180 */     this.machine = machine;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lis_handler_result")
/*     */   public String getLisHandlerResult() {
/* 186 */     return this.lisHandlerResult;
/*     */   }
/*     */   
/*     */   public void setLisHandlerResult(String lisHandlerResult) {
/* 190 */     this.lisHandlerResult = lisHandlerResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lis_device_result")
/*     */   public String getLisDeviceResult() {
/* 196 */     return this.lisDeviceResult;
/*     */   }
/*     */   
/*     */   public void setLisDeviceResult(String lisDeviceResult) {
/* 200 */     this.lisDeviceResult = lisDeviceResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fund_log_id")
/*     */   public Integer getFundLogId() {
/* 206 */     return this.fundLogId;
/*     */   }
/*     */   
/*     */   public void setFundLogId(Integer fundLogId) {
/* 210 */     this.fundLogId = fundLogId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/* 216 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/* 220 */     this.unitId = unitId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_id")
/*     */   public Integer getRoomHandleId() {
/* 227 */     return this.roomHandleId;
/*     */   }
/*     */   
/*     */   public void setRoomHandleId(Integer roomHandleId) {
/* 231 */     this.roomHandleId = roomHandleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_id")
/*     */   public Integer getRoomSampleId() {
/* 237 */     return this.roomSampleId;
/*     */   }
/*     */   
/*     */   public void setRoomSampleId(Integer roomSampleId) {
/* 241 */     this.roomSampleId = roomSampleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_id")
/*     */   public Integer getTicketId() {
/* 247 */     return this.ticketId;
/*     */   }
/*     */   
/*     */   public void setTicketId(Integer ticketId) {
/* 251 */     this.ticketId = ticketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_code")
/*     */   public String getOrderCode() {
/* 257 */     return this.orderCode;
/*     */   }
/*     */   
/*     */   public void setOrderCode(String orderCode) {
/* 261 */     this.orderCode = orderCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/* 267 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/* 271 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/* 277 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/* 281 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public Integer getServiceId() {
/* 287 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/* 291 */     this.serviceId = serviceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_id")
/*     */   public Integer getServiceGroupId() {
/* 297 */     return this.serviceGroupId;
/*     */   }
/*     */   
/*     */   public void setServiceGroupId(Integer serviceGroupId) {
/* 301 */     this.serviceGroupId = serviceGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_code")
/*     */   public String getServiceCode() {
/* 307 */     return this.serviceCode;
/*     */   }
/*     */   
/*     */   public void setServiceCode(String serviceCode) {
/* 311 */     this.serviceCode = serviceCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_name")
/*     */   public String getServiceName() {
/* 317 */     return this.serviceName;
/*     */   }
/*     */   
/*     */   public void setServiceName(String serviceName) {
/* 321 */     this.serviceName = serviceName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "qty")
/*     */   public Integer getQty() {
/* 327 */     return this.qty;
/*     */   }
/*     */   
/*     */   public void setQty(Integer qty) {
/* 331 */     this.qty = qty;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit")
/*     */   public String getUnit() {
/* 337 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/* 341 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public Double getPrice() {
/* 347 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 351 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "total_amount")
/*     */   public Double getTotalAmount() {
/* 357 */     return this.totalAmount;
/*     */   }
/*     */   
/*     */   public void setTotalAmount(Double totalAmount) {
/* 361 */     this.totalAmount = totalAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_pay")
/*     */   public Double getInsurancePay() {
/* 367 */     return this.insurancePay;
/*     */   }
/*     */   
/*     */   public void setInsurancePay(Double insurancePay) {
/* 371 */     this.insurancePay = insurancePay;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "pay_amount")
/*     */   public Double getPayAmount() {
/* 377 */     return this.payAmount;
/*     */   }
/*     */   
/*     */   public void setPayAmount(Double payAmount) {
/* 381 */     this.payAmount = payAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "currency_code")
/*     */   public String getCurrencyCode() {
/* 387 */     return this.currencyCode;
/*     */   }
/*     */   
/*     */   public void setCurrencyCode(String currencyCode) {
/* 391 */     this.currencyCode = currencyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment")
/*     */   public String getPayment() {
/* 397 */     return this.payment;
/*     */   }
/*     */   
/*     */   public void setPayment(String payment) {
/* 401 */     this.payment = payment;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 407 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 411 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "paygate_code")
/*     */   public String getPaygateCode() {
/* 417 */     return this.paygateCode;
/*     */   }
/*     */   
/*     */   public void setPaygateCode(String paygateCode) {
/* 421 */     this.paygateCode = paygateCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payee_id")
/*     */   public Integer getPayeeId() {
/* 427 */     return this.payeeId;
/*     */   }
/*     */   
/*     */   public void setPayeeId(Integer payeeId) {
/* 431 */     this.payeeId = payeeId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 437 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 441 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 447 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 451 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 457 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 461 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "service_group_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public MedicServiceGroups getServiceGroups() {
/* 467 */     return this.serviceGroups;
/*     */   }
/*     */   
/*     */   public void setServiceGroups(MedicServiceGroups serviceGroups) {
/* 471 */     this.serviceGroups = serviceGroups;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "unit_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public MedicUnit getMedicUnit() {
/* 477 */     return this.medicUnit;
/*     */   }
/*     */   
/*     */   public void setMedicUnit(MedicUnit medicUnit) {
/* 481 */     this.medicUnit = medicUnit;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "room_handle_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRoomHandle() {
/* 487 */     return this.medicRoomHandle;
/*     */   }
/*     */   
/*     */   public void setMedicRoomHandle(MedicRooms medicRoomHandle) {
/* 491 */     this.medicRoomHandle = medicRoomHandle;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "room_sample_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRoomSample() {
/* 497 */     return this.medicRoomSample;
/*     */   }
/*     */   
/*     */   public void setMedicRoomSample(MedicRooms medicRoomSample) {
/* 501 */     this.medicRoomSample = medicRoomSample;
/*     */   }
/*     */   
/*     */   @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
/*     */   @JoinColumn(name = "order_service_id")
/*     */   public Set<MedicOrderServicesExt> getMedicOrderServicesExts() {
/* 507 */     return this.medicOrderServicesExts;
/*     */   }
/*     */   
/*     */   public void setMedicOrderServicesExts(Set<MedicOrderServicesExt> medicOrderServicesExts) {
/* 511 */     this.medicOrderServicesExts = medicOrderServicesExts;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_object ")
/*     */   public String getServiceObject() {
/* 517 */     return this.serviceObject;
/*     */   }
/*     */   
/*     */   public void setServiceObject(String serviceObject) {
/* 521 */     this.serviceObject = serviceObject;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "benefit_rate")
/*     */   public Integer getBenefitRate() {
/* 527 */     return this.benefitRate;
/*     */   }
/*     */   
/*     */   public void setBenefitRate(Integer benefitRate) {
/* 531 */     this.benefitRate = benefitRate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "copay_patient")
/*     */   public Double getCopayPatient() {
/* 537 */     return this.copayPatient;
/*     */   }
/*     */   
/*     */   public void setCopayPatient(Double copayPatient) {
/* 541 */     this.copayPatient = copayPatient;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_paid")
/*     */   public Double getPatientsPaid() {
/* 547 */     return this.patientsPaid;
/*     */   }
/*     */   
/*     */   public void setPatientsPaid(Double patientsPaid) {
/* 551 */     this.patientsPaid = patientsPaid;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_in_debt")
/*     */   public Double getPatientsInDebt() {
/* 557 */     return this.patientsInDebt;
/*     */   }
/*     */   
/*     */   public void setPatientsInDebt(Double patientsInDebt) {
/* 561 */     this.patientsInDebt = patientsInDebt;
/*     */   }
/*     */   
/*     */   @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
/*     */   @JoinColumn(name = "order_service_id")
/*     */   public Set<MedicOrderServicesPttt> getMedicOrderServicesPttts() {
/* 567 */     return this.medicOrderServicesPttts;
/*     */   }
/*     */   
/*     */   public void setMedicOrderServicesPttts(Set<MedicOrderServicesPttt> medicOrderServicesPttts) {
/* 571 */     this.medicOrderServicesPttts = medicOrderServicesPttts;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getCreatorName() {
/* 576 */     return this.creatorName;
/*     */   }
/*     */   
/*     */   public void setCreatorName(String creatorName) {
/* 580 */     this.creatorName = creatorName;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderService\MedicOrderServices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */