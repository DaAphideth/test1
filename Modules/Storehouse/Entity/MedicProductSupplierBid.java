/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ 
/*     */ import java.sql.Date;
/*     */ import java.util.Objects;
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
/*     */ @Entity
/*     */ @Table(name = "medic_product_supplier_bid")
/*     */ public class MedicProductSupplierBid
/*     */ {
/*     */   private int id;
/*     */   private Integer productId;
/*     */   private String code;
/*     */   private String name;
/*     */   private String bidNumber;
/*     */   private String bidGroup;
/*     */   private String bidPackage;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  31 */     return this.id;
/*     */   }
/*     */   private Date bidDate; private String bidYear; private String description; private Integer status; private String creatorId; private String updaterId; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  35 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "product_id")
/*     */   public Integer getProductId() {
/*  41 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Integer productId) {
/*  45 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  51 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  55 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  61 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  65 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_number")
/*     */   public String getBidNumber() {
/*  71 */     return this.bidNumber;
/*     */   }
/*     */   
/*     */   public void setBidNumber(String bidNumber) {
/*  75 */     this.bidNumber = bidNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_group")
/*     */   public String getBidGroup() {
/*  81 */     return this.bidGroup;
/*     */   }
/*     */   
/*     */   public void setBidGroup(String bidGroup) {
/*  85 */     this.bidGroup = bidGroup;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_package")
/*     */   public String getBidPackage() {
/*  91 */     return this.bidPackage;
/*     */   }
/*     */   
/*     */   public void setBidPackage(String bidPackage) {
/*  95 */     this.bidPackage = bidPackage;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_date")
/*     */   public Date getBidDate() {
/* 101 */     return this.bidDate;
/*     */   }
/*     */   
/*     */   public void setBidDate(Date bidDate) {
/* 105 */     this.bidDate = bidDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bid_year")
/*     */   public String getBidYear() {
/* 111 */     return this.bidYear;
/*     */   }
/*     */   
/*     */   public void setBidYear(String bidYear) {
/* 115 */     this.bidYear = bidYear;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 121 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 125 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 131 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 135 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public String getCreatorId() {
/* 141 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String creatorId) {
/* 145 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 151 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 155 */     this.updaterId = updaterId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 161 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 165 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 171 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 175 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 180 */     if (this == o) return true; 
/* 181 */     if (o == null || getClass() != o.getClass()) return false; 
/* 182 */     MedicProductSupplierBid that = (MedicProductSupplierBid)o;
/* 183 */     return (this.id == that.id && Objects.equals(this.productId, that.productId) && Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name) && Objects.equals(this.bidNumber, that.bidNumber) && Objects.equals(this.bidGroup, that.bidGroup) && Objects.equals(this.bidPackage, that.bidPackage) && Objects.equals(this.bidDate, that.bidDate) && Objects.equals(this.bidYear, that.bidYear) && Objects.equals(this.description, that.description) && Objects.equals(this.status, that.status) && Objects.equals(this.creatorId, that.creatorId) && Objects.equals(this.updaterId, that.updaterId) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 188 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.productId, this.code, this.name, this.bidNumber, this.bidGroup, this.bidPackage, this.bidDate, this.bidYear, this.description, this.status, this.creatorId, this.updaterId, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductSupplierBid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */