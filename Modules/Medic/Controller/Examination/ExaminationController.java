/*     */ package nencer.app.Modules.Medic.Controller.Examination;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinStatus;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Examination.MedicExamination;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceGroupRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TicketRepository;
/*     */ import nencer.app.Modules.Report.Model.ExaminationModel;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExaminationController extends BaseMedicController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationController.class);
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
/*     */   ServiceTypeRepository serviceTypeRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ServiceGroupRepository serviceGroupRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   TicketRepository ticketRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_examination/create"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicExamination request) {
/*  68 */     ApiResponse rs = new ApiResponse();
/*  69 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  71 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(request.getMdId());
/*  72 */       if (!medicCheckinRecord.isPresent()) {
/*  73 */         return this.apiError.getError("999", new String[] { request.getMdId() + "" });
/*     */       }
/*  75 */       Optional<MedicExamination> examinations = this.examinationRepository.findByMdId(request.getMdId());
/*     */       
/*  77 */       Integer ageInsurance = this.medicService.fn_tinh_tuoi_benh_nhan_bhyt(request.getMdId().intValue());
/*     */       
/*  79 */       ExaminationModel examinationModel = (ExaminationModel)this.objectMapper.readValue(request.getExaminationArray(), ExaminationModel.class);
/*     */       
/*  81 */       if (ageInsurance != null && ageInsurance.intValue() <= 1 && examinationModel != null && Strings.isEmpty(examinationModel.getWeight())) {
/*  82 */         return this.apiError.getError("612", new String[0]);
/*     */       }
/*     */       
/*  85 */       if (examinations.isPresent()) {
/*  86 */         request.setId(((MedicExamination)examinations.get()).getId());
/*  87 */         request.setUpdatedAt(new Date());
/*     */       } else {
/*  89 */         request.setCreatedAt(new Date());
/*     */       } 
/*  91 */       request.setDiagnosticArray((examinationModel != null) ? this.objectMapper.writeValueAsString(examinationModel.getDiagnosticArray()) : "");
/*  92 */       request.setDiagnosticSubArray(this.objectMapper.writeValueAsString(examinationModel.getDiagnosticSubArray()));
/*     */       
/*  94 */       MedicExamination x = (MedicExamination)this.examinationRepository.saveAndFlush(request);
/*  95 */       MedicCheckinRecord mcr = medicCheckinRecord.get();
/*  96 */       mcr.setDoctorId(request.getDoctorId());
/*  97 */       mcr.setDoctorName(request.getDoctorName());
/*  98 */       this.medicCheckinRecordRepository.saveAndFlush(mcr);
/*     */ 
/*     */       
/* 101 */       data.put("id", x.getId());
/*     */       
/* 103 */       rs.put("status", "OK");
/* 104 */       rs.put("responseCode", "00");
/* 105 */       rs.put("data", data);
/*     */     }
/* 107 */     catch (Exception e) {
/* 108 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 109 */       logger.error(exceptionAsString);
/* 110 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 111 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 113 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getExaminationResult/{mdId}"})
/*     */   public ApiResponse getCheckinService(@PathVariable @Valid Integer mdId) {
/* 121 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 124 */       if (mdId == null) {
/* 125 */         return this.apiError.getError("02");
/*     */       }
/* 127 */       Optional<MedicExamination> examinations = this.examinationRepository.findByMdId(mdId);
/*     */       
/* 129 */       rs.put("status", "OK");
/* 130 */       rs.put("responseCode", "00");
/* 131 */       rs.put("data", examinations);
/*     */     }
/* 133 */     catch (Exception e) {
/* 134 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 135 */       logger.error(exceptionAsString);
/* 136 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 138 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/examinationProcess/{mdId}"})
/*     */   public ApiResponse examinationProcess(@PathVariable @Valid Integer mdId) {
/* 146 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 149 */       if (mdId == null) {
/* 150 */         return this.apiError.getError("02");
/*     */       }
/* 152 */       Optional<MedicCheckinRecord> medicCheckinRecordOp = this.medicCheckinRecordRepository.findById(mdId);
/* 153 */       if (!medicCheckinRecordOp.isPresent()) {
/* 154 */         return this.apiError.getError("02");
/*     */       }
/* 156 */       MedicCheckinRecord medicCheckinRecord = medicCheckinRecordOp.get();
/* 157 */       medicCheckinRecord.setStatus(CheckinStatus.PROCESSING.getCheckinStatus());
/* 158 */       medicCheckinRecord.setUpdatedAt(new Date());
/* 159 */       this.medicCheckinRecordRepository.save(medicCheckinRecord);
/* 160 */       MedicCheckin medicCheckin = medicCheckinRecord.getMedicCheckin();
/* 161 */       medicCheckin.setStatus(CheckinStatus.PROCESSING.getCheckinStatus());
/* 162 */       medicCheckin.setUpdatedAt(new Date());
/* 163 */       this.checkinRepository.saveAndFlush(medicCheckin);
/*     */ 
/*     */       
/* 166 */       rs.put("status", "OK");
/* 167 */       rs.put("responseCode", "00");
/* 168 */       rs.put("data", "THANH CONG");
/*     */     }
/* 170 */     catch (Exception e) {
/* 171 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 172 */       logger.error(exceptionAsString);
/* 173 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 175 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/examinationCancel/{mdId}"})
/*     */   public ApiResponse examinationCancel(@PathVariable @Valid Integer mdId) {
/* 183 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 186 */       if (mdId == null) {
/* 187 */         return this.apiError.getError("02");
/*     */       }
/* 189 */       Optional<MedicCheckinRecord> checkinRecordOp = this.medicCheckinRecordRepository.findById(mdId);
/* 190 */       if (!checkinRecordOp.isPresent()) {
/* 191 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 199 */       List<MedicTicket> medicTickets = this.ticketRepository.findAllByTicketTypeAndMdId(TicketType.SERVICE.getTicketType(), mdId).orElse(new ArrayList<>());
/* 200 */       if (medicTickets.size() > 1) {
/* 201 */         return this.apiError.getError("309", new String[0]);
/*     */       }
/* 203 */       MedicCheckinRecord medicCheckinRecord = checkinRecordOp.get();
/* 204 */       MedicCheckin medicCheckin = medicCheckinRecord.getMedicCheckin();
/* 205 */       medicCheckin.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 206 */       medicCheckin.setUpdatedAt(new Date());
/* 207 */       this.checkinRepository.saveAndFlush(medicCheckin);
/*     */       
/* 209 */       medicCheckinRecord.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 210 */       this.medicCheckinRecordRepository.save(medicCheckinRecord);
/*     */       
/* 212 */       rs.put("status", "OK");
/* 213 */       rs.put("responseCode", "00");
/* 214 */       rs.put("data", "THANH CONG");
/*     */     }
/* 216 */     catch (Exception e) {
/* 217 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 218 */       logger.error(exceptionAsString);
/* 219 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 221 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Examination\ExaminationController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */