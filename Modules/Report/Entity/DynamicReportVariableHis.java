/*    */ package nencer.app.Modules.Report.Entity;
/*    */ @Entity
/*    */ @Table(name = "dynamic_report_variable_his")
/*    */ public class DynamicReportVariableHis { @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer id; @Column(name = "rp_var_id")
/*    */   private Integer rpVarId; @Basic
/*    */   @Column(name = "rp_id")
/*    */   private Integer rpId; @Basic
/*    */   @Column(name = "rp_var_code")
/* 12 */   private String rpVarCode; public void setId(Integer id) { this.id = id; } @Basic @Column(name = "rp_var_name") private String rpVarName; @Basic @Column(name = "rp_var_type") private String rpVarType; @Basic @Column(name = "rp_var_sql") private String rpVarSql; @Basic @Column(name = "rp_var_field_display") private String rpVarFieldDisplay; @Basic @Column(name = "rp_var_field_data") private String rpVarFieldData; public void setRpVarId(Integer rpVarId) { this.rpVarId = rpVarId; } public void setRpId(Integer rpId) { this.rpId = rpId; } public void setRpVarCode(String rpVarCode) { this.rpVarCode = rpVarCode; } public void setRpVarName(String rpVarName) { this.rpVarName = rpVarName; } public void setRpVarType(String rpVarType) { this.rpVarType = rpVarType; } public void setRpVarSql(String rpVarSql) { this.rpVarSql = rpVarSql; } public void setRpVarFieldDisplay(String rpVarFieldDisplay) { this.rpVarFieldDisplay = rpVarFieldDisplay; } public void setRpVarFieldData(String rpVarFieldData) { this.rpVarFieldData = rpVarFieldData; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 18 */     return this.id;
/*    */   }
/*    */   public Integer getRpVarId() {
/* 21 */     return this.rpVarId;
/*    */   }
/*    */   public Integer getRpId() {
/* 24 */     return this.rpId;
/*    */   }
/*    */   public String getRpVarCode() {
/* 27 */     return this.rpVarCode;
/*    */   }
/*    */   public String getRpVarName() {
/* 30 */     return this.rpVarName;
/*    */   }
/*    */   public String getRpVarType() {
/* 33 */     return this.rpVarType;
/*    */   }
/*    */   public String getRpVarSql() {
/* 36 */     return this.rpVarSql;
/*    */   }
/*    */   public String getRpVarFieldDisplay() {
/* 39 */     return this.rpVarFieldDisplay;
/*    */   }
/*    */   public String getRpVarFieldData() {
/* 42 */     return this.rpVarFieldData;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Entity\DynamicReportVariableHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */