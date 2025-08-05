/*    */ package nencer.app.Modules.Report.OutputProcess;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Report.Model.ExportModel;
/*    */ import nencer.app.Modules.Report.Model.ResultTimeModel;
/*    */ import nencer.app.Utils.ApiHelper;
/*    */ import nencer.app.Utils.MergeFieldDTO;
/*    */ import nencer.app.Utils.ObjectCommonUtils;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class HenGioTraKetQuaProcess
/*    */   extends BaseProcess
/*    */ {
/*    */   public String getProcess(ExportModel exportModel, String contentBarCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*    */     try {
/* 20 */       List<ResultTimeModel> timeModels = this.commonReportRepo.sp_get_result_time_and_barCode(exportModel.getTicketId().intValue());
/* 21 */       if (!timeModels.isEmpty()) {
/* 22 */         for (ResultTimeModel model : timeModels) {
/* 23 */           contentBarCode = model.getBarCode();
/* 24 */           process(model, fieldData, mergeFieldDTO);
/*    */         } 
/*    */       }
/* 27 */       return contentBarCode;
/* 28 */     } catch (Exception ex) {
/* 29 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 30 */       logger.error(exceptionAsString);
/* 31 */       return contentBarCode;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void process(ResultTimeModel timeModel, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/* 36 */     int addHouse = (timeModel.getDefaultValue() != null) ? Integer.parseInt(timeModel.getDefaultValue()) : 0;
/* 37 */     Date resultTime = ApiHelper.addHoursToJavaUtilDate(timeModel.getRoomSampleDate(), addHouse);
/*    */     
/* 39 */     mergeFieldDTO.setCode("customerName");
/* 40 */     mergeFieldDTO.setValue(timeModel.getName());
/* 41 */     mergeFieldDTO.setMergeField("customerName");
/* 42 */     MergeFieldDTO fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 43 */     fieldData.add(fieldDTO);
/*    */     
/* 45 */     mergeFieldDTO.setCode("patientId");
/* 46 */     mergeFieldDTO.setValue(timeModel.getPatientId());
/* 47 */     mergeFieldDTO.setMergeField("patientId");
/* 48 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 49 */     fieldData.add(fieldDTO);
/*    */     
/* 51 */     mergeFieldDTO.setCode("gender");
/* 52 */     mergeFieldDTO.setValue(timeModel.getGender());
/* 53 */     mergeFieldDTO.setMergeField("gender");
/* 54 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 55 */     fieldData.add(fieldDTO);
/*    */     
/* 57 */     mergeFieldDTO.setCode("age");
/* 58 */     mergeFieldDTO.setValue(timeModel.getYearBorn());
/* 59 */     mergeFieldDTO.setMergeField("age");
/* 60 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 61 */     fieldData.add(fieldDTO);
/*    */     
/* 63 */     mergeFieldDTO.setCode("resultTime");
/* 64 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(resultTime));
/* 65 */     mergeFieldDTO.setMergeField("resultTime");
/* 66 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 67 */     fieldData.add(fieldDTO);
/*    */     
/* 69 */     mergeFieldDTO.setCode("roomName");
/* 70 */     mergeFieldDTO.setValue(timeModel.getRoomName());
/* 71 */     mergeFieldDTO.setMergeField("roomName");
/* 72 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 73 */     fieldData.add(fieldDTO);
/*    */     
/* 75 */     mergeFieldDTO.setCode("roomNumber");
/* 76 */     mergeFieldDTO.setValue(timeModel.getRoomNumber());
/* 77 */     mergeFieldDTO.setMergeField("roomNumber");
/* 78 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 79 */     fieldData.add(fieldDTO);
/*    */     
/* 81 */     mergeFieldDTO.setCode("createDate");
/* 82 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(timeModel.getRoomSampleDate()));
/* 83 */     mergeFieldDTO.setMergeField("createDate");
/* 84 */     fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 85 */     fieldData.add(fieldDTO);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\HenGioTraKetQuaProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */