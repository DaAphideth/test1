/*     */ package nencer.app.Modules.Auth.Controller;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import nencer.app.Modules.Auth.Helper.JwtTokenHelper;
/*     */ import nencer.app.Modules.Auth.Model.LoginRequest;
/*     */ import nencer.app.Modules.Auth.Model.UserResponseInfo;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Model.Role.PermissionsModel;
/*     */ import nencer.app.Modules.Users.Repository.CommonUserRoleRepo;
/*     */ import nencer.app.Modules.Users.Repository.UserRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.security.authentication.AuthenticationManager;
/*     */ import org.springframework.security.authentication.BadCredentialsException;
/*     */ import org.springframework.security.authentication.DisabledException;
/*     */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class AuthController extends BaseMedicController {
/*  42 */   public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
/*     */   
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   Environment env;
/*     */   
/*     */   @Autowired
/*     */   UserRepository userRepository;
/*     */   
/*     */   @Autowired
/*     */   AuthenticationManager authenticationManager;
/*     */   
/*     */   @Autowired
/*     */   JwtTokenHelper jwtTokenHelper;
/*     */   
/*     */   @Autowired
/*     */   CommonUserRoleRepo commonUserRoleRepo;
/*     */   
/*     */   @PostMapping({"/login"})
/*     */   public ApiResponse login(@RequestBody LoginRequest loginRequest) {
/*  64 */     ApiResponse rs = new ApiResponse();
/*  65 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  68 */       Authentication authentication = this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken(loginRequest
/*     */             
/*  70 */             .getUsername(), loginRequest
/*  71 */             .getPassword()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       SecurityContextHolder.getContext().setAuthentication(authentication);
/*     */ 
/*     */       
/*  80 */       String ip = InetAddress.getLocalHost().getHostAddress();
/*  81 */       Users users = (Users)authentication.getPrincipal();
/*     */ 
/*     */ 
/*     */       
/*  85 */       UserResponseInfo userResponseInfo = (UserResponseInfo)this.modelMapper.map(users, UserResponseInfo.class);
/*     */       
/*  87 */       List<Roles> roles = this.commonUserRoleRepo.spGetRolesByUserId(Integer.valueOf(Math.toIntExact(userResponseInfo.getId().longValue())));
/*  88 */       List<PermissionsModel> permissions = this.commonUserRoleRepo.spGetPermissionByUserId(Math.toIntExact(userResponseInfo.getId().longValue()));
/*  89 */       userResponseInfo.setRoles(roles);
/*  90 */       userResponseInfo.setPermissions(permissions);
/*     */       
/*  92 */       String jwt = this.jwtTokenHelper.generateToken(users);
/*  93 */       String refreshToken = this.jwtTokenHelper.generateRefreshToken(users);
/*  94 */       data.put("accessToken", jwt);
/*  95 */       data.put("refreshToken", refreshToken);
/*  96 */       data.put("refresh_expires_in", Long.valueOf(this.jwtTokenHelper.expiresIn));
/*  97 */       data.put("access_expires_in", Long.valueOf(this.jwtTokenHelper.expiresIn * 3L));
/*  98 */       data.put("token_type", "JWT");
/*  99 */       data.put("user", userResponseInfo);
/* 100 */       this.userRepository.updateTokenById(users.getId(), jwt, refreshToken, ip);
/* 101 */       rs.put("status", "OK");
/* 102 */       rs.put("responseCode", "00");
/* 103 */       rs.put("data", data);
/*     */     }
/* 105 */     catch (BadCredentialsException e) {
/* 106 */       String exceptionAsString = ExceptionUtils.getStackTrace((Throwable)e);
/* 107 */       return this.apiError.getError("807", new String[] { exceptionAsString });
/* 108 */     } catch (DisabledException e) {
/* 109 */       String exceptionAsString = ExceptionUtils.getStackTrace((Throwable)e);
/* 110 */       return this.apiError.getError("808", new String[] { exceptionAsString });
/* 111 */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/* 113 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 114 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 117 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/logout"})
/*     */   public ApiResponse logout(HttpServletRequest request) {
/* 122 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 124 */       String accessToken = getJwtFromRequest(request);
/* 125 */       Optional<Users> users = this.userRepository.findByApiToken(accessToken);
/* 126 */       users.ifPresent(value -> this.userRepository.updateTokenById(value.getId(), "", "", ""));
/*     */       
/* 128 */       rs.put("status", "OK");
/* 129 */       rs.put("responseCode", "00");
/*     */     }
/* 131 */     catch (Exception e) {
/* 132 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 133 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 136 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/refreshToken"})
/*     */   public ApiResponse refreshToken(@RequestBody Map refreshTokenRq) {
/* 141 */     ApiResponse rs = new ApiResponse();
/* 142 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 145 */       String refreshToken = (refreshTokenRq.get("refreshToken") != null) ? refreshTokenRq.get("refreshToken").toString() : "";
/* 146 */       Optional<Users> users = this.userRepository.findByRememberToken(refreshToken);
/* 147 */       if (this.jwtTokenHelper.validateRefreshToken(refreshToken)) {
/* 148 */         String ip = InetAddress.getLocalHost().getHostAddress();
/* 149 */         String jwt = this.jwtTokenHelper.generateToken(users.get());
/* 150 */         refreshToken = this.jwtTokenHelper.generateRefreshToken(users.get());
/* 151 */         data.put("accessToken", jwt);
/* 152 */         data.put("refreshToken", refreshToken);
/* 153 */         data.put("refresh_expires_in", Long.valueOf(this.jwtTokenHelper.expiresIn));
/* 154 */         data.put("access_expires_in", Long.valueOf(this.jwtTokenHelper.expiresIn * 3L));
/* 155 */         data.put("token_type", "JWT");
/* 156 */         this.userRepository.updateTokenById(((Users)users.get()).getId(), jwt, refreshToken, ip);
/*     */       } 
/*     */       
/* 159 */       rs.put("data", data);
/* 160 */       rs.put("status", "OK");
/* 161 */       rs.put("responseCode", "00");
/*     */     }
/* 163 */     catch (Exception e) {
/* 164 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 165 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 168 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getJwtFromRequest(HttpServletRequest request) {
/* 173 */     String bearerToken = request.getHeader("Authorization");
/*     */     
/* 175 */     if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
/* 176 */       return bearerToken.substring(7);
/*     */     }
/* 178 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Controller\AuthController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */