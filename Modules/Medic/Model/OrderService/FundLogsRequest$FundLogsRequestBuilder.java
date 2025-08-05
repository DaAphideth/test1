/*    */ package nencer.app.Modules.Medic.Model.OrderService;
/*    */ 
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*    */ 
/*    */ public class FundLogsRequestBuilder
/*    */ {
/*    */   private Double fees;
/*    */   private Double discount;
/*    */   private String discountReason;
/*    */   private Double payAmount;
/*    */   private Double netAmount;
/*    */   private String orderType;
/*    */   
/*    */   public FundLogsRequestBuilder fees(Double fees) {
/* 16 */     this.fees = fees; return this; } private String paygate; private String description; private String note; private List<OrderServiceRequest> orderServiceRequests; private List<MedicProductOrder> orderProductRequests; private Integer creatorId; public FundLogsRequestBuilder discount(Double discount) { this.discount = discount; return this; } public FundLogsRequestBuilder discountReason(String discountReason) { this.discountReason = discountReason; return this; } public FundLogsRequestBuilder payAmount(Double payAmount) { this.payAmount = payAmount; return this; } public FundLogsRequestBuilder netAmount(Double netAmount) { this.netAmount = netAmount; return this; } public FundLogsRequestBuilder orderType(String orderType) { this.orderType = orderType; return this; } public FundLogsRequestBuilder paygate(String paygate) { this.paygate = paygate; return this; } public FundLogsRequestBuilder description(String description) { this.description = description; return this; } public FundLogsRequestBuilder note(String note) { this.note = note; return this; } public FundLogsRequestBuilder orderServiceRequests(List<OrderServiceRequest> orderServiceRequests) { this.orderServiceRequests = orderServiceRequests; return this; } public FundLogsRequestBuilder orderProductRequests(List<MedicProductOrder> orderProductRequests) { this.orderProductRequests = orderProductRequests; return this; } public FundLogsRequestBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public FundLogsRequest build() { return new FundLogsRequest(this.fees, this.discount, this.discountReason, this.payAmount, this.netAmount, this.orderType, this.paygate, this.description, this.note, this.orderServiceRequests, this.orderProductRequests, this.creatorId); } public String toString() { return "FundLogsRequest.FundLogsRequestBuilder(fees=" + this.fees + ", discount=" + this.discount + ", discountReason=" + this.discountReason + ", payAmount=" + this.payAmount + ", netAmount=" + this.netAmount + ", orderType=" + this.orderType + ", paygate=" + this.paygate + ", description=" + this.description + ", note=" + this.note + ", orderServiceRequests=" + this.orderServiceRequests + ", orderProductRequests=" + this.orderProductRequests + ", creatorId=" + this.creatorId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\OrderService\FundLogsRequest$FundLogsRequestBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */