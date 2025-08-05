/*    */ package nencer.app.Modules.Medic.Entity.Service;
/*    */ 
/*    */ public class MedicOrderServicesExtBuilder {
/*    */   private int id;
/*    */   private Integer serviceId;
/*    */   private Integer orderServiceId;
/*    */   private Integer serviceGroupId;
/*    */   private Integer ticketId;
/*    */   private String serviceCode;
/*    */   private String serviceName;
/*    */   
/* 12 */   public MedicOrderServicesExtBuilder id(int id) { this.id = id; return this; } private Integer unitId; private String originalResult; private String handlerResult; private String deviceResult; private Date createdAt; private Date updatedAt; private MedicUnit medicUnit; public MedicOrderServicesExtBuilder serviceId(Integer serviceId) { this.serviceId = serviceId; return this; } public MedicOrderServicesExtBuilder orderServiceId(Integer orderServiceId) { this.orderServiceId = orderServiceId; return this; } public MedicOrderServicesExtBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public MedicOrderServicesExtBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicOrderServicesExtBuilder serviceCode(String serviceCode) { this.serviceCode = serviceCode; return this; } public MedicOrderServicesExtBuilder serviceName(String serviceName) { this.serviceName = serviceName; return this; } public MedicOrderServicesExtBuilder unitId(Integer unitId) { this.unitId = unitId; return this; } public MedicOrderServicesExtBuilder originalResult(String originalResult) { this.originalResult = originalResult; return this; } public MedicOrderServicesExtBuilder handlerResult(String handlerResult) { this.handlerResult = handlerResult; return this; } public MedicOrderServicesExtBuilder deviceResult(String deviceResult) { this.deviceResult = deviceResult; return this; } public MedicOrderServicesExtBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicOrderServicesExtBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicOrderServicesExtBuilder medicUnit(MedicUnit medicUnit) { this.medicUnit = medicUnit; return this; } public MedicOrderServicesExt build() { return new MedicOrderServicesExt(this.id, this.serviceId, this.orderServiceId, this.serviceGroupId, this.ticketId, this.serviceCode, this.serviceName, this.unitId, this.originalResult, this.handlerResult, this.deviceResult, this.createdAt, this.updatedAt, this.medicUnit); } public String toString() { return "MedicOrderServicesExt.MedicOrderServicesExtBuilder(id=" + this.id + ", serviceId=" + this.serviceId + ", orderServiceId=" + this.orderServiceId + ", serviceGroupId=" + this.serviceGroupId + ", ticketId=" + this.ticketId + ", serviceCode=" + this.serviceCode + ", serviceName=" + this.serviceName + ", unitId=" + this.unitId + ", originalResult=" + this.originalResult + ", handlerResult=" + this.handlerResult + ", deviceResult=" + this.deviceResult + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", medicUnit=" + this.medicUnit + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicOrderServicesExt$MedicOrderServicesExtBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */