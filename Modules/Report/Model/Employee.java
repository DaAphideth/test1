/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Employee
/*    */ {
/*    */   private String name;
/*    */   private Date birthDate;
/*    */   private BigDecimal payment;
/*    */   private BigDecimal bonus;
/*    */   
/*    */   public Employee(String name, Date birthDate, BigDecimal payment, BigDecimal bonus) {
/* 16 */     this.name = name;
/* 17 */     this.birthDate = birthDate;
/* 18 */     this.payment = payment;
/* 19 */     this.bonus = bonus;
/*    */   }
/*    */   
/*    */   public Employee(String name, Date birthDate, double payment, double bonus) {
/* 23 */     this(name, birthDate, new BigDecimal(payment), new BigDecimal(bonus));
/*    */   }
/*    */   
/*    */   public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 31 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Date getBirthDate() {
/* 35 */     return this.birthDate;
/*    */   }
/*    */   
/*    */   public void setBirthDate(Date birthDate) {
/* 39 */     this.birthDate = birthDate;
/*    */   }
/*    */   
/*    */   public BigDecimal getPayment() {
/* 43 */     return this.payment;
/*    */   }
/*    */   
/*    */   public void setPayment(BigDecimal payment) {
/* 47 */     this.payment = payment;
/*    */   }
/*    */   
/*    */   public BigDecimal getBonus() {
/* 51 */     return this.bonus;
/*    */   }
/*    */   
/*    */   public void setBonus(BigDecimal bonus) {
/* 55 */     this.bonus = bonus;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\Employee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */