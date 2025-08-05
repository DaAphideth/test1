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
/*     */ @Component
/*     */ public class PhieuThuTienKhoProcess
/*     */   extends BaseProcess {
/*     */   @Autowired
/*     */   CustomerProcess customerProcess;
/*     */   
/*     */   public String getProcess(ExportModel exportModel, String contentBarCode, Calendar calendar, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO, String orderType) throws JsonProcessingException {
/*     */     try {
/*  24 */       List<CheckinPrintFormResponse> rei = this.commonReportRepo.spGetPayment(exportModel.getFundLogId().intValue(), orderType);
/*  25 */       if (!rei.isEmpty())
/*     */       {
/*  27 */         for (CheckinPrintFormResponse r : rei) {
/*  28 */           contentBarCode = process(r, fieldData, mergeFieldDTO);
/*     */         }
/*     */       }
/*  31 */       return contentBarCode;
/*  32 */     } catch (Exception ex) {
/*  33 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  34 */       logger.error(exceptionAsString);
/*  35 */       return contentBarCode;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String process(CheckinPrintFormResponse r, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*  41 */     NumberFormat currentLocale = NumberFormat.getInstance();
/*  42 */     String netAmount = (r.getNetAmount() != null) ? r.getNetAmount().toString() : "0";
/*     */     
/*  44 */     String payAmountFormat = currentLocale.format((r.getPayAmount() != null) ? r.getPayAmount().longValue() : 0L);
/*     */     
/*  46 */     String netAmountFormat = currentLocale.format((r.getNetAmount() != null) ? r.getNetAmount().longValue() : 0L);
/*     */     
/*  48 */     String discountFormat = currentLocale.format((r.getDiscount() != null) ? r.getDiscount().longValue() : 0L);
/*     */     
/*  50 */     this.customerProcess.getCustomer(r, fieldData, mergeFieldDTO);
/*     */     
/*  52 */     mergeFieldDTO.setCode("bookNumber");
/*  53 */     mergeFieldDTO.setValue(r.getBookNumber());
/*  54 */     mergeFieldDTO.setMergeField("bookNumber");
/*  55 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  56 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  58 */     mergeFieldDTO.setCode("fundLog");
/*  59 */     mergeFieldDTO.setValue(r.getFundLog());
/*  60 */     mergeFieldDTO.setMergeField("fundLog");
/*  61 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  62 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  64 */     mergeFieldDTO.setCode("totalRecord");
/*  65 */     mergeFieldDTO.setValue(r.getTotalRecord());
/*  66 */     mergeFieldDTO.setMergeField("totalRecord");
/*  67 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  68 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  71 */     mergeFieldDTO.setCode("nameDepartment");
/*  72 */     mergeFieldDTO.setValue(r.getNameDepartment());
/*  73 */     mergeFieldDTO.setMergeField("nameDepartment");
/*  74 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  75 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  77 */     mergeFieldDTO.setCode("serviceName");
/*  78 */     mergeFieldDTO.setValue(r.getServiceName());
/*  79 */     mergeFieldDTO.setMergeField("serviceName");
/*  80 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  81 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  83 */     mergeFieldDTO.setCode("description");
/*  84 */     mergeFieldDTO.setValue(r.getDescription());
/*  85 */     mergeFieldDTO.setMergeField("description");
/*  86 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  87 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  89 */     mergeFieldDTO.setCode("payAmount");
/*  90 */     mergeFieldDTO.setValue(payAmountFormat + " " + r.getNameCurrency());
/*  91 */     mergeFieldDTO.setMergeField("payAmount");
/*  92 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  93 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  96 */     mergeFieldDTO.setCode("discount");
/*  97 */     mergeFieldDTO.setValue(discountFormat + " " + r.getNameCurrency());
/*  98 */     mergeFieldDTO.setMergeField("discount");
/*  99 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 100 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 103 */     mergeFieldDTO.setCode("netAmount");
/* 104 */     mergeFieldDTO.setValue(netAmountFormat + " " + r.getNameCurrency());
/* 105 */     mergeFieldDTO.setMergeField("netAmount");
/* 106 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 109 */     mergeFieldDTO.setCode("writtenInLetters");
/* 110 */     mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(netAmount, r.getNameCurrency(), null));
/* 111 */     mergeFieldDTO.setMergeField("writtenInLetters");
/* 112 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 113 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 115 */     mergeFieldDTO.setCode("collecter");
/* 116 */     mergeFieldDTO.setValue(r.getCollecter());
/* 117 */     mergeFieldDTO.setMergeField("collecter");
/* 118 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 119 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 121 */     return r.getCheckinId();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuThuTienKhoProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */