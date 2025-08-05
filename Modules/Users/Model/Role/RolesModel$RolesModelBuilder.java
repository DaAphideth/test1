/*    */ package nencer.app.Modules.Users.Model.Role;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Users.Entity.User.Permissions;
/*    */ 
/*    */ public class RolesModelBuilder {
/*    */   private Long id;
/*    */   private String name;
/*    */   private String guardName;
/*    */   
/*    */   public RolesModelBuilder id(Long id) {
/* 13 */     this.id = id; return this; } private String description; private Date createdAt; private Date updatedAt; private List<Permissions> permissions; public RolesModelBuilder name(String name) { this.name = name; return this; } public RolesModelBuilder guardName(String guardName) { this.guardName = guardName; return this; } public RolesModelBuilder description(String description) { this.description = description; return this; } public RolesModelBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RolesModelBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RolesModelBuilder permissions(List<Permissions> permissions) { this.permissions = permissions; return this; } public RolesModel build() { return new RolesModel(this.id, this.name, this.guardName, this.description, this.createdAt, this.updatedAt, this.permissions); } public String toString() { return "RolesModel.RolesModelBuilder(id=" + this.id + ", name=" + this.name + ", guardName=" + this.guardName + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", permissions=" + this.permissions + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Role\RolesModel$RolesModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */