/*     */ package nencer.app.Modules.Users.Entity.User;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import nencer.app.Modules.Users.Entity.Group.Groups;
/*     */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "users")
/*     */ @JsonIgnoreProperties(ignoreUnknown = true)
/*     */ public class Users {
/*     */   public Users(Integer id, String username, String name, String email, String phone, Integer jobTitle, String countryCode, String gender, String avatar, String password, String rememberToken, String apiToken, Date apiTokenCreated, String provider, String providerId, String mkc2, String finger, String tmp, String tmpToken, Integer status, Integer parentId, Integer lft, Integer rgt, String currencyCode, Double appversion, String language, String twofactor, String twofactorSecret, String ip, String ref, String lastLoginIp, String lastSessionId, Integer failed, String failedReason, String apiKey, String certificate, String verifyFailReason, String documentNumber, Date documentExpiry, Integer verifyPhone, Integer verifyEmail, Integer verifyDocument, Integer vendor, Integer group, Double stake, Date birthday, Date createdAt, Date updatedAt, List<Groups> groups, List<Roles> roles, String practisingCertificate) {
/*  22 */     this.id = id; this.username = username; this.name = name; this.email = email; this.phone = phone; this.jobTitle = jobTitle; this.countryCode = countryCode; this.gender = gender; this.avatar = avatar; this.password = password; this.rememberToken = rememberToken; this.apiToken = apiToken; this.apiTokenCreated = apiTokenCreated; this.provider = provider; this.providerId = providerId; this.mkc2 = mkc2; this.finger = finger; this.tmp = tmp; this.tmpToken = tmpToken; this.status = status; this.parentId = parentId; this.lft = lft; this.rgt = rgt; this.currencyCode = currencyCode; this.appversion = appversion; this.language = language; this.twofactor = twofactor; this.twofactorSecret = twofactorSecret; this.ip = ip; this.ref = ref; this.lastLoginIp = lastLoginIp; this.lastSessionId = lastSessionId; this.failed = failed; this.failedReason = failedReason; this.apiKey = apiKey; this.certificate = certificate; this.verifyFailReason = verifyFailReason; this.documentNumber = documentNumber; this.documentExpiry = documentExpiry; this.verifyPhone = verifyPhone; this.verifyEmail = verifyEmail; this.verifyDocument = verifyDocument; this.vendor = vendor; this.group = group; this.stake = stake; this.birthday = birthday; this.createdAt = createdAt; this.updatedAt = updatedAt; this.groups = groups; this.roles = roles; this.practisingCertificate = practisingCertificate;
/*     */   }
/*     */ 
/*     */   
/*     */   private Integer id;
/*     */   @NotNull(message = "804")
/*     */   private String username;
/*     */   @NotNull(message = "804")
/*     */   private String name;
/*     */   @NotNull(message = "804")
/*     */   private String email;
/*     */   private String phone;
/*     */   private Integer jobTitle;
/*     */   private String countryCode;
/*     */   private String gender;
/*     */   private String avatar;
/*     */   private String password;
/*     */   private String rememberToken;
/*     */   private String apiToken;
/*     */   private Date apiTokenCreated;
/*     */   private String provider;
/*     */   private String providerId;
/*     */   private String mkc2;
/*     */   private String finger;
/*     */   private String tmp;
/*     */   private String tmpToken;
/*     */   private Integer status;
/*     */   private Integer parentId;
/*     */   private Integer lft;
/*     */   private Integer rgt;
/*     */   private String currencyCode;
/*     */   private Double appversion;
/*     */   private String language;
/*     */   private String twofactor;
/*     */   private String twofactorSecret;
/*     */   private String ip;
/*     */   private String ref;
/*     */   private String lastLoginIp;
/*     */   private String lastSessionId;
/*     */   private Integer failed;
/*     */   private String failedReason;
/*     */   private String apiKey;
/*     */   private String certificate;
/*     */   private String verifyFailReason;
/*     */   private String documentNumber;
/*     */   private Date documentExpiry;
/*     */   private Integer verifyPhone;
/*     */   private Integer verifyEmail;
/*     */   private Integer verifyDocument;
/*     */   private Integer vendor;
/*     */   private Integer group;
/*     */   private Double stake;
/*     */   private Date birthday;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   private List<Groups> groups;
/*     */   private List<Roles> roles;
/*     */   private String practisingCertificate;
/*     */   
/*     */   public Users() {}
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  87 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  91 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "username")
/*     */   @NotNull
/*     */   public String getUsername() {
/*  98 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/* 102 */     this.username = username;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`name`")
/*     */   public String getName() {
/* 108 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 112 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "email")
/*     */   public String getEmail() {
/* 118 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 122 */     this.email = email;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "phone")
/*     */   public String getPhone() {
/* 128 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 132 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`job_title`")
/*     */   public Integer getJobTitle() {
/* 138 */     return this.jobTitle;
/*     */   }
/*     */   
/*     */   public void setJobTitle(Integer jobTitle) {
/* 142 */     this.jobTitle = jobTitle;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 148 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 152 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "gender")
/*     */   public String getGender() {
/* 158 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 162 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "avatar")
/*     */   public String getAvatar() {
/* 168 */     return this.avatar;
/*     */   }
/*     */   
/*     */   public void setAvatar(String avatar) {
/* 172 */     this.avatar = avatar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "password")
/*     */   @NotNull
/*     */   public String getPassword() {
/* 189 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 193 */     this.password = password;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "remember_token")
/*     */   public String getRememberToken() {
/* 199 */     return this.rememberToken;
/*     */   }
/*     */   
/*     */   public void setRememberToken(String rememberToken) {
/* 203 */     this.rememberToken = rememberToken;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "api_token")
/*     */   public String getApiToken() {
/* 209 */     return this.apiToken;
/*     */   }
/*     */   
/*     */   public void setApiToken(String apiToken) {
/* 213 */     this.apiToken = apiToken;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "api_token_created")
/*     */   public Date getApiTokenCreated() {
/* 219 */     return this.apiTokenCreated;
/*     */   }
/*     */   
/*     */   public void setApiTokenCreated(Date apiTokenCreated) {
/* 223 */     this.apiTokenCreated = apiTokenCreated;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "provider")
/*     */   public String getProvider() {
/* 229 */     return this.provider;
/*     */   }
/*     */   
/*     */   public void setProvider(String provider) {
/* 233 */     this.provider = provider;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "provider_id")
/*     */   public String getProviderId() {
/* 239 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 243 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`mkc2`")
/*     */   public String getMkc2() {
/* 249 */     return this.mkc2;
/*     */   }
/*     */   
/*     */   public void setMkc2(String mkc2) {
/* 253 */     this.mkc2 = mkc2;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "finger")
/*     */   public String getFinger() {
/* 259 */     return this.finger;
/*     */   }
/*     */   
/*     */   public void setFinger(String finger) {
/* 263 */     this.finger = finger;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "tmp")
/*     */   public String getTmp() {
/* 269 */     return this.tmp;
/*     */   }
/*     */   
/*     */   public void setTmp(String tmp) {
/* 273 */     this.tmp = tmp;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "tmp_token")
/*     */   public String getTmpToken() {
/* 279 */     return this.tmpToken;
/*     */   }
/*     */   
/*     */   public void setTmpToken(String tmpToken) {
/* 283 */     this.tmpToken = tmpToken;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 289 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 293 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "parent_id")
/*     */   public Integer getParentId() {
/* 299 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(Integer parentId) {
/* 303 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`_lft`")
/*     */   public Integer getLft() {
/* 309 */     return this.lft;
/*     */   }
/*     */   
/*     */   public void setLft(Integer lft) {
/* 313 */     this.lft = lft;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "_rgt")
/*     */   public Integer getRgt() {
/* 319 */     return this.rgt;
/*     */   }
/*     */   
/*     */   public void setRgt(Integer rgt) {
/* 323 */     this.rgt = rgt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "currency_code")
/*     */   public String getCurrencyCode() {
/* 329 */     return this.currencyCode;
/*     */   }
/*     */   
/*     */   public void setCurrencyCode(String currencyCode) {
/* 333 */     this.currencyCode = currencyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "appversion")
/*     */   public Double getAppversion() {
/* 339 */     return this.appversion;
/*     */   }
/*     */   
/*     */   public void setAppversion(Double appversion) {
/* 343 */     this.appversion = appversion;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`language`")
/*     */   public String getLanguage() {
/* 349 */     return this.language;
/*     */   }
/*     */   
/*     */   public void setLanguage(String language) {
/* 353 */     this.language = language;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "twofactor")
/*     */   public String getTwofactor() {
/* 359 */     return this.twofactor;
/*     */   }
/*     */   
/*     */   public void setTwofactor(String twofactor) {
/* 363 */     this.twofactor = twofactor;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "twofactor_secret")
/*     */   public String getTwofactorSecret() {
/* 369 */     return this.twofactorSecret;
/*     */   }
/*     */   
/*     */   public void setTwofactorSecret(String twofactorSecret) {
/* 373 */     this.twofactorSecret = twofactorSecret;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`ip`")
/*     */   public String getIp() {
/* 379 */     return this.ip;
/*     */   }
/*     */   
/*     */   public void setIp(String ip) {
/* 383 */     this.ip = ip;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ref")
/*     */   public String getRef() {
/* 389 */     return this.ref;
/*     */   }
/*     */   
/*     */   public void setRef(String ref) {
/* 393 */     this.ref = ref;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`last_login_ip`")
/*     */   public String getLastLoginIp() {
/* 399 */     return this.lastLoginIp;
/*     */   }
/*     */   
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 403 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`last_session_id`")
/*     */   public String getLastSessionId() {
/* 409 */     return this.lastSessionId;
/*     */   }
/*     */   
/*     */   public void setLastSessionId(String lastSessionId) {
/* 413 */     this.lastSessionId = lastSessionId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "failed")
/*     */   public Integer getFailed() {
/* 419 */     return this.failed;
/*     */   }
/*     */   
/*     */   public void setFailed(Integer failed) {
/* 423 */     this.failed = failed;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "failed_reason")
/*     */   public String getFailedReason() {
/* 429 */     return this.failedReason;
/*     */   }
/*     */   
/*     */   public void setFailedReason(String failedReason) {
/* 433 */     this.failedReason = failedReason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "api_key")
/*     */   public String getApiKey() {
/* 439 */     return this.apiKey;
/*     */   }
/*     */   
/*     */   public void setApiKey(String apiKey) {
/* 443 */     this.apiKey = apiKey;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "certificate")
/*     */   public String getCertificate() {
/* 449 */     return this.certificate;
/*     */   }
/*     */   
/*     */   public void setCertificate(String certificate) {
/* 453 */     this.certificate = certificate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verify_fail_reason")
/*     */   public String getVerifyFailReason() {
/* 459 */     return this.verifyFailReason;
/*     */   }
/*     */   
/*     */   public void setVerifyFailReason(String verifyFailReason) {
/* 463 */     this.verifyFailReason = verifyFailReason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "document_number")
/*     */   public String getDocumentNumber() {
/* 469 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */   public void setDocumentNumber(String documentNumber) {
/* 473 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "document_expiry")
/*     */   public Date getDocumentExpiry() {
/* 479 */     return this.documentExpiry;
/*     */   }
/*     */   
/*     */   public void setDocumentExpiry(Date documentExpiry) {
/* 483 */     this.documentExpiry = documentExpiry;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verify_phone")
/*     */   public Integer getVerifyPhone() {
/* 489 */     return this.verifyPhone;
/*     */   }
/*     */   
/*     */   public void setVerifyPhone(Integer verifyPhone) {
/* 493 */     this.verifyPhone = verifyPhone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verify_email")
/*     */   public Integer getVerifyEmail() {
/* 499 */     return this.verifyEmail;
/*     */   }
/*     */   
/*     */   public void setVerifyEmail(Integer verifyEmail) {
/* 503 */     this.verifyEmail = verifyEmail;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verify_document")
/*     */   public Integer getVerifyDocument() {
/* 509 */     return this.verifyDocument;
/*     */   }
/*     */   
/*     */   public void setVerifyDocument(Integer verifyDocument) {
/* 513 */     this.verifyDocument = verifyDocument;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "vendor")
/*     */   public Integer getVendor() {
/* 519 */     return this.vendor;
/*     */   }
/*     */   
/*     */   public void setVendor(Integer vendor) {
/* 523 */     this.vendor = vendor;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "stake")
/*     */   public Double getStake() {
/* 529 */     return this.stake;
/*     */   }
/*     */   
/*     */   public void setStake(Double stake) {
/* 533 */     this.stake = stake;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "birthday")
/*     */   public Date getBirthday() {
/* 539 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setBirthday(Date birthday) {
/* 543 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 549 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 553 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 559 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 563 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`group`")
/*     */   public Integer getGroup() {
/* 569 */     return this.group;
/*     */   }
/*     */   
/*     */   public void setGroup(Integer group) {
/* 573 */     this.group = group;
/*     */   }
/*     */ 
/*     */   
/*     */   @Transient
/*     */   public List<Groups> getGroups() {
/* 579 */     return this.groups;
/*     */   }
/*     */   
/*     */   public void setGroups(List<Groups> groups) {
/* 583 */     this.groups = groups;
/*     */   }
/*     */ 
/*     */   
/*     */   @Transient
/*     */   public List<Roles> getRoles() {
/* 589 */     return this.roles;
/*     */   }
/*     */   
/*     */   public void setRoles(List<Roles> roles) {
/* 593 */     this.roles = roles;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "practising_certificate")
/*     */   public String getPractisingCertificate() {
/* 599 */     return this.practisingCertificate;
/*     */   }
/*     */   
/*     */   public void setPractisingCertificate(String practisingCertificate) {
/* 603 */     this.practisingCertificate = practisingCertificate;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\Users.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */