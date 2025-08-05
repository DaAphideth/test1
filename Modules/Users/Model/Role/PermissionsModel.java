/*    */ package nencer.app.Modules.Users.Model.Role;public class PermissionsModel { private Long perId; private String perName; private String perType; private String description; private Date createdAt; private Date updatedAt; private String perCode;
/*    */   private Integer status;
/*    */   private Integer perMenu;
/*    */   private String perMenuCode;
/*    */   private Integer totalRecord;
/*    */   private List<PermissionsModel> childPermissions;
/*    */   
/*    */   public PermissionsModel() {}
/*    */   
/* 10 */   public PermissionsModel(Long perId, String perName, String perType, String description, Date createdAt, Date updatedAt, String perCode, Integer status, Integer perMenu, String perMenuCode, Integer totalRecord, List<PermissionsModel> childPermissions) { this.perId = perId; this.perName = perName; this.perType = perType; this.description = description; this.createdAt = createdAt; this.updatedAt = updatedAt; this.perCode = perCode; this.status = status; this.perMenu = perMenu; this.perMenuCode = perMenuCode; this.totalRecord = totalRecord; this.childPermissions = childPermissions; }
/* 11 */   public static PermissionsModelBuilder builder() { return new PermissionsModelBuilder(); } public static class PermissionsModelBuilder { private Long perId; private String perName; private String perType; private String description; private Date createdAt; private Date updatedAt; public PermissionsModelBuilder perId(Long perId) { this.perId = perId; return this; } private String perCode; private Integer status; private Integer perMenu; private String perMenuCode; private Integer totalRecord; private List<PermissionsModel> childPermissions; public PermissionsModelBuilder perName(String perName) { this.perName = perName; return this; } public PermissionsModelBuilder perType(String perType) { this.perType = perType; return this; } public PermissionsModelBuilder description(String description) { this.description = description; return this; } public PermissionsModelBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public PermissionsModelBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public PermissionsModelBuilder perCode(String perCode) { this.perCode = perCode; return this; } public PermissionsModelBuilder status(Integer status) { this.status = status; return this; } public PermissionsModelBuilder perMenu(Integer perMenu) { this.perMenu = perMenu; return this; } public PermissionsModelBuilder perMenuCode(String perMenuCode) { this.perMenuCode = perMenuCode; return this; } public PermissionsModelBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public PermissionsModelBuilder childPermissions(List<PermissionsModel> childPermissions) { this.childPermissions = childPermissions; return this; } public PermissionsModel build() { return new PermissionsModel(this.perId, this.perName, this.perType, this.description, this.createdAt, this.updatedAt, this.perCode, this.status, this.perMenu, this.perMenuCode, this.totalRecord, this.childPermissions); } public String toString() { return "PermissionsModel.PermissionsModelBuilder(perId=" + this.perId + ", perName=" + this.perName + ", perType=" + this.perType + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", perCode=" + this.perCode + ", status=" + this.status + ", perMenu=" + this.perMenu + ", perMenuCode=" + this.perMenuCode + ", totalRecord=" + this.totalRecord + ", childPermissions=" + this.childPermissions + ")"; } }
/* 12 */   public void setPerId(Long perId) { this.perId = perId; } public void setPerName(String perName) { this.perName = perName; } public void setPerType(String perType) { this.perType = perType; } public void setDescription(String description) { this.description = description; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setPerCode(String perCode) { this.perCode = perCode; } public void setStatus(Integer status) { this.status = status; } public void setPerMenu(Integer perMenu) { this.perMenu = perMenu; } public void setPerMenuCode(String perMenuCode) { this.perMenuCode = perMenuCode; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public void setChildPermissions(List<PermissionsModel> childPermissions) { this.childPermissions = childPermissions; }
/*    */ 
/*    */   
/*    */   public Long getPerId() {
/* 16 */     return this.perId;
/* 17 */   } public String getPerName() { return this.perName; }
/* 18 */   public String getPerType() { return this.perType; }
/* 19 */   public String getDescription() { return this.description; }
/* 20 */   public Date getCreatedAt() { return this.createdAt; }
/* 21 */   public Date getUpdatedAt() { return this.updatedAt; }
/* 22 */   public String getPerCode() { return this.perCode; }
/* 23 */   public Integer getStatus() { return this.status; }
/* 24 */   public Integer getPerMenu() { return this.perMenu; }
/* 25 */   public String getPerMenuCode() { return this.perMenuCode; } public Integer getTotalRecord() {
/* 26 */     return this.totalRecord;
/*    */   } public List<PermissionsModel> getChildPermissions() {
/* 28 */     return this.childPermissions;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Role\PermissionsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */