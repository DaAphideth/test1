/*    */ package nencer.app.Modules.Report.OutputProcess;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Report.Model.ExportModel;
/*    */ import nencer.app.Utils.ApiHelper;
/*    */ import nencer.app.Utils.MergeFieldDTO;
/*    */ import nencer.app.Utils.ObjectCommonUtils;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class SoTiepDonProcess
/*    */ {
/*    */   public void getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData) {
/* 15 */     MergeFieldDTO mergeFieldDTONum = new MergeFieldDTO();
/* 16 */     mergeFieldDTONum.setCode("num");
/* 17 */     mergeFieldDTONum.setValue(exportModel.getNumber() + "");
/* 18 */     mergeFieldDTONum.setMergeField("num");
/* 19 */     fieldData.add(mergeFieldDTONum);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     MergeFieldDTO mergeFieldDTO = new MergeFieldDTO();
/* 28 */     Date dt = new Date();
/* 29 */     mergeFieldDTO.setCode("day");
/* 30 */     mergeFieldDTO.setValue(ApiHelper.dateToString(dt, "dd"));
/* 31 */     mergeFieldDTO.setMergeField("day");
/* 32 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 33 */     fieldData.add(mergeFieldDTOClone);
/*    */     
/* 35 */     mergeFieldDTO.setCode("month");
/* 36 */     mergeFieldDTO.setValue(ApiHelper.dateToString(dt, "MM"));
/* 37 */     mergeFieldDTO.setMergeField("month");
/* 38 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 39 */     fieldData.add(mergeFieldDTOClone);
/*    */     
/* 41 */     mergeFieldDTO.setCode("year");
/* 42 */     mergeFieldDTO.setValue(ApiHelper.dateToString(dt, "yyyy"));
/* 43 */     mergeFieldDTO.setMergeField("year");
/* 44 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 45 */     fieldData.add(mergeFieldDTOClone);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\SoTiepDonProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */