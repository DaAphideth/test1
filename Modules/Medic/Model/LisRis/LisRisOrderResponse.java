/*    */ package nencer.app.Modules.Medic.Model.LisRis;
/*    */ 
/*    */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*    */ import nencer.app.Modules.Medic.Entity.Service.MedicOrderServicesExt;
/*    */ 
/*    */ public class LisRisOrderResponse extends MedicOrderServices {
/*    */   private List<MedicOrderServicesExt> medicOrderServicesExtList;
/*    */   private MedicTicket medicTicket;
/*    */   
/* 10 */   public void setMedicOrderServicesExtList(List<MedicOrderServicesExt> medicOrderServicesExtList) { this.medicOrderServicesExtList = medicOrderServicesExtList; } private String originalResult; private String statusResult; public void setMedicTicket(MedicTicket medicTicket) { this.medicTicket = medicTicket; } public void setOriginalResult(String originalResult) { this.originalResult = originalResult; } public void setStatusResult(String statusResult) { this.statusResult = statusResult; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LisRisOrderResponse)) return false;  LisRisOrderResponse other = (LisRisOrderResponse)o; if (!other.canEqual(this)) return false;  Object<MedicOrderServicesExt> this$medicOrderServicesExtList = (Object<MedicOrderServicesExt>)getMedicOrderServicesExtList(), other$medicOrderServicesExtList = (Object<MedicOrderServicesExt>)other.getMedicOrderServicesExtList(); if ((this$medicOrderServicesExtList == null) ? (other$medicOrderServicesExtList != null) : !this$medicOrderServicesExtList.equals(other$medicOrderServicesExtList)) return false;  Object this$medicTicket = getMedicTicket(), other$medicTicket = other.getMedicTicket(); if ((this$medicTicket == null) ? (other$medicTicket != null) : !this$medicTicket.equals(other$medicTicket)) return false;  Object this$originalResult = getOriginalResult(), other$originalResult = other.getOriginalResult(); if ((this$originalResult == null) ? (other$originalResult != null) : !this$originalResult.equals(other$originalResult)) return false;  Object this$statusResult = getStatusResult(), other$statusResult = other.getStatusResult(); return !((this$statusResult == null) ? (other$statusResult != null) : !this$statusResult.equals(other$statusResult)); } protected boolean canEqual(Object other) { return other instanceof LisRisOrderResponse; } public int hashCode() { int PRIME = 59; result = 1; Object<MedicOrderServicesExt> $medicOrderServicesExtList = (Object<MedicOrderServicesExt>)getMedicOrderServicesExtList(); result = result * 59 + (($medicOrderServicesExtList == null) ? 43 : $medicOrderServicesExtList.hashCode()); Object $medicTicket = getMedicTicket(); result = result * 59 + (($medicTicket == null) ? 43 : $medicTicket.hashCode()); Object $originalResult = getOriginalResult(); result = result * 59 + (($originalResult == null) ? 43 : $originalResult.hashCode()); Object $statusResult = getStatusResult(); return result * 59 + (($statusResult == null) ? 43 : $statusResult.hashCode()); } public String toString() { return "LisRisOrderResponse(medicOrderServicesExtList=" + getMedicOrderServicesExtList() + ", medicTicket=" + getMedicTicket() + ", originalResult=" + getOriginalResult() + ", statusResult=" + getStatusResult() + ")"; }
/*    */   
/* 12 */   public List<MedicOrderServicesExt> getMedicOrderServicesExtList() { return this.medicOrderServicesExtList; } public MedicTicket getMedicTicket() {
/* 13 */     return this.medicTicket;
/*    */   }
/* 15 */   public String getOriginalResult() { return this.originalResult; } public String getStatusResult() {
/* 16 */     return this.statusResult;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\LisRis\LisRisOrderResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */