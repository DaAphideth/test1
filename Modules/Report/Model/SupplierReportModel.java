/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ 
/*    */ public class SupplierReportModel {
/*    */   private String productSrcCode;
/*    */   private String productSrcName;
/*    */   private List<SupplierReportChildModel> supplierReportChildModels;
/*    */   
/*  9 */   public void setProductSrcCode(String productSrcCode) { this.productSrcCode = productSrcCode; } public void setProductSrcName(String productSrcName) { this.productSrcName = productSrcName; } public void setSupplierReportChildModels(List<SupplierReportChildModel> supplierReportChildModels) { this.supplierReportChildModels = supplierReportChildModels; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SupplierReportModel)) return false;  SupplierReportModel other = (SupplierReportModel)o; if (!other.canEqual(this)) return false;  Object this$productSrcCode = getProductSrcCode(), other$productSrcCode = other.getProductSrcCode(); if ((this$productSrcCode == null) ? (other$productSrcCode != null) : !this$productSrcCode.equals(other$productSrcCode)) return false;  Object this$productSrcName = getProductSrcName(), other$productSrcName = other.getProductSrcName(); if ((this$productSrcName == null) ? (other$productSrcName != null) : !this$productSrcName.equals(other$productSrcName)) return false;  Object<SupplierReportChildModel> this$supplierReportChildModels = (Object<SupplierReportChildModel>)getSupplierReportChildModels(), other$supplierReportChildModels = (Object<SupplierReportChildModel>)other.getSupplierReportChildModels(); return !((this$supplierReportChildModels == null) ? (other$supplierReportChildModels != null) : !this$supplierReportChildModels.equals(other$supplierReportChildModels)); } protected boolean canEqual(Object other) { return other instanceof SupplierReportModel; } public int hashCode() { int PRIME = 59; result = 1; Object $productSrcCode = getProductSrcCode(); result = result * 59 + (($productSrcCode == null) ? 43 : $productSrcCode.hashCode()); Object $productSrcName = getProductSrcName(); result = result * 59 + (($productSrcName == null) ? 43 : $productSrcName.hashCode()); Object<SupplierReportChildModel> $supplierReportChildModels = (Object<SupplierReportChildModel>)getSupplierReportChildModels(); return result * 59 + (($supplierReportChildModels == null) ? 43 : $supplierReportChildModels.hashCode()); } public String toString() { return "SupplierReportModel(productSrcCode=" + getProductSrcCode() + ", productSrcName=" + getProductSrcName() + ", supplierReportChildModels=" + getSupplierReportChildModels() + ")"; }
/*    */ 
/*    */   
/* 12 */   public String getProductSrcCode() { return this.productSrcCode; }
/* 13 */   public String getProductSrcName() { return this.productSrcName; } public List<SupplierReportChildModel> getSupplierReportChildModels() {
/* 14 */     return this.supplierReportChildModels;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\SupplierReportModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */