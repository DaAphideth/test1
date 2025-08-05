/*     */ package nencer.app.Modules.Medic.Repository.Checkin;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordModel;
/*     */ import nencer.app.Modules.Medic.Model.Examination.MedicExaminationResultsRs;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicOrderServiceDetail;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.ProductTicket;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Repository
/*     */ public class CommonTicketRepo
/*     */ {
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   @Autowired
/*     */   public Environment env;
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */   
/*     */   public List<MedicCheckinRecordModel> getCheckinRecordSp(Integer userId, Integer roomId, Integer departmentId, Integer patientId, String searchValue, String customerType, String checkInType, String fromDate, String toDate, String fieldSort, String direction, int page, int size) {
/*  46 */     this
/*     */ 
/*     */       
/*  49 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_checkin_record").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordModel.class));
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
/*  64 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", userId).addValue("P_ROOM_ID", roomId).addValue("P_PATIENT_ID", patientId).addValue("P_SEARCH_VALUE", searchValue).addValue("P_CUSTOMER_TYPE", customerType).addValue("P_DEPARTMENT_ID", departmentId).addValue("P_MD_TYPE", checkInType).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_FIELD_SORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/*  66 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  67 */     List<MedicCheckinRecordModel> list = (List<MedicCheckinRecordModel>)out.get("V_DATASET");
/*     */     
/*  69 */     return list;
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
/*     */   public List<ProductTicket> spGetProductTicketTreatment(String fromDate, String toDate, String orderDateFrom, String orderDateTo, String ticketType, String ticketStatus, String orderType, String searchValue, Integer departmentId, Integer storehouseId, Integer chamberId, String fieldSort, String direction, int page, int size) {
/*  89 */     this
/*     */ 
/*     */       
/*  92 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_ticket_treatment").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(ProductTicket.class));
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
/* 109 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_CHAMBER_ID", chamberId).addValue("P_STOREHOUSE_ID", storehouseId).addValue("P_ORDER_DATE_FROM", DataUtil.safeToDate(orderDateFrom)).addValue("P_ORDER_DATE_TO", DataUtil.safeToDate(orderDateTo)).addValue("P_DEPARTMENT_ID", departmentId).addValue("P_FROM_DATE", DataUtil.safeToDate(fromDate)).addValue("P_TO_DATE", DataUtil.safeToDate(toDate)).addValue("P_FIELD_SORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_TICKET_TYPE", DataUtil.safeToString2(ticketType)).addValue("P_TICKET_STATUS", DataUtil.safeToString2(ticketStatus)).addValue("P_ORDER_TYPE", DataUtil.safeToString2(orderType)).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/* 111 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 112 */     List<ProductTicket> list = (List<ProductTicket>)out.get("V_DATASET");
/*     */     
/* 114 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicOrderServiceDetail> spGetMedicOrderServiceByMdId(Integer mdId) {
/* 119 */     this
/*     */ 
/*     */       
/* 122 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_order_service_by_mdid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicOrderServiceDetail.class));
/*     */ 
/*     */     
/* 125 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId);
/*     */ 
/*     */     
/* 128 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 129 */     List<MedicOrderServiceDetail> list = (List<MedicOrderServiceDetail>)out.get("V_DATASET");
/*     */     
/* 131 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public MedicExaminationResultsRs spGetExaminationByMdId(Integer mdId) {
/* 136 */     this
/*     */ 
/*     */       
/* 139 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_examination_by_mdid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicExaminationResultsRs.class));
/*     */ 
/*     */     
/* 142 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId);
/*     */ 
/*     */     
/* 145 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 146 */     List<MedicExaminationResultsRs> list = (List<MedicExaminationResultsRs>)out.get("V_DATASET");
/*     */     
/* 148 */     return ((((list != null) ? 1 : 0) & ((list.size() > 0) ? 1 : 0)) != 0) ? list.get(0) : null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\CommonTicketRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */