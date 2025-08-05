/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class WardResponseBuilder {
/*    */   private Integer id;
/*    */   private String code;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String fullName;
/*    */   private String fullNameEn;
/*    */   private String codeName;
/*    */   private String districtCode;
/*    */   
/* 13 */   public WardResponseBuilder id(Integer id) { this.id = id; return this; } private String shortCode; private Integer administrativeUnitId; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public WardResponseBuilder code(String code) { this.code = code; return this; } public WardResponseBuilder name(String name) { this.name = name; return this; } public WardResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public WardResponseBuilder fullName(String fullName) { this.fullName = fullName; return this; } public WardResponseBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public WardResponseBuilder codeName(String codeName) { this.codeName = codeName; return this; } public WardResponseBuilder districtCode(String districtCode) { this.districtCode = districtCode; return this; } public WardResponseBuilder shortCode(String shortCode) { this.shortCode = shortCode; return this; } public WardResponseBuilder administrativeUnitId(Integer administrativeUnitId) { this.administrativeUnitId = administrativeUnitId; return this; } public WardResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public WardResponseBuilder status(Integer status) { this.status = status; return this; } public WardResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public WardResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public WardResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public WardResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public WardResponse build() { return new WardResponse(this.id, this.code, this.name, this.nameEn, this.fullName, this.fullNameEn, this.codeName, this.districtCode, this.shortCode, this.administrativeUnitId, this.sort, this.status, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "WardResponse.WardResponseBuilder(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", nameEn=" + this.nameEn + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", codeName=" + this.codeName + ", districtCode=" + this.districtCode + ", shortCode=" + this.shortCode + ", administrativeUnitId=" + this.administrativeUnitId + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\WardResponse$WardResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */