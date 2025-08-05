/*     */ package nencer.app.Modules.Medic.Controller.Service;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.QueryOperator;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Service.MedicServiceResponse;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceCatagory;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceRequest;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ServiceController extends BaseMedicController {
/*  44 */   public static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
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
/*     */   ServiceRepository serviceRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   OrderServiceRepository orderServiceRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  65 */     ApiResponse rs = new ApiResponse();
/*  66 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  68 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  69 */       if (!StringUtils.isEmpty(filter)) {
/*  70 */         ObjectMapper objectMapper = new ObjectMapper();
/*  71 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  74 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  75 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  76 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  78 */       Page<MedicServices> pages = this.serviceRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  79 */       data.put("services", pages.getContent());
/*  80 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  81 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  83 */       rs.put("status", "OK");
/*  84 */       rs.put("responseCode", "00");
/*  85 */       rs.put("data", data);
/*     */     }
/*  87 */     catch (Exception e) {
/*  88 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  89 */       logger.error(exceptionAsString);
/*  90 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  92 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  98 */     ApiResponse rs = new ApiResponse();
/*  99 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 102 */       if (id == null) {
/* 103 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 106 */       Optional<MedicServices> g = this.serviceRepository.findById(id);
/* 107 */       if (!g.isPresent()) {
/* 108 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 111 */       rs.put("status", "OK");
/* 112 */       rs.put("responseCode", "00");
/* 113 */       rs.put("data", this.modelMapper.map(g.get(), ServiceResponse.class));
/*     */     }
/* 115 */     catch (Exception e) {
/* 116 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 117 */       logger.error(exceptionAsString);
/* 118 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 120 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_service/create"})
/*     */   public ApiResponse create(@Valid @RequestBody ServiceRequest request) {
/* 125 */     ApiResponse rs = new ApiResponse();
/* 126 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 128 */       MedicServices service = this.serviceRepository.findByCode(request.getCode()).orElse(null);
/* 129 */       if (Objects.nonNull(service)) {
/* 130 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 133 */       MedicServices MedicServices = (MedicServices)this.modelMapper.map(request, MedicServices.class);
/* 134 */       MedicServices.setCreatedAt(new Date());
/* 135 */       MedicServices result = (MedicServices)this.serviceRepository.saveAndFlush(MedicServices);
/*     */       
/* 137 */       data.put("id", result.getId());
/*     */       
/* 139 */       rs.put("status", "OK");
/* 140 */       rs.put("responseCode", "00");
/* 141 */       rs.put("data", data);
/*     */     }
/* 143 */     catch (Exception e) {
/* 144 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 145 */       logger.error(exceptionAsString);
/* 146 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 148 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_service/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody ServiceRequest request) {
/* 153 */     ApiResponse rs = new ApiResponse();
/* 154 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 157 */       if (id == null) {
/* 158 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 161 */       Optional<MedicServices> g = this.serviceRepository.findById(id);
/* 162 */       if (!g.isPresent()) {
/* 163 */         return this.apiError.getError("02");
/*     */       }
/* 165 */       MedicServices serviceTypes = this.serviceRepository.findByCode(request.getCode()).orElse(null);
/* 166 */       if (Objects.nonNull(serviceTypes) && !((MedicServices)g.get()).getCode().equals(request.getCode())) {
/* 167 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 170 */       MedicServices MedicServices = (MedicServices)this.modelMapper.map(request, MedicServices.class);
/* 171 */       MedicServices.setId(id);
/* 172 */       MedicServices.setCreatedAt(((MedicServices)g.get()).getCreatedAt());
/* 173 */       MedicServices.setUpdatedAt(new Date());
/*     */       
/* 175 */       this.serviceRepository.saveAndFlush(MedicServices);
/*     */       
/* 177 */       rs.put("status", "OK");
/* 178 */       rs.put("responseCode", "00");
/* 179 */       rs.put("data", data);
/*     */     }
/* 181 */     catch (Exception e) {
/* 182 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 183 */       logger.error(exceptionAsString);
/* 184 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 186 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_service/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 191 */     ApiResponse rs = new ApiResponse();
/* 192 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 195 */       if (id == null) {
/* 196 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 199 */       Optional<MedicServices> g = this.serviceRepository.findById(id);
/* 200 */       if (!g.isPresent()) {
/* 201 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 204 */       List<MedicOrderServices> orderServices = this.orderServiceRepository.findAllByServiceId(id).orElse(new ArrayList<>());
/* 205 */       if (CollectionUtils.isNotEmpty(orderServices)) {
/* 206 */         return this.apiError.getError("505");
/*     */       }
/*     */       
/* 209 */       this.serviceRepository.updateServiceStatus(id);
/*     */       
/* 211 */       rs.put("status", "OK");
/* 212 */       rs.put("responseCode", "00");
/* 213 */       rs.put("data", data);
/*     */     }
/* 215 */     catch (Exception e) {
/* 216 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 217 */       logger.error(exceptionAsString);
/* 218 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 220 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_service/getService"})
/*     */   public ApiResponse getService(@RequestParam(required = false) String value, @RequestParam(required = false) String serviceGroupId) {
/* 230 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 232 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 237 */       SearchCriteria searchCriteria = SearchCriteria.builder().field("name").operator(QueryOperator.LIKE).value(value).build();
/* 238 */       searchFilter.add(searchCriteria);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 243 */       SearchCriteria searchCriteria1 = SearchCriteria.builder().field("status").operator(QueryOperator.EQUALS).value(Integer.valueOf(1)).build();
/* 244 */       searchFilter.add(searchCriteria1);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 249 */       SearchCriteria searchCriteria2 = SearchCriteria.builder().field("serviceGroupId").operator(QueryOperator.EQUALS).value(serviceGroupId).build();
/* 250 */       searchFilter.add(searchCriteria2);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 255 */       SearchCriteria searchCriteria3 = SearchCriteria.builder().field("parentId").operator(QueryOperator.EQUALS).value(Integer.valueOf(0)).build();
/* 256 */       searchFilter.add(searchCriteria3);
/* 257 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 259 */       List<MedicServiceResponse> medicServiceResponses = new ArrayList<>();
/* 260 */       List<MedicServices> services = this.serviceRepository.findAll((Specification)specifications);
/* 261 */       if (services != null && services.size() > 0)
/*     */       {
/* 263 */         for (MedicServices ms : services) {
/* 264 */           MedicServiceResponse mss = (MedicServiceResponse)this.modelMapper.map(ms, MedicServiceResponse.class);
/*     */           try {
/* 266 */             if (!StringUtils.isEmpty(mss.getRoomSampleId())) {
/*     */ 
/*     */               
/* 269 */               List<Integer> ints = (List<Integer>)Arrays.<String>stream(mss.getRoomSampleId().split(",")).map(Integer::parseInt).collect(Collectors.toList());
/* 270 */               List<MedicRooms> mrn = this.roomRepository.findAllByIdIn(ints).orElse(null);
/* 271 */               if (mrn != null) {
/* 272 */                 mss.setMedicSamples(mrn);
/*     */               }
/*     */             } 
/* 275 */             if (!StringUtils.isEmpty(mss.getRoomHandleId())) {
/*     */ 
/*     */               
/* 278 */               List<Integer> ints = (List<Integer>)Arrays.<String>stream(mss.getRoomHandleId().split(",")).map(Integer::parseInt).collect(Collectors.toList());
/* 279 */               List<MedicRooms> mrn = this.roomRepository.findAllByIdIn(ints).orElse(null);
/* 280 */               if (mrn != null) {
/* 281 */                 mss.setMedicHandles(mrn);
/*     */               }
/*     */             } 
/* 284 */           } catch (Exception exception) {}
/*     */           
/* 286 */           medicServiceResponses.add(mss);
/* 287 */           mss.setRoomSampleId("");
/* 288 */           mss.setRoomHandleId("");
/*     */         } 
/*     */       }
/*     */       
/* 292 */       rs.put("status", "OK");
/* 293 */       rs.put("responseCode", "00");
/* 294 */       rs.put("data", medicServiceResponses);
/*     */     }
/* 296 */     catch (Exception e) {
/* 297 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 298 */       logger.error(exceptionAsString);
/* 299 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 301 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service/getAll"})
/*     */   public ApiResponse getAll() {
/* 306 */     ApiResponse rs = new ApiResponse();
/* 307 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 309 */       List<MedicServices> servicesList = this.serviceRepository.findAllByStatus(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 315 */       rs.put("status", "OK");
/* 316 */       rs.put("responseCode", "00");
/* 317 */       rs.put("data", servicesList);
/*     */     }
/* 319 */     catch (Exception e) {
/* 320 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 321 */       logger.error(exceptionAsString);
/* 322 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 324 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service/get_service_xn"})
/*     */   public ApiResponse get_service_xn() {
/* 329 */     ApiResponse rs = new ApiResponse();
/* 330 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 333 */       List<MedicServices> servicesList = this.serviceRepository.findAllByServiceGroupIdAndStatus(Integer.valueOf(2), Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 339 */       rs.put("status", "OK");
/* 340 */       rs.put("responseCode", "00");
/* 341 */       rs.put("data", servicesList);
/*     */     }
/* 343 */     catch (Exception e) {
/* 344 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 345 */       logger.error(exceptionAsString);
/* 346 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 348 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service/getAllServiceExam"})
/*     */   public ApiResponse getAllServiceExam() {
/* 353 */     ApiResponse rs = new ApiResponse();
/* 354 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 356 */       List<MedicServices> servicesList = this.serviceRepository.findByServiceGroupId(Integer.valueOf(1), Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 362 */       rs.put("status", "OK");
/* 363 */       rs.put("responseCode", "00");
/* 364 */       rs.put("data", servicesList);
/*     */     }
/* 366 */     catch (Exception e) {
/* 367 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 368 */       logger.error(exceptionAsString);
/* 369 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 371 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service/getAllChild"})
/*     */   public ApiResponse getAllChild() {
/* 376 */     ApiResponse rs = new ApiResponse();
/* 377 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 379 */       List<MedicServices> servicesList = this.serviceRepository.findAll();
/* 380 */       List<MedicServices> services = getTreeValues(servicesList);
/* 381 */       data.put("medicServices", services.stream()
/* 382 */           .filter(f -> (f.getStatus().intValue() == 1L))
/* 383 */           .map(s -> (ServiceCatagory)this.modelMapper.map(s, ServiceCatagory.class)).collect(Collectors.toList()));
/*     */       
/* 385 */       rs.put("status", "OK");
/* 386 */       rs.put("responseCode", "00");
/* 387 */       rs.put("data", data);
/*     */     }
/* 389 */     catch (Exception e) {
/* 390 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 391 */       logger.error(exceptionAsString);
/* 392 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 394 */     return rs;
/*     */   }
/*     */   
/*     */   private List<MedicServices> getTreeValues(List<MedicServices> mngCategories) {
/* 398 */     List<Integer> collect = (List<Integer>)mngCategories.stream().map(MedicServices::getId).collect(Collectors.toList());
/*     */     
/* 400 */     List<MedicServices> roots = new ArrayList<>();
/* 401 */     for (MedicServices medicServices : mngCategories);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 411 */     return roots;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Service\ServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */