/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedicCheckinLiveBuilder
/*    */ {
/*    */   private List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges;
/*    */   private Map<String, Object> customerData;
/*    */   
/*    */   public MedicCheckinLiveBuilder medicCheckinLiveMerges(List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges) {
/* 14 */     this.medicCheckinLiveMerges = medicCheckinLiveMerges; return this; } public MedicCheckinLiveBuilder customerData(Map<String, Object> customerData) { this.customerData = customerData; return this; } public MedicCheckinLive build() { return new MedicCheckinLive(this.medicCheckinLiveMerges, this.customerData); } public String toString() { return "MedicCheckinLive.MedicCheckinLiveBuilder(medicCheckinLiveMerges=" + this.medicCheckinLiveMerges + ", customerData=" + this.customerData + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLive$MedicCheckinLiveBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */