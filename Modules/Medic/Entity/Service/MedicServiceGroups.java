/*     */ package nencer.app.Modules.Medic.Entity.Service;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_service_groups")
/*     */ public class MedicServiceGroups {
/*     */   private int id;
/*     */   private Integer code;
/*     */   private String codeName;
/*     */   private String name;
/*     */   private Integer status;
/*     */   private Integer sort;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*  16 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicServiceGroups)) return false;  MedicServiceGroups other = (MedicServiceGroups)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$codeName = getCodeName(), other$codeName = other.getCodeName(); if ((this$codeName == null) ? (other$codeName != null) : !this$codeName.equals(other$codeName)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof MedicServiceGroups; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $codeName = getCodeName(); result = result * 59 + (($codeName == null) ? 43 : $codeName.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "MedicServiceGroups(id=" + getId() + ", code=" + getCode() + ", codeName=" + getCodeName() + ", name=" + getName() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*     */    public MedicServiceGroups() {} public MedicServiceGroups(int id, Integer code, String codeName, String name, Integer status, Integer sort, Date createdAt, Date updatedAt) {
/*  18 */     this.id = id; this.code = code; this.codeName = codeName; this.name = name; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*     */   }
/*  20 */   public static MedicServiceGroupsBuilder builder() { return new MedicServiceGroupsBuilder(); } public static class MedicServiceGroupsBuilder { private int id; private Integer code; private String codeName; private String name; public MedicServiceGroupsBuilder id(int id) { this.id = id; return this; } private Integer status; private Integer sort; private Date createdAt; private Date updatedAt; public MedicServiceGroupsBuilder code(Integer code) { this.code = code; return this; } public MedicServiceGroupsBuilder codeName(String codeName) { this.codeName = codeName; return this; } public MedicServiceGroupsBuilder name(String name) { this.name = name; return this; } public MedicServiceGroupsBuilder status(Integer status) { this.status = status; return this; } public MedicServiceGroupsBuilder sort(Integer sort) { this.sort = sort; return this; } public MedicServiceGroupsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicServiceGroupsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicServiceGroups build() { return new MedicServiceGroups(this.id, this.code, this.codeName, this.name, this.status, this.sort, this.createdAt, this.updatedAt); } public String toString() { return "MedicServiceGroups.MedicServiceGroupsBuilder(id=" + this.id + ", code=" + this.code + ", codeName=" + this.codeName + ", name=" + this.name + ", status=" + this.status + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  35 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  39 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name")
/*     */   public String getCodeName() {
/*  45 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setCodeName(String name) {
/*  49 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  55 */     return this.codeName;
/*     */   }
/*     */   
/*     */   public void setName(String codeName) {
/*  59 */     this.codeName = codeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  65 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  69 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  75 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  79 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  85 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  89 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/*  95 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/*  99 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public Integer getCode() {
/* 105 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(Integer code) {
/* 109 */     this.code = code;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicServiceGroups.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */