/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class FieldReportModel {
/*    */   private String field;
/*    */   private String nameField;
/*    */   
/*  8 */   public void setField(String field) { this.field = field; } public void setNameField(String nameField) { this.nameField = nameField; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof FieldReportModel)) return false;  FieldReportModel other = (FieldReportModel)o; if (!other.canEqual(this)) return false;  Object this$field = getField(), other$field = other.getField(); if ((this$field == null) ? (other$field != null) : !this$field.equals(other$field)) return false;  Object this$nameField = getNameField(), other$nameField = other.getNameField(); return !((this$nameField == null) ? (other$nameField != null) : !this$nameField.equals(other$nameField)); } protected boolean canEqual(Object other) { return other instanceof FieldReportModel; } public int hashCode() { int PRIME = 59; result = 1; Object $field = getField(); result = result * 59 + (($field == null) ? 43 : $field.hashCode()); Object $nameField = getNameField(); return result * 59 + (($nameField == null) ? 43 : $nameField.hashCode()); } public String toString() { return "FieldReportModel(field=" + getField() + ", nameField=" + getNameField() + ")"; }
/*    */    public FieldReportModel() {} public FieldReportModel(String field, String nameField) {
/* 10 */     this.field = field; this.nameField = nameField;
/*    */   }
/*    */   
/* 13 */   public String getField() { return this.field; } public String getNameField() {
/* 14 */     return this.nameField;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\FieldReportModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */