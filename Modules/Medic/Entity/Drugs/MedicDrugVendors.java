/*     */ package nencer.app.Modules.Medic.Entity.Drugs;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_drug_vendors")
/*     */ public class MedicDrugVendors {
/*     */   public String toString() {
/*  11 */     return "MedicDrugVendors(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", image=" + getImage() + ", description=" + getDescription() + ", status=" + getStatus() + ", countryCode=" + getCountryCode() + ", cityId=" + getCityId() + ", address=" + getAddress() + ", phone=" + getPhone() + ", email=" + getEmail() + ", companyName=" + getCompanyName() + ", taxNumber=" + getTaxNumber() + ", companyAddress=" + getCompanyAddress() + ", certificate=" + getCertificate() + ", director=" + getDirector() + ", featured=" + getFeatured() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")";
/*     */   }
/*     */   private int id;
/*     */   private String name;
/*     */   private String code;
/*     */   private String image;
/*     */   private String description;
/*     */   private Integer status;
/*     */   private String countryCode;
/*     */   private Integer cityId;
/*     */   private String address;
/*     */   private String phone;
/*     */   private String email;
/*     */   private String companyName;
/*     */   private String taxNumber;
/*     */   private String companyAddress;
/*     */   private String certificate;
/*     */   private String director;
/*     */   private Integer featured;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  37 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  41 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  47 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  51 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  57 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  61 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  67 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  71 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  77 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  81 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  87 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  91 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/*  97 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 101 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "city_id")
/*     */   public Integer getCityId() {
/* 107 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Integer cityId) {
/* 111 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/* 117 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 121 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "phone")
/*     */   public String getPhone() {
/* 127 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 131 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "email")
/*     */   public String getEmail() {
/* 137 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 141 */     this.email = email;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "company_name")
/*     */   public String getCompanyName() {
/* 147 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/* 151 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "tax_number")
/*     */   public String getTaxNumber() {
/* 157 */     return this.taxNumber;
/*     */   }
/*     */   
/*     */   public void setTaxNumber(String taxNumber) {
/* 161 */     this.taxNumber = taxNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "company_address")
/*     */   public String getCompanyAddress() {
/* 167 */     return this.companyAddress;
/*     */   }
/*     */   
/*     */   public void setCompanyAddress(String companyAddress) {
/* 171 */     this.companyAddress = companyAddress;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "certificate")
/*     */   public String getCertificate() {
/* 177 */     return this.certificate;
/*     */   }
/*     */   
/*     */   public void setCertificate(String certificate) {
/* 181 */     this.certificate = certificate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "director")
/*     */   public String getDirector() {
/* 187 */     return this.director;
/*     */   }
/*     */   
/*     */   public void setDirector(String director) {
/* 191 */     this.director = director;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public Integer getFeatured() {
/* 197 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(Integer featured) {
/* 201 */     this.featured = featured;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 207 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 211 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 217 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 221 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 226 */     if (this == o) return true; 
/* 227 */     if (o == null || getClass() != o.getClass()) return false; 
/* 228 */     MedicDrugVendors that = (MedicDrugVendors)o;
/* 229 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.code, that.code) && Objects.equals(this.image, that.image) && Objects.equals(this.description, that.description) && Objects.equals(this.status, that.status) && Objects.equals(this.countryCode, that.countryCode) && Objects.equals(this.cityId, that.cityId) && Objects.equals(this.address, that.address) && Objects.equals(this.phone, that.phone) && Objects.equals(this.email, that.email) && Objects.equals(this.companyName, that.companyName) && Objects.equals(this.taxNumber, that.taxNumber) && Objects.equals(this.companyAddress, that.companyAddress) && Objects.equals(this.certificate, that.certificate) && Objects.equals(this.director, that.director) && Objects.equals(this.featured, that.featured) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 234 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, this.image, this.description, this.status, this.countryCode, this.cityId, this.address, this.phone, this.email, this.companyName, this.taxNumber, this.companyAddress, this.certificate, this.director, this.featured, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Drugs\MedicDrugVendors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */