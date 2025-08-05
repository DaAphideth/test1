/*     */ package nencer.app.Modules.Storehouse.Controller.Product;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.CacheRedis.CacheData;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProduct;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductRequest;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicProductController extends BaseMedicController {
/*  37 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   MedicProductRepository medicProductRepository;
/*     */   
/*     */   @Autowired
/*     */   private CacheDataRepository cacheDataRepository;
/*     */   
/*     */   public static final String MEDIC_PRODUCT = "allProduct";
/*     */   
/*     */   @GetMapping({"/medic_product/get_all"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter) {
/*  55 */     ApiResponse rs = new ApiResponse();
/*  56 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  58 */       List<MedicProduct> products = new ArrayList<>();
/*  59 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("allProduct");
/*  60 */       if (optionalCacheData.isPresent()) {
/*  61 */         String productAsString = ((CacheData)optionalCacheData.get()).getValue();
/*  62 */         products = (List<MedicProduct>)this.objectMapper.readValue(productAsString, new TypeReference<List<MedicProduct>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } else {
/*  67 */         products = this.medicProductRepository.findAllByStatus(Integer.valueOf(1)).orElse(null);
/*  68 */         String productsAsJsonString = this.objectMapper.writeValueAsString(products);
/*  69 */         CacheData cacheData = new CacheData("allProduct", productsAsJsonString);
/*  70 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/*     */       
/*  73 */       data.put("medicProduct", products);
/*  74 */       rs.put("status", "OK");
/*  75 */       rs.put("responseCode", "00");
/*  76 */       rs.put("data", data);
/*     */     }
/*  78 */     catch (Exception e) {
/*  79 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  80 */       logger.error(exceptionAsString);
/*  81 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  83 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size) {
/*  92 */     ApiResponse rs = new ApiResponse();
/*  93 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  95 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  96 */       if (!StringUtils.isEmpty(filter)) {
/*  97 */         ObjectMapper objectMapper = new ObjectMapper();
/*  98 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/* 101 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 102 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 103 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 105 */       Page<MedicProduct> pages = this.medicProductRepository.findAll((Specification)specifications, (Pageable)pageable);
/* 106 */       data.put("medicProduct", pages.get());
/* 107 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 108 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/* 110 */       rs.put("status", "OK");
/* 111 */       rs.put("responseCode", "00");
/* 112 */       rs.put("data", data);
/*     */     }
/* 114 */     catch (Exception e) {
/* 115 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 116 */       logger.error(exceptionAsString);
/* 117 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 119 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 124 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 127 */       if (id == null) {
/* 128 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 131 */       Optional<MedicProduct> g = this.medicProductRepository.findById(id);
/* 132 */       if (!g.isPresent()) {
/* 133 */         return this.apiError.getError("02");
/*     */       }
/* 135 */       rs.put("status", "OK");
/* 136 */       rs.put("responseCode", "00");
/* 137 */       rs.put("data", g.get());
/*     */     }
/* 139 */     catch (Exception e) {
/* 140 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 141 */       logger.error(exceptionAsString);
/* 142 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 144 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_product/create"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicProductRequest request) {
/* 149 */     ApiResponse rs = new ApiResponse();
/* 150 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 152 */       MedicProduct medicProduct = this.medicProductRepository.findByCode(request.getCode()).orElse(null);
/* 153 */       if (Objects.nonNull(medicProduct)) {
/* 154 */         return this.apiError.getError("05");
/*     */       }
/* 156 */       MedicProduct product = (MedicProduct)this.modelMapper.map(request, MedicProduct.class);
/* 157 */       product.setFeatured("0");
/* 158 */       product.setCreatorId(request.getAccessToken());
/* 159 */       product.setCreatedAt(new Date());
/* 160 */       MedicProduct result = (MedicProduct)this.medicProductRepository.saveAndFlush(product);
/*     */       
/* 162 */       this.cacheDataRepository.deleteById("allProduct");
/*     */       
/* 164 */       saveRedisProduct();
/*     */       
/* 166 */       data.put("id", Integer.valueOf(result.getId()));
/* 167 */       rs.put("status", "OK");
/* 168 */       rs.put("responseCode", "00");
/* 169 */       rs.put("data", data);
/*     */     }
/* 171 */     catch (Exception e) {
/* 172 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 173 */       logger.error(exceptionAsString);
/* 174 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 176 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_product/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductRequest request) {
/* 182 */     ApiResponse rs = new ApiResponse();
/* 183 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 186 */       if (id == null) {
/* 187 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 190 */       Optional<MedicProduct> g = this.medicProductRepository.findById(id);
/* 191 */       if (!g.isPresent()) {
/* 192 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 195 */       MedicProduct medicProduct = this.medicProductRepository.findByCode(request.getCode()).orElse(null);
/* 196 */       if (Objects.nonNull(medicProduct) && !((MedicProduct)g.get()).getCode().equals(request.getCode())) {
/* 197 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 200 */       MedicProduct product = (MedicProduct)this.modelMapper.map(request, MedicProduct.class);
/* 201 */       product.setId(id.intValue());
/* 202 */       product.setFeatured("0");
/* 203 */       product.setCreatorId(((MedicProduct)g.get()).getCreatorId());
/* 204 */       product.setUpdaterId(request.getAccessToken());
/* 205 */       product.setCreatedAt(((MedicProduct)g.get()).getCreatedAt());
/* 206 */       product.setUpdatedAt(new Date());
/*     */       
/* 208 */       this.medicProductRepository.saveAndFlush(product);
/*     */       
/* 210 */       this.cacheDataRepository.deleteById("allProduct");
/*     */       
/* 212 */       saveRedisProduct();
/*     */       
/* 214 */       rs.put("status", "OK");
/* 215 */       rs.put("responseCode", "00");
/* 216 */       rs.put("data", data);
/*     */     }
/* 218 */     catch (Exception e) {
/* 219 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 220 */       logger.error(exceptionAsString);
/* 221 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 223 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_product/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 228 */     ApiResponse rs = new ApiResponse();
/* 229 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 232 */       if (id == null) {
/* 233 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 236 */       Optional<MedicProduct> g = this.medicProductRepository.findById(id);
/* 237 */       if (!g.isPresent()) {
/* 238 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 241 */       this.medicProductRepository.updateProductStatus(id);
/*     */       
/* 243 */       this.cacheDataRepository.deleteById("allProduct");
/*     */       
/* 245 */       saveRedisProduct();
/*     */       
/* 247 */       rs.put("status", "OK");
/* 248 */       rs.put("responseCode", "00");
/* 249 */       rs.put("data", data);
/*     */     }
/* 251 */     catch (Exception e) {
/* 252 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 253 */       logger.error(exceptionAsString);
/* 254 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 256 */     return rs;
/*     */   }
/*     */   
/*     */   public void saveRedisProduct() throws JsonProcessingException {
/* 260 */     List<MedicProduct> products = this.medicProductRepository.findAllByStatus(Integer.valueOf(1)).orElse(null);
/* 261 */     String productsAsJsonString = this.objectMapper.writeValueAsString(products);
/* 262 */     CacheData cacheData = new CacheData("allProduct", productsAsJsonString);
/* 263 */     this.cacheDataRepository.save(cacheData);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Product\MedicProductController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */