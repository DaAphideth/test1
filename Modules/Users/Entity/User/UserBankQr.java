/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "user_bank_qr")
/*    */ public class UserBankQr {
/*    */   private int id;
/*    */   private String bankCode;
/*    */   private String adminBankNumber;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   private int userPhone; private String qr; private Timestamp createdAt; private Timestamp updatedAt;
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "bank_code")
/*    */   public String getBankCode() {
/* 31 */     return this.bankCode;
/*    */   }
/*    */   
/*    */   public void setBankCode(String bankCode) {
/* 35 */     this.bankCode = bankCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "admin_bank_number")
/*    */   public String getAdminBankNumber() {
/* 41 */     return this.adminBankNumber;
/*    */   }
/*    */   
/*    */   public void setAdminBankNumber(String adminBankNumber) {
/* 45 */     this.adminBankNumber = adminBankNumber;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "user_phone")
/*    */   public int getUserPhone() {
/* 51 */     return this.userPhone;
/*    */   }
/*    */   
/*    */   public void setUserPhone(int userPhone) {
/* 55 */     this.userPhone = userPhone;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "qr")
/*    */   public String getQr() {
/* 61 */     return this.qr;
/*    */   }
/*    */   
/*    */   public void setQr(String qr) {
/* 65 */     this.qr = qr;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Timestamp getCreatedAt() {
/* 71 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Timestamp createdAt) {
/* 75 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Timestamp getUpdatedAt() {
/* 81 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Timestamp updatedAt) {
/* 85 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 90 */     if (this == o) return true; 
/* 91 */     if (o == null || getClass() != o.getClass()) return false; 
/* 92 */     UserBankQr that = (UserBankQr)o;
/* 93 */     return (this.id == that.id && this.userPhone == that.userPhone && Objects.equals(this.bankCode, that.bankCode) && Objects.equals(this.adminBankNumber, that.adminBankNumber) && Objects.equals(this.qr, that.qr) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.bankCode, this.adminBankNumber, Integer.valueOf(this.userPhone), this.qr, this.createdAt, this.updatedAt });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserBankQr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */