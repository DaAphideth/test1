/*     */ package nencer.app.Modules.Medic.Controller.Drug;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugs;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Hospital.HospitalResponse;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
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
/*     */ public class MedicDrugsController {
/*  28 */   public static final Logger logger = LoggerFactory.getLogger(MedicDrugsController.class);
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
/*     */   MedicDrugsRepository medicDrugsRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_drugs"})
/*     */   public ApiResponse getPaging(@Valid @RequestBody(required = false) List<SearchCriteria> criterias, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  46 */     ApiResponse rs = new ApiResponse();
/*  47 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  50 */       PageRequest pageable = PageRequest.of(page - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  51 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  52 */       TSpecification specifications = new TSpecification(criterias);
/*     */       
/*  54 */       Page<MedicDrugs> pages = this.medicDrugsRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  55 */       data.put("hospitals", pages.stream().map(m -> (HospitalResponse)this.modelMapper.map(m, HospitalResponse.class)).collect(Collectors.toList()));
/*  56 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  57 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  59 */       rs.put("status", "OK");
/*  60 */       rs.put("responseCode", "00");
/*  61 */       rs.put("data", data);
/*     */     }
/*  63 */     catch (Exception e) {
/*  64 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  65 */       logger.error(exceptionAsString);
/*  66 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  68 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_drugs/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  74 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  77 */       if (id == null) {
/*  78 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  81 */       Optional<MedicDrugs> g = this.medicDrugsRepository.findById(id);
/*  82 */       if (!g.isPresent()) {
/*  83 */         return this.apiError.getError("02");
/*     */       }
/*  85 */       rs.put("status", "OK");
/*  86 */       rs.put("responseCode", "00");
/*  87 */       rs.put("data", g.get());
/*     */     }
/*  89 */     catch (Exception e) {
/*  90 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  91 */       logger.error(exceptionAsString);
/*  92 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  94 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_drugs"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicDrugs request) {
/*  99 */     ApiResponse rs = new ApiResponse();
/* 100 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 102 */       request.setCreatedAt(new Date());
/* 103 */       MedicDrugs result = (MedicDrugs)this.medicDrugsRepository.saveAndFlush(request);
/*     */       
/* 105 */       data.put("id", Integer.valueOf(result.getId()));
/* 106 */       rs.put("status", "OK");
/* 107 */       rs.put("responseCode", "00");
/* 108 */       rs.put("data", data);
/*     */     }
/* 110 */     catch (Exception e) {
/* 111 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 112 */       logger.error(exceptionAsString);
/* 113 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 115 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_drugs/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicDrugs request) {
/* 121 */     ApiResponse rs = new ApiResponse();
/* 122 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 125 */       if (id == null) {
/* 126 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 129 */       Optional<MedicDrugs> g = this.medicDrugsRepository.findById(id);
/* 130 */       if (!g.isPresent()) {
/* 131 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 134 */       request.setId(id.intValue());
/*     */ 
/*     */       
/* 137 */       this.medicDrugsRepository.saveAndFlush(request);
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
/*     */   @DeleteMapping({"/medic_drugs/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 153 */     ApiResponse rs = new ApiResponse();
/* 154 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 157 */       if (id == null) {
/* 158 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 161 */       Optional<MedicDrugs> g = this.medicDrugsRepository.findById(id);
/* 162 */       if (!g.isPresent()) {
/* 163 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 167 */       this.medicDrugsRepository.delete(g.get());
/* 168 */       rs.put("status", "OK");
/* 169 */       rs.put("responseCode", "00");
/* 170 */       rs.put("data", data);
/*     */     }
/* 172 */     catch (Exception e) {
/* 173 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 174 */       logger.error(exceptionAsString);
/* 175 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 177 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Drug\MedicDrugsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */