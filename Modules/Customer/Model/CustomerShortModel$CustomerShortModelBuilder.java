/*   */ package nencer.app.Modules.Customer.Model;
/*   */ 
/*   */ public class CustomerShortModelBuilder {
/*   */   private Integer customerId;
/*   */   private String name;
/*   */   private String phone;
/*   */   
/* 8 */   public CustomerShortModelBuilder customerId(Integer customerId) { this.customerId = customerId; return this; } private String idCard; private String yearBorn; private Integer age; private CustomerDetailsShortModel customerDetailsInfo; public CustomerShortModelBuilder name(String name) { this.name = name; return this; } public CustomerShortModelBuilder phone(String phone) { this.phone = phone; return this; } public CustomerShortModelBuilder idCard(String idCard) { this.idCard = idCard; return this; } public CustomerShortModelBuilder yearBorn(String yearBorn) { this.yearBorn = yearBorn; return this; } public CustomerShortModelBuilder age(Integer age) { this.age = age; return this; } public CustomerShortModelBuilder customerDetailsInfo(CustomerDetailsShortModel customerDetailsInfo) { this.customerDetailsInfo = customerDetailsInfo; return this; } public CustomerShortModel build() { return new CustomerShortModel(this.customerId, this.name, this.phone, this.idCard, this.yearBorn, this.age, this.customerDetailsInfo); } public String toString() { return "CustomerShortModel.CustomerShortModelBuilder(customerId=" + this.customerId + ", name=" + this.name + ", phone=" + this.phone + ", idCard=" + this.idCard + ", yearBorn=" + this.yearBorn + ", age=" + this.age + ", customerDetailsInfo=" + this.customerDetailsInfo + ")"; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Model\CustomerShortModel$CustomerShortModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */