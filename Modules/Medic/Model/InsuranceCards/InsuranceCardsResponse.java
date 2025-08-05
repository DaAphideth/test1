/*    */ package nencer.app.Modules.Medic.Model.InsuranceCards;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class InsuranceCardsResponse {
/*    */   private int id;
/*    */   private String insuranceCode;
/*    */   private String benefitCode;
/*    */   
/*  9 */   public void setId(int id) { this.id = id; } private String insuranceName; private Integer benefitRate; private Integer totalRecord; public void setInsuranceCode(String insuranceCode) { this.insuranceCode = insuranceCode; } public void setBenefitCode(String benefitCode) { this.benefitCode = benefitCode; } public void setInsuranceName(String insuranceName) { this.insuranceName = insuranceName; } public void setBenefitRate(Integer benefitRate) { this.benefitRate = benefitRate; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof InsuranceCardsResponse)) return false;  InsuranceCardsResponse other = (InsuranceCardsResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$insuranceCode = getInsuranceCode(), other$insuranceCode = other.getInsuranceCode(); if ((this$insuranceCode == null) ? (other$insuranceCode != null) : !this$insuranceCode.equals(other$insuranceCode)) return false;  Object this$benefitCode = getBenefitCode(), other$benefitCode = other.getBenefitCode(); if ((this$benefitCode == null) ? (other$benefitCode != null) : !this$benefitCode.equals(other$benefitCode)) return false;  Object this$insuranceName = getInsuranceName(), other$insuranceName = other.getInsuranceName(); if ((this$insuranceName == null) ? (other$insuranceName != null) : !this$insuranceName.equals(other$insuranceName)) return false;  Object this$benefitRate = getBenefitRate(), other$benefitRate = other.getBenefitRate(); if ((this$benefitRate == null) ? (other$benefitRate != null) : !this$benefitRate.equals(other$benefitRate)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } protected boolean canEqual(Object other) { return other instanceof InsuranceCardsResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $insuranceCode = getInsuranceCode(); result = result * 59 + (($insuranceCode == null) ? 43 : $insuranceCode.hashCode()); Object $benefitCode = getBenefitCode(); result = result * 59 + (($benefitCode == null) ? 43 : $benefitCode.hashCode()); Object $insuranceName = getInsuranceName(); result = result * 59 + (($insuranceName == null) ? 43 : $insuranceName.hashCode()); Object $benefitRate = getBenefitRate(); result = result * 59 + (($benefitRate == null) ? 43 : $benefitRate.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "InsuranceCardsResponse(id=" + getId() + ", insuranceCode=" + getInsuranceCode() + ", benefitCode=" + getBenefitCode() + ", insuranceName=" + getInsuranceName() + ", benefitRate=" + getBenefitRate() + ", totalRecord=" + getTotalRecord() + ")"; } public InsuranceCardsResponse(int id, String insuranceCode, String benefitCode, String insuranceName, Integer benefitRate, Integer totalRecord) {
/* 10 */     this.id = id; this.insuranceCode = insuranceCode; this.benefitCode = benefitCode; this.insuranceName = insuranceName; this.benefitRate = benefitRate; this.totalRecord = totalRecord;
/*    */   }
/*    */   public InsuranceCardsResponse() {}
/*    */   
/* 14 */   public int getId() { return this.id; }
/* 15 */   public String getInsuranceCode() { return this.insuranceCode; }
/* 16 */   public String getBenefitCode() { return this.benefitCode; }
/* 17 */   public String getInsuranceName() { return this.insuranceName; }
/* 18 */   public Integer getBenefitRate() { return this.benefitRate; } public Integer getTotalRecord() {
/* 19 */     return this.totalRecord;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\InsuranceCards\InsuranceCardsResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */