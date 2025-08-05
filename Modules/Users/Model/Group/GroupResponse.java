/*    */ package nencer.app.Modules.Users.Model.Group;
/*    */ public class GroupResponse {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   private String description;
/*    */   private Integer status;
/*    */   private Integer hideit;
/*    */   private String createdAt;
/*    */   
/* 11 */   public void setId(Integer id) { this.id = id; } public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setDescription(String description) { this.description = description; } public void setStatus(Integer status) { this.status = status; } public void setHideit(Integer hideit) { this.hideit = hideit; } public void setCreatedAt(String createdAt) { this.createdAt = createdAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GroupResponse)) return false;  GroupResponse other = (GroupResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$hideit = getHideit(), other$hideit = other.getHideit(); if ((this$hideit == null) ? (other$hideit != null) : !this$hideit.equals(other$hideit)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); return !((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)); } protected boolean canEqual(Object other) { return other instanceof GroupResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $hideit = getHideit(); result = result * 59 + (($hideit == null) ? 43 : $hideit.hashCode()); Object $createdAt = getCreatedAt(); return result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); } public String toString() { return "GroupResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", description=" + getDescription() + ", status=" + getStatus() + ", hideit=" + getHideit() + ", createdAt=" + getCreatedAt() + ")"; } public GroupResponse(Integer id, String name, String code, String description, Integer status, Integer hideit, String createdAt) {
/* 12 */     this.id = id; this.name = name; this.code = code; this.description = description; this.status = status; this.hideit = hideit; this.createdAt = createdAt;
/*    */   } public GroupResponse() {}
/* 14 */   public static GroupResponseBuilder builder() { return new GroupResponseBuilder(); } public static class GroupResponseBuilder { private Integer id; private String name; private String code; public GroupResponseBuilder id(Integer id) { this.id = id; return this; } private String description; private Integer status; private Integer hideit; private String createdAt; public GroupResponseBuilder name(String name) { this.name = name; return this; } public GroupResponseBuilder code(String code) { this.code = code; return this; } public GroupResponseBuilder description(String description) { this.description = description; return this; } public GroupResponseBuilder status(Integer status) { this.status = status; return this; } public GroupResponseBuilder hideit(Integer hideit) { this.hideit = hideit; return this; } public GroupResponseBuilder createdAt(String createdAt) { this.createdAt = createdAt; return this; } public GroupResponse build() { return new GroupResponse(this.id, this.name, this.code, this.description, this.status, this.hideit, this.createdAt); } public String toString() { return "GroupResponse.GroupResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", description=" + this.description + ", status=" + this.status + ", hideit=" + this.hideit + ", createdAt=" + this.createdAt + ")"; }
/*    */      }
/* 16 */   public Integer getId() { return this.id; }
/* 17 */   public String getName() { return this.name; }
/* 18 */   public String getCode() { return this.code; }
/* 19 */   public String getDescription() { return this.description; }
/* 20 */   public Integer getStatus() { return this.status; }
/* 21 */   public Integer getHideit() { return this.hideit; } public String getCreatedAt() {
/* 22 */     return this.createdAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Group\GroupResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */