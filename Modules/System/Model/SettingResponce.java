/*    */ package nencer.app.Modules.System.Model;public class SettingResponce { private int id;
/*    */   private String key;
/*    */   private String value;
/*    */   private String valueArr;
/*    */   private String tab;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   private String updatedAtDis;
/*    */   private String createdAtDis;
/*    */   
/* 11 */   public void setId(int id) { this.id = id; } public void setKey(String key) { this.key = key; } public void setValue(String value) { this.value = value; } public void setValueArr(String valueArr) { this.valueArr = valueArr; } public void setTab(String tab) { this.tab = tab; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SettingResponce)) return false;  SettingResponce other = (SettingResponce)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$key = getKey(), other$key = other.getKey(); if ((this$key == null) ? (other$key != null) : !this$key.equals(other$key)) return false;  Object this$value = getValue(), other$value = other.getValue(); if ((this$value == null) ? (other$value != null) : !this$value.equals(other$value)) return false;  Object this$valueArr = getValueArr(), other$valueArr = other.getValueArr(); if ((this$valueArr == null) ? (other$valueArr != null) : !this$valueArr.equals(other$valueArr)) return false;  Object this$tab = getTab(), other$tab = other.getTab(); if ((this$tab == null) ? (other$tab != null) : !this$tab.equals(other$tab)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof SettingResponce; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $key = getKey(); result = result * 59 + (($key == null) ? 43 : $key.hashCode()); Object $value = getValue(); result = result * 59 + (($value == null) ? 43 : $value.hashCode()); Object $valueArr = getValueArr(); result = result * 59 + (($valueArr == null) ? 43 : $valueArr.hashCode()); Object $tab = getTab(); result = result * 59 + (($tab == null) ? 43 : $tab.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "SettingResponce(id=" + getId() + ", key=" + getKey() + ", value=" + getValue() + ", valueArr=" + getValueArr() + ", tab=" + getTab() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public SettingResponce() {}
/* 13 */   public SettingResponce(int id, String key, String value, String valueArr, String tab, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) { this.id = id; this.key = key; this.value = value; this.valueArr = valueArr; this.tab = tab; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis; }
/* 14 */   public static SettingResponceBuilder builder() { return new SettingResponceBuilder(); } public static class SettingResponceBuilder { private int id; private String key; private String value; private String valueArr; public SettingResponceBuilder id(int id) { this.id = id; return this; } private String tab; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public SettingResponceBuilder key(String key) { this.key = key; return this; } public SettingResponceBuilder value(String value) { this.value = value; return this; } public SettingResponceBuilder valueArr(String valueArr) { this.valueArr = valueArr; return this; } public SettingResponceBuilder tab(String tab) { this.tab = tab; return this; } public SettingResponceBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public SettingResponceBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public SettingResponceBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public SettingResponceBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public SettingResponce build() { return new SettingResponce(this.id, this.key, this.value, this.valueArr, this.tab, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "SettingResponce.SettingResponceBuilder(id=" + this.id + ", key=" + this.key + ", value=" + this.value + ", valueArr=" + this.valueArr + ", tab=" + this.tab + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */      }
/* 16 */   public int getId() { return this.id; }
/* 17 */   public String getKey() { return this.key; }
/* 18 */   public String getValue() { return this.value; }
/* 19 */   public String getValueArr() { return this.valueArr; }
/* 20 */   public String getTab() { return this.tab; }
/* 21 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 22 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 27 */     if (this.updatedAt == null) return ""; 
/* 28 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 32 */     if (this.createdAt == null) return ""; 
/* 33 */     return ApiHelper.dateToString(this.createdAt);
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\SettingResponce.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */