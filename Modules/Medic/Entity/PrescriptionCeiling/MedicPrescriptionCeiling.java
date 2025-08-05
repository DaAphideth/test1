/*    */ package nencer.app.Modules.Medic.Entity.PrescriptionCeiling;
/*    */ import java.util.Date;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_prescription_ceiling")
/*    */ public class MedicPrescriptionCeiling {
/*    */   private int id;
/*    */   private String diagnosticCode;
/*    */   private String healthInsuranceCeiling;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 20 */     return this.id;
/*    */   }
/*    */   private String ceilingTotalExpenditure; private Date createdAt; private Date updatedAt;
/*    */   public void setId(int id) {
/* 24 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "diagnostic_code")
/*    */   public String getDiagnosticCode() {
/* 30 */     return this.diagnosticCode;
/*    */   }
/*    */   
/*    */   public void setDiagnosticCode(String diagnosticCode) {
/* 34 */     this.diagnosticCode = diagnosticCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "health_insurance_ceiling")
/*    */   public String getHealthInsuranceCeiling() {
/* 40 */     return this.healthInsuranceCeiling;
/*    */   }
/*    */   
/*    */   public void setHealthInsuranceCeiling(String healthInsuranceCeiling) {
/* 44 */     this.healthInsuranceCeiling = healthInsuranceCeiling;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "ceiling_total_expenditure")
/*    */   public String getCeilingTotalExpenditure() {
/* 50 */     return this.ceilingTotalExpenditure;
/*    */   }
/*    */   
/*    */   public void setCeilingTotalExpenditure(String ceilingTotalExpenditure) {
/* 54 */     this.ceilingTotalExpenditure = ceilingTotalExpenditure;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 59 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 63 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 69 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 73 */     this.updatedAt = updatedAt;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 77 */     if (this == o) return true; 
/* 78 */     if (o == null || getClass() != o.getClass()) return false; 
/* 79 */     MedicPrescriptionCeiling that = (MedicPrescriptionCeiling)o;
/* 80 */     return (this.id == that.id && Objects.equals(this.diagnosticCode, that.diagnosticCode) && Objects.equals(this.healthInsuranceCeiling, that.healthInsuranceCeiling) && Objects.equals(this.ceilingTotalExpenditure, that.ceilingTotalExpenditure));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 85 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.diagnosticCode, this.healthInsuranceCeiling, this.ceilingTotalExpenditure });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\PrescriptionCeiling\MedicPrescriptionCeiling.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */