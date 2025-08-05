/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ @Component
/*    */ public class ReExaminationModel {
/*    */   private String name;
/*    */   private String code;
/*    */   
/* 12 */   public void setName(String name) { this.name = name; } private String appointment; private List<String> appointmentList; private String appointmentDay; public void setCode(String code) { this.code = code; } public void setAppointment(String appointment) { this.appointment = appointment; } public void setAppointmentList(List<String> appointmentList) { this.appointmentList = appointmentList; } public void setAppointmentDay(String appointmentDay) { this.appointmentDay = appointmentDay; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ReExaminationModel)) return false;  ReExaminationModel other = (ReExaminationModel)o; if (!other.canEqual(this)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$appointment = getAppointment(), other$appointment = other.getAppointment(); if ((this$appointment == null) ? (other$appointment != null) : !this$appointment.equals(other$appointment)) return false;  Object<String> this$appointmentList = (Object<String>)getAppointmentList(), other$appointmentList = (Object<String>)other.getAppointmentList(); if ((this$appointmentList == null) ? (other$appointmentList != null) : !this$appointmentList.equals(other$appointmentList)) return false;  Object this$appointmentDay = getAppointmentDay(), other$appointmentDay = other.getAppointmentDay(); return !((this$appointmentDay == null) ? (other$appointmentDay != null) : !this$appointmentDay.equals(other$appointmentDay)); } protected boolean canEqual(Object other) { return other instanceof ReExaminationModel; } public int hashCode() { int PRIME = 59; result = 1; Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $appointment = getAppointment(); result = result * 59 + (($appointment == null) ? 43 : $appointment.hashCode()); Object<String> $appointmentList = (Object<String>)getAppointmentList(); result = result * 59 + (($appointmentList == null) ? 43 : $appointmentList.hashCode()); Object $appointmentDay = getAppointmentDay(); return result * 59 + (($appointmentDay == null) ? 43 : $appointmentDay.hashCode()); } public ReExaminationModel(String name, String code, String appointment, List<String> appointmentList, String appointmentDay) {
/* 13 */     this.name = name; this.code = code; this.appointment = appointment; this.appointmentList = appointmentList; this.appointmentDay = appointmentDay;
/*    */   }
/*    */   
/*    */   public ReExaminationModel() {}
/*    */   
/* 18 */   public String getName() { return this.name; }
/* 19 */   public String getCode() { return this.code; }
/* 20 */   public String getAppointment() { return this.appointment; }
/* 21 */   public List<String> getAppointmentList() { return this.appointmentList; } public String getAppointmentDay() {
/* 22 */     return this.appointmentDay;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 26 */     if (getName() != null && getCode() != null) {
/* 27 */       return this.code + " - " + this.name;
/*    */     }
/* 29 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\ReExaminationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */