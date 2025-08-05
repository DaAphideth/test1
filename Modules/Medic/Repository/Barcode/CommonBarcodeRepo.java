/*    */ package nencer.app.Modules.Medic.Repository.Barcode;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
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
/*    */ @Repository
/*    */ public class CommonBarcodeRepo
/*    */ {
/*    */   @Autowired
/*    */   JdbcTemplate jdbcTemplate;
/*    */   @Autowired
/*    */   public Environment env;
/*    */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*    */   
/*    */   public Integer fnGenerateBarcode(Integer max) {
/* 27 */     this
/*    */       
/* 29 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withFunctionName("fn_generate_barcode");
/*    */ 
/*    */     
/* 32 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_MAX_NUM", max);
/*    */     
/* 34 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 35 */     Integer number = (Integer)out.get("return");
/*    */     
/* 37 */     return number;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Barcode\CommonBarcodeRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */