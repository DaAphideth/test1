/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ 
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "local_countries")
/*     */ public class LocalCountries
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String nameEn;
/*     */   private String code;
/*     */   private String dialCode;
/*     */   private String lang;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   private int featured; private Integer sort; private Integer status; private String area; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  33 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  39 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  43 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_en")
/*     */   public String getNameEn() {
/*  49 */     return this.nameEn;
/*     */   }
/*     */   
/*     */   public void setNameEn(String nameEn) {
/*  53 */     this.nameEn = nameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  59 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  63 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "dial_code")
/*     */   public String getDialCode() {
/*  69 */     return this.dialCode;
/*     */   }
/*     */   
/*     */   public void setDialCode(String dialCode) {
/*  73 */     this.dialCode = dialCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lang")
/*     */   public String getLang() {
/*  79 */     return this.lang;
/*     */   }
/*     */   
/*     */   public void setLang(String lang) {
/*  83 */     this.lang = lang;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public int getFeatured() {
/*  89 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(int featured) {
/*  93 */     this.featured = featured;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  99 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 103 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 109 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 113 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "area")
/*     */   public String getArea() {
/* 119 */     return this.area;
/*     */   }
/*     */   
/*     */   public void setArea(String area) {
/* 123 */     this.area = area;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 129 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 133 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 139 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 143 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalCountries.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */