/*     */ package nencer.app.Modules.Medic.Controller.InsuranceCards;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Controller.DiagnosticController;
/*     */ import nencer.app.Modules.Medic.Entity.Insurance.MedicInsuranceCards;
/*     */ import nencer.app.Modules.Medic.Model.InsuranceCards.InsuranceCardsRequest;
/*     */ import nencer.app.Modules.Medic.Model.InsuranceCards.InsuranceCardsResponse;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class InsuranceCardsController extends BaseMedicController {
/*  35 */   public static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   InsuranceCardsRepository insuranceCardsRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_insurance_cards"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  53 */     ApiResponse rs = new ApiResponse();
/*  54 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  56 */       List<InsuranceCardsResponse> list = this.medicService.spGetSearchInsuranceCards(page, size, searchValue, fieldSort, direction);
/*     */       
/*  58 */       data.put("dataRes", list);
/*  59 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((InsuranceCardsResponse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  61 */       rs.put("status", "OK");
/*  62 */       rs.put("responseCode", "00");
/*  63 */       rs.put("data", data);
/*     */     }
/*  65 */     catch (Exception e) {
/*  66 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  67 */       logger.error(exceptionAsString);
/*  68 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  70 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_insurance_cards/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  76 */     ApiResponse rs = new ApiResponse();
/*  77 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  80 */       if (id == null) {
/*  81 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  84 */       Optional<MedicInsuranceCards> g = this.insuranceCardsRepository.findById(id);
/*  85 */       if (!g.isPresent()) {
/*  86 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  89 */       rs.put("status", "OK");
/*  90 */       rs.put("responseCode", "00");
/*  91 */       rs.put("data", this.modelMapper.map(g.get(), InsuranceCardsRequest.class));
/*     */     }
/*  93 */     catch (Exception e) {
/*  94 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  95 */       logger.error(exceptionAsString);
/*  96 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  98 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_insurance_cards/create"})
/*     */   public ApiResponse create(@Valid @RequestBody InsuranceCardsRequest request) {
/* 103 */     ApiResponse rs = new ApiResponse();
/* 104 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 106 */       MedicInsuranceCards cards = this.insuranceCardsRepository.findByInsuranceCode(request.getInsuranceCode()).orElse(null);
/* 107 */       if (Objects.nonNull(cards)) {
/* 108 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 111 */       MedicInsuranceCards insuranceCards = (MedicInsuranceCards)this.modelMapper.map(request, MedicInsuranceCards.class);
/* 112 */       MedicInsuranceCards result = (MedicInsuranceCards)this.insuranceCardsRepository.saveAndFlush(insuranceCards);
/*     */       
/* 114 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
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
/*     */   @PutMapping({"/medic_insurance_cards/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody InsuranceCardsRequest request) {
/* 130 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 134 */       if (id == null) {
/* 135 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 138 */       Optional<MedicInsuranceCards> g = this.insuranceCardsRepository.findById(id);
/* 139 */       if (!g.isPresent()) {
/* 140 */         return this.apiError.getError("02");
/*     */       }
/* 142 */       MedicInsuranceCards cards = this.insuranceCardsRepository.findByInsuranceCode(request.getInsuranceCode()).orElse(null);
/* 143 */       if (Objects.nonNull(cards) && !((MedicInsuranceCards)g.get()).getInsuranceCode().equalsIgnoreCase(request.getInsuranceCode())) {
/* 144 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 147 */       MedicInsuranceCards medicInsuranceCards = (MedicInsuranceCards)this.modelMapper.map(request, MedicInsuranceCards.class);
/* 148 */       medicInsuranceCards.setId(id.intValue());
/*     */ 
/*     */ 
/*     */       
/* 152 */       this.insuranceCardsRepository.saveAndFlush(medicInsuranceCards);
/*     */       
/* 154 */       rs.put("status", "OK");
/* 155 */       rs.put("responseCode", "00");
/*     */     
/*     */     }
/* 158 */     catch (Exception e) {
/* 159 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 160 */       logger.error(exceptionAsString);
/* 161 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 163 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_insurance_cards/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 168 */     ApiResponse rs = new ApiResponse();
/* 169 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 172 */       if (id == null) {
/* 173 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 176 */       Optional<MedicInsuranceCards> g = this.insuranceCardsRepository.findById(id);
/* 177 */       if (!g.isPresent()) {
/* 178 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 182 */       this.insuranceCardsRepository.delete(g.get());
/*     */       
/* 184 */       rs.put("status", "OK");
/* 185 */       rs.put("responseCode", "00");
/* 186 */       rs.put("data", data);
/*     */     }
/* 188 */     catch (Exception e) {
/* 189 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 190 */       logger.error(exceptionAsString);
/* 191 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 193 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_insurance_cards/getAll"})
/*     */   public ApiResponse getAll() {
/* 197 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 200 */       List<MedicInsuranceCards> medicInsuranceCards = this.insuranceCardsRepository.findAll();
/*     */ 
/*     */       
/* 203 */       rs.put("status", "OK");
/* 204 */       rs.put("responseCode", "00");
/* 205 */       rs.put("data", medicInsuranceCards);
/*     */     }
/* 207 */     catch (Exception e) {
/* 208 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 209 */       logger.error(exceptionAsString);
/* 210 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 212 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\InsuranceCards\InsuranceCardsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */