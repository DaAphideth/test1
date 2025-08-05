/*    */ package nencer.app.Modules.Users.Entity.Role;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Embeddable
/*    */ public class RoleHasPermissionsPK implements Serializable {
/*    */   @Column(name = "per_id")
/*    */   @Id
/*    */   private Integer perId;
/*    */   
/* 14 */   public void setPerId(Integer perId) { this.perId = perId; } @Column(name = "role_id") @Id private Integer roleId; public void setRoleId(Integer roleId) { this.roleId = roleId; }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getPerId() {
/* 19 */     return this.perId;
/*    */   }
/*    */   
/*    */   public Integer getRoleId() {
/* 23 */     return this.roleId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Role\RoleHasPermissionsPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */