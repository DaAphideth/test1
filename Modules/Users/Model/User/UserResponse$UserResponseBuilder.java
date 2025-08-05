/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ 
/*    */ public class UserResponseBuilder {
/*    */   private Long id;
/*    */   private String username;
/*    */   private String name;
/*    */   private String phone;
/*    */   private String email;
/*    */   
/*    */   public UserResponseBuilder id(Long id) {
/* 11 */     this.id = id; return this; } public UserResponseBuilder username(String username) { this.username = username; return this; } public UserResponseBuilder name(String name) { this.name = name; return this; } public UserResponseBuilder phone(String phone) { this.phone = phone; return this; } public UserResponseBuilder email(String email) { this.email = email; return this; } public UserResponse build() { return new UserResponse(this.id, this.username, this.name, this.phone, this.email); } public String toString() { return "UserResponse.UserResponseBuilder(id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", phone=" + this.phone + ", email=" + this.email + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UserResponse$UserResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */