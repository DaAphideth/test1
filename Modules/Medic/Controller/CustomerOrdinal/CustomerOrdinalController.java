/*     */ package nencer.app.Modules.Medic.Controller.CustomerOrdinal;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.MasterData.Repository.MedicMasterDataRepository;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinStt;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinal;
/*     */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinalResponse;
/*     */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.ExaminationCallingUserResponse;
/*     */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.OrdinalDoorNumberResponse;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.MedicCheckinSttRepository;
/*     */ import nencer.app.Modules.Medic.Service.MedicService;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.messaging.simp.SimpMessagingTemplate;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class CustomerOrdinalController
/*     */   extends BaseMedicController
/*     */ {
/*     */   @Autowired
/*     */   MedicService medicService;
/*     */   @Autowired
/*     */   MedicMasterDataRepository masterDataRepository;
/*     */   @Autowired
/*     */   MedicCheckinSttRepository medicCheckinSttRepository;
/*     */   @Autowired
/*     */   private SimpMessagingTemplate template;
/*     */   
/*     */   @GetMapping({"/takeNumber/generate-number"})
/*     */   public ApiResponse generateNumber(@Valid @RequestParam String takeNumber) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  51 */       MedicMasterData settings = this.masterDataRepository.findByMedicCode("HOSPITAL").orElse(null);
/*  52 */       this.medicService.generateNumber(takeNumber);
/*  53 */       List<CustomerOrdinalResponse> ordinalResponses = ordinalResponse();
/*  54 */       data.put("hospital", Objects.nonNull(settings) ? settings.getMedicName() : "");
/*     */ 
/*     */ 
/*     */       
/*  58 */       data.put("ordinalResponse", ordinalResponses);
/*  59 */       rs.put("status", "OK");
/*  60 */       rs.put("responseCode", "00");
/*  61 */       rs.put("data", data);
/*  62 */     } catch (Exception e) {
/*  63 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  64 */       logger.error(exceptionAsString);
/*  65 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  67 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/takeNumber/calling"})
/*     */   public ApiResponse calling() {
/*  96 */     ApiResponse rs = new ApiResponse();
/*  97 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  99 */       MedicMasterData settings = this.masterDataRepository.findByMedicCode("HOSPITAL").orElse(null);
/* 100 */       List<CustomerOrdinalResponse> customerOrdinalResponse = ordinalResponse();
/*     */       
/* 102 */       data.put("hospital", Objects.nonNull(settings) ? settings.getMedicName() : "");
/* 103 */       data.put("ordinalResponse", customerOrdinalResponse);
/*     */       
/* 105 */       rs.put("status", "OK");
/* 106 */       rs.put("responseCode", "00");
/* 107 */       rs.put("data", data);
/* 108 */     } catch (Exception e) {
/* 109 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 110 */       logger.error(exceptionAsString);
/* 111 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 113 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/takeNumber/calling1"})
/*     */   public ApiResponse calling1(@Valid @RequestParam String takeNumber, @Valid @RequestParam String doorId) {
/* 121 */     ApiResponse rs = new ApiResponse();
/* 122 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 124 */       MedicMasterData settings = this.masterDataRepository.findByMedicCode("HOSPITAL").orElse(null);
/* 125 */       MedicMasterData doorName = this.masterDataRepository.findByMedicTypeAndMedicCode("ordinal_door", doorId).orElse(null);
/* 126 */       List<CustomerOrdinal> customerOrdinalResponse = this.customerOrdinalRepository.getByTakeNumberAndDoorId(doorId, takeNumber);
/*     */       
/* 128 */       data.put("hospital", Objects.nonNull(settings) ? settings.getMedicName() : "");
/* 129 */       if (customerOrdinalResponse.isEmpty()) {
/* 130 */         data.put("ordinalResponse", null);
/*     */       } else {
/* 132 */         CustomerOrdinalResponse mco = (CustomerOrdinalResponse)this.modelMapper.map(customerOrdinalResponse.get(0), CustomerOrdinalResponse.class);
/* 133 */         mco.setWindow(Objects.nonNull(doorName) ? doorName.getMedicName() : "");
/* 134 */         mco.setNumberWindow(Objects.nonNull(doorName) ? doorName.getMedicCode() : "");
/* 135 */         data.put("ordinalResponse", mco);
/*     */       } 
/*     */       
/* 138 */       rs.put("status", "OK");
/* 139 */       rs.put("responseCode", "00");
/* 140 */       rs.put("data", data);
/* 141 */     } catch (Exception e) {
/* 142 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 143 */       logger.error(exceptionAsString);
/* 144 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 146 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/takeNumber/call-next-number"})
/*     */   public ApiResponse callNextNumber(@Valid @RequestParam String takeNumber, @Valid @RequestParam String id) {
/* 154 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 156 */       Optional<MedicMasterData> medicOrdinalDoor = this.masterDataRepository.findByMedicTypeAndMedicCode("ordinal_door", id);
/*     */       
/* 158 */       if (!medicOrdinalDoor.isPresent()) {
/* 159 */         return this.apiError.getError("502");
/*     */       }
/*     */       
/* 162 */       CustomerOrdinal customerOrdinal = this.customerOrdinalRepository.getCallingNumber1(takeNumber);
/* 163 */       Integer callingNumber = Integer.valueOf(Objects.nonNull(customerOrdinal) ? (customerOrdinal.getCallingNumber().intValue() + 1) : 1);
/*     */ 
/*     */       
/* 166 */       CustomerOrdinal medicCustomerOrdinal = this.customerOrdinalRepository.findByNumberAndNameRoom(callingNumber, takeNumber);
/* 167 */       if (Objects.isNull(medicCustomerOrdinal)) {
/* 168 */         return this.apiError.getError("501");
/*     */       }
/*     */       
/* 171 */       this.customerOrdinalRepository.updateCallingNumber1(medicCustomerOrdinal.getId(), callingNumber, id);
/*     */       
/* 173 */       MedicMasterData settings = this.masterDataRepository.findByMedicCode("HOSPITAL").orElse(null);
/* 174 */       Map<String, Object> data = new HashMap<>();
/*     */ 
/*     */       
/* 177 */       data.put("hospital", Objects.nonNull(settings) ? settings.getMedicName() : "");
/* 178 */       data.put("window", ((MedicMasterData)medicOrdinalDoor.get()).getMedicName());
/* 179 */       data.put("numberWindow", ((MedicMasterData)medicOrdinalDoor.get()).getMedicCode());
/* 180 */       data.put("sttCalling", medicCustomerOrdinal.getNumber());
/* 181 */       data.put("roomGetNumber", medicCustomerOrdinal.getDoorCode());
/*     */       
/* 183 */       rs.put("status", "OK");
/* 184 */       rs.put("responseCode", "00");
/* 185 */       rs.put("data", data);
/*     */ 
/*     */       
/* 188 */       Thread s = new Thread(() -> sendWs());
/* 189 */       s.start();
/* 190 */     } catch (Exception e) {
/* 191 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 192 */       logger.error(exceptionAsString);
/* 193 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 195 */     return rs;
/*     */   }
/*     */   
/*     */   private void sendWs() {
/* 199 */     String doorId = "";
/* 200 */     List<MedicMasterData> lmd = this.masterDataRepository.findAllByMedicType("ordinal_door");
/* 201 */     if (!lmd.isEmpty()) {
/*     */       
/* 203 */       for (MedicMasterData md : lmd) {
/* 204 */         doorId = doorId + md.getMedicCode() + ";";
/*     */       }
/*     */     } else {
/* 207 */       doorId = "1";
/*     */     } 
/* 209 */     String doorIds = StringUtils.chop(doorId);
/* 210 */     this.template.convertAndSend("/api/topic/checkin/window-calling-number", windowCallingNumber(doorIds));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/takeNumber/call-back"})
/*     */   public ApiResponse callBackNumber(@Valid @RequestParam String takeNumber, @Valid @RequestParam Integer id, @Valid @RequestParam Integer number) {
/* 220 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 223 */       Optional<MedicMasterData> medicOrdinalDoor = this.masterDataRepository.findByMedicTypeAndMedicCode("ordinal_door", id + "");
/*     */       
/* 225 */       if (!medicOrdinalDoor.isPresent()) {
/* 226 */         return this.apiError.getError("502");
/*     */       }
/*     */       
/* 229 */       CustomerOrdinal customerOrdinal = this.customerOrdinalRepository.findByNumberAndNameRoom(number, takeNumber);
/* 230 */       if (Objects.isNull(customerOrdinal)) {
/* 231 */         return this.apiError.getError("501");
/*     */       }
/*     */       
/* 234 */       MedicMasterData settings = this.masterDataRepository.findByMedicCode("HOSPITAL").orElse(null);
/*     */       
/* 236 */       Map<String, Object> data = new HashMap<>();
/*     */       
/* 238 */       data.put("roomGetNumber", customerOrdinal.getDoorCode());
/* 239 */       data.put("sttCallingBack", customerOrdinal.getNumber());
/* 240 */       data.put("window", ((MedicMasterData)medicOrdinalDoor.get()).getMedicName());
/* 241 */       data.put("hospital", Objects.nonNull(settings) ? settings.getMedicName() : "");
/*     */       
/* 243 */       rs.put("status", "OK");
/* 244 */       rs.put("responseCode", "00");
/* 245 */       rs.put("data", data);
/* 246 */     } catch (Exception e) {
/* 247 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 248 */       logger.error(exceptionAsString);
/* 249 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 251 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/takeNumber/window-calling-number"})
/*     */   public ApiResponse windowCallingNumber(@Valid @RequestParam String doorId) {
/* 260 */     ApiResponse rs = new ApiResponse();
/* 261 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 263 */       String[] door = doorId.split(";");
/* 264 */       List<OrdinalDoorNumberResponse> lsOn = this.medicService.windowCallingNumber(door);
/* 265 */       rs.put("status", "OK");
/* 266 */       rs.put("responseCode", "00");
/* 267 */       rs.put("data", lsOn);
/* 268 */     } catch (Exception e) {
/* 269 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 270 */       logger.error(exceptionAsString);
/* 271 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 274 */     return rs;
/*     */   }
/*     */   
/*     */   public List<CustomerOrdinalResponse> ordinalResponse() {
/* 278 */     return this.medicService.getCallingNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/examination/calling1"})
/*     */   public ApiResponse examinationCalling1(@Valid @RequestParam Integer roomId) {
/* 289 */     ApiResponse rs = new ApiResponse();
/* 290 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 292 */       MedicRooms rooms = this.roomRepository.findById(roomId).orElse(null);
/* 293 */       if (Objects.isNull(rooms)) return this.apiError.getError("510");
/*     */       
/* 295 */       List<MedicCheckinStt> customerOrdinalResponse = this.medicCheckinSttRepository.findByRoomId(roomId);
/*     */       
/* 297 */       if (customerOrdinalResponse.isEmpty()) {
/* 298 */         data.put("ordinalResponse", null);
/*     */       } else {
/* 300 */         CustomerOrdinalResponse mco = (CustomerOrdinalResponse)this.modelMapper.map(customerOrdinalResponse.get(0), CustomerOrdinalResponse.class);
/* 301 */         mco.setWindow(rooms.getName());
/* 302 */         mco.setNumberWindow(rooms.getRoomNumber());
/* 303 */         data.put("ordinalResponse", mco);
/*     */       } 
/* 305 */       rs.put("status", "OK");
/* 306 */       rs.put("responseCode", "00");
/* 307 */       rs.put("data", data);
/* 308 */     } catch (Exception e) {
/* 309 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 310 */       logger.error(exceptionAsString);
/* 311 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 313 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/examination/call-next-number"})
/*     */   public ApiResponse examinationCallNextNumber(@Valid @RequestParam Integer roomId) {
/* 321 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 323 */       MedicRooms rooms = this.roomRepository.findById(roomId).orElse(null);
/* 324 */       if (Objects.isNull(rooms)) return this.apiError.getError("510");
/*     */       
/* 326 */       CustomerOrdinal customerOrdinal = this.medicCheckinSttRepository.getCallingNumber1(roomId, "CALLED");
/* 327 */       Integer callingNumber = Integer.valueOf(Objects.nonNull(customerOrdinal) ? (customerOrdinal.getCallingNumber().intValue() + 1) : 1);
/*     */ 
/*     */       
/* 330 */       MedicCheckinStt medicCustomerOrdinal = this.medicCheckinSttRepository.findFirstByNumberAndRoomId(callingNumber, roomId);
/* 331 */       if (Objects.isNull(medicCustomerOrdinal)) {
/* 332 */         return this.apiError.getError("501");
/*     */       }
/*     */       
/* 335 */       this.medicCheckinSttRepository.updateCallingNumber1(Integer.valueOf(medicCustomerOrdinal.getId()), callingNumber);
/*     */       
/* 337 */       Map<String, Object> data = new HashMap<>();
/* 338 */       data.put("window", rooms.getName());
/* 339 */       data.put("numberWindow", rooms.getRoomNumber());
/* 340 */       data.put("callingNumber", callingNumber);
/* 341 */       data.put("sttCalling", medicCustomerOrdinal.getNumber());
/* 342 */       data.put("roomId", roomId);
/*     */       
/* 344 */       rs.put("status", "OK");
/* 345 */       rs.put("responseCode", "00");
/* 346 */       rs.put("data", data);
/* 347 */       Thread s = new Thread(() -> this.template.convertAndSend("/api/topic/examination/window-calling-number", examinationWindowCallingNumber(rooms.getCode())));
/*     */ 
/*     */ 
/*     */       
/* 351 */       s.start();
/* 352 */     } catch (Exception e) {
/* 353 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 354 */       logger.error(exceptionAsString);
/* 355 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 357 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/examination/call-back"})
/*     */   public ApiResponse examinationCallBackNumber(@Valid @RequestParam Integer roomId, @Valid @RequestParam Integer number) {
/* 366 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 368 */       MedicRooms rooms = this.roomRepository.findById(roomId).orElse(null);
/* 369 */       if (Objects.isNull(rooms)) return this.apiError.getError("510");
/*     */       
/* 371 */       CustomerOrdinal customerOrdinal = this.medicCheckinSttRepository.findByNumberAndNameRoom(number, roomId);
/* 372 */       if (Objects.isNull(customerOrdinal)) {
/* 373 */         return this.apiError.getError("501");
/*     */       }
/*     */       
/* 376 */       Map<String, Object> data = new HashMap<>();
/* 377 */       data.put("window", rooms.getName());
/* 378 */       data.put("numberWindow", rooms.getRoomNumber());
/* 379 */       data.put("sttCalling", customerOrdinal.getNumber());
/* 380 */       data.put("roomId", roomId);
/* 381 */       data.put("number", roomId);
/* 382 */       rs.put("status", "OK");
/* 383 */       rs.put("responseCode", "00");
/* 384 */       rs.put("data", data);
/* 385 */     } catch (Exception e) {
/* 386 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 387 */       logger.error(exceptionAsString);
/* 388 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 390 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/examination/window-calling-number"})
/*     */   public ApiResponse examinationWindowCallingNumber(@Valid @RequestParam String roomCode) {
/* 399 */     ApiResponse rs = new ApiResponse();
/* 400 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 402 */       String[] rc = roomCode.split(";");
/* 403 */       for (String d : rc) {
/* 404 */         ExaminationCallingUserResponse ordinalResponse = this.medicService.sp_get_room_number(d);
/* 405 */         if (Objects.nonNull(ordinalResponse)) {
/* 406 */           data.put(d, ordinalResponse);
/*     */         } else {
/* 408 */           data.put(d, null);
/*     */         } 
/*     */       } 
/* 411 */       rs.put("status", "OK");
/* 412 */       rs.put("responseCode", "00");
/* 413 */       rs.put("data", data);
/* 414 */     } catch (Exception e) {
/* 415 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 416 */       logger.error(exceptionAsString);
/* 417 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 419 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\CustomerOrdinal\CustomerOrdinalController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */