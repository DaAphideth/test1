/*     */ package nencer.app.Modules.Medic.Entity.Service;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_services")
/*     */ public class MedicServices implements Serializable {
/*     */   private Integer id;
/*     */   private int parentId;
/*     */   
/*     */   public MedicServices(Integer id, int parentId, String name, String nameIns, String code, String codeIns, String description, Integer unitId, String unit, Integer serviceGroupId, Integer serviceGroupCode, Integer serviceTypeId, String insuranceGroupCode, Double price, Double priceIns, Double priceService, String roomHandleId, String roomId, String roomSampleId, Integer status, Integer sort, Date createdAt, Date updatedAt, String originalResult, Set<MedicServices> children, String specialtyCode, String equivalentCode, Integer reassignmentTime, Integer rightRate, Integer offlineRate, MedicServiceGroups serviceGroup, MedicServiceTypes serviceTypes, MedicUnit medicUnit) {
/*  13 */     this.id = id; this.parentId = parentId; this.name = name; this.nameIns = nameIns; this.code = code; this.codeIns = codeIns; this.description = description; this.unitId = unitId; this.unit = unit; this.serviceGroupId = serviceGroupId; this.serviceGroupCode = serviceGroupCode; this.serviceTypeId = serviceTypeId; this.insuranceGroupCode = insuranceGroupCode; this.price = price; this.priceIns = priceIns; this.priceService = priceService; this.roomHandleId = roomHandleId; this.roomId = roomId; this.roomSampleId = roomSampleId; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.originalResult = originalResult; this.children = children; this.specialtyCode = specialtyCode; this.equivalentCode = equivalentCode; this.reassignmentTime = reassignmentTime; this.rightRate = rightRate; this.offlineRate = offlineRate; this.serviceGroup = serviceGroup; this.serviceTypes = serviceTypes; this.medicUnit = medicUnit;
/*     */   }
/*     */   private String name; private String nameIns;
/*     */   private String code;
/*     */   private String codeIns;
/*     */   private String description;
/*     */   private Integer unitId;
/*     */   private String unit;
/*     */   private Integer serviceGroupId;
/*     */   private Integer serviceGroupCode;
/*     */   private Integer serviceTypeId;
/*     */   private String insuranceGroupCode;
/*     */   private Double price;
/*     */   private Double priceIns;
/*     */   private Double priceService;
/*     */   private String roomHandleId;
/*     */   private String roomId;
/*     */   private String roomSampleId;
/*     */   private Integer status;
/*     */   private Integer sort;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   private String originalResult;
/*     */   private Set<MedicServices> children;
/*     */   private String specialtyCode;
/*     */   private String equivalentCode;
/*     */   private Integer reassignmentTime;
/*     */   private Integer rightRate;
/*     */   private Integer offlineRate;
/*     */   private MedicServiceGroups serviceGroup;
/*     */   private MedicServiceTypes serviceTypes;
/*     */   private MedicUnit medicUnit;
/*     */   
/*     */   public MedicServices() {}
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  52 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  56 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "original_result")
/*     */   public String getOriginalResult() {
/*  62 */     return this.originalResult;
/*     */   }
/*     */   
/*     */   public void setOriginalResult(String originalResult) {
/*  66 */     this.originalResult = originalResult;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit")
/*     */   public String getUnit() {
/*  73 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/*  77 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_code")
/*     */   public Integer getServiceGroupCode() {
/*  83 */     return this.serviceGroupCode;
/*     */   }
/*     */   
/*     */   public void setServiceGroupCode(Integer serviceGroupCode) {
/*  87 */     this.serviceGroupCode = serviceGroupCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_group_code")
/*     */   public String getInsuranceGroupCode() {
/*  93 */     return this.insuranceGroupCode;
/*     */   }
/*     */   
/*     */   public void setInsuranceGroupCode(String insuranceGroupCode) {
/*  97 */     this.insuranceGroupCode = insuranceGroupCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "parent_id")
/*     */   public int getParentId() {
/* 103 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(int parentId) {
/* 107 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public String getRoomId() {
/* 113 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(String roomId) {
/* 117 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/* 123 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 127 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_ins")
/*     */   public String getNameIns() {
/* 133 */     return this.nameIns;
/*     */   }
/*     */   
/*     */   public void setNameIns(String nameIns) {
/* 137 */     this.nameIns = nameIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/* 143 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 147 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_ins")
/*     */   public String getCodeIns() {
/* 153 */     return this.codeIns;
/*     */   }
/*     */   
/*     */   public void setCodeIns(String codeIns) {
/* 157 */     this.codeIns = codeIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 163 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 167 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "unit_id")
/*     */   public Integer getUnitId() {
/* 173 */     return this.unitId;
/*     */   }
/*     */   
/*     */   public void setUnitId(Integer unitId) {
/* 177 */     this.unitId = unitId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_id")
/*     */   public Integer getServiceGroupId() {
/* 183 */     return this.serviceGroupId;
/*     */   }
/*     */   
/*     */   public void setServiceGroupId(Integer serviceGroupId) {
/* 187 */     this.serviceGroupId = serviceGroupId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_type_id")
/*     */   public Integer getServiceTypeId() {
/* 193 */     return this.serviceTypeId;
/*     */   }
/*     */   
/*     */   public void setServiceTypeId(Integer serviceTypeId) {
/* 197 */     this.serviceTypeId = serviceTypeId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price")
/*     */   public Double getPrice() {
/* 203 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 207 */     this.price = price;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_ins")
/*     */   public Double getPriceIns() {
/* 213 */     return this.priceIns;
/*     */   }
/*     */   
/*     */   public void setPriceIns(Double priceIns) {
/* 217 */     this.priceIns = priceIns;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "price_service")
/*     */   public Double getPriceService() {
/* 223 */     return this.priceService;
/*     */   }
/*     */   
/*     */   public void setPriceService(Double priceService) {
/* 227 */     this.priceService = priceService;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_handle_id")
/*     */   public String getRoomHandleId() {
/* 233 */     return this.roomHandleId;
/*     */   }
/*     */   
/*     */   public void setRoomHandleId(String roomHandleId) {
/* 237 */     this.roomHandleId = roomHandleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_sample_id")
/*     */   public String getRoomSampleId() {
/* 243 */     return this.roomSampleId;
/*     */   }
/*     */   
/*     */   public void setRoomSampleId(String roomSampleId) {
/* 247 */     this.roomSampleId = roomSampleId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 253 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 257 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 263 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 267 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 273 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 277 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 283 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 287 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "service_group_id", updatable = false, insertable = false)
/*     */   public MedicServiceGroups getServiceGroup() {
/* 295 */     return this.serviceGroup;
/*     */   }
/*     */   
/*     */   public void setServiceGroup(MedicServiceGroups serviceGroup) {
/* 299 */     this.serviceGroup = serviceGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "service_type_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicServiceTypes getServiceTypes() {
/* 308 */     return this.serviceTypes;
/*     */   }
/*     */   
/*     */   public void setServiceTypes(MedicServiceTypes serviceTypes) {
/* 312 */     this.serviceTypes = serviceTypes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "unit_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicUnit getMedicUnit() {
/* 320 */     return this.medicUnit;
/*     */   }
/*     */   
/*     */   public void setMedicUnit(MedicUnit medicUnit) {
/* 324 */     this.medicUnit = medicUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transient
/*     */   public Set<MedicServices> getChildren() {
/* 331 */     return this.children;
/*     */   }
/*     */   
/*     */   public void setChildren(Set<MedicServices> children) {
/* 335 */     this.children = children;
/*     */   }
/*     */   
/*     */   public void addChild(MedicServices children) {
/* 339 */     this.children.add(children);
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "specialty_code")
/*     */   public String getSpecialtyCode() {
/* 345 */     return this.specialtyCode;
/*     */   }
/*     */   
/*     */   public void setSpecialtyCode(String specialtyCode) {
/* 349 */     this.specialtyCode = specialtyCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "equivalent_code")
/*     */   public String getEquivalentCode() {
/* 355 */     return this.equivalentCode;
/*     */   }
/*     */   
/*     */   public void setEquivalentCode(String equivalentCode) {
/* 359 */     this.equivalentCode = equivalentCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reassignment_time")
/*     */   public Integer getReassignmentTime() {
/* 365 */     return this.reassignmentTime;
/*     */   }
/*     */   
/*     */   public void setReassignmentTime(Integer reassignmentTime) {
/* 369 */     this.reassignmentTime = reassignmentTime;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "right_rate")
/*     */   public Integer getRightRate() {
/* 375 */     return this.rightRate;
/*     */   }
/*     */   
/*     */   public void setRightRate(Integer rightRate) {
/* 379 */     this.rightRate = rightRate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "offline_rate")
/*     */   public Integer getOffLineRate() {
/* 385 */     return this.offlineRate;
/*     */   }
/*     */   
/*     */   public void setOffLineRate(Integer offlineRate) {
/* 389 */     this.offlineRate = offlineRate;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicServices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */