/*     */ package nencer.app.Modules.Medic.Repository.Checkin;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Entity.Insurance.MedicInsuranceCards;
/*     */ import nencer.app.Modules.Medic.Model.OrderService.MedicOrderServiceDetail;
/*     */ import nencer.app.Modules.Medic.Model.bhyt.MedicOrderServiceBhyt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Repository
/*     */ public class CommonBhytRepo
/*     */ {
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   @Autowired
/*     */   public Environment env;
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */   
/*     */   public List<MedicOrderServiceDetail> getOrderServiceByCheckinId(Integer checkinId) {
/*  41 */     this
/*     */ 
/*     */       
/*  44 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_order_service_checkinid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicOrderServiceDetail.class));
/*     */ 
/*     */     
/*  47 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*     */     
/*  49 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  50 */     List<MedicOrderServiceDetail> list = (List<MedicOrderServiceDetail>)out.get("V_DATASET");
/*     */     
/*  52 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicInsuranceCards spGetMedicInsuranceCards(Integer checkinId) {
/*  59 */     this
/*     */ 
/*     */       
/*  62 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_medic_insurance_cards").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicInsuranceCards.class));
/*     */ 
/*     */     
/*  65 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_CHECKIN_ID", checkinId);
/*     */     
/*  67 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  68 */     List<MedicInsuranceCards> list = (List<MedicInsuranceCards>)out.get("V_DATASET");
/*     */     
/*  70 */     return (list != null && list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer fnGetMedicInsuranceCards(String pInsuranceCode, String pBenefitCode) {
/*  76 */     this
/*     */ 
/*     */       
/*  79 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("fn_get_insurence_benefit_rate").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Integer.class));
/*     */ 
/*     */ 
/*     */     
/*  83 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_INSURANCE_CODE", pInsuranceCode).addValue("P_BENEFIT_CODE", pBenefitCode);
/*     */ 
/*     */     
/*  86 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  87 */     Integer benefitRate = (Integer)out.get("V_DATASET");
/*     */     
/*  89 */     return benefitRate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MedicOrderServiceBhyt> spGetOrderPaidByIds(List<Integer> serviceOrderIds, List<Integer> productOrderIds) {
/*  96 */     String serviceOrderIdsStr = (serviceOrderIds.size() > 0) ? String.join(",", new CharSequence[] { String.valueOf(serviceOrderIds) }) : null;
/*  97 */     String productOrderIdsStr = (productOrderIds.size() > 0) ? String.join(",", new CharSequence[] { String.valueOf(productOrderIds) }) : null;
/*     */     
/*  99 */     if (StringUtils.isNotBlank(serviceOrderIdsStr)) {
/* 100 */       serviceOrderIdsStr = serviceOrderIdsStr.replaceAll("[\\[\\]]", "");
/*     */     }
/*     */     
/* 103 */     if (StringUtils.isNotBlank(productOrderIdsStr)) {
/* 104 */       productOrderIdsStr = productOrderIdsStr.replaceAll("[\\[\\]]", "");
/*     */     }
/*     */     
/* 107 */     this
/*     */ 
/*     */       
/* 110 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_order_paid_by_ids").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(MedicOrderServiceBhyt.class));
/*     */ 
/*     */ 
/*     */     
/* 114 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("SERVICE_ORDER_IDS", serviceOrderIdsStr).addValue("PRODUCT_ORDER_IDS", productOrderIdsStr);
/*     */     
/* 116 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 117 */     List<MedicOrderServiceBhyt> list = (List<MedicOrderServiceBhyt>)out.get("V_DATASET");
/*     */     
/* 119 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\CommonBhytRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */