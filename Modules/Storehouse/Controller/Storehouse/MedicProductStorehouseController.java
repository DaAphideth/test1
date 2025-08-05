/*     */ package nencer.app.Modules.Storehouse.Controller.Storehouse;
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
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
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
/*     */ public class MedicProductStorehouseController {
/*  31 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductStorehouseController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   CommonStoreHouseRepo commonStoreHouseRepo;
/*     */   
/*     */   @Autowired
/*     */   MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse/get_all"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  51 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  52 */       if (!StringUtils.isEmpty(filter)) {
/*  53 */         ObjectMapper objectMapper = new ObjectMapper();
/*  54 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  57 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  59 */       List<MedicProductStorehouse> pages = this.medicProductStorehouseRepository.findAll((Specification)specifications);
/*  60 */       data.put("medicProductStorehouse", pages);
/*     */       
/*  62 */       rs.put("status", "OK");
/*  63 */       rs.put("responseCode", "00");
/*  64 */       rs.put("data", data);
/*     */     }
/*  66 */     catch (Exception e) {
/*  67 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  68 */       logger.error(exceptionAsString);
/*  69 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  71 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) Integer status, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "ASC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  83 */     ApiResponse rs = new ApiResponse();
/*  84 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  87 */       List<MedicProductStorehouse> list = this.commonStoreHouseRepo.spSerchProductStorehouse(searchValue, storehouseId, status, fieldSort, direction, page, size);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       data.put("dataRes", list);
/*  98 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicProductStorehouse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 100 */       rs.put("status", "OK");
/* 101 */       rs.put("responseCode", "00");
/* 102 */       rs.put("data", data);
/*     */     }
/* 104 */     catch (Exception e) {
/* 105 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 106 */       logger.error(exceptionAsString);
/* 107 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 109 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 114 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 117 */       if (id == null) {
/* 118 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 121 */       Optional<MedicProductStorehouse> g = this.medicProductStorehouseRepository.findById(id);
/* 122 */       if (!g.isPresent()) {
/* 123 */         return this.apiError.getError("02");
/*     */       }
/* 125 */       rs.put("status", "OK");
/* 126 */       rs.put("responseCode", "00");
/* 127 */       rs.put("data", g.get());
/*     */     }
/* 129 */     catch (Exception e) {
/* 130 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 131 */       logger.error(exceptionAsString);
/* 132 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 134 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_product_storehouse"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicProductStorehouse request) {
/* 139 */     ApiResponse rs = new ApiResponse();
/* 140 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 142 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findByCode(request.getCode()).orElse(null);
/* 143 */       if (Objects.nonNull(medicProductStorehouse)) {
/* 144 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 147 */       request.setCreatedAt(new Date());
/* 148 */       MedicProductStorehouse result = (MedicProductStorehouse)this.medicProductStorehouseRepository.saveAndFlush(request);
/*     */       
/* 150 */       data.put("id", result.getId());
/* 151 */       rs.put("status", "OK");
/* 152 */       rs.put("responseCode", "00");
/* 153 */       rs.put("data", data);
/*     */     }
/* 155 */     catch (Exception e) {
/* 156 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 157 */       logger.error(exceptionAsString);
/* 158 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 160 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_product_storehouse/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductStorehouse request) {
/* 166 */     ApiResponse rs = new ApiResponse();
/* 167 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 170 */       if (id == null) {
/* 171 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 174 */       Optional<MedicProductStorehouse> g = this.medicProductStorehouseRepository.findById(id);
/* 175 */       if (!g.isPresent()) {
/* 176 */         return this.apiError.getError("02");
/*     */       }
/* 178 */       MedicProductStorehouse storehouse = this.medicProductStorehouseRepository.findByCode(request.getCode()).orElse(null);
/* 179 */       if (Objects.nonNull(storehouse) && !((MedicProductStorehouse)g.get()).getCode().equalsIgnoreCase(request.getCode())) {
/* 180 */         return this.apiError.getError("05");
/*     */       }
/*     */ 
/*     */       
/* 184 */       request.setId(id);
/* 185 */       request.setCreatedAt(((MedicProductStorehouse)g.get()).getCreatedAt());
/* 186 */       request.setUpdatedAt(new Date());
/* 187 */       request.setCreatorId(((MedicProductStorehouse)g.get()).getCreatorId());
/*     */       
/* 189 */       this.medicProductStorehouseRepository.saveAndFlush(request);
/*     */       
/* 191 */       rs.put("status", "OK");
/* 192 */       rs.put("responseCode", "00");
/* 193 */       rs.put("data", data);
/*     */     }
/* 195 */     catch (Exception e) {
/* 196 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 197 */       logger.error(exceptionAsString);
/* 198 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 200 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_product_storehouse/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 205 */     ApiResponse rs = new ApiResponse();
/* 206 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 209 */       if (id == null) {
/* 210 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 213 */       Optional<MedicProductStorehouse> g = this.medicProductStorehouseRepository.findById(id);
/* 214 */       if (!g.isPresent()) {
/* 215 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 218 */       this.medicProductStorehouseRepository.delete(g.get());
/* 219 */       rs.put("status", "OK");
/* 220 */       rs.put("responseCode", "00");
/*     */     }
/* 222 */     catch (Exception e) {
/* 223 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 224 */       logger.error(exceptionAsString);
/* 225 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 227 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Storehouse\MedicProductStorehouseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */