/*     */ package nencer.app.Modules.Medic.Controller.LisRis;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServicesPttt;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomRepository;
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
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class PtttController extends BaseMedicController {
/*  36 */   public static final Logger logger = LoggerFactory.getLogger(PtttController.class);
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
/*     */   RoomRepository roomRepository;
/*     */   
/*     */   @Autowired
/*     */   RoomNumberRepository roomNumberRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_pttt/getPtttOrderService/{orderServiceId}/{ticketId}"})
/*     */   public ApiResponse getRisOrderService(@PathVariable @Valid Integer orderServiceId, @PathVariable @Valid Integer ticketId) {
/*  58 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  61 */       if (orderServiceId == null) {
/*  62 */         return this.apiError.getError("02");
/*     */       }
/*  64 */       if (ticketId == null) {
/*  65 */         return this.apiError.getError("02");
/*     */       }
/*  67 */       Optional<MedicTicket> mt = this.ticketRepository.findById(ticketId);
/*  68 */       if (!mt.isPresent()) return this.apiError.getError("02");
/*     */       
/*  70 */       MedicOrderServicesPttt lrs = this.orderServicePtttRepository.findByOrderAndTicketId(orderServiceId, ticketId).orElse(null);
/*  71 */       rs.put("status", "OK");
/*  72 */       rs.put("responseCode", "00");
/*  73 */       rs.put("data", lrs);
/*     */     }
/*  75 */     catch (Exception e) {
/*  76 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  77 */       logger.error(exceptionAsString);
/*  78 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  80 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_pttt/savePttOrderService"})
/*     */   public ApiResponse savePttOrderService(@Valid @RequestBody MedicOrderServicesPttt request) {
/*  89 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  92 */       if (request == null) {
/*  93 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/*  96 */       if (request.getTicketId() == null) {
/*  97 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 100 */       if (request.getOrderServiceId() == null) {
/* 101 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 105 */       Optional<MedicTicket> omt = this.ticketRepository.findById(request.getTicketId());
/* 106 */       if (!omt.isPresent()) {
/* 107 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 111 */       this.orderServicePtttRepository.deleteByOrderService(request.getOrderServiceId(), request.getTicketId());
/*     */       
/* 113 */       this.orderServicePtttRepository.saveAndFlush(request);
/*     */       
/* 115 */       rs.put("status", "OK");
/* 116 */       rs.put("responseCode", "00");
/* 117 */       rs.put("data", "THANH CONG");
/*     */     }
/* 119 */     catch (Exception e) {
/* 120 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 121 */       logger.error(exceptionAsString);
/* 122 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 123 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 125 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_pttt/deletePttOrderService"})
/*     */   public ApiResponse deletePttOrderService(@Valid @RequestBody MedicOrderServicesPttt request) {
/* 134 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 137 */       if (request == null) {
/* 138 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/* 141 */       if (request.getTicketId() == null) {
/* 142 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 145 */       if (request.getOrderServiceId() == null) {
/* 146 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 150 */       Optional<MedicTicket> omt = this.ticketRepository.findById(request.getTicketId());
/* 151 */       if (!omt.isPresent()) {
/* 152 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 156 */       this.orderServicePtttRepository.deleteByOrderService(request.getOrderServiceId(), request.getTicketId());
/*     */       
/* 158 */       rs.put("status", "OK");
/* 159 */       rs.put("responseCode", "00");
/* 160 */       rs.put("data", "THANH CONG");
/*     */     }
/* 162 */     catch (Exception e) {
/* 163 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 164 */       logger.error(exceptionAsString);
/* 165 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 166 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 168 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_checkin/deletePttOrderService/{orderServiceId}/{ticketId}"})
/*     */   public ApiResponse deletePttOrderService(@PathVariable @Valid Integer orderServiceId, @PathVariable @Valid Integer ticketId) {
/* 175 */     ApiResponse rs = new ApiResponse();
/* 176 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 179 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 180 */       if (!omt.isPresent()) {
/* 181 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 185 */       this.orderServicePtttRepository.deleteByOrderService(orderServiceId, ticketId);
/*     */       
/* 187 */       rs.put("status", "OK");
/* 188 */       rs.put("responseCode", "00");
/* 189 */       rs.put("data", "THANH CONG");
/*     */     }
/* 191 */     catch (Exception e) {
/* 192 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 193 */       logger.error(exceptionAsString);
/* 194 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 196 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\LisRis\PtttController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */