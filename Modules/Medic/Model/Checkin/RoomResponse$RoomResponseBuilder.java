/*   */ package nencer.app.Modules.Medic.Model.Checkin;
/*   */ 
/*   */ public class RoomResponseBuilder {
/*   */   private int id;
/*   */   private String name;
/*   */   private String code;
/*   */   
/* 8 */   public RoomResponseBuilder id(int id) { this.id = id; return this; } public RoomResponseBuilder name(String name) { this.name = name; return this; } public RoomResponseBuilder code(String code) { this.code = code; return this; } public RoomResponse build() { return new RoomResponse(this.id, this.name, this.code); } public String toString() { return "RoomResponse.RoomResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ")"; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Checkin\RoomResponse$RoomResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */