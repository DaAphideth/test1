/*     */ package nencer.app.Modules.Medic.Entity.Department;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_departments")
/*     */ public class MedicDepartments
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String nameArray;
/*     */   private String nameByt;
/*     */   private String code;
/*     */   private String description;
/*     */   private String image;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  33 */     return this.id;
/*     */   }
/*     */   private String manager; private String allowUsers; private String phone; private String email; private Integer status; private Integer sort; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  43 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  47 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_users")
/*     */   public String getAllowUsers() {
/*  53 */     return this.allowUsers;
/*     */   }
/*     */   
/*     */   public void setAllowUsers(String allowUsers) {
/*  57 */     this.allowUsers = allowUsers;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_array")
/*     */   public String getNameArray() {
/*  63 */     return this.nameArray;
/*     */   }
/*     */   
/*     */   public void setNameArray(String nameArray) {
/*  67 */     this.nameArray = nameArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_byt")
/*     */   public String getNameByt() {
/*  73 */     return this.nameByt;
/*     */   }
/*     */   
/*     */   public void setNameByt(String nameByt) {
/*  77 */     this.nameByt = nameByt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  83 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  87 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  93 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  97 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "image")
/*     */   public String getImage() {
/* 103 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(String image) {
/* 107 */     this.image = image;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "manager")
/*     */   public String getManager() {
/* 113 */     return this.manager;
/*     */   }
/*     */   
/*     */   public void setManager(String manager) {
/* 117 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "phone")
/*     */   public String getPhone() {
/* 123 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 127 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "email")
/*     */   public String getEmail() {
/* 133 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 137 */     this.email = email;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 143 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 147 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 153 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 157 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 163 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 167 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 173 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 177 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Department\MedicDepartments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */