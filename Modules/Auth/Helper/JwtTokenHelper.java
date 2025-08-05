/*     */ package nencer.app.Modules.Auth.Helper;
/*     */ import io.jsonwebtoken.Claims;
/*     */ import io.jsonwebtoken.ExpiredJwtException;
/*     */ import io.jsonwebtoken.Jwts;
/*     */ import io.jsonwebtoken.MalformedJwtException;
/*     */ import io.jsonwebtoken.SignatureAlgorithm;
/*     */ import io.jsonwebtoken.UnsupportedJwtException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Function;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import org.slf4j.Logger;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class JwtTokenHelper {
/*  20 */   private static final Logger logger = LoggerFactory.getLogger(JwtTokenHelper.class);
/*     */ 
/*     */   
/*     */   @Value("${jwt.expiresIn}")
/*     */   public long expiresIn;
/*     */   
/*     */   @Value("${jwt.secret}")
/*     */   private String secret;
/*     */   
/*     */   @Autowired
/*     */   UserRepository userRepository;
/*     */ 
/*     */   
/*     */   public Date getExpirationDateFromToken(String token) {
/*  34 */     return getClaimFromToken(token, Claims::getExpiration);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIDFromToken(String token) {
/*  39 */     return getClaimFromToken(token, Claims::getSubject);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
/*  44 */     Claims claims = getAllClaimsFromToken(token);
/*  45 */     return claimsResolver.apply(claims);
/*     */   }
/*     */ 
/*     */   
/*     */   private Claims getAllClaimsFromToken(String token) {
/*  50 */     return (Claims)Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
/*     */   }
/*     */ 
/*     */   
/*     */   private Boolean isTokenExpired(String token) {
/*  55 */     Date expiration = getExpirationDateFromToken(token);
/*  56 */     return Boolean.valueOf(expiration.before(new Date()));
/*     */   }
/*     */ 
/*     */   
/*     */   public String generateToken(Users users) {
/*  61 */     Map<String, Object> claims = new HashMap<>();
/*  62 */     claims.put("jti", users.getId());
/*  63 */     claims.put("fullName", users.getName());
/*  64 */     return doGenerateToken(claims, users.getUsername());
/*     */   }
/*     */   
/*     */   public String generateRefreshToken(Users users) {
/*  68 */     Map<String, Object> claims = new HashMap<>();
/*  69 */     claims.put("jti", users.getId());
/*  70 */     claims.put("userName", users.getUsername());
/*  71 */     claims.put("fullName", users.getName());
/*  72 */     return Jwts.builder().setClaims(claims)
/*  73 */       .setSubject(users.getUsername())
/*  74 */       .setIssuedAt(new Date(System.currentTimeMillis()))
/*  75 */       .setExpiration(new Date(System.currentTimeMillis() + this.expiresIn * 3L))
/*  76 */       .signWith(SignatureAlgorithm.HS512, this.secret)
/*  77 */       .compact();
/*     */   }
/*     */ 
/*     */   
/*     */   private String doGenerateToken(Map<String, Object> claims, String subject) {
/*  82 */     String jwt = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  89 */       jwt = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + this.expiresIn)).signWith(SignatureAlgorithm.HS512, this.secret).compact();
/*  90 */     } catch (Exception e) {
/*  91 */       e.printStackTrace();
/*     */     } 
/*  93 */     return jwt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validateToken(String authToken) {
/*     */     try {
/*  99 */       if (isTokenExpired(authToken).booleanValue()) {
/* 100 */         return false;
/*     */       }
/* 102 */       Optional<Users> users = this.userRepository.findByApiToken(authToken);
/* 103 */       return users.isPresent();
/* 104 */     } catch (MalformedJwtException ex) {
/* 105 */       logger.error("Invalid JWT token");
/* 106 */     } catch (ExpiredJwtException ex) {
/* 107 */       logger.error("Expired JWT token");
/* 108 */     } catch (UnsupportedJwtException ex) {
/* 109 */       logger.error("Unsupported JWT token");
/* 110 */     } catch (IllegalArgumentException ex) {
/* 111 */       logger.error("JWT claims string is empty.");
/*     */     } 
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validateRefreshToken(String authToken) {
/*     */     try {
/* 119 */       if (isTokenExpired(authToken).booleanValue()) {
/* 120 */         return false;
/*     */       }
/* 122 */       return true;
/* 123 */     } catch (MalformedJwtException ex) {
/* 124 */       logger.error("Invalid JWT token");
/* 125 */     } catch (ExpiredJwtException ex) {
/* 126 */       logger.error("Expired JWT token");
/* 127 */     } catch (UnsupportedJwtException ex) {
/* 128 */       logger.error("Unsupported JWT token");
/* 129 */     } catch (IllegalArgumentException ex) {
/* 130 */       logger.error("JWT claims string is empty.");
/*     */     } 
/* 132 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Helper\JwtTokenHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */