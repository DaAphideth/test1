/*    */ package nencer.app.Modules.Users.Entity.Group;
/*    */ @Entity
/*    */ @Table(name = "`groups`")
/*    */ public class Groups { @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   private Integer id; @Basic
/*    */   @Column(name = "`name`")
/*    */   private String name; @Basic
/*    */   @Column(name = "`code`")
/*    */   private String code; @Basic
/*    */   @Column(name = "description")
/*    */   private String description;
/*    */   
/* 15 */   public static GroupsBuilder builder() { return new GroupsBuilder(); } @Basic @Column(name = "status") private int status; @Basic @Column(name = "hideit") private int hideit; @Basic @Column(name = "sort") private Integer sort; @Basic @Column(name = "created_at") private Date createdAt; @Basic @Column(name = "updated_at") private Date updatedAt; public static class GroupsBuilder { private Integer id; private String name; private String code; private String description; private int status; private int hideit; private Integer sort; private Date createdAt; private Date updatedAt; public GroupsBuilder id(Integer id) { this.id = id; return this; } public GroupsBuilder name(String name) { this.name = name; return this; } public GroupsBuilder code(String code) { this.code = code; return this; } public GroupsBuilder description(String description) { this.description = description; return this; } public GroupsBuilder status(int status) { this.status = status; return this; } public GroupsBuilder hideit(int hideit) { this.hideit = hideit; return this; } public GroupsBuilder sort(Integer sort) { this.sort = sort; return this; } public GroupsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public GroupsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public Groups build() { return new Groups(this.id, this.name, this.code, this.description, this.status, this.hideit, this.sort, this.createdAt, this.updatedAt); } public String toString() { return "Groups.GroupsBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", description=" + this.description + ", status=" + this.status + ", hideit=" + this.hideit + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */      }
/* 17 */   public void setId(Integer id) { this.id = id; } public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setDescription(String description) { this.description = description; } public void setStatus(int status) { this.status = status; } public void setHideit(int hideit) { this.hideit = hideit; } public void setSort(Integer sort) { this.sort = sort; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof Groups)) return false;  Groups other = (Groups)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  if (getStatus() != other.getStatus()) return false;  if (getHideit() != other.getHideit()) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof Groups; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); result = result * 59 + getStatus(); result = result * 59 + getHideit(); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "Groups(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", description=" + getDescription() + ", status=" + getStatus() + ", hideit=" + getHideit() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public Groups() {} public Groups(Integer id, String name, String code, String description, int status, int hideit, Integer sort, Date createdAt, Date updatedAt) {
/* 19 */     this.id = id; this.name = name; this.code = code; this.description = description; this.status = status; this.hideit = hideit; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 24 */     return this.id;
/*    */   }
/*    */   public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */   public String getCode() {
/* 30 */     return this.code;
/*    */   }
/*    */   public String getDescription() {
/* 33 */     return this.description;
/*    */   }
/*    */   public int getStatus() {
/* 36 */     return this.status;
/*    */   }
/*    */   public int getHideit() {
/* 39 */     return this.hideit;
/*    */   }
/*    */   public Integer getSort() {
/* 42 */     return this.sort;
/*    */   }
/*    */   public Date getCreatedAt() {
/* 45 */     return this.createdAt;
/*    */   }
/*    */   public Date getUpdatedAt() {
/* 48 */     return this.updatedAt;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Group\Groups.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */