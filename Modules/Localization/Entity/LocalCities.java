/*     */ package nencer.app.Modules.Localization.Entity;@Entity
/*     */ @Table(name = "local_cities")
/*     */ public class LocalCities { private int id; private String name; private String nameEn;
/*     */   private String code;
/*     */   private String countryCode;
/*     */   private String region;
/*     */   private String type;
/*     */   private int featured;
/*     */   private Integer sort;
/*     */   private Integer status;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   private LocalCountries localCountries;
/*     */   private LocalRegions localRegions;
/*     */   
/*     */   public LocalCities(int id, String name, String nameEn, String code, String countryCode, String region, String type, int featured, Integer sort, Integer status, Date createdAt, Date updatedAt, LocalCountries localCountries, LocalRegions localRegions) {
/*  17 */     this.id = id; this.name = name; this.nameEn = nameEn; this.code = code; this.countryCode = countryCode; this.region = region; this.type = type; this.featured = featured; this.sort = sort; this.status = status; this.createdAt = createdAt; this.updatedAt = updatedAt; this.localCountries = localCountries; this.localRegions = localRegions;
/*     */   } public LocalCities() {}
/*  19 */   public static LocalCitiesBuilder builder() { return new LocalCitiesBuilder(); } public static class LocalCitiesBuilder { private int id; private String name; private String nameEn; private String code; private String countryCode; private String region; private String type; public LocalCitiesBuilder id(int id) { this.id = id; return this; } private int featured; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private LocalCountries localCountries; private LocalRegions localRegions; public LocalCitiesBuilder name(String name) { this.name = name; return this; } public LocalCitiesBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public LocalCitiesBuilder code(String code) { this.code = code; return this; } public LocalCitiesBuilder countryCode(String countryCode) { this.countryCode = countryCode; return this; } public LocalCitiesBuilder region(String region) { this.region = region; return this; } public LocalCitiesBuilder type(String type) { this.type = type; return this; } public LocalCitiesBuilder featured(int featured) { this.featured = featured; return this; } public LocalCitiesBuilder sort(Integer sort) { this.sort = sort; return this; } public LocalCitiesBuilder status(Integer status) { this.status = status; return this; } public LocalCitiesBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LocalCitiesBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LocalCitiesBuilder localCountries(LocalCountries localCountries) { this.localCountries = localCountries; return this; } public LocalCitiesBuilder localRegions(LocalRegions localRegions) { this.localRegions = localRegions; return this; } public LocalCities build() { return new LocalCities(this.id, this.name, this.nameEn, this.code, this.countryCode, this.region, this.type, this.featured, this.sort, this.status, this.createdAt, this.updatedAt, this.localCountries, this.localRegions); } public String toString() { return "LocalCities.LocalCitiesBuilder(id=" + this.id + ", name=" + this.name + ", nameEn=" + this.nameEn + ", code=" + this.code + ", countryCode=" + this.countryCode + ", region=" + this.region + ", type=" + this.type + ", featured=" + this.featured + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", localCountries=" + this.localCountries + ", localRegions=" + this.localRegions + ")"; } } public String toString() {
/*  20 */     return "LocalCities(id=" + getId() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", code=" + getCode() + ", countryCode=" + getCountryCode() + ", region=" + getRegion() + ", type=" + getType() + ", featured=" + getFeatured() + ", sort=" + getSort() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", localCountries=" + getLocalCountries() + ", localRegions=" + getLocalRegions() + ")";
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
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  40 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  44 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  50 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  54 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_en")
/*     */   public String getNameEn() {
/*  60 */     return this.nameEn;
/*     */   }
/*     */   
/*     */   public void setNameEn(String nameEn) {
/*  64 */     this.nameEn = nameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  70 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  74 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/*  80 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/*  84 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "region")
/*     */   public String getRegion() {
/*  90 */     return this.region;
/*     */   }
/*     */   
/*     */   public void setRegion(String region) {
/*  94 */     this.region = region;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/* 100 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 104 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public int getFeatured() {
/* 110 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(int featured) {
/* 114 */     this.featured = featured;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 120 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 124 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 130 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 134 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 140 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 144 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 150 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 154 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "country_code", foreignKey = @ForeignKey(name = "cities_countries"), referencedColumnName = "code", nullable = true, updatable = false, insertable = false)
/*     */   public LocalCountries getLocalCountries() {
/* 160 */     return this.localCountries;
/*     */   }
/*     */   
/*     */   public void setLocalCountries(LocalCountries localCountries) {
/* 164 */     this.localCountries = localCountries;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "region", nullable = true, updatable = false, insertable = false)
/*     */   public LocalRegions getLocalRegions() {
/* 172 */     return this.localRegions;
/*     */   }
/*     */   
/*     */   public void setLocalRegions(LocalRegions localRegions) {
/* 176 */     this.localRegions = localRegions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 183 */     if (this == o) return true; 
/* 184 */     if (o == null || getClass() != o.getClass()) return false; 
/* 185 */     LocalCities that = (LocalCities)o;
/* 186 */     return (this.id == that.id && this.featured == that.featured && this.status == that.status && Objects.equals(this.name, that.name) && Objects.equals(this.nameEn, that.nameEn) && Objects.equals(this.code, that.code) && Objects.equals(this.region, that.region) && Objects.equals(this.type, that.type) && Objects.equals(this.sort, that.sort) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 191 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.nameEn, this.code, this.region, this.type, Integer.valueOf(this.featured), this.sort, this.status, this.createdAt, this.updatedAt });
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalCities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */