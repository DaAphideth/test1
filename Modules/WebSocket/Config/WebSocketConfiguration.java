/*    */ package nencer.app.Modules.WebSocket.Config;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.messaging.simp.config.MessageBrokerRegistry;
/*    */ import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
/*    */ import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
/*    */ import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/*    */ 
/*    */ @Configuration
/*    */ @EnableWebSocketMessageBroker
/*    */ public class WebSocketConfiguration
/*    */   implements WebSocketMessageBrokerConfigurer
/*    */ {
/*    */   public void registerStompEndpoints(StompEndpointRegistry registry) {
/* 15 */     registry
/* 16 */       .addEndpoint(new String[] { "/api/ws"
/* 17 */         }).setAllowedOrigins(new String[] { "*" });
/* 18 */     registry
/* 19 */       .addEndpoint(new String[] { "/api/ws"
/* 20 */         }).setAllowedOrigins(new String[] { "*"
/* 21 */         }).withSockJS();
/*    */   }
/*    */ 
/*    */   
/*    */   public void configureMessageBroker(MessageBrokerRegistry registry) {
/* 26 */     registry.enableSimpleBroker(new String[] { "/api/topic" });
/*    */     
/* 28 */     registry.setApplicationDestinationPrefixes(new String[] { "/api/app" });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\WebSocket\Config\WebSocketConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */