/*     */ package nencer.app.Modules.Storehouse.Controller.Supplier;
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
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Report.Repository.CommonReportRepo;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductSupplier;
/*     */ import nencer.app.Modules.Storehouse.Model.ProductSupplierResponse;
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
/*     */ public class MedicProductSupplierController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductSupplierController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   CommonReportRepo commonReportRepo;
/*     */   
/*     */   @Autowired
/*     */   MedicProductSupplierRepository medicProductSupplierRepository;
/*     */   
/*     */   @GetMapping({"/medic_product_supplier/get_all"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter) {
/*  50 */     ApiResponse rs = new ApiResponse();
/*  51 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  53 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  54 */       if (!StringUtils.isEmpty(filter)) {
/*  55 */         ObjectMapper objectMapper = new ObjectMapper();
/*  56 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  60 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  62 */       List<MedicProductSupplier> pages = this.medicProductSupplierRepository.findAll((Specification)specifications);
/*  63 */       data.put("medicProductSupplier", pages);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_supplier"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer status, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  84 */     ApiResponse rs = new ApiResponse();
/*  85 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  87 */       List<ProductSupplierResponse> list = this.commonReportRepo.searchProductSupplier(page, size, searchValue, fieldSort, direction, status);
/*     */       
/*  89 */       data.put("dataRes", list);
/*  90 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((ProductSupplierResponse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  92 */       rs.put("status", "OK");
/*  93 */       rs.put("responseCode", "00");
/*  94 */       rs.put("data", data);
/*     */     }
/*  96 */     catch (Exception e) {
/*  97 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  98 */       logger.error(exceptionAsString);
/*  99 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 101 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_supplier/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 106 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 109 */       if (id == null) {
/* 110 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 113 */       Optional<MedicProductSupplier> g = this.medicProductSupplierRepository.findById(id);
/* 114 */       if (!g.isPresent()) {
/* 115 */         return this.apiError.getError("02");
/*     */       }
/* 117 */       rs.put("status", "OK");
/* 118 */       rs.put("responseCode", "00");
/* 119 */       rs.put("data", g.get());
/*     */     }
/* 121 */     catch (Exception e) {
/* 122 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 123 */       logger.error(exceptionAsString);
/* 124 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 126 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_product_supplier"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicProductSupplier request) {
/* 131 */     ApiResponse rs = new ApiResponse();
/* 132 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 134 */       MedicProductSupplier medicProductSupplier = this.medicProductSupplierRepository.findByCode(request.getCode());
/* 135 */       if (Objects.nonNull(medicProductSupplier)) {
/* 136 */         return this.apiError.getError("05");
/*     */       }
/* 138 */       request.setCreatedAt(new Date());
/* 139 */       MedicProductSupplier result = (MedicProductSupplier)this.medicProductSupplierRepository.saveAndFlush(request);
/*     */       
/* 141 */       data.put("id", Integer.valueOf(result.getId()));
/* 142 */       rs.put("status", "OK");
/* 143 */       rs.put("responseCode", "00");
/* 144 */       rs.put("data", data);
/*     */     }
/* 146 */     catch (Exception e) {
/* 147 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 148 */       logger.error(exceptionAsString);
/* 149 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 151 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_product_supplier/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductSupplier request) {
/* 157 */     ApiResponse rs = new ApiResponse();
/* 158 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 161 */       if (id == null) {
/* 162 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 165 */       Optional<MedicProductSupplier> g = this.medicProductSupplierRepository.findById(id);
/* 166 */       if (!g.isPresent()) {
/* 167 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 170 */       MedicProductSupplier medicProductSupplier = this.medicProductSupplierRepository.findByCode(request.getCode());
/* 171 */       if (Objects.nonNull(medicProductSupplier) && !((MedicProductSupplier)g.get()).getCode().equals(request.getCode())) {
/* 172 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 175 */       request.setId(id.intValue());
/* 176 */       request.setCreatedAt(((MedicProductSupplier)g.get()).getCreatedAt());
/* 177 */       request.setUpdatedAt(new Date());
/* 178 */       request.setCreatorId(((MedicProductSupplier)g.get()).getCreatorId());
/*     */ 
/*     */       
/* 181 */       this.medicProductSupplierRepository.saveAndFlush(request);
/*     */       
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
/*     */   
/*     */   @DeleteMapping({"/medic_product_supplier/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 197 */     ApiResponse rs = new ApiResponse();
/* 198 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 201 */       if (id == null) {
/* 202 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 205 */       Optional<MedicProductSupplier> g = this.medicProductSupplierRepository.findById(id);
/* 206 */       if (!g.isPresent()) {
/* 207 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 210 */       this.medicProductSupplierRepository.delete(g.get());
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


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Supplier\MedicProductSupplierController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */