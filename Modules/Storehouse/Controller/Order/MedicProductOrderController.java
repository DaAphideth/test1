/*     */ package nencer.app.Modules.Storehouse.Controller.Order;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.MedicProductStorehouseType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Modules.Customer.Entity.Customers;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.MedicTicketTotal;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.ProductTicket;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderCategory;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import nencer.app.Utils.IncorrectExportInvenException;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
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
/*     */ public class MedicProductOrderController extends BaseStorehoseController {
/*  48 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductOrderController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   MedicProductOrderRepository medicProductOrderRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductOrderDetailRepository medicProductOrderDetailRepository;
/*     */   
/*     */   @Autowired
/*     */   TicketRepository ticketRepository;
/*     */   
/*     */   @Autowired
/*     */   CustomerRepository customerRepository;
/*     */   
/*     */   @Autowired
/*     */   CommonStoreHouseRepo commonStoreHouseRepo;
/*     */   
/*     */   @Autowired
/*     */   StoreHouseService storeHouseService;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_order/getAll"})
/*     */   public ApiResponse getAll(@RequestParam(required = false) String searchValue, @RequestParam(required = false) String filter) {
/*  74 */     ApiResponse rs = new ApiResponse();
/*  75 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  77 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  78 */       if (!StringUtils.isEmpty(filter)) {
/*  79 */         ObjectMapper objectMapper = new ObjectMapper();
/*  80 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  84 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  86 */       Specification specifications2 = specifications.and(MedicProductOrderSpecification.search(searchValue));
/*     */       
/*  88 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAll(specifications2);
/*  89 */       data.put("medicProduct", medicProductOrders);
/*     */       
/*  91 */       rs.put("status", "OK");
/*  92 */       rs.put("responseCode", "00");
/*  93 */       rs.put("data", data);
/*     */     }
/*  95 */     catch (Exception e) {
/*  96 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  97 */       logger.error(exceptionAsString);
/*  98 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 100 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_order/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 105 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 108 */       if (id == null) {
/* 109 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 112 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 113 */       if (!g.isPresent()) {
/* 114 */         return this.apiError.getError("02");
/*     */       }
/* 116 */       rs.put("status", "OK");
/* 117 */       rs.put("responseCode", "00");
/* 118 */       rs.put("data", g.get());
/*     */     }
/* 120 */     catch (Exception e) {
/* 121 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 122 */       logger.error(exceptionAsString);
/* 123 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 125 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_product_order"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicProductOrderModel request) {
/*     */     try {
/*     */       ApiResponse rs;
/* 138 */       request.setCreatedAt(new Date());
/* 139 */       if (StringUtils.isNotBlank(request.getCustomerCode()) || StringUtils.isNotBlank(request.getCustomerName())) {
/* 140 */         Customers customers = (Customers)this.customerRepository.save(Customers.builder()
/* 141 */             .birthday(request.getCustomerBirthday())
/* 142 */             .idCard(request.getCustomerCode())
/* 143 */             .gender(request.getCustomerGender())
/* 144 */             .phone(request.getCustomerPhone())
/* 145 */             .name(request.getCustomerName())
/* 146 */             .address(request.getCustomerWards() + "-" + request.getCustomerDistrict() + "-" + request.getCustomerProvince())
/* 147 */             .customerProvince(request.getCustomerProvince())
/* 148 */             .customerDistrict(request.getCustomerDistrict())
/* 149 */             .customerWards(request.getCustomerWards())
/* 150 */             .build());
/* 151 */         request.setCustomerId(Integer.valueOf(customers.getId()));
/*     */       } 
/*     */       
/* 154 */       MedicProductOrder medicProductOrder = (MedicProductOrder)this.modelMapper.map(request, MedicProductOrder.class);
/*     */       
/* 156 */       if (StringUtils.isNotBlank(medicProductOrder.getCode()) && medicProductOrder
/* 157 */         .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NCC.getMedicProductOrderType())) {
/* 158 */         Integer flagCode = this.medicProductOrderRepository.checkExistsByCode(medicProductOrder.getCode());
/* 159 */         if (flagCode != null && flagCode.intValue() == 1) {
/* 160 */           return this.apiError.getError("515", new String[] { medicProductOrder.getCode() });
/*     */         }
/*     */       } 
/*     */       
/* 164 */       if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/*     */         
/* 166 */         Integer storehouseFromId = medicProductOrder.getStorehouseId();
/* 167 */         medicProductOrder.setStorehouseId(medicProductOrder.getStorehouseFromId());
/* 168 */         medicProductOrder.setStorehouseFromId(storehouseFromId);
/*     */       } 
/*     */ 
/*     */       
/* 172 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(medicProductOrder.getStorehouseId()).orElse(null);
/* 173 */       if (medicProductStorehouse == null) {
/* 174 */         return this.apiError.getError("202", new String[] { "Kho" });
/*     */       }
/* 176 */       MedicProductStorehouseType typeMail = MedicProductStorehouseType.valueOf(medicProductStorehouse.getShType());
/*     */       
/* 178 */       switch (typeMail) {
/*     */         case XK_XBCSTT:
/* 180 */           if (!medicProductStorehouse.getOrderTypeArray().contains(request.getOrderType())) {
/* 181 */             return this.apiError.getError("213", new String[] { "Loại đơn" });
/*     */           }
/* 183 */           rs = saveProductKhachLe(medicProductOrder);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 218 */           return rs;case NK_NBCSTT: if (!medicProductStorehouse.getOrderTypeArray().contains(request.getOrderType())) return this.apiError.getError("213", new String[] { "Loại đơn" });  rs = saveProductNgoaiTru(medicProductOrder); return rs;case null: rs = saveProductNoiTru(medicProductOrder); return rs;case null: rs = saveProductTongHop(medicProductOrder); return rs;case null: rs = saveProductStatusTT(medicProductOrder); return rs;case null: medicProductOrder.setDepartmentId(medicProductStorehouse.getDepartmentId()); rs = saveProductKhoa(medicProductOrder); return rs;
/*     */       }  return this.apiError.getError("213", new String[] { "Loại kho" });
/*     */     } catch (IncorrectExportInvenException e) {
/*     */       logger.error(e.getMessage()); TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); return this.apiError.getError("999", new String[] { e.getMessage() });
/*     */     } catch (Exception e) {
/*     */       String exceptionAsString = ExceptionUtils.getStackTrace(e); logger.error(exceptionAsString);
/*     */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*     */       return this.apiError.getError("999", new String[] { exceptionAsString });
/* 226 */     }  } @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class}) @PutMapping({"/medic_product_order/{id}"}) public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductOrderModel request) { ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 229 */       if (id == null) {
/* 230 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 233 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 234 */       if (!g.isPresent()) {
/* 235 */         return this.apiError.getError("02");
/*     */       }
/* 237 */       MedicProductOrder medicProductOrder = g.get();
/* 238 */       if (ProductOrderStatus.DDDNKDXK.getProductOrderStatus().contains(medicProductOrder.getOrderStatus())) {
/* 239 */         return this.apiError.getError("207");
/*     */       }
/* 241 */       if (StringUtils.isNotBlank(request.getCustomerCode()) || StringUtils.isNotBlank(request.getCustomerName())) {
/* 242 */         Customers customers = (Customers)this.customerRepository.save(Customers.builder()
/* 243 */             .birthday(request.getCustomerBirthday())
/* 244 */             .idCard(request.getCustomerCode())
/* 245 */             .gender(request.getCustomerGender())
/* 246 */             .phone(request.getCustomerPhone())
/* 247 */             .address(request.getCustomerWards() + "," + request.getCustomerDistrict() + "," + request.getCustomerProvince())
/* 248 */             .customerWards(request.getCustomerWards())
/* 249 */             .customerDistrict(request.getCustomerDistrict())
/* 250 */             .customerProvince(request.getCustomerProvince())
/* 251 */             .name(request.getCustomerName())
/* 252 */             .build());
/* 253 */         request.setCustomerId(Integer.valueOf(customers.getId()));
/*     */       } 
/*     */       
/* 256 */       request.setId(id.intValue());
/* 257 */       request.setTicketId(medicProductOrder.getTicketId());
/* 258 */       if (request.getStorehouseId() == null && request
/* 259 */         .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 260 */         request.setStorehouseId(request.getStorehouseFromId());
/* 261 */         request.setStorehouseFromId(null);
/* 262 */         request.setStatus(medicProductOrder.getStatus());
/*     */       } 
/*     */       
/* 265 */       MedicProductOrder medicProductOrderU = (MedicProductOrder)this.modelMapper.map(request, MedicProductOrder.class);
/* 266 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderU.getMedicProductOrderDetails()) {
/* 267 */         medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */       }
/*     */ 
/*     */       
/* 271 */       if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 272 */         this.storeHouseService.recoveryStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder));
/* 273 */         this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrderU));
/*     */       } 
/*     */       
/* 276 */       MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrderU);
/* 277 */       if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 278 */         this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/* 279 */         for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 280 */           String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 281 */           String[] exFeParts = expirationDateFe.split("/");
/* 282 */           Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 283 */           medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 288 */       rs.put("status", "OK");
/* 289 */       rs.put("responseCode", "00");
/*     */     }
/* 291 */     catch (Exception e) {
/* 292 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 293 */       logger.error(exceptionAsString);
/* 294 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 295 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 297 */     return rs; }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PatchMapping({"/medic_product_order/approve/{id}"})
/*     */   public ApiResponse approve(@PathVariable @Valid Integer id, @Valid @RequestBody MedicProductOrderModel request) {
/* 304 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 307 */       if (id == null) {
/* 308 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 311 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 312 */       if (!g.isPresent()) {
/* 313 */         return this.apiError.getError("02");
/*     */       }
/* 315 */       MedicProductOrder medicProductOrder = g.get();
/* 316 */       if (ProductOrderStatus.DDDNKDXK.getProductOrderStatus().contains(medicProductOrder.getOrderStatus())) {
/* 317 */         return this.apiError.getError("207");
/*     */       }
/*     */       
/* 320 */       request.setId(id.intValue());
/* 321 */       request.setTicketId(medicProductOrder.getTicketId());
/* 322 */       if (request.getStorehouseId() == null && request
/* 323 */         .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 324 */         request.setStorehouseId(request.getStorehouseFromId());
/* 325 */         request.setStorehouseFromId(null);
/* 326 */         request.setStatus(medicProductOrder.getStatus());
/*     */       } 
/*     */       
/* 329 */       MedicProductOrder medicProductOrderU = (MedicProductOrder)this.modelMapper.map(request, MedicProductOrder.class);
/* 330 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderU.getMedicProductOrderDetails()) {
/* 331 */         medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */       }
/*     */ 
/*     */       
/* 335 */       if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 336 */         this.storeHouseService.recoveryStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder));
/* 337 */         this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrderU));
/*     */       } 
/*     */       
/* 340 */       medicProductOrderU.setOrderStatus(ProductOrderStatus.DD.getProductOrderStatus());
/* 341 */       this.medicProductOrderRepository.saveAndFlush(medicProductOrderU);
/*     */       
/* 343 */       rs.put("status", "OK");
/* 344 */       rs.put("responseCode", "00");
/*     */     }
/* 346 */     catch (Exception e) {
/* 347 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 348 */       logger.error(exceptionAsString);
/* 349 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 350 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 352 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_product_order/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 357 */     ApiResponse rs = new ApiResponse();
/* 358 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 361 */       if (id == null) {
/* 362 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 365 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 366 */       if (!g.isPresent()) {
/* 367 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 370 */       this.medicProductOrderRepository.delete(g.get());
/* 371 */       rs.put("status", "OK");
/* 372 */       rs.put("responseCode", "00");
/* 373 */       rs.put("data", data);
/*     */     }
/* 375 */     catch (Exception e) {
/* 376 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 377 */       logger.error(exceptionAsString);
/* 378 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 380 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_order/category"})
/*     */   public ApiResponse getCategory(@RequestParam(required = false) String filter, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate) {
/* 388 */     ApiResponse rs = new ApiResponse();
/* 389 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 391 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 392 */       if (!StringUtils.isEmpty(filter)) {
/* 393 */         ObjectMapper objectMapper = new ObjectMapper();
/* 394 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } 
/*     */       
/* 400 */       SearchCriteria searchCriteria = searchFilter.stream().filter(e -> e.getField().equals("orderType")).findFirst().orElse(null);
/* 401 */       String orderType = (searchCriteria == null) ? null : (String)searchCriteria.getValue();
/*     */       
/* 403 */       Date fromDateD = DataUtil.safeToDate(fromDate);
/* 404 */       Date toDateD = DataUtil.safeToDate(toDate);
/*     */ 
/*     */ 
/*     */       
/* 408 */       List<MedicProductOrderCategory> medicProductOrderCategories = this.commonStoreHouseRepo.getProductOrderCategorySp(orderType, fromDateD, toDateD);
/*     */       
/* 410 */       for (MedicProductOrderCategory medicProductOrderCategory : medicProductOrderCategories) {
/* 411 */         medicProductOrderCategory.setSubMedicProductOrderCategory(new ArrayList());
/*     */       }
/* 413 */       data.put("medicProductOrderCategories", getTreeValues(medicProductOrderCategories));
/*     */       
/* 415 */       rs.put("status", "OK");
/* 416 */       rs.put("responseCode", "00");
/* 417 */       rs.put("data", data);
/*     */     }
/* 419 */     catch (Exception e) {
/* 420 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 421 */       logger.error(exceptionAsString);
/* 422 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 424 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<MedicProductOrderCategory> getTreeValues(List<MedicProductOrderCategory> mngCategories) {
/* 429 */     List<String> collect = (List<String>)mngCategories.stream().map(MedicProductOrderCategory::getGroupOrderType).collect(Collectors.toList());
/*     */     
/* 431 */     List<MedicProductOrderCategory> roots = new ArrayList<>();
/* 432 */     for (MedicProductOrderCategory parent : mngCategories) {
/* 433 */       if (null == parent.getGroupOrderType() || !collect.contains(parent.getGroupOrderType())) {
/* 434 */         roots.add(parent);
/*     */       }
/* 436 */       for (MedicProductOrderCategory child : mngCategories) {
/* 437 */         if (StringUtils.isNotBlank(parent.getOrderType()) && StringUtils.isNotBlank(child.getGroupOrderType()) && parent.getOrderType().equals(child.getGroupOrderType())) {
/* 438 */           parent.getSubMedicProductOrderCategory().add(child);
/*     */         }
/*     */       } 
/*     */     } 
/* 442 */     return roots;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_product_order2/status"})
/*     */   public ApiResponse editStatus2(@RequestParam(required = false) Integer id, @RequestParam String status) {
/*     */     try {
/*     */       ApiResponse rs;
/* 452 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 453 */       if (!g.isPresent()) {
/* 454 */         return this.apiError.getError("02");
/*     */       }
/* 456 */       MedicProductOrder medicProductOrder = g.get();
/* 457 */       if (medicProductOrder.getMedicProductOrderDetails() == null || medicProductOrder
/* 458 */         .getMedicProductOrderDetails().size() == 0) {
/* 459 */         return this.apiError.getError("202", new String[] { "medicProductOrder" });
/*     */       }
/*     */       
/* 462 */       MedicProductStorehouseType typeMail = MedicProductStorehouseType.valueOf(medicProductOrder.getMedicProductStorehouse().getShType());
/*     */       
/* 464 */       switch (typeMail) {
/*     */         case XK_XBCSTT:
/* 466 */           rs = changeStatusKhachLe(medicProductOrder, status);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 497 */           return rs;case NK_NBCSTT: rs = changeStatusNgoaiTru(medicProductOrder, status); return rs;case null: rs = changeStatusNoiTru(medicProductOrder, status); return rs;case null: rs = changeStatusTongHop(medicProductOrder, status); return rs;case null: rs = changeStatusTT(medicProductOrder, status); return rs;case null: rs = changeStatusKhoa(medicProductOrder, status); return rs;
/*     */       } 
/*     */       return this.apiError.getError("213", new String[] { "Loại kho" });
/*     */     } catch (IncorrectExportInvenException e) {
/*     */       logger.error(e.getMessage());
/*     */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*     */       return this.apiError.getError("999", new String[] { e.getMessage() });
/*     */     } catch (Exception e) {
/*     */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       logger.error(exceptionAsString);
/*     */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*     */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */   @GetMapping({"/medic_product_order2"})
/*     */   public ApiResponse getPaging2(@RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer userId, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) String shType, @RequestParam(required = false) String orderStatus, @RequestParam(required = false) String orderType, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size) {
/* 513 */     ApiResponse rs = new ApiResponse();
/* 514 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 517 */       Date fromDateD = DataUtil.safeToDate(fromDate);
/* 518 */       Date toDateD = DataUtil.safeToDate(toDate);
/*     */       
/* 520 */       List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderSp(userId, searchValue, shType, storehouseId, orderStatus, orderType, fromDateD, toDateD, fieldSort, direction, page, size);
/*     */ 
/*     */       
/* 523 */       for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */         
/* 525 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/* 526 */         medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */       } 
/*     */       
/* 529 */       data.put("medicProductOrder", medicProductOrderModels);
/* 530 */       data.put("totalItems", Integer.valueOf((medicProductOrderModels.size() > 0) ? ((MedicProductOrderModel)medicProductOrderModels.get(0)).getTotalRecord().intValue() : 0));
/* 531 */       rs.put("status", "OK");
/* 532 */       rs.put("responseCode", "00");
/* 533 */       rs.put("data", data);
/*     */     }
/* 535 */     catch (Exception e) {
/* 536 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 537 */       logger.error(exceptionAsString);
/* 538 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 540 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_order/order_type/{storehouseId}/{lang}"})
/*     */   public ApiResponse getAllOrderType(@PathVariable(required = false) Integer storehouseId, @PathVariable(required = false) String lang) {
/* 547 */     ApiResponse rs = new ApiResponse();
/* 548 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 550 */       List<MedicMasterData> medicMasterData = this.commonStoreHouseRepo.getAllOrderTypeSp(storehouseId, lang);
/* 551 */       data.put("dataRes", medicMasterData);
/* 552 */       rs.put("status", "OK");
/* 553 */       rs.put("responseCode", "00");
/* 554 */       rs.put("data", data);
/*     */     }
/* 556 */     catch (Exception e) {
/* 557 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 558 */       logger.error(exceptionAsString);
/* 559 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 561 */     return rs;
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
/*     */   @GetMapping({"/medic_product_order/product_cabinet_customer"})
/*     */   public ApiResponse getProductTicket2(@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(required = false) String orderDateTo, @RequestParam(required = false) String orderDateFrom, @RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer departmentId, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) String orderType, @RequestParam(required = false) String ticketStatus, @RequestParam(required = false) String orderStatus, @RequestParam(required = false) String ticketType) {
/* 580 */     ApiResponse rs = new ApiResponse();
/* 581 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 584 */       List<ProductTicket> list = this.commonStoreHouseRepo.spGetProductMedicCabinet(fromDate, toDate, orderDateFrom, orderDateTo, ticketType, ticketStatus, orderType, searchValue, departmentId, storehouseId, orderStatus);
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
/* 597 */       data.put("productTicket", list);
/* 598 */       data.put("totalItems", !list.isEmpty() ? ((ProductTicket)list.get(0)).getTotalRecord() : null);
/*     */       
/* 600 */       rs.put("status", "OK");
/* 601 */       rs.put("responseCode", "00");
/* 602 */       rs.put("data", data);
/* 603 */       return rs;
/* 604 */     } catch (Exception e) {
/* 605 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 606 */       logger.error(exceptionAsString);
/* 607 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_product_order/synthetic_cabinet"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse saveTicketTotal(@Valid @RequestBody MedicTicketTotal medicTicketTotal) {
/* 617 */     ApiResponse rs = new ApiResponse();
/* 618 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*     */       MedicProductOrder medicProductOrder2;
/* 622 */       Set<Integer> ticketIds = medicTicketTotal.getMedicTickets();
/* 623 */       Set<Integer> orderIds = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 632 */       String orderType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType() : MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType();
/*     */       
/* 634 */       String groupOrderType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.XK.getMedicProductOrderType() : MedicProductOrderType.NK.getMedicProductOrderType();
/*     */ 
/*     */       
/* 637 */       String ticketType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? TicketType.MEDIC_RETURN_TOTAL.getTicketType() : TicketType.MEDIC_GET_TOTAL.getTicketType();
/*     */       
/* 639 */       MedicTicket medicTicketParent = (MedicTicket)this.ticketRepository.save(MedicTicket.builder()
/* 640 */           .createdBy(medicTicketTotal.getUser().getUsername())
/* 641 */           .ticketType(ticketType)
/* 642 */           .createdId(Integer.valueOf(medicTicketTotal.getUser().getId().intValue()))
/* 643 */           .roomId(medicTicketTotal.getRoomId())
/* 644 */           .createdAt(new Date())
/* 645 */           .updatedAt(new Date())
/* 646 */           .orderDateTo(medicTicketTotal.getOrderDateTo())
/* 647 */           .orderDateFrom(medicTicketTotal.getOrderDateFrom())
/* 648 */           .code(UUID.randomUUID().toString())
/* 649 */           .status(OrderStatus.PAID.getOrderStatus())
/* 650 */           .build());
/*     */       
/* 652 */       this.ticketRepository.updateParentTicketId(medicTicketParent.getId(), ticketIds, TicketStatus.DONE.getTicketStatus());
/*     */ 
/*     */       
/* 655 */       MedicProductOrder medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.save(MedicProductOrder.builder()
/* 656 */           .storehouseId(medicTicketTotal.getStorehouseId())
/* 657 */           .roomId(medicTicketTotal.getRoomId())
/*     */           
/* 659 */           .storehouseFromId(medicTicketTotal.getStorehouseFromId())
/* 660 */           .creatorId(Integer.valueOf(medicTicketTotal.getUser().getId().intValue()))
/* 661 */           .ticketId(medicTicketParent.getId())
/* 662 */           .groupOrderType(groupOrderType)
/* 663 */           .createdAt(new Date())
/* 664 */           .orderDate(new Date())
/* 665 */           .orderType(orderType)
/* 666 */           .orderStatus(ProductOrderStatus.DXK.getProductOrderStatus())
/* 667 */           .exportDate(new Date())
/* 668 */           .build());
/* 669 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAllByTicketIdIn(ticketIds);
/* 670 */       Set<MedicProductOrderDetail> medicProductOrderDetails = new HashSet<>();
/* 671 */       for (MedicProductOrder productOrder : medicProductOrders) {
/* 672 */         orderIds.add(productOrder.getId());
/* 673 */         Optional<Set<MedicProductOrderDetail>> medicProductOrderDetailSetOp = this.medicProductOrderDetailRepository.findAllByOrderId(productOrder.getId());
/* 674 */         if (medicProductOrderDetailSetOp.isPresent()) {
/* 675 */           medicProductOrderDetails.addAll(medicProductOrderDetailSetOp.get());
/*     */         }
/*     */       } 
/* 678 */       if (medicProductOrderDetails.size() == 0) {
/* 679 */         throw new Exception("Not medic detail");
/*     */       }
/*     */ 
/*     */       
/* 683 */       Set<MedicProductOrderDetail> medicProductOrderDetails2 = new HashSet<>();
/* 684 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/* 685 */         MedicProductOrderDetail m = (MedicProductOrderDetail)ObjectCommonUtils.cloneObject(medicProductOrderDetail);
/* 686 */         m.setOrderId(medicProductOrder.getId());
/*     */ 
/*     */         
/* 689 */         int sum = medicProductOrderDetails.stream().filter(o -> o.getProductId().equals(m.getProductId())).mapToInt(MedicProductOrderDetail::getQty).sum();
/* 690 */         m.setQty(Integer.valueOf(sum));
/* 691 */         m.setApprovalQty(Integer.valueOf(sum));
/*     */ 
/*     */         
/* 694 */         if (medicProductOrderDetails2.stream().map(e -> Boolean.valueOf(e.getProductId().equals(m.getProductId()))).noneMatch(Predicate.isEqual(Boolean.valueOf(true)))) {
/* 695 */           m.setId(null);
/* 696 */           m.setInvenId(null);
/* 697 */           medicProductOrderDetails2.add(m);
/*     */         } 
/*     */       } 
/*     */       
/* 701 */       this.medicProductOrderDetailRepository.saveAll(medicProductOrderDetails2);
/* 702 */       medicProductOrder.setMedicProductOrderDetails(medicProductOrderDetails2);
/* 703 */       MedicProductStorehouse khoNoiTru = this.medicProductStorehouseRepository.findById(medicProductOrder.getStorehouseFromId()).orElse(null);
/* 704 */       if (khoNoiTru == null) {
/* 705 */         return this.apiError.getError("202", new String[] { String.valueOf(medicProductOrder.getStorehouseFromId()) });
/*     */       }
/*     */       
/* 708 */       MedicProductOrderType caseType = MedicProductOrderType.valueOf(orderType);
/* 709 */       switch (caseType) {
/*     */         
/*     */         case XK_XBCSTT:
/* 712 */           medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 713 */           medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 714 */           medicProductOrder2.setStorehouseId(khoNoiTru.getId());
/* 715 */           this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, false);
/*     */           
/* 717 */           this.storeHouseService.changeStoreHouseInven2(medicProductOrder, false);
/*     */           break;
/*     */         
/*     */         case NK_NBCSTT:
/* 721 */           medicProductOrder.setOrderStatus(ProductOrderStatus.DD.getProductOrderStatus());
/* 722 */           medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 723 */           medicProductOrder2.setGroupOrderType(MedicProductOrderType.XK.getMedicProductOrderType());
/* 724 */           medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 725 */           this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder2);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 730 */       this.medicProductOrderRepository.updateStatusByIds(orderIds, ProductOrderStatus.PDTH.getProductOrderStatus());
/*     */       
/* 732 */       logger.info("// Ket thuc Ke don thuoc: " + medicTicketParent.getId());
/*     */ 
/*     */       
/* 735 */       data.put("id", medicTicketParent.getId());
/* 736 */       rs.put("status", "OK");
/* 737 */       rs.put("responseCode", "00");
/* 738 */       rs.put("data", data);
/* 739 */     } catch (IncorrectExportInvenException e) {
/* 740 */       String exceptionAsString = e.getMessage();
/* 741 */       logger.error(exceptionAsString);
/* 742 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 743 */       return this.apiError.getError("702", new String[] { exceptionAsString });
/* 744 */     } catch (Exception e) {
/* 745 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 746 */       logger.error(exceptionAsString);
/* 747 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 748 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 750 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductNgoaiTru(MedicProductOrder medicProductOrder) throws Exception {
/* 754 */     Map<String, Object> data = new HashMap<>();
/* 755 */     ApiResponse rs = new ApiResponse();
/* 756 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 757 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 758 */         String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 759 */         String[] exFeParts = expirationDateFe.split("/");
/* 760 */         Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 761 */         medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */       } 
/*     */     }
/* 764 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 765 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 768 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 771 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 772 */       this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(result));
/*     */     }
/* 774 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 775 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/* 777 */     data.put("id", result.getId());
/* 778 */     rs.put("status", "OK");
/* 779 */     rs.put("responseCode", "00");
/* 780 */     rs.put("data", data);
/* 781 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/medic_product_order2/withdrawal"})
/*     */   public ApiResponse withdrawal(@RequestParam(required = false) Integer id, @RequestParam String status) {
/*     */     try {
/*     */       ApiResponse rs;
/* 791 */       Optional<MedicProductOrder> g = this.medicProductOrderRepository.findById(id);
/* 792 */       if (!g.isPresent()) {
/* 793 */         return this.apiError.getError("02");
/*     */       }
/* 795 */       MedicProductOrder medicProductOrder = g.get();
/* 796 */       if (medicProductOrder.getMedicProductOrderDetails() == null || medicProductOrder
/* 797 */         .getMedicProductOrderDetails().size() == 0) {
/* 798 */         return this.apiError.getError("202", new String[] { "medicProductOrder" });
/*     */       }
/* 800 */       if (!medicProductOrder.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 801 */         return this.apiError.getError("703", new String[0]);
/*     */       }
/*     */ 
/*     */       
/* 805 */       MedicProductStorehouseType typeMail = MedicProductStorehouseType.valueOf(medicProductOrder.getMedicProductStorehouse().getShType());
/*     */       
/* 807 */       switch (typeMail) {
/*     */         case XK_XBCSTT:
/* 809 */           rs = changeStatusKhachLe(medicProductOrder, status);
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
/* 825 */           return rs;
/*     */       } 
/*     */       return this.apiError.getError("213", new String[] { "Loại kho" });
/*     */     } catch (IncorrectExportInvenException e) {
/*     */       logger.error(e.getMessage());
/*     */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*     */       return this.apiError.getError("999", new String[] { e.getMessage() });
/*     */     } catch (Exception e) {
/*     */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*     */       logger.error(exceptionAsString);
/*     */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*     */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Order\MedicProductOrderController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */