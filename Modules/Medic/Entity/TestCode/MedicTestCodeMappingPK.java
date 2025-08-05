/*    */ package nencer.app.Modules.Medic.Entity.TestCode;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ public class MedicTestCodeMappingPK implements Serializable {
/*    */   private String testCode;
/*    */   private String serviceCode;
/*    */   
/*    */   @Column(name = "test_code")
/*    */   @Id
/*    */   public String getTestCode() {
/* 15 */     return this.testCode;
/*    */   }
/*    */   
/*    */   public void setTestCode(String testCode) {
/* 19 */     this.testCode = testCode;
/*    */   }
/*    */   
/*    */   @Column(name = "service_code")
/*    */   @Id
/*    */   public String getServiceCode() {
/* 25 */     return this.serviceCode;
/*    */   }
/*    */   
/*    */   public void setServiceCode(String serviceCode) {
/* 29 */     this.serviceCode = serviceCode;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 34 */     if (this == o) return true; 
/* 35 */     if (o == null || getClass() != o.getClass()) return false; 
/* 36 */     MedicTestCodeMappingPK that = (MedicTestCodeMappingPK)o;
/* 37 */     return (Objects.equals(this.testCode, that.testCode) && Objects.equals(this.serviceCode, that.serviceCode));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return Objects.hash(new Object[] { this.testCode, this.serviceCode });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TestCode\MedicTestCodeMappingPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */