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
/*     */ import nencer.app.Modules.Localization.Model.DistrictRequest;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
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
/*     */ public class DistrictController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(DistrictController.class);
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
/*     */   DistrictRepository districtRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/district"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  52 */     ApiResponse rs = new ApiResponse();
/*  53 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  56 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  57 */       if (!StringUtils.isEmpty(filter)) {
/*  58 */         ObjectMapper objectMapper = new ObjectMapper();
/*  59 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  62 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  63 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  64 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  66 */       Page<LocalDistricts> pages = this.districtRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  67 */       data.put("districts", pages.get());
/*  68 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  69 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  71 */       rs.put("status", "OK");
/*  72 */       rs.put("responseCode", "00");
/*  73 */       rs.put("data", data);
/*     */     }
/*  75 */     catch (Exception e) {
/*  76 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  77 */       logger.error(exceptionAsString);
/*  78 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  80 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/district/getByProvinceCode/{code}"})
/*     */   public ApiResponse getByCityId(@PathVariable @Valid String code) {
/*  90 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  93 */       List<LocalDistricts> citiesList = this.districtRepository.findByProvinceCode(code).orElse(new ArrayList<>());
/*     */       
/*  95 */       rs.put("status", "OK");
/*  96 */       rs.put("responseCode", "00");
/*  97 */       rs.put("data", citiesList);
/*     */     }
/*  99 */     catch (Exception e) {
/* 100 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 101 */       logger.error(exceptionAsString);
/* 102 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 104 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/district/getAll"})
/*     */   public ApiResponse getAll() {
/* 109 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 111 */       List<LocalDistricts> districtsList = this.districtRepository.findAll();
/*     */       
/* 113 */       rs.put("status", "OK");
/* 114 */       rs.put("responseCode", "00");
/* 115 */       rs.put("data", districtsList);
/*     */     }
/* 117 */     catch (Exception e) {
/* 118 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 119 */       logger.error(exceptionAsString);
/* 120 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 122 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/district/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 128 */     ApiResponse rs = new ApiResponse();
/* 129 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 132 */       if (id == null) {
/* 133 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 136 */       Optional<LocalDistricts> g = this.districtRepository.findById(id);
/* 137 */       if (!g.isPresent()) {
/* 138 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 141 */       rs.put("status", "OK");
/* 142 */       rs.put("responseCode", "00");
/* 143 */       rs.put("data", this.modelMapper.map(g.get(), DistrictResponse.class));
/*     */     }
/* 145 */     catch (Exception e) {
/* 146 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 147 */       logger.error(exceptionAsString);
/* 148 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 150 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/district/create"})
/*     */   public ApiResponse create(@Valid @RequestBody DistrictRequest request) {
/* 155 */     ApiResponse rs = new ApiResponse();
/* 156 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 158 */       LocalDistricts localDistricts = this.districtRepository.findByCode(request.getCode()).orElse(null);
/* 159 */       if (Objects.nonNull(localDistricts)) {
/* 160 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 163 */       LocalDistricts district = (LocalDistricts)this.modelMapper.map(request, LocalDistricts.class);
/* 164 */       district.setCreatedAt(new Date());
/* 165 */       LocalDistricts dis = (LocalDistricts)this.districtRepository.saveAndFlush(district);
/*     */       
/* 167 */       data.put("id", Integer.valueOf(dis.getId()));
/*     */       
/* 169 */       rs.put("status", "OK");
/* 170 */       rs.put("responseCode", "00");
/* 171 */       rs.put("data", data);
/*     */     }
/* 173 */     catch (Exception e) {
/* 174 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 175 */       logger.error(exceptionAsString);
/* 176 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 178 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/district/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody DistrictRequest request) {
/* 183 */     ApiResponse rs = new ApiResponse();
/* 184 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 187 */       if (id == null) {
/* 188 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 191 */       Optional<LocalDistricts> g = this.districtRepository.findById(id);
/* 192 */       if (!g.isPresent()) {
/* 193 */         return this.apiError.getError("02");
/*     */       }
/* 195 */       LocalDistricts localDistricts = this.districtRepository.findByCode(request.getCode()).orElse(null);
/* 196 */       if (Objects.nonNull(localDistricts) && !((LocalDistricts)g.get()).getCode().equals(request.getCode())) {
/* 197 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 200 */       LocalDistricts district = (LocalDistricts)this.modelMapper.map(request, LocalDistricts.class);
/* 201 */       district.setId(id.intValue());
/* 202 */       district.setCreatedAt(((LocalDistricts)g.get()).getCreatedAt());
/* 203 */       district.setUpdatedAt(new Date());
/*     */       
/* 205 */       this.districtRepository.saveAndFlush(district);
/*     */       
/* 207 */       rs.put("status", "OK");
/* 208 */       rs.put("responseCode", "00");
/* 209 */       rs.put("data", data);
/*     */     }
/* 211 */     catch (Exception e) {
/* 212 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 213 */       logger.error(exceptionAsString);
/* 214 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 216 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/district/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 221 */     ApiResponse rs = new ApiResponse();
/* 222 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 225 */       if (id == null) {
/* 226 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 229 */       Optional<LocalDistricts> g = this.districtRepository.findById(id);
/* 230 */       if (!g.isPresent()) {
/* 231 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 235 */       this.districtRepository.updateDistrictsStatus(id);
/*     */       
/* 237 */       rs.put("status", "OK");
/* 238 */       rs.put("responseCode", "00");
/* 239 */       rs.put("data", data);
/*     */     }
/* 241 */     catch (Exception e) {
/* 242 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 243 */       logger.error(exceptionAsString);
/* 244 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 246 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\DistrictController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */