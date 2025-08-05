/*    */ package nencer.app.Modules.Medic.Entity.TestCode;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_test_code_mapping")
/*    */ @IdClass(MedicTestCodeMappingPK.class)
/*    */ public class MedicTestCodeMapping {
/*    */   private String testCode;
/*    */   private String serviceCode;
/*    */   
/*    */   @Id
/*    */   @Column(name = "test_code")
/*    */   public String getTestCode() {
/* 17 */     return this.testCode;
/*    */   }
/*    */   private Integer serviceId; private Integer testDeviceId;
/*    */   public void setTestCode(String testCode) {
/* 21 */     this.testCode = testCode;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name = "service_code")
/*    */   public String getServiceCode() {
/* 27 */     return this.serviceCode;
/*    */   }
/*    */   
/*    */   public void setServiceCode(String serviceCode) {
/* 31 */     this.serviceCode = serviceCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "service_id")
/*    */   public Integer getServiceId() {
/* 37 */     return this.serviceId;
/*    */   }
/*    */   
/*    */   public void setServiceId(Integer serviceId) {
/* 41 */     this.serviceId = serviceId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "test_device_id")
/*    */   public Integer getTestDeviceId() {
/* 47 */     return this.testDeviceId;
/*    */   }
/*    */   
/*    */   public void setTestDeviceId(Integer testDeviceId) {
/* 51 */     this.testDeviceId = testDeviceId;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 56 */     if (this == o) return true; 
/* 57 */     if (o == null || getClass() != o.getClass()) return false; 
/* 58 */     MedicTestCodeMapping that = (MedicTestCodeMapping)o;
/* 59 */     return (Objects.equals(this.testCode, that.testCode) && Objects.equals(this.serviceCode, that.serviceCode) && Objects.equals(this.serviceId, that.serviceId) && Objects.equals(this.testDeviceId, that.testDeviceId));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 64 */     return Objects.hash(new Object[] { this.testCode, this.serviceCode, this.serviceId, this.testDeviceId });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TestCode\MedicTestCodeMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */