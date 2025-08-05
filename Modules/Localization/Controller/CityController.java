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
/*     */ import nencer.app.Modules.Localization.Entity.LocalCities;
/*     */ import nencer.app.Modules.Localization.Model.CityRequest;
/*     */ import nencer.app.Modules.Localization.Model.CityResponse;
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
/*     */ public class CityController {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(CityController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   CityRepository cityRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   DistrictRepository districtRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/city"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  55 */     ApiResponse rs = new ApiResponse();
/*  56 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  59 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  60 */       if (!StringUtils.isEmpty(filter)) {
/*  61 */         ObjectMapper objectMapper = new ObjectMapper();
/*  62 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  65 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  66 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  67 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  69 */       Page<LocalCities> pages = this.cityRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  70 */       data.put("cities", pages.getContent());
/*  71 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  72 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
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
/*     */   
/*     */   @GetMapping({"/city/getAll"})
/*     */   public ApiResponse getAll() {
/*  93 */     ApiResponse rs = new ApiResponse();
/*  94 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  96 */       List<LocalCities> cities = this.cityRepository.findAll();
/*  97 */       data.put("cities", cities.stream()
/*  98 */           .filter(f -> (f.getStatus().intValue() == 1L))
/*  99 */           .sorted(Comparator.comparing(LocalCities::getSort))
/* 100 */           .map(Country -> (CityResponse)this.modelMapper.map(Country, CityResponse.class)).collect(Collectors.toList()));
/*     */       
/* 102 */       rs.put("status", "OK");
/* 103 */       rs.put("responseCode", "00");
/* 104 */       rs.put("data", data);
/*     */     }
/* 106 */     catch (Exception e) {
/* 107 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 108 */       logger.error(exceptionAsString);
/* 109 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 111 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/city/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 117 */     ApiResponse rs = new ApiResponse();
/* 118 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 121 */       if (id == null) {
/* 122 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 125 */       Optional<LocalCities> g = this.cityRepository.findById(id);
/* 126 */       if (!g.isPresent()) {
/* 127 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 130 */       rs.put("status", "OK");
/* 131 */       rs.put("responseCode", "00");
/* 132 */       rs.put("data", this.modelMapper.map(g.get(), CityResponse.class));
/*     */     }
/* 134 */     catch (Exception e) {
/* 135 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 136 */       logger.error(exceptionAsString);
/* 137 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 139 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/city/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CityRequest request) {
/* 144 */     ApiResponse rs = new ApiResponse();
/* 145 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 147 */       LocalCities localCities = this.cityRepository.findByCode(request.getCode()).orElse(null);
/* 148 */       if (Objects.nonNull(localCities)) {
/* 149 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 152 */       LocalCities city = (LocalCities)this.modelMapper.map(request, LocalCities.class);
/* 153 */       city.setCreatedAt(new Date());
/* 154 */       city.setFeatured(0);
/* 155 */       LocalCities cityRs = (LocalCities)this.cityRepository.saveAndFlush(city);
/*     */       
/* 157 */       data.put("id", Integer.valueOf(cityRs.getId()));
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
/*     */   @PutMapping({"/city/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody CityRequest request) {
/* 173 */     ApiResponse rs = new ApiResponse();
/* 174 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 177 */       if (id == null) {
/* 178 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 181 */       Optional<LocalCities> g = this.cityRepository.findById(id);
/* 182 */       if (!g.isPresent()) {
/* 183 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 186 */       LocalCities localCities = this.cityRepository.findByCode(request.getCode()).orElse(null);
/* 187 */       if (Objects.nonNull(localCities) && !((LocalCities)g.get()).getCode().equals(request.getCode())) {
/* 188 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 191 */       LocalCities city = (LocalCities)this.modelMapper.map(request, LocalCities.class);
/* 192 */       city.setId(id.intValue());
/* 193 */       city.setFeatured(0);
/* 194 */       city.setCreatedAt(((LocalCities)g.get()).getCreatedAt());
/* 195 */       city.setUpdatedAt(new Date());
/*     */       
/* 197 */       this.cityRepository.saveAndFlush(city);
/*     */       
/* 199 */       rs.put("status", "OK");
/* 200 */       rs.put("responseCode", "00");
/* 201 */       rs.put("data", data);
/*     */     }
/* 203 */     catch (Exception e) {
/* 204 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 205 */       logger.error(exceptionAsString);
/* 206 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 208 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/city/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 213 */     ApiResponse rs = new ApiResponse();
/* 214 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 217 */       if (id == null) {
/* 218 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 221 */       Optional<LocalCities> g = this.cityRepository.findById(id);
/* 222 */       if (!g.isPresent()) {
/* 223 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 227 */       this.cityRepository.updateCityStatus(id);
/*     */       
/* 229 */       rs.put("status", "OK");
/* 230 */       rs.put("responseCode", "00");
/* 231 */       rs.put("data", data);
/*     */     }
/* 233 */     catch (Exception e) {
/* 234 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 235 */       logger.error(exceptionAsString);
/* 236 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 238 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\CityController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */