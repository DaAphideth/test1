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
/*     */ import nencer.app.CacheRedis.CacheData;
/*     */ import nencer.app.Modules.Medic.Entity.Department.MedicDepartments;
/*     */ import nencer.app.Modules.Medic.Model.Department.DepartmentRequest;
/*     */ import nencer.app.Modules.Medic.Model.Department.DepartmentResponse;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
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
/*     */ public class DepartmentController {
/*  42 */   public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
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
/*     */   DepartmentRepository departmentRepository;
/*     */   
/*     */   @Autowired
/*     */   CacheDataRepository cacheDataRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */   
/*     */   @Autowired
/*     */   ObjectMapper objectMapper;
/*     */   
/*     */   private static final String MEDIC_DEPARTMENT = "medicDepartment";
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_department"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(defaultValue = "name") String fieldSort, @RequestParam(defaultValue = "asc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size) {
/*  70 */     ApiResponse rs = new ApiResponse();
/*  71 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  73 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  74 */       if (!StringUtils.isEmpty(filter)) {
/*  75 */         ObjectMapper objectMapper = new ObjectMapper();
/*  76 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  79 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  80 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  81 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  83 */       Page<MedicDepartments> pages = this.departmentRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  84 */       data.put("medicDepartments", pages.get());
/*  85 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  86 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  88 */       rs.put("status", "OK");
/*  89 */       rs.put("responseCode", "00");
/*  90 */       rs.put("data", data);
/*     */     }
/*  92 */     catch (Exception e) {
/*  93 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  94 */       logger.error(exceptionAsString);
/*  95 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  97 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_department/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 103 */     ApiResponse rs = new ApiResponse();
/* 104 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 107 */       if (id == null) {
/* 108 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 111 */       Optional<MedicDepartments> g = this.departmentRepository.findById(id);
/* 112 */       if (!g.isPresent()) {
/* 113 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 116 */       rs.put("status", "OK");
/* 117 */       rs.put("responseCode", "00");
/* 118 */       rs.put("data", this.modelMapper.map(g.get(), DepartmentResponse.class));
/*     */     }
/* 120 */     catch (Exception e) {
/* 121 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 122 */       logger.error(exceptionAsString);
/* 123 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 125 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_department/create"})
/*     */   public ApiResponse create(@Valid @RequestBody DepartmentRequest request) {
/* 130 */     ApiResponse rs = new ApiResponse();
/* 131 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 133 */       MedicDepartments medicDepartments = this.departmentRepository.findByCode(request.getCode()).orElse(null);
/* 134 */       if (Objects.nonNull(medicDepartments)) {
/* 135 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 138 */       MedicDepartments MedicDepartments = (MedicDepartments)this.modelMapper.map(request, MedicDepartments.class);
/* 139 */       MedicDepartments.setCreatedAt(new Date());
/* 140 */       MedicDepartments result = (MedicDepartments)this.departmentRepository.saveAndFlush(MedicDepartments);
/*     */       
/* 142 */       updateDepartmentStoreHouse(MedicDepartments);
/*     */       
/* 144 */       this.cacheDataRepository.deleteById("medicDepartment");
/*     */       
/* 146 */       saveRedisDepartment();
/* 147 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 149 */       rs.put("status", "OK");
/* 150 */       rs.put("responseCode", "00");
/* 151 */       rs.put("data", data);
/*     */     }
/* 153 */     catch (Exception e) {
/* 154 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 155 */       logger.error(exceptionAsString);
/* 156 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 158 */     return rs;
/*     */   }
/*     */   
/*     */   private void updateDepartmentStoreHouse(MedicDepartments medicDepartments) {
/* 162 */     Optional<MedicProductStorehouse> medicProductStorehouseOp = this.medicProductStorehouseRepository.findByDepartmentId(Integer.valueOf(medicDepartments.getId()));
/* 163 */     if (medicProductStorehouseOp.isPresent()) {
/* 164 */       MedicProductStorehouse medicProductStorehouse = medicProductStorehouseOp.get();
/* 165 */       medicProductStorehouse.setCode(medicDepartments.getCode());
/* 166 */       medicProductStorehouse.setName(medicDepartments.getName());
/* 167 */       this.medicProductStorehouseRepository.save(medicProductStorehouse);
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 174 */       MedicProductStorehouse medicProductStorehouse = MedicProductStorehouse.builder().name(medicDepartments.getName()).code(medicDepartments.getCode()).code(medicDepartments.getCode()).departmentId(Integer.valueOf(medicDepartments.getId())).build();
/* 175 */       this.medicProductStorehouseRepository.save(medicProductStorehouse);
/*     */     } 
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_department/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody DepartmentRequest request) {
/* 181 */     ApiResponse rs = new ApiResponse();
/* 182 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 185 */       if (id == null) {
/* 186 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 189 */       Optional<MedicDepartments> g = this.departmentRepository.findById(id);
/* 190 */       if (!g.isPresent()) {
/* 191 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 194 */       MedicDepartments medicDepartments = this.departmentRepository.findByCode(request.getCode()).orElse(null);
/* 195 */       if (Objects.nonNull(medicDepartments) && !((MedicDepartments)g.get()).getCode().equals(request.getCode())) {
/* 196 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 199 */       MedicDepartments medicDepartmentUdpate = (MedicDepartments)this.modelMapper.map(request, MedicDepartments.class);
/* 200 */       medicDepartmentUdpate.setId(id.intValue());
/* 201 */       medicDepartmentUdpate.setCreatedAt(((MedicDepartments)g.get()).getCreatedAt());
/* 202 */       medicDepartmentUdpate.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 205 */       this.departmentRepository.saveAndFlush(medicDepartmentUdpate);
/*     */       
/* 207 */       updateDepartmentStoreHouse(medicDepartmentUdpate);
/*     */       
/* 209 */       this.cacheDataRepository.deleteById("medicDepartment");
/*     */       
/* 211 */       saveRedisDepartment();
/* 212 */       rs.put("status", "OK");
/* 213 */       rs.put("responseCode", "00");
/* 214 */       rs.put("data", data);
/*     */     }
/* 216 */     catch (Exception e) {
/* 217 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 218 */       logger.error(exceptionAsString);
/* 219 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 221 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_department/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 226 */     ApiResponse rs = new ApiResponse();
/* 227 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 230 */       if (id == null) {
/* 231 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 234 */       Optional<MedicDepartments> g = this.departmentRepository.findById(id);
/* 235 */       if (!g.isPresent()) {
/* 236 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 239 */       Optional<MedicProductStorehouse> medicProductStorehouseOp = this.medicProductStorehouseRepository.findByDepartmentId(id);
/* 240 */       if (medicProductStorehouseOp.isPresent()) {
/* 241 */         this.medicProductStorehouseRepository.deleteByDepartmentId(id);
/*     */       }
/*     */       
/* 244 */       this.departmentRepository.updateMedicDepartmentStatus(id);
/*     */       
/* 246 */       this.cacheDataRepository.deleteById("medicDepartment");
/*     */       
/* 248 */       saveRedisDepartment();
/* 249 */       rs.put("status", "OK");
/* 250 */       rs.put("responseCode", "00");
/* 251 */       rs.put("data", data);
/*     */     }
/* 253 */     catch (Exception e) {
/* 254 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 255 */       logger.error(exceptionAsString);
/* 256 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 258 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_department/getAll"})
/*     */   public ApiResponse getAll() {
/* 262 */     ApiResponse rs = new ApiResponse();
/* 263 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 266 */       List<MedicDepartments> medicRoomsList = new ArrayList<>();
/* 267 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("medicDepartment");
/* 268 */       if (optionalCacheData.isPresent()) {
/* 269 */         String opCacheData = ((CacheData)optionalCacheData.get()).getValue();
/* 270 */         medicRoomsList = (List<MedicDepartments>)this.objectMapper.readValue(opCacheData, new TypeReference<List<MedicDepartments>>() {  }
/*     */           );
/*     */       } else {
/* 273 */         medicRoomsList = this.departmentRepository.findAll();
/* 274 */         String masterDataJsonString = this.objectMapper.writeValueAsString(medicRoomsList);
/* 275 */         CacheData cacheData = new CacheData("medicDepartment", masterDataJsonString);
/* 276 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/*     */       
/* 279 */       rs.put("status", "OK");
/* 280 */       rs.put("responseCode", "00");
/* 281 */       rs.put("data", medicRoomsList);
/*     */     }
/* 283 */     catch (Exception e) {
/* 284 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 285 */       logger.error(exceptionAsString);
/* 286 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 288 */     return rs;
/*     */   }
/*     */   public void saveRedisDepartment() throws JsonProcessingException {
/* 291 */     List<MedicDepartments> medicRoomsList = this.departmentRepository.findAll();
/* 292 */     if (CollectionUtils.isNotEmpty(medicRoomsList)) {
/* 293 */       String masterDataJsonString = this.objectMapper.writeValueAsString(medicRoomsList);
/* 294 */       CacheData cacheData = new CacheData("medicDepartment", masterDataJsonString);
/* 295 */       this.cacheDataRepository.save(cacheData);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Manage\DepartmentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */