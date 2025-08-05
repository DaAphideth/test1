/*    */ package nencer.app.Modules.Medic.Model.Checkin;
/*    */ 
/*    */ public class CheckinPaymentShortResponseBuilder {
/*    */   private Integer checkinId;
/*    */   private Integer mdId;
/*    */   private Integer ticketId;
/*    */   private Integer patientId;
/*    */   private Integer priority;
/*    */   private String name;
/*    */   private String status;
/*    */   
/* 12 */   public CheckinPaymentShortResponseBuilder checkinId(Integer checkinId) { this.checkinId = checkinId; return this; } private String province; private String district; private String ward; private String customerType; private String createdAt; private String barCode; private CustomerShortModel customerInfo; public CheckinPaymentShortResponseBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public CheckinPaymentShortResponseBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public CheckinPaymentShortResponseBuilder patientId(Integer patientId) { this.patientId = patientId; return this; } public CheckinPaymentShortResponseBuilder priority(Integer priority) { this.priority = priority; return this; } public CheckinPaymentShortResponseBuilder name(String name) { this.name = name; return this; } public CheckinPaymentShortResponseBuilder status(String status) { this.status = status; return this; } public CheckinPaymentShortResponseBuilder province(String province) { this.province = province; return this; } public CheckinPaymentShortResponseBuilder district(String district) { this.district = district; return this; } public CheckinPaymentShortResponseBuilder ward(String ward) { this.ward = ward; return this; } public CheckinPaymentShortResponseBuilder customerType(String customerType) { this.customerType = customerType; return this; } public CheckinPaymentShortResponseBuilder createdAt(String createdAt) { this.createdAt = createdAt; return this; } public CheckinPaymentShortResponseBuilder barCode(String barCode) { this.barCode = barCode; return this; } public CheckinPaymentShortResponseBuilder customerInfo(CustomerShortModel customerInfo) { this.customerInfo = customerInfo; return this; } public CheckinPaymentShortResponse build() { return new CheckinPaymentShortResponse(this.checkinId, this.mdId, this.ticketId, this.patientId, this.priority, this.name, this.status, this.province, this.district, this.ward, this.customerType, this.createdAt, this.barCode, this.customerInfo); } public String toString() { return "CheckinPaymentShortResponse.CheckinPaymentShortResponseBuilder(checkinId=" + this.checkinId + ", mdId=" + this.mdId + ", ticketId=" + this.ticketId + ", patientId=" + this.patientId + ", priority=" + this.priority + ", name=" + this.name + ", status=" + this.status + ", province=" + this.province + ", district=" + this.district + ", ward=" + this.ward + ", customerType=" + this.customerType + ", createdAt=" + this.createdAt + ", barCode=" + this.barCode + ", customerInfo=" + this.customerInfo + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Checkin\CheckinPaymentShortResponse$CheckinPaymentShortResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */