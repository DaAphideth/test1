/*     */ package nencer.app.Modules.Medic.Controller.LisRis;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.TicketStatus;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicOrderServicesExt;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisDetailResponse;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisModel;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisOrderResponse;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomRepository;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class LisHandleController extends BaseMedicController {
/*  42 */   public static final Logger logger = LoggerFactory.getLogger(LisHandleController.class);
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
/*     */   
/*     */   @GetMapping({"/medic_lis/getCheckinLisHandle2"})
/*     */   public ApiResponse getCheckinLisHandle(@Valid @RequestParam Integer userId, @Valid @RequestParam Integer roomId, @RequestParam(required = false) Integer patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String customerType, @RequestParam(required = false) String barcode, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  74 */     ApiResponse rs = new ApiResponse();
/*  75 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  78 */       List<LisRisModel> list = this.medicService.getSearchHandle(page, size, userId, patientId, name, customerType, roomId, barcode, fromDate, toDate, 
/*  79 */           Integer.valueOf(2));
/*     */       
/*  81 */       data.put("lis", list);
/*  82 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((LisRisModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  84 */       rs.put("status", "OK");
/*  85 */       rs.put("responseCode", "00");
/*  86 */       rs.put("data", data);
/*     */       
/*  88 */       return rs;
/*  89 */     } catch (Exception e) {
/*  90 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  91 */       logger.error(exceptionAsString);
/*  92 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/putCheckinLisHandle/{ticketId}"})
/*     */   public ApiResponse putCheckinLisHandle(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 105 */     ApiResponse rs = new ApiResponse();
/* 106 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 109 */       if (ticketId == null) {
/* 110 */         return this.apiError.getError("02");
/*     */       }
/* 112 */       if (request == null) {
/* 113 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/* 116 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 117 */       if (!omt.isPresent()) {
/* 118 */         return this.apiError.getError("02");
/*     */       }
/* 120 */       MedicTicket mt = omt.get();
/* 121 */       MedicCheckinRecord medicCheckinRecord = this.medicCheckinRecordRepository.findById(mt.getMdId()).orElse(null);
/* 122 */       if (medicCheckinRecord == null) {
/* 123 */         return this.apiError.getError("202", new String[] { String.valueOf(mt.getMdId()) });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       if (!mt.getRoomSampleStatus().equalsIgnoreCase(TicketStatus.DONE.getTicketStatus())) {
/* 133 */         return this.apiError.getError("603");
/*     */       }
/* 135 */       if (StringUtils.isNotBlank(mt.getRoomHandleStatus()) && 
/* 136 */         !mt.getRoomHandleStatus().equalsIgnoreCase(TicketStatus.PENDING.getTicketStatus())) {
/* 137 */         return this.apiError.getError("603");
/*     */       }
/*     */ 
/*     */       
/* 141 */       String status = TicketStatus.PROCESSING.getTicketStatus();
/* 142 */       mt.setRoomHandleStatus(status);
/* 143 */       mt.setIsDeleteHandle(Integer.valueOf(1));
/* 144 */       mt.setRoomHandleBy(request.getRoomHandleBy());
/* 145 */       mt.setRoomHandleDate(new Date());
/* 146 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */ 
/*     */       
/* 150 */       for (LisRisOrderResponse lror : request.getOrderServices()) {
/*     */         
/* 152 */         this.orderServiceRepository.updateLisResult(Integer.valueOf(lror.getId()), lror.getLisHandlerResult(), lror.getLisDeviceResult());
/*     */ 
/*     */         
/* 155 */         for (MedicOrderServicesExt mosx : lror.getMedicOrderServicesExtList()) {
/* 156 */           this.orderServiceExtRepository.updateResult(Integer.valueOf(mosx.getId()), mosx.getHandlerResult(), mosx.getDeviceResult());
/*     */         }
/*     */       } 
/*     */       
/* 160 */       rs.put("status", "OK");
/* 161 */       rs.put("responseCode", "00");
/* 162 */       rs.put("data", data);
/*     */     }
/* 164 */     catch (Exception e) {
/* 165 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 166 */       logger.error(exceptionAsString);
/* 167 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 168 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 170 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/cancelCheckinLisHandle/{ticketId}"})
/*     */   public ApiResponse cancelCheckinLisHandle(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 182 */     ApiResponse rs = new ApiResponse();
/* 183 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 186 */       if (ticketId == null) {
/* 187 */         return this.apiError.getError("02");
/*     */       }
/* 189 */       if (request == null) {
/* 190 */         return this.apiError.getError("602");
/*     */       }
/* 192 */       if (StringUtils.isEmpty(request.getRoomHandleResultBy())) {
/* 193 */         return this.apiError.getError("804", new String[] { "roomHandleResultBy" });
/*     */       }
/*     */       
/* 196 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 197 */       if (!omt.isPresent()) {
/* 198 */         return this.apiError.getError("02");
/*     */       }
/* 200 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       if (StringUtils.isEmpty(mt.getRoomHandleStatus())) {
/* 210 */         return this.apiError.getError("605");
/*     */       }
/*     */ 
/*     */       
/* 214 */       this.ticketRepository.updateRoomHandleStatus(mt.getId(), TicketStatus.PENDING.getTicketStatus(), request.getRoomHandleResultBy(), new Date(), Integer.valueOf(0));
/* 215 */       Optional<List<MedicOrderServices>> mos = this.orderServiceRepository.findAllByTicketId(mt.getId());
/* 216 */       if (mos.isPresent())
/*     */       {
/* 218 */         for (MedicOrderServices m : mos.get()) {
/* 219 */           this.orderServiceRepository.updateLisResult(Integer.valueOf(m.getId()), "", "");
/*     */           
/* 221 */           List<MedicOrderServicesExt> mosext = this.orderServiceExtRepository.findAllByOrderServiceId(Integer.valueOf(m.getId()));
/* 222 */           if (mosext != null && mosext.size() > 0)
/*     */           {
/*     */             
/* 225 */             for (MedicOrderServicesExt mosx : mosext) {
/* 226 */               this.orderServiceExtRepository.updateResult(Integer.valueOf(mosx.getId()), "", "");
/*     */             }
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 232 */       rs.put("status", "OK");
/* 233 */       rs.put("responseCode", "00");
/* 234 */       rs.put("data", data);
/*     */     }
/* 236 */     catch (Exception e) {
/* 237 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 238 */       logger.error(exceptionAsString);
/* 239 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 240 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 242 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/resultCheckinLisHandle/{ticketId}"})
/*     */   public ApiResponse resultCheckinLisHandle(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 254 */     ApiResponse rs = new ApiResponse();
/* 255 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 258 */       if (ticketId == null) {
/* 259 */         return this.apiError.getError("02");
/*     */       }
/* 261 */       if (request == null) {
/* 262 */         return this.apiError.getError("602");
/*     */       }
/* 264 */       if (StringUtils.isEmpty(request.getRoomHandleResultBy())) {
/* 265 */         return this.apiError.getError("804", new String[] { "roomHandleResultBy" });
/*     */       }
/*     */       
/* 268 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 269 */       if (!omt.isPresent()) {
/* 270 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 273 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 282 */       if (StringUtils.isEmpty(mt.getRoomHandleStatus())) {
/* 283 */         return this.apiError.getError("605");
/*     */       }
/*     */       
/* 286 */       if (mt.getRoomHandleStatus().equalsIgnoreCase(TicketStatus.DONE.getTicketStatus())) {
/* 287 */         return this.apiError.getError("604");
/*     */       }
/*     */ 
/*     */       
/* 291 */       this.ticketRepository.updateRoomHandleStatus(mt.getId(), TicketStatus.DONE.getTicketStatus(), request.getRoomHandleResultBy(), new Date(), Integer.valueOf(1));
/*     */       
/* 293 */       rs.put("status", "OK");
/* 294 */       rs.put("responseCode", "00");
/* 295 */       rs.put("data", data);
/*     */     }
/* 297 */     catch (Exception e) {
/* 298 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 299 */       logger.error(exceptionAsString);
/* 300 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 301 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 303 */     return rs;
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/cancelResultCheckinLisHandle/{ticketId}"})
/*     */   public ApiResponse cancelResultCheckinLisHandle(@PathVariable @Valid Integer ticketId, @Valid @RequestBody LisRisDetailResponse request) {
/* 309 */     ApiResponse rs = new ApiResponse();
/* 310 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 313 */       if (ticketId == null) {
/* 314 */         return this.apiError.getError("02");
/*     */       }
/* 316 */       if (request == null) {
/* 317 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/* 320 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 321 */       if (!omt.isPresent()) {
/* 322 */         return this.apiError.getError("02");
/*     */       }
/* 324 */       MedicTicket mt = omt.get();
/*     */ 
/*     */ 
/*     */       
/* 328 */       if (StringUtils.isNotBlank(mt.getRoomHandleStatus()) && 
/* 329 */         !mt.getRoomHandleStatus().equalsIgnoreCase(TicketStatus.DONE.getTicketStatus())) {
/* 330 */         return this.apiError.getError("603");
/*     */       }
/*     */       
/* 333 */       String status = TicketStatus.PROCESSING.getTicketStatus();
/* 334 */       this.ticketRepository.updateRoomHanderStatus(mt.getId(), status);
/*     */       
/* 336 */       rs.put("status", "OK");
/* 337 */       rs.put("responseCode", "00");
/* 338 */       rs.put("data", data);
/*     */     }
/* 340 */     catch (Exception e) {
/* 341 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 342 */       logger.error(exceptionAsString);
/* 343 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 344 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 346 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\LisRis\LisHandleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */