/*    */ package nencer.app.Modules.Medic.Repository.Treatment;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import nencer.app.Modules.Storehouse.Model.StoreHouseCardModel;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.jdbc.core.RowMapper;
/*    */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*    */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*    */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Repository
/*    */ public class CommonTreatmentRepo
/*    */ {
/*    */   @Autowired
/*    */   JdbcTemplate jdbcTemplate;
/*    */   @Autowired
/*    */   public Environment env;
/*    */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*    */   
/*    */   public List<StoreHouseCardModel> spGetTreatmentReturnInven(Integer ticketId) {
/* 34 */     this
/*    */ 
/*    */       
/* 37 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_treatment_return_inven").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*    */ 
/*    */     
/* 40 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*    */ 
/*    */     
/* 43 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 44 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*    */     
/* 46 */     return list;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<StoreHouseCardModel> spGetTreatmentReturned(Integer ticketId) {
/* 51 */     this
/*    */ 
/*    */       
/* 54 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_treatment_returned").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*    */ 
/*    */     
/* 57 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_TICKET_ID", ticketId);
/*    */ 
/*    */     
/* 60 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 61 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*    */     
/* 63 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Treatment\CommonTreatmentRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */