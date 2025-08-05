/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ @Component
/*    */ public class ExaminationSolveDiagnosticModel {
/*    */   private String name;
/*    */   private String code;
/*    */   
/* 12 */   public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ExaminationSolveDiagnosticModel)) return false;  ExaminationSolveDiagnosticModel other = (ExaminationSolveDiagnosticModel)o; if (!other.canEqual(this)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); return !((this$code == null) ? (other$code != null) : !this$code.equals(other$code)); } protected boolean canEqual(Object other) { return other instanceof ExaminationSolveDiagnosticModel; } public int hashCode() { int PRIME = 59; result = 1; Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); return result * 59 + (($code == null) ? 43 : $code.hashCode()); } public ExaminationSolveDiagnosticModel(String name, String code) {
/* 13 */     this.name = name; this.code = code;
/*    */   }
/*    */   
/*    */   public ExaminationSolveDiagnosticModel() {}
/*    */   
/* 18 */   public String getName() { return this.name; } public String getCode() {
/* 19 */     return this.code;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 23 */     if (getName() != null && getCode() != null) {
/* 24 */       return this.code + " - " + this.name;
/*    */     }
/* 26 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\ExaminationSolveDiagnosticModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */