/*     */ package nencer.app.Modules.Localization.Controller;
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
/*     */ import nencer.app.Modules.Localization.Entity.MedicUnit;
/*     */ import nencer.app.Modules.Localization.Model.UnitRequest;
/*     */ import nencer.app.Modules.Localization.Model.UnitResponse;
/*     */ import nencer.app.Modules.Localization.Repository.MedicUnitRepository;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
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
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class UnitController extends BaseMedicController {
/*  46 */   public static final Logger logger = LoggerFactory.getLogger(UnitController.class);
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
/*     */   MedicUnitRepository unitRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   CacheDataRepository cacheDataRepository;
/*     */   
/*     */   public static final String MEDIC_UNIT = "medicUnit";
/*     */ 
/*     */   
/*     */   @GetMapping({"/unit"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  69 */     ApiResponse rs = new ApiResponse();
/*  70 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  72 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  73 */       if (!StringUtils.isEmpty(filter)) {
/*  74 */         ObjectMapper objectMapper = new ObjectMapper();
/*  75 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  78 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  79 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  80 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  82 */       Page<MedicUnit> pages = this.unitRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  83 */       data.put("unit", pages.getContent());
/*  84 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  85 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  87 */       rs.put("status", "OK");
/*  88 */       rs.put("responseCode", "00");
/*  89 */       rs.put("data", data);
/*     */     }
/*  91 */     catch (Exception e) {
/*  92 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  93 */       logger.error(exceptionAsString);
/*  94 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  96 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/unit/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 102 */     ApiResponse rs = new ApiResponse();
/* 103 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 106 */       if (id == null) {
/* 107 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 110 */       Optional<MedicUnit> g = this.unitRepository.findById(id);
/* 111 */       if (!g.isPresent()) {
/* 112 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 115 */       rs.put("status", "OK");
/* 116 */       rs.put("responseCode", "00");
/* 117 */       rs.put("data", this.modelMapper.map(g.get(), UnitResponse.class));
/*     */     }
/* 119 */     catch (Exception e) {
/* 120 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 121 */       logger.error(exceptionAsString);
/* 122 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 124 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/unit/create"})
/*     */   public ApiResponse create(@Valid @RequestBody UnitRequest request) {
/* 129 */     ApiResponse rs = new ApiResponse();
/* 130 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 132 */       MedicUnit medicUnit = this.unitRepository.findByKey(request.getKey()).orElse(null);
/* 133 */       if (Objects.nonNull(medicUnit)) {
/* 134 */         return this.apiError.getError("10");
/*     */       }
/*     */       
/* 137 */       MedicUnit localAdminUnits = (MedicUnit)this.modelMapper.map(request, MedicUnit.class);
/* 138 */       localAdminUnits.setCreatedAt(new Date());
/* 139 */       MedicUnit unitRs = (MedicUnit)this.unitRepository.saveAndFlush(localAdminUnits);
/*     */       
/* 141 */       this.cacheDataRepository.deleteById("medicUnit");
/* 142 */       saveRedisUnit();
/* 143 */       data.put("id", Integer.valueOf(unitRs.getId()));
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
/*     */   @PutMapping({"/unit/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody UnitRequest request) {
/* 159 */     ApiResponse rs = new ApiResponse();
/* 160 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 163 */       if (id == null) {
/* 164 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 167 */       Optional<MedicUnit> g = this.unitRepository.findById(id);
/* 168 */       if (!g.isPresent()) {
/* 169 */         return this.apiError.getError("02");
/*     */       }
/* 171 */       MedicUnit medicUnit = this.unitRepository.findByKey(request.getKey()).orElse(null);
/* 172 */       if (Objects.nonNull(medicUnit) && !((MedicUnit)g.get()).getKey().equals(request.getKey())) {
/* 173 */         return this.apiError.getError("10");
/*     */       }
/*     */       
/* 176 */       MedicUnit localAdminUnits = (MedicUnit)this.modelMapper.map(request, MedicUnit.class);
/* 177 */       localAdminUnits.setId(id.intValue());
/* 178 */       localAdminUnits.setCreatedAt(((MedicUnit)g.get()).getCreatedAt());
/* 179 */       localAdminUnits.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 182 */       this.unitRepository.saveAndFlush(localAdminUnits);
/*     */       
/* 184 */       this.cacheDataRepository.deleteById("medicUnit");
/* 185 */       saveRedisUnit();
/* 186 */       rs.put("status", "OK");
/* 187 */       rs.put("responseCode", "00");
/* 188 */       rs.put("data", data);
/*     */     }
/* 190 */     catch (Exception e) {
/* 191 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 192 */       logger.error(exceptionAsString);
/* 193 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 195 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/unit/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 200 */     ApiResponse rs = new ApiResponse();
/* 201 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 204 */       if (id == null) {
/* 205 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 208 */       Optional<MedicUnit> g = this.unitRepository.findById(id);
/* 209 */       if (!g.isPresent()) {
/* 210 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 214 */       this.unitRepository.delete(g.get());
/*     */       
/* 216 */       this.cacheDataRepository.deleteById("medicUnit");
/*     */       
/* 218 */       saveRedisUnit();
/* 219 */       rs.put("status", "OK");
/* 220 */       rs.put("responseCode", "00");
/* 221 */       rs.put("data", data);
/*     */     }
/* 223 */     catch (Exception e) {
/* 224 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 225 */       logger.error(exceptionAsString);
/* 226 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 228 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/unit/getAllUnit"})
/*     */   public ApiResponse getAllUnit() {
/* 234 */     ApiResponse rs = new ApiResponse();
/* 235 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 238 */       List<MedicUnit> medicUnits = new ArrayList<>();
/* 239 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("medicUnit");
/* 240 */       if (optionalCacheData.isPresent()) {
/* 241 */         String opCacheData = ((CacheData)optionalCacheData.get()).getValue();
/* 242 */         medicUnits = (List<MedicUnit>)this.objectMapper.readValue(opCacheData, new TypeReference<List<MedicUnit>>() {  }
/*     */           );
/*     */       } else {
/* 245 */         medicUnits = this.unitRepository.findAll();
/* 246 */         String medicUnitJsonString = this.objectMapper.writeValueAsString(medicUnits);
/* 247 */         CacheData cacheData = new CacheData("medicUnit", medicUnitJsonString);
/* 248 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/* 250 */       rs.put("status", "OK");
/* 251 */       rs.put("responseCode", "00");
/* 252 */       rs.put("data", medicUnits);
/*     */     }
/* 254 */     catch (Exception e) {
/* 255 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 256 */       logger.error(exceptionAsString);
/* 257 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 259 */     return rs;
/*     */   }
/*     */   
/*     */   public void saveRedisUnit() throws JsonProcessingException {
/* 263 */     List<MedicUnit> medicUnits = this.unitRepository.findAll();
/* 264 */     if (CollectionUtils.isNotEmpty(medicUnits)) {
/* 265 */       String medicUnitJsonString = this.objectMapper.writeValueAsString(medicUnits);
/* 266 */       CacheData cacheData = new CacheData("medicUnit", medicUnitJsonString);
/* 267 */       this.cacheDataRepository.save(cacheData);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\UnitController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */