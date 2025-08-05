/*     */ package nencer.app.Modules.Medic.Entity.Location;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_locations")
/*     */ public class MedicLocations
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String code;
/*     */   private String image;
/*     */   private String description;
/*     */   private String certificate;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  26 */     return this.id;
/*     */   }
/*     */   private String manager; private String address; private Integer cityId; private String countryCode; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  30 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  36 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  40 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  46 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  50 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  56 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  60 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  66 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  70 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "certificate")
/*     */   public String getCertificate() {
/*  76 */     return this.certificate;
/*     */   }
/*     */   
/*     */   public void setCertificate(String certificate) {
/*  80 */     this.certificate = certificate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "manager")
/*     */   public String getManager() {
/*  86 */     return this.manager;
/*     */   }
/*     */   
/*     */   public void setManager(String manager) {
/*  90 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/*  96 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 100 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "city_id")
/*     */   public Integer getCityId() {
/* 106 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Integer cityId) {
/* 110 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 116 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 120 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 126 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 130 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 136 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 140 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 145 */     if (this == o) return true; 
/* 146 */     if (o == null || getClass() != o.getClass()) return false; 
/* 147 */     MedicLocations that = (MedicLocations)o;
/* 148 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.code, that.code) && Objects.equals(this.image, that.image) && Objects.equals(this.description, that.description) && Objects.equals(this.certificate, that.certificate) && Objects.equals(this.manager, that.manager) && Objects.equals(this.address, that.address) && Objects.equals(this.cityId, that.cityId) && Objects.equals(this.countryCode, that.countryCode) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 153 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, this.image, this.description, this.certificate, this.manager, this.address, this.cityId, this.countryCode, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Location\MedicLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */