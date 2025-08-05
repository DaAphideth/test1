/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class CountryResponseBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String code;
/*    */   private String dialCode;
/*    */   private String lang;
/*    */   private int featured;
/*    */   
/* 12 */   public CountryResponseBuilder id(int id) { this.id = id; return this; } private Integer sort; private Integer status; private String area; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public CountryResponseBuilder name(String name) { this.name = name; return this; } public CountryResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public CountryResponseBuilder code(String code) { this.code = code; return this; } public CountryResponseBuilder dialCode(String dialCode) { this.dialCode = dialCode; return this; } public CountryResponseBuilder lang(String lang) { this.lang = lang; return this; } public CountryResponseBuilder featured(int featured) { this.featured = featured; return this; } public CountryResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public CountryResponseBuilder status(Integer status) { this.status = status; return this; } public CountryResponseBuilder area(String area) { this.area = area; return this; } public CountryResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public CountryResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public CountryResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public CountryResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public CountryResponse build() { return new CountryResponse(this.id, this.name, this.nameEn, this.code, this.dialCode, this.lang, this.featured, this.sort, this.status, this.area, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "CountryResponse.CountryResponseBuilder(id=" + this.id + ", name=" + this.name + ", nameEn=" + this.nameEn + ", code=" + this.code + ", dialCode=" + this.dialCode + ", lang=" + this.lang + ", featured=" + this.featured + ", sort=" + this.sort + ", status=" + this.status + ", area=" + this.area + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\CountryResponse$CountryResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */