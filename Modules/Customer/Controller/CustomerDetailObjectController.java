/*     */ package nencer.app.Modules.Customer.Controller;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Customer.Entity.CustomerDetailObject;
/*     */ import nencer.app.Modules.Customer.Model.CustomerDetailObjectModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class CustomerDetailObjectController extends BaseMedicController {
/*  25 */   public static final Logger logger = LoggerFactory.getLogger(CustomerDetailObjectController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   CustomerDetailObjectRepository customerDetailObjectRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/cus_ob_detail/getAll"})
/*     */   public ApiResponse getAll() {
/*  36 */     ApiResponse rs = new ApiResponse();
/*  37 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  39 */       List<CustomerDetailObject> customerDetailObjects = this.customerDetailObjectRepository.findAll();
/*     */       
/*  41 */       rs.put("status", "OK");
/*  42 */       rs.put("responseCode", "00");
/*  43 */       rs.put("data", customerDetailObjects);
/*     */     }
/*  45 */     catch (Exception e) {
/*  46 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  47 */       logger.error(exceptionAsString);
/*  48 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  50 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/cus_ob_detail"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  59 */     ApiResponse rs = new ApiResponse();
/*  60 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  62 */       List<CustomerDetailObjectModel> list = this.medicService.searchCustomerDetailObject(page, size, searchValue, fieldSort, direction);
/*     */       
/*  64 */       data.put("dataRes", list);
/*  65 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((CustomerDetailObjectModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  67 */       rs.put("status", "OK");
/*  68 */       rs.put("responseCode", "00");
/*  69 */       rs.put("data", data);
/*     */     }
/*  71 */     catch (Exception e) {
/*  72 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  73 */       logger.error(exceptionAsString);
/*  74 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  76 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/cus_ob_detail/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CustomerDetailObject request) {
/*  81 */     ApiResponse rs = new ApiResponse();
/*  82 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  84 */       CustomerDetailObject customerDetailObject = this.customerDetailObjectRepository.findById(request.getDoCode()).orElse(null);
/*  85 */       if (Objects.nonNull(customerDetailObject)) {
/*  86 */         return this.apiError.getError("05");
/*     */       }
/*  88 */       CustomerDetailObject result = (CustomerDetailObject)this.customerDetailObjectRepository.saveAndFlush(request);
/*     */       
/*  90 */       data.put("id", result.getDoCode());
/*  91 */       rs.put("status", "OK");
/*  92 */       rs.put("responseCode", "00");
/*  93 */       rs.put("data", data);
/*     */     }
/*  95 */     catch (Exception e) {
/*  96 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  97 */       logger.error(exceptionAsString);
/*  98 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 100 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/cus_ob_detail/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid String id, @Valid @RequestBody CustomerDetailObject request) {
/* 106 */     ApiResponse rs = new ApiResponse();
/* 107 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 110 */       if (id == null) {
/* 111 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 114 */       Optional<CustomerDetailObject> g = this.customerDetailObjectRepository.findById(id);
/* 115 */       if (!g.isPresent()) {
/* 116 */         return this.apiError.getError("02");
/*     */       }
/* 118 */       CustomerDetailObject customerDetailObject = this.customerDetailObjectRepository.findById(request.getDoCode()).orElse(null);
/* 119 */       if (Objects.nonNull(customerDetailObject) && !((CustomerDetailObject)g.get()).getDoCode().equals(request.getDoCode())) {
/* 120 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 123 */       request.setDoCode(id);
/*     */ 
/*     */       
/* 126 */       this.customerDetailObjectRepository.saveAndFlush(request);
/*     */       
/* 128 */       rs.put("status", "OK");
/* 129 */       rs.put("responseCode", "00");
/* 130 */       rs.put("data", data);
/*     */     }
/* 132 */     catch (Exception e) {
/* 133 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 134 */       logger.error(exceptionAsString);
/* 135 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 137 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/cus_ob_detail/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid String id) {
/* 142 */     ApiResponse rs = new ApiResponse();
/* 143 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 146 */       if (id == null) {
/* 147 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 150 */       Optional<CustomerDetailObject> g = this.customerDetailObjectRepository.findById(id);
/* 151 */       if (!g.isPresent()) {
/* 152 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 156 */       this.customerDetailObjectRepository.delete(g.get());
/* 157 */       rs.put("status", "OK");
/* 158 */       rs.put("responseCode", "00");
/* 159 */       rs.put("data", data);
/*     */     }
/* 161 */     catch (Exception e) {
/* 162 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 163 */       logger.error(exceptionAsString);
/* 164 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 166 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Controller\CustomerDetailObjectController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */