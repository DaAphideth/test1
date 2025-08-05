/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.List;
/*     */ import nencer.app.Modules.Medic.Model.Examination.MedicExaminationResultsRs;
/*     */ import nencer.app.Modules.Report.Model.DeathModel;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuTuVongModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class PhieuTuVongProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  31 */       GetPhieuTuVongModel phieuTuVongModel = this.commonReportRepo.getPhieuTuVong(exportModel.getMdId());
/*  32 */       List<MdmHeaderModel> headerDeathRes = phieuTuVongModel.getMdmHeaderModel();
/*  33 */       List<CustomerModel> customerDeathRes = phieuTuVongModel.getCustomerModel();
/*  34 */       MedicExaminationResultsRs examinations = this.commonTicketRepo.spGetExaminationByMdId(exportModel.getMdId());
/*  35 */       if (examinations != null) {
/*  36 */         process(fieldData, mergeFieldDTO, headerDeathRes, customerDeathRes, examinations);
/*     */       }
/*  38 */     } catch (Exception ex) {
/*  39 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  40 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void process(List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, MedicExaminationResultsRs examinationResultsRs) throws JsonProcessingException {
/*  45 */     if (!headerCDHARes.isEmpty()) {
/*  46 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  47 */       mergeFieldDTO.setCode("soYTe");
/*  48 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  49 */       mergeFieldDTO.setMergeField("soYTe");
/*  50 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  51 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  53 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  54 */       mergeFieldDTO.setCode("tenBV");
/*  55 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  56 */       mergeFieldDTO.setMergeField("tenBV");
/*  57 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  58 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  60 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  61 */       mergeFieldDTO.setCode("diaChiBV");
/*  62 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  63 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  64 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  65 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  67 */     if (!customerCDHARes.isEmpty()) {
/*  68 */       CustomerModel customerModel = customerCDHARes.get(0);
/*  69 */       mergeFieldDTO.setCode("maBN");
/*  70 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/*  71 */       mergeFieldDTO.setMergeField("maBN");
/*  72 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  73 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  75 */       mergeFieldDTO.setCode("hoVaTen");
/*  76 */       mergeFieldDTO.setValue(customerModel.getName());
/*  77 */       mergeFieldDTO.setMergeField("hoVaTen");
/*  78 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  79 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  81 */       mergeFieldDTO.setCode("namSinh");
/*  82 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/*  83 */       mergeFieldDTO.setMergeField("namSinh");
/*  84 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  85 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  87 */       mergeFieldDTO.setCode("tuoi");
/*  88 */       mergeFieldDTO.setValue(customerModel.getAge());
/*  89 */       mergeFieldDTO.setMergeField("tuoi");
/*  90 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  91 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  93 */       mergeFieldDTO.setCode("gioiTinh");
/*  94 */       mergeFieldDTO.setValue(customerModel.getGender());
/*  95 */       mergeFieldDTO.setMergeField("gioiTinh");
/*  96 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  97 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  99 */       mergeFieldDTO.setCode("diaChiBN");
/* 100 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 101 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 102 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 103 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 105 */       mergeFieldDTO.setCode("noiChiDinh");
/* 106 */       mergeFieldDTO.setValue(customerModel.getRoomName());
/* 107 */       mergeFieldDTO.setMergeField("noiChiDinh");
/* 108 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 109 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 111 */       mergeFieldDTO.setCode("doiTuong");
/* 112 */       mergeFieldDTO.setValue(customerModel.getCustomerType());
/* 113 */       mergeFieldDTO.setMergeField("doiTuong");
/* 114 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 115 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 117 */       mergeFieldDTO.setCode("cccd");
/* 118 */       mergeFieldDTO.setValue(customerModel.getCccd());
/* 119 */       mergeFieldDTO.setMergeField("cccd");
/* 120 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 121 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 123 */       mergeFieldDTO.setCode("soBH");
/* 124 */       mergeFieldDTO.setValue(customerModel.getSoBH());
/* 125 */       mergeFieldDTO.setMergeField("soBH");
/* 126 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 127 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 129 */       mergeFieldDTO.setCode("hanBH");
/* 130 */       mergeFieldDTO.setValue(customerModel.getHanBH());
/* 131 */       mergeFieldDTO.setMergeField("hanBH");
/* 132 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 133 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 135 */       mergeFieldDTO.setCode("insuranceFromDate");
/* 136 */       mergeFieldDTO.setValue(customerModel.getInsuranceFromDate());
/* 137 */       mergeFieldDTO.setMergeField("insuranceFromDate");
/* 138 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 139 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 141 */       mergeFieldDTO.setCode("insuranceExpirationDate");
/* 142 */       mergeFieldDTO.setValue(customerModel.getInsuranceExpirationDate());
/* 143 */       mergeFieldDTO.setMergeField("insuranceExpirationDate");
/* 144 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 145 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 147 */       mergeFieldDTO.setCode("xa");
/* 148 */       mergeFieldDTO.setValue(customerModel.getWardName());
/* 149 */       mergeFieldDTO.setMergeField("xa");
/* 150 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 151 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 153 */       mergeFieldDTO.setCode("huyen");
/* 154 */       mergeFieldDTO.setValue(customerModel.getDistrictName());
/* 155 */       mergeFieldDTO.setMergeField("huyen");
/* 156 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 157 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 159 */       mergeFieldDTO.setCode("tinh");
/* 160 */       mergeFieldDTO.setValue(customerModel.getProvinceName());
/* 161 */       mergeFieldDTO.setMergeField("tinh");
/* 162 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 163 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 165 */       mergeFieldDTO.setCode("chucVu");
/* 166 */       mergeFieldDTO.setValue(customerModel.getPoisition());
/* 167 */       mergeFieldDTO.setMergeField("chucVu");
/* 168 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 169 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 171 */       mergeFieldDTO.setCode("donVi");
/* 172 */       mergeFieldDTO.setValue(customerModel.getCheckinUnit());
/* 173 */       mergeFieldDTO.setMergeField("donVi");
/* 174 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 175 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 177 */       mergeFieldDTO.setCode("capBac");
/* 178 */       mergeFieldDTO.setValue(customerModel.getCheckinLevel());
/* 179 */       mergeFieldDTO.setMergeField("capBac");
/* 180 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 181 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/* 183 */     if (examinationResultsRs != null) {
/* 184 */       DeathModel deathModel = (DeathModel)this.objectMapper.readValue(examinationResultsRs.getDeath(), new TypeReference<DeathModel>() {
/*     */           
/*     */           });
/* 187 */       mergeFieldDTO.setCode("guiCho");
/* 188 */       mergeFieldDTO.setValue(deathModel.getSendTo());
/* 189 */       mergeFieldDTO.setMergeField("guiCho");
/* 190 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 191 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 193 */       mergeFieldDTO.setCode("doChungVaDoCaNhan");
/* 194 */       mergeFieldDTO.setValue(deathModel.getGeneralAndPersonalItems());
/* 195 */       mergeFieldDTO.setMergeField("doChungVaDoCaNhan");
/* 196 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 197 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 199 */       mergeFieldDTO.setCode("duocTraDoChinhSach");
/* 200 */       mergeFieldDTO.setValue(deathModel.getReturnPolicy());
/* 201 */       mergeFieldDTO.setMergeField("duocTraDoChinhSach");
/* 202 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 203 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 205 */       mergeFieldDTO.setCode("noiCatGiuXac");
/* 206 */       mergeFieldDTO.setValue(deathModel.getPlaceStoreBodies());
/* 207 */       mergeFieldDTO.setMergeField("noiCatGiuXac");
/* 208 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 209 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 211 */       mergeFieldDTO.setCode("noiTuVong");
/* 212 */       mergeFieldDTO.setValue(deathModel.getDeathLocation());
/* 213 */       mergeFieldDTO.setMergeField("noiTuVong");
/* 214 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 215 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 217 */       mergeFieldDTO.setCode("lyDoTuVong");
/* 218 */       mergeFieldDTO.setValue(deathModel.getDeathReason());
/* 219 */       mergeFieldDTO.setMergeField("lyDoTuVong");
/* 220 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 221 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 223 */       mergeFieldDTO.setCode("ngayThangNamTuVong");
/* 224 */       mergeFieldDTO.setValue(ApiHelper.dateToString1(deathModel.getDeathTimes()));
/* 225 */       mergeFieldDTO.setMergeField("ngayThangNamTuVong");
/* 226 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 227 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 229 */       mergeFieldDTO.setCode("ngayVaoVien");
/* 230 */       mergeFieldDTO.setValue(ApiHelper.dateToString1(deathModel.getHospitalDischargeTime()));
/* 231 */       mergeFieldDTO.setMergeField("ngayVaoVien");
/* 232 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 233 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 235 */       mergeFieldDTO.setCode("tenChongHoacVo");
/* 236 */       mergeFieldDTO.setValue(deathModel.getSpouseName());
/* 237 */       mergeFieldDTO.setMergeField("tenChongHoacVo");
/* 238 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 239 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 241 */       mergeFieldDTO.setCode("tenBo");
/* 242 */       mergeFieldDTO.setValue(deathModel.getFatherName());
/* 243 */       mergeFieldDTO.setMergeField("tenBo");
/* 244 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 245 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 247 */       mergeFieldDTO.setCode("tenMe");
/* 248 */       mergeFieldDTO.setValue(deathModel.getMotherName());
/* 249 */       mergeFieldDTO.setMergeField("tenMe");
/* 250 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 251 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 253 */       mergeFieldDTO.setCode("ngayVaoQD");
/* 254 */       mergeFieldDTO.setValue(ApiHelper.dateToString1(deathModel.getDateJoinMilitary()));
/* 255 */       mergeFieldDTO.setMergeField("ngayVaoQD");
/* 256 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 257 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 259 */       mergeFieldDTO.setCode("ngayVaoCM");
/* 260 */       mergeFieldDTO.setValue(ApiHelper.dateToString1(deathModel.getDateJoinRevolution()));
/* 261 */       mergeFieldDTO.setMergeField("ngayVaoCM");
/* 262 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 263 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 265 */       mergeFieldDTO.setCode("nhiemVuPhuTrach");
/* 266 */       mergeFieldDTO.setValue(deathModel.getDutyHandle());
/* 267 */       mergeFieldDTO.setMergeField("nhiemVuPhuTrach");
/* 268 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 269 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuTuVongProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */