/*     */ package nencer.app.Modules.Storehouse.Entity;@Entity
/*     */ @Table(name = "medic_storehouse_inven", uniqueConstraints = {@UniqueConstraint(name = "groupUniqueInven", columnNames = {"storehouse_id", "product_id", "price_input", "price", "price_ins", "price_fee", "price_hospital", "price_request", "batch_number", "vat", "bid_number", "bid_group", "bid_package", "bid_year", "expiration_date_fe", "production_date"})})
/*     */ public class MedicStorehouseInven { private Integer invenId; private Integer storehouseId; private Integer productId; private Double priceInput; private Double price; private Double priceIns; private Double priceFee; private Double priceHospital; private Double priceRequest; private Double priceSelling; private String batchNumber;
/*     */   private Double vat;
/*     */   private String bidNumber;
/*     */   private String bidGroup;
/*     */   private String bidPackage;
/*     */   private String bidYear;
/*     */   private String expirationDateFe;
/*     */   private Date expirationDate;
/*     */   private Date productionDate;
/*     */   private Date createdDate;
/*     */   private Date updatedDate;
/*     */   private Integer qty;
/*     */   private Integer qtyLock;
/*     */   private Integer orderDetailId;
/*     */   
/*  18 */   public static MedicStorehouseInvenBuilder builder() { return new MedicStorehouseInvenBuilder(); } public static class MedicStorehouseInvenBuilder { private Integer invenId; private Integer storehouseId; private Integer productId; private Double priceInput; private Double price; private Double priceIns; private Double priceFee; private Double priceHospital; private Double priceRequest; private Double priceSelling; private String batchNumber; private Double vat; public MedicStorehouseInvenBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } private String bidNumber; private String bidGroup; private String bidPackage; private String bidYear; private String expirationDateFe; private Date expirationDate; private Date productionDate; private Date createdDate; private Date updatedDate; private Integer qty; private Integer qtyLock; private Integer orderDetailId; public MedicStorehouseInvenBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicStorehouseInvenBuilder productId(Integer productId) { this.productId = productId; return this; } public MedicStorehouseInvenBuilder priceInput(Double priceInput) { this.priceInput = priceInput; return this; } public MedicStorehouseInvenBuilder price(Double price) { this.price = price; return this; } public MedicStorehouseInvenBuilder priceIns(Double priceIns) { this.priceIns = priceIns; return this; } public MedicStorehouseInvenBuilder priceFee(Double priceFee) { this.priceFee = priceFee; return this; } public MedicStorehouseInvenBuilder priceHospital(Double priceHospital) { this.priceHospital = priceHospital; return this; } public MedicStorehouseInvenBuilder priceRequest(Double priceRequest) { this.priceRequest = priceRequest; return this; } public MedicStorehouseInvenBuilder priceSelling(Double priceSelling) { this.priceSelling = priceSelling; return this; } public MedicStorehouseInvenBuilder batchNumber(String batchNumber) { this.batchNumber = batchNumber; return this; } public MedicStorehouseInvenBuilder vat(Double vat) { this.vat = vat; return this; } public MedicStorehouseInvenBuilder bidNumber(String bidNumber) { this.bidNumber = bidNumber; return this; } public MedicStorehouseInvenBuilder bidGroup(String bidGroup) { this.bidGroup = bidGroup; return this; } public MedicStorehouseInvenBuilder bidPackage(String bidPackage) { this.bidPackage = bidPackage; return this; } public MedicStorehouseInvenBuilder bidYear(String bidYear) { this.bidYear = bidYear; return this; } public MedicStorehouseInvenBuilder expirationDateFe(String expirationDateFe) { this.expirationDateFe = expirationDateFe; return this; } public MedicStorehouseInvenBuilder expirationDate(Date expirationDate) { this.expirationDate = expirationDate; return this; } public MedicStorehouseInvenBuilder productionDate(Date productionDate) { this.productionDate = productionDate; return this; } public MedicStorehouseInvenBuilder createdDate(Date createdDate) { this.createdDate = createdDate; return this; } public MedicStorehouseInvenBuilder updatedDate(Date updatedDate) { this.updatedDate = updatedDate; return this; } public MedicStorehouseInvenBuilder qty(Integer qty) { this.qty = qty; return this; } public MedicStorehouseInvenBuilder qtyLock(Integer qtyLock) { this.qtyLock = qtyLock; return this; } public MedicStorehouseInvenBuilder orderDetailId(Integer orderDetailId) { this.orderDetailId = orderDetailId; return this; } public MedicStorehouseInven build() { return new MedicStorehouseInven(this.invenId, this.storehouseId, this.productId, this.priceInput, this.price, this.priceIns, this.priceFee, this.priceHospital, this.priceRequest, this.priceSelling, this.batchNumber, this.vat, this.bidNumber, this.bidGroup, this.bidPackage, this.bidYear, this.expirationDateFe, this.expirationDate, this.productionDate, this.createdDate, this.updatedDate, this.qty, this.qtyLock, this.orderDetailId); } public String toString() { return "MedicStorehouseInven.MedicStorehouseInvenBuilder(invenId=" + this.invenId + ", storehouseId=" + this.storehouseId + ", productId=" + this.productId + ", priceInput=" + this.priceInput + ", price=" + this.price + ", priceIns=" + this.priceIns + ", priceFee=" + this.priceFee + ", priceHospital=" + this.priceHospital + ", priceRequest=" + this.priceRequest + ", priceSelling=" + this.priceSelling + ", batchNumber=" + this.batchNumber + ", vat=" + this.vat + ", bidNumber=" + this.bidNumber + ", bidGroup=" + this.bidGroup + ", bidPackage=" + this.bidPackage + ", bidYear=" + this.bidYear + ", expirationDateFe=" + this.expirationDateFe + ", expirationDate=" + this.expirationDate + ", productionDate=" + this.productionDate + ", createdDate=" + this.createdDate + ", updatedDate=" + this.updatedDate + ", qty=" + this.qty + ", qtyLock=" + this.qtyLock + ", orderDetailId=" + this.orderDetailId + ")"; }
/*     */      } public MedicStorehouseInven() {} public MedicStorehouseInven(Integer invenId, Integer storehouseId, Integer productId, Double priceInput, Double price, Double priceIns, Double priceFee, Double priceHospital, Double priceRequest, Double priceSelling, String batchNumber, Double vat, String bidNumber, String bidGroup, String bidPackage, String bidYear, String expirationDateFe, Date expirationDate, Date productionDate, Date createdDate, Date updatedDate, Integer qty, Integer qtyLock, Integer orderDetailId) {
/*  20 */     this.invenId = invenId; this.storehouseId = storehouseId; this.productId = productId; this.priceInput = priceInput; this.price = price; this.priceIns = priceIns; this.priceFee = priceFee; this.priceHospital = priceHospital; this.priceRequest = priceRequest; this.priceSelling = priceSelling; this.batchNumber = batchNumber; this.vat = vat; this.bidNumber = bidNumber; this.bidGroup = bidGroup; this.bidPackage = bidPackage; this.bidYear = bidYear; this.expirationDateFe = expirationDateFe; this.expirationDate = expirationDate; this.productionDate = productionDate; this.createdDate = createdDate; this.updatedDate = updatedDate; this.qty = qty; this.qtyLock = qtyLock; this.orderDetailId = orderDetailId;
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
/*     */   @Id
/*     */   @Column(name = "inven_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getInvenId() {
/*  53 */     return this.invenId;
/*     */   }
/*     */   
/*     */   public void setInvenId(Integer invenId) {
/*  57 */     this.invenId = invenId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_id")
/*     */   public Integer getStorehouseId() {
/*  63 */     return this.storehouseId;
/*     */   }
/*     */   
/*     */   public void setStorehouseId(Integer storehouseId) {
/*  67 */     this.storehouseId = storehouseId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_id")
/*     */   public Integer getProductId() {
/*  73 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Integer productId) {
/*  77 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_input")
/*     */   public Double getPriceInput() {
/*  83 */     return this.priceInput;
/*     */   }
/*     */   
/*     */   public void setPriceInput(Double priceInput) {
/*  87 */     this.priceInput = priceInput;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public Double getPrice() {
/*  93 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/*  97 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_ins")
/*     */   public Double getPriceIns() {
/* 103 */     return this.priceIns;
/*     */   }
/*     */   
/*     */   public void setPriceIns(Double priceIns) {
/* 107 */     this.priceIns = priceIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_fee")
/*     */   public Double getPriceFee() {
/* 113 */     return this.priceFee;
/*     */   }
/*     */   
/*     */   public void setPriceFee(Double priceFee) {
/* 117 */     this.priceFee = priceFee;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_hospital")
/*     */   public Double getPriceHospital() {
/* 123 */     return this.priceHospital;
/*     */   }
/*     */   
/*     */   public void setPriceHospital(Double priceHospital) {
/* 127 */     this.priceHospital = priceHospital;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_request")
/*     */   public Double getPriceRequest() {
/* 133 */     return this.priceRequest;
/*     */   }
/*     */   
/*     */   public void setPriceRequest(Double priceRequest) {
/* 137 */     this.priceRequest = priceRequest;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "batch_number")
/*     */   public String getBatchNumber() {
/* 143 */     return this.batchNumber;
/*     */   }
/*     */   
/*     */   public void setBatchNumber(String batchNumber) {
/* 147 */     this.batchNumber = batchNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "vat")
/*     */   public Double getVat() {
/* 153 */     return this.vat;
/*     */   }
/*     */   
/*     */   public void setVat(Double vat) {
/* 157 */     this.vat = vat;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_number")
/*     */   public String getBidNumber() {
/* 163 */     return this.bidNumber;
/*     */   }
/*     */   
/*     */   public void setBidNumber(String bidNumber) {
/* 167 */     this.bidNumber = bidNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_group")
/*     */   public String getBidGroup() {
/* 173 */     return this.bidGroup;
/*     */   }
/*     */   
/*     */   public void setBidGroup(String bidGroup) {
/* 177 */     this.bidGroup = bidGroup;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_package")
/*     */   public String getBidPackage() {
/* 183 */     return this.bidPackage;
/*     */   }
/*     */   
/*     */   public void setBidPackage(String bidPackage) {
/* 187 */     this.bidPackage = bidPackage;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_year")
/*     */   public String getBidYear() {
/* 193 */     return this.bidYear;
/*     */   }
/*     */   
/*     */   public void setBidYear(String bidYear) {
/* 197 */     this.bidYear = bidYear;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expiration_date_fe")
/*     */   public String getExpirationDateFe() {
/* 203 */     return this.expirationDateFe;
/*     */   }
/*     */   
/*     */   public void setExpirationDateFe(String expirationDateFe) {
/* 207 */     this.expirationDateFe = expirationDateFe;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "production_date")
/*     */   public Date getProductionDate() {
/* 213 */     return this.productionDate;
/*     */   }
/*     */   
/*     */   public void setProductionDate(Date productionDate) {
/* 217 */     this.productionDate = productionDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "qty")
/*     */   public Integer getQty() {
/* 223 */     return this.qty;
/*     */   }
/*     */   
/*     */   public void setQty(Integer qty) {
/* 227 */     this.qty = qty;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "qty_lock")
/*     */   public Integer getQtyLock() {
/* 233 */     return this.qtyLock;
/*     */   }
/*     */   
/*     */   public void setQtyLock(Integer qtyLock) {
/* 237 */     this.qtyLock = qtyLock;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expiration_date")
/*     */   public Date getExpirationDate() {
/* 243 */     return this.expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date expirationDate) {
/* 247 */     this.expirationDate = expirationDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_detail_id")
/*     */   public Integer getOrderDetailId() {
/* 253 */     return this.orderDetailId;
/*     */   }
/*     */   
/*     */   public void setOrderDetailId(Integer orderDetailId) {
/* 257 */     this.orderDetailId = orderDetailId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_selling")
/*     */   public Double getPriceSelling() {
/* 263 */     return this.priceSelling;
/*     */   }
/*     */   
/*     */   public void setPriceSelling(Double priceSelling) {
/* 267 */     this.priceSelling = priceSelling;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_date")
/*     */   public Date getCreatedDate() {
/* 273 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Date createdDate) {
/* 277 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_date")
/*     */   public Date getUpdatedDate() {
/* 283 */     return this.updatedDate;
/*     */   }
/*     */   
/*     */   public void setUpdatedDate(Date updatedDate) {
/* 287 */     this.updatedDate = updatedDate;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicStorehouseInven.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */