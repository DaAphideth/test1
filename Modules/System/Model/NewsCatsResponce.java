/*    */ package nencer.app.Modules.System.Model;
/*    */ public class NewsCatsResponce { private int id;
/*    */   private String name;
/*    */   private String urlKey;
/*    */   private String description;
/*    */   private Integer parentId;
/*    */   private Integer sort;
/*    */   private Integer level;
/*    */   
/* 10 */   public void setId(int id) { this.id = id; } private String image; private String lang; private Integer lft; private Integer rgt; private Integer status; private Date createdAt; private Date updatedAt; public void setName(String name) { this.name = name; } public void setUrlKey(String urlKey) { this.urlKey = urlKey; } public void setDescription(String description) { this.description = description; } public void setParentId(Integer parentId) { this.parentId = parentId; } public void setSort(Integer sort) { this.sort = sort; } public void setLevel(Integer level) { this.level = level; } public void setImage(String image) { this.image = image; } public void setLang(String lang) { this.lang = lang; } public void setLft(Integer lft) { this.lft = lft; } public void setRgt(Integer rgt) { this.rgt = rgt; } public void setStatus(Integer status) { this.status = status; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof NewsCatsResponce)) return false;  NewsCatsResponce other = (NewsCatsResponce)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$urlKey = getUrlKey(), other$urlKey = other.getUrlKey(); if ((this$urlKey == null) ? (other$urlKey != null) : !this$urlKey.equals(other$urlKey)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$parentId = getParentId(), other$parentId = other.getParentId(); if ((this$parentId == null) ? (other$parentId != null) : !this$parentId.equals(other$parentId)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$level = getLevel(), other$level = other.getLevel(); if ((this$level == null) ? (other$level != null) : !this$level.equals(other$level)) return false;  Object this$image = getImage(), other$image = other.getImage(); if ((this$image == null) ? (other$image != null) : !this$image.equals(other$image)) return false;  Object this$lang = getLang(), other$lang = other.getLang(); if ((this$lang == null) ? (other$lang != null) : !this$lang.equals(other$lang)) return false;  Object this$lft = getLft(), other$lft = other.getLft(); if ((this$lft == null) ? (other$lft != null) : !this$lft.equals(other$lft)) return false;  Object this$rgt = getRgt(), other$rgt = other.getRgt(); if ((this$rgt == null) ? (other$rgt != null) : !this$rgt.equals(other$rgt)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof NewsCatsResponce; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $urlKey = getUrlKey(); result = result * 59 + (($urlKey == null) ? 43 : $urlKey.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $parentId = getParentId(); result = result * 59 + (($parentId == null) ? 43 : $parentId.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $level = getLevel(); result = result * 59 + (($level == null) ? 43 : $level.hashCode()); Object $image = getImage(); result = result * 59 + (($image == null) ? 43 : $image.hashCode()); Object $lang = getLang(); result = result * 59 + (($lang == null) ? 43 : $lang.hashCode()); Object $lft = getLft(); result = result * 59 + (($lft == null) ? 43 : $lft.hashCode()); Object $rgt = getRgt(); result = result * 59 + (($rgt == null) ? 43 : $rgt.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "NewsCatsResponce(id=" + getId() + ", name=" + getName() + ", urlKey=" + getUrlKey() + ", description=" + getDescription() + ", parentId=" + getParentId() + ", sort=" + getSort() + ", level=" + getLevel() + ", image=" + getImage() + ", lang=" + getLang() + ", lft=" + getLft() + ", rgt=" + getRgt() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public NewsCatsResponce() {} public NewsCatsResponce(int id, String name, String urlKey, String description, Integer parentId, Integer sort, Integer level, String image, String lang, Integer lft, Integer rgt, Integer status, Date createdAt, Date updatedAt) {
/* 12 */     this.id = id; this.name = name; this.urlKey = urlKey; this.description = description; this.parentId = parentId; this.sort = sort; this.level = level; this.image = image; this.lang = lang; this.lft = lft; this.rgt = rgt; this.status = status; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   }
/* 14 */   public int getId() { return this.id; }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getUrlKey() { return this.urlKey; }
/* 17 */   public String getDescription() { return this.description; }
/* 18 */   public Integer getParentId() { return this.parentId; }
/* 19 */   public Integer getSort() { return this.sort; }
/* 20 */   public Integer getLevel() { return this.level; }
/* 21 */   public String getImage() { return this.image; }
/* 22 */   public String getLang() { return this.lang; }
/* 23 */   public Integer getLft() { return this.lft; }
/* 24 */   public Integer getRgt() { return this.rgt; }
/* 25 */   public Integer getStatus() { return this.status; }
/* 26 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 27 */     return this.updatedAt;
/*    */   } public String getUpdatedAtDis() {
/* 29 */     if (this.updatedAt == null) return ""; 
/* 30 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 34 */     if (this.createdAt == null) return ""; 
/* 35 */     return ApiHelper.dateToString(this.createdAt);
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\NewsCatsResponce.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */