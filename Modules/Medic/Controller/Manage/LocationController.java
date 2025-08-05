/*     */ package nencer.app.Modules.Medic.Controller.Manage;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Location.MedicLocations;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Location.LocationRequest;
/*     */ import nencer.app.Modules.Medic.Model.Location.LocationResponse;
/*     */ import nencer.app.Modules.Medic.Repository.LocationRepository;
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
/*     */ public class LocationController {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(LocationController.class);
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
/*     */   LocationRepository locationRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_location"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  53 */     ApiResponse rs = new ApiResponse();
/*  54 */     Map<String, Object> data = new HashMap<>();
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
/*  66 */       Page<MedicLocations> pages = this.locationRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  67 */       data.put("medicProduct", pages.get());
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
/*     */   @GetMapping({"/medic_location/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  86 */     ApiResponse rs = new ApiResponse();
/*  87 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  90 */       if (id == null) {
/*  91 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  94 */       Optional<MedicLocations> g = this.locationRepository.findById(id);
/*  95 */       if (!g.isPresent()) {
/*  96 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  99 */       rs.put("status", "OK");
/* 100 */       rs.put("responseCode", "00");
/* 101 */       rs.put("data", this.modelMapper.map(g.get(), LocationResponse.class));
/*     */     }
/* 103 */     catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_location/create"})
/*     */   public ApiResponse create(@Valid @RequestBody LocationRequest request) {
/* 113 */     ApiResponse rs = new ApiResponse();
/* 114 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 117 */       MedicLocations MedicLocations = (MedicLocations)this.modelMapper.map(request, MedicLocations.class);
/* 118 */       MedicLocations.setCreatedAt(new Date());
/* 119 */       MedicLocations result = (MedicLocations)this.locationRepository.saveAndFlush(MedicLocations);
/*     */       
/* 121 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 123 */       rs.put("status", "OK");
/* 124 */       rs.put("responseCode", "00");
/* 125 */       rs.put("data", data);
/*     */     }
/* 127 */     catch (Exception e) {
/* 128 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 129 */       logger.error(exceptionAsString);
/* 130 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 132 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_location/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody LocationRequest request) {
/* 137 */     ApiResponse rs = new ApiResponse();
/* 138 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 141 */       if (id == null) {
/* 142 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 145 */       Optional<MedicLocations> g = this.locationRepository.findById(id);
/* 146 */       if (!g.isPresent()) {
/* 147 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 150 */       MedicLocations MedicLocations = (MedicLocations)this.modelMapper.map(request, MedicLocations.class);
/* 151 */       MedicLocations.setId(id.intValue());
/* 152 */       MedicLocations.setCreatedAt(((MedicLocations)g.get()).getCreatedAt());
/* 153 */       MedicLocations.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 156 */       this.locationRepository.saveAndFlush(MedicLocations);
/*     */       
/* 158 */       rs.put("status", "OK");
/* 159 */       rs.put("responseCode", "00");
/* 160 */       rs.put("data", data);
/*     */     }
/* 162 */     catch (Exception e) {
/* 163 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 164 */       logger.error(exceptionAsString);
/* 165 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 167 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_location/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 172 */     ApiResponse rs = new ApiResponse();
/* 173 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 176 */       if (id == null) {
/* 177 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 180 */       Optional<MedicLocations> g = this.locationRepository.findById(id);
/* 181 */       if (!g.isPresent()) {
/* 182 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 186 */       this.locationRepository.delete(g.get());
/*     */       
/* 188 */       rs.put("status", "OK");
/* 189 */       rs.put("responseCode", "00");
/* 190 */       rs.put("data", data);
/*     */     }
/* 192 */     catch (Exception e) {
/* 193 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 194 */       logger.error(exceptionAsString);
/* 195 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 197 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_location/getAll"})
/*     */   public ApiResponse getAll() {
/* 201 */     ApiResponse rs = new ApiResponse();
/* 202 */     Map<String, Object> data = new HashMap<>();
/*     */ 
/*     */     
/*     */     try {
/* 206 */       List<MedicLocations> medicRoomsList = this.locationRepository.findAll();
/*     */ 
/*     */       
/* 209 */       rs.put("status", "OK");
/* 210 */       rs.put("responseCode", "00");
/* 211 */       rs.put("data", medicRoomsList);
/*     */     }
/* 213 */     catch (Exception e) {
/* 214 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 215 */       logger.error(exceptionAsString);
/* 216 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 218 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Manage\LocationController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */