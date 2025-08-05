/*    */ package nencer.app.Modules.Users.Entity.Role;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "role_has_permissions")
/*    */ @IdClass(RoleHasPermissionsPK.class)
/*    */ public class RoleHasPermissions {
/*    */   @Id
/*    */   @Column(name = "per_id")
/*    */   private Integer perId;
/*    */   
/* 15 */   public void setPerId(Integer perId) { this.perId = perId; } @Id @Column(name = "role_id") private Integer roleId; public void setRoleId(Integer roleId) { this.roleId = roleId; }
/*    */    public RoleHasPermissions() {} public RoleHasPermissions(Integer perId, Integer roleId) {
/* 17 */     this.perId = perId; this.roleId = roleId;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getPerId() {
/* 22 */     return this.perId;
/*    */   }
/*    */   
/*    */   public Integer getRoleId() {
/* 26 */     return this.roleId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Role\RoleHasPermissions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */