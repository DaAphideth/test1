/*     */ package nencer.app.Modules.Report.Repository;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.MedicCheckinLive;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.MedicCheckinLiveDetailModel;
/*     */ import nencer.app.Modules.Report.Entity.DynamicReportVariable;
/*     */ import nencer.app.Modules.Report.Model.ExaminationXNReport;
/*     */ import nencer.app.Modules.Report.Model.LableMedicModel;
/*     */ import nencer.app.Modules.Report.Model.MedicExaminationReport;
/*     */ import nencer.app.Modules.Report.Model.PaymentReport;
/*     */ import nencer.app.Modules.Report.Model.TicketInfoModel;
/*     */ import nencer.app.Modules.Report.Model.TreatmentDetailModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.CustomerModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuChiDinhModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuRaVienModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.GetPhieuTuVongModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.MdmHeaderModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.OrderServiceModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.PhieuDieuTriModel;
/*     */ import nencer.app.Modules.Report.Model.cddv.PtttInfo;
/*     */ import nencer.app.Modules.Report.Model.cddv.TicketModel;
/*     */ import nencer.app.Modules.Storehouse.Model.DrugVendorsResponse;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*     */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*     */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*     */ 
/*     */ @Repository
/*     */ public class CommonReportRepo {
/*  34 */   private final Logger logger = LoggerFactory.getLogger(CommonReportRepo.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   public Environment env;
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<InvenReportModel> spGetInvenReport(Integer storehouseId, Date fromDate, Date toDate) {
/*  54 */     this
/*     */ 
/*     */       
/*  57 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_inven_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(InvenReportModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/*  64 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  65 */     List<InvenReportModel> list = (List<InvenReportModel>)out.get("V_DATASET");
/*  66 */     return list;
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
/*     */   public List<InvenReportChildModel> spGetLogisticInvenReport(Integer storehouseId, String productType, String fieldSort, String direction, Date fromDate, Date toDate) {
/*  81 */     this
/*     */ 
/*     */       
/*  84 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_logistic_inven_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(InvenReportChildModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_TYPE", productType).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/*  94 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  95 */     List<InvenReportChildModel> list = (List<InvenReportChildModel>)out.get("V_DATASET");
/*     */     
/*  97 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<SupplierReportModel> spGetSupplierParentReport(Integer storehouseId, Date fromDate, Date toDate) {
/* 103 */     this
/*     */ 
/*     */       
/* 106 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_supplier_parent_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(SupplierReportModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 113 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 114 */     List<SupplierReportModel> list = (List<SupplierReportModel>)out.get("V_DATASET");
/*     */     
/* 116 */     return list;
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
/*     */   public List<SupplierReportChildModel> spGetSupplierReport(Integer storehouseId, String productSrcCode, Date fromDate, Date toDate) {
/* 128 */     this
/*     */ 
/*     */       
/* 131 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_supplier_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(SupplierReportChildModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_SRC_CODE", productSrcCode).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 139 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 140 */     List<SupplierReportChildModel> list = (List<SupplierReportChildModel>)out.get("V_DATASET");
/*     */     
/* 142 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MedicExaminationReport> spGetMedicExaminationReport(Date fromDate, Date toDate) {
/* 152 */     this
/*     */ 
/*     */       
/* 155 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_medic_examination_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicExaminationReport.class));
/*     */ 
/*     */ 
/*     */     
/* 159 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 161 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 162 */     List<MedicExaminationReport> list = (List<MedicExaminationReport>)out.get("V_DATASET");
/*     */     
/* 164 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ReportModel> getInvenReportDetail(Integer storehouseId, Integer productId, Date fromDate, Date toDate, String fieldSort, String direction) {
/* 174 */     this
/*     */ 
/*     */       
/* 177 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_store_house_inven_report_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ReportModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_ID", productId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 187 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 188 */     List<ReportModel> list = (List<ReportModel>)out.get("V_DATASET");
/*     */     
/* 190 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PatientProduct> spGetProductInven(Set<Integer> ticketIds, Integer invenId) {
/* 196 */     String pTicketIds = (ticketIds.size() > 0) ? String.join(",", new CharSequence[] { String.valueOf(ticketIds) }) : null;
/* 197 */     if (StringUtils.isNotBlank(pTicketIds)) {
/* 198 */       pTicketIds = pTicketIds.replaceAll("[\\[\\]]", "");
/*     */     }
/* 200 */     this
/*     */ 
/*     */       
/* 203 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_patient_product").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PatientProduct.class));
/*     */ 
/*     */ 
/*     */     
/* 207 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_IDS", pTicketIds).addValue("P_INVEN_ID", invenId);
/*     */     
/* 209 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 210 */     List<PatientProduct> list = (List<PatientProduct>)out.get("V_DATASET");
/*     */     
/* 212 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MedicCheckinRecordHis> getMedicCheckinRecordHis(Integer checkinId) {
/* 218 */     this
/*     */ 
/*     */       
/* 221 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_checkin_record_his").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordHis.class));
/*     */ 
/*     */     
/* 224 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*     */     
/* 226 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 227 */     List<MedicCheckinRecordHis> list = (List<MedicCheckinRecordHis>)out.get("V_DATASET");
/*     */     
/* 229 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CheckinPrintFormResponse> printFormResponses(int checkinId) {
/* 235 */     this
/*     */ 
/*     */       
/* 238 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_checkin_registration").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinPrintFormResponse.class));
/*     */     
/* 240 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", Integer.valueOf(checkinId));
/* 241 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 242 */     List<CheckinPrintFormResponse> list = (List<CheckinPrintFormResponse>)out.get("V_DATASET");
/* 243 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CheckinPrintFormResponse> spGetPayment(int fundLog, String orderType) {
/* 250 */     this
/*     */ 
/*     */       
/* 253 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_payment").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinPrintFormResponse.class));
/*     */ 
/*     */     
/* 256 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FUND_LOG", Integer.valueOf(fundLog)).addValue("P_ORDER_TYPE", orderType);
/* 257 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 258 */     List<CheckinPrintFormResponse> list = (List<CheckinPrintFormResponse>)out.get("V_DATASET");
/* 259 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CheckinPrintFormResponse> spReExamination(int mdId) {
/* 264 */     this
/*     */ 
/*     */       
/* 267 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_re_examination").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinPrintFormResponse.class));
/*     */     
/* 269 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_RECORD", Integer.valueOf(mdId));
/*     */     
/* 271 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 272 */     List<CheckinPrintFormResponse> list = (List<CheckinPrintFormResponse>)out.get("V_DATASET");
/* 273 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CheckinPrintFormResponse> spGetExamination(int mdId) {
/* 278 */     this
/*     */ 
/*     */       
/* 281 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_examination").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinPrintFormResponse.class));
/*     */     
/* 283 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_RECORD", Integer.valueOf(mdId));
/*     */     
/* 285 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 286 */     List<CheckinPrintFormResponse> list = (List<CheckinPrintFormResponse>)out.get("V_DATASET");
/* 287 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CheckinPrintFormResponse> sp_get_kq_cdha(int ticketId) {
/* 292 */     this
/*     */ 
/*     */       
/* 295 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_kq_cdha").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinPrintFormResponse.class));
/*     */     
/* 297 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", Integer.valueOf(ticketId));
/*     */     
/* 299 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 300 */     List<CheckinPrintFormResponse> list = (List<CheckinPrintFormResponse>)out.get("V_DATASET");
/* 301 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PrintFormCDHAResponse> sp_get_kq_cdha_response(int ticketId) {
/* 306 */     this
/*     */ 
/*     */       
/* 309 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_kq_cdha").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PrintFormCDHAResponse.class));
/*     */     
/* 311 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", Integer.valueOf(ticketId));
/*     */     
/* 313 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 314 */     List<PrintFormCDHAResponse> list = (List<PrintFormCDHAResponse>)out.get("V_DATASET");
/* 315 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GetPhieuChiDinhModel getPhieuChiDinhDv(Integer ticketId, Integer mdId) {
/* 321 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 327 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_phieu_chi_dinh_dv").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TicketModel.class)).returningResultSet("r4", (RowMapper)new BeanPropertyRowMapper(OrderServiceModel.class));
/*     */ 
/*     */ 
/*     */     
/* 331 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId).addValue("P_MDID", mdId);
/*     */     
/* 333 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 334 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 335 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 336 */     List<TicketModel> ticketRes = (List<TicketModel>)out.get("r3");
/* 337 */     List<OrderServiceModel> orderServiceRes = (List<OrderServiceModel>)out.get("r4");
/*     */     
/* 339 */     GetPhieuChiDinhModel specifyVotes = new GetPhieuChiDinhModel();
/* 340 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 341 */     specifyVotes.setCustomerModel(customerRes);
/* 342 */     specifyVotes.setTicketModel(ticketRes);
/* 343 */     specifyVotes.setOrderServiceModel(orderServiceRes);
/*     */     
/* 345 */     return specifyVotes;
/*     */   }
/*     */ 
/*     */   
/*     */   public GetPhieuChiDinhModel getPhieuKetQuaXetNhiem(Integer ticketId, Integer mdId) {
/* 350 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 356 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_phieu_kq_xet_nghiem").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TicketModel.class)).returningResultSet("r4", (RowMapper)new BeanPropertyRowMapper(OrderServiceModel.class));
/*     */ 
/*     */ 
/*     */     
/* 360 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId).addValue("P_MDID", mdId);
/*     */     
/* 362 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 363 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 364 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 365 */     List<TicketModel> ticketRes = (List<TicketModel>)out.get("r3");
/* 366 */     List<OrderServiceModel> orderServiceResSH = (List<OrderServiceModel>)out.get("r4");
/*     */ 
/*     */     
/* 369 */     GetPhieuChiDinhModel specifyVotes = new GetPhieuChiDinhModel();
/* 370 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 371 */     specifyVotes.setCustomerModel(customerRes);
/* 372 */     specifyVotes.setTicketModel(ticketRes);
/* 373 */     specifyVotes.setOrderServiceModel(orderServiceResSH);
/*     */     
/* 375 */     return specifyVotes;
/*     */   }
/*     */   
/*     */   public TicketInfoModel getTicketInfo(Integer ticketId) {
/* 379 */     this
/*     */ 
/*     */       
/* 382 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_loai_phieu").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(TicketInfoModel.class));
/*     */     
/* 384 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*     */     
/* 386 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 387 */     List<TicketInfoModel> ticketInfoModels = (List<TicketInfoModel>)out.get("r1");
/* 388 */     if (!ticketInfoModels.isEmpty()) return ticketInfoModels.get(0); 
/* 389 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OrderServiceModel> sp_get_phieu_kq_xet_nghiem_dv_con(OrderServiceModel orderService) {
/* 394 */     this
/*     */ 
/*     */       
/* 397 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_phieu_kq_xet_nghiem_dv_con").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(OrderServiceModel.class));
/*     */     
/* 399 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_SERVICE_ID", orderService.getId());
/*     */     
/* 401 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 402 */     List<OrderServiceModel> list = (List<OrderServiceModel>)out.get("V_DATASET");
/* 403 */     if (!list.isEmpty()) {
/* 404 */       for (OrderServiceModel x : list) {
/* 405 */         x.setServiceTypeId(orderService.getServiceTypeId());
/*     */       }
/*     */     }
/* 408 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ResultTimeModel> sp_get_result_time_and_barCode(int ticketId) {
/* 413 */     this
/*     */ 
/*     */       
/* 416 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_result_time_and_barCode").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ResultTimeModel.class));
/*     */     
/* 418 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", Integer.valueOf(ticketId));
/*     */     
/* 420 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 421 */     List<ResultTimeModel> list = (List<ResultTimeModel>)out.get("V_DATASET");
/* 422 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FinancialReportModel> sp_get_financial_report(Date fromDate, Date toDate) {
/* 428 */     this
/*     */ 
/*     */       
/* 431 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_financial_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(FinancialReportModel.class));
/*     */ 
/*     */     
/* 434 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TO_DATE", toDate).addValue("P_FROM_DATE", fromDate);
/*     */     
/* 436 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 437 */     List<FinancialReportModel> list = (List<FinancialReportModel>)out.get("V_DATASET");
/* 438 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ExaminationReport> spGetExaminationReport(Date fromDate, Date toDate) {
/* 443 */     this
/*     */ 
/*     */       
/* 446 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_examination_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ExaminationReport.class));
/*     */ 
/*     */     
/* 449 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 451 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 452 */     List<ExaminationReport> list = (List<ExaminationReport>)out.get("V_DATASET");
/* 453 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ExaminationXNReport> spGetExaminationXNReport(Date fromDate, Date toDate) {
/* 458 */     this
/*     */ 
/*     */       
/* 461 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_xn_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ExaminationXNReport.class));
/*     */ 
/*     */     
/* 464 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 466 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 467 */     List<ExaminationXNReport> list = (List<ExaminationXNReport>)out.get("#result-set-2");
/* 468 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PaymentReport> spGetPaymentReport(Date fromDate, Date toDate) {
/* 473 */     this
/*     */ 
/*     */       
/* 476 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_payment_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PaymentReport.class));
/*     */ 
/*     */     
/* 479 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 481 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 482 */     List<PaymentReport> list = (List<PaymentReport>)out.get("V_DATASET");
/* 483 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ExaminationCDHAReport> spExaminationCDHAReport(Date fromDate, Date toDate) {
/* 488 */     this
/*     */ 
/*     */       
/* 491 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_kq_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ExaminationCDHAReport.class));
/*     */ 
/*     */     
/* 494 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 496 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 497 */     List<ExaminationCDHAReport> list = (List<ExaminationCDHAReport>)out.get("#result-set-2");
/* 498 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CheckinReport> spCheckinReport(Date fromDate, Date toDate) {
/* 503 */     this
/*     */ 
/*     */       
/* 506 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_checkin_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(CheckinReport.class));
/*     */ 
/*     */     
/* 509 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 511 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 512 */     List<CheckinReport> list = (List<CheckinReport>)out.get("V_DATASET");
/* 513 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public GetPhieuRaVienModel sp_get_hospital_checkout(Integer mdId) {
/* 518 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 523 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_hospital_checkout").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(ExaminationResultsModel.class));
/*     */ 
/*     */     
/* 526 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId);
/*     */     
/* 528 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 529 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 530 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 531 */     List<ExaminationResultsModel> examinationResult = (List<ExaminationResultsModel>)out.get("r3");
/*     */ 
/*     */     
/* 534 */     GetPhieuRaVienModel specifyVotes = new GetPhieuRaVienModel();
/* 535 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 536 */     specifyVotes.setCustomerModel(customerRes);
/* 537 */     specifyVotes.setExaminationResults(examinationResult);
/*     */ 
/*     */     
/* 540 */     return specifyVotes;
/*     */   }
/*     */ 
/*     */   
/*     */   public GetPhieuChiDinhModel sp_get_payout_statement(Integer mdId) {
/* 545 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 551 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_payout_statement").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TicketModel.class)).returningResultSet("r4", (RowMapper)new BeanPropertyRowMapper(OrderServiceModel.class));
/*     */ 
/*     */     
/* 554 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId);
/*     */     
/* 556 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 557 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 558 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 559 */     List<TicketModel> ticketRes = (List<TicketModel>)out.get("r3");
/* 560 */     List<OrderServiceModel> orderServiceRes = (List<OrderServiceModel>)out.get("r4");
/*     */     
/* 562 */     GetPhieuChiDinhModel specifyVotes = new GetPhieuChiDinhModel();
/* 563 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 564 */     specifyVotes.setCustomerModel(customerRes);
/* 565 */     specifyVotes.setTicketModel(ticketRes);
/* 566 */     specifyVotes.setOrderServiceModel(orderServiceRes);
/*     */     
/* 568 */     return specifyVotes;
/*     */   }
/*     */   
/*     */   public PtttInfo spGetPtttInfo(Integer ticketId, Integer orderServiceId) {
/* 572 */     this
/*     */ 
/*     */       
/* 575 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_pttt_info").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PtttInfo.class));
/*     */ 
/*     */ 
/*     */     
/* 579 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId).addValue("P_ORDER_SERVICE_ID", orderServiceId);
/*     */     
/* 581 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 582 */     List<PtttInfo> ptttInfos = (List<PtttInfo>)out.get("V_DATASET");
/*     */     
/* 584 */     return (ptttInfos != null && ptttInfos.size() > 0) ? ptttInfos.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ProductSupplierResponse> searchProductSupplier(int page, int size, String searchValue, String fieldSort, String direction, Integer status) {
/*     */     try {
/* 590 */       this
/*     */ 
/*     */         
/* 593 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_product_supplier").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ProductSupplierResponse.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 600 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue).addValue("P_STATUS", status);
/* 601 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 602 */       List<ProductSupplierResponse> list = (List<ProductSupplierResponse>)out.get("V_DATASET");
/* 603 */       return list;
/* 604 */     } catch (Exception e) {
/* 605 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DrugVendorsResponse> spGetSearchDrugVendors(int page, int size, String searchValue, String fieldSort, String direction, Integer status) {
/*     */     try {
/* 612 */       this
/*     */ 
/*     */         
/* 615 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_search_drug_vendors").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(DrugVendorsResponse.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 622 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_SEARCH_VALUE", searchValue).addValue("P_STATUS", status);
/* 623 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 624 */       List<DrugVendorsResponse> list = (List<DrugVendorsResponse>)out.get("V_DATASET");
/* 625 */       return list;
/* 626 */     } catch (Exception e) {
/* 627 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map<String, Object>> getReportDynamicData(String rpSql, Map<String, String> variables, List<DynamicReportVariable> dynamicReportVariables) throws ParseException {
/* 634 */     String sql = formatWithNamedPlaceholders(rpSql, variables, dynamicReportVariables);
/* 635 */     this.logger.info("getReportDynamicData: " + sql);
/* 636 */     return this.jdbcTemplate.queryForList(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String formatWithNamedPlaceholders(String format, Map<String, String> arguments, List<DynamicReportVariable> dynamicReportVariables) throws ParseException {
/* 643 */     String formattedString = format;
/* 644 */     SimpleDateFormat inputDateFm = new SimpleDateFormat("dd/MM/yyyy");
/* 645 */     SimpleDateFormat outDateFm = new SimpleDateFormat("yyyy-MM-dd");
/*     */     
/* 647 */     for (Map.Entry<String, String> entry : arguments.entrySet()) {
/* 648 */       String placeholder = "{" + (String)entry.getKey() + "}";
/* 649 */       String value = StringUtils.isNotBlank(entry.getValue()) ? entry.getValue() : "null";
/* 650 */       for (DynamicReportVariable dynamicReportVariable : dynamicReportVariables) {
/* 651 */         if (dynamicReportVariable.getRpVarType().equals(ReportVarType.datetime.name()) && dynamicReportVariable
/* 652 */           .getRpVarCode().equals(entry.getKey()) && 
/* 653 */           !value.equals("null"))
/*     */         {
/* 655 */           value = outDateFm.format(inputDateFm.parse(value));
/*     */         }
/*     */       } 
/*     */       
/* 659 */       formattedString = formattedString.replace(placeholder, getAppearValue(value));
/*     */     } 
/*     */     
/* 662 */     return formattedString;
/*     */   }
/*     */   
/*     */   private String getAppearValue(String value) {
/* 666 */     if (value.equals("null"))
/* 667 */       return "''"; 
/* 668 */     String[] strings = value.split("[,;]");
/*     */     try {
/* 670 */       for (String string : strings) {
/* 671 */         Integer.parseInt(string);
/*     */       }
/* 673 */       return value;
/* 674 */     } catch (Exception e) {
/* 675 */       return "'" + value + "'";
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> getVariableData(String sql) {
/*     */     List<Map<String, Object>> result;
/*     */     try {
/* 682 */       result = this.jdbcTemplate.queryForList(sql);
/* 683 */     } catch (Exception e) {
/* 684 */       e.printStackTrace();
/* 685 */       result = null;
/*     */     } 
/* 687 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DynamicReport> spGetDynamicReport(Integer userId, String searchValue, int page, int size) {
/*     */     try {
/* 694 */       this
/*     */ 
/*     */         
/* 697 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_dynamic_report").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(DynamicReport.class));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 702 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_USER_ID", userId);
/* 703 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*     */       
/* 705 */       List<DynamicReport> list = (List<DynamicReport>)out.get("V_DATASET");
/*     */       
/* 707 */       return list;
/* 708 */     } catch (Exception e) {
/* 709 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LableMedicModel sp_get_medic_product_order_detail(Integer id) {
/*     */     try {
/* 717 */       this
/*     */ 
/*     */         
/* 720 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_product_order_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LableMedicModel.class));
/*     */       
/* 722 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ID", id);
/* 723 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*     */       
/* 725 */       List<LableMedicModel> list = (List<LableMedicModel>)out.get("V_DATASET");
/*     */       
/* 727 */       return (list != null && list.size() > 0) ? list.get(0) : null;
/* 728 */     } catch (Exception e) {
/* 729 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<LableMedicModel> sp_get_all_medic_product_order_detail(Integer orderId) {
/*     */     try {
/* 737 */       this
/*     */ 
/*     */         
/* 740 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_all_medic_product_order_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(LableMedicModel.class));
/*     */       
/* 742 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("ORDER_ID", orderId);
/* 743 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*     */       
/* 745 */       List<LableMedicModel> list = (List<LableMedicModel>)out.get("V_DATASET");
/*     */       
/* 747 */       return list;
/* 748 */     } catch (Exception e) {
/* 749 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetPhieuTuVongModel getPhieuTuVong(Integer mdId) {
/* 757 */     this
/*     */ 
/*     */ 
/*     */       
/* 761 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_report_death").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class));
/*     */ 
/*     */ 
/*     */     
/* 765 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId);
/*     */     
/* 767 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 768 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 769 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/*     */     
/* 771 */     GetPhieuTuVongModel specifyVotes = new GetPhieuTuVongModel();
/* 772 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 773 */     specifyVotes.setCustomerModel(customerRes);
/*     */     
/* 775 */     return specifyVotes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PhieuDieuTriModel getPhieuDieuTri(Integer mdId, Integer id) {
/* 781 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 786 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_report_treatment_detail").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TreatmentDetailModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 791 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId).addValue("P_ID", id);
/*     */     
/* 793 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 794 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 795 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 796 */     List<TreatmentDetailModel> treatmentDetailModels = (List<TreatmentDetailModel>)out.get("r3");
/*     */     
/* 798 */     PhieuDieuTriModel specifyVotes = new PhieuDieuTriModel();
/* 799 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 800 */     specifyVotes.setCustomerModel(customerRes);
/* 801 */     specifyVotes.setTreatmentDetailModels(treatmentDetailModels);
/*     */     
/* 803 */     return specifyVotes;
/*     */   }
/*     */   
/*     */   public PhieuDieuTriModel getPhieuDieuTriDateFromTo(Integer mdId, String f, String t) {
/* 807 */     Date fromDate = DataUtil.safeToDate2(f);
/* 808 */     Date toDate = DataUtil.safeToDate2(t);
/* 809 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 814 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_report_treatment_detail_from_to").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TreatmentDetailModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 820 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 822 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 823 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 824 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 825 */     List<TreatmentDetailModel> treatmentDetailModels = (List<TreatmentDetailModel>)out.get("r3");
/*     */     
/* 827 */     PhieuDieuTriModel specifyVotes = new PhieuDieuTriModel();
/* 828 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 829 */     specifyVotes.setCustomerModel(customerRes);
/* 830 */     specifyVotes.setTreatmentDetailModels(treatmentDetailModels);
/*     */     
/* 832 */     return specifyVotes;
/*     */   }
/*     */ 
/*     */   
/*     */   public MedicCheckinLive spGetLiveFunction(Integer mdId, Date fromDate, Date toDate) {
/* 837 */     MedicCheckinLive medicCheckinLive = new MedicCheckinLive();
/* 838 */     List<MedicCheckinLiveDetailModel> medicCheckinLiveDetailModels = new ArrayList<>();
/* 839 */     this
/*     */ 
/*     */ 
/*     */       
/* 843 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_live_fuction").returningResultSet("return1", (RowMapper)new BeanPropertyRowMapper(MedicCheckinLiveDetailModel.class)).returningResultSet("return2", (RowMapper)new ColumnMapRowMapper());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 849 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 851 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 852 */     medicCheckinLiveDetailModels = (List<MedicCheckinLiveDetailModel>)out.get("return1");
/* 853 */     List<Map<String, Object>> cusRs = (List<Map<String, Object>>)out.get("return2");
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
/* 872 */     medicCheckinLive.setCustomerData((cusRs != null && cusRs.size() > 0) ? cusRs.get(0) : null);
/* 873 */     medicCheckinLive.setMedicCheckinLiveMerges(medicCheckinLiveDetailModels);
/* 874 */     return medicCheckinLive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> getBenhAN(Integer mdId) {
/* 880 */     this
/*     */ 
/*     */       
/* 883 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medical_record").returningResultSet("r1", (RowMapper)new ColumnMapRowMapper());
/*     */ 
/*     */ 
/*     */     
/* 887 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MDID", mdId);
/*     */     
/* 889 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 890 */     List<Map<String, Object>> medicCheckinMedicalRecords = (List<Map<String, Object>>)out.get("r1");
/*     */     
/* 892 */     return (medicCheckinMedicalRecords != null) ? medicCheckinMedicalRecords.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public GetPhieuChiDinhModel sp_get_payout_statement_by_checkin(Integer checkinId) {
/* 897 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 903 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_payout_statement_by_checkin").returningResultSet("r1", (RowMapper)new BeanPropertyRowMapper(MdmHeaderModel.class)).returningResultSet("r2", (RowMapper)new BeanPropertyRowMapper(CustomerModel.class)).returningResultSet("r3", (RowMapper)new BeanPropertyRowMapper(TicketModel.class)).returningResultSet("r4", (RowMapper)new BeanPropertyRowMapper(OrderServiceModel.class));
/*     */ 
/*     */     
/* 906 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*     */     
/* 908 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 909 */     List<MdmHeaderModel> headerModels = (List<MdmHeaderModel>)out.get("r1");
/* 910 */     List<CustomerModel> customerRes = (List<CustomerModel>)out.get("r2");
/* 911 */     List<TicketModel> ticketRes = (List<TicketModel>)out.get("r3");
/* 912 */     List<OrderServiceModel> orderServiceRes = (List<OrderServiceModel>)out.get("r4");
/*     */     
/* 914 */     GetPhieuChiDinhModel specifyVotes = new GetPhieuChiDinhModel();
/* 915 */     specifyVotes.setMdmHeaderModel(headerModels);
/* 916 */     specifyVotes.setCustomerModel(customerRes);
/* 917 */     specifyVotes.setTicketModel(ticketRes);
/* 918 */     specifyVotes.setOrderServiceModel(orderServiceRes);
/*     */     
/* 920 */     return specifyVotes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Repository\CommonReportRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */