/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RoomNumberRequestBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String number;
/*    */   private int roomId;
/*    */   private int roomTypeId;
/*    */   
/*    */   public RoomNumberRequestBuilder id(int id) {
/* 13 */     this.id = id; return this; } private String roomTypeCode; private String note; private String allowUsers; private Integer status; private Date createdAt; private Date updatedAt; public RoomNumberRequestBuilder name(String name) { this.name = name; return this; } public RoomNumberRequestBuilder number(String number) { this.number = number; return this; } public RoomNumberRequestBuilder roomId(int roomId) { this.roomId = roomId; return this; } public RoomNumberRequestBuilder roomTypeId(int roomTypeId) { this.roomTypeId = roomTypeId; return this; } public RoomNumberRequestBuilder roomTypeCode(String roomTypeCode) { this.roomTypeCode = roomTypeCode; return this; } public RoomNumberRequestBuilder note(String note) { this.note = note; return this; } public RoomNumberRequestBuilder allowUsers(String allowUsers) { this.allowUsers = allowUsers; return this; } public RoomNumberRequestBuilder status(Integer status) { this.status = status; return this; } public RoomNumberRequestBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RoomNumberRequestBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RoomNumberRequest build() { return new RoomNumberRequest(this.id, this.name, this.number, this.roomId, this.roomTypeId, this.roomTypeCode, this.note, this.allowUsers, this.status, this.createdAt, this.updatedAt); } public String toString() { return "RoomNumberRequest.RoomNumberRequestBuilder(id=" + this.id + ", name=" + this.name + ", number=" + this.number + ", roomId=" + this.roomId + ", roomTypeId=" + this.roomTypeId + ", roomTypeCode=" + this.roomTypeCode + ", note=" + this.note + ", allowUsers=" + this.allowUsers + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\RoomNumberRequest$RoomNumberRequestBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */