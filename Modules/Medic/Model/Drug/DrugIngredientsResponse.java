/*    */ package nencer.app.Modules.Medic.Model.Drug;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class DrugIngredientsResponse { private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   
/*  7 */   public void setId(int id) { this.id = id; } private Date createdAt; private Date updatedAt; private Integer totalRecord; public void setCode(String code) { this.code = code; } public void setName(String name) { this.name = name; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DrugIngredientsResponse)) return false;  DrugIngredientsResponse other = (DrugIngredientsResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } protected boolean canEqual(Object other) { return other instanceof DrugIngredientsResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "DrugIngredientsResponse(id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", totalRecord=" + getTotalRecord() + ")"; }
/*    */ 
/*    */   
/* 10 */   public int getId() { return this.id; }
/* 11 */   public String getCode() { return this.code; }
/* 12 */   public String getName() { return this.name; }
/* 13 */   public Date getCreatedAt() { return this.createdAt; }
/* 14 */   public Date getUpdatedAt() { return this.updatedAt; } public Integer getTotalRecord() {
/* 15 */     return this.totalRecord;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Drug\DrugIngredientsResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */