/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
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
/*     */ public class BangKeThanhToanProcess extends BaseProcess {
/*     */   public String getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  28 */       GetPhieuChiDinhModel getPhieuChiDinhModels = this.commonReportRepo.sp_get_payout_statement_by_checkin(exportModel.getCheckinId());
/*  29 */       List<MdmHeaderModel> getHeaderRes = getPhieuChiDinhModels.getMdmHeaderModel();
/*  30 */       List<CustomerModel> getCustomerRes = getPhieuChiDinhModels.getCustomerModel();
/*  31 */       List<TicketModel> getTicket = getPhieuChiDinhModels.getTicketModel();
/*  32 */       List<OrderServiceModel> getOrderService = getPhieuChiDinhModels.getOrderServiceModel();
/*     */ 
/*     */       
/*  35 */       Set<MedicProductOrderDetailModel> setMedicProductOrderDetailModels = new HashSet<>();
/*  36 */       List<MedicCheckinRecord> medicCheckinRecords = this.medicCheckinRecordRepository.findAllByCheckinId(exportModel.getCheckinId());
/*  37 */       if (medicCheckinRecords.size() > 0) {
/*  38 */         for (MedicCheckinRecord medicCheckinRecord : medicCheckinRecords) {
/*  39 */           List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSp(medicCheckinRecord.getCheckinId(), null);
/*  40 */           for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */             
/*  42 */             Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  43 */             setMedicProductOrderDetailModels.addAll(medicProductOrderDetailModels);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*  48 */       barCode = payoutStatement(barCode, fieldData, mergeFieldDTO, getHeaderRes, getCustomerRes, getTicket, getOrderService, exportModel
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  55 */           .getName(), setMedicProductOrderDetailModels);
/*     */ 
/*     */ 
/*     */       
/*  59 */       return barCode;
/*  60 */     } catch (Exception ex) {
/*  61 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  62 */       logger.error(exceptionAsString);
/*  63 */       return barCode;
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
/*  77 */     if (!headerCDHARes.isEmpty()) {
/*  78 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  79 */       mergeFieldDTO.setCode("soYTe");
/*  80 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  81 */       mergeFieldDTO.setMergeField("soYTe");
/*  82 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  83 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  85 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  86 */       mergeFieldDTO.setCode("tenBV");
/*  87 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  88 */       mergeFieldDTO.setMergeField("tenBV");
/*  89 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  92 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  93 */       mergeFieldDTO.setCode("diaChiBV");
/*  94 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  95 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  96 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  97 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  99 */     if (!customerCDHARes.isEmpty()) {
/* 100 */       CustomerModel customerModel = customerCDHARes.get(0);
/* 101 */       contentBarCode = customerModel.getPatientId();
/*     */       
/* 103 */       mergeFieldDTO.setCode("maBN");
/* 104 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/* 105 */       mergeFieldDTO.setMergeField("maBN");
/* 106 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 110 */       mergeFieldDTO.setCode("tenBN");
/* 111 */       mergeFieldDTO.setValue(customerModel.getName());
/* 112 */       mergeFieldDTO.setMergeField("tenBN");
/* 113 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 114 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 116 */       mergeFieldDTO.setCode("namSinh");
/* 117 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/* 118 */       mergeFieldDTO.setMergeField("namSinh");
/* 119 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 120 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 122 */       mergeFieldDTO.setCode("tuoi");
/* 123 */       mergeFieldDTO.setValue(customerModel.getAge());
/* 124 */       mergeFieldDTO.setMergeField("tuoi");
/* 125 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 126 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 128 */       mergeFieldDTO.setCode("nam");
/* 129 */       mergeFieldDTO.setValue(customerModel.getGenderMale());
/* 130 */       mergeFieldDTO.setMergeField("nam");
/* 131 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 132 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 134 */       mergeFieldDTO.setCode("nu");
/* 135 */       mergeFieldDTO.setValue(customerModel.getGenderFemale());
/* 136 */       mergeFieldDTO.setMergeField("nu");
/* 137 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 138 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 140 */       mergeFieldDTO.setCode("diaChiBN");
/* 141 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 142 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 143 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 144 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 147 */       mergeFieldDTO.setCode("doiTuong");
/* 148 */       mergeFieldDTO.setValue(customerModel.getCustomerType());
/* 149 */       mergeFieldDTO.setMergeField("doiTuong");
/* 150 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 151 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 154 */     if (!ticketCDHA.isEmpty()) {
/* 155 */       TicketModel ticketModel = ticketCDHA.get(0);
/* 156 */       String diagnostic = ticketModel.getDiagnosticArray();
/* 157 */       List<ReExaminationModel> reExam = new ArrayList<>();
/* 158 */       if (StringUtils.isNotBlank(diagnostic))
/* 159 */         reExam = (List<ReExaminationModel>)this.objectMapper.readValue(diagnostic, new TypeReference<List<ReExaminationModel>>() {
/*     */             
/*     */             }); 
/* 162 */       mergeFieldDTO.setCode("maChanDoan");
/* 163 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? ((ReExaminationModel)reExam.get(0)).getCode() : "");
/* 164 */       mergeFieldDTO.setMergeField("maChanDoan");
/* 165 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 166 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 168 */       mergeFieldDTO.setCode("chanDoan");
/* 169 */       mergeFieldDTO.setValue(!reExam.isEmpty() ? ((ReExaminationModel)reExam.get(0)).getName() : "");
/* 170 */       mergeFieldDTO.setMergeField("chanDoan");
/* 171 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 172 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 174 */       mergeFieldDTO.setCode("khoa");
/* 175 */       mergeFieldDTO.setValue(ticketModel.getDepartmentName());
/* 176 */       mergeFieldDTO.setMergeField("khoa");
/* 177 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 178 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 180 */       mergeFieldDTO.setCode("maPhieu");
/* 181 */       mergeFieldDTO.setValue(ticketModel.getCode());
/* 182 */       mergeFieldDTO.setMergeField("maPhieu");
/* 183 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 184 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 186 */       mergeFieldDTO.setCode("soBenhAn");
/* 187 */       mergeFieldDTO.setValue(ticketModel.getId());
/* 188 */       mergeFieldDTO.setMergeField("soBenhAn");
/* 189 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 190 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 192 */       mergeFieldDTO.setCode("bacSiDieuTri");
/* 193 */       mergeFieldDTO.setValue(ticketModel.getPerformedDoctor());
/* 194 */       mergeFieldDTO.setMergeField("bacSiDieuTri");
/* 195 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 196 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/* 199 */       mergeFieldDTO.setCode("ngayVaoKham");
/* 200 */       mergeFieldDTO.setValue(ticketModel.getDayExam());
/* 201 */       mergeFieldDTO.setMergeField("ngayVaoKham");
/* 202 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 203 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 205 */       mergeFieldDTO.setCode("thangVaoKham");
/* 206 */       mergeFieldDTO.setValue(ticketModel.getMonthExam());
/* 207 */       mergeFieldDTO.setMergeField("thangVaoKham");
/* 208 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 209 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 211 */       mergeFieldDTO.setCode("namVaoKham");
/* 212 */       mergeFieldDTO.setValue(ticketModel.getYearExam());
/* 213 */       mergeFieldDTO.setMergeField("namVaoKham");
/* 214 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 215 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 217 */       mergeFieldDTO.setCode("ngayKham");
/* 218 */       mergeFieldDTO.setValue(ticketModel.getDateSynthesis());
/* 219 */       mergeFieldDTO.setMergeField("ngayKham");
/* 220 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 221 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 223 */       mergeFieldDTO.setCode("thangKham");
/* 224 */       mergeFieldDTO.setValue(ticketModel.getMonthSynthesis());
/* 225 */       mergeFieldDTO.setMergeField("thangKham");
/* 226 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 227 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 229 */       mergeFieldDTO.setCode("namKham");
/* 230 */       mergeFieldDTO.setValue(ticketModel.getYearSynthesis());
/* 231 */       mergeFieldDTO.setMergeField("namKham");
/* 232 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 233 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 236 */     int stt = 0;
/* 237 */     long a = 0L;
/* 238 */     long b = 0L;
/* 239 */     long c = 0L;
/* 240 */     if (!orderServiceCDHA.isEmpty()) {
/*     */ 
/*     */       
/* 243 */       if (!setMedicProductOrderDetailModels.isEmpty())
/*     */       {
/* 245 */         for (MedicProductOrderDetailModel pod : setMedicProductOrderDetailModels) {
/* 246 */           orderServiceCDHA.add(OrderServiceModel.builder()
/* 247 */               .serviceGroupId(Integer.valueOf(6))
/* 248 */               .serviceName(pod.getName())
/* 249 */               .qty(pod.getQty())
/* 250 */               .priceDouble(pod.getPrice())
/* 251 */               .payAmountDouble(Double.valueOf((pod.getPayAmount() == null) ? 0.0D : pod.getPayAmount().doubleValue()))
/* 252 */               .insurancePayDouble(Double.valueOf((pod.getInsurancePay() == null) ? 0.0D : pod.getInsurancePay().doubleValue()))
/* 253 */               .totalAmount(Double.valueOf((pod.getTotalAmount() == null) ? 0.0D : pod.getTotalAmount().doubleValue()))
/* 254 */               .unit(pod.getUnit())
/* 255 */               .currencyName(pod.getCurrencyCode())
/* 256 */               .isEdit(Integer.valueOf(1))
/* 257 */               .build());
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 262 */       Set<Integer> serviceGroupIds = (Set<Integer>)orderServiceCDHA.stream().map(OrderServiceModel::getServiceGroupId).collect(Collectors.toSet());
/* 263 */       List<OrderServiceModel> orderServiceModels2 = new ArrayList<>();
/* 264 */       for (Integer serviceGroupId : serviceGroupIds) {
/* 265 */         stt++;
/* 266 */         Optional<MedicServiceGroups> servicesGroup = this.serviceGroupRepository.findById(serviceGroupId);
/* 267 */         OrderServiceModel orderServiceModel = new OrderServiceModel();
/* 268 */         orderServiceModel.setStt(String.valueOf(stt));
/* 269 */         orderServiceModel.setServiceName(servicesGroup.isPresent() ? ((MedicServiceGroups)servicesGroup.get()).getName() : "");
/* 270 */         orderServiceModel.setServiceGroupId(serviceGroupId);
/* 271 */         orderServiceModel.setTotalAmount(Double.valueOf(0.0D));
/* 272 */         orderServiceModel.setInsurancePayDouble(Double.valueOf(0.0D));
/* 273 */         orderServiceModel.setPayAmountDouble(Double.valueOf(0.0D));
/* 274 */         orderServiceModels2.add(orderServiceModel);
/*     */       } 
/* 276 */       orderServiceModels2.addAll(orderServiceCDHA);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 281 */       List<OrderServiceModel> orderServiceModels = (List<OrderServiceModel>)orderServiceModels2.stream().sorted(Comparator.comparing(OrderServiceModel::getServiceGroupId)).collect(Collectors.toList());
/*     */ 
/*     */ 
/*     */       
/* 285 */       for (OrderServiceModel osm : orderServiceModels) {
/*     */         
/* 287 */         MergeFieldDTO mfd = new MergeFieldDTO();
/* 288 */         List<MergeFieldDTO> children = new ArrayList<>();
/* 289 */         MergeFieldDTO mfdExt = new MergeFieldDTO();
/*     */         
/* 291 */         mfd.setCode("«start»");
/* 292 */         mfd.setIsGroup(Boolean.valueOf(true));
/* 293 */         mfd.setIsMultiple(Boolean.valueOf(true));
/* 294 */         mfd.setStartGroup("«start»");
/* 295 */         mfd.setEndGroup("«end»");
/*     */         
/* 297 */         MergeFieldDTO model = new MergeFieldDTO();
/*     */         
/* 299 */         MergeFieldDTO modelExt = new MergeFieldDTO();
/* 300 */         modelExt.setCode("dichVu");
/* 301 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 302 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 303 */         modelExt.setValue(osm.getServiceName());
/* 304 */         modelExt.setMergeField("dichVu");
/* 305 */         MergeFieldDTO fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 306 */         children.add(fieldDTOExt);
/*     */         
/* 308 */         modelExt.setCode("donVi");
/* 309 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 310 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 311 */         modelExt.setValue(osm.getUnit());
/* 312 */         modelExt.setMergeField("donVi");
/* 313 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 314 */         children.add(fieldDTOExt);
/*     */         
/* 316 */         modelExt.setCode("soLuong");
/* 317 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 318 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 319 */         modelExt.setValue((osm.getQty() != null) ? String.valueOf(osm.getQty()) : "");
/* 320 */         modelExt.setMergeField("soLuong");
/* 321 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 322 */         children.add(fieldDTOExt);
/*     */         
/* 324 */         modelExt.setCode("donGia");
/* 325 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 326 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 327 */         modelExt.setValue((osm.getPriceDouble() != null) ? ApiHelper.formatDecimal(osm.getPriceDouble()) : "");
/* 328 */         modelExt.setMergeField("donGia");
/* 329 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 330 */         children.add(fieldDTOExt);
/* 331 */         if (Objects.isNull(osm.getIsEdit())) {
/* 332 */           model.setCode("stt");
/* 333 */           model.setIsGroup(Boolean.valueOf(false));
/* 334 */           model.setIsMultiple(Boolean.valueOf(false));
/* 335 */           model.setValue(osm.getStt() + ". ");
/* 336 */           model.setMergeField("stt");
/* 337 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 338 */           children.add(fieldDTOExt);
/*     */         } else {
/* 340 */           model.setCode("stt");
/* 341 */           model.setIsGroup(Boolean.valueOf(false));
/* 342 */           model.setIsMultiple(Boolean.valueOf(false));
/* 343 */           model.setValue(" - ");
/* 344 */           model.setMergeField("stt");
/* 345 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(model);
/* 346 */           children.add(fieldDTOExt);
/*     */           
/* 348 */           modelExt.setCode("thanhTien");
/* 349 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 350 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 351 */           modelExt.setValue((osm.getPayAmountDouble() != null) ? ApiHelper.formatDecimal(osm.getPayAmountDouble()) : "");
/* 352 */           modelExt.setMergeField("thanhTien");
/* 353 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 354 */           children.add(fieldDTOExt);
/*     */           
/* 356 */           modelExt.setCode("nguonKhac");
/* 357 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 358 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 359 */           modelExt.setValue((osm.getInsurancePayDouble() != null) ? ApiHelper.formatDecimal(osm.getInsurancePayDouble()) : "");
/* 360 */           modelExt.setMergeField("nguonKhac");
/* 361 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 362 */           children.add(fieldDTOExt);
/*     */           
/* 364 */           modelExt.setCode("BNTra");
/* 365 */           modelExt.setIsGroup(Boolean.valueOf(false));
/* 366 */           modelExt.setIsMultiple(Boolean.valueOf(false));
/* 367 */           modelExt.setValue((osm.getTotalAmount() != null) ? ApiHelper.formatDecimal(osm.getTotalAmount()) : "");
/* 368 */           modelExt.setMergeField("BNTra");
/* 369 */           fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 370 */           children.add(fieldDTOExt);
/*     */         } 
/* 372 */         modelExt.setCode("cong");
/* 373 */         modelExt.setIsGroup(Boolean.valueOf(false));
/* 374 */         modelExt.setIsMultiple(Boolean.valueOf(false));
/* 375 */         modelExt.setValue("cong");
/* 376 */         modelExt.setMergeField("cong");
/* 377 */         fieldDTOExt = (MergeFieldDTO)ObjectCommonUtils.cloneObject(modelExt);
/* 378 */         children.add(fieldDTOExt);
/*     */ 
/*     */ 
/*     */         
/* 382 */         fieldData.add(ObjectCommonUtils.cloneObject(mfdExt));
/*     */         
/* 384 */         a = (long)(a + osm.getTotalAmount().doubleValue());
/* 385 */         b = (long)(b + osm.getInsurancePayDouble().doubleValue());
/* 386 */         c = (long)(c + osm.getPayAmountDouble().doubleValue());
/*     */ 
/*     */         
/* 389 */         mfd.setChildren(children);
/* 390 */         fieldData.add(ObjectCommonUtils.cloneObject(mfd));
/*     */       } 
/* 392 */       String totalAmount = String.valueOf(a);
/* 393 */       String insurancePay = String.valueOf(b);
/* 394 */       String payAmount = String.valueOf(c);
/*     */       
/* 396 */       mergeFieldDTO.setCode("tongThanhTien");
/* 397 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(c)));
/* 398 */       mergeFieldDTO.setMergeField("tongThanhTien");
/* 399 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 400 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 402 */       mergeFieldDTO.setCode("tongNguonKhac");
/* 403 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(b)));
/* 404 */       mergeFieldDTO.setMergeField("tongNguonKhac");
/* 405 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 406 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 408 */       mergeFieldDTO.setCode("nguoiBenhThanhToan");
/* 409 */       mergeFieldDTO.setValue(ApiHelper.formatDecimal(Long.valueOf(a)));
/* 410 */       mergeFieldDTO.setMergeField("nguoiBenhThanhToan");
/* 411 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 412 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 414 */       mergeFieldDTO.setCode("tongChiPhi");
/* 415 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(payAmount, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 416 */       mergeFieldDTO.setMergeField("tongChiPhi");
/* 417 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 418 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 420 */       mergeFieldDTO.setCode("bhytChiTra");
/* 421 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(insurancePay, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 422 */       mergeFieldDTO.setMergeField("bhytChiTra");
/* 423 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 424 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 426 */       mergeFieldDTO.setCode("tongSoBNTra");
/* 427 */       mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(totalAmount, ((OrderServiceModel)orderServiceCDHA.get(0)).getCurrencyName(), null));
/* 428 */       mergeFieldDTO.setMergeField("tongSoBNTra");
/* 429 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 430 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 432 */       mergeFieldDTO.setCode("nguoiTongHop");
/* 433 */       mergeFieldDTO.setValue(voter);
/* 434 */       mergeFieldDTO.setMergeField("nguoiTongHop");
/* 435 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 436 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 441 */     return contentBarCode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\BangKeThanhToanProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */