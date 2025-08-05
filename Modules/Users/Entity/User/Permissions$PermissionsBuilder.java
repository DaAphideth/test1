/*    */ package nencer.app.Modules.Users.Entity.User;
/*    */ 
/*    */ public class PermissionsBuilder {
/*    */   private Integer perId;
/*    */   private String perName;
/*    */   private String perType;
/*    */   private String description;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   private String perCode;
/*    */   private Integer status;
/*    */   private Integer perMenu;
/*    */   private Integer totalRecord;
/*    */   
/* 15 */   public PermissionsBuilder perId(Integer perId) { this.perId = perId; return this; } public PermissionsBuilder perName(String perName) { this.perName = perName; return this; } public PermissionsBuilder perType(String perType) { this.perType = perType; return this; } public PermissionsBuilder description(String description) { this.description = description; return this; } public PermissionsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public PermissionsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public PermissionsBuilder perCode(String perCode) { this.perCode = perCode; return this; } public PermissionsBuilder status(Integer status) { this.status = status; return this; } public PermissionsBuilder perMenu(Integer perMenu) { this.perMenu = perMenu; return this; } public PermissionsBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public Permissions build() { return new Permissions(this.perId, this.perName, this.perType, this.description, this.createdAt, this.updatedAt, this.perCode, this.status, this.perMenu, this.totalRecord); } public String toString() { return "Permissions.PermissionsBuilder(perId=" + this.perId + ", perName=" + this.perName + ", perType=" + this.perType + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", perCode=" + this.perCode + ", status=" + this.status + ", perMenu=" + this.perMenu + ", totalRecord=" + this.totalRecord + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\Permissions$PermissionsBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */