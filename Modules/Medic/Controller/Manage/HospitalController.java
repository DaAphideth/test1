/*     */ package nencer.app.Modules.Medic.Controller.Manage;
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
/*     */ import nencer.app.Modules.Medic.Entity.Hospital.MedicHospitals;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Hospital.HospitalRequest;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class HospitalController {
/*  31 */   public static final Logger logger = LoggerFactory.getLogger(HospitalController.class);
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
/*     */   HospitalRepository hospitalRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_hospital"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  49 */     ApiResponse rs = new ApiResponse();
/*  50 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  52 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  53 */       if (!StringUtils.isEmpty(filter)) {
/*  54 */         ObjectMapper objectMapper = new ObjectMapper();
/*  55 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  58 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  59 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  60 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  62 */       Page<MedicHospitals> pages = this.hospitalRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  63 */       data.put("medicHospital", pages.get());
/*  64 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  65 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  67 */       rs.put("status", "OK");
/*  68 */       rs.put("responseCode", "00");
/*  69 */       rs.put("data", data);
/*     */     }
/*  71 */     catch (Exception e) {
/*  72 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  73 */       logger.error(exceptionAsString);
/*  74 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  76 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_hospital/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  82 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  85 */       if (id == null) {
/*  86 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  89 */       Optional<MedicHospitals> g = this.hospitalRepository.findById(id);
/*  90 */       if (!g.isPresent()) {
/*  91 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  94 */       rs.put("status", "OK");
/*  95 */       rs.put("responseCode", "00");
/*  96 */       rs.put("data", g.get());
/*     */     }
/*  98 */     catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       logger.error(exceptionAsString);
/* 101 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 103 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_hospital/create"})
/*     */   public ApiResponse create(@Valid @RequestBody HospitalRequest request) {
/* 108 */     ApiResponse rs = new ApiResponse();
/* 109 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 111 */       MedicHospitals hospitals = this.hospitalRepository.findByCode(request.getCode()).orElse(null);
/* 112 */       if (Objects.nonNull(hospitals)) {
/* 113 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 116 */       MedicHospitals MedicHospitals = (MedicHospitals)this.modelMapper.map(request, MedicHospitals.class);
/* 117 */       MedicHospitals.setCreatedAt(new Date());
/* 118 */       MedicHospitals result = (MedicHospitals)this.hospitalRepository.saveAndFlush(MedicHospitals);
/*     */       
/* 120 */       data.put("id", result.getId());
/*     */       
/* 122 */       rs.put("status", "OK");
/* 123 */       rs.put("responseCode", "00");
/* 124 */       rs.put("data", data);
/*     */     }
/* 126 */     catch (Exception e) {
/* 127 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 128 */       logger.error(exceptionAsString);
/* 129 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 131 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_hospital/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody HospitalRequest request) {
/* 136 */     ApiResponse rs = new ApiResponse();
/* 137 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 140 */       if (id == null) {
/* 141 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 144 */       Optional<MedicHospitals> g = this.hospitalRepository.findById(id);
/* 145 */       if (!g.isPresent()) {
/* 146 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 149 */       MedicHospitals hospitals = this.hospitalRepository.findByCode(request.getCode()).orElse(null);
/* 150 */       if (Objects.nonNull(hospitals) && !((MedicHospitals)g.get()).getCode().equalsIgnoreCase(request.getCode())) {
/* 151 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 154 */       MedicHospitals MedicHospitals = (MedicHospitals)this.modelMapper.map(request, MedicHospitals.class);
/* 155 */       MedicHospitals.setId(id);
/* 156 */       MedicHospitals.setCreatedAt(((MedicHospitals)g.get()).getCreatedAt());
/* 157 */       MedicHospitals.setUpdatedAt(new Date());
/*     */       
/* 159 */       this.hospitalRepository.saveAndFlush(MedicHospitals);
/*     */       
/* 161 */       rs.put("status", "OK");
/* 162 */       rs.put("responseCode", "00");
/* 163 */       rs.put("data", data);
/*     */     }
/* 165 */     catch (Exception e) {
/* 166 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 167 */       logger.error(exceptionAsString);
/* 168 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 170 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_hospital/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 175 */     ApiResponse rs = new ApiResponse();
/* 176 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 179 */       if (id == null) {
/* 180 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 183 */       Optional<MedicHospitals> g = this.hospitalRepository.findById(id);
/* 184 */       if (!g.isPresent()) {
/* 185 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 189 */       this.hospitalRepository.delete(g.get());
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
/*     */   @GetMapping({"/medic_hospital/getAll"})
/*     */   public ApiResponse getAll() {
/* 205 */     ApiResponse rs = new ApiResponse();
/* 206 */     Map<String, Object> data = new HashMap<>();
/*     */ 
/*     */     
/*     */     try {
/* 210 */       List<MedicHospitals> medicRoomsList = this.hospitalRepository.findAll();
/*     */ 
/*     */       
/* 213 */       rs.put("status", "OK");
/* 214 */       rs.put("responseCode", "00");
/* 215 */       rs.put("data", medicRoomsList);
/*     */     }
/* 217 */     catch (Exception e) {
/* 218 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 219 */       logger.error(exceptionAsString);
/* 220 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 222 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_hospital/get_hospital_moved_to"})
/*     */   public ApiResponse hospitalMovedTo(@RequestParam @Valid String value) {
/* 227 */     ApiResponse rs = new ApiResponse();
/* 228 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 230 */       List<MedicHospitals> medicRoomsList = new ArrayList<>();
/*     */       
/* 232 */       if (Strings.isEmpty(value)) {
/* 233 */         medicRoomsList = this.hospitalRepository.findAll();
/*     */       } else {
/* 235 */         medicRoomsList = this.hospitalRepository.findByValue(value).orElse(new ArrayList<>());
/*     */       } 
/*     */       
/* 238 */       rs.put("status", "OK");
/* 239 */       rs.put("responseCode", "00");
/* 240 */       rs.put("data", medicRoomsList);
/*     */     }
/* 242 */     catch (Exception e) {
/* 243 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 244 */       logger.error(exceptionAsString);
/* 245 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 247 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Manage\HospitalController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */