/*    */ package nencer.app.Modules.Medic.Model.Product;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Set;
/*    */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*    */ 
/*    */ public class MedicRequestBuilder
/*    */ {
/*    */   private Integer storeId;
/*    */   private Integer storehouseId;
/*    */   private Integer ticketId;
/*    */   private Integer parentTicketId;
/*    */   private String orderType;
/*    */   private String note;
/*    */   private String diagnosticArray;
/*    */   
/*    */   public MedicRequestBuilder storeId(Integer storeId) {
/* 18 */     this.storeId = storeId; return this; } private String diagnosticSubArray; private Set<MedicProductOrderDetail> productOrders; private Integer creatorId; private String creatorName; private Integer roomId; private Date orderDate; private String medicProductArray; private Integer treatmentDeatailId; public MedicRequestBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicRequestBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicRequestBuilder parentTicketId(Integer parentTicketId) { this.parentTicketId = parentTicketId; return this; } public MedicRequestBuilder orderType(String orderType) { this.orderType = orderType; return this; } public MedicRequestBuilder note(String note) { this.note = note; return this; } public MedicRequestBuilder diagnosticArray(String diagnosticArray) { this.diagnosticArray = diagnosticArray; return this; } public MedicRequestBuilder diagnosticSubArray(String diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; return this; } public MedicRequestBuilder productOrders(Set<MedicProductOrderDetail> productOrders) { this.productOrders = productOrders; return this; } public MedicRequestBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public MedicRequestBuilder creatorName(String creatorName) { this.creatorName = creatorName; return this; } public MedicRequestBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicRequestBuilder orderDate(Date orderDate) { this.orderDate = orderDate; return this; } public MedicRequestBuilder medicProductArray(String medicProductArray) { this.medicProductArray = medicProductArray; return this; } public MedicRequestBuilder treatmentDeatailId(Integer treatmentDeatailId) { this.treatmentDeatailId = treatmentDeatailId; return this; } public MedicRequest build() { return new MedicRequest(this.storeId, this.storehouseId, this.ticketId, this.parentTicketId, this.orderType, this.note, this.diagnosticArray, this.diagnosticSubArray, this.productOrders, this.creatorId, this.creatorName, this.roomId, this.orderDate, this.medicProductArray, this.treatmentDeatailId); } public String toString() { return "MedicRequest.MedicRequestBuilder(storeId=" + this.storeId + ", storehouseId=" + this.storehouseId + ", ticketId=" + this.ticketId + ", parentTicketId=" + this.parentTicketId + ", orderType=" + this.orderType + ", note=" + this.note + ", diagnosticArray=" + this.diagnosticArray + ", diagnosticSubArray=" + this.diagnosticSubArray + ", productOrders=" + this.productOrders + ", creatorId=" + this.creatorId + ", creatorName=" + this.creatorName + ", roomId=" + this.roomId + ", orderDate=" + this.orderDate + ", medicProductArray=" + this.medicProductArray + ", treatmentDeatailId=" + this.treatmentDeatailId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Product\MedicRequest$MedicRequestBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */