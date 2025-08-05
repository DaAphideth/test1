/*    */ package nencer.app.Modules.Localization.Model;
/*    */ public class CityRequest { private Long id; @NotNull(message = "804")
/*    */   private String name; private String nameEn;
/*    */   @NotNull(message = "804")
/*    */   private String code;
/*    */   @NotNull(message = "804")
/*    */   private String countryCode;
/*    */   
/*  9 */   public void setId(Long id) { this.id = id; } private String region; private String type; private int featured; private Integer sort; private Integer status; public void setName(String name) { this.name = name; } public void setNameEn(String nameEn) { this.nameEn = nameEn; } public void setCode(String code) { this.code = code; } public void setCountryCode(String countryCode) { this.countryCode = countryCode; } public void setRegion(String region) { this.region = region; } public void setType(String type) { this.type = type; } public void setFeatured(int featured) { this.featured = featured; } public void setSort(Integer sort) { this.sort = sort; } public void setStatus(Integer status) { this.status = status; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CityRequest)) return false;  CityRequest other = (CityRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameEn = getNameEn(), other$nameEn = other.getNameEn(); if ((this$nameEn == null) ? (other$nameEn != null) : !this$nameEn.equals(other$nameEn)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$countryCode = getCountryCode(), other$countryCode = other.getCountryCode(); if ((this$countryCode == null) ? (other$countryCode != null) : !this$countryCode.equals(other$countryCode)) return false;  Object this$region = getRegion(), other$region = other.getRegion(); if ((this$region == null) ? (other$region != null) : !this$region.equals(other$region)) return false;  Object this$type = getType(), other$type = other.getType(); if ((this$type == null) ? (other$type != null) : !this$type.equals(other$type)) return false;  if (getFeatured() != other.getFeatured()) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); return !((this$status == null) ? (other$status != null) : !this$status.equals(other$status)); } protected boolean canEqual(Object other) { return other instanceof CityRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameEn = getNameEn(); result = result * 59 + (($nameEn == null) ? 43 : $nameEn.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $countryCode = getCountryCode(); result = result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode()); Object $region = getRegion(); result = result * 59 + (($region == null) ? 43 : $region.hashCode()); Object $type = getType(); result = result * 59 + (($type == null) ? 43 : $type.hashCode()); result = result * 59 + getFeatured(); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $status = getStatus(); return result * 59 + (($status == null) ? 43 : $status.hashCode()); } public String toString() { return "CityRequest(id=" + getId() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", code=" + getCode() + ", countryCode=" + getCountryCode() + ", region=" + getRegion() + ", type=" + getType() + ", featured=" + getFeatured() + ", sort=" + getSort() + ", status=" + getStatus() + ")"; }
/*    */    public CityRequest() {} public CityRequest(Long id, String name, String nameEn, String code, String countryCode, String region, String type, int featured, Integer sort, Integer status) {
/* 11 */     this.id = id; this.name = name; this.nameEn = nameEn; this.code = code; this.countryCode = countryCode; this.region = region; this.type = type; this.featured = featured; this.sort = sort; this.status = status;
/*    */   } public Long getId() {
/* 13 */     return this.id;
/*    */   }
/* 15 */   public String getName() { return this.name; } public String getNameEn() {
/* 16 */     return this.nameEn;
/*    */   } public String getCode() {
/* 18 */     return this.code;
/*    */   }
/* 20 */   public String getCountryCode() { return this.countryCode; }
/* 21 */   public String getRegion() { return this.region; }
/* 22 */   public String getType() { return this.type; }
/* 23 */   public int getFeatured() { return this.featured; }
/* 24 */   public Integer getSort() { return this.sort; } public Integer getStatus() {
/* 25 */     return this.status;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\CityRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */