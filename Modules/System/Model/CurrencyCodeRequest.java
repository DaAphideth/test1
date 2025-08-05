/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ import javax.validation.constraints.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CurrencyCodeRequest
/*    */ {
/*    */   @NotNull(message = "804")
/*    */   private String code;
/*    */   private String name;
/*    */   
/*    */   public void setCode(String code) {
/* 14 */     this.code = code; } public void setName(String name) { this.name = name; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CurrencyCodeRequest)) return false;  CurrencyCodeRequest other = (CurrencyCodeRequest)o; if (!other.canEqual(this)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); return !((this$name == null) ? (other$name != null) : !this$name.equals(other$name)); } protected boolean canEqual(Object other) { return other instanceof CurrencyCodeRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); return result * 59 + (($name == null) ? 43 : $name.hashCode()); } public String toString() { return "CurrencyCodeRequest(code=" + getCode() + ", name=" + getName() + ")"; }
/*    */    public CurrencyCodeRequest() {} public CurrencyCodeRequest(String code, String name) {
/* 16 */     this.code = code; this.name = name;
/*    */   }
/*    */   
/* 19 */   public String getCode() { return this.code; } public String getName() {
/* 20 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\CurrencyCodeRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */