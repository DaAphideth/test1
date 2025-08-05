/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class UnitRequest {
/*    */   private int id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   @NotNull(message = "804")
/*    */   private String key;
/*    */   
/* 10 */   public void setId(int id) { this.id = id; } private String type; private String description; private Date createdAt; private Date updatedAt; public void setName(String name) { this.name = name; } public void setKey(String key) { this.key = key; } public void setType(String type) { this.type = type; } public void setDescription(String description) { this.description = description; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof UnitRequest)) return false;  UnitRequest other = (UnitRequest)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$key = getKey(), other$key = other.getKey(); if ((this$key == null) ? (other$key != null) : !this$key.equals(other$key)) return false;  Object this$type = getType(), other$type = other.getType(); if ((this$type == null) ? (other$type != null) : !this$type.equals(other$type)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof UnitRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $key = getKey(); result = result * 59 + (($key == null) ? 43 : $key.hashCode()); Object $type = getType(); result = result * 59 + (($type == null) ? 43 : $type.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "UnitRequest(id=" + getId() + ", name=" + getName() + ", key=" + getKey() + ", type=" + getType() + ", description=" + getDescription() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public UnitRequest() {} public UnitRequest(int id, String name, String key, String type, String description, Date createdAt, Date updatedAt) {
/* 12 */     this.id = id; this.name = name; this.key = key; this.type = type; this.description = description; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   } public int getId() {
/* 14 */     return this.id;
/*    */   } public String getName() {
/* 16 */     return this.name;
/*    */   }
/*    */   
/* 19 */   public String getKey() { return this.key; }
/* 20 */   public String getType() { return this.type; }
/* 21 */   public String getDescription() { return this.description; }
/* 22 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 23 */     return this.updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\UnitRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */