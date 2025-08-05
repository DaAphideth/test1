/*     */ package nencer.app.Modules.Medic.Controller.Treatment;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetail;
/*     */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinTreatmentDetailRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinTreatmentDetailTicketRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.CommonStoreHouseRepo;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicCheckinTreatmentDetailController
/*     */   extends BaseMedicController
/*     */ {
/*  37 */   public static final Logger logger = LoggerFactory.getLogger(MedicCheckinTreatmentDetailController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinTreatmentDetailRepository medicCheckinTreatmentDetailRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinTreatmentDetailTicketRepository medicCheckinTreatmentDetailTicketRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   CommonStoreHouseRepo commonStoreHouseRepo;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin_treatment_detail"})
/*     */   public ApiResponse getInputPatient(@Valid @RequestParam int mdId, @Valid @RequestParam(required = false) String fromDate, @Valid @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  58 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  60 */       Date f = DataUtil.safeToDate2(fromDate);
/*  61 */       Date t = DataUtil.safeToDate2(toDate);
/*  62 */       List<MedicCheckinTreatmentDetail> medicCheckinLiveDetails = this.medicService.sp_get_search_checkin_treatment_detail(page, size, Integer.valueOf(mdId), f, t);
/*  63 */       rs.put("status", "OK");
/*  64 */       rs.put("responseCode", "00");
/*  65 */       rs.put("data", medicCheckinLiveDetails);
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  69 */       logger.error(exceptionAsString);
/*  70 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  72 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_checkin_treatment_detail/create"})
/*     */   public ApiResponse create(@RequestBody MedicCheckinTreatmentDetail request) {
/*  78 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  80 */       Optional<MedicCheckinRecord> medicTestDevice = this.medicCheckinRecordRepository.findById(request.getMdId());
/*  81 */       if (!medicTestDevice.isPresent()) {
/*  82 */         return this.apiError.getError("05", new String[0]);
/*     */       }
/*  84 */       if (request.getNgayYLenh() != null) {
/*  85 */         request.setCreatedDate(request.getNgayYLenh());
/*     */       } else {
/*  87 */         request.setCreatedDate(new Date());
/*     */       } 
/*  89 */       this.medicCheckinTreatmentDetailRepository.saveAndFlush(request);
/*  90 */       rs.put("status", "OK");
/*  91 */       rs.put("responseCode", "00");
/*  92 */       rs.put("data", "THANH CONG");
/*  93 */     } catch (Exception e) {
/*  94 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  95 */       logger.error(exceptionAsString);
/*  96 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  98 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_checkin_treatment_detail/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @RequestBody MedicCheckinTreatmentDetail request) {
/* 103 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 105 */       if (id == null) {
/* 106 */         return this.apiError.getError("02");
/*     */       }
/* 108 */       Optional<MedicCheckinTreatmentDetail> testDevice = this.medicCheckinTreatmentDetailRepository.findById(id);
/* 109 */       if (!testDevice.isPresent()) {
/* 110 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/* 112 */       request.setCreatedDate(((MedicCheckinTreatmentDetail)testDevice.get()).getCreatedDate());
/* 113 */       this.medicCheckinTreatmentDetailRepository.saveAndFlush(request);
/* 114 */       rs.put("status", "OK");
/* 115 */       rs.put("responseCode", "00");
/* 116 */       rs.put("data", "THANH CONG");
/* 117 */     } catch (Exception e) {
/* 118 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 119 */       logger.error(exceptionAsString);
/* 120 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 122 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_checkin_treatment_detail/{id}"})
/*     */   public ApiResponse get(@PathVariable @Valid Integer id) {
/* 127 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 129 */       if (id == null) {
/* 130 */         return this.apiError.getError("02");
/*     */       }
/* 132 */       Optional<MedicCheckinTreatmentDetail> resObj = this.medicCheckinTreatmentDetailRepository.findById(id);
/* 133 */       if (!resObj.isPresent()) {
/* 134 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/* 136 */       rs.put("status", "OK");
/* 137 */       rs.put("responseCode", "00");
/* 138 */       rs.put("data", resObj);
/* 139 */     } catch (Exception e) {
/* 140 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 141 */       logger.error(exceptionAsString);
/* 142 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 144 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_checkin_treatment_detail/get_by_md_id/{mdId}"})
/*     */   public ApiResponse getByMdId(@PathVariable @Valid Integer mdId) {
/* 149 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 152 */       List<MedicCheckinTreatmentDetail> resObj = this.medicService.sp_get_treatment_detail_by_mdId(mdId.intValue());
/* 153 */       rs.put("status", "OK");
/* 154 */       rs.put("responseCode", "00");
/* 155 */       rs.put("data", resObj);
/* 156 */     } catch (Exception e) {
/* 157 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 158 */       logger.error(exceptionAsString);
/* 159 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 161 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_checkin_treatment_detail/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 166 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 169 */       if (id == null) {
/* 170 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 173 */       Optional<MedicCheckinTreatmentDetail> testDevice = this.medicCheckinTreatmentDetailRepository.findById(id);
/* 174 */       if (!testDevice.isPresent()) {
/* 175 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/*     */ 
/*     */       
/* 179 */       this.medicCheckinTreatmentDetailRepository.deleteById(id);
/* 180 */       this.medicCheckinTreatmentDetailTicketRepository.deleteByTreatmentId(id);
/*     */       
/* 182 */       rs.put("status", "OK");
/* 183 */       rs.put("responseCode", "00");
/*     */     }
/* 185 */     catch (Exception e) {
/* 186 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 187 */       logger.error(exceptionAsString);
/* 188 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 190 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/medic_checkin_treatment_detail/delete_by_id_and_ticket/{id}/{ticketId}"})
/*     */   public ApiResponse deleteByIdAndTicketId(@PathVariable @Valid Integer id, @PathVariable @Valid Integer ticketId) {
/* 196 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 199 */       if (id == null) {
/* 200 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 203 */       Optional<MedicCheckinTreatmentDetail> testDevice = this.medicCheckinTreatmentDetailRepository.findById(id);
/* 204 */       if (!testDevice.isPresent()) {
/* 205 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/*     */ 
/*     */       
/* 209 */       this.medicCheckinTreatmentDetailTicketRepository.deleteByTreatmentIdAndTicketId(id, ticketId);
/*     */       
/* 211 */       rs.put("status", "OK");
/* 212 */       rs.put("responseCode", "00");
/*     */     }
/* 214 */     catch (Exception e) {
/* 215 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 216 */       logger.error(exceptionAsString);
/* 217 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 219 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin_treatment_detail/get_title_order/{treatmentId}"})
/*     */   public ApiResponse getTitleOrder(@PathVariable @Valid Integer treatmentId) {
/* 225 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 227 */       rs.put("status", "OK");
/* 228 */       rs.put("responseCode", "00");
/* 229 */       rs.put("data", this.medicService.getTreatmentDetailTicket(treatmentId));
/* 230 */     } catch (Exception e) {
/* 231 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 232 */       logger.error(exceptionAsString);
/* 233 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 235 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\MedicCheckinTreatmentDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */