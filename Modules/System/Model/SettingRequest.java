/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ public class SettingRequest {
/*    */   private int id;
/*    */   @NotNull(message = "804")
/*    */   private String key;
/*    */   private String value;
/*    */   
/*  9 */   public void setId(int id) { this.id = id; } private String valueArr; private String tab; private Date createdAt; private Date updatedAt; public void setKey(String key) { this.key = key; } public void setValue(String value) { this.value = value; } public void setValueArr(String valueArr) { this.valueArr = valueArr; } public void setTab(String tab) { this.tab = tab; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SettingRequest)) return false;  SettingRequest other = (SettingRequest)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$key = getKey(), other$key = other.getKey(); if ((this$key == null) ? (other$key != null) : !this$key.equals(other$key)) return false;  Object this$value = getValue(), other$value = other.getValue(); if ((this$value == null) ? (other$value != null) : !this$value.equals(other$value)) return false;  Object this$valueArr = getValueArr(), other$valueArr = other.getValueArr(); if ((this$valueArr == null) ? (other$valueArr != null) : !this$valueArr.equals(other$valueArr)) return false;  Object this$tab = getTab(), other$tab = other.getTab(); if ((this$tab == null) ? (other$tab != null) : !this$tab.equals(other$tab)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof SettingRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $key = getKey(); result = result * 59 + (($key == null) ? 43 : $key.hashCode()); Object $value = getValue(); result = result * 59 + (($value == null) ? 43 : $value.hashCode()); Object $valueArr = getValueArr(); result = result * 59 + (($valueArr == null) ? 43 : $valueArr.hashCode()); Object $tab = getTab(); result = result * 59 + (($tab == null) ? 43 : $tab.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "SettingRequest(id=" + getId() + ", key=" + getKey() + ", value=" + getValue() + ", valueArr=" + getValueArr() + ", tab=" + getTab() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public SettingRequest() {} public SettingRequest(int id, String key, String value, String valueArr, String tab, Date createdAt, Date updatedAt) {
/* 11 */     this.id = id; this.key = key; this.value = value; this.valueArr = valueArr; this.tab = tab; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   } public int getId() {
/* 13 */     return this.id;
/*    */   }
/* 15 */   public String getKey() { return this.key; }
/* 16 */   public String getValue() { return this.value; }
/* 17 */   public String getValueArr() { return this.valueArr; }
/* 18 */   public String getTab() { return this.tab; }
/* 19 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 20 */     return this.updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\SettingRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */