/*     */ package nencer.app.Modules.Storehouse.Entity;
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
/*     */ @Entity
/*     */ @Table(name = "medic_product_supplier")
/*     */ public class MedicProductSupplier
/*     */ {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String address;
/*     */   private String contactPhone;
/*     */   private String contactEmail;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  28 */     return this.id;
/*     */   }
/*     */   private String description; private Integer status; private String creatorId; private String updaterId; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  32 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  38 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  42 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  48 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  52 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/*  58 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  62 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "contact_phone")
/*     */   public String getContactPhone() {
/*  68 */     return this.contactPhone;
/*     */   }
/*     */   
/*     */   public void setContactPhone(String contactPhone) {
/*  72 */     this.contactPhone = contactPhone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "contact_email")
/*     */   public String getContactEmail() {
/*  78 */     return this.contactEmail;
/*     */   }
/*     */   
/*     */   public void setContactEmail(String contactEmail) {
/*  82 */     this.contactEmail = contactEmail;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  88 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  92 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  98 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 102 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public String getCreatorId() {
/* 108 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String creatorId) {
/* 112 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 118 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 122 */     this.updaterId = updaterId;
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
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */