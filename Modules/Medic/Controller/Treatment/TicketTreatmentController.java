/*     */ package nencer.app.Modules.Medic.Controller.Treatment;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.CheckinType;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.QueryOperator;
/*     */ import nencer.app.Constant.TicketStatus;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.MedicTicketTotal;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.PatientProduct;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.PatientProductTotal;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.ProductTicket;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.TicketProductCategory;
/*     */ import nencer.app.Modules.Medic.Repository.Specification.MedicTicketSpecification;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class TicketTreatmentController extends BaseMedicController {
/*  45 */   public static final Logger logger = LoggerFactory.getLogger(TicketTreatmentController.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicChamberRepository medicChamberRepository;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicBedRepository medicBedRepository;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/product_ticket"})
/*     */   public ApiResponse getProductTicket(@Valid @RequestParam(required = false) String filter, @Valid @RequestParam(required = false) Integer departmentId, @Valid @RequestParam(required = false) Integer storehouseId, @Valid @RequestParam(required = false) Integer chamberId, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  67 */     ApiResponse rs = new ApiResponse();
/*  68 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  70 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  71 */       if (!StringUtils.isEmpty(filter)) {
/*  72 */         ObjectMapper objectMapper = new ObjectMapper();
/*  73 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/*  80 */       SearchCriteria searchCriteria4 = SearchCriteria.builder().field("ticketType").operator(QueryOperator.LIKE).value(TicketType.MEDIC.getTicketType()).build();
/*  81 */       searchFilter.add(searchCriteria4);
/*     */       
/*  83 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  84 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  85 */       TSpecification specifications = new TSpecification(searchFilter);
/*  86 */       Specification specifications2 = specifications.and(MedicTicketSpecification.search(CheckinType.IN_PATIENT.getCheckinType()));
/*  87 */       Specification specifications3 = specifications2.and(MedicTicketSpecification.searchDepartment(departmentId));
/*  88 */       Specification specifications4 = specifications3.and(MedicTicketSpecification.searchStorehouseId(storehouseId));
/*  89 */       Specification specifications5 = specifications4.and(MedicTicketSpecification.searchChamberId(chamberId));
/*     */       
/*  91 */       Page<MedicTicket> pages = this.ticketRepository.findAll(specifications5, (Pageable)pageable);
/*     */       
/*  93 */       data.put("productTicket", pages.get());
/*  94 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  95 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  97 */       rs.put("status", "OK");
/*  98 */       rs.put("responseCode", "00");
/*  99 */       rs.put("data", data);
/* 100 */       return rs;
/* 101 */     } catch (Exception e) {
/* 102 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 103 */       logger.error(exceptionAsString);
/* 104 */       return this.apiError.getError("999", new String[] { exceptionAsString });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/product_ticket2"})
/*     */   public ApiResponse getProductTicket2(@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(required = false) String orderDateTo, @RequestParam(required = false) String orderDateFrom, @RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer departmentId, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) Integer chamberId, @RequestParam(required = false) String ticketCode, @RequestParam(required = false) String orderType, @RequestParam(required = false) String ticketStatus, @RequestParam(required = false) String ticketType, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/* 129 */     ApiResponse rs = new ApiResponse();
/* 130 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 133 */       List<ProductTicket> list = this.commonTicketRepo.spGetProductTicketTreatment(fromDate, toDate, orderDateFrom, orderDateTo, ticketType, ticketStatus, orderType, searchValue, departmentId, storehouseId, chamberId, fieldSort, direction, page, size);
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
/* 149 */       data.put("productTicket", list);
/* 150 */       data.put("totalItems", !list.isEmpty() ? ((ProductTicket)list.get(0)).getTotalRecord() : null);
/*     */       
/* 152 */       rs.put("status", "OK");
/* 153 */       rs.put("responseCode", "00");
/* 154 */       rs.put("data", data);
/* 155 */       return rs;
/* 156 */     } catch (Exception e) {
/* 157 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 158 */       logger.error(exceptionAsString);
/* 159 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/product_ticket/category"})
/*     */   public ApiResponse getInputPatient(@Valid @RequestParam(required = false) String filter) {
/* 169 */     ApiResponse rs = new ApiResponse();
/* 170 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 172 */       List<TicketProductCategory> ticketProductCategorys = new ArrayList<>();
/* 173 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 174 */       if (!StringUtils.isEmpty(filter)) {
/* 175 */         ObjectMapper objectMapper = new ObjectMapper();
/* 176 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>()
/*     */             {
/*     */             
/*     */             });
/*     */       } 
/* 181 */       List<MedicMasterData> ticketTypes = this.medicMasterDataRepository.findByMedicTypeAndMedicCodeLike("ticketType", TicketType.MEDIC.getTicketType());
/*     */       
/* 183 */       for (MedicMasterData ticketType : ticketTypes) {
/* 184 */         List<SearchCriteria> searchFilterFor = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 189 */         SearchCriteria searchCriteria4 = SearchCriteria.builder().field("ticketType").operator(QueryOperator.EQUALS).value(ticketType.getMedicCode()).build();
/* 190 */         searchFilterFor.add(searchCriteria4);
/* 191 */         searchFilterFor.addAll(searchFilter);
/*     */         
/* 193 */         TSpecification specifications = new TSpecification(searchFilterFor);
/* 194 */         Specification specifications2 = specifications.and(MedicTicketSpecification.search(CheckinType.IN_PATIENT.getCheckinType()));
/* 195 */         long countTicket = this.ticketRepository.count(specifications2);
/*     */         
/* 197 */         ticketProductCategorys.add(TicketProductCategory.builder()
/* 198 */             .totalRecord(Integer.valueOf(Math.toIntExact(countTicket)))
/* 199 */             .ticketType(ticketType.getMedicCode())
/* 200 */             .ticketTypeName(ticketType.getMedicName())
/* 201 */             .build());
/*     */       } 
/*     */       
/* 204 */       data.put("category", ticketProductCategorys);
/* 205 */       rs.put("status", "OK");
/* 206 */       rs.put("responseCode", "00");
/* 207 */       rs.put("data", data);
/*     */     
/*     */     }
/* 210 */     catch (Exception e) {
/* 211 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 212 */       logger.error(exceptionAsString);
/* 213 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 215 */     return rs;
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
/*     */   @GetMapping({"/medic_treatment/product_ticket/category2"})
/*     */   public ApiResponse getInputPatient2(@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(required = false) String orderDateTo, @RequestParam(required = false) String orderDateFrom, @RequestParam(required = false) String searchValue, @RequestParam(required = false) Integer departmentId, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) Integer chamberId, @RequestParam(required = false) String ticketCode) {
/* 231 */     ApiResponse rs = new ApiResponse();
/* 232 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 234 */       List<TicketProductCategory> ticketProductCategorys = new ArrayList<>();
/*     */ 
/*     */       
/* 237 */       List<MedicMasterData> ticketTypes = this.medicMasterDataRepository.findByMedicTypeAndMedicCodeLike("ticketType", TicketType.MEDIC.getTicketType());
/*     */       
/* 239 */       for (MedicMasterData ticketType : ticketTypes) {
/* 240 */         List<ProductTicket> list = this.commonTicketRepo.spGetProductTicketTreatment(fromDate, toDate, orderDateFrom, orderDateTo, ticketType
/*     */ 
/*     */ 
/*     */             
/* 244 */             .getMedicCode(), null, null, searchValue, departmentId, storehouseId, chamberId, null, null, 1, 1);
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
/* 255 */         int countTicket = !list.isEmpty() ? ((ProductTicket)list.get(0)).getTotalRecord().intValue() : 0;
/* 256 */         ticketProductCategorys.add(TicketProductCategory.builder()
/* 257 */             .totalRecord(Integer.valueOf(countTicket))
/* 258 */             .ticketType(ticketType.getMedicCode())
/* 259 */             .ticketTypeName(ticketType.getMedicName())
/* 260 */             .build());
/*     */       } 
/*     */       
/* 263 */       data.put("category", ticketProductCategorys);
/* 264 */       rs.put("status", "OK");
/* 265 */       rs.put("responseCode", "00");
/* 266 */       rs.put("data", data);
/*     */     
/*     */     }
/* 269 */     catch (Exception e) {
/* 270 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 271 */       logger.error(exceptionAsString);
/* 272 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 274 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/medic_treatment/product_ticket"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse saveTicketTotal(@Valid @RequestBody MedicTicketTotal medicTicketTotal) {
/* 283 */     ApiResponse rs = new ApiResponse();
/* 284 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 287 */       Set<Integer> department = new HashSet<>();
/* 288 */       Set<Integer> ticketIds = medicTicketTotal.getMedicTickets();
/* 289 */       Set<Integer> orderIds = new HashSet<>();
/* 290 */       List<MedicTicket> medicTickets = this.ticketRepository.findAllByIdInAndStatusNot(ticketIds, TicketStatus.DONE.getTicketStatus());
/* 291 */       for (MedicTicket medicTicket : medicTickets) {
/* 292 */         department.add(medicTicket.getMedicCheckinRecord().getDepartmentId());
/* 293 */         if (department.size() > 1) {
/* 294 */           return this.apiError.getError("504", new String[0]);
/*     */         }
/*     */       } 
/*     */       
/* 298 */       String orderType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.NK_THHT.getMedicProductOrderType() : MedicProductOrderType.XK_THYL.getMedicProductOrderType();
/*     */       
/* 300 */       String groupOrderType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.NK.getMedicProductOrderType() : MedicProductOrderType.XK.getMedicProductOrderType();
/*     */ 
/*     */       
/* 303 */       String ticketType = (medicTicketTotal.getOrderType() != null && medicTicketTotal.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? TicketType.MEDIC_RETURN_TOTAL.getTicketType() : TicketType.MEDIC_GET_TOTAL.getTicketType();
/*     */       
/* 305 */       MedicTicket medicTicketParent = (MedicTicket)this.ticketRepository.save(MedicTicket.builder()
/* 306 */           .createdBy(medicTicketTotal.getUser().getUsername())
/* 307 */           .ticketType(ticketType)
/* 308 */           .createdId(Integer.valueOf(medicTicketTotal.getUser().getId().intValue()))
/* 309 */           .roomId(medicTicketTotal.getRoomId())
/* 310 */           .createdAt(new Date())
/* 311 */           .updatedAt(new Date())
/* 312 */           .orderDateTo(medicTicketTotal.getOrderDateTo())
/* 313 */           .orderDateFrom(medicTicketTotal.getOrderDateFrom())
/* 314 */           .code(UUID.randomUUID().toString())
/* 315 */           .status(OrderStatus.PAID.getOrderStatus())
/* 316 */           .build());
/*     */       
/* 318 */       this.ticketRepository.updateParentTicketId(medicTicketParent.getId(), ticketIds, TicketStatus.DONE.getTicketStatus());
/*     */ 
/*     */       
/* 321 */       MedicProductOrder medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.save(MedicProductOrder.builder()
/* 322 */           .storehouseId(medicTicketTotal.getStorehouseId())
/* 323 */           .roomId(medicTicketTotal.getRoomId())
/* 324 */           .departmentId(department.stream().findFirst().orElse(null))
/* 325 */           .creatorId(Integer.valueOf(medicTicketTotal.getUser().getId().intValue()))
/* 326 */           .ticketId(medicTicketParent.getId())
/* 327 */           .groupOrderType(groupOrderType)
/* 328 */           .createdAt(new Date())
/* 329 */           .orderDate(new Date())
/* 330 */           .orderType(orderType)
/* 331 */           .orderStatus(ProductOrderStatus.CD.getProductOrderStatus())
/* 332 */           .build());
/* 333 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAllByTicketIdIn(ticketIds);
/* 334 */       Set<MedicProductOrderDetail> medicProductOrderDetails = new HashSet<>();
/* 335 */       for (MedicProductOrder productOrder : medicProductOrders) {
/* 336 */         orderIds.add(productOrder.getId());
/* 337 */         medicProductOrderDetails.addAll(productOrder.getMedicProductOrderDetails());
/*     */       } 
/* 339 */       if (medicProductOrderDetails.size() == 0) {
/* 340 */         throw new Exception("Not medic detail");
/*     */       }
/*     */ 
/*     */       
/* 344 */       Set<MedicProductOrderDetail> medicProductOrderDetails2 = new HashSet<>();
/* 345 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/* 346 */         MedicProductOrderDetail m = (MedicProductOrderDetail)ObjectCommonUtils.cloneObject(medicProductOrderDetail);
/* 347 */         m.setOrderId(medicProductOrder.getId());
/*     */ 
/*     */         
/* 350 */         int sum = medicProductOrderDetails.stream().filter(o -> o.getProductId().equals(m.getProductId())).mapToInt(MedicProductOrderDetail::getQty).sum();
/* 351 */         m.setQty(Integer.valueOf(sum));
/* 352 */         m.setApprovalQty(Integer.valueOf(sum));
/* 353 */         if (medicProductOrderDetails2.stream().map(e -> Boolean.valueOf(e.getProductId().equals(m.getProductId()))).noneMatch(Predicate.isEqual(Boolean.valueOf(true)))) {
/* 354 */           m.setId(null);
/* 355 */           medicProductOrderDetails2.add(m);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 360 */       List<MedicProductOrderDetail> medicProductOrderDetailList = this.medicProductOrderDetailRepository.saveAll(medicProductOrderDetails2);
/* 361 */       this.storeHouseService.copyProductExportSynthesis(medicProductOrderDetailList, medicProductOrderDetails);
/* 362 */       this.medicProductOrderRepository.updateStatusByIds(orderIds, ProductOrderStatus.PDTH.getProductOrderStatus());
/*     */       
/* 364 */       logger.info("// Ket thuc Ke don thuoc: " + medicTicketParent.getId());
/*     */ 
/*     */       
/* 367 */       data.put("id", medicTicketParent.getId());
/* 368 */       rs.put("status", "OK");
/* 369 */       rs.put("responseCode", "00");
/* 370 */       rs.put("data", data);
/* 371 */     } catch (Exception e) {
/* 372 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 373 */       logger.error(exceptionAsString);
/* 374 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 375 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 377 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_treatment/product_ticket/synthesis"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse getProductPatient(@Valid @RequestParam String ticketIds) {
/* 386 */     ApiResponse rs = new ApiResponse();
/* 387 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 389 */       Set<String> ticketIdStrSet = new HashSet<>(Arrays.asList(ticketIds.split("[,;]")));
/* 390 */       Set<Integer> ticketIds2 = new HashSet<>();
/* 391 */       if (StringUtils.isNotBlank(ticketIds)) {
/* 392 */         for (String s : ticketIdStrSet) {
/* 393 */           ticketIds2.add(Integer.valueOf(Integer.parseInt(s)));
/*     */         }
/*     */       }
/* 396 */       List<PatientProductTotal> patientProductTotals = this.commonCheckinRepo.spGetProductTotalInven(ticketIds2);
/* 397 */       for (PatientProductTotal patientProductTotal : patientProductTotals) {
/* 398 */         List<PatientProduct> patientProducts = this.commonCheckinRepo.spGetProductInven(ticketIds2, patientProductTotal.getInvenId());
/* 399 */         patientProductTotal.setPatientProducts(patientProducts);
/* 400 */         patientProductTotal.setRequestQty(Integer.valueOf(patientProducts.stream().mapToInt(PatientProduct::getRequestQty).sum()));
/*     */       } 
/* 402 */       data.put("dataRes", patientProductTotals);
/* 403 */       rs.put("status", "OK");
/* 404 */       rs.put("responseCode", "00");
/* 405 */       rs.put("data", data);
/* 406 */     } catch (Exception e) {
/* 407 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 408 */       logger.error(exceptionAsString);
/* 409 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 410 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 412 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\TicketTreatmentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */