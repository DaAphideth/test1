/*    */ package nencer.app.Modules.Localization.Model;
/*    */ public class CountryRequest { private Long id; @NotNull(message = "804")
/*    */   private String name;
/*    */   private String nameEn;
/*    */   @NotNull(message = "804")
/*    */   private String code;
/*    */   private String dialCode;
/*    */   private String lang;
/*    */   
/* 10 */   public void setId(Long id) { this.id = id; } private int featured; private Integer sort; private Integer status; private String area; private Date createdAt; private Date updatedAt; public void setName(String name) { this.name = name; } public void setNameEn(String nameEn) { this.nameEn = nameEn; } public void setCode(String code) { this.code = code; } public void setDialCode(String dialCode) { this.dialCode = dialCode; } public void setLang(String lang) { this.lang = lang; } public void setFeatured(int featured) { this.featured = featured; } public void setSort(Integer sort) { this.sort = sort; } public void setStatus(Integer status) { this.status = status; } public void setArea(String area) { this.area = area; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CountryRequest)) return false;  CountryRequest other = (CountryRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameEn = getNameEn(), other$nameEn = other.getNameEn(); if ((this$nameEn == null) ? (other$nameEn != null) : !this$nameEn.equals(other$nameEn)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$dialCode = getDialCode(), other$dialCode = other.getDialCode(); if ((this$dialCode == null) ? (other$dialCode != null) : !this$dialCode.equals(other$dialCode)) return false;  Object this$lang = getLang(), other$lang = other.getLang(); if ((this$lang == null) ? (other$lang != null) : !this$lang.equals(other$lang)) return false;  if (getFeatured() != other.getFeatured()) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$area = getArea(), other$area = other.getArea(); if ((this$area == null) ? (other$area != null) : !this$area.equals(other$area)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof CountryRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameEn = getNameEn(); result = result * 59 + (($nameEn == null) ? 43 : $nameEn.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $dialCode = getDialCode(); result = result * 59 + (($dialCode == null) ? 43 : $dialCode.hashCode()); Object $lang = getLang(); result = result * 59 + (($lang == null) ? 43 : $lang.hashCode()); result = result * 59 + getFeatured(); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $area = getArea(); result = result * 59 + (($area == null) ? 43 : $area.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "CountryRequest(id=" + getId() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", code=" + getCode() + ", dialCode=" + getDialCode() + ", lang=" + getLang() + ", featured=" + getFeatured() + ", sort=" + getSort() + ", status=" + getStatus() + ", area=" + getArea() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public CountryRequest() {} public CountryRequest(Long id, String name, String nameEn, String code, String dialCode, String lang, int featured, Integer sort, Integer status, String area, Date createdAt, Date updatedAt) {
/* 12 */     this.id = id; this.name = name; this.nameEn = nameEn; this.code = code; this.dialCode = dialCode; this.lang = lang; this.featured = featured; this.sort = sort; this.status = status; this.area = area; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   } public Long getId() {
/* 14 */     return this.id;
/*    */   }
/* 16 */   public String getName() { return this.name; } public String getNameEn() {
/* 17 */     return this.nameEn;
/*    */   }
/* 19 */   public String getCode() { return this.code; }
/* 20 */   public String getDialCode() { return this.dialCode; }
/* 21 */   public String getLang() { return this.lang; }
/* 22 */   public int getFeatured() { return this.featured; }
/* 23 */   public Integer getSort() { return this.sort; }
/* 24 */   public Integer getStatus() { return this.status; }
/* 25 */   public String getArea() { return this.area; }
/* 26 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 27 */     return this.updatedAt;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\CountryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */