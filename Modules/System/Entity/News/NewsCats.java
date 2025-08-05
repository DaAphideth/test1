/*     */ package nencer.app.Modules.System.Entity.News;
/*     */ 
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
/*     */ @Table(name = "news_cats")
/*     */ public class NewsCats
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String urlKey;
/*     */   private String description;
/*     */   private Integer parentId;
/*     */   private Integer sort;
/*     */   private Integer level;
/*     */   
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   private String image; private String lang; private Integer lft; private Integer rgt; private Integer status; private Date createdAt; private Date updatedAt;
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
/*     */   @Column(name = "url_key")
/*     */   public String getUrlKey() {
/*  49 */     return this.urlKey;
/*     */   }
/*     */   
/*     */   public void setUrlKey(String urlKey) {
/*  53 */     this.urlKey = urlKey;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  59 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  63 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "parent_id")
/*     */   public Integer getParentId() {
/*  69 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(Integer parentId) {
/*  73 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  79 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  83 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "level")
/*     */   public Integer getLevel() {
/*  89 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(Integer level) {
/*  93 */     this.level = level;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  99 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/* 103 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lang")
/*     */   public String getLang() {
/* 109 */     return this.lang;
/*     */   }
/*     */   
/*     */   public void setLang(String lang) {
/* 113 */     this.lang = lang;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "_lft")
/*     */   public Integer getLft() {
/* 119 */     return this.lft;
/*     */   }
/*     */   
/*     */   public void setLft(Integer lft) {
/* 123 */     this.lft = lft;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "_rgt")
/*     */   public Integer getRgt() {
/* 129 */     return this.rgt;
/*     */   }
/*     */   
/*     */   public void setRgt(Integer rgt) {
/* 133 */     this.rgt = rgt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 139 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 143 */     this.status = status;
/*     */   }
/*     */   
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
/*     */   
/*     */   public boolean equals(Object o) {
/* 168 */     if (this == o) return true; 
/* 169 */     if (o == null || getClass() != o.getClass()) return false; 
/* 170 */     NewsCats newsCats = (NewsCats)o;
/* 171 */     return (this.id == newsCats.id && Objects.equals(this.name, newsCats.name) && Objects.equals(this.urlKey, newsCats.urlKey) && Objects.equals(this.description, newsCats.description) && Objects.equals(this.parentId, newsCats.parentId) && Objects.equals(this.sort, newsCats.sort) && Objects.equals(this.level, newsCats.level) && Objects.equals(this.image, newsCats.image) && Objects.equals(this.lang, newsCats.lang) && Objects.equals(this.lft, newsCats.lft) && Objects.equals(this.rgt, newsCats.rgt) && Objects.equals(this.status, newsCats.status) && Objects.equals(this.createdAt, newsCats.createdAt) && Objects.equals(this.updatedAt, newsCats.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.urlKey, this.description, this.parentId, this.sort, this.level, this.image, this.lang, this.lft, this.rgt, this.status, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\News\NewsCats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */