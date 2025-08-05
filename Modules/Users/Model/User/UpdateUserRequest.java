/*   */ package nencer.app.Modules.Users.Model.User;
/*   */ public class UpdateUserRequest {
/*   */   private String lastSessionId;
/*   */   
/* 5 */   public String toString() { return "UpdateUserRequest(lastSessionId=" + getLastSessionId() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $lastSessionId = getLastSessionId(); return result * 59 + (($lastSessionId == null) ? 43 : $lastSessionId.hashCode()); } protected boolean canEqual(Object other) { return other instanceof UpdateUserRequest; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof UpdateUserRequest)) return false;  UpdateUserRequest other = (UpdateUserRequest)o; if (!other.canEqual(this)) return false;  Object this$lastSessionId = getLastSessionId(), other$lastSessionId = other.getLastSessionId(); return !((this$lastSessionId == null) ? (other$lastSessionId != null) : !this$lastSessionId.equals(other$lastSessionId)); } public void setLastSessionId(String lastSessionId) { this.lastSessionId = lastSessionId; }
/*   */    public String getLastSessionId() {
/* 7 */     return this.lastSessionId;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\UpdateUserRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */