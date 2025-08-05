/*    */ package nencer.app.Modules.Medic.Model.Fillter;
/*    */ 
/*    */ 
/*    */ public class SearchCriteria {
/*    */   private String field;
/*    */   private Object value;
/*    */   private QueryOperator operator;
/*    */   
/*  9 */   public void setField(String field) { this.field = field; } public void setValue(Object value) { this.value = value; } public void setOperator(QueryOperator operator) { this.operator = operator; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SearchCriteria)) return false;  SearchCriteria other = (SearchCriteria)o; if (!other.canEqual(this)) return false;  Object this$field = getField(), other$field = other.getField(); if ((this$field == null) ? (other$field != null) : !this$field.equals(other$field)) return false;  Object this$value = getValue(), other$value = other.getValue(); if ((this$value == null) ? (other$value != null) : !this$value.equals(other$value)) return false;  Object this$operator = getOperator(), other$operator = other.getOperator(); return !((this$operator == null) ? (other$operator != null) : !this$operator.equals(other$operator)); } protected boolean canEqual(Object other) { return other instanceof SearchCriteria; } public int hashCode() { int PRIME = 59; result = 1; Object $field = getField(); result = result * 59 + (($field == null) ? 43 : $field.hashCode()); Object $value = getValue(); result = result * 59 + (($value == null) ? 43 : $value.hashCode()); Object $operator = getOperator(); return result * 59 + (($operator == null) ? 43 : $operator.hashCode()); } public String toString() { return "SearchCriteria(field=" + getField() + ", value=" + getValue() + ", operator=" + getOperator() + ")"; }
/* 10 */   public static SearchCriteriaBuilder builder() { return new SearchCriteriaBuilder(); } public static class SearchCriteriaBuilder { private String field; public SearchCriteriaBuilder field(String field) { this.field = field; return this; } private Object value; private QueryOperator operator; public SearchCriteriaBuilder value(Object value) { this.value = value; return this; } public SearchCriteriaBuilder operator(QueryOperator operator) { this.operator = operator; return this; } public SearchCriteria build() { return new SearchCriteria(this.field, this.value, this.operator); } public String toString() { return "SearchCriteria.SearchCriteriaBuilder(field=" + this.field + ", value=" + this.value + ", operator=" + this.operator + ")"; } } public SearchCriteria(String field, Object value, QueryOperator operator) {
/* 11 */     this.field = field; this.value = value; this.operator = operator;
/*    */   }
/*    */   public SearchCriteria() {}
/* 14 */   public String getField() { return this.field; }
/* 15 */   public Object getValue() { return this.value; } public QueryOperator getOperator() {
/* 16 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Fillter\SearchCriteria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */