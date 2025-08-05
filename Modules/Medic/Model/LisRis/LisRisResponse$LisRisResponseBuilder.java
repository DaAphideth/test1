/*    */ package nencer.app.Modules.Medic.Model.LisRis;
/*    */ 
/*    */ import nencer.app.Modules.Customer.Model.CustomerShortModel;
/*    */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*    */ 
/*    */ public class LisRisResponseBuilder {
/*    */   private Integer checkinId;
/*    */   private Integer mdId;
/*    */   private Integer ticketId;
/*    */   private Integer patientId;
/*    */   private Integer priority;
/*    */   private String name;
/*    */   private String status;
/*    */   
/*    */   public LisRisResponseBuilder checkinId(Integer checkinId) {
/* 16 */     this.checkinId = checkinId; return this; } private String province; private String district; private String ward; private String customerType; private String createdAt; private String barCode; private CustomerShortModel customerInfo; private MedicTicket medicTicket; public LisRisResponseBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public LisRisResponseBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public LisRisResponseBuilder patientId(Integer patientId) { this.patientId = patientId; return this; } public LisRisResponseBuilder priority(Integer priority) { this.priority = priority; return this; } public LisRisResponseBuilder name(String name) { this.name = name; return this; } public LisRisResponseBuilder status(String status) { this.status = status; return this; } public LisRisResponseBuilder province(String province) { this.province = province; return this; } public LisRisResponseBuilder district(String district) { this.district = district; return this; } public LisRisResponseBuilder ward(String ward) { this.ward = ward; return this; } public LisRisResponseBuilder customerType(String customerType) { this.customerType = customerType; return this; } public LisRisResponseBuilder createdAt(String createdAt) { this.createdAt = createdAt; return this; } public LisRisResponseBuilder barCode(String barCode) { this.barCode = barCode; return this; } public LisRisResponseBuilder customerInfo(CustomerShortModel customerInfo) { this.customerInfo = customerInfo; return this; } public LisRisResponseBuilder medicTicket(MedicTicket medicTicket) { this.medicTicket = medicTicket; return this; } public LisRisResponse build() { return new LisRisResponse(this.checkinId, this.mdId, this.ticketId, this.patientId, this.priority, this.name, this.status, this.province, this.district, this.ward, this.customerType, this.createdAt, this.barCode, this.customerInfo, this.medicTicket); } public String toString() { return "LisRisResponse.LisRisResponseBuilder(checkinId=" + this.checkinId + ", mdId=" + this.mdId + ", ticketId=" + this.ticketId + ", patientId=" + this.patientId + ", priority=" + this.priority + ", name=" + this.name + ", status=" + this.status + ", province=" + this.province + ", district=" + this.district + ", ward=" + this.ward + ", customerType=" + this.customerType + ", createdAt=" + this.createdAt + ", barCode=" + this.barCode + ", customerInfo=" + this.customerInfo + ", medicTicket=" + this.medicTicket + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\LisRis\LisRisResponse$LisRisResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */