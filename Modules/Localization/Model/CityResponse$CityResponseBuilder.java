/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class CityResponseBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String code;
/*    */   private String countryCode;
/*    */   private String region;
/*    */   private String type;
/*    */   
/* 12 */   public CityResponseBuilder id(int id) { this.id = id; return this; } private int featured; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public CityResponseBuilder name(String name) { this.name = name; return this; } public CityResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public CityResponseBuilder code(String code) { this.code = code; return this; } public CityResponseBuilder countryCode(String countryCode) { this.countryCode = countryCode; return this; } public CityResponseBuilder region(String region) { this.region = region; return this; } public CityResponseBuilder type(String type) { this.type = type; return this; } public CityResponseBuilder featured(int featured) { this.featured = featured; return this; } public CityResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public CityResponseBuilder status(Integer status) { this.status = status; return this; } public CityResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public CityResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public CityResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public CityResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public CityResponse build() { return new CityResponse(this.id, this.name, this.nameEn, this.code, this.countryCode, this.region, this.type, this.featured, this.sort, this.status, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "CityResponse.CityResponseBuilder(id=" + this.id + ", name=" + this.name + ", nameEn=" + this.nameEn + ", code=" + this.code + ", countryCode=" + this.countryCode + ", region=" + this.region + ", type=" + this.type + ", featured=" + this.featured + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\CityResponse$CityResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */