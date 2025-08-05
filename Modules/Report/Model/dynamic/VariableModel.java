/*    */ package nencer.app.Modules.Report.Model.dynamic;
/*    */ 
/*    */ 
/*    */ public class VariableModel {
/*    */   @NotNull(message = "804")
/*    */   private String rpVarCode;
/*    */   @NotNull(message = "804")
/*    */   private String rpVarValue;
/*    */   
/* 10 */   public void setRpVarCode(String rpVarCode) { this.rpVarCode = rpVarCode; } public void setRpVarValue(String rpVarValue) { this.rpVarValue = rpVarValue; }
/*    */ 
/*    */   
/*    */   public String getRpVarCode() {
/* 14 */     return this.rpVarCode;
/*    */   } public String getRpVarValue() {
/* 16 */     return this.rpVarValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\dynamic\VariableModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */