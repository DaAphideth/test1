/*    */ package nencer.app.Modules.Medic.Model.Service;
/*    */ 
/*    */ public class ServiceGroupRequest {
/*    */   private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private Integer code;
/*    */   @NotNull(message = "804")
/*    */   private String codeName;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } private String name; private Integer status; private Integer sort; public void setCode(Integer code) { this.code = code; } public void setCodeName(String codeName) { this.codeName = codeName; } public void setName(String name) { this.name = name; } public void setStatus(Integer status) { this.status = status; } public void setSort(Integer sort) { this.sort = sort; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ServiceGroupRequest)) return false;  ServiceGroupRequest other = (ServiceGroupRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$codeName = getCodeName(), other$codeName = other.getCodeName(); if ((this$codeName == null) ? (other$codeName != null) : !this$codeName.equals(other$codeName)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); return !((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)); } protected boolean canEqual(Object other) { return other instanceof ServiceGroupRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $codeName = getCodeName(); result = result * 59 + (($codeName == null) ? 43 : $codeName.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); return result * 59 + (($sort == null) ? 43 : $sort.hashCode()); } public String toString() { return "ServiceGroupRequest(id=" + getId() + ", code=" + getCode() + ", codeName=" + getCodeName() + ", name=" + getName() + ", status=" + getStatus() + ", sort=" + getSort() + ")"; }
/*    */    public ServiceGroupRequest() {} public ServiceGroupRequest(Integer id, Integer code, String codeName, String name, Integer status, Integer sort) {
/* 12 */     this.id = id; this.code = code; this.codeName = codeName; this.name = name; this.status = status; this.sort = sort;
/*    */   } public Integer getId() {
/* 14 */     return this.id;
/*    */   } public Integer getCode() {
/* 16 */     return this.code;
/*    */   }
/* 18 */   public String getCodeName() { return this.codeName; }
/* 19 */   public String getName() { return this.name; }
/* 20 */   public Integer getStatus() { return this.status; } public Integer getSort() {
/* 21 */     return this.sort;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Service\ServiceGroupRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */