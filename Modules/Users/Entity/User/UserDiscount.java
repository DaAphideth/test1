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
/*    */ @Table(name = "user_discount")
/*    */ public class UserDiscount {
/*    */   private int id;
/*    */   private int userId;
/*    */   private int level;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   private String module; private double discount; private Timestamp createdAt; private Timestamp updatedAt;
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "user_id")
/*    */   public int getUserId() {
/* 31 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(int userId) {
/* 35 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "level")
/*    */   public int getLevel() {
/* 41 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(int level) {
/* 45 */     this.level = level;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "module")
/*    */   public String getModule() {
/* 51 */     return this.module;
/*    */   }
/*    */   
/*    */   public void setModule(String module) {
/* 55 */     this.module = module;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "discount")
/*    */   public double getDiscount() {
/* 61 */     return this.discount;
/*    */   }
/*    */   
/*    */   public void setDiscount(double discount) {
/* 65 */     this.discount = discount;
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
/* 92 */     UserDiscount that = (UserDiscount)o;
/* 93 */     return (this.id == that.id && this.userId == that.userId && this.level == that.level && Double.compare(that.discount, this.discount) == 0 && Objects.equals(this.module, that.module) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), Integer.valueOf(this.userId), Integer.valueOf(this.level), this.module, Double.valueOf(this.discount), this.createdAt, this.updatedAt });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserDiscount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */