/*     */ package nencer.app.Modules.Medic.Controller;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.CacheRedis.CacheData;
/*     */ import nencer.app.Modules.Medic.Entity.Diagnostic.MedicDiagnostic;
/*     */ import nencer.app.Modules.Medic.Model.Diagnostic.DiagnosticRequest;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Repository.DiagnosticRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
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
/*     */ public class DiagnosticController extends BaseMedicController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);
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
/*     */   DiagnosticRepository diagnosticRepository;
/*     */   
/*     */   @Autowired
/*     */   private CacheDataRepository cacheDataRepository;
/*     */   
/*     */   public static final String MEDIC_DIAGNOSTIC = "allDiagnostic";
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_diagnostic/getAll"})
/*     */   public ApiResponse getCheckinService() {
/*  62 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  64 */       List<MedicDiagnostic> medicDiagnostics = new ArrayList<>();
/*  65 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("allDiagnostic");
/*  66 */       if (optionalCacheData.isPresent()) {
/*  67 */         String productAsString = ((CacheData)optionalCacheData.get()).getValue();
/*  68 */         medicDiagnostics = (List<MedicDiagnostic>)this.objectMapper.readValue(productAsString, new TypeReference<List<MedicDiagnostic>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } else {
/*  73 */         medicDiagnostics = this.diagnosticRepository.findAllByStatus().orElse(null);
/*  74 */         String productsAsJsonString = this.objectMapper.writeValueAsString(medicDiagnostics);
/*  75 */         CacheData cacheData = new CacheData("allDiagnostic", productsAsJsonString);
/*     */         
/*  77 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/*     */       
/*  80 */       rs.put("status", "OK");
/*  81 */       rs.put("responseCode", "00");
/*  82 */       rs.put("data", medicDiagnostics);
/*     */     }
/*  84 */     catch (Exception e) {
/*  85 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  86 */       logger.error(exceptionAsString);
/*  87 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  89 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_diagnostic/getBy/{value}"})
/*     */   public ApiResponse getBy(@PathVariable @Valid String value) {
/*  94 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  97 */       List<MedicDiagnostic> medicDiagnostics = new ArrayList<>();
/*  98 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("allDiagnostic" + value.toUpperCase());
/*  99 */       if (optionalCacheData.isPresent()) {
/* 100 */         String productAsString = ((CacheData)optionalCacheData.get()).getValue();
/* 101 */         medicDiagnostics = (List<MedicDiagnostic>)this.objectMapper.readValue(productAsString, new TypeReference<List<MedicDiagnostic>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } else {
/* 106 */         medicDiagnostics = this.diagnosticRepository.findByValue(value).orElse(null);
/* 107 */         String productsAsJsonString = this.objectMapper.writeValueAsString(medicDiagnostics);
/* 108 */         CacheData cacheData = new CacheData("allDiagnostic" + value.toUpperCase(), productsAsJsonString);
/*     */         
/* 110 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/* 112 */       rs.put("status", "OK");
/* 113 */       rs.put("responseCode", "00");
/* 114 */       rs.put("data", medicDiagnostics);
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
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_diagnostic"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 130 */     ApiResponse rs = new ApiResponse();
/* 131 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 133 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 134 */       if (!StringUtils.isEmpty(filter)) {
/* 135 */         ObjectMapper objectMapper = new ObjectMapper();
/* 136 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/* 139 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 140 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 141 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 143 */       Page<MedicDiagnostic> pages = this.diagnosticRepository.findAll((Specification)specifications, (Pageable)pageable);
/* 144 */       data.put("services", pages.getContent());
/* 145 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 146 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/* 148 */       rs.put("status", "OK");
/* 149 */       rs.put("responseCode", "00");
/* 150 */       rs.put("data", data);
/*     */     }
/* 152 */     catch (Exception e) {
/* 153 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 154 */       logger.error(exceptionAsString);
/* 155 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 157 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_diagnostic/create"})
/*     */   public ApiResponse create(@Valid @RequestBody DiagnosticRequest request) {
/* 162 */     ApiResponse rs = new ApiResponse();
/* 163 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 165 */       MedicDiagnostic medicDiagnostic = this.diagnosticRepository.findByCode(request.getCode()).orElse(null);
/* 166 */       if (Objects.nonNull(medicDiagnostic)) {
/* 167 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 170 */       MedicDiagnostic diagnostic = (MedicDiagnostic)this.modelMapper.map(request, MedicDiagnostic.class);
/* 171 */       diagnostic.setCreatedAt(new Date());
/* 172 */       MedicDiagnostic result = (MedicDiagnostic)this.diagnosticRepository.saveAndFlush(diagnostic);
/*     */       
/* 174 */       deleteRedisDiagnostic();
/*     */       
/* 176 */       saveRedisDiagnostic();
/* 177 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 179 */       rs.put("status", "OK");
/* 180 */       rs.put("responseCode", "00");
/* 181 */       rs.put("data", data);
/*     */     }
/* 183 */     catch (Exception e) {
/* 184 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 185 */       logger.error(exceptionAsString);
/* 186 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 188 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_diagnostic/edit/{id}"})
/*     */   public ApiResponse create(@Valid @PathVariable Integer id, @Valid @RequestBody DiagnosticRequest request) {
/* 193 */     ApiResponse rs = new ApiResponse();
/* 194 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 196 */       if (id == null) {
/* 197 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 200 */       Optional<MedicDiagnostic> g = this.diagnosticRepository.findById(id);
/* 201 */       if (!g.isPresent()) {
/* 202 */         return this.apiError.getError("02");
/*     */       }
/* 204 */       MedicDiagnostic medicDiagnostic = this.diagnosticRepository.findByCode(request.getCode()).orElse(null);
/* 205 */       if (Objects.nonNull(medicDiagnostic) && !((MedicDiagnostic)g.get()).getCode().equals(request.getCode())) {
/* 206 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 209 */       MedicDiagnostic diagnostic = (MedicDiagnostic)this.modelMapper.map(request, MedicDiagnostic.class);
/* 210 */       diagnostic.setId(id.intValue());
/* 211 */       diagnostic.setUpdatedAt(new Date());
/* 212 */       diagnostic.setCreatedAt(((MedicDiagnostic)g.get()).getCreatedAt());
/* 213 */       MedicDiagnostic result = (MedicDiagnostic)this.diagnosticRepository.saveAndFlush(diagnostic);
/*     */       
/* 215 */       deleteRedisDiagnostic();
/*     */       
/* 217 */       saveRedisDiagnostic();
/* 218 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 220 */       rs.put("status", "OK");
/* 221 */       rs.put("responseCode", "00");
/* 222 */       rs.put("data", data);
/*     */     }
/* 224 */     catch (Exception e) {
/* 225 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 226 */       logger.error(exceptionAsString);
/* 227 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 229 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_diagnostic/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 234 */     ApiResponse rs = new ApiResponse();
/* 235 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 238 */       if (id == null) {
/* 239 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 242 */       Optional<MedicDiagnostic> g = this.diagnosticRepository.findById(id);
/* 243 */       if (!g.isPresent()) {
/* 244 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 248 */       this.diagnosticRepository.updateMedicDiagnosticStatus(id);
/*     */       
/* 250 */       deleteRedisDiagnostic();
/*     */       
/* 252 */       saveRedisDiagnostic();
/* 253 */       rs.put("status", "OK");
/* 254 */       rs.put("responseCode", "00");
/* 255 */       rs.put("data", data);
/*     */     }
/* 257 */     catch (Exception e) {
/* 258 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 259 */       logger.error(exceptionAsString);
/* 260 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 262 */     return rs;
/*     */   }
/*     */   
/*     */   public void saveRedisDiagnostic() throws JsonProcessingException {
/* 266 */     List<MedicDiagnostic> medicDiagnostics = this.diagnosticRepository.findAllByStatus().orElse(null);
/* 267 */     if (CollectionUtils.isNotEmpty(medicDiagnostics)) {
/* 268 */       String productsAsJsonString = this.objectMapper.writeValueAsString(medicDiagnostics);
/* 269 */       CacheData cacheData = new CacheData("allDiagnostic", productsAsJsonString);
/* 270 */       this.cacheDataRepository.save(cacheData);
/*     */     } 
/*     */   }
/*     */   @DeleteMapping({"/medic_diagnostic/delete"})
/*     */   public void deleteRedisDiagnostic() {
/* 275 */     List<CacheData> cacheData = (List<CacheData>)this.cacheDataRepository.findAll();
/*     */     
/* 277 */     List<CacheData> dataList = (List<CacheData>)cacheData.stream().filter(x -> x.getKey().contains("allDiagnostic")).collect(Collectors.toList());
/* 278 */     this.cacheDataRepository.deleteAll(dataList);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\DiagnosticController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */