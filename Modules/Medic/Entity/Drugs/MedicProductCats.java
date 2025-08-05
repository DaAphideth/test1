/*     */ package nencer.app.Modules.Medic.Entity.Drugs;
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_product_cats", schema = "nencer_api")
/*     */ public class MedicProductCats {
/*     */   public String toString() {
/*  11 */     return "MedicProductCats(id=" + getId() + ", name=" + getName() + ", slug=" + getSlug() + ", area=" + getArea() + ", description=" + getDescription() + ", sort=" + getSort() + ", image=" + getImage() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")";
/*     */   }
/*     */   private int id;
/*     */   private String name;
/*     */   private String slug;
/*     */   private String area;
/*     */   private String description;
/*     */   private Integer sort;
/*     */   private String image;
/*     */   private Integer status;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  27 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  31 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  37 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  41 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "slug")
/*     */   public String getSlug() {
/*  47 */     return this.slug;
/*     */   }
/*     */   
/*     */   public void setSlug(String slug) {
/*  51 */     this.slug = slug;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "area")
/*     */   public String getArea() {
/*  57 */     return this.area;
/*     */   }
/*     */   
/*     */   public void setArea(String area) {
/*  61 */     this.area = area;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  67 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  71 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  77 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  81 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  87 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  91 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  97 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 101 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 107 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 111 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 117 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 121 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 126 */     if (this == o) return true; 
/* 127 */     if (o == null || getClass() != o.getClass()) return false; 
/* 128 */     MedicProductCats that = (MedicProductCats)o;
/* 129 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.slug, that.slug) && Objects.equals(this.area, that.area) && Objects.equals(this.description, that.description) && Objects.equals(this.sort, that.sort) && Objects.equals(this.image, that.image) && Objects.equals(this.status, that.status) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 134 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.slug, this.area, this.description, this.sort, this.image, this.status, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Drugs\MedicProductCats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */