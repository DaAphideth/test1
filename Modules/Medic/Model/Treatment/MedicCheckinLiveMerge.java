/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import java.util.List;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicCheckinLiveMerge {
/*    */   private String followDate;
/*    */   private List<MedicCheckinLiveDetailModel> liveDetailModels;
/*    */   
/* 11 */   public void setFollowDate(String followDate) { this.followDate = followDate; } public void setLiveDetailModels(List<MedicCheckinLiveDetailModel> liveDetailModels) { this.liveDetailModels = liveDetailModels; } public MedicCheckinLiveMerge(String followDate, List<MedicCheckinLiveDetailModel> liveDetailModels) {
/* 12 */     this.followDate = followDate; this.liveDetailModels = liveDetailModels;
/*    */   } public MedicCheckinLiveMerge() {}
/* 14 */   public static MedicCheckinLiveMergeBuilder builder() { return new MedicCheckinLiveMergeBuilder(); } public static class MedicCheckinLiveMergeBuilder { private String followDate; public MedicCheckinLiveMergeBuilder followDate(String followDate) { this.followDate = followDate; return this; } private List<MedicCheckinLiveDetailModel> liveDetailModels; public MedicCheckinLiveMergeBuilder liveDetailModels(List<MedicCheckinLiveDetailModel> liveDetailModels) { this.liveDetailModels = liveDetailModels; return this; } public MedicCheckinLiveMerge build() { return new MedicCheckinLiveMerge(this.followDate, this.liveDetailModels); } public String toString() { return "MedicCheckinLiveMerge.MedicCheckinLiveMergeBuilder(followDate=" + this.followDate + ", liveDetailModels=" + this.liveDetailModels + ")"; }
/*    */      }
/*    */   
/* 17 */   public String getFollowDate() { return this.followDate; } public List<MedicCheckinLiveDetailModel> getLiveDetailModels() {
/* 18 */     return this.liveDetailModels;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLiveMerge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */