/*     */ package nencer.app.Modules.Medic.Controller.Service;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceGroupRequest;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceGroupResponse;
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
/*     */ public class ServiceGroupController extends BaseMedicController {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(ServiceGroupController.class);
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
/*     */   ServiceGroupRepository serviceGroupRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service_group"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
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
/*  66 */       Page<MedicServiceGroups> pages = this.serviceGroupRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  67 */       data.put("serviceGroups", pages.getContent());
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
/*     */   @GetMapping({"/medic_service_group/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  86 */     ApiResponse rs = new ApiResponse();
/*  87 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  90 */       if (id == null) {
/*  91 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  94 */       Optional<MedicServiceGroups> g = this.serviceGroupRepository.findById(id);
/*  95 */       if (!g.isPresent()) {
/*  96 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  99 */       rs.put("status", "OK");
/* 100 */       rs.put("responseCode", "00");
/* 101 */       rs.put("data", this.modelMapper.map(g.get(), ServiceGroupResponse.class));
/*     */     }
/* 103 */     catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_service_group/create"})
/*     */   public ApiResponse create(@Valid @RequestBody ServiceGroupRequest request) {
/* 113 */     ApiResponse rs = new ApiResponse();
/* 114 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 117 */       MedicServiceGroups MedicServiceGroups = (MedicServiceGroups)this.modelMapper.map(request, MedicServiceGroups.class);
/* 118 */       MedicServiceGroups.setCreatedAt(new Date());
/* 119 */       MedicServiceGroups result = (MedicServiceGroups)this.serviceGroupRepository.saveAndFlush(MedicServiceGroups);
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
/*     */   @PutMapping({"/medic_service_group/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody ServiceGroupRequest request) {
/* 137 */     ApiResponse rs = new ApiResponse();
/* 138 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 141 */       if (id == null) {
/* 142 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 145 */       Optional<MedicServiceGroups> g = this.serviceGroupRepository.findById(id);
/* 146 */       if (!g.isPresent()) {
/* 147 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 150 */       MedicServiceGroups MedicServiceGroups = (MedicServiceGroups)this.modelMapper.map(request, MedicServiceGroups.class);
/* 151 */       MedicServiceGroups.setId(id.intValue());
/* 152 */       MedicServiceGroups.setCreatedAt(((MedicServiceGroups)g.get()).getCreatedAt());
/* 153 */       MedicServiceGroups.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 156 */       this.serviceGroupRepository.saveAndFlush(MedicServiceGroups);
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
/*     */   
/*     */   @PutMapping({"/medic_service_group/changeStatus/{id}"})
/*     */   public ApiResponse changeStatus(@PathVariable @Valid Integer id) {
/* 173 */     ApiResponse rs = new ApiResponse();
/* 174 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 177 */       if (id == null) {
/* 178 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 181 */       Optional<MedicServiceGroups> g = this.serviceGroupRepository.findById(id);
/* 182 */       if (!g.isPresent()) {
/* 183 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 186 */       MedicServiceGroups medicServiceGroups = g.get();
/*     */ 
/*     */       
/* 189 */       Integer used = this.serviceRepository.findUsedServiceGroup(Integer.valueOf(medicServiceGroups.getId()));
/* 190 */       if (used.intValue() > 0) {
/* 191 */         return this.apiError.getError("205");
/*     */       }
/*     */       
/* 194 */       medicServiceGroups.setStatus(Integer.valueOf((medicServiceGroups.getStatus().intValue() != 1) ? 1 : 0));
/* 195 */       medicServiceGroups.setId(id.intValue());
/*     */ 
/*     */       
/* 198 */       this.serviceGroupRepository.saveAndFlush(medicServiceGroups);
/*     */       
/* 200 */       rs.put("status", "OK");
/* 201 */       rs.put("responseCode", "00");
/* 202 */       rs.put("data", data);
/*     */     }
/* 204 */     catch (Exception e) {
/* 205 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 206 */       logger.error(exceptionAsString);
/* 207 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 209 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_service_group/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 214 */     ApiResponse rs = new ApiResponse();
/* 215 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 218 */       if (id == null) {
/* 219 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 222 */       Optional<MedicServiceGroups> g = this.serviceGroupRepository.findById(id);
/* 223 */       if (!g.isPresent()) {
/* 224 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 228 */       this.serviceGroupRepository.delete(g.get());
/*     */       
/* 230 */       rs.put("status", "OK");
/* 231 */       rs.put("responseCode", "00");
/* 232 */       rs.put("data", data);
/*     */     }
/* 234 */     catch (Exception e) {
/* 235 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 236 */       logger.error(exceptionAsString);
/* 237 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 239 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service_group/getAll"})
/*     */   public ApiResponse getAll() {
/* 249 */     ApiResponse rs = new ApiResponse();
/* 250 */     Map<String, Object> data = new HashMap<>();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 255 */       List<MedicServiceGroups> medicRoomsList = this.serviceGroupRepository.findAlllByStatusOrderBySort(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       
/* 257 */       rs.put("status", "OK");
/* 258 */       rs.put("responseCode", "00");
/* 259 */       rs.put("data", medicRoomsList);
/*     */     }
/* 261 */     catch (Exception e) {
/* 262 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 263 */       logger.error(exceptionAsString);
/* 264 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 266 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Service\ServiceGroupController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */