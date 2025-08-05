/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.TransitionModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class GiayChuyenTuyenProcess
/*     */   extends BaseProcess {
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   public void getProcess(ExportModel exportModel, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  29 */       List<CheckinPrintFormResponse> examination = this.commonReportRepo.spReExamination(exportModel.getMdId().intValue());
/*  30 */       if (!examination.isEmpty())
/*     */       {
/*  32 */         for (CheckinPrintFormResponse exam : examination) {
/*  33 */           TransitionModel transitionModel = new TransitionModel();
/*  34 */           if (exam.getTransition() != null) {
/*  35 */             transitionModel = (TransitionModel)this.objectMapper.readValue(exam.getTransition(), TransitionModel.class);
/*     */           }
/*     */           
/*  38 */           String diagnostic = "";
/*  39 */           if (exam.getDiagnostic() != null) {
/*  40 */             List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(exam.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/*  43 */             diagnostic = reExam.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */           } 
/*     */           
/*  46 */           String diagnostics = "";
/*  47 */           if (exam.getDiagnosticSub() != null) {
/*  48 */             List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(exam.getDiagnosticSub(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/*  51 */             String diagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */             
/*  53 */             diagnostics = Strings.isNotBlank(diagnosticSub) ? (diagnostic + "; " + diagnosticSub) : diagnostic;
/*     */           } 
/*  55 */           String fromDate = (transitionModel.getFromDate() != null) ? ApiHelper.dateToString2(transitionModel.getFromDate()) : "0";
/*  56 */           String toDate = (transitionModel.getToDate() != null) ? ApiHelper.dateToString2(transitionModel.getToDate()) : "0";
/*     */           
/*  58 */           transition(exam, fieldData, mergeFieldDTO, calendar, transitionModel, diagnostics, fromDate, toDate);
/*     */         } 
/*     */       }
/*  61 */     } catch (Exception ex) {
/*  62 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  63 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void transition(CheckinPrintFormResponse re, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, Calendar calendar, TransitionModel exa, String diagnostics, String fromDate, String toDate) {
/*  70 */     this.customerProcess.getCustomer(re, fieldData, mergeFieldDTO);
/*     */ 
/*     */     
/*  73 */     mergeFieldDTO.setCode("diagnostic");
/*  74 */     mergeFieldDTO.setValue(diagnostics);
/*  75 */     mergeFieldDTO.setMergeField("diagnostic");
/*  76 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  77 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  80 */     mergeFieldDTO.setCode("profileNumber");
/*  81 */     mergeFieldDTO.setValue(re.getProfileNumber());
/*  82 */     mergeFieldDTO.setMergeField("profileNumber");
/*  83 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  84 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  86 */     mergeFieldDTO.setCode("transferBookNumber");
/*  87 */     mergeFieldDTO.setValue(re.getTransferBookNumber());
/*  88 */     mergeFieldDTO.setMergeField("transferBookNumber");
/*  89 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  93 */     mergeFieldDTO.setCode("fromDate");
/*  94 */     mergeFieldDTO.setValue(fromDate);
/*  95 */     mergeFieldDTO.setMergeField("fromDate");
/*  96 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  97 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  99 */     mergeFieldDTO.setCode("toDate");
/* 100 */     mergeFieldDTO.setValue(toDate);
/* 101 */     mergeFieldDTO.setMergeField("toDate");
/* 102 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 103 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 105 */     mergeFieldDTO.setCode("clinicalSigns");
/* 106 */     mergeFieldDTO.setValue(exa.getClinicalSigns());
/* 107 */     mergeFieldDTO.setMergeField("clinicalSigns");
/* 108 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 109 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 112 */     mergeFieldDTO.setCode("clinicalResults");
/* 113 */     mergeFieldDTO.setValue(exa.getClinicalResults());
/* 114 */     mergeFieldDTO.setMergeField("clinicalResults");
/* 115 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 116 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 118 */     mergeFieldDTO.setCode("technicalMethod");
/* 119 */     mergeFieldDTO.setValue(exa.getTechnicalMethod());
/* 120 */     mergeFieldDTO.setMergeField("technicalMethod");
/* 121 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 122 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 124 */     mergeFieldDTO.setCode("patientCondition");
/* 125 */     mergeFieldDTO.setValue(exa.getPatientCondition());
/* 126 */     mergeFieldDTO.setMergeField("patientCondition");
/* 127 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 128 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 130 */     mergeFieldDTO.setCode("directionTreatment");
/* 131 */     mergeFieldDTO.setValue(exa.getDirectionTreatment());
/* 132 */     mergeFieldDTO.setMergeField("directionTreatment");
/* 133 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 134 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     mergeFieldDTO.setCode("transitTimeDay");
/* 144 */     mergeFieldDTO.setValue(ApiHelper.dateToString(exa.getTransitTime(), "dd"));
/* 145 */     mergeFieldDTO.setMergeField("transitTimeDay");
/* 146 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 147 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 149 */     mergeFieldDTO.setCode("transitTimeMonth");
/* 150 */     mergeFieldDTO.setValue(ApiHelper.dateToString(exa.getTransitTime(), "MM"));
/* 151 */     mergeFieldDTO.setMergeField("transitTimeMonth");
/* 152 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 153 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 155 */     mergeFieldDTO.setCode("transitTimeYear");
/* 156 */     mergeFieldDTO.setValue(ApiHelper.dateToString(exa.getTransitTime(), "yyyy"));
/* 157 */     mergeFieldDTO.setMergeField("transitTimeYear");
/* 158 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 159 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 162 */     mergeFieldDTO.setCode("gioRaVien");
/* 163 */     mergeFieldDTO.setValue(re.getHourDischarge());
/* 164 */     mergeFieldDTO.setMergeField("gioRaVien");
/* 165 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 166 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 168 */     mergeFieldDTO.setCode("ngayRaVien");
/* 169 */     mergeFieldDTO.setValue(re.getDayDischarge());
/* 170 */     mergeFieldDTO.setMergeField("ngayRaVien");
/* 171 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 172 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 175 */     mergeFieldDTO.setCode("thangRaVien");
/* 176 */     mergeFieldDTO.setValue(re.getMonthDischarge());
/* 177 */     mergeFieldDTO.setMergeField("thangRaVien");
/* 178 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 179 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 181 */     mergeFieldDTO.setCode("namRaVien");
/* 182 */     mergeFieldDTO.setValue(re.getYearDischarge());
/* 183 */     mergeFieldDTO.setMergeField("namRaVien");
/* 184 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 185 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 188 */     mergeFieldDTO.setCode("transportation");
/* 189 */     mergeFieldDTO.setValue(exa.getTransportation());
/* 190 */     mergeFieldDTO.setMergeField("transportation");
/* 191 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 192 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 194 */     mergeFieldDTO.setCode("personName");
/* 195 */     mergeFieldDTO.setValue(exa.getPersonName());
/* 196 */     mergeFieldDTO.setMergeField("personName");
/* 197 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 198 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 200 */     mergeFieldDTO.setCode("transitPerson");
/* 201 */     mergeFieldDTO.setValue(exa.getTransitPerson());
/* 202 */     mergeFieldDTO.setMergeField("transitPerson");
/* 203 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 204 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 206 */     mergeFieldDTO.setCode("referralHospital");
/* 207 */     mergeFieldDTO.setValue(exa.getReferralHospitalName());
/* 208 */     mergeFieldDTO.setMergeField("referralHospital");
/* 209 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 210 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 213 */     mergeFieldDTO.setCode("transitReason");
/* 214 */     mergeFieldDTO.setValue(exa.getTransitReasonName());
/* 215 */     mergeFieldDTO.setMergeField("transitReason");
/* 216 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 217 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\GiayChuyenTuyenProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */