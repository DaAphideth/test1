/*     */ package nencer.app.Modules.System.Entity.Hrm;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import org.springframework.data.annotation.CreatedDate;
/*     */ import org.springframework.data.annotation.LastModifiedBy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "hrm_jobs")
/*     */ public class HrmJobs
/*     */ {
/*     */   private int id;
/*     */   private String title;
/*     */   private String image;
/*     */   private String code;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  28 */     return this.id;
/*     */   } private int status; private Integer minSalary; private Integer maxSalary; @CreatedDate
/*     */   private Date createdAt; @LastModifiedBy
/*     */   private Date updatedAt; public void setId(int id) {
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
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  48 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  52 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  58 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  62 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public int getStatus() {
/*  68 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/*  72 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "min_salary")
/*     */   public Integer getMinSalary() {
/*  78 */     return this.minSalary;
/*     */   }
/*     */   
/*     */   public void setMinSalary(Integer minSalary) {
/*  82 */     this.minSalary = minSalary;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "max_salary")
/*     */   public Integer getMaxSalary() {
/*  88 */     return this.maxSalary;
/*     */   }
/*     */   
/*     */   public void setMaxSalary(Integer maxSalary) {
/*  92 */     this.maxSalary = maxSalary;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  98 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 102 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 108 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 112 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 117 */     if (this == o) return true; 
/* 118 */     if (o == null || getClass() != o.getClass()) return false; 
/* 119 */     HrmJobs hrmJobs = (HrmJobs)o;
/* 120 */     return (this.id == hrmJobs.id && this.status == hrmJobs.status && Objects.equals(this.title, hrmJobs.title) && Objects.equals(this.image, hrmJobs.image) && Objects.equals(this.code, hrmJobs.code) && Objects.equals(this.minSalary, hrmJobs.minSalary) && Objects.equals(this.maxSalary, hrmJobs.maxSalary) && Objects.equals(this.createdAt, hrmJobs.createdAt) && Objects.equals(this.updatedAt, hrmJobs.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.title, this.image, this.code, Integer.valueOf(this.status), this.minSalary, this.maxSalary, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\Hrm\HrmJobs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */