/*    */ package nencer.app.Modules.Medic.Model.OrderService;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*    */ 
/*    */ public class InvoiceRequestBuilder {
/*    */   private Double fees;
/*    */   private Double discount;
/*    */   private Double payAmount;
/*    */   private Double netAmount;
/*    */   private String orderType;
/*    */   private String paygate;
/*    */   private String description;
/*    */   private String adminNote;
/*    */   private List<OrderServiceRequest> orderServiceRequests;
/*    */   
/* 18 */   public InvoiceRequestBuilder fees(Double fees) { this.fees = fees; return this; } private List<MedicProductOrderModel> orderProductRequests; private Integer creatorId; private Integer roomId; private String creatorName; private Date orderDate; private String checkinStatus; private String diagnosticArray; private String diagnosticSubArray; private String chkRadio; private Integer treatmentDeatailId; public InvoiceRequestBuilder discount(Double discount) { this.discount = discount; return this; } public InvoiceRequestBuilder payAmount(Double payAmount) { this.payAmount = payAmount; return this; } public InvoiceRequestBuilder netAmount(Double netAmount) { this.netAmount = netAmount; return this; } public InvoiceRequestBuilder orderType(String orderType) { this.orderType = orderType; return this; } public InvoiceRequestBuilder paygate(String paygate) { this.paygate = paygate; return this; } public InvoiceRequestBuilder description(String description) { this.description = description; return this; } public InvoiceRequestBuilder adminNote(String adminNote) { this.adminNote = adminNote; return this; } public InvoiceRequestBuilder orderServiceRequests(List<OrderServiceRequest> orderServiceRequests) { this.orderServiceRequests = orderServiceRequests; return this; } public InvoiceRequestBuilder orderProductRequests(List<MedicProductOrderModel> orderProductRequests) { this.orderProductRequests = orderProductRequests; return this; } public InvoiceRequestBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public InvoiceRequestBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public InvoiceRequestBuilder creatorName(String creatorName) { this.creatorName = creatorName; return this; } public InvoiceRequestBuilder orderDate(Date orderDate) { this.orderDate = orderDate; return this; } public InvoiceRequestBuilder checkinStatus(String checkinStatus) { this.checkinStatus = checkinStatus; return this; } public InvoiceRequestBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public InvoiceRequestBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public InvoiceRequestBuilder chkRadio(String chkRadio) { this.chkRadio = chkRadio; return this; } public InvoiceRequestBuilder treatmentDeatailId(Integer treatmentDeatailId) { this.treatmentDeatailId = treatmentDeatailId; return this; } public InvoiceRequest build() { return new InvoiceRequest(this.fees, this.discount, this.payAmount, this.netAmount, this.orderType, this.paygate, this.description, this.adminNote, this.orderServiceRequests, this.orderProductRequests, this.creatorId, this.roomId, this.creatorName, this.orderDate, this.checkinStatus, this.diagnosticArray, this.diagnosticSubArray, this.chkRadio, this.treatmentDeatailId); } public String toString() { return "InvoiceRequest.InvoiceRequestBuilder(fees=" + this.fees + ", discount=" + this.discount + ", payAmount=" + this.payAmount + ", netAmount=" + this.netAmount + ", orderType=" + this.orderType + ", paygate=" + this.paygate + ", description=" + this.description + ", adminNote=" + this.adminNote + ", orderServiceRequests=" + this.orderServiceRequests + ", orderProductRequests=" + this.orderProductRequests + ", creatorId=" + this.creatorId + ", roomId=" + this.roomId + ", creatorName=" + this.creatorName + ", orderDate=" + this.orderDate + ", checkinStatus=" + this.checkinStatus + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", chkRadio=" + this.chkRadio + ", treatmentDeatailId=" + this.treatmentDeatailId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\OrderService\InvoiceRequest$InvoiceRequestBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */