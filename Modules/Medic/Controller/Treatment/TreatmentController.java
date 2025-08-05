/*     */ package nencer.app.Modules.Medic.Controller.Treatment;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinStatus;
/*     */ import nencer.app.Constant.CheckinType;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Department.MedicDepartments;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExamination;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExaminationResults;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordModel;
/*     */ import nencer.app.Modules.Medic.Model.Examination.InsuranceCustomerModel;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicOrderServiceDetail;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicBedRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicChamberRepository;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class TreatmentController extends BaseMedicController {
/*  48 */   public static final Logger logger = LoggerFactory.getLogger(TreatmentController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicChamberRepository medicChamberRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicBedRepository medicBedRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   DepartmentRepository departmentRepository;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment"})
/*     */   public ApiResponse getInputPatient(@Valid @RequestParam Integer departmentId, @Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "createdAt", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*     */     try {
/*  71 */       if (ObjectUtils.isEmpty(departmentId)) {
/*  72 */         return this.apiError.getError("02");
/*     */       }
/*  74 */       return getCheckinProcess(page, size, filter, fieldSort, direction, new String[] { CheckinStatus.WAITING
/*  75 */             .getCheckinStatus(), CheckinStatus.PROCESSING
/*  76 */             .getCheckinStatus(), CheckinStatus.DONE
/*  77 */             .getCheckinStatus() }, OrderStatus.PAID
/*  78 */           .getOrderStatus(), CheckinType.IN_PATIENT.getCheckinType(), departmentId);
/*  79 */     } catch (Exception e) {
/*  80 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  81 */       logger.error(exceptionAsString);
/*  82 */       return this.apiError.getError("999", new String[] { exceptionAsString });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment2"})
/*     */   public ApiResponse getInputPatient(@Valid @RequestParam Integer userId, @RequestParam(required = false) Integer departmentId, @RequestParam(required = false) Integer patientId, @RequestParam(required = false) String searchValue, @RequestParam(required = false) String customerType, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "created_at", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 102 */     ApiResponse rs = new ApiResponse();
/* 103 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 105 */       String d = departmentId + "";
/* 106 */       if (departmentId == null || departmentId.intValue() <= 0) {
/*     */         
/* 108 */         List<MedicDepartments> ld = this.departmentRepository.findByAllowUserId(userId).orElse(null);
/* 109 */         if (ld != null && ld.size() > 0) {
/* 110 */           d = "";
/*     */           
/* 112 */           for (MedicDepartments md : ld) {
/* 113 */             d = d + md.getId() + ",";
/*     */           }
/* 115 */           d = StringUtils.chop(d);
/*     */         } 
/*     */       } 
/*     */       
/* 119 */       List<MedicCheckinRecordModel> list = this.commonCheckinRepo.getCheckinRecordSp(userId, null, d, patientId, searchValue, customerType, CheckinType.IN_PATIENT
/* 120 */           .getCheckinType(), fromDate, toDate, fieldSort, direction, page, size);
/*     */       
/* 122 */       data.put("dataRes", list);
/* 123 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicCheckinRecordModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 125 */       rs.put("status", "OK");
/* 126 */       rs.put("responseCode", "00");
/* 127 */       rs.put("data", data);
/* 128 */     } catch (Exception e) {
/* 129 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 130 */       logger.error(exceptionAsString);
/* 131 */       rs = this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 133 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/treatmentProcess/{mdId}"})
/*     */   public ApiResponse examinationProcess(@PathVariable @Valid Integer mdId) {
/* 142 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 145 */       if (mdId == null) {
/* 146 */         return this.apiError.getError("02");
/*     */       }
/* 148 */       Optional<MedicCheckinRecord> medicCheckinRecordOp = this.medicCheckinRecordRepository.findById(mdId);
/* 149 */       if (!medicCheckinRecordOp.isPresent()) {
/* 150 */         return this.apiError.getError("02");
/*     */       }
/* 152 */       MedicCheckinRecord medicCheckinRecord = medicCheckinRecordOp.get();
/* 153 */       medicCheckinRecord.setStatus(CheckinStatus.PROCESSING.getCheckinStatus());
/* 154 */       medicCheckinRecord.setUpdatedAt(new Date());
/* 155 */       this.medicCheckinRecordRepository.saveAndFlush(medicCheckinRecord);
/*     */ 
/*     */       
/* 158 */       rs.put("status", "OK");
/* 159 */       rs.put("responseCode", "00");
/* 160 */       rs.put("data", "THANH CONG");
/*     */     }
/* 162 */     catch (Exception e) {
/* 163 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 164 */       logger.error(exceptionAsString);
/* 165 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 167 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_treatment/create"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicCheckinRecord medicCheckinRecordRq) {
/* 176 */     ApiResponse rs = new ApiResponse();
/* 177 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 179 */       Optional<MedicCheckinRecord> medicCheckinRecordOp = this.medicCheckinRecordRepository.findById(medicCheckinRecordRq.getMdId());
/* 180 */       if (!medicCheckinRecordOp.isPresent())
/* 181 */         return this.apiError.getError("202", new String[] { medicCheckinRecordRq.getMdId() + "" }); 
/* 182 */       MedicCheckinRecord medicCheckinRecord = medicCheckinRecordOp.get();
/* 183 */       medicCheckinRecord.setUpdatedAt(new Date());
/* 184 */       medicCheckinRecord.setChamberId(medicCheckinRecordRq.getChamberId());
/* 185 */       medicCheckinRecord.setBedId(medicCheckinRecordRq.getBedId());
/* 186 */       medicCheckinRecord.setRoomTreatmentId(medicCheckinRecordRq.getRoomTreatmentId());
/* 187 */       medicCheckinRecord.setDoctorId(medicCheckinRecordRq.getDoctorId());
/* 188 */       medicCheckinRecord.setDoctorName(medicCheckinRecordRq.getDoctorName());
/* 189 */       medicCheckinRecord.setCheckinInfo(medicCheckinRecordRq.getCheckinInfo());
/* 190 */       this.medicCheckinRecordRepository.saveAndFlush(medicCheckinRecord);
/*     */       
/* 192 */       Optional<MedicExamination> medicExaminationOp = this.examinationRepository.findByMdId(medicCheckinRecordRq.getMdId());
/* 193 */       if (medicExaminationOp.isPresent()) {
/* 194 */         MedicExamination examination = medicExaminationOp.get();
/* 195 */         examination.setDoctorName(medicCheckinRecordRq.getDoctorName());
/* 196 */         examination.setDoctorId(medicCheckinRecordRq.getDoctorId());
/* 197 */         examination.setDiagnosticArray(medicCheckinRecordRq.getDiagnosticArray());
/* 198 */         examination.setDiagnosticSubArray(medicCheckinRecordRq.getDiagnosticSubArray());
/* 199 */         examination.setUpdatedAt(new Date());
/* 200 */         this.examinationRepository.saveAndFlush(examination);
/*     */       } else {
/* 202 */         MedicExamination medicExamination = new MedicExamination();
/* 203 */         medicExamination.setMdId(medicCheckinRecordRq.getMdId());
/* 204 */         medicExamination.setDoctorName(medicCheckinRecordRq.getDoctorName());
/* 205 */         medicExamination.setDoctorId(medicCheckinRecordRq.getDoctorId());
/* 206 */         medicExamination.setDiagnosticArray(medicCheckinRecordRq.getDiagnosticArray());
/* 207 */         medicExamination.setDiagnosticSubArray(medicCheckinRecordRq.getDiagnosticSubArray());
/* 208 */         medicExamination.setCreatedAt(new Date());
/* 209 */         this.examinationRepository.saveAndFlush(medicExamination);
/*     */       } 
/* 211 */       data.put("id", ((MedicCheckinRecord)medicCheckinRecordOp.get()).getMdId());
/*     */       
/* 213 */       rs.put("status", "OK");
/* 214 */       rs.put("responseCode", "00");
/* 215 */       rs.put("data", data);
/*     */     }
/* 217 */     catch (Exception e) {
/* 218 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 219 */       logger.error(exceptionAsString);
/* 220 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 221 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 223 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/getTreatment/{mdId}"})
/*     */   public ApiResponse getCheckinService(@PathVariable @Valid Integer mdId) {
/* 231 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 234 */       if (mdId == null) {
/* 235 */         return this.apiError.getError("02");
/*     */       }
/* 237 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 238 */       if (!medicCheckinRecord.isPresent()) {
/* 239 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/* 241 */       MedicCheckinRecord m = medicCheckinRecord.get();
/* 242 */       Optional<MedicExamination> medicExaminationOp = this.examinationRepository.findByMdId(mdId);
/* 243 */       if (medicExaminationOp.isPresent()) {
/* 244 */         MedicExamination s = medicExaminationOp.get();
/* 245 */         m.setDiagnosticArray(s.getDiagnosticArray());
/* 246 */         m.setDiagnosticSubArray(s.getDiagnosticSubArray());
/*     */       } 
/*     */       
/* 249 */       rs.put("status", "OK");
/* 250 */       rs.put("responseCode", "00");
/* 251 */       rs.put("data", m);
/*     */     }
/* 253 */     catch (Exception e) {
/* 254 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 255 */       logger.error(exceptionAsString);
/* 256 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 258 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/treatmentCancel/{mdId}"})
/*     */   public ApiResponse treatmentCancel(@PathVariable @Valid Integer mdId) {
/* 266 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 269 */       if (mdId == null) {
/* 270 */         return this.apiError.getError("02");
/*     */       }
/* 272 */       Optional<MedicCheckinRecord> checkinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 273 */       if (!checkinRecord.isPresent()) {
/* 274 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 278 */       List<MedicTicket> medicTickets = this.ticketRepository.findAllByTicketTypeAndMdId(TicketType.MEDIC.getTicketType(), mdId).orElse(new ArrayList<>());
/* 279 */       if (medicTickets.size() > 0) {
/* 280 */         return this.apiError.getError("309", new String[0]);
/*     */       }
/*     */       
/* 283 */       MedicCheckinRecord medicCheckinR = checkinRecord.get();
/* 284 */       medicCheckinR.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 285 */       medicCheckinR.setUpdatedAt(new Date());
/* 286 */       this.medicCheckinRecordRepository.saveAndFlush(medicCheckinR);
/*     */ 
/*     */       
/* 289 */       rs.put("status", "OK");
/* 290 */       rs.put("responseCode", "00");
/* 291 */       rs.put("data", "THANH CONG");
/*     */     }
/* 293 */     catch (Exception e) {
/* 294 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 295 */       logger.error(exceptionAsString);
/* 296 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 298 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_treatment/createSolve"})
/*     */   public ApiResponse createSolve(@Valid @RequestBody MedicExaminationResults request) {
/* 307 */     ApiResponse rs = new ApiResponse();
/* 308 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 310 */       String status = CheckinStatus.DONE.getCheckinStatus();
/* 311 */       String checkinStatus = CheckinStatus.DONE.getCheckinStatus();
/*     */       
/* 313 */       Optional<MedicCheckinRecord> medicTicketRecord = this.medicCheckinRecordRepository.findById(Integer.valueOf(request.getMdId()));
/* 314 */       if (!medicTicketRecord.isPresent()) {
/* 315 */         return this.apiError.getError("202", new String[] { String.valueOf(request.getMdId()) });
/*     */       }
/* 317 */       this.examinationResultRepository.deleteByMdId(Integer.valueOf(request.getMdId()));
/*     */       
/* 319 */       if (request.getFromResultArray().contains("0")) {
/*     */         
/* 321 */         MedicCheckinRecord medicCheckinDieuTri = (MedicCheckinRecord)ObjectCommonUtils.cloneObject(medicTicketRecord.get());
/* 322 */         medicCheckinDieuTri.setMdId(null);
/* 323 */         medicCheckinDieuTri.setMdType(CheckinType.IN_PATIENT.getCheckinType());
/* 324 */         medicCheckinDieuTri.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 325 */         medicCheckinDieuTri.setDepartmentId(Integer.valueOf(Integer.parseInt(request.getHospitalization())));
/* 326 */         medicCheckinDieuTri.setCreatedAt(new Date());
/* 327 */         this.medicCheckinRecordRepository.saveAndFlush(medicCheckinDieuTri);
/* 328 */         checkinStatus = CheckinStatus.PROCESSING.getCheckinStatus();
/*     */       } 
/* 330 */       request.setCreatedAt(new Date());
/* 331 */       MedicExaminationResults x = (MedicExaminationResults)this.examinationResultRepository.saveAndFlush(request);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 338 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(Integer.valueOf(request.getMdId()));
/* 339 */       if (medicCheckinRecord.isPresent()) {
/* 340 */         this.medicCheckinRecordRepository.updateStatus(((MedicCheckinRecord)medicCheckinRecord.get()).getMdId(), status);
/* 341 */         this.checkinRepository.updateStatus(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId(), checkinStatus);
/*     */       } 
/* 343 */       data.put("id", Integer.valueOf(x.getId()));
/*     */       
/* 345 */       rs.put("status", "OK");
/* 346 */       rs.put("responseCode", "00");
/* 347 */       rs.put("data", data);
/*     */     }
/* 349 */     catch (Exception e) {
/* 350 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 351 */       logger.error(exceptionAsString);
/* 352 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 353 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 355 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/getPayment/{mdId}"})
/*     */   public ApiResponse getPayment(@PathVariable @Valid Integer mdId) {
/* 363 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 365 */       if (mdId == null) {
/* 366 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 369 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 370 */       if (!medicCheckinRecord.isPresent()) {
/* 371 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/* 373 */       List<MedicOrderServiceDetail> orderServices = this.commonTicketRepo.spGetMedicOrderServiceByMdId(mdId);
/*     */       
/* 375 */       double totalevent = orderServices.stream().mapToDouble(MedicOrderServiceDetail::getPayAmount).sum();
/*     */ 
/*     */ 
/*     */       
/* 379 */       List<InsuranceCustomerModel> insuranceCustomer = this.medicService.sp_get_information_insurance_customer(mdId.intValue());
/* 380 */       if (CollectionUtils.isNotEmpty(insuranceCustomer)) {
/* 381 */         Double minimumSalaryMonth = ((InsuranceCustomerModel)insuranceCustomer.get(0)).getMinimumSalaryMonth();
/* 382 */         Integer benefitRate = ((InsuranceCustomerModel)insuranceCustomer.get(0)).getBenefitRate();
/* 383 */         Integer actualBenefits = Integer.valueOf((totalevent < minimumSalaryMonth.doubleValue()) ? 100 : benefitRate.intValue());
/* 384 */         ((InsuranceCustomerModel)insuranceCustomer.get(0)).setActualBenefits(actualBenefits);
/* 385 */         rs.put("dataInsurance", insuranceCustomer);
/*     */       } 
/*     */       
/* 388 */       Set<MedicProductOrderDetailModel> setMedicProductOrderDetailModels = new HashSet<>();
/* 389 */       List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSpViewPayment(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId(), null);
/* 390 */       for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */         
/* 392 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSpExport(Integer.valueOf(medicProductOrderModel.getId()), medicProductOrderModel.getCreatorId()));
/* 393 */         setMedicProductOrderDetailModels.addAll(medicProductOrderDetailModels);
/*     */       } 
/* 395 */       if (setMedicProductOrderDetailModels != null && setMedicProductOrderDetailModels.size() > 0) {
/* 396 */         MedicServiceGroups mg = this.serviceGroupRepository.findById(Integer.valueOf(6)).orElse(null);
/*     */         
/* 398 */         for (MedicProductOrderDetailModel pod : setMedicProductOrderDetailModels)
/*     */         {
/* 400 */           orderServices.add(MedicOrderServiceDetail.builder()
/* 401 */               .id(Integer.valueOf(pod.getId()))
/* 402 */               .mdId(mdId)
/* 403 */               .serviceGroupId(Integer.valueOf(6))
/* 404 */               .serviceGroupName(mg.getName())
/* 405 */               .serviceCode(pod.getCode())
/* 406 */               .serviceName(pod.getName())
/* 407 */               .creatorId(pod.getCreatorId())
/* 408 */               .creatorName(pod.getCreatorName())
/* 409 */               .qty(pod.getQty())
/* 410 */               .price(pod.getPrice())
/* 411 */               .payAmount(Double.valueOf((pod.getPayAmount() == null) ? 0.0D : pod.getPayAmount().doubleValue()))
/*     */               
/* 413 */               .totalAmount(Double.valueOf((pod.getTotalAmount() == null) ? 0.0D : pod.getTotalAmount().doubleValue()))
/* 414 */               .unit(pod.getUnit())
/* 415 */               .currencyCode(pod.getCurrencyCode())
/* 416 */               .build());
/*     */         }
/*     */       } 
/*     */       
/* 420 */       rs.put("status", "OK");
/* 421 */       rs.put("responseCode", "00");
/* 422 */       rs.put("data", orderServices);
/*     */     
/*     */     }
/* 425 */     catch (Exception e) {
/* 426 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 427 */       logger.error(exceptionAsString);
/* 428 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 430 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\TreatmentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */