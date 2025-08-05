/*    */ package nencer.app.Modules.Medic.Model.TreatmentRegimen;
/*    */ public class TreatmentRegimenRequest { private int id;
/*    */   private String regimenName;
/*    */   
/*  5 */   public void setId(int id) { this.id = id; } private String diagnosticCode; private String serviceId; private String drugIngredient; public void setRegimenName(String regimenName) { this.regimenName = regimenName; } public void setDiagnosticCode(String diagnosticCode) { this.diagnosticCode = diagnosticCode; } public void setServiceId(String serviceId) { this.serviceId = serviceId; } public void setDrugIngredient(String drugIngredient) { this.drugIngredient = drugIngredient; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TreatmentRegimenRequest)) return false;  TreatmentRegimenRequest other = (TreatmentRegimenRequest)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$regimenName = getRegimenName(), other$regimenName = other.getRegimenName(); if ((this$regimenName == null) ? (other$regimenName != null) : !this$regimenName.equals(other$regimenName)) return false;  Object this$diagnosticCode = getDiagnosticCode(), other$diagnosticCode = other.getDiagnosticCode(); if ((this$diagnosticCode == null) ? (other$diagnosticCode != null) : !this$diagnosticCode.equals(other$diagnosticCode)) return false;  Object this$serviceId = getServiceId(), other$serviceId = other.getServiceId(); if ((this$serviceId == null) ? (other$serviceId != null) : !this$serviceId.equals(other$serviceId)) return false;  Object this$drugIngredient = getDrugIngredient(), other$drugIngredient = other.getDrugIngredient(); return !((this$drugIngredient == null) ? (other$drugIngredient != null) : !this$drugIngredient.equals(other$drugIngredient)); } protected boolean canEqual(Object other) { return other instanceof TreatmentRegimenRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $regimenName = getRegimenName(); result = result * 59 + (($regimenName == null) ? 43 : $regimenName.hashCode()); Object $diagnosticCode = getDiagnosticCode(); result = result * 59 + (($diagnosticCode == null) ? 43 : $diagnosticCode.hashCode()); Object $serviceId = getServiceId(); result = result * 59 + (($serviceId == null) ? 43 : $serviceId.hashCode()); Object $drugIngredient = getDrugIngredient(); return result * 59 + (($drugIngredient == null) ? 43 : $drugIngredient.hashCode()); } public String toString() { return "TreatmentRegimenRequest(id=" + getId() + ", regimenName=" + getRegimenName() + ", diagnosticCode=" + getDiagnosticCode() + ", serviceId=" + getServiceId() + ", drugIngredient=" + getDrugIngredient() + ")"; }
/*    */   
/*  7 */   public int getId() { return this.id; }
/*  8 */   public String getRegimenName() { return this.regimenName; }
/*  9 */   public String getDiagnosticCode() { return this.diagnosticCode; }
/* 10 */   public String getServiceId() { return this.serviceId; } public String getDrugIngredient() {
/* 11 */     return this.drugIngredient;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\TreatmentRegimen\TreatmentRegimenRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */