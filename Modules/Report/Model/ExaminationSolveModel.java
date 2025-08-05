/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ @Component
/*    */ public class ExaminationSolveModel {
/*    */   private List<ExaminationSolveDiagnosticModel> diagnosticSubArray;
/*    */   private List<ExaminationSolveDiagnosticModel> diagnosticArray;
/*    */   
/* 11 */   public void setDiagnosticSubArray(List<ExaminationSolveDiagnosticModel> diagnosticSubArray) { this.diagnosticSubArray = diagnosticSubArray; } public void setDiagnosticArray(List<ExaminationSolveDiagnosticModel> diagnosticArray) { this.diagnosticArray = diagnosticArray; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ExaminationSolveModel)) return false;  ExaminationSolveModel other = (ExaminationSolveModel)o; if (!other.canEqual(this)) return false;  Object<ExaminationSolveDiagnosticModel> this$diagnosticSubArray = (Object<ExaminationSolveDiagnosticModel>)getDiagnosticSubArray(), other$diagnosticSubArray = (Object<ExaminationSolveDiagnosticModel>)other.getDiagnosticSubArray(); if ((this$diagnosticSubArray == null) ? (other$diagnosticSubArray != null) : !this$diagnosticSubArray.equals(other$diagnosticSubArray)) return false;  Object<ExaminationSolveDiagnosticModel> this$diagnosticArray = (Object<ExaminationSolveDiagnosticModel>)getDiagnosticArray(), other$diagnosticArray = (Object<ExaminationSolveDiagnosticModel>)other.getDiagnosticArray(); return !((this$diagnosticArray == null) ? (other$diagnosticArray != null) : !this$diagnosticArray.equals(other$diagnosticArray)); } protected boolean canEqual(Object other) { return other instanceof ExaminationSolveModel; } public int hashCode() { int PRIME = 59; result = 1; Object<ExaminationSolveDiagnosticModel> $diagnosticSubArray = (Object<ExaminationSolveDiagnosticModel>)getDiagnosticSubArray(); result = result * 59 + (($diagnosticSubArray == null) ? 43 : $diagnosticSubArray.hashCode()); Object<ExaminationSolveDiagnosticModel> $diagnosticArray = (Object<ExaminationSolveDiagnosticModel>)getDiagnosticArray(); return result * 59 + (($diagnosticArray == null) ? 43 : $diagnosticArray.hashCode()); } public String toString() { return "ExaminationSolveModel(diagnosticSubArray=" + getDiagnosticSubArray() + ", diagnosticArray=" + getDiagnosticArray() + ")"; } public ExaminationSolveModel(List<ExaminationSolveDiagnosticModel> diagnosticSubArray, List<ExaminationSolveDiagnosticModel> diagnosticArray) {
/* 12 */     this.diagnosticSubArray = diagnosticSubArray; this.diagnosticArray = diagnosticArray;
/*    */   }
/*    */   
/*    */   public ExaminationSolveModel() {}
/*    */   
/* 17 */   public List<ExaminationSolveDiagnosticModel> getDiagnosticSubArray() { return this.diagnosticSubArray; } public List<ExaminationSolveDiagnosticModel> getDiagnosticArray() {
/* 18 */     return this.diagnosticArray;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\ExaminationSolveModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */