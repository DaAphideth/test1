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
/*     */ import nencer.app.Modules.Localization.Entity.LocalDistricts;
/*     */ import nencer.app.Modules.Localization.Entity.LocalWards;
/*     */ import nencer.app.Modules.Localization.Model.WardRequest;
/*     */ import nencer.app.Modules.Localization.Model.WardShortResponse;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class WardController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(WardController.class);
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
/*     */   WardRepository wardRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ProvinceRepository provinceRepository;
/*     */   
/*     */   @Autowired
/*     */   DistrictRepository districtRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/ward"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  65 */     ApiResponse rs = new ApiResponse();
/*  66 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  69 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  70 */       if (!StringUtils.isEmpty(filter)) {
/*  71 */         ObjectMapper objectMapper = new ObjectMapper();
/*  72 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  75 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  76 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  77 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  79 */       Page<LocalWards> pages = this.districtRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  80 */       data.put("wards", pages.get());
/*  81 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  82 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  84 */       rs.put("status", "OK");
/*  85 */       rs.put("responseCode", "00");
/*  86 */       rs.put("data", data);
/*     */     }
/*  88 */     catch (Exception e) {
/*  89 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  90 */       logger.error(exceptionAsString);
/*  91 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  93 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/ward/getByDistrictCode/{code}"})
/*     */   public ApiResponse getByCityId(@PathVariable @Valid String code) {
/* 102 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 105 */       List<LocalWards> wards = this.wardRepository.findByDistrictCode(code).orElse(new ArrayList<>());
/*     */       
/* 107 */       rs.put("status", "OK");
/* 108 */       rs.put("responseCode", "00");
/* 109 */       rs.put("data", wards);
/*     */     }
/* 111 */     catch (Exception e) {
/* 112 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 113 */       logger.error(exceptionAsString);
/* 114 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 116 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/ward/getAll"})
/*     */   public ApiResponse getAll() {
/* 121 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 123 */       List<LocalWards> wardsList = this.wardRepository.findAll();
/*     */       
/* 125 */       rs.put("status", "OK");
/* 126 */       rs.put("responseCode", "00");
/* 127 */       rs.put("data", wardsList);
/*     */     }
/* 129 */     catch (Exception e) {
/* 130 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 131 */       logger.error(exceptionAsString);
/* 132 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 134 */     return rs;
/*     */   }
/*     */   @GetMapping({"/ward/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 138 */     ApiResponse rs = new ApiResponse();
/* 139 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 142 */       if (id == null) {
/* 143 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 146 */       Optional<LocalWards> g = this.wardRepository.findById(id);
/* 147 */       if (!g.isPresent()) {
/* 148 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 151 */       rs.put("status", "OK");
/* 152 */       rs.put("responseCode", "00");
/* 153 */       rs.put("data", this.modelMapper.map(g.get(), WardResponse.class));
/*     */     }
/* 155 */     catch (Exception e) {
/* 156 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 157 */       logger.error(exceptionAsString);
/* 158 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 160 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/ward/create"})
/*     */   public ApiResponse create(@Valid @RequestBody WardRequest request) {
/* 165 */     ApiResponse rs = new ApiResponse();
/* 166 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 168 */       LocalWards localWards = this.wardRepository.findByCode(request.getCode()).orElse(null);
/* 169 */       if (Objects.nonNull(localWards)) {
/* 170 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 173 */       LocalWards LocalWards = (LocalWards)this.modelMapper.map(request, LocalWards.class);
/* 174 */       LocalWards.setCreatedAt(new Date());
/* 175 */       LocalWards result = (LocalWards)this.wardRepository.saveAndFlush(LocalWards);
/*     */       
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
/*     */   @PutMapping({"/ward/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody WardRequest request) {
/* 193 */     ApiResponse rs = new ApiResponse();
/* 194 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 197 */       if (id == null) {
/* 198 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 201 */       Optional<LocalWards> g = this.wardRepository.findById(id);
/* 202 */       if (!g.isPresent()) {
/* 203 */         return this.apiError.getError("02");
/*     */       }
/* 205 */       LocalWards localWards = this.wardRepository.findByCode(request.getCode()).orElse(null);
/* 206 */       if (Objects.nonNull(localWards) && !((LocalWards)g.get()).getCode().equals(request.getCode())) {
/* 207 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 210 */       LocalWards LocalWards = (LocalWards)this.modelMapper.map(request, LocalWards.class);
/* 211 */       LocalWards.setId(id.intValue());
/* 212 */       LocalWards.setCreatedAt(((LocalWards)g.get()).getCreatedAt());
/* 213 */       LocalWards.setUpdatedAt(new Date());
/*     */       
/* 215 */       this.wardRepository.saveAndFlush(LocalWards);
/*     */       
/* 217 */       rs.put("status", "OK");
/* 218 */       rs.put("responseCode", "00");
/* 219 */       rs.put("data", data);
/*     */     }
/* 221 */     catch (Exception e) {
/* 222 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 223 */       logger.error(exceptionAsString);
/* 224 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 226 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/ward/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 231 */     ApiResponse rs = new ApiResponse();
/* 232 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 235 */       if (id == null) {
/* 236 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 239 */       Optional<LocalWards> g = this.wardRepository.findById(id);
/* 240 */       if (!g.isPresent()) {
/* 241 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 245 */       this.wardRepository.updateWardStatus(id);
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
/*     */   @GetMapping({"/ward/getByShortCode/{shortCode}"})
/*     */   public ApiResponse getByShortCode(@PathVariable @Valid String shortCode) {
/* 261 */     ApiResponse rs = new ApiResponse();
/* 262 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 265 */       if (StringUtils.isEmpty(shortCode)) {
/* 266 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 269 */       List<LocalWards> g = this.wardRepository.findAllByShortCode(shortCode).orElse(null);
/* 270 */       if (g.isEmpty() || g.size() <= 0) {
/* 271 */         return this.apiError.getError("02");
/*     */       }
/* 273 */       WardShortResponse wardResponse = new WardShortResponse();
/*     */       
/* 275 */       wardResponse.setWardCode(((LocalWards)g.get(0)).getCode());
/* 276 */       LocalWards localWards = g.get(0);
/* 277 */       wardResponse.setDistrictCode(localWards.getDistrictCode());
/* 278 */       Optional<LocalDistricts> localProvinces = this.districtRepository.findByCode(localWards.getDistrictCode());
/* 279 */       if (localProvinces.isPresent()) {
/* 280 */         wardResponse.setProvinceCode(((LocalDistricts)localProvinces.get()).getProvinceCode());
/*     */       }
/*     */       
/* 283 */       rs.put("status", "OK");
/* 284 */       rs.put("responseCode", "00");
/* 285 */       rs.put("data", wardResponse);
/*     */     }
/* 287 */     catch (Exception e) {
/* 288 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 289 */       logger.error(exceptionAsString);
/* 290 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 292 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\WardController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */