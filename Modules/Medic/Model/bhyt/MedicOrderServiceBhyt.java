/*    */ package nencer.app.Modules.Medic.Model.bhyt;
/*    */ 
/*    */ import javax.validation.constraints.NotNull;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicOrderServiceBhyt {
/*    */   @NotNull(message = "804")
/*    */   private Integer id;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } @NotNull(message = "804") private String serviceObjectCode; @NotNull(message = "804") private Integer serviceGroupId; public void setServiceObjectCode(String serviceObjectCode) { this.serviceObjectCode = serviceObjectCode; } public void setServiceGroupId(Integer serviceGroupId) { this.serviceGroupId = serviceGroupId; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicOrderServiceBhyt)) return false;  MedicOrderServiceBhyt other = (MedicOrderServiceBhyt)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$serviceObjectCode = getServiceObjectCode(), other$serviceObjectCode = other.getServiceObjectCode(); if ((this$serviceObjectCode == null) ? (other$serviceObjectCode != null) : !this$serviceObjectCode.equals(other$serviceObjectCode)) return false;  Object this$serviceGroupId = getServiceGroupId(), other$serviceGroupId = other.getServiceGroupId(); return !((this$serviceGroupId == null) ? (other$serviceGroupId != null) : !this$serviceGroupId.equals(other$serviceGroupId)); } protected boolean canEqual(Object other) { return other instanceof MedicOrderServiceBhyt; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $serviceObjectCode = getServiceObjectCode(); result = result * 59 + (($serviceObjectCode == null) ? 43 : $serviceObjectCode.hashCode()); Object $serviceGroupId = getServiceGroupId(); return result * 59 + (($serviceGroupId == null) ? 43 : $serviceGroupId.hashCode()); } public String toString() { return "MedicOrderServiceBhyt(id=" + getId() + ", serviceObjectCode=" + getServiceObjectCode() + ", serviceGroupId=" + getServiceGroupId() + ")"; }
/*    */    public MedicOrderServiceBhyt() {} public MedicOrderServiceBhyt(Integer id, String serviceObjectCode, Integer serviceGroupId) {
/* 12 */     this.id = id; this.serviceObjectCode = serviceObjectCode; this.serviceGroupId = serviceGroupId;
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 16 */     return this.id;
/*    */   } public String getServiceObjectCode() {
/* 18 */     return this.serviceObjectCode;
/*    */   } public Integer getServiceGroupId() {
/* 20 */     return this.serviceGroupId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\bhyt\MedicOrderServiceBhyt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */