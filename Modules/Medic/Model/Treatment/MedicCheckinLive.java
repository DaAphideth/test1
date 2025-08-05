/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicCheckinLive {
/*    */   private List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges;
/*    */   private Map<String, Object> customerData;
/*    */   
/* 11 */   public void setMedicCheckinLiveMerges(List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges) { this.medicCheckinLiveMerges = medicCheckinLiveMerges; } public void setCustomerData(Map<String, Object> customerData) { this.customerData = customerData; } public MedicCheckinLive(List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges, Map<String, Object> customerData) {
/* 12 */     this.medicCheckinLiveMerges = medicCheckinLiveMerges; this.customerData = customerData;
/*    */   } public MedicCheckinLive() {}
/* 14 */   public static MedicCheckinLiveBuilder builder() { return new MedicCheckinLiveBuilder(); } public static class MedicCheckinLiveBuilder { private List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges; public MedicCheckinLiveBuilder medicCheckinLiveMerges(List<MedicCheckinLiveDetailModel> medicCheckinLiveMerges) { this.medicCheckinLiveMerges = medicCheckinLiveMerges; return this; } private Map<String, Object> customerData; public MedicCheckinLiveBuilder customerData(Map<String, Object> customerData) { this.customerData = customerData; return this; } public MedicCheckinLive build() { return new MedicCheckinLive(this.medicCheckinLiveMerges, this.customerData); } public String toString() { return "MedicCheckinLive.MedicCheckinLiveBuilder(medicCheckinLiveMerges=" + this.medicCheckinLiveMerges + ", customerData=" + this.customerData + ")"; }
/*    */      }
/* 16 */   public List<MedicCheckinLiveDetailModel> getMedicCheckinLiveMerges() { return this.medicCheckinLiveMerges; } public Map<String, Object> getCustomerData() {
/* 17 */     return this.customerData;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLive.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */