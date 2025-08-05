/*    */ package nencer.app.Modules.Medic.Entity.Insurance;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_insurance_cards")
/*    */ public class MedicInsuranceCards {
/*    */   private int id;
/*    */   private String insuranceCode;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 18 */     return this.id;
/*    */   }
/*    */   private String benefitCode; private String insuranceName; private Integer benefitRate;
/*    */   public void setId(int id) {
/* 22 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "insurance_code")
/*    */   public String getInsuranceCode() {
/* 28 */     return this.insuranceCode;
/*    */   }
/*    */   
/*    */   public void setInsuranceCode(String insuranceCode) {
/* 32 */     this.insuranceCode = insuranceCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "benefit_code")
/*    */   public String getBenefitCode() {
/* 38 */     return this.benefitCode;
/*    */   }
/*    */   
/*    */   public void setBenefitCode(String benefitCode) {
/* 42 */     this.benefitCode = benefitCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "benefit_rate")
/*    */   public Integer getBenefitRate() {
/* 48 */     return this.benefitRate;
/*    */   }
/*    */   
/*    */   public void setBenefitRate(Integer benefitRate) {
/* 52 */     this.benefitRate = benefitRate;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "insurance_name")
/*    */   public String getInsuranceName() {
/* 58 */     return this.insuranceName;
/*    */   }
/*    */   
/*    */   public void setInsuranceName(String insuranceName) {
/* 62 */     this.insuranceName = insuranceName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Insurance\MedicInsuranceCards.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */