/*     */ package nencer.app.Modules.Medic.Controller.Payment;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Fund.PaymentBook;
/*     */ import nencer.app.Modules.Medic.Repository.OrderServicesHisRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Payment.CommonPaymentRepo;
/*     */ import nencer.app.Modules.Medic.Repository.Payment.FundLogRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Payment.PaymentBookRepository;
/*     */ import nencer.app.Modules.Storehouse.Service.StoreHouseService;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class PaymentBookController
/*     */   extends BaseMedicController
/*     */ {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(PaymentBookController.class);
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
/*     */   @Autowired
/*     */   PaymentBookRepository paymentBookRepository;
/*     */ 
/*     */   
/*     */   @PostMapping({"/payment_book"})
/*     */   public ApiResponse savePaymentBook(@RequestBody(required = false) PaymentBook paymentBook) {
/*  64 */     ApiResponse rs = new ApiResponse();
/*  65 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  68 */       paymentBook.setCreatedDate(new Date());
/*  69 */       PaymentBook result = (PaymentBook)this.paymentBookRepository.saveAndFlush(paymentBook);
/*     */       
/*  71 */       data.put("dataRes", result);
/*     */       
/*  73 */       rs.put("status", "OK");
/*  74 */       rs.put("responseCode", "00");
/*  75 */       rs.put("data", data);
/*     */     }
/*  77 */     catch (Exception e) {
/*  78 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  79 */       logger.error(exceptionAsString);
/*  80 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  82 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PutMapping({"/payment_book"})
/*     */   public ApiResponse editPaymentBook(@RequestBody(required = false) PaymentBook paymentBook) {
/*  90 */     ApiResponse rs = new ApiResponse();
/*  91 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  94 */       if (paymentBook.getPbId() == null) {
/*  95 */         return this.apiError.getError("202", new String[] { "pbId" });
/*     */       }
/*     */ 
/*     */       
/*  99 */       paymentBook.setCreatedDate(new Date());
/* 100 */       PaymentBook result = (PaymentBook)this.paymentBookRepository.saveAndFlush(paymentBook);
/*     */       
/* 102 */       data.put("dataRes", result);
/*     */       
/* 104 */       rs.put("status", "OK");
/* 105 */       rs.put("responseCode", "00");
/* 106 */       rs.put("data", data);
/*     */     }
/* 108 */     catch (Exception e) {
/* 109 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 110 */       logger.error(exceptionAsString);
/* 111 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 113 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Payment\PaymentBookController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */