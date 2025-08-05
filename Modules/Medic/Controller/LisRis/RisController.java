/*     */ package nencer.app.Modules.Medic.Controller.LisRis;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.RisStatus;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisDetailResponse;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisModel;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisOrderResponse;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.RisModel;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomRepository;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class RisController
/*     */   extends BaseMedicController
/*     */ {
/*  51 */   public static final Logger logger = LoggerFactory.getLogger(RisController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomRepository roomRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomNumberRepository roomNumberRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_ris/getCheckinRisSample1"})
/*     */   public ApiResponse getCheckinLisSample(@Valid @RequestParam Integer userId, @Valid @RequestParam Integer roomId, @RequestParam(required = false) Integer patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String customerType, @RequestParam(required = false) String barcode, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  82 */     ApiResponse rs = new ApiResponse();
/*  83 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  86 */       List<LisRisModel> list = this.medicService.getSearchRis(page, size, userId, patientId, name, customerType, roomId, barcode, fromDate, toDate, 
/*  87 */           Integer.valueOf(3));
/*     */       
/*  89 */       data.put("ris", list);
/*  90 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((LisRisModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  92 */       rs.put("status", "OK");
/*  93 */       rs.put("responseCode", "00");
/*  94 */       rs.put("data", data);
/*     */       
/*  96 */       return rs;
/*  97 */     } catch (Exception e) {
/*  98 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  99 */       logger.error(exceptionAsString);
/* 100 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_ris/getCheckinRisOrderService/{mdId}/{ticketId}"})
/*     */   public ApiResponse getCheckinRisOrderService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer ticketId) {
/* 109 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 112 */       if (mdId == null) {
/* 113 */         return this.apiError.getError("02");
/*     */       }
/* 115 */       if (ticketId == null) {
/* 116 */         return this.apiError.getError("02");
/*     */       }
/* 118 */       Optional<MedicTicket> mt = this.ticketRepository.findById(ticketId);
/* 119 */       if (!mt.isPresent()) return this.apiError.getError("02");
/*     */       
/* 121 */       LisRisDetailResponse lrs = new LisRisDetailResponse();
/* 122 */       MedicTicket mtt = mt.get();
/*     */       
/* 124 */       MedicRooms mr = this.roomRepository.findById(mtt.getRoomId()).orElse(null);
/* 125 */       mtt.setMedicRoom(mr);
/* 126 */       lrs.setMedicTicket(mtt);
/*     */       
/* 128 */       List<LisRisOrderResponse> lros = new ArrayList<>();
/* 129 */       Optional<List<MedicOrderServices>> medicOrderServices = this.orderServiceRepository.findByMdIdAndTicketId(mdId, ticketId);
/* 130 */       if (medicOrderServices.isPresent()) {
/*     */         
/* 132 */         for (MedicOrderServices mos : medicOrderServices.get()) {
/* 133 */           LisRisOrderResponse lr = (LisRisOrderResponse)this.modelMapper.map(mos, LisRisOrderResponse.class);
/* 134 */           lr.setMedicOrderServicesExtList(this.orderServiceExtRepository.findAllByOrderServiceId(Integer.valueOf(mos.getId())));
/* 135 */           lros.add(lr);
/*     */         } 
/* 137 */         lrs.setOrderServices(lros);
/*     */       } 
/* 139 */       medicOrderServices.ifPresent(orderServices -> lrs.setOrderServices((List)orderServices.stream().map(()).collect(Collectors.toList())));
/*     */ 
/*     */ 
/*     */       
/* 143 */       rs.put("status", "OK");
/* 144 */       rs.put("responseCode", "00");
/* 145 */       rs.put("data", lrs);
/*     */     }
/* 147 */     catch (Exception e) {
/* 148 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 149 */       logger.error(exceptionAsString);
/* 150 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 152 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_ris/getRisOrderService/{mdId}/{ticketId}"})
/*     */   public ApiResponse getRisOrderService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer ticketId) {
/* 160 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 163 */       if (mdId == null) {
/* 164 */         return this.apiError.getError("02");
/*     */       }
/* 166 */       if (ticketId == null) {
/* 167 */         return this.apiError.getError("02");
/*     */       }
/* 169 */       Optional<MedicTicket> mt = this.ticketRepository.findById(ticketId);
/* 170 */       if (!mt.isPresent()) return this.apiError.getError("02");
/*     */       
/* 172 */       List<RisModel> lrs = this.medicService.sp_get_ris_order_service(mdId.intValue(), ticketId.intValue());
/* 173 */       rs.put("status", "OK");
/* 174 */       rs.put("responseCode", "00");
/* 175 */       rs.put("data", lrs);
/*     */     }
/* 177 */     catch (Exception e) {
/* 178 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 179 */       logger.error(exceptionAsString);
/* 180 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 182 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_ris/saveHandleCheckinRis/{ticketId}"})
/*     */   public ApiResponse saveCheckinRis(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 191 */     ApiResponse rs = new ApiResponse();
/* 192 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 195 */       if (ticketId == null) {
/* 196 */         return this.apiError.getError("02");
/*     */       }
/* 198 */       if (request == null) {
/* 199 */         return this.apiError.getError("602");
/*     */       }
/* 201 */       if (request.getOrderServiceId() == null) {
/* 202 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 206 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 207 */       if (!omt.isPresent()) {
/* 208 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 211 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       Optional<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findByIdAndTicketId(request.getOrderServiceId(), ticketId);
/* 221 */       if (!medicOrderServices.isPresent()) {
/* 222 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 225 */       mt.setRoomHandleBy(request.getRoomHandleBy());
/* 226 */       mt.setRoomHandleDate(new Date());
/* 227 */       mt.setIsDeleteSample(Integer.valueOf(1));
/* 228 */       mt.setIsDeleteHandle(Integer.valueOf(1));
/* 229 */       mt.setRoomHandleStatus(RisStatus.PROCESSING.getRisStatus());
/* 230 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */       
/* 233 */       this.orderServiceRepository.updateStatusRisResult(request
/* 234 */           .getOrderServiceId(), RisStatus.PROCESSING
/* 235 */           .getRisStatus());
/*     */ 
/*     */       
/* 238 */       rs.put("status", "OK");
/* 239 */       rs.put("responseCode", "00");
/* 240 */       rs.put("data", data);
/*     */     }
/* 242 */     catch (Exception e) {
/* 243 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 244 */       logger.error(exceptionAsString);
/* 245 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 246 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 248 */     return rs;
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
/*     */   @PutMapping({"/medic_ris/cancelHandleCheckinRis/{ticketId}"})
/*     */   public ApiResponse cancelHandleCheckinRis(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 261 */     ApiResponse rs = new ApiResponse();
/* 262 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 265 */       if (ticketId == null) {
/* 266 */         return this.apiError.getError("02");
/*     */       }
/* 268 */       if (request == null) {
/* 269 */         return this.apiError.getError("602");
/*     */       }
/* 271 */       if (request.getOrderServiceId() == null) {
/* 272 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 276 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 277 */       if (!omt.isPresent()) {
/* 278 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 281 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 290 */       Optional<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findByIdAndTicketId(request.getOrderServiceId(), ticketId);
/* 291 */       if (!medicOrderServices.isPresent()) {
/* 292 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 295 */       mt.setRoomHandleBy(request.getRisResultBy());
/* 296 */       mt.setRoomHandleDate(new Date());
/* 297 */       mt.setIsDeleteSample(Integer.valueOf(0));
/* 298 */       mt.setIsDeleteHandle(Integer.valueOf(0));
/* 299 */       mt.setRoomHandleStatus(RisStatus.PENDING.getRisStatus());
/* 300 */       mt.setRoomSampleStatus(RisStatus.PENDING.getRisStatus());
/* 301 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */       
/* 304 */       this.orderServiceRepository.updateStatusRisResult(request
/* 305 */           .getOrderServiceId(), RisStatus.PENDING
/* 306 */           .getRisStatus());
/*     */ 
/*     */       
/* 309 */       rs.put("status", "OK");
/* 310 */       rs.put("responseCode", "00");
/* 311 */       rs.put("data", data);
/*     */     }
/* 313 */     catch (Exception e) {
/* 314 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 315 */       logger.error(exceptionAsString);
/* 316 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 317 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 319 */     return rs;
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
/*     */   @PutMapping({"/medic_ris/putCheckinRis/{ticketId}"})
/*     */   public ApiResponse putCheckinRis(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 332 */     ApiResponse rs = new ApiResponse();
/* 333 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 336 */       if (ticketId == null) {
/* 337 */         return this.apiError.getError("02");
/*     */       }
/* 339 */       if (request == null) {
/* 340 */         return this.apiError.getError("602");
/*     */       }
/* 342 */       if (request.getOrderServiceId() == null) {
/* 343 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 347 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 348 */       if (!omt.isPresent()) {
/* 349 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 352 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 361 */       Optional<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findByIdAndTicketId(request.getOrderServiceId(), ticketId);
/* 362 */       if (!medicOrderServices.isPresent()) {
/* 363 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 366 */       mt.setRoomSampleStatus(RisStatus.DONE.getRisStatus());
/* 367 */       mt.setRoomSampleBy(request.getRisResultBy());
/* 368 */       mt.setRoomSampleDate(new Date());
/* 369 */       mt.setRoomHandleStatus(RisStatus.DONE.getRisStatus());
/* 370 */       this.ticketRepository.saveAndFlush(mt);
/*     */       
/* 372 */       this.orderServiceRepository.updateRisResult(request
/* 373 */           .getOrderServiceId(), request
/* 374 */           .getRisResult(), request
/* 375 */           .getRisDevice(), request
/* 376 */           .getRisResultBy(), request
/* 377 */           .getRisFinish(), request
/* 378 */           .getMachine(), RisStatus.DONE
/* 379 */           .getRisStatus(), new Date());
/*     */ 
/*     */ 
/*     */       
/* 383 */       rs.put("status", "OK");
/* 384 */       rs.put("responseCode", "00");
/* 385 */       rs.put("data", data);
/*     */     }
/* 387 */     catch (Exception e) {
/* 388 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 389 */       logger.error(exceptionAsString);
/* 390 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 391 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 393 */     return rs;
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
/*     */   @PutMapping({"/medic_ris/cancelCheckinRis/{ticketId}"})
/*     */   public ApiResponse cancelCheckinLisSample(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 406 */     ApiResponse rs = new ApiResponse();
/* 407 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 410 */       if (ticketId == null) {
/* 411 */         return this.apiError.getError("02");
/*     */       }
/* 413 */       if (request == null) {
/* 414 */         return this.apiError.getError("602");
/*     */       }
/* 416 */       if (request.getOrderServiceId() == null) {
/* 417 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 421 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 422 */       if (!omt.isPresent()) {
/* 423 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 426 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 435 */       Optional<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findByIdAndTicketId(request.getOrderServiceId(), ticketId);
/* 436 */       if (!medicOrderServices.isPresent()) {
/* 437 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 441 */       mt.setRoomSampleStatus(RisStatus.PROCESSING.getRisStatus());
/* 442 */       mt.setRoomSampleBy(request.getRoomHandleBy());
/* 443 */       mt.setRoomSampleDate(new Date());
/* 444 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */       
/* 447 */       this.orderServiceRepository.updateStatusRisResult(request
/* 448 */           .getOrderServiceId(), RisStatus.PROCESSING
/* 449 */           .getRisStatus());
/*     */       
/* 451 */       rs.put("status", "OK");
/* 452 */       rs.put("responseCode", "00");
/* 453 */       rs.put("data", data);
/*     */     }
/* 455 */     catch (Exception e) {
/* 456 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 457 */       logger.error(exceptionAsString);
/* 458 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 459 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 461 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @GetMapping({"/medic_ris/choose_execution_machine/{roomId}"})
/*     */   public ApiResponse chooseExecutionMachine(@Valid @PathVariable Integer roomId) {
/* 473 */     ApiResponse rs = new ApiResponse();
/* 474 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 476 */       List<MedicMasterData> medicMasterData = new ArrayList<>();
/* 477 */       MedicRooms medicRooms = this.roomRepository.findById(roomId).orElse(null);
/* 478 */       if (Objects.nonNull(medicRooms) && Strings.isNotEmpty(medicRooms.getRisDevice())) {
/* 479 */         String[] risDevice = medicRooms.getRisDevice().split(",");
/* 480 */         for (String x : risDevice) {
/* 481 */           MedicMasterData masterData = this.medicMasterDataRepository.findByMedicTypeAndMedicCode("executionMachine", x).orElse(null);
/* 482 */           medicMasterData.add(Objects.nonNull(masterData) ? masterData : null);
/*     */         } 
/*     */       } else {
/* 485 */         medicMasterData = this.medicMasterDataRepository.findAllByMedicType("executionMachine");
/*     */       } 
/*     */       
/* 488 */       rs.put("status", "OK");
/* 489 */       rs.put("responseCode", "00");
/* 490 */       rs.put("data", medicMasterData);
/*     */     }
/* 492 */     catch (Exception e) {
/* 493 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 494 */       logger.error(exceptionAsString);
/* 495 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 496 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 498 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\LisRis\RisController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */