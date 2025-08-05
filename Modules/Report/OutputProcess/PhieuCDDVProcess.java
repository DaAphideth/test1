/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceTypes;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuChiDinhModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.OrderServiceModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.TicketModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class PhieuCDDVProcess extends BaseProcess {
/*     */   public String getProcess(ExportModel exportModel, String contentBarCode, String filePath, String uploadfileUrl, String lang, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  28 */       GetPhieuChiDinhModel phieuChiDinhModels = this.commonReportRepo.getPhieuChiDinhDv(exportModel.getTicketId(), exportModel.getMdId());
/*  29 */       List<MdmHeaderModel> headerRes = phieuChiDinhModels.getMdmHeaderModel();
/*  30 */       List<CustomerModel> customerRes = phieuChiDinhModels.getCustomerModel();
/*  31 */       List<TicketModel> ticket = phieuChiDinhModels.getTicketModel();
/*  32 */       List<OrderServiceModel> orderService = phieuChiDinhModels.getOrderServiceModel();
/*     */       
/*  34 */       if (!ticket.isEmpty()) {
/*  35 */         String file_code = "PHIEU_CHI_DINH_XN";
/*  36 */         if (((TicketModel)ticket.get(0)).getServiceGroupCode().equalsIgnoreCase("3")) {
/*  37 */           file_code = "PHIEU_CHI_DINH_CDHA";
/*     */         }
/*  39 */         filePath = uploadfileUrl + "/" + file_code + "_" + lang + ".docx";
/*     */       } 
/*  41 */       contentBarCode = cddvProcess(contentBarCode, fieldData, mergeFieldDTO, headerRes, customerRes, ticket, orderService);
/*  42 */       return contentBarCode + "#" + filePath;
/*  43 */     } catch (Exception ex) {
/*  44 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  45 */       logger.error(exceptionAsString);
/*  46 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String cddvProcess(String contentBarCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, List<MdmHeaderModel> headerCDHARes, List<CustomerModel> customerCDHARes, List<TicketModel> ticketCDHA, List<OrderServiceModel> orderServiceCDHA) throws JsonProcessingException {
/*  52 */     if (!headerCDHARes.isEmpty()) {
/*  53 */       MdmHeaderModel departmentName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null);
/*  54 */       mergeFieldDTO.setCode("soYTe");
/*  55 */       mergeFieldDTO.setValue((departmentName != null) ? departmentName.getMedicName() : "");
/*  56 */       mergeFieldDTO.setMergeField("soYTe");
/*  57 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  58 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  60 */       MdmHeaderModel hospitalName = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null);
/*  61 */       mergeFieldDTO.setCode("tenBV");
/*  62 */       mergeFieldDTO.setValue((hospitalName != null) ? hospitalName.getMedicName() : "");
/*  63 */       mergeFieldDTO.setMergeField("tenBV");
/*  64 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  65 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  67 */       MdmHeaderModel addHospital = headerCDHARes.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("ADDRESS")).findFirst().orElse(null);
/*  68 */       mergeFieldDTO.setCode("diaChiBV");
/*  69 */       mergeFieldDTO.setValue((addHospital != null) ? addHospital.getMedicName() : "");
/*  70 */       mergeFieldDTO.setMergeField("diaChiBV");
/*  71 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  72 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*  74 */     if (!customerCDHARes.isEmpty()) {
/*  75 */       CustomerModel customerModel = customerCDHARes.get(0);
/*  76 */       contentBarCode = customerModel.getPatientId();
/*     */       
/*  78 */       mergeFieldDTO.setCode("maBN");
/*  79 */       mergeFieldDTO.setValue(customerModel.getPatientId());
/*  80 */       mergeFieldDTO.setMergeField("maBN");
/*  81 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  82 */       fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */       
/*  85 */       mergeFieldDTO.setCode("tenBN");
/*  86 */       mergeFieldDTO.setValue(customerModel.getName());
/*  87 */       mergeFieldDTO.setMergeField("tenBN");
/*  88 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  89 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  91 */       mergeFieldDTO.setCode("namSinh");
/*  92 */       mergeFieldDTO.setValue(customerModel.getYearBorn());
/*  93 */       mergeFieldDTO.setMergeField("namSinh");
/*  94 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  95 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/*  97 */       mergeFieldDTO.setCode("tuoi");
/*  98 */       mergeFieldDTO.setValue(customerModel.getAge());
/*  99 */       mergeFieldDTO.setMergeField("tuoi");
/* 100 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 101 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 103 */       mergeFieldDTO.setCode("gioiTinh");
/* 104 */       mergeFieldDTO.setValue(customerModel.getGender());
/* 105 */       mergeFieldDTO.setMergeField("gioiTinh");
/* 106 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 109 */       mergeFieldDTO.setCode("diaChiBN");
/* 110 */       mergeFieldDTO.setValue(customerModel.getAddress());
/* 111 */       mergeFieldDTO.setMergeField("diaChiBN");
/* 112 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 113 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 115 */       mergeFieldDTO.setCode("noiChiDinh");
/* 116 */       mergeFieldDTO.setValue(customerModel.getRoomName());
/* 117 */       mergeFieldDTO.setMergeField("noiChiDinh");
/* 118 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 119 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 121 */       mergeFieldDTO.setCode("doiTuong");
/* 122 */       mergeFieldDTO.setValue(customerModel.getCustomerType());
/* 123 */       mergeFieldDTO.setMergeField("doiTuong");
/* 124 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 125 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 127 */       mergeFieldDTO.setCode("cccd");
/* 128 */       mergeFieldDTO.setValue(customerModel.getCccd());
/* 129 */       mergeFieldDTO.setMergeField("cccd");
/* 130 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 131 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 133 */       mergeFieldDTO.setCode("soBH");
/* 134 */       mergeFieldDTO.setValue(customerModel.getSoBH());
/* 135 */       mergeFieldDTO.setMergeField("soBH");
/* 136 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 137 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 139 */       mergeFieldDTO.setCode("hanBH");
/* 140 */       mergeFieldDTO.setValue(customerModel.getHanBH());
/* 141 */       mergeFieldDTO.setMergeField("hanBH");
/* 142 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 143 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 145 */       mergeFieldDTO.setCode("insuranceFromDate");
/* 146 */       mergeFieldDTO.setValue(customerModel.getInsuranceFromDate());
/* 147 */       mergeFieldDTO.setMergeField("insuranceFromDate");
/* 148 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 149 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 151 */       mergeFieldDTO.setCode("insuranceExpirationDate");
/* 152 */       mergeFieldDTO.setValue(customerModel.getInsuranceExpirationDate());
/* 153 */       mergeFieldDTO.setMergeField("insuranceExpirationDate");
/* 154 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 155 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/*     */     
/* 158 */     if (!ticketCDHA.isEmpty()) {
/* 159 */       TicketModel ticketModel = ticketCDHA.get(0);
/* 160 */       List<ReExaminationModel> reExam = new ArrayList<>();
/* 161 */       if (StringUtils.isNotBlank(ticketModel.getDiagnosticArray()))
/* 162 */         reExam = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticArray(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */           ); 
/* 164 */       List<ReExaminationModel> reExamSub = new ArrayList<>();
/* 165 */       if (StringUtils.isNotBlank(ticketModel.getDiagnosticSubArray()))
/* 166 */         reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(ticketModel.getDiagnosticSubArray(), new TypeReference<List<ReExaminationModel>>() {
/*     */             
/*     */             }); 
/* 169 */       String getDiagnosticSub = reExamSub.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/* 170 */       mergeFieldDTO.setCode("chanDoan");
/* 171 */       mergeFieldDTO.setValue((reExam != null && reExam
/* 172 */           .size() > 0) ? ((
/* 173 */           StringUtils.isNotBlank(((ReExaminationModel)reExam.get(0)).getCode()) ? (((ReExaminationModel)reExam.get(0)).getCode() + " - ") : "") + ((ReExaminationModel)reExam.get(0)).getName() + "; " + getDiagnosticSub) : "");
/*     */       
/* 175 */       mergeFieldDTO.setMergeField("chanDoan");
/* 176 */       MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 177 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 179 */       mergeFieldDTO.setCode("phongThucHien");
/* 180 */       mergeFieldDTO.setValue(StringUtils.isEmpty(ticketModel.getTitlePrintName()) ? ticketModel.getRoomHandleName() : ticketModel.getTitlePrintName());
/* 181 */       mergeFieldDTO.setMergeField("phongThucHien");
/* 182 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 183 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 185 */       mergeFieldDTO.setCode("khamCC");
/* 186 */       mergeFieldDTO.setValue(ticketModel.getExaminationCC());
/* 187 */       mergeFieldDTO.setMergeField("khamCC");
/* 188 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 189 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 191 */       mergeFieldDTO.setCode("khamThuong");
/* 192 */       mergeFieldDTO.setValue(ticketModel.getExaminationKT());
/* 193 */       mergeFieldDTO.setMergeField("khamThuong");
/* 194 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 195 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 197 */       mergeFieldDTO.setCode("maVP");
/* 198 */       mergeFieldDTO.setValue(ticketModel.getCode());
/* 199 */       mergeFieldDTO.setMergeField("maVP");
/* 200 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 201 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 203 */       mergeFieldDTO.setCode("soPhieu");
/* 204 */       mergeFieldDTO.setValue(ticketModel.getId());
/* 205 */       mergeFieldDTO.setMergeField("soPhieu");
/* 206 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 207 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 209 */       mergeFieldDTO.setCode("bsChiDinh");
/* 210 */       mergeFieldDTO.setValue(ticketModel.getDoctorName());
/* 211 */       mergeFieldDTO.setMergeField("bsChiDinh");
/* 212 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 213 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 215 */       mergeFieldDTO.setCode("gioKham");
/* 216 */       mergeFieldDTO.setValue(ticketModel.getHourExam());
/* 217 */       mergeFieldDTO.setMergeField("gioKham");
/* 218 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 219 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 221 */       mergeFieldDTO.setCode("ngayKham");
/* 222 */       mergeFieldDTO.setValue(ticketModel.getDayExam());
/* 223 */       mergeFieldDTO.setMergeField("ngayKham");
/* 224 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 225 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 227 */       mergeFieldDTO.setCode("thangKham");
/* 228 */       mergeFieldDTO.setValue(ticketModel.getMonthExam());
/* 229 */       mergeFieldDTO.setMergeField("thangKham");
/* 230 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 231 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 233 */       mergeFieldDTO.setCode("namKham");
/* 234 */       mergeFieldDTO.setValue(ticketModel.getYearExam());
/* 235 */       mergeFieldDTO.setMergeField("namKham");
/* 236 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 237 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 239 */       mergeFieldDTO.setCode("barCode");
/* 240 */       mergeFieldDTO.setValue(ticketModel.getBarCode());
/* 241 */       mergeFieldDTO.setMergeField("barCode");
/* 242 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 243 */       fieldData.add(mergeFieldDTOClone);
/*     */     } 
/* 245 */     if (!orderServiceCDHA.isEmpty()) {
/* 246 */       Double p = Double.valueOf(0.0D);
/* 247 */       int stt = 0;
/*     */       
/* 249 */       Set<Integer> serviceTypeIds = (Set<Integer>)orderServiceCDHA.stream().map(OrderServiceModel::getServiceTypeId).collect(Collectors.toSet());
/* 250 */       List<OrderServiceModel> orderServiceModels = new ArrayList<>();
/*     */       
/* 252 */       for (Integer serviceTypeId : serviceTypeIds) {
/* 253 */         stt++;
/* 254 */         Optional<MedicServiceTypes> serviceTypes = this.serviceTypeRepository.findById(serviceTypeId);
/* 255 */         OrderServiceModel model = new OrderServiceModel();
/* 256 */         model.setServiceName(serviceTypes.isPresent() ? ((MedicServiceTypes)serviceTypes.get()).getName() : "");
/* 257 */         model.setServiceTypeId(serviceTypeId);
/* 258 */         model.setStt(String.valueOf(stt));
/* 259 */         model.setIsEdit(Integer.valueOf(0));
/* 260 */         model.setTotalAmount(Double.valueOf(0.0D));
/* 261 */         orderServiceModels.add(model);
/*     */       } 
/* 263 */       orderServiceModels.addAll(orderServiceCDHA);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 268 */       List<OrderServiceModel> modelList = (List<OrderServiceModel>)orderServiceModels.stream().sorted(Comparator.comparing(OrderServiceModel::getServiceTypeId)).collect(Collectors.toList());
/*     */       
/* 270 */       for (OrderServiceModel osm : modelList) {
/* 271 */         MergeFieldDTO mfd = new MergeFieldDTO();
/* 272 */         mfd.setCode("«start»");
/* 273 */         mfd.setIsGroup(Boolean.valueOf(true));
/* 274 */         mfd.setIsMultiple(Boolean.valueOf(true));
/* 275 */         mfd.setStartGroup("«start»");
/* 276 */         mfd.setEndGroup("«end»");
/*     */         
/* 278 */         List<MergeFieldDTO> children = new ArrayList<>();
/* 279 */         MergeFieldDTO model = new MergeFieldDTO();
/*     */         
/* 281 */         model.setCode("tenDichVu");
/* 282 */         model.setIsGroup(Boolean.valueOf(false));
/* 283 */         model.setIsMultiple(Boolean.valueOf(false));
/* 284 */         model.setValue(osm.getServiceName());
/* 285 */         model.setMergeField("tenDichVu");
/* 286 */         MergeFieldDTO fieldDTO = model;
/* 287 */         children.add(fieldDTO);
/*     */         
/* 289 */         if (osm.getIsEdit().equals(Integer.valueOf(0))) {
/* 290 */           model = new MergeFieldDTO();
/* 291 */           model.setCode("stt");
/* 292 */           model.setIsGroup(Boolean.valueOf(false));
/* 293 */           model.setIsMultiple(Boolean.valueOf(false));
/* 294 */           model.setValue(osm.getStt() + ". ");
/* 295 */           model.setMergeField("stt");
/* 296 */           fieldDTO = model;
/* 297 */           children.add(fieldDTO);
/*     */         } else {
/* 299 */           model = new MergeFieldDTO();
/* 300 */           model.setCode("stt");
/* 301 */           model.setIsGroup(Boolean.valueOf(false));
/* 302 */           model.setIsMultiple(Boolean.valueOf(false));
/* 303 */           model.setValue(" - ");
/* 304 */           model.setMergeField("stt");
/* 305 */           fieldDTO = model;
/* 306 */           children.add(fieldDTO);
/*     */           
/* 308 */           model = new MergeFieldDTO();
/* 309 */           model.setCode("thanhTien");
/* 310 */           model.setIsGroup(Boolean.valueOf(false));
/* 311 */           model.setIsMultiple(Boolean.valueOf(false));
/* 312 */           model.setValue(osm.getPayAmount());
/* 313 */           model.setMergeField("thanhTien");
/* 314 */           fieldDTO = model;
/* 315 */           children.add(fieldDTO);
/*     */         } 
/*     */ 
/*     */         
/* 319 */         model = new MergeFieldDTO();
/* 320 */         model.setCode("donvi");
/* 321 */         model.setIsGroup(Boolean.valueOf(false));
/* 322 */         model.setIsMultiple(Boolean.valueOf(false));
/* 323 */         model.setValue(osm.getUnit());
/* 324 */         model.setMergeField("donvi");
/* 325 */         fieldDTO = model;
/* 326 */         children.add(fieldDTO);
/*     */         
/* 328 */         model = new MergeFieldDTO();
/* 329 */         model.setCode("soLuong");
/* 330 */         model.setIsGroup(Boolean.valueOf(false));
/* 331 */         model.setIsMultiple(Boolean.valueOf(false));
/* 332 */         model.setValue((osm.getQty() == null) ? "" : String.valueOf(osm.getQty()));
/* 333 */         model.setMergeField("soLuong");
/* 334 */         fieldDTO = model;
/* 335 */         children.add(fieldDTO);
/*     */         
/* 337 */         model = new MergeFieldDTO();
/* 338 */         model.setCode("donGia");
/* 339 */         model.setIsGroup(Boolean.valueOf(false));
/* 340 */         model.setIsMultiple(Boolean.valueOf(false));
/* 341 */         model.setValue(osm.getPrice());
/* 342 */         model.setMergeField("donGia");
/* 343 */         fieldDTO = model;
/* 344 */         children.add(fieldDTO);
/*     */         
/* 346 */         mfd.setChildren(children);
/* 347 */         fieldData.add(mfd);
/*     */         
/* 349 */         p = Double.valueOf(p.doubleValue() + ((osm.getTotalAmount() == null) ? 0.0D : osm.getTotalAmount().doubleValue()));
/*     */       } 
/* 351 */       MergeFieldDTO mfTong = new MergeFieldDTO();
/* 352 */       mfTong.setCode("tongTien");
/* 353 */       mfTong.setValue(ApiHelper.formatDecimal(p));
/* 354 */       mfTong.setMergeField("tongTien");
/* 355 */       fieldData.add(mfTong);
/*     */     } 
/*     */     
/* 358 */     return contentBarCode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuCDDVProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */