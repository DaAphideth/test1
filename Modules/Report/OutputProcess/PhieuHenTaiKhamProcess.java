/*    */ package nencer.app.Modules.Report.OutputProcess;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import java.util.Calendar;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*    */ import nencer.app.Modules.Report.Model.ExportModel;
/*    */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*    */ import nencer.app.Utils.ApiHelper;
/*    */ import nencer.app.Utils.MergeFieldDTO;
/*    */ import nencer.app.Utils.ObjectCommonUtils;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class PhieuHenTaiKhamProcess
/*    */   extends BaseProcess
/*    */ {
/*    */   @Autowired
/*    */   CustomerProcess customerProcess;
/*    */   
/*    */   public void getProcess(ExportModel exportModel, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*    */     try {
/* 29 */       List<CheckinPrintFormResponse> ree = this.commonReportRepo.spReExamination(exportModel.getMdId().intValue());
/* 30 */       if (!ree.isEmpty())
/*    */       {
/* 32 */         for (CheckinPrintFormResponse re : ree) {
/* 33 */           String appointmentDay; List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(re.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {  }
/*    */             );
/* 35 */           List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(re.getDiagnosticSub(), new TypeReference<List<ReExaminationModel>>() {
/*    */               
/*    */               });
/* 38 */           String getDiagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("\n"));
/*    */           
/* 40 */           if (re.getDeliveryOfPrescription() != null) {
/* 41 */             ReExaminationModel appointment = (ReExaminationModel)this.objectMapper.readValue(re.getDeliveryOfPrescription(), ReExaminationModel.class);
/* 42 */             appointmentDay = (appointment.getAppointmentDay() != null) ? appointment.getAppointmentDay() : "10";
/*    */           } else {
/* 44 */             appointmentDay = "10";
/*    */           } 
/* 46 */           process(re, fieldData, mergeFieldDTO, calendar, reExam, getDiagnosticSub, appointmentDay);
/*    */         } 
/*    */       }
/* 49 */     } catch (Exception ex) {
/* 50 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 51 */       logger.error(exceptionAsString);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void process(CheckinPrintFormResponse re, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, Calendar calendar, List<ReExaminationModel> reExam, String getDiagnosticSub, String appointmentDay) {
/* 59 */     this.customerProcess.getCustomer(re, fieldData, mergeFieldDTO);
/*    */     
/* 61 */     mergeFieldDTO.setCode("diagnostic");
/* 62 */     mergeFieldDTO.setValue(((ReExaminationModel)reExam.get(0)).getCode() + " - " + ((ReExaminationModel)reExam.get(0)).getName());
/* 63 */     mergeFieldDTO.setMergeField("diagnostic");
/* 64 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 65 */     fieldData.add(mergeFieldDTOClone);
/*    */     
/* 67 */     mergeFieldDTO.setCode("diagnosticSub");
/* 68 */     mergeFieldDTO.setValue(getDiagnosticSub);
/* 69 */     mergeFieldDTO.setMergeField("diagnosticSub");
/* 70 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 71 */     fieldData.add(mergeFieldDTOClone);
/*    */ 
/*    */     
/* 74 */     mergeFieldDTO.setCode("createDate");
/* 75 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(re.getCreatedDate()));
/* 76 */     mergeFieldDTO.setMergeField("createDate");
/* 77 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 78 */     fieldData.add(mergeFieldDTOClone);
/*    */ 
/*    */     
/* 81 */     mergeFieldDTO.setCode("appointmentDate");
/* 82 */     mergeFieldDTO.setValue(ApiHelper.dateToString2(ApiHelper.addDay(re.getCreatedDate(), Integer.parseInt(appointmentDay))));
/* 83 */     mergeFieldDTO.setMergeField("appointmentDate");
/* 84 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 85 */     fieldData.add(mergeFieldDTOClone);
/*    */ 
/*    */     
/* 88 */     mergeFieldDTO.setCode("appointmentDay");
/* 89 */     mergeFieldDTO.setValue(appointmentDay);
/* 90 */     mergeFieldDTO.setMergeField("appointmentDay");
/* 91 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 92 */     fieldData.add(mergeFieldDTOClone);
/*    */ 
/*    */     
/* 95 */     mergeFieldDTO.setCode("hospitalRepresentative");
/* 96 */     mergeFieldDTO.setValue(re.getHospitalRepresentative());
/* 97 */     mergeFieldDTO.setMergeField("hospitalRepresentative");
/* 98 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 99 */     fieldData.add(mergeFieldDTOClone);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuHenTaiKhamProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */