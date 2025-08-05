/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.util.List;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.PtttInfo;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class GiayChungNhanPTTTProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  21 */       PtttInfo ptttInfo = this.commonReportRepo.spGetPtttInfo(exportModel.getTicketId(), exportModel.getOrderServiceId());
/*  22 */       ptttMergeFields(mergeFieldDTO, fieldData, ptttInfo);
/*  23 */     } catch (Exception ex) {
/*  24 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  25 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void ptttMergeFields(MergeFieldDTO mergeFieldDTO, List<MergeFieldDTO> fieldData, PtttInfo ptttInfo) {
/*  31 */     mergeFieldDTO.setCode("soYte");
/*  32 */     mergeFieldDTO.setValue(ptttInfo.getSoYte());
/*  33 */     mergeFieldDTO.setMergeField("soYte");
/*  34 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  35 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  37 */     mergeFieldDTO.setCode("hospitalName");
/*  38 */     mergeFieldDTO.setValue(ptttInfo.getHospitalName());
/*  39 */     mergeFieldDTO.setMergeField("hospitalName");
/*  40 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  41 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  43 */     mergeFieldDTO.setCode("customerId");
/*  44 */     mergeFieldDTO.setValue(ptttInfo.getCustomerId());
/*  45 */     mergeFieldDTO.setMergeField("customerId");
/*  46 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  47 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  49 */     mergeFieldDTO.setCode("vpId");
/*  50 */     mergeFieldDTO.setValue(ptttInfo.getVpId());
/*  51 */     mergeFieldDTO.setMergeField("vpId");
/*  52 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  53 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  55 */     mergeFieldDTO.setCode("hospitalName");
/*  56 */     mergeFieldDTO.setValue(ptttInfo.getHospitalName());
/*  57 */     mergeFieldDTO.setMergeField("hospitalName");
/*  58 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  59 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  61 */     mergeFieldDTO.setCode("customerName");
/*  62 */     mergeFieldDTO.setValue(ptttInfo.getCustomerName());
/*  63 */     mergeFieldDTO.setMergeField("customerName");
/*  64 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  65 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  67 */     mergeFieldDTO.setCode("customerAge");
/*  68 */     mergeFieldDTO.setValue(ptttInfo.getCustomerAge());
/*  69 */     mergeFieldDTO.setMergeField("customerAge");
/*  70 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  71 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  73 */     mergeFieldDTO.setCode("customerGender");
/*  74 */     mergeFieldDTO.setValue(ptttInfo.getCustomerGender());
/*  75 */     mergeFieldDTO.setMergeField("customerGender");
/*  76 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  77 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  79 */     mergeFieldDTO.setCode("customerAddress");
/*  80 */     mergeFieldDTO.setValue(ptttInfo.getCustomerAddress());
/*  81 */     mergeFieldDTO.setMergeField("customerAddress");
/*  82 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  83 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  85 */     mergeFieldDTO.setCode("serviceName");
/*  86 */     mergeFieldDTO.setValue(ptttInfo.getServiceName());
/*  87 */     mergeFieldDTO.setMergeField("serviceName");
/*  88 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  89 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  91 */     mergeFieldDTO.setCode("bloodGroup");
/*  92 */     mergeFieldDTO.setValue(ptttInfo.getBloodGroup());
/*  93 */     mergeFieldDTO.setMergeField("bloodGroup");
/*  94 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  95 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  97 */     mergeFieldDTO.setCode("rh");
/*  98 */     mergeFieldDTO.setValue(ptttInfo.getRh());
/*  99 */     mergeFieldDTO.setMergeField("rh");
/* 100 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 101 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 103 */     mergeFieldDTO.setCode("predictTime");
/* 104 */     mergeFieldDTO.setValue(ptttInfo.getPredictTime());
/* 105 */     mergeFieldDTO.setMergeField("predictTime");
/* 106 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 109 */     mergeFieldDTO.setCode("startTime");
/* 110 */     mergeFieldDTO.setValue(ptttInfo.getStartTime());
/* 111 */     mergeFieldDTO.setMergeField("startTime");
/* 112 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 113 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 115 */     mergeFieldDTO.setCode("endTime");
/* 116 */     mergeFieldDTO.setValue(ptttInfo.getEndTime());
/* 117 */     mergeFieldDTO.setMergeField("endTime");
/* 118 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 119 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 121 */     mergeFieldDTO.setCode("diagnosticCode");
/* 122 */     mergeFieldDTO.setValue(ptttInfo.getDiagnosticCode());
/* 123 */     mergeFieldDTO.setMergeField("diagnosticCode");
/* 124 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 125 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 127 */     mergeFieldDTO.setCode("diagnosticName");
/* 128 */     mergeFieldDTO.setValue(ptttInfo.getDiagnosticName());
/* 129 */     mergeFieldDTO.setMergeField("diagnosticName");
/* 130 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 131 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 133 */     mergeFieldDTO.setCode("departmentName");
/* 134 */     mergeFieldDTO.setValue(ptttInfo.getDepartmentName());
/* 135 */     mergeFieldDTO.setMergeField("departmentName");
/* 136 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 137 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 139 */     mergeFieldDTO.setCode("ptttProcedure");
/* 140 */     mergeFieldDTO.setValue(ptttInfo.getPtttProcedure());
/* 141 */     mergeFieldDTO.setMergeField("ptttProcedure");
/* 142 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 143 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 145 */     mergeFieldDTO.setCode("ptttType");
/* 146 */     mergeFieldDTO.setValue(ptttInfo.getPtttType());
/* 147 */     mergeFieldDTO.setMergeField("ptttType");
/* 148 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 149 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 151 */     mergeFieldDTO.setCode("bspt1");
/* 152 */     mergeFieldDTO.setValue(ptttInfo.getBspt1());
/* 153 */     mergeFieldDTO.setMergeField("bspt1");
/* 154 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 155 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 157 */     mergeFieldDTO.setCode("bspt2");
/* 158 */     mergeFieldDTO.setValue(ptttInfo.getBspt2());
/* 159 */     mergeFieldDTO.setMergeField("bspt2");
/* 160 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 161 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 163 */     mergeFieldDTO.setCode("pm1");
/* 164 */     mergeFieldDTO.setValue(ptttInfo.getPm1());
/* 165 */     mergeFieldDTO.setMergeField("pm1");
/* 166 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 167 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 169 */     mergeFieldDTO.setCode("pm2");
/* 170 */     mergeFieldDTO.setValue(ptttInfo.getPm2());
/* 171 */     mergeFieldDTO.setMergeField("pm2");
/* 172 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 173 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 175 */     mergeFieldDTO.setCode("pm3");
/* 176 */     mergeFieldDTO.setValue(ptttInfo.getPm3());
/* 177 */     mergeFieldDTO.setMergeField("pm3");
/* 178 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 179 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 181 */     mergeFieldDTO.setCode("pm4");
/* 182 */     mergeFieldDTO.setValue(ptttInfo.getPm4());
/* 183 */     mergeFieldDTO.setMergeField("pm4");
/* 184 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 185 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 187 */     mergeFieldDTO.setCode("pm5");
/* 188 */     mergeFieldDTO.setValue(ptttInfo.getPm5());
/* 189 */     mergeFieldDTO.setMergeField("pm5");
/* 190 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 191 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 193 */     mergeFieldDTO.setCode("gme1");
/* 194 */     mergeFieldDTO.setValue(ptttInfo.getGme1());
/* 195 */     mergeFieldDTO.setMergeField("gme1");
/* 196 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 197 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 199 */     mergeFieldDTO.setCode("gme2");
/* 200 */     mergeFieldDTO.setValue(ptttInfo.getGme2());
/* 201 */     mergeFieldDTO.setMergeField("gme2");
/* 202 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 203 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 205 */     mergeFieldDTO.setCode("emotionlessMethod");
/* 206 */     mergeFieldDTO.setValue((ptttInfo.getEmotionlessMethod() == null) ? ptttInfo.getEmotionlessMethod() : "");
/* 207 */     mergeFieldDTO.setMergeField("emotionlessMethod");
/* 208 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 209 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 211 */     mergeFieldDTO.setCode("description");
/* 212 */     mergeFieldDTO.setValue(ptttInfo.getDescription());
/* 213 */     mergeFieldDTO.setMergeField("description");
/* 214 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 215 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 217 */     mergeFieldDTO.setCode("day");
/* 218 */     mergeFieldDTO.setValue(ptttInfo.getDay());
/* 219 */     mergeFieldDTO.setMergeField("day");
/* 220 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 221 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 223 */     mergeFieldDTO.setCode("month");
/* 224 */     mergeFieldDTO.setValue(ptttInfo.getMonth());
/* 225 */     mergeFieldDTO.setMergeField("month");
/* 226 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 227 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 229 */     mergeFieldDTO.setCode("year");
/* 230 */     mergeFieldDTO.setValue(ptttInfo.getYear());
/* 231 */     mergeFieldDTO.setMergeField("year");
/* 232 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 233 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 235 */     mergeFieldDTO.setCode("checkinId");
/* 236 */     mergeFieldDTO.setValue(ptttInfo.getCheckinId());
/* 237 */     mergeFieldDTO.setMergeField("checkinId");
/* 238 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 239 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\GiayChungNhanPTTTProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */