/*    */ package nencer.app.Modules.Auth.Custom;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import nencer.app.Modules.Auth.Helper.JBcryptHelper;
/*    */ import nencer.app.Modules.Users.Entity.User.Users;
/*    */ import nencer.app.Modules.Users.Repository.RolesRepository;
/*    */ import nencer.app.Modules.Users.Repository.UserRepository;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Primary;
/*    */ import org.springframework.security.authentication.AuthenticationManager;
/*    */ import org.springframework.security.authentication.BadCredentialsException;
/*    */ import org.springframework.security.authentication.DisabledException;
/*    */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Primary
/*    */ @Component
/*    */ public class CustomAuthenticationManager
/*    */   implements AuthenticationManager
/*    */ {
/*    */   @Autowired
/*    */   UserRepository userRepository;
/*    */   @Autowired
/*    */   JBcryptHelper jBcryptHelper;
/*    */   @Autowired
/*    */   RolesRepository rolesRepository;
/*    */   
/*    */   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
/* 38 */     String username = authentication.getPrincipal() + "";
/* 39 */     String password = authentication.getCredentials() + "";
/*    */     
/* 41 */     Optional<Users> users = this.userRepository.findByUsername(username);
/* 42 */     if (!users.isPresent()) {
/* 43 */       throw new BadCredentialsException("1000");
/*    */     }
/* 45 */     if (!this.jBcryptHelper.checkBcryptPassword(password, ((Users)users.get()).getPassword()).booleanValue()) {
/* 46 */       throw new BadCredentialsException("1000");
/*    */     }
/* 48 */     if (((Users)users.get()).getStatus().equals(Integer.valueOf(0))) {
/* 49 */       throw new DisabledException("1001");
/*    */     }
/* 51 */     return (Authentication)new UsernamePasswordAuthenticationToken(users.get(), null, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Custom\CustomAuthenticationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */