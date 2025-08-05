/*     */ package nencer.app.Modules.Auth.Fillter;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import nencer.app.Modules.Auth.Helper.JwtTokenHelper;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Repository.RolesRepository;
/*     */ import nencer.app.Modules.Users.Repository.UserRepository;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.annotation.Primary;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
/*     */ import org.springframework.stereotype.Component;
/*     */ import org.springframework.web.filter.OncePerRequestFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ @Primary
/*     */ public class JwtAuthenticationFilter
/*     */   extends OncePerRequestFilter
/*     */ {
/*     */   @Autowired
/*     */   private JwtTokenHelper jwtTokenHelper;
/*     */   @Autowired
/*     */   private UserRepository userRepository;
/*     */   @Autowired
/*     */   private RolesRepository rolesRepository;
/*     */   @Autowired
/*     */   private Environment env;
/*     */   
/*     */   protected boolean shouldNotFilter(HttpServletRequest request) {
/*  52 */     return (request.getServletPath().contains("/api/login") || request
/*  53 */       .getServletPath().contains("/api/refreshToken") || request
/*  54 */       .getServletPath().contains("/api/publicReport") || request
/*  55 */       .getServletPath().contains("/api/takeNumber") || request
/*  56 */       .getServletPath().contains("/api/examination") || request
/*  57 */       .getServletPath().contains("/api/ws") || request
/*  58 */       .getServletPath().contains("/api/topic") || request
/*  59 */       .getServletPath().contains("/api/app") || request
/*  60 */       .getServletPath().contains("/api/ws/examination/window-calling-number") || request
/*  61 */       .getServletPath().contains("/api/ws/checkin/window-calling-number") || request
/*  62 */       .getServletPath().contains("/swagger-ui.html") || request
/*  63 */       .getServletPath().contains("/v2/api-docs") || request
/*  64 */       .getServletPath().contains("/webjars/springfox-swagger-ui/css/typography.css") || request
/*  65 */       .getServletPath().contains("/webjars/springfox-swagger-ui/css/reset.css") || request
/*  66 */       .getServletPath().contains("/webjars/springfox-swagger-ui/css/screen.css") || request
/*  67 */       .getServletPath().contains("/webjars/springfox-swagger-ui/css/print.css") || request
/*  68 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/object-assign-pollyfill.js") || request
/*  69 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/jquery-1.8.0.min.js") || request
/*  70 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/jquery.slideto.min.js") || request
/*  71 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/jquery.wiggle.min.js") || request
/*  72 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/jquery.ba-bbq.min.js") || request
/*  73 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/handlebars-4.0.5.js") || request
/*  74 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/lodash.min.js") || request
/*  75 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/backbone-min.js") || request
/*  76 */       .getServletPath().contains("/webjars/springfox-swagger-ui/swagger-ui.min.js") || request
/*  77 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/highlight.9.1.0.pack.js") || request
/*  78 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/highlight.9.1.0.pack_extended.js") || request
/*  79 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/jsoneditor.min.js") || request
/*  80 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/marked.js") || request
/*  81 */       .getServletPath().contains("/webjars/springfox-swagger-ui/lib/swagger-oauth.js") || request
/*  82 */       .getServletPath().contains("/webjars/springfox-swagger-ui/springfox.js") || request
/*  83 */       .getServletPath().contains("/webjars/springfox-swagger-ui/springfox.js") || request
/*  84 */       .getServletPath().contains("/swagger-resources/configuration/ui") || request
/*  85 */       .getServletPath().contains("/swagger-resources") || request
/*  86 */       .getServletPath().contains("/api/roche/saveResult"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
/*  94 */     if (StringUtils.isNotBlank(this.env.getProperty("doFilterInternal")) && this.env
/*  95 */       .getProperty("doFilterInternal").equalsIgnoreCase("Y")) {
/*     */       try {
/*  97 */         String jwt = getJwtFromRequest(request);
/*  98 */         if (StringUtils.isBlank(jwt)) {
/*  99 */           Map<String, Object> rs = new HashMap<>();
/* 100 */           rs.put("status", "FAILE");
/* 101 */           rs.put("desc", "NOT Authorization");
/* 102 */           rs.put("responseCode", "410");
/* 103 */           ObjectMapper json = new ObjectMapper();
/* 104 */           String x = json.writeValueAsString(rs);
/*     */           
/* 106 */           PrintWriter out = response.getWriter();
/* 107 */           response.setStatus(200);
/* 108 */           response.setContentType("application/json");
/* 109 */           response.setCharacterEncoding("UTF-8");
/* 110 */           out.print(x);
/* 111 */           out.flush();
/*     */           return;
/*     */         } 
/* 114 */         if (StringUtils.isNotBlank(jwt) && this.jwtTokenHelper.validateToken(jwt)) {
/* 115 */           String userName = this.jwtTokenHelper.getIDFromToken(jwt);
/*     */           
/* 117 */           Optional<Users> users = this.userRepository.findByUsername(userName);
/* 118 */           if (users.isPresent()) {
/*     */             
/* 120 */             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(((Users)users.get()).getUsername(), null, null);
/*     */ 
/*     */             
/* 123 */             authentication.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
/*     */             
/* 125 */             SecurityContextHolder.getContext().setAuthentication((Authentication)authentication);
/*     */           } 
/*     */         } else {
/* 128 */           Map<String, Object> rs = new HashMap<>();
/* 129 */           rs.put("status", "FAILE");
/* 130 */           rs.put("desc", "TOKEN INVALID");
/* 131 */           rs.put("responseCode", "409");
/* 132 */           ObjectMapper json = new ObjectMapper();
/* 133 */           String x = json.writeValueAsString(rs);
/*     */           
/* 135 */           PrintWriter out = response.getWriter();
/* 136 */           response.setStatus(200);
/* 137 */           response.setContentType("application/json");
/* 138 */           response.setCharacterEncoding("UTF-8");
/* 139 */           out.print(x);
/* 140 */           out.flush();
/*     */           
/*     */           return;
/*     */         } 
/* 144 */       } catch (Exception ex) {
/* 145 */         this.logger.error("failed on set user authentication", ex);
/* 146 */         Map<String, Object> rs = new HashMap<>();
/* 147 */         rs.put("status", "FAILE");
/* 148 */         rs.put("desc", ExceptionUtils.getMessage(ex));
/* 149 */         rs.put("responseCode", "411");
/* 150 */         ObjectMapper json = new ObjectMapper();
/* 151 */         String x = json.writeValueAsString(rs);
/*     */         
/* 153 */         PrintWriter out = response.getWriter();
/* 154 */         response.setStatus(200);
/* 155 */         response.setContentType("application/json");
/* 156 */         response.setCharacterEncoding("UTF-8");
/* 157 */         out.print(x);
/* 158 */         out.flush();
/*     */         
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/* 164 */     filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*     */   }
/*     */   
/*     */   private String getJwtFromRequest(HttpServletRequest request) {
/* 168 */     String bearerToken = request.getHeader("Authorization");
/*     */     
/* 170 */     if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
/* 171 */       return bearerToken.substring(7);
/*     */     }
/* 173 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Fillter\JwtAuthenticationFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */