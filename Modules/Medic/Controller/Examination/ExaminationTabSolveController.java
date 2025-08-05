/*     */ package nencer.app.Modules.Medic.Controller.Examination;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinStatus;
/*     */ import nencer.app.Constant.CheckinType;
/*     */ import nencer.app.Constant.CustomerType;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.ServiceObjectType;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExamination;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExaminationResults;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExaminationResultsHis;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.Examination.MedicExaminationResultsRs;
/*     */ import nencer.app.Modules.Report.Model.ExaminationSolveModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExaminationTabSolveController extends BaseMedicController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationTabSolveController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getSolveResult/{mdId}"})
/*     */   public ApiResponse getServiceGroup(@PathVariable @Valid Integer mdId) {
/*  54 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  57 */       MedicExaminationResultsRs examinations = this.commonTicketRepo.spGetExaminationByMdId(mdId);
/*     */       
/*  59 */       rs.put("status", "OK");
/*  60 */       rs.put("responseCode", "00");
/*  61 */       rs.put("data", examinations);
/*     */     }
/*  63 */     catch (Exception e) {
/*  64 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  65 */       logger.error(exceptionAsString);
/*  66 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  68 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/checkSolve/{mdId}"})
/*     */   public ApiResponse checkSolve(@PathVariable @Valid Integer mdId) {
/*  76 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  79 */       List<MedicTicket> examinations = this.commonCheckinRepo.getSolveResult(mdId);
/*     */       
/*  81 */       if (examinations.size() > 0) {
/*  82 */         return this.apiError.getError("212", new String[0]);
/*     */       }
/*     */       
/*  85 */       rs.put("status", "OK");
/*  86 */       rs.put("responseCode", "00");
/*  87 */       String desc = this.env.getProperty("nencerapi.error.err217");
/*  88 */       rs.put("data", desc);
/*     */     }
/*  90 */     catch (Exception e) {
/*  91 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  92 */       logger.error(exceptionAsString);
/*  93 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  95 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/createSolve"})
/*     */   public ApiResponse createSolve(@Valid @RequestBody MedicExaminationResults request) {
/* 108 */     ApiResponse rs = new ApiResponse();
/* 109 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 111 */       String status = CheckinStatus.DONE.getCheckinStatus();
/* 112 */       String checkinStatus = CheckinStatus.DONE.getCheckinStatus();
/*     */       
/* 114 */       Optional<MedicCheckinRecord> medicTicketRecord = this.medicCheckinRecordRepository.findById(Integer.valueOf(request.getMdId()));
/* 115 */       if (!medicTicketRecord.isPresent()) {
/* 116 */         return this.apiError.getError("202", new String[] { String.valueOf(request.getMdId()) });
/*     */       }
/* 118 */       this.examinationResultRepository.deleteByMdId(Integer.valueOf(request.getMdId()));
/* 119 */       MedicCheckinRecord mcr = medicTicketRecord.get();
/* 120 */       if (request.getFromResultArray().contains("2")) {
/*     */         
/* 122 */         if (mcr.getMdType().equalsIgnoreCase(CheckinType.OUT_PATIENT.getCheckinType())) {
/*     */           
/* 124 */           List<MedicCheckinRecord> listRcCheck = this.medicCheckinRecordRepository.findAllByCheckinIdAndMdTypeAndStatusIn(mcr.getMedicCheckin().getId(), CheckinType.IN_PATIENT.getCheckinType(), 
/* 125 */               Arrays.asList(new String[] { CheckinStatus.WAITING.getCheckinStatus(), CheckinStatus.PROCESSING.getCheckinStatus() }));
/* 126 */           if (listRcCheck.size() > 0) {
/* 127 */             return this.apiError.getError("208", new String[] { String.valueOf(request.getMdId()) });
/*     */           }
/*     */         } 
/* 130 */         MedicCheckinRecord medicCheckinDieuTri = (MedicCheckinRecord)ObjectCommonUtils.cloneObject(medicTicketRecord.get());
/* 131 */         medicCheckinDieuTri.setMdId(null);
/* 132 */         medicCheckinDieuTri.setMdType(CheckinType.IN_PATIENT.getCheckinType());
/* 133 */         medicCheckinDieuTri.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 134 */         medicCheckinDieuTri.setDepartmentId(Integer.valueOf(Integer.parseInt(request.getHospitalization())));
/* 135 */         medicCheckinDieuTri.setCreatedAt(new Date());
/* 136 */         medicCheckinDieuTri.setMdIdBefore(Integer.valueOf(request.getMdId()));
/* 137 */         medicCheckinDieuTri.setFromResultArray(request.getFromResultArray());
/* 138 */         MedicCheckinRecord mdDieutri = (MedicCheckinRecord)this.medicCheckinRecordRepository.saveAndFlush(medicCheckinDieuTri);
/* 139 */         checkinStatus = CheckinStatus.PROCESSING.getCheckinStatus();
/*     */ 
/*     */         
/*     */         try {
/* 143 */           MedicExamination examination = this.examinationRepository.findByMdId(Integer.valueOf(request.getMdId())).orElse(null);
/* 144 */           if (examination != null) {
/* 145 */             ExaminationSolveModel appointment = (ExaminationSolveModel)this.objectMapper.readValue(examination.getExaminationArray(), ExaminationSolveModel.class);
/* 146 */             if (appointment != null) {
/* 147 */               MedicExamination medicExamination = new MedicExamination();
/* 148 */               medicExamination.setMdId(mdDieutri.getMdId());
/* 149 */               medicExamination.setDiagnosticArray(this.objectMapper.writeValueAsString(appointment.getDiagnosticArray()));
/* 150 */               medicExamination.setDiagnosticSubArray(this.objectMapper.writeValueAsString(appointment.getDiagnosticSubArray()));
/* 151 */               medicExamination.setCreatedAt(new Date());
/* 152 */               this.examinationRepository.saveAndFlush(medicExamination);
/*     */             } 
/*     */           } 
/* 155 */         } catch (Exception ex) {
/* 156 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 157 */           logger.error(exceptionAsString);
/*     */         } 
/*     */       } 
/* 160 */       if (request.getFromResultArray().contains("1")) {
/*     */ 
/*     */         
/* 163 */         MedicCheckinRecord medicCheckinChuyenKhoa = (MedicCheckinRecord)ObjectCommonUtils.cloneObject(medicTicketRecord.get());
/* 164 */         medicCheckinChuyenKhoa.setMdId(null);
/* 165 */         medicCheckinChuyenKhoa.setMdType(CheckinType.OUT_PATIENT.getCheckinType());
/* 166 */         medicCheckinChuyenKhoa.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 167 */         medicCheckinChuyenKhoa.setPaymentStatus(InvoiceStatus.UNPAID.getInvoiceStatus());
/* 168 */         medicCheckinChuyenKhoa.setRoomId(request.getRoomId());
/* 169 */         medicCheckinChuyenKhoa.setCreatedAt(new Date());
/* 170 */         medicCheckinChuyenKhoa.setMdIdBefore(Integer.valueOf(request.getMdId()));
/* 171 */         medicCheckinChuyenKhoa.setFromResultArray(request.getFromResultArray());
/* 172 */         medicCheckinChuyenKhoa = (MedicCheckinRecord)this.medicCheckinRecordRepository.saveAndFlush(medicCheckinChuyenKhoa);
/* 173 */         checkinStatus = CheckinStatus.WAITING.getCheckinStatus();
/*     */         
/* 175 */         Integer num = this.medicService.getSttCheckin(medicCheckinChuyenKhoa.getMdId(), request.getRoomId());
/* 176 */         this.medicCheckinRecordRepository.updateStt(medicCheckinChuyenKhoa.getMdId(), num);
/*     */         
/* 178 */         MedicServices medicServices = this.serviceRepository.findById(request.getServiceId()).orElse(null);
/* 179 */         MedicCheckin medicCheckin = this.checkinRepository.findById(((MedicCheckinRecord)medicTicketRecord.get()).getCheckinId()).orElse(null);
/*     */ 
/*     */         
/* 182 */         this.checkinRepository.updateNewCheckinRecord(request.getRoomId(), medicServices.getId(), medicCheckin.getId());
/* 183 */         Double price = Double.valueOf(0.0D);
/* 184 */         Double total = Double.valueOf(0.0D);
/* 185 */         Double payAmount = null;
/* 186 */         Double insurance = null;
/* 187 */         String status1 = OrderStatus.UNPAID.getOrderStatus();
/* 188 */         String serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */         try {
/* 190 */           medicServices = this.serviceRepository.findById(request.getServiceId()).orElse(null);
/* 191 */           if (medicServices != null) {
/* 192 */             if (medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.fee.getCustomerType())) {
/* 193 */               total = payAmount = price = medicServices.getPrice();
/* 194 */               serviceObj = ServiceObjectType.fee.getServiceObjectType();
/*     */             } 
/* 196 */             if (medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.request.getCustomerType())) {
/* 197 */               total = payAmount = price = medicServices.getPrice();
/* 198 */               serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */             } 
/* 200 */             if (medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType())) {
/* 201 */               status1 = OrderStatus.BHYT.getOrderStatus();
/* 202 */               payAmount = insurance = medicServices.getPriceIns();
/* 203 */               price = medicServices.getPrice();
/* 204 */               serviceObj = ServiceObjectType.bhyt.getServiceObjectType();
/* 205 */               total = Double.valueOf(payAmount.doubleValue() - medicServices.getPriceIns().doubleValue());
/*     */             } 
/* 207 */             if (medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType())) {
/* 208 */               status1 = OrderStatus.PAID.getOrderStatus();
/* 209 */               total = payAmount = price = medicServices.getPrice();
/* 210 */               serviceObj = ServiceObjectType.free.getServiceObjectType();
/*     */             } 
/*     */           } else {
/* 213 */             total = payAmount = price = medicServices.getPrice();
/* 214 */             price = medicServices.getPriceService();
/*     */           } 
/* 216 */         } catch (Exception ex) {
/* 217 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 218 */           logger.error(exceptionAsString);
/*     */         } 
/* 220 */         if (total.doubleValue() == 0.0D)
/*     */         {
/* 222 */           this.medicCheckinRecordRepository.updatePayemntStatus(medicCheckinChuyenKhoa.getMdId(), OrderStatus.PAID.getOrderStatus());
/*     */         }
/* 224 */         String barcode = this.medicService.getBarcode(medicCheckin.getId(), new Date());
/* 225 */         MedicTicket medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/* 226 */             .mdId(medicCheckinChuyenKhoa.getMdId())
/* 227 */             .checkinPatientId(medicCheckin.getPatientId())
/* 228 */             .checkinName(medicCheckin.getCustomers().getName())
/* 229 */             .ticketType(TicketType.SERVICE.getTicketType())
/* 230 */             .barCode(barcode)
/* 231 */             .code("CPK")
/* 232 */             .checkinName("CPK")
/* 233 */             .serviceGroupCode(medicServices.getServiceGroupCode())
/* 234 */             .createdId(medicCheckin.getCreatorId())
/* 235 */             .roomId(request.getRoomId())
/* 236 */             .createdAt(new Date())
/* 237 */             .status(status1)
/* 238 */             .orderDate(new Date())
/* 239 */             .build());
/* 240 */         logger.info("// 5. tao phieu yeu cau");
/* 241 */         this.orderServiceRepository.saveAndFlush(MedicOrderServices.builder()
/* 242 */             .ticketId(medicTicket.getId())
/* 243 */             .mdId(medicCheckinChuyenKhoa.getMdId())
/* 244 */             .customerId(Integer.valueOf(medicCheckin.getCustomers().getId()))
/* 245 */             .serviceId(medicServices.getId())
/* 246 */             .serviceCode(medicServices.getCode())
/* 247 */             .serviceName(medicServices.getName())
/* 248 */             .serviceGroupId(medicServices.getServiceGroupId())
/* 249 */             .qty(Integer.valueOf(1))
/* 250 */             .unitId(medicServices.getUnitId())
/* 251 */             .unit(medicServices.getUnit())
/* 252 */             .price(price)
/* 253 */             .totalAmount(total)
/* 254 */             .payAmount(payAmount)
/* 255 */             .currencyCode(this.medicService.getCurrency())
/* 256 */             .payment(status1)
/* 257 */             .creatorId(medicCheckin.getCreatorId())
/* 258 */             .createdAt(new Date())
/* 259 */             .status(status1)
/* 260 */             .serviceObject(serviceObj)
/* 261 */             .insurancePay(insurance)
/* 262 */             .build());
/*     */         
/* 264 */         this.checkinRepository.updatePaymentStatus(medicCheckin.getId(), status1);
/*     */       } 
/* 266 */       request.setCreatedAt(new Date());
/* 267 */       MedicExaminationResults x = (MedicExaminationResults)this.examinationResultRepository.saveAndFlush(request);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 274 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(Integer.valueOf(request.getMdId()));
/* 275 */       if (medicCheckinRecord.isPresent()) {
/* 276 */         this.medicCheckinRecordRepository.updateStatus(((MedicCheckinRecord)medicCheckinRecord.get()).getMdId(), status);
/* 277 */         this.checkinRepository.updateStatus(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId(), checkinStatus);
/*     */       } 
/* 279 */       data.put("id", Integer.valueOf(x.getId()));
/*     */       
/* 281 */       rs.put("status", "OK");
/* 282 */       rs.put("responseCode", "00");
/* 283 */       rs.put("data", data);
/*     */     }
/* 285 */     catch (Exception e) {
/* 286 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 287 */       logger.error(exceptionAsString);
/* 288 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 289 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 291 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/editSolve"})
/*     */   public ApiResponse editSolve(@Valid @RequestBody MedicExaminationResults request) {
/* 303 */     ApiResponse rs = new ApiResponse();
/* 304 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 307 */       Optional<MedicCheckinRecord> medicTicket = this.medicCheckinRecordRepository.findById(Integer.valueOf(request.getMdId()));
/* 308 */       if (!medicTicket.isPresent()) {
/* 309 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 313 */       List<MedicCheckinRecord> listCheck = this.medicCheckinRecordRepository.findAllByCheckinIdAndMdTypeAndStatusIn(((MedicCheckinRecord)medicTicket.get()).getCheckinId(), CheckinType.OUT_PATIENT.getCheckinType(), 
/* 314 */           Arrays.asList(new String[] { CheckinStatus.WAITING.getCheckinStatus(), CheckinStatus.PROCESSING.getCheckinStatus() }));
/*     */       
/* 316 */       for (MedicCheckinRecord medicCheckinRecord : listCheck) {
/* 317 */         if (medicCheckinRecord.getStatus().equalsIgnoreCase(CheckinStatus.PROCESSING.getCheckinStatus())) {
/* 318 */           return this.apiError.getError("209", new String[0]);
/*     */         }
/* 320 */         if (medicCheckinRecord.getStatus().equalsIgnoreCase(CheckinStatus.WAITING.getCheckinStatus())) {
/* 321 */           Optional<List<MedicTicket>> medicTicket1 = this.ticketRepository.findAllByTicketTypeAndMdId(TicketType.SERVICE.getTicketType(), medicCheckinRecord.getMdId());
/* 322 */           if (medicTicket1.isPresent()) {
/* 323 */             for (MedicTicket ticket : medicTicket1.get()) {
/* 324 */               this.orderServiceRepository.deleteAllByTicketId(ticket.getId());
/* 325 */               this.ticketRepository.delete(ticket);
/*     */             } 
/* 327 */             this.medicCheckinRecordRepository.delete(medicCheckinRecord);
/*     */           } 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 333 */       MedicExaminationResults examinations = this.examinationResultRepository.findByMdId(Integer.valueOf(request.getMdId())).orElse(null);
/* 334 */       if (examinations != null) {
/*     */         
/* 336 */         MedicExaminationResultsHis his = (MedicExaminationResultsHis)this.modelMapper.map(examinations, MedicExaminationResultsHis.class);
/* 337 */         this.examinationResultHisRepository.saveAndFlush(his);
/*     */ 
/*     */         
/* 340 */         examinations.setReasonEdit(request.getReasonEdit());
/* 341 */         this.examinationResultRepository.save(examinations);
/*     */       } 
/*     */ 
/*     */       
/* 345 */       this.medicCheckinRecordRepository.updateStatus(Integer.valueOf(request.getMdId()), CheckinStatus.PROCESSING.getCheckinStatus());
/* 346 */       this.checkinRepository.updateStatus(((MedicCheckinRecord)medicTicket.get()).getCheckinId(), CheckinStatus.PROCESSING.getCheckinStatus());
/*     */       
/* 348 */       this.medicCheckinRecordRepository.deleteHospitalize(Integer.valueOf(request.getMdId()));
/* 349 */       rs.put("status", "OK");
/* 350 */       rs.put("responseCode", "00");
/* 351 */       rs.put("data", data);
/*     */     }
/* 353 */     catch (Exception e) {
/* 354 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 355 */       logger.error(exceptionAsString);
/* 356 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 357 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 359 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Examination\ExaminationTabSolveController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */