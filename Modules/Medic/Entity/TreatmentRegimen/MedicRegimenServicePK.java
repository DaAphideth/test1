/*    */ package nencer.app.Modules.Medic.Entity.TreatmentRegimen;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ public class MedicRegimenServicePK implements Serializable {
/*    */   private int regimenId;
/*    */   private int serviceId;
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
/*    */   @Column(name = "service_id")
/*    */   @Id
/*    */   public int getServiceId() {
/* 25 */     return this.serviceId;
/*    */   }
/*    */   
/*    */   public void setServiceId(int serviceId) {
/* 29 */     this.serviceId = serviceId;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 34 */     if (this == o) return true; 
/* 35 */     if (o == null || getClass() != o.getClass()) return false; 
/* 36 */     MedicRegimenServicePK that = (MedicRegimenServicePK)o;
/* 37 */     return (this.regimenId == that.regimenId && this.serviceId == that.serviceId);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return Objects.hash(new Object[] { Integer.valueOf(this.regimenId), Integer.valueOf(this.serviceId) });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentRegimen\MedicRegimenServicePK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */