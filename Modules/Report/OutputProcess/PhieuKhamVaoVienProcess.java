/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Modules.Report.Model.ExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class PhieuKhamVaoVienProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   public void getProcess(ExportModel exportModel, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  29 */       List<CheckinPrintFormResponse> exa = this.commonReportRepo.spGetExamination(exportModel.getMdId().intValue());
/*  30 */       if (!exa.isEmpty())
/*     */       {
/*  32 */         for (CheckinPrintFormResponse e : exa) {
/*  33 */           ExaminationModel examination = new ExaminationModel();
/*  34 */           String getDiagnosticSub = "";
/*  35 */           if (e.getExamination() != null) {
/*  36 */             examination = (ExaminationModel)this.objectMapper.readValue(e.getExamination(), ExaminationModel.class);
/*     */             
/*  38 */             getDiagnosticSub = examination.getDiagnosticSubArray().stream().filter(er -> StringUtils.isNotBlank(er.getCode())).map(ReExaminationModel::toString).collect(Collectors.joining("\n"));
/*     */           } 
/*  40 */           process(e, fieldData, mergeFieldDTO, calendar, examination, getDiagnosticSub);
/*     */         } 
/*     */       }
/*  43 */     } catch (Exception ex) {
/*  44 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  45 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(CheckinPrintFormResponse re, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, Calendar calendar, ExaminationModel exa, String getDiagnosticSub) {
/*  51 */     this.customerProcess.getCustomer(re, fieldData, mergeFieldDTO);
/*     */     
/*  53 */     mergeFieldDTO.setCode("diagnostic");
/*  54 */     mergeFieldDTO.setValue((exa.getDiagnosticCode() != null) ? (exa.getDiagnosticCode() + " - " + exa.getDiagnosticName()) : "");
/*  55 */     mergeFieldDTO.setMergeField("diagnostic");
/*  56 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  57 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  59 */     mergeFieldDTO.setCode("diagnosticSub");
/*  60 */     mergeFieldDTO.setValue(getDiagnosticSub);
/*  61 */     mergeFieldDTO.setMergeField("diagnosticSub");
/*  62 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  63 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  66 */     mergeFieldDTO.setCode("reason");
/*  67 */     mergeFieldDTO.setValue(exa.getReason());
/*  68 */     mergeFieldDTO.setMergeField("reason");
/*  69 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  70 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  72 */     mergeFieldDTO.setCode("transitReason");
/*  73 */     mergeFieldDTO.setValue(exa.getTransitReason());
/*  74 */     mergeFieldDTO.setMergeField("transitReason");
/*  75 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  76 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  79 */     mergeFieldDTO.setCode("pathologicalProcess");
/*  80 */     mergeFieldDTO.setValue(exa.getPathologicalProcess());
/*  81 */     mergeFieldDTO.setMergeField("pathologicalProcess");
/*  82 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  83 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  86 */     mergeFieldDTO.setCode("personalHistory");
/*  87 */     mergeFieldDTO.setValue(exa.getPersonalHistory());
/*  88 */     mergeFieldDTO.setMergeField("personalHistory");
/*  89 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  92 */     mergeFieldDTO.setCode("familyHistory");
/*  93 */     mergeFieldDTO.setValue(exa.getFamilyHistory());
/*  94 */     mergeFieldDTO.setMergeField("familyHistory");
/*  95 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  96 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  98 */     mergeFieldDTO.setCode("examination");
/*  99 */     mergeFieldDTO.setValue(exa.getExamination());
/* 100 */     mergeFieldDTO.setMergeField("examination");
/* 101 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 102 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 104 */     mergeFieldDTO.setCode("partsExamination");
/* 105 */     mergeFieldDTO.setValue(exa.getPartsExamination());
/* 106 */     mergeFieldDTO.setMergeField("partsExamination");
/* 107 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 108 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 110 */     mergeFieldDTO.setCode("circuit");
/* 111 */     mergeFieldDTO.setValue(exa.getCircuit());
/* 112 */     mergeFieldDTO.setMergeField("circuit");
/* 113 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 114 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 116 */     mergeFieldDTO.setCode("temperature");
/* 117 */     mergeFieldDTO.setValue(exa.getTemperature());
/* 118 */     mergeFieldDTO.setMergeField("temperature");
/* 119 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 120 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 122 */     mergeFieldDTO.setCode("bloodPressure");
/* 123 */     mergeFieldDTO.setValue(exa.getBloodPressure());
/* 124 */     mergeFieldDTO.setMergeField("bloodPressure");
/* 125 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 126 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 128 */     mergeFieldDTO.setCode("breathing");
/* 129 */     mergeFieldDTO.setValue(exa.getBreathing());
/* 130 */     mergeFieldDTO.setMergeField("breathing");
/* 131 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 132 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 134 */     mergeFieldDTO.setCode("sp02");
/* 135 */     mergeFieldDTO.setValue(exa.getSp02());
/* 136 */     mergeFieldDTO.setMergeField("sp02");
/* 137 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 138 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 140 */     mergeFieldDTO.setCode("weight");
/* 141 */     mergeFieldDTO.setValue(exa.getWeight());
/* 142 */     mergeFieldDTO.setMergeField("weight");
/* 143 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 144 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 146 */     mergeFieldDTO.setCode("height");
/* 147 */     mergeFieldDTO.setValue(exa.getHeight());
/* 148 */     mergeFieldDTO.setMergeField("height");
/* 149 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 150 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 152 */     mergeFieldDTO.setCode("bmi");
/* 153 */     mergeFieldDTO.setValue(exa.getBmi());
/* 154 */     mergeFieldDTO.setMergeField("bmi");
/* 155 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 156 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 158 */     mergeFieldDTO.setCode("hospitalTime");
/* 159 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(re.getCreatedDate()));
/* 160 */     mergeFieldDTO.setMergeField("hospitalTime");
/* 161 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 162 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 164 */     mergeFieldDTO.setCode("diagnosisReferral");
/* 165 */     mergeFieldDTO.setValue(re.getDiagnosisReferral());
/* 166 */     mergeFieldDTO.setMergeField("diagnosisReferral");
/* 167 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 168 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 170 */     mergeFieldDTO.setCode("technicalMethod");
/* 171 */     mergeFieldDTO.setValue(re.getTechnicalMethod());
/* 172 */     mergeFieldDTO.setMergeField("technicalMethod");
/* 173 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 174 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 176 */     mergeFieldDTO.setCode("treatmentDepartment");
/* 177 */     mergeFieldDTO.setValue(re.getTreatmentDepartment());
/* 178 */     mergeFieldDTO.setMergeField("treatmentDepartment");
/* 179 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 180 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuKhamVaoVienProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */