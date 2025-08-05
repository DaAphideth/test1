/*    */ package nencer.app.Modules.Users.Entity.Role;
/*    */ @Entity
/*    */ public class Roles { @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer id;
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   private String name;
/*    */   @Basic
/*    */   @Column(name = "guard_name")
/*    */   private String guardName;
/*    */   
/* 14 */   public void setId(Integer id) { this.id = id; } @Basic @Column(name = "description") private String description; @Basic @Column(name = "created_at") private Date createdAt; @Basic @Column(name = "updated_at") private Date updatedAt; public void setName(String name) { this.name = name; } public void setGuardName(String guardName) { this.guardName = guardName; } public void setDescription(String description) { this.description = description; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof Roles)) return false;  Roles other = (Roles)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$guardName = getGuardName(), other$guardName = other.getGuardName(); if ((this$guardName == null) ? (other$guardName != null) : !this$guardName.equals(other$guardName)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof Roles; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $guardName = getGuardName(); result = result * 59 + (($guardName == null) ? 43 : $guardName.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "Roles(id=" + getId() + ", name=" + getName() + ", guardName=" + getGuardName() + ", description=" + getDescription() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public Roles() {}
/* 16 */   public Roles(Integer id, String name, String guardName, String description, Date createdAt, Date updatedAt) { this.id = id; this.name = name; this.guardName = guardName; this.description = description; this.createdAt = createdAt; this.updatedAt = updatedAt; }
/* 17 */   public static RolesBuilder builder() { return new RolesBuilder(); } public static class RolesBuilder { private Integer id; private String name; private String guardName; private String description; private Date createdAt; private Date updatedAt; public RolesBuilder id(Integer id) { this.id = id; return this; } public RolesBuilder name(String name) { this.name = name; return this; } public RolesBuilder guardName(String guardName) { this.guardName = guardName; return this; } public RolesBuilder description(String description) { this.description = description; return this; } public RolesBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RolesBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public Roles build() { return new Roles(this.id, this.name, this.guardName, this.description, this.createdAt, this.updatedAt); } public String toString() { return "Roles.RolesBuilder(id=" + this.id + ", name=" + this.name + ", guardName=" + this.guardName + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */      }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getGuardName() {
/* 31 */     return this.guardName;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 35 */     return this.description;
/*    */   }
/*    */   
/*    */   public Date getCreatedAt() {
/* 39 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public Date getUpdatedAt() {
/* 43 */     return this.updatedAt;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Role\Roles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */