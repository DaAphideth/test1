/*     */ package nencer.app.Modules.Localization.Entity;
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
/*     */ @Entity
/*     */ @Table(name = "local_districts")
/*     */ public class LocalDistricts
/*     */   implements Serializable
/*     */ {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String nameEn;
/*     */   private String fullName;
/*     */   private String fullNameEn;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   private String codeName; private String provinceCode; private Integer administrativeUnitId; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  33 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  39 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  43 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  49 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  53 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_en")
/*     */   public String getNameEn() {
/*  59 */     return this.nameEn;
/*     */   }
/*     */   
/*     */   public void setNameEn(String nameEn) {
/*  63 */     this.nameEn = nameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name")
/*     */   public String getFullName() {
/*  69 */     return this.fullName;
/*     */   }
/*     */   
/*     */   public void setFullName(String fullName) {
/*  73 */     this.fullName = fullName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name_en")
/*     */   public String getFullNameEn() {
/*  79 */     return this.fullNameEn;
/*     */   }
/*     */   
/*     */   public void setFullNameEn(String fullNameEn) {
/*  83 */     this.fullNameEn = fullNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name")
/*     */   public String getCodeName() {
/*  89 */     return this.codeName;
/*     */   }
/*     */   
/*     */   public void setCodeName(String codeName) {
/*  93 */     this.codeName = codeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "province_code")
/*     */   public String getProvinceCode() {
/*  99 */     return this.provinceCode;
/*     */   }
/*     */   
/*     */   public void setProvinceCode(String provinceCode) {
/* 103 */     this.provinceCode = provinceCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "administrative_unit_id")
/*     */   public Integer getAdministrativeUnitId() {
/* 109 */     return this.administrativeUnitId;
/*     */   }
/*     */   
/*     */   public void setAdministrativeUnitId(Integer administrativeUnitId) {
/* 113 */     this.administrativeUnitId = administrativeUnitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 119 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 123 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 129 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 133 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 139 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 143 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 149 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 153 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalDistricts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */