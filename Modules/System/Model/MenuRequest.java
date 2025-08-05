/*    */ package nencer.app.Modules.System.Model;
/*    */ public class MenuRequest {
/*    */   private int id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   @NotNull(message = "804")
/*    */   private String url;
/*    */   private String menuType;
/*    */   private Integer level;
/*    */   private Integer childrenCount;
/*    */   
/* 12 */   public void setId(int id) { this.id = id; } private Integer sortOrder; private Integer status; private String language; private Date createdAt; private Date updatedAt; private Menu parentId; public void setName(String name) { this.name = name; } public void setUrl(String url) { this.url = url; } public void setMenuType(String menuType) { this.menuType = menuType; } public void setLevel(Integer level) { this.level = level; } public void setChildrenCount(Integer childrenCount) { this.childrenCount = childrenCount; } public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; } public void setStatus(Integer status) { this.status = status; } public void setLanguage(String language) { this.language = language; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setParentId(Menu parentId) { this.parentId = parentId; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MenuRequest)) return false;  MenuRequest other = (MenuRequest)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$url = getUrl(), other$url = other.getUrl(); if ((this$url == null) ? (other$url != null) : !this$url.equals(other$url)) return false;  Object this$menuType = getMenuType(), other$menuType = other.getMenuType(); if ((this$menuType == null) ? (other$menuType != null) : !this$menuType.equals(other$menuType)) return false;  Object this$level = getLevel(), other$level = other.getLevel(); if ((this$level == null) ? (other$level != null) : !this$level.equals(other$level)) return false;  Object this$childrenCount = getChildrenCount(), other$childrenCount = other.getChildrenCount(); if ((this$childrenCount == null) ? (other$childrenCount != null) : !this$childrenCount.equals(other$childrenCount)) return false;  Object this$sortOrder = getSortOrder(), other$sortOrder = other.getSortOrder(); if ((this$sortOrder == null) ? (other$sortOrder != null) : !this$sortOrder.equals(other$sortOrder)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$language = getLanguage(), other$language = other.getLanguage(); if ((this$language == null) ? (other$language != null) : !this$language.equals(other$language)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$parentId = getParentId(), other$parentId = other.getParentId(); return !((this$parentId == null) ? (other$parentId != null) : !this$parentId.equals(other$parentId)); } protected boolean canEqual(Object other) { return other instanceof MenuRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $url = getUrl(); result = result * 59 + (($url == null) ? 43 : $url.hashCode()); Object $menuType = getMenuType(); result = result * 59 + (($menuType == null) ? 43 : $menuType.hashCode()); Object $level = getLevel(); result = result * 59 + (($level == null) ? 43 : $level.hashCode()); Object $childrenCount = getChildrenCount(); result = result * 59 + (($childrenCount == null) ? 43 : $childrenCount.hashCode()); Object $sortOrder = getSortOrder(); result = result * 59 + (($sortOrder == null) ? 43 : $sortOrder.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $language = getLanguage(); result = result * 59 + (($language == null) ? 43 : $language.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $parentId = getParentId(); return result * 59 + (($parentId == null) ? 43 : $parentId.hashCode()); } public String toString() { return "MenuRequest(id=" + getId() + ", name=" + getName() + ", url=" + getUrl() + ", menuType=" + getMenuType() + ", level=" + getLevel() + ", childrenCount=" + getChildrenCount() + ", sortOrder=" + getSortOrder() + ", status=" + getStatus() + ", language=" + getLanguage() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", parentId=" + getParentId() + ")"; }
/*    */    public MenuRequest() {} public MenuRequest(int id, String name, String url, String menuType, Integer level, Integer childrenCount, Integer sortOrder, Integer status, String language, Date createdAt, Date updatedAt, Menu parentId) {
/* 14 */     this.id = id; this.name = name; this.url = url; this.menuType = menuType; this.level = level; this.childrenCount = childrenCount; this.sortOrder = sortOrder; this.status = status; this.language = language; this.createdAt = createdAt; this.updatedAt = updatedAt; this.parentId = parentId;
/*    */   } public int getId() {
/* 16 */     return this.id;
/*    */   } public String getName() {
/* 18 */     return this.name;
/*    */   }
/* 20 */   public String getUrl() { return this.url; } public String getMenuType() {
/* 21 */     return this.menuType;
/*    */   }
/* 23 */   public Integer getLevel() { return this.level; }
/* 24 */   public Integer getChildrenCount() { return this.childrenCount; }
/* 25 */   public Integer getSortOrder() { return this.sortOrder; }
/* 26 */   public Integer getStatus() { return this.status; }
/* 27 */   public String getLanguage() { return this.language; }
/* 28 */   public Date getCreatedAt() { return this.createdAt; }
/* 29 */   public Date getUpdatedAt() { return this.updatedAt; } public Menu getParentId() {
/* 30 */     return this.parentId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\MenuRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */