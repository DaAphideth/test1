/*    */ package nencer.app.Modules.Medic.Model.Examination;
/*    */ 
/*    */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*    */ 
/*    */ public class TabPaymenInfo {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private List<MedicOrderServices> medicOrderServices;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } public void setName(String name) { this.name = name; } public void setMedicOrderServices(List<MedicOrderServices> medicOrderServices) { this.medicOrderServices = medicOrderServices; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TabPaymenInfo)) return false;  TabPaymenInfo other = (TabPaymenInfo)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object<MedicOrderServices> this$medicOrderServices = (Object<MedicOrderServices>)getMedicOrderServices(), other$medicOrderServices = (Object<MedicOrderServices>)other.getMedicOrderServices(); return !((this$medicOrderServices == null) ? (other$medicOrderServices != null) : !this$medicOrderServices.equals(other$medicOrderServices)); } protected boolean canEqual(Object other) { return other instanceof TabPaymenInfo; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object<MedicOrderServices> $medicOrderServices = (Object<MedicOrderServices>)getMedicOrderServices(); return result * 59 + (($medicOrderServices == null) ? 43 : $medicOrderServices.hashCode()); } public String toString() { return "TabPaymenInfo(id=" + getId() + ", name=" + getName() + ", medicOrderServices=" + getMedicOrderServices() + ")"; } public TabPaymenInfo(Integer id, String name, List<MedicOrderServices> medicOrderServices) {
/* 11 */     this.id = id; this.name = name; this.medicOrderServices = medicOrderServices;
/*    */   }
/*    */   public TabPaymenInfo() {}
/* 14 */   public Integer getId() { return this.id; }
/* 15 */   public String getName() { return this.name; } public List<MedicOrderServices> getMedicOrderServices() {
/* 16 */     return this.medicOrderServices;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Examination\TabPaymenInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */