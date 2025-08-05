/*    */ package nencer.app.Modules.Users.Model.User;
/*    */ 
/*    */ public class GetUserByRequest {
/*    */   @NotNull(message = "Required Parameter: Account Identifier.")
/*    */   private String id;
/*    */   
/*  7 */   public void setId(String id) { this.id = id; } private String userName; public void setUserName(String userName) { this.userName = userName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GetUserByRequest)) return false;  GetUserByRequest other = (GetUserByRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$userName = getUserName(), other$userName = other.getUserName(); return !((this$userName == null) ? (other$userName != null) : !this$userName.equals(other$userName)); } protected boolean canEqual(Object other) { return other instanceof GetUserByRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $userName = getUserName(); return result * 59 + (($userName == null) ? 43 : $userName.hashCode()); } public String toString() { return "GetUserByRequest(id=" + getId() + ", userName=" + getUserName() + ")"; }
/*    */ 
/*    */   
/* 10 */   public String getId() { return this.id; } public String getUserName() {
/* 11 */     return this.userName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\User\GetUserByRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */