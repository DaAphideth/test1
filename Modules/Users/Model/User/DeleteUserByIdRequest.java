/*   */ package nencer.app.Modules.Users.Model.User;
/*   */ public class DeleteUserByIdRequest {
/*   */   private Long id;
/*   */   
/* 5 */   public String toString() { return "DeleteUserByIdRequest(id=" + getId() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); return result * 59 + (($id == null) ? 43 : $id.hashCode()); } protected boolean canEqual(Object other) { return other instanceof DeleteUserByIdRequest; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DeleteUserByIdRequest)) return false;  DeleteUserByIdRequest other = (DeleteUserByIdRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); return !((this$id == null) ? (other$id != null) : !this$id.equals(other$id)); } public void setId(Long id) { this.id = id; }
/*   */    public Long getId() {
/* 7 */     return this.id;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\DeleteUserByIdRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */