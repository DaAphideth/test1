/*    */ package nencer.app.Modules.MasterData.Entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ public class MedicMasterDataPK implements Serializable {
/*    */   private String medicCode;
/*    */   private String medicType;
/*    */   
/*    */   @Id
/*    */   @Basic
/*    */   @Column(name = "medic_code")
/*    */   public String getMedicCode() {
/* 16 */     return this.medicCode;
/*    */   }
/*    */   
/*    */   public void setMedicCode(String medicCode) {
/* 20 */     this.medicCode = medicCode;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "medic_type")
/*    */   public String getMedicType() {
/* 25 */     return this.medicType;
/*    */   }
/*    */   
/*    */   public void setMedicType(String medicType) {
/* 29 */     this.medicType = medicType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\MasterData\Entity\MedicMasterDataPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */