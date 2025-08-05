/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicChamberResponse { private Integer id; private String name;
/*    */   private String code;
/*    */   
/*  6 */   public void setId(Integer id) { this.id = id; } private Integer roomId; private String roomName; private Integer totalRecord; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setRoomId(Integer roomId) { this.roomId = roomId; } public void setRoomName(String roomName) { this.roomName = roomName; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicChamberResponse)) return false;  MedicChamberResponse other = (MedicChamberResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$roomId = getRoomId(), other$roomId = other.getRoomId(); if ((this$roomId == null) ? (other$roomId != null) : !this$roomId.equals(other$roomId)) return false;  Object this$roomName = getRoomName(), other$roomName = other.getRoomName(); if ((this$roomName == null) ? (other$roomName != null) : !this$roomName.equals(other$roomName)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } protected boolean canEqual(Object other) { return other instanceof MedicChamberResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $roomId = getRoomId(); result = result * 59 + (($roomId == null) ? 43 : $roomId.hashCode()); Object $roomName = getRoomName(); result = result * 59 + (($roomName == null) ? 43 : $roomName.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "MedicChamberResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", roomId=" + getRoomId() + ", roomName=" + getRoomName() + ", totalRecord=" + getTotalRecord() + ")"; }
/*    */ 
/*    */   
/*  9 */   public Integer getId() { return this.id; }
/* 10 */   public String getName() { return this.name; }
/* 11 */   public String getCode() { return this.code; }
/* 12 */   public Integer getRoomId() { return this.roomId; }
/* 13 */   public String getRoomName() { return this.roomName; } public Integer getTotalRecord() {
/* 14 */     return this.totalRecord;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\MedicChamberResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */