/*    */ package nencer.app.Modules.Customer.Model;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class CustomerDetailObjectModel { private String doType;
/*    */   private String doCode;
/*    */   
/*  6 */   public void setDoType(String doType) { this.doType = doType; } private String doName; private Integer doBenefit; private Integer totalRecord; public void setDoCode(String doCode) { this.doCode = doCode; } public void setDoName(String doName) { this.doName = doName; } public void setDoBenefit(Integer doBenefit) { this.doBenefit = doBenefit; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CustomerDetailObjectModel)) return false;  CustomerDetailObjectModel other = (CustomerDetailObjectModel)o; if (!other.canEqual(this)) return false;  Object this$doType = getDoType(), other$doType = other.getDoType(); if ((this$doType == null) ? (other$doType != null) : !this$doType.equals(other$doType)) return false;  Object this$doCode = getDoCode(), other$doCode = other.getDoCode(); if ((this$doCode == null) ? (other$doCode != null) : !this$doCode.equals(other$doCode)) return false;  Object this$doName = getDoName(), other$doName = other.getDoName(); if ((this$doName == null) ? (other$doName != null) : !this$doName.equals(other$doName)) return false;  Object this$doBenefit = getDoBenefit(), other$doBenefit = other.getDoBenefit(); if ((this$doBenefit == null) ? (other$doBenefit != null) : !this$doBenefit.equals(other$doBenefit)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } protected boolean canEqual(Object other) { return other instanceof CustomerDetailObjectModel; } public int hashCode() { int PRIME = 59; result = 1; Object $doType = getDoType(); result = result * 59 + (($doType == null) ? 43 : $doType.hashCode()); Object $doCode = getDoCode(); result = result * 59 + (($doCode == null) ? 43 : $doCode.hashCode()); Object $doName = getDoName(); result = result * 59 + (($doName == null) ? 43 : $doName.hashCode()); Object $doBenefit = getDoBenefit(); result = result * 59 + (($doBenefit == null) ? 43 : $doBenefit.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "CustomerDetailObjectModel(doType=" + getDoType() + ", doCode=" + getDoCode() + ", doName=" + getDoName() + ", doBenefit=" + getDoBenefit() + ", totalRecord=" + getTotalRecord() + ")"; }
/*    */ 
/*    */   
/*  9 */   public String getDoType() { return this.doType; }
/* 10 */   public String getDoCode() { return this.doCode; }
/* 11 */   public String getDoName() { return this.doName; }
/* 12 */   public Integer getDoBenefit() { return this.doBenefit; } public Integer getTotalRecord() {
/* 13 */     return this.totalRecord;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Model\CustomerDetailObjectModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */