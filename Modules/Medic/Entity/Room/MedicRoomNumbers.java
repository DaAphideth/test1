/*     */ package nencer.app.Modules.Medic.Entity.Room;
/*     */ @Entity
/*     */ @Table(name = "medic_room_numbers")
/*     */ public class MedicRoomNumbers {
/*     */   private int id;
/*     */   private String name;
/*     */   private String number;
/*     */   private int roomId;
/*     */   private int roomTypeId;
/*     */   private String roomTypeCode;
/*     */   
/*  12 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicRoomNumbers)) return false;  MedicRoomNumbers other = (MedicRoomNumbers)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$number = getNumber(), other$number = other.getNumber(); if ((this$number == null) ? (other$number != null) : !this$number.equals(other$number)) return false;  if (getRoomId() != other.getRoomId()) return false;  if (getRoomTypeId() != other.getRoomTypeId()) return false;  Object this$roomTypeCode = getRoomTypeCode(), other$roomTypeCode = other.getRoomTypeCode(); if ((this$roomTypeCode == null) ? (other$roomTypeCode != null) : !this$roomTypeCode.equals(other$roomTypeCode)) return false;  Object this$note = getNote(), other$note = other.getNote(); if ((this$note == null) ? (other$note != null) : !this$note.equals(other$note)) return false;  Object this$allowUsers = getAllowUsers(), other$allowUsers = other.getAllowUsers(); if ((this$allowUsers == null) ? (other$allowUsers != null) : !this$allowUsers.equals(other$allowUsers)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$medicRooms = getMedicRooms(), other$medicRooms = other.getMedicRooms(); if ((this$medicRooms == null) ? (other$medicRooms != null) : !this$medicRooms.equals(other$medicRooms)) return false;  Object this$medicRoomTypes = getMedicRoomTypes(), other$medicRoomTypes = other.getMedicRoomTypes(); return !((this$medicRoomTypes == null) ? (other$medicRoomTypes != null) : !this$medicRoomTypes.equals(other$medicRoomTypes)); } private String note; private String allowUsers; private Integer status; private Date createdAt; private Date updatedAt; private MedicRooms medicRooms; private MedicRoomTypes medicRoomTypes; protected boolean canEqual(Object other) { return other instanceof MedicRoomNumbers; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $number = getNumber(); result = result * 59 + (($number == null) ? 43 : $number.hashCode()); result = result * 59 + getRoomId(); result = result * 59 + getRoomTypeId(); Object $roomTypeCode = getRoomTypeCode(); result = result * 59 + (($roomTypeCode == null) ? 43 : $roomTypeCode.hashCode()); Object $note = getNote(); result = result * 59 + (($note == null) ? 43 : $note.hashCode()); Object $allowUsers = getAllowUsers(); result = result * 59 + (($allowUsers == null) ? 43 : $allowUsers.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $medicRooms = getMedicRooms(); result = result * 59 + (($medicRooms == null) ? 43 : $medicRooms.hashCode()); Object $medicRoomTypes = getMedicRoomTypes(); return result * 59 + (($medicRoomTypes == null) ? 43 : $medicRoomTypes.hashCode()); } public String toString() { return "MedicRoomNumbers(id=" + getId() + ", name=" + getName() + ", number=" + getNumber() + ", roomId=" + getRoomId() + ", roomTypeId=" + getRoomTypeId() + ", roomTypeCode=" + getRoomTypeCode() + ", note=" + getNote() + ", allowUsers=" + getAllowUsers() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", medicRooms=" + getMedicRooms() + ", medicRoomTypes=" + getMedicRoomTypes() + ")"; } public MedicRoomNumbers(int id, String name, String number, int roomId, int roomTypeId, String roomTypeCode, String note, String allowUsers, Integer status, Date createdAt, Date updatedAt, MedicRooms medicRooms, MedicRoomTypes medicRoomTypes) {
/*  13 */     this.id = id; this.name = name; this.number = number; this.roomId = roomId; this.roomTypeId = roomTypeId; this.roomTypeCode = roomTypeCode; this.note = note; this.allowUsers = allowUsers; this.status = status; this.createdAt = createdAt; this.updatedAt = updatedAt; this.medicRooms = medicRooms; this.medicRoomTypes = medicRoomTypes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicRoomNumbers() {}
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
/*  33 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  43 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  47 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public String getNumber() {
/*  53 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(String number) {
/*  57 */     this.number = number;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public int getRoomId() {
/*  63 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(int roomId) {
/*  67 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/*  73 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/*  77 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_users")
/*     */   public String getAllowUsers() {
/*  83 */     return this.allowUsers;
/*     */   }
/*     */   
/*     */   public void setAllowUsers(String allowUsers) {
/*  87 */     this.allowUsers = allowUsers;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  93 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  97 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 103 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 107 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 113 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 117 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_type_id")
/*     */   public int getRoomTypeId() {
/* 123 */     return this.roomTypeId;
/*     */   }
/*     */   
/*     */   public void setRoomTypeId(int roomTypeId) {
/* 127 */     this.roomTypeId = roomTypeId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_type_code")
/*     */   public String getRoomTypeCode() {
/* 133 */     return this.roomTypeCode;
/*     */   }
/*     */   
/*     */   public void setRoomTypeCode(String roomTypeCode) {
/* 137 */     this.roomTypeCode = roomTypeCode;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "room_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicRooms getMedicRooms() {
/* 143 */     return this.medicRooms;
/*     */   }
/*     */   
/*     */   public void setMedicRooms(MedicRooms medicRooms) {
/* 147 */     this.medicRooms = medicRooms;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "room_type_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicRoomTypes getMedicRoomTypes() {
/* 155 */     return this.medicRoomTypes;
/*     */   }
/*     */   
/*     */   public void setMedicRoomTypes(MedicRoomTypes medicRoomTypes) {
/* 159 */     this.medicRoomTypes = medicRoomTypes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicRoomNumbers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */