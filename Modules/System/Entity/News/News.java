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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ public class News
/*     */ {
/*     */   private int id;
/*     */   private String title;
/*     */   private String newsSlug;
/*     */   private String meta;
/*     */   private String shortDescription;
/*     */   private String description;
/*     */   private String author;
/*     */   private String authorEmail;
/*     */   
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  32 */     return this.id;
/*     */   }
/*     */   private String image; private String language; private Byte customLayout; private Integer viewCount; private Integer status; private Integer cats; private String publishDate; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  36 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "title")
/*     */   public String getTitle() {
/*  42 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  46 */     this.title = title;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "news_slug")
/*     */   public String getNewsSlug() {
/*  52 */     return this.newsSlug;
/*     */   }
/*     */   
/*     */   public void setNewsSlug(String newsSlug) {
/*  56 */     this.newsSlug = newsSlug;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "meta")
/*     */   public String getMeta() {
/*  62 */     return this.meta;
/*     */   }
/*     */   
/*     */   public void setMeta(String meta) {
/*  66 */     this.meta = meta;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "short_description")
/*     */   public String getShortDescription() {
/*  72 */     return this.shortDescription;
/*     */   }
/*     */   
/*     */   public void setShortDescription(String shortDescription) {
/*  76 */     this.shortDescription = shortDescription;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  82 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  86 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "author")
/*     */   public String getAuthor() {
/*  92 */     return this.author;
/*     */   }
/*     */   
/*     */   public void setAuthor(String author) {
/*  96 */     this.author = author;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "author_email")
/*     */   public String getAuthorEmail() {
/* 102 */     return this.authorEmail;
/*     */   }
/*     */   
/*     */   public void setAuthorEmail(String authorEmail) {
/* 106 */     this.authorEmail = authorEmail;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/* 112 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/* 116 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "language")
/*     */   public String getLanguage() {
/* 122 */     return this.language;
/*     */   }
/*     */   
/*     */   public void setLanguage(String language) {
/* 126 */     this.language = language;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "custom_layout")
/*     */   public Byte getCustomLayout() {
/* 132 */     return this.customLayout;
/*     */   }
/*     */   
/*     */   public void setCustomLayout(Byte customLayout) {
/* 136 */     this.customLayout = customLayout;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "view_count")
/*     */   public Integer getViewCount() {
/* 142 */     return this.viewCount;
/*     */   }
/*     */   
/*     */   public void setViewCount(Integer viewCount) {
/* 146 */     this.viewCount = viewCount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 152 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 156 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "cats")
/*     */   public Integer getCats() {
/* 162 */     return this.cats;
/*     */   }
/*     */   
/*     */   public void setCats(Integer cats) {
/* 166 */     this.cats = cats;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "publish_date")
/*     */   public String getPublishDate() {
/* 172 */     return this.publishDate;
/*     */   }
/*     */   
/*     */   public void setPublishDate(String publishDate) {
/* 176 */     this.publishDate = publishDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 182 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 186 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 192 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 196 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 203 */     if (this == o) return true; 
/* 204 */     if (o == null || getClass() != o.getClass()) return false; 
/* 205 */     News news = (News)o;
/* 206 */     return (this.id == news.id && this.status == news.status && Objects.equals(this.title, news.title) && Objects.equals(this.newsSlug, news.newsSlug) && Objects.equals(this.meta, news.meta) && Objects.equals(this.shortDescription, news.shortDescription) && Objects.equals(this.description, news.description) && Objects.equals(this.author, news.author) && Objects.equals(this.authorEmail, news.authorEmail) && Objects.equals(this.image, news.image) && Objects.equals(this.language, news.language) && Objects.equals(this.customLayout, news.customLayout) && Objects.equals(this.viewCount, news.viewCount) && Objects.equals(this.cats, news.cats) && Objects.equals(this.publishDate, news.publishDate) && Objects.equals(this.createdAt, news.createdAt) && Objects.equals(this.updatedAt, news.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 211 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.title, this.newsSlug, this.meta, this.shortDescription, this.description, this.author, this.authorEmail, this.image, this.language, this.customLayout, this.viewCount, this.status, this.cats, this.publishDate, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\News\News.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */