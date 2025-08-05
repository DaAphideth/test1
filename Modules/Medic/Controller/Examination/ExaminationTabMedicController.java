/*     */ package nencer.app.Modules.Medic.Controller.Examination;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CustomerType;
/*     */ import nencer.app.Constant.FundStatus;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.MedicProductStorehouseType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetail;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetailTicket;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicTicketResponse;
/*     */ import nencer.app.Modules.Medic.Model.Product.MedicRequest;
/*     */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinTreatmentDetailTicketRepository;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.IncorrectExportInvenException;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExaminationTabMedicController extends BaseMedicController {
/*  49 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationTabMedicController.class);
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
/*     */   @Autowired
/*     */   TicketRepository ticketRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ServiceGroupRepository serviceGroupRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicProductRepository medicProductRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductOrderRepository medicProductOrderRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductOrderDetailRepository medicProductOrderDetailRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinTreatmentDetailRepository medicCheckinTreatmentDetailRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinTreatmentDetailTicketRepository medicCheckinTreatmentDetailTicketRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getAllStore"})
/*     */   public ApiResponse getAllStore(@RequestParam(required = false) String storehouseTypeCodes, @RequestParam(required = false) Integer userId, @RequestParam(required = false) Integer roomId) {
/*  93 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  98 */       List<MedicProductStorehouse> medicProductStorehouses = this.commonStoreHouseRepo.spGetProductStorehouse(storehouseTypeCodes, userId, roomId);
/*     */       
/* 100 */       rs.put("status", "OK");
/* 101 */       rs.put("responseCode", "00");
/* 102 */       rs.put("data", medicProductStorehouses);
/*     */     }
/* 104 */     catch (Exception e) {
/* 105 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 106 */       logger.error(exceptionAsString);
/* 107 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 109 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/regisCheckinMedic/{mdId}"})
/*     */   public ApiResponse regisCheckinMedic(@PathVariable @Valid Integer mdId, @Valid @RequestBody MedicRequest request) {
/* 118 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*     */       MedicProductOrder medicProductOrder;
/*     */       Integer benefitRate;
/* 122 */       logger.info("// Bat dau luu chi dinh dich vu: " + mdId);
/* 123 */       if (mdId == null) {
/* 124 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 127 */       if (request == null) {
/* 128 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 131 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 132 */       if (!medicCheckinRecord.isPresent()) {
/* 133 */         return this.apiError.getError("02");
/*     */       }
/* 135 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 136 */       if (!checkin.isPresent()) {
/* 137 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() });
/*     */       }
/* 139 */       MedicCheckin medicCheckin = checkin.get();
/* 140 */       if (((MedicCheckinRecord)medicCheckinRecord.get()).getStatus().equalsIgnoreCase(CheckinStatus.DONE.getCheckinStatus())) {
/* 141 */         return this.apiError.getError("620");
/*     */       }
/*     */       
/* 144 */       if (request.getProductOrders() == null) {
/* 145 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 148 */       if (request.getProductOrders().size() <= 0) {
/* 149 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 152 */       logger.info("// Tao phieu: " + mdId);
/* 153 */       String code = UUID.randomUUID().toString();
/* 154 */       String barcode = this.medicService.getBarcode(mdId, new Date());
/* 155 */       MedicCheckinRecord mc = medicCheckinRecord.get();
/* 156 */       MedicTicket medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/* 157 */           .mdId(mdId)
/* 158 */           .checkinName(mc.getMedicCheckin().getCustomers().getName())
/* 159 */           .checkinPatientId(mc.getMedicCheckin().getPatientId())
/* 160 */           .roomId(mc.getRoomId())
/* 161 */           .code(code)
/* 162 */           .barCode(barcode)
/* 163 */           .ticketType(TicketType.MEDIC.getTicketType())
/* 164 */           .status(ProductOrderStatus.CD.getProductOrderStatus())
/* 165 */           .createdAt(new Date())
/* 166 */           .orderDate((request.getOrderDate() == null) ? new Date() : request.getOrderDate())
/* 167 */           .createdBy(request.getCreatorName())
/* 168 */           .createdId(request.getCreatorId())
/* 169 */           .diagnosticArray(request.getDiagnosticArray())
/* 170 */           .diagnosticSubArray(request.getDiagnosticSubArray())
/* 171 */           .roomId(mc.getRoomId())
/* 172 */           .medicProductArray(request.getMedicProductArray())
/* 173 */           .serviceGroupCode(Integer.valueOf(6))
/* 174 */           .build());
/*     */       
/* 176 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(request.getStoreId()).orElse(null);
/* 177 */       if (medicProductStorehouse == null) {
/* 178 */         return this.apiError.getError("202", new String[] { "Kho" });
/*     */       }
/* 180 */       MedicProductStorehouseType typeMail = MedicProductStorehouseType.valueOf(medicProductStorehouse.getShType());
/*     */ 
/*     */       
/* 183 */       switch (typeMail) {
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
/*     */         case kho_ban_le:
/*     */         case kho_ngoai_tru:
/*     */         case kho_noi_tru:
/*     */         case kho_tong_hop:
/* 201 */           medicProductOrder = MedicProductOrder.builder().storehouseId(request.getStoreId()).roomId(request.getRoomId()).creatorId(request.getCreatorId()).ticketId(medicTicket.getId()).groupOrderType(MedicProductOrderType.XK.getMedicProductOrderType()).customerId(mc.getMedicCheckin().getPatientId()).createdAt(new Date()).orderDate(new Date()).orderType(MedicProductOrderType.XK_KL.getMedicProductOrderType()).orderStatus(ProductOrderStatus.CD.getProductOrderStatus()).departmentId(mc.getDepartmentId()).build();
/* 202 */           medicProductOrder.setMedicProductOrderDetails(request.getProductOrders());
/*     */ 
/*     */           
/* 205 */           benefitRate = getBenefitRateProduct(medicCheckin.getId(), medicCheckin.getCustomerType(), medicProductStorehouse.getShType());
/*     */           
/* 207 */           if (benefitRate.equals(Integer.valueOf(100))) {
/* 208 */             medicProductOrder.setStatus(FundStatus.PAID.getFundStatus());
/*     */           }
/*     */           
/* 211 */           for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 212 */             medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/* 213 */             medicProductOrderDetail.setBenefitRate(benefitRate);
/* 214 */             medicProductOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/*     */           } 
/*     */ 
/*     */           
/* 218 */           this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */           
/* 220 */           this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */           break;
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
/*     */         case kho_tu_truc:
/* 236 */           medicProductOrder = MedicProductOrder.builder().storehouseId(request.getStoreId()).roomId(request.getRoomId()).creatorId(request.getCreatorId()).ticketId(medicTicket.getId()).groupOrderType(MedicProductOrderType.XK.getMedicProductOrderType()).customerId(mc.getMedicCheckin().getPatientId()).createdAt(new Date()).orderDate(new Date()).orderType(MedicProductOrderType.XK_KL.getMedicProductOrderType()).orderStatus(ProductOrderStatus.DXK.getProductOrderStatus()).exportDate(new Date()).departmentId(mc.getDepartmentId()).build();
/* 237 */           medicProductOrder.setMedicProductOrderDetails(request.getProductOrders());
/*     */ 
/*     */ 
/*     */           
/* 241 */           benefitRate = getBenefitRateProduct(medicCheckin.getId(), medicCheckin.getCustomerType(), medicProductStorehouse.getShType());
/*     */           
/* 243 */           if (benefitRate.equals(Integer.valueOf(100))) {
/* 244 */             medicProductOrder.setStatus(FundStatus.PAID.getFundStatus());
/*     */           }
/*     */           
/* 247 */           for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 248 */             medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/* 249 */             medicProductOrderDetail.setBenefitRate(benefitRate);
/* 250 */             medicProductOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/*     */           } 
/*     */ 
/*     */           
/* 254 */           this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */           
/* 257 */           this.storeHouseService.changeStoreHouseInven2(medicProductOrder, false);
/*     */           break;
/*     */         default:
/* 260 */           return this.apiError.getError("213", new String[] { "Loại kho" });
/*     */       } 
/*     */ 
/*     */       
/* 264 */       if (request.getTreatmentDeatailId() == null) {
/* 265 */         MedicCheckinTreatmentDetail medicCheckinTreatmentDetail = (MedicCheckinTreatmentDetail)this.medicCheckinTreatmentDetailRepository.saveAndFlush(MedicCheckinTreatmentDetail.builder()
/* 266 */             .createdDate(new Date())
/* 267 */             .mdId(mdId)
/* 268 */             .createdBy(request.getCreatorName())
/* 269 */             .createdId(request.getCreatorId())
/* 270 */             .build());
/* 271 */         this.medicCheckinTreatmentDetailTicketRepository.saveAndFlush(MedicCheckinTreatmentDetailTicket.builder()
/* 272 */             .ticketId(medicTicket.getId())
/* 273 */             .serviceGroupId(Integer.valueOf(6))
/* 274 */             .ticketType(TicketType.MEDIC.getTicketType())
/* 275 */             .treatmentId(medicCheckinTreatmentDetail.getId())
/* 276 */             .build());
/*     */       } else {
/*     */         
/* 279 */         this.medicCheckinTreatmentDetailTicketRepository.saveAndFlush(MedicCheckinTreatmentDetailTicket.builder()
/* 280 */             .ticketId(medicTicket.getId())
/* 281 */             .serviceGroupId(Integer.valueOf(6))
/* 282 */             .ticketType(TicketType.MEDIC.getTicketType())
/* 283 */             .treatmentId(request.getTreatmentDeatailId().intValue())
/* 284 */             .build());
/*     */       } 
/*     */       
/* 287 */       logger.info("// Ket thuc Ke don thuoc: " + mdId);
/*     */       
/* 289 */       rs.put("status", "OK");
/* 290 */       rs.put("responseCode", "00");
/* 291 */       rs.put("data", "THANH CONG");
/* 292 */     } catch (IncorrectExportInvenException e) {
/* 293 */       logger.error(e.getMessage());
/* 294 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 295 */       return this.apiError.getError("999", new String[] { e.getMessage() });
/* 296 */     } catch (Exception e) {
/* 297 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 298 */       logger.error(exceptionAsString);
/* 299 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 300 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 302 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getMedicTicketByCheckinId/{mdId}"})
/*     */   public ApiResponse getMedicTicketByCheckinId(@PathVariable @Valid Integer mdId) {
/* 310 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 313 */       if (mdId == null) {
/* 314 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 318 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 319 */       if (!medicCheckinRecord.isPresent()) {
/* 320 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/* 322 */       List<MedicCheckinRecord> medicCheckinRecords = this.medicCheckinRecordRepository.findAllByCheckinId(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/*     */ 
/*     */       
/* 325 */       List<MedicTicketResponse> medicTicketResponses = new ArrayList<>();
/* 326 */       for (MedicCheckinRecord checkinRecord : medicCheckinRecords) {
/* 327 */         List<MedicTicket> medicTickets = this.ticketRepository.findAllByTicketTypeAndMdId(TicketType.MEDIC.getTicketType(), checkinRecord.getMdId()).orElse(null);
/* 328 */         if (medicTickets != null)
/*     */         {
/* 330 */           for (MedicTicket m : medicTickets) {
/* 331 */             medicTicketResponses.add(getMap(m));
/*     */           }
/*     */         }
/*     */       } 
/*     */       
/* 336 */       rs.put("status", "OK");
/* 337 */       rs.put("responseCode", "00");
/* 338 */       rs.put("data", medicTicketResponses);
/*     */     }
/* 340 */     catch (Exception e) {
/* 341 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 342 */       logger.error(exceptionAsString);
/* 343 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 345 */     return rs;
/*     */   }
/*     */   
/*     */   private MedicTicketResponse getMap(MedicTicket m) {
/* 349 */     MedicTicketResponse medicTicketResponse = (MedicTicketResponse)this.modelMapper.map(m, MedicTicketResponse.class);
/* 350 */     this.roomRepository.findById(m.getRoomId()).ifPresent(medicRoomNumbers -> medicTicketResponse.setRoomName(medicRoomNumbers.getName()));
/*     */     
/* 352 */     return medicTicketResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_examination/addProductDetailOrder/{mdId}/{orderId}"})
/*     */   public ApiResponse addCheckinService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer orderId, @Valid @RequestBody MedicRequest request) {
/* 358 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 362 */       logger.info("// Bat dau luu chi dinh dich vu: " + mdId);
/* 363 */       if (mdId == null) {
/* 364 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 367 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 368 */       if (!medicCheckinRecord.isPresent()) {
/* 369 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 372 */       if (request == null || request.getProductOrders().size() <= 0) {
/* 373 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 376 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 377 */       if (!checkin.isPresent()) {
/* 378 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() });
/*     */       }
/* 380 */       MedicCheckin medicCheckin = checkin.get();
/*     */       
/* 382 */       logger.info("// Tao phieu: " + mdId);
/*     */ 
/*     */ 
/*     */       
/* 386 */       Optional<MedicProductOrder> medicProductOrderOp = this.medicProductOrderRepository.findById(orderId);
/* 387 */       if (!medicProductOrderOp.isPresent())
/* 388 */         return this.apiError.getError("307"); 
/* 389 */       MedicProductOrder medicProductOrderOld = medicProductOrderOp.get();
/*     */ 
/*     */       
/* 392 */       if (request.getStoreId() == null || !request.getStoreId().equals(medicProductOrderOld.getStorehouseId())) {
/* 393 */         return this.apiError.getError("618");
/*     */       }
/*     */       
/* 396 */       if (!medicProductOrderOld.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus()) || (
/* 397 */         StringUtils.isNotBlank(((MedicProductOrder)medicProductOrderOp.get()).getStatus()) && 
/* 398 */         !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType()) && 
/* 399 */         !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType()) && ((MedicProductOrder)medicProductOrderOp
/* 400 */         .get()).getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())))
/*     */       {
/* 402 */         return this.apiError.getError("210");
/*     */       }
/* 404 */       Set<MedicProductOrderDetail> medicProductOrderDetails = new HashSet<>();
/*     */ 
/*     */       
/* 407 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrderOld);
/*     */ 
/*     */       
/* 410 */       Integer benefitRate = getBenefitRateProduct(medicProductOrderOld.getId(), medicCheckin.getCustomerType());
/*     */       
/* 412 */       for (MedicProductOrderDetail productOrderDetail : request.getProductOrders()) {
/* 413 */         productOrderDetail.setOrderId(medicProductOrderOld.getId());
/*     */         
/* 415 */         MedicProductOrderDetail medicProductOrderDetail = this.medicProductOrderDetailRepository.findByInvenIdAndOrderId(productOrderDetail.getInvenId(), ((MedicProductOrder)medicProductOrderOp.get()).getId()).orElse(null);
/* 416 */         if (medicProductOrderDetail != null) {
/* 417 */           productOrderDetail.setQty(Integer.valueOf(productOrderDetail.getQty().intValue() + medicProductOrderDetail.getQty().intValue()));
/* 418 */           productOrderDetail.setApprovalQty(Integer.valueOf(productOrderDetail.getQty().intValue() + medicProductOrderDetail.getApprovalQty().intValue()));
/* 419 */           productOrderDetail.setId(medicProductOrderDetail.getId());
/*     */         } else {
/* 421 */           productOrderDetail.setApprovalQty(productOrderDetail.getQty());
/*     */         } 
/* 423 */         productOrderDetail.setBenefitRate(benefitRate);
/* 424 */         productOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/* 425 */         medicProductOrderDetails.add(productOrderDetail);
/*     */       } 
/*     */       
/* 428 */       List<MedicProductOrderDetail> medicProductOrderDetailsNew = this.medicProductOrderDetailRepository.saveAll(medicProductOrderDetails);
/* 429 */       medicProductOrderDetails = new HashSet<>(medicProductOrderDetailsNew);
/* 430 */       this.storeHouseService.addStoreHouseInvenLook(medicProductOrderDetails, medicProductOrderOld);
/*     */       
/* 432 */       logger.info("// Ket thuc Ke don thuoc: " + mdId);
/*     */       
/* 434 */       rs.put("status", "OK");
/* 435 */       rs.put("responseCode", "00");
/* 436 */       rs.put("data", "THANH CONG");
/* 437 */     } catch (IncorrectExportInvenException e) {
/* 438 */       logger.error(e.getMessage());
/* 439 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 440 */       return this.apiError.getError("999", new String[] { e.getMessage() });
/* 441 */     } catch (Exception e) {
/* 442 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 443 */       logger.error(exceptionAsString);
/* 444 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 445 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 447 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_examination/deleteMedicTicket/{ticketId}"})
/*     */   public ApiResponse deleteTicket(@PathVariable @Valid Integer ticketId) {
/* 456 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 459 */       if (ticketId == null) {
/* 460 */         return this.apiError.getError("02");
/*     */       }
/* 462 */       Optional<MedicTicket> medicTicket = this.ticketRepository.findByIdAndTicketType(ticketId, TicketType.MEDIC.getTicketType());
/* 463 */       if (!medicTicket.isPresent()) {
/* 464 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 468 */       Optional<MedicProductOrder> c = this.medicProductOrderRepository.findByTicketId(ticketId);
/*     */ 
/*     */       
/* 471 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(((MedicTicket)medicTicket.get()).getMdId());
/* 472 */       if (!medicCheckinRecord.isPresent()) return this.apiError.getError("02"); 
/* 473 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 474 */       if (!checkin.isPresent())
/* 475 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() }); 
/* 476 */       MedicCheckin medicCheckin = checkin.get();
/*     */       
/* 478 */       if (c.isPresent()) {
/* 479 */         if (!((MedicProductOrder)c.get()).getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus()) || (
/* 480 */           !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType()) && 
/* 481 */           !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType()) && 
/* 482 */           StringUtils.isNotBlank(((MedicProductOrder)c.get()).getStatus()) && ((MedicProductOrder)c.get()).getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())))
/*     */         {
/* 484 */           return this.apiError.getError("204");
/*     */         }
/* 486 */         this.storeHouseService.recoveryStoreHouseInvenLook(c.get());
/*     */       } 
/* 488 */       this.ticketRepository.deleteById(ticketId);
/* 489 */       this.medicProductOrderRepository.deleteByTicketId(ticketId);
/*     */ 
/*     */       
/* 492 */       this.medicCheckinTreatmentDetailTicketRepository.deleteByTicketId(ticketId);
/*     */       
/* 494 */       rs.put("status", "OK");
/* 495 */       rs.put("responseCode", "00");
/* 496 */       rs.put("data", "THANH CONG");
/* 497 */     } catch (IncorrectExportInvenException e) {
/* 498 */       logger.error(e.getMessage());
/* 499 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 500 */       return this.apiError.getError("702", new String[] { e.getMessage() });
/* 501 */     } catch (Exception e) {
/* 502 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 503 */       logger.error(exceptionAsString);
/* 504 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 505 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 507 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_examination/deleteProductDetailOrder/{mdId}/{productId}/{ticketId}"})
/*     */   public ApiResponse deleteOrderService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer productId, @PathVariable @Valid Integer ticketId) {
/* 518 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 521 */       if (mdId == null) {
/* 522 */         return this.apiError.getError("02");
/*     */       }
/* 524 */       if (productId == null) {
/* 525 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 528 */       if (ticketId == null) {
/* 529 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 533 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 534 */       if (!medicCheckinRecord.isPresent()) {
/* 535 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 538 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 539 */       if (!checkin.isPresent())
/* 540 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() }); 
/* 541 */       MedicCheckin medicCheckin = checkin.get();
/*     */       
/* 543 */       Optional<MedicTicket> medicTicket = this.ticketRepository.findById(ticketId);
/* 544 */       if (!medicTicket.isPresent()) {
/* 545 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 549 */       Optional<MedicProductOrder> medicProductOrder = this.medicProductOrderRepository.findByTicketId(ticketId);
/* 550 */       if (!medicProductOrder.isPresent()) {
/* 551 */         return this.apiError.getError("02");
/*     */       }
/* 553 */       MedicProductOrder mpo = medicProductOrder.get();
/* 554 */       if (!mpo.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus()) || (
/* 555 */         !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType()) && 
/* 556 */         !medicCheckin.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType()) && 
/* 557 */         StringUtils.isNotBlank(mpo.getStatus()) && mpo.getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())))
/*     */       {
/* 559 */         return this.apiError.getError("204");
/*     */       }
/*     */ 
/*     */       
/* 563 */       Optional<MedicProductOrderDetail> medicProductOrderDetail = this.medicProductOrderDetailRepository.findByProductIdAndOrderId(productId, mpo.getId());
/* 564 */       if (!medicProductOrderDetail.isPresent()) {
/* 565 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 568 */       if (mpo.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus())) {
/* 569 */         this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrderDetail.get());
/*     */       }
/*     */       
/* 572 */       this.medicProductOrderDetailRepository.deleteById(((MedicProductOrderDetail)medicProductOrderDetail.get()).getId());
/*     */       
/* 574 */       rs.put("status", "OK");
/* 575 */       rs.put("responseCode", "00");
/* 576 */       rs.put("data", "THANH CONG");
/* 577 */     } catch (IncorrectExportInvenException e) {
/* 578 */       logger.error(e.getMessage());
/* 579 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 580 */       return this.apiError.getError("702", new String[] { e.getMessage() });
/* 581 */     } catch (Exception e) {
/* 582 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 583 */       logger.error(exceptionAsString);
/* 584 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 585 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 587 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/editProductDetailOrder/{mdId}/{orderId}"})
/*     */   public ApiResponse editProductDetailOrder(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer orderId, @Valid @RequestBody MedicRequest request) {
/* 597 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 601 */       logger.info("// Bat dau luu chi dinh dich vu: " + mdId);
/* 602 */       if (mdId == null) {
/* 603 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 606 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 607 */       if (!medicCheckinRecord.isPresent()) {
/* 608 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 611 */       if (request == null || request.getProductOrders().size() <= 0) {
/* 612 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 615 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 616 */       if (!checkin.isPresent()) {
/* 617 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() });
/*     */       }
/* 619 */       MedicCheckin medicCheckin = checkin.get();
/*     */       
/* 621 */       logger.info("// Tao phieu: " + mdId);
/*     */ 
/*     */ 
/*     */       
/* 625 */       Optional<MedicProductOrder> medicProductOrderOp = this.medicProductOrderRepository.findById(orderId);
/* 626 */       if (!medicProductOrderOp.isPresent())
/* 627 */         return this.apiError.getError("307"); 
/* 628 */       MedicProductOrder medicProductOrderOld = medicProductOrderOp.get();
/*     */ 
/*     */       
/* 631 */       if (request.getStoreId() == null || !request.getStoreId().equals(medicProductOrderOld.getStorehouseId())) {
/* 632 */         return this.apiError.getError("618");
/*     */       }
/*     */       
/* 635 */       if (!medicProductOrderOld.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus()) || (
/* 636 */         StringUtils.isNotBlank(((MedicProductOrder)medicProductOrderOp.get()).getStatus()) && ((MedicProductOrder)medicProductOrderOp.get()).getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())))
/*     */       {
/* 638 */         return this.apiError.getError("210");
/*     */       }
/* 640 */       Set<MedicProductOrderDetail> medicProductOrderDetails = new HashSet<>();
/*     */ 
/*     */       
/* 643 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrderOld);
/*     */ 
/*     */       
/* 646 */       Integer benefitRate = getBenefitRateProduct(medicProductOrderOld.getId(), medicCheckin.getCustomerType());
/*     */       
/* 648 */       for (MedicProductOrderDetail productOrderDetail : request.getProductOrders()) {
/* 649 */         productOrderDetail.setOrderId(medicProductOrderOld.getId());
/* 650 */         productOrderDetail.setApprovalQty(productOrderDetail.getQty());
/* 651 */         productOrderDetail.setBenefitRate(benefitRate);
/* 652 */         productOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/* 653 */         medicProductOrderDetails.add(productOrderDetail);
/*     */       } 
/*     */       
/* 656 */       List<MedicProductOrderDetail> medicProductOrderDetailsNew = this.medicProductOrderDetailRepository.saveAll(medicProductOrderDetails);
/* 657 */       medicProductOrderDetails = new HashSet<>(medicProductOrderDetailsNew);
/* 658 */       this.storeHouseService.addStoreHouseInvenLook(medicProductOrderDetails, medicProductOrderOld);
/*     */       
/* 660 */       logger.info("// Ket thuc Ke don thuoc: " + mdId);
/*     */       
/* 662 */       rs.put("status", "OK");
/* 663 */       rs.put("responseCode", "00");
/* 664 */       rs.put("data", "THANH CONG");
/* 665 */     } catch (IncorrectExportInvenException e) {
/* 666 */       logger.error(e.getMessage());
/* 667 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 668 */       return this.apiError.getError("999", new String[] { e.getMessage() });
/* 669 */     } catch (Exception e) {
/* 670 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 671 */       logger.error(exceptionAsString);
/* 672 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 673 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 675 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Examination\ExaminationTabMedicController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */