/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ import java.util.Date;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_treatment_regimen")
/*    */ public class MedicTreatmentRegimen {
/*    */   private int id;
/*    */   private String regimenName;
/*    */   private String diagnosticCode;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   private String serviceId; private String drugIngredient; private Date createdAt; private Date updatedAt;
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "regimen_name")
/*    */   public String getRegimenName() {
/* 31 */     return this.regimenName;
/*    */   }
/*    */   
/*    */   public void setRegimenName(String regimenName) {
/* 35 */     this.regimenName = regimenName;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "diagnostic_code")
/*    */   public String getDiagnosticCode() {
/* 41 */     return this.diagnosticCode;
/*    */   }
/*    */   
/*    */   public void setDiagnosticCode(String diagnosticCode) {
/* 45 */     this.diagnosticCode = diagnosticCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "service_id")
/*    */   public String getServiceId() {
/* 51 */     return this.serviceId;
/*    */   }
/*    */   
/*    */   public void setServiceId(String serviceId) {
/* 55 */     this.serviceId = serviceId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "drug_ingredient")
/*    */   public String getDrugIngredient() {
/* 61 */     return this.drugIngredient;
/*    */   }
/*    */   
/*    */   public void setDrugIngredient(String drugIngredient) {
/* 65 */     this.drugIngredient = drugIngredient;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 70 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 74 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 80 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 84 */     this.updatedAt = updatedAt;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 88 */     if (this == o) return true; 
/* 89 */     if (o == null || getClass() != o.getClass()) return false; 
/* 90 */     MedicTreatmentRegimen that = (MedicTreatmentRegimen)o;
/* 91 */     return (this.id == that.id && Objects.equals(this.regimenName, that.regimenName) && Objects.equals(this.diagnosticCode, that.diagnosticCode) && Objects.equals(this.serviceId, that.serviceId) && Objects.equals(this.drugIngredient, that.drugIngredient));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 96 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.regimenName, this.diagnosticCode, this.serviceId, this.drugIngredient });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicTreatmentRegimen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */