/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class CreateUserRequest { @NotNull(message = "804")
/*    */   private String username; @NotNull(message = "804")
/*    */   private String name; @NotNull(message = "804")
/*    */   @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "609")
/*    */   private String email;
/*    */   private String phone;
/*    */   private Integer jobTitle;
/*    */   private String countryCode;
/*    */   private String gender;
/*    */   private String avatar;
/*    */   
/* 14 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CreateUserRequest)) return false;  CreateUserRequest other = (CreateUserRequest)o; if (!other.canEqual(this)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$phone = getPhone(), other$phone = other.getPhone(); if ((this$phone == null) ? (other$phone != null) : !this$phone.equals(other$phone)) return false;  Object this$jobTitle = getJobTitle(), other$jobTitle = other.getJobTitle(); if ((this$jobTitle == null) ? (other$jobTitle != null) : !this$jobTitle.equals(other$jobTitle)) return false;  Object this$countryCode = getCountryCode(), other$countryCode = other.getCountryCode(); if ((this$countryCode == null) ? (other$countryCode != null) : !this$countryCode.equals(other$countryCode)) return false;  Object this$gender = getGender(), other$gender = other.getGender(); if ((this$gender == null) ? (other$gender != null) : !this$gender.equals(other$gender)) return false;  Object this$avatar = getAvatar(), other$avatar = other.getAvatar(); if ((this$avatar == null) ? (other$avatar != null) : !this$avatar.equals(other$avatar)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$birthday = getBirthday(), other$birthday = other.getBirthday(); if ((this$birthday == null) ? (other$birthday != null) : !this$birthday.equals(other$birthday)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object<Groups> this$groups = (Object<Groups>)getGroups(), other$groups = (Object<Groups>)other.getGroups(); if ((this$groups == null) ? (other$groups != null) : !this$groups.equals(other$groups)) return false;  Object this$practisingCertificate = getPractisingCertificate(), other$practisingCertificate = other.getPractisingCertificate(); if ((this$practisingCertificate == null) ? (other$practisingCertificate != null) : !this$practisingCertificate.equals(other$practisingCertificate)) return false;  Object<Roles> this$roles = (Object<Roles>)getRoles(), other$roles = (Object<Roles>)other.getRoles(); return !((this$roles == null) ? (other$roles != null) : !this$roles.equals(other$roles)); } @NotNull(message = "804") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{7,20}$", message = "608") private String password; private Integer status; private Date birthday; private Date createdAt; private Date updatedAt; private Set<Groups> groups; private String practisingCertificate; private Set<Roles> roles; protected boolean canEqual(Object other) { return other instanceof CreateUserRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $phone = getPhone(); result = result * 59 + (($phone == null) ? 43 : $phone.hashCode()); Object $jobTitle = getJobTitle(); result = result * 59 + (($jobTitle == null) ? 43 : $jobTitle.hashCode()); Object $countryCode = getCountryCode(); result = result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode()); Object $gender = getGender(); result = result * 59 + (($gender == null) ? 43 : $gender.hashCode()); Object $avatar = getAvatar(); result = result * 59 + (($avatar == null) ? 43 : $avatar.hashCode()); Object $password = getPassword(); result = result * 59 + (($password == null) ? 43 : $password.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $birthday = getBirthday(); result = result * 59 + (($birthday == null) ? 43 : $birthday.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object<Groups> $groups = (Object<Groups>)getGroups(); result = result * 59 + (($groups == null) ? 43 : $groups.hashCode()); Object $practisingCertificate = getPractisingCertificate(); result = result * 59 + (($practisingCertificate == null) ? 43 : $practisingCertificate.hashCode()); Object<Roles> $roles = (Object<Roles>)getRoles(); return result * 59 + (($roles == null) ? 43 : $roles.hashCode()); } public String toString() { return "CreateUserRequest(username=" + getUsername() + ", name=" + getName() + ", email=" + getEmail() + ", phone=" + getPhone() + ", jobTitle=" + getJobTitle() + ", countryCode=" + getCountryCode() + ", gender=" + getGender() + ", avatar=" + getAvatar() + ", password=" + getPassword() + ", status=" + getStatus() + ", birthday=" + getBirthday() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", groups=" + getGroups() + ", practisingCertificate=" + getPractisingCertificate() + ", roles=" + getRoles() + ")"; }
/*    */   
/* 16 */   public void setUsername(String username) { this.username = username; } public void setName(String name) { this.name = name; } public void setEmail(String email) { this.email = email; } public void setPhone(String phone) { this.phone = phone; } public void setJobTitle(Integer jobTitle) { this.jobTitle = jobTitle; } public void setCountryCode(String countryCode) { this.countryCode = countryCode; } public void setGender(String gender) { this.gender = gender; } public void setAvatar(String avatar) { this.avatar = avatar; } public void setPassword(String password) { this.password = password; } public void setStatus(Integer status) { this.status = status; } public void setBirthday(Date birthday) { this.birthday = birthday; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setGroups(Set<Groups> groups) { this.groups = groups; } public void setPractisingCertificate(String practisingCertificate) { this.practisingCertificate = practisingCertificate; } public void setRoles(Set<Roles> roles) { this.roles = roles; }
/*    */    public CreateUserRequest() {} public CreateUserRequest(String username, String name, String email, String phone, Integer jobTitle, String countryCode, String gender, String avatar, String password, Integer status, Date birthday, Date createdAt, Date updatedAt, Set<Groups> groups, String practisingCertificate, Set<Roles> roles) {
/* 18 */     this.username = username; this.name = name; this.email = email; this.phone = phone; this.jobTitle = jobTitle; this.countryCode = countryCode; this.gender = gender; this.avatar = avatar; this.password = password; this.status = status; this.birthday = birthday; this.createdAt = createdAt; this.updatedAt = updatedAt; this.groups = groups; this.practisingCertificate = practisingCertificate; this.roles = roles;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 23 */     return this.username;
/*    */   } public String getName() {
/* 25 */     return this.name;
/*    */   }
/*    */   public String getEmail() {
/* 28 */     return this.email;
/*    */   }
/* 30 */   public String getPhone() { return this.phone; }
/* 31 */   public Integer getJobTitle() { return this.jobTitle; }
/* 32 */   public String getCountryCode() { return this.countryCode; }
/* 33 */   public String getGender() { return this.gender; } public String getAvatar() {
/* 34 */     return this.avatar;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 38 */     return this.password;
/*    */   }
/* 40 */   public Integer getStatus() { return this.status; }
/* 41 */   public Date getBirthday() { return this.birthday; }
/* 42 */   public Date getCreatedAt() { return this.createdAt; }
/* 43 */   public Date getUpdatedAt() { return this.updatedAt; }
/* 44 */   public Set<Groups> getGroups() { return this.groups; }
/* 45 */   public String getPractisingCertificate() { return this.practisingCertificate; } public Set<Roles> getRoles() {
/* 46 */     return this.roles;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\CreateUserRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */