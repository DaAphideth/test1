/*   */ package nencer.app.Modules.Medic.Model.Fillter;
/*   */ public class FilterData {
/*   */   private String filter;
/*   */   
/* 5 */   public String toString() { return "FilterData(filter=" + getFilter() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $filter = getFilter(); return result * 59 + (($filter == null) ? 43 : $filter.hashCode()); } protected boolean canEqual(Object other) { return other instanceof FilterData; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof FilterData)) return false;  FilterData other = (FilterData)o; if (!other.canEqual(this)) return false;  Object this$filter = getFilter(), other$filter = other.getFilter(); return !((this$filter == null) ? (other$filter != null) : !this$filter.equals(other$filter)); } public void setFilter(String filter) { this.filter = filter; }
/*   */    public String getFilter() {
/* 7 */     return this.filter;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Fillter\FilterData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */