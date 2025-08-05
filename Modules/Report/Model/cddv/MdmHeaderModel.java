/*   */ package nencer.app.Modules.Report.Model.cddv;
/*   */ public class MdmHeaderModel { private String medicCode;
/*   */   private String medicName;
/*   */   
/* 5 */   public void setMedicCode(String medicCode) { this.medicCode = medicCode; } public void setMedicName(String medicName) { this.medicName = medicName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MdmHeaderModel)) return false;  MdmHeaderModel other = (MdmHeaderModel)o; if (!other.canEqual(this)) return false;  Object this$medicCode = getMedicCode(), other$medicCode = other.getMedicCode(); if ((this$medicCode == null) ? (other$medicCode != null) : !this$medicCode.equals(other$medicCode)) return false;  Object this$medicName = getMedicName(), other$medicName = other.getMedicName(); return !((this$medicName == null) ? (other$medicName != null) : !this$medicName.equals(other$medicName)); } protected boolean canEqual(Object other) { return other instanceof MdmHeaderModel; } public int hashCode() { int PRIME = 59; result = 1; Object $medicCode = getMedicCode(); result = result * 59 + (($medicCode == null) ? 43 : $medicCode.hashCode()); Object $medicName = getMedicName(); return result * 59 + (($medicName == null) ? 43 : $medicName.hashCode()); } public String toString() { return "MdmHeaderModel(medicCode=" + getMedicCode() + ", medicName=" + getMedicName() + ")"; }
/*   */   
/* 7 */   public String getMedicCode() { return this.medicCode; } public String getMedicName() {
/* 8 */     return this.medicName;
/*   */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\cddv\MdmHeaderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */