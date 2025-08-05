/*     */ package nencer.app.Modules.Medic.Controller.PrescriptionCeiling;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.PrescriptionCeiling.MedicPrescriptionCeiling;
/*     */ import nencer.app.Modules.Medic.Model.PrescriptionCeiling.PrescriptionCeilingRequest;
/*     */ import nencer.app.Modules.Medic.Model.PrescriptionCeiling.PrescriptionCeilingResponse;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*     */ public class PrescriptionCeilingController extends BaseMedicController {
/*     */   @PostMapping({"/prescription_ceiling/create"})
/*     */   public ApiResponse prescriptionCeilingCreate(@Valid @RequestBody PrescriptionCeilingRequest request) {
/*  27 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  30 */       MedicPrescriptionCeiling medicPrescriptionCeiling = this.prescriptionCeilingRepository.findByDiagnosticCode(request.getDiagnosticCode()).orElse(null);
/*  31 */       if (Objects.isNull(medicPrescriptionCeiling)) {
/*  32 */         return this.apiError.getError("613");
/*     */       }
/*  34 */       MedicPrescriptionCeiling prescriptionCeiling = (MedicPrescriptionCeiling)this.modelMapper.map(request, MedicPrescriptionCeiling.class);
/*  35 */       prescriptionCeiling.setCreatedAt(new Date());
/*     */       
/*  37 */       MedicPrescriptionCeiling ceiling = (MedicPrescriptionCeiling)this.prescriptionCeilingRepository.saveAndFlush(prescriptionCeiling);
/*  38 */       rs.put("status", "OK");
/*  39 */       rs.put("responseCode", "00");
/*  40 */       rs.put("data", Integer.valueOf(ceiling.getId()));
/*  41 */     } catch (Exception e) {
/*  42 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  43 */       logger.error(exceptionAsString);
/*  44 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  45 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  47 */     return rs;
/*     */   } @Autowired
/*     */   PrescriptionCeilingRepository prescriptionCeilingRepository;
/*     */   @PutMapping({"/prescription_ceiling/edit/{id}"})
/*     */   public ApiResponse prescriptionCeilingEdit(@Valid @PathVariable Integer id, @Valid @RequestBody PrescriptionCeilingRequest request) {
/*  52 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  55 */       if (id == null) {
/*  56 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  59 */       Optional<MedicPrescriptionCeiling> g = this.prescriptionCeilingRepository.findById(id);
/*  60 */       if (!g.isPresent()) {
/*  61 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  64 */       MedicPrescriptionCeiling medicPrescriptionCeiling = this.prescriptionCeilingRepository.findByDiagnosticCode(request.getDiagnosticCode()).orElse(null);
/*  65 */       if (Objects.isNull(medicPrescriptionCeiling) && !((MedicPrescriptionCeiling)g.get()).getDiagnosticCode().equals(request.getDiagnosticCode())) {
/*  66 */         return this.apiError.getError("613");
/*     */       }
/*  68 */       MedicPrescriptionCeiling ceiling = (MedicPrescriptionCeiling)this.modelMapper.map(request, MedicPrescriptionCeiling.class);
/*  69 */       ceiling.setId(id.intValue());
/*  70 */       ceiling.setCreatedAt(((MedicPrescriptionCeiling)g.get()).getCreatedAt());
/*  71 */       ceiling.setUpdatedAt(new Date());
/*     */       
/*  73 */       this.prescriptionCeilingRepository.saveAndFlush(ceiling);
/*     */       
/*  75 */       rs.put("status", "OK");
/*  76 */       rs.put("responseCode", "00");
/*     */     }
/*  78 */     catch (Exception e) {
/*  79 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  80 */       logger.error(exceptionAsString);
/*  81 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  82 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  84 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/prescription_ceiling/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/*  89 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  92 */       if (id == null) {
/*  93 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  96 */       Optional<MedicPrescriptionCeiling> g = this.prescriptionCeilingRepository.findById(id);
/*  97 */       if (!g.isPresent()) {
/*  98 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 102 */       this.prescriptionCeilingRepository.deleteById(id);
/*     */       
/* 104 */       rs.put("status", "OK");
/* 105 */       rs.put("responseCode", "00");
/*     */     }
/* 107 */     catch (Exception e) {
/* 108 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 109 */       logger.error(exceptionAsString);
/* 110 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 112 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/prescription_ceiling/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 117 */     ApiResponse rs = new ApiResponse();
/* 118 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 121 */       if (id == null) {
/* 122 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 125 */       Optional<MedicPrescriptionCeiling> g = this.prescriptionCeilingRepository.findById(id);
/* 126 */       if (!g.isPresent()) {
/* 127 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 130 */       rs.put("status", "OK");
/* 131 */       rs.put("responseCode", "00");
/* 132 */       rs.put("data", g.get());
/*     */     }
/* 134 */     catch (Exception e) {
/* 135 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 136 */       logger.error(exceptionAsString);
/* 137 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 139 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/prescription_ceiling"})
/*     */   public ApiResponse getPaging1(@RequestParam(required = false) String code, @RequestParam(required = false) String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 148 */     ApiResponse rs = new ApiResponse();
/* 149 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 152 */       List<PrescriptionCeilingResponse> list = this.medicService.sp_get_prescription_ceiling(page, size, code, name);
/*     */ 
/*     */       
/* 155 */       data.put("checkins", list);
/* 156 */       data.put("totalItems", !list.isEmpty() ? ((PrescriptionCeilingResponse)list.get(0)).getTotalRecord() : null);
/* 157 */       data.put("totalPages", "");
/*     */       
/* 159 */       rs.put("status", "OK");
/* 160 */       rs.put("responseCode", "00");
/* 161 */       rs.put("data", data);
/*     */     }
/* 163 */     catch (Exception e) {
/* 164 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 165 */       logger.error(exceptionAsString);
/* 166 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 168 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\PrescriptionCeiling\PrescriptionCeilingController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */