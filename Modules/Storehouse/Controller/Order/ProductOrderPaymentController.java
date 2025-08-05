/*     */ package nencer.app.Modules.Storehouse.Controller.Order;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.OrderType;
/*     */ import nencer.app.Modules.Medic.Entity.Fund.FundLogs;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.FundLogsRequest;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderHis;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Modules.Storehouse.Model.ProductOrderCusModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ProductOrderPaymentController extends BaseStorehoseController {
/*  41 */   public static final Logger logger = LoggerFactory.getLogger(ProductOrderPaymentController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   private FundLogRepository fundLogRepository;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   private MedicProductOrderHisRepository medicProductOrderHisRepository;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/product_order_payment/get_order"})
/*     */   public ApiResponse getAllCustomer(@RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  58 */     ApiResponse rs = new ApiResponse();
/*  59 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  62 */       Date fromDateD = DataUtil.safeToDate(fromDate);
/*  63 */       Date toDateD = DataUtil.safeToDate(toDate);
/*  64 */       List<ProductOrderCusModel> productOrderModels = this.commonStoreHouseRepo.getProductOrderCustomerSp(searchValue, storehouseId, fromDateD, toDateD, fieldSort, direction, page, size);
/*     */       
/*  66 */       for (ProductOrderCusModel productOrderCusModel : productOrderModels) {
/*     */         
/*  68 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(productOrderCusModel.getOrderId()));
/*  69 */         productOrderCusModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */       } 
/*     */       
/*  72 */       data.put("dataRes", productOrderModels);
/*  73 */       data.put("totalItems", Integer.valueOf((productOrderModels.size() > 0) ? ((ProductOrderCusModel)productOrderModels.get(0)).getTotalRecord().intValue() : 0));
/*  74 */       rs.put("status", "OK");
/*  75 */       rs.put("responseCode", "00");
/*  76 */       rs.put("data", data);
/*     */     }
/*  78 */     catch (Exception e) {
/*  79 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  80 */       logger.error(exceptionAsString);
/*  81 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  83 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/product_order_payment/{orderId}"})
/*     */   public ApiResponse getOrderDetail(@PathVariable @Valid Integer orderId) {
/*  91 */     ApiResponse rs = new ApiResponse();
/*  92 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  95 */       Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(orderId));
/*     */       
/*  97 */       data.put("dataRes", medicProductOrderDetailModels);
/*  98 */       data.put("totalItems", Integer.valueOf(medicProductOrderDetailModels.size()));
/*  99 */       rs.put("status", "OK");
/* 100 */       rs.put("responseCode", "00");
/* 101 */       rs.put("data", data);
/*     */     }
/* 103 */     catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/product_order_payment/{orderId}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse payment(@PathVariable @Valid Integer orderId, @Valid @RequestBody FundLogsRequest request) {
/* 117 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 120 */       logger.info("// Bat dau luu phieu thu cho: " + orderId);
/* 121 */       if (orderId == null) {
/* 122 */         return this.apiError.getError("804", new String[] { "orderId" });
/*     */       }
/* 124 */       Optional<MedicProductOrder> medicProductOrderOp = this.medicProductOrderRepository.findById(orderId);
/* 125 */       if (!medicProductOrderOp.isPresent()) {
/* 126 */         return this.apiError.getError("202", new String[] { String.valueOf(orderId) });
/*     */       }
/* 128 */       MedicProductOrder medicProductOrder = medicProductOrderOp.get();
/*     */       
/* 130 */       if (!medicProductOrder.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 131 */         return this.apiError.getError("617", new String[0]);
/*     */       }
/*     */       
/* 134 */       logger.info("// save order service, fundLog: " + orderId);
/* 135 */       if (medicProductOrder.getStatus() != null && medicProductOrder.getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())) {
/* 136 */         return this.apiError.getError("611", new String[0]);
/*     */       }
/*     */ 
/*     */       
/* 140 */       if (request.getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/*     */         
/* 142 */         List<MedicProductOrderDetailModel> medicProductOrderDetailModels = this.commonStoreHouseRepo.getExportProductOrderDetailSp(orderId);
/* 143 */         Double price = Double.valueOf(0.0D);
/* 144 */         for (MedicProductOrderDetailModel medicProductOrderDetailModel : medicProductOrderDetailModels) {
/* 145 */           price = Double.valueOf(price.doubleValue() + medicProductOrderDetailModel.getPriceSelling().doubleValue());
/*     */         }
/*     */         
/* 148 */         if (request.getPayAmount().doubleValue() < price.doubleValue()) {
/* 149 */           return this.apiError.getError("610", new String[] { String.valueOf(price) });
/*     */         }
/*     */       } 
/*     */       
/* 153 */       logger.info("// Luu thong tin phieu thu: " + orderId);
/* 154 */       FundLogs fundLogs = (FundLogs)this.fundLogRepository.save(FundLogs.builder()
/* 155 */           .orderId(orderId)
/* 156 */           .customerId(medicProductOrder.getCustomerId())
/* 157 */           .description(request.getDescription())
/* 158 */           .creator(request.getCreatorId())
/* 159 */           .createdAt(new Date())
/* 160 */           .status(OrderStatus.PAID.getOrderStatus())
/* 161 */           .orderType(request.getOrderType())
/* 162 */           .fees(request.getFees())
/* 163 */           .discount(request.getDiscount())
/* 164 */           .payAmount(request.getPayAmount())
/* 165 */           .netAmount(request.getNetAmount())
/* 166 */           .paygate(request.getPaygate())
/* 167 */           .currencyCode(Currency.LAO.name())
/* 168 */           .fundLogChannel(FundLogChannel.RETAIL_CASHIER.toString())
/* 169 */           .build());
/*     */ 
/*     */       
/* 172 */       medicProductOrder.setStatus(OrderStatus.PAID.getOrderStatus());
/* 173 */       medicProductOrder.setFundLogId(fundLogs.getFundLogId());
/* 174 */       this.medicProductOrderRepository.save(medicProductOrder);
/*     */       
/* 176 */       logger.info("// Ket thuc thanh toan: " + orderId);
/*     */       
/* 178 */       rs.put("status", "OK");
/* 179 */       rs.put("responseCode", "00");
/* 180 */       rs.put("data", fundLogs);
/*     */     }
/* 182 */     catch (Exception e) {
/* 183 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 184 */       logger.error(exceptionAsString);
/* 185 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 186 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 188 */     return rs;
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
/*     */   @GetMapping({"/product_order_payment"})
/*     */   public ApiResponse getPayment(@RequestParam(required = false) Integer orderId, @RequestParam(defaultValue = "createdAt") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 201 */     ApiResponse rs = new ApiResponse();
/* 202 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 204 */       if (orderId == null) {
/* 205 */         return this.apiError.getError("804", new String[] { "mdId" });
/*     */       }
/*     */       
/* 208 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 209 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*     */       
/* 211 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       SearchCriteria searchCriteria1 = SearchCriteria.builder().field("orderId").operator(QueryOperator.EQUALS).value(orderId).build();
/* 217 */       searchFilter.add(searchCriteria1);
/* 218 */       TSpecification specifications = new TSpecification(searchFilter);
/* 219 */       Page<FundLogs> pages = this.fundLogRepository.findAll((Specification)specifications, (Pageable)pageable);
/* 220 */       pages.get().forEach(e -> {
/*     */             List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashLeSp(e.getFundLogId());
/*     */             
/*     */             if (medicProductOrderModels.size() == 0 && e.getStatus().equalsIgnoreCase(OrderStatus.CANCEL.getOrderStatus())) {
/*     */               List<MedicProductOrderHis> medicProductOrderHis = this.medicProductOrderHisRepository.findAllByFundLogId(e.getFundLogId().intValue());
/*     */               
/*     */               medicProductOrderModels = (List<MedicProductOrderModel>)this.objectMapper.convertValue(medicProductOrderHis, new TypeReference<List<MedicProductOrderModel>>()
/*     */                   {
/*     */                   
/*     */                   });
/*     */               
/*     */               for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */                 medicProductOrderModel.setId(e.getOrderId().intValue());
/*     */                 
/*     */                 Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*     */                 medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */               } 
/*     */             } 
/*     */             for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */               Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*     */               medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */             } 
/*     */             e.setMedicProductOrders(medicProductOrderModels);
/*     */           });
/* 244 */       data.put("dataRes", pages.get());
/* 245 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 246 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/* 248 */       rs.put("status", "OK");
/* 249 */       rs.put("responseCode", "00");
/* 250 */       rs.put("data", data);
/*     */     }
/* 252 */     catch (Exception e) {
/* 253 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 254 */       logger.error(exceptionAsString);
/* 255 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 257 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PutMapping({"/product_order_payment/status"})
/*     */   public ApiResponse changeStatusInvoices(@RequestBody Map fundLogInput) {
/* 266 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 268 */       Integer fundLogId = Integer.valueOf(DataUtil.safeToInt(fundLogInput.get("fundLogId")));
/* 269 */       String status = DataUtil.safeToString(fundLogInput.get("status"));
/* 270 */       String note = DataUtil.safeToString(fundLogInput.get("note"));
/* 271 */       if (fundLogId.equals(Integer.valueOf(0))) {
/* 272 */         return this.apiError.getError("804", new String[] { "fundLogId" });
/*     */       }
/* 274 */       if (StringUtils.isBlank(status)) {
/* 275 */         return this.apiError.getError("804", new String[] { "status" });
/*     */       }
/* 277 */       FundLogs fundLogs = this.fundLogRepository.findById(fundLogId).orElse(null);
/*     */       
/* 279 */       if (fundLogs == null) {
/* 280 */         return this.apiError.getError("202", new String[] { "fundLogs" });
/*     */       }
/*     */       
/* 283 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAllByFundLogId(fundLogId);
/* 284 */       if (medicProductOrders.size() <= 0 && fundLogs.getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/* 285 */         return this.apiError.getError("202", new String[] { "Medic Order Services" });
/*     */       }
/*     */ 
/*     */       
/* 289 */       fundLogs.setStatus(status);
/* 290 */       fundLogs.setNote(note);
/* 291 */       this.fundLogRepository.saveAndFlush(fundLogs);
/*     */       
/* 293 */       if (fundLogs.getOrderType().equalsIgnoreCase(OrderType.TT.getOrderType())) {
/*     */         
/* 295 */         List<MedicProductOrder> productOrders = new ArrayList<>();
/* 296 */         List<MedicProductOrderHis> listPOHis = (List<MedicProductOrderHis>)this.objectMapper.convertValue(medicProductOrders, new TypeReference<List<MedicProductOrderHis>>() {  }
/*     */           );
/* 298 */         for (MedicProductOrderHis listHi : listPOHis) {
/* 299 */           listHi.setOrderId(listHi.getId());
/* 300 */           listHi.setId(null);
/*     */         } 
/* 302 */         this.medicProductOrderHisRepository.saveAll(listPOHis);
/*     */ 
/*     */         
/* 305 */         for (MedicProductOrder mos : medicProductOrders) {
/* 306 */           mos.setStatus(OrderStatus.UNPAID.getOrderStatus());
/* 307 */           productOrders.add(mos);
/*     */         } 
/* 309 */         this.medicProductOrderRepository.saveAll(productOrders);
/*     */       } 
/*     */ 
/*     */       
/* 313 */       rs.put("status", "OK");
/* 314 */       rs.put("responseCode", "00");
/*     */     }
/* 316 */     catch (Exception e) {
/* 317 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 318 */       logger.error(exceptionAsString);
/* 319 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 320 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 322 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Order\ProductOrderPaymentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */