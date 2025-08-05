/*     */ package nencer.app.Modules.Users.Entity.User;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "user_images")
/*     */ public class UserImages
/*     */ {
/*     */   private int id;
/*     */   private String title;
/*     */   private int userId;
/*     */   private String description;
/*     */   private String image;
/*     */   private String size;
/*     */   private String extension;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  28 */     return this.id;
/*     */   }
/*     */   private Integer album; private String cat; private Integer sort; private String type; private String admin; private Timestamp createdAt; private Timestamp updatedAt;
/*     */   public void setId(int id) {
/*  32 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "title")
/*     */   public String getTitle() {
/*  38 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  42 */     this.title = title;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public int getUserId() {
/*  48 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  52 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  58 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  62 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  68 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  72 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "size")
/*     */   public String getSize() {
/*  78 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(String size) {
/*  82 */     this.size = size;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "extension")
/*     */   public String getExtension() {
/*  88 */     return this.extension;
/*     */   }
/*     */   
/*     */   public void setExtension(String extension) {
/*  92 */     this.extension = extension;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "album")
/*     */   public Integer getAlbum() {
/*  98 */     return this.album;
/*     */   }
/*     */   
/*     */   public void setAlbum(Integer album) {
/* 102 */     this.album = album;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "cat")
/*     */   public String getCat() {
/* 108 */     return this.cat;
/*     */   }
/*     */   
/*     */   public void setCat(String cat) {
/* 112 */     this.cat = cat;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 118 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 122 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/* 128 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 132 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "admin")
/*     */   public String getAdmin() {
/* 138 */     return this.admin;
/*     */   }
/*     */   
/*     */   public void setAdmin(String admin) {
/* 142 */     this.admin = admin;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Timestamp getCreatedAt() {
/* 148 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Timestamp createdAt) {
/* 152 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Timestamp getUpdatedAt() {
/* 158 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Timestamp updatedAt) {
/* 162 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 167 */     if (this == o) return true; 
/* 168 */     if (o == null || getClass() != o.getClass()) return false; 
/* 169 */     UserImages that = (UserImages)o;
/* 170 */     return (this.id == that.id && this.userId == that.userId && Objects.equals(this.title, that.title) && Objects.equals(this.description, that.description) && Objects.equals(this.image, that.image) && Objects.equals(this.size, that.size) && Objects.equals(this.extension, that.extension) && Objects.equals(this.album, that.album) && Objects.equals(this.cat, that.cat) && Objects.equals(this.sort, that.sort) && Objects.equals(this.type, that.type) && Objects.equals(this.admin, that.admin) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.title, Integer.valueOf(this.userId), this.description, this.image, this.size, this.extension, this.album, this.cat, this.sort, this.type, this.admin, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserImages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */