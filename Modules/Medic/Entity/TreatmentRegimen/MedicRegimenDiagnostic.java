/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.IdClass;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_regimen_diagnostic", schema = "nencer_api", catalog = "")
/*    */ @IdClass(MedicRegimenDiagnosticPK.class)
/*    */ public class MedicRegimenDiagnostic {
/*    */   private int regimenId;
/*    */   
/*    */   @Id
/*    */   @Column(name = "regimen_id")
/*    */   public int getRegimenId() {
/* 17 */     return this.regimenId;
/*    */   }
/*    */   private String diagnosticCode; private String regimenName;
/*    */   public void setRegimenId(int regimenId) {
/* 21 */     this.regimenId = regimenId;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "diagnostic_code")
/*    */   public String getDiagnosticCode() {
/* 27 */     return this.diagnosticCode;
/*    */   }
/*    */   
/*    */   public void setDiagnosticCode(String diagnosticCode) {
/* 31 */     this.diagnosticCode = diagnosticCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "regimen_name")
/*    */   public String getRegimenName() {
/* 37 */     return this.regimenName;
/*    */   }
/*    */   
/*    */   public void setRegimenName(String regimenName) {
/* 41 */     this.regimenName = regimenName;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 46 */     if (this == o) return true; 
/* 47 */     if (o == null || getClass() != o.getClass()) return false; 
/* 48 */     MedicRegimenDiagnostic that = (MedicRegimenDiagnostic)o;
/* 49 */     return (this.regimenId == that.regimenId && Objects.equals(this.diagnosticCode, that.diagnosticCode) && Objects.equals(this.regimenName, that.regimenName));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     return Objects.hash(new Object[] { Integer.valueOf(this.regimenId), this.diagnosticCode, this.regimenName });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicRegimenDiagnostic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */