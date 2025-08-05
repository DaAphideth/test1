/*    */ package nencer.app.Modules.Medic.Repository.Payment;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import nencer.app.Modules.Medic.Model.Payment.PaymentAmount;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Repository
/*    */ public class CommonPaymentRepo
/*    */ {
/*    */   @Autowired
/*    */   JdbcTemplate jdbcTemplate;
/*    */   @Autowired
/*    */   public Environment env;
/*    */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*    */   
/*    */   public PaymentAmount getMedicPaymentAmount(Integer checkinId) {
/* 38 */     this
/*    */ 
/*    */       
/* 41 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_payment_amount").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PaymentAmount.class));
/*    */ 
/*    */     
/* 44 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*    */ 
/*    */     
/* 47 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 48 */     List<PaymentAmount> list = (List<PaymentAmount>)out.get("V_DATASET");
/* 49 */     PaymentAmount paymentAmount = (list.size() > 0) ? list.get(0) : null;
/* 50 */     return paymentAmount;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Payment\CommonPaymentRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */