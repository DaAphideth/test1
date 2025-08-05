/*    */ package nencer.app.Modules.Medic.Model.Response.MedicExamination;
/*    */ 
/*    */ public class PaymentDetailModelBuilder {
/*    */   private Integer serviceGroupId;
/*    */   private String serviceGroupName;
/*    */   private String serviceCode;
/*    */   private String serviceName;
/*    */   private String doctorName;
/*    */   
/* 10 */   public PaymentDetailModelBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } private String roomSampleName; private Integer qty; private Double price; private Double payAmount; private Double insurancePay; private String serviceObject; public PaymentDetailModelBuilder serviceGroupName(String serviceGroupName) { this.serviceGroupName = serviceGroupName; return this; } public PaymentDetailModelBuilder serviceCode(String serviceCode) { this.serviceCode = serviceCode; return this; } public PaymentDetailModelBuilder serviceName(String serviceName) { this.serviceName = serviceName; return this; } public PaymentDetailModelBuilder doctorName(String doctorName) { this.doctorName = doctorName; return this; } public PaymentDetailModelBuilder roomSampleName(String roomSampleName) { this.roomSampleName = roomSampleName; return this; } public PaymentDetailModelBuilder qty(Integer qty) { this.qty = qty; return this; } public PaymentDetailModelBuilder price(Double price) { this.price = price; return this; } public PaymentDetailModelBuilder payAmount(Double payAmount) { this.payAmount = payAmount; return this; } public PaymentDetailModelBuilder insurancePay(Double insurancePay) { this.insurancePay = insurancePay; return this; } public PaymentDetailModelBuilder serviceObject(String serviceObject) { this.serviceObject = serviceObject; return this; } public PaymentDetailModel build() { return new PaymentDetailModel(this.serviceGroupId, this.serviceGroupName, this.serviceCode, this.serviceName, this.doctorName, this.roomSampleName, this.qty, this.price, this.payAmount, this.insurancePay, this.serviceObject); } public String toString() { return "PaymentDetailModel.PaymentDetailModelBuilder(serviceGroupId=" + this.serviceGroupId + ", serviceGroupName=" + this.serviceGroupName + ", serviceCode=" + this.serviceCode + ", serviceName=" + this.serviceName + ", doctorName=" + this.doctorName + ", roomSampleName=" + this.roomSampleName + ", qty=" + this.qty + ", price=" + this.price + ", payAmount=" + this.payAmount + ", insurancePay=" + this.insurancePay + ", serviceObject=" + this.serviceObject + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Response\MedicExamination\PaymentDetailModel$PaymentDetailModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */