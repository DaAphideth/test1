/*    */ package nencer.app.Modules.Auth.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*    */ import nencer.app.Modules.Users.Model.Role.PermissionsModel;
/*    */ 
/*    */ public class UserResponseInfoBuilder {
/*    */   private Long id;
/*    */   private String username;
/*    */   private String name;
/*    */   private String email;
/*    */   private String phone;
/*    */   private Integer jobTitle;
/*    */   private String countryCode;
/*    */   
/* 17 */   public UserResponseInfoBuilder id(Long id) { this.id = id; return this; } private String gender; private String avatar; private String lastLoginIp; private Date createdAt; private Date updatedAt; private List<Roles> roles; private List<PermissionsModel> permissions; public UserResponseInfoBuilder username(String username) { this.username = username; return this; } public UserResponseInfoBuilder name(String name) { this.name = name; return this; } public UserResponseInfoBuilder email(String email) { this.email = email; return this; } public UserResponseInfoBuilder phone(String phone) { this.phone = phone; return this; } public UserResponseInfoBuilder jobTitle(Integer jobTitle) { this.jobTitle = jobTitle; return this; } public UserResponseInfoBuilder countryCode(String countryCode) { this.countryCode = countryCode; return this; } public UserResponseInfoBuilder gender(String gender) { this.gender = gender; return this; } public UserResponseInfoBuilder avatar(String avatar) { this.avatar = avatar; return this; } public UserResponseInfoBuilder lastLoginIp(String lastLoginIp) { this.lastLoginIp = lastLoginIp; return this; } public UserResponseInfoBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public UserResponseInfoBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public UserResponseInfoBuilder roles(List<Roles> roles) { this.roles = roles; return this; } public UserResponseInfoBuilder permissions(List<PermissionsModel> permissions) { this.permissions = permissions; return this; } public UserResponseInfo build() { return new UserResponseInfo(this.id, this.username, this.name, this.email, this.phone, this.jobTitle, this.countryCode, this.gender, this.avatar, this.lastLoginIp, this.createdAt, this.updatedAt, this.roles, this.permissions); } public String toString() { return "UserResponseInfo.UserResponseInfoBuilder(id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", email=" + this.email + ", phone=" + this.phone + ", jobTitle=" + this.jobTitle + ", countryCode=" + this.countryCode + ", gender=" + this.gender + ", avatar=" + this.avatar + ", lastLoginIp=" + this.lastLoginIp + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", roles=" + this.roles + ", permissions=" + this.permissions + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Model\UserResponseInfo$UserResponseInfoBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */