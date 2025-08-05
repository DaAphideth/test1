/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserPasswordBuilder
/*    */ {
/*    */   private Long id;
/*    */   private String username;
/*    */   private String oldPassword;
/*    */   private String newPassword;
/*    */   
/*    */   public UserPasswordBuilder id(Long id) {
/* 15 */     this.id = id; return this; } public UserPasswordBuilder username(String username) { this.username = username; return this; } public UserPasswordBuilder oldPassword(String oldPassword) { this.oldPassword = oldPassword; return this; } public UserPasswordBuilder newPassword(String newPassword) { this.newPassword = newPassword; return this; } public UserPassword build() { return new UserPassword(this.id, this.username, this.oldPassword, this.newPassword); } public String toString() { return "UserPassword.UserPasswordBuilder(id=" + this.id + ", username=" + this.username + ", oldPassword=" + this.oldPassword + ", newPassword=" + this.newPassword + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UserPassword$UserPasswordBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */