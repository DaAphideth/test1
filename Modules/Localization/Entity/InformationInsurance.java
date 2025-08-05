/*    */ package nencer.app.Modules.Localization.Entity;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "information_insurance")
/*    */ public class InformationInsurance {
/*    */   private int id;
/*    */   private Double minimumSalaryMonth;
/*    */   private Integer offlinePayment;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 20 */     return this.id;
/*    */   }
/*    */   private String apiSocialInsurance; private String accountSocialInsurance; private String passwordSocialInsurance;
/*    */   public void setId(int id) {
/* 24 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "minimum_salary_month")
/*    */   public Double getMinimumSalaryMonth() {
/* 30 */     return this.minimumSalaryMonth;
/*    */   }
/*    */   
/*    */   public void setMinimumSalaryMonth(Double minimumSalaryMonth) {
/* 34 */     this.minimumSalaryMonth = minimumSalaryMonth;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "offline_payment")
/*    */   public Integer getOfflinePayment() {
/* 40 */     return this.offlinePayment;
/*    */   }
/*    */   
/*    */   public void setOfflinePayment(Integer offlinePayment) {
/* 44 */     this.offlinePayment = offlinePayment;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "api_social_insurance")
/*    */   public String getApiSocialInsurance() {
/* 50 */     return this.apiSocialInsurance;
/*    */   }
/*    */   
/*    */   public void setApiSocialInsurance(String apiSocialInsurance) {
/* 54 */     this.apiSocialInsurance = apiSocialInsurance;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "account_social_insurance")
/*    */   public String getAccountSocialInsurance() {
/* 60 */     return this.accountSocialInsurance;
/*    */   }
/*    */   
/*    */   public void setAccountSocialInsurance(String accountSocialInsurance) {
/* 64 */     this.accountSocialInsurance = accountSocialInsurance;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "password_social_insurance")
/*    */   public String getPasswordSocialInsurance() {
/* 70 */     return this.passwordSocialInsurance;
/*    */   }
/*    */   
/*    */   public void setPasswordSocialInsurance(String passwordSocialInsurance) {
/* 74 */     this.passwordSocialInsurance = passwordSocialInsurance;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 79 */     if (this == o) return true; 
/* 80 */     if (o == null || getClass() != o.getClass()) return false; 
/* 81 */     InformationInsurance that = (InformationInsurance)o;
/* 82 */     return (this.id == that.id && Objects.equals(this.minimumSalaryMonth, that.minimumSalaryMonth) && Objects.equals(this.offlinePayment, that.offlinePayment) && Objects.equals(this.apiSocialInsurance, that.apiSocialInsurance) && Objects.equals(this.accountSocialInsurance, that.accountSocialInsurance) && Objects.equals(this.passwordSocialInsurance, that.passwordSocialInsurance));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 87 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.minimumSalaryMonth, this.offlinePayment, this.apiSocialInsurance, this.accountSocialInsurance, this.passwordSocialInsurance });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\InformationInsurance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */