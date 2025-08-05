/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class RegionRequest {
/*    */   private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   private String nameEn;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String codeName; private String codeNameEn; private Integer sort; private Integer status; public void setName(String name) { this.name = name; } public void setNameEn(String nameEn) { this.nameEn = nameEn; } public void setCodeName(String codeName) { this.codeName = codeName; } public void setCodeNameEn(String codeNameEn) { this.codeNameEn = codeNameEn; } public void setSort(Integer sort) { this.sort = sort; } public void setStatus(Integer status) { this.status = status; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof RegionRequest)) return false;  RegionRequest other = (RegionRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameEn = getNameEn(), other$nameEn = other.getNameEn(); if ((this$nameEn == null) ? (other$nameEn != null) : !this$nameEn.equals(other$nameEn)) return false;  Object this$codeName = getCodeName(), other$codeName = other.getCodeName(); if ((this$codeName == null) ? (other$codeName != null) : !this$codeName.equals(other$codeName)) return false;  Object this$codeNameEn = getCodeNameEn(), other$codeNameEn = other.getCodeNameEn(); if ((this$codeNameEn == null) ? (other$codeNameEn != null) : !this$codeNameEn.equals(other$codeNameEn)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); return !((this$status == null) ? (other$status != null) : !this$status.equals(other$status)); } protected boolean canEqual(Object other) { return other instanceof RegionRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameEn = getNameEn(); result = result * 59 + (($nameEn == null) ? 43 : $nameEn.hashCode()); Object $codeName = getCodeName(); result = result * 59 + (($codeName == null) ? 43 : $codeName.hashCode()); Object $codeNameEn = getCodeNameEn(); result = result * 59 + (($codeNameEn == null) ? 43 : $codeNameEn.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $status = getStatus(); return result * 59 + (($status == null) ? 43 : $status.hashCode()); } public String toString() { return "RegionRequest(id=" + getId() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", codeName=" + getCodeName() + ", codeNameEn=" + getCodeNameEn() + ", sort=" + getSort() + ", status=" + getStatus() + ")"; }
/*    */    public RegionRequest() {} public RegionRequest(Integer id, String name, String nameEn, String codeName, String codeNameEn, Integer sort, Integer status) {
/* 11 */     this.id = id; this.name = name; this.nameEn = nameEn; this.codeName = codeName; this.codeNameEn = codeNameEn; this.sort = sort; this.status = status;
/*    */   } public Integer getId() {
/* 13 */     return this.id;
/*    */   }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getNameEn() { return this.nameEn; }
/* 17 */   public String getCodeName() { return this.codeName; }
/* 18 */   public String getCodeNameEn() { return this.codeNameEn; }
/* 19 */   public Integer getSort() { return this.sort; } public Integer getStatus() {
/* 20 */     return this.status;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\RegionRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */