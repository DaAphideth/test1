/*     */ package nencer.app.Modules.Medic.Entity.Room;
/*     */ @Entity
/*     */ @Table(name = "medic_rooms")
/*     */ public class MedicRooms { private int id; private String name; private String code;
/*     */   private Integer roomType;
/*     */   private Integer departmentId;
/*     */   private Integer hospitalId;
/*     */   private Integer locationId;
/*     */   private Integer acceptInsurance;
/*     */   private Integer polyclinic;
/*     */   private Integer bigClinic;
/*     */   private Integer status;
/*     */   
/*  14 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicRooms)) return false;  MedicRooms other = (MedicRooms)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$roomType = getRoomType(), other$roomType = other.getRoomType(); if ((this$roomType == null) ? (other$roomType != null) : !this$roomType.equals(other$roomType)) return false;  Object this$departmentId = getDepartmentId(), other$departmentId = other.getDepartmentId(); if ((this$departmentId == null) ? (other$departmentId != null) : !this$departmentId.equals(other$departmentId)) return false;  Object this$hospitalId = getHospitalId(), other$hospitalId = other.getHospitalId(); if ((this$hospitalId == null) ? (other$hospitalId != null) : !this$hospitalId.equals(other$hospitalId)) return false;  Object this$locationId = getLocationId(), other$locationId = other.getLocationId(); if ((this$locationId == null) ? (other$locationId != null) : !this$locationId.equals(other$locationId)) return false;  Object this$acceptInsurance = getAcceptInsurance(), other$acceptInsurance = other.getAcceptInsurance(); if ((this$acceptInsurance == null) ? (other$acceptInsurance != null) : !this$acceptInsurance.equals(other$acceptInsurance)) return false;  Object this$polyclinic = getPolyclinic(), other$polyclinic = other.getPolyclinic(); if ((this$polyclinic == null) ? (other$polyclinic != null) : !this$polyclinic.equals(other$polyclinic)) return false;  Object this$bigClinic = getBigClinic(), other$bigClinic = other.getBigClinic(); if ((this$bigClinic == null) ? (other$bigClinic != null) : !this$bigClinic.equals(other$bigClinic)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$roomNumber = getRoomNumber(), other$roomNumber = other.getRoomNumber(); if ((this$roomNumber == null) ? (other$roomNumber != null) : !this$roomNumber.equals(other$roomNumber)) return false;  Object this$allowUsers = getAllowUsers(), other$allowUsers = other.getAllowUsers(); if ((this$allowUsers == null) ? (other$allowUsers != null) : !this$allowUsers.equals(other$allowUsers)) return false;  Object this$titlePrintName = getTitlePrintName(), other$titlePrintName = other.getTitlePrintName(); if ((this$titlePrintName == null) ? (other$titlePrintName != null) : !this$titlePrintName.equals(other$titlePrintName)) return false;  Object this$medicRoomTypes = getMedicRoomTypes(), other$medicRoomTypes = other.getMedicRoomTypes(); if ((this$medicRoomTypes == null) ? (other$medicRoomTypes != null) : !this$medicRoomTypes.equals(other$medicRoomTypes)) return false;  Object this$risDevice = getRisDevice(), other$risDevice = other.getRisDevice(); if ((this$risDevice == null) ? (other$risDevice != null) : !this$risDevice.equals(other$risDevice)) return false;  Object this$medicDepartments = getMedicDepartments(), other$medicDepartments = other.getMedicDepartments(); if ((this$medicDepartments == null) ? (other$medicDepartments != null) : !this$medicDepartments.equals(other$medicDepartments)) return false;  Object this$medicHospitals = getMedicHospitals(), other$medicHospitals = other.getMedicHospitals(); if ((this$medicHospitals == null) ? (other$medicHospitals != null) : !this$medicHospitals.equals(other$medicHospitals)) return false;  Object this$medicLocations = getMedicLocations(), other$medicLocations = other.getMedicLocations(); return !((this$medicLocations == null) ? (other$medicLocations != null) : !this$medicLocations.equals(other$medicLocations)); } private Integer sort; private Date createdAt; private Date updatedAt; private String roomNumber; private String allowUsers; private String titlePrintName; private MedicRoomTypes medicRoomTypes; private String risDevice; private MedicDepartments medicDepartments; private MedicHospitals medicHospitals; private MedicLocations medicLocations; protected boolean canEqual(Object other) { return other instanceof MedicRooms; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $roomType = getRoomType(); result = result * 59 + (($roomType == null) ? 43 : $roomType.hashCode()); Object $departmentId = getDepartmentId(); result = result * 59 + (($departmentId == null) ? 43 : $departmentId.hashCode()); Object $hospitalId = getHospitalId(); result = result * 59 + (($hospitalId == null) ? 43 : $hospitalId.hashCode()); Object $locationId = getLocationId(); result = result * 59 + (($locationId == null) ? 43 : $locationId.hashCode()); Object $acceptInsurance = getAcceptInsurance(); result = result * 59 + (($acceptInsurance == null) ? 43 : $acceptInsurance.hashCode()); Object $polyclinic = getPolyclinic(); result = result * 59 + (($polyclinic == null) ? 43 : $polyclinic.hashCode()); Object $bigClinic = getBigClinic(); result = result * 59 + (($bigClinic == null) ? 43 : $bigClinic.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $roomNumber = getRoomNumber(); result = result * 59 + (($roomNumber == null) ? 43 : $roomNumber.hashCode()); Object $allowUsers = getAllowUsers(); result = result * 59 + (($allowUsers == null) ? 43 : $allowUsers.hashCode()); Object $titlePrintName = getTitlePrintName(); result = result * 59 + (($titlePrintName == null) ? 43 : $titlePrintName.hashCode()); Object $medicRoomTypes = getMedicRoomTypes(); result = result * 59 + (($medicRoomTypes == null) ? 43 : $medicRoomTypes.hashCode()); Object $risDevice = getRisDevice(); result = result * 59 + (($risDevice == null) ? 43 : $risDevice.hashCode()); Object $medicDepartments = getMedicDepartments(); result = result * 59 + (($medicDepartments == null) ? 43 : $medicDepartments.hashCode()); Object $medicHospitals = getMedicHospitals(); result = result * 59 + (($medicHospitals == null) ? 43 : $medicHospitals.hashCode()); Object $medicLocations = getMedicLocations(); return result * 59 + (($medicLocations == null) ? 43 : $medicLocations.hashCode()); } public String toString() { return "MedicRooms(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", roomType=" + getRoomType() + ", departmentId=" + getDepartmentId() + ", hospitalId=" + getHospitalId() + ", locationId=" + getLocationId() + ", acceptInsurance=" + getAcceptInsurance() + ", polyclinic=" + getPolyclinic() + ", bigClinic=" + getBigClinic() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", roomNumber=" + getRoomNumber() + ", allowUsers=" + getAllowUsers() + ", titlePrintName=" + getTitlePrintName() + ", medicRoomTypes=" + getMedicRoomTypes() + ", risDevice=" + getRisDevice() + ", medicDepartments=" + getMedicDepartments() + ", medicHospitals=" + getMedicHospitals() + ", medicLocations=" + getMedicLocations() + ")"; }
/*     */    public MedicRooms() {} public MedicRooms(int id, String name, String code, Integer roomType, Integer departmentId, Integer hospitalId, Integer locationId, Integer acceptInsurance, Integer polyclinic, Integer bigClinic, Integer status, Integer sort, Date createdAt, Date updatedAt, String roomNumber, String allowUsers, String titlePrintName, MedicRoomTypes medicRoomTypes, String risDevice, MedicDepartments medicDepartments, MedicHospitals medicHospitals, MedicLocations medicLocations) {
/*  16 */     this.id = id; this.name = name; this.code = code; this.roomType = roomType; this.departmentId = departmentId; this.hospitalId = hospitalId; this.locationId = locationId; this.acceptInsurance = acceptInsurance; this.polyclinic = polyclinic; this.bigClinic = bigClinic; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.roomNumber = roomNumber; this.allowUsers = allowUsers; this.titlePrintName = titlePrintName; this.medicRoomTypes = medicRoomTypes; this.risDevice = risDevice; this.medicDepartments = medicDepartments; this.medicHospitals = medicHospitals; this.medicLocations = medicLocations;
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
/*     */   public int getId() {
/*  42 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  46 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  52 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  56 */     this.name = name;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  63 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  67 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_type")
/*     */   public Integer getRoomType() {
/*  73 */     return this.roomType;
/*     */   }
/*     */   
/*     */   public void setRoomType(Integer roomType) {
/*  77 */     this.roomType = roomType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "department_id")
/*     */   public Integer getDepartmentId() {
/*  83 */     return this.departmentId;
/*     */   }
/*     */   
/*     */   public void setDepartmentId(Integer departmentId) {
/*  87 */     this.departmentId = departmentId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_id")
/*     */   public Integer getHospitalId() {
/*  93 */     return this.hospitalId;
/*     */   }
/*     */   
/*     */   public void setHospitalId(Integer hospitalId) {
/*  97 */     this.hospitalId = hospitalId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "location_id")
/*     */   public Integer getLocationId() {
/* 103 */     return this.locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(Integer locationId) {
/* 107 */     this.locationId = locationId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "accept_insurance")
/*     */   public Integer getAcceptInsurance() {
/* 113 */     return this.acceptInsurance;
/*     */   }
/*     */   
/*     */   public void setAcceptInsurance(Integer acceptInsurance) {
/* 117 */     this.acceptInsurance = acceptInsurance;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "polyclinic")
/*     */   public Integer getPolyclinic() {
/* 123 */     return this.polyclinic;
/*     */   }
/*     */   
/*     */   public void setPolyclinic(Integer polyclinic) {
/* 127 */     this.polyclinic = polyclinic;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "big_clinic")
/*     */   public Integer getBigClinic() {
/* 133 */     return this.bigClinic;
/*     */   }
/*     */   
/*     */   public void setBigClinic(Integer bigClinic) {
/* 137 */     this.bigClinic = bigClinic;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 143 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 147 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/* 153 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 157 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 163 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 167 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 173 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 177 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "department_id", updatable = false, insertable = false)
/*     */   public MedicDepartments getMedicDepartments() {
/* 185 */     return this.medicDepartments;
/*     */   }
/*     */   
/*     */   public void setMedicDepartments(MedicDepartments medicDepartments) {
/* 189 */     this.medicDepartments = medicDepartments;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "hospital_id", updatable = false, insertable = false)
/*     */   public MedicHospitals getMedicHospitals() {
/* 197 */     return this.medicHospitals;
/*     */   }
/*     */   
/*     */   public void setMedicHospitals(MedicHospitals medicHospitals) {
/* 201 */     this.medicHospitals = medicHospitals;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "location_id", updatable = false, insertable = false)
/*     */   public MedicLocations getMedicLocations() {
/* 209 */     return this.medicLocations;
/*     */   }
/*     */   
/*     */   public void setMedicLocations(MedicLocations medicLocations) {
/* 213 */     this.medicLocations = medicLocations;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "room_type", updatable = false, insertable = false)
/*     */   public MedicRoomTypes getMedicRoomTypes() {
/* 221 */     return this.medicRoomTypes;
/*     */   }
/*     */   
/*     */   public void setMedicRoomTypes(MedicRoomTypes medicRoomTypes) {
/* 225 */     this.medicRoomTypes = medicRoomTypes;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_number")
/*     */   public String getRoomNumber() {
/* 231 */     return this.roomNumber;
/*     */   }
/*     */   
/*     */   public void setRoomNumber(String roomNumber) {
/* 235 */     this.roomNumber = roomNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "title_print_name")
/*     */   public String getTitlePrintName() {
/* 241 */     return this.titlePrintName;
/*     */   }
/*     */   
/*     */   public void setTitlePrintName(String titlePrintName) {
/* 245 */     this.titlePrintName = titlePrintName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_users")
/*     */   public String getAllowUsers() {
/* 251 */     return this.allowUsers;
/*     */   }
/*     */   
/*     */   public void setAllowUsers(String allowUsers) {
/* 255 */     this.allowUsers = allowUsers;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ris_device")
/*     */   public String getRisDevice() {
/* 261 */     return this.risDevice;
/*     */   }
/*     */   
/*     */   public void setRisDevice(String risDevice) {
/* 265 */     this.risDevice = risDevice;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicRooms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */