/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "user_has_group")
/*    */ @IdClass(UserHasGroupPK.class)
/*    */ public class UserHasGroup {
/*    */   private Integer groupId;
/*    */   private String modelType;
/*    */   private int usrUid;
/*    */   
/* 13 */   public static UserHasGroupBuilder builder() { return new UserHasGroupBuilder(); } public static class UserHasGroupBuilder { private Integer groupId; public UserHasGroupBuilder groupId(Integer groupId) { this.groupId = groupId; return this; } private String modelType; private int usrUid; public UserHasGroupBuilder modelType(String modelType) { this.modelType = modelType; return this; } public UserHasGroupBuilder usrUid(int usrUid) { this.usrUid = usrUid; return this; } public UserHasGroup build() { return new UserHasGroup(this.groupId, this.modelType, this.usrUid); } public String toString() { return "UserHasGroup.UserHasGroupBuilder(groupId=" + this.groupId + ", modelType=" + this.modelType + ", usrUid=" + this.usrUid + ")"; }
/*    */      } public UserHasGroup() {} public UserHasGroup(Integer groupId, String modelType, int usrUid) {
/* 15 */     this.groupId = groupId; this.modelType = modelType; this.usrUid = usrUid;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "group_id")
/*    */   public Integer getGroupId() {
/* 24 */     return this.groupId;
/*    */   }
/*    */   
/*    */   public void setGroupId(Integer groupId) {
/* 28 */     this.groupId = groupId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "model_type")
/*    */   public String getModelType() {
/* 34 */     return this.modelType;
/*    */   }
/*    */   
/*    */   public void setModelType(String modelType) {
/* 38 */     this.modelType = modelType;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "usr_uid")
/*    */   public Integer getUsrUid() {
/* 44 */     return Integer.valueOf(this.usrUid);
/*    */   }
/*    */   
/*    */   public void setUsrUid(Integer usrUid) {
/* 48 */     this.usrUid = usrUid.intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */