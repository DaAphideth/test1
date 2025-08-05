/*      */ package nencer.app.Modules.Medic.Service;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Optional;
/*      */ import java.util.stream.Collectors;
/*      */ import nencer.app.Constant.CheckinSttStatus;
/*      */ import nencer.app.Constant.OrderStatus;
/*      */ import nencer.app.Constant.OrdinalDoor;
/*      */ import nencer.app.Constant.ServiceObjectType;
/*      */ import nencer.app.Constant.TicketStatus;
/*      */ import nencer.app.Constant.TicketType;
/*      */ import nencer.app.Modules.Customer.Entity.Customers;
/*      */ import nencer.app.Modules.Customer.Entity.CustomersInsurance;
/*      */ import nencer.app.Modules.Customer.Model.CustomerDetailObjectModel;
/*      */ import nencer.app.Modules.Customer.Model.CustomerDetailsShortModel;
/*      */ import nencer.app.Modules.Customer.Model.CustomerShortModel;
/*      */ import nencer.app.Modules.Customer.Repository.CustomerRepository;
/*      */ import nencer.app.Modules.Customer.Repository.CustomersInsuranceRepository;
/*      */ import nencer.app.Modules.Localization.Entity.LocalDistricts;
/*      */ import nencer.app.Modules.Localization.Entity.LocalProvinces;
/*      */ import nencer.app.Modules.Localization.Entity.LocalWards;
/*      */ import nencer.app.Modules.Localization.Repository.ProvinceRepository;
/*      */ import nencer.app.Modules.Localization.Repository.WardRepository;
/*      */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*      */ import nencer.app.Modules.MasterData.Repository.MedicMasterDataRepository;
/*      */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*      */ import nencer.app.Modules.Medic.Entity.CustomerOrdinal.MedicCustomerOrdinal;
/*      */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*      */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*      */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicketBarcode;
/*      */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
/*      */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*      */ import nencer.app.Modules.Medic.Entity.TestCode.MedicTestDevice;
/*      */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinLiveDetail;
/*      */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetail;
/*      */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetailTicket;
/*      */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPaymentShortResponse;
/*      */ import nencer.app.Modules.Medic.Model.Checkin.CheckinResponse;
/*      */ import nencer.app.Modules.Medic.Model.Checkin.CheckinSttInterface;
/*      */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordModel;
/*      */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinal;
/*      */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinalResponse;
/*      */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.ExaminationCallingUserResponse;
/*      */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.OrdinalDoorNumberResponse;
/*      */ import nencer.app.Modules.Medic.Model.Drug.DrugIngredientsResponse;
/*      */ import nencer.app.Modules.Medic.Model.DrugIngredientInteraction.DrugIngredientInteractionResponse;
/*      */ import nencer.app.Modules.Medic.Model.Examination.InsuranceCustomerModel;
/*      */ import nencer.app.Modules.Medic.Model.InsuranceCards.InsuranceCardsResponse;
/*      */ import nencer.app.Modules.Medic.Model.LisRis.LisRisModel;
/*      */ import nencer.app.Modules.Medic.Model.LisRis.RisModel;
/*      */ import nencer.app.Modules.Medic.Model.OrderService.InvoiceRequest;
/*      */ import nencer.app.Modules.Medic.Model.OrderService.OrderServiceRequest;
/*      */ import nencer.app.Modules.Medic.Model.PrescriptionCeiling.PrescriptionCeilingResponse;
/*      */ import nencer.app.Modules.Medic.Model.Response.MedicExamination.PaymentDetailModel;
/*      */ import nencer.app.Modules.Medic.Model.Response.MedicTreatment.TreatmentDetailModel;
/*      */ import nencer.app.Modules.Medic.Model.Room.MedicBedResponse;
/*      */ import nencer.app.Modules.Medic.Model.Room.MedicChamberResponse;
/*      */ import nencer.app.Modules.Medic.Model.Service.ServiceRequest;
/*      */ import nencer.app.Modules.Medic.Model.TestCode.TestCodeMappingModel;
/*      */ import nencer.app.Modules.Medic.Model.TreatmentRegimen.TreatmentRegimenResponse;
/*      */ import nencer.app.Modules.Medic.Repository.Barcode.CommonBarcodeRepo;
/*      */ import nencer.app.Modules.Medic.Repository.Barcode.TicketBarcodeRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Checkin.CheckinSttRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Checkin.MedicCheckinRecordRepository;
/*      */ import nencer.app.Modules.Medic.Repository.CustomerOrdinal.CustomerOrdinalRepository;
/*      */ import nencer.app.Modules.Medic.Repository.OrderServiceExtRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Service.ServiceRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinTreatmentDetailRepository;
/*      */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinTreatmentDetailTicketRepository;
/*      */ import nencer.app.Modules.Storehouse.Model.ProductTreatmentDetailModel;
/*      */ import nencer.app.Modules.Storehouse.Repository.CommonStoreHouseRepo;
/*      */ import nencer.app.Utils.ApiHelper;
/*      */ import nencer.app.Utils.DataUtil;
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.core.env.Environment;
/*      */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*      */ import org.springframework.jdbc.core.JdbcTemplate;
/*      */ import org.springframework.jdbc.core.RowMapper;
/*      */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*      */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*      */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*      */ import org.springframework.stereotype.Service;
/*      */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*      */ import org.springframework.util.CollectionUtils;
/*      */ 
/*      */ @Service
/*      */ public class MedicService {
/*   97 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationController.class);
/*      */   
/*      */   @Autowired
/*      */   CommonBhytRepo commonBhytRepo;
/*      */   
/*      */   @Autowired
/*      */   Environment env;
/*      */   
/*      */   @Autowired
/*      */   ServiceTypeRepository serviceTypeRepository;
/*      */   
/*      */   @Autowired
/*      */   ServiceGroupRepository serviceGroupRepository;
/*      */   
/*      */   @Autowired
/*      */   TicketRepository ticketRepository;
/*      */   
/*      */   @Autowired
/*      */   ServiceRepository serviceRepository;
/*      */   
/*      */   @Autowired
/*      */   OrderServiceRepository orderServiceRepository;
/*      */   
/*      */   @Autowired
/*      */   TicketBarcodeRepository ticketBarcodeRepository;
/*      */   
/*      */   @Autowired
/*      */   CommonBarcodeRepo commonBarcodeRepo;
/*      */   
/*      */   @Autowired
/*      */   ProvinceRepository provinceRepository;
/*      */   
/*      */   @Autowired
/*      */   DistrictRepository districtRepository;
/*      */   
/*      */   @Autowired
/*      */   WardRepository wardRepository;
/*      */   
/*      */   @Autowired
/*      */   CustomerRepository customerRepository;
/*      */   
/*      */   @Autowired
/*      */   OrderServiceExtRepository orderServiceExtRepository;
/*      */   
/*      */   @Autowired
/*      */   MedicMasterDataRepository medicMasterDataRepository;
/*      */   
/*      */   @Autowired
/*      */   CustomerOrdinalRepository customerOrdinalRepository;
/*      */   
/*      */   @Autowired
/*      */   CheckinSttRepository checkinSttRepository;
/*      */   
/*      */   @Autowired
/*      */   CustomersInsuranceRepository insuranceRepository;
/*      */   
/*      */   @Autowired
/*      */   JdbcTemplate jdbcTemplate;
/*      */   
/*      */   @Autowired
/*      */   MedicCheckinRecordRepository medicCheckinRecordRepository;
/*      */   
/*      */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*      */   
/*      */   @Autowired
/*      */   MedicCheckinTreatmentDetailRepository medicCheckinTreatmentDetailRepository;
/*      */   
/*      */   @Autowired
/*      */   MedicCheckinTreatmentDetailTicketRepository medicCheckinTreatmentDetailTicketRepository;
/*      */   
/*      */   @Autowired
/*      */   CommonStoreHouseRepo commonStoreHouseRepo;
/*      */ 
/*      */   
/*      */   public String saveOrderTicket(Integer ticketId, MedicCheckinRecord checkinRecord, OrderServiceRequest oreq) {
/*  172 */     MedicServices medicServices = this.serviceRepository.findById(oreq.getServiceId()).orElse(null);
/*  173 */     if (!ObjectUtils.isEmpty(medicServices)) {
/*      */       
/*  175 */       Double total = null;
/*  176 */       Double price = null;
/*  177 */       Double payAmount = null;
/*  178 */       Double insurance = null;
/*  179 */       String status = OrderStatus.UNPAID.getOrderStatus();
/*  180 */       String serviceObject = oreq.getServiceObject();
/*  181 */       if (StringUtils.isBlank(oreq.getServiceObject())) {
/*  182 */         serviceObject = checkinRecord.getCustomerType();
/*      */       }
/*      */       try {
/*  185 */         if (StringUtils.isNotBlank(serviceObject)) {
/*  186 */           if (serviceObject.equalsIgnoreCase(ServiceObjectType.fee.getServiceObjectType())) {
/*  187 */             total = payAmount = Double.valueOf(medicServices.getPrice().doubleValue() * oreq.getQty().intValue());
/*  188 */             price = medicServices.getPrice();
/*      */           } 
/*  190 */           if (serviceObject.equalsIgnoreCase(ServiceObjectType.request.getServiceObjectType())) {
/*  191 */             total = payAmount = Double.valueOf(medicServices.getPriceService().doubleValue() * oreq.getQty().intValue());
/*  192 */             price = medicServices.getPriceService();
/*      */           } 
/*  194 */           if (serviceObject.equalsIgnoreCase(ServiceObjectType.bhyt.getServiceObjectType())) {
/*  195 */             payAmount = insurance = Double.valueOf(medicServices.getPriceIns().doubleValue() * oreq.getQty().intValue());
/*  196 */             total = Double.valueOf(payAmount.doubleValue() - medicServices.getPriceIns().doubleValue() * oreq.getQty().intValue());
/*  197 */             price = medicServices.getPriceIns();
/*  198 */             status = OrderStatus.BHYT.getOrderStatus();
/*      */           } 
/*  200 */           if (serviceObject.equalsIgnoreCase(ServiceObjectType.free.getServiceObjectType())) {
/*  201 */             status = OrderStatus.PAID.getOrderStatus();
/*  202 */             total = payAmount = Double.valueOf(medicServices.getPrice().doubleValue() * oreq.getQty().intValue());
/*  203 */             price = medicServices.getPrice();
/*      */           } 
/*      */         } else {
/*  206 */           total = payAmount = Double.valueOf(medicServices.getPrice().doubleValue() * oreq.getQty().intValue());
/*  207 */           price = medicServices.getPrice();
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*  214 */       catch (Exception ex) {
/*  215 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  216 */         logger.error(exceptionAsString);
/*      */       } 
/*      */ 
/*      */       
/*      */       try {
/*  221 */         MedicOrderServices o = (MedicOrderServices)this.orderServiceRepository.saveAndFlush(MedicOrderServices.builder()
/*  222 */             .id((oreq.getId() != null && oreq.getId().intValue() >= 0) ? oreq.getId().intValue() : 0)
/*  223 */             .ticketId(ticketId)
/*  224 */             .mdId(checkinRecord.getMdId())
/*  225 */             .customerId(checkinRecord.getMedicCheckin().getPatientId())
/*  226 */             .serviceId(oreq.getServiceId())
/*  227 */             .serviceCode(medicServices.getCode())
/*  228 */             .serviceName(medicServices.getName())
/*  229 */             .serviceGroupId(medicServices.getServiceGroupId())
/*  230 */             .qty(oreq.getQty())
/*  231 */             .unit(oreq.getUnit())
/*  232 */             .unitId(oreq.getUnitId())
/*  233 */             .price(price)
/*  234 */             .totalAmount(total)
/*  235 */             .payAmount(payAmount)
/*  236 */             .insurancePay(insurance)
/*  237 */             .currencyCode(getCurrency())
/*  238 */             .payment(status)
/*  239 */             .status(status)
/*  240 */             .creatorId(checkinRecord.getMedicCheckin().getCreatorId())
/*  241 */             .createdAt(new Date())
/*  242 */             .roomHandleId(oreq.getRoomHandleId())
/*  243 */             .roomSampleId(oreq.getRoomSampleId())
/*  244 */             .serviceObject(oreq.getServiceObject())
/*  245 */             .build());
/*      */         
/*  247 */         if (oreq.getServiceGroupCode().intValue() == 2) {
/*  248 */           Optional<List<MedicServices>> lms = this.serviceRepository.findAllByParentIdAndStatus(oreq.getServiceId(), Integer.valueOf(1));
/*  249 */           if (lms.isPresent())
/*      */           {
/*  251 */             for (MedicServices ms : lms.get()) {
/*  252 */               this.orderServiceExtRepository.saveAndFlush(MedicOrderServicesExt.builder()
/*  253 */                   .orderServiceId(Integer.valueOf(o.getId()))
/*  254 */                   .serviceId(ms.getId())
/*  255 */                   .serviceCode(ms.getCode())
/*  256 */                   .serviceName(ms.getName())
/*  257 */                   .serviceGroupId(ms.getServiceGroupId())
/*  258 */                   .unitId(ms.getUnitId())
/*  259 */                   .createdAt(new Date())
/*  260 */                   .ticketId(ticketId)
/*  261 */                   .originalResult(ms.getOriginalResult())
/*  262 */                   .build());
/*      */             }
/*      */           }
/*      */         } 
/*  266 */       } catch (Exception ex) {
/*  267 */         String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  268 */         TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*  269 */         logger.error(exceptionAsString);
/*      */       } 
/*      */     } else {
/*  272 */       return "NOT FOUND";
/*      */     } 
/*  274 */     return "";
/*      */   }
/*      */   
/*      */   public MedicTicket saveTicket(MedicCheckinRecord checkinRecord, InvoiceRequest request, Integer key, String barcode) {
/*  278 */     Date createdDate = new Date();
/*  279 */     MedicTicket medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/*  280 */         .mdId(checkinRecord.getMdId())
/*  281 */         .checkinName(checkinRecord.getMedicCheckin().getCustomers().getName())
/*  282 */         .checkinPatientId(checkinRecord.getMedicCheckin().getPatientId())
/*  283 */         .barCode(barcode)
/*  284 */         .ticketType(TicketType.SERVICE.getTicketType())
/*  285 */         .serviceGroupCode(key)
/*  286 */         .createdAt(createdDate)
/*  287 */         .createdBy(request.getCreatorName())
/*  288 */         .createdId(request.getCreatorId())
/*  289 */         .orderDate((request.getOrderDate() == null) ? new Date() : request.getOrderDate())
/*  290 */         .diagnosticArray(request.getDiagnosticArray())
/*  291 */         .diagnosticSubArray(request.getDiagnosticSubArray())
/*  292 */         .roomId(checkinRecord.getRoomId())
/*  293 */         .status(TicketStatus.UNPAID.getTicketStatus())
/*  294 */         .isDeleteSample(Integer.valueOf(0))
/*  295 */         .isShowSample(Integer.valueOf(0))
/*  296 */         .isDeleteHandle(Integer.valueOf(0))
/*  297 */         .isShowHandle(Integer.valueOf(0))
/*  298 */         .chkRadio(request.getChkRadio())
/*  299 */         .build());
/*      */     
/*  301 */     if (request.getTreatmentDeatailId() == null) {
/*  302 */       MedicCheckinTreatmentDetail medicCheckinTreatmentDetail = (MedicCheckinTreatmentDetail)this.medicCheckinTreatmentDetailRepository.saveAndFlush(MedicCheckinTreatmentDetail.builder()
/*  303 */           .createdDate(createdDate)
/*  304 */           .mdId(checkinRecord.getMdId())
/*  305 */           .createdBy(request.getCreatorName())
/*  306 */           .createdId(request.getCreatorId())
/*  307 */           .build());
/*  308 */       this.medicCheckinTreatmentDetailTicketRepository.saveAndFlush(MedicCheckinTreatmentDetailTicket.builder()
/*  309 */           .ticketId(medicTicket.getId())
/*  310 */           .serviceGroupId(key)
/*  311 */           .ticketType(TicketType.SERVICE.getTicketType())
/*  312 */           .treatmentId(medicCheckinTreatmentDetail.getId())
/*  313 */           .build());
/*      */     } else {
/*      */       
/*  316 */       this.medicCheckinTreatmentDetailTicketRepository.saveAndFlush(MedicCheckinTreatmentDetailTicket.builder()
/*  317 */           .ticketId(medicTicket.getId())
/*  318 */           .serviceGroupId(key)
/*  319 */           .ticketType(TicketType.SERVICE.getTicketType())
/*  320 */           .treatmentId(request.getTreatmentDeatailId().intValue())
/*  321 */           .build());
/*      */     } 
/*  323 */     return medicTicket;
/*      */   }
/*      */   
/*      */   public String getBarcode(Integer mdId, Date orderDate) {
/*      */     try {
/*  328 */       Integer max = Integer.valueOf(5);
/*  329 */       MedicMasterData s = this.medicMasterDataRepository.findByMedicCode("barcode").orElse(null);
/*  330 */       if (s != null) {
/*      */         try {
/*  332 */           max = Integer.valueOf(Integer.parseInt(s.getDefaultValue()));
/*  333 */         } catch (Exception e) {
/*  334 */           max = Integer.valueOf(5);
/*      */         } 
/*      */       }
/*  337 */       Integer num = getMaxBarCodeTicket(max);
/*  338 */       String generateBarCode = ApiHelper.generateBarCode(num, max);
/*  339 */       this.ticketBarcodeRepository.saveAndFlush(MedicTicketBarcode.builder()
/*  340 */           .number(num)
/*  341 */           .mdId(mdId)
/*  342 */           .dateTime(generateBarCode)
/*  343 */           .createdAt(orderDate)
/*  344 */           .build());
/*      */       
/*  346 */       return ApiHelper.getBarCode(num, max);
/*  347 */     } catch (Exception ex) {
/*  348 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  349 */       logger.error(exceptionAsString);
/*  350 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private Integer getMaxBarCodeTicket(Integer max) {
/*      */     int num;
/*  357 */     Integer maxNum = this.commonBarcodeRepo.fnGenerateBarcode(max);
/*  358 */     if (maxNum != null) {
/*  359 */       num = maxNum.intValue() + 1;
/*      */     } else {
/*  361 */       num = 1;
/*  362 */     }  return Integer.valueOf(num);
/*      */   }
/*      */   
/*      */   public Integer getSttCheckin(Integer mdid, Integer roomId) {
/*      */     try {
/*  367 */       Integer max = Integer.valueOf(5);
/*  368 */       MedicMasterData s = this.medicMasterDataRepository.findByMedicCode("sttCheckin").orElse(null);
/*  369 */       if (s != null) {
/*  370 */         max = Integer.valueOf(Integer.parseInt(s.getDefaultValue()));
/*      */       }
/*  372 */       Integer num = getMaxSttCheckin(max, roomId);
/*  373 */       String generateStt = ApiHelper.generateBarCode(num, max);
/*  374 */       this.checkinSttRepository.saveAndFlush(MedicCheckinStt.builder()
/*  375 */           .number(num)
/*  376 */           .roomId(roomId)
/*  377 */           .dateTime(generateStt)
/*  378 */           .createdAt(new Date())
/*  379 */           .mdId(mdid)
/*  380 */           .status(CheckinSttStatus.WAITING.getCheckinSttStatus())
/*  381 */           .build());
/*      */       
/*  383 */       return num;
/*  384 */     } catch (Exception ex) {
/*  385 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  386 */       logger.error(exceptionAsString);
/*  387 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private Integer getMaxSttCheckin(Integer max, Integer roomId) {
/*  392 */     int num = 1;
/*  393 */     List<CheckinSttInterface> maxNum = this.checkinSttRepository.getGenerateStt(max, roomId);
/*  394 */     if (maxNum != null && maxNum.size() > 0) {
/*  395 */       num = (maxNum != null && maxNum.get(0) != null) ? (((CheckinSttInterface)maxNum.get(0)).getNumber().intValue() + 1) : 1;
/*      */     }
/*  397 */     return Integer.valueOf(num);
/*      */   }
/*      */ 
/*      */   
/*      */   public CheckinPaymentShortResponse bindCheckinPayment(MedicCheckinRecord m) {
/*  402 */     LocalProvinces provinces = this.provinceRepository.findByCode(m.getMedicCheckin().getCustomers().getCustomerProvince()).orElse(null);
/*  403 */     LocalDistricts localDistricts = this.districtRepository.findByCode(m.getMedicCheckin().getCustomers().getCustomerDistrict()).orElse(null);
/*  404 */     LocalWards localWards = this.wardRepository.findByCode(m.getMedicCheckin().getCustomers().getCustomerWards()).orElse(null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  417 */     CheckinPaymentShortResponse medictRs = CheckinPaymentShortResponse.builder().checkinId(m.getMedicCheckin().getId()).mdId(m.getMdId()).patientId(m.getMedicCheckin().getPatientId()).priority(m.getMedicCheckin().getPriority()).name(m.getMedicCheckin().getCustomers().getName()).status(m.getStatus()).customerType(m.getMedicCheckin().getCustomerType()).createdAt(ApiHelper.dateToString(m.getCreatedAt())).province((provinces != null) ? provinces.getName() : "").district((localDistricts != null) ? localDistricts.getName() : "").ward((localWards != null) ? localWards.getName() : "").build();
/*      */     
/*  419 */     Customers customers = this.customerRepository.findById(m.getMedicCheckin().getPatientId()).orElse(null);
/*  420 */     if (customers != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  428 */       CustomerShortModel customerShortModel = CustomerShortModel.builder().customerId(Integer.valueOf(customers.getId())).name(customers.getName()).phone(customers.getPhone()).idCard(customers.getIdCard()).yearBorn(customers.getYearBorn()).age(ApiHelper.getAge(customers.getYearBorn())).build();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  433 */       CustomerDetailsShortModel customerDetailsShortModel = CustomerDetailsShortModel.builder().address(customers.getAddress()).address2(customers.getAddress2()).build();
/*  434 */       customerShortModel.setCustomerDetailsInfo(customerDetailsShortModel);
/*  435 */       medictRs.setCustomerInfo(customerShortModel);
/*      */     } 
/*      */     
/*  438 */     return medictRs;
/*      */   }
/*      */   
/*      */   public List<CheckinResponse> getCheckinInfo(int page, int size, Integer id, String name, String status, String patientId, String idType, String fromDate, String toDate) {
/*      */     try {
/*  443 */       this
/*      */ 
/*      */         
/*  446 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_checkin").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  457 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_ID", id).addValue("P_NAME", name).addValue("P_STATUS", status).addValue("P_PATIENT_ID", patientId).addValue("P_ID_TYPE", idType).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*      */       
/*  459 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  460 */       return (List<CheckinResponse>)out.get("V_DATASET");
/*  461 */     } catch (Exception ex) {
/*  462 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  463 */       logger.error(exceptionAsString);
/*  464 */       return new ArrayList<>();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCurrency() {
/*  471 */     String defCurr = this.env.getProperty("defaultCurrency");
/*  472 */     List<MedicMasterData> medicMasterData = this.medicMasterDataRepository.findAllByMedicType("defaultCurrency");
/*  473 */     if (!defCurr.isEmpty()) {
/*  474 */       List<MedicMasterData> medicMasterData1 = (List<MedicMasterData>)medicMasterData.stream().filter(f -> f.getDefaultValue().equalsIgnoreCase("1")).collect(Collectors.toList());
/*  475 */       if (!medicMasterData1.isEmpty()) {
/*  476 */         defCurr = ((MedicMasterData)medicMasterData1.get(0)).getMedicCode();
/*      */       }
/*      */     } 
/*      */     
/*  480 */     return defCurr;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<CheckinResponse> sp_get_phieu_chi_dinh_xn(Integer ticketId) {
/*      */     try {
/*  487 */       this
/*      */ 
/*      */         
/*  490 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_phieu_chi_dinh_xn").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinResponse.class));
/*      */ 
/*      */       
/*  493 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*      */       
/*  495 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  496 */       return (List<CheckinResponse>)out.get("V_DATASET");
/*  497 */     } catch (Exception ex) {
/*  498 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  499 */       logger.error(exceptionAsString);
/*  500 */       return new ArrayList<>();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<MedicCheckinRecordModel> getSearchExamination(int page, int size, Integer userId, Integer roomId, String patientId, String name, String customerType, String fromDate, String toDate) {
/*      */     try {
/*  512 */       this
/*      */ 
/*      */         
/*  515 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_examination").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  526 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_USER_ID", userId).addValue("P_NAME", name).addValue("P_CUSTOMER_TYPE", customerType).addValue("P_ROOM_ID", roomId).addValue("P_PATIENT_ID", patientId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*      */       
/*  528 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  529 */       return (List<MedicCheckinRecordModel>)out.get("V_DATASET");
/*  530 */     } catch (Exception ex) {
/*  531 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  532 */       logger.error(exceptionAsString);
/*  533 */       return new ArrayList<>();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<LisRisModel> getSearchHandle(int page, int size, Integer userId, Integer patientId, String name, String customerType, Integer roomHandleIds, String barcode, String fromDate, String toDate, Integer serviceGroupId) {
/*  552 */     this
/*      */ 
/*      */       
/*  555 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_lis_handle").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LisRisModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  568 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_USER_ID", userId).addValue("P_PATIENT_ID", patientId).addValue("P_NAME", name).addValue("P_BARCODE", barcode).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_HANDLE_ROOM_ID", roomHandleIds).addValue("P_SERVICE_GROUP_ID", serviceGroupId).addValue("P_CUSTOMER_TYPE", customerType);
/*      */     
/*  570 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  571 */     List<LisRisModel> list = (List<LisRisModel>)out.get("V_DATASET");
/*      */     
/*  573 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<LisRisModel> getSearchSample(int page, int size, Integer userId, Integer patientId, String name, String customerType, Integer roomSampleIds, String barcode, String fromDate, String toDate, Integer serviceGroupId) {
/*  591 */     this
/*      */ 
/*      */       
/*  594 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_lis_sample").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LisRisModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  607 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_USER_ID", userId).addValue("P_PATIENT_ID", patientId).addValue("P_NAME", name).addValue("P_BARCODE", barcode).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_SAMPLE_ROOM_ID", roomSampleIds).addValue("P_SERVICE_GROUP_ID", serviceGroupId).addValue("P_CUSTOMER_TYPE", customerType);
/*      */     
/*  609 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  610 */     List<LisRisModel> list = (List<LisRisModel>)out.get("V_DATASET");
/*      */     
/*  612 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<LisRisModel> search(Integer userId, Integer patientId, String searchValue, String customerType, Integer roomSampleIds, Integer roomHandleIds, String barcode, Date fromDate, Date toDate, String fieldSort, String direction, int page, int size) {
/*  631 */     this
/*      */ 
/*      */       
/*  634 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_lis_ris").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LisRisModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  649 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", userId).addValue("P_PATIENT_ID", patientId).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_CUSTOMER_TYPE", DataUtil.safeToString2(customerType)).addValue("P_SAMPLE_ROOM_ID", roomSampleIds).addValue("P_HANDLE_ROOM_ID", roomHandleIds).addValue("P_BARCODE", DataUtil.safeToString2(barcode)).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_FIELD_SORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*      */     
/*  651 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  652 */     List<LisRisModel> list = (List<LisRisModel>)out.get("V_DATASET");
/*      */     
/*  654 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<LisRisModel> getSearchRis(int page, int size, Integer userId, Integer patientId, String name, String customerType, Integer roomHandleIds, String barcode, String fromDate, String toDate, Integer serviceGroupId) {
/*  672 */     this
/*      */ 
/*      */       
/*  675 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_ris").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LisRisModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  688 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_USER_ID", userId).addValue("P_PATIENT_ID", patientId).addValue("P_NAME", name).addValue("P_BARCODE", barcode).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_HANDLE_ROOM_ID", roomHandleIds).addValue("P_SERVICE_GROUP_ID", serviceGroupId).addValue("P_CUSTOMER_TYPE", customerType);
/*      */     
/*  690 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  691 */     List<LisRisModel> list = (List<LisRisModel>)out.get("V_DATASET");
/*      */     
/*  693 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer generateNumber(String takeNumber) {
/*  699 */     Integer num = getMaxNumTicket(takeNumber);
/*      */     try {
/*  701 */       String id = ApiHelper.generateTakeNumber(num, takeNumber);
/*      */       
/*  703 */       MedicCustomerOrdinal medicCustomerOrdinal = new MedicCustomerOrdinal();
/*  704 */       medicCustomerOrdinal.setCreatedAt(new Date());
/*  705 */       medicCustomerOrdinal.setDateTime(id);
/*  706 */       medicCustomerOrdinal.setNumber(num);
/*      */       
/*  708 */       medicCustomerOrdinal.setDoorCode(takeNumber.equalsIgnoreCase(OrdinalDoor.ST.getOrdinalDoor()) ? OrdinalDoor.ST.getOrdinalDoor() : OrdinalDoor.UT.getOrdinalDoor());
/*  709 */       this.customerOrdinalRepository.saveAndFlush(medicCustomerOrdinal);
/*  710 */     } catch (Exception ex) {
/*  711 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  712 */       logger.error(exceptionAsString);
/*  713 */       return Integer.valueOf(0);
/*      */     } 
/*  715 */     return num;
/*      */   }
/*      */ 
/*      */   
/*      */   public Integer getMaxNumTicket(String takeNumber) {
/*  720 */     Integer num = Integer.valueOf(1);
/*      */     
/*  722 */     List<CustomerOrdinal> maxNum = this.customerOrdinalRepository.getGenerateNumber(takeNumber);
/*      */     
/*  724 */     if (maxNum != null && maxNum.size() > 0 && !maxNum.isEmpty()) {
/*  725 */       num = Integer.valueOf(((CustomerOrdinal)maxNum.get(0)).getNumber().intValue() + 1);
/*      */     }
/*      */     
/*  728 */     return num;
/*      */   }
/*      */   
/*      */   public List<CustomerOrdinalResponse> getCallingNumber() {
/*  732 */     List<CustomerOrdinalResponse> list = new ArrayList<>();
/*  733 */     this
/*      */ 
/*      */       
/*  736 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_callingNumber").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CustomerOrdinalResponse.class));
/*  737 */     MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
/*  738 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  739 */     List<CustomerOrdinalResponse> rs = (List<CustomerOrdinalResponse>)out.get("V_DATASET");
/*  740 */     List<CustomerOrdinalResponse> rs2 = (List<CustomerOrdinalResponse>)out.get("#result-set-2");
/*      */     
/*  742 */     if (rs.isEmpty()) {
/*  743 */       list.add(CustomerOrdinalResponse.builder()
/*  744 */           .callingNumber(Integer.valueOf(0))
/*  745 */           .number(Integer.valueOf(0))
/*  746 */           .doorCode("ST")
/*  747 */           .build());
/*      */     } else {
/*  749 */       list.addAll(rs);
/*      */     } 
/*      */     
/*  752 */     if (rs2.isEmpty()) {
/*  753 */       list.add(CustomerOrdinalResponse.builder()
/*  754 */           .callingNumber(Integer.valueOf(0))
/*  755 */           .number(Integer.valueOf(0))
/*  756 */           .doorCode("UT")
/*  757 */           .build());
/*      */     } else {
/*  759 */       list.addAll(rs2);
/*      */     } 
/*  761 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<OrdinalDoorNumberResponse> sp_get_door_number(String doorId) {
/*  768 */     List<OrdinalDoorNumberResponse> list = new ArrayList<>();
/*  769 */     this
/*      */ 
/*      */       
/*  772 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_door_number").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(OrdinalDoorNumberResponse.class));
/*      */     
/*  774 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_DOOR_ID", doorId);
/*  775 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  776 */     list = (List<OrdinalDoorNumberResponse>)out.get("V_DATASET");
/*  777 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExaminationCallingUserResponse sp_get_room_number(String roomCode) {
/*  784 */     ExaminationCallingUserResponse ex = new ExaminationCallingUserResponse();
/*  785 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  791 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_room_number").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(OrdinalDoorNumberResponse.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(OrdinalDoorNumberResponse.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(OrdinalDoorNumberResponse.class)).returningResultSet("r4", (RowMapper)new BeanPropertyRowMapper(OrdinalDoorNumberResponse.class));
/*      */     
/*  793 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ROOM_CODE", roomCode);
/*  794 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*      */     
/*  796 */     List<OrdinalDoorNumberResponse> docRs = (List<OrdinalDoorNumberResponse>)out.get("r1");
/*  797 */     if (!docRs.isEmpty()) ex.setDoctor(docRs.get(0));
/*      */     
/*  799 */     List<OrdinalDoorNumberResponse> calledRs = (List<OrdinalDoorNumberResponse>)out.get("r2");
/*  800 */     if (!calledRs.isEmpty()) ex.setCalled(calledRs.get(0));
/*      */     
/*  802 */     ex.setWaiting((List)out.get("r3"));
/*      */     
/*  804 */     ex.setLisRis((List)out.get("r4"));
/*  805 */     return ex;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<OrdinalDoorNumberResponse> windowCallingNumber(String[] door) {
/*  810 */     List<OrdinalDoorNumberResponse> lsOn = new ArrayList<>();
/*  811 */     for (String d : door) {
/*  812 */       List<OrdinalDoorNumberResponse> ordinalResponse = sp_get_door_number(d);
/*  813 */       if (!CollectionUtils.isEmpty(ordinalResponse)) {
/*  814 */         lsOn.add(ordinalResponse.get(0));
/*      */       }
/*      */     } 
/*      */     
/*  818 */     return lsOn;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<RisModel> sp_get_ris_order_service(int mdId, int ticketId) {
/*      */     try {
/*  824 */       this
/*      */ 
/*      */         
/*  827 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_ris_order_service").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(RisModel.class));
/*      */ 
/*      */ 
/*      */       
/*  831 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", Integer.valueOf(mdId)).addValue("P_TICKET_ID", Integer.valueOf(ticketId));
/*      */       
/*  833 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  834 */       List<RisModel> list = (List<RisModel>)out.get("V_DATASET");
/*      */       
/*  836 */       return list;
/*  837 */     } catch (Exception e) {
/*  838 */       logger.error(e.getMessage());
/*  839 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<InsuranceCustomerModel> sp_get_information_insurance_customer(int mdId) {
/*      */     try {
/*  846 */       this
/*      */ 
/*      */         
/*  849 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_information_insurance_customer").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(InsuranceCustomerModel.class));
/*      */       
/*  851 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", Integer.valueOf(mdId));
/*  852 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  853 */       List<InsuranceCustomerModel> list = (List<InsuranceCustomerModel>)out.get("V_DATASET");
/*  854 */       return list;
/*  855 */     } catch (Exception e) {
/*  856 */       logger.error(e.getMessage());
/*  857 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Integer customersInsurance(CustomersInsurance request, Integer patientId, Integer created) {
/*  862 */     if (Objects.nonNull(request)) {
/*      */ 
/*      */ 
/*      */       
/*  866 */       String insuranceNumber = (StringUtils.isNotBlank(request.getInsuranceNumber1()) ? request.getInsuranceNumber1() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber2()) ? request.getInsuranceNumber2() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber3()) ? request.getInsuranceNumber3() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber4()) ? request.getInsuranceNumber4() : "");
/*  867 */       String insuranceCskcb = request.getInsuranceCskcb1() + request.getInsuranceCskcb2();
/*      */       
/*  869 */       Integer benefitRate = Integer.valueOf(100);
/*  870 */       if (StringUtils.isNotBlank(request.getInsuranceNumber1()) && StringUtils.isNotBlank(request.getInsuranceNumber2())) {
/*  871 */         benefitRate = this.commonBhytRepo.fnGetMedicInsuranceCards(request.getInsuranceNumber1(), request.getInsuranceNumber2());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  895 */       CustomersInsurance customersInsurance = CustomersInsurance.builder().insuranceId(request.getInsuranceId()).customerId(patientId).insuranceNumber1(request.getInsuranceNumber1()).insuranceNumber2(request.getInsuranceNumber2()).insuranceNumber3(request.getInsuranceNumber3()).insuranceNumber4(request.getInsuranceNumber4()).insuranceNumber(insuranceNumber).insuranceCskcb1(request.getInsuranceCskcb1()).insuranceCskcb2(request.getInsuranceCskcb2()).insuranceCskcb(insuranceCskcb).insuranceFromDate(request.getInsuranceFromDate()).insuranceExpirationDate(request.getInsuranceExpirationDate()).insuranceAddress(request.getInsuranceAddress()).insuranceLine(request.getInsuranceLine()).insuranceLive(request.getInsuranceLive()).creatorId(request.getCreatorId()).updatedId(created).createdAt(request.getCreatedAt()).updatedAt(new Date()).benefitRate(benefitRate).build();
/*  896 */       CustomersInsurance insurance = (CustomersInsurance)this.insuranceRepository.saveAndFlush(customersInsurance);
/*  897 */       return insurance.getInsuranceId();
/*      */     } 
/*  899 */     return null;
/*      */   }
/*      */   
/*      */   public Integer updateCustomersInsurance(CustomersInsurance request, Integer patientId, Integer created) {
/*  903 */     if (Objects.nonNull(request)) {
/*      */       
/*  905 */       CustomersInsurance insuranceSave, insurance = this.insuranceRepository.findByCustomerId(patientId).orElse(null);
/*  906 */       if (Objects.nonNull(insurance)) {
/*  907 */         insuranceSave = getCustomersInsurance(request, created, insurance);
/*      */       } else {
/*  909 */         insuranceSave = getCustomersInsurance(request, created, request);
/*      */       } 
/*  911 */       return insuranceSave.getInsuranceId();
/*      */     } 
/*  913 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CustomersInsurance getCustomersInsurance(CustomersInsurance request, Integer created, CustomersInsurance insurance) {
/*  922 */     String insuranceNumber = (StringUtils.isNotBlank(request.getInsuranceNumber1()) ? request.getInsuranceNumber1() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber2()) ? request.getInsuranceNumber2() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber3()) ? request.getInsuranceNumber3() : "") + (StringUtils.isNotBlank(request.getInsuranceNumber4()) ? request.getInsuranceNumber4() : "");
/*      */     
/*  924 */     String insuranceCskcb = request.getInsuranceCskcb1() + request.getInsuranceCskcb2();
/*      */     
/*  926 */     Integer benefitRate = Integer.valueOf(100);
/*  927 */     if (StringUtils.isNotBlank(request.getInsuranceNumber1()) && StringUtils.isNotBlank(request.getInsuranceNumber2())) {
/*  928 */       benefitRate = this.commonBhytRepo.fnGetMedicInsuranceCards(request.getInsuranceNumber1(), request.getInsuranceNumber2());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  952 */     CustomersInsurance customersInsurance = CustomersInsurance.builder().insuranceId(insurance.getInsuranceId()).customerId(insurance.getCustomerId()).insuranceNumber1(request.getInsuranceNumber1()).insuranceNumber2(request.getInsuranceNumber2()).insuranceNumber3(request.getInsuranceNumber3()).insuranceNumber4(request.getInsuranceNumber4()).insuranceNumber(insuranceNumber).insuranceCskcb1(request.getInsuranceCskcb1()).insuranceCskcb2(request.getInsuranceCskcb2()).insuranceCskcb(insuranceCskcb).insuranceFromDate(request.getInsuranceFromDate()).insuranceExpirationDate(request.getInsuranceExpirationDate()).insuranceAddress(request.getInsuranceAddress()).insuranceLine(request.getInsuranceLine()).insuranceLive(request.getInsuranceLive()).creatorId(insurance.getCreatorId()).updatedId(created).createdAt(insurance.getCreatedAt()).updatedAt(new Date()).benefitRate(benefitRate).build();
/*  953 */     CustomersInsurance insuranceSave = (CustomersInsurance)this.insuranceRepository.saveAndFlush(customersInsurance);
/*  954 */     return insuranceSave;
/*      */   }
/*      */   
/*      */   public Integer fn_tinh_tuoi_benh_nhan_bhyt(int mdId) {
/*      */     try {
/*  959 */       this
/*      */         
/*  961 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withFunctionName("fn_tinh_tuoi_benh_nhan_bhyt");
/*      */       
/*  963 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", Integer.valueOf(mdId));
/*  964 */       return (Integer)this.simpleJdbcCallRefCursor.executeFunction(Integer.class, (SqlParameterSource)mapSqlParameterSource);
/*  965 */     } catch (Exception e) {
/*  966 */       logger.error(e.getMessage());
/*  967 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<DrugIngredientInteractionResponse> sp_get_drug_ingredient_interaction(int page, int size, String codeIngredient, String nameIngredient) {
/*      */     try {
/*  974 */       this
/*      */ 
/*      */         
/*  977 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_drug_ingredient_interaction").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(DrugIngredientInteractionResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  982 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_CODE", codeIngredient).addValue("P_NAME", nameIngredient);
/*  983 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  984 */       List<DrugIngredientInteractionResponse> list = (List<DrugIngredientInteractionResponse>)out.get("V_DATASET");
/*  985 */       return list;
/*  986 */     } catch (Exception e) {
/*  987 */       logger.error(e.getMessage());
/*  988 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<PrescriptionCeilingResponse> sp_get_prescription_ceiling(int page, int size, String codeIngredient, String nameIngredient) {
/*      */     try {
/*  995 */       this
/*      */ 
/*      */         
/*  998 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_prescription_ceiling").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PrescriptionCeilingResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1003 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_CODE", codeIngredient).addValue("P_NAME", nameIngredient);
/* 1004 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1005 */       List<PrescriptionCeilingResponse> list = (List<PrescriptionCeilingResponse>)out.get("V_DATASET");
/* 1006 */       return list;
/* 1007 */     } catch (Exception e) {
/* 1008 */       logger.error(e.getMessage());
/* 1009 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<TreatmentRegimenResponse> sp_get_treatment_regimen(int page, int size, String nameIngredient) {
/*      */     try {
/* 1016 */       this
/*      */ 
/*      */         
/* 1019 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_treatment_regimen").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(TreatmentRegimenResponse.class));
/*      */ 
/*      */ 
/*      */       
/* 1023 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_NAME", nameIngredient);
/* 1024 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1025 */       List<TreatmentRegimenResponse> list = (List<TreatmentRegimenResponse>)out.get("V_DATASET");
/* 1026 */       return list;
/* 1027 */     } catch (Exception e) {
/* 1028 */       logger.error(e.getMessage());
/* 1029 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicChamberResponse> spGetSearchChamber(int page, int size, String searchValue, String fieldSort, String direction) {
/*      */     try {
/* 1036 */       this
/*      */ 
/*      */         
/* 1039 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_chamber").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicChamberResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1045 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue);
/* 1046 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1047 */       List<MedicChamberResponse> list = (List<MedicChamberResponse>)out.get("V_DATASET");
/* 1048 */       return list;
/* 1049 */     } catch (Exception e) {
/* 1050 */       logger.error(e.getMessage());
/* 1051 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicBedResponse> spGetSearchBed(int page, int size, String searchValue, String fieldSort, String direction) {
/*      */     try {
/* 1058 */       this
/*      */ 
/*      */         
/* 1061 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_bed").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicBedResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1067 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue);
/* 1068 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1069 */       List<MedicBedResponse> list = (List<MedicBedResponse>)out.get("V_DATASET");
/* 1070 */       return list;
/* 1071 */     } catch (Exception e) {
/* 1072 */       logger.error(e.getMessage());
/* 1073 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<InsuranceCardsResponse> spGetSearchInsuranceCards(int page, int size, String searchValue, String fieldSort, String direction) {
/*      */     try {
/* 1080 */       this
/*      */ 
/*      */         
/* 1083 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_insurance_cards").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(InsuranceCardsResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1089 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue);
/* 1090 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1091 */       List<InsuranceCardsResponse> list = (List<InsuranceCardsResponse>)out.get("V_DATASET");
/* 1092 */       return list;
/* 1093 */     } catch (Exception e) {
/* 1094 */       logger.error(e.getMessage());
/* 1095 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<DrugIngredientsResponse> spGetSearchDrugIngredients(int page, int size, String searchValue, String fieldSort, String direction) {
/*      */     try {
/* 1102 */       this
/*      */ 
/*      */         
/* 1105 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_drug_ingredients").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(DrugIngredientsResponse.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1111 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue);
/* 1112 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1113 */       List<DrugIngredientsResponse> list = (List<DrugIngredientsResponse>)out.get("V_DATASET");
/* 1114 */       return list;
/* 1115 */     } catch (Exception e) {
/* 1116 */       logger.error(e.getMessage());
/* 1117 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<CustomerDetailObjectModel> searchCustomerDetailObject(int page, int size, String searchValue, String fieldSort, String direction) {
/*      */     try {
/* 1124 */       this
/*      */ 
/*      */         
/* 1127 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_customer_detail_object").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CustomerDetailObjectModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1133 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue);
/* 1134 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1135 */       List<CustomerDetailObjectModel> list = (List<CustomerDetailObjectModel>)out.get("V_DATASET");
/* 1136 */       return list;
/* 1137 */     } catch (Exception e) {
/* 1138 */       logger.error(e.getMessage());
/* 1139 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<ServiceRequest> spGetMedicService() {
/*      */     try {
/* 1146 */       this
/*      */ 
/*      */         
/* 1149 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_service").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ServiceRequest.class));
/* 1150 */       MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
/*      */       
/* 1152 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1153 */       List<ServiceRequest> list = (List<ServiceRequest>)out.get("V_DATASET");
/* 1154 */       return list;
/* 1155 */     } catch (Exception e) {
/* 1156 */       logger.error(e.getMessage());
/* 1157 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicTestDevice> sp_get_search_test_device(int page, int pageSize, String code, String name, String status) {
/*      */     try {
/* 1164 */       this
/*      */ 
/*      */         
/* 1167 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_test_device").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicTestDevice.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1173 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(pageSize)).addValue("P_CODE", code).addValue("P_NAME", name).addValue("P_STATUS", status);
/*      */       
/* 1175 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1176 */       List<MedicTestDevice> list = (List<MedicTestDevice>)out.get("V_DATASET");
/* 1177 */       return list;
/* 1178 */     } catch (Exception e) {
/* 1179 */       logger.error(e.getMessage());
/* 1180 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<TestCodeMappingModel> sp_get_search_test_code_mapping(int page, int pageSize, String code, String device) {
/*      */     try {
/* 1187 */       this
/*      */ 
/*      */         
/* 1190 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_test_code_mapping").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(TestCodeMappingModel.class));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1195 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(pageSize)).addValue("P_TEST_CODE", code).addValue("P_TEST_DEVICE", device);
/*      */ 
/*      */       
/* 1198 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1199 */       List<TestCodeMappingModel> list = (List<TestCodeMappingModel>)out.get("V_DATASET");
/* 1200 */       return list;
/* 1201 */     } catch (Exception e) {
/* 1202 */       logger.error(e.getMessage());
/* 1203 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicCheckinLiveDetail> sp_get_search_checkin_live(int page, int pageSize, Integer mdId, Date fromDate, Date toDate) {
/*      */     try {
/* 1210 */       this
/*      */ 
/*      */         
/* 1213 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_checkin_live").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinLiveDetail.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1219 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(pageSize)).addValue("P_MDID", mdId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*      */       
/* 1221 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1222 */       List<MedicCheckinLiveDetail> list = (List<MedicCheckinLiveDetail>)out.get("V_DATASET");
/* 1223 */       return list;
/* 1224 */     } catch (Exception e) {
/* 1225 */       logger.error(e.getMessage());
/* 1226 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicCheckinTreatmentDetail> sp_get_search_checkin_treatment_detail(int page, int pageSize, Integer mdId, Date fromDate, Date toDate) {
/*      */     try {
/* 1233 */       this
/*      */ 
/*      */         
/* 1236 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_checkin_treatment_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinTreatmentDetail.class));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1242 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(pageSize)).addValue("P_MD_ID", mdId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*      */       
/* 1244 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1245 */       List<MedicCheckinTreatmentDetail> list = (List<MedicCheckinTreatmentDetail>)out.get("V_DATASET");
/* 1246 */       return list;
/* 1247 */     } catch (Exception e) {
/* 1248 */       logger.error(e.getMessage());
/* 1249 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<MedicCheckinTreatmentDetail> sp_get_treatment_detail_by_mdId(int mdId) {
/*      */     try {
/* 1256 */       this
/*      */ 
/*      */         
/* 1259 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_treatment_detail_by_md_id").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinTreatmentDetail.class));
/*      */       
/* 1261 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", Integer.valueOf(mdId));
/*      */       
/* 1263 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1264 */       List<MedicCheckinTreatmentDetail> list = (List<MedicCheckinTreatmentDetail>)out.get("V_DATASET");
/* 1265 */       return list;
/* 1266 */     } catch (Exception e) {
/* 1267 */       logger.error(e.getMessage());
/* 1268 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PaymentDetailModel> sp_get_order_service_by_md_id(Integer md_id) {
/*      */     try {
/* 1276 */       this
/*      */ 
/*      */         
/* 1279 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_order_service_by_md_id").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PaymentDetailModel.class));
/*      */       
/* 1281 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", md_id);
/*      */       
/* 1283 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 1284 */       List<PaymentDetailModel> list = (List<PaymentDetailModel>)out.get("V_DATASET");
/* 1285 */       return list;
/* 1286 */     } catch (Exception e) {
/* 1287 */       logger.error(e.getMessage());
/* 1288 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<TreatmentDetailModel> getTreatmentDetailTicket(Integer treatmentId) {
/* 1294 */     List<MedicCheckinTreatmentDetailTicket> resObj = this.medicCheckinTreatmentDetailTicketRepository.findAllByTreatmentId(treatmentId);
/* 1295 */     List<TreatmentDetailModel> stringBuilder = new ArrayList<>();
/* 1296 */     if (resObj != null && resObj.size() > 0)
/*      */     {
/* 1298 */       for (MedicCheckinTreatmentDetailTicket medicCheckinTreatmentDetailTicket : resObj) {
/*      */         
/* 1300 */         MedicServiceGroups mg = this.serviceGroupRepository.findById(medicCheckinTreatmentDetailTicket.getServiceGroupId()).orElse(null);
/* 1301 */         stringBuilder.add(TreatmentDetailModel.builder()
/* 1302 */             .serviceGroupId(Integer.valueOf(mg.getId()))
/* 1303 */             .serviceGroupName(mg.getName())
/* 1304 */             .build());
/* 1305 */         if (medicCheckinTreatmentDetailTicket.getTicketType().equalsIgnoreCase(TicketType.SERVICE.getTicketType())) {
/* 1306 */           List<MedicOrderServices> orderServices = this.orderServiceRepository.findAllByTicketId(medicCheckinTreatmentDetailTicket.getTicketId()).orElse(null);
/* 1307 */           if (orderServices != null && orderServices.size() > 0)
/*      */           {
/* 1309 */             for (MedicOrderServices mos : orderServices) {
/* 1310 */               String finish; switch (mos.getServiceGroupId().intValue()) {
/*      */                 
/*      */                 case 3:
/*      */                 case 4:
/* 1314 */                   finish = StringUtils.isNotBlank(mos.getRisFinish()) ? ("(" + mos.getRisFinish() + ")") : "";
/* 1315 */                   stringBuilder.add(
/* 1316 */                       TreatmentDetailModel.builder()
/* 1317 */                       .treatmentId(treatmentId)
/* 1318 */                       .serviceGroupId(Integer.valueOf(mg.getId()))
/* 1319 */                       .serviceGroupName(mg.getName())
/* 1320 */                       .ticketId(mos.getTicketId())
/* 1321 */                       .title(" - " + mos.getServiceName() + " " + finish)
/* 1322 */                       .build());
/*      */                   continue;
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1332 */               stringBuilder.add(
/* 1333 */                   TreatmentDetailModel.builder()
/* 1334 */                   .treatmentId(treatmentId)
/* 1335 */                   .serviceGroupId(Integer.valueOf(mg.getId()))
/* 1336 */                   .serviceGroupName(mg.getName())
/* 1337 */                   .ticketId(mos.getTicketId())
/* 1338 */                   .title(" - " + mos.getServiceName())
/* 1339 */                   .build());
/*      */             } 
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1346 */         if (medicCheckinTreatmentDetailTicket.getTicketType().equalsIgnoreCase(TicketType.MEDIC.getTicketType())) {
/* 1347 */           List<ProductTreatmentDetailModel> t = this.commonStoreHouseRepo.getProductTreatmentDetail(medicCheckinTreatmentDetailTicket.getTicketId());
/* 1348 */           if (t != null && t.size() > 0)
/*      */           {
/* 1350 */             for (ProductTreatmentDetailModel p : t) {
/* 1351 */               stringBuilder.add(
/* 1352 */                   TreatmentDetailModel.builder()
/* 1353 */                   .treatmentId(treatmentId)
/* 1354 */                   .serviceGroupId(Integer.valueOf(mg.getId()))
/* 1355 */                   .serviceGroupName(mg.getName())
/* 1356 */                   .ticketId(medicCheckinTreatmentDetailTicket.getTicketId())
/* 1357 */                   .title(" - " + p.getTitle())
/* 1358 */                   .build());
/*      */             }
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1365 */     return stringBuilder;
/*      */   }
/*      */   
/*      */   public String getTreatmentDetailTicket2(Integer treatmentId) {
/* 1369 */     List<MedicCheckinTreatmentDetailTicket> resObj = this.medicCheckinTreatmentDetailTicketRepository.findAllByTreatmentId(treatmentId);
/* 1370 */     StringBuilder stringBuilder = new StringBuilder();
/* 1371 */     if (resObj != null && resObj.size() > 0)
/*      */     {
/* 1373 */       for (MedicCheckinTreatmentDetailTicket medicCheckinTreatmentDetailTicket : resObj) {
/*      */         
/* 1375 */         MedicServiceGroups mg = this.serviceGroupRepository.findById(medicCheckinTreatmentDetailTicket.getServiceGroupId()).orElse(null);
/* 1376 */         stringBuilder.append(mg.getName());
/* 1377 */         stringBuilder.append(System.getProperty("line.separator"));
/* 1378 */         if (medicCheckinTreatmentDetailTicket.getTicketType().equalsIgnoreCase(TicketType.SERVICE.getTicketType())) {
/* 1379 */           List<MedicOrderServices> orderServices = this.orderServiceRepository.findAllByTicketId(medicCheckinTreatmentDetailTicket.getTicketId()).orElse(null);
/* 1380 */           if (orderServices != null && orderServices.size() > 0)
/*      */           {
/* 1382 */             for (MedicOrderServices mos : orderServices) {
/* 1383 */               String finish; switch (mos.getServiceGroupId().intValue()) {
/*      */                 
/*      */                 case 3:
/*      */                 case 4:
/* 1387 */                   finish = StringUtils.isNotBlank(mos.getRisFinish()) ? ("(" + mos.getRisFinish() + ")") : "";
/* 1388 */                   stringBuilder.append(" - " + mos.getServiceName() + " " + finish);
/* 1389 */                   stringBuilder.append(System.getProperty("line.separator"));
/*      */                   continue;
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1399 */               stringBuilder.append(" - " + mos.getServiceName());
/* 1400 */               stringBuilder.append(System.getProperty("line.separator"));
/*      */             } 
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1407 */         if (medicCheckinTreatmentDetailTicket.getTicketType().equalsIgnoreCase(TicketType.MEDIC.getTicketType())) {
/* 1408 */           List<ProductTreatmentDetailModel> t = this.commonStoreHouseRepo.getProductTreatmentDetail(medicCheckinTreatmentDetailTicket.getTicketId());
/* 1409 */           if (t != null && t.size() > 0)
/*      */           {
/* 1411 */             for (ProductTreatmentDetailModel p : t) {
/* 1412 */               stringBuilder.append(" - " + p.getTitle());
/* 1413 */               stringBuilder.append(System.getProperty("line.separator"));
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1420 */     return stringBuilder.toString();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Service\MedicService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */