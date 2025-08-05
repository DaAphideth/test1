/*    */ package nencer.app.Modules.Report.OutputProcess;
/*    */ 
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*    */ import nencer.app.Modules.Report.Model.ExportModel;
/*    */ import nencer.app.Utils.MergeFieldDTO;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class PhieuDangKyKhamProcess
/*    */   extends BaseProcess
/*    */ {
/*    */   @Autowired
/*    */   CustomerProcess customerProcess;
/*    */   
/*    */   public void getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*    */     try {
/* 21 */       List<CheckinPrintFormResponse> mcr = this.commonReportRepo.printFormResponses(exportModel.getCheckinId().intValue());
/* 22 */       if (!mcr.isEmpty())
/*    */       {
/* 24 */         for (CheckinPrintFormResponse m : mcr) {
/* 25 */           this.customerProcess.getCustomer(m, fieldData, mergeFieldDTO);
/*    */         }
/*    */       }
/* 28 */     } catch (Exception ex) {
/* 29 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 30 */       logger.error(exceptionAsString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuDangKyKhamProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */