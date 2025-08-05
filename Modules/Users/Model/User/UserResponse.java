/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ public class UserResponse { private Long id;
/*    */   private String username;
/*    */   private String name;
/*    */   private String phone;
/*    */   private String email;
/*    */   
/*  8 */   public void setId(Long id) { this.id = id; } public void setUsername(String username) { this.username = username; } public void setName(String name) { this.name = name; } public void setPhone(String phone) { this.phone = phone; } public void setEmail(String email) { this.email = email; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof UserResponse)) return false;  UserResponse other = (UserResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$phone = getPhone(), other$phone = other.getPhone(); if ((this$phone == null) ? (other$phone != null) : !this$phone.equals(other$phone)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); return !((this$email == null) ? (other$email != null) : !this$email.equals(other$email)); } protected boolean canEqual(Object other) { return other instanceof UserResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $phone = getPhone(); result = result * 59 + (($phone == null) ? 43 : $phone.hashCode()); Object $email = getEmail(); return result * 59 + (($email == null) ? 43 : $email.hashCode()); } public String toString() { return "UserResponse(id=" + getId() + ", username=" + getUsername() + ", name=" + getName() + ", phone=" + getPhone() + ", email=" + getEmail() + ")"; } public UserResponse(Long id, String username, String name, String phone, String email) {
/*  9 */     this.id = id; this.username = username; this.name = name; this.phone = phone; this.email = email;
/*    */   } public UserResponse() {}
/* 11 */   public static UserResponseBuilder builder() { return new UserResponseBuilder(); } public static class UserResponseBuilder { private Long id; private String username; public UserResponseBuilder id(Long id) { this.id = id; return this; } private String name; private String phone; private String email; public UserResponseBuilder username(String username) { this.username = username; return this; } public UserResponseBuilder name(String name) { this.name = name; return this; } public UserResponseBuilder phone(String phone) { this.phone = phone; return this; } public UserResponseBuilder email(String email) { this.email = email; return this; } public UserResponse build() { return new UserResponse(this.id, this.username, this.name, this.phone, this.email); } public String toString() { return "UserResponse.UserResponseBuilder(id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", phone=" + this.phone + ", email=" + this.email + ")"; }
/*    */      }
/* 13 */   public Long getId() { return this.id; }
/* 14 */   public String getUsername() { return this.username; }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getPhone() { return this.phone; } public String getEmail() {
/* 17 */     return this.email;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UserResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */