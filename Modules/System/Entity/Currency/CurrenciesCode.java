/*    */ package nencer.app.Modules.System.Entity.Currency;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "currencies_code")
/*    */ public class CurrenciesCode {
/*    */   private String code;
/*    */   
/*    */   @Basic
/*    */   @Id
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 16 */     return this.code;
/*    */   }
/*    */   private String name;
/*    */   public void setCode(String code) {
/* 20 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 30 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 35 */     if (this == o) return true; 
/* 36 */     if (o == null || getClass() != o.getClass()) return false; 
/* 37 */     CurrenciesCode that = (CurrenciesCode)o;
/* 38 */     return (Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 43 */     return Objects.hash(new Object[] { this.code, this.name });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\Currency\CurrenciesCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */