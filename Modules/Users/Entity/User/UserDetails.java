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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "user_details")
/*     */ public class UserDetails
/*     */ {
/*     */   private int id;
/*     */   private int userId;
/*     */   private Integer jobId;
/*     */   private String description;
/*     */   private String address;
/*     */   private String idNumber;
/*     */   private Timestamp idExpireAt;
/*     */   private Integer cityId;
/*     */   private String countryCode;
/*     */   private String nationality;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  34 */     return this.id;
/*     */   }
/*     */   private String religion; private Integer married; private Integer children; private Integer partyMember; private String fatherInfo; private String motherInfo; private String husbandWifeInfo; private String childrenInfo; private Timestamp createdAt; private Timestamp updatedAt;
/*     */   public void setId(int id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public int getUserId() {
/*  44 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  48 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "job_id")
/*     */   public Integer getJobId() {
/*  54 */     return this.jobId;
/*     */   }
/*     */   
/*     */   public void setJobId(Integer jobId) {
/*  58 */     this.jobId = jobId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  64 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  68 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/*  74 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  78 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "id_number")
/*     */   public String getIdNumber() {
/*  84 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String idNumber) {
/*  88 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "id_expire_at")
/*     */   public Timestamp getIdExpireAt() {
/*  94 */     return this.idExpireAt;
/*     */   }
/*     */   
/*     */   public void setIdExpireAt(Timestamp idExpireAt) {
/*  98 */     this.idExpireAt = idExpireAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "city_id")
/*     */   public Integer getCityId() {
/* 104 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Integer cityId) {
/* 108 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 114 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 118 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "nationality")
/*     */   public String getNationality() {
/* 124 */     return this.nationality;
/*     */   }
/*     */   
/*     */   public void setNationality(String nationality) {
/* 128 */     this.nationality = nationality;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "religion")
/*     */   public String getReligion() {
/* 134 */     return this.religion;
/*     */   }
/*     */   
/*     */   public void setReligion(String religion) {
/* 138 */     this.religion = religion;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "married")
/*     */   public Integer getMarried() {
/* 144 */     return this.married;
/*     */   }
/*     */   
/*     */   public void setMarried(Integer married) {
/* 148 */     this.married = married;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "children")
/*     */   public Integer getChildren() {
/* 154 */     return this.children;
/*     */   }
/*     */   
/*     */   public void setChildren(Integer children) {
/* 158 */     this.children = children;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "party_member")
/*     */   public Integer getPartyMember() {
/* 164 */     return this.partyMember;
/*     */   }
/*     */   
/*     */   public void setPartyMember(Integer partyMember) {
/* 168 */     this.partyMember = partyMember;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "father_info")
/*     */   public String getFatherInfo() {
/* 174 */     return this.fatherInfo;
/*     */   }
/*     */   
/*     */   public void setFatherInfo(String fatherInfo) {
/* 178 */     this.fatherInfo = fatherInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "mother_info")
/*     */   public String getMotherInfo() {
/* 184 */     return this.motherInfo;
/*     */   }
/*     */   
/*     */   public void setMotherInfo(String motherInfo) {
/* 188 */     this.motherInfo = motherInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "husband_wife_info")
/*     */   public String getHusbandWifeInfo() {
/* 194 */     return this.husbandWifeInfo;
/*     */   }
/*     */   
/*     */   public void setHusbandWifeInfo(String husbandWifeInfo) {
/* 198 */     this.husbandWifeInfo = husbandWifeInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "children_info")
/*     */   public String getChildrenInfo() {
/* 204 */     return this.childrenInfo;
/*     */   }
/*     */   
/*     */   public void setChildrenInfo(String childrenInfo) {
/* 208 */     this.childrenInfo = childrenInfo;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Timestamp getCreatedAt() {
/* 214 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Timestamp createdAt) {
/* 218 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Timestamp getUpdatedAt() {
/* 224 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Timestamp updatedAt) {
/* 228 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 233 */     if (this == o) return true; 
/* 234 */     if (o == null || getClass() != o.getClass()) return false; 
/* 235 */     UserDetails that = (UserDetails)o;
/* 236 */     return (this.id == that.id && this.userId == that.userId && Objects.equals(this.jobId, that.jobId) && Objects.equals(this.description, that.description) && Objects.equals(this.address, that.address) && Objects.equals(this.idNumber, that.idNumber) && Objects.equals(this.idExpireAt, that.idExpireAt) && Objects.equals(this.cityId, that.cityId) && Objects.equals(this.countryCode, that.countryCode) && Objects.equals(this.nationality, that.nationality) && Objects.equals(this.religion, that.religion) && Objects.equals(this.married, that.married) && Objects.equals(this.children, that.children) && Objects.equals(this.partyMember, that.partyMember) && Objects.equals(this.fatherInfo, that.fatherInfo) && Objects.equals(this.motherInfo, that.motherInfo) && Objects.equals(this.husbandWifeInfo, that.husbandWifeInfo) && Objects.equals(this.childrenInfo, that.childrenInfo) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 241 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), Integer.valueOf(this.userId), this.jobId, this.description, this.address, this.idNumber, this.idExpireAt, this.cityId, this.countryCode, this.nationality, this.religion, this.married, this.children, this.partyMember, this.fatherInfo, this.motherInfo, this.husbandWifeInfo, this.childrenInfo, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserDetails.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */