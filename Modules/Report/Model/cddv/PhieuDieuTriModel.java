/*    */ package nencer.app.Modules.Report.Model.cddv;
/*    */ 
/*    */ import nencer.app.Modules.Report.Model.TreatmentDetailModel;
/*    */ 
/*    */ public class PhieuDieuTriModel {
/*    */   private List<CustomerModel> customerModel;
/*    */   
/*  8 */   public void setCustomerModel(List<CustomerModel> customerModel) { this.customerModel = customerModel; } private List<MdmHeaderModel> mdmHeaderModel; private List<TreatmentDetailModel> treatmentDetailModels; public void setMdmHeaderModel(List<MdmHeaderModel> mdmHeaderModel) { this.mdmHeaderModel = mdmHeaderModel; } public void setTreatmentDetailModels(List<TreatmentDetailModel> treatmentDetailModels) { this.treatmentDetailModels = treatmentDetailModels; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PhieuDieuTriModel)) return false;  PhieuDieuTriModel other = (PhieuDieuTriModel)o; if (!other.canEqual(this)) return false;  Object<CustomerModel> this$customerModel = (Object<CustomerModel>)getCustomerModel(), other$customerModel = (Object<CustomerModel>)other.getCustomerModel(); if ((this$customerModel == null) ? (other$customerModel != null) : !this$customerModel.equals(other$customerModel)) return false;  Object<MdmHeaderModel> this$mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(), other$mdmHeaderModel = (Object<MdmHeaderModel>)other.getMdmHeaderModel(); if ((this$mdmHeaderModel == null) ? (other$mdmHeaderModel != null) : !this$mdmHeaderModel.equals(other$mdmHeaderModel)) return false;  Object<TreatmentDetailModel> this$treatmentDetailModels = (Object<TreatmentDetailModel>)getTreatmentDetailModels(), other$treatmentDetailModels = (Object<TreatmentDetailModel>)other.getTreatmentDetailModels(); return !((this$treatmentDetailModels == null) ? (other$treatmentDetailModels != null) : !this$treatmentDetailModels.equals(other$treatmentDetailModels)); } protected boolean canEqual(Object other) { return other instanceof PhieuDieuTriModel; } public int hashCode() { int PRIME = 59; result = 1; Object<CustomerModel> $customerModel = (Object<CustomerModel>)getCustomerModel(); result = result * 59 + (($customerModel == null) ? 43 : $customerModel.hashCode()); Object<MdmHeaderModel> $mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(); result = result * 59 + (($mdmHeaderModel == null) ? 43 : $mdmHeaderModel.hashCode()); Object<TreatmentDetailModel> $treatmentDetailModels = (Object<TreatmentDetailModel>)getTreatmentDetailModels(); return result * 59 + (($treatmentDetailModels == null) ? 43 : $treatmentDetailModels.hashCode()); } public String toString() { return "PhieuDieuTriModel(customerModel=" + getCustomerModel() + ", mdmHeaderModel=" + getMdmHeaderModel() + ", treatmentDetailModels=" + getTreatmentDetailModels() + ")"; }
/*    */   
/* 10 */   public List<CustomerModel> getCustomerModel() { return this.customerModel; }
/* 11 */   public List<MdmHeaderModel> getMdmHeaderModel() { return this.mdmHeaderModel; } public List<TreatmentDetailModel> getTreatmentDetailModels() {
/* 12 */     return this.treatmentDetailModels;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\cddv\PhieuDieuTriModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */