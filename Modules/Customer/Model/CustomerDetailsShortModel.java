/*    */ package nencer.app.Modules.Customer.Model;
/*    */ 
/*    */ public class CustomerDetailsShortModel {
/*    */   private String address;
/*    */   private String address2;
/*    */   
/*    */   public static CustomerDetailsShortModelBuilder builder() {
/*  8 */     return new CustomerDetailsShortModelBuilder(); } public static class CustomerDetailsShortModelBuilder { private String address; public CustomerDetailsShortModelBuilder address(String address) { this.address = address; return this; } private String address2; public CustomerDetailsShortModelBuilder address2(String address2) { this.address2 = address2; return this; } public CustomerDetailsShortModel build() { return new CustomerDetailsShortModel(this.address, this.address2); } public String toString() { return "CustomerDetailsShortModel.CustomerDetailsShortModelBuilder(address=" + this.address + ", address2=" + this.address2 + ")"; } }
/*  9 */   public void setAddress(String address) { this.address = address; } public void setAddress2(String address2) { this.address2 = address2; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CustomerDetailsShortModel)) return false;  CustomerDetailsShortModel other = (CustomerDetailsShortModel)o; if (!other.canEqual(this)) return false;  Object this$address = getAddress(), other$address = other.getAddress(); if ((this$address == null) ? (other$address != null) : !this$address.equals(other$address)) return false;  Object this$address2 = getAddress2(), other$address2 = other.getAddress2(); return !((this$address2 == null) ? (other$address2 != null) : !this$address2.equals(other$address2)); } protected boolean canEqual(Object other) { return other instanceof CustomerDetailsShortModel; } public int hashCode() { int PRIME = 59; result = 1; Object $address = getAddress(); result = result * 59 + (($address == null) ? 43 : $address.hashCode()); Object $address2 = getAddress2(); return result * 59 + (($address2 == null) ? 43 : $address2.hashCode()); } public String toString() { return "CustomerDetailsShortModel(address=" + getAddress() + ", address2=" + getAddress2() + ")"; } public CustomerDetailsShortModel(String address, String address2) {
/* 10 */     this.address = address; this.address2 = address2;
/*    */   }
/*    */   public CustomerDetailsShortModel() {}
/* 13 */   public String getAddress() { return this.address; } public String getAddress2() {
/* 14 */     return this.address2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Model\CustomerDetailsShortModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */