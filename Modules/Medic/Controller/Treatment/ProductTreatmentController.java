/*     */ package nencer.app.Modules.Medic.Controller.Treatment;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.FundStatus;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.MedicProductStorehouseType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Constant.TicketType;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Model.Product.MedicRequest;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicBedRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicChamberRepository;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Modules.Storehouse.Model.StoreHouseCardModel;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.IncorrectExportInvenException;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ProductTreatmentController extends BaseMedicController {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(ProductTreatmentController.class);
/*     */   
/*     */   @Autowired
/*     */   protected MedicChamberRepository medicChamberRepository;
/*     */   
/*     */   @Autowired
/*     */   protected MedicBedRepository medicBedRepository;
/*     */   
/*     */   @GetMapping({"/medic_treatment/return_inven/{ticketId}"})
/*     */   public ApiResponse getProductInven(@PathVariable Integer ticketId) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  51 */       List<StoreHouseCardModel> list = this.commonTreatmentRepo.spGetTreatmentReturnInven(ticketId);
/*  52 */       data.put("dataRes", list);
/*  53 */       rs.put("status", "OK");
/*  54 */       rs.put("responseCode", "00");
/*  55 */       rs.put("data", data);
/*     */     }
/*  57 */     catch (Exception e) {
/*  58 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  59 */       logger.error(exceptionAsString);
/*  60 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  62 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_treatment/regisCheckinMedic/{mdId}"})
/*     */   public ApiResponse regisCheckinMedic(@PathVariable @Valid Integer mdId, @Valid @RequestBody MedicRequest request) {
/*  72 */     ApiResponse rs = new ApiResponse(); try {
/*     */       MedicTicket medicTicket;
/*     */       MedicProductOrder medicProductOrder;
/*     */       Integer benefitRate;
/*  76 */       logger.info("// Bat dau luu chi dinh dich vu: " + mdId);
/*  77 */       if (mdId == null || request == null) {
/*  78 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  81 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/*  82 */       if (!medicCheckinRecord.isPresent()) {
/*  83 */         return this.apiError.getError("02");
/*     */       }
/*  85 */       Optional<MedicCheckin> checkin = this.checkinRepository.findById(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId());
/*  86 */       if (!checkin.isPresent()) {
/*  87 */         return this.apiError.getError("201", new String[] { ((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId().toString() });
/*     */       }
/*  89 */       MedicCheckin medicCheckin = checkin.get();
/*     */       
/*  91 */       if (medicCheckin.getStatus().equalsIgnoreCase(CheckinStatus.DONE.getCheckinStatus())) {
/*  92 */         return this.apiError.getError("620");
/*     */       }
/*     */ 
/*     */       
/*  96 */       if (request.getProductOrders() == null) {
/*  97 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 100 */       if (request.getProductOrders().size() <= 0) {
/* 101 */         return this.apiError.getError("307");
/*     */       }
/*     */       
/* 104 */       String orderType = (request.getOrderType() != null && request.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.NK_HT.getMedicProductOrderType() : MedicProductOrderType.XK_KL.getMedicProductOrderType();
/*     */       
/* 106 */       String groupOrderType = (request.getOrderType() != null && request.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) ? MedicProductOrderType.NK.getMedicProductOrderType() : MedicProductOrderType.XK.getMedicProductOrderType();
/*     */ 
/*     */ 
/*     */       
/* 110 */       if (orderType.equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType())) {
/* 111 */         List<StoreHouseCardModel> list = this.commonTreatmentRepo.spGetTreatmentReturnInven(request.getTicketId());
/* 112 */         if (list.size() == 0) {
/* 113 */           return this.apiError.getError("214", new String[] { String.valueOf(request.getTicketId()) });
/*     */         }
/* 115 */         String productOverReturn = checkOverReturn(request, list);
/* 116 */         if (StringUtils.isNotBlank(productOverReturn)) {
/* 117 */           return this.apiError.getError("215", new String[] { productOverReturn });
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 122 */       logger.info("// Tao phieu: " + mdId);
/* 123 */       String code = UUID.randomUUID().toString();
/* 124 */       String barcode = this.medicService.getBarcode(mdId, new Date());
/* 125 */       MedicCheckinRecord mc = medicCheckinRecord.get();
/*     */ 
/*     */ 
/*     */       
/* 129 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(request.getStorehouseId()).orElse(null);
/* 130 */       if (medicProductStorehouse == null) {
/* 131 */         return this.apiError.getError("202", new String[] { "Kho" });
/*     */       }
/* 133 */       MedicProductStorehouseType typeMail = MedicProductStorehouseType.valueOf(medicProductStorehouse.getShType());
/*     */ 
/*     */       
/* 136 */       switch (typeMail) {
/*     */         case kho_ban_le:
/*     */         case kho_ngoai_tru:
/*     */         case kho_noi_tru:
/*     */         case kho_tong_hop:
/* 141 */           medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/* 142 */               .mdId(mdId)
/* 143 */               .checkinName(mc.getMedicCheckin().getCustomers().getName())
/* 144 */               .checkinPatientId(mc.getMedicCheckin().getPatientId())
/* 145 */               .roomId(mc.getRoomId())
/* 146 */               .code(code)
/* 147 */               .barCode(barcode)
/* 148 */               .ticketType(TicketType.MEDIC.getTicketType())
/* 149 */               .status(ProductOrderStatus.CD.getProductOrderStatus())
/* 150 */               .createdAt(new Date())
/* 151 */               .orderDate((request.getOrderDate() == null) ? new Date() : request.getOrderDate())
/* 152 */               .createdBy(request.getCreatorName())
/* 153 */               .createdId(request.getCreatorId())
/* 154 */               .diagnosticArray(request.getDiagnosticArray())
/* 155 */               .diagnosticSubArray(request.getDiagnosticSubArray())
/* 156 */               .roomId(mc.getRoomId())
/* 157 */               .medicProductArray(request.getMedicProductArray())
/* 158 */               .returnFromTicketId(orderType.equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType()) ? request.getTicketId() : null)
/* 159 */               .serviceGroupCode(Integer.valueOf(6))
/* 160 */               .build());
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
/* 175 */           medicProductOrder = MedicProductOrder.builder().storehouseId(request.getStorehouseId()).roomId(request.getRoomId()).creatorId(request.getCreatorId()).ticketId(medicTicket.getId()).groupOrderType(groupOrderType).customerId(mc.getMedicCheckin().getPatientId()).createdAt(new Date()).orderDate(new Date()).orderType(orderType).orderStatus(ProductOrderStatus.CD.getProductOrderStatus()).departmentId(mc.getDepartmentId()).note(request.getNote()).build();
/* 176 */           medicProductOrder.setMedicProductOrderDetails(request.getProductOrders());
/*     */ 
/*     */           
/* 179 */           benefitRate = getBenefitRateProduct(medicCheckin.getId(), medicCheckin.getCustomerType(), medicProductStorehouse.getShType());
/*     */           
/* 181 */           if (benefitRate.equals(Integer.valueOf(100))) {
/* 182 */             medicProductOrder.setStatus(FundStatus.PAID.getFundStatus());
/*     */           }
/*     */           
/* 185 */           for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 186 */             medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/* 187 */             medicProductOrderDetail.setBenefitRate(benefitRate);
/* 188 */             medicProductOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/*     */           } 
/*     */           
/* 191 */           this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */           
/* 193 */           this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */           break;
/*     */         
/*     */         case kho_tu_truc:
/* 197 */           medicTicket = (MedicTicket)this.ticketRepository.saveAndFlush(MedicTicket.builder()
/* 198 */               .mdId(mdId)
/* 199 */               .checkinName(mc.getMedicCheckin().getCustomers().getName())
/* 200 */               .checkinPatientId(mc.getMedicCheckin().getPatientId())
/* 201 */               .roomId(mc.getRoomId())
/* 202 */               .code(code)
/* 203 */               .barCode(barcode)
/* 204 */               .ticketType(TicketType.MEDIC.getTicketType())
/* 205 */               .status(ProductOrderStatus.DXK.getProductOrderStatus())
/* 206 */               .createdAt(new Date())
/* 207 */               .orderDate((request.getOrderDate() == null) ? new Date() : request.getOrderDate())
/* 208 */               .createdBy(request.getCreatorName())
/* 209 */               .createdId(request.getCreatorId())
/* 210 */               .diagnosticArray(request.getDiagnosticArray())
/* 211 */               .diagnosticSubArray(request.getDiagnosticSubArray())
/* 212 */               .roomId(mc.getRoomId())
/* 213 */               .medicProductArray(request.getMedicProductArray())
/* 214 */               .returnFromTicketId(orderType.equalsIgnoreCase(MedicProductOrderType.NK_HT.getMedicProductOrderType()) ? request.getTicketId() : null)
/* 215 */               .serviceGroupCode(Integer.valueOf(6))
/* 216 */               .build());
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
/* 231 */           medicProductOrder = MedicProductOrder.builder().storehouseId(request.getStorehouseId()).roomId(request.getRoomId()).creatorId(request.getCreatorId()).ticketId(medicTicket.getId()).groupOrderType(groupOrderType).customerId(mc.getMedicCheckin().getPatientId()).createdAt(new Date()).orderDate(new Date()).orderType(orderType).note(request.getNote()).orderStatus(ProductOrderStatus.DXK.getProductOrderStatus()).exportDate(new Date()).departmentId(mc.getDepartmentId()).build();
/* 232 */           medicProductOrder.setMedicProductOrderDetails(request.getProductOrders());
/*     */ 
/*     */           
/* 235 */           benefitRate = getBenefitRateProduct(medicCheckin.getId(), medicCheckin.getCustomerType(), medicProductStorehouse.getShType());
/*     */           
/* 237 */           if (benefitRate.equals(Integer.valueOf(100))) {
/* 238 */             medicProductOrder.setStatus(FundStatus.PAID.getFundStatus());
/*     */           }
/*     */           
/* 241 */           for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 242 */             medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/* 243 */             medicProductOrderDetail.setBenefitRate(benefitRate);
/* 244 */             medicProductOrderDetail.setServiceObject(medicCheckin.getCustomerType());
/*     */           } 
/*     */ 
/*     */           
/* 248 */           this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */           
/* 251 */           this.storeHouseService.changeStoreHouseInven2(medicProductOrder, false);
/*     */           break;
/*     */         
/*     */         default:
/* 255 */           return this.apiError.getError("213", new String[] { "Loại kho" });
/*     */       } 
/*     */ 
/*     */       
/* 259 */       logger.info("// Ket thuc Ke don thuoc: " + mdId);
/*     */       
/* 261 */       rs.put("status", "OK");
/* 262 */       rs.put("responseCode", "00");
/* 263 */       rs.put("data", medicTicket.getId());
/* 264 */     } catch (IncorrectExportInvenException e) {
/* 265 */       logger.error(e.getMessage());
/* 266 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 267 */       return this.apiError.getError("999", new String[] { e.getMessage() });
/* 268 */     } catch (Exception e) {
/* 269 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 270 */       logger.error(exceptionAsString);
/* 271 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 272 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 274 */     return rs;
/*     */   }
/*     */   
/*     */   private String checkOverReturn(MedicRequest request, List<StoreHouseCardModel> list) {
/* 278 */     List<StoreHouseCardModel> listReturned = this.commonTreatmentRepo.spGetTreatmentReturned(request.getTicketId());
/* 279 */     for (StoreHouseCardModel storeHouseCardModel : list) {
/* 280 */       for (MedicProductOrderDetail productOrder : request.getProductOrders()) {
/* 281 */         if (productOrder.getProductId().equals(storeHouseCardModel.getProductId())) {
/* 282 */           for (StoreHouseCardModel houseCardModel : listReturned) {
/* 283 */             if (houseCardModel.getProductId().equals(storeHouseCardModel.getProductId()) && 
/* 284 */               storeHouseCardModel.getQty().intValue() < productOrder.getQty().intValue() + houseCardModel.getQty().intValue()) {
/* 285 */               return storeHouseCardModel.getProductName();
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 291 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\ProductTreatmentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */