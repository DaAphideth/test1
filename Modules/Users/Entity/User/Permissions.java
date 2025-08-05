/*    */ package nencer.app.Modules.Users.Entity.User;@Entity @Table(name = "permissions") public class Permissions { @Id
/*    */   @Column(name = "per_id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer perId; @Basic
/*    */   @Column(name = "per_name")
/*    */   private String perName; @Basic
/*    */   @Column(name = "per_type")
/*    */   private String perType; @Basic
/*    */   @Column(name = "description")
/*    */   private String description; @Basic
/*    */   @Column(name = "created_at")
/* 12 */   private Date createdAt; public void setPerId(Integer perId) { this.perId = perId; } @Basic @Column(name = "updated_at") private Date updatedAt; @Basic @Column(name = "per_code") private String perCode; @Column(name = "status") private Integer status; @Column(name = "per_menu") private Integer perMenu; @Transient private Integer totalRecord; public void setPerName(String perName) { this.perName = perName; } public void setPerType(String perType) { this.perType = perType; } public void setDescription(String description) { this.description = description; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setPerCode(String perCode) { this.perCode = perCode; } public void setStatus(Integer status) { this.status = status; } public void setPerMenu(Integer perMenu) { this.perMenu = perMenu; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; }
/*    */    public Permissions() {}
/* 14 */   public Permissions(Integer perId, String perName, String perType, String description, Date createdAt, Date updatedAt, String perCode, Integer status, Integer perMenu, Integer totalRecord) { this.perId = perId; this.perName = perName; this.perType = perType; this.description = description; this.createdAt = createdAt; this.updatedAt = updatedAt; this.perCode = perCode; this.status = status; this.perMenu = perMenu; this.totalRecord = totalRecord; }
/* 15 */   public static PermissionsBuilder builder() { return new PermissionsBuilder(); } public static class PermissionsBuilder { private Integer perId; private String perName; private String perType; private String description; private Date createdAt; private Date updatedAt; private String perCode; private Integer status; private Integer perMenu; private Integer totalRecord; public PermissionsBuilder perId(Integer perId) { this.perId = perId; return this; } public PermissionsBuilder perName(String perName) { this.perName = perName; return this; } public PermissionsBuilder perType(String perType) { this.perType = perType; return this; } public PermissionsBuilder description(String description) { this.description = description; return this; } public PermissionsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public PermissionsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public PermissionsBuilder perCode(String perCode) { this.perCode = perCode; return this; } public PermissionsBuilder status(Integer status) { this.status = status; return this; } public PermissionsBuilder perMenu(Integer perMenu) { this.perMenu = perMenu; return this; } public PermissionsBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public Permissions build() { return new Permissions(this.perId, this.perName, this.perType, this.description, this.createdAt, this.updatedAt, this.perCode, this.status, this.perMenu, this.totalRecord); } public String toString() { return "Permissions.PermissionsBuilder(perId=" + this.perId + ", perName=" + this.perName + ", perType=" + this.perType + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", perCode=" + this.perCode + ", status=" + this.status + ", perMenu=" + this.perMenu + ", totalRecord=" + this.totalRecord + ")"; }
/*    */      }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getPerId() {
/* 22 */     return this.perId;
/*    */   }
/*    */   
/*    */   public String getPerName() {
/* 26 */     return this.perName;
/*    */   }
/*    */   
/*    */   public String getPerType() {
/* 30 */     return this.perType;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 34 */     return this.description;
/*    */   }
/*    */   
/*    */   public Date getCreatedAt() {
/* 38 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public Date getUpdatedAt() {
/* 42 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public String getPerCode() {
/* 46 */     return this.perCode;
/*    */   }
/*    */   public Integer getStatus() {
/* 49 */     return this.status;
/*    */   }
/*    */   
/*    */   public Integer getPerMenu() {
/* 53 */     return this.perMenu;
/*    */   }
/*    */   public Integer getTotalRecord() {
/* 56 */     return this.totalRecord;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\Permissions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */