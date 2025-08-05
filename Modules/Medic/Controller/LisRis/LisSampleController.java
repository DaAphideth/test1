/*     */ package nencer.app.Modules.Medic.Controller.LisRis;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.StatusResult;
/*     */ import nencer.app.Constant.TicketStatus;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicOrderServicesExt;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Entity.TestCode.MedicTestCodeMapping;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisDetailResponse;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisModel;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.LisRisOrderResponse;
/*     */ import nencer.app.Modules.Medic.Model.LisRis.ListCheckin;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class LisSampleController extends BaseMedicController {
/*  48 */   public static final Logger logger = LoggerFactory.getLogger(LisSampleController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomRepository roomRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomNumberRepository roomNumberRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */ 
/*     */   
/*     */   @Value("${recho_req}")
/*     */   private String rechoReq;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_lis/getCheckinLisSample2"})
/*     */   public ApiResponse getCheckinLisHandle(@Valid @RequestParam Integer userId, @Valid @RequestParam Integer roomId, @RequestParam(required = false) Integer patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String customerType, @RequestParam(required = false) String barcode, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*  81 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  84 */       List<LisRisModel> list = this.medicService.getSearchSample(page, size, userId, patientId, name, customerType, roomId, barcode, fromDate, toDate, 
/*  85 */           Integer.valueOf(2));
/*     */       
/*  87 */       data.put("lis", list);
/*  88 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((LisRisModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  90 */       rs.put("status", "OK");
/*  91 */       rs.put("responseCode", "00");
/*  92 */       rs.put("data", data);
/*     */       
/*  94 */       return rs;
/*  95 */     } catch (Exception e) {
/*  96 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  97 */       logger.error(exceptionAsString);
/*  98 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_lis/getCheckinLisOrderService/{mdId}/{ticketId}"})
/*     */   public ApiResponse getCheckinLisOrderService(@PathVariable @Valid Integer mdId, @PathVariable @Valid Integer ticketId) {
/* 107 */     ApiResponse rs = new ApiResponse();
/* 108 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 111 */       if (mdId == null) {
/* 112 */         return this.apiError.getError("02");
/*     */       }
/* 114 */       if (ticketId == null) {
/* 115 */         return this.apiError.getError("02");
/*     */       }
/* 117 */       Optional<MedicTicket> mt = this.ticketRepository.findById(ticketId);
/* 118 */       if (!mt.isPresent()) return this.apiError.getError("02");
/*     */       
/* 120 */       LisRisDetailResponse lrs = new LisRisDetailResponse();
/* 121 */       lrs.setMedicTicket(mt.get());
/*     */       
/* 123 */       List<LisRisOrderResponse> lros = new ArrayList<>();
/* 124 */       Optional<List<MedicOrderServices>> medicOrderServices = this.orderServiceRepository.findByMdIdAndTicketId(mdId, ticketId);
/* 125 */       if (medicOrderServices.isPresent()) {
/*     */         
/* 127 */         for (MedicOrderServices mos : medicOrderServices.get()) {
/* 128 */           LisRisOrderResponse lr = (LisRisOrderResponse)this.modelMapper.map(mos, LisRisOrderResponse.class);
/* 129 */           lr.setMedicOrderServicesExtList(this.orderServiceExtRepository.findAllByOrderServiceId(Integer.valueOf(mos.getId())));
/* 130 */           MedicServices medicServices = this.serviceRepository.findById(lr.getServiceId()).orElse(null);
/* 131 */           if (medicServices != null) {
/* 132 */             String originalResult = medicServices.getOriginalResult();
/* 133 */             lr.setOriginalResult(originalResult);
/* 134 */             if (StringUtils.isNotBlank(medicServices.getOriginalResult())) {
/* 135 */               String[] normalRsArray = originalResult.split(";");
/* 136 */               for (String normalR : normalRsArray) {
/* 137 */                 if (!StringUtils.isBlank(normalR)) {
/*     */ 
/*     */                   
/* 140 */                   String[] normalRs = normalR.split("-");
/* 141 */                   if (StringUtils.isNotBlank(normalRs[0]) && StringUtils.isNotBlank(lr.getLisHandlerResult()) && 
/* 142 */                     Double.parseDouble(normalRs[0]) > Double.parseDouble(lr.getLisHandlerResult())) {
/* 143 */                     lr.setStatusResult(StatusResult.LOW.toString());
/* 144 */                   } else if (StringUtils.isNotBlank(normalRs[normalRs.length - 1]) && StringUtils.isNotBlank(lr.getLisHandlerResult()) && 
/* 145 */                     Double.parseDouble(normalRs[normalRs.length - 1]) < Double.parseDouble(lr.getLisHandlerResult())) {
/* 146 */                     lr.setStatusResult(StatusResult.HIGH.toString());
/*     */                   } else {
/* 148 */                     lr.setStatusResult(StatusResult.NORMAL.toString());
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 153 */           }  lros.add(lr);
/*     */         } 
/* 155 */         lrs.setOrderServices(lros);
/*     */       } 
/*     */       
/* 158 */       MedicCheckinRecord medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId).orElse(null);
/*     */       
/* 160 */       lrs.setRoomId((medicCheckinRecord != null) ? medicCheckinRecord.getRoomId() : null);
/* 161 */       lrs.setRoomName((medicCheckinRecord != null) ? medicCheckinRecord.getMedicRooms().getName() : null);
/*     */       
/* 163 */       rs.put("status", "OK");
/* 164 */       rs.put("responseCode", "00");
/* 165 */       rs.put("data", lrs);
/*     */     }
/* 167 */     catch (Exception e) {
/* 168 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 169 */       logger.error(exceptionAsString);
/* 170 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 172 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/putCheckinLisSample/{ticketId}"})
/*     */   public ApiResponse putCheckinLisHandle(@PathVariable @Valid Integer ticketId, @Valid @RequestBody ListCheckin request) {
/* 181 */     ApiResponse rs = new ApiResponse();
/* 182 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 185 */       if (ticketId == null) {
/* 186 */         return this.apiError.getError("02");
/*     */       }
/* 188 */       if (request == null) {
/* 189 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/* 192 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 193 */       if (!omt.isPresent()) {
/* 194 */         return this.apiError.getError("02");
/*     */       }
/* 196 */       MedicTicket mt = omt.get();
/* 197 */       MedicCheckinRecord medicCheckinRecord = this.medicCheckinRecordRepository.findById(mt.getMdId()).orElse(null);
/* 198 */       if (medicCheckinRecord == null) {
/* 199 */         return this.apiError.getError("202", new String[] { String.valueOf(mt.getMdId()) });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 210 */       mt.setRoomSampleStatus(TicketStatus.DONE.getTicketStatus());
/* 211 */       mt.setIsDeleteSample(Integer.valueOf(1));
/* 212 */       mt.setIsShowHandle(Integer.valueOf(1));
/* 213 */       mt.setRoomSampleBy(request.getRoomSampleBy());
/* 214 */       mt.setRoomSampleDate(new Date());
/* 215 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       StringBuilder str1 = new StringBuilder();
/* 224 */       int i = 0;
/* 225 */       List<MedicOrderServices> lms = this.orderServiceRepository.findAllByTicketId(mt.getId()).orElse(null);
/* 226 */       if (!lms.isEmpty()) {
/*     */         
/* 228 */         for (MedicOrderServices lror : lms) {
/*     */           
/* 230 */           MedicTestCodeMapping mtc = this.testCodeMappingRepository.findAllByServiceId(lror.getServiceId());
/* 231 */           if (mtc == null)
/* 232 */             break;  List<MedicOrderServicesExt> lmse = this.orderServiceExtRepository.findAllByOrderServiceId(Integer.valueOf(lror.getId()));
/* 233 */           if (lmse == null || lmse
/* 234 */             .size() <= 0) {
/* 235 */             i++;
/* 236 */             str1.append(String.format("OBR|%s|||%s^%s", new Object[] { Integer.valueOf(i), mtc.getTestCode(), lror.getServiceName() }));
/* 237 */             str1.append(System.getProperty("line.separator"));
/*     */           } 
/*     */           
/* 240 */           int j = i;
/* 241 */           for (MedicOrderServicesExt mosx : lmse) {
/* 242 */             j++;
/* 243 */             MedicTestCodeMapping mtc1 = this.testCodeMappingRepository.findAllByServiceId(mosx.getServiceId());
/* 244 */             if (mtc1 == null)
/* 245 */               break;  str1.append(String.format("OBR|%s|||%s^%s", new Object[] { Integer.valueOf(j), mtc1.getTestCode(), mosx.getServiceName() }));
/* 246 */             str1.append(System.getProperty("line.separator"));
/*     */           } 
/* 248 */           i = j;
/*     */         } 
/* 250 */         rocheProcess(medicCheckinRecord, mt, request, str1);
/*     */       } 
/*     */       
/* 253 */       rs.put("status", "OK");
/* 254 */       rs.put("responseCode", "00");
/* 255 */       rs.put("data", data);
/*     */     }
/* 257 */     catch (Exception e) {
/* 258 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 259 */       logger.error(exceptionAsString);
/* 260 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 261 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 263 */     return rs;
/*     */   }
/*     */   
/*     */   private void rocheProcess(MedicCheckinRecord medicCheckinRecord, MedicTicket mt, ListCheckin request, StringBuilder str1) {
/*     */     try {
/* 268 */       String dt = ApiHelper.formatDate("yyyyMMddHHmmss");
/* 269 */       logger.info("#START: --------------" + mt.getId());
/* 270 */       StringBuilder stringBuilder = new StringBuilder();
/* 271 */       stringBuilder.append(String.format("MSH|^~\\&|HIS||LIS||%s||OML^O21^OML_O21|%s|P|2.4||AL|ER||8859/1", new Object[] { dt, 
/*     */               
/* 273 */               UUID.randomUUID() }));
/* 274 */       String gender = medicCheckinRecord.getMedicCheckin().getCustomers().getGender();
/* 275 */       String g = "";
/* 276 */       switch (gender) {
/*     */         case "male":
/* 278 */           g = "F";
/*     */           break;
/*     */         case "female":
/* 281 */           g = "M";
/*     */           break;
/*     */         case "undefined":
/* 284 */           g = "U";
/*     */           break;
/*     */         case "other":
/* 287 */           g = "O";
/*     */           break;
/*     */         default:
/* 290 */           g = "";
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 295 */       String day = (medicCheckinRecord.getMedicCheckin().getCustomers().getDayBorn() == null) ? "01" : ApiHelper.padLeftZeros1(medicCheckinRecord.getMedicCheckin().getCustomers().getDayBorn(), 2);
/*     */       
/* 297 */       String month = (medicCheckinRecord.getMedicCheckin().getCustomers().getMonthBorn() == null) ? "01" : ApiHelper.padLeftZeros1(medicCheckinRecord.getMedicCheckin().getCustomers().getMonthBorn(), 2);
/* 298 */       String dob = medicCheckinRecord.getMedicCheckin().getCustomers().getYearBorn() + month + day;
/*     */       
/* 300 */       stringBuilder.append(System.getProperty("line.separator"));
/* 301 */       stringBuilder.append(String.format("PID|1||%s||-^%s||%s|%s", new Object[] { medicCheckinRecord
/* 302 */               .getMedicCheckin().getPatientId(), medicCheckinRecord
/* 303 */               .getMedicCheckin().getCustomers().getName(), dob, g }));
/*     */ 
/*     */ 
/*     */       
/* 307 */       String mdType = "U";
/* 308 */       switch (medicCheckinRecord.getMdType()) {
/*     */         case "IN_PATIENT":
/* 310 */           mdType = "I";
/*     */           break;
/*     */         case "OUT_PATIENT":
/* 313 */           mdType = "O";
/*     */           break;
/*     */       } 
/* 316 */       stringBuilder.append(System.getProperty("line.separator"));
/* 317 */       stringBuilder.append(String.format("PV1|1|%s|||||||||||||||||GIPTOB15^^^^^^^^%s", new Object[] { mdType, mt
/*     */               
/* 319 */               .getMedicRoomHandle().getName() }));
/*     */       
/* 321 */       Users user = this.userRepository.findByUsername(request.getRoomSampleBy()).orElse(null);
/* 322 */       stringBuilder.append(System.getProperty("line.separator"));
/* 323 */       stringBuilder.append(String.format("ORC|NW|%s|||||||%s||%s^%s|%s||^|^", new Object[] { mt
/* 324 */               .getId(), dt, request
/*     */               
/* 326 */               .getRoomSampleBy(), (user == null) ? request
/* 327 */               .getRoomSampleBy() : user.getName(), mt
/* 328 */               .getMedicRoomHandle().getDepartmentId() + "^" + mt.getMedicRoomHandle().getName() }));
/*     */       
/* 330 */       stringBuilder.append(System.getProperty("line.separator"));
/* 331 */       stringBuilder.append(str1);
/*     */ 
/*     */ 
/*     */       
/* 335 */       String fileName = "HIS_" + mt.getId() + "_" + dt + ".hl7";
/* 336 */       String fileResponsePath = this.rechoReq + "/HIS_" + mt.getId() + "_" + dt + ".hl7";
/* 337 */       try (FileOutputStream fos = new FileOutputStream(fileResponsePath)) {
/* 338 */         fos.write(stringBuilder.toString().getBytes());
/*     */       } 
/*     */       try {
/* 341 */         this.rocheDataRepository.save(RocheData.builder()
/* 342 */             .fileName(fileName)
/* 343 */             .ticketId(mt.getId())
/* 344 */             .filePath(fileResponsePath)
/* 345 */             .fileData(stringBuilder.toString())
/* 346 */             .createdAt(new Date())
/* 347 */             .direction("OUT")
/* 348 */             .build());
/* 349 */       } catch (Exception ex) {
/* 350 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 351 */         logger.error(exceptionAsString);
/*     */       } 
/* 353 */       logger.info("#END: --------------" + mt.getId());
/* 354 */     } catch (Exception ex) {
/* 355 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 356 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_lis/cancelCheckinLisSample/{ticketId}"})
/*     */   public ApiResponse cancelCheckinLisSample(@PathVariable @Valid Integer ticketId, @Valid @RequestBody ListCheckin request) {
/* 366 */     ApiResponse rs = new ApiResponse();
/* 367 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 370 */       if (ticketId == null) {
/* 371 */         return this.apiError.getError("02");
/*     */       }
/* 373 */       if (request == null) {
/* 374 */         return this.apiError.getError("602");
/*     */       }
/*     */       
/* 377 */       Optional<MedicTicket> omt = this.ticketRepository.findById(ticketId);
/* 378 */       if (!omt.isPresent()) {
/* 379 */         return this.apiError.getError("02");
/*     */       }
/* 381 */       MedicTicket mt = omt.get();
/* 382 */       MedicCheckinRecord medicCheckinRecord = this.medicCheckinRecordRepository.findById(mt.getMdId()).orElse(null);
/* 383 */       if (medicCheckinRecord == null) {
/* 384 */         return this.apiError.getError("202", new String[] { String.valueOf(mt.getMdId()) });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 394 */       if (mt.getIsDeleteHandle().intValue() == 1) {
/* 395 */         return this.apiError.getError("603");
/*     */       }
/*     */ 
/*     */       
/* 399 */       mt.setIsDeleteSample(Integer.valueOf(0));
/* 400 */       mt.setIsShowHandle(Integer.valueOf(0));
/* 401 */       mt.setRoomSampleStatus(TicketStatus.PENDING.getTicketStatus());
/* 402 */       mt.setRoomHandleStatus(null);
/* 403 */       mt.setRoomSampleBy(request.getRoomSampleBy());
/* 404 */       mt.setRoomSampleDate(new Date());
/* 405 */       this.ticketRepository.saveAndFlush(mt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 412 */       rs.put("status", "OK");
/* 413 */       rs.put("responseCode", "00");
/* 414 */       rs.put("data", data);
/*     */     }
/* 416 */     catch (Exception e) {
/* 417 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 418 */       logger.error(exceptionAsString);
/* 419 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 420 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 422 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\LisRis\LisSampleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */