/*     */ package nencer.app.Modules.Users.Entity.User;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "user_devices")
/*     */ public class UserDevices
/*     */ {
/*     */   private int id;
/*     */   private int userId;
/*     */   private String deviceId;
/*     */   private String deviceName;
/*     */   private String browserName;
/*     */   private String platform;
/*     */   private String version;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   private String versionPlatform; private String userAgent; private Integer verified; private String token; private String sessionId; private Timestamp verifiedAt; private Timestamp createdAt; private Timestamp updatedAt;
/*     */   public void setId(int id) {
/*  33 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public int getUserId() {
/*  39 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  43 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "device_id")
/*     */   public String getDeviceId() {
/*  49 */     return this.deviceId;
/*     */   }
/*     */   
/*     */   public void setDeviceId(String deviceId) {
/*  53 */     this.deviceId = deviceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "device_name")
/*     */   public String getDeviceName() {
/*  59 */     return this.deviceName;
/*     */   }
/*     */   
/*     */   public void setDeviceName(String deviceName) {
/*  63 */     this.deviceName = deviceName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "browser_name")
/*     */   public String getBrowserName() {
/*  69 */     return this.browserName;
/*     */   }
/*     */   
/*     */   public void setBrowserName(String browserName) {
/*  73 */     this.browserName = browserName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "platform")
/*     */   public String getPlatform() {
/*  79 */     return this.platform;
/*     */   }
/*     */   
/*     */   public void setPlatform(String platform) {
/*  83 */     this.platform = platform;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "version")
/*     */   public String getVersion() {
/*  89 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/*  93 */     this.version = version;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "version_platform")
/*     */   public String getVersionPlatform() {
/*  99 */     return this.versionPlatform;
/*     */   }
/*     */   
/*     */   public void setVersionPlatform(String versionPlatform) {
/* 103 */     this.versionPlatform = versionPlatform;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_agent")
/*     */   public String getUserAgent() {
/* 109 */     return this.userAgent;
/*     */   }
/*     */   
/*     */   public void setUserAgent(String userAgent) {
/* 113 */     this.userAgent = userAgent;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verified")
/*     */   public Integer getVerified() {
/* 119 */     return this.verified;
/*     */   }
/*     */   
/*     */   public void setVerified(Integer verified) {
/* 123 */     this.verified = verified;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "token")
/*     */   public String getToken() {
/* 129 */     return this.token;
/*     */   }
/*     */   
/*     */   public void setToken(String token) {
/* 133 */     this.token = token;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "session_id")
/*     */   public String getSessionId() {
/* 139 */     return this.sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(String sessionId) {
/* 143 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "verified_at")
/*     */   public Timestamp getVerifiedAt() {
/* 149 */     return this.verifiedAt;
/*     */   }
/*     */   
/*     */   public void setVerifiedAt(Timestamp verifiedAt) {
/* 153 */     this.verifiedAt = verifiedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Timestamp getCreatedAt() {
/* 159 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Timestamp createdAt) {
/* 163 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Timestamp getUpdatedAt() {
/* 169 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Timestamp updatedAt) {
/* 173 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 178 */     if (this == o) return true; 
/* 179 */     if (o == null || getClass() != o.getClass()) return false; 
/* 180 */     UserDevices that = (UserDevices)o;
/* 181 */     return (this.id == that.id && this.userId == that.userId && Objects.equals(this.deviceId, that.deviceId) && Objects.equals(this.deviceName, that.deviceName) && Objects.equals(this.browserName, that.browserName) && Objects.equals(this.platform, that.platform) && Objects.equals(this.version, that.version) && Objects.equals(this.versionPlatform, that.versionPlatform) && Objects.equals(this.userAgent, that.userAgent) && Objects.equals(this.verified, that.verified) && Objects.equals(this.token, that.token) && Objects.equals(this.sessionId, that.sessionId) && Objects.equals(this.verifiedAt, that.verifiedAt) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 186 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), Integer.valueOf(this.userId), this.deviceId, this.deviceName, this.browserName, this.platform, this.version, this.versionPlatform, this.userAgent, this.verified, this.token, this.sessionId, this.verifiedAt, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserDevices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */