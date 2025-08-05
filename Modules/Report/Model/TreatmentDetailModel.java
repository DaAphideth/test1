/*    */ package nencer.app.Modules.Report.Model;
/*    */ public class TreatmentDetailModel { private Integer id;
/*    */   private String createdDate;
/*    */   
/*  5 */   public void setId(Integer id) { this.id = id; } private String dienBienBenh; private String yLenh; private String doctorName; public void setCreatedDate(String createdDate) { this.createdDate = createdDate; } public void setDienBienBenh(String dienBienBenh) { this.dienBienBenh = dienBienBenh; } public void setYLenh(String yLenh) { this.yLenh = yLenh; } public void setDoctorName(String doctorName) { this.doctorName = doctorName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TreatmentDetailModel)) return false;  TreatmentDetailModel other = (TreatmentDetailModel)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$createdDate = getCreatedDate(), other$createdDate = other.getCreatedDate(); if ((this$createdDate == null) ? (other$createdDate != null) : !this$createdDate.equals(other$createdDate)) return false;  Object this$dienBienBenh = getDienBienBenh(), other$dienBienBenh = other.getDienBienBenh(); if ((this$dienBienBenh == null) ? (other$dienBienBenh != null) : !this$dienBienBenh.equals(other$dienBienBenh)) return false;  Object this$yLenh = getYLenh(), other$yLenh = other.getYLenh(); if ((this$yLenh == null) ? (other$yLenh != null) : !this$yLenh.equals(other$yLenh)) return false;  Object this$doctorName = getDoctorName(), other$doctorName = other.getDoctorName(); return !((this$doctorName == null) ? (other$doctorName != null) : !this$doctorName.equals(other$doctorName)); } protected boolean canEqual(Object other) { return other instanceof TreatmentDetailModel; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $createdDate = getCreatedDate(); result = result * 59 + (($createdDate == null) ? 43 : $createdDate.hashCode()); Object $dienBienBenh = getDienBienBenh(); result = result * 59 + (($dienBienBenh == null) ? 43 : $dienBienBenh.hashCode()); Object $yLenh = getYLenh(); result = result * 59 + (($yLenh == null) ? 43 : $yLenh.hashCode()); Object $doctorName = getDoctorName(); return result * 59 + (($doctorName == null) ? 43 : $doctorName.hashCode()); } public String toString() { return "TreatmentDetailModel(id=" + getId() + ", createdDate=" + getCreatedDate() + ", dienBienBenh=" + getDienBienBenh() + ", yLenh=" + getYLenh() + ", doctorName=" + getDoctorName() + ")"; }
/*    */   
/*  7 */   public Integer getId() { return this.id; }
/*  8 */   public String getCreatedDate() { return this.createdDate; }
/*  9 */   public String getDienBienBenh() { return this.dienBienBenh; }
/* 10 */   public String getYLenh() { return this.yLenh; } public String getDoctorName() {
/* 11 */     return this.doctorName;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\TreatmentDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */