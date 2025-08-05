/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserHasRolesBuilder
/*    */ {
/*    */   private Integer roleId;
/*    */   private String modelType;
/*    */   private Integer usrUid;
/*    */   
/*    */   public UserHasRolesBuilder roleId(Integer roleId) {
/* 12 */     this.roleId = roleId; return this; } public UserHasRolesBuilder modelType(String modelType) { this.modelType = modelType; return this; } public UserHasRolesBuilder usrUid(Integer usrUid) { this.usrUid = usrUid; return this; } public UserHasRoles build() { return new UserHasRoles(this.roleId, this.modelType, this.usrUid); } public String toString() { return "UserHasRoles.UserHasRolesBuilder(roleId=" + this.roleId + ", modelType=" + this.modelType + ", usrUid=" + this.usrUid + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasRoles$UserHasRolesBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */