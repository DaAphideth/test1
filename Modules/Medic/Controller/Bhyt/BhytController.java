/*     */ package nencer.app.Modules.Medic.Controller.Bhyt;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Constant.FundStatus;
/*     */ import nencer.app.Constant.OrderStatus;
/*     */ import nencer.app.Constant.ServiceObjectType;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServices;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicOrderServiceDetail;
/*     */ import nencer.app.Modules.Medic.Model.bhyt.MedicOrderServiceBhyt;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class BhytController extends BaseMedicController {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(BhytController.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_bhyt/all_medic_order_services/{mdId}"})
/*     */   public ApiResponse getAllOrderSeviceByMdId(@PathVariable @Valid Integer mdId) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  52 */       List<MedicOrderServiceDetail> list = this.commonTicketRepo.spGetMedicOrderServiceByMdId(mdId);
/*     */       
/*  54 */       data.put("dataRes", list);
/*  55 */       rs.put("status", "OK");
/*  56 */       rs.put("responseCode", "00");
/*  57 */       rs.put("data", data);
/*     */       
/*  59 */       return rs;
/*  60 */     } catch (Exception e) {
/*  61 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  62 */       logger.error(exceptionAsString);
/*  63 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */   }
/*     */   
/*     */   @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   @PostMapping({"/medic_bhyt/all_medic_order_services/edit"})
/*     */   public ApiResponse editPaymentObject(@Valid @RequestBody List<MedicOrderServiceBhyt> medicOrderServiceBhyts) {
/*  70 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  73 */       List<Integer> serviceOrderIds = new ArrayList<>();
/*  74 */       List<Integer> productOrderIds = new ArrayList<>();
/*     */       
/*  76 */       for (MedicOrderServiceBhyt medicOrderServiceBhyt : medicOrderServiceBhyts) {
/*  77 */         if (medicOrderServiceBhyt.getServiceGroupId().intValue() == 0) {
/*  78 */           productOrderIds.add(medicOrderServiceBhyt.getId()); continue;
/*     */         } 
/*  80 */         serviceOrderIds.add(medicOrderServiceBhyt.getId());
/*     */       } 
/*     */       
/*  83 */       List<MedicOrderServiceBhyt> medicOrderServiceBhytChecks = this.commonBhytRepo.spGetOrderPaidByIds(serviceOrderIds, productOrderIds);
/*     */       
/*  85 */       if (medicOrderServiceBhytChecks != null && medicOrderServiceBhytChecks.size() > 0) {
/*  86 */         this.apiError.getError("619", new String[0]);
/*     */       }
/*     */       
/*  89 */       for (MedicOrderServiceBhyt medicOrderServiceBhyt : medicOrderServiceBhyts) {
/*  90 */         if (medicOrderServiceBhyt.getServiceGroupId().intValue() == 0) {
/*  91 */           String str = medicOrderServiceBhyt.getServiceObjectCode();
/*  92 */           MedicProductOrderDetail medicProductOrderDetail = this.medicProductOrderDetailRepository.findById(medicOrderServiceBhyt.getId()).orElse(null);
/*  93 */           if (medicProductOrderDetail == null) {
/*  94 */             return this.apiError.getError("202", new String[] { String.valueOf(medicOrderServiceBhyt.getId()) });
/*     */           }
/*  96 */           MedicProductOrder medicProductOrder = this.medicProductOrderRepository.findById(medicProductOrderDetail.getOrderId()).orElse(null);
/*  97 */           if (medicProductOrder == null || medicProductOrder.getStatus().equalsIgnoreCase(FundStatus.PAID.getFundStatus())) {
/*     */             continue;
/*     */           }
/*     */           
/* 101 */           Integer benefitRate = getBenefitRateProduct(medicProductOrderDetail.getOrderId(), str);
/*     */           
/* 103 */           medicProductOrderDetail.setBenefitRate(benefitRate);
/* 104 */           medicProductOrderDetail.setServiceObject(str);
/*     */           
/* 106 */           this.medicProductOrderDetailRepository.saveAndFlush(medicProductOrderDetail); continue;
/*     */         } 
/* 108 */         Double total = null;
/* 109 */         Double price = null;
/* 110 */         Double payAmount = null;
/* 111 */         Double insurance = null;
/* 112 */         String status = OrderStatus.UNPAID.getOrderStatus();
/* 113 */         String serviceObject = medicOrderServiceBhyt.getServiceObjectCode();
/* 114 */         MedicOrderServices mos = this.orderServiceRepository.findByIdQuery(medicOrderServiceBhyt.getId()).orElse(null);
/* 115 */         if (mos == null) {
/* 116 */           return this.apiError.getError("999", new String[] { "MedicOrderServices IS NULL" });
/*     */         }
/* 118 */         MedicServices ms = this.serviceRepository.findById(mos.getServiceId()).orElse(null);
/* 119 */         if (ms == null) {
/* 120 */           return this.apiError.getError("999", new String[] { "MedicServices IS NULL" });
/*     */         }
/* 122 */         String serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */         try {
/* 124 */           if (StringUtils.isNotBlank(serviceObject)) {
/* 125 */             if (serviceObject.equalsIgnoreCase(ServiceObjectType.fee.getServiceObjectType())) {
/* 126 */               total = payAmount = Double.valueOf(ms.getPrice().doubleValue() * mos.getQty().intValue());
/* 127 */               price = ms.getPrice();
/* 128 */               serviceObj = ServiceObjectType.fee.getServiceObjectType();
/*     */             } 
/* 130 */             if (serviceObject.equalsIgnoreCase(ServiceObjectType.request.getServiceObjectType())) {
/* 131 */               total = payAmount = Double.valueOf(ms.getPriceService().doubleValue() * mos.getQty().intValue());
/* 132 */               price = ms.getPriceService();
/* 133 */               serviceObj = ServiceObjectType.request.getServiceObjectType();
/*     */             } 
/* 135 */             if (serviceObject.equalsIgnoreCase(ServiceObjectType.bhyt.getServiceObjectType())) {
/* 136 */               payAmount = Double.valueOf(ms.getPriceIns().doubleValue() * mos.getQty().intValue());
/* 137 */               insurance = Double.valueOf(ms.getPriceIns().doubleValue() * mos.getQty().intValue());
/*     */               
/* 139 */               total = Double.valueOf(payAmount.doubleValue() - ms.getPriceIns().doubleValue() * mos.getQty().intValue());
/* 140 */               price = ms.getPriceIns();
/* 141 */               status = OrderStatus.BHYT.getOrderStatus();
/* 142 */               serviceObj = ServiceObjectType.bhyt.getServiceObjectType();
/*     */             } 
/*     */           } else {
/* 145 */             total = payAmount = Double.valueOf(ms.getPriceService().doubleValue() * mos.getQty().intValue());
/* 146 */             price = ms.getPriceService();
/*     */           }
/*     */         
/* 149 */         } catch (Exception ex) {
/* 150 */           String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 151 */           logger.error(exceptionAsString);
/*     */         } 
/* 153 */         mos.setPayAmount(payAmount);
/* 154 */         mos.setTotalAmount(total);
/* 155 */         mos.setPrice(price);
/* 156 */         mos.setStatus(status);
/* 157 */         mos.setPayment(status);
/* 158 */         mos.setInsurancePay(insurance);
/* 159 */         mos.setServiceObject(serviceObj);
/* 160 */         this.orderServiceRepository.saveAndFlush(mos);
/*     */       } 
/*     */       
/* 163 */       rs.put("status", "OK");
/* 164 */       rs.put("responseCode", "00");
/* 165 */     } catch (Exception e) {
/* 166 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 167 */       logger.error(exceptionAsString);
/* 168 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 169 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 171 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Bhyt\BhytController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */