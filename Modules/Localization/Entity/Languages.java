/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ 
/*     */ @Entity
/*     */ public class Languages {
/*     */   private int id;
/*     */   private String name;
/*     */   private String code;
/*     */   private String flag;
/*     */   private String hreflang;
/*     */   private String charset;
/*     */   private int isDefault;
/*     */   private int status;
/*     */   private int installed;
/*     */   private int sort;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  28 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  32 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  38 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  42 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  48 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  52 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "flag")
/*     */   public String getFlag() {
/*  58 */     return this.flag;
/*     */   }
/*     */   
/*     */   public void setFlag(String flag) {
/*  62 */     this.flag = flag;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hreflang")
/*     */   public String getHreflang() {
/*  68 */     return this.hreflang;
/*     */   }
/*     */   
/*     */   public void setHreflang(String hreflang) {
/*  72 */     this.hreflang = hreflang;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "charset")
/*     */   public String getCharset() {
/*  78 */     return this.charset;
/*     */   }
/*     */   
/*     */   public void setCharset(String charset) {
/*  82 */     this.charset = charset;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "default")
/*     */   public int getIsDefault() {
/*  88 */     return this.isDefault;
/*     */   }
/*     */   
/*     */   public void setIsDefault(int isDefault) {
/*  92 */     this.isDefault = isDefault;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public int getStatus() {
/*  98 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/* 102 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "installed")
/*     */   public int getInstalled() {
/* 108 */     return this.installed;
/*     */   }
/*     */   
/*     */   public void setInstalled(int installed) {
/* 112 */     this.installed = installed;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public int getSort() {
/* 118 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(int sort) {
/* 122 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 128 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 132 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 138 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 142 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 147 */     if (this == o) return true; 
/* 148 */     if (o == null || getClass() != o.getClass()) return false; 
/* 149 */     Languages languages = (Languages)o;
/* 150 */     return (this.id == languages.id && this.isDefault == languages.isDefault && this.status == languages.status && this.installed == languages.installed && this.sort == languages.sort && Objects.equals(this.name, languages.name) && Objects.equals(this.code, languages.code) && Objects.equals(this.flag, languages.flag) && Objects.equals(this.hreflang, languages.hreflang) && Objects.equals(this.charset, languages.charset) && Objects.equals(this.createdAt, languages.createdAt) && Objects.equals(this.updatedAt, languages.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 155 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, this.flag, this.hreflang, this.charset, Integer.valueOf(this.isDefault), Integer.valueOf(this.status), Integer.valueOf(this.installed), Integer.valueOf(this.sort), this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\Languages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */