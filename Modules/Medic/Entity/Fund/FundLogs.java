/*     */ package nencer.app.Modules.Medic.Entity.Fund;
/*     */ @Entity
/*     */ @Table(name = "fund_logs")
/*     */ public class FundLogs { private Integer fundLogId; private String code; private String fundLogChannel; private Integer checkinId;
/*     */   private Integer orderId;
/*     */   private String currencyCode;
/*     */   private String description;
/*     */   private Integer creator;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   private Integer customerId;
/*     */   private String status;
/*     */   private String orderType;
/*     */   
/*  15 */   public static FundLogsBuilder builder() { return new FundLogsBuilder(); } private Double netAmount; private Double fees; private Double discount; private Double payAmount; private String paygate; private String note; private String bookNumber; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; private List<MedicOrderServices> medicOrderServices; private List<MedicProductOrderModel> medicProductOrders; public static class FundLogsBuilder { private Integer fundLogId; private String code; private String fundLogChannel; private Integer checkinId; private Integer orderId; private String currencyCode; private String description; private Integer creator; private Date createdAt; private Date updatedAt; private Integer customerId; private String status; private String orderType; private Double netAmount; private Double fees; private Double discount; private Double payAmount; private String paygate; private String note; private String bookNumber; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; private List<MedicOrderServices> medicOrderServices; private List<MedicProductOrderModel> medicProductOrders; public FundLogsBuilder fundLogId(Integer fundLogId) { this.fundLogId = fundLogId; return this; } public FundLogsBuilder code(String code) { this.code = code; return this; } public FundLogsBuilder fundLogChannel(String fundLogChannel) { this.fundLogChannel = fundLogChannel; return this; } public FundLogsBuilder checkinId(Integer checkinId) { this.checkinId = checkinId; return this; } public FundLogsBuilder orderId(Integer orderId) { this.orderId = orderId; return this; } public FundLogsBuilder currencyCode(String currencyCode) { this.currencyCode = currencyCode; return this; } public FundLogsBuilder description(String description) { this.description = description; return this; } public FundLogsBuilder creator(Integer creator) { this.creator = creator; return this; } public FundLogsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public FundLogsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public FundLogsBuilder customerId(Integer customerId) { this.customerId = customerId; return this; } public FundLogsBuilder status(String status) { this.status = status; return this; } public FundLogsBuilder orderType(String orderType) { this.orderType = orderType; return this; } public FundLogsBuilder netAmount(Double netAmount) { this.netAmount = netAmount; return this; } public FundLogsBuilder fees(Double fees) { this.fees = fees; return this; } public FundLogsBuilder discount(Double discount) { this.discount = discount; return this; } public FundLogsBuilder payAmount(Double payAmount) { this.payAmount = payAmount; return this; } public FundLogsBuilder paygate(String paygate) { this.paygate = paygate; return this; } public FundLogsBuilder note(String note) { this.note = note; return this; } public FundLogsBuilder bookNumber(String bookNumber) { this.bookNumber = bookNumber; return this; } public FundLogsBuilder serviceObject(String serviceObject) { this.serviceObject = serviceObject; return this; } public FundLogsBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public FundLogsBuilder copayPatient(Double copayPatient) { this.copayPatient = copayPatient; return this; } public FundLogsBuilder patientsPaid(Double patientsPaid) { this.patientsPaid = patientsPaid; return this; } public FundLogsBuilder patientsInDebt(Double patientsInDebt) { this.patientsInDebt = patientsInDebt; return this; } public FundLogsBuilder medicOrderServices(List<MedicOrderServices> medicOrderServices) { this.medicOrderServices = medicOrderServices; return this; } public FundLogsBuilder medicProductOrders(List<MedicProductOrderModel> medicProductOrders) { this.medicProductOrders = medicProductOrders; return this; } public FundLogs build() { return new FundLogs(this.fundLogId, this.code, this.fundLogChannel, this.checkinId, this.orderId, this.currencyCode, this.description, this.creator, this.createdAt, this.updatedAt, this.customerId, this.status, this.orderType, this.netAmount, this.fees, this.discount, this.payAmount, this.paygate, this.note, this.bookNumber, this.serviceObject, this.benefitRate, this.copayPatient, this.patientsPaid, this.patientsInDebt, this.medicOrderServices, this.medicProductOrders); } public String toString() { return "FundLogs.FundLogsBuilder(fundLogId=" + this.fundLogId + ", code=" + this.code + ", fundLogChannel=" + this.fundLogChannel + ", checkinId=" + this.checkinId + ", orderId=" + this.orderId + ", currencyCode=" + this.currencyCode + ", description=" + this.description + ", creator=" + this.creator + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", customerId=" + this.customerId + ", status=" + this.status + ", orderType=" + this.orderType + ", netAmount=" + this.netAmount + ", fees=" + this.fees + ", discount=" + this.discount + ", payAmount=" + this.payAmount + ", paygate=" + this.paygate + ", note=" + this.note + ", bookNumber=" + this.bookNumber + ", serviceObject=" + this.serviceObject + ", benefitRate=" + this.benefitRate + ", copayPatient=" + this.copayPatient + ", patientsPaid=" + this.patientsPaid + ", patientsInDebt=" + this.patientsInDebt + ", medicOrderServices=" + this.medicOrderServices + ", medicProductOrders=" + this.medicProductOrders + ")"; }
/*     */      } public FundLogs() {} public FundLogs(Integer fundLogId, String code, String fundLogChannel, Integer checkinId, Integer orderId, String currencyCode, String description, Integer creator, Date createdAt, Date updatedAt, Integer customerId, String status, String orderType, Double netAmount, Double fees, Double discount, Double payAmount, String paygate, String note, String bookNumber, String serviceObject, Integer benefitRate, Double copayPatient, Double patientsPaid, Double patientsInDebt, List<MedicOrderServices> medicOrderServices, List<MedicProductOrderModel> medicProductOrders) {
/*  17 */     this.fundLogId = fundLogId; this.code = code; this.fundLogChannel = fundLogChannel; this.checkinId = checkinId; this.orderId = orderId; this.currencyCode = currencyCode; this.description = description; this.creator = creator; this.createdAt = createdAt; this.updatedAt = updatedAt; this.customerId = customerId; this.status = status; this.orderType = orderType; this.netAmount = netAmount; this.fees = fees; this.discount = discount; this.payAmount = payAmount; this.paygate = paygate; this.note = note; this.bookNumber = bookNumber; this.serviceObject = serviceObject; this.benefitRate = benefitRate; this.copayPatient = copayPatient; this.patientsPaid = patientsPaid; this.patientsInDebt = patientsInDebt; this.medicOrderServices = medicOrderServices; this.medicProductOrders = medicProductOrders;
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
/*     */   @Id
/*     */   @Column(name = "fund_log_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getFundLogId() {
/*  53 */     return this.fundLogId;
/*     */   }
/*     */   
/*     */   public void setFundLogId(Integer fundLogId) {
/*  57 */     this.fundLogId = fundLogId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  63 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  67 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_id")
/*     */   public Integer getCheckinId() {
/*  73 */     return this.checkinId;
/*     */   }
/*     */   
/*     */   public void setCheckinId(Integer checkinId) {
/*  77 */     this.checkinId = checkinId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_id")
/*     */   public Integer getOrderId() {
/*  83 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Integer orderId) {
/*  87 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "currency_code")
/*     */   public String getCurrencyCode() {
/*  93 */     return this.currencyCode;
/*     */   }
/*     */   
/*     */   public void setCurrencyCode(String currencyCode) {
/*  97 */     this.currencyCode = currencyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 103 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 107 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator")
/*     */   public Integer getCreator() {
/* 113 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(Integer creator) {
/* 117 */     this.creator = creator;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 123 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 127 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 133 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 137 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/* 143 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/* 147 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 153 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 157 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_type")
/*     */   public String getOrderType() {
/* 163 */     return this.orderType;
/*     */   }
/*     */   
/*     */   public void setOrderType(String orderType) {
/* 167 */     this.orderType = orderType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "net_amount")
/*     */   public Double getNetAmount() {
/* 173 */     return this.netAmount;
/*     */   }
/*     */   
/*     */   public void setNetAmount(Double netAmount) {
/* 177 */     this.netAmount = netAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fees")
/*     */   public Double getFees() {
/* 183 */     return this.fees;
/*     */   }
/*     */   
/*     */   public void setFees(Double fees) {
/* 187 */     this.fees = fees;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "discount")
/*     */   public Double getDiscount() {
/* 193 */     return this.discount;
/*     */   }
/*     */   
/*     */   public void setDiscount(Double discount) {
/* 197 */     this.discount = discount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "pay_amount")
/*     */   public Double getPayAmount() {
/* 203 */     return this.payAmount;
/*     */   }
/*     */   
/*     */   public void setPayAmount(Double payAmount) {
/* 207 */     this.payAmount = payAmount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "paygate")
/*     */   public String getPaygate() {
/* 213 */     return this.paygate;
/*     */   }
/*     */   
/*     */   public void setPaygate(String paygate) {
/* 217 */     this.paygate = paygate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`note`")
/*     */   public String getNote() {
/* 223 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 227 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "book_number")
/*     */   public String getBookNumber() {
/* 233 */     return this.bookNumber;
/*     */   }
/*     */   
/*     */   public void setBookNumber(String bookNumber) {
/* 237 */     this.bookNumber = bookNumber;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public List<MedicOrderServices> getMedicOrderServices() {
/* 242 */     return this.medicOrderServices;
/*     */   }
/*     */   
/*     */   public void setMedicOrderServices(List<MedicOrderServices> medicOrderServices) {
/* 246 */     this.medicOrderServices = medicOrderServices;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public List<MedicProductOrderModel> getMedicProductOrders() {
/* 251 */     return this.medicProductOrders;
/*     */   }
/*     */   
/*     */   public void setMedicProductOrders(List<MedicProductOrderModel> medicProductOrders) {
/* 255 */     this.medicProductOrders = medicProductOrders;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_object")
/*     */   public String getServiceObject() {
/* 261 */     return this.serviceObject;
/*     */   }
/*     */   
/*     */   public void setServiceObject(String serviceObject) {
/* 265 */     this.serviceObject = serviceObject;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "benefit_rate")
/*     */   public Integer getBenefitRate() {
/* 271 */     return this.benefitRate;
/*     */   }
/*     */   
/*     */   public void setBenefitRate(Integer benefitRate) {
/* 275 */     this.benefitRate = benefitRate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "copay_patient")
/*     */   public Double getCopayPatient() {
/* 281 */     return this.copayPatient;
/*     */   }
/*     */   
/*     */   public void setCopayPatient(Double copayPatient) {
/* 285 */     this.copayPatient = copayPatient;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_paid")
/*     */   public Double getPatientsPaid() {
/* 291 */     return this.patientsPaid;
/*     */   }
/*     */   
/*     */   public void setPatientsPaid(Double patientsPaid) {
/* 295 */     this.patientsPaid = patientsPaid;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_in_debt")
/*     */   public Double getPatientsInDebt() {
/* 301 */     return this.patientsInDebt;
/*     */   }
/*     */   
/*     */   public void setPatientsInDebt(Double patientsInDebt) {
/* 305 */     this.patientsInDebt = patientsInDebt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fund_log_channel")
/*     */   public String getFundLogChannel() {
/* 311 */     return this.fundLogChannel;
/*     */   }
/*     */   
/*     */   public void setFundLogChannel(String fundLogChannel) {
/* 315 */     this.fundLogChannel = fundLogChannel;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Fund\FundLogs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */