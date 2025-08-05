/*     */ package nencer.app.Modules.Medic.Entity.Drugs;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_drugs", schema = "nencer_api")
/*     */ public class MedicDrugs
/*     */ {
/*     */   private Integer id;
/*     */   private String name;
/*     */   private String code;
/*     */   private String barCode;
/*     */   private Integer drugTypeId;
/*     */   private String registerNumber;
/*     */   private String ingredientIds;
/*     */   private Integer drugGroupId;
/*     */   private Integer unitId;
/*     */   private String drugContent;
/*     */   private String concentration;
/*     */   private String volume;
/*     */   private String countryCode;
/*     */   private Integer vendor;
/*     */   private String packing;
/*     */   private String atcCode;
/*     */   private String insuranceGroupId;
/*     */   private Integer antibiotic;
/*     */   private Integer newDrug;
/*     */   private Integer traditionalMedicineTaste;
/*     */   private Integer traditionalMedicineProduct;
/*     */   private Integer drugReceipt;
/*     */   private Integer functionalFood;
/*     */   private String inputPrice;
/*     */   private String price;
/*     */   private String priceIns;
/*     */   private Integer status;
/*     */   private Integer featured;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  49 */     return this.id.intValue();
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  53 */     this.id = Integer.valueOf(id);
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  59 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  63 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  69 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  73 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bar_code")
/*     */   public String getBarCode() {
/*  79 */     return this.barCode;
/*     */   }
/*     */   
/*     */   public void setBarCode(String barCode) {
/*  83 */     this.barCode = barCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "drug_type_id")
/*     */   public Integer getDrugTypeId() {
/*  89 */     return this.drugTypeId;
/*     */   }
/*     */   
/*     */   public void setDrugTypeId(Integer drugTypeId) {
/*  93 */     this.drugTypeId = drugTypeId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "register_number")
/*     */   public String getRegisterNumber() {
/*  99 */     return this.registerNumber;
/*     */   }
/*     */   
/*     */   public void setRegisterNumber(String registerNumber) {
/* 103 */     this.registerNumber = registerNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ingredient_ids")
/*     */   public String getIngredientIds() {
/* 109 */     return this.ingredientIds;
/*     */   }
/*     */   
/*     */   public void setIngredientIds(String ingredientIds) {
/* 113 */     this.ingredientIds = ingredientIds;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "drug_group_id")
/*     */   public Integer getDrugGroupId() {
/* 119 */     return this.drugGroupId;
/*     */   }
/*     */   
/*     */   public void setDrugGroupId(Integer drugGroupId) {
/* 123 */     this.drugGroupId = drugGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/* 129 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/* 133 */     this.unitId = unitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "drug_content")
/*     */   public String getDrugContent() {
/* 139 */     return this.drugContent;
/*     */   }
/*     */   
/*     */   public void setDrugContent(String drugContent) {
/* 143 */     this.drugContent = drugContent;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "concentration")
/*     */   public String getConcentration() {
/* 149 */     return this.concentration;
/*     */   }
/*     */   
/*     */   public void setConcentration(String concentration) {
/* 153 */     this.concentration = concentration;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "volume")
/*     */   public String getVolume() {
/* 159 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setVolume(String volume) {
/* 163 */     this.volume = volume;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 169 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 173 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "vendor")
/*     */   public Integer getVendor() {
/* 179 */     return this.vendor;
/*     */   }
/*     */   
/*     */   public void setVendor(Integer vendor) {
/* 183 */     this.vendor = vendor;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "packing")
/*     */   public String getPacking() {
/* 189 */     return this.packing;
/*     */   }
/*     */   
/*     */   public void setPacking(String packing) {
/* 193 */     this.packing = packing;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "atc_code")
/*     */   public String getAtcCode() {
/* 199 */     return this.atcCode;
/*     */   }
/*     */   
/*     */   public void setAtcCode(String atcCode) {
/* 203 */     this.atcCode = atcCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_group_id")
/*     */   public String getInsuranceGroupId() {
/* 209 */     return this.insuranceGroupId;
/*     */   }
/*     */   
/*     */   public void setInsuranceGroupId(String insuranceGroupId) {
/* 213 */     this.insuranceGroupId = insuranceGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "antibiotic")
/*     */   public Integer getAntibiotic() {
/* 219 */     return this.antibiotic;
/*     */   }
/*     */   
/*     */   public void setAntibiotic(Integer antibiotic) {
/* 223 */     this.antibiotic = antibiotic;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "new_drug")
/*     */   public Integer getNewDrug() {
/* 229 */     return this.newDrug;
/*     */   }
/*     */   
/*     */   public void setNewDrug(Integer newDrug) {
/* 233 */     this.newDrug = newDrug;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "traditional_medicine_taste")
/*     */   public Integer getTraditionalMedicineTaste() {
/* 239 */     return this.traditionalMedicineTaste;
/*     */   }
/*     */   
/*     */   public void setTraditionalMedicineTaste(Integer traditionalMedicineTaste) {
/* 243 */     this.traditionalMedicineTaste = traditionalMedicineTaste;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "traditional_medicine_product")
/*     */   public Integer getTraditionalMedicineProduct() {
/* 249 */     return this.traditionalMedicineProduct;
/*     */   }
/*     */   
/*     */   public void setTraditionalMedicineProduct(Integer traditionalMedicineProduct) {
/* 253 */     this.traditionalMedicineProduct = traditionalMedicineProduct;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "drug_receipt")
/*     */   public Integer getDrugReceipt() {
/* 259 */     return this.drugReceipt;
/*     */   }
/*     */   
/*     */   public void setDrugReceipt(Integer drugReceipt) {
/* 263 */     this.drugReceipt = drugReceipt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "functional_food")
/*     */   public Integer getFunctionalFood() {
/* 269 */     return this.functionalFood;
/*     */   }
/*     */   
/*     */   public void setFunctionalFood(Integer functionalFood) {
/* 273 */     this.functionalFood = functionalFood;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "input_price")
/*     */   public String getInputPrice() {
/* 279 */     return this.inputPrice;
/*     */   }
/*     */   
/*     */   public void setInputPrice(String inputPrice) {
/* 283 */     this.inputPrice = inputPrice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public String getPrice() {
/* 289 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(String price) {
/* 293 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_ins")
/*     */   public String getPriceIns() {
/* 299 */     return this.priceIns;
/*     */   }
/*     */   
/*     */   public void setPriceIns(String priceIns) {
/* 303 */     this.priceIns = priceIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 309 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 313 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public Integer getFeatured() {
/* 319 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(Integer featured) {
/* 323 */     this.featured = featured;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 329 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 333 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 339 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 343 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Drugs\MedicDrugs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */