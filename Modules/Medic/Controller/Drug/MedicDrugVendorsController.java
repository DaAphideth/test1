/*     */ package nencer.app.Modules.Medic.Controller.Drug;
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
/*     */ import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugVendors;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Report.Repository.CommonReportRepo;
/*     */ import nencer.app.Modules.Storehouse.Model.DrugVendorsResponse;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicDrugVendorsController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(MedicDrugVendorsController.class);
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
/*     */   CommonReportRepo commonReportRepo;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicDrugVendorsRepository medicDrugVendorsRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_drug_vendors"})
/*     */   public ApiResponse getPaging(@RequestBody(required = false) String searchValue, @RequestParam(required = false) Integer status, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  56 */     ApiResponse rs = new ApiResponse();
/*  57 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  60 */       List<DrugVendorsResponse> list = this.commonReportRepo.spGetSearchDrugVendors(page, size, searchValue, fieldSort, direction, status);
/*     */       
/*  62 */       data.put("dataRes", list);
/*  63 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((DrugVendorsResponse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  65 */       rs.put("status", "OK");
/*  66 */       rs.put("responseCode", "00");
/*  67 */       rs.put("data", data);
/*     */     }
/*  69 */     catch (Exception e) {
/*  70 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  71 */       logger.error(exceptionAsString);
/*  72 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  74 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_drug_vendors/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  79 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  82 */       if (id == null) {
/*  83 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  86 */       Optional<MedicDrugVendors> g = this.medicDrugVendorsRepository.findById(id);
/*  87 */       if (!g.isPresent()) {
/*  88 */         return this.apiError.getError("02");
/*     */       }
/*  90 */       rs.put("status", "OK");
/*  91 */       rs.put("responseCode", "00");
/*  92 */       rs.put("data", g.get());
/*     */     }
/*  94 */     catch (Exception e) {
/*  95 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  96 */       logger.error(exceptionAsString);
/*  97 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  99 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_drug_vendors"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicDrugVendors request) {
/* 104 */     ApiResponse rs = new ApiResponse();
/* 105 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 107 */       MedicDrugVendors medicDrugVendors = this.medicDrugVendorsRepository.findByCode(request.getCode());
/* 108 */       if (Objects.nonNull(medicDrugVendors)) {
/* 109 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 112 */       request.setCreatedAt(new Date());
/* 113 */       MedicDrugVendors result = (MedicDrugVendors)this.medicDrugVendorsRepository.saveAndFlush(request);
/*     */       
/* 115 */       data.put("id", Integer.valueOf(result.getId()));
/* 116 */       rs.put("status", "OK");
/* 117 */       rs.put("responseCode", "00");
/* 118 */       rs.put("data", data);
/*     */     }
/* 120 */     catch (Exception e) {
/* 121 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 122 */       logger.error(exceptionAsString);
/* 123 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 125 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_drug_vendors/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicDrugVendors request) {
/* 131 */     ApiResponse rs = new ApiResponse();
/* 132 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 135 */       if (id == null) {
/* 136 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 139 */       Optional<MedicDrugVendors> g = this.medicDrugVendorsRepository.findById(id);
/* 140 */       if (!g.isPresent()) {
/* 141 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 144 */       MedicDrugVendors medicDrugVendors = this.medicDrugVendorsRepository.findByCode(request.getCode());
/* 145 */       if (Objects.nonNull(medicDrugVendors) && !((MedicDrugVendors)g.get()).getCode().equals(request.getCode())) {
/* 146 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 149 */       request.setId(id.intValue());
/* 150 */       request.setCreatedAt(((MedicDrugVendors)g.get()).getCreatedAt());
/* 151 */       request.setUpdatedAt(new Date());
/*     */       
/* 153 */       this.medicDrugVendorsRepository.saveAndFlush(request);
/*     */       
/* 155 */       rs.put("status", "OK");
/* 156 */       rs.put("responseCode", "00");
/* 157 */       rs.put("data", data);
/*     */     }
/* 159 */     catch (Exception e) {
/* 160 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 161 */       logger.error(exceptionAsString);
/* 162 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 164 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_drug_vendors/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 169 */     ApiResponse rs = new ApiResponse();
/* 170 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 173 */       if (id == null) {
/* 174 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 177 */       Optional<MedicDrugVendors> g = this.medicDrugVendorsRepository.findById(id);
/* 178 */       if (!g.isPresent()) {
/* 179 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 182 */       this.medicDrugVendorsRepository.delete(g.get());
/* 183 */       rs.put("status", "OK");
/* 184 */       rs.put("responseCode", "00");
/* 185 */       rs.put("data", data);
/*     */     }
/* 187 */     catch (Exception e) {
/* 188 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 189 */       logger.error(exceptionAsString);
/* 190 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 192 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_drug_vendors/get_all"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter) {
/* 196 */     ApiResponse rs = new ApiResponse();
/* 197 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 199 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 200 */       if (!StringUtils.isEmpty(filter)) {
/* 201 */         ObjectMapper objectMapper = new ObjectMapper();
/* 202 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/* 206 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 208 */       List<MedicDrugVendors> pages = this.medicDrugVendorsRepository.findAll((Specification)specifications);
/* 209 */       data.put("medicDrugVendors", pages);
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
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Drug\MedicDrugVendorsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */