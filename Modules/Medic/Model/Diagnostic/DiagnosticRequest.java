/*    */ package nencer.app.Modules.Medic.Model.Diagnostic;
/*    */ 
/*    */ 
/*    */ public class DiagnosticRequest {
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   
/*  9 */   public void setId(int id) { this.id = id; } private String nameEn; private Integer status; private Date createdAt; private Date updatedAt; public void setCode(String code) { this.code = code; } public void setName(String name) { this.name = name; } public void setNameEn(String nameEn) { this.nameEn = nameEn; } public void setStatus(Integer status) { this.status = status; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DiagnosticRequest)) return false;  DiagnosticRequest other = (DiagnosticRequest)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameEn = getNameEn(), other$nameEn = other.getNameEn(); if ((this$nameEn == null) ? (other$nameEn != null) : !this$nameEn.equals(other$nameEn)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof DiagnosticRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameEn = getNameEn(); result = result * 59 + (($nameEn == null) ? 43 : $nameEn.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "DiagnosticRequest(id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public DiagnosticRequest() {} public DiagnosticRequest(int id, String code, String name, String nameEn, Integer status, Date createdAt, Date updatedAt) {
/* 11 */     this.id = id; this.code = code; this.name = name; this.nameEn = nameEn; this.status = status; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   }
/* 13 */   public int getId() { return this.id; }
/* 14 */   public String getCode() { return this.code; }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getNameEn() { return this.nameEn; }
/* 17 */   public Integer getStatus() { return this.status; }
/* 18 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 19 */     return this.updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Diagnostic\DiagnosticRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */