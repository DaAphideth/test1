/*    */ package nencer.app;
/*    */ 
/*    */ import org.springframework.boot.builder.SpringApplicationBuilder;
/*    */ import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*    */ 
/*    */ public class ServletInitializer
/*    */   extends SpringBootServletInitializer
/*    */ {
/*    */   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
/* 10 */     return application.sources(new Class[] { NencerApiBootApplication.class });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\ServletInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */