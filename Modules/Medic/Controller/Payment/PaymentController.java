/*     */ package nencer.app.Modules.Medic.Controller.Payment;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinStatus;
/*     */ import nencer.app.Constant.CheckinType;
/*     */ import nencer.app.Constant.FundStatus;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.OrderType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Fund.FundLogs;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServicesHis;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.FundLogsRequest;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.OrderServiceRequest;
/*     */ import nencer.app.Modules.Medic.Model.Payment.PaymentAmount;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderHis;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class PaymentController extends BaseMedicController {
/*  56 */   public static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   FundLogRepository fundLogRepository;
/*     */   
/*     */   @Autowired
/*     */   OrderServicesHisRepository orderServicesHisRepository;
/*     */   
/*     */   @Autowired
/*     */   StoreHouseService storeHouseService;
/*     */   
/*     */   @Autowired
/*     */   CommonPaymentRepo commonPaymentRepo;
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_payment/payment/{checkinId}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse payment(@PathVariable @Valid Integer checkinId, @Valid @RequestBody FundLogsRequest request) {
/*  82 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  85 */       logger.info("// Bat dau luu phieu thu cho: " + checkinId);
/*  86 */       if (checkinId == null) {
/*  87 */         return this.apiError.getError("804", new String[] { "mdId" });
/*     */       }
/*  89 */       List<OrderServiceRequest> orderServiceRequestList = request.getOrderServiceRequests();
/*  90 */       List<MedicProductOrder> medicProductOrders = request.getOrderProductRequests();
/*  91 */       if (Objects.isNull(orderServiceRequestList) && 
/*  92 */         Objects.isNull(medicProductOrders) && request
/*  93 */         .getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/*  94 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/*  97 */       if (orderServiceRequestList.size() == 0 && medicProductOrders.size() == 0 && request
/*  98 */         .getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/*  99 */         return this.apiError.getError("307");
/*     */       }
/* 101 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(checkinId);
/* 102 */       if (!checkin.isPresent()) {
/* 103 */         return this.apiError.getError("201", new String[] { checkinId.toString() });
/*     */       }
/* 105 */       MedicCheckin medicCheckin = checkin.get();
/* 106 */       if (!medicCheckin.getStatus().equalsIgnoreCase(CheckinStatus.DONE.getCheckinStatus()) && request
/* 107 */         .getOrderProductRequests() != null && 
/* 108 */         request.getOrderProductRequests().size() > 0) {
/* 109 */         for (MedicProductOrder medicProductOrder : medicProductOrders) {
/* 110 */           if (this.commonStoreHouseRepo.spCheckProductPayment(medicProductOrder.getId())) {
/* 111 */             return this.apiError.getError("211", new String[] { checkinId.toString() });
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 117 */       logger.info("// save order service, fundLog: " + checkinId);
/* 118 */       FundLogs fundLogs = (FundLogs)this.fundLogRepository.save(FundLogs.builder()
/* 119 */           .checkinId(checkinId)
/* 120 */           .currencyCode(this.medicService.getCurrency())
/* 121 */           .customerId(medicCheckin.getPatientId())
/* 122 */           .description(request.getDescription())
/* 123 */           .creator(request.getCreatorId())
/* 124 */           .createdAt(new Date())
/* 125 */           .status(OrderStatus.PAID.getOrderStatus())
/* 126 */           .orderType(request.getOrderType())
/* 127 */           .fees(request.getFees())
/* 128 */           .discount(request.getDiscount())
/* 129 */           .payAmount(request.getPayAmount())
/* 130 */           .netAmount(request.getNetAmount())
/* 131 */           .paygate(request.getPaygate())
/* 132 */           .currencyCode(Currency.LAO.name())
/* 133 */           .fundLogChannel(FundLogChannel.CASHIER.toString())
/* 134 */           .build());
/* 135 */       logger.info("// Luu thong tin phieu thu: " + checkinId);
/*     */       
/* 137 */       if (request.getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/*     */         
/* 139 */         List<MedicOrderServices> medicServicesList = new ArrayList<>();
/* 140 */         for (OrderServiceRequest orderServiceRequest : orderServiceRequestList) {
/* 141 */           MedicOrderServices medicServices = this.orderServiceRepository.findByIdAndStatus(orderServiceRequest.getId(), OrderStatus.UNPAID.getOrderStatus()).orElse(null);
/* 142 */           if (!ObjectUtils.isEmpty(medicServices))
/* 143 */             medicServicesList.add(medicServices); 
/*     */         } 
/* 145 */         for (MedicOrderServices medicOrderServices : medicServicesList) {
/*     */           
/* 147 */           MedicServices medicServices = this.serviceRepository.findById(medicOrderServices.getServiceId()).orElse(null);
/* 148 */           if (medicServices == null)
/*     */             continue; 
/* 150 */           logger.info("// save order service, fundLog: " + checkinId);
/*     */           try {
/* 152 */             medicOrderServices.setStatus(OrderStatus.PAID.getOrderStatus());
/* 153 */             medicOrderServices.setPayment(OrderStatus.PAID.getOrderStatus());
/*     */             
/* 155 */             medicOrderServices.setFundLogId(fundLogs.getFundLogId());
/* 156 */             this.orderServiceRepository.saveAndFlush(medicOrderServices);
/*     */ 
/*     */             
/* 159 */             this.ticketRepository.updateStatus(medicOrderServices.getTicketId(), OrderStatus.PAID.getOrderStatus(), Integer.valueOf(1));
/* 160 */           } catch (Exception ex) {
/* 161 */             String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 162 */             logger.error(exceptionAsString);
/*     */           } 
/*     */         } 
/*     */         
/*     */         try {
/* 167 */           logger.info("// Cap nhat trang thai checkin: " + checkinId);
/* 168 */           if (medicCheckin.getPaymentStatus().equalsIgnoreCase(OrderStatus.UNPAID.getOrderStatus())) {
/* 169 */             this.checkinRepository.updatePaymentStatus(medicCheckin.getId(), OrderStatus.PAID.getOrderStatus());
/* 170 */             Optional<List<MedicCheckinRecord>> medicCheckinRecords = this.medicCheckinRecordRepository.findByCheckinIdAndStatusInAndMdTypeOrderByCreatedAtDesc(checkinId, 
/* 171 */                 Arrays.asList(new String[] { CheckinStatus.WAITING.getCheckinStatus(), CheckinStatus.PROCESSING.getCheckinStatus() }, ), CheckinType.OUT_PATIENT.getCheckinType());
/* 172 */             if (medicCheckinRecords.isPresent()) {
/* 173 */               for (MedicCheckinRecord medicCheckinRecord : medicCheckinRecords.get()) {
/* 174 */                 this.medicCheckinRecordRepository.updatePaymentStatus(medicCheckinRecord.getMdId(), OrderStatus.PAID.getOrderStatus());
/*     */               }
/*     */             }
/*     */           } 
/* 178 */           if (request.getOrderProductRequests().size() > 0) {
/* 179 */             Set<Integer> orderIds = new HashSet<>();
/* 180 */             for (MedicProductOrder orderProductRequest : request.getOrderProductRequests()) {
/* 181 */               orderIds.add(orderProductRequest.getId());
/*     */             }
/*     */             
/* 184 */             for (Integer orderId : orderIds) {
/* 185 */               Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(orderId);
/* 186 */               if (!g.isPresent()) {
/* 187 */                 return this.apiError.getError("02");
/*     */               }
/* 189 */               MedicProductOrder medicProductOrder = g.get();
/* 190 */               if (medicProductOrder.getStatus() == null || !medicProductOrder.getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())) {
/* 191 */                 medicProductOrder.setFundLogId(fundLogs.getFundLogId());
/* 192 */                 if (medicProductOrder.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.CD.getProductOrderStatus()))
/* 193 */                   medicProductOrder.setOrderStatus(ProductOrderStatus.DD.getProductOrderStatus()); 
/* 194 */                 medicProductOrder.setUpdatedAt(new Date());
/* 195 */                 medicProductOrder.setStatus(FundStatus.PAID.getFundStatus());
/* 196 */                 this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */               }
/*     */             
/*     */             } 
/*     */           } 
/* 201 */         } catch (Exception ex) {
/* 202 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 203 */           logger.error(exceptionAsString);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 209 */       logger.info("// Ket thuc thanh toan: " + checkinId);
/*     */       
/* 211 */       rs.put("status", "OK");
/* 212 */       rs.put("responseCode", "00");
/* 213 */       rs.put("data", fundLogs);
/*     */     }
/* 215 */     catch (Exception e) {
/* 216 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 217 */       logger.error(exceptionAsString);
/* 218 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 219 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 221 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_payment/payment"})
/*     */   public ApiResponse getPayment(@RequestParam(required = false) Integer checkinId, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 233 */     ApiResponse rs = new ApiResponse();
/* 234 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 236 */       if (checkinId == null) {
/* 237 */         return this.apiError.getError("804", new String[] { "mdId" });
/*     */       }
/*     */       
/* 240 */       Optional<MedicCheckin> medicCheckin = this.checkinRepository.findById(checkinId);
/* 241 */       if (!medicCheckin.isPresent()) {
/* 242 */         return this.apiError.getError("202", new String[] { checkinId + "" });
/*     */       }
/*     */       
/* 245 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 246 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*     */       
/* 248 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 253 */       SearchCriteria searchCriteria1 = SearchCriteria.builder().field("checkinId").operator(QueryOperator.EQUALS).value(checkinId).build();
/* 254 */       searchFilter.add(searchCriteria1);
/* 255 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 257 */       Page<FundLogs> pages = this.fundLogRepository.findAll((Specification)specifications, (Pageable)pageable);
/*     */       
/* 259 */       List<FundLogs> fundLogs = new ArrayList<>();
/* 260 */       pages.get().forEach(e -> {
/*     */             List<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findAllByFundLogId(e.getFundLogId());
/*     */             
/*     */             if (medicOrderServices.size() == 0 && e.getStatus().equalsIgnoreCase(OrderStatus.CANCEL.getOrderStatus())) {
/*     */               List<MedicOrderServicesHis> medicOrderServicesHis = this.orderServicesHisRepository.findAllByFundLogId(e.getFundLogId());
/*     */               medicOrderServices = (List<MedicOrderServices>)this.objectMapper.convertValue(medicOrderServicesHis, new TypeReference<List<MedicOrderServices>>()
/*     */                   {
/*     */                   
/*     */                   });
/*     */             } 
/*     */             e.setMedicOrderServices(medicOrderServices);
/*     */             List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSp(null, e.getFundLogId());
/*     */             if (medicProductOrderModels.size() == 0 && e.getStatus().equalsIgnoreCase(OrderStatus.CANCEL.getOrderStatus())) {
/*     */               List<MedicProductOrderHis> medicProductOrderHis = this.medicProductOrderHisRepository.findAllByFundLogId(e.getFundLogId().intValue());
/*     */               medicProductOrderModels = (List<MedicProductOrderModel>)this.objectMapper.convertValue(medicProductOrderHis, new TypeReference<List<MedicProductOrderModel>>()
/*     */                   {
/*     */                   
/*     */                   });
/*     */             } 
/*     */             for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */               Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*     */               medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */             } 
/*     */             e.setMedicProductOrders(medicProductOrderModels);
/*     */             fundLogs.add(e);
/*     */           });
/* 286 */       data.put("fundlogs", pages.get());
/* 287 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 288 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/* 290 */       rs.put("status", "OK");
/* 291 */       rs.put("responseCode", "00");
/* 292 */       rs.put("data", data);
/*     */     }
/* 294 */     catch (Exception e) {
/* 295 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 296 */       logger.error(exceptionAsString);
/* 297 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 299 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_payment/payment/reimbursement"})
/*     */   public ApiResponse getPaymentReimbursement(@RequestParam(required = false) Integer checkinId) {
/* 307 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 309 */       if (checkinId == null) {
/* 310 */         return this.apiError.getError("804", new String[] { "mdId" });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 316 */       Double tu = this.fundLogRepository.countReimbursement(checkinId, OrderType.TU.getOrderType());
/* 317 */       Double hu = this.fundLogRepository.countReimbursement(checkinId, OrderType.HU.getOrderType());
/* 318 */       double sum = ((tu != null) ? tu.doubleValue() : 0.0D) - ((hu != null) ? hu.doubleValue() : 0.0D);
/*     */       
/* 320 */       rs.put("status", "OK");
/* 321 */       rs.put("responseCode", "00");
/* 322 */       rs.put("data", Double.valueOf((sum <= 0.0D) ? 0.0D : sum));
/*     */     }
/* 324 */     catch (Exception e) {
/*     */       
/* 326 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 327 */       logger.error(exceptionAsString);
/* 328 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 330 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_payment/payment/status"})
/*     */   public ApiResponse changeStatusInvoices(@RequestBody Map fundLogInput) {
/* 339 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 341 */       Integer fundLogId = Integer.valueOf(DataUtil.safeToInt(fundLogInput.get("fundLogId")));
/* 342 */       String status = DataUtil.safeToString(fundLogInput.get("status"));
/* 343 */       String note = DataUtil.safeToString(fundLogInput.get("note"));
/* 344 */       if (fundLogId.equals(Integer.valueOf(0))) {
/* 345 */         return this.apiError.getError("804", new String[] { "fundLogId" });
/*     */       }
/* 347 */       if (StringUtils.isBlank(status)) {
/* 348 */         return this.apiError.getError("804", new String[] { "status" });
/*     */       }
/* 350 */       FundLogs fundLogs = this.fundLogRepository.findById(fundLogId).orElse(null);
/*     */       
/* 352 */       if (fundLogs == null) {
/* 353 */         return this.apiError.getError("202", new String[] { "fundLogs" });
/*     */       }
/*     */       
/* 356 */       List<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findAllByFundLogId(fundLogId);
/* 357 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAllByFundLogId(fundLogs.getFundLogId());
/*     */       
/* 359 */       if (status.equalsIgnoreCase(FundStatus.CANCEL.getFundStatus()) && medicProductOrders.size() > 0 && (
/* 360 */         (MedicProductOrder)medicProductOrders.get(0)).getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus())) {
/* 361 */         return this.apiError.getError("204");
/*     */       }
/*     */       
/* 364 */       if (fundLogs.getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/* 365 */         if (medicOrderServices.size() > 0) {
/* 366 */           List<MedicOrderServicesHis> listHis = (List<MedicOrderServicesHis>)this.objectMapper.convertValue(medicOrderServices, new TypeReference<List<MedicOrderServicesHis>>() {  }
/*     */             );
/* 368 */           for (MedicOrderServicesHis listHi : listHis) {
/* 369 */             listHi.setOrderServiceId(listHi.getId());
/* 370 */             listHi.setId(null);
/*     */           } 
/* 372 */           this.orderServicesHisRepository.saveAll(listHis);
/*     */           
/* 374 */           List<MedicOrderServices> lmo = new ArrayList<>();
/*     */           
/* 376 */           for (MedicOrderServices mos : medicOrderServices) {
/* 377 */             mos.setStatus(OrderStatus.UNPAID.getOrderStatus());
/* 378 */             mos.setPayment(OrderStatus.UNPAID.getOrderStatus());
/* 379 */             lmo.add(mos);
/*     */ 
/*     */             
/* 382 */             MedicTicket mt = this.ticketRepository.findById(mos.getTicketId()).orElse(null);
/* 383 */             if (mt != null) {
/* 384 */               this.ticketRepository.updateStatus(mos.getTicketId(), TicketStatus.UNPAID.getTicketStatus(), Integer.valueOf(0));
/*     */             }
/*     */           } 
/* 387 */           this.orderServiceRepository.saveAll(lmo);
/*     */ 
/*     */           
/* 390 */           if (medicOrderServices.size() == 1) {
/* 391 */             this.checkinRepository.updatePaymentStatus(fundLogs.getCheckinId(), OrderStatus.UNPAID.getOrderStatus());
/* 392 */             Optional<List<MedicCheckinRecord>> medicCheckinRecord = this.medicCheckinRecordRepository.findByCheckinIdAndStatusAndMdTypeOrderByCreatedAtDesc(fundLogs.getCheckinId(), CheckinStatus.WAITING.getCheckinStatus(), CheckinType.OUT_PATIENT
/* 393 */                 .getCheckinType());
/* 394 */             if (medicCheckinRecord.isPresent()) {
/* 395 */               for (MedicCheckinRecord checkinRecord : medicCheckinRecord.get()) {
/* 396 */                 this.medicCheckinRecordRepository.updatePaymentStatus(checkinRecord.getMdId(), OrderStatus.UNPAID.getOrderStatus());
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 403 */         List<MedicProductOrder> productOrders = new ArrayList<>();
/* 404 */         if (medicProductOrders.size() > 0) {
/*     */           
/* 406 */           List<MedicProductOrderHis> listPOHis = (List<MedicProductOrderHis>)this.objectMapper.convertValue(medicProductOrders, new TypeReference<List<MedicProductOrderHis>>() {  }
/*     */             );
/* 408 */           for (MedicProductOrderHis listHi : listPOHis) {
/* 409 */             listHi.setOrderId(listHi.getId());
/* 410 */             listHi.setId(null);
/*     */           } 
/* 412 */           this.medicProductOrderHisRepository.saveAll(listPOHis);
/*     */ 
/*     */           
/* 415 */           for (MedicProductOrder mos : medicProductOrders) {
/* 416 */             mos.setOrderStatus(ProductOrderStatus.CD.getProductOrderStatus());
/* 417 */             mos.setStatus(OrderStatus.UNPAID.getOrderStatus());
/* 418 */             productOrders.add(mos);
/*     */           } 
/* 420 */           this.medicProductOrderRepository.saveAll(productOrders);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 425 */       fundLogs.setStatus(status);
/* 426 */       fundLogs.setNote(note);
/* 427 */       this.fundLogRepository.saveAndFlush(fundLogs);
/*     */ 
/*     */       
/* 430 */       rs.put("status", "OK");
/* 431 */       rs.put("responseCode", "00");
/*     */     }
/* 433 */     catch (Exception e) {
/*     */       
/* 435 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 436 */       logger.error(exceptionAsString);
/* 437 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 438 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 440 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_payment/payment_amount/{checkinId}"})
/*     */   public ApiResponse getPaymentAmount(@PathVariable @Valid Integer checkinId) {
/* 448 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 450 */       if (checkinId == null) {
/* 451 */         return this.apiError.getError("804", new String[] { "checkinId" });
/*     */       }
/* 453 */       PaymentAmount paymentAmount = this.commonPaymentRepo.getMedicPaymentAmount(checkinId);
/*     */       
/* 455 */       rs.put("status", "OK");
/* 456 */       rs.put("responseCode", "00");
/* 457 */       rs.put("dataRes", paymentAmount);
/*     */     }
/* 459 */     catch (Exception e) {
/*     */       
/* 461 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 462 */       logger.error(exceptionAsString);
/* 463 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 465 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Payment\PaymentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */