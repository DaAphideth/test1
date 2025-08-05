/*     */ package nencer.app.Modules.Medic.Controller.TemplateService;
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
/*     */ import nencer.app.Modules.Medic.Entity.TemplateService.MedicTemplateService;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.TemplateService.TemplateServiceRequest;
/*     */ import nencer.app.Modules.Medic.Repository.OrderServiceRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
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
/*     */ public class TemplateServiceController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(TemplateServiceController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   TemplateServiceRepository templateServiceRepository;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   OrderServiceRepository orderServiceRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_template_service"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
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
/*  73 */       Page<MedicTemplateService> pages = this.templateServiceRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  74 */       data.put("templateService", pages.getContent());
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
/*     */   
/*     */   @PostMapping({"/medic_template_service/create"})
/*     */   public ApiResponse create(@Valid @RequestBody TemplateServiceRequest request) {
/*  93 */     ApiResponse rs = new ApiResponse();
/*  94 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  96 */       MedicTemplateService templateServiceName = this.templateServiceRepository.findByName(request.getName()).orElse(null);
/*  97 */       if (Objects.nonNull(templateServiceName)) {
/*  98 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 101 */       MedicTemplateService templateServiceCode = this.templateServiceRepository.findByCode(request.getCode()).orElse(null);
/* 102 */       if (Objects.nonNull(templateServiceCode)) {
/* 103 */         return this.apiError.getError("05");
/*     */       }
/*     */ 
/*     */       
/* 107 */       MedicTemplateService templateService = (MedicTemplateService)this.modelMapper.map(request, MedicTemplateService.class);
/* 108 */       templateService.setCreatedAt(new Date());
/* 109 */       templateService.setCreatorId(request.getAccessToken());
/* 110 */       MedicTemplateService result = (MedicTemplateService)this.templateServiceRepository.saveAndFlush(templateService);
/*     */       
/* 112 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 114 */       rs.put("status", "OK");
/* 115 */       rs.put("responseCode", "00");
/* 116 */       rs.put("data", data);
/*     */     }
/* 118 */     catch (Exception e) {
/* 119 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 120 */       logger.error(exceptionAsString);
/* 121 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 123 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_template_service/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody TemplateServiceRequest request) {
/* 128 */     ApiResponse rs = new ApiResponse();
/* 129 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 132 */       if (id == null) {
/* 133 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 136 */       Optional<MedicTemplateService> g = this.templateServiceRepository.findById(id);
/* 137 */       if (!g.isPresent()) {
/* 138 */         return this.apiError.getError("02");
/*     */       }
/* 140 */       MedicTemplateService templateServiceName = this.templateServiceRepository.findByName(request.getName()).orElse(null);
/* 141 */       if (Objects.nonNull(templateServiceName) && !((MedicTemplateService)g.get()).getName().equals(request.getName())) {
/* 142 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 145 */       MedicTemplateService templateServiceCode = this.templateServiceRepository.findByCode(request.getCode()).orElse(null);
/* 146 */       if (Objects.nonNull(templateServiceCode) && !((MedicTemplateService)g.get()).getCode().equals(request.getCode())) {
/* 147 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 150 */       MedicTemplateService templateService = (MedicTemplateService)this.modelMapper.map(request, MedicTemplateService.class);
/* 151 */       templateService.setId(id.intValue());
/* 152 */       templateService.setCreatedAt(((MedicTemplateService)g.get()).getCreatedAt());
/* 153 */       templateService.setCreatorId(((MedicTemplateService)g.get()).getCreatorId());
/* 154 */       templateService.setUpdatedAt(new Date());
/*     */       
/* 156 */       this.templateServiceRepository.saveAndFlush(templateService);
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
/*     */   @DeleteMapping({"/medic_template_service/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 172 */     ApiResponse rs = new ApiResponse();
/* 173 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 176 */       if (id == null) {
/* 177 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 180 */       Optional<MedicTemplateService> g = this.templateServiceRepository.findById(id);
/* 181 */       if (!g.isPresent()) {
/* 182 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 186 */       this.templateServiceRepository.delete(g.get());
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
/*     */   
/*     */   @GetMapping({"/medic_template_service/get_all"})
/*     */   public ApiResponse getAll() {
/* 202 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 204 */       List<MedicTemplateService> medicTemplateServices = this.templateServiceRepository.findAll();
/*     */       
/* 206 */       rs.put("status", "OK");
/* 207 */       rs.put("responseCode", "00");
/* 208 */       rs.put("data", medicTemplateServices);
/*     */     }
/* 210 */     catch (Exception e) {
/* 211 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       
/* 213 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 215 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_template_service/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 220 */     ApiResponse rs = new ApiResponse();
/* 221 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 224 */       if (id == null) {
/* 225 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 228 */       Optional<MedicTemplateService> g = this.templateServiceRepository.findById(id);
/* 229 */       if (!g.isPresent()) {
/* 230 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 233 */       rs.put("status", "OK");
/* 234 */       rs.put("responseCode", "00");
/* 235 */       rs.put("data", this.modelMapper.map(g.get(), TemplateServiceResponse.class));
/*     */     }
/* 237 */     catch (Exception e) {
/* 238 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 239 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 241 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\TemplateService\TemplateServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */