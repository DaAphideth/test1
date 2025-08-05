/*     */ package nencer.app.Modules.Medic.Controller.Drug;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugIngredients;
/*     */ import nencer.app.Modules.Medic.Model.Drug.DrugIngredientsResponse;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProduct;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
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
/*     */ public class MedicDrugIngredientsController extends BaseMedicController {
/*  37 */   public static final Logger logger = LoggerFactory.getLogger(MedicDrugIngredientsController.class);
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
/*     */   MedicDrugIngredientsRepository medicDrugIngredientsRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicProductRepository medicProductRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_drug_ingredients"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String searchValue, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  58 */     ApiResponse rs = new ApiResponse();
/*  59 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  62 */       List<DrugIngredientsResponse> list = this.medicService.spGetSearchDrugIngredients(page, size, searchValue, fieldSort, direction);
/*     */       
/*  64 */       data.put("dataRes", list);
/*  65 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((DrugIngredientsResponse)list.get(0)).getTotalRecord().intValue() : 0));
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
/*     */   @GetMapping({"/medic_drug_ingredients/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  81 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  84 */       if (id == null) {
/*  85 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  88 */       Optional<MedicDrugIngredients> g = this.medicDrugIngredientsRepository.findById(id);
/*  89 */       if (!g.isPresent()) {
/*  90 */         return this.apiError.getError("02");
/*     */       }
/*  92 */       rs.put("status", "OK");
/*  93 */       rs.put("responseCode", "00");
/*  94 */       rs.put("data", g.get());
/*     */     }
/*  96 */     catch (Exception e) {
/*  97 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  98 */       logger.error(exceptionAsString);
/*  99 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 101 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_drug_ingredients"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicDrugIngredients request) {
/* 106 */     ApiResponse rs = new ApiResponse();
/* 107 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 109 */       List<MedicDrugIngredients> drugIngredients = this.medicDrugIngredientsRepository.findAllByCode(request.getCode());
/* 110 */       if (CollectionUtils.isNotEmpty(drugIngredients)) {
/* 111 */         return this.apiError.getError("05");
/*     */       }
/* 113 */       request.setCreatedAt(new Date());
/* 114 */       MedicDrugIngredients result = (MedicDrugIngredients)this.medicDrugIngredientsRepository.saveAndFlush(request);
/*     */       
/* 116 */       data.put("id", Integer.valueOf(result.getId()));
/* 117 */       rs.put("status", "OK");
/* 118 */       rs.put("responseCode", "00");
/* 119 */       rs.put("data", data);
/*     */     }
/* 121 */     catch (Exception e) {
/* 122 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 123 */       logger.error(exceptionAsString);
/* 124 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 126 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_drug_ingredients/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicDrugIngredients request) {
/* 132 */     ApiResponse rs = new ApiResponse();
/* 133 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 136 */       if (id == null) {
/* 137 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 140 */       Optional<MedicDrugIngredients> g = this.medicDrugIngredientsRepository.findById(id);
/* 141 */       if (!g.isPresent()) {
/* 142 */         return this.apiError.getError("02");
/*     */       }
/* 144 */       List<MedicDrugIngredients> drugIngredients = this.medicDrugIngredientsRepository.findAllByCode(request.getCode());
/* 145 */       if (CollectionUtils.isNotEmpty(drugIngredients) && !((MedicDrugIngredients)g.get()).getCode().equals(request.getCode())) {
/* 146 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 149 */       request.setId(id.intValue());
/* 150 */       request.setCreatedAt(((MedicDrugIngredients)g.get()).getCreatedAt());
/* 151 */       request.setUpdatedAt(new Date());
/*     */       
/* 153 */       this.medicDrugIngredientsRepository.saveAndFlush(request);
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
/*     */   @DeleteMapping({"/medic_drug_ingredients/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 169 */     ApiResponse rs = new ApiResponse();
/* 170 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 173 */       if (id == null) {
/* 174 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 177 */       Optional<MedicDrugIngredients> g = this.medicDrugIngredientsRepository.findById(id);
/* 178 */       if (!g.isPresent()) {
/* 179 */         return this.apiError.getError("02");
/*     */       }
/* 181 */       List<MedicProduct> medicProduct = this.medicProductRepository.findByActiveIngCode(((MedicDrugIngredients)g.get()).getCode()).orElse(new ArrayList<>());
/* 182 */       if (CollectionUtils.isNotEmpty(medicProduct)) {
/* 183 */         return this.apiError.getError("512");
/*     */       }
/*     */       
/* 186 */       this.medicDrugIngredientsRepository.delete(g.get());
/* 187 */       rs.put("status", "OK");
/* 188 */       rs.put("responseCode", "00");
/* 189 */       rs.put("data", data);
/*     */     }
/* 191 */     catch (Exception e) {
/* 192 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 193 */       logger.error(exceptionAsString);
/* 194 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 196 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_drug_ingredients/get_all"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter) {
/* 200 */     ApiResponse rs = new ApiResponse();
/* 201 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 203 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 204 */       if (!StringUtils.isEmpty(filter)) {
/* 205 */         ObjectMapper objectMapper = new ObjectMapper();
/* 206 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/* 210 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/* 212 */       List<MedicDrugIngredients> pages = this.medicDrugIngredientsRepository.findAll((Specification)specifications);
/* 213 */       data.put("medicDrugIngredients", pages);
/*     */       
/* 215 */       rs.put("status", "OK");
/* 216 */       rs.put("responseCode", "00");
/* 217 */       rs.put("data", data);
/*     */     }
/* 219 */     catch (Exception e) {
/* 220 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 221 */       logger.error(exceptionAsString);
/* 222 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 224 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Drug\MedicDrugIngredientsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */