/*     */ package nencer.app.Modules.Customer.Entity;
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
/*     */ @Table(name = "customer_family")
/*     */ public class CustomerFamily
/*     */ {
/*     */   private int faId;
/*     */   private Integer customerId;
/*     */   private Integer faCustomerId;
/*     */   private String faName;
/*     */   private String faIdCard;
/*     */   
/*     */   @Id
/*     */   @Column(name = "fa_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getFaId() {
/*  27 */     return this.faId;
/*     */   }
/*     */   private String faEducation; private String faAddress; private String faPhone; private String faParentsType; private Date createdAt; private Integer creatorId;
/*     */   public void setFaId(int faId) {
/*  31 */     this.faId = faId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/*  37 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/*  41 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_customer_id")
/*     */   public Integer getFaCustomerId() {
/*  47 */     return this.faCustomerId;
/*     */   }
/*     */   
/*     */   public void setFaCustomerId(Integer faCustomerId) {
/*  51 */     this.faCustomerId = faCustomerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_name")
/*     */   public String getFaName() {
/*  57 */     return this.faName;
/*     */   }
/*     */   
/*     */   public void setFaName(String faName) {
/*  61 */     this.faName = faName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_id_card")
/*     */   public String getFaIdCard() {
/*  67 */     return this.faIdCard;
/*     */   }
/*     */   
/*     */   public void setFaIdCard(String faIdCard) {
/*  71 */     this.faIdCard = faIdCard;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_education")
/*     */   public String getFaEducation() {
/*  77 */     return this.faEducation;
/*     */   }
/*     */   
/*     */   public void setFaEducation(String faEducation) {
/*  81 */     this.faEducation = faEducation;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_address")
/*     */   public String getFaAddress() {
/*  87 */     return this.faAddress;
/*     */   }
/*     */   
/*     */   public void setFaAddress(String faAddress) {
/*  91 */     this.faAddress = faAddress;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_phone")
/*     */   public String getFaPhone() {
/*  97 */     return this.faPhone;
/*     */   }
/*     */   
/*     */   public void setFaPhone(String faPhone) {
/* 101 */     this.faPhone = faPhone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fa_parents_type")
/*     */   public String getFaParentsType() {
/* 107 */     return this.faParentsType;
/*     */   }
/*     */   
/*     */   public void setFaParentsType(String faParentsType) {
/* 111 */     this.faParentsType = faParentsType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 117 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 121 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 127 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 131 */     this.creatorId = creatorId;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Entity\CustomerFamily.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */