/*    */ package nencer.app.Modules.Medic.Model.Service;
/*    */ 
/*    */ public class ServiceGroupResponse {
/*    */   private int id;
/*    */   private Integer code;
/*    */   private String codeName;
/*    */   private String name;
/*    */   private Integer status;
/*    */   
/* 10 */   public void setId(int id) { this.id = id; } private Integer sort; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public void setCode(Integer code) { this.code = code; } public void setCodeName(String codeName) { this.codeName = codeName; } public void setName(String name) { this.name = name; } public void setStatus(Integer status) { this.status = status; } public void setSort(Integer sort) { this.sort = sort; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ServiceGroupResponse)) return false;  ServiceGroupResponse other = (ServiceGroupResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$codeName = getCodeName(), other$codeName = other.getCodeName(); if ((this$codeName == null) ? (other$codeName != null) : !this$codeName.equals(other$codeName)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof ServiceGroupResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $codeName = getCodeName(); result = result * 59 + (($codeName == null) ? 43 : $codeName.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "ServiceGroupResponse(id=" + getId() + ", code=" + getCode() + ", codeName=" + getCodeName() + ", name=" + getName() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public ServiceGroupResponse() {} public ServiceGroupResponse(int id, Integer code, String codeName, String name, Integer status, Integer sort, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) {
/* 12 */     this.id = id; this.code = code; this.codeName = codeName; this.name = name; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis;
/*    */   }
/* 14 */   public int getId() { return this.id; }
/* 15 */   public Integer getCode() { return this.code; }
/* 16 */   public String getCodeName() { return this.codeName; }
/* 17 */   public String getName() { return this.name; }
/* 18 */   public Integer getStatus() { return this.status; }
/* 19 */   public Integer getSort() { return this.sort; }
/* 20 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 21 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 27 */     if (this.updatedAt == null) return ""; 
/* 28 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 32 */     if (this.createdAt == null) return ""; 
/* 33 */     return ApiHelper.dateToString(this.createdAt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Service\ServiceGroupResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */