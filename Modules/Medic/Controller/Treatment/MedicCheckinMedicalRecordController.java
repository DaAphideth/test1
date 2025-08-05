/*    */ package nencer.app.Modules.Medic.Controller.Treatment;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Optional;
/*    */ import javax.validation.Valid;
/*    */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*    */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*    */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinMedicalRecord;
/*    */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinMedicalRecordRepository;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.transaction.annotation.Propagation;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class MedicCheckinMedicalRecordController extends BaseMedicController {
/* 28 */   public static final Logger logger = LoggerFactory.getLogger(MedicCheckinMedicalRecordController.class);
/*    */ 
/*    */   
/*    */   @Autowired
/*    */   MedicCheckinMedicalRecordRepository medicCheckinMedicalRecordRepository;
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/medic_checkin_medical_record/{mdId}"})
/*    */   public ApiResponse getInputPatient(@PathVariable @Valid Integer mdId) {
/* 38 */     ApiResponse rs = new ApiResponse();
/*    */     try {
/* 40 */       Optional<MedicCheckinMedicalRecord> medicTestDevice = this.medicCheckinMedicalRecordRepository.findByMdId(mdId.intValue());
/* 41 */       if (!medicTestDevice.isPresent()) {
/* 42 */         return this.apiError.getError("05", new String[0]);
/*    */       }
/* 44 */       rs.put("status", "OK");
/* 45 */       rs.put("responseCode", "00");
/* 46 */       rs.put("data", medicTestDevice);
/*    */     }
/* 48 */     catch (Exception e) {
/* 49 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 50 */       logger.error(exceptionAsString);
/* 51 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 53 */     return rs;
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*    */   @PostMapping({"/medic_checkin_medical_record/create"})
/*    */   public ApiResponse create(@Valid @RequestBody MedicCheckinMedicalRecord medicCheckinRecordRq) {
/* 60 */     ApiResponse rs = new ApiResponse();
/* 61 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 63 */       Optional<MedicCheckinRecord> medicTestDevice = this.medicCheckinRecordRepository.findById(Integer.valueOf(medicCheckinRecordRq.getMdId()));
/* 64 */       if (!medicTestDevice.isPresent()) {
/* 65 */         return this.apiError.getError("02", new String[0]);
/*    */       }
/* 67 */       this.medicCheckinMedicalRecordRepository.deleteByMdId(Integer.valueOf(medicCheckinRecordRq.getMdId()));
/* 68 */       this.medicCheckinMedicalRecordRepository.saveAndFlush(medicCheckinRecordRq);
/*    */       
/* 70 */       rs.put("status", "OK");
/* 71 */       rs.put("responseCode", "00");
/* 72 */       rs.put("data", "THANH CONG");
/*    */     }
/* 74 */     catch (Exception e) {
/* 75 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 76 */       logger.error(exceptionAsString);
/* 77 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 78 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 80 */     return rs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\MedicCheckinMedicalRecordController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */