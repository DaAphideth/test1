/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class ProvinceResponseBuilder {
/*    */   private Integer id;
/*    */   private String code;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String fullName;
/*    */   private String fullNameEn;
/*    */   private String codeName;
/*    */   private Integer administrativeUnitId;
/*    */   
/* 13 */   public ProvinceResponseBuilder id(Integer id) { this.id = id; return this; } private Integer administrativeRegionId; private Integer featured; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public ProvinceResponseBuilder code(String code) { this.code = code; return this; } public ProvinceResponseBuilder name(String name) { this.name = name; return this; } public ProvinceResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public ProvinceResponseBuilder fullName(String fullName) { this.fullName = fullName; return this; } public ProvinceResponseBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public ProvinceResponseBuilder codeName(String codeName) { this.codeName = codeName; return this; } public ProvinceResponseBuilder administrativeUnitId(Integer administrativeUnitId) { this.administrativeUnitId = administrativeUnitId; return this; } public ProvinceResponseBuilder administrativeRegionId(Integer administrativeRegionId) { this.administrativeRegionId = administrativeRegionId; return this; } public ProvinceResponseBuilder featured(Integer featured) { this.featured = featured; return this; } public ProvinceResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public ProvinceResponseBuilder status(Integer status) { this.status = status; return this; } public ProvinceResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public ProvinceResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public ProvinceResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public ProvinceResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public ProvinceResponse build() { return new ProvinceResponse(this.id, this.code, this.name, this.nameEn, this.fullName, this.fullNameEn, this.codeName, this.administrativeUnitId, this.administrativeRegionId, this.featured, this.sort, this.status, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "ProvinceResponse.ProvinceResponseBuilder(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", nameEn=" + this.nameEn + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", codeName=" + this.codeName + ", administrativeUnitId=" + this.administrativeUnitId + ", administrativeRegionId=" + this.administrativeRegionId + ", featured=" + this.featured + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\ProvinceResponse$ProvinceResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */