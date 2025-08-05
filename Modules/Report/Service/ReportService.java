/*     */ package nencer.app.Modules.Report.Service;
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.MedicCheckinLive;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReportVariable;
/*     */ import nencer.app.Modules.Report.Model.CheckinReport;
/*     */ import nencer.app.Modules.Report.Model.ExaminationCDHAReport;
/*     */ import nencer.app.Modules.Report.Model.ExaminationReport;
/*     */ import nencer.app.Modules.Report.Model.ExaminationXNReport;
/*     */ import nencer.app.Modules.Report.Model.InvenReportChildModel;
/*     */ import nencer.app.Modules.Report.Model.InvenReportModel;
/*     */ import nencer.app.Modules.Report.Model.MedicExaminationReport;
/*     */ import nencer.app.Modules.Report.Model.PaymentReport;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Report.Model.SupplierReportChildModel;
/*     */ import nencer.app.Modules.Report.Model.SupplierReportModel;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ 
/*     */ @Service
/*     */ public class ReportService {
/*  33 */   public static final Logger logger = LoggerFactory.getLogger(ExaminationController.class);
/*     */   
/*     */   @Autowired
/*     */   Environment env;
/*     */   
/*     */   @Autowired
/*     */   private CommonReportRepo commonReportRepo;
/*     */   
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   
/*     */   @Autowired
/*     */   MedicMasterDataRepository medicMasterDataRepository;
/*     */   
/*     */   @Autowired
/*     */   MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */   
/*     */   @Autowired
/*     */   ObjectMapper objectMapper;
/*     */ 
/*     */   
/*     */   public Map<String, Object> getMedicExaminationReportService(String startDate, String endDate) {
/*  55 */     Date fromDate = DataUtil.safeToDate2(startDate);
/*  56 */     Date toDate = DataUtil.safeToDate2(endDate);
/*  57 */     List<MedicMasterData> medicMasterData = this.medicMasterDataRepository.findAllByMedicType("department_health");
/*     */     
/*  59 */     List<MedicExaminationReport> medicExaminationReports = this.commonReportRepo.spGetMedicExaminationReport(fromDate, toDate);
/*  60 */     Map<String, Object> data = new HashMap<>();
/*  61 */     data.put("medicExaminationReports", medicExaminationReports);
/*  62 */     data.put("fromDate", startDate);
/*  63 */     data.put("toDate", endDate);
/*  64 */     data.put("hospital", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null));
/*  65 */     data.put("department", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null));
/*  66 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getLogisticInvenReportService(String startDate, String endDate, Integer storehouseId) {
/*  70 */     Date fromDate = DataUtil.safeToDate2(startDate);
/*  71 */     Date toDate = DataUtil.safeToDate2(endDate);
/*  72 */     List<InvenReportModel> invenReportModels = this.commonReportRepo.spGetInvenReport(storehouseId, fromDate, toDate);
/*  73 */     for (InvenReportModel invenReportModel : invenReportModels) {
/*     */       
/*  75 */       List<InvenReportChildModel> invenReportChildModels = this.commonReportRepo.spGetLogisticInvenReport(storehouseId, invenReportModel.getProductType(), null, null, fromDate, toDate);
/*  76 */       invenReportModel.setInvenReportChildModels(invenReportChildModels);
/*     */     } 
/*     */     
/*  79 */     List<MedicMasterData> medicMasterData = this.medicMasterDataRepository.findAllByMedicType("department_health");
/*     */     
/*  81 */     Map<String, Object> data = new HashMap<>();
/*  82 */     data.put("invenReportModels", invenReportModels);
/*  83 */     data.put("hospital", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null));
/*  84 */     data.put("department", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null));
/*     */     
/*  86 */     data.put("storehouseName", (invenReportModels.size() > 0) ? ((InvenReportModel)invenReportModels.get(0)).getStorehouseName() : "");
/*  87 */     data.put("fromDate", startDate);
/*  88 */     data.put("toDate", endDate);
/*  89 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getSupplierReportService(String startDate, String endDate, Integer storehouseId) {
/*  93 */     Date fromDate = DataUtil.safeToDate2(startDate);
/*  94 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/*  96 */     List<SupplierReportModel> supplierReportModels = this.commonReportRepo.spGetSupplierParentReport(storehouseId, fromDate, toDate);
/*  97 */     for (SupplierReportModel supplierReportModel : supplierReportModels) {
/*     */       
/*  99 */       List<SupplierReportChildModel> supplierReportChildModels = this.commonReportRepo.spGetSupplierReport(storehouseId, supplierReportModel.getProductSrcCode(), fromDate, toDate);
/* 100 */       supplierReportModel.setSupplierReportChildModels(supplierReportChildModels);
/*     */     } 
/*     */     
/* 103 */     MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(storehouseId).orElse(new MedicProductStorehouse());
/*     */     
/* 105 */     Map<String, Object> data = new HashMap<>();
/* 106 */     data.put("supplierReportModels", supplierReportModels);
/* 107 */     data.put("storehouseName", medicProductStorehouse.getName());
/* 108 */     data.put("fromDate", startDate);
/* 109 */     data.put("toDate", endDate);
/* 110 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getExaminationReport(String startDate, String endDate) {
/* 114 */     Date fromDate = DataUtil.safeToDate2(startDate);
/* 115 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/* 117 */     List<ExaminationReport> examinationReports = this.commonReportRepo.spGetExaminationReport(fromDate, toDate);
/* 118 */     Map<String, Object> data = new HashMap<>();
/* 119 */     data.put("examinationReports", examinationReports);
/* 120 */     data.put("fromDate", startDate);
/* 121 */     data.put("toDate", endDate);
/* 122 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> spGetXNReport(String startDate, String endDate) {
/* 126 */     Date fromDate = DataUtil.safeToDate2(startDate);
/* 127 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/* 129 */     List<ExaminationXNReport> examinationXNReports = this.commonReportRepo.spGetExaminationXNReport(fromDate, toDate);
/* 130 */     Map<String, Object> data = new HashMap<>();
/* 131 */     data.put("examinationXNReports", examinationXNReports);
/* 132 */     data.put("fromDate", startDate);
/* 133 */     data.put("toDate", endDate);
/* 134 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> spGetPaymentReport(String startDate, String endDate) {
/* 138 */     Date fromDate = DataUtil.safeToDate2(startDate);
/* 139 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/* 141 */     List<PaymentReport> paymentReports = this.commonReportRepo.spGetPaymentReport(fromDate, toDate);
/*     */     
/* 143 */     for (PaymentReport paymentReport : paymentReports) {
/* 144 */       paymentReport.setPayAmount(ApiHelper.formatDecimal(paymentReport.getPayAmountDouble()));
/* 145 */       paymentReport.setPayAmountTU(ApiHelper.formatDecimal(paymentReport.getPayAmountTUDouble()));
/* 146 */       paymentReport.setPayAmountHU(ApiHelper.formatDecimal(paymentReport.getPayAmountHUDouble()));
/* 147 */       paymentReport.setPayAmountMG(ApiHelper.formatDecimal(paymentReport.getPayAmountMGDouble()));
/*     */     } 
/*     */     
/* 150 */     Double payAmountDouble = Double.valueOf(paymentReports.stream().mapToDouble(PaymentReport::getPayAmountDouble).sum());
/* 151 */     Double payAmountTUDouble = Double.valueOf(paymentReports.stream().mapToDouble(PaymentReport::getPayAmountTUDouble).sum());
/* 152 */     Double payAmountHUDouble = Double.valueOf(paymentReports.stream().mapToDouble(PaymentReport::getPayAmountHUDouble).sum());
/* 153 */     Double payAmountMGDouble = Double.valueOf(paymentReports.stream().mapToDouble(PaymentReport::getPayAmountMGDouble).sum());
/*     */     
/* 155 */     String totalPayAmount = ApiHelper.formatDecimal(payAmountDouble);
/* 156 */     String totalPayAmountTU = ApiHelper.formatDecimal(payAmountTUDouble);
/* 157 */     String totalPayAmountHU = ApiHelper.formatDecimal(payAmountHUDouble);
/* 158 */     String totalPayAmountMG = ApiHelper.formatDecimal(payAmountMGDouble);
/*     */     
/* 160 */     String total = ApiHelper.formatDecimal(Double.valueOf(payAmountDouble.doubleValue() + payAmountTUDouble.doubleValue() - payAmountHUDouble.doubleValue() - payAmountMGDouble.doubleValue()));
/*     */     
/* 162 */     Map<String, Object> data = new HashMap<>();
/* 163 */     data.put("paymentReports", paymentReports);
/* 164 */     data.put("fromDate", startDate);
/* 165 */     data.put("toDate", endDate);
/* 166 */     data.put("totalPayAmount", totalPayAmount);
/* 167 */     data.put("totalPayAmountTU", totalPayAmountTU);
/* 168 */     data.put("totalPayAmountHU", totalPayAmountHU);
/* 169 */     data.put("totalPayAmountMG", totalPayAmountMG);
/* 170 */     data.put("total", total);
/* 171 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> spGetCDHAReport(String startDate, String endDate) {
/* 175 */     Date fromDate = DataUtil.safeToDate2(startDate);
/* 176 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/* 178 */     List<ExaminationCDHAReport> examinationCDHAReports = this.commonReportRepo.spExaminationCDHAReport(fromDate, toDate);
/*     */     
/* 180 */     List<MedicMasterData> medicMasterData = this.medicMasterDataRepository.findAllByMedicType("department_health");
/*     */     
/* 182 */     Map<String, Object> data = new HashMap<>();
/* 183 */     data.put("examinationCDHAReports", examinationCDHAReports);
/* 184 */     data.put("hospital", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("HOSPITAL")).findFirst().orElse(null));
/* 185 */     data.put("department", medicMasterData.stream().filter(f -> f.getMedicCode().equalsIgnoreCase("DEPARTMENT")).findFirst().orElse(null));
/* 186 */     data.put("fromDate", startDate);
/* 187 */     data.put("toDate", endDate);
/* 188 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> spGetCheckinReport(String startDate, String endDate) {
/* 192 */     Date fromDate = DataUtil.safeToDate2(startDate);
/* 193 */     Date toDate = DataUtil.safeToDate2(endDate);
/*     */     
/* 195 */     List<CheckinReport> checkinReports = this.commonReportRepo.spCheckinReport(fromDate, toDate);
/* 196 */     Map<String, Object> data = new HashMap<>();
/* 197 */     data.put("checkinReports", checkinReports);
/* 198 */     data.put("fromDate", startDate);
/* 199 */     data.put("toDate", endDate);
/* 200 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getReportDynamicData(String rpSql, Map<String, String> variables, List<DynamicReportVariable> dynamicReportVariables) throws ParseException {
/* 204 */     Map<String, Object> data = new HashMap<>();
/* 205 */     List<Map<String, Object>> dynamicData = this.commonReportRepo.getReportDynamicData(rpSql, variables, dynamicReportVariables);
/* 206 */     data.put("data", dynamicData);
/* 207 */     data.putAll(variables);
/* 208 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getLiveFunction(Integer mdId, String from, String to) throws JsonProcessingException {
/* 212 */     Date fromDate = DataUtil.safeToDate2(from);
/* 213 */     Date toDate = DataUtil.safeToDate2(to);
/*     */ 
/*     */     
/* 216 */     MedicCheckinLive medicCheckinLive = this.commonReportRepo.spGetLiveFunction(mdId, fromDate, toDate);
/* 217 */     Map<String, Object> data = new HashMap<>();
/* 218 */     data.put("data", medicCheckinLive.getMedicCheckinLiveMerges());
/* 219 */     if (medicCheckinLive.getCustomerData() != null) {
/* 220 */       StringBuilder stringBuilder = new StringBuilder();
/* 221 */       for (Map.Entry<String, Object> entry : (Iterable<Map.Entry<String, Object>>)medicCheckinLive.getCustomerData().entrySet()) {
/* 222 */         String key = entry.getKey();
/* 223 */         if (key.equalsIgnoreCase("diagnostic") || key.equalsIgnoreCase("subDiagnostic")) {
/* 224 */           extractTextProcess(stringBuilder, entry);
/*     */         }
/*     */       } 
/* 227 */       data.put("diagnosticName", stringBuilder.toString());
/*     */     } 
/*     */     
/* 230 */     data.putAll(medicCheckinLive.getCustomerData());
/* 231 */     return data;
/*     */   }
/*     */   
/*     */   private void extractTextProcess(StringBuilder stringBuilder, Map.Entry<String, Object> entry) throws JsonProcessingException {
/* 235 */     String x = (String)entry.getValue();
/* 236 */     List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(x, new TypeReference<List<ReExaminationModel>>() {
/*     */         
/*     */         });
/* 239 */     String diagnostic = reExam.stream().filter(e -> StringUtils.isNoneBlank(new CharSequence[] { e.getCode() })).map(ReExaminationModel::toString).collect(Collectors.joining("; "));
/* 240 */     stringBuilder.append(diagnostic);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Service\ReportService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */