/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RoomNumberResponseBuilder
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private String number;
/*    */   private int roomId;
/*    */   private String note;
/*    */   
/*    */   public RoomNumberResponseBuilder id(int id) {
/* 14 */     this.id = id; return this; } private String allowUsers; private Integer status; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public RoomNumberResponseBuilder name(String name) { this.name = name; return this; } public RoomNumberResponseBuilder number(String number) { this.number = number; return this; } public RoomNumberResponseBuilder roomId(int roomId) { this.roomId = roomId; return this; } public RoomNumberResponseBuilder note(String note) { this.note = note; return this; } public RoomNumberResponseBuilder allowUsers(String allowUsers) { this.allowUsers = allowUsers; return this; } public RoomNumberResponseBuilder status(Integer status) { this.status = status; return this; } public RoomNumberResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RoomNumberResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RoomNumberResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public RoomNumberResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public RoomNumberResponse build() { return new RoomNumberResponse(this.id, this.name, this.number, this.roomId, this.note, this.allowUsers, this.status, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "RoomNumberResponse.RoomNumberResponseBuilder(id=" + this.id + ", name=" + this.name + ", number=" + this.number + ", roomId=" + this.roomId + ", note=" + this.note + ", allowUsers=" + this.allowUsers + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\RoomNumberResponse$RoomNumberResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */