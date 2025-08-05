/*    */ package nencer.app.Modules.Customer.Entity;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "customer_detail_object")
/*    */ public class CustomerDetailObject {
/*    */   private String doType;
/*    */   private String doCode;
/*    */   
/*    */   @Basic
/*    */   @Column(name = "do_type")
/*    */   public String getDoType() {
/* 18 */     return this.doType;
/*    */   }
/*    */   private String doName; private Integer doBenefit;
/*    */   public void setDoType(String doType) {
/* 22 */     this.doType = doType;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "do_code")
/*    */   public String getDoCode() {
/* 28 */     return this.doCode;
/*    */   }
/*    */   
/*    */   public void setDoCode(String doCode) {
/* 32 */     this.doCode = doCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "do_name")
/*    */   public String getDoName() {
/* 38 */     return this.doName;
/*    */   }
/*    */   
/*    */   public void setDoName(String doName) {
/* 42 */     this.doName = doName;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "do_benefit")
/*    */   public Integer getDoBenefit() {
/* 48 */     return this.doBenefit;
/*    */   }
/*    */   
/*    */   public void setDoBenefit(Integer doBenefit) {
/* 52 */     this.doBenefit = doBenefit;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 57 */     if (this == o) return true; 
/* 58 */     if (o == null || getClass() != o.getClass()) return false; 
/* 59 */     CustomerDetailObject that = (CustomerDetailObject)o;
/* 60 */     return (Objects.equals(this.doType, that.doType) && Objects.equals(this.doCode, that.doCode) && Objects.equals(this.doName, that.doName) && Objects.equals(this.doBenefit, that.doBenefit));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     return Objects.hash(new Object[] { this.doType, this.doCode, this.doName, this.doBenefit });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Entity\CustomerDetailObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */