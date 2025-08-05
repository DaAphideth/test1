/*    */ package nencer.app.Modules.Report.Model.cddv;
/*    */ 
/*    */ 
/*    */ public class GetPhieuRaVienModel {
/*    */   private List<CustomerModel> customerModel;
/*    */   
/*  7 */   public void setCustomerModel(List<CustomerModel> customerModel) { this.customerModel = customerModel; } private List<MdmHeaderModel> mdmHeaderModel; private List<ExaminationResultsModel> examinationResults; public void setMdmHeaderModel(List<MdmHeaderModel> mdmHeaderModel) { this.mdmHeaderModel = mdmHeaderModel; } public void setExaminationResults(List<ExaminationResultsModel> examinationResults) { this.examinationResults = examinationResults; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GetPhieuRaVienModel)) return false;  GetPhieuRaVienModel other = (GetPhieuRaVienModel)o; if (!other.canEqual(this)) return false;  Object<CustomerModel> this$customerModel = (Object<CustomerModel>)getCustomerModel(), other$customerModel = (Object<CustomerModel>)other.getCustomerModel(); if ((this$customerModel == null) ? (other$customerModel != null) : !this$customerModel.equals(other$customerModel)) return false;  Object<MdmHeaderModel> this$mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(), other$mdmHeaderModel = (Object<MdmHeaderModel>)other.getMdmHeaderModel(); if ((this$mdmHeaderModel == null) ? (other$mdmHeaderModel != null) : !this$mdmHeaderModel.equals(other$mdmHeaderModel)) return false;  Object<ExaminationResultsModel> this$examinationResults = (Object<ExaminationResultsModel>)getExaminationResults(), other$examinationResults = (Object<ExaminationResultsModel>)other.getExaminationResults(); return !((this$examinationResults == null) ? (other$examinationResults != null) : !this$examinationResults.equals(other$examinationResults)); } protected boolean canEqual(Object other) { return other instanceof GetPhieuRaVienModel; } public int hashCode() { int PRIME = 59; result = 1; Object<CustomerModel> $customerModel = (Object<CustomerModel>)getCustomerModel(); result = result * 59 + (($customerModel == null) ? 43 : $customerModel.hashCode()); Object<MdmHeaderModel> $mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(); result = result * 59 + (($mdmHeaderModel == null) ? 43 : $mdmHeaderModel.hashCode()); Object<ExaminationResultsModel> $examinationResults = (Object<ExaminationResultsModel>)getExaminationResults(); return result * 59 + (($examinationResults == null) ? 43 : $examinationResults.hashCode()); } public String toString() { return "GetPhieuRaVienModel(customerModel=" + getCustomerModel() + ", mdmHeaderModel=" + getMdmHeaderModel() + ", examinationResults=" + getExaminationResults() + ")"; }
/*    */   
/*  9 */   public List<CustomerModel> getCustomerModel() { return this.customerModel; }
/* 10 */   public List<MdmHeaderModel> getMdmHeaderModel() { return this.mdmHeaderModel; } public List<ExaminationResultsModel> getExaminationResults() {
/* 11 */     return this.examinationResults;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\cddv\GetPhieuRaVienModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */