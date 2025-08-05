/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "local_provinces")
/*     */ public class LocalProvinces implements Serializable {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String nameEn;
/*     */   private String fullName;
/*     */   private String fullNameEn;
/*     */   private String codeName;
/*     */   private Integer administrativeUnitId;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  30 */     return this.id;
/*     */   }
/*     */   private Integer administrativeRegionId; private Integer featured; private Integer status; private Integer sort; private Date createdAt; private Date updatedAt; private LocalAdminUnits adminUnits; private LocalRegions localRegions;
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
/*     */   @Column(name = "administrative_unit_id")
/*     */   public Integer getAdministrativeUnitId() {
/* 100 */     return this.administrativeUnitId;
/*     */   }
/*     */   
/*     */   public void setAdministrativeUnitId(Integer administrativeUnitId) {
/* 104 */     this.administrativeUnitId = administrativeUnitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "administrative_region_id")
/*     */   public Integer getAdministrativeRegionId() {
/* 110 */     return this.administrativeRegionId;
/*     */   }
/*     */   
/*     */   public void setAdministrativeRegionId(Integer administrativeRegionId) {
/* 114 */     this.administrativeRegionId = administrativeRegionId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "featured")
/*     */   public Integer getFeatured() {
/* 120 */     return this.featured;
/*     */   }
/*     */   
/*     */   public void setFeatured(Integer featured) {
/* 124 */     this.featured = featured;
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
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 150 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 154 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 160 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 164 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "administrative_unit_id", nullable = true, updatable = false, insertable = false)
/*     */   public LocalAdminUnits getLocalAdminUnits() {
/* 170 */     return this.adminUnits;
/*     */   }
/*     */   
/*     */   public void setLocalAdminUnits(LocalAdminUnits adminUnits) {
/* 174 */     this.adminUnits = adminUnits;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "administrative_region_id", nullable = true, updatable = false, insertable = false)
/*     */   public LocalRegions getLocalRegions() {
/* 182 */     return this.localRegions;
/*     */   }
/*     */   
/*     */   public void setLocalRegions(LocalRegions localRegions) {
/* 186 */     this.localRegions = localRegions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 192 */     if (this == o) return true; 
/* 193 */     if (o == null || getClass() != o.getClass()) return false; 
/* 194 */     LocalProvinces that = (LocalProvinces)o;
/* 195 */     return (this.id == that.id && Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name) && Objects.equals(this.nameEn, that.nameEn) && Objects.equals(this.fullName, that.fullName) && Objects.equals(this.fullNameEn, that.fullNameEn) && Objects.equals(this.codeName, that.codeName) && Objects.equals(this.administrativeUnitId, that.administrativeUnitId) && Objects.equals(this.administrativeRegionId, that.administrativeRegionId) && Objects.equals(this.featured, that.featured) && Objects.equals(this.status, that.status) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 200 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.code, this.name, this.nameEn, this.fullName, this.fullNameEn, this.codeName, this.administrativeUnitId, this.administrativeRegionId, this.featured, this.status, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalProvinces.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */