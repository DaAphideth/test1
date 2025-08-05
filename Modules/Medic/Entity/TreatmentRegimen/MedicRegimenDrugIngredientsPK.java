/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ public class MedicRegimenDrugIngredientsPK implements Serializable {
/*    */   private int regimenId;
/*    */   private int drugIngredientsId;
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
/*    */   @Column(name = "drug_ingredients_id")
/*    */   @Id
/*    */   public int getDrugIngredientsId() {
/* 25 */     return this.drugIngredientsId;
/*    */   }
/*    */   
/*    */   public void setDrugIngredientsId(int drugIngredientsCode) {
/* 29 */     this.drugIngredientsId = drugIngredientsCode;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 34 */     if (this == o) return true; 
/* 35 */     if (o == null || getClass() != o.getClass()) return false; 
/* 36 */     MedicRegimenDrugIngredientsPK that = (MedicRegimenDrugIngredientsPK)o;
/* 37 */     return (this.regimenId == that.regimenId && Objects.equals(Integer.valueOf(this.drugIngredientsId), Integer.valueOf(that.drugIngredientsId)));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return Objects.hash(new Object[] { Integer.valueOf(this.regimenId), Integer.valueOf(this.drugIngredientsId) });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicRegimenDrugIngredientsPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */