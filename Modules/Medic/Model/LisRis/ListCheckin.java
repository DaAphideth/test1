/*   */ package nencer.app.Modules.Medic.Model.LisRis;
/*   */ public class ListCheckin {
/*   */   private String roomSampleBy;
/*   */   
/* 5 */   public String toString() { return "ListCheckin(roomSampleBy=" + getRoomSampleBy() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $roomSampleBy = getRoomSampleBy(); return result * 59 + (($roomSampleBy == null) ? 43 : $roomSampleBy.hashCode()); } protected boolean canEqual(Object other) { return other instanceof ListCheckin; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ListCheckin)) return false;  ListCheckin other = (ListCheckin)o; if (!other.canEqual(this)) return false;  Object this$roomSampleBy = getRoomSampleBy(), other$roomSampleBy = other.getRoomSampleBy(); return !((this$roomSampleBy == null) ? (other$roomSampleBy != null) : !this$roomSampleBy.equals(other$roomSampleBy)); } public void setRoomSampleBy(String roomSampleBy) { this.roomSampleBy = roomSampleBy; }
/*   */    public String getRoomSampleBy() {
/* 7 */     return this.roomSampleBy;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\LisRis\ListCheckin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */