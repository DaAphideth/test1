/*     */ package nencer.app.Modules.Localization.Controller;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Localization.Entity.InformationInsurance;
/*     */ import nencer.app.Modules.Localization.Repository.InformationInsuranceRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class InformationInsuranceController {
/*  26 */   public static final Logger logger = LoggerFactory.getLogger(DistrictController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   @Autowired
/*     */   InformationInsuranceRepository insuranceRepository;
/*     */   
/*     */   @GetMapping({"/information_insurance/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  38 */     ApiResponse rs = new ApiResponse();
/*  39 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  42 */       if (id == null) {
/*  43 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  46 */       Optional<InformationInsurance> g = this.insuranceRepository.findById(id);
/*  47 */       if (!g.isPresent()) {
/*  48 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  51 */       rs.put("status", "OK");
/*  52 */       rs.put("responseCode", "00");
/*  53 */       rs.put("data", g.get());
/*     */     }
/*  55 */     catch (Exception e) {
/*  56 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  57 */       logger.error(exceptionAsString);
/*  58 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  60 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/information_insurance/create"})
/*     */   public ApiResponse create(@Valid @RequestBody InformationInsurance request) {
/*  65 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  68 */       InformationInsurance insurance = (InformationInsurance)this.insuranceRepository.saveAndFlush(request);
/*     */       
/*  70 */       rs.put("status", "OK");
/*  71 */       rs.put("responseCode", "00");
/*  72 */       rs.put("data", insurance);
/*     */     }
/*  74 */     catch (Exception e) {
/*  75 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  76 */       logger.error(exceptionAsString);
/*  77 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  79 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/information_insurance/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody InformationInsurance request) {
/*  84 */     ApiResponse rs = new ApiResponse();
/*  85 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  88 */       if (id == null) {
/*  89 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  92 */       Optional<InformationInsurance> g = this.insuranceRepository.findById(id);
/*  93 */       if (!g.isPresent()) {
/*  94 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/*  98 */       InformationInsurance insurance = (InformationInsurance)this.insuranceRepository.saveAndFlush(request);
/*     */       
/* 100 */       rs.put("status", "OK");
/* 101 */       rs.put("responseCode", "00");
/* 102 */       rs.put("data", insurance);
/*     */     }
/* 104 */     catch (Exception e) {
/* 105 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 106 */       logger.error(exceptionAsString);
/* 107 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 109 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\InformationInsuranceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */