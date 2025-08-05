/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "local_wards")
/*     */ public class LocalWards implements Serializable {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String nameEn;
/*     */   private String fullName;
/*     */   private String fullNameEn;
/*     */   private String codeName;
/*     */   private String districtCode;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  30 */     return this.id;
/*     */   }
/*     */   private String shortCode; private Integer administrativeUnitId; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private LocalDistricts localDistricts; private LocalAdminUnits adminUnits;
/*     */   public void setId(int id) {
/*  34 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  40 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  44 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  50 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  54 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_en")
/*     */   public String getNameEn() {
/*  60 */     return this.nameEn;
/*     */   }
/*     */   
/*     */   public void setNameEn(String nameEn) {
/*  64 */     this.nameEn = nameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name")
/*     */   public String getFullName() {
/*  70 */     return this.fullName;
/*     */   }
/*     */   
/*     */   public void setFullName(String fullName) {
/*  74 */     this.fullName = fullName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name_en")
/*     */   public String getFullNameEn() {
/*  80 */     return this.fullNameEn;
/*     */   }
/*     */   
/*     */   public void setFullNameEn(String fullNameEn) {
/*  84 */     this.fullNameEn = fullNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name")
/*     */   public String getCodeName() {
/*  90 */     return this.codeName;
/*     */   }
/*     */   
/*     */   public void setCodeName(String codeName) {
/*  94 */     this.codeName = codeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "district_code")
/*     */   public String getDistrictCode() {
/* 100 */     return this.districtCode;
/*     */   }
/*     */   
/*     */   public void setDistrictCode(String districtCode) {
/* 104 */     this.districtCode = districtCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "short_code")
/*     */   public String getShortCode() {
/* 110 */     return this.shortCode;
/*     */   }
/*     */   
/*     */   public void setShortCode(String shortCode) {
/* 114 */     this.shortCode = shortCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "administrative_unit_id")
/*     */   public Integer getAdministrativeUnitId() {
/* 120 */     return this.administrativeUnitId;
/*     */   }
/*     */   
/*     */   public void setAdministrativeUnitId(Integer administrativeUnitId) {
/* 124 */     this.administrativeUnitId = administrativeUnitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 130 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 134 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 140 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 144 */     this.status = status;
/*     */   }
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 149 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 153 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 159 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 163 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "district_code", referencedColumnName = "code", nullable = true, updatable = false, insertable = false)
/*     */   public LocalDistricts getLocalDistricts() {
/* 169 */     return this.localDistricts;
/*     */   }
/*     */   
/*     */   public void setLocalDistricts(LocalDistricts localDistricts) {
/* 173 */     this.localDistricts = localDistricts;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "administrative_unit_id", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
/*     */   public LocalAdminUnits getLocalAdminUnits() {
/* 181 */     return this.adminUnits;
/*     */   }
/*     */   
/*     */   public void setLocalAdminUnits(LocalAdminUnits adminUnits) {
/* 185 */     this.adminUnits = adminUnits;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalWards.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */