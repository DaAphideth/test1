/*   */ package nencer.app.Modules.Medic.Model.Checkin;
/*   */ public class RoomNumberResponse {
/*   */   private int id;
/*   */   
/* 5 */   public void setId(int id) { this.id = id; } private String name; private String number; public void setName(String name) { this.name = name; } public void setNumber(String number) { this.number = number; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof RoomNumberResponse)) return false;  RoomNumberResponse other = (RoomNumberResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$number = getNumber(), other$number = other.getNumber(); return !((this$number == null) ? (other$number != null) : !this$number.equals(other$number)); } protected boolean canEqual(Object other) { return other instanceof RoomNumberResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $number = getNumber(); return result * 59 + (($number == null) ? 43 : $number.hashCode()); } public String toString() { return "RoomNumberResponse(id=" + getId() + ", name=" + getName() + ", number=" + getNumber() + ")"; }
/*   */   
/* 7 */   public int getId() { return this.id; }
/* 8 */   public String getName() { return this.name; } public String getNumber() {
/* 9 */     return this.number;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Checkin\RoomNumberResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */