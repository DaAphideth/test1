/*     */ package nencer.app.Modules.Localization.Controller;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Localization.Entity.LocalRegions;
/*     */ import nencer.app.Modules.Localization.Model.RegionRequest;
/*     */ import nencer.app.Modules.Localization.Model.RegionResponse;
/*     */ import nencer.app.Modules.Localization.Repository.RegionRepository;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*     */ public class RegionController {
/*  36 */   public static final Logger logger = LoggerFactory.getLogger(RegionController.class);
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
/*     */   RegionRepository regionRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/region"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  54 */     ApiResponse rs = new ApiResponse();
/*  55 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  58 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  59 */       if (!StringUtils.isEmpty(filter)) {
/*  60 */         ObjectMapper objectMapper = new ObjectMapper();
/*  61 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  64 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  65 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  66 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  68 */       Page<LocalRegions> pages = this.regionRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  69 */       data.put("regions", pages.get());
/*  70 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  71 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  73 */       rs.put("status", "OK");
/*  74 */       rs.put("responseCode", "00");
/*  75 */       rs.put("data", data);
/*     */     }
/*  77 */     catch (Exception e) {
/*  78 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  79 */       logger.error(exceptionAsString);
/*  80 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  82 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/region/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  88 */     ApiResponse rs = new ApiResponse();
/*  89 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  92 */       if (id == null) {
/*  93 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  96 */       Optional<LocalRegions> g = this.regionRepository.findById(id);
/*  97 */       if (!g.isPresent()) {
/*  98 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 101 */       rs.put("status", "OK");
/* 102 */       rs.put("responseCode", "00");
/* 103 */       rs.put("data", this.modelMapper.map(g.get(), RegionResponse.class));
/*     */     }
/* 105 */     catch (Exception e) {
/* 106 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 107 */       logger.error(exceptionAsString);
/* 108 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 110 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/region/create"})
/*     */   public ApiResponse create(@Valid @RequestBody RegionRequest request) {
/* 115 */     ApiResponse rs = new ApiResponse();
/* 116 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 119 */       LocalRegions LocalRegions = (LocalRegions)this.modelMapper.map(request, LocalRegions.class);
/* 120 */       LocalRegions.setCreatedAt(new Date());
/* 121 */       LocalRegions result = (LocalRegions)this.regionRepository.saveAndFlush(LocalRegions);
/*     */       
/* 123 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 125 */       rs.put("status", "OK");
/* 126 */       rs.put("responseCode", "00");
/* 127 */       rs.put("data", data);
/*     */     }
/* 129 */     catch (Exception e) {
/* 130 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 131 */       logger.error(exceptionAsString);
/* 132 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 134 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/region/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody RegionRequest request) {
/* 139 */     ApiResponse rs = new ApiResponse();
/* 140 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 143 */       if (id == null) {
/* 144 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 147 */       Optional<LocalRegions> g = this.regionRepository.findById(id);
/* 148 */       if (!g.isPresent()) {
/* 149 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 152 */       LocalRegions LocalRegions = (LocalRegions)this.modelMapper.map(request, LocalRegions.class);
/* 153 */       LocalRegions.setId(id.intValue());
/* 154 */       LocalRegions.setCreatedAt(((LocalRegions)g.get()).getCreatedAt());
/* 155 */       LocalRegions.setUpdatedAt(new Date());
/*     */       
/* 157 */       this.regionRepository.saveAndFlush(LocalRegions);
/*     */       
/* 159 */       rs.put("status", "OK");
/* 160 */       rs.put("responseCode", "00");
/* 161 */       rs.put("data", data);
/*     */     }
/* 163 */     catch (Exception e) {
/* 164 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 165 */       logger.error(exceptionAsString);
/* 166 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 168 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/region/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 173 */     ApiResponse rs = new ApiResponse();
/* 174 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 177 */       if (id == null) {
/* 178 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 181 */       Optional<LocalRegions> g = this.regionRepository.findById(id);
/* 182 */       if (!g.isPresent()) {
/* 183 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 187 */       this.regionRepository.updateRegionsStatus(id);
/*     */       
/* 189 */       rs.put("status", "OK");
/* 190 */       rs.put("responseCode", "00");
/* 191 */       rs.put("data", data);
/*     */     }
/* 193 */     catch (Exception e) {
/* 194 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 195 */       logger.error(exceptionAsString);
/* 196 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 198 */     return rs;
/*     */   }
/*     */   @GetMapping({"/region/getAll"})
/*     */   public ApiResponse getAll() {
/* 202 */     ApiResponse rs = new ApiResponse();
/* 203 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 205 */       List<LocalRegions> provinces = this.regionRepository.findAll();
/*     */ 
/*     */       
/* 208 */       rs.put("status", "OK");
/* 209 */       rs.put("responseCode", "00");
/* 210 */       rs.put("data", provinces);
/*     */     }
/* 212 */     catch (Exception e) {
/* 213 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 214 */       logger.error(exceptionAsString);
/* 215 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 217 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\RegionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */