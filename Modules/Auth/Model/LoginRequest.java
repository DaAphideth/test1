/*    */ package nencer.app.Modules.Auth.Model;
/*    */ 
/*    */ public class LoginRequest {
/*    */   @NotNull(message = "804")
/*    */   private String username;
/*    */   
/*  7 */   public void setUsername(String username) { this.username = username; } @NotNull(message = "804") private String password; public void setPassword(String password) { this.password = password; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LoginRequest)) return false;  LoginRequest other = (LoginRequest)o; if (!other.canEqual(this)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); return !((this$password == null) ? (other$password != null) : !this$password.equals(other$password)); } protected boolean canEqual(Object other) { return other instanceof LoginRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $password = getPassword(); return result * 59 + (($password == null) ? 43 : $password.hashCode()); } public String toString() { return "LoginRequest(username=" + getUsername() + ", password=" + getPassword() + ")"; }
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 11 */     return this.username;
/*    */   } public String getPassword() {
/* 13 */     return this.password;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Model\LoginRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */