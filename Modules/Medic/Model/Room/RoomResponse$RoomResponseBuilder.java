/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ 
/*    */ public class RoomResponseBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String code;
/*    */   private Integer roomType;
/*    */   private String roomNumber;
/*    */   private Integer departmentId;
/*    */   private Integer hospitalId;
/*    */   private Integer locationId;
/*    */   private Integer acceptInsurance;
/*    */   
/* 14 */   public RoomResponseBuilder id(int id) { this.id = id; return this; } private Integer polyclinic; private Integer bigClinic; private Integer status; private Integer sort; private Date createdAt; private Date updatedAt; private String allowUsers; private String risDevice; private String updatedAtDis; private String createdAtDis; public RoomResponseBuilder name(String name) { this.name = name; return this; } public RoomResponseBuilder code(String code) { this.code = code; return this; } public RoomResponseBuilder roomType(Integer roomType) { this.roomType = roomType; return this; } public RoomResponseBuilder roomNumber(String roomNumber) { this.roomNumber = roomNumber; return this; } public RoomResponseBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public RoomResponseBuilder hospitalId(Integer hospitalId) { this.hospitalId = hospitalId; return this; } public RoomResponseBuilder locationId(Integer locationId) { this.locationId = locationId; return this; } public RoomResponseBuilder acceptInsurance(Integer acceptInsurance) { this.acceptInsurance = acceptInsurance; return this; } public RoomResponseBuilder polyclinic(Integer polyclinic) { this.polyclinic = polyclinic; return this; } public RoomResponseBuilder bigClinic(Integer bigClinic) { this.bigClinic = bigClinic; return this; } public RoomResponseBuilder status(Integer status) { this.status = status; return this; } public RoomResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public RoomResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RoomResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RoomResponseBuilder allowUsers(String allowUsers) { this.allowUsers = allowUsers; return this; } public RoomResponseBuilder risDevice(String risDevice) { this.risDevice = risDevice; return this; } public RoomResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public RoomResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public RoomResponse build() { return new RoomResponse(this.id, this.name, this.code, this.roomType, this.roomNumber, this.departmentId, this.hospitalId, this.locationId, this.acceptInsurance, this.polyclinic, this.bigClinic, this.status, this.sort, this.createdAt, this.updatedAt, this.allowUsers, this.risDevice, this.updatedAtDis, this.createdAtDis); } public String toString() { return "RoomResponse.RoomResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", roomType=" + this.roomType + ", roomNumber=" + this.roomNumber + ", departmentId=" + this.departmentId + ", hospitalId=" + this.hospitalId + ", locationId=" + this.locationId + ", acceptInsurance=" + this.acceptInsurance + ", polyclinic=" + this.polyclinic + ", bigClinic=" + this.bigClinic + ", status=" + this.status + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", allowUsers=" + this.allowUsers + ", risDevice=" + this.risDevice + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\RoomResponse$RoomResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */