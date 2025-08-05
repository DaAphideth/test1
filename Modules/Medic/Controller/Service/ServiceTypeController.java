/*     */ package nencer.app.Modules.Medic.Controller.Service;
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
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceTypes;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceTypeRequest;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
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
/*     */ public class ServiceTypeController {
/*  39 */   public static final Logger logger = LoggerFactory.getLogger(ServiceTypeController.class);
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
/*     */   ServiceTypeRepository serviceTypeRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ServiceRepository serviceRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service_type"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "asc", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  60 */     ApiResponse rs = new ApiResponse();
/*  61 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  63 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  64 */       if (!StringUtils.isEmpty(filter)) {
/*  65 */         ObjectMapper objectMapper = new ObjectMapper();
/*  66 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  69 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  70 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  71 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  73 */       Page<MedicServiceTypes> pages = this.serviceTypeRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  74 */       data.put("medicProduct", pages.get());
/*  75 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  76 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  78 */       rs.put("status", "OK");
/*  79 */       rs.put("responseCode", "00");
/*  80 */       rs.put("data", data);
/*     */     }
/*  82 */     catch (Exception e) {
/*  83 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  84 */       logger.error(exceptionAsString);
/*  85 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  87 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service_type/getAll"})
/*     */   public ApiResponse getAll() {
/*  92 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  97 */       List<MedicServiceTypes> medicRoomsList = this.serviceTypeRepository.findAllByStatusOrderBySort(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       
/*  99 */       rs.put("status", "OK");
/* 100 */       rs.put("responseCode", "00");
/* 101 */       rs.put("data", medicRoomsList);
/*     */     }
/* 103 */     catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service_type/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 113 */     ApiResponse rs = new ApiResponse();
/* 114 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 117 */       if (id == null) {
/* 118 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 121 */       Optional<MedicServiceTypes> g = this.serviceTypeRepository.findById(id);
/* 122 */       if (!g.isPresent()) {
/* 123 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 126 */       rs.put("status", "OK");
/* 127 */       rs.put("responseCode", "00");
/* 128 */       rs.put("data", this.modelMapper.map(g.get(), ServiceTypeResponse.class));
/*     */     }
/* 130 */     catch (Exception e) {
/* 131 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 132 */       logger.error(exceptionAsString);
/* 133 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 135 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_service_type/create"})
/*     */   public ApiResponse create(@Valid @RequestBody ServiceTypeRequest request) {
/* 140 */     ApiResponse rs = new ApiResponse();
/* 141 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 143 */       MedicServiceTypes serviceTypes = this.serviceTypeRepository.findByName(request.getName()).orElse(null);
/* 144 */       if (Objects.nonNull(serviceTypes)) {
/* 145 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 148 */       MedicServiceTypes MedicServiceTypes = (MedicServiceTypes)this.modelMapper.map(request, MedicServiceTypes.class);
/* 149 */       MedicServiceTypes.setCreatedAt(new Date());
/* 150 */       MedicServiceTypes result = (MedicServiceTypes)this.serviceTypeRepository.saveAndFlush(MedicServiceTypes);
/*     */       
/* 152 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 154 */       rs.put("status", "OK");
/* 155 */       rs.put("responseCode", "00");
/* 156 */       rs.put("data", data);
/*     */     }
/* 158 */     catch (Exception e) {
/* 159 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 160 */       logger.error(exceptionAsString);
/* 161 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 163 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_service_type/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody ServiceTypeRequest request) {
/* 168 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 172 */       if (id == null) {
/* 173 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 176 */       Optional<MedicServiceTypes> g = this.serviceTypeRepository.findById(id);
/* 177 */       if (!g.isPresent()) {
/* 178 */         return this.apiError.getError("02");
/*     */       }
/* 180 */       MedicServiceTypes serviceTypes = this.serviceTypeRepository.findByName(request.getName()).orElse(null);
/* 181 */       if (Objects.nonNull(serviceTypes) && !((MedicServiceTypes)g.get()).getName().equals(request.getName())) {
/* 182 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 185 */       MedicServiceTypes medicServiceTypes = (MedicServiceTypes)this.modelMapper.map(request, MedicServiceTypes.class);
/* 186 */       medicServiceTypes.setId(id.intValue());
/* 187 */       medicServiceTypes.setCreatedAt(((MedicServiceTypes)g.get()).getCreatedAt());
/* 188 */       medicServiceTypes.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 191 */       this.serviceTypeRepository.saveAndFlush(medicServiceTypes);
/*     */       
/* 193 */       rs.put("status", "OK");
/* 194 */       rs.put("responseCode", "00");
/*     */     
/*     */     }
/* 197 */     catch (Exception e) {
/* 198 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 199 */       logger.error(exceptionAsString);
/* 200 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 202 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_service_type/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 207 */     ApiResponse rs = new ApiResponse();
/* 208 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 211 */       if (id == null) {
/* 212 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 215 */       Optional<MedicServiceTypes> g = this.serviceTypeRepository.findById(id);
/* 216 */       if (!g.isPresent()) {
/* 217 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 220 */       List<MedicServices> services = this.serviceRepository.findAllByServiceTypeId(id).orElse(new ArrayList<>());
/* 221 */       if (CollectionUtils.isNotEmpty(services)) {
/* 222 */         return this.apiError.getError("506");
/*     */       }
/*     */       
/* 225 */       this.serviceTypeRepository.deleteById(id);
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
/*     */   
/*     */   @GetMapping({"/medic_service_type/get_type_group"})
/*     */   public ApiResponse getTypeGroup(@RequestParam @Valid Integer serviceGroupId) {
/* 241 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*     */       List<MedicServiceTypes> medicRoomsList;
/* 245 */       if (serviceGroupId != null) {
/*     */ 
/*     */         
/* 248 */         medicRoomsList = this.serviceTypeRepository.findAllByServiceGroupIdAndStatus(serviceGroupId, Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       } else {
/* 250 */         medicRoomsList = this.serviceTypeRepository.findAll();
/*     */       } 
/*     */       
/* 253 */       rs.put("status", "OK");
/* 254 */       rs.put("responseCode", "00");
/* 255 */       rs.put("data", medicRoomsList);
/*     */     }
/* 257 */     catch (Exception e) {
/* 258 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 259 */       logger.error(exceptionAsString);
/* 260 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 262 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Service\ServiceTypeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */