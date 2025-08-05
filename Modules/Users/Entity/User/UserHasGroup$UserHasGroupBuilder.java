/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserHasGroupBuilder
/*    */ {
/*    */   private Integer groupId;
/*    */   private String modelType;
/*    */   private int usrUid;
/*    */   
/*    */   public UserHasGroupBuilder groupId(Integer groupId) {
/* 13 */     this.groupId = groupId; return this; } public UserHasGroupBuilder modelType(String modelType) { this.modelType = modelType; return this; } public UserHasGroupBuilder usrUid(int usrUid) { this.usrUid = usrUid; return this; } public UserHasGroup build() { return new UserHasGroup(this.groupId, this.modelType, this.usrUid); } public String toString() { return "UserHasGroup.UserHasGroupBuilder(groupId=" + this.groupId + ", modelType=" + this.modelType + ", usrUid=" + this.usrUid + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasGroup$UserHasGroupBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */