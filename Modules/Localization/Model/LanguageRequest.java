/*    */ package nencer.app.Modules.Localization.Model;
/*    */ public class LanguageRequest { private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   @NotNull(message = "804")
/*    */   private String code;
/*    */   private String flag;
/*    */   private String hreflang;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } private String charset; private int isDefault; private int status; private int installed; private int sort; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setFlag(String flag) { this.flag = flag; } public void setHreflang(String hreflang) { this.hreflang = hreflang; } public void setCharset(String charset) { this.charset = charset; } public void setIsDefault(int isDefault) { this.isDefault = isDefault; } public void setStatus(int status) { this.status = status; } public void setInstalled(int installed) { this.installed = installed; } public void setSort(int sort) { this.sort = sort; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LanguageRequest)) return false;  LanguageRequest other = (LanguageRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$flag = getFlag(), other$flag = other.getFlag(); if ((this$flag == null) ? (other$flag != null) : !this$flag.equals(other$flag)) return false;  Object this$hreflang = getHreflang(), other$hreflang = other.getHreflang(); if ((this$hreflang == null) ? (other$hreflang != null) : !this$hreflang.equals(other$hreflang)) return false;  Object this$charset = getCharset(), other$charset = other.getCharset(); return ((this$charset == null) ? (other$charset != null) : !this$charset.equals(other$charset)) ? false : ((getIsDefault() != other.getIsDefault()) ? false : ((getStatus() != other.getStatus()) ? false : ((getInstalled() != other.getInstalled()) ? false : (!(getSort() != other.getSort()))))); } protected boolean canEqual(Object other) { return other instanceof LanguageRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $flag = getFlag(); result = result * 59 + (($flag == null) ? 43 : $flag.hashCode()); Object $hreflang = getHreflang(); result = result * 59 + (($hreflang == null) ? 43 : $hreflang.hashCode()); Object $charset = getCharset(); result = result * 59 + (($charset == null) ? 43 : $charset.hashCode()); result = result * 59 + getIsDefault(); result = result * 59 + getStatus(); result = result * 59 + getInstalled(); return result * 59 + getSort(); } public String toString() { return "LanguageRequest(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", flag=" + getFlag() + ", hreflang=" + getHreflang() + ", charset=" + getCharset() + ", isDefault=" + getIsDefault() + ", status=" + getStatus() + ", installed=" + getInstalled() + ", sort=" + getSort() + ")"; }
/*    */    public LanguageRequest() {} public LanguageRequest(Integer id, String name, String code, String flag, String hreflang, String charset, int isDefault, int status, int installed, int sort) {
/* 12 */     this.id = id; this.name = name; this.code = code; this.flag = flag; this.hreflang = hreflang; this.charset = charset; this.isDefault = isDefault; this.status = status; this.installed = installed; this.sort = sort;
/*    */   } public Integer getId() {
/* 14 */     return this.id;
/*    */   } public String getName() {
/* 16 */     return this.name;
/*    */   }
/* 18 */   public String getCode() { return this.code; }
/* 19 */   public String getFlag() { return this.flag; }
/* 20 */   public String getHreflang() { return this.hreflang; }
/* 21 */   public String getCharset() { return this.charset; }
/* 22 */   public int getIsDefault() { return this.isDefault; }
/* 23 */   public int getStatus() { return this.status; }
/* 24 */   public int getInstalled() { return this.installed; } public int getSort() {
/* 25 */     return this.sort;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\LanguageRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */