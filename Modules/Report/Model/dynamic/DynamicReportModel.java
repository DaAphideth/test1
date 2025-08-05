/*    */ package nencer.app.Modules.Report.Model.dynamic;
/*    */ public class DynamicReportModel { private Integer rpId; @NotNull(message = "804")
/*    */   private String rpCode; @NotNull(message = "804")
/*    */   private String rpName;
/*    */   private String rpFileType;
/*    */   private String rpType;
/*    */   @NotNull(message = "804")
/*    */   private String rpSql;
/*    */   private String rpNote;
/*    */   
/* 11 */   public void setRpId(Integer rpId) { this.rpId = rpId; } private String rpLang; @NotNull(message = "804") private String rpFileName; private String rpFileStoreName; private String rpFileStream; private String rpStatus; private String rpUpdateBy; private List<DynamicReportVariableModel> variables; private String allowGroup; public void setRpCode(String rpCode) { this.rpCode = rpCode; } public void setRpName(String rpName) { this.rpName = rpName; } public void setRpFileType(String rpFileType) { this.rpFileType = rpFileType; } public void setRpType(String rpType) { this.rpType = rpType; } public void setRpSql(String rpSql) { this.rpSql = rpSql; } public void setRpNote(String rpNote) { this.rpNote = rpNote; } public void setRpLang(String rpLang) { this.rpLang = rpLang; } public void setRpFileName(String rpFileName) { this.rpFileName = rpFileName; } public void setRpFileStoreName(String rpFileStoreName) { this.rpFileStoreName = rpFileStoreName; } public void setRpFileStream(String rpFileStream) { this.rpFileStream = rpFileStream; } public void setRpStatus(String rpStatus) { this.rpStatus = rpStatus; } public void setRpUpdateBy(String rpUpdateBy) { this.rpUpdateBy = rpUpdateBy; } public void setVariables(List<DynamicReportVariableModel> variables) { this.variables = variables; } public void setAllowGroup(String allowGroup) { this.allowGroup = allowGroup; }
/*    */   
/*    */   public Integer getRpId() {
/* 14 */     return this.rpId;
/*    */   }
/*    */   public String getRpCode() {
/* 17 */     return this.rpCode;
/*    */   }
/* 19 */   public String getRpName() { return this.rpName; }
/* 20 */   public String getRpFileType() { return this.rpFileType; } public String getRpType() {
/* 21 */     return this.rpType;
/*    */   }
/*    */   
/* 24 */   public String getRpSql() { return this.rpSql; }
/* 25 */   public String getRpNote() { return this.rpNote; } public String getRpLang() {
/* 26 */     return this.rpLang;
/*    */   }
/*    */   
/* 29 */   public String getRpFileName() { return this.rpFileName; }
/* 30 */   public String getRpFileStoreName() { return this.rpFileStoreName; }
/* 31 */   public String getRpFileStream() { return this.rpFileStream; }
/* 32 */   public String getRpStatus() { return this.rpStatus; }
/* 33 */   public String getRpUpdateBy() { return this.rpUpdateBy; }
/* 34 */   public List<DynamicReportVariableModel> getVariables() { return this.variables; } public String getAllowGroup() {
/* 35 */     return this.allowGroup;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\dynamic\DynamicReportModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */