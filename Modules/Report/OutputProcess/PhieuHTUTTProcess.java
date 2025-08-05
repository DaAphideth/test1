/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Utils.ConvertCurrentcyToString;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class PhieuHTUTTProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   public String getProcess(ExportModel exportModel, String contentBarCode, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, String orderType) throws JsonProcessingException {
/*     */     try {
/*  30 */       List<CheckinPrintFormResponse> rei = this.commonReportRepo.spGetPayment(exportModel.getFundLogId().intValue(), orderType);
/*  31 */       if (!rei.isEmpty())
/*     */       {
/*  33 */         for (CheckinPrintFormResponse r : rei) {
/*  34 */           contentBarCode = process(r, fieldData, mergeFieldDTO, calendar);
/*     */         }
/*     */       }
/*  37 */       return contentBarCode;
/*  38 */     } catch (Exception ex) {
/*  39 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  40 */       logger.error(exceptionAsString);
/*  41 */       return contentBarCode;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String process(CheckinPrintFormResponse r, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, Calendar calendar) {
/*  48 */     NumberFormat currentLocale = NumberFormat.getInstance();
/*  49 */     String netAmount = (r.getNetAmount() != null) ? r.getNetAmount().toString() : "0";
/*     */     
/*  51 */     String payAmountFormat = currentLocale.format((r.getPayAmount() != null) ? r.getPayAmount().longValue() : 0L);
/*     */     
/*  53 */     String netAmountFormat = currentLocale.format((r.getNetAmount() != null) ? r.getNetAmount().longValue() : 0L);
/*     */     
/*  55 */     String discountFormat = currentLocale.format((r.getDiscount() != null) ? r.getDiscount().longValue() : 0L);
/*     */     
/*  57 */     this.customerProcess.getCustomer(r, fieldData, mergeFieldDTO);
/*     */     
/*  59 */     mergeFieldDTO.setCode("bookNumber");
/*  60 */     mergeFieldDTO.setValue(r.getBookNumber());
/*  61 */     mergeFieldDTO.setMergeField("bookNumber");
/*  62 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  63 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  65 */     mergeFieldDTO.setCode("fundLog");
/*  66 */     mergeFieldDTO.setValue(r.getFundLog());
/*  67 */     mergeFieldDTO.setMergeField("fundLog");
/*  68 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  69 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  71 */     mergeFieldDTO.setCode("totalRecord");
/*  72 */     mergeFieldDTO.setValue(r.getTotalRecord());
/*  73 */     mergeFieldDTO.setMergeField("totalRecord");
/*  74 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  75 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  78 */     mergeFieldDTO.setCode("nameDepartment");
/*  79 */     mergeFieldDTO.setValue(r.getNameDepartment());
/*  80 */     mergeFieldDTO.setMergeField("nameDepartment");
/*  81 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  82 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  84 */     mergeFieldDTO.setCode("serviceName");
/*  85 */     mergeFieldDTO.setValue(r.getServiceName());
/*  86 */     mergeFieldDTO.setMergeField("serviceName");
/*  87 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  88 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  90 */     mergeFieldDTO.setCode("description");
/*  91 */     mergeFieldDTO.setValue(r.getDescription());
/*  92 */     mergeFieldDTO.setMergeField("description");
/*  93 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  94 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  96 */     mergeFieldDTO.setCode("payAmount");
/*  97 */     mergeFieldDTO.setValue(payAmountFormat + " " + r.getNameCurrency());
/*  98 */     mergeFieldDTO.setMergeField("payAmount");
/*  99 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 100 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 103 */     mergeFieldDTO.setCode("discount");
/* 104 */     mergeFieldDTO.setValue(discountFormat + " " + r.getNameCurrency());
/* 105 */     mergeFieldDTO.setMergeField("discount");
/* 106 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 110 */     mergeFieldDTO.setCode("netAmount");
/* 111 */     mergeFieldDTO.setValue(netAmountFormat + " " + r.getNameCurrency());
/* 112 */     mergeFieldDTO.setMergeField("netAmount");
/* 113 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 114 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 116 */     mergeFieldDTO.setCode("writtenInLetters");
/* 117 */     mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(netAmount, r.getNameCurrency(), null));
/* 118 */     mergeFieldDTO.setMergeField("writtenInLetters");
/* 119 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 120 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 122 */     mergeFieldDTO.setCode("collecter");
/* 123 */     mergeFieldDTO.setValue(r.getCollecter());
/* 124 */     mergeFieldDTO.setMergeField("collecter");
/* 125 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 126 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 128 */     return r.getCheckinId();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuHTUTTProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */