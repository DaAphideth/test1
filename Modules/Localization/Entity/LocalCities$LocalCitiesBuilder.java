/*    */ package nencer.app.Modules.Localization.Entity;
/*    */ 
/*    */ public class LocalCitiesBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String code;
/*    */   private String countryCode;
/*    */   private String region;
/*    */   private String type;
/*    */   private int featured;
/*    */   private Integer sort;
/*    */   private Integer status;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   private LocalCountries localCountries;
/*    */   private LocalRegions localRegions;
/*    */   
/* 19 */   public LocalCitiesBuilder id(int id) { this.id = id; return this; } public LocalCitiesBuilder name(String name) { this.name = name; return this; } public LocalCitiesBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public LocalCitiesBuilder code(String code) { this.code = code; return this; } public LocalCitiesBuilder countryCode(String countryCode) { this.countryCode = countryCode; return this; } public LocalCitiesBuilder region(String region) { this.region = region; return this; } public LocalCitiesBuilder type(String type) { this.type = type; return this; } public LocalCitiesBuilder featured(int featured) { this.featured = featured; return this; } public LocalCitiesBuilder sort(Integer sort) { this.sort = sort; return this; } public LocalCitiesBuilder status(Integer status) { this.status = status; return this; } public LocalCitiesBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LocalCitiesBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LocalCitiesBuilder localCountries(LocalCountries localCountries) { this.localCountries = localCountries; return this; } public LocalCitiesBuilder localRegions(LocalRegions localRegions) { this.localRegions = localRegions; return this; } public LocalCities build() { return new LocalCities(this.id, this.name, this.nameEn, this.code, this.countryCode, this.region, this.type, this.featured, this.sort, this.status, this.createdAt, this.updatedAt, this.localCountries, this.localRegions); } public String toString() { return "LocalCities.LocalCitiesBuilder(id=" + this.id + ", name=" + this.name + ", nameEn=" + this.nameEn + ", code=" + this.code + ", countryCode=" + this.countryCode + ", region=" + this.region + ", type=" + this.type + ", featured=" + this.featured + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", localCountries=" + this.localCountries + ", localRegions=" + this.localRegions + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalCities$LocalCitiesBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */