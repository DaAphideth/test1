/*     */ package nencer.app.Modules.Medic.Repository.Checkin;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordHis;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.MedicCheckinRecordModel;
/*     */ import nencer.app.Modules.Medic.Model.Ticket.TicketGroupResponse;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.PatientProduct;
/*     */ import nencer.app.Modules.Medic.Model.Treatment.PatientProductTotal;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ @Repository
/*     */ public class CommonCheckinRepo
/*     */ {
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   @Autowired
/*     */   public Environment env;
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */   
/*     */   public List<MedicCheckinRecordHis> getMedicCheckinRecordHis(Integer checkinId) {
/*  38 */     this
/*     */ 
/*     */       
/*  41 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_checkin_record_his").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordHis.class));
/*     */ 
/*     */     
/*  44 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*     */ 
/*     */     
/*  47 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  48 */     List<MedicCheckinRecordHis> list = (List<MedicCheckinRecordHis>)out.get("V_DATASET");
/*     */     
/*  50 */     return list;
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
/*     */   public List<MedicCheckinRecordModel> getCheckinRecordSp(Integer userId, Integer roomId, String departmentId, Integer patientId, String searchValue, String customerType, String checkInType, String fromDate, String toDate, String fieldSort, String direction, int page, int size) {
/*  67 */     this
/*     */ 
/*     */       
/*  70 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_checkin_record").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordModel.class));
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
/*  85 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", userId).addValue("P_ROOM_ID", roomId).addValue("P_PATIENT_ID", patientId).addValue("P_SEARCH_VALUE", searchValue).addValue("P_CUSTOMER_TYPE", customerType).addValue("P_DEPARTMENT_ID", departmentId).addValue("P_MD_TYPE", checkInType).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate).addValue("P_FIELD_SORT", fieldSort).addValue("P_DIRECTION", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */ 
/*     */     
/*  88 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  89 */     List<MedicCheckinRecordModel> list = (List<MedicCheckinRecordModel>)out.get("V_DATASET");
/*     */     
/*  91 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PatientProductTotal> spGetProductTotalInven(Set<Integer> ticketIds) {
/*  97 */     String pTicketIds = (ticketIds.size() > 0) ? String.join(",", new CharSequence[] { String.valueOf(ticketIds) }) : null;
/*  98 */     if (StringUtils.isNotBlank(pTicketIds)) {
/*  99 */       pTicketIds = pTicketIds.replaceAll("[\\[\\]]", "");
/*     */     }
/* 101 */     this
/*     */ 
/*     */       
/* 104 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_patient_product_total").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PatientProductTotal.class));
/*     */ 
/*     */     
/* 107 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_IDS", pTicketIds);
/*     */     
/* 109 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 110 */     List<PatientProductTotal> list = (List<PatientProductTotal>)out.get("V_DATASET");
/*     */     
/* 112 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PatientProduct> spGetProductInven(Set<Integer> ticketIds, Integer invenId) {
/* 118 */     String pTicketIds = (ticketIds.size() > 0) ? String.join(",", new CharSequence[] { String.valueOf(ticketIds) }) : null;
/* 119 */     if (StringUtils.isNotBlank(pTicketIds)) {
/* 120 */       pTicketIds = pTicketIds.replaceAll("[\\[\\]]", "");
/*     */     }
/* 122 */     this
/*     */ 
/*     */       
/* 125 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_patient_product").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PatientProduct.class));
/*     */ 
/*     */ 
/*     */     
/* 129 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_IDS", pTicketIds).addValue("P_INVEN_ID", invenId);
/*     */     
/* 131 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 132 */     List<PatientProduct> list = (List<PatientProduct>)out.get("V_DATASET");
/*     */     
/* 134 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicTicket> getSolveResult(Integer mdId) {
/* 139 */     this
/*     */ 
/*     */       
/* 142 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_check_solve").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicTicket.class));
/*     */ 
/*     */     
/* 145 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId);
/*     */     
/* 147 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 148 */     List<MedicTicket> list = (List<MedicTicket>)out.get("V_DATASET");
/*     */     
/* 150 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<TicketGroupResponse> getServiceGroupSp(Integer mdId, String ticketType) {
/* 155 */     this
/*     */ 
/*     */       
/* 158 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_service_group_sp").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(TicketGroupResponse.class));
/*     */ 
/*     */ 
/*     */     
/* 162 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId).addValue("P_TICKET_TYPE", ticketType);
/*     */ 
/*     */     
/* 165 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 166 */     List<TicketGroupResponse> list = (List<TicketGroupResponse>)out.get("V_DATASET");
/*     */     
/* 168 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicTicket> getAllTicketByMdIdSp(String ticketType, Integer serviceGroupCode, Integer mdId) {
/* 173 */     this
/*     */ 
/*     */       
/* 176 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_all_ticket_by_md_id_sp").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicTicket.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MD_ID", mdId).addValue("P_TICKET_TYPE", ticketType).addValue("P_SERVICE_GROUP", serviceGroupCode);
/*     */ 
/*     */     
/* 184 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 185 */     List<MedicTicket> list = (List<MedicTicket>)out.get("V_DATASET");
/*     */     
/* 187 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicCheckinRecordHis> getMedicCheckinRecordPatientIdHis(Integer patientId) {
/*     */     try {
/* 193 */       this
/*     */ 
/*     */         
/* 196 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_checkin_record_patient_his").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordHis.class));
/*     */ 
/*     */       
/* 199 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PATIENT_ID", patientId);
/*     */       
/* 201 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 202 */       List<MedicCheckinRecordHis> list = (List<MedicCheckinRecordHis>)out.get("V_DATASET");
/*     */       
/* 204 */       return list;
/*     */     }
/* 206 */     catch (Exception e) {
/* 207 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MedicCheckinRecordHis> getMedicCheckinRecordPatientIdHis1(Integer patientId) {
/*     */     try {
/* 214 */       this
/*     */ 
/*     */         
/* 217 */         .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_checkin_record_patient_his1").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicCheckinRecordHis.class));
/*     */ 
/*     */       
/* 220 */       MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PATIENT_ID", patientId);
/*     */       
/* 222 */       Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 223 */       List<MedicCheckinRecordHis> list = (List<MedicCheckinRecordHis>)out.get("V_DATASET");
/*     */       
/* 225 */       return list;
/*     */     }
/* 227 */     catch (Exception e) {
/* 228 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\CommonCheckinRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */