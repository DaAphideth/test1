/*    */ package nencer.app.Modules.Medic.Entity.TestCode;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_test_code")
/*    */ public class MedicTestCode {
/*    */   private String testCode;
/*    */   
/*    */   @Id
/*    */   @Column(name = "test_code")
/*    */   public String getTestCode() {
/* 15 */     return this.testCode;
/*    */   }
/*    */   private String testName;
/*    */   public void setTestCode(String testCode) {
/* 19 */     this.testCode = testCode;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "test_name")
/*    */   public String getTestName() {
/* 25 */     return this.testName;
/*    */   }
/*    */   
/*    */   public void setTestName(String testName) {
/* 29 */     this.testName = testName;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 34 */     if (this == o) return true; 
/* 35 */     if (o == null || getClass() != o.getClass()) return false; 
/* 36 */     MedicTestCode that = (MedicTestCode)o;
/* 37 */     return (Objects.equals(this.testCode, that.testCode) && Objects.equals(this.testName, that.testName));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return Objects.hash(new Object[] { this.testCode, this.testName });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TestCode\MedicTestCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */