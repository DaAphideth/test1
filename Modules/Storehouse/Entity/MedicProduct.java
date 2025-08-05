/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
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
/*     */ @Entity
/*     */ @Table(name = "medic_product")
/*     */ public class MedicProduct
/*     */ {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String unit;
/*     */   private Integer unitId;
/*     */   private String activeIng;
/*     */   private String activeIngCode;
/*     */   private String concentration;
/*     */   private String volume;
/*     */   private String usageProduct;
/*     */   private String atc;
/*     */   private String clinicalPharm;
/*     */   private String registerNumber;
/*     */   private String producer;
/*     */   private String description;
/*     */   private String featured;
/*     */   private Integer catId;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  54 */     return this.id;
/*     */   }
/*     */   private String image; private String countryCode; private String brandCode; private String creatorId; private String updaterId; private Integer status; private Date createdAt; private Date updatedAt; private String productSrc; private String productType; private Integer hospitalId; private Integer insuranceId; private String productPacking; private String nameIns; private Integer rightRate; private Integer offlineRate; private Integer expiredDay;
/*     */   public void setId(int id) {
/*  58 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   @JsonProperty("productCode")
/*     */   public String getCode() {
/*  65 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  69 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  75 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  79 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit")
/*     */   public String getUnit() {
/*  85 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/*  89 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/*  95 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/*  99 */     this.unitId = unitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "active_ing")
/*     */   public String getActiveIng() {
/* 105 */     return this.activeIng;
/*     */   }
/*     */   
/*     */   public void setActiveIng(String activeIng) {
/* 109 */     this.activeIng = activeIng;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "concentration")
/*     */   public String getConcentration() {
/* 115 */     return this.concentration;
/*     */   }
/*     */   
/*     */   public void setConcentration(String concentration) {
/* 119 */     this.concentration = concentration;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "volume")
/*     */   public String getVolume() {
/* 125 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setVolume(String volume) {
/* 129 */     this.volume = volume;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "usage_product")
/*     */   public String getUsageProduct() {
/* 135 */     return this.usageProduct;
/*     */   }
/*     */   
/*     */   public void setUsageProduct(String usageProduct) {
/* 139 */     this.usageProduct = usageProduct;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "atc")
/*     */   public String getAtc() {
/* 145 */     return this.atc;
/*     */   }
/*     */   
/*     */   public void setAtc(String atc) {
/* 149 */     this.atc = atc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "clinical_pharm")
/*     */   public String getClinicalPharm() {
/* 155 */     return this.clinicalPharm;
/*     */   }
/*     */   
/*     */   public void setClinicalPharm(String clinicalPharm) {
/* 159 */     this.clinicalPharm = clinicalPharm;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "register_number")
/*     */   public String getRegisterNumber() {
/* 165 */     return this.registerNumber;
/*     */   }
/*     */   
/*     */   public void setRegisterNumber(String registerNumber) {
/* 169 */     this.registerNumber = registerNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "producer")
/*     */   public String getProducer() {
/* 175 */     return this.producer;
/*     */   }
/*     */   
/*     */   public void setProducer(String producer) {
/* 179 */     this.producer = producer;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 185 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 189 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public String getFeatured() {
/* 195 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(String featured) {
/* 199 */     this.featured = featured;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "cat_id")
/*     */   public Integer getCatId() {
/* 205 */     return this.catId;
/*     */   }
/*     */   
/*     */   public void setCatId(Integer catId) {
/* 209 */     this.catId = catId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/* 215 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/* 219 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 225 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 229 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "brand_code")
/*     */   public String getBrandCode() {
/* 235 */     return this.brandCode;
/*     */   }
/*     */   
/*     */   public void setBrandCode(String brandCode) {
/* 239 */     this.brandCode = brandCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public String getCreatorId() {
/* 245 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String creatorId) {
/* 249 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 255 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 259 */     this.updaterId = updaterId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 265 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 269 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 275 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 279 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 285 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 289 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_type")
/*     */   public String getProductType() {
/* 295 */     return this.productType;
/*     */   }
/*     */   
/*     */   public void setProductType(String productType) {
/* 299 */     this.productType = productType;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getProductSrc() {
/* 304 */     return this.productSrc;
/*     */   }
/*     */   
/*     */   public void setProductSrc(String productSrc) {
/* 308 */     this.productSrc = productSrc;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_id")
/*     */   public Integer getHospitalId() {
/* 314 */     return this.hospitalId;
/*     */   }
/*     */   
/*     */   public void setHospitalId(Integer hospitalId) {
/* 318 */     this.hospitalId = hospitalId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_id")
/*     */   public Integer getInsuranceId() {
/* 324 */     return this.insuranceId;
/*     */   }
/*     */   
/*     */   public void setInsuranceId(Integer insuranceId) {
/* 328 */     this.insuranceId = insuranceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_packing")
/*     */   public String getProductPacking() {
/* 334 */     return this.productPacking;
/*     */   }
/*     */   
/*     */   public void setProductPacking(String productPacking) {
/* 338 */     this.productPacking = productPacking;
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
/*     */   @Column(name = "active_ing_code")
/*     */   public String getActiveIngCode() {
/* 387 */     return this.activeIngCode;
/*     */   }
/*     */   
/*     */   public void setActiveIngCode(String activeIngCode) {
/* 391 */     this.activeIngCode = activeIngCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_ins")
/*     */   public String getNameIns() {
/* 397 */     return this.nameIns;
/*     */   }
/*     */   
/*     */   public void setNameIns(String nameIns) {
/* 401 */     this.nameIns = nameIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "right_rate")
/*     */   public Integer getRightRate() {
/* 407 */     return this.rightRate;
/*     */   }
/*     */   
/*     */   public void setRightRate(Integer rightRate) {
/* 411 */     this.rightRate = rightRate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "offline_rate")
/*     */   public Integer getOffLineRate() {
/* 417 */     return this.offlineRate;
/*     */   }
/*     */   
/*     */   public void setOffLineRate(Integer offlineRate) {
/* 421 */     this.offlineRate = offlineRate;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expired_day")
/*     */   public Integer getExpiredDay() {
/* 428 */     return this.expiredDay;
/*     */   }
/*     */   
/*     */   public void setExpiredDay(Integer expiredDay) {
/* 432 */     this.expiredDay = expiredDay;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProduct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */