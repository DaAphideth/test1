/*    */ package nencer.app.Modules.Users.Model.Group;
/*    */ public class GroupRequest { private Integer id; @NotNull(message = "804")
/*    */   private String name;
/*    */   @NotNull(message = "804")
/*    */   private String code;
/*    */   
/*  7 */   public void setId(Integer id) { this.id = id; } private String description; private Integer sort; private Integer status; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setDescription(String description) { this.description = description; } public void setSort(Integer sort) { this.sort = sort; } public void setStatus(Integer status) { this.status = status; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GroupRequest)) return false;  GroupRequest other = (GroupRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); return !((this$status == null) ? (other$status != null) : !this$status.equals(other$status)); } protected boolean canEqual(Object other) { return other instanceof GroupRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $status = getStatus(); return result * 59 + (($status == null) ? 43 : $status.hashCode()); } public String toString() { return "GroupRequest(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", description=" + getDescription() + ", sort=" + getSort() + ", status=" + getStatus() + ")"; }
/*    */    public Integer getId() {
/*  9 */     return this.id;
/*    */   }
/*    */   public String getName() {
/* 12 */     return this.name;
/*    */   }
/* 14 */   public String getCode() { return this.code; }
/* 15 */   public String getDescription() { return this.description; }
/* 16 */   public Integer getSort() { return this.sort; } public Integer getStatus() {
/* 17 */     return this.status;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Group\GroupRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */