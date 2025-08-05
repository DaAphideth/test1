/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuChiDinhModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.OrderServiceModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.TicketModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ConvertCurrentcyToString;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ 
/*     */ @Component
/*     */ public class PhieuThanhToanProcess extends BaseProcess {
/*     */   public String getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  27 */       GetPhieuChiDinhModel getPhieuChiDinhModels = this.commonReportRepo.sp_get_payout_statement(exportModel.getMdId());
/*  28 */       List<MdmHeaderModel> getHeaderRes = getPhieuChiDinhModels.getMdmHeaderModel();
/*  29 */       List<CustomerModel> getCustomerRes = getPhieuChiDinhModels.getCustomerModel();
/*  30 */       List<TicketModel> getTicket = getPhieuChiDinhModels.getTicketModel();
/*  31 */       List<OrderServiceModel> getOrderService = getPhieuChiDinhModels.getOrderServiceModel();
/*     */ 
/*     */       
/*  34 */       Set<MedicProductOrderDetailModel> setMedicProductOrderDetailModels = new HashSet<>();
/*  35 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(exportModel.getMdId());
/*  36 */       if (medicCheckinRecord.isPresent()) {
/*  37 */         List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSp(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId(), null);
/*  38 */         for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */           
/*  40 */           Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  41 */           setMedicProductOrderDetailModels.addAll(medicProductOrderDetailModels);
/*     */         } 
/*     */       } 
/*  44 */       barCode = payoutStatement(barCode, fieldData, mergeFieldDTO, getHeaderRes, getCustomerRes, getTicket, getOrderService, exportModel
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  51 */           .getName(), setMedicProductOrderDetailModels);
/*     */ 
/*     */ 
/*     */       
/*  55 */       return barCode;
/*  56 */     } catch (Exception ex) {
/*  57 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  58 */       logger.error(exceptionAsString);
/*  59 */       return barCode;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String payoutStatement(String contentBarCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, List<TicketModel> ticketCDHA, List<OrderServiceModel> orderServiceCDHA, String voter, Set<MedicProductOrderDetailModel> setMedicProductOrderDetailModels) throws JsonProcessingException {
/*  73 */     if (!headerCDHARes.isEmpty()) {
/*  74 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  75 */       mergeFieldDTO.setCode("soYTe");
/*  76 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  77 */       mergeFieldDTO.setMergeField("soYTe");
/*  78 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  79 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  81 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  82 */       mergeFieldDTO.setCode("tenBV");
/*  83 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  84 */       mergeFieldDTO.setMergeField("tenBV");
/*  85 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  86 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  88 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  89 */       mergeFieldDTO.setCode("diaChiBV");
/*  90 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  91 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  92 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  93 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  95 */     if (!customerCDHARes.isEmpty()) {
/*  96 */       CustomerModel customerModel = customerCDHARes.get(0);
/*  97 */       contentBarCode = customerModel.getPatientId();
/*     */       
/*  99 */       mergeFieldDTO.setCode("maBN");
/* 100 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/* 101 */       mergeFieldDTO.setMergeField("maBN");
/* 102 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 103 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 106 */       mergeFieldDTO.setCode("tenBN");
/* 107 */       mergeFieldDTO.setValue(customerModel.getName());
/* 108 */       mergeFieldDTO.setMergeField("tenBN");
/* 109 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 110 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 112 */       mergeFieldDTO.setCode("namSinh");
/* 113 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/* 114 */       mergeFieldDTO.setMergeField("namSinh");
/* 115 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 116 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 118 */       mergeFieldDTO.setCode("tuoi");
/* 119 */       mergeFieldDTO.setValue(customerModel.getAge());
/* 120 */       mergeFieldDTO.setMergeField("tuoi");
/* 121 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 122 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 124 */       mergeFieldDTO.setCode("nam");
/* 125 */       mergeFieldDTO.setValue(customerModel.getGenderMale());
/* 126 */       mergeFieldDTO.setMergeField("nam");
/* 127 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 128 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 130 */       mergeFieldDTO.setCode("nu");
/* 131 */       mergeFieldDTO.setValue(customerModel.getGenderFemale());
/* 132 */       mergeFieldDTO.setMergeField("nu");
/* 133 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 134 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 136 */       mergeFieldDTO.setCode("diaChiBN");
/* 137 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 138 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 139 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 140 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 143 */       mergeFieldDTO.setCode("doiTuong");
/* 144 */       mergeFieldDTO.setValue(customerModel.getCustomerType());
/* 145 */       mergeFieldDTO.setMergeField("doiTuong");
/* 146 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 147 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 150 */     if (!ticketCDHA.isEmpty()) {
/* 151 */       TicketModel ticketModel = ticketCDHA.get(0);
/* 152 */       String diagnostic = ticketModel.getDiagnosticArray();
/* 153 */       List<ReExaminationModel> reExam = new ArrayList<>();
/* 154 */       if (StringUtils.isNotBlank(diagnostic))
/* 155 */         reExam = (List<ReExaminationModel>)this.objectMapper.readValue(diagnostic, new TypeReference<List<ReExaminationModel>>() {
/*     */             
/*     */             }); 
/* 158 */       mergeFieldDTO.setCode("maChanDoan");
/* 159 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? ((ReExaminationModel)reExam.get(0)).getCode() : "");
/* 160 */       mergeFieldDTO.setMergeField("maChanDoan");
/* 161 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 162 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 164 */       mergeFieldDTO.setCode("chanDoan");
/* 165 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? ((ReExaminationModel)reExam.get(0)).getName() : "");
/* 166 */       mergeFieldDTO.setMergeField("chanDoan");
/* 167 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 168 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 170 */       mergeFieldDTO.setCode("khoa");
/* 171 */       mergeFieldDTO.setValue(ticketModel.getDepartmentName());
/* 172 */       mergeFieldDTO.setMergeField("khoa");
/* 173 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 174 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 176 */       mergeFieldDTO.setCode("maPhieu");
/* 177 */       mergeFieldDTO.setValue(ticketModel.getCode());
/* 178 */       mergeFieldDTO.setMergeField("maPhieu");
/* 179 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 180 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 182 */       mergeFieldDTO.setCode("soBenhAn");
/* 183 */       mergeFieldDTO.setValue(ticketModel.getId());
/* 184 */       mergeFieldDTO.setMergeField("soBenhAn");
/* 185 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 186 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 188 */       mergeFieldDTO.setCode("bacSiDieuTri");
/* 189 */       mergeFieldDTO.setValue(ticketModel.getPerformedDoctor());
/* 190 */       mergeFieldDTO.setMergeField("bacSiDieuTri");
/* 191 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 192 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 195 */       mergeFieldDTO.setCode("ngayVaoKham");
/* 196 */       mergeFieldDTO.setValue(ticketModel.getDayExam());
/* 197 */       mergeFieldDTO.setMergeField("ngayVaoKham");
/* 198 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 199 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 201 */       mergeFieldDTO.setCode("thangVaoKham");
/* 202 */       mergeFieldDTO.setValue(ticketModel.getMonthExam());
/* 203 */       mergeFieldDTO.setMergeField("thangVaoKham");
/* 204 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 205 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 207 */       mergeFieldDTO.setCode("namVaoKham");
/* 208 */       mergeFieldDTO.setValue(ticketModel.getYearExam());
/* 209 */       mergeFieldDTO.setMergeField("namVaoKham");
/* 210 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 211 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 213 */       mergeFieldDTO.setCode("ngayKham");
/* 214 */       mergeFieldDTO.setValue(ticketModel.getDateSynthesis());
/* 215 */       mergeFieldDTO.setMergeField("ngayKham");
/* 216 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 217 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 219 */       mergeFieldDTO.setCode("thangKham");
/* 220 */       mergeFieldDTO.setValue(ticketModel.getMonthSynthesis());
/* 221 */       mergeFieldDTO.setMergeField("thangKham");
/* 222 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 223 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 225 */       mergeFieldDTO.setCode("namKham");
/* 226 */       mergeFieldDTO.setValue(ticketModel.getYearSynthesis());
/* 227 */       mergeFieldDTO.setMergeField("namKham");
/* 228 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 229 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 232 */     int stt = 0;
/* 233 */     long a = 0L;
/* 234 */     long b = 0L;
/* 235 */     long c = 0L;
/* 236 */     if (!orderServiceCDHA.isEmpty()) {
/*     */ 
/*     */       
/* 239 */       if (!setMedicProductOrderDetailModels.isEmpty())
/*     */       {
/* 241 */         for (MedicProductOrderDetailModel pod : setMedicProductOrderDetailModels) {
/* 242 */           orderServiceCDHA.add(OrderServiceModel.builder()
/* 243 */               .serviceGroupId(Integer.valueOf(6))
/* 244 */               .serviceName(pod.getName())
/* 245 */               .qty(pod.getQty())
/* 246 */               .priceDouble(pod.getPrice())
/* 247 */               .payAmountDouble(Double.valueOf((pod.getPayAmount() == null) ? 0.0D : pod.getPayAmount().doubleValue()))
/* 248 */               .insurancePayDouble(Double.valueOf((pod.getInsurancePay() == null) ? 0.0D : pod.getInsurancePay().doubleValue()))
/* 249 */               .totalAmount(Double.valueOf((pod.getTotalAmount() == null) ? 0.0D : pod.getTotalAmount().doubleValue()))
/* 250 */               .unit(pod.getUnit())
/* 251 */               .currencyName(pod.getCurrencyCode())
/* 252 */               .isEdit(Integer.valueOf(1))
/* 253 */               .build());
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 258 */       Set<Integer> serviceGroupIds = (Set<Integer>)orderServiceCDHA.stream().map(OrderServiceModel::getServiceGroupId).collect(Collectors.toSet());
/* 259 */       List<OrderServiceModel> orderServiceModels2 = new ArrayList<>();
/* 260 */       for (Integer serviceGroupId : serviceGroupIds) {
/* 261 */         stt++;
/* 262 */         Optional<MedicServiceGroups> servicesGroup = this.serviceGroupRepository.findById(serviceGroupId);
/* 263 */         OrderServiceModel orderServiceModel = new OrderServiceModel();
/* 264 */         orderServiceModel.setStt(String.valueOf(stt));
/* 265 */         orderServiceModel.setServiceName(servicesGroup.isPresent() ? ((MedicServiceGroups)servicesGroup.get()).getName() : "");
/* 266 */         orderServiceModel.setServiceGroupId(serviceGroupId);
/* 267 */         orderServiceModel.setTotalAmount(Double.valueOf(0.0D));
/* 268 */         orderServiceModel.setInsurancePayDouble(Double.valueOf(0.0D));
/* 269 */         orderServiceModel.setPayAmountDouble(Double.valueOf(0.0D));
/* 270 */         orderServiceModels2.add(orderServiceModel);
/*     */       } 
/* 272 */       orderServiceModels2.addAll(orderServiceCDHA);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 277 */       List<OrderServiceModel> orderServiceModels = (List<OrderServiceModel>)orderServiceModels2.stream().sorted(Comparator.comparing(OrderServiceModel::getServiceGroupId)).collect(Collectors.toList());
/*     */ 
/*     */ 
/*     */       
/* 281 */       for (OrderServiceModel osm : orderServiceModels) {
/*     */         
/* 283 */         MergeFieldDTO mfd = new MergeFieldDTO();
/* 284 */         List<MergeFieldDTO> children = new ArrayList<>();
/* 285 */         MergeFieldDTO mfdExt = new MergeFieldDTO();
/*     */         
/* 287 */         mfd.setCode("«start»");
/* 288 */         mfd.setIsGroup(Boolean.valueOf(true));
/* 289 */         mfd.setIsMultiple(Boolean.valueOf(true));
/* 290 */         mfd.setStartGroup("«start»");
/* 291 */         mfd.setEndGroup("«end»");
/*     */         
/* 293 */         MergeFieldDTO model = new MergeFieldDTO();
/*     */         
/* 295 */         MergeFieldDTO modelExt = new MergeFieldDTO();
/* 296 */         modelExt.setCode("dichVu");
/* 297 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 298 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 299 */         modelExt.setValue(osm.getServiceName());
/* 300 */         modelExt.setMergeField("dichVu");
/* 301 */         MergeFieldDTO fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 302 */         children.add(fieldDTOExt);
/*     */         
/* 304 */         modelExt.setCode("donVi");
/* 305 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 306 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 307 */         modelExt.setValue(osm.getUnit());
/* 308 */         modelExt.setMergeField("donVi");
/* 309 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 310 */         children.add(fieldDTOExt);
/*     */         
/* 312 */         modelExt.setCode("soLuong");
/* 313 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 314 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 315 */         modelExt.setValue((osm.getQty() != null) ? String.valueOf(osm.getQty()) : "");
/* 316 */         modelExt.setMergeField("soLuong");
/* 317 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 318 */         children.add(fieldDTOExt);
/*     */         
/* 320 */         modelExt.setCode("donGia");
/* 321 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 322 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 323 */         modelExt.setValue((osm.getPriceDouble() != null) ? ApiHelper.formatDecimal(osm.getPriceDouble()) : "");
/* 324 */         modelExt.setMergeField("donGia");
/* 325 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 326 */         children.add(fieldDTOExt);
/* 327 */         if (Objects.isNull(osm.getIsEdit())) {
/* 328 */           model.setCode("stt");
/* 329 */           model.setIsGroup(Boolean.valueOf(false));
/* 330 */           model.setIsMultiple(Boolean.valueOf(false));
/* 331 */           model.setValue(osm.getStt() + ". ");
/* 332 */           model.setMergeField("stt");
/* 333 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 334 */           children.add(fieldDTOExt);
/*     */         } else {
/* 336 */           model.setCode("stt");
/* 337 */           model.setIsGroup(Boolean.valueOf(false));
/* 338 */           model.setIsMultiple(Boolean.valueOf(false));
/* 339 */           model.setValue(" - ");
/* 340 */           model.setMergeField("stt");
/* 341 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 342 */           children.add(fieldDTOExt);
/*     */           
/* 344 */           modelExt.setCode("thanhTien");
/* 345 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 346 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 347 */           modelExt.setValue((osm.getPayAmountDouble() != null) ? ApiHelper.formatDecimal(osm.getPayAmountDouble()) : "");
/* 348 */           modelExt.setMergeField("thanhTien");
/* 349 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 350 */           children.add(fieldDTOExt);
/*     */           
/* 352 */           modelExt.setCode("nguonKhac");
/* 353 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 354 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 355 */           modelExt.setValue((osm.getInsurancePayDouble() != null) ? ApiHelper.formatDecimal(osm.getInsurancePayDouble()) : "");
/* 356 */           modelExt.setMergeField("nguonKhac");
/* 357 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 358 */           children.add(fieldDTOExt);
/*     */           
/* 360 */           modelExt.setCode("BNTra");
/* 361 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 362 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 363 */           modelExt.setValue((osm.getTotalAmount() != null) ? ApiHelper.formatDecimal(osm.getTotalAmount()) : "");
/* 364 */           modelExt.setMergeField("BNTra");
/* 365 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 366 */           children.add(fieldDTOExt);
/*     */         } 
/* 368 */         modelExt.setCode("cong");
/* 369 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 370 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 371 */         modelExt.setValue("cong");
/* 372 */         modelExt.setMergeField("cong");
/* 373 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 374 */         children.add(fieldDTOExt);
/*     */ 
/*     */ 
/*     */         
/* 378 */         fieldData.add(ObjectCommonUtils.cloneObject(mfdExt));
/*     */         
/* 380 */         a = (long)(a + osm.getTotalAmount().doubleValue());
/* 381 */         b = (long)(b + osm.getInsurancePayDouble().doubleValue());
/* 382 */         c = (long)(c + osm.getPayAmountDouble().doubleValue());
/*     */ 
/*     */         
/* 385 */         mfd.setChildren(children);
/* 386 */         fieldData.add(ObjectCommonUtils.cloneObject(mfd));
/*     */       } 
/* 388 */       String totalAmount = String.valueOf(a);
/* 389 */       String insurancePay = String.valueOf(b);
/* 390 */       String payAmount = String.valueOf(c);
/*     */       
/* 392 */       mergeFieldDTO.setCode("tongThanhTien");
/* 393 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(c)));
/* 394 */       mergeFieldDTO.setMergeField("tongThanhTien");
/* 395 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 396 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 398 */       mergeFieldDTO.setCode("tongNguonKhac");
/* 399 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(b)));
/* 400 */       mergeFieldDTO.setMergeField("tongNguonKhac");
/* 401 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 402 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 404 */       mergeFieldDTO.setCode("nguoiBenhThanhToan");
/* 405 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(a)));
/* 406 */       mergeFieldDTO.setMergeField("nguoiBenhThanhToan");
/* 407 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 408 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 410 */       mergeFieldDTO.setCode("tongChiPhi");
/* 411 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(payAmount, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 412 */       mergeFieldDTO.setMergeField("tongChiPhi");
/* 413 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 414 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 416 */       mergeFieldDTO.setCode("bhytChiTra");
/* 417 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(insurancePay, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 418 */       mergeFieldDTO.setMergeField("bhytChiTra");
/* 419 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 420 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 422 */       mergeFieldDTO.setCode("tongSoBNTra");
/* 423 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(totalAmount, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 424 */       mergeFieldDTO.setMergeField("tongSoBNTra");
/* 425 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 426 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 428 */       mergeFieldDTO.setCode("nguoiTongHop");
/* 429 */       mergeFieldDTO.setValue(voter);
/* 430 */       mergeFieldDTO.setMergeField("nguoiTongHop");
/* 431 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 432 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 437 */     return contentBarCode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuThanhToanProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */