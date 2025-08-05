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
/*     */ @Entity
/*     */ @Table(name = "user_certificates")
/*     */ public class UserCertificates
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private int userId;
/*     */   private String image;
/*     */   private String type;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  25 */     return this.id;
/*     */   }
/*     */   private Timestamp issueDate; private Timestamp expireDate; private String issueBy; private Integer status; private Timestamp createdAt; private Timestamp updatedAt;
/*     */   public void setId(int id) {
/*  29 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  35 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  39 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public int getUserId() {
/*  45 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  49 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/*  55 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/*  59 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/*  65 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  69 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "issue_date")
/*     */   public Timestamp getIssueDate() {
/*  75 */     return this.issueDate;
/*     */   }
/*     */   
/*     */   public void setIssueDate(Timestamp issueDate) {
/*  79 */     this.issueDate = issueDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "expire_date")
/*     */   public Timestamp getExpireDate() {
/*  85 */     return this.expireDate;
/*     */   }
/*     */   
/*     */   public void setExpireDate(Timestamp expireDate) {
/*  89 */     this.expireDate = expireDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "issue_by")
/*     */   public String getIssueBy() {
/*  95 */     return this.issueBy;
/*     */   }
/*     */   
/*     */   public void setIssueBy(String issueBy) {
/*  99 */     this.issueBy = issueBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 105 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 109 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Timestamp getCreatedAt() {
/* 115 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Timestamp createdAt) {
/* 119 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Timestamp getUpdatedAt() {
/* 125 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Timestamp updatedAt) {
/* 129 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 134 */     if (this == o) return true; 
/* 135 */     if (o == null || getClass() != o.getClass()) return false; 
/* 136 */     UserCertificates that = (UserCertificates)o;
/* 137 */     return (this.id == that.id && this.userId == that.userId && Objects.equals(this.name, that.name) && Objects.equals(this.image, that.image) && Objects.equals(this.type, that.type) && Objects.equals(this.issueDate, that.issueDate) && Objects.equals(this.expireDate, that.expireDate) && Objects.equals(this.issueBy, that.issueBy) && Objects.equals(this.status, that.status) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 142 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, Integer.valueOf(this.userId), this.image, this.type, this.issueDate, this.expireDate, this.issueBy, this.status, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserCertificates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */