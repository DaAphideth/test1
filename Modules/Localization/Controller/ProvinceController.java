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
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Localization.Entity.LocalProvinces;
/*     */ import nencer.app.Modules.Localization.Model.CountryResponse;
/*     */ import nencer.app.Modules.Localization.Model.ProvinceRequest;
/*     */ import nencer.app.Modules.Localization.Model.ProvinceResponse;
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
/*     */ public class ProvinceController {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);
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
/*     */   ProvinceRepository provinceRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/province"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  56 */     ApiResponse rs = new ApiResponse();
/*  57 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  60 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  61 */       if (!StringUtils.isEmpty(filter)) {
/*  62 */         ObjectMapper objectMapper = new ObjectMapper();
/*  63 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  66 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  67 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  68 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  70 */       Page<LocalProvinces> pages = this.provinceRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  71 */       data.put("provinces", pages.get());
/*  72 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  73 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  75 */       rs.put("status", "OK");
/*  76 */       rs.put("responseCode", "00");
/*  77 */       rs.put("data", data);
/*     */     }
/*  79 */     catch (Exception e) {
/*  80 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  81 */       logger.error(exceptionAsString);
/*  82 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  84 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/province/getAll"})
/*     */   public ApiResponse getAll() {
/*  94 */     ApiResponse rs = new ApiResponse();
/*  95 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  97 */       List<LocalProvinces> provinces = this.provinceRepository.findAll();
/*  98 */       data.put("cities", provinces.stream()
/*  99 */           .filter(f -> (f.getStatus().intValue() == 1L))
/* 100 */           .sorted(Comparator.comparing(LocalProvinces::getFeatured).reversed())
/* 101 */           .map(Country -> (CountryResponse)this.modelMapper.map(Country, CountryResponse.class)).collect(Collectors.toList()));
/*     */       
/* 103 */       rs.put("status", "OK");
/* 104 */       rs.put("responseCode", "00");
/* 105 */       rs.put("data", data);
/*     */     }
/* 107 */     catch (Exception e) {
/* 108 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 109 */       logger.error(exceptionAsString);
/* 110 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 112 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/province/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 118 */     ApiResponse rs = new ApiResponse();
/* 119 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 122 */       if (id == null) {
/* 123 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 126 */       Optional<LocalProvinces> g = this.provinceRepository.findById(id);
/* 127 */       if (!g.isPresent()) {
/* 128 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 131 */       rs.put("status", "OK");
/* 132 */       rs.put("responseCode", "00");
/* 133 */       rs.put("data", this.modelMapper.map(g.get(), ProvinceResponse.class));
/*     */     }
/* 135 */     catch (Exception e) {
/* 136 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 137 */       logger.error(exceptionAsString);
/* 138 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 140 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/province/create"})
/*     */   public ApiResponse create(@Valid @RequestBody ProvinceRequest request) {
/* 145 */     ApiResponse rs = new ApiResponse();
/* 146 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 148 */       LocalProvinces localProvinces = this.provinceRepository.findByCode(request.getCode()).orElse(null);
/* 149 */       if (Objects.nonNull(localProvinces)) {
/* 150 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 153 */       LocalProvinces localAdminProvinces = (LocalProvinces)this.modelMapper.map(request, LocalProvinces.class);
/* 154 */       localAdminProvinces.setFeatured(Integer.valueOf(0));
/* 155 */       localAdminProvinces.setCreatedAt(new Date());
/* 156 */       LocalProvinces result = (LocalProvinces)this.provinceRepository.saveAndFlush(localAdminProvinces);
/*     */       
/* 158 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 160 */       rs.put("status", "OK");
/* 161 */       rs.put("responseCode", "00");
/* 162 */       rs.put("data", data);
/*     */     }
/* 164 */     catch (Exception e) {
/* 165 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 166 */       logger.error(exceptionAsString);
/* 167 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 169 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/province/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody ProvinceRequest request) {
/* 174 */     ApiResponse rs = new ApiResponse();
/* 175 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 178 */       if (id == null) {
/* 179 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 182 */       Optional<LocalProvinces> g = this.provinceRepository.findById(id);
/* 183 */       if (!g.isPresent()) {
/* 184 */         return this.apiError.getError("02");
/*     */       }
/* 186 */       LocalProvinces localProvinces = this.provinceRepository.findByCode(request.getCode()).orElse(null);
/* 187 */       if (Objects.nonNull(localProvinces) && !((LocalProvinces)g.get()).getCode().equals(request.getCode())) {
/* 188 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 191 */       LocalProvinces localAdminProvinces = (LocalProvinces)this.modelMapper.map(request, LocalProvinces.class);
/* 192 */       localAdminProvinces.setId(id.intValue());
/* 193 */       localAdminProvinces.setFeatured(Integer.valueOf(0));
/* 194 */       localAdminProvinces.setCreatedAt(((LocalProvinces)g.get()).getCreatedAt());
/* 195 */       localAdminProvinces.setUpdatedAt(new Date());
/*     */       
/* 197 */       this.provinceRepository.saveAndFlush(localAdminProvinces);
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
/*     */   @DeleteMapping({"/province/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 213 */     ApiResponse rs = new ApiResponse();
/* 214 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 217 */       if (id == null) {
/* 218 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 221 */       Optional<LocalProvinces> g = this.provinceRepository.findById(id);
/* 222 */       if (!g.isPresent()) {
/* 223 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 227 */       this.provinceRepository.updateProvincesStatus(id);
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


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\ProvinceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */