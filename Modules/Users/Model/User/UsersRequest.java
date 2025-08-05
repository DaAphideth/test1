/*    */ package nencer.app.Modules.Users.Model.User;@JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class UsersRequest { private Integer id; @NotNull(message = "804")
/*    */   private String username; @NotNull(message = "804")
/*    */   private String name; @NotNull(message = "804")
/*    */   private String email; private String phone; private Integer jobTitle; private String countryCode; private String gender; private String avatar; private String password; private String rememberToken; private String apiToken; private Date apiTokenCreated; private String provider; private String providerId;
/*    */   private String mkc2;
/*    */   private String finger;
/*    */   private String tmp;
/*    */   private String tmpToken;
/*    */   private Integer status;
/*    */   private Integer parentId;
/*    */   private Integer lft;
/*    */   private Integer rgt;
/*    */   private String currencyCode;
/*    */   private Double appversion;
/*    */   
/*    */   public UsersRequest(Integer id, String username, String name, String email, String phone, Integer jobTitle, String countryCode, String gender, String avatar, String password, String rememberToken, String apiToken, Date apiTokenCreated, String provider, String providerId, String mkc2, String finger, String tmp, String tmpToken, Integer status, Integer parentId, Integer lft, Integer rgt, String currencyCode, Double appversion, String language, String twofactor, String twofactorSecret, String ip, String ref, String lastLoginIp, String lastSessionId, Integer failed, String failedReason, String apiKey, String certificate, String verifyFailReason, String documentNumber, Date documentExpiry, Integer verifyPhone, Integer verifyEmail, Integer verifyDocument, Integer vendor, Double stake, Date birthday, Date createdAt, Date updatedAt, Set<Groups> groups, List<Roles> roles, String practisingCertificate) {
/* 18 */     this.id = id; this.username = username; this.name = name; this.email = email; this.phone = phone; this.jobTitle = jobTitle; this.countryCode = countryCode; this.gender = gender; this.avatar = avatar; this.password = password; this.rememberToken = rememberToken; this.apiToken = apiToken; this.apiTokenCreated = apiTokenCreated; this.provider = provider; this.providerId = providerId; this.mkc2 = mkc2; this.finger = finger; this.tmp = tmp; this.tmpToken = tmpToken; this.status = status; this.parentId = parentId; this.lft = lft; this.rgt = rgt; this.currencyCode = currencyCode; this.appversion = appversion; this.language = language; this.twofactor = twofactor; this.twofactorSecret = twofactorSecret; this.ip = ip; this.ref = ref; this.lastLoginIp = lastLoginIp; this.lastSessionId = lastSessionId; this.failed = failed; this.failedReason = failedReason; this.apiKey = apiKey; this.certificate = certificate; this.verifyFailReason = verifyFailReason; this.documentNumber = documentNumber; this.documentExpiry = documentExpiry; this.verifyPhone = verifyPhone; this.verifyEmail = verifyEmail; this.verifyDocument = verifyDocument; this.vendor = vendor; this.stake = stake; this.birthday = birthday; this.createdAt = createdAt; this.updatedAt = updatedAt; this.groups = groups; this.roles = roles; this.practisingCertificate = practisingCertificate;
/*    */   } private String language; private String twofactor; private String twofactorSecret; private String ip; private String ref; private String lastLoginIp; private String lastSessionId; private Integer failed; private String failedReason; private String apiKey; private String certificate; private String verifyFailReason; private String documentNumber; private Date documentExpiry; private Integer verifyPhone; private Integer verifyEmail; private Integer verifyDocument; private Integer vendor; private Double stake; private Date birthday; private Date createdAt; private Date updatedAt; private Set<Groups> groups; private List<Roles> roles; private String practisingCertificate; public UsersRequest() {} public void setId(Integer id) {
/* 20 */     this.id = id; } public void setUsername(String username) { this.username = username; } public void setName(String name) { this.name = name; } public void setEmail(String email) { this.email = email; } public void setPhone(String phone) { this.phone = phone; } public void setJobTitle(Integer jobTitle) { this.jobTitle = jobTitle; } public void setCountryCode(String countryCode) { this.countryCode = countryCode; } public void setGender(String gender) { this.gender = gender; } public void setAvatar(String avatar) { this.avatar = avatar; } public void setPassword(String password) { this.password = password; } public void setRememberToken(String rememberToken) { this.rememberToken = rememberToken; } public void setApiToken(String apiToken) { this.apiToken = apiToken; } public void setApiTokenCreated(Date apiTokenCreated) { this.apiTokenCreated = apiTokenCreated; } public void setProvider(String provider) { this.provider = provider; } public void setProviderId(String providerId) { this.providerId = providerId; } public void setMkc2(String mkc2) { this.mkc2 = mkc2; } public void setFinger(String finger) { this.finger = finger; } public void setTmp(String tmp) { this.tmp = tmp; } public void setTmpToken(String tmpToken) { this.tmpToken = tmpToken; } public void setStatus(Integer status) { this.status = status; } public void setParentId(Integer parentId) { this.parentId = parentId; } public void setLft(Integer lft) { this.lft = lft; } public void setRgt(Integer rgt) { this.rgt = rgt; } public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; } public void setAppversion(Double appversion) { this.appversion = appversion; } public void setLanguage(String language) { this.language = language; } public void setTwofactor(String twofactor) { this.twofactor = twofactor; } public void setTwofactorSecret(String twofactorSecret) { this.twofactorSecret = twofactorSecret; } public void setIp(String ip) { this.ip = ip; } public void setRef(String ref) { this.ref = ref; } public void setLastLoginIp(String lastLoginIp) { this.lastLoginIp = lastLoginIp; } public void setLastSessionId(String lastSessionId) { this.lastSessionId = lastSessionId; } public void setFailed(Integer failed) { this.failed = failed; } public void setFailedReason(String failedReason) { this.failedReason = failedReason; } public void setApiKey(String apiKey) { this.apiKey = apiKey; } public void setCertificate(String certificate) { this.certificate = certificate; } public void setVerifyFailReason(String verifyFailReason) { this.verifyFailReason = verifyFailReason; } public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; } public void setDocumentExpiry(Date documentExpiry) { this.documentExpiry = documentExpiry; } public void setVerifyPhone(Integer verifyPhone) { this.verifyPhone = verifyPhone; } public void setVerifyEmail(Integer verifyEmail) { this.verifyEmail = verifyEmail; } public void setVerifyDocument(Integer verifyDocument) { this.verifyDocument = verifyDocument; } public void setVendor(Integer vendor) { this.vendor = vendor; } public void setStake(Double stake) { this.stake = stake; } public void setBirthday(Date birthday) { this.birthday = birthday; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setGroups(Set<Groups> groups) { this.groups = groups; } public void setRoles(List<Roles> roles) { this.roles = roles; } public void setPractisingCertificate(String practisingCertificate) { this.practisingCertificate = practisingCertificate; }
/*    */   
/*    */   public Integer getId() {
/* 23 */     return this.id;
/*    */   } public String getUsername() {
/* 25 */     return this.username;
/*    */   } public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */   
/* 30 */   public String getEmail() { return this.email; }
/* 31 */   public String getPhone() { return this.phone; }
/* 32 */   public Integer getJobTitle() { return this.jobTitle; }
/* 33 */   public String getCountryCode() { return this.countryCode; }
/* 34 */   public String getGender() { return this.gender; }
/* 35 */   public String getAvatar() { return this.avatar; }
/* 36 */   public String getPassword() { return this.password; }
/* 37 */   public String getRememberToken() { return this.rememberToken; }
/* 38 */   public String getApiToken() { return this.apiToken; }
/* 39 */   public Date getApiTokenCreated() { return this.apiTokenCreated; }
/* 40 */   public String getProvider() { return this.provider; }
/* 41 */   public String getProviderId() { return this.providerId; }
/* 42 */   public String getMkc2() { return this.mkc2; }
/* 43 */   public String getFinger() { return this.finger; }
/* 44 */   public String getTmp() { return this.tmp; }
/* 45 */   public String getTmpToken() { return this.tmpToken; }
/* 46 */   public Integer getStatus() { return this.status; }
/* 47 */   public Integer getParentId() { return this.parentId; }
/* 48 */   public Integer getLft() { return this.lft; }
/* 49 */   public Integer getRgt() { return this.rgt; }
/* 50 */   public String getCurrencyCode() { return this.currencyCode; }
/* 51 */   public Double getAppversion() { return this.appversion; }
/* 52 */   public String getLanguage() { return this.language; }
/* 53 */   public String getTwofactor() { return this.twofactor; }
/* 54 */   public String getTwofactorSecret() { return this.twofactorSecret; }
/* 55 */   public String getIp() { return this.ip; }
/* 56 */   public String getRef() { return this.ref; }
/* 57 */   public String getLastLoginIp() { return this.lastLoginIp; }
/* 58 */   public String getLastSessionId() { return this.lastSessionId; }
/* 59 */   public Integer getFailed() { return this.failed; }
/* 60 */   public String getFailedReason() { return this.failedReason; }
/* 61 */   public String getApiKey() { return this.apiKey; }
/* 62 */   public String getCertificate() { return this.certificate; }
/* 63 */   public String getVerifyFailReason() { return this.verifyFailReason; }
/* 64 */   public String getDocumentNumber() { return this.documentNumber; }
/* 65 */   public Date getDocumentExpiry() { return this.documentExpiry; }
/* 66 */   public Integer getVerifyPhone() { return this.verifyPhone; }
/* 67 */   public Integer getVerifyEmail() { return this.verifyEmail; }
/* 68 */   public Integer getVerifyDocument() { return this.verifyDocument; }
/* 69 */   public Integer getVendor() { return this.vendor; }
/* 70 */   public Double getStake() { return this.stake; }
/* 71 */   public Date getBirthday() { return this.birthday; }
/* 72 */   public Date getCreatedAt() { return this.createdAt; }
/* 73 */   public Date getUpdatedAt() { return this.updatedAt; }
/* 74 */   public Set<Groups> getGroups() { return this.groups; }
/* 75 */   public List<Roles> getRoles() { return this.roles; } public String getPractisingCertificate() {
/* 76 */     return this.practisingCertificate;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UsersRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */