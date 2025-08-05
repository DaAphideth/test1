/*    */ package nencer.app.Modules.Users.Model.Role;
/*    */ public class RolesModel { private Long id;
/*    */   private String name;
/*    */   private String guardName;
/*    */   private String description;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   private List<Permissions> permissions;
/*    */   
/*    */   public RolesModel() {}
/*    */   
/* 12 */   public RolesModel(Long id, String name, String guardName, String description, Date createdAt, Date updatedAt, List<Permissions> permissions) { this.id = id; this.name = name; this.guardName = guardName; this.description = description; this.createdAt = createdAt; this.updatedAt = updatedAt; this.permissions = permissions; }
/* 13 */   public static RolesModelBuilder builder() { return new RolesModelBuilder(); } public static class RolesModelBuilder { private Long id; private String name; private String guardName; public RolesModelBuilder id(Long id) { this.id = id; return this; } private String description; private Date createdAt; private Date updatedAt; private List<Permissions> permissions; public RolesModelBuilder name(String name) { this.name = name; return this; } public RolesModelBuilder guardName(String guardName) { this.guardName = guardName; return this; } public RolesModelBuilder description(String description) { this.description = description; return this; } public RolesModelBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RolesModelBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RolesModelBuilder permissions(List<Permissions> permissions) { this.permissions = permissions; return this; } public RolesModel build() { return new RolesModel(this.id, this.name, this.guardName, this.description, this.createdAt, this.updatedAt, this.permissions); } public String toString() { return "RolesModel.RolesModelBuilder(id=" + this.id + ", name=" + this.name + ", guardName=" + this.guardName + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", permissions=" + this.permissions + ")"; } }
/* 14 */   public void setId(Long id) { this.id = id; } public void setName(String name) { this.name = name; } public void setGuardName(String guardName) { this.guardName = guardName; } public void setDescription(String description) { this.description = description; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setPermissions(List<Permissions> permissions) { this.permissions = permissions; }
/*    */ 
/*    */   
/*    */   public Long getId() {
/* 18 */     return this.id;
/* 19 */   } public String getName() { return this.name; }
/* 20 */   public String getGuardName() { return this.guardName; }
/* 21 */   public String getDescription() { return this.description; }
/* 22 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 23 */     return this.updatedAt;
/*    */   } public List<Permissions> getPermissions() {
/* 25 */     return this.permissions;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Role\RolesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */