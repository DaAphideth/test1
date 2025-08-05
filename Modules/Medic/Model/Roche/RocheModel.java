/*   */ package nencer.app.Modules.Medic.Model.Roche;
/*   */ public class RocheModel {
/*   */   private String data;
/*   */   
/* 5 */   public String toString() { return "RocheModel(data=" + getData() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $data = getData(); return result * 59 + (($data == null) ? 43 : $data.hashCode()); } protected boolean canEqual(Object other) { return other instanceof RocheModel; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof RocheModel)) return false;  RocheModel other = (RocheModel)o; if (!other.canEqual(this)) return false;  Object this$data = getData(), other$data = other.getData(); return !((this$data == null) ? (other$data != null) : !this$data.equals(other$data)); } public void setData(String data) { this.data = data; }
/*   */    public String getData() {
/* 7 */     return this.data;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Roche\RocheModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */