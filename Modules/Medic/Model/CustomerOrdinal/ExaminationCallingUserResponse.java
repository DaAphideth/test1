/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class ExaminationCallingUserResponse {
/*    */   OrdinalDoorNumberResponse doctor;
/*    */   OrdinalDoorNumberResponse called;
/*    */   
/* 10 */   public void setDoctor(OrdinalDoorNumberResponse doctor) { this.doctor = doctor; } List<OrdinalDoorNumberResponse> waiting; List<OrdinalDoorNumberResponse> lisRis; public void setCalled(OrdinalDoorNumberResponse called) { this.called = called; } public void setWaiting(List<OrdinalDoorNumberResponse> waiting) { this.waiting = waiting; } public void setLisRis(List<OrdinalDoorNumberResponse> lisRis) { this.lisRis = lisRis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ExaminationCallingUserResponse)) return false;  ExaminationCallingUserResponse other = (ExaminationCallingUserResponse)o; if (!other.canEqual(this)) return false;  Object this$doctor = getDoctor(), other$doctor = other.getDoctor(); if ((this$doctor == null) ? (other$doctor != null) : !this$doctor.equals(other$doctor)) return false;  Object this$called = getCalled(), other$called = other.getCalled(); if ((this$called == null) ? (other$called != null) : !this$called.equals(other$called)) return false;  Object<OrdinalDoorNumberResponse> this$waiting = (Object<OrdinalDoorNumberResponse>)getWaiting(), other$waiting = (Object<OrdinalDoorNumberResponse>)other.getWaiting(); if ((this$waiting == null) ? (other$waiting != null) : !this$waiting.equals(other$waiting)) return false;  Object<OrdinalDoorNumberResponse> this$lisRis = (Object<OrdinalDoorNumberResponse>)getLisRis(), other$lisRis = (Object<OrdinalDoorNumberResponse>)other.getLisRis(); return !((this$lisRis == null) ? (other$lisRis != null) : !this$lisRis.equals(other$lisRis)); } protected boolean canEqual(Object other) { return other instanceof ExaminationCallingUserResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $doctor = getDoctor(); result = result * 59 + (($doctor == null) ? 43 : $doctor.hashCode()); Object $called = getCalled(); result = result * 59 + (($called == null) ? 43 : $called.hashCode()); Object<OrdinalDoorNumberResponse> $waiting = (Object<OrdinalDoorNumberResponse>)getWaiting(); result = result * 59 + (($waiting == null) ? 43 : $waiting.hashCode()); Object<OrdinalDoorNumberResponse> $lisRis = (Object<OrdinalDoorNumberResponse>)getLisRis(); return result * 59 + (($lisRis == null) ? 43 : $lisRis.hashCode()); } public String toString() { return "ExaminationCallingUserResponse(doctor=" + getDoctor() + ", called=" + getCalled() + ", waiting=" + getWaiting() + ", lisRis=" + getLisRis() + ")"; } public ExaminationCallingUserResponse(OrdinalDoorNumberResponse doctor, OrdinalDoorNumberResponse called, List<OrdinalDoorNumberResponse> waiting, List<OrdinalDoorNumberResponse> lisRis) {
/* 11 */     this.doctor = doctor; this.called = called; this.waiting = waiting; this.lisRis = lisRis;
/*    */   }
/*    */   public ExaminationCallingUserResponse() {}
/*    */   
/* 15 */   public OrdinalDoorNumberResponse getDoctor() { return this.doctor; }
/* 16 */   public OrdinalDoorNumberResponse getCalled() { return this.called; }
/* 17 */   public List<OrdinalDoorNumberResponse> getWaiting() { return this.waiting; } public List<OrdinalDoorNumberResponse> getLisRis() {
/* 18 */     return this.lisRis;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\ExaminationCallingUserResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */