/*     */ package nencer.app.Modules.Medic.Controller;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinStatus;
/*     */ import nencer.app.Constant.CheckinType;
/*     */ import nencer.app.Constant.CustomerType;
/*     */ import nencer.app.Constant.ExaminationTypeStatus;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.ServiceObjectType;
/*     */ import nencer.app.Modules.Customer.Entity.CustomerFamily;
/*     */ import nencer.app.Modules.Customer.Entity.Customers;
/*     */ import nencer.app.Modules.Localization.Entity.LocalDistricts;
/*     */ import nencer.app.Modules.Localization.Entity.LocalProvinces;
/*     */ import nencer.app.Modules.Localization.Entity.LocalWards;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinHis;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinRequest;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinResponse;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordModel;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.FilterData;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.InvoiceRequest;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.OrderServiceRequest;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class CheckinController extends BaseMedicController {
/*     */   @GetMapping({"/medic_checkin"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  67 */     ApiResponse rs = new ApiResponse();
/*  68 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  71 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  72 */       if (!StringUtils.isEmpty(filter)) {
/*  73 */         ObjectMapper objectMapper = new ObjectMapper();
/*  74 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  78 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  79 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  80 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */ 
/*     */       
/*  83 */       Page<MedicCheckin> pages = this.checkinRepository.findAll((Specification)specifications, (Pageable)pageable);
/*     */       
/*  85 */       data.put("checkins", null);
/*  86 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  87 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  89 */       rs.put("status", "OK");
/*  90 */       rs.put("responseCode", "00");
/*  91 */       rs.put("data", data);
/*     */     }
/*  93 */     catch (Exception e) {
/*  94 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  95 */       logger.error(exceptionAsString);
/*  96 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  98 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   public JdbcTemplate jdbcTemplate;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin1"})
/*     */   public ApiResponse getPaging1(@RequestParam(required = false) String status, @RequestParam(required = false) String name, @RequestParam(required = false) String patientId, @RequestParam(required = false) String idType, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 111 */     ApiResponse rs = new ApiResponse();
/* 112 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 115 */       List<CheckinResponse> list = this.medicService.getCheckinInfo(page, size, null, name, status, patientId, idType, fromDate, toDate);
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
/* 127 */       for (CheckinResponse family : list) {
/* 128 */         List<CustomerFamily> customerFamily = this.customerFamilyRepository.findAllByCustomerId(family.getPatientId());
/* 129 */         family.setCustomerFamilys(customerFamily);
/*     */       } 
/*     */ 
/*     */       
/* 133 */       data.put("checkins", list);
/* 134 */       data.put("totalItems", !list.isEmpty() ? Integer.valueOf(((CheckinResponse)list.get(0)).getTotalRecord()) : null);
/* 135 */       data.put("totalPages", "");
/*     */       
/* 137 */       rs.put("status", "OK");
/* 138 */       rs.put("responseCode", "00");
/* 139 */       rs.put("data", data);
/*     */     }
/* 141 */     catch (Exception e) {
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
/*     */   @GetMapping({"/medic_checkin/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 154 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 157 */       if (id == null) {
/* 158 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 161 */       List<CheckinResponse> medictRs = this.medicService.getCheckinInfo(1, 10, id, "", "", "", "", "", "");
/*     */       
/* 163 */       rs.put("status", "OK");
/* 164 */       rs.put("responseCode", "00");
/* 165 */       rs.put("data", !medictRs.isEmpty() ? medictRs.get(0) : null);
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
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_checkin/create"})
/*     */   public ApiResponse create(@Valid @RequestBody CheckinRequest request) {
/* 181 */     ApiResponse rs = new ApiResponse();
/* 182 */     Map<String, Object> data = new HashMap<>(); try {
/*     */       Integer insuranceId;
/* 184 */       logger.info("// validate");
/*     */       
/* 186 */       Optional<MedicRooms> medicRooms = this.roomRepository.findById(request.getRoomId());
/* 187 */       if (!medicRooms.isPresent()) {
/* 188 */         return this.apiError.getError("301", new String[] { request.getRoomId() + "" });
/*     */       }
/*     */       
/* 191 */       Optional<LocalProvinces> provinces = this.provinceRepository.findByCode(request.getProvinceCode());
/* 192 */       if (!provinces.isPresent()) {
/* 193 */         return this.apiError.getError("304", new String[] { request.getProvinceCode() });
/*     */       }
/*     */       
/* 196 */       Optional<LocalDistricts> districts = this.districtRepository.findByCode(request.getDistrictCode());
/* 197 */       if (!districts.isPresent()) {
/* 198 */         return this.apiError.getError("305", new String[] { request.getDistrictCode() });
/*     */       }
/*     */       
/* 201 */       Optional<LocalWards> wards = this.wardRepository.findByCode(request.getWardCode());
/* 202 */       if (!wards.isPresent()) {
/* 203 */         return this.apiError.getError("306", new String[] { request.getWardCode() });
/*     */       }
/*     */       
/* 206 */       logger.info("// 1 Luu thong tin khach hang");
/*     */       
/* 208 */       Customers customersOld = (request.getPatientId() != null) ? this.customerRepository.findById(request.getPatientId()).orElse(null) : null;
/* 209 */       if (!ObjectUtils.isEmpty(customersOld)) {
/* 210 */         Customers customers = (Customers)this.modelMapper.map(request, Customers.class);
/* 211 */         customers.setCustomerProvince(request.getProvinceCode());
/* 212 */         customers.setCustomerDistrict(request.getDistrictCode());
/* 213 */         customers.setCustomerWards(request.getWardCode());
/* 214 */         customers.setAddress2(customersOld.getAddress2());
/* 215 */         customers.setId(customersOld.getId());
/* 216 */         customers.setPatientNumber(customersOld.getPatientNumber());
/* 217 */         customers.setUpdatedAt(new Date());
/* 218 */         customersOld = (Customers)this.customerRepository.saveAndFlush(customers);
/*     */ 
/*     */         
/* 221 */         insuranceId = request.getCustomerType().equalsIgnoreCase("bhyt") ? this.medicService.updateCustomersInsurance(request.getCustomersInsurance(), Integer.valueOf(customersOld.getId()), request.getCreatorId()) : null;
/*     */       } else {
/*     */         
/* 224 */         Customers customers = (Customers)this.modelMapper.map(request, Customers.class);
/* 225 */         customers.setCreatedAt(new Date());
/* 226 */         customers.setCustomerProvince(request.getProvinceCode());
/* 227 */         customers.setCustomerDistrict(request.getDistrictCode());
/* 228 */         customers.setAddress2(request.getAddress2());
/* 229 */         customers.setCustomerWards(request.getWardCode());
/* 230 */         customersOld = (Customers)this.customerRepository.saveAndFlush(customers);
/*     */         
/* 232 */         String par = ApiHelper.generatePartientNumber(Integer.valueOf(customersOld.getId()));
/* 233 */         customersOld.setPatientNumber(par);
/* 234 */         customersOld = (Customers)this.customerRepository.saveAndFlush(customersOld);
/*     */ 
/*     */ 
/*     */         
/* 238 */         insuranceId = request.getCustomerType().equalsIgnoreCase("bhyt") ? this.medicService.customersInsurance(request.getCustomersInsurance(), Integer.valueOf(customersOld.getId()), request.getCreatorId()) : null;
/*     */       } 
/*     */ 
/*     */       
/* 242 */       logger.info("// 3. Luu thong tin nguoi nha");
/* 243 */       if (request.getCustomerFamilys() != null && request.getCustomerFamilys().size() > 0) {
/* 244 */         List<CustomerFamily> customerFamilys = this.customerFamilyRepository.findAllByCustomerId(request.getPatientId());
/*     */         
/* 246 */         List<CustomerFamily> customerDetails2 = (List<CustomerFamily>)request.getCustomerFamilys().stream().map(c -> (CustomerFamily)this.modelMapper.map(c, CustomerFamily.class)).collect(Collectors.toList());
/*     */         
/* 248 */         this.customerFamilyRepository.deleteAll(customerFamilys);
/* 249 */         Integer customerId = Integer.valueOf(customersOld.getId());
/* 250 */         customerDetails2.forEach(f -> f.setCustomerId(customerId));
/* 251 */         this.customerFamilyRepository.saveAll(customerDetails2);
/*     */       } 
/*     */       
/* 254 */       logger.info("// 3. Luu tiep don");
/*     */       
/* 256 */       boolean isCreateInvoice = true;
/* 257 */       MedicCheckin checkin = (MedicCheckin)this.modelMapper.map(request, MedicCheckin.class);
/* 258 */       checkin.setId(Integer.valueOf(0));
/* 259 */       checkin.setRoomId(request.getRoomId());
/* 260 */       checkin.setServiceId(request.getServiceId());
/* 261 */       checkin.setPatientId(Integer.valueOf(customersOld.getId()));
/* 262 */       checkin.setPatientNumber(customersOld.getPatientNumber());
/* 263 */       checkin.setCreatedAt(new Date());
/* 264 */       checkin.setInsuranceId(insuranceId);
/*     */       
/* 266 */       checkin.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 267 */       checkin.setPaymentStatus(TicketStatus.UNPAID.getTicketStatus());
/* 268 */       MedicCheckin rsCheckin = (MedicCheckin)this.checkinRepository.saveAndFlush(checkin);
/*     */ 
/*     */       
/* 271 */       MedicCheckinRecord medicCheckinRecord = (MedicCheckinRecord)this.modelMapper.map(request, MedicCheckinRecord.class);
/* 272 */       medicCheckinRecord.setCheckinId(rsCheckin.getId());
/* 273 */       medicCheckinRecord.setMdType(CheckinType.OUT_PATIENT.getCheckinType());
/* 274 */       medicCheckinRecord.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 275 */       medicCheckinRecord.setCustomerType(request.getCustomerType());
/*     */       
/* 277 */       isCreateInvoice = true;
/* 278 */       medicCheckinRecord.setCreatedAt(new Date());
/*     */       
/* 280 */       medicCheckinRecord = (MedicCheckinRecord)this.medicCheckinRecordRepository.saveAndFlush(medicCheckinRecord);
/*     */       
/* 282 */       Integer num = this.medicService.getSttCheckin(medicCheckinRecord.getMdId(), request.getRoomId());
/* 283 */       this.medicCheckinRecordRepository.updateStt(medicCheckinRecord.getMdId(), num);
/*     */       
/* 285 */       this.checkinRepository.updateStt(rsCheckin.getId(), num);
/*     */       
/* 287 */       if (isCreateInvoice) {
/*     */         
/* 289 */         Double price = Double.valueOf(0.0D);
/* 290 */         Double total = Double.valueOf(0.0D);
/* 291 */         Double payAmount = null;
/* 292 */         Double insurance = null;
/* 293 */         MedicServices medicServices = null;
/* 294 */         String status = OrderStatus.UNPAID.getOrderStatus();
/* 295 */         String serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */         try {
/* 297 */           medicServices = this.serviceRepository.findById(request.getServiceId()).orElse(null);
/* 298 */           if (medicServices != null) {
/* 299 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.fee.getCustomerType())) {
/* 300 */               total = payAmount = price = medicServices.getPrice();
/* 301 */               serviceObj = ServiceObjectType.fee.getServiceObjectType();
/*     */             } 
/* 303 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.request.getCustomerType())) {
/* 304 */               total = payAmount = price = medicServices.getPrice();
/* 305 */               serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */             } 
/* 307 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType())) {
/* 308 */               status = OrderStatus.BHYT.getOrderStatus();
/* 309 */               payAmount = insurance = medicServices.getPriceIns();
/* 310 */               price = medicServices.getPrice();
/* 311 */               total = Double.valueOf(payAmount.doubleValue() - medicServices.getPriceIns().doubleValue());
/* 312 */               serviceObj = ServiceObjectType.bhyt.getServiceObjectType();
/*     */             } 
/* 314 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType())) {
/* 315 */               status = OrderStatus.PAID.getOrderStatus();
/* 316 */               total = payAmount = price = medicServices.getPrice();
/* 317 */               serviceObj = ServiceObjectType.free.getServiceObjectType();
/*     */             } 
/*     */           } else {
/* 320 */             total = payAmount = price = medicServices.getPrice();
/*     */           } 
/* 322 */         } catch (Exception ex) {
/* 323 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 324 */           logger.error(exceptionAsString);
/*     */         } 
/*     */         
/* 327 */         if (total.doubleValue() == 0.0D) {
/* 328 */           status = OrderStatus.PAID.getOrderStatus();
/* 329 */           this.medicCheckinRecordRepository.updatePayemntStatus(medicCheckinRecord.getMdId(), OrderStatus.PAID.getOrderStatus());
/*     */         } 
/*     */         
/* 332 */         if (!ObjectUtils.isEmpty(medicServices)) {
/* 333 */           logger.info("// 4. create order service: luon tao phieu thu");
/* 334 */           String barcode = this.medicService.getBarcode(rsCheckin.getId(), new Date());
/* 335 */           MedicTicket medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/* 336 */               .mdId(medicCheckinRecord.getMdId())
/* 337 */               .checkinPatientId(rsCheckin.getPatientId())
/* 338 */               .checkinName(customersOld.getName())
/* 339 */               .ticketType(TicketType.SERVICE.getTicketType())
/* 340 */               .barCode(barcode)
/* 341 */               .code("KBD")
/* 342 */               .checkinName("KBD")
/* 343 */               .serviceGroupCode(medicServices.getServiceGroupCode())
/* 344 */               .createdId(request.getCreatorId())
/* 345 */               .roomId(request.getRoomId())
/* 346 */               .createdAt(new Date())
/* 347 */               .orderDate(new Date())
/* 348 */               .isDeleteSample(Integer.valueOf(0))
/* 349 */               .isShowSample(Integer.valueOf(0))
/* 350 */               .isDeleteHandle(Integer.valueOf(0))
/* 351 */               .isShowHandle(Integer.valueOf(0))
/* 352 */               .status(status)
/* 353 */               .build());
/* 354 */           logger.info("// 5. tao phieu yeu cau");
/*     */           
/* 356 */           this.orderServiceRepository.saveAndFlush(MedicOrderServices.builder()
/* 357 */               .ticketId(medicTicket.getId())
/* 358 */               .mdId(medicCheckinRecord.getMdId())
/* 359 */               .customerId(Integer.valueOf(customersOld.getId()))
/* 360 */               .serviceId(medicServices.getId())
/* 361 */               .serviceCode(medicServices.getCode())
/* 362 */               .serviceName(medicServices.getName())
/* 363 */               .serviceGroupId(medicServices.getServiceGroupId())
/* 364 */               .qty(Integer.valueOf(1))
/* 365 */               .unitId(medicServices.getUnitId())
/* 366 */               .unit(medicServices.getUnit())
/* 367 */               .price(price)
/* 368 */               .totalAmount(total)
/* 369 */               .payAmount(payAmount)
/* 370 */               .currencyCode(this.medicService.getCurrency())
/* 371 */               .payment(status)
/* 372 */               .creatorId(request.getCreatorId())
/* 373 */               .createdAt(new Date())
/* 374 */               .status(status)
/* 375 */               .serviceObject(serviceObj)
/* 376 */               .insurancePay(insurance)
/* 377 */               .build());
/*     */         } else {
/* 379 */           medicCheckinRecord.setMdId(medicCheckinRecord.getMdId());
/* 380 */           medicCheckinRecord.setStatus(CheckinStatus.WAITING.getCheckinStatus());
/* 381 */           medicCheckinRecord.setPaymentStatus(OrderStatus.PAID.getOrderStatus());
/* 382 */           this.medicCheckinRecordRepository.saveAndFlush(medicCheckinRecord);
/*     */         } 
/*     */       } 
/*     */       
/* 386 */       data.put("patientId", rsCheckin.getPatientId());
/* 387 */       data.put("patientNumber", rsCheckin.getPatientNumber());
/* 388 */       data.put("mdId", medicCheckinRecord.getMdId());
/* 389 */       data.put("id", rsCheckin.getId());
/*     */       
/* 391 */       rs.put("status", "OK");
/* 392 */       rs.put("responseCode", "00");
/* 393 */       rs.put("data", data);
/*     */     }
/* 395 */     catch (Exception e) {
/* 396 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 397 */       logger.error(exceptionAsString);
/* 398 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 399 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 401 */     return rs;
/*     */   }
/*     */   
/*     */   private boolean isCreateInvoice(@RequestBody @Valid CheckinRequest request, boolean isCreateInvoice, MedicCheckinRecord medicCheckinRecord) {
/* 405 */     if (request.getExaminationType().equalsIgnoreCase(ExaminationTypeStatus.CC.getExaminationType())) {
/* 406 */       medicCheckinRecord.setPaymentStatus(OrderStatus.PAID.getOrderStatus());
/* 407 */       isCreateInvoice = false;
/*     */     } 
/* 409 */     if (request.getExaminationType().equalsIgnoreCase(ExaminationTypeStatus.KT.getExaminationType())) {
/* 410 */       medicCheckinRecord.setPaymentStatus(OrderStatus.UNPAID.getOrderStatus());
/*     */     }
/* 412 */     return isCreateInvoice;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_checkin/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody CheckinRequest request) {
/* 421 */     ApiResponse rs = new ApiResponse();
/* 422 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 425 */       if (id == null || id.intValue() <= 0) {
/* 426 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 429 */       MedicCheckin checkinOld = this.checkinRepository.findById(id).orElse(null);
/* 430 */       if (ObjectUtils.isEmpty(checkinOld)) {
/* 431 */         return this.apiError.getError("02");
/*     */       }
/* 433 */       Integer oldRoomId = checkinOld.getRoomId();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 440 */       Optional<MedicRooms> medicRooms = this.roomRepository.findById(request.getRoomId());
/* 441 */       if (!medicRooms.isPresent()) {
/* 442 */         return this.apiError.getError("301", new String[] { request.getRoomId() + "" });
/*     */       }
/*     */ 
/*     */       
/* 446 */       Optional<LocalProvinces> provinces = this.provinceRepository.findByCode(request.getProvinceCode());
/* 447 */       if (!provinces.isPresent()) {
/* 448 */         return this.apiError.getError("304", new String[] { request.getProvinceCode() });
/*     */       }
/*     */       
/* 451 */       Optional<LocalDistricts> districts = this.districtRepository.findByCode(request.getDistrictCode());
/* 452 */       if (!districts.isPresent()) {
/* 453 */         return this.apiError.getError("305", new String[] { request.getDistrictCode() });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 461 */       Integer insurance = this.medicService.updateCustomersInsurance(request.getCustomersInsurance(), request.getPatientId(), request.getCreatorId());
/*     */       
/* 463 */       logger.info("// 1. Luu thong tin tiep don");
/*     */ 
/*     */       
/* 466 */       MedicCheckin checkin = (MedicCheckin)this.modelMapper.map(request, MedicCheckin.class);
/* 467 */       checkin.setId(id);
/* 468 */       checkin.setUpdatedAt(new Date());
/* 469 */       checkin.setRoomId(request.getRoomId());
/* 470 */       checkin.setServiceId(request.getServiceId());
/* 471 */       checkin.setCreatedAt(checkinOld.getCreatedAt());
/* 472 */       checkin.setPatientId(checkinOld.getPatientId());
/* 473 */       checkin.setPatientNumber(checkinOld.getPatientNumber());
/* 474 */       checkin.setStatus(checkinOld.getStatus());
/* 475 */       checkin.setNumber(checkinOld.getNumber());
/* 476 */       checkin.setPaymentStatus(checkinOld.getPaymentStatus());
/* 477 */       checkin.setInsuranceId(insurance);
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
/* 488 */       this.checkinRepository.saveAndFlush(checkin);
/* 489 */       List<MedicCheckinRecord> medicCheckinRecordDbs = this.medicCheckinRecordRepository.findAllByCheckinId(id);
/* 490 */       MedicCheckinRecord oldRecord = medicCheckinRecordDbs.get(0);
/*     */       
/* 492 */       MedicCheckinRecord medicCheckinRecord = (MedicCheckinRecord)this.modelMapper.map(request, MedicCheckinRecord.class);
/* 493 */       medicCheckinRecord.setMdId(oldRecord.getMdId());
/* 494 */       medicCheckinRecord.setCheckinId(id);
/* 495 */       medicCheckinRecord.setCreatedAt(oldRecord.getCreatedAt());
/* 496 */       medicCheckinRecord.setUpdatedAt(new Date());
/* 497 */       medicCheckinRecord.setMdType(CheckinType.OUT_PATIENT.getCheckinType());
/* 498 */       medicCheckinRecord.setStatus(oldRecord.getStatus());
/* 499 */       medicCheckinRecord.setPaymentStatus(oldRecord.getPaymentStatus());
/* 500 */       medicCheckinRecord.setCustomerType(request.getCustomerType());
/* 501 */       medicCheckinRecord = (MedicCheckinRecord)this.medicCheckinRecordRepository.saveAndFlush(medicCheckinRecord);
/*     */       
/* 503 */       logger.info("// 2. Luu thong tin khach hang");
/* 504 */       Customers customers = this.customerRepository.findById(checkinOld.getPatientId()).orElse(null);
/* 505 */       if (ObjectUtils.isEmpty(customers)) {
/* 506 */         return this.apiError.getError("202", new String[] { "Khách hàng mã " + checkinOld.getPatientId() });
/*     */       }
/* 508 */       customers = (Customers)this.modelMapper.map(request, Customers.class);
/* 509 */       customers.setId(checkinOld.getPatientId().intValue());
/* 510 */       customers.setUpdatedAt(new Date());
/* 511 */       customers.setAddress2(request.getAddress2());
/* 512 */       customers.setCustomerProvince(request.getProvinceCode());
/* 513 */       customers.setCustomerDistrict(request.getDistrictCode());
/* 514 */       customers.setCustomerWards(request.getWardCode());
/* 515 */       customers = (Customers)this.customerRepository.saveAndFlush(customers);
/*     */       
/* 517 */       logger.info("// 3. Luu thong tin nguoi nha");
/* 518 */       if (request.getCustomerFamilys() != null && request.getCustomerFamilys().size() > 0) {
/* 519 */         List<CustomerFamily> customerFamilys = this.customerFamilyRepository.findAllByCustomerId(request.getPatientId());
/*     */         
/* 521 */         List<CustomerFamily> customerDetails2 = (List<CustomerFamily>)request.getCustomerFamilys().stream().map(c -> (CustomerFamily)this.modelMapper.map(c, CustomerFamily.class)).collect(Collectors.toList());
/*     */         
/* 523 */         this.customerFamilyRepository.deleteAll(customerFamilys);
/* 524 */         Integer customerId = Integer.valueOf(customers.getId());
/* 525 */         customerDetails2.forEach(f -> f.setCustomerId(customerId));
/* 526 */         this.customerFamilyRepository.saveAll(customerDetails2);
/*     */       } 
/*     */ 
/*     */       
/* 530 */       if (!oldRoomId.equals(request.getRoomId())) {
/*     */         
/* 532 */         Integer num = this.medicService.getSttCheckin(medicCheckinRecord.getMdId(), request.getRoomId());
/* 533 */         this.medicCheckinRecordRepository.updateStt(medicCheckinRecord.getMdId(), num);
/*     */         
/* 535 */         this.checkinRepository.updateStt(checkin.getId(), num);
/*     */       } 
/*     */       
/* 538 */       Integer checkPayment = this.orderServiceRepository.havingOrderServicePayment(oldRecord.getMdId(), OrderStatus.PAID.getOrderStatus());
/*     */       
/* 540 */       logger.info("// 4. Tao invoice");
/*     */       
/* 542 */       if (checkinOld.getPaymentStatus().equalsIgnoreCase(OrderStatus.UNPAID.getOrderStatus()) && checkPayment.intValue() <= 0) {
/*     */         
/* 544 */         Double price = Double.valueOf(0.0D);
/* 545 */         Double total = Double.valueOf(0.0D);
/* 546 */         Double payAmount = null;
/* 547 */         Double insurance1 = null;
/* 548 */         MedicServices medicServices = null;
/* 549 */         String status = OrderStatus.UNPAID.getOrderStatus();
/* 550 */         String serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */         try {
/* 552 */           medicServices = this.serviceRepository.findById(request.getServiceId()).orElse(null);
/* 553 */           if (medicServices != null) {
/* 554 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.fee.getCustomerType())) {
/* 555 */               total = payAmount = price = medicServices.getPrice();
/* 556 */               serviceObj = ServiceObjectType.fee.getServiceObjectType();
/*     */             } 
/* 558 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.request.getCustomerType())) {
/* 559 */               total = payAmount = price = medicServices.getPrice();
/* 560 */               serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */             } 
/* 562 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.bhyt.getCustomerType())) {
/* 563 */               status = OrderStatus.BHYT.getOrderStatus();
/* 564 */               price = medicServices.getPrice();
/* 565 */               payAmount = insurance1 = medicServices.getPriceIns();
/* 566 */               serviceObj = ServiceObjectType.bhyt.getServiceObjectType();
/* 567 */               total = Double.valueOf(payAmount.doubleValue() - medicServices.getPriceIns().doubleValue());
/*     */             } 
/* 569 */             if (request.getCustomerType().equalsIgnoreCase(CustomerType.free.getCustomerType())) {
/* 570 */               status = OrderStatus.PAID.getOrderStatus();
/* 571 */               total = payAmount = price = medicServices.getPrice();
/* 572 */               serviceObj = ServiceObjectType.free.getServiceObjectType();
/*     */             } 
/*     */           } else {
/* 575 */             total = payAmount = price = medicServices.getPrice();
/*     */           } 
/* 577 */         } catch (Exception ex) {
/* 578 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 579 */           logger.error(exceptionAsString);
/*     */         } 
/* 581 */         if (total.doubleValue() == 0.0D) {
/* 582 */           status = OrderStatus.PAID.getOrderStatus();
/* 583 */           this.medicCheckinRecordRepository.updatePayemntStatus(medicCheckinRecord.getMdId(), OrderStatus.PAID.getOrderStatus());
/*     */         } 
/* 585 */         logger.info("// 5. xoa invoice cũ");
/* 586 */         MedicOrderServices medicOrderServices = this.orderServiceRepository.findFirstByMdId(medicCheckinRecord.getMdId()).orElse(null);
/* 587 */         if (medicOrderServices != null) {
/*     */           
/* 589 */           logger.info("// 6. tao phieu yeu cau");
/* 590 */           logger.info("// 7. create order service: luon tao phieu thu");
/* 591 */           if (!ObjectUtils.isEmpty(medicServices)) {
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
/* 610 */             MedicOrderServices ms = MedicOrderServices.builder().mdId(medicCheckinRecord.getMdId()).customerId(Integer.valueOf(customers.getId())).serviceId(medicServices.getId()).serviceCode(medicServices.getCode()).serviceName(medicServices.getName()).serviceGroupId(medicServices.getServiceGroupId()).qty(Integer.valueOf(1)).price(price).totalAmount(total).payAmount(payAmount).currencyCode(this.medicService.getCurrency()).payment(status).status(status).creatorId(request.getCreatorId()).createdAt(new Date()).serviceObject(serviceObj).insurancePay(insurance1).build();
/* 611 */             ms.setTicketId(medicOrderServices.getTicketId());
/* 612 */             ms.setId(medicOrderServices.getId());
/* 613 */             this.orderServiceRepository.saveAndFlush(ms);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 620 */       data.put("patientNumber", checkinOld.getPatientNumber());
/* 621 */       data.put("id", checkinOld.getId());
/*     */       
/* 623 */       rs.put("status", "OK");
/* 624 */       rs.put("responseCode", "00");
/* 625 */       rs.put("data", data);
/*     */     }
/* 627 */     catch (Exception e) {
/* 628 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 629 */       logger.error(exceptionAsString);
/* 630 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 631 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 633 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @DeleteMapping({"/medic_checkin/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 642 */     ApiResponse rs = new ApiResponse();
/* 643 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 646 */       if (id == null) {
/* 647 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 650 */       Optional<MedicCheckin> g = this.checkinRepository.findById(id);
/* 651 */       if (!g.isPresent()) {
/* 652 */         return this.apiError.getError("02");
/*     */       }
/* 654 */       if (((MedicCheckin)g.get()).getPaymentStatus().equalsIgnoreCase(OrderStatus.PAID.getOrderStatus())) {
/* 655 */         return this.apiError.getError("802");
/*     */       }
/* 657 */       List<MedicCheckinRecord> medicCheckinRecordDbs = this.medicCheckinRecordRepository.findAllByCheckinId(id);
/* 658 */       if (medicCheckinRecordDbs == null || medicCheckinRecordDbs.size() <= 0)
/* 659 */         return this.apiError.getError("02"); 
/* 660 */       MedicCheckinRecord oldRecord = medicCheckinRecordDbs.get(0);
/* 661 */       Integer checkPayment = this.orderServiceRepository.havingOrderServicePayment(oldRecord.getMdId(), OrderStatus.PAID.getOrderStatus());
/* 662 */       if (checkPayment.intValue() > 0) {
/* 663 */         return this.apiError.getError("802");
/*     */       }
/*     */ 
/*     */       
/* 667 */       this.checkinHisRepository.saveAndFlush(this.modelMapper.map(g.get(), MedicCheckinHis.class));
/* 668 */       this.medicCheckinRecordHisRepository.saveAndFlush(this.modelMapper.map(oldRecord, MedicCheckinRecordHis.class));
/*     */ 
/*     */       
/* 671 */       this.checkinRepository.deleteById(id);
/*     */       
/* 673 */       rs.put("status", "OK");
/* 674 */       rs.put("responseCode", "00");
/* 675 */       rs.put("data", data);
/*     */     }
/* 677 */     catch (Exception e) {
/* 678 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 679 */       logger.error(exceptionAsString);
/* 680 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 681 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 683 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin/getByPartial/{patientId}"})
/*     */   public ApiResponse getByPartial(@PathVariable @Valid String patientId) {
/* 691 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 694 */       if (ObjectUtils.isEmpty(patientId)) {
/* 695 */         return this.apiError.getError("02");
/*     */       }
/* 697 */       List<CheckinResponse> medictRs = this.medicService.getCheckinInfo(1, 10, null, "", "", patientId, "", "", "");
/*     */       
/* 699 */       for (CheckinResponse x : medictRs) {
/* 700 */         List<CustomerFamily> customerFamily = this.customerFamilyRepository.findAllByCustomerId(x.getPatientId());
/* 701 */         x.setCustomerFamilys(customerFamily);
/*     */       } 
/*     */       
/* 704 */       rs.put("status", "OK");
/* 705 */       rs.put("responseCode", "00");
/* 706 */       CheckinResponse cr = !medictRs.isEmpty() ? medictRs.get(0) : null;
/* 707 */       if (cr != null) {
/* 708 */         cr.setId(null);
/*     */       }
/* 710 */       rs.put("data", cr);
/*     */     }
/* 712 */     catch (Exception e) {
/* 713 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 714 */       logger.error(exceptionAsString);
/* 715 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 717 */     return rs;
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
/*     */   @GetMapping({"/medic_examination"})
/*     */   public ApiResponse getExamination(@Valid @RequestParam Integer userId, @Valid @RequestParam Integer roomId, @Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "createdAt", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*     */     try {
/* 734 */       if (ObjectUtils.isEmpty(userId)) {
/* 735 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 745 */       return getCheckinRecordProcess(page, size, filter, fieldSort, direction, new String[] { CheckinStatus.WAITING
/* 746 */             .getCheckinStatus(), CheckinStatus.PROCESSING
/* 747 */             .getCheckinStatus(), CheckinStatus.DONE
/* 748 */             .getCheckinStatus() }, roomId, OrderStatus.PAID
/* 749 */           .getOrderStatus(), CheckinType.OUT_PATIENT.getCheckinType());
/* 750 */     } catch (Exception e) {
/* 751 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 752 */       logger.error(exceptionAsString);
/* 753 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
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
/*     */   @GetMapping({"/medic_examination1"})
/*     */   public ApiResponse getMedicExamination1(@Valid @RequestParam Integer userId, @RequestParam(required = false) Integer roomId, @RequestParam(required = false) String patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String customerType, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 769 */     ApiResponse rs = new ApiResponse();
/* 770 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 772 */       List<MedicCheckinRecordModel> list = this.medicService.getSearchExamination(page, size, userId, roomId, patientId, name, customerType, fromDate, toDate);
/*     */       
/* 774 */       data.put("dataRes", list);
/* 775 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicCheckinRecordModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 777 */       rs.put("status", "OK");
/* 778 */       rs.put("responseCode", "00");
/* 779 */       rs.put("data", data);
/* 780 */     } catch (Exception e) {
/* 781 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 782 */       logger.error(exceptionAsString);
/* 783 */       rs = this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 785 */     return rs;
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
/*     */   @GetMapping({"/medic_examination_store"})
/*     */   public ApiResponse getExamination(@Valid @RequestParam Integer userId, @RequestParam(required = false) Integer roomId, @RequestParam(required = false) Integer patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 801 */     ApiResponse rs = new ApiResponse();
/* 802 */     Map<String, Object> data = new HashMap<>();
/*     */ 
/*     */     
/*     */     try {
/* 806 */       List<MedicCheckinRecordModel> list = this.commonCheckinRepo.getCheckinRecordSp(userId, roomId, null, patientId, "", "", CheckinType.OUT_PATIENT
/* 807 */           .getCheckinType(), fromDate, toDate, "", "", page, size);
/*     */       
/* 809 */       data.put("dataRes", list);
/* 810 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicCheckinRecordModel)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 812 */       rs.put("status", "OK");
/* 813 */       rs.put("responseCode", "00");
/* 814 */       rs.put("data", data);
/* 815 */     } catch (Exception e) {
/* 816 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 817 */       logger.error(exceptionAsString);
/* 818 */       rs = this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 820 */     return rs;
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
/*     */   @GetMapping({"/medic_checkin_payment"})
/*     */   public ApiResponse getCheckInPayment(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "createdAt", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*     */     try {
/* 835 */       return getCheckinProcess(page, size, filter, fieldSort, direction, new String[] { CheckinStatus.PROCESSING
/* 836 */             .getCheckinStatus(), CheckinStatus.DONE
/* 837 */             .getCheckinStatus(), CheckinStatus.WAITING
/* 838 */             .getCheckinStatus() }, null, null);
/*     */     }
/* 840 */     catch (Exception e) {
/* 841 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 842 */       logger.error(exceptionAsString);
/* 843 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
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
/*     */   @GetMapping({"/medic_checkin_payment2"})
/*     */   public ApiResponse getCheckInPayment(@RequestParam(required = false) String patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 858 */     ApiResponse rs = new ApiResponse();
/* 859 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 862 */       List<CheckinResponse> medictRs = this.medicService.getCheckinInfo(page, size, null, name, "", patientId, "", fromDate, toDate);
/* 863 */       data.put("checkins", medictRs);
/* 864 */       data.put("totalItems", Integer.valueOf((medictRs.size() > 0) ? ((CheckinResponse)medictRs.get(0)).getTotalRecord() : 0));
/*     */       
/* 866 */       rs.put("status", "OK");
/* 867 */       rs.put("responseCode", "00");
/* 868 */       rs.put("data", data);
/* 869 */     } catch (Exception e) {
/* 870 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 871 */       logger.error(exceptionAsString);
/* 872 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 874 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin/getCheckinService/{checkinId}"})
/*     */   public ApiResponse getCheckinService(@PathVariable @Valid Integer checkinId) {
/* 883 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 886 */       if (checkinId == null) {
/* 887 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/*     */       
/* 890 */       MedicCheckin medicCheckin = this.checkinRepository.findById(checkinId).orElse(null);
/* 891 */       if (medicCheckin == null) {
/* 892 */         return this.apiError.getError("202", new String[] { String.valueOf(checkinId) });
/*     */       }
/*     */       
/* 895 */       List<Integer> mdIds = this.medicCheckinRecordRepository.findIntergerAllByCheckinId(checkinId);
/*     */ 
/*     */ 
/*     */       
/* 899 */       List<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findAllByMdIdInOrderByCreatedAtDesc(mdIds).orElse(new ArrayList<>());
/*     */       
/* 901 */       List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSp(checkinId, null);
/* 902 */       for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */         
/* 904 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/* 905 */         medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */       } 
/*     */       
/* 908 */       InvoiceRequest invoiceRequest = InvoiceRequest.builder().build();
/* 909 */       invoiceRequest.setOrderServiceRequests((List)medicOrderServices
/*     */           
/* 911 */           .stream()
/* 912 */           .map(m -> (OrderServiceRequest)this.modelMapper.map(m, OrderServiceRequest.class))
/* 913 */           .collect(Collectors.toList()));
/*     */       
/* 915 */       invoiceRequest.setOrderProductRequests(medicProductOrderModels);
/*     */       
/* 917 */       invoiceRequest.setCheckinStatus(medicCheckin.getStatus());
/*     */       
/* 919 */       rs.put("status", "OK");
/* 920 */       rs.put("responseCode", "00");
/* 921 */       rs.put("data", invoiceRequest);
/*     */     }
/* 923 */     catch (Exception e) {
/* 924 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 925 */       logger.error(exceptionAsString);
/* 926 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 928 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_checkin/filterData"})
/*     */   public ApiResponse getFilterData(@Valid @RequestBody FilterData filterData) {
/* 936 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 938 */       if (filterData == null) {
/* 939 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/* 941 */       String sql = String.format("SELECT * FROM %s", new Object[] { filterData.getFilter() });
/* 942 */       List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
/*     */       
/* 944 */       rs.put("status", "OK");
/* 945 */       rs.put("responseCode", "00");
/* 946 */       rs.put("data", rows);
/*     */     }
/* 948 */     catch (Exception e) {
/* 949 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 950 */       logger.error(exceptionAsString);
/* 951 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 953 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\CheckinController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */