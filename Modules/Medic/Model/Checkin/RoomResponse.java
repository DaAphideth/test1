/*    */ package nencer.app.Modules.Medic.Model.Checkin;
/*    */ public class RoomResponse {
/*    */   private int id;
/*    */   private String name;
/*    */   private String code;
/*    */   
/*  7 */   public void setId(int id) { this.id = id; } public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof RoomResponse)) return false;  RoomResponse other = (RoomResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); return !((this$code == null) ? (other$code != null) : !this$code.equals(other$code)); } protected boolean canEqual(Object other) { return other instanceof RoomResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); return result * 59 + (($code == null) ? 43 : $code.hashCode()); } public String toString() { return "RoomResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ")"; }
/*  8 */   public static RoomResponseBuilder builder() { return new RoomResponseBuilder(); } public static class RoomResponseBuilder { private int id; public RoomResponseBuilder id(int id) { this.id = id; return this; } private String name; private String code; public RoomResponseBuilder name(String name) { this.name = name; return this; } public RoomResponseBuilder code(String code) { this.code = code; return this; } public RoomResponse build() { return new RoomResponse(this.id, this.name, this.code); } public String toString() { return "RoomResponse.RoomResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ")"; } } public RoomResponse(int id, String name, String code) {
/*  9 */     this.id = id; this.name = name; this.code = code;
/*    */   }
/* 11 */   public int getId() { return this.id; }
/* 12 */   public String getName() { return this.name; } public String getCode() {
/* 13 */     return this.code;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Checkin\RoomResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */