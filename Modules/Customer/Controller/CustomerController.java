/*     */ package nencer.app.Modules.Customer.Controller;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Customer.Entity.Customers;
/*     */ import nencer.app.Modules.Customer.Model.CustomerRequest;
/*     */ import nencer.app.Modules.Customer.Model.CustomerResponse;
/*     */ import nencer.app.Modules.Customer.Repository.CustomerRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
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
/*     */ public class CustomerController {
/*  31 */   public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
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
/*     */   CustomerRepository customerRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/customer"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String name, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  49 */     ApiResponse rs = new ApiResponse();
/*  50 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  52 */       int p = 1;
/*  53 */       int s = 10;
/*     */       try {
/*  55 */         p = (page <= 0) ? 1 : page;
/*  56 */         s = (size <= 0) ? 10 : size;
/*  57 */       } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */       
/*  61 */       PageRequest pageRequest = PageRequest.of(p - 1, s);
/*     */       
/*  63 */       Page<Customers> pages = this.customerRepository.findAll((Pageable)pageRequest);
/*  64 */       data.put("Customers", pages.stream().map(m -> (CustomerResponse)this.modelMapper.map(m, CustomerResponse.class)).collect(Collectors.toList()));
/*  65 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  66 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  68 */       rs.put("status", "OK");
/*  69 */       rs.put("responseCode", "00");
/*  70 */       rs.put("data", data);
/*     */     }
/*  72 */     catch (Exception e) {
/*  73 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  74 */       logger.error(exceptionAsString);
/*  75 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  77 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/customer/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  83 */     ApiResponse rs = new ApiResponse();
/*  84 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  87 */       if (id == null) {
/*  88 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  91 */       Optional<Customers> g = this.customerRepository.findById(id);
/*  92 */       if (!g.isPresent()) {
/*  93 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  96 */       rs.put("status", "OK");
/*  97 */       rs.put("responseCode", "00");
/*  98 */       rs.put("data", this.modelMapper.map(g.get(), CustomerResponse.class));
/*     */     }
/* 100 */     catch (Exception e) {
/* 101 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 102 */       logger.error(exceptionAsString);
/* 103 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 105 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/customer/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CustomerRequest request) {
/* 110 */     ApiResponse rs = new ApiResponse();
/* 111 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 114 */       Customers customers = (Customers)this.modelMapper.map(request, Customers.class);
/* 115 */       customers.setCreatedAt(new Date());
/* 116 */       Customers result = (Customers)this.customerRepository.saveAndFlush(customers);
/*     */       
/* 118 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 120 */       rs.put("status", "OK");
/* 121 */       rs.put("responseCode", "00");
/* 122 */       rs.put("data", data);
/*     */     }
/* 124 */     catch (Exception e) {
/* 125 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 126 */       logger.error(exceptionAsString);
/* 127 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 129 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/customer/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody CustomerRequest request) {
/* 134 */     ApiResponse rs = new ApiResponse();
/* 135 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 138 */       if (id == null) {
/* 139 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 142 */       Optional<Customers> g = this.customerRepository.findById(id);
/* 143 */       if (!g.isPresent()) {
/* 144 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 147 */       Customers customers = (Customers)this.modelMapper.map(request, Customers.class);
/* 148 */       customers.setId(id.intValue());
/*     */ 
/*     */       
/* 151 */       this.customerRepository.saveAndFlush(customers);
/*     */       
/* 153 */       rs.put("status", "OK");
/* 154 */       rs.put("responseCode", "00");
/* 155 */       rs.put("data", data);
/*     */     }
/* 157 */     catch (Exception e) {
/* 158 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 159 */       logger.error(exceptionAsString);
/* 160 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 162 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/customer/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 167 */     ApiResponse rs = new ApiResponse();
/* 168 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 171 */       if (id == null) {
/* 172 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 175 */       Optional<Customers> g = this.customerRepository.findById(id);
/* 176 */       if (!g.isPresent()) {
/* 177 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 181 */       this.customerRepository.delete(g.get());
/*     */       
/* 183 */       rs.put("status", "OK");
/* 184 */       rs.put("responseCode", "00");
/* 185 */       rs.put("data", data);
/*     */     }
/* 187 */     catch (Exception e) {
/* 188 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 189 */       logger.error(exceptionAsString);
/* 190 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 192 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Controller\CustomerController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */