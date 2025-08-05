/*     */ package nencer.app.Modules.Medic.Entity.Service;
/*     */ @Entity
/*     */ @Table(name = "medic_order_services_ext")
/*     */ public class MedicOrderServicesExt { private int id;
/*     */   private Integer serviceId;
/*     */   private Integer orderServiceId;
/*     */   private Integer serviceGroupId;
/*     */   private Integer ticketId;
/*     */   private String serviceCode;
/*     */   private String serviceName;
/*     */   
/*  12 */   public static MedicOrderServicesExtBuilder builder() { return new MedicOrderServicesExtBuilder(); } private Integer unitId; private String originalResult; private String handlerResult; private String deviceResult; private Date createdAt; private Date updatedAt; private MedicUnit medicUnit; public static class MedicOrderServicesExtBuilder { private int id; private Integer serviceId; private Integer orderServiceId; private Integer serviceGroupId; private Integer ticketId; private String serviceCode; private String serviceName; private Integer unitId; private String originalResult; private String handlerResult; private String deviceResult; private Date createdAt; private Date updatedAt; private MedicUnit medicUnit; public MedicOrderServicesExtBuilder id(int id) { this.id = id; return this; } public MedicOrderServicesExtBuilder serviceId(Integer serviceId) { this.serviceId = serviceId; return this; } public MedicOrderServicesExtBuilder orderServiceId(Integer orderServiceId) { this.orderServiceId = orderServiceId; return this; } public MedicOrderServicesExtBuilder serviceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; return this; } public MedicOrderServicesExtBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicOrderServicesExtBuilder serviceCode(String serviceCode) { this.serviceCode = serviceCode; return this; } public MedicOrderServicesExtBuilder serviceName(String serviceName) { this.serviceName = serviceName; return this; } public MedicOrderServicesExtBuilder unitId(Integer unitId) { this.unitId = unitId; return this; } public MedicOrderServicesExtBuilder originalResult(String originalResult) { this.originalResult = originalResult; return this; } public MedicOrderServicesExtBuilder handlerResult(String handlerResult) { this.handlerResult = handlerResult; return this; } public MedicOrderServicesExtBuilder deviceResult(String deviceResult) { this.deviceResult = deviceResult; return this; } public MedicOrderServicesExtBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicOrderServicesExtBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicOrderServicesExtBuilder medicUnit(MedicUnit medicUnit) { this.medicUnit = medicUnit; return this; } public MedicOrderServicesExt build() { return new MedicOrderServicesExt(this.id, this.serviceId, this.orderServiceId, this.serviceGroupId, this.ticketId, this.serviceCode, this.serviceName, this.unitId, this.originalResult, this.handlerResult, this.deviceResult, this.createdAt, this.updatedAt, this.medicUnit); } public String toString() { return "MedicOrderServicesExt.MedicOrderServicesExtBuilder(id=" + this.id + ", serviceId=" + this.serviceId + ", orderServiceId=" + this.orderServiceId + ", serviceGroupId=" + this.serviceGroupId + ", ticketId=" + this.ticketId + ", serviceCode=" + this.serviceCode + ", serviceName=" + this.serviceName + ", unitId=" + this.unitId + ", originalResult=" + this.originalResult + ", handlerResult=" + this.handlerResult + ", deviceResult=" + this.deviceResult + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", medicUnit=" + this.medicUnit + ")"; } } public MedicOrderServicesExt(int id, Integer serviceId, Integer orderServiceId, Integer serviceGroupId, Integer ticketId, String serviceCode, String serviceName, Integer unitId, String originalResult, String handlerResult, String deviceResult, Date createdAt, Date updatedAt, MedicUnit medicUnit) {
/*  13 */     this.id = id; this.serviceId = serviceId; this.orderServiceId = orderServiceId; this.serviceGroupId = serviceGroupId; this.ticketId = ticketId; this.serviceCode = serviceCode; this.serviceName = serviceName; this.unitId = unitId; this.originalResult = originalResult; this.handlerResult = handlerResult; this.deviceResult = deviceResult; this.createdAt = createdAt; this.updatedAt = updatedAt; this.medicUnit = medicUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicOrderServicesExt() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  36 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  40 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "handler_result")
/*     */   public String getHandlerResult() {
/*  46 */     return this.handlerResult;
/*     */   }
/*     */   
/*     */   public void setHandlerResult(String handlerResult) {
/*  50 */     this.handlerResult = handlerResult;
/*     */   }
/*     */   @Basic
/*     */   @Column(name = "device_result")
/*     */   public String getDeviceResult() {
/*  55 */     return this.deviceResult;
/*     */   }
/*     */   
/*     */   public void setDeviceResult(String deviceResult) {
/*  59 */     this.deviceResult = deviceResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_service_id")
/*     */   public Integer getOrderServiceId() {
/*  65 */     return this.orderServiceId;
/*     */   }
/*     */   
/*     */   public void setOrderServiceId(Integer orderServiceId) {
/*  69 */     this.orderServiceId = orderServiceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ticket_id")
/*     */   public Integer getTicketId() {
/*  75 */     return this.ticketId;
/*     */   }
/*     */   
/*     */   public void setTicketId(Integer ticketId) {
/*  79 */     this.ticketId = ticketId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public Integer getServiceId() {
/*  85 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/*  89 */     this.serviceId = serviceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_id")
/*     */   public Integer getServiceGroupId() {
/*  95 */     return this.serviceGroupId;
/*     */   }
/*     */   
/*     */   public void setServiceGroupId(Integer serviceGroupId) {
/*  99 */     this.serviceGroupId = serviceGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_code")
/*     */   public String getServiceCode() {
/* 105 */     return this.serviceCode;
/*     */   }
/*     */   
/*     */   public void setServiceCode(String serviceCode) {
/* 109 */     this.serviceCode = serviceCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_name")
/*     */   public String getServiceName() {
/* 115 */     return this.serviceName;
/*     */   }
/*     */   
/*     */   public void setServiceName(String serviceName) {
/* 119 */     this.serviceName = serviceName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/* 125 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/* 129 */     this.unitId = unitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "original_result")
/*     */   public String getOriginalResult() {
/* 135 */     return this.originalResult;
/*     */   }
/*     */   
/*     */   public void setOriginalResult(String originalResult) {
/* 139 */     this.originalResult = originalResult;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 145 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 149 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 155 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 159 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "unit_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public MedicUnit getMedicUnit() {
/* 165 */     return this.medicUnit;
/*     */   }
/*     */   
/*     */   public void setMedicUnit(MedicUnit medicUnit) {
/* 169 */     this.medicUnit = medicUnit;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicOrderServicesExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */