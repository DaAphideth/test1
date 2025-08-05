/*    */ package nencer.app.Modules.Storehouse.Model;
/*    */ public class ProductTreatmentDetailModel { private String productName;
/*    */   private String unit;
/*    */   
/*  5 */   public void setProductName(String productName) { this.productName = productName; } private String userGuide; private Integer qty; private String title; public void setUnit(String unit) { this.unit = unit; } public void setUserGuide(String userGuide) { this.userGuide = userGuide; } public void setQty(Integer qty) { this.qty = qty; } public void setTitle(String title) { this.title = title; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ProductTreatmentDetailModel)) return false;  ProductTreatmentDetailModel other = (ProductTreatmentDetailModel)o; if (!other.canEqual(this)) return false;  Object this$productName = getProductName(), other$productName = other.getProductName(); if ((this$productName == null) ? (other$productName != null) : !this$productName.equals(other$productName)) return false;  Object this$unit = getUnit(), other$unit = other.getUnit(); if ((this$unit == null) ? (other$unit != null) : !this$unit.equals(other$unit)) return false;  Object this$userGuide = getUserGuide(), other$userGuide = other.getUserGuide(); if ((this$userGuide == null) ? (other$userGuide != null) : !this$userGuide.equals(other$userGuide)) return false;  Object this$qty = getQty(), other$qty = other.getQty(); if ((this$qty == null) ? (other$qty != null) : !this$qty.equals(other$qty)) return false;  Object this$title = getTitle(), other$title = other.getTitle(); return !((this$title == null) ? (other$title != null) : !this$title.equals(other$title)); } protected boolean canEqual(Object other) { return other instanceof ProductTreatmentDetailModel; } public int hashCode() { int PRIME = 59; result = 1; Object $productName = getProductName(); result = result * 59 + (($productName == null) ? 43 : $productName.hashCode()); Object $unit = getUnit(); result = result * 59 + (($unit == null) ? 43 : $unit.hashCode()); Object $userGuide = getUserGuide(); result = result * 59 + (($userGuide == null) ? 43 : $userGuide.hashCode()); Object $qty = getQty(); result = result * 59 + (($qty == null) ? 43 : $qty.hashCode()); Object $title = getTitle(); return result * 59 + (($title == null) ? 43 : $title.hashCode()); } public String toString() { return "ProductTreatmentDetailModel(productName=" + getProductName() + ", unit=" + getUnit() + ", userGuide=" + getUserGuide() + ", qty=" + getQty() + ", title=" + getTitle() + ")"; }
/*    */   
/*  7 */   public String getProductName() { return this.productName; }
/*  8 */   public String getUnit() { return this.unit; }
/*  9 */   public String getUserGuide() { return this.userGuide; }
/* 10 */   public Integer getQty() { return this.qty; } public String getTitle() {
/* 11 */     return this.title;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Model\ProductTreatmentDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */