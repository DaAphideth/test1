/*     */ package nencer.app.Modules.Storehouse.Entity;
/*     */ @Entity
/*     */ @Table(name = "medic_product_storehouse")
/*     */ @JsonIgnoreProperties(ignoreUnknown = true)
/*     */ public class MedicProductStorehouse { private Integer id; private String code;
/*     */   private String name;
/*     */   private String address;
/*     */   private String contactPhone;
/*     */   private String contactEmail;
/*     */   private String description;
/*     */   private Integer status;
/*     */   private String creatorId;
/*     */   
/*  14 */   public static MedicProductStorehouseBuilder builder() { return new MedicProductStorehouseBuilder(); } private String updaterId; private Date createdAt; private Date updatedAt; private String shType; private String orderTypeArray; private Integer isCashier; private Integer departmentId; private String allowRoomTreatmentId; private String allowUsers; private Integer totalRecord; public static class MedicProductStorehouseBuilder { private Integer id; private String code; private String name; private String address; private String contactPhone; private String contactEmail; private String description; private Integer status; private String creatorId; private String updaterId; private Date createdAt; private Date updatedAt; private String shType; private String orderTypeArray; private Integer isCashier; private Integer departmentId; private String allowRoomTreatmentId; private String allowUsers; private Integer totalRecord; public MedicProductStorehouseBuilder id(Integer id) { this.id = id; return this; } public MedicProductStorehouseBuilder code(String code) { this.code = code; return this; } public MedicProductStorehouseBuilder name(String name) { this.name = name; return this; } public MedicProductStorehouseBuilder address(String address) { this.address = address; return this; } public MedicProductStorehouseBuilder contactPhone(String contactPhone) { this.contactPhone = contactPhone; return this; } public MedicProductStorehouseBuilder contactEmail(String contactEmail) { this.contactEmail = contactEmail; return this; } public MedicProductStorehouseBuilder description(String description) { this.description = description; return this; } public MedicProductStorehouseBuilder status(Integer status) { this.status = status; return this; } public MedicProductStorehouseBuilder creatorId(String creatorId) { this.creatorId = creatorId; return this; } public MedicProductStorehouseBuilder updaterId(String updaterId) { this.updaterId = updaterId; return this; } public MedicProductStorehouseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicProductStorehouseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicProductStorehouseBuilder shType(String shType) { this.shType = shType; return this; } public MedicProductStorehouseBuilder orderTypeArray(String orderTypeArray) { this.orderTypeArray = orderTypeArray; return this; } public MedicProductStorehouseBuilder isCashier(Integer isCashier) { this.isCashier = isCashier; return this; } public MedicProductStorehouseBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicProductStorehouseBuilder allowRoomTreatmentId(String allowRoomTreatmentId) { this.allowRoomTreatmentId = allowRoomTreatmentId; return this; } public MedicProductStorehouseBuilder allowUsers(String allowUsers) { this.allowUsers = allowUsers; return this; } public MedicProductStorehouseBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public MedicProductStorehouse build() { return new MedicProductStorehouse(this.id, this.code, this.name, this.address, this.contactPhone, this.contactEmail, this.description, this.status, this.creatorId, this.updaterId, this.createdAt, this.updatedAt, this.shType, this.orderTypeArray, this.isCashier, this.departmentId, this.allowRoomTreatmentId, this.allowUsers, this.totalRecord); } public String toString() { return "MedicProductStorehouse.MedicProductStorehouseBuilder(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", address=" + this.address + ", contactPhone=" + this.contactPhone + ", contactEmail=" + this.contactEmail + ", description=" + this.description + ", status=" + this.status + ", creatorId=" + this.creatorId + ", updaterId=" + this.updaterId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", shType=" + this.shType + ", orderTypeArray=" + this.orderTypeArray + ", isCashier=" + this.isCashier + ", departmentId=" + this.departmentId + ", allowRoomTreatmentId=" + this.allowRoomTreatmentId + ", allowUsers=" + this.allowUsers + ", totalRecord=" + this.totalRecord + ")"; }
/*     */      } public MedicProductStorehouse() {} public MedicProductStorehouse(Integer id, String code, String name, String address, String contactPhone, String contactEmail, String description, Integer status, String creatorId, String updaterId, Date createdAt, Date updatedAt, String shType, String orderTypeArray, Integer isCashier, Integer departmentId, String allowRoomTreatmentId, String allowUsers, Integer totalRecord) {
/*  16 */     this.id = id; this.code = code; this.name = name; this.address = address; this.contactPhone = contactPhone; this.contactEmail = contactEmail; this.description = description; this.status = status; this.creatorId = creatorId; this.updaterId = updaterId; this.createdAt = createdAt; this.updatedAt = updatedAt; this.shType = shType; this.orderTypeArray = orderTypeArray; this.isCashier = isCashier; this.departmentId = departmentId; this.allowRoomTreatmentId = allowRoomTreatmentId; this.allowUsers = allowUsers; this.totalRecord = totalRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public Integer getId() {
/*  43 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  47 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  53 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  57 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  63 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  67 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/*  73 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  77 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "contact_phone")
/*     */   public String getContactPhone() {
/*  83 */     return this.contactPhone;
/*     */   }
/*     */   
/*     */   public void setContactPhone(String contactPhone) {
/*  87 */     this.contactPhone = contactPhone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "contact_email")
/*     */   public String getContactEmail() {
/*  93 */     return this.contactEmail;
/*     */   }
/*     */   
/*     */   public void setContactEmail(String contactEmail) {
/*  97 */     this.contactEmail = contactEmail;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/* 103 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 107 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 113 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 117 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public String getCreatorId() {
/* 123 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String creatorId) {
/* 127 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updater_id")
/*     */   public String getUpdaterId() {
/* 133 */     return this.updaterId;
/*     */   }
/*     */   
/*     */   public void setUpdaterId(String updaterId) {
/* 137 */     this.updaterId = updaterId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 143 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 147 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 153 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 157 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sh_type")
/*     */   public String getShType() {
/* 163 */     return this.shType;
/*     */   }
/*     */   
/*     */   public void setShType(String shType) {
/* 167 */     this.shType = shType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "order_type_array")
/*     */   public String getOrderTypeArray() {
/* 173 */     return this.orderTypeArray;
/*     */   }
/*     */   
/*     */   public void setOrderTypeArray(String orderTypeArray) {
/* 177 */     this.orderTypeArray = orderTypeArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_cashier")
/*     */   public Integer getIsCashier() {
/* 183 */     return this.isCashier;
/*     */   }
/*     */   
/*     */   public void setIsCashier(Integer isCashier) {
/* 187 */     this.isCashier = isCashier;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "department_id")
/*     */   public Integer getDepartmentId() {
/* 194 */     return this.departmentId;
/*     */   }
/*     */   
/*     */   public void setDepartmentId(Integer departmentId) {
/* 198 */     this.departmentId = departmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_room_treatment_id")
/*     */   public String getAllowRoomTreatmentId() {
/* 204 */     return this.allowRoomTreatmentId;
/*     */   }
/*     */   
/*     */   public void setAllowRoomTreatmentId(String allowRoomTreatmentId) {
/* 208 */     this.allowRoomTreatmentId = allowRoomTreatmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_users")
/*     */   public String getAllowUsers() {
/* 214 */     return this.allowUsers;
/*     */   }
/*     */   
/*     */   public void setAllowUsers(String allowUsers) {
/* 218 */     this.allowUsers = allowUsers;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public Integer getTotalRecord() {
/* 223 */     return this.totalRecord;
/*     */   }
/*     */   
/*     */   public void setTotalRecord(Integer totalRecord) {
/* 227 */     this.totalRecord = totalRecord;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicProductStorehouse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */