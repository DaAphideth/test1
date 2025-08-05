/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.FinancialReportModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ConvertCurrentcyToString;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class BaoCaoTaiChinhProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  26 */       Date fromDate = DataUtil.safeToDate2(exportModel.getStartDate());
/*  27 */       Date toDate = DataUtil.safeToDate2(exportModel.getEndDate());
/*  28 */       List<FinancialReportModel> reportModels = this.commonReportRepo.sp_get_financial_report(fromDate, toDate);
/*  29 */       if (!reportModels.isEmpty()) {
/*  30 */         for (FinancialReportModel re : reportModels) {
/*  31 */           process(re, mergeFieldDTO, fieldData, exportModel.getName(), fromDate, toDate);
/*     */         }
/*     */       }
/*  34 */     } catch (Exception ex) {
/*  35 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  36 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(FinancialReportModel re, MergeFieldDTO mergeFieldDTO, List<MergeFieldDTO> fieldData, String nameDoctor, Date fromDate, Date toDate) {
/*  42 */     Calendar cal = Calendar.getInstance();
/*  43 */     NumberFormat currentLocale = NumberFormat.getInstance();
/*     */     
/*  45 */     String totalPaymentWriten = ConvertCurrentcyToString.getCurrentName(re.getTotalPayment().toString(), DataUtil.safeToString(re.getCurrency()).toLowerCase(), null);
/*  46 */     mergeFieldDTO.setCode("tongDaThuNhanDan");
/*  47 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountReceivedPeople()));
/*  48 */     mergeFieldDTO.setMergeField("tongDaThuNhanDan");
/*  49 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  50 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  52 */     mergeFieldDTO.setCode("tongDaThuBhyt");
/*  53 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountReceivedBHYT()));
/*  54 */     mergeFieldDTO.setMergeField("tongDaThuBhyt");
/*  55 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  56 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  58 */     mergeFieldDTO.setCode("tongDaThu");
/*  59 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountReceived()));
/*  60 */     mergeFieldDTO.setMergeField("tongDaThu");
/*  61 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  62 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  64 */     mergeFieldDTO.setCode("tongThucThuNhanDan");
/*  65 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountActuallyCollectedPeople()));
/*  66 */     mergeFieldDTO.setMergeField("tongThucThuNhanDan");
/*  67 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  68 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  71 */     mergeFieldDTO.setCode("tongThucThuBHYT");
/*  72 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountActuallyCollectedBHYT()));
/*  73 */     mergeFieldDTO.setMergeField("tongThucThuBHYT");
/*  74 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  75 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  77 */     mergeFieldDTO.setCode("tongThucThu");
/*  78 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountActuallyCollected()));
/*  79 */     mergeFieldDTO.setMergeField("tongThucThu");
/*  80 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  81 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  83 */     mergeFieldDTO.setCode("tongHoanUngNhanDan");
/*  84 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRefundPeople()));
/*  85 */     mergeFieldDTO.setMergeField("tongHoanUngNhanDan");
/*  86 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  87 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  89 */     mergeFieldDTO.setCode("tongHoanUngBHYT");
/*  90 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRefundBHYT()));
/*  91 */     mergeFieldDTO.setMergeField("tongHoanUngBHYT");
/*  92 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  93 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  95 */     mergeFieldDTO.setCode("tongHoanUng");
/*  96 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRefund()));
/*  97 */     mergeFieldDTO.setMergeField("tongHoanUng");
/*  98 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  99 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 101 */     mergeFieldDTO.setCode("tongMienGiamNhanDan");
/* 102 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountOfExemptionsPeople()));
/* 103 */     mergeFieldDTO.setMergeField("tongMienGiamNhanDan");
/* 104 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 105 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 107 */     mergeFieldDTO.setCode("tongMienGiamBHYT");
/* 108 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountOfExemptionsBHYT()));
/* 109 */     mergeFieldDTO.setMergeField("tongMienGiamBHYT");
/* 110 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 111 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 113 */     mergeFieldDTO.setCode("tongMienGiam");
/* 114 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountOfExemptions()));
/* 115 */     mergeFieldDTO.setMergeField("tongMienGiam");
/* 116 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 117 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 119 */     mergeFieldDTO.setCode("tongTamUngNhanDan");
/* 120 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAdvanceAmountPeople()));
/* 121 */     mergeFieldDTO.setMergeField("tongTamUngNhanDan");
/* 122 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 123 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 125 */     mergeFieldDTO.setCode("tongTamUngBHYT");
/* 126 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAdvanceAmountBHYT()));
/* 127 */     mergeFieldDTO.setMergeField("tongTamUngBHYT");
/* 128 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 129 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 131 */     mergeFieldDTO.setCode("tongTamUng");
/* 132 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAdvanceAmount()));
/* 133 */     mergeFieldDTO.setMergeField("tongTamUng");
/* 134 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 135 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 137 */     mergeFieldDTO.setCode("tongDaHuyNhanDan");
/* 138 */     mergeFieldDTO.setValue(re.getTotalNumberCancellationsPeople());
/* 139 */     mergeFieldDTO.setMergeField("tongDaHuyNhanDan");
/* 140 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 141 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 143 */     mergeFieldDTO.setCode("tongDaHuyBHYT");
/* 144 */     mergeFieldDTO.setValue(re.getTotalNumberCancellationsBHYT());
/* 145 */     mergeFieldDTO.setMergeField("tongDaHuyBHYT");
/* 146 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 147 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 149 */     mergeFieldDTO.setCode("tongDaHuy");
/* 150 */     mergeFieldDTO.setValue(re.getTotalNumberCancellations());
/* 151 */     mergeFieldDTO.setMergeField("tongDaHuy");
/* 152 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 153 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 155 */     mergeFieldDTO.setCode("tongHoanTraNhanDan");
/* 156 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountRefundedPeople()));
/* 157 */     mergeFieldDTO.setMergeField("tongHoanTraNhanDan");
/* 158 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 159 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 161 */     mergeFieldDTO.setCode("tongHoanTraBHYT");
/* 162 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountRefundedBHYT()));
/* 163 */     mergeFieldDTO.setMergeField("tongHoanTraBHYT");
/* 164 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 165 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 167 */     mergeFieldDTO.setCode("tongHoanTra");
/* 168 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalAmountRefunded()));
/* 169 */     mergeFieldDTO.setMergeField("tongHoanTra");
/* 170 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 171 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 173 */     mergeFieldDTO.setCode("tongBenhNhanVuotTranPeople");
/* 174 */     mergeFieldDTO.setValue(re.getTotalPatientsExceededPeople());
/* 175 */     mergeFieldDTO.setMergeField("tongBenhNhanVuotTranPeople");
/* 176 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 177 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 179 */     mergeFieldDTO.setCode("tongBenhNhanVuotTranBHYT");
/* 180 */     mergeFieldDTO.setValue(re.getTotalPatientsExceededBHYT());
/* 181 */     mergeFieldDTO.setMergeField("tongBenhNhanVuotTranBHYT");
/* 182 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 183 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 185 */     mergeFieldDTO.setCode("tongBenhNhanVuotTran");
/* 186 */     mergeFieldDTO.setValue(re.getTotalPatientsExceeded());
/* 187 */     mergeFieldDTO.setMergeField("tongBenhNhanVuotTran");
/* 188 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 189 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 191 */     mergeFieldDTO.setCode("tongTienNopQuy");
/* 192 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalPayment()));
/* 193 */     mergeFieldDTO.setMergeField("tongTienNopQuy");
/* 194 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 195 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 197 */     mergeFieldDTO.setCode("curency");
/* 198 */     mergeFieldDTO.setValue(DataUtil.safeToString(re.getCurrency()).toLowerCase());
/* 199 */     mergeFieldDTO.setMergeField("curency");
/* 200 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 201 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 203 */     mergeFieldDTO.setCode("tongTienNopQuyGhiBangChu");
/* 204 */     mergeFieldDTO.setValue(totalPaymentWriten);
/* 205 */     mergeFieldDTO.setMergeField("tongTienNopQuyGhiBangChu");
/* 206 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 207 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 209 */     mergeFieldDTO.setCode("ngayKham");
/* 210 */     mergeFieldDTO.setValue(String.valueOf(cal.get(5)));
/* 211 */     mergeFieldDTO.setMergeField("ngayKham");
/* 212 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 213 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 215 */     mergeFieldDTO.setCode("thangKham");
/* 216 */     mergeFieldDTO.setValue(String.valueOf(cal.get(2)));
/* 217 */     mergeFieldDTO.setMergeField("thangKham");
/* 218 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 219 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 221 */     mergeFieldDTO.setCode("namKham");
/* 222 */     mergeFieldDTO.setValue(String.valueOf(cal.get(1)));
/* 223 */     mergeFieldDTO.setMergeField("namKham");
/* 224 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 225 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 227 */     mergeFieldDTO.setCode("departmentHealth");
/* 228 */     mergeFieldDTO.setValue(re.getDepartmentHealth());
/* 229 */     mergeFieldDTO.setMergeField("departmentHealth");
/* 230 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 231 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 233 */     mergeFieldDTO.setCode("hospitalName");
/* 234 */     mergeFieldDTO.setValue(re.getHospitalName());
/* 235 */     mergeFieldDTO.setMergeField("hospitalName");
/* 236 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 237 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 239 */     mergeFieldDTO.setCode("addressHospital");
/* 240 */     mergeFieldDTO.setValue(re.getAddressHospital());
/* 241 */     mergeFieldDTO.setMergeField("addressHospital");
/* 242 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 243 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 245 */     mergeFieldDTO.setCode("fromDate");
/* 246 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(fromDate));
/* 247 */     mergeFieldDTO.setMergeField("fromDate");
/* 248 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 249 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 251 */     mergeFieldDTO.setCode("toDate");
/* 252 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(toDate));
/* 253 */     mergeFieldDTO.setMergeField("toDate");
/* 254 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 255 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 257 */     mergeFieldDTO.setCode("nameDoctor");
/* 258 */     mergeFieldDTO.setValue(nameDoctor);
/* 259 */     mergeFieldDTO.setMergeField("nameDoctor");
/* 260 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 261 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 264 */     mergeFieldDTO.setCode("tongDoanhThuNhanDan");
/* 265 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRevenueBHYT()));
/* 266 */     mergeFieldDTO.setMergeField("tongDoanhThuNhanDan");
/* 267 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 268 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 270 */     mergeFieldDTO.setCode("tongDoanhThuBHYT");
/* 271 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRevenuePeople()));
/* 272 */     mergeFieldDTO.setMergeField("tongDoanhThuBHYT");
/* 273 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 274 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 276 */     mergeFieldDTO.setCode("tongDoanhThu");
/* 277 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalRevenue()));
/* 278 */     mergeFieldDTO.setMergeField("tongDoanhThu");
/* 279 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 280 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 282 */     mergeFieldDTO.setCode("tongBhytChitraNhanDan");
/* 283 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalHealthInsurancePaysPeople()));
/* 284 */     mergeFieldDTO.setMergeField("tongBhytChitraNhanDan");
/* 285 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 286 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 288 */     mergeFieldDTO.setCode("tongBhytChitraBHYT");
/* 289 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalHealthInsurancePaysBHYT()));
/* 290 */     mergeFieldDTO.setMergeField("tongBhytChitraBHYT");
/* 291 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 292 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 294 */     mergeFieldDTO.setCode("tongBhytChitra");
/* 295 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalHealthInsurancePays()));
/* 296 */     mergeFieldDTO.setMergeField("tongBhytChitra");
/* 297 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 298 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 300 */     mergeFieldDTO.setCode("tongMienGiamDichVuNhanDan");
/* 301 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceExemptionsPeople()));
/* 302 */     mergeFieldDTO.setMergeField("tongMienGiamDichVuNhanDan");
/* 303 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 304 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 306 */     mergeFieldDTO.setCode("tongMienGiamDichVuBHYT");
/* 307 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceExemptionsBHYT()));
/* 308 */     mergeFieldDTO.setMergeField("tongMienGiamDichVuBHYT");
/* 309 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 310 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 312 */     mergeFieldDTO.setCode("tongMienGiamDichVu");
/* 313 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceExemptions()));
/* 314 */     mergeFieldDTO.setMergeField("tongMienGiamDichVu");
/* 315 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 316 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 318 */     mergeFieldDTO.setCode("tongCanThuNhanDan");
/* 319 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalCollectionPatientPeople()));
/* 320 */     mergeFieldDTO.setMergeField("tongCanThuNhanDan");
/* 321 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 322 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 324 */     mergeFieldDTO.setCode("tongCanThuBHYT");
/* 325 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalCollectionPatientBHYT()));
/* 326 */     mergeFieldDTO.setMergeField("tongCanThuBHYT");
/* 327 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 328 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 330 */     mergeFieldDTO.setCode("tongCanThu");
/* 331 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalCollectionPatient()));
/* 332 */     mergeFieldDTO.setMergeField("tongCanThu");
/* 333 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 334 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 336 */     mergeFieldDTO.setCode("tongDaThuDichVuNhanDan");
/* 337 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceMedicinePeople()));
/* 338 */     mergeFieldDTO.setMergeField("tongDaThuDichVuNhanDan");
/* 339 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 340 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 342 */     mergeFieldDTO.setCode("tongDaThuDichVuBHYT");
/* 343 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceMedicineBHYT()));
/* 344 */     mergeFieldDTO.setMergeField("tongDaThuDichVuBHYT");
/* 345 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 346 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 348 */     mergeFieldDTO.setCode("tongDaThuDichVu");
/* 349 */     mergeFieldDTO.setValue(currentLocale.format(re.getTotalServiceMedicine()));
/* 350 */     mergeFieldDTO.setMergeField("tongDaThuDichVu");
/* 351 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 352 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\BaoCaoTaiChinhProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */