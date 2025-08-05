/*    */ package nencer.app.Modules.Report.Model.cddv;
/*    */ 
/*    */ public class GetPhieuTuVongModel {
/*    */   private List<CustomerModel> customerModel;
/*    */   private List<MdmHeaderModel> mdmHeaderModel;
/*    */   
/*  7 */   public void setCustomerModel(List<CustomerModel> customerModel) { this.customerModel = customerModel; } public void setMdmHeaderModel(List<MdmHeaderModel> mdmHeaderModel) { this.mdmHeaderModel = mdmHeaderModel; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GetPhieuTuVongModel)) return false;  GetPhieuTuVongModel other = (GetPhieuTuVongModel)o; if (!other.canEqual(this)) return false;  Object<CustomerModel> this$customerModel = (Object<CustomerModel>)getCustomerModel(), other$customerModel = (Object<CustomerModel>)other.getCustomerModel(); if ((this$customerModel == null) ? (other$customerModel != null) : !this$customerModel.equals(other$customerModel)) return false;  Object<MdmHeaderModel> this$mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(), other$mdmHeaderModel = (Object<MdmHeaderModel>)other.getMdmHeaderModel(); return !((this$mdmHeaderModel == null) ? (other$mdmHeaderModel != null) : !this$mdmHeaderModel.equals(other$mdmHeaderModel)); } protected boolean canEqual(Object other) { return other instanceof GetPhieuTuVongModel; } public int hashCode() { int PRIME = 59; result = 1; Object<CustomerModel> $customerModel = (Object<CustomerModel>)getCustomerModel(); result = result * 59 + (($customerModel == null) ? 43 : $customerModel.hashCode()); Object<MdmHeaderModel> $mdmHeaderModel = (Object<MdmHeaderModel>)getMdmHeaderModel(); return result * 59 + (($mdmHeaderModel == null) ? 43 : $mdmHeaderModel.hashCode()); } public String toString() { return "GetPhieuTuVongModel(customerModel=" + getCustomerModel() + ", mdmHeaderModel=" + getMdmHeaderModel() + ")"; }
/*    */   
/*  9 */   public List<CustomerModel> getCustomerModel() { return this.customerModel; } public List<MdmHeaderModel> getMdmHeaderModel() {
/* 10 */     return this.mdmHeaderModel;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\cddv\GetPhieuTuVongModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */