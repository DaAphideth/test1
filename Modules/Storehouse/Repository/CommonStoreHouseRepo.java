/*     */ package nencer.app.Modules.Storehouse.Repository;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.ProductTicket;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicStorehouseInven;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderCategory;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Modules.Storehouse.Model.ProductOrderCusModel;
/*     */ import nencer.app.Modules.Storehouse.Model.ProductTreatmentDetailModel;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.JdbcTemplate;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*     */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*     */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*     */ import org.springframework.stereotype.Repository;
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
/*     */ @Repository
/*     */ public class CommonStoreHouseRepo
/*     */ {
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   @Autowired
/*     */   public Environment env;
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */   
/*     */   public List<MedicProductOrderModel> getProductOrderSp(Integer userId, String searchValue, String shType, Integer storehouseId, String orderStatus, String orderType, Date fromDate, Date toDate, String fieldSort, String direction, int page, int size) {
/*  49 */     this
/*     */ 
/*     */       
/*  52 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
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
/*  66 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USERID", DataUtil.safeToString2(userId)).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_SH_TYPE", DataUtil.safeToString2(shType)).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_ORDER_STATUS", DataUtil.safeToString2(orderStatus)).addValue("P_PRODUCT_ORDER_TYPE", DataUtil.safeToString2(orderType)).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/*  68 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  69 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/*  70 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderDetailModel> getProductOrderDetailSp(Integer orderId) {
/*  75 */     return getProductOrderDetailsProcess(orderId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderModel> getProductOrderCashSp(Integer checkinId, Integer fundLogId) {
/*  81 */     this
/*     */ 
/*     */       
/*  84 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_cash").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */ 
/*     */     
/*  88 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId).addValue("P_FUND_LOG_ID", fundLogId);
/*     */     
/*  90 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  91 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/*  92 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderModel> getProductOrderCashSpViewPayment(Integer checkinId, Integer fundLogId) {
/*  97 */     this
/*     */ 
/*     */       
/* 100 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_cash_view_payment").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */ 
/*     */     
/* 104 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId).addValue("P_FUND_LOG_ID", fundLogId);
/*     */     
/* 106 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 107 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 108 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderModel> getProductOrderCashLeSp(Integer fundLogId) {
/* 113 */     this
/*     */ 
/*     */       
/* 116 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_cash_le").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */     
/* 119 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_FUND_LOG_ID", fundLogId);
/*     */     
/* 121 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 122 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 123 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicProductOrderModel getProductOrderExoprtSp(Integer ticketId) {
/* 129 */     this
/*     */ 
/*     */       
/* 132 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_export").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */     
/* 135 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*     */     
/* 137 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 138 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 139 */     return (list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public MedicProductOrderModel getProductOrderExoprtSp1(Integer id) {
/* 144 */     this
/*     */ 
/*     */       
/* 147 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_export1").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */     
/* 150 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ID", id);
/*     */     
/* 152 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 153 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 154 */     return (list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderCategory> getProductOrderCategorySp(String orderType, Date fromDateD, Date toDateD) {
/* 159 */     this
/*     */ 
/*     */       
/* 162 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_category").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderCategory.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_TYPE", orderType).addValue("P_FROM_DATE", fromDateD).addValue("P_TO_DATE", toDateD);
/*     */     
/* 169 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 170 */     List<MedicProductOrderCategory> list = (List<MedicProductOrderCategory>)out.get("V_DATASET");
/* 171 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ProductOrderCusModel> getProductOrderCustomerSp(String searchValue, Integer storehouseId, Date fromDate, Date toDate, String fieldSort, String direction, int page, int size) {
/* 182 */     this
/*     */ 
/*     */       
/* 185 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_cus").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ProductOrderCusModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/* 197 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 198 */     List<ProductOrderCusModel> list = (List<ProductOrderCusModel>)out.get("V_DATASET");
/* 199 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrder> getMedicProductPaidSp(Integer orderId) {
/* 204 */     this
/*     */ 
/*     */       
/* 207 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_product_paid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrder.class));
/*     */ 
/*     */     
/* 210 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_ID", orderId);
/*     */     
/* 212 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 213 */     List<MedicProductOrder> list = (List<MedicProductOrder>)out.get("V_DATASET");
/* 214 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicMasterData> getAllOrderTypeSp(Integer storehouseId, String lang) {
/* 219 */     this
/*     */ 
/*     */       
/* 222 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_all_order_type_sp").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicMasterData.class));
/*     */ 
/*     */ 
/*     */     
/* 226 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_LANG", lang);
/*     */     
/* 228 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 229 */     List<MedicMasterData> list = (List<MedicMasterData>)out.get("V_DATASET");
/* 230 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductStorehouse> spGetProductStorehouse(String storehouseTypeCodes, Integer userId, Integer roomId) {
/* 235 */     this
/*     */ 
/*     */       
/* 238 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_store_house").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductStorehouse.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STOREHOUSE_TYPE_CODES", storehouseTypeCodes).addValue("P_USER_ID", DataUtil.safeToString2(userId)).addValue("P_ROOM_TREATMENT_ID", roomId);
/*     */     
/* 245 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 246 */     List<MedicProductStorehouse> list = (List<MedicProductStorehouse>)out.get("V_DATASET");
/* 247 */     return list;
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
/*     */   public List<MedicProductStorehouse> spSerchProductStorehouse(String searchValue, Integer storehouseId, Integer status, String fieldSort, String direction, int page, int size) {
/* 260 */     this
/*     */ 
/*     */       
/* 263 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_product_store_house").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductStorehouse.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", searchValue).addValue("P_STOREHOUSE_ID", storehouseId).addValue("P_STATUS", status).addValue("P_FIELDSORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/* 274 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 275 */     List<MedicProductStorehouse> list = (List<MedicProductStorehouse>)out.get("V_DATASET");
/* 276 */     return list;
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
/*     */   public List<ProductTicket> spGetProductMedicCabinet(String fromDate, String toDate, String orderDateFrom, String orderDateTo, String ticketType, String ticketStatus, String orderType, String searchValue, Integer departmentId, Integer storehouseId, String orderStatus) {
/* 292 */     this
/*     */ 
/*     */       
/* 295 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_medic_cabinet").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ProductTicket.class));
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
/* 308 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_STOREHOUSE_ID", storehouseId).addValue("P_ORDER_DATE_FROM", DataUtil.safeToDate(orderDateFrom)).addValue("P_ORDER_DATE_TO", DataUtil.safeToDate(orderDateTo)).addValue("P_DEPARTMENT_ID", departmentId).addValue("P_FROM_DATE", DataUtil.safeToDate(fromDate)).addValue("P_TO_DATE", DataUtil.safeToDate(toDate)).addValue("P_TICKET_TYPE", DataUtil.safeToString2(ticketType)).addValue("P_TICKET_STATUS", DataUtil.safeToString2(ticketStatus)).addValue("P_ORDER_TYPE", DataUtil.safeToString2(orderType)).addValue("P_ORDER_STATUS", DataUtil.safeToString2(orderStatus));
/*     */ 
/*     */     
/* 311 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 312 */     List<ProductTicket> list = (List<ProductTicket>)out.get("V_DATASET");
/* 313 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicStorehouseInven> spGetInvenNotZeroOrderExpiration(Integer productId, Integer storehouseId) {
/* 318 */     this
/*     */ 
/*     */       
/* 321 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_invennotzero_order_expiration").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicStorehouseInven.class));
/*     */ 
/*     */ 
/*     */     
/* 325 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PRODUCT_ID", productId).addValue("P_STOREHOUSE_ID", storehouseId);
/*     */     
/* 327 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 328 */     List<MedicStorehouseInven> list = (List<MedicStorehouseInven>)out.get("V_DATASET");
/* 329 */     return list;
/*     */   }
/*     */   
/*     */   public List<MedicProductOrderDetailModel> getExportProductOrderDetailSp(Integer orderId) {
/* 333 */     return getProductExportOrderDetailsProcess(orderId, null);
/*     */   }
/*     */   
/*     */   public List<MedicProductOrderDetailModel> getExportProductOrderDetailSpExport(Integer orderId, Integer creatorId) {
/* 337 */     return getProductExportOrderDetailsProcess(orderId, creatorId);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<MedicProductOrderDetailModel> getProductExportOrderDetailsProcess(Integer orderId, Integer creatorId) {
/* 342 */     this
/*     */ 
/*     */       
/* 345 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_export_product_order_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderDetailModel.class));
/*     */ 
/*     */ 
/*     */     
/* 349 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_ID", orderId).addValue("P_CREATOR_ID", creatorId);
/*     */     
/* 351 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 352 */     List<MedicProductOrderDetailModel> list = (List<MedicProductOrderDetailModel>)out.get("V_DATASET");
/* 353 */     return list;
/*     */   }
/*     */   
/*     */   public List<ProductTreatmentDetailModel> getProductTreatmentDetail(Integer ticketId) {
/* 357 */     return sp_get_export_product_order_detail_treatment(ticketId);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<ProductTreatmentDetailModel> sp_get_export_product_order_detail_treatment(Integer ticketId) {
/* 362 */     this
/*     */ 
/*     */       
/* 365 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_export_product_order_detail_treatment").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ProductTreatmentDetailModel.class));
/*     */ 
/*     */     
/* 368 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*     */     
/* 370 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 371 */     List<ProductTreatmentDetailModel> list = (List<ProductTreatmentDetailModel>)out.get("V_DATASET");
/* 372 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public MedicProductOrderModel getProductOrderRetailSp(Integer ticketId) {
/* 377 */     this
/*     */ 
/*     */       
/* 380 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_order_retail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */     
/* 383 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*     */     
/* 385 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 386 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 387 */     return (list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean spCheckProductPayment(Integer orderId) {
/* 393 */     this
/*     */ 
/*     */       
/* 396 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_check_product_payment").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderModel.class));
/*     */ 
/*     */     
/* 399 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_ID", orderId);
/*     */     
/* 401 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 402 */     List<MedicProductOrderModel> list = (List<MedicProductOrderModel>)out.get("V_DATASET");
/* 403 */     return (list != null && list.size() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicProductOrderDetailModel> getProductOrderDetailsProcess(Integer id) {
/*     */     try {
/* 409 */       this
/*     */ 
/*     */         
/* 412 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_product_order_detail2").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicProductOrderDetailModel.class));
/*     */       
/* 414 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_ID", id);
/* 415 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*     */       
/* 417 */       List<MedicProductOrderDetailModel> list = (List<MedicProductOrderDetailModel>)out.get("V_DATASET");
/*     */       
/* 419 */       return list;
/* 420 */     } catch (Exception e) {
/* 421 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\CommonStoreHouseRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */