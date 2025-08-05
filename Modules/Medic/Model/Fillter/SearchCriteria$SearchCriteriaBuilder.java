/*    */ package nencer.app.Modules.Medic.Model.Fillter;
/*    */ 
/*    */ import nencer.app.Constant.QueryOperator;
/*    */ 
/*    */ public class SearchCriteriaBuilder {
/*    */   private String field;
/*    */   private Object value;
/*    */   private QueryOperator operator;
/*    */   
/* 10 */   public SearchCriteriaBuilder field(String field) { this.field = field; return this; } public SearchCriteriaBuilder value(Object value) { this.value = value; return this; } public SearchCriteriaBuilder operator(QueryOperator operator) { this.operator = operator; return this; } public SearchCriteria build() { return new SearchCriteria(this.field, this.value, this.operator); } public String toString() { return "SearchCriteria.SearchCriteriaBuilder(field=" + this.field + ", value=" + this.value + ", operator=" + this.operator + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Fillter\SearchCriteria$SearchCriteriaBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */