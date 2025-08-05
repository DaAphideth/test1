/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Embeddable
/*    */ public class UserHasGroupPK
/*    */   implements Serializable {
/*    */   private int groupId;
/*    */   private int usrUid;
/*    */   
/*    */   @Column(name = "group_id")
/*    */   @Id
/*    */   public int getGroupId() {
/* 17 */     return this.groupId;
/*    */   }
/*    */   
/*    */   public void setGroupId(int groupId) {
/* 21 */     this.groupId = groupId;
/*    */   }
/*    */   
/*    */   @Column(name = "usr_uid")
/*    */   @Id
/*    */   public int getUsrUid() {
/* 27 */     return this.usrUid;
/*    */   }
/*    */   
/*    */   public void setUsrUid(int usrUid) {
/* 31 */     this.usrUid = usrUid;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasGroupPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */