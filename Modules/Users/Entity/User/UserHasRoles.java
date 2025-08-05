/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "user_has_roles")
/*    */ @IdClass(UserHasRolesPK.class)
/*    */ public class UserHasRoles {
/*    */   @Column(name = "role_id")
/*    */   @Id
/*    */   private Integer roleId;
/*    */   
/* 12 */   public static UserHasRolesBuilder builder() { return new UserHasRolesBuilder(); } @Column(name = "model_type") private String modelType; @Column(name = "usr_uid") @Id private Integer usrUid; public static class UserHasRolesBuilder { private Integer roleId; private String modelType; private Integer usrUid; public UserHasRolesBuilder roleId(Integer roleId) { this.roleId = roleId; return this; } public UserHasRolesBuilder modelType(String modelType) { this.modelType = modelType; return this; } public UserHasRolesBuilder usrUid(Integer usrUid) { this.usrUid = usrUid; return this; } public UserHasRoles build() { return new UserHasRoles(this.roleId, this.modelType, this.usrUid); } public String toString() { return "UserHasRoles.UserHasRolesBuilder(roleId=" + this.roleId + ", modelType=" + this.modelType + ", usrUid=" + this.usrUid + ")"; }
/*    */      } public UserHasRoles() {} public UserHasRoles(Integer roleId, String modelType, Integer usrUid) {
/* 14 */     this.roleId = roleId; this.modelType = modelType; this.usrUid = usrUid;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasRoles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */