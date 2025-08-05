/*     */ package nencer.app.Modules.Users.Controller;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Users.Entity.Role.RoleHasPermissions;
/*     */ import nencer.app.Modules.Users.Entity.User.Permissions;
/*     */ import nencer.app.Modules.Users.Model.Role.PermissionsModel;
/*     */ import nencer.app.Modules.Users.Repository.CommonUserRoleRepo;
/*     */ import nencer.app.Modules.Users.Repository.PermissionsRepository;
/*     */ import nencer.app.Modules.Users.Repository.RoleHasPermissionsRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class PermissionsController
/*     */ {
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   @Autowired
/*     */   PermissionsRepository permissionsRepository;
/*     */   @Autowired
/*     */   private CommonUserRoleRepo commonUserRoleRepo;
/*     */   @Autowired
/*     */   private RoleHasPermissionsRepository roleHasPermissionsRepository;
/*     */   
/*     */   @GetMapping({"/permissions/getAll"})
/*     */   public ApiResponse getAllPermission(@RequestParam(required = false) String perType, @RequestParam(required = false) String searchValue) {
/*  56 */     ApiResponse rs = new ApiResponse();
/*  57 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  60 */       List<Permissions> pages = this.commonUserRoleRepo.spGetAllPermission(searchValue, perType);
/*  61 */       data.put("dataRes", pages);
/*  62 */       data.put("totalItems", Integer.valueOf((pages != null && pages.size() > 0) ? ((Permissions)pages.get(0)).getTotalRecord().intValue() : 0));
/*  63 */       rs.put("status", "OK");
/*  64 */       rs.put("responseCode", "00");
/*  65 */       rs.put("data", data);
/*  66 */     } catch (Exception e) {
/*  67 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  68 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/*  71 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/permissions"})
/*     */   public ApiResponse getUserBy(@RequestParam(required = false) String perType, @RequestParam(required = false) String searchValue, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  87 */     ApiResponse rs = new ApiResponse();
/*  88 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  91 */       List<Permissions> pages = this.commonUserRoleRepo.spSearchPermission(searchValue, perType, fieldSort, direction, page, size);
/*  92 */       data.put("dataRes", pages);
/*  93 */       data.put("totalItems", Integer.valueOf((pages != null && pages.size() > 0) ? ((Permissions)pages.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  95 */       rs.put("status", "OK");
/*  96 */       rs.put("responseCode", "00");
/*  97 */       rs.put("data", data);
/*  98 */     } catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 103 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/permissions/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 109 */     ApiResponse rs = new ApiResponse();
/* 110 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 113 */       if (id == null) {
/* 114 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 117 */       Optional<Permissions> g = this.permissionsRepository.findById(id);
/* 118 */       if (!g.isPresent()) {
/* 119 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 122 */       rs.put("status", "OK");
/* 123 */       rs.put("responseCode", "00");
/* 124 */       rs.put("data", g.get());
/*     */     }
/* 126 */     catch (Exception e) {
/* 127 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 128 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 130 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/permissions"})
/*     */   public ApiResponse create(@Valid @RequestBody Permissions permissions) {
/* 135 */     ApiResponse rs = new ApiResponse();
/* 136 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 139 */       String code = permissions.getPerCode().toUpperCase(Locale.ROOT);
/* 140 */       Optional<Permissions> permissionsOp = this.permissionsRepository.getRolesByPerCodeAndPerMenu(code, permissions.getPerMenu());
/* 141 */       if (permissionsOp.isPresent()) {
/* 142 */         return this.apiError.getError("814", new String[] { code });
/*     */       }
/*     */       
/* 145 */       Permissions permissionsRs = (Permissions)this.permissionsRepository.saveAndFlush(Permissions.builder()
/* 146 */           .perName(code)
/* 147 */           .description(permissions.getDescription())
/* 148 */           .createdAt(new Date())
/* 149 */           .updatedAt(new Date())
/* 150 */           .perType(permissions.getPerType().toLowerCase(Locale.ROOT))
/* 151 */           .perCode(permissions.getPerCode())
/* 152 */           .status(permissions.getStatus())
/* 153 */           .perMenu(permissions.getPerMenu())
/* 154 */           .build());
/*     */       
/* 156 */       data.put("permissions", permissionsRs);
/* 157 */       rs.put("status", "OK");
/* 158 */       rs.put("responseCode", "00");
/* 159 */       rs.put("data", data);
/*     */     }
/* 161 */     catch (Exception e) {
/* 162 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 163 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 165 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/permissions/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody Permissions request) {
/* 170 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 174 */       if (id == null) {
/* 175 */         return this.apiError.getError("813");
/*     */       }
/*     */       
/* 178 */       Optional<Permissions> g = this.permissionsRepository.findById(id);
/* 179 */       if (!g.isPresent()) {
/* 180 */         return this.apiError.getError("813", new String[] { request.getPerName() });
/*     */       }
/*     */       
/* 183 */       this.permissionsRepository.saveAndFlush(Permissions.builder()
/* 184 */           .perId(id)
/* 185 */           .perName(request.getPerName())
/* 186 */           .description(request.getDescription())
/* 187 */           .createdAt(request.getCreatedAt())
/* 188 */           .updatedAt(new Date())
/* 189 */           .perType(request.getPerType().toLowerCase(Locale.ROOT))
/* 190 */           .perCode(request.getPerCode())
/* 191 */           .status(request.getStatus())
/* 192 */           .perMenu(request.getPerMenu())
/* 193 */           .build());
/* 194 */       rs.put("status", "OK");
/* 195 */       rs.put("responseCode", "00");
/*     */     }
/* 197 */     catch (Exception e) {
/* 198 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 199 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 201 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/permissions/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 206 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 209 */       if (id == null) {
/* 210 */         return this.apiError.getError("804", new String[] { "id" });
/*     */       }
/*     */       
/* 213 */       Optional<Permissions> g = this.permissionsRepository.findById(id);
/* 214 */       if (!g.isPresent()) {
/* 215 */         return this.apiError.getError("813", new String[] { String.valueOf(id) });
/*     */       }
/*     */       
/* 218 */       List<RoleHasPermissions> roleHasPermissions = this.roleHasPermissionsRepository.findAllByPerId(Integer.valueOf(Math.toIntExact(id.intValue())));
/* 219 */       boolean checkRoleUsePermission = (roleHasPermissions != null && roleHasPermissions.size() > 0);
/* 220 */       if (checkRoleUsePermission) {
/* 221 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 224 */       this.permissionsRepository.delete(g.get());
/*     */       
/* 226 */       rs.put("status", "OK");
/* 227 */       rs.put("responseCode", "00");
/*     */     }
/* 229 */     catch (Exception e) {
/* 230 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 231 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 233 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/permissions/menu"})
/*     */   public ApiResponse getMenuPermission(@RequestParam(required = false) String searchValue) {
/* 243 */     ApiResponse rs = new ApiResponse();
/* 244 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 247 */       List<PermissionsModel> pages = this.commonUserRoleRepo.spGetMenuPermission(searchValue);
/* 248 */       if (pages != null && pages.size() > 0) {
/* 249 */         for (PermissionsModel page : pages) {
/* 250 */           List<PermissionsModel> chilPermissions = this.commonUserRoleRepo.spGetChillPermission(page.getPerId());
/* 251 */           page.setChildPermissions(chilPermissions);
/*     */         } 
/*     */       }
/*     */       
/* 255 */       data.put("dataRes", pages);
/* 256 */       data.put("totalItems", Integer.valueOf((pages != null && pages.size() > 0) ? ((PermissionsModel)pages.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 258 */       rs.put("status", "OK");
/* 259 */       rs.put("responseCode", "00");
/* 260 */       rs.put("data", data);
/* 261 */     } catch (Exception e) {
/* 262 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 263 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 266 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Controller\PermissionsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */