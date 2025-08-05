/*     */ package nencer.app.Modules.Storehouse.Controller.Product;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Drugs.MedicProductCats;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
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
/*     */ public class MedicProductCatsController {
/*  30 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductCatsController.class);
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
/*     */   MedicProductCatsRepository medicProductCatsRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_cats"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  51 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  52 */       if (!StringUtils.isEmpty(filter)) {
/*  53 */         ObjectMapper objectMapper = new ObjectMapper();
/*  54 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  58 */       PageRequest pageable = PageRequest.of(page - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  59 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  60 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  62 */       Page<MedicProductCats> pages = this.medicProductCatsRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  63 */       data.put("medicProductCats", pages.get());
/*  64 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  65 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*  66 */       rs.put("status", "OK");
/*  67 */       rs.put("responseCode", "00");
/*  68 */       rs.put("data", data);
/*     */     }
/*  70 */     catch (Exception e) {
/*  71 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  72 */       logger.error(exceptionAsString);
/*  73 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  75 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_cats/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  83 */       if (id == null) {
/*  84 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  87 */       Optional<MedicProductCats> g = this.medicProductCatsRepository.findById(id);
/*  88 */       if (!g.isPresent()) {
/*  89 */         return this.apiError.getError("02");
/*     */       }
/*  91 */       rs.put("status", "OK");
/*  92 */       rs.put("responseCode", "00");
/*  93 */       rs.put("data", g.get());
/*     */     }
/*  95 */     catch (Exception e) {
/*  96 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  97 */       logger.error(exceptionAsString);
/*  98 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 100 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_product_cats"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicProductCats request) {
/* 105 */     ApiResponse rs = new ApiResponse();
/* 106 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 108 */       request.setCreatedAt(new Date());
/* 109 */       MedicProductCats result = (MedicProductCats)this.medicProductCatsRepository.saveAndFlush(request);
/*     */       
/* 111 */       data.put("id", Integer.valueOf(result.getId()));
/* 112 */       rs.put("status", "OK");
/* 113 */       rs.put("responseCode", "00");
/* 114 */       rs.put("data", data);
/*     */     }
/* 116 */     catch (Exception e) {
/* 117 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 118 */       logger.error(exceptionAsString);
/* 119 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 121 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_product_cats/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductCats request) {
/* 127 */     ApiResponse rs = new ApiResponse();
/* 128 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 131 */       if (id == null) {
/* 132 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 135 */       Optional<MedicProductCats> g = this.medicProductCatsRepository.findById(id);
/* 136 */       if (!g.isPresent()) {
/* 137 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 140 */       request.setId(id.intValue());
/*     */ 
/*     */       
/* 143 */       this.medicProductCatsRepository.saveAndFlush(request);
/*     */       
/* 145 */       rs.put("status", "OK");
/* 146 */       rs.put("responseCode", "00");
/* 147 */       rs.put("data", data);
/*     */     }
/* 149 */     catch (Exception e) {
/* 150 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 151 */       logger.error(exceptionAsString);
/* 152 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 154 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_product_cats/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 159 */     ApiResponse rs = new ApiResponse();
/* 160 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 163 */       if (id == null) {
/* 164 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 167 */       Optional<MedicProductCats> g = this.medicProductCatsRepository.findById(id);
/* 168 */       if (!g.isPresent()) {
/* 169 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 172 */       this.medicProductCatsRepository.delete(g.get());
/* 173 */       rs.put("status", "OK");
/* 174 */       rs.put("responseCode", "00");
/* 175 */       rs.put("data", data);
/*     */     }
/* 177 */     catch (Exception e) {
/* 178 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 179 */       logger.error(exceptionAsString);
/* 180 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 182 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_cats/getAll"})
/*     */   public ApiResponse getAll() {
/* 187 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 190 */       List<MedicProductCats> medicRoomsList = this.medicProductCatsRepository.findAllByStatus(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */ 
/*     */       
/* 193 */       rs.put("status", "OK");
/* 194 */       rs.put("responseCode", "00");
/* 195 */       rs.put("data", medicRoomsList);
/*     */     }
/* 197 */     catch (Exception e) {
/* 198 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 199 */       logger.error(exceptionAsString);
/* 200 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 202 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Product\MedicProductCatsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */