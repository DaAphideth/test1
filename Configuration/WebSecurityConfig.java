/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*    */ import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*    */ import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
/*    */ import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/*    */ import org.springframework.security.web.util.matcher.RequestMatcher;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EnableWebSecurity
/*    */ public class WebSecurityConfig
/*    */   extends WebSecurityConfigurerAdapter
/*    */ {
/*    */   protected void configure(HttpSecurity http) throws Exception {
/* 22 */     ((HttpSecurity)((HttpSecurity)http
/* 23 */       .cors()
/* 24 */       .and())
/* 25 */       .csrf()
/* 26 */       .disable())
/* 27 */       .authorizeRequests(request -> ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)request.requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/api/**") })).permitAll().requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/swagger-ui.html") })).permitAll().requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/webjars/**") })).permitAll().requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/v2/api-docs") })).permitAll().requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/webjars/**") })).permitAll().requestMatchers(new RequestMatcher[] { (RequestMatcher)new AntPathRequestMatcher("/swagger-resources/**") })).permitAll().anyRequest()).authenticated());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\WebSecurityConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */