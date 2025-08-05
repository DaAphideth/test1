/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RoomTypeResponse {
/*    */   private int id;
/*    */   private String name;
/*    */   private String nameArray;
/*    */   private String code;
/*    */   private Integer status;
/*    */   
/* 12 */   public void setId(int id) { this.id = id; } private Integer sort; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public void setName(String name) { this.name = name; } public void setNameArray(String nameArray) { this.nameArray = nameArray; } public void setCode(String code) { this.code = code; } public void setStatus(Integer status) { this.status = status; } public void setSort(Integer sort) { this.sort = sort; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof RoomTypeResponse)) return false;  RoomTypeResponse other = (RoomTypeResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameArray = getNameArray(), other$nameArray = other.getNameArray(); if ((this$nameArray == null) ? (other$nameArray != null) : !this$nameArray.equals(other$nameArray)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$sort = getSort(), other$sort = other.getSort(); if ((this$sort == null) ? (other$sort != null) : !this$sort.equals(other$sort)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof RoomTypeResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameArray = getNameArray(); result = result * 59 + (($nameArray == null) ? 43 : $nameArray.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $sort = getSort(); result = result * 59 + (($sort == null) ? 43 : $sort.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "RoomTypeResponse(id=" + getId() + ", name=" + getName() + ", nameArray=" + getNameArray() + ", code=" + getCode() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public RoomTypeResponse() {} public RoomTypeResponse(int id, String name, String nameArray, String code, Integer status, Integer sort, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) {
/* 14 */     this.id = id; this.name = name; this.nameArray = nameArray; this.code = code; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis;
/*    */   }
/* 16 */   public int getId() { return this.id; }
/* 17 */   public String getName() { return this.name; }
/* 18 */   public String getNameArray() { return this.nameArray; }
/* 19 */   public String getCode() { return this.code; }
/* 20 */   public Integer getStatus() { return this.status; }
/* 21 */   public Integer getSort() { return this.sort; }
/* 22 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 23 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 29 */     if (this.updatedAt == null) return ""; 
/* 30 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 34 */     if (this.createdAt == null) return ""; 
/* 35 */     return ApiHelper.dateToString(this.createdAt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\RoomTypeResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */