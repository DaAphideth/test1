/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ import com.google.common.base.Predicates;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ import springfox.documentation.builders.RequestHandlerSelectors;
/*    */ import springfox.documentation.service.ApiKey;
/*    */ import springfox.documentation.service.AuthorizationScope;
/*    */ import springfox.documentation.service.SecurityReference;
/*    */ import springfox.documentation.spi.DocumentationType;
/*    */ import springfox.documentation.spi.service.contexts.SecurityContext;
/*    */ import springfox.documentation.spring.web.plugins.Docket;
/*    */ import springfox.documentation.swagger.web.ApiKeyVehicle;
/*    */ import springfox.documentation.swagger.web.SecurityConfiguration;
/*    */ import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ @EnableSwagger2
/*    */ public class SpringFoxConfig
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   @Bean
/*    */   public Docket api() {
/* 30 */     return (new Docket(DocumentationType.SWAGGER_2)).select()
/* 31 */       .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
/* 32 */       .build()
/* 33 */       .securityContexts(Arrays.asList(new SecurityContext[] { securityContext()
/* 34 */           })).securitySchemes(Arrays.asList(new ApiKey[] { apiKey() }));
/*    */   }
/*    */ 
/*    */   
/*    */   @Bean
/*    */   SecurityConfiguration security() {
/* 40 */     return new SecurityConfiguration(null, null, null, null, null, ApiKeyVehicle.HEADER, null, ",");
/*    */   }
/*    */ 
/*    */   
/*    */   private ApiKey apiKey() {
/* 45 */     return new ApiKey("Authorization", null, "header");
/*    */   }
/*    */   
/*    */   private SecurityContext securityContext() {
/* 49 */     return SecurityContext.builder()
/* 50 */       .securityReferences(defaultAuth())
/* 51 */       .build();
/*    */   }
/*    */   
/*    */   List<SecurityReference> defaultAuth() {
/* 55 */     AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
/*    */     
/* 57 */     final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
/* 58 */     authorizationScopes[0] = authorizationScope;
/* 59 */     return new ArrayList<SecurityReference>()
/*    */       {
/*    */       
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry) {
/* 67 */     registry.addResourceHandler(new String[] { "swagger-ui.html" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/" });
/* 68 */     registry.addResourceHandler(new String[] { "/webjars/**" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/webjars/" });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\SpringFoxConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */