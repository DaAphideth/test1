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
/*     */ import nencer.app.Modules.Localization.Entity.LocalCountries;
/*     */ import nencer.app.Modules.Localization.Model.CountryRequest;
/*     */ import nencer.app.Modules.Localization.Model.CountryResponse;
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
/*     */ public class CountryController {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(CountryController.class);
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
/*     */   CountryRepository countryRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/country"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  53 */     ApiResponse rs = new ApiResponse();
/*  54 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  57 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  58 */       if (!StringUtils.isEmpty(filter)) {
/*  59 */         ObjectMapper objectMapper = new ObjectMapper();
/*  60 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  63 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  64 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  65 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  67 */       Page<LocalCountries> pages = this.countryRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  68 */       data.put("countries", pages.get());
/*  69 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  70 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  72 */       rs.put("status", "OK");
/*  73 */       rs.put("responseCode", "00");
/*  74 */       rs.put("data", data);
/*     */     }
/*  76 */     catch (Exception e) {
/*  77 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  78 */       logger.error(exceptionAsString);
/*  79 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  81 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/country/getAll"})
/*     */   public ApiResponse getAll() {
/*  91 */     ApiResponse rs = new ApiResponse();
/*  92 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  94 */       List<LocalCountries> countriesList = this.countryRepository.findAll();
/*  95 */       data.put("countries", countriesList.stream()
/*  96 */           .filter(f -> (f.getStatus().intValue() == 1L))
/*  97 */           .sorted(Comparator.comparing(LocalCountries::getFeatured).reversed())
/*  98 */           .map(Country -> (CountryResponse)this.modelMapper.map(Country, CountryResponse.class)).collect(Collectors.toList()));
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
/*     */   
/*     */   @GetMapping({"/country/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 115 */     ApiResponse rs = new ApiResponse();
/* 116 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 119 */       if (id == null) {
/* 120 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 123 */       Optional<LocalCountries> g = this.countryRepository.findById(id);
/* 124 */       if (!g.isPresent()) {
/* 125 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 128 */       rs.put("status", "OK");
/* 129 */       rs.put("responseCode", "00");
/* 130 */       rs.put("data", this.modelMapper.map(g.get(), CountryResponse.class));
/*     */     }
/* 132 */     catch (Exception e) {
/* 133 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 134 */       logger.error(exceptionAsString);
/* 135 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 137 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/country/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CountryRequest request) {
/* 142 */     ApiResponse rs = new ApiResponse();
/* 143 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 145 */       LocalCountries localCountries = this.countryRepository.findByCode(request.getCode()).orElse(null);
/* 146 */       if (Objects.nonNull(localCountries)) {
/* 147 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 150 */       LocalCountries country = (LocalCountries)this.modelMapper.map(request, LocalCountries.class);
/* 151 */       country.setFeatured(0);
/* 152 */       country.setCreatedAt(new Date());
/* 153 */       LocalCountries countryRs = (LocalCountries)this.countryRepository.saveAndFlush(country);
/*     */       
/* 155 */       data.put("id", Integer.valueOf(countryRs.getId()));
/*     */       
/* 157 */       rs.put("status", "OK");
/* 158 */       rs.put("responseCode", "00");
/* 159 */       rs.put("data", data);
/*     */     }
/* 161 */     catch (Exception e) {
/* 162 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 163 */       logger.error(exceptionAsString);
/* 164 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 166 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/country/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody CountryRequest request) {
/* 171 */     ApiResponse rs = new ApiResponse();
/* 172 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 175 */       if (id == null) {
/* 176 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 179 */       Optional<LocalCountries> g = this.countryRepository.findById(id);
/* 180 */       if (!g.isPresent()) {
/* 181 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 184 */       LocalCountries localCountries = this.countryRepository.findByCode(request.getCode()).orElse(null);
/* 185 */       if (Objects.nonNull(localCountries) && !((LocalCountries)g.get()).getCode().equals(request.getCode())) {
/* 186 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 189 */       LocalCountries country = (LocalCountries)this.modelMapper.map(request, LocalCountries.class);
/* 190 */       country.setId(id.intValue());
/* 191 */       country.setFeatured(0);
/* 192 */       country.setCreatedAt(((LocalCountries)g.get()).getCreatedAt());
/* 193 */       country.setUpdatedAt(new Date());
/*     */       
/* 195 */       this.countryRepository.saveAndFlush(country);
/*     */       
/* 197 */       rs.put("status", "OK");
/* 198 */       rs.put("responseCode", "00");
/* 199 */       rs.put("data", data);
/*     */     }
/* 201 */     catch (Exception e) {
/* 202 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 203 */       logger.error(exceptionAsString);
/* 204 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 206 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/country/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 211 */     ApiResponse rs = new ApiResponse();
/* 212 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 215 */       if (id == null) {
/* 216 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 219 */       Optional<LocalCountries> g = this.countryRepository.findById(id);
/* 220 */       if (!g.isPresent()) {
/* 221 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 225 */       this.countryRepository.updateCountriesStatus(id);
/*     */       
/* 227 */       rs.put("status", "OK");
/* 228 */       rs.put("responseCode", "00");
/* 229 */       rs.put("data", data);
/*     */     }
/* 231 */     catch (Exception e) {
/* 232 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 233 */       logger.error(exceptionAsString);
/* 234 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 236 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Controller\CountryController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */