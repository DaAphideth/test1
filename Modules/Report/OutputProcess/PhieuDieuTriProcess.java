/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Modules.Report.Model.DienBienBenhModel;
/*     */ import nencer.app.Modules.Report.Model.ExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.TreatmentDetailModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.PhieuDieuTriModel;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class PhieuDieuTriProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public String getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  29 */       PhieuDieuTriModel phieuDieuTriModel = new PhieuDieuTriModel();
/*  30 */       if (exportModel.getOrderId() != null) {
/*  31 */         phieuDieuTriModel = this.commonReportRepo.getPhieuDieuTri(exportModel.getMdId(), exportModel.getOrderId());
/*     */       } else {
/*  33 */         phieuDieuTriModel = this.commonReportRepo.getPhieuDieuTriDateFromTo(exportModel.getMdId(), exportModel.getStartDate(), exportModel.getEndDate());
/*     */       } 
/*  35 */       List<MdmHeaderModel> headerPhieuDieuTriRes = phieuDieuTriModel.getMdmHeaderModel();
/*  36 */       List<CustomerModel> customerPhieuDieutriRes = phieuDieuTriModel.getCustomerModel();
/*  37 */       List<TreatmentDetailModel> treatmentDetailModels = phieuDieuTriModel.getTreatmentDetailModels();
/*  38 */       return process(barCode, fieldData, mergeFieldDTO, headerPhieuDieuTriRes, customerPhieuDieutriRes, treatmentDetailModels);
/*  39 */     } catch (Exception ex) {
/*  40 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  41 */       logger.error(exceptionAsString);
/*  42 */       return barCode;
/*     */     } 
/*     */   } @Autowired
/*     */   MedicService medicService;
/*     */   private String process(String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, List<TreatmentDetailModel> treatmentDetailModels) throws JsonProcessingException {
/*  47 */     if (!headerCDHARes.isEmpty()) {
/*  48 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  49 */       mergeFieldDTO.setCode("soYTe");
/*  50 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  51 */       mergeFieldDTO.setMergeField("soYTe");
/*  52 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  53 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  55 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  56 */       mergeFieldDTO.setCode("tenBV");
/*  57 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  58 */       mergeFieldDTO.setMergeField("tenBV");
/*  59 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  60 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  62 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  63 */       mergeFieldDTO.setCode("diaChiBV");
/*  64 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  65 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  66 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  67 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  69 */     if (!customerCDHARes.isEmpty()) {
/*     */       
/*  71 */       CustomerModel customerModel = customerCDHARes.get(0);
/*  72 */       barCode = customerModel.getPatientId();
/*  73 */       mergeFieldDTO.setCode("maBN");
/*  74 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/*  75 */       mergeFieldDTO.setMergeField("maBN");
/*  76 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  77 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  79 */       mergeFieldDTO.setCode("hoVaTen");
/*  80 */       mergeFieldDTO.setValue(customerModel.getName());
/*  81 */       mergeFieldDTO.setMergeField("hoVaTen");
/*  82 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  83 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  85 */       mergeFieldDTO.setCode("namSinh");
/*  86 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/*  87 */       mergeFieldDTO.setMergeField("namSinh");
/*  88 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  89 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  91 */       mergeFieldDTO.setCode("tuoi");
/*  92 */       mergeFieldDTO.setValue(customerModel.getAge());
/*  93 */       mergeFieldDTO.setMergeField("tuoi");
/*  94 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  95 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  97 */       mergeFieldDTO.setCode("gioiTinh");
/*  98 */       mergeFieldDTO.setValue(customerModel.getGender());
/*  99 */       mergeFieldDTO.setMergeField("gioiTinh");
/* 100 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 101 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 103 */       mergeFieldDTO.setCode("diaChiBN");
/* 104 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 105 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 106 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 109 */       mergeFieldDTO.setCode("noiChiDinh");
/* 110 */       mergeFieldDTO.setValue(customerModel.getRoomName());
/* 111 */       mergeFieldDTO.setMergeField("noiChiDinh");
/* 112 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 113 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 115 */       mergeFieldDTO.setCode("giuongBenh");
/* 116 */       mergeFieldDTO.setValue(customerModel.getBedName());
/* 117 */       mergeFieldDTO.setMergeField("giuongBenh");
/* 118 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 119 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 121 */       mergeFieldDTO.setCode("buongBenh");
/* 122 */       mergeFieldDTO.setValue(customerModel.getChamberName());
/* 123 */       mergeFieldDTO.setMergeField("buongBenh");
/* 124 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 125 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 128 */       if (StringUtils.isNotBlank(customerModel.getExaminationArray())) {
/* 129 */         ExaminationModel examination = (ExaminationModel)this.objectMapper.readValue(customerModel.getExaminationArray(), ExaminationModel.class);
/* 130 */         if (examination != null) {
/*     */           
/* 132 */           String getDiagnosticSub = examination.getDiagnosticSubArray().stream().filter(er -> StringUtils.isNotBlank(er.getCode())).map(ReExaminationModel::toString).collect(Collectors.joining(";"));
/* 133 */           mergeFieldDTO.setCode("chanDoan");
/* 134 */           String x = StringUtils.isNotBlank(examination.getDiagnosticName()) ? examination.getDiagnosticName() : "";
/* 135 */           mergeFieldDTO.setValue(examination.getDiagnosticCode() + "-" + x + ";" + getDiagnosticSub);
/* 136 */           mergeFieldDTO.setMergeField("chanDoan");
/* 137 */           mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 138 */           fieldData.add(mergeFieldDTOClone);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 143 */       mergeFieldDTO.setCode("tenKhoa");
/* 144 */       mergeFieldDTO.setValue(customerModel.getDepartmentName());
/* 145 */       mergeFieldDTO.setMergeField("tenKhoa");
/* 146 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 147 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 150 */     if (!treatmentDetailModels.isEmpty())
/*     */     {
/* 152 */       for (TreatmentDetailModel osm : treatmentDetailModels) {
/* 153 */         MergeFieldDTO mfd = new MergeFieldDTO();
/* 154 */         mfd.setCode("«start»");
/* 155 */         mfd.setIsGroup(Boolean.valueOf(true));
/* 156 */         mfd.setIsMultiple(Boolean.valueOf(true));
/* 157 */         mfd.setStartGroup("«start»");
/* 158 */         mfd.setEndGroup("«end»");
/*     */         
/* 160 */         List<MergeFieldDTO> children = new ArrayList<>();
/* 161 */         MergeFieldDTO model = new MergeFieldDTO();
/* 162 */         MergeFieldDTO fieldDTO = model;
/* 163 */         model = new MergeFieldDTO();
/* 164 */         model.setCode("ngayGio");
/* 165 */         model.setValue(osm.getCreatedDate());
/* 166 */         model.setMergeField("ngayGio");
/* 167 */         fieldDTO = model;
/* 168 */         children.add(fieldDTO);
/*     */         
/* 170 */         DienBienBenhModel dienBienBenhModel = (DienBienBenhModel)this.objectMapper.readValue(osm.getDienBienBenh(), DienBienBenhModel.class);
/* 171 */         if (dienBienBenhModel != null) {
/*     */           
/* 173 */           model = new MergeFieldDTO();
/* 174 */           model.setCode("khamBenh");
/* 175 */           model.setValue(dienBienBenhModel.getExam());
/* 176 */           model.setMergeField("khamBenh");
/* 177 */           fieldDTO = model;
/* 178 */           children.add(fieldDTO);
/*     */           
/* 180 */           model = new MergeFieldDTO();
/* 181 */           model.setCode("trieuChung");
/* 182 */           model.setValue(dienBienBenhModel.getSymptom());
/* 183 */           model.setMergeField("trieuChung");
/* 184 */           fieldDTO = model;
/* 185 */           children.add(fieldDTO);
/*     */           
/* 187 */           model = new MergeFieldDTO();
/* 188 */           model.setCode("thuocTuTuc");
/* 189 */           model.setValue(dienBienBenhModel.getSelfSufficientMedicine());
/* 190 */           model.setMergeField("thuocTuTuc");
/* 191 */           fieldDTO = model;
/* 192 */           children.add(fieldDTO);
/*     */           
/* 194 */           model = new MergeFieldDTO();
/* 195 */           model.setCode("huongXL");
/* 196 */           model.setValue(dienBienBenhModel.getSolution());
/* 197 */           model.setMergeField("huongXL");
/* 198 */           fieldDTO = model;
/* 199 */           children.add(fieldDTO);
/*     */           
/* 201 */           model = new MergeFieldDTO();
/* 202 */           model.setCode("cheDoAn");
/* 203 */           model.setValue(dienBienBenhModel.getDiet());
/* 204 */           model.setMergeField("cheDoAn");
/* 205 */           fieldDTO = model;
/* 206 */           children.add(fieldDTO);
/*     */           
/* 208 */           model = new MergeFieldDTO();
/* 209 */           model.setCode("cheDoChamS");
/* 210 */           model.setValue(dienBienBenhModel.getCareMode());
/* 211 */           model.setMergeField("cheDoChamS");
/* 212 */           fieldDTO = model;
/* 213 */           children.add(fieldDTO);
/*     */           
/* 215 */           model = new MergeFieldDTO();
/* 216 */           model.setCode("ghiChu");
/* 217 */           model.setValue(dienBienBenhModel.getNote());
/* 218 */           model.setMergeField("ghiChu");
/* 219 */           fieldDTO = model;
/* 220 */           children.add(fieldDTO);
/*     */           
/* 222 */           model = new MergeFieldDTO();
/* 223 */           model.setCode("PD");
/* 224 */           model.setValue(dienBienBenhModel.getPdDate());
/* 225 */           model.setMergeField("PD");
/* 226 */           fieldDTO = model;
/* 227 */           children.add(fieldDTO);
/*     */           
/* 229 */           model = new MergeFieldDTO();
/* 230 */           model.setCode("circuit");
/* 231 */           model.setValue(dienBienBenhModel.getCircuit());
/* 232 */           model.setMergeField("circuit");
/* 233 */           fieldDTO = model;
/* 234 */           children.add(fieldDTO);
/*     */           
/* 236 */           model = new MergeFieldDTO();
/* 237 */           model.setCode("temperature");
/* 238 */           model.setValue(dienBienBenhModel.getTemperature());
/* 239 */           model.setMergeField("temperature");
/* 240 */           fieldDTO = model;
/* 241 */           children.add(fieldDTO);
/*     */           
/* 243 */           model = new MergeFieldDTO();
/* 244 */           model.setCode("bloodPressure");
/* 245 */           model.setValue(dienBienBenhModel.getBloodPressure());
/* 246 */           model.setMergeField("bloodPressure");
/* 247 */           fieldDTO = model;
/* 248 */           children.add(fieldDTO);
/*     */           
/* 250 */           model = new MergeFieldDTO();
/* 251 */           model.setCode("bloodPressure1");
/* 252 */           model.setValue(dienBienBenhModel.getBloodPressure1());
/* 253 */           model.setMergeField("bloodPressure1");
/* 254 */           fieldDTO = model;
/* 255 */           children.add(fieldDTO);
/*     */           
/* 257 */           model = new MergeFieldDTO();
/* 258 */           model.setCode("breathing");
/* 259 */           model.setValue(dienBienBenhModel.getBreathing());
/* 260 */           model.setMergeField("breathing");
/* 261 */           fieldDTO = model;
/* 262 */           children.add(fieldDTO);
/*     */           
/* 264 */           model = new MergeFieldDTO();
/* 265 */           model.setCode("weight");
/* 266 */           model.setValue(dienBienBenhModel.getWeight());
/* 267 */           model.setMergeField("weight");
/* 268 */           fieldDTO = model;
/* 269 */           children.add(fieldDTO);
/*     */           
/* 271 */           model = new MergeFieldDTO();
/* 272 */           model.setCode("height");
/* 273 */           model.setValue(dienBienBenhModel.getHeight());
/* 274 */           model.setMergeField("height");
/* 275 */           fieldDTO = model;
/* 276 */           children.add(fieldDTO);
/*     */           
/* 278 */           model = new MergeFieldDTO();
/* 279 */           model.setCode("doctorName");
/* 280 */           model.setValue(dienBienBenhModel.getCreatedBy());
/* 281 */           model.setMergeField("doctorName");
/* 282 */           fieldDTO = model;
/* 283 */           children.add(fieldDTO);
/*     */         } 
/*     */         
/* 286 */         model = new MergeFieldDTO();
/* 287 */         model.setCode("yLenh");
/* 288 */         model.setValue(this.medicService.getTreatmentDetailTicket2(osm.getId()));
/* 289 */         model.setMergeField("yLenh");
/* 290 */         fieldDTO = model;
/* 291 */         children.add(fieldDTO);
/*     */ 
/*     */         
/* 294 */         mfd.setChildren(children);
/* 295 */         fieldData.add(mfd);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 300 */     return barCode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuDieuTriProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */