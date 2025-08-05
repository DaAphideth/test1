/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ import org.modelmapper.ModelMapper;
/*    */ import org.modelmapper.convention.MatchingStrategies;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class ModelMapperConfig
/*    */ {
/*    */   @Bean
/*    */   public ModelMapper modelMapper() {
/* 16 */     ModelMapper modelMapper = new ModelMapper();
/* 17 */     modelMapper.getConfiguration()
/* 18 */       .setMatchingStrategy(MatchingStrategies.STRICT);
/*    */     
/* 20 */     return modelMapper;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\ModelMapperConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */