/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "local_regions")
/*     */ public class LocalRegions {
/*     */   private int id;
/*     */   private String name;
/*     */   private String nameEn;
/*     */   private String codeName;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  24 */     return this.id;
/*     */   }
/*     */   private String codeNameEn; private Integer sort; private Integer status; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  28 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  34 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  38 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_en")
/*     */   public String getNameEn() {
/*  44 */     return this.nameEn;
/*     */   }
/*     */   
/*     */   public void setNameEn(String nameEn) {
/*  48 */     this.nameEn = nameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name")
/*     */   public String getCodeName() {
/*  54 */     return this.codeName;
/*     */   }
/*     */   
/*     */   public void setCodeName(String codeName) {
/*  58 */     this.codeName = codeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name_en")
/*     */   public String getCodeNameEn() {
/*  64 */     return this.codeNameEn;
/*     */   }
/*     */   
/*     */   public void setCodeNameEn(String codeNameEn) {
/*  68 */     this.codeNameEn = codeNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  74 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  78 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  84 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  88 */     this.status = status;
/*     */   }
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  93 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  97 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 103 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 107 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 112 */     if (this == o) return true; 
/* 113 */     if (o == null || getClass() != o.getClass()) return false; 
/* 114 */     LocalRegions that = (LocalRegions)o;
/* 115 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.nameEn, that.nameEn) && Objects.equals(this.codeName, that.codeName) && Objects.equals(this.codeNameEn, that.codeNameEn) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.nameEn, this.codeName, this.codeNameEn, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalRegions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */