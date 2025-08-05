/*     */ package nencer.app.Modules.Medic.Controller.DrugIngredientInteraction;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.DrugIngredientInteraction.MedicDrugIngredientInteraction;
/*     */ import nencer.app.Modules.Medic.Model.DrugIngredientInteraction.DrugIngredientInteractionRequest;
/*     */ import nencer.app.Modules.Medic.Model.DrugIngredientInteraction.DrugIngredientInteractionResponse;
/*     */ import nencer.app.Modules.Medic.Repository.DrugIngredientInteraction.DrugIngredientInteractionRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class DrugIngredientInteractionController extends BaseMedicController {
/*     */   @PostMapping({"/drug_ingredient_interaction/create"})
/*     */   public ApiResponse drugIngredientInteractionCreate(@Valid @RequestBody DrugIngredientInteractionRequest request) {
/*  28 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  30 */       MedicDrugIngredientInteraction interaction = (MedicDrugIngredientInteraction)this.modelMapper.map(request, MedicDrugIngredientInteraction.class);
/*  31 */       interaction.setCreatedAt(new Date());
/*     */       
/*  33 */       MedicDrugIngredientInteraction ingredientInteraction = (MedicDrugIngredientInteraction)this.drugIngredientInteractionRepository.saveAndFlush(interaction);
/*  34 */       rs.put("status", "OK");
/*  35 */       rs.put("responseCode", "00");
/*  36 */       rs.put("data", Integer.valueOf(ingredientInteraction.getId()));
/*  37 */     } catch (Exception e) {
/*  38 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  39 */       logger.error(exceptionAsString);
/*  40 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  41 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  43 */     return rs;
/*     */   } @Autowired
/*     */   DrugIngredientInteractionRepository drugIngredientInteractionRepository;
/*     */   @PutMapping({"/drug_ingredient_interaction/edit/{id}"})
/*     */   public ApiResponse drugIngredientInteractionEdit(@Valid @PathVariable Integer id, @Valid @RequestBody DrugIngredientInteractionRequest request) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  51 */       if (id == null) {
/*  52 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  55 */       Optional<MedicDrugIngredientInteraction> g = this.drugIngredientInteractionRepository.findById(id);
/*  56 */       if (!g.isPresent()) {
/*  57 */         return this.apiError.getError("02");
/*     */       }
/*  59 */       MedicDrugIngredientInteraction interaction = (MedicDrugIngredientInteraction)this.modelMapper.map(request, MedicDrugIngredientInteraction.class);
/*  60 */       interaction.setId(id.intValue());
/*  61 */       interaction.setCreatedAt(((MedicDrugIngredientInteraction)g.get()).getCreatedAt());
/*  62 */       interaction.setUpdatedAt(new Date());
/*     */       
/*  64 */       this.drugIngredientInteractionRepository.saveAndFlush(interaction);
/*     */       
/*  66 */       rs.put("status", "OK");
/*  67 */       rs.put("responseCode", "00");
/*     */     }
/*  69 */     catch (Exception e) {
/*  70 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  71 */       logger.error(exceptionAsString);
/*  72 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  73 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  75 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/drug_ingredient_interaction/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  83 */       if (id == null) {
/*  84 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  87 */       Optional<MedicDrugIngredientInteraction> g = this.drugIngredientInteractionRepository.findById(id);
/*  88 */       if (!g.isPresent()) {
/*  89 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/*  93 */       this.drugIngredientInteractionRepository.deleteById(id);
/*     */       
/*  95 */       rs.put("status", "OK");
/*  96 */       rs.put("responseCode", "00");
/*     */     }
/*  98 */     catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       logger.error(exceptionAsString);
/* 101 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 103 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/drug_ingredient_interaction/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 108 */     ApiResponse rs = new ApiResponse();
/* 109 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 112 */       if (id == null) {
/* 113 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 116 */       Optional<MedicDrugIngredientInteraction> g = this.drugIngredientInteractionRepository.findById(id);
/* 117 */       if (!g.isPresent()) {
/* 118 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 121 */       rs.put("status", "OK");
/* 122 */       rs.put("responseCode", "00");
/* 123 */       rs.put("data", this.modelMapper.map(g.get(), DrugIngredientInteractionResponse.class));
/*     */     }
/* 125 */     catch (Exception e) {
/* 126 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 127 */       logger.error(exceptionAsString);
/* 128 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 130 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/drug_ingredient_interaction"})
/*     */   public ApiResponse getPaging1(@RequestParam(required = false) String code, @RequestParam(required = false) String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 138 */     ApiResponse rs = new ApiResponse();
/* 139 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 142 */       List<DrugIngredientInteractionResponse> list = this.medicService.sp_get_drug_ingredient_interaction(page, size, code, name);
/*     */ 
/*     */       
/* 145 */       data.put("checkins", list);
/* 146 */       data.put("totalItems", !list.isEmpty() ? ((DrugIngredientInteractionResponse)list.get(0)).getTotalRecord() : null);
/* 147 */       data.put("totalPages", "");
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
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\DrugIngredientInteraction\DrugIngredientInteractionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */