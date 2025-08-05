/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ 
/*    */ public class DistrictResponseBuilder {
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String fullName;
/*    */   private String fullNameEn;
/*    */   
/* 12 */   public DistrictResponseBuilder id(int id) { this.id = id; return this; } private String codeName; private String provinceCode; private Integer administrativeUnitId; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; public DistrictResponseBuilder code(String code) { this.code = code; return this; } public DistrictResponseBuilder name(String name) { this.name = name; return this; } public DistrictResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public DistrictResponseBuilder fullName(String fullName) { this.fullName = fullName; return this; } public DistrictResponseBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public DistrictResponseBuilder codeName(String codeName) { this.codeName = codeName; return this; } public DistrictResponseBuilder provinceCode(String provinceCode) { this.provinceCode = provinceCode; return this; } public DistrictResponseBuilder administrativeUnitId(Integer administrativeUnitId) { this.administrativeUnitId = administrativeUnitId; return this; } public DistrictResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public DistrictResponseBuilder status(Integer status) { this.status = status; return this; } public DistrictResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public DistrictResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public DistrictResponse build() { return new DistrictResponse(this.id, this.code, this.name, this.nameEn, this.fullName, this.fullNameEn, this.codeName, this.provinceCode, this.administrativeUnitId, this.sort, this.status, this.createdAt, this.updatedAt); } public String toString() { return "DistrictResponse.DistrictResponseBuilder(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", nameEn=" + this.nameEn + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", codeName=" + this.codeName + ", provinceCode=" + this.provinceCode + ", administrativeUnitId=" + this.administrativeUnitId + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\DistrictResponse$DistrictResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */