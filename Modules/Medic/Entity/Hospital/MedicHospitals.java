/*     */ package nencer.app.Modules.Medic.Entity.Hospital;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_hospitals")
/*     */ public class MedicHospitals
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String name;
/*     */   private String code;
/*     */   private String rank;
/*     */   private String type;
/*     */   private String description;
/*     */   private String image;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  31 */     return this.id;
/*     */   }
/*     */   private String director; private String address; private String phone; private String email; private Integer cityId; private String countryCode; private Date createdAt; private Date updatedAt;
/*     */   public void setId(Integer id) {
/*  35 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`name`")
/*     */   public String getName() {
/*  41 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  45 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  51 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  55 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`rank`")
/*     */   public String getRank() {
/*  61 */     return this.rank;
/*     */   }
/*     */   
/*     */   public void setRank(String rank) {
/*  65 */     this.rank = rank;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`type`")
/*     */   public String getType() {
/*  71 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  75 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  81 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  85 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  91 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  95 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "director")
/*     */   public String getDirector() {
/* 101 */     return this.director;
/*     */   }
/*     */   
/*     */   public void setDirector(String director) {
/* 105 */     this.director = director;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/* 111 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 115 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "phone")
/*     */   public String getPhone() {
/* 121 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 125 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "email")
/*     */   public String getEmail() {
/* 131 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 135 */     this.email = email;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "city_id")
/*     */   public Integer getCityId() {
/* 141 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Integer cityId) {
/* 145 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 151 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 155 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 161 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 165 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 171 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 175 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Hospital\MedicHospitals.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */