/*    */ package nencer.app.Modules.Medic.Model.Service;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import javax.validation.constraints.NotNull;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class ServiceTypeRequest {
/*    */   private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   private String nameArray;
/*    */   
/*    */   public void setId(Integer id) {
/* 14 */     this.id = id; } private Integer serviceGroupId; private String code; private Integer status; private Integer sort; public void setName(String name) { this.name = name; } public void setNameArray(String nameArray) { this.nameArray = nameArray; } public void setServiceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; } public void setCode(String code) { this.code = code; } public void setStatus(Integer status) { this.status = status; } public void setSort(Integer sort) { this.sort = sort; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ServiceTypeRequest)) return false;  ServiceTypeRequest other = (ServiceTypeRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameArray = getNameArray(), other$nameArray = other.getNameArray(); if ((this$nameArray == null) ? (other$nameArray != null) : !this$nameArray.equals(other$nameArray)) return false;  Object this$serviceGroupId = getServiceGroupId(), other$serviceGroupId = other.getServiceGroupId(); if ((this$serviceGroupId == null) ? (other$serviceGroupId != null) : !this$serviceGroupId.equals(other$serviceGroupId)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); return !((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)); } protected boolean canEqual(Object other) { return other instanceof ServiceTypeRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameArray = getNameArray(); result = result * 59 + (($nameArray == null) ? 43 : $nameArray.hashCode()); Object $serviceGroupId = getServiceGroupId(); result = result * 59 + (($serviceGroupId == null) ? 43 : $serviceGroupId.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); return result * 59 + (($sort == null) ? 43 : $sort.hashCode()); } public String toString() { return "ServiceTypeRequest(id=" + getId() + ", name=" + getName() + ", nameArray=" + getNameArray() + ", serviceGroupId=" + getServiceGroupId() + ", code=" + getCode() + ", status=" + getStatus() + ", sort=" + getSort() + ")"; }
/*    */    public ServiceTypeRequest() {} public ServiceTypeRequest(Integer id, String name, String nameArray, Integer serviceGroupId, String code, Integer status, Integer sort) {
/* 16 */     this.id = id; this.name = name; this.nameArray = nameArray; this.serviceGroupId = serviceGroupId; this.code = code; this.status = status; this.sort = sort;
/*    */   }
/*    */   public Integer getId() {
/* 19 */     return this.id;
/*    */   }
/* 21 */   public String getName() { return this.name; }
/* 22 */   public String getNameArray() { return this.nameArray; }
/* 23 */   public Integer getServiceGroupId() { return this.serviceGroupId; }
/* 24 */   public String getCode() { return this.code; }
/* 25 */   public Integer getStatus() { return this.status; } public Integer getSort() {
/* 26 */     return this.sort;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Service\ServiceTypeRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */