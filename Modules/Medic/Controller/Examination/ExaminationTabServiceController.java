/*     */ package nencer.app.Modules.Medic.Controller.Examination;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CustomerType;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.ServiceObjectType;
/*     */ import nencer.app.Constant.TicketStatus;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Department.MedicDepartments;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.InvoiceRequest;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicTicketResponse;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.OrderServiceRequest;
/*     */ import nencer.app.Modules.Medic.Model.Ticket.TicketGroupResponse;
/*     */ import nencer.app.Modules.Medic.Repository.Examination.ExaminationResultRepository;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExaminationTabServiceController extends BaseMedicController {
/*  48 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationTabServiceController.class);
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
/*     */   TicketRepository ticketRepository;
/*     */   
/*     */   @Autowired
/*     */   ServiceGroupRepository serviceGroupRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */   
/*     */   @Autowired
/*     */   ExaminationResultRepository examinationResultRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicService medicHelper;
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinTreatmentDetailTicketRepository medicCheckinTreatmentDetailTicketRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getServiceGroup/{mdId}"})
/*     */   public ApiResponse getServiceGroup(@PathVariable @Valid Integer mdId) {
/*  79 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  82 */       if (mdId == null) {
/*  83 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  86 */       Optional<MedicCheckinRecord> medicCheckinRrRecord = this.medicCheckinRecordRepository.findById(mdId);
/*  87 */       if (!medicCheckinRrRecord.isPresent()) {
/*  88 */         return this.apiError.getError("202", new String[] { mdId + "" });
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
/*     */ 
/*     */       
/* 101 */       List<TicketGroupResponse> ticketGroupResponses = this.commonCheckinRepo.getServiceGroupSp(mdId, TicketType.SERVICE.getTicketType());
/* 102 */       rs.put("status", "OK");
/* 103 */       rs.put("responseCode", "00");
/* 104 */       rs.put("data", ticketGroupResponses);
/*     */     }
/* 106 */     catch (Exception e) {
/* 107 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 108 */       logger.error(exceptionAsString);
/* 109 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 111 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getTicketByCheckinId/{mdId}/{serviceGroupCode}"})
/*     */   public ApiResponse getTicketByCheckinId(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer serviceGroupCode) {
/* 120 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 123 */       if (mdId == null) {
/* 124 */         return this.apiError.getError("02");
/*     */       }
/* 126 */       if (ObjectUtils.isEmpty(serviceGroupCode)) {
/* 127 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 131 */       Optional<Integer> medicCheckinRecord = this.medicCheckinRecordRepository.findByMdId(mdId);
/* 132 */       if (!medicCheckinRecord.isPresent()) {
/* 133 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/*     */       
/* 136 */       Integer serviceTicketGroup = this.serviceGroupRepository.findByCode(serviceGroupCode);
/* 137 */       if (serviceTicketGroup.intValue() <= 0) {
/* 138 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/*     */ 
/*     */       
/* 142 */       List<MedicTicketResponse> medicTicketResponses = new ArrayList<>();
/*     */       
/* 144 */       List<MedicTicket> medicTickets = this.commonCheckinRepo.getAllTicketByMdIdSp(TicketType.SERVICE.getTicketType(), serviceGroupCode, mdId);
/* 145 */       if (medicTickets != null)
/*     */       {
/* 147 */         for (MedicTicket m : medicTickets) {
/* 148 */           medicTicketResponses.add(getMap(m));
/*     */         }
/*     */       }
/*     */       
/* 152 */       rs.put("status", "OK");
/* 153 */       rs.put("responseCode", "00");
/* 154 */       rs.put("data", medicTicketResponses);
/*     */     }
/* 156 */     catch (Exception e) {
/* 157 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 158 */       logger.error(exceptionAsString);
/* 159 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 161 */     return rs;
/*     */   }
/*     */   
/*     */   private MedicTicketResponse getMap(MedicTicket m) {
/* 165 */     MedicTicketResponse medicTicketResponse = (MedicTicketResponse)this.modelMapper.map(m, MedicTicketResponse.class);
/* 166 */     medicTicketResponse.setMedicTicket(m);
/* 167 */     this.roomRepository.findById(m.getRoomId()).ifPresent(medicRooms -> {
/*     */           medicTicketResponse.setRoomName(medicRooms.getName());
/*     */           medicTicketResponse.setDepartmentId(Integer.valueOf((medicRooms.getDepartmentId() != null) ? medicRooms.getDepartmentId().intValue() : 0));
/*     */         });
/* 171 */     this.departmentRepository.findById(medicTicketResponse.getDepartmentId()).ifPresent(departments -> medicTicketResponse.setDepartmentName(departments.getName()));
/* 172 */     Optional<List<MedicOrderServices>> s = this.orderServiceRepository.findAllByTicketId(m.getId());
/* 173 */     s.ifPresent(medicTicketResponse::setMedicOrderServices);
/* 174 */     return medicTicketResponse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/addCheckinService/{mdId}/{ticketId}"})
/*     */   public ApiResponse addCheckinService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer ticketId, @Valid @RequestBody InvoiceRequest request) {
/* 183 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 187 */       logger.info("// addCheckinService# Bat dau luu chi dinh dich vu: " + mdId);
/* 188 */       if (mdId == null) {
/* 189 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 192 */       Optional<MedicCheckinRecord> medicCheckinRecordOp = this.medicCheckinRecordRepository.findById(mdId);
/* 193 */       if (!medicCheckinRecordOp.isPresent()) {
/* 194 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 197 */       if (request != null && request.getOrderServiceRequests().size() <= 0) {
/* 198 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 201 */       MedicTicket medicTicket = this.ticketRepository.findById(ticketId).orElse(null);
/* 202 */       if (medicTicket == null) {
/* 203 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 206 */       if (medicTicket.getIsDeleteSample().intValue() == 1) {
/* 207 */         return this.apiError.getError("204");
/*     */       }
/* 209 */       logger.info("// addCheckinService# Tach phieu: " + mdId);
/* 210 */       if (request != null && request.getOrderServiceRequests().size() > 0) {
/* 211 */         logger.info("// addCheckinService# Save tach phieu: " + mdId);
/* 212 */         MedicCheckinRecord checkinRecord = medicCheckinRecordOp.get();
/*     */ 
/*     */ 
/*     */         
/* 216 */         for (OrderServiceRequest entry : request.getOrderServiceRequests()) {
/* 217 */           List<MedicOrderServices> olm = this.orderServiceRepository.findByMdIdAndTicketId(mdId, ticketId).orElse(null);
/* 218 */           if (!olm.isEmpty()) {
/* 219 */             entry.setRoomHandleId(((MedicOrderServices)olm.get(0)).getRoomHandleId());
/* 220 */             entry.setRoomSampleId(((MedicOrderServices)olm.get(0)).getRoomSampleId());
/*     */           } 
/* 222 */           Optional<MedicOrderServices> orderServices = this.orderServiceRepository.findByMdIdAndServiceIdAndTicketId(mdId, entry.getServiceId(), ticketId);
/* 223 */           if (orderServices.isPresent()) {
/*     */             
/* 225 */             this.orderServiceRepository.deleteById(Integer.valueOf(((MedicOrderServices)orderServices.get()).getId()));
/* 226 */             this.orderServiceExtRepository.deleteByOrderService(Integer.valueOf(((MedicOrderServices)orderServices.get()).getId()));
/*     */           } 
/*     */           
/* 229 */           this.medicService.saveOrderTicket(ticketId, checkinRecord, entry);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       logger.info("// addCheckinService# Ket thuc chi dinh dich vu: " + mdId);
/*     */       
/* 241 */       rs.put("status", "OK");
/* 242 */       rs.put("responseCode", "00");
/* 243 */       rs.put("data", "THANH CONG");
/*     */     }
/* 245 */     catch (Exception e) {
/* 246 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 247 */       logger.error(exceptionAsString);
/* 248 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 249 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 251 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_examination/deleteServiceTicket/{ticketId}"})
/*     */   public ApiResponse deleteTicket(@PathVariable @Valid Integer ticketId) {
/* 260 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 263 */       if (ticketId == null) {
/* 264 */         return this.apiError.getError("02");
/*     */       }
/* 266 */       Optional<MedicTicket> medicTicket = this.ticketRepository.findByIdAndTicketType(ticketId, TicketType.SERVICE.getTicketType());
/* 267 */       if (!medicTicket.isPresent()) {
/* 268 */         return this.apiError.getError("02");
/*     */       }
/* 270 */       MedicTicket mt = medicTicket.get();
/*     */ 
/*     */       
/* 273 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mt.getMdId());
/* 274 */       if (!medicCheckinRecord.isPresent()) {
/* 275 */         return this.apiError.getError("02");
/*     */       }
/* 277 */       MedicCheckinRecord mcr = medicCheckinRecord.get();
/* 278 */       if (!mcr.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType()) && 
/* 279 */         !mcr.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType()))
/*     */       {
/* 281 */         if (!mt.getStatus().equalsIgnoreCase(TicketStatus.UNPAID.getTicketStatus()))
/*     */         {
/* 283 */           return this.apiError.getError("204");
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 288 */       if (mt.getIsDeleteSample().intValue() == 1) {
/* 289 */         return this.apiError.getError("204");
/*     */       }
/*     */       
/* 292 */       boolean isDelete = false;
/* 293 */       List<MedicOrderServices> mss = null;
/* 294 */       Optional<List<MedicOrderServices>> medicOrderServices = this.orderServiceRepository.findAllByTicketId(ticketId);
/* 295 */       if (medicOrderServices.isPresent()) {
/*     */         
/* 297 */         mss = medicOrderServices.get();
/*     */ 
/*     */ 
/*     */         
/* 301 */         isDelete = true;
/*     */       } 
/*     */ 
/*     */       
/* 305 */       this.ticketRepository.deleteById(ticketId);
/* 306 */       if (isDelete && !mss.isEmpty()) {
/* 307 */         this.orderServiceRepository.deleteAll(mss);
/*     */         
/* 309 */         for (MedicOrderServices mos : mss) {
/* 310 */           this.orderServiceExtRepository.deleteByOrderService(Integer.valueOf(mos.getId()));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 315 */       this.medicCheckinTreatmentDetailTicketRepository.deleteByTicketId(ticketId);
/*     */       
/* 317 */       rs.put("status", "OK");
/* 318 */       rs.put("responseCode", "00");
/* 319 */       rs.put("data", "THANH CONG");
/*     */     }
/* 321 */     catch (Exception e) {
/* 322 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 323 */       logger.error(exceptionAsString);
/* 324 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 325 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 327 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_examination/deleteOrderService/{mdId}/{serviceId}/{ticketId}"})
/*     */   public ApiResponse deleteOrderService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer serviceId, @PathVariable @Valid Integer ticketId) {
/* 336 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 339 */       if (mdId == null) {
/* 340 */         return this.apiError.getError("02");
/*     */       }
/* 342 */       if (ticketId == null) {
/* 343 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 346 */       if (serviceId == null) {
/* 347 */         return this.apiError.getError("02");
/*     */       }
/* 349 */       Optional<MedicCheckinRecord> medicCheckinRecordOp = this.medicCheckinRecordRepository.findById(mdId);
/* 350 */       if (!medicCheckinRecordOp.isPresent()) {
/* 351 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 354 */       Optional<MedicServices> medicService = this.serviceRepository.findById(serviceId);
/* 355 */       if (!medicService.isPresent()) {
/* 356 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 359 */       MedicTicket medicTicket = this.ticketRepository.findById(ticketId).orElse(null);
/* 360 */       if (medicTicket == null) {
/* 361 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 364 */       if (medicTicket.getIsDeleteSample().intValue() == 1) {
/* 365 */         return this.apiError.getError("204");
/*     */       }
/*     */ 
/*     */       
/* 369 */       MedicOrderServices orderServices = this.orderServiceRepository.findByMdIdAndServiceIdAndTicketId(mdId, serviceId, ticketId).orElse(null);
/* 370 */       if (orderServices == null) {
/* 371 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 378 */       this.orderServiceRepository.deleteById(Integer.valueOf(orderServices.getId()));
/* 379 */       this.orderServiceExtRepository.deleteByOrderService(Integer.valueOf(orderServices.getId()));
/*     */       
/* 381 */       rs.put("status", "OK");
/* 382 */       rs.put("responseCode", "00");
/* 383 */       rs.put("data", "THANH CONG");
/*     */     }
/* 385 */     catch (Exception e) {
/* 386 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 387 */       logger.error(exceptionAsString);
/* 388 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 389 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 391 */     return rs;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/regisCheckinService/{mdId}"})
/*     */   public ApiResponse regisCheckinService(@PathVariable @Valid Integer mdId, @Valid @RequestBody InvoiceRequest request) {
/* 446 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 449 */       logger.info("// Bat dau luu chi dinh dich vu: " + mdId);
/* 450 */       if (mdId == null) {
/* 451 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 454 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/* 455 */       if (!medicCheckinRecord.isPresent()) {
/* 456 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 459 */       if (request != null && request.getOrderServiceRequests().size() <= 0) {
/* 460 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 463 */       logger.info("// Tach phieu: " + mdId);
/*     */ 
/*     */       
/* 466 */       if (request != null && request.getOrderServiceRequests().size() > 0) {
/* 467 */         HashMap<String, List<OrderServiceRequest>> groupAll = new HashMap<>();
/* 468 */         HashMap<String, List<OrderServiceRequest>> groupService = new HashMap<>();
/* 469 */         HashMap<String, List<OrderServiceRequest>> groupRoomHandler = new HashMap<>();
/* 470 */         HashMap<String, List<OrderServiceRequest>> groupRoomSample = new HashMap<>();
/*     */         
/* 472 */         for (OrderServiceRequest oreq : request.getOrderServiceRequests()) {
/*     */           
/* 474 */           if (oreq.getRoomSampleId() != null && oreq.getRoomHandleId() != null) {
/* 475 */             String str = oreq.getServiceGroupCode() + "|" + oreq.getRoomSampleId() + "|" + oreq.getRoomHandleId();
/* 476 */             if (!groupAll.containsKey(str)) {
/* 477 */               List<OrderServiceRequest> list = new ArrayList<>();
/* 478 */               list.add(oreq);
/* 479 */               groupAll.put(str, list); continue;
/*     */             } 
/* 481 */             ((List<OrderServiceRequest>)groupAll.get(str)).add(oreq); continue;
/*     */           } 
/* 483 */           if (oreq.getRoomSampleId() != null && (oreq.getRoomHandleId() == null || oreq.getRoomHandleId().intValue() <= 0)) {
/* 484 */             String str = oreq.getServiceGroupCode() + "|" + oreq.getRoomSampleId();
/* 485 */             if (!groupRoomSample.containsKey(str)) {
/* 486 */               List<OrderServiceRequest> list = new ArrayList<>();
/* 487 */               list.add(oreq);
/* 488 */               groupRoomSample.put(str, list); continue;
/*     */             } 
/* 490 */             ((List<OrderServiceRequest>)groupRoomSample.get(str)).add(oreq); continue;
/*     */           } 
/* 492 */           if (oreq.getRoomHandleId() != null && (oreq.getRoomSampleId() == null || oreq.getRoomSampleId().intValue() <= 0)) {
/* 493 */             String str = oreq.getServiceGroupCode() + "|" + oreq.getRoomHandleId();
/* 494 */             if (!groupRoomHandler.containsKey(str)) {
/* 495 */               List<OrderServiceRequest> list = new ArrayList<>();
/* 496 */               list.add(oreq);
/* 497 */               groupRoomHandler.put(str, list); continue;
/*     */             } 
/* 499 */             ((List<OrderServiceRequest>)groupRoomHandler.get(str)).add(oreq);
/*     */             continue;
/*     */           } 
/* 502 */           String key = oreq.getServiceGroupCode() + "";
/* 503 */           if (!groupService.containsKey(key)) {
/* 504 */             List<OrderServiceRequest> list = new ArrayList<>();
/* 505 */             list.add(oreq);
/* 506 */             groupService.put(key, list); continue;
/*     */           } 
/* 508 */           ((List<OrderServiceRequest>)groupService.get(key)).add(oreq);
/*     */         } 
/*     */ 
/*     */         
/* 512 */         logger.info("// Save tach phieu: " + mdId);
/* 513 */         MedicCheckinRecord checkinRecord = medicCheckinRecord.get();
/*     */ 
/*     */ 
/*     */         
/* 517 */         for (Map.Entry<String, List<OrderServiceRequest>> entry : groupAll.entrySet()) {
/*     */           
/* 519 */           String[] key = ((String)entry.getKey()).split("\\|");
/* 520 */           Integer roomHandles = null;
/* 521 */           Integer roomSamples = null;
/*     */           
/* 523 */           String barcode = this.medicHelper.getBarcode(mdId, request.getOrderDate());
/* 524 */           MedicTicket medicTicket = this.medicHelper.saveTicket(checkinRecord, request, Integer.valueOf(Integer.parseInt(key[0])), barcode);
/* 525 */           String status = OrderStatus.UNPAID.getOrderStatus();
/*     */           
/* 527 */           for (OrderServiceRequest ord : entry.getValue()) {
/* 528 */             if (ord.getRoomHandleId() != null && ord.getRoomHandleId().intValue() >= 0) {
/* 529 */               roomHandles = ord.getRoomHandleId();
/*     */             }
/* 531 */             if (ord.getRoomSampleId() != null && ord.getRoomSampleId().intValue() >= 0) {
/* 532 */               roomSamples = ord.getRoomSampleId();
/*     */             }
/* 534 */             this.medicHelper.saveOrderTicket(medicTicket.getId(), checkinRecord, ord);
/*     */           } 
/*     */           
/* 537 */           updateObjectStatus(medicTicket, checkinRecord.getMedicCheckin(), status);
/*     */           
/* 539 */           this.ticketRepository.updateRoomHandlerSampleIds(roomHandles, roomSamples, medicTicket
/*     */ 
/*     */               
/* 542 */               .getId(), "", "");
/*     */         } 
/*     */         
/* 545 */         for (Map.Entry<String, List<OrderServiceRequest>> entry : groupRoomSample.entrySet()) {
/*     */           
/* 547 */           String[] key = ((String)entry.getKey()).split("\\|");
/* 548 */           Integer roomSamples = null;
/*     */           
/* 550 */           String barcode = this.medicHelper.getBarcode(mdId, request.getOrderDate());
/* 551 */           MedicTicket medicTicket = this.medicHelper.saveTicket(checkinRecord, request, Integer.valueOf(Integer.parseInt(key[0])), barcode);
/* 552 */           String status = OrderStatus.UNPAID.getOrderStatus();
/*     */           
/* 554 */           for (OrderServiceRequest ord : entry.getValue()) {
/* 555 */             if (ord.getRoomSampleId() != null && ord.getRoomSampleId().intValue() >= 0) {
/* 556 */               roomSamples = ord.getRoomSampleId();
/*     */             }
/* 558 */             if (ord.getRoomHandleId() != null && ord.getRoomHandleId().intValue() >= 0) {
/* 559 */               roomSamples = ord.getRoomHandleId();
/*     */             }
/* 561 */             ord.setRoomSampleId(roomSamples);
/* 562 */             ord.setRoomHandleId(roomSamples);
/* 563 */             this.medicHelper.saveOrderTicket(medicTicket.getId(), checkinRecord, ord);
/*     */           } 
/*     */           
/* 566 */           updateObjectStatus(medicTicket, checkinRecord.getMedicCheckin(), status);
/*     */           
/* 568 */           ObjectMapper objectMapper = new ObjectMapper();
/* 569 */           this.ticketRepository.updateRoomHandlerSampleIds(roomSamples, roomSamples, medicTicket.getId(), "", "");
/*     */         } 
/*     */ 
/*     */         
/* 573 */         for (Map.Entry<String, List<OrderServiceRequest>> entry : groupRoomHandler.entrySet()) {
/* 574 */           String[] key = ((String)entry.getKey()).split("\\|");
/* 575 */           Integer roomHandles = null;
/*     */           
/* 577 */           String barcode = this.medicHelper.getBarcode(mdId, request.getOrderDate());
/* 578 */           MedicTicket medicTicket = this.medicHelper.saveTicket(checkinRecord, request, Integer.valueOf(Integer.parseInt(key[0])), barcode);
/* 579 */           String status = OrderStatus.UNPAID.getOrderStatus();
/*     */           
/* 581 */           for (OrderServiceRequest ord : entry.getValue()) {
/* 582 */             if (ord.getRoomSampleId() != null && ord.getRoomSampleId().intValue() >= 0) {
/* 583 */               roomHandles = ord.getRoomSampleId();
/*     */             }
/* 585 */             if (ord.getRoomHandleId() != null && ord.getRoomHandleId().intValue() >= 0) {
/* 586 */               roomHandles = ord.getRoomHandleId();
/*     */             }
/* 588 */             ord.setRoomSampleId(roomHandles);
/* 589 */             ord.setRoomHandleId(roomHandles);
/* 590 */             this.medicHelper.saveOrderTicket(medicTicket.getId(), checkinRecord, ord);
/*     */           } 
/*     */           
/* 593 */           updateObjectStatus(medicTicket, checkinRecord.getMedicCheckin(), status);
/*     */           
/* 595 */           this.ticketRepository.updateRoomHandlerSampleIds(roomHandles, roomHandles, medicTicket.getId(), "", "");
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 600 */         for (Map.Entry<String, List<OrderServiceRequest>> entry : groupService.entrySet()) {
/* 601 */           String[] key = ((String)entry.getKey()).split("\\|");
/* 602 */           Integer roomHandles = null;
/*     */           
/* 604 */           String barcode = this.medicHelper.getBarcode(mdId, request.getOrderDate());
/* 605 */           MedicTicket medicTicket = this.medicHelper.saveTicket(checkinRecord, request, Integer.valueOf(Integer.parseInt(key[0])), barcode);
/* 606 */           String status = OrderStatus.UNPAID.getOrderStatus();
/*     */           
/* 608 */           for (OrderServiceRequest ord : entry.getValue()) {
/* 609 */             if (ord.getRoomHandleId() != null && ord.getRoomHandleId().intValue() >= 0) {
/* 610 */               roomHandles = ord.getRoomHandleId();
/*     */             }
/* 612 */             if (ord.getRoomSampleId() != null && ord.getRoomSampleId().intValue() >= 0) {
/* 613 */               roomHandles = ord.getRoomSampleId();
/*     */             }
/* 615 */             ord.setRoomSampleId(roomHandles);
/* 616 */             ord.setRoomHandleId(roomHandles);
/* 617 */             this.medicHelper.saveOrderTicket(medicTicket.getId(), checkinRecord, ord);
/*     */           } 
/* 619 */           updateObjectStatus(medicTicket, checkinRecord.getMedicCheckin(), status);
/*     */ 
/*     */           
/* 622 */           this.ticketRepository.updateRoomHandlerSampleIds(roomHandles, roomHandles, medicTicket.getId(), "", "");
/*     */         } 
/*     */       } 
/*     */       
/* 626 */       logger.info("// Ket thuc chi dinh dich vu: " + mdId);
/*     */       
/* 628 */       rs.put("status", "OK");
/* 629 */       rs.put("responseCode", "00");
/* 630 */       rs.put("data", "THANH CONG");
/*     */     }
/* 632 */     catch (Exception e) {
/* 633 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 634 */       logger.error(exceptionAsString);
/* 635 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 636 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 638 */     return rs;
/*     */   }

package controllers

import (
	"strconv"
	"strings"

	"github.com/gofiber/fiber/v2"
)

// --- Models (expand as needed) ---

type InvoiceRequest struct {
	OrderServiceRequests []OrderServiceRequest `json:"orderServiceRequests"`
	OrderDate            string                `json:"orderDate"`
}

type OrderServiceRequest struct {
	ServiceGroupCode int  `json:"serviceGroupCode"`
	RoomSampleId     *int `json:"roomSampleId"`
	RoomHandleId     *int `json:"roomHandleId"`
	// ... other fields as needed
}

type MedicCheckinRecord struct{}
type MedicTicket struct{ ID int }

// --- Helper/service stubs (replace with real logic) ---

func getBarcode(mdId int, orderDate string) string { return "BARCODE" }
func saveTicket(checkinRecord MedicCheckinRecord, request InvoiceRequest, groupCode int, barcode string) MedicTicket {
	return MedicTicket{ID: 1}
}
func saveOrderTicket(ticketId int, checkinRecord MedicCheckinRecord, ord OrderServiceRequest) {}
func updateObjectStatus(medicTicket MedicTicket, checkin interface{}, status string)          {}
func updateRoomHandlerSampleIds(roomHandles, roomSamples *int, ticketId int, a, b string)    {}
const OrderStatusUnpaid = "UNPAID"

// --- Main controller logic ---

func RegisterExaminationRoutes(app *fiber.App) {
	group := app.Group("/medic_examination")
	group.Post("/regisCheckinService/:mdId", regisCheckinService)
}

func regisCheckinService(c *fiber.Ctx) error {
	mdIdStr := c.Params("mdId")
	mdId, err := strconv.Atoi(mdIdStr)
	if err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{"error": "Invalid mdId"})
	}

	var request InvoiceRequest
	if err := c.BodyParser(&request); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{"error": err.Error()})
	}

	if len(request.OrderServiceRequests) == 0 {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{"error": "No orderServiceRequests provided"})
	}

	// --- Grouping logic ---
	groupAll := make(map[string][]OrderServiceRequest)
	groupService := make(map[string][]OrderServiceRequest)
	groupRoomHandler := make(map[string][]OrderServiceRequest)
	groupRoomSample := make(map[string][]OrderServiceRequest)

	for _, oreq := range request.OrderServiceRequests {
		if oreq.RoomSampleId != nil && oreq.RoomHandleId != nil {
			key := strings.Join([]string{strconv.Itoa(oreq.ServiceGroupCode), strconv.Itoa(*oreq.RoomSampleId), strconv.Itoa(*oreq.RoomHandleId)}, "|")
			groupAll[key] = append(groupAll[key], oreq)
		} else if oreq.RoomSampleId != nil && (oreq.RoomHandleId == nil || *oreq.RoomHandleId <= 0) {
			key := strings.Join([]string{strconv.Itoa(oreq.ServiceGroupCode), strconv.Itoa(*oreq.RoomSampleId)}, "|")
			groupRoomSample[key] = append(groupRoomSample[key], oreq)
		} else if oreq.RoomHandleId != nil && (oreq.RoomSampleId == nil || *oreq.RoomSampleId <= 0) {
			key := strings.Join([]string{strconv.Itoa(oreq.ServiceGroupCode), strconv.Itoa(*oreq.RoomHandleId)}, "|")
			groupRoomHandler[key] = append(groupRoomHandler[key], oreq)
		} else {
			key := strconv.Itoa(oreq.ServiceGroupCode)
			groupService[key] = append(groupService[key], oreq)
		}
	}

	// --- Simulate fetching checkin record (replace with real DB call) ---
	checkinRecord := MedicCheckinRecord{}

	// --- Ticket/order processing logic (mirrors Java) ---

	// groupAll
	for key, orders := range groupAll {
		parts := strings.Split(key, "|")
		groupCode, _ := strconv.Atoi(parts[0])
		var roomHandles, roomSamples *int

		barcode := getBarcode(mdId, request.OrderDate)
		medicTicket := saveTicket(checkinRecord, request, groupCode, barcode)
		status := OrderStatusUnpaid

		for _, ord := range orders {
			if ord.RoomHandleId != nil && *ord.RoomHandleId >= 0 {
				roomHandles = ord.RoomHandleId
			}
			if ord.RoomSampleId != nil && *ord.RoomSampleId >= 0 {
				roomSamples = ord.RoomSampleId
			}
			saveOrderTicket(medicTicket.ID, checkinRecord, ord)
		}
		updateObjectStatus(medicTicket, nil, status)
		updateRoomHandlerSampleIds(roomHandles, roomSamples, medicTicket.ID, "", "")
	}

	// groupRoomSample
	for key, orders := range groupRoomSample {
		parts := strings.Split(key, "|")
		groupCode, _ := strconv.Atoi(parts[0])
		var roomSamples *int

		barcode := getBarcode(mdId, request.OrderDate)
		medicTicket := saveTicket(checkinRecord, request, groupCode, barcode)
		status := OrderStatusUnpaid

		for _, ord := range orders {
			if ord.RoomSampleId != nil && *ord.RoomSampleId >= 0 {
				roomSamples = ord.RoomSampleId
			}
			if ord.RoomHandleId != nil && *ord.RoomHandleId >= 0 {
				roomSamples = ord.RoomHandleId
			}
			ord.RoomSampleId = roomSamples
			ord.RoomHandleId = roomSamples
			saveOrderTicket(medicTicket.ID, checkinRecord, ord)
		}
		updateObjectStatus(medicTicket, nil, status)
		updateRoomHandlerSampleIds(roomSamples, roomSamples, medicTicket.ID, "", "")
	}

	// groupRoomHandler
	for key, orders := range groupRoomHandler {
		parts := strings.Split(key, "|")
		groupCode, _ := strconv.Atoi(parts[0])
		var roomHandles *int

		barcode := getBarcode(mdId, request.OrderDate)
		medicTicket := saveTicket(checkinRecord, request, groupCode, barcode)
		status := OrderStatusUnpaid

		for _, ord := range orders {
			if ord.RoomSampleId != nil && *ord.RoomSampleId >= 0 {
				roomHandles = ord.RoomSampleId
			}
			if ord.RoomHandleId != nil && *ord.RoomHandleId >= 0 {
				roomHandles = ord.RoomHandleId
			}
			ord.RoomSampleId = roomHandles
			ord.RoomHandleId = roomHandles
			saveOrderTicket(medicTicket.ID, checkinRecord, ord)
		}
		updateObjectStatus(medicTicket, nil, status)
		updateRoomHandlerSampleIds(roomHandles, roomHandles, medicTicket.ID, "", "")
	}

	// groupService
	for key, orders := range groupService {
		parts := strings.Split(key, "|")
		groupCode, _ := strconv.Atoi(parts[0])
		var roomHandles *int

		barcode := getBarcode(mdId, request.OrderDate)
		medicTicket := saveTicket(checkinRecord, request, groupCode, barcode)
		status := OrderStatusUnpaid

		for _, ord := range orders {
			if ord.RoomHandleId != nil && *ord.RoomHandleId >= 0 {
				roomHandles = ord.RoomHandleId
			}
			if ord.RoomSampleId != nil && *ord.RoomSampleId >= 0 {
				roomHandles = ord.RoomSampleId
			}
			ord.RoomSampleId = roomHandles
			ord.RoomHandleId = roomHandles
			saveOrderTicket(medicTicket.ID, checkinRecord, ord)
		}
		updateObjectStatus(medicTicket, nil, status)
		updateRoomHandlerSampleIds(roomHandles, roomHandles, medicTicket.ID, "", "")
	}

	// --- Response ---
	return c.Status(fiber.StatusOK).JSON(fiber.Map{
		"status":       "OK",
		"responseCode": "00",
		"data":         "THANH CONG",
	})
}
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateObjectStatus(MedicTicket medicTicket, MedicCheckin checkin, String status) {
/* 644 */     if (checkin != null) {
/* 645 */       if (checkin.getCustomerType().equalsIgnoreCase(ServiceObjectType.bhyt.getServiceObjectType()) || checkin
/* 646 */         .getCustomerType().equalsIgnoreCase(ServiceObjectType.free.getServiceObjectType())) {
/* 647 */         status = OrderStatus.PAID.getOrderStatus();
/*     */       }
/*     */       
/* 650 */       this.ticketRepository.updateStatus(medicTicket.getId(), status);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Examination\ExaminationTabServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */