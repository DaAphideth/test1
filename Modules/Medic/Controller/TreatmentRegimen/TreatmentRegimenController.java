/*     */ package nencer.app.Modules.Medic.Controller.TreatmentRegimen;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenDiagnostic;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenDrugIngredients;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenService;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicTreatmentRegimen;
/*     */ import nencer.app.Modules.Medic.Model.TreatmentRegimen.TreatmentRegimenRequest;
/*     */ import nencer.app.Modules.Medic.Model.TreatmentRegimen.TreatmentRegimenResponse;
/*     */ import nencer.app.Modules.Medic.Repository.TreatmentRegimen.RegimenDiagnosticRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TreatmentRegimen.RegimenServiceRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TreatmentRegimen.TreatmentRegimenRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class TreatmentRegimenController extends BaseMedicController {
/*     */   @Autowired
/*     */   TreatmentRegimenRepository treatmentRegimenRepository;
/*     */   @Autowired
/*     */   RegimenDiagnosticRepository regimenDiagnosticRepository;
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/treatment_regimen/create"})
/*     */   public ApiResponse treatmentRegimenCreate(@Valid @RequestBody TreatmentRegimenRequest request) {
/*  45 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  47 */       MedicTreatmentRegimen treatmentRegimenName = this.treatmentRegimenRepository.findByRegimenName(request.getRegimenName()).orElse(null);
/*  48 */       if (Objects.nonNull(treatmentRegimenName)) {
/*  49 */         return this.apiError.getError("01", new String[0]);
/*     */       }
/*  51 */       MedicTreatmentRegimen treatmentRegimen = (MedicTreatmentRegimen)this.modelMapper.map(request, MedicTreatmentRegimen.class);
/*  52 */       treatmentRegimen.setCreatedAt(new Date());
/*     */       
/*  54 */       MedicTreatmentRegimen regimen = (MedicTreatmentRegimen)this.treatmentRegimenRepository.saveAndFlush(treatmentRegimen);
/*  55 */       saveAttachedProtocol(regimen);
/*  56 */       rs.put("status", "OK");
/*  57 */       rs.put("responseCode", "00");
/*  58 */       rs.put("data", Integer.valueOf(regimen.getId()));
/*  59 */     } catch (Exception e) {
/*  60 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  61 */       logger.error(exceptionAsString);
/*  62 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  63 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  65 */     return rs;
/*     */   } @Autowired
/*     */   RegimenServiceRepository regimenServiceRepository; @Autowired
/*     */   RegimenDrugIngredientsRepository drugIngredientsRepository; @PutMapping({"/treatment_regimen/edit/{id}"})
/*     */   public ApiResponse treatmentRegimenEdit(@Valid @PathVariable Integer id, @Valid @RequestBody TreatmentRegimenRequest request) {
/*  70 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  73 */       if (id == null) {
/*  74 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  77 */       Optional<MedicTreatmentRegimen> g = this.treatmentRegimenRepository.findById(id);
/*  78 */       if (!g.isPresent()) {
/*  79 */         return this.apiError.getError("02");
/*     */       }
/*  81 */       MedicTreatmentRegimen treatmentRegimenName = this.treatmentRegimenRepository.findByRegimenName(request.getRegimenName()).orElse(null);
/*  82 */       if (Objects.nonNull(treatmentRegimenName) && !((MedicTreatmentRegimen)g.get()).getRegimenName().equals(request.getRegimenName())) {
/*  83 */         return this.apiError.getError("01");
/*     */       }
/*  85 */       MedicTreatmentRegimen treatmentRegimen = (MedicTreatmentRegimen)this.modelMapper.map(request, MedicTreatmentRegimen.class);
/*  86 */       treatmentRegimen.setId(id.intValue());
/*  87 */       treatmentRegimen.setCreatedAt(((MedicTreatmentRegimen)g.get()).getCreatedAt());
/*  88 */       treatmentRegimen.setUpdatedAt(new Date());
/*     */       
/*  90 */       MedicTreatmentRegimen medicTreatmentRegimen = (MedicTreatmentRegimen)this.treatmentRegimenRepository.saveAndFlush(treatmentRegimen);
/*  91 */       this.regimenDiagnosticRepository.deleteRegimenId(treatmentRegimen.getId());
/*  92 */       this.regimenServiceRepository.deleteRegimenId(treatmentRegimen.getId());
/*  93 */       this.drugIngredientsRepository.deleteRegimenId(treatmentRegimen.getId());
/*  94 */       saveAttachedProtocol(medicTreatmentRegimen);
/*  95 */       rs.put("status", "OK");
/*  96 */       rs.put("responseCode", "00");
/*     */     }
/*  98 */     catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       logger.error(exceptionAsString);
/* 101 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 102 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 104 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/treatment_regimen/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 109 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 112 */       if (id == null) {
/* 113 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 116 */       Optional<MedicTreatmentRegimen> g = this.treatmentRegimenRepository.findById(id);
/* 117 */       if (!g.isPresent()) {
/* 118 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 122 */       this.treatmentRegimenRepository.deleteById(id);
/*     */       
/* 124 */       rs.put("status", "OK");
/* 125 */       rs.put("responseCode", "00");
/*     */     }
/* 127 */     catch (Exception e) {
/* 128 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 129 */       logger.error(exceptionAsString);
/* 130 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 132 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/treatment_regimen/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 137 */     ApiResponse rs = new ApiResponse();
/* 138 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 141 */       if (id == null) {
/* 142 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 145 */       Optional<MedicTreatmentRegimen> g = this.treatmentRegimenRepository.findById(id);
/* 146 */       if (!g.isPresent()) {
/* 147 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 150 */       rs.put("status", "OK");
/* 151 */       rs.put("responseCode", "00");
/* 152 */       rs.put("data", g.get());
/*     */     }
/* 154 */     catch (Exception e) {
/* 155 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 156 */       logger.error(exceptionAsString);
/* 157 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 159 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/treatment_regimen"})
/*     */   public ApiResponse getPaging1(@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 167 */     ApiResponse rs = new ApiResponse();
/* 168 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 171 */       List<TreatmentRegimenResponse> list = this.medicService.sp_get_treatment_regimen(page, size, name);
/*     */ 
/*     */       
/* 174 */       data.put("checkins", list);
/* 175 */       data.put("totalItems", !list.isEmpty() ? ((TreatmentRegimenResponse)list.get(0)).getTotalRecord() : null);
/* 176 */       data.put("totalPages", "");
/*     */       
/* 178 */       rs.put("status", "OK");
/* 179 */       rs.put("responseCode", "00");
/* 180 */       rs.put("data", data);
/*     */     }
/* 182 */     catch (Exception e) {
/* 183 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 184 */       logger.error(exceptionAsString);
/* 185 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 187 */     return rs;
/*     */   }
/*     */   
/*     */   private void saveAttachedProtocol(MedicTreatmentRegimen regimen) {
/* 191 */     String[] diagnosticCode = regimen.getDiagnosticCode().split(",");
/* 192 */     String[] serviceId = regimen.getServiceId().split(",");
/* 193 */     String[] drugIngredient = regimen.getDrugIngredient().split(",");
/* 194 */     for (String a : diagnosticCode) {
/* 195 */       MedicRegimenDiagnostic diagnostic = new MedicRegimenDiagnostic();
/* 196 */       diagnostic.setRegimenId(regimen.getId());
/* 197 */       diagnostic.setRegimenName(regimen.getRegimenName());
/* 198 */       diagnostic.setDiagnosticCode(a);
/* 199 */       this.regimenDiagnosticRepository.saveAndFlush(diagnostic);
/*     */     } 
/* 201 */     for (String b : serviceId) {
/* 202 */       MedicRegimenService regimenService = new MedicRegimenService();
/* 203 */       regimenService.setRegimenId(regimen.getId());
/* 204 */       regimenService.setRegimenName(regimen.getRegimenName());
/* 205 */       regimenService.setServiceId(Integer.parseInt(b));
/* 206 */       this.regimenServiceRepository.saveAndFlush(regimenService);
/*     */     } 
/* 208 */     for (String c : drugIngredient) {
/* 209 */       MedicRegimenDrugIngredients regimenDrugIngredients = new MedicRegimenDrugIngredients();
/* 210 */       regimenDrugIngredients.setRegimenId(regimen.getId());
/* 211 */       regimenDrugIngredients.setRegimenName(regimen.getRegimenName());
/* 212 */       regimenDrugIngredients.setDrugIngredientsId(Integer.parseInt(c));
/* 213 */       this.drugIngredientsRepository.saveAndFlush(regimenDrugIngredients);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\TreatmentRegimen\TreatmentRegimenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */