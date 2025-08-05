/*    */ package nencer.app.CacheRedis;
/*    */ import org.springframework.data.annotation.Id;
/*    */ import org.springframework.data.redis.core.RedisHash;
/*    */ import org.springframework.data.redis.core.index.Indexed;
/*    */ 
/*    */ @RedisHash("cacheData")
/*    */ public class CacheData {
/*    */   public CacheData(String key, String value) {
/*  9 */     this.key = key; this.value = value;
/*    */   }
/*    */   @Id
/*    */   private String key;
/*    */   
/*    */   public String getKey() {
/* 15 */     return this.key;
/*    */   } @Indexed
/*    */   private String value; public String getValue() {
/* 18 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\CacheRedis\CacheData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */