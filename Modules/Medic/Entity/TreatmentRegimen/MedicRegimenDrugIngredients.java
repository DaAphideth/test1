/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.IdClass;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_regimen_drug_ingredients", schema = "nencer_api", catalog = "")
/*    */ @IdClass(MedicRegimenDrugIngredientsPK.class)
/*    */ public class MedicRegimenDrugIngredients {
/*    */   private int regimenId;
/*    */   
/*    */   @Id
/*    */   @Column(name = "regimen_id")
/*    */   public int getRegimenId() {
/* 17 */     return this.regimenId;
/*    */   }
/*    */   private int drugIngredientsId; private String regimenName;
/*    */   public void setRegimenId(int regimenId) {
/* 21 */     this.regimenId = regimenId;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "drug_ingredients_id")
/*    */   public int getDrugIngredientsId() {
/* 27 */     return this.drugIngredientsId;
/*    */   }
/*    */   
/*    */   public void setDrugIngredientsId(int drugIngredientsCode) {
/* 31 */     this.drugIngredientsId = drugIngredientsCode;
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
/* 48 */     MedicRegimenDrugIngredients that = (MedicRegimenDrugIngredients)o;
/* 49 */     return (this.regimenId == that.regimenId && Objects.equals(Integer.valueOf(this.drugIngredientsId), Integer.valueOf(that.drugIngredientsId)) && Objects.equals(this.regimenName, that.regimenName));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     return Objects.hash(new Object[] { Integer.valueOf(this.regimenId), Integer.valueOf(this.drugIngredientsId), this.regimenName });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicRegimenDrugIngredients.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */