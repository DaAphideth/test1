/*    */ package nencer.app.Modules.Medic.Model.InsuranceCards;
/*    */ 
/*    */ public class InsuranceCardsRequestBuilder {
/*    */   private int id;
/*    */   private String insuranceCode;
/*    */   private String benefitCode;
/*    */   private String insuranceName;
/*    */   private Integer benefitRate;
/*    */   
/*    */   public InsuranceCardsRequestBuilder id(int id) {
/* 11 */     this.id = id; return this; } public InsuranceCardsRequestBuilder insuranceCode(String insuranceCode) { this.insuranceCode = insuranceCode; return this; } public InsuranceCardsRequestBuilder benefitCode(String benefitCode) { this.benefitCode = benefitCode; return this; } public InsuranceCardsRequestBuilder insuranceName(String insuranceName) { this.insuranceName = insuranceName; return this; } public InsuranceCardsRequestBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public InsuranceCardsRequest build() { return new InsuranceCardsRequest(this.id, this.insuranceCode, this.benefitCode, this.insuranceName, this.benefitRate); } public String toString() { return "InsuranceCardsRequest.InsuranceCardsRequestBuilder(id=" + this.id + ", insuranceCode=" + this.insuranceCode + ", benefitCode=" + this.benefitCode + ", insuranceName=" + this.insuranceName + ", benefitRate=" + this.benefitRate + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\InsuranceCards\InsuranceCardsRequest$InsuranceCardsRequestBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */