/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ @Entity
/*     */ @Table(name = "medic_product_order_detail")
/*     */ public class MedicProductOrderDetail { private Integer id; @NotNull(message = "804")
/*     */   private Integer productId; private Integer orderId; private String barcode; private String packageCode; private String batchNumber; private Integer qty; private Integer approvalQty; private Double priceInput; private Double price; private Double priceIns; private Double priceFee; private Double priceHospital; private Double priceRequest;
/*     */   private Double priceSelling;
/*     */   private Double totalPrice;
/*     */   private String currencyCode;
/*     */   private Double vat;
/*     */   private Integer bidId;
/*     */   private String bidNumber;
/*     */   private String bidGroup;
/*     */   private String bidPackage;
/*     */   
/*  15 */   public static MedicProductOrderDetailBuilder builder() { return new MedicProductOrderDetailBuilder(); } private String bidSTT; private Integer rateTT; private Date expirationDate; private String expirationDateFe; private Date productionDate; private Date bidDate; private String bidYear; private String productSrc; private String productEvenSrc; private String userGuide; private String doctorAdvice; private Date bidEffectDate; private Date bidExpirationDate; private String hospitalFeeGroup; private String hospitalFeeType; private String insuranceGroup; private Integer invenId; private MedicProduct medicProduct; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; public static class MedicProductOrderDetailBuilder { private Integer id; private Integer productId; private Integer orderId; private String barcode; private String packageCode; private String batchNumber; private Integer qty; private Integer approvalQty; private Double priceInput; private Double price; private Double priceIns; private Double priceFee; private Double priceHospital; private Double priceRequest; private Double priceSelling; private Double totalPrice; private String currencyCode; private Double vat; private Integer bidId; private String bidNumber; private String bidGroup; private String bidPackage; private String bidSTT; private Integer rateTT; private Date expirationDate; private String expirationDateFe; private Date productionDate; private Date bidDate; private String bidYear; private String productSrc; private String productEvenSrc; private String userGuide; private String doctorAdvice; private Date bidEffectDate; private Date bidExpirationDate; private String hospitalFeeGroup; private String hospitalFeeType; private String insuranceGroup; private Integer invenId; private MedicProduct medicProduct; private String serviceObject; private Integer benefitRate; private Double copayPatient; private Double patientsPaid; private Double patientsInDebt; public MedicProductOrderDetailBuilder id(Integer id) { this.id = id; return this; } public MedicProductOrderDetailBuilder productId(Integer productId) { this.productId = productId; return this; } public MedicProductOrderDetailBuilder orderId(Integer orderId) { this.orderId = orderId; return this; } public MedicProductOrderDetailBuilder barcode(String barcode) { this.barcode = barcode; return this; } public MedicProductOrderDetailBuilder packageCode(String packageCode) { this.packageCode = packageCode; return this; } public MedicProductOrderDetailBuilder batchNumber(String batchNumber) { this.batchNumber = batchNumber; return this; } public MedicProductOrderDetailBuilder qty(Integer qty) { this.qty = qty; return this; } public MedicProductOrderDetailBuilder approvalQty(Integer approvalQty) { this.approvalQty = approvalQty; return this; } public MedicProductOrderDetailBuilder priceInput(Double priceInput) { this.priceInput = priceInput; return this; } public MedicProductOrderDetailBuilder price(Double price) { this.price = price; return this; } public MedicProductOrderDetailBuilder priceIns(Double priceIns) { this.priceIns = priceIns; return this; } public MedicProductOrderDetailBuilder priceFee(Double priceFee) { this.priceFee = priceFee; return this; } public MedicProductOrderDetailBuilder priceHospital(Double priceHospital) { this.priceHospital = priceHospital; return this; } public MedicProductOrderDetailBuilder priceRequest(Double priceRequest) { this.priceRequest = priceRequest; return this; } public MedicProductOrderDetailBuilder priceSelling(Double priceSelling) { this.priceSelling = priceSelling; return this; } public MedicProductOrderDetailBuilder totalPrice(Double totalPrice) { this.totalPrice = totalPrice; return this; } public MedicProductOrderDetailBuilder currencyCode(String currencyCode) { this.currencyCode = currencyCode; return this; } public MedicProductOrderDetailBuilder vat(Double vat) { this.vat = vat; return this; } public MedicProductOrderDetailBuilder bidId(Integer bidId) { this.bidId = bidId; return this; } public MedicProductOrderDetailBuilder bidNumber(String bidNumber) { this.bidNumber = bidNumber; return this; } public MedicProductOrderDetailBuilder bidGroup(String bidGroup) { this.bidGroup = bidGroup; return this; } public MedicProductOrderDetailBuilder bidPackage(String bidPackage) { this.bidPackage = bidPackage; return this; } public MedicProductOrderDetailBuilder bidSTT(String bidSTT) { this.bidSTT = bidSTT; return this; } public MedicProductOrderDetailBuilder rateTT(Integer rateTT) { this.rateTT = rateTT; return this; } public MedicProductOrderDetailBuilder expirationDate(Date expirationDate) { this.expirationDate = expirationDate; return this; } public MedicProductOrderDetailBuilder expirationDateFe(String expirationDateFe) { this.expirationDateFe = expirationDateFe; return this; } public MedicProductOrderDetailBuilder productionDate(Date productionDate) { this.productionDate = productionDate; return this; } public MedicProductOrderDetailBuilder bidDate(Date bidDate) { this.bidDate = bidDate; return this; } public MedicProductOrderDetailBuilder bidYear(String bidYear) { this.bidYear = bidYear; return this; } public MedicProductOrderDetailBuilder productSrc(String productSrc) { this.productSrc = productSrc; return this; } public MedicProductOrderDetailBuilder productEvenSrc(String productEvenSrc) { this.productEvenSrc = productEvenSrc; return this; } public MedicProductOrderDetailBuilder userGuide(String userGuide) { this.userGuide = userGuide; return this; } public MedicProductOrderDetailBuilder doctorAdvice(String doctorAdvice) { this.doctorAdvice = doctorAdvice; return this; } public MedicProductOrderDetailBuilder bidEffectDate(Date bidEffectDate) { this.bidEffectDate = bidEffectDate; return this; } public MedicProductOrderDetailBuilder bidExpirationDate(Date bidExpirationDate) { this.bidExpirationDate = bidExpirationDate; return this; } public MedicProductOrderDetailBuilder hospitalFeeGroup(String hospitalFeeGroup) { this.hospitalFeeGroup = hospitalFeeGroup; return this; } public MedicProductOrderDetailBuilder hospitalFeeType(String hospitalFeeType) { this.hospitalFeeType = hospitalFeeType; return this; } public MedicProductOrderDetailBuilder insuranceGroup(String insuranceGroup) { this.insuranceGroup = insuranceGroup; return this; } public MedicProductOrderDetailBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } public MedicProductOrderDetailBuilder medicProduct(MedicProduct medicProduct) { this.medicProduct = medicProduct; return this; } public MedicProductOrderDetailBuilder serviceObject(String serviceObject) { this.serviceObject = serviceObject; return this; } public MedicProductOrderDetailBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public MedicProductOrderDetailBuilder copayPatient(Double copayPatient) { this.copayPatient = copayPatient; return this; } public MedicProductOrderDetailBuilder patientsPaid(Double patientsPaid) { this.patientsPaid = patientsPaid; return this; } public MedicProductOrderDetailBuilder patientsInDebt(Double patientsInDebt) { this.patientsInDebt = patientsInDebt; return this; } public MedicProductOrderDetail build() { return new MedicProductOrderDetail(this.id, this.productId, this.orderId, this.barcode, this.packageCode, this.batchNumber, this.qty, this.approvalQty, this.priceInput, this.price, this.priceIns, this.priceFee, this.priceHospital, this.priceRequest, this.priceSelling, this.totalPrice, this.currencyCode, this.vat, this.bidId, this.bidNumber, this.bidGroup, this.bidPackage, this.bidSTT, this.rateTT, this.expirationDate, this.expirationDateFe, this.productionDate, this.bidDate, this.bidYear, this.productSrc, this.productEvenSrc, this.userGuide, this.doctorAdvice, this.bidEffectDate, this.bidExpirationDate, this.hospitalFeeGroup, this.hospitalFeeType, this.insuranceGroup, this.invenId, this.medicProduct, this.serviceObject, this.benefitRate, this.copayPatient, this.patientsPaid, this.patientsInDebt); } public String toString() { return "MedicProductOrderDetail.MedicProductOrderDetailBuilder(id=" + this.id + ", productId=" + this.productId + ", orderId=" + this.orderId + ", barcode=" + this.barcode + ", packageCode=" + this.packageCode + ", batchNumber=" + this.batchNumber + ", qty=" + this.qty + ", approvalQty=" + this.approvalQty + ", priceInput=" + this.priceInput + ", price=" + this.price + ", priceIns=" + this.priceIns + ", priceFee=" + this.priceFee + ", priceHospital=" + this.priceHospital + ", priceRequest=" + this.priceRequest + ", priceSelling=" + this.priceSelling + ", totalPrice=" + this.totalPrice + ", currencyCode=" + this.currencyCode + ", vat=" + this.vat + ", bidId=" + this.bidId + ", bidNumber=" + this.bidNumber + ", bidGroup=" + this.bidGroup + ", bidPackage=" + this.bidPackage + ", bidSTT=" + this.bidSTT + ", rateTT=" + this.rateTT + ", expirationDate=" + this.expirationDate + ", expirationDateFe=" + this.expirationDateFe + ", productionDate=" + this.productionDate + ", bidDate=" + this.bidDate + ", bidYear=" + this.bidYear + ", productSrc=" + this.productSrc + ", productEvenSrc=" + this.productEvenSrc + ", userGuide=" + this.userGuide + ", doctorAdvice=" + this.doctorAdvice + ", bidEffectDate=" + this.bidEffectDate + ", bidExpirationDate=" + this.bidExpirationDate + ", hospitalFeeGroup=" + this.hospitalFeeGroup + ", hospitalFeeType=" + this.hospitalFeeType + ", insuranceGroup=" + this.insuranceGroup + ", invenId=" + this.invenId + ", medicProduct=" + this.medicProduct + ", serviceObject=" + this.serviceObject + ", benefitRate=" + this.benefitRate + ", copayPatient=" + this.copayPatient + ", patientsPaid=" + this.patientsPaid + ", patientsInDebt=" + this.patientsInDebt + ")"; } } public MedicProductOrderDetail(Integer id, Integer productId, Integer orderId, String barcode, String packageCode, String batchNumber, Integer qty, Integer approvalQty, Double priceInput, Double price, Double priceIns, Double priceFee, Double priceHospital, Double priceRequest, Double priceSelling, Double totalPrice, String currencyCode, Double vat, Integer bidId, String bidNumber, String bidGroup, String bidPackage, String bidSTT, Integer rateTT, Date expirationDate, String expirationDateFe, Date productionDate, Date bidDate, String bidYear, String productSrc, String productEvenSrc, String userGuide, String doctorAdvice, Date bidEffectDate, Date bidExpirationDate, String hospitalFeeGroup, String hospitalFeeType, String insuranceGroup, Integer invenId, MedicProduct medicProduct, String serviceObject, Integer benefitRate, Double copayPatient, Double patientsPaid, Double patientsInDebt) {
/*  16 */     this.id = id; this.productId = productId; this.orderId = orderId; this.barcode = barcode; this.packageCode = packageCode; this.batchNumber = batchNumber; this.qty = qty; this.approvalQty = approvalQty; this.priceInput = priceInput; this.price = price; this.priceIns = priceIns; this.priceFee = priceFee; this.priceHospital = priceHospital; this.priceRequest = priceRequest; this.priceSelling = priceSelling; this.totalPrice = totalPrice; this.currencyCode = currencyCode; this.vat = vat; this.bidId = bidId; this.bidNumber = bidNumber; this.bidGroup = bidGroup; this.bidPackage = bidPackage; this.bidSTT = bidSTT; this.rateTT = rateTT; this.expirationDate = expirationDate; this.expirationDateFe = expirationDateFe; this.productionDate = productionDate; this.bidDate = bidDate; this.bidYear = bidYear; this.productSrc = productSrc; this.productEvenSrc = productEvenSrc; this.userGuide = userGuide; this.doctorAdvice = doctorAdvice; this.bidEffectDate = bidEffectDate; this.bidExpirationDate = bidExpirationDate; this.hospitalFeeGroup = hospitalFeeGroup; this.hospitalFeeType = hospitalFeeType; this.insuranceGroup = insuranceGroup; this.invenId = invenId; this.medicProduct = medicProduct; this.serviceObject = serviceObject; this.benefitRate = benefitRate; this.copayPatient = copayPatient; this.patientsPaid = patientsPaid; this.patientsInDebt = patientsInDebt;
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
/*     */   public MedicProductOrderDetail() {}
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
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  70 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  74 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_id")
/*     */   public Integer getProductId() {
/*  80 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Integer productId) {
/*  84 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_id")
/*     */   public Integer getOrderId() {
/*  90 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Integer orderId) {
/*  94 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "barcode")
/*     */   public String getBarcode() {
/* 100 */     return this.barcode;
/*     */   }
/*     */   
/*     */   public void setBarcode(String barcode) {
/* 104 */     this.barcode = barcode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "package_code")
/*     */   public String getPackageCode() {
/* 110 */     return this.packageCode;
/*     */   }
/*     */   
/*     */   public void setPackageCode(String packageCode) {
/* 114 */     this.packageCode = packageCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "batch_number")
/*     */   public String getBatchNumber() {
/* 120 */     return this.batchNumber;
/*     */   }
/*     */   
/*     */   public void setBatchNumber(String batchNumber) {
/* 124 */     this.batchNumber = batchNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "qty")
/*     */   public Integer getQty() {
/* 130 */     return this.qty;
/*     */   }
/*     */   
/*     */   public void setQty(Integer qty) {
/* 134 */     this.qty = qty;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_input")
/*     */   public Double getPriceInput() {
/* 140 */     return this.priceInput;
/*     */   }
/*     */   
/*     */   public void setPriceInput(Double priceInput) {
/* 144 */     this.priceInput = priceInput;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public Double getPrice() {
/* 150 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 154 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_ins")
/*     */   public Double getPriceIns() {
/* 160 */     return this.priceIns;
/*     */   }
/*     */   
/*     */   public void setPriceIns(Double priceIns) {
/* 164 */     this.priceIns = priceIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_fee")
/*     */   public Double getPriceFee() {
/* 170 */     return this.priceFee;
/*     */   }
/*     */   
/*     */   public void setPriceFee(Double priceFee) {
/* 174 */     this.priceFee = priceFee;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_hospital")
/*     */   public Double getPriceHospital() {
/* 180 */     return this.priceHospital;
/*     */   }
/*     */   
/*     */   public void setPriceHospital(Double priceHospital) {
/* 184 */     this.priceHospital = priceHospital;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_request")
/*     */   public Double getPriceRequest() {
/* 190 */     return this.priceRequest;
/*     */   }
/*     */   
/*     */   public void setPriceRequest(Double priceRequest) {
/* 194 */     this.priceRequest = priceRequest;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "total_price")
/*     */   public Double getTotalPrice() {
/* 200 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(Double totalPrice) {
/* 204 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "currency_code")
/*     */   public String getCurrencyCode() {
/* 210 */     return this.currencyCode;
/*     */   }
/*     */   
/*     */   public void setCurrencyCode(String currencyCode) {
/* 214 */     this.currencyCode = currencyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "vat")
/*     */   public Double getVat() {
/* 220 */     return this.vat;
/*     */   }
/*     */   
/*     */   public void setVat(Double vat) {
/* 224 */     this.vat = vat;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_id")
/*     */   public Integer getBidId() {
/* 230 */     return this.bidId;
/*     */   }
/*     */   
/*     */   public void setBidId(Integer bidId) {
/* 234 */     this.bidId = bidId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_number")
/*     */   public String getBidNumber() {
/* 240 */     return this.bidNumber;
/*     */   }
/*     */   
/*     */   public void setBidNumber(String bidNumber) {
/* 244 */     this.bidNumber = bidNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_group")
/*     */   public String getBidGroup() {
/* 250 */     return this.bidGroup;
/*     */   }
/*     */   
/*     */   public void setBidGroup(String bidGroup) {
/* 254 */     this.bidGroup = bidGroup;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_package")
/*     */   public String getBidPackage() {
/* 260 */     return this.bidPackage;
/*     */   }
/*     */   
/*     */   public void setBidPackage(String bidPackage) {
/* 264 */     this.bidPackage = bidPackage;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_date")
/*     */   public Date getBidDate() {
/* 270 */     return this.bidDate;
/*     */   }
/*     */   
/*     */   public void setBidDate(Date bidDate) {
/* 274 */     this.bidDate = bidDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_year")
/*     */   public String getBidYear() {
/* 280 */     return this.bidYear;
/*     */   }
/*     */   
/*     */   public void setBidYear(String bidYear) {
/* 284 */     this.bidYear = bidYear;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "production_date")
/*     */   public Date getProductionDate() {
/* 290 */     return this.productionDate;
/*     */   }
/*     */   
/*     */   public void setProductionDate(Date productionDate) {
/* 294 */     this.productionDate = productionDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expiration_date")
/*     */   public Date getExpirationDate() {
/* 300 */     return this.expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date expirationDate) {
/* 304 */     this.expirationDate = expirationDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expiration_date_fe")
/*     */   public String getExpirationDateFe() {
/* 310 */     return this.expirationDateFe;
/*     */   }
/*     */   
/*     */   public void setExpirationDateFe(String expirationDateFe) {
/* 314 */     this.expirationDateFe = expirationDateFe;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_src")
/*     */   public String getProductSrc() {
/* 320 */     return this.productSrc;
/*     */   }
/*     */   
/*     */   public void setProductSrc(String productSrc) {
/* 324 */     this.productSrc = productSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_even_src")
/*     */   public String getProductEvenSrc() {
/* 330 */     return this.productEvenSrc;
/*     */   }
/*     */   
/*     */   public void setProductEvenSrc(String productEvenSrc) {
/* 334 */     this.productEvenSrc = productEvenSrc;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "product_id", updatable = false, insertable = false)
/*     */   @NotFound(action = NotFoundAction.IGNORE)
/*     */   public MedicProduct getMedicProduct() {
/* 341 */     return this.medicProduct;
/*     */   }
/*     */   
/*     */   public void setMedicProduct(MedicProduct medicProduct) {
/* 345 */     this.medicProduct = medicProduct;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_guide")
/*     */   public String getUserGuide() {
/* 351 */     return this.userGuide;
/*     */   }
/*     */   
/*     */   public void setUserGuide(String userGuide) {
/* 355 */     this.userGuide = userGuide;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_advice")
/*     */   public String getDoctorAdvice() {
/* 361 */     return this.doctorAdvice;
/*     */   }
/*     */   
/*     */   public void setDoctorAdvice(String doctorAdvice) {
/* 365 */     this.doctorAdvice = doctorAdvice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_stt")
/*     */   public String getBidSTT() {
/* 371 */     return this.bidSTT;
/*     */   }
/*     */   
/*     */   public void setBidSTT(String bidSTT) {
/* 375 */     this.bidSTT = bidSTT;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rate_tt")
/*     */   public Integer getRateTT() {
/* 381 */     return this.rateTT;
/*     */   }
/*     */   
/*     */   public void setRateTT(Integer rateTT) {
/* 385 */     this.rateTT = rateTT;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_effect_date")
/*     */   public Date getBidEffectDate() {
/* 391 */     return this.bidEffectDate;
/*     */   }
/*     */   
/*     */   public void setBidEffectDate(Date bidEffectDate) {
/* 395 */     this.bidEffectDate = bidEffectDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_expiration_date")
/*     */   public Date getBidExpirationDate() {
/* 401 */     return this.bidExpirationDate;
/*     */   }
/*     */   
/*     */   public void setBidExpirationDate(Date bidExpirationDate) {
/* 405 */     this.bidExpirationDate = bidExpirationDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_fee_group")
/*     */   public String getHospitalFeeGroup() {
/* 411 */     return this.hospitalFeeGroup;
/*     */   }
/*     */   
/*     */   public void setHospitalFeeGroup(String hospitalFeeGroup) {
/* 415 */     this.hospitalFeeGroup = hospitalFeeGroup;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_fee_type")
/*     */   public String getHospitalFeeType() {
/* 421 */     return this.hospitalFeeType;
/*     */   }
/*     */   
/*     */   public void setHospitalFeeType(String hospitalFeeType) {
/* 425 */     this.hospitalFeeType = hospitalFeeType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_group")
/*     */   public String getInsuranceGroup() {
/* 431 */     return this.insuranceGroup;
/*     */   }
/*     */   
/*     */   public void setInsuranceGroup(String insuranceGroup) {
/* 435 */     this.insuranceGroup = insuranceGroup;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "inven_id")
/*     */   public Integer getInvenId() {
/* 441 */     return this.invenId;
/*     */   }
/*     */   
/*     */   public void setInvenId(Integer invenId) {
/* 445 */     this.invenId = invenId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "approval_qty")
/*     */   public Integer getApprovalQty() {
/* 452 */     return this.approvalQty;
/*     */   }
/*     */   
/*     */   public void setApprovalQty(Integer approvalQty) {
/* 456 */     this.approvalQty = approvalQty;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_selling")
/*     */   public Double getPriceSelling() {
/* 462 */     return this.priceSelling;
/*     */   }
/*     */   
/*     */   public void setPriceSelling(Double priceSelling) {
/* 466 */     this.priceSelling = priceSelling;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_object ")
/*     */   public String getServiceObject() {
/* 472 */     return this.serviceObject;
/*     */   }
/*     */   
/*     */   public void setServiceObject(String serviceObject) {
/* 476 */     this.serviceObject = serviceObject;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "benefit_rate")
/*     */   public Integer getBenefitRate() {
/* 482 */     return this.benefitRate;
/*     */   }
/*     */   
/*     */   public void setBenefitRate(Integer benefitRate) {
/* 486 */     this.benefitRate = benefitRate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "copay_patient")
/*     */   public Double getCopayPatient() {
/* 492 */     return this.copayPatient;
/*     */   }
/*     */   
/*     */   public void setCopayPatient(Double copayPatient) {
/* 496 */     this.copayPatient = copayPatient;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_paid")
/*     */   public Double getPatientsPaid() {
/* 502 */     return this.patientsPaid;
/*     */   }
/*     */   
/*     */   public void setPatientsPaid(Double patientsPaid) {
/* 506 */     this.patientsPaid = patientsPaid;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patients_in_debt")
/*     */   public Double getPatientsInDebt() {
/* 512 */     return this.patientsInDebt;
/*     */   }
/*     */   
/*     */   public void setPatientsInDebt(Double patientsInDebt) {
/* 516 */     this.patientsInDebt = patientsInDebt;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductOrderDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */