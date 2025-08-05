/*     */ package nencer.app.Modules.System.Controller;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.System.Entity.Currency.Currencies;
/*     */ import nencer.app.Modules.System.Model.CurrencyRequest;
/*     */ import nencer.app.Modules.System.Model.CurrencyResponse;
/*     */ import nencer.app.Modules.System.Repository.CurrencyRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class CurrencyController {
/*  28 */   public static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
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
/*     */   CurrencyRepository currencyRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/currency"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String name, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  46 */     ApiResponse rs = new ApiResponse();
/*  47 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  49 */       int p = 1;
/*  50 */       int s = 10;
/*     */       try {
/*  52 */         p = (page <= 0) ? 1 : page;
/*  53 */         s = (size <= 0) ? 10 : size;
/*  54 */       } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */       
/*  58 */       PageRequest pageRequest = PageRequest.of(p - 1, s);
/*     */       
/*  60 */       Page<Currencies> pages = this.currencyRepository.findAll((Pageable)pageRequest);
/*  61 */       data.put("currencies", pages.stream().map(m -> (CurrencyResponse)this.modelMapper.map(m, CurrencyResponse.class)).collect(Collectors.toList()));
/*  62 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  63 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  65 */       rs.put("status", "OK");
/*  66 */       rs.put("responseCode", "00");
/*  67 */       rs.put("data", data);
/*     */     }
/*  69 */     catch (Exception e) {
/*  70 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  71 */       logger.error(exceptionAsString);
/*  72 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  74 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/currency/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*  81 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  84 */       if (id == null) {
/*  85 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  88 */       Optional<Currencies> g = this.currencyRepository.findById(id);
/*  89 */       if (!g.isPresent()) {
/*  90 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  93 */       rs.put("status", "OK");
/*  94 */       rs.put("responseCode", "00");
/*  95 */       rs.put("data", this.modelMapper.map(g.get(), CurrencyResponse.class));
/*     */     }
/*  97 */     catch (Exception e) {
/*  98 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  99 */       logger.error(exceptionAsString);
/* 100 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 102 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/currency/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CurrencyRequest request) {
/* 107 */     ApiResponse rs = new ApiResponse();
/* 108 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 111 */       Currencies currencies = (Currencies)this.modelMapper.map(request, Currencies.class);
/* 112 */       currencies.setStatus((request.getStatus() != 1) ? 1 : 0);
/* 113 */       currencies.setCreatedAt(new Date());
/* 114 */       currencies.setChecksum(UUID.randomUUID().toString());
/* 115 */       Currencies result = (Currencies)this.currencyRepository.saveAndFlush(currencies);
/* 116 */       data.put("id", Integer.valueOf(result.getId()));
/* 117 */       rs.put("status", "OK");
/* 118 */       rs.put("responseCode", "00");
/* 119 */       rs.put("data", data);
/*     */     }
/* 121 */     catch (Exception e) {
/* 122 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 123 */       logger.error(exceptionAsString);
/* 124 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 126 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/currency/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody CurrencyRequest request) {
/* 131 */     ApiResponse rs = new ApiResponse();
/* 132 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 135 */       if (id == null) {
/* 136 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 139 */       Optional<Currencies> g = this.currencyRepository.findById(id);
/* 140 */       if (!g.isPresent()) {
/* 141 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 144 */       Currencies currencies = (Currencies)this.modelMapper.map(request, Currencies.class);
/* 145 */       currencies.setId(id.intValue());
/* 146 */       currencies.setCreatedAt(((Currencies)g.get()).getCreatedAt());
/* 147 */       currencies.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 150 */       this.currencyRepository.saveAndFlush(currencies);
/* 151 */       data.put("id", Integer.valueOf(currencies.getId()));
/* 152 */       rs.put("status", "OK");
/* 153 */       rs.put("responseCode", "00");
/* 154 */       rs.put("data", data);
/*     */     }
/* 156 */     catch (Exception e) {
/* 157 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 158 */       logger.error(exceptionAsString);
/* 159 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 161 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/currency/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 166 */     ApiResponse rs = new ApiResponse();
/* 167 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 170 */       if (id == null) {
/* 171 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 174 */       Optional<Currencies> g = this.currencyRepository.findById(id);
/* 175 */       if (!g.isPresent()) {
/* 176 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 180 */       this.currencyRepository.delete(g.get());
/*     */       
/* 182 */       rs.put("status", "OK");
/* 183 */       rs.put("responseCode", "00");
/* 184 */       rs.put("data", data);
/*     */     }
/* 186 */     catch (Exception e) {
/* 187 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 188 */       logger.error(exceptionAsString);
/* 189 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 191 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Controller\CurrencyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */