/*    */ package nencer.app.Modules.Users.Entity.Role;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RolesBuilder
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String guardName;
/*    */   private String description;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   
/*    */   public RolesBuilder id(Integer id) {
/* 17 */     this.id = id; return this; } public RolesBuilder name(String name) { this.name = name; return this; } public RolesBuilder guardName(String guardName) { this.guardName = guardName; return this; } public RolesBuilder description(String description) { this.description = description; return this; } public RolesBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RolesBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public Roles build() { return new Roles(this.id, this.name, this.guardName, this.description, this.createdAt, this.updatedAt); } public String toString() { return "Roles.RolesBuilder(id=" + this.id + ", name=" + this.name + ", guardName=" + this.guardName + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Role\Roles$RolesBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */