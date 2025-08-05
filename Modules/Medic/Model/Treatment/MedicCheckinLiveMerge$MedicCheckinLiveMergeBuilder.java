/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedicCheckinLiveMergeBuilder
/*    */ {
/*    */   private String followDate;
/*    */   private List<MedicCheckinLiveDetailModel> liveDetailModels;
/*    */   
/*    */   public MedicCheckinLiveMergeBuilder followDate(String followDate) {
/* 14 */     this.followDate = followDate; return this; } public MedicCheckinLiveMergeBuilder liveDetailModels(List<MedicCheckinLiveDetailModel> liveDetailModels) { this.liveDetailModels = liveDetailModels; return this; } public MedicCheckinLiveMerge build() { return new MedicCheckinLiveMerge(this.followDate, this.liveDetailModels); } public String toString() { return "MedicCheckinLiveMerge.MedicCheckinLiveMergeBuilder(followDate=" + this.followDate + ", liveDetailModels=" + this.liveDetailModels + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicCheckinLiveMerge$MedicCheckinLiveMergeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */