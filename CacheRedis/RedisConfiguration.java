/*    */ package nencer.app.CacheRedis;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.Primary;
/*    */ import org.springframework.data.redis.connection.RedisConnectionFactory;
/*    */ import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
/*    */ import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
/*    */ import org.springframework.data.redis.core.RedisTemplate;
/*    */ import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ @EnableRedisRepositories
/*    */ public class RedisConfiguration
/*    */ {
/*    */   @Value("${redis.host}")
/*    */   private String redisHost;
/*    */   @Value("${redis.port}")
/*    */   private int redisPort;
/*    */   
/*    */   @Bean
/*    */   public LettuceConnectionFactory redisConnectionFactory() {
/* 27 */     return new LettuceConnectionFactory(new RedisStandaloneConfiguration(this.redisHost, this.redisPort));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   @Primary
/*    */   public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
/* 37 */     RedisTemplate<Object, Object> template = new RedisTemplate();
/* 38 */     template.setConnectionFactory(redisConnectionFactory);
/* 39 */     return template;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\CacheRedis\RedisConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */