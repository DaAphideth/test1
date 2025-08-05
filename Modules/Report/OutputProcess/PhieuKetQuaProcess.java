/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceTypes;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.TicketInfoModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuChiDinhModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.OrderServiceModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.TicketModel;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class PhieuKetQuaProcess extends BaseProcess {
/*     */   public String getProcess(ExportModel exportModel, String contentBarCode, String filePath, String uploadfileUrl, Calendar calendar, String lang, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  33 */       return process(exportModel, contentBarCode, filePath, uploadfileUrl, lang, calendar, fieldData, mergeFieldDTO);
/*  34 */     } catch (Exception ex) {
/*  35 */       return contentBarCode;
/*     */     } 
/*     */   } @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   private String process(ExportModel exportModel, String contentBarCode, String filePath, String uploadfileUrl, String lang, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*  40 */     TicketInfoModel ticketInfo = this.commonReportRepo.getTicketInfo(exportModel.getTicketId());
/*  41 */     if (ticketInfo != null) {
/*     */       
/*  43 */       if (ticketInfo.getServiceGroupCode().equalsIgnoreCase("2")) {
/*  44 */         String file_code = "PHIEU_KET_QUA_XET_NGHIEM";
/*  45 */         filePath = uploadfileUrl + "/" + file_code + "_" + lang + ".docx";
/*  46 */         GetPhieuChiDinhModel phieuKetQuaModels = this.commonReportRepo.getPhieuKetQuaXetNhiem(exportModel.getTicketId(), exportModel.getMdId());
/*  47 */         List<MdmHeaderModel> headerResponse = phieuKetQuaModels.getMdmHeaderModel();
/*  48 */         List<CustomerModel> customerResponse = phieuKetQuaModels.getCustomerModel();
/*  49 */         List<TicketModel> ticketResponse = phieuKetQuaModels.getTicketModel();
/*  50 */         List<OrderServiceModel> orderServiceResponseSH = phieuKetQuaModels.getOrderServiceModel();
/*     */         
/*  52 */         contentBarCode = kqxnProcess(contentBarCode, fieldData, mergeFieldDTO, headerResponse, customerResponse, ticketResponse, orderServiceResponseSH);
/*     */       } 
/*  54 */       if (ticketInfo.getServiceGroupCode().equalsIgnoreCase("3")) {
/*  55 */         String file_code = "PHIEU_KET_QUA_CDHA_TDCN";
/*  56 */         filePath = uploadfileUrl + "/" + file_code + "_" + lang + ".docx";
/*  57 */         List<CheckinPrintFormResponse> kqCdha = this.commonReportRepo.sp_get_kq_cdha(exportModel.getTicketId().intValue());
/*  58 */         if (!kqCdha.isEmpty())
/*     */         {
/*  60 */           for (CheckinPrintFormResponse cdha : kqCdha) {
/*  61 */             contentBarCode = cdha.getPatientId();
/*  62 */             List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(cdha.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/*  65 */             String diagnostic = reExam.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */             
/*  67 */             List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(cdha.getDiagnosticSub(), new TypeReference<List<ReExaminationModel>>() {
/*     */                 
/*     */                 });
/*  70 */             String diagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/*     */             
/*  72 */             String diagnostics = Strings.isNotBlank(diagnosticSub) ? (diagnostic + "; " + diagnosticSub) : diagnostic;
/*  73 */             kqCDHA(cdha, fieldData, mergeFieldDTO, calendar, diagnostics);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*  78 */     String r = contentBarCode + "#" + filePath;
/*  79 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   private String kqxnProcess(String contentBarCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, List<TicketModel> ticketCDHA, List<OrderServiceModel> orderServiceCDHA) throws JsonProcessingException {
/*  84 */     if (!headerCDHARes.isEmpty()) {
/*  85 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  86 */       mergeFieldDTO.setCode("soYTe");
/*  87 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  88 */       mergeFieldDTO.setMergeField("soYTe");
/*  89 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  92 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  93 */       mergeFieldDTO.setCode("tenBV");
/*  94 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  95 */       mergeFieldDTO.setMergeField("tenBV");
/*  96 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  97 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  99 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/* 100 */       mergeFieldDTO.setCode("diaChiBV");
/* 101 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/* 102 */       mergeFieldDTO.setMergeField("diaChiBV");
/* 103 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 104 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/* 106 */     if (!customerCDHARes.isEmpty()) {
/* 107 */       CustomerModel customerModel = customerCDHARes.get(0);
/* 108 */       contentBarCode = customerModel.getPatientId();
/*     */       
/* 110 */       mergeFieldDTO.setCode("maBN");
/* 111 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/* 112 */       mergeFieldDTO.setMergeField("maBN");
/* 113 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 114 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 117 */       mergeFieldDTO.setCode("tenBN");
/* 118 */       mergeFieldDTO.setValue(customerModel.getName());
/* 119 */       mergeFieldDTO.setMergeField("tenBN");
/* 120 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 121 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 123 */       mergeFieldDTO.setCode("namSinh");
/* 124 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/* 125 */       mergeFieldDTO.setMergeField("namSinh");
/* 126 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 127 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 129 */       mergeFieldDTO.setCode("tuoi");
/* 130 */       mergeFieldDTO.setValue(customerModel.getAge());
/* 131 */       mergeFieldDTO.setMergeField("tuoi");
/* 132 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 133 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 135 */       mergeFieldDTO.setCode("gioiTinh");
/* 136 */       mergeFieldDTO.setValue(customerModel.getGender());
/* 137 */       mergeFieldDTO.setMergeField("gioiTinh");
/* 138 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 139 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 141 */       mergeFieldDTO.setCode("diaChiBN");
/* 142 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 143 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 144 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 145 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 147 */       mergeFieldDTO.setCode("noiChiDinh");
/* 148 */       mergeFieldDTO.setValue(customerModel.getRoomName());
/* 149 */       mergeFieldDTO.setMergeField("noiChiDinh");
/* 150 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 151 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 153 */       mergeFieldDTO.setCode("doiTuong");
/* 154 */       mergeFieldDTO.setValue(customerModel.getCustomerType());
/* 155 */       mergeFieldDTO.setMergeField("doiTuong");
/* 156 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 157 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 159 */       mergeFieldDTO.setCode("cccd");
/* 160 */       mergeFieldDTO.setValue(customerModel.getCccd());
/* 161 */       mergeFieldDTO.setMergeField("cccd");
/* 162 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 163 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 165 */       mergeFieldDTO.setCode("bhyt");
/* 166 */       mergeFieldDTO.setValue(customerModel.getSoBH());
/* 167 */       mergeFieldDTO.setMergeField("bhyt");
/* 168 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 169 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 171 */       mergeFieldDTO.setCode("insuranceFromDate");
/* 172 */       mergeFieldDTO.setValue(customerModel.getInsuranceFromDate());
/* 173 */       mergeFieldDTO.setMergeField("insuranceFromDate");
/* 174 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 175 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 177 */       mergeFieldDTO.setCode("insuranceExpirationDate");
/* 178 */       mergeFieldDTO.setValue(customerModel.getInsuranceExpirationDate());
/* 179 */       mergeFieldDTO.setMergeField("insuranceExpirationDate");
/* 180 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 181 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/* 183 */     if (!ticketCDHA.isEmpty()) {
/* 184 */       TicketModel ticketModel = ticketCDHA.get(0);
/*     */       
/* 186 */       List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticArray(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */         );
/* 188 */       List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticSubArray(), new TypeReference<List<ReExaminationModel>>() {
/*     */           
/*     */           });
/* 191 */       String getDiagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/* 192 */       mergeFieldDTO.setCode("chanDoan");
/* 193 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? (((ReExaminationModel)reExam.get(0)).getCode() + " - " + ((ReExaminationModel)reExam.get(0)).getName() + getDiagnosticSub) : "");
/* 194 */       mergeFieldDTO.setMergeField("chanDoan");
/* 195 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 196 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 198 */       mergeFieldDTO.setCode("khamCC");
/* 199 */       mergeFieldDTO.setValue(ticketModel.getExaminationCC());
/* 200 */       mergeFieldDTO.setMergeField("khamCC");
/* 201 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 202 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 204 */       mergeFieldDTO.setCode("khamThuong");
/* 205 */       mergeFieldDTO.setValue(ticketModel.getExaminationKT());
/* 206 */       mergeFieldDTO.setMergeField("khamThuong");
/* 207 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 208 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 211 */       mergeFieldDTO.setCode("phongThucHien");
/* 212 */       mergeFieldDTO.setValue(StringUtils.isEmpty(ticketModel.getTitlePrintName()) ? ticketModel.getRoomHandleName() : ticketModel.getTitlePrintName());
/* 213 */       mergeFieldDTO.setMergeField("phongThucHien");
/* 214 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 215 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 217 */       mergeFieldDTO.setCode("maVP");
/* 218 */       mergeFieldDTO.setValue(ticketModel.getId());
/* 219 */       mergeFieldDTO.setMergeField("maVP");
/* 220 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 221 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 223 */       mergeFieldDTO.setCode("soPhieu");
/* 224 */       mergeFieldDTO.setValue(ticketModel.getId());
/* 225 */       mergeFieldDTO.setMergeField("soPhieu");
/* 226 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 227 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 229 */       mergeFieldDTO.setCode("bsChiDinh");
/* 230 */       mergeFieldDTO.setValue(ticketModel.getDoctorName());
/* 231 */       mergeFieldDTO.setMergeField("bsChiDinh");
/* 232 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 233 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 235 */       mergeFieldDTO.setCode("gioKham");
/* 236 */       mergeFieldDTO.setValue(ticketModel.getHourExam());
/* 237 */       mergeFieldDTO.setMergeField("gioKham");
/* 238 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 239 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 241 */       mergeFieldDTO.setCode("ngayKham");
/* 242 */       mergeFieldDTO.setValue(ticketModel.getDayExam());
/* 243 */       mergeFieldDTO.setMergeField("ngayKham");
/* 244 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 245 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 247 */       mergeFieldDTO.setCode("thangKham");
/* 248 */       mergeFieldDTO.setValue(ticketModel.getMonthExam());
/* 249 */       mergeFieldDTO.setMergeField("thangKham");
/* 250 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 251 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 253 */       mergeFieldDTO.setCode("namKham");
/* 254 */       mergeFieldDTO.setValue(ticketModel.getYearExam());
/* 255 */       mergeFieldDTO.setMergeField("namKham");
/* 256 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 257 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 259 */       mergeFieldDTO.setCode("barCode");
/* 260 */       mergeFieldDTO.setValue(ticketModel.getBarCode());
/* 261 */       mergeFieldDTO.setMergeField("barCode");
/* 262 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 263 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 265 */       mergeFieldDTO.setCode("performedDoctor");
/* 266 */       mergeFieldDTO.setValue(ticketModel.getPerformedDoctor());
/* 267 */       mergeFieldDTO.setMergeField("performedDoctor");
/* 268 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 269 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 271 */       mergeFieldDTO.setCode("khoaPhong");
/* 272 */       mergeFieldDTO.setValue(ticketModel.getRoomName());
/* 273 */       mergeFieldDTO.setMergeField("khoaPhong");
/* 274 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 275 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */ 
/*     */     
/* 279 */     int stt = 0;
/* 280 */     if (!orderServiceCDHA.isEmpty()) {
/*     */ 
/*     */       
/* 283 */       Set<Integer> serviceTypeIds = (Set<Integer>)orderServiceCDHA.stream().map(OrderServiceModel::getServiceTypeId).collect(Collectors.toSet());
/* 284 */       List<OrderServiceModel> list = new ArrayList<>();
/*     */       
/* 286 */       for (Integer serviceTypeId : serviceTypeIds) {
/* 287 */         stt++;
/* 288 */         Optional<MedicServiceTypes> serviceTypes = this.serviceTypeRepository.findById(serviceTypeId);
/* 289 */         OrderServiceModel model = new OrderServiceModel();
/* 290 */         model.setServiceName(serviceTypes.isPresent() ? ((MedicServiceTypes)serviceTypes.get()).getName() : "");
/* 291 */         model.setServiceTypeId(serviceTypeId);
/* 292 */         model.setStt(String.valueOf(stt));
/* 293 */         model.setIsEdit(Integer.valueOf(0));
/* 294 */         list.add(model);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 305 */       for (OrderServiceModel om : orderServiceCDHA) {
/* 306 */         List<OrderServiceModel> orderServiceExtModels = this.commonReportRepo.sp_get_phieu_kq_xet_nghiem_dv_con(om);
/* 307 */         list.add(om);
/* 308 */         list.addAll(orderServiceExtModels);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 315 */       List<OrderServiceModel> modelList = (List<OrderServiceModel>)list.stream().sorted(Comparator.comparing(OrderServiceModel::getServiceTypeId)).collect(Collectors.toList());
/*     */       
/* 317 */       for (OrderServiceModel osm : modelList) {
/*     */         
/* 319 */         MergeFieldDTO mfd = new MergeFieldDTO();
/* 320 */         mfd.setCode("«start»");
/* 321 */         mfd.setIsGroup(Boolean.valueOf(true));
/* 322 */         mfd.setIsMultiple(Boolean.valueOf(true));
/* 323 */         mfd.setStartGroup("«start»");
/* 324 */         mfd.setEndGroup("«end»");
/*     */         
/* 326 */         List<MergeFieldDTO> children = new ArrayList<>();
/*     */         
/* 328 */         MergeFieldDTO model = new MergeFieldDTO();
/*     */         
/* 330 */         model.setCode("tenDichVu");
/* 331 */         model.setIsGroup(Boolean.valueOf(false));
/* 332 */         model.setIsMultiple(Boolean.valueOf(false));
/* 333 */         model.setValue(osm.getServiceName());
/* 334 */         model.setMergeField("tenDichVu");
/* 335 */         MergeFieldDTO fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 336 */         children.add(fieldDTO);
/*     */         
/* 338 */         if (osm.getIsEdit().intValue() == 0) {
/* 339 */           model.setCode("stt");
/* 340 */           model.setIsGroup(Boolean.valueOf(false));
/* 341 */           model.setIsMultiple(Boolean.valueOf(false));
/* 342 */           model.setValue(osm.getStt() + ". ");
/* 343 */           model.setMergeField("stt");
/* 344 */           fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 345 */           children.add(fieldDTO);
/* 346 */         } else if (osm.getIsEdit().intValue() == 2) {
/* 347 */           model.setCode("stt");
/* 348 */           model.setIsGroup(Boolean.valueOf(false));
/* 349 */           model.setIsMultiple(Boolean.valueOf(false));
/* 350 */           model.setValue(" + ");
/* 351 */           model.setMergeField("stt");
/* 352 */           fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 353 */           children.add(fieldDTO);
/*     */         } else {
/* 355 */           model.setCode("stt");
/* 356 */           model.setIsGroup(Boolean.valueOf(false));
/* 357 */           model.setIsMultiple(Boolean.valueOf(false));
/* 358 */           model.setValue(" - ");
/* 359 */           model.setMergeField("stt");
/* 360 */           fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 361 */           children.add(fieldDTO);
/*     */         } 
/* 363 */         model.setCode("donvi");
/* 364 */         model.setIsGroup(Boolean.valueOf(false));
/* 365 */         model.setIsMultiple(Boolean.valueOf(false));
/* 366 */         model.setValue(osm.getUnit());
/* 367 */         model.setMergeField("donvi");
/* 368 */         fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 369 */         children.add(fieldDTO);
/*     */         
/* 371 */         model.setCode("ketQua");
/* 372 */         model.setIsGroup(Boolean.valueOf(false));
/* 373 */         model.setIsMultiple(Boolean.valueOf(false));
/* 374 */         model.setValue(osm.getHandlerResult());
/* 375 */         model.setMergeField("ketQua");
/* 376 */         fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 377 */         children.add(fieldDTO);
/*     */         
/* 379 */         model.setCode("binhThuong");
/* 380 */         model.setIsGroup(Boolean.valueOf(false));
/* 381 */         model.setIsMultiple(Boolean.valueOf(false));
/* 382 */         model.setValue(osm.getOriginalResult());
/* 383 */         model.setMergeField("binhThuong");
/* 384 */         fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 385 */         children.add(fieldDTO);
/*     */         
/* 387 */         model.setCode("mayThucHien");
/* 388 */         model.setIsGroup(Boolean.valueOf(false));
/* 389 */         model.setIsMultiple(Boolean.valueOf(false));
/* 390 */         model.setValue(osm.getExecutionMachine());
/* 391 */         model.setMergeField("mayThucHien");
/* 392 */         fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 393 */         children.add(fieldDTO);
/*     */         
/* 395 */         model.setCode("maQuyTrinh");
/* 396 */         model.setIsGroup(Boolean.valueOf(false));
/* 397 */         model.setIsMultiple(Boolean.valueOf(false));
/* 398 */         model.setValue(osm.getProcessCode());
/* 399 */         model.setMergeField("maQuyTrinh");
/* 400 */         fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 401 */         children.add(fieldDTO);
/*     */         
/* 403 */         mfd.setChildren(children);
/* 404 */         fieldData.add(ObjectCommonUtils.cloneObject(mfd));
/*     */       } 
/*     */     } 
/*     */     
/* 408 */     return contentBarCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void kqCDHA(CheckinPrintFormResponse re, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, Calendar calendar, String diagnostics) {
/* 414 */     mergeFieldDTO.setCode("«start»");
/* 415 */     mergeFieldDTO.setIsGroup(Boolean.valueOf(true));
/* 416 */     mergeFieldDTO.setIsMultiple(Boolean.valueOf(true));
/* 417 */     mergeFieldDTO.setStartGroup("«start»");
/* 418 */     mergeFieldDTO.setEndGroup("«end»");
/*     */     
/* 420 */     MergeFieldDTO mergeFieldDTO1 = new MergeFieldDTO();
/* 421 */     List<MergeFieldDTO> fieldData1 = new ArrayList<>();
/* 422 */     this.customerProcess.getCustomer(re, fieldData1, mergeFieldDTO1);
/*     */ 
/*     */     
/* 425 */     mergeFieldDTO1.setCode("diagnostic");
/* 426 */     mergeFieldDTO1.setValue(diagnostics);
/* 427 */     mergeFieldDTO1.setMergeField("diagnostic");
/* 428 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO1);
/* 429 */     fieldData1.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 432 */     mergeFieldDTO1.setCode("codeVP");
/* 433 */     mergeFieldDTO1.setValue(re.getCode());
/* 434 */     mergeFieldDTO1.setMergeField("codeVP");
/* 435 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO1);
/* 436 */     fieldData1.add(mergeFieldDTOClone);
/*     */     
/* 438 */     mergeFieldDTO1.setCode("risResult");
/* 439 */     mergeFieldDTO1.setValue(re.getRisResult());
/* 440 */     mergeFieldDTO1.setMergeField("risResult");
/* 441 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO1);
/* 442 */     fieldData1.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 445 */     mergeFieldDTO1.setCode("risFinish");
/* 446 */     mergeFieldDTO1.setValue(re.getRisFinish());
/* 447 */     mergeFieldDTO1.setMergeField("risFinish");
/* 448 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO1);
/* 449 */     fieldData1.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */     
/* 453 */     mergeFieldDTO1.setCode("performedDoctor");
/* 454 */     mergeFieldDTO1.setValue(re.getPerformedDoctor());
/* 455 */     mergeFieldDTO1.setMergeField("performedDoctor");
/* 456 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO1);
/* 457 */     fieldData1.add(mergeFieldDTOClone);
/*     */     
/* 459 */     mergeFieldDTO.setChildren(fieldData1);
/* 460 */     MergeFieldDTO fieldDTO = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 461 */     fieldData.add(fieldDTO);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuKetQuaProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */