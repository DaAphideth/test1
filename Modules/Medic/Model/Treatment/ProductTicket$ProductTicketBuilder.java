/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ 
/*    */ public class ProductTicketBuilder
/*    */ {
/*    */   private String storehouseId;
/*    */   private String orderStatus;
/*    */   private String orderStatusName;
/*    */   private String ticketId;
/*    */   private String orderId;
/*    */   private String orderType;
/*    */   private String orderTypeName;
/*    */   private String customerId;
/*    */   private String customernName;
/*    */   
/*    */   public ProductTicketBuilder storehouseId(String storehouseId) {
/* 17 */     this.storehouseId = storehouseId; return this; } private String gender; private String age; private String createdAt; private String orderDate; private String departmentId; private String departmentName; private String ticketStatus; private Integer totalRecord; private String insuranceNumber; private Integer benefitRate; public ProductTicketBuilder orderStatus(String orderStatus) { this.orderStatus = orderStatus; return this; } public ProductTicketBuilder orderStatusName(String orderStatusName) { this.orderStatusName = orderStatusName; return this; } public ProductTicketBuilder ticketId(String ticketId) { this.ticketId = ticketId; return this; } public ProductTicketBuilder orderId(String orderId) { this.orderId = orderId; return this; } public ProductTicketBuilder orderType(String orderType) { this.orderType = orderType; return this; } public ProductTicketBuilder orderTypeName(String orderTypeName) { this.orderTypeName = orderTypeName; return this; } public ProductTicketBuilder customerId(String customerId) { this.customerId = customerId; return this; } public ProductTicketBuilder customernName(String customernName) { this.customernName = customernName; return this; } public ProductTicketBuilder gender(String gender) { this.gender = gender; return this; } public ProductTicketBuilder age(String age) { this.age = age; return this; } public ProductTicketBuilder createdAt(String createdAt) { this.createdAt = createdAt; return this; } public ProductTicketBuilder orderDate(String orderDate) { this.orderDate = orderDate; return this; } public ProductTicketBuilder departmentId(String departmentId) { this.departmentId = departmentId; return this; } public ProductTicketBuilder departmentName(String departmentName) { this.departmentName = departmentName; return this; } public ProductTicketBuilder ticketStatus(String ticketStatus) { this.ticketStatus = ticketStatus; return this; } public ProductTicketBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public ProductTicketBuilder insuranceNumber(String insuranceNumber) { this.insuranceNumber = insuranceNumber; return this; } public ProductTicketBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public ProductTicket build() { return new ProductTicket(this.storehouseId, this.orderStatus, this.orderStatusName, this.ticketId, this.orderId, this.orderType, this.orderTypeName, this.customerId, this.customernName, this.gender, this.age, this.createdAt, this.orderDate, this.departmentId, this.departmentName, this.ticketStatus, this.totalRecord, this.insuranceNumber, this.benefitRate); } public String toString() { return "ProductTicket.ProductTicketBuilder(storehouseId=" + this.storehouseId + ", orderStatus=" + this.orderStatus + ", orderStatusName=" + this.orderStatusName + ", ticketId=" + this.ticketId + ", orderId=" + this.orderId + ", orderType=" + this.orderType + ", orderTypeName=" + this.orderTypeName + ", customerId=" + this.customerId + ", customernName=" + this.customernName + ", gender=" + this.gender + ", age=" + this.age + ", createdAt=" + this.createdAt + ", orderDate=" + this.orderDate + ", departmentId=" + this.departmentId + ", departmentName=" + this.departmentName + ", ticketStatus=" + this.ticketStatus + ", totalRecord=" + this.totalRecord + ", insuranceNumber=" + this.insuranceNumber + ", benefitRate=" + this.benefitRate + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\ProductTicket$ProductTicketBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */