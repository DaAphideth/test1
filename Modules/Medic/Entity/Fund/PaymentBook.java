/*     */ package nencer.app.Modules.Medic.Entity.Fund;
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
/*     */ @Entity
/*     */ @Table(name = "payment_book")
/*     */ public class PaymentBook {
/*     */   private Integer pbId;
/*     */   private Integer userId;
/*     */   private Integer storehouseId;
/*     */   private String bookCode;
/*     */   private Integer startNumber;
/*     */   
/*     */   @Id
/*     */   @Column(name = "pb_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getPbId() {
/*  25 */     return this.pbId;
/*     */   }
/*     */   private Integer endNumber; private Integer currentCountNumber; private String status; private Date createdDate; private Date updatedDate;
/*     */   public void setPbId(Integer pbId) {
/*  29 */     this.pbId = pbId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public Integer getUserId() {
/*  35 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Integer userId) {
/*  39 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "storehouse_id")
/*     */   public Integer getStorehouseId() {
/*  45 */     return this.storehouseId;
/*     */   }
/*     */   
/*     */   public void setStorehouseId(Integer storehouseId) {
/*  49 */     this.storehouseId = storehouseId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "book_code")
/*     */   public String getBookCode() {
/*  55 */     return this.bookCode;
/*     */   }
/*     */   
/*     */   public void setBookCode(String bookCode) {
/*  59 */     this.bookCode = bookCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "start_number")
/*     */   public Integer getStartNumber() {
/*  65 */     return this.startNumber;
/*     */   }
/*     */   
/*     */   public void setStartNumber(Integer startNumber) {
/*  69 */     this.startNumber = startNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "end_number")
/*     */   public Integer getEndNumber() {
/*  75 */     return this.endNumber;
/*     */   }
/*     */   
/*     */   public void setEndNumber(Integer endNumber) {
/*  79 */     this.endNumber = endNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "current_count_number")
/*     */   public Integer getCurrentCountNumber() {
/*  85 */     return this.currentCountNumber;
/*     */   }
/*     */   
/*     */   public void setCurrentCountNumber(Integer currentCountNumber) {
/*  89 */     this.currentCountNumber = currentCountNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/*  95 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/*  99 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_date")
/*     */   public Date getCreatedDate() {
/* 105 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Date createdDate) {
/* 109 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_date")
/*     */   public Date getUpdatedDate() {
/* 115 */     return this.updatedDate;
/*     */   }
/*     */   
/*     */   public void setUpdatedDate(Date updatedDate) {
/* 119 */     this.updatedDate = updatedDate;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Fund\PaymentBook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */