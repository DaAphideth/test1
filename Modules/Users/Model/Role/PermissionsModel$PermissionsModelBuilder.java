/*    */ package nencer.app.Modules.Users.Model.Role;
/*    */ 
/*    */ public class PermissionsModelBuilder {
/*    */   private Long perId;
/*    */   private String perName;
/*    */   private String perType;
/*    */   private String description;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   
/* 11 */   public PermissionsModelBuilder perId(Long perId) { this.perId = perId; return this; } private String perCode; private Integer status; private Integer perMenu; private String perMenuCode; private Integer totalRecord; private List<PermissionsModel> childPermissions; public PermissionsModelBuilder perName(String perName) { this.perName = perName; return this; } public PermissionsModelBuilder perType(String perType) { this.perType = perType; return this; } public PermissionsModelBuilder description(String description) { this.description = description; return this; } public PermissionsModelBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public PermissionsModelBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public PermissionsModelBuilder perCode(String perCode) { this.perCode = perCode; return this; } public PermissionsModelBuilder status(Integer status) { this.status = status; return this; } public PermissionsModelBuilder perMenu(Integer perMenu) { this.perMenu = perMenu; return this; } public PermissionsModelBuilder perMenuCode(String perMenuCode) { this.perMenuCode = perMenuCode; return this; } public PermissionsModelBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public PermissionsModelBuilder childPermissions(List<PermissionsModel> childPermissions) { this.childPermissions = childPermissions; return this; } public PermissionsModel build() { return new PermissionsModel(this.perId, this.perName, this.perType, this.description, this.createdAt, this.updatedAt, this.perCode, this.status, this.perMenu, this.perMenuCode, this.totalRecord, this.childPermissions); } public String toString() { return "PermissionsModel.PermissionsModelBuilder(perId=" + this.perId + ", perName=" + this.perName + ", perType=" + this.perType + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", perCode=" + this.perCode + ", status=" + this.status + ", perMenu=" + this.perMenu + ", perMenuCode=" + this.perMenuCode + ", totalRecord=" + this.totalRecord + ", childPermissions=" + this.childPermissions + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Role\PermissionsModel$PermissionsModelBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */