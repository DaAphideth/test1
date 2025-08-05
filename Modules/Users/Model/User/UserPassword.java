/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ 
/*    */ 
/*    */ public class UserPassword {
/*    */   private Long id;
/*    */   private String username;
/*    */   private String oldPassword;
/*    */   @NotNull(message = "804")
/*    */   @Range(min = 6L, message = "607")
/*    */   private String newPassword;
/*    */   
/* 12 */   public void setId(Long id) { this.id = id; } public void setUsername(String username) { this.username = username; } public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; } public void setNewPassword(String newPassword) { this.newPassword = newPassword; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof UserPassword)) return false;  UserPassword other = (UserPassword)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$oldPassword = getOldPassword(), other$oldPassword = other.getOldPassword(); if ((this$oldPassword == null) ? (other$oldPassword != null) : !this$oldPassword.equals(other$oldPassword)) return false;  Object this$newPassword = getNewPassword(), other$newPassword = other.getNewPassword(); return !((this$newPassword == null) ? (other$newPassword != null) : !this$newPassword.equals(other$newPassword)); } protected boolean canEqual(Object other) { return other instanceof UserPassword; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $oldPassword = getOldPassword(); result = result * 59 + (($oldPassword == null) ? 43 : $oldPassword.hashCode()); Object $newPassword = getNewPassword(); return result * 59 + (($newPassword == null) ? 43 : $newPassword.hashCode()); } public String toString() { return "UserPassword(id=" + getId() + ", username=" + getUsername() + ", oldPassword=" + getOldPassword() + ", newPassword=" + getNewPassword() + ")"; } public UserPassword(Long id, String username, String oldPassword, String newPassword) {
/* 13 */     this.id = id; this.username = username; this.oldPassword = oldPassword; this.newPassword = newPassword;
/*    */   } public UserPassword() {}
/* 15 */   public static UserPasswordBuilder builder() { return new UserPasswordBuilder(); } public static class UserPasswordBuilder { private Long id; private String username; public UserPasswordBuilder id(Long id) { this.id = id; return this; } private String oldPassword; private String newPassword; public UserPasswordBuilder username(String username) { this.username = username; return this; } public UserPasswordBuilder oldPassword(String oldPassword) { this.oldPassword = oldPassword; return this; } public UserPasswordBuilder newPassword(String newPassword) { this.newPassword = newPassword; return this; } public UserPassword build() { return new UserPassword(this.id, this.username, this.oldPassword, this.newPassword); } public String toString() { return "UserPassword.UserPasswordBuilder(id=" + this.id + ", username=" + this.username + ", oldPassword=" + this.oldPassword + ", newPassword=" + this.newPassword + ")"; }
/*    */      }
/* 17 */   public Long getId() { return this.id; }
/* 18 */   public String getUsername() { return this.username; } public String getOldPassword() {
/* 19 */     return this.oldPassword;
/*    */   }
/*    */   public String getNewPassword() {
/* 22 */     return this.newPassword;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UserPassword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */