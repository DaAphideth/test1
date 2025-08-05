/*   */ package nencer.app.Modules.Report.Model;
/*   */ public class TicketInfoModel { private String serviceGroupCode;
/*   */   private String id;
/*   */   
/* 5 */   public void setServiceGroupCode(String serviceGroupCode) { this.serviceGroupCode = serviceGroupCode; } public void setId(String id) { this.id = id; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TicketInfoModel)) return false;  TicketInfoModel other = (TicketInfoModel)o; if (!other.canEqual(this)) return false;  Object this$serviceGroupCode = getServiceGroupCode(), other$serviceGroupCode = other.getServiceGroupCode(); if ((this$serviceGroupCode == null) ? (other$serviceGroupCode != null) : !this$serviceGroupCode.equals(other$serviceGroupCode)) return false;  Object this$id = getId(), other$id = other.getId(); return !((this$id == null) ? (other$id != null) : !this$id.equals(other$id)); } protected boolean canEqual(Object other) { return other instanceof TicketInfoModel; } public int hashCode() { int PRIME = 59; result = 1; Object $serviceGroupCode = getServiceGroupCode(); result = result * 59 + (($serviceGroupCode == null) ? 43 : $serviceGroupCode.hashCode()); Object $id = getId(); return result * 59 + (($id == null) ? 43 : $id.hashCode()); } public String toString() { return "TicketInfoModel(serviceGroupCode=" + getServiceGroupCode() + ", id=" + getId() + ")"; }
/*   */   
/* 7 */   public String getServiceGroupCode() { return this.serviceGroupCode; } public String getId() {
/* 8 */     return this.id;
/*   */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\TicketInfoModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */