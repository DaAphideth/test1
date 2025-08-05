/*   */ package nencer.app.Modules.Customer.Model;
/*   */ 
/*   */ public class CustomerDetailsShortModelBuilder {
/*   */   private String address;
/*   */   private String address2;
/*   */   
/*   */   public CustomerDetailsShortModelBuilder address(String address) {
/* 8 */     this.address = address; return this; } public CustomerDetailsShortModelBuilder address2(String address2) { this.address2 = address2; return this; } public CustomerDetailsShortModel build() { return new CustomerDetailsShortModel(this.address, this.address2); } public String toString() { return "CustomerDetailsShortModel.CustomerDetailsShortModelBuilder(address=" + this.address + ", address2=" + this.address2 + ")"; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Model\CustomerDetailsShortModel$CustomerDetailsShortModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */