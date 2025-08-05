/*     */ package nencer.app.Modules.System.Controller;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.System.Entity.Currency.CurrenciesCode;
/*     */ import nencer.app.Modules.System.Model.CurrencyCodeRequest;
/*     */ import nencer.app.Modules.System.Model.CurrencyCodeResponse;
/*     */ import nencer.app.Modules.System.Model.CurrencyRequest;
/*     */ import nencer.app.Modules.System.Repository.CurrencyCodeRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class CurrencyCodeController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(CurrencyCodeController.class);
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
/*     */   CurrencyCodeRepository currencyCodeRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/currencycode"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String name, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  52 */     ApiResponse rs = new ApiResponse();
/*  53 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  55 */       int p = 1;
/*  56 */       int s = 10;
/*     */       try {
/*  58 */         p = (page <= 0) ? 1 : page;
/*  59 */         s = (size <= 0) ? 10 : size;
/*  60 */       } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */       
/*  64 */       PageRequest pageRequest = PageRequest.of(p - 1, s);
/*     */       
/*  66 */       Page<CurrenciesCode> pages = this.currencyCodeRepository.findAll((Pageable)pageRequest);
/*  67 */       data.put("currenciesCode", pages.stream().map(m -> (CurrencyCodeResponse)this.modelMapper.map(m, CurrencyCodeResponse.class)).collect(Collectors.toList()));
/*  68 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  69 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  71 */       rs.put("status", "OK");
/*  72 */       rs.put("responseCode", "00");
/*  73 */       rs.put("data", data);
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
/*     */   @GetMapping({"/currencycode/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid String id) {
/*  86 */     ApiResponse rs = new ApiResponse();
/*  87 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  90 */       if (StringUtils.isEmpty(id)) {
/*  91 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  94 */       Optional<CurrenciesCode> g = this.currencyCodeRepository.findById(id);
/*  95 */       if (!g.isPresent()) {
/*  96 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  99 */       rs.put("status", "OK");
/* 100 */       rs.put("responseCode", "00");
/* 101 */       rs.put("data", this.modelMapper.map(g.get(), CurrencyResponse.class));
/*     */     }
/* 103 */     catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/currencycode/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CurrencyCodeRequest request) {
/* 113 */     ApiResponse rs = new ApiResponse();
/* 114 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 117 */       CurrenciesCode CurrenciesCode = (CurrenciesCode)this.modelMapper.map(request, CurrenciesCode.class);
/* 118 */       CurrenciesCode result = (CurrenciesCode)this.currencyCodeRepository.saveAndFlush(CurrenciesCode);
/*     */       
/* 120 */       data.put("id", result.getCode());
/*     */       
/* 122 */       rs.put("status", "OK");
/* 123 */       rs.put("responseCode", "00");
/* 124 */       rs.put("data", data);
/*     */     }
/* 126 */     catch (Exception e) {
/* 127 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 128 */       logger.error(exceptionAsString);
/* 129 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 131 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/currencycode/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid String id, @Valid @RequestBody CurrencyRequest request) {
/* 136 */     ApiResponse rs = new ApiResponse();
/* 137 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 140 */       if (id == null) {
/* 141 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 144 */       Optional<CurrenciesCode> g = this.currencyCodeRepository.findById(id);
/* 145 */       if (!g.isPresent()) {
/* 146 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 149 */       CurrenciesCode CurrenciesCode = (CurrenciesCode)this.modelMapper.map(request, CurrenciesCode.class);
/* 150 */       CurrenciesCode.setCode(id);
/*     */ 
/*     */       
/* 153 */       this.currencyCodeRepository.saveAndFlush(CurrenciesCode);
/*     */       
/* 155 */       rs.put("status", "OK");
/* 156 */       rs.put("responseCode", "00");
/* 157 */       rs.put("data", data);
/*     */     }
/* 159 */     catch (Exception e) {
/* 160 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 161 */       logger.error(exceptionAsString);
/* 162 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 164 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/currencycode/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid String id) {
/* 169 */     ApiResponse rs = new ApiResponse();
/* 170 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 173 */       if (id == null) {
/* 174 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 177 */       Optional<CurrenciesCode> g = this.currencyCodeRepository.findById(id);
/* 178 */       if (!g.isPresent()) {
/* 179 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 183 */       this.currencyCodeRepository.delete(g.get());
/*     */       
/* 185 */       rs.put("status", "OK");
/* 186 */       rs.put("responseCode", "00");
/* 187 */       rs.put("data", data);
/*     */     }
/* 189 */     catch (Exception e) {
/* 190 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 191 */       logger.error(exceptionAsString);
/* 192 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 194 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Controller\CurrencyCodeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */