/*    */ package nencer.app.Modules.Medic.Controller;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.validation.Valid;
/*    */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordHis;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class MedicCheckinRecordController
/*    */   extends BaseMedicController
/*    */ {
/*    */   @GetMapping({"/medic_checkin_record/his/{checkInId}"})
/*    */   public ApiResponse getHisByCheckin(@PathVariable @Valid Integer checkInId) {
/* 25 */     ApiResponse rs = new ApiResponse();
/* 26 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 28 */       List<MedicCheckinRecordHis> hisList = this.commonCheckinRepo.getMedicCheckinRecordHis(checkInId);
/* 29 */       data.put("checkins", hisList);
/* 30 */       data.put("totalItems", Integer.valueOf(hisList.size()));
/* 31 */       rs.put("status", "OK");
/* 32 */       rs.put("responseCode", "00");
/* 33 */       rs.put("data", data);
/*    */     }
/* 35 */     catch (Exception e) {
/* 36 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 37 */       logger.error(exceptionAsString);
/* 38 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 40 */     return rs;
/*    */   }
/*    */   
/*    */   @GetMapping({"/medic_checkin_record/his1/{patientId}"})
/*    */   public ApiResponse getPatientIdHisByCheckin(@PathVariable @Valid Integer patientId) {
/* 45 */     ApiResponse rs = new ApiResponse();
/* 46 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 48 */       List<MedicCheckinRecordHis> hisPatientIdList = this.commonCheckinRepo.getMedicCheckinRecordPatientIdHis(patientId);
/* 49 */       data.put("checkins", hisPatientIdList);
/* 50 */       data.put("totalItems", Integer.valueOf(hisPatientIdList.size()));
/* 51 */       rs.put("status", "OK");
/* 52 */       rs.put("responseCode", "00");
/* 53 */       rs.put("data", data);
/*    */     }
/* 55 */     catch (Exception e) {
/* 56 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 57 */       logger.error(exceptionAsString);
/* 58 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 60 */     return rs;
/*    */   }
/*    */   
/*    */   @GetMapping({"/medic_checkin_record/his2/{patientId}"})
/*    */   public ApiResponse getPatientIdHisByCheckin1(@PathVariable @Valid Integer patientId) {
/* 65 */     ApiResponse rs = new ApiResponse();
/* 66 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 68 */       List<MedicCheckinRecordHis> hisPatientIdList = this.commonCheckinRepo.getMedicCheckinRecordPatientIdHis1(patientId);
/* 69 */       data.put("checkins", hisPatientIdList);
/* 70 */       data.put("totalItems", Integer.valueOf(hisPatientIdList.size()));
/* 71 */       rs.put("status", "OK");
/* 72 */       rs.put("responseCode", "00");
/* 73 */       rs.put("data", data);
/*    */     }
/* 75 */     catch (Exception e) {
/* 76 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 77 */       logger.error(exceptionAsString);
/* 78 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 80 */     return rs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\MedicCheckinRecordController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */