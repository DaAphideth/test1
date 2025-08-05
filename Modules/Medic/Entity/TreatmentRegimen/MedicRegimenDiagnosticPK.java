/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ public class MedicRegimenDiagnosticPK implements Serializable {
/*    */   private int regimenId;
/*    */   private String diagnosticCode;
/*    */   
/*    */   @Column(name = "regimen_id")
/*    */   @Id
/*    */   public int getRegimenId() {
/* 15 */     return this.regimenId;
/*    */   }
/*    */   
/*    */   public void setRegimenId(int regimenId) {
/* 19 */     this.regimenId = regimenId;
/*    */   }
/*    */   
/*    */   @Column(name = "diagnostic_code")
/*    */   @Id
/*    */   public String getDiagnosticCode() {
/* 25 */     return this.diagnosticCode;
/*    */   }
/*    */   
/*    */   public void setDiagnosticCode(String diagnosticCode) {
/* 29 */     this.diagnosticCode = diagnosticCode;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 34 */     if (this == o) return true; 
/* 35 */     if (o == null || getClass() != o.getClass()) return false; 
/* 36 */     MedicRegimenDiagnosticPK that = (MedicRegimenDiagnosticPK)o;
/* 37 */     return (this.regimenId == that.regimenId && Objects.equals(this.diagnosticCode, that.diagnosticCode));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return Objects.hash(new Object[] { Integer.valueOf(this.regimenId), this.diagnosticCode });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicRegimenDiagnosticPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */