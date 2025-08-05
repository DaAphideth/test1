/*     */ package nencer.app.Modules.Users.Controller;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*     */ import nencer.app.Modules.Users.Entity.User.Permissions;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Model.Role.RolesModel;
/*     */ import nencer.app.Modules.Users.Repository.CommonUserRoleRepo;
/*     */ import nencer.app.Modules.Users.Repository.PermissionsRepository;
/*     */ import nencer.app.Modules.Users.Repository.RoleHasPermissionsRepository;
/*     */ import nencer.app.Modules.Users.Repository.RolesRepository;
/*     */ import nencer.app.Modules.Users.Repository.specifications.RolesSpecification;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class RolesController
/*     */ {
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */   @Autowired
/*     */   private RolesRepository rolesRepository;
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @GetMapping({"/roles"})
/*     */   public ApiResponse getUserBy(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  65 */     ApiResponse rs = new ApiResponse();
/*  66 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  68 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  69 */       if (!StringUtils.isEmpty(filter)) {
/*  70 */         ObjectMapper objectMapper = new ObjectMapper();
/*  71 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  74 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  75 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  76 */       RolesSpecification specifications = new RolesSpecification(searchFilter);
/*     */       
/*  78 */       Page<Roles> pages = this.rolesRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  79 */       data.put("users", pages.get());
/*  80 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  81 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  83 */       rs.put("status", "OK");
/*  84 */       rs.put("responseCode", "00");
/*  85 */       rs.put("data", data);
/*  86 */     } catch (Exception e) {
/*  87 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  88 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/*  91 */     return rs;
/*     */   } @Autowired
/*     */   private PermissionsRepository permissionsRepository; @Autowired
/*     */   private RoleHasPermissionsRepository roleHasPermissionsRepository; @Autowired
/*     */   private CommonUserRoleRepo commonUserRoleRepo; @GetMapping({"/roles/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  97 */     ApiResponse rs = new ApiResponse();
/*  98 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 101 */       if (id == null) {
/* 102 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 105 */       Optional<Roles> g = this.rolesRepository.findById(id);
/* 106 */       if (!g.isPresent()) {
/* 107 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 110 */       RolesModel rolesModel = (RolesModel)this.modelMapper.map(g.get(), RolesModel.class);
/*     */       
/* 112 */       List<Permissions> permissions = this.commonUserRoleRepo.spGetPermissionByRoleId(id);
/* 113 */       rolesModel.setPermissions(permissions);
/*     */       
/* 115 */       rs.put("status", "OK");
/* 116 */       rs.put("responseCode", "00");
/* 117 */       rs.put("data", rolesModel);
/*     */     }
/* 119 */     catch (Exception e) {
/* 120 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 121 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 123 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/roles"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse create(@Valid @RequestBody RolesModel rolesModel) {
/* 129 */     ApiResponse rs = new ApiResponse();
/* 130 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 133 */       String name = rolesModel.getName().toUpperCase(Locale.ROOT);
/* 134 */       Optional<Roles> rolesOp = this.rolesRepository.getRolesByName(name);
/* 135 */       if (rolesOp.isPresent()) {
/* 136 */         return this.apiError.getError("811", new String[] { rolesModel.getName() });
/*     */       }
/*     */ 
/*     */       
/* 140 */       Roles roles = (Roles)this.rolesRepository.saveAndFlush(Roles.builder()
/* 141 */           .name(name)
/* 142 */           .description(rolesModel.getDescription())
/* 143 */           .createdAt(new Date())
/* 144 */           .updatedAt(new Date())
/* 145 */           .guardName(rolesModel.getGuardName())
/* 146 */           .build());
/*     */       
/* 148 */       if (rolesModel.getPermissions() != null && rolesModel.getPermissions().size() > 0) {
/* 149 */         List<Permissions> permissionsSet = rolesModel.getPermissions();
/* 150 */         for (Permissions permissions : permissionsSet) {
/* 151 */           Optional<Permissions> permissionsCheck = this.permissionsRepository.findById(permissions.getPerId());
/* 152 */           if (!permissionsCheck.isPresent()) {
/* 153 */             return this.apiError.getError("813", new String[] { permissions.getPerName() });
/*     */           }
/*     */         } 
/* 156 */         this.roleHasPermissionsRepository.deleteAllByRoleId(roles.getId());
/* 157 */         for (Permissions permissions : permissionsSet) {
/* 158 */           this.roleHasPermissionsRepository.saveRHP(permissions.getPerId(), roles.getId());
/*     */         }
/*     */       } 
/* 161 */       rolesOp = this.rolesRepository.findById(roles.getId());
/* 162 */       data.put("roles", rolesOp.get());
/* 163 */       rs.put("status", "OK");
/* 164 */       rs.put("responseCode", "00");
/* 165 */       rs.put("data", data);
/*     */     }
/* 167 */     catch (Exception e) {
/* 168 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 169 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 170 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 172 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/roles/{id}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody RolesModel request) {
/* 178 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 182 */       if (id == null) {
/* 183 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 186 */       Optional<Roles> g = this.rolesRepository.findById(id);
/* 187 */       if (!g.isPresent()) {
/* 188 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 192 */       Roles roles = (Roles)this.rolesRepository.saveAndFlush(Roles.builder()
/* 193 */           .id(id)
/* 194 */           .name(request.getName())
/* 195 */           .description(request.getDescription())
/* 196 */           .createdAt(new Date())
/* 197 */           .updatedAt(new Date())
/* 198 */           .guardName(request.getGuardName())
/* 199 */           .build());
/*     */       
/* 201 */       if (request.getPermissions() != null && request.getPermissions().size() > 0) {
/* 202 */         List<Permissions> permissionsSet = request.getPermissions();
/* 203 */         for (Permissions permissions : permissionsSet) {
/* 204 */           Optional<Permissions> permissionsCheck = this.permissionsRepository.findById(permissions.getPerId());
/* 205 */           if (!permissionsCheck.isPresent()) {
/* 206 */             return this.apiError.getError("813", new String[] { permissions.getPerName() });
/*     */           }
/*     */         } 
/* 209 */         this.roleHasPermissionsRepository.deleteAllByRoleId(roles.getId());
/* 210 */         for (Permissions permissions : permissionsSet) {
/* 211 */           this.roleHasPermissionsRepository.saveRHP(permissions.getPerId(), roles.getId());
/*     */         }
/*     */       } 
/* 214 */       rs.put("status", "OK");
/* 215 */       rs.put("responseCode", "00");
/*     */     }
/* 217 */     catch (Exception e) {
/* 218 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 219 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 220 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 222 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/roles/{id}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 228 */     ApiResponse rs = new ApiResponse();
/* 229 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 232 */       if (id == null) {
/* 233 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 236 */       Optional<Roles> g = this.rolesRepository.findById(id);
/* 237 */       if (!g.isPresent()) {
/* 238 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 241 */       List<Users> usersList = this.commonUserRoleRepo.spGetUserByRoleId(id);
/* 242 */       boolean checkUserInRoles = (usersList != null && usersList.size() > 0);
/* 243 */       if (checkUserInRoles) {
/* 244 */         return this.apiError.getError("812", new String[0]);
/*     */       }
/*     */       
/* 247 */       this.rolesRepository.delete(g.get());
/* 248 */       this.roleHasPermissionsRepository.deleteAllByRoleId(id);
/*     */       
/* 250 */       rs.put("status", "OK");
/* 251 */       rs.put("responseCode", "00");
/*     */     }
/* 253 */     catch (Exception e) {
/* 254 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 255 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 256 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 258 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PutMapping({"/roles/updatePermission/{id}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse updatePermission(@PathVariable @Valid Integer id, @Valid @RequestBody List<Permissions> permissionsList) {
/* 267 */     ApiResponse rs = new ApiResponse();
/* 268 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 271 */       Optional<Roles> rolesOp = this.rolesRepository.findById(id);
/* 272 */       if (!rolesOp.isPresent()) {
/* 273 */         return this.apiError.getError("202", new String[] { String.valueOf(id) });
/*     */       }
/*     */       
/* 276 */       for (Permissions permissions : permissionsList) {
/* 277 */         Optional<Permissions> permissionsCheck = this.permissionsRepository.findById(permissions.getPerId());
/* 278 */         if (!permissionsCheck.isPresent()) {
/* 279 */           return this.apiError.getError("813", new String[] { permissions.getPerName() });
/*     */         }
/*     */       } 
/* 282 */       this.roleHasPermissionsRepository.deleteAllByRoleId(id);
/* 283 */       for (Permissions permissions : permissionsList) {
/* 284 */         this.roleHasPermissionsRepository.saveRHP(permissions.getPerId(), id);
/*     */       }
/*     */       
/* 287 */       rs.put("status", "OK");
/* 288 */       rs.put("responseCode", "00");
/*     */     }
/* 290 */     catch (Exception e) {
/* 291 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 292 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 293 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 295 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Controller\RolesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */