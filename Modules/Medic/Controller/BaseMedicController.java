/*     */ package nencer.app.Modules.Medic.Controller;
/*     */ import com.aspose.cells.FontConfigs;
/*     */ import com.aspose.cells.License;
/*     */ import com.aspose.cells.PdfSaveOptions;
/*     */ import com.aspose.cells.SaveOptions;
/*     */ import com.aspose.cells.Workbook;
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import nencer.app.Constant.QueryOperator;
/*     */ import nencer.app.Constant.ServiceObjectType;
/*     */ import nencer.app.Modules.Customer.Repository.CustomerFamilyRepository;
/*     */ import nencer.app.Modules.Customer.Repository.CustomerRepository;
/*     */ import nencer.app.Modules.Customer.Repository.CustomersInsuranceRepository;
/*     */ import nencer.app.Modules.Localization.Repository.ProvinceRepository;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.MasterData.Repository.MedicMasterDataRepository;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Insurance.MedicInsuranceCards;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.CheckinRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.CommonCheckinRepo;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.CommonTicketRepo;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.MedicCheckinRecordRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.MedicCheckinSttRepository;
/*     */ import nencer.app.Modules.Medic.Repository.CustomerOrdinal.CustomerOrdinalRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Examination.ExaminationRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Examination.ExaminationResultHisRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Examination.ExaminationResultRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Insurance.InsuranceCardsRepository;
/*     */ import nencer.app.Modules.Medic.Repository.OrderServiceExtRepository;
/*     */ import nencer.app.Modules.Medic.Repository.OrderServicePtttRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TestCode.RocheDataRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TestCode.TestCodeMappingRepository;
/*     */ import nencer.app.Modules.Storehouse.Controller.BaseStorehoseController;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderDetailRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductStorehouseRepository;
/*     */ import nencer.app.Modules.Storehouse.Service.StoreHouseService;
/*     */ import nencer.app.Modules.Users.Repository.UserRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.stereotype.Controller;
/*     */ 
/*     */ @Controller
/*     */ public class BaseMedicController {
/*  76 */   public static final Logger logger = LoggerFactory.getLogger(BaseMedicController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected CommonCheckinRepo commonCheckinRepo;
/*     */   
/*     */   @Autowired
/*     */   protected CommonBhytRepo commonBhytRepo;
/*     */   
/*     */   @Autowired
/*     */   protected InsuranceCardsRepository insuranceCardsRepository;
/*     */   
/*     */   @Autowired
/*     */   protected CommonTicketRepo commonTicketRepo;
/*     */   
/*     */   @Autowired
/*     */   public CommonTreatmentRepo commonTreatmentRepo;
/*     */   
/*     */   @Autowired
/*     */   public Environment env;
/*     */   
/*     */   @Autowired
/*     */   public ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   public ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   public ObjectMapper objectMapper;
/*     */   
/*     */   @Autowired
/*     */   public CheckinRepository checkinRepository;
/*     */   
/*     */   @Autowired
/*     */   public CheckinHisRepository checkinHisRepository;
/*     */   
/*     */   @Autowired
/*     */   public RoomNumberRepository roomNumberRepository;
/*     */   
/*     */   @Autowired
/*     */   public RoomRepository roomRepository;
/*     */   
/*     */   @Autowired
/*     */   public DepartmentRepository departmentRepository;
/*     */   
/*     */   @Autowired
/*     */   public ProvinceRepository provinceRepository;
/*     */   
/*     */   @Autowired
/*     */   public DistrictRepository districtRepository;
/*     */   
/*     */   @Autowired
/*     */   public WardRepository wardRepository;
/*     */   
/*     */   @Autowired
/*     */   public OrderServiceRepository orderServiceRepository;
/*     */   
/*     */   @Autowired
/*     */   public OrderServiceExtRepository orderServiceExtRepository;
/*     */   
/*     */   @Autowired
/*     */   public ServiceRepository serviceRepository;
/*     */   
/*     */   @Autowired
/*     */   public CustomerRepository customerRepository;
/*     */   
/*     */   @Autowired
/*     */   public UserRepository userRepository;
/*     */   
/*     */   @Autowired
/*     */   protected ServiceTypeRepository serviceTypeRepository;
/*     */   
/*     */   @Autowired
/*     */   protected FundLogRepository fundLogRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductOrderRepository medicProductOrderRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductOrderHisRepository medicProductOrderHisRepository;
/*     */   
/*     */   @Autowired
/*     */   public ExaminationRepository examinationRepository;
/*     */   
/*     */   @Autowired
/*     */   public ExaminationResultRepository examinationResultRepository;
/*     */   
/*     */   @Autowired
/*     */   public ExaminationResultHisRepository examinationResultHisRepository;
/*     */   
/*     */   @Autowired
/*     */   public TicketRepository ticketRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicService medicService;
/*     */   
/*     */   @Autowired
/*     */   protected MedicMasterDataRepository medicMasterDataRepository;
/*     */   
/*     */   @Autowired
/*     */   CustomerFamilyRepository customerFamilyRepository;
/*     */   
/*     */   @Autowired
/*     */   CustomersInsuranceRepository customersInsuranceRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicCheckinRecordRepository medicCheckinRecordRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicCheckinRecordHisRepository medicCheckinRecordHisRepository;
/*     */   
/*     */   @Autowired
/*     */   protected CustomerOrdinalRepository customerOrdinalRepository;
/*     */   
/*     */   @Autowired
/*     */   protected CommonStoreHouseRepo commonStoreHouseRepo;
/*     */   
/*     */   @Autowired
/*     */   protected BaseStorehoseController baseStorehoseController;
/*     */   
/*     */   @Autowired
/*     */   protected MedicCheckinSttRepository medicCheckinSttRepository;
/*     */   
/*     */   @Autowired
/*     */   protected StoreHouseService storeHouseService;
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductOrderDetailRepository medicProductOrderDetailRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */   
/*     */   @Autowired
/*     */   protected TestCodeMappingRepository testCodeMappingRepository;
/*     */   
/*     */   @Autowired
/*     */   protected RocheDataRepository rocheDataRepository;
/*     */   
/*     */   @Autowired
/*     */   protected OrderServicePtttRepository orderServicePtttRepository;
/*     */   
/*     */   @Autowired
/*     */   protected ServiceGroupRepository serviceGroupRepository;
/*     */   
/*     */   @Value("${fontFolder}")
/*     */   public String fontsFolder;
/*     */ 
/*     */   
/*     */   protected ApiResponse getCheckinRecordProcess(int page, int size, String filter, String fieldSort, String direction, String[] status, Integer roomId, String paymentStatus, String checkinType) throws JsonProcessingException {
/* 225 */     ApiResponse rs = new ApiResponse();
/* 226 */     Map<String, Object> data = new HashMap<>();
/*     */     
/* 228 */     List<SearchCriteria> searchFilter = new ArrayList<>();
/* 229 */     if (!StringUtils.isEmpty(filter)) {
/* 230 */       ObjectMapper objectMapper = new ObjectMapper();
/* 231 */       searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 239 */     SearchCriteria searchCriteria1 = SearchCriteria.builder().field("status").operator(QueryOperator.IN).value(Arrays.asList(status)).build();
/* 240 */     searchFilter.add(searchCriteria1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     SearchCriteria searchCriteria2 = SearchCriteria.builder().field("roomId").operator(QueryOperator.EQUALS).value((roomId.intValue() == 0) ? "" : roomId).build();
/* 247 */     searchFilter.add(searchCriteria2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     SearchCriteria searchCriteria3 = SearchCriteria.builder().field("paymentStatus").operator(QueryOperator.EQUALS).value(paymentStatus).build();
/* 254 */     searchFilter.add(searchCriteria3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     SearchCriteria searchCriteria4 = SearchCriteria.builder().field("mdType").operator(QueryOperator.EQUALS).value(checkinType).build();
/* 261 */     searchFilter.add(searchCriteria4);
/*     */     
/* 263 */     PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 264 */         Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 265 */     TSpecification specifications = new TSpecification(searchFilter);
/*     */ 
/*     */     
/* 268 */     Page<MedicCheckinRecord> pages = this.medicCheckinRecordRepository.findAll((Specification)specifications, (Pageable)pageable);
/*     */     
/* 270 */     data.put("checkins", pages.get());
/* 271 */     data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 272 */     data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */     
/* 274 */     rs.put("status", "OK");
/* 275 */     rs.put("responseCode", "00");
/* 276 */     rs.put("data", data);
/*     */     
/* 278 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ApiResponse getCheckinProcess(int page, int size, String filter, String fieldSort, String direction, String[] status, String paymentStatus, String checkinType, Integer departmentId) throws JsonProcessingException {
/* 283 */     ApiResponse rs = new ApiResponse();
/* 284 */     Map<String, Object> data = new HashMap<>();
/*     */     
/* 286 */     List<SearchCriteria> searchFilter = new ArrayList<>();
/* 287 */     if (!StringUtils.isEmpty(filter)) {
/* 288 */       ObjectMapper objectMapper = new ObjectMapper();
/* 289 */       searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 297 */     SearchCriteria searchCriteria1 = SearchCriteria.builder().field("status").operator(QueryOperator.IN).value(Arrays.asList(status)).build();
/* 298 */     searchFilter.add(searchCriteria1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     SearchCriteria searchCriteria3 = SearchCriteria.builder().field("paymentStatus").operator(QueryOperator.EQUALS).value(paymentStatus).build();
/* 305 */     searchFilter.add(searchCriteria3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     SearchCriteria searchCriteria4 = SearchCriteria.builder().field("mdType").operator(QueryOperator.EQUALS).value(checkinType).build();
/* 312 */     searchFilter.add(searchCriteria4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     SearchCriteria searchCriteria5 = SearchCriteria.builder().field("departmentId").operator(QueryOperator.EQUALS).value((departmentId.intValue() == 0) ? "" : departmentId).build();
/* 319 */     searchFilter.add(searchCriteria5);
/*     */     
/* 321 */     PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 322 */         Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 323 */     TSpecification specifications = new TSpecification(searchFilter);
/*     */ 
/*     */     
/* 326 */     Page<MedicCheckinRecord> pages = this.medicCheckinRecordRepository.findAll((Specification)specifications, (Pageable)pageable);
/*     */     
/* 328 */     data.put("checkins", pages.get());
/* 329 */     data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 330 */     data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */     
/* 332 */     rs.put("status", "OK");
/* 333 */     rs.put("responseCode", "00");
/* 334 */     rs.put("data", data);
/*     */     
/* 336 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ApiResponse getCheckinProcess(int page, int size, String filter, String fieldSort, String direction, String[] status, String paymentStatus, String checkinType) throws JsonProcessingException {
/* 341 */     ApiResponse rs = new ApiResponse();
/* 342 */     Map<String, Object> data = new HashMap<>();
/*     */     
/* 344 */     List<SearchCriteria> searchFilter = new ArrayList<>();
/* 345 */     if (!StringUtils.isEmpty(filter)) {
/* 346 */       ObjectMapper objectMapper = new ObjectMapper();
/* 347 */       searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 355 */     SearchCriteria searchCriteria1 = SearchCriteria.builder().field("status").operator(QueryOperator.IN).value(Arrays.asList(status)).build();
/* 356 */     searchFilter.add(searchCriteria1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     SearchCriteria searchCriteria3 = SearchCriteria.builder().field("paymentStatus").operator(QueryOperator.EQUALS).value(paymentStatus).build();
/* 363 */     searchFilter.add(searchCriteria3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 373 */         Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 374 */     TSpecification specifications = new TSpecification(searchFilter);
/*     */ 
/*     */     
/* 377 */     Page<MedicCheckin> pages = this.checkinRepository.findAll((Specification)specifications, (Pageable)pageable);
/* 378 */     List<MedicCheckin> list = new ArrayList<>();
/* 379 */     pages.get().forEach(e -> {
/*     */           List<MedicOrderServices> medicOrderServices = this.orderServiceRepository.findAllByCheckinId(e.getId());
/*     */           
/*     */           e.setMedicOrderServices(medicOrderServices);
/*     */           list.add(e);
/*     */         });
/* 385 */     data.put("checkins", list);
/* 386 */     data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 387 */     data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */     
/* 389 */     rs.put("status", "OK");
/* 390 */     rs.put("responseCode", "00");
/* 391 */     rs.put("data", data);
/*     */     
/* 393 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getBenefitRateProduct(Integer checkinId, String customerType, String shType) {
/*     */     int benefitRate;
/* 399 */     if (customerType.equalsIgnoreCase(ServiceObjectType.bhyt.getServiceObjectType())) {
/*     */       
/* 401 */       MedicMasterData storehouseBhyt = this.medicMasterDataRepository.findByMedicTypeAndMedicCode("shTypeBhyt", shType).orElse(null);
/* 402 */       if (storehouseBhyt != null) {
/* 403 */         MedicInsuranceCards medicInsuranceCards = this.commonBhytRepo.spGetMedicInsuranceCards(checkinId);
/* 404 */         benefitRate = (medicInsuranceCards == null) ? 100 : medicInsuranceCards.getBenefitRate().intValue();
/*     */       } else {
/* 406 */         benefitRate = 0;
/*     */       } 
/* 408 */     } else if (customerType.equalsIgnoreCase(ServiceObjectType.free.getServiceObjectType())) {
/* 409 */       benefitRate = 100;
/*     */     } else {
/* 411 */       benefitRate = 0;
/*     */     } 
/* 413 */     return Integer.valueOf(benefitRate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Integer getBenefitRateProduct(Integer orderId, String serviceObject) {
/*     */     int benefitRate;
/* 422 */     MedicProductOrder medicProductOrder = this.medicProductOrderRepository.findById(orderId).orElse(null);
/* 423 */     if (medicProductOrder == null)
/* 424 */       return Integer.valueOf(0); 
/* 425 */     MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(medicProductOrder.getStorehouseId()).orElse(null);
/* 426 */     if (medicProductStorehouse == null)
/* 427 */       return Integer.valueOf(0); 
/* 428 */     String shType = medicProductStorehouse.getShType();
/* 429 */     Optional<MedicTicket> medicTicket = this.ticketRepository.findById(medicProductOrder.getTicketId());
/* 430 */     if (!medicTicket.isPresent()) {
/* 431 */       return Integer.valueOf(0);
/*     */     }
/* 433 */     Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(((MedicTicket)medicTicket.get()).getMdId());
/* 434 */     if (!medicCheckinRecord.isPresent()) {
/* 435 */       return Integer.valueOf(0);
/*     */     }
/* 437 */     Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/* 438 */     if (!checkin.isPresent()) {
/* 439 */       return Integer.valueOf(0);
/*     */     }
/* 441 */     Integer checkinId = ((MedicCheckin)checkin.get()).getId();
/*     */ 
/*     */     
/* 444 */     if (serviceObject.equalsIgnoreCase(ServiceObjectType.bhyt.getServiceObjectType())) {
/*     */       
/* 446 */       MedicMasterData storehouseBhyt = this.medicMasterDataRepository.findByMedicTypeAndMedicCode("shTypeBhyt", shType).orElse(null);
/* 447 */       if (storehouseBhyt != null) {
/* 448 */         MedicInsuranceCards medicInsuranceCards = this.commonBhytRepo.spGetMedicInsuranceCards(checkinId);
/* 449 */         benefitRate = (medicInsuranceCards == null) ? 100 : medicInsuranceCards.getBenefitRate().intValue();
/*     */       } else {
/* 451 */         benefitRate = 0;
/*     */       } 
/* 453 */     } else if (serviceObject.equalsIgnoreCase(ServiceObjectType.free.getServiceObjectType())) {
/* 454 */       benefitRate = 100;
/*     */     } else {
/* 456 */       benefitRate = 0;
/*     */     } 
/* 458 */     return Integer.valueOf(benefitRate);
/*     */   }
/*     */   
/*     */   public void convertExcelToPdf(String inputFilePath, String outputFilePath) {
/*     */     try {
/* 463 */       boolean auth = authrolizeLicense();
/* 464 */       if (!auth) {
/* 465 */         logger.error("Ops!!!! Aspose");
/*     */         
/*     */         return;
/*     */       } 
/* 469 */       InputStream inputStream = new FileInputStream(inputFilePath);
/* 470 */       Workbook workbook = new Workbook(inputStream);
/*     */ 
/*     */ 
/*     */       
/* 474 */       FileOutputStream outputStream = new FileOutputStream(outputFilePath);
/*     */ 
/*     */       
/* 477 */       PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
/*     */       
/* 479 */       FontConfigs.setFontFolder(this.fontsFolder, true);
/* 480 */       FontConfigs.setFontSubstitutes("Arial", new String[] { "Phetsarath OT" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 486 */       pdfSaveOptions.setCalculateFormula(true);
/* 487 */       pdfSaveOptions.setOnePagePerSheet(true);
/*     */ 
/*     */       
/* 490 */       workbook.save(outputFilePath, (SaveOptions)pdfSaveOptions);
/*     */ 
/*     */       
/* 493 */       outputStream.close();
/* 494 */       inputStream.close();
/*     */       
/* 496 */       logger.info("Excel converted to PDF successfully!");
/* 497 */     } catch (Exception e) {
/* 498 */       e.printStackTrace();
/* 499 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 500 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean authrolizeLicense() {
/* 505 */     boolean result = false;
/*     */     try {
/* 507 */       InputStream is = License.class.getResourceAsStream("/com.aspose.cells.lic_2999.xml");
/* 508 */       License asposeLicense = new License();
/* 509 */       asposeLicense.setLicense(is);
/* 510 */       is.close();
/* 511 */       result = true;
/* 512 */     } catch (Exception e) {
/* 513 */       e.printStackTrace();
/* 514 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 515 */       logger.error(exceptionAsString);
/*     */     } 
/* 517 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void convertExcelToPdf2(String inputFilePath, String outputFilePath) {
/*     */     try {
/* 523 */       Workbook workbook = new Workbook(inputFilePath);
/*     */ 
/*     */       
/* 526 */       PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
/*     */ 
/*     */       
/* 529 */       pdfSaveOptions.setCalculateFormula(true);
/* 530 */       pdfSaveOptions.setOnePagePerSheet(true);
/*     */ 
/*     */       
/* 533 */       workbook.save(outputFilePath, (SaveOptions)pdfSaveOptions);
/*     */       
/* 535 */       System.out.println("Conversion completed successfully.");
/* 536 */     } catch (Exception e) {
/* 537 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\BaseMedicController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */