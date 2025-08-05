/*     */ package nencer.app.Modules.Medic.Controller.Examination;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
/*     */ import nencer.app.Modules.Medic.Model.Response.MedicExamination.PaymentDetailModel;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceGroupRepository;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class ExaminationTabPaymentController
/*     */   extends BaseMedicController
/*     */ {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationTabPaymentController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   ServiceGroupRepository serviceGroupRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_examination/getPayment/{mdId}"})
/*     */   public ApiResponse getPayment(@PathVariable @Valid Integer mdId) {
/*  54 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  56 */       if (mdId == null) {
/*  57 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  60 */       Optional<MedicCheckinRecord> medicCheckinRecord = this.medicCheckinRecordRepository.findById(mdId);
/*  61 */       if (!medicCheckinRecord.isPresent()) {
/*  62 */         return this.apiError.getError("202", new String[] { mdId + "" });
/*     */       }
/*     */       
/*  65 */       List<PaymentDetailModel> orderServices = this.medicService.sp_get_order_service_by_md_id(mdId);
/*     */ 
/*     */       
/*  68 */       Set<MedicProductOrderDetailModel> setMedicProductOrderDetailModels = new HashSet<>();
/*  69 */       List<MedicProductOrderModel> medicProductOrderModels = this.commonStoreHouseRepo.getProductOrderCashSpViewPayment(((MedicCheckinRecord)medicCheckinRecord.get()).getCheckinId(), null);
/*  70 */       for (MedicProductOrderModel medicProductOrderModel : medicProductOrderModels) {
/*     */         
/*  72 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  73 */         setMedicProductOrderDetailModels.addAll(medicProductOrderDetailModels);
/*     */       } 
/*  75 */       if (setMedicProductOrderDetailModels != null && setMedicProductOrderDetailModels.size() > 0) {
/*  76 */         MedicServiceGroups mg = this.serviceGroupRepository.findById(Integer.valueOf(6)).orElse(null);
/*     */         
/*  78 */         for (MedicProductOrderDetailModel pod : setMedicProductOrderDetailModels)
/*     */         {
/*  80 */           orderServices.add(PaymentDetailModel.builder()
/*  81 */               .serviceGroupId(Integer.valueOf(6))
/*  82 */               .serviceGroupName(mg.getName())
/*  83 */               .serviceCode(pod.getCode())
/*  84 */               .serviceName(pod.getName())
/*  85 */               .serviceObject(pod.getServiceObject())
/*     */               
/*  87 */               .doctorName(pod.getCreatorName())
/*  88 */               .qty(pod.getQty())
/*  89 */               .price(pod.getPrice())
/*  90 */               .payAmount(Double.valueOf((pod.getPayAmount() == null) ? 0.0D : pod.getPayAmount().doubleValue()))
/*  91 */               .insurancePay(pod.getInsurancePay())
/*  92 */               .build());
/*     */         }
/*     */       } 
/*  95 */       rs.put("status", "OK");
/*  96 */       rs.put("responseCode", "00");
/*  97 */       rs.put("data", orderServices);
/*  98 */     } catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       logger.error(exceptionAsString);
/* 101 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 103 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Examination\ExaminationTabPaymentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */