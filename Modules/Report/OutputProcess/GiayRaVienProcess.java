/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Report.Model.DeliveryPrescriptionModel;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.ExaminationResultsModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuRaVienModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
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
/*     */ public class GiayRaVienProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   public void getProcess(ExportModel exportModel, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  35 */       GetPhieuRaVienModel getPhieuRaVienModel = this.commonReportRepo.sp_get_hospital_checkout(exportModel.getMdId());
/*  36 */       List<MdmHeaderModel> headerResponse = getPhieuRaVienModel.getMdmHeaderModel();
/*  37 */       List<CustomerModel> customerResponse = getPhieuRaVienModel.getCustomerModel();
/*  38 */       List<ExaminationResultsModel> examinationResults = getPhieuRaVienModel.getExaminationResults();
/*  39 */       process(fieldData, mergeFieldDTO, headerResponse, customerResponse, examinationResults);
/*  40 */     } catch (Exception ex) {
/*  41 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  42 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, List<ExaminationResultsModel> ticketCDHA) throws JsonProcessingException {
/*  48 */     if (!headerCDHARes.isEmpty()) {
/*  49 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  50 */       mergeFieldDTO.setCode("soYTe");
/*  51 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  52 */       mergeFieldDTO.setMergeField("soYTe");
/*  53 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  54 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  56 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  57 */       mergeFieldDTO.setCode("tenBV");
/*  58 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  59 */       mergeFieldDTO.setMergeField("tenBV");
/*  60 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  61 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  63 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  64 */       mergeFieldDTO.setCode("diaChiBV");
/*  65 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  66 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  67 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  68 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  70 */       MdmHeaderModel hospitalRepresentative = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("hospitalRepresentative")).findFirst().orElse(null);
/*  71 */       mergeFieldDTO.setCode("thuTruongDonVi");
/*  72 */       mergeFieldDTO.setValue((hospitalRepresentative != null) ? hospitalRepresentative.getMedicName() : "");
/*  73 */       mergeFieldDTO.setMergeField("thuTruongDonVi");
/*  74 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  75 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  77 */     if (!customerCDHARes.isEmpty()) {
/*  78 */       CustomerModel customerModel = customerCDHARes.get(0);
/*     */       
/*  80 */       mergeFieldDTO.setCode("maBN");
/*  81 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/*  82 */       mergeFieldDTO.setMergeField("maBN");
/*  83 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  84 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  86 */       mergeFieldDTO.setCode("tenBN");
/*  87 */       mergeFieldDTO.setValue(customerModel.getName());
/*  88 */       mergeFieldDTO.setMergeField("tenBN");
/*  89 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  92 */       mergeFieldDTO.setCode("namSinh");
/*  93 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/*  94 */       mergeFieldDTO.setMergeField("namSinh");
/*  95 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  96 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  98 */       mergeFieldDTO.setCode("tuoi");
/*  99 */       mergeFieldDTO.setValue(customerModel.getAge());
/* 100 */       mergeFieldDTO.setMergeField("tuoi");
/* 101 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 102 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 104 */       mergeFieldDTO.setCode("gioiTinh");
/* 105 */       mergeFieldDTO.setValue(customerModel.getGender());
/* 106 */       mergeFieldDTO.setMergeField("gioiTinh");
/* 107 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 108 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 110 */       mergeFieldDTO.setCode("diaChiBN");
/* 111 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 112 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 113 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 114 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 116 */       mergeFieldDTO.setCode("danToc");
/* 117 */       mergeFieldDTO.setValue(customerModel.getEthnic());
/* 118 */       mergeFieldDTO.setMergeField("danToc");
/* 119 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 120 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 122 */       mergeFieldDTO.setCode("ngheNghiep");
/* 123 */       mergeFieldDTO.setValue(customerModel.getJobTitle());
/* 124 */       mergeFieldDTO.setMergeField("ngheNghiep");
/* 125 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 126 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 128 */       mergeFieldDTO.setCode("soBH");
/* 129 */       mergeFieldDTO.setValue(customerModel.getSoBH());
/* 130 */       mergeFieldDTO.setMergeField("soBH");
/* 131 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 132 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 134 */       mergeFieldDTO.setCode("maso");
/* 135 */       mergeFieldDTO.setValue(customerModel.getMaso());
/* 136 */       mergeFieldDTO.setMergeField("maso");
/* 137 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 138 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/* 140 */     if (!ticketCDHA.isEmpty()) {
/* 141 */       ExaminationResultsModel ticketModel = ticketCDHA.get(0);
/* 142 */       List<ReExaminationModel> reExam = new ArrayList<>();
/* 143 */       if (StringUtils.isNotBlank(ticketModel.getDiagnosticArray()))
/* 144 */         reExam = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticArray(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */           ); 
/* 146 */       List<ReExaminationModel> reExamSub = new ArrayList<>();
/* 147 */       if (StringUtils.isNotBlank(ticketModel.getDiagnosticSubArray()))
/* 148 */         reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticSubArray(), new TypeReference<List<ReExaminationModel>>() {
/*     */             
/*     */             }); 
/* 151 */       String getDiagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("\n"));
/*     */       
/* 153 */       DeliveryPrescriptionModel prescriptionModel = new DeliveryPrescriptionModel();
/* 154 */       if (StringUtils.isNotBlank(ticketModel.getDeliveryPrescription())) {
/* 155 */         prescriptionModel = (DeliveryPrescriptionModel)this.objectMapper.readValue(ticketModel.getDeliveryPrescription(), DeliveryPrescriptionModel.class);
/*     */       }
/*     */       
/* 158 */       Date hospitalDischargeTime = prescriptionModel.getHospitalDischargeTime();
/* 159 */       Date hospitalizedDay = ticketModel.getHospitalizedDay();
/*     */       
/* 161 */       mergeFieldDTO.setCode("chanDoan");
/* 162 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? (((ReExaminationModel)reExam.get(0)).getCode() + "-" + ((ReExaminationModel)reExam.get(0)).getName() + ";" + getDiagnosticSub) : "");
/* 163 */       mergeFieldDTO.setMergeField("chanDoan");
/* 164 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 165 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       mergeFieldDTO.setCode("vaoVienLucDay");
/* 174 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalizedDay, "dd"));
/* 175 */       mergeFieldDTO.setMergeField("vaoVienLucDay");
/* 176 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 177 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 179 */       mergeFieldDTO.setCode("vaoVienLucMonth");
/* 180 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalizedDay, "MM"));
/* 181 */       mergeFieldDTO.setMergeField("vaoVienLucMonth");
/* 182 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 183 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 185 */       mergeFieldDTO.setCode("vaoVienLucYear");
/* 186 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalizedDay, "yyyy"));
/* 187 */       mergeFieldDTO.setMergeField("vaoVienLucYear");
/* 188 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 189 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 191 */       mergeFieldDTO.setCode("gioVaoVien");
/* 192 */       mergeFieldDTO.setValue(ticketModel.getHourExam());
/* 193 */       mergeFieldDTO.setMergeField("gioVaoVien");
/* 194 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 195 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 197 */       mergeFieldDTO.setCode("ngayVaoVien");
/* 198 */       mergeFieldDTO.setValue(ticketModel.getDayExam());
/* 199 */       mergeFieldDTO.setMergeField("ngayVaoVien");
/* 200 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 201 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 203 */       mergeFieldDTO.setCode("thangVaoVien");
/* 204 */       mergeFieldDTO.setValue(ticketModel.getMonthExam());
/* 205 */       mergeFieldDTO.setMergeField("thangVaoVien");
/* 206 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 207 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 209 */       mergeFieldDTO.setCode("namVaoVien");
/* 210 */       mergeFieldDTO.setValue(ticketModel.getYearExam());
/* 211 */       mergeFieldDTO.setMergeField("namVaoVien");
/* 212 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 213 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 221 */       mergeFieldDTO.setCode("raVienLucDay");
/* 222 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "dd"));
/* 223 */       mergeFieldDTO.setMergeField("raVienLucDay");
/* 224 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 225 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 227 */       mergeFieldDTO.setCode("raVienLucMonth");
/* 228 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "MM"));
/* 229 */       mergeFieldDTO.setMergeField("raVienLucMonth");
/* 230 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 231 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 233 */       mergeFieldDTO.setCode("raVienLucYear");
/* 234 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "yyyy"));
/* 235 */       mergeFieldDTO.setMergeField("raVienLucYear");
/* 236 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 237 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 239 */       mergeFieldDTO.setCode("gioRaVien");
/* 240 */       mergeFieldDTO.setValue(ticketModel.getHourDischarge());
/* 241 */       mergeFieldDTO.setMergeField("gioRaVien");
/* 242 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 243 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 245 */       mergeFieldDTO.setCode("ngayRaVien");
/* 246 */       mergeFieldDTO.setValue(ticketModel.getDayDischarge());
/* 247 */       mergeFieldDTO.setMergeField("ngayRaVien");
/* 248 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 249 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 251 */       mergeFieldDTO.setCode("thangRaVien");
/* 252 */       mergeFieldDTO.setValue(ticketModel.getMonthDischarge());
/* 253 */       mergeFieldDTO.setMergeField("thangRaVien");
/* 254 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 255 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 257 */       mergeFieldDTO.setCode("namRaVien");
/* 258 */       mergeFieldDTO.setValue(ticketModel.getYearDischarge());
/* 259 */       mergeFieldDTO.setMergeField("namRaVien");
/* 260 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 261 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 263 */       mergeFieldDTO.setCode("phuongPhapDieuTri");
/* 264 */       mergeFieldDTO.setValue(prescriptionModel.getTreatmentMethod());
/* 265 */       mergeFieldDTO.setMergeField("phuongPhapDieuTri");
/* 266 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 267 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 269 */       mergeFieldDTO.setCode("ghiChu");
/* 270 */       mergeFieldDTO.setValue(prescriptionModel.getNote());
/* 271 */       mergeFieldDTO.setMergeField("ghiChu");
/* 272 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 273 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 275 */       mergeFieldDTO.setCode("khoaPhong");
/* 276 */       mergeFieldDTO.setValue(ticketModel.getDepartmentName());
/* 277 */       mergeFieldDTO.setMergeField("khoaPhong");
/* 278 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 279 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 287 */       mergeFieldDTO.setCode("thoiGianDay");
/* 288 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "dd"));
/* 289 */       mergeFieldDTO.setMergeField("raVienLucDay");
/* 290 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 291 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 293 */       mergeFieldDTO.setCode("thoiGianMonth");
/* 294 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "MM"));
/* 295 */       mergeFieldDTO.setMergeField("thoiGianMonth");
/* 296 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 297 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 299 */       mergeFieldDTO.setCode("thoiGianYear");
/* 300 */       mergeFieldDTO.setValue(ApiHelper.dateToString(hospitalDischargeTime, "yyyy"));
/* 301 */       mergeFieldDTO.setMergeField("thoiGianYear");
/* 302 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 303 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 305 */       mergeFieldDTO.setCode("truongKhoa");
/* 306 */       mergeFieldDTO.setValue(ticketModel.getManager());
/* 307 */       mergeFieldDTO.setMergeField("truongKhoa");
/* 308 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 309 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\GiayRaVienProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */