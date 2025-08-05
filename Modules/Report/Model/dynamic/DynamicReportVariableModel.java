/*    */ package nencer.app.Modules.Report.Model.dynamic;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class DynamicReportVariableModel {
/*    */   private Integer rpVarId;
/*    */   private Integer rpId;
/*    */   @NotNull(message = "804")
/*    */   private String rpVarCode;
/*    */   @NotNull(message = "804")
/*    */   private String rpVarName;
/*    */   
/* 13 */   public void setRpVarId(Integer rpVarId) { this.rpVarId = rpVarId; } @NotNull(message = "804") private String rpVarType; private String rpVarSql; private String rpVarFieldDisplay; private String rpVarFieldData; private List<Map<String, Object>> rpVarData; public void setRpId(Integer rpId) { this.rpId = rpId; } public void setRpVarCode(String rpVarCode) { this.rpVarCode = rpVarCode; } public void setRpVarName(String rpVarName) { this.rpVarName = rpVarName; } public void setRpVarType(String rpVarType) { this.rpVarType = rpVarType; } public void setRpVarSql(String rpVarSql) { this.rpVarSql = rpVarSql; } public void setRpVarFieldDisplay(String rpVarFieldDisplay) { this.rpVarFieldDisplay = rpVarFieldDisplay; } public void setRpVarFieldData(String rpVarFieldData) { this.rpVarFieldData = rpVarFieldData; } public void setRpVarData(List<Map<String, Object>> rpVarData) { this.rpVarData = rpVarData; }
/*    */ 
/*    */   
/*    */   public Integer getRpVarId() {
/* 17 */     return this.rpVarId; } public Integer getRpId() {
/* 18 */     return this.rpId;
/*    */   } public String getRpVarCode() {
/* 20 */     return this.rpVarCode;
/*    */   } public String getRpVarName() {
/* 22 */     return this.rpVarName;
/*    */   }
/* 24 */   public String getRpVarType() { return this.rpVarType; }
/* 25 */   public String getRpVarSql() { return this.rpVarSql; }
/* 26 */   public String getRpVarFieldDisplay() { return this.rpVarFieldDisplay; }
/* 27 */   public String getRpVarFieldData() { return this.rpVarFieldData; } public List<Map<String, Object>> getRpVarData() {
/* 28 */     return this.rpVarData;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\dynamic\DynamicReportVariableModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */