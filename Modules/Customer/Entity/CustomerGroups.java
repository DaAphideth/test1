/*     */ package nencer.app.Modules.Customer.Entity;
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
/*     */ import org.springframework.data.annotation.CreatedDate;
/*     */ import org.springframework.data.annotation.LastModifiedDate;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "customer_groups")
/*     */ public class CustomerGroups
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String code;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  27 */     return this.id;
/*     */   } private String nameArray; private Integer sort; @CreatedDate
/*     */   private Date createdAt; @LastModifiedDate
/*     */   private Date updatedAt; public void setId(int id) {
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
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  47 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  51 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_array")
/*     */   public String getNameArray() {
/*  57 */     return this.nameArray;
/*     */   }
/*     */   
/*     */   public void setNameArray(String nameArray) {
/*  61 */     this.nameArray = nameArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  67 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  71 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  77 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  81 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/*  87 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/*  91 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  96 */     if (this == o) return true; 
/*  97 */     if (o == null || getClass() != o.getClass()) return false; 
/*  98 */     CustomerGroups that = (CustomerGroups)o;
/*  99 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.code, that.code) && Objects.equals(this.nameArray, that.nameArray) && Objects.equals(this.sort, that.sort) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 104 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, this.nameArray, this.sort, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Entity\CustomerGroups.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */