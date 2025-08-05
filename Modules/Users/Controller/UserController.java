/*     */ package nencer.app.Modules.Users.Controller;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Users.Entity.Group.Groups;
/*     */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Model.User.CreateUserRequest;
/*     */ import nencer.app.Modules.Users.Model.User.UserPassword;
/*     */ import nencer.app.Modules.Users.Model.User.UserResponse;
/*     */ import nencer.app.Modules.Users.Model.User.UsersRequest;
/*     */ import nencer.app.Modules.Users.Repository.GroupRepository;
/*     */ import nencer.app.Modules.Users.Repository.specifications.UserSpecification;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class UserController {
/*  46 */   public static final Logger logger = LoggerFactory.getLogger(UserController.class);
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
/*     */   JBcryptHelper jBcryptHelper;
/*     */   
/*     */   @Autowired
/*     */   RolesRepository rolesRepository;
/*     */   
/*     */   @Autowired
/*     */   ModelHasRolesRepository modelHasRolesRepository;
/*     */   
/*     */   @Autowired
/*     */   ModelHasGroupRepository modelHasGroupRepository;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   CommonUserRoleRepo commonUserRoleRepo;
/*     */   
/*     */   @Autowired
/*     */   GroupRepository groupRepository;
/*     */   
/*     */   @GetMapping({"/user/get_all"})
/*     */   public ApiResponse getUser(@RequestParam(required = false) String filter) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*  81 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  83 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  84 */       if (!StringUtils.isEmpty(filter)) {
/*  85 */         ObjectMapper objectMapper = new ObjectMapper();
/*  86 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  89 */       UserSpecification specifications = new UserSpecification(searchFilter);
/*     */       
/*  91 */       List<Users> pages = this.userRepository.findAll((Specification)specifications);
/*  92 */       List<UserResponse> userResponses = (List<UserResponse>)pages.stream().map(group -> (UserResponse)this.modelMapper.map(group, UserResponse.class)).collect(Collectors.toList());
/*  93 */       data.put("users", userResponses);
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
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/user"})
/*     */   public ApiResponse getUser(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 112 */     ApiResponse rs = new ApiResponse();
/* 113 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 115 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 116 */       if (!StringUtils.isEmpty(filter)) {
/* 117 */         ObjectMapper objectMapper = new ObjectMapper();
/* 118 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/* 121 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/* 122 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/* 123 */       UserSpecification specifications = new UserSpecification(searchFilter);
/*     */       
/* 125 */       Page<Users> pages = this.userRepository.findAll((Specification)specifications, (Pageable)pageable);
/* 126 */       for (Users users : pages) {
/* 127 */         List<Roles> roles = this.commonUserRoleRepo.spGetRolesByUserId(Integer.valueOf(Math.toIntExact(users.getId().intValue())));
/* 128 */         users.setRoles(roles);
/*     */         
/* 130 */         List<Groups> groups = this.commonUserRoleRepo.spGetGroupsByUserId(Integer.valueOf(Math.toIntExact(users.getId().intValue())));
/* 131 */         users.setGroups(groups);
/*     */       } 
/*     */       
/* 134 */       data.put("users", pages.get());
/* 135 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/* 136 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/* 138 */       rs.put("status", "OK");
/* 139 */       rs.put("responseCode", "00");
/* 140 */       rs.put("data", data);
/* 141 */     } catch (Exception e) {
/* 142 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 143 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 146 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/user/{username}"})
/*     */   public ApiResponse getUserById(@PathVariable @Valid String username) {
/* 151 */     ApiResponse rs = new ApiResponse();
/* 152 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 154 */       if (StringUtils.isNotBlank(username)) {
/* 155 */         Optional<Users> users = this.userRepository.findByUsername(username);
/* 156 */         if (users.isPresent()) {
/* 157 */           data.put("user", users);
/*     */         }
/*     */       } 
/* 160 */       rs.put("status", "OK");
/* 161 */       rs.put("responseCode", "00");
/* 162 */       rs.put("data", data);
/*     */     }
/* 164 */     catch (Exception e) {
/* 165 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 166 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 169 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/userbyId/{id}"})
/*     */   public ApiResponse getUserById(@PathVariable @Valid Integer id) {
/* 174 */     ApiResponse rs = new ApiResponse();
/* 175 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 178 */       Optional<Users> users = this.userRepository.findById(id);
/* 179 */       if (users.isPresent()) {
/* 180 */         data.put("user", users);
/*     */       }
/* 182 */       rs.put("status", "OK");
/* 183 */       rs.put("responseCode", "00");
/* 184 */       rs.put("data", data);
/*     */     }
/* 186 */     catch (Exception e) {
/* 187 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 188 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 191 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/user"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse createUser(@Valid @RequestBody CreateUserRequest request) {
/* 197 */     ApiResponse rs = new ApiResponse();
/* 198 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 200 */       String username = request.getUsername().toLowerCase(Locale.ROOT);
/* 201 */       String email = request.getEmail().toLowerCase(Locale.ROOT);
/* 202 */       Optional<Users> users = this.userRepository.findByUsernameOrEmail(username, email);
/* 203 */       if (users.isPresent()) {
/* 204 */         return this.apiError.getError("809", new String[] { username, email });
/*     */       }
/* 206 */       Set<Roles> rolesList = request.getRoles();
/* 207 */       for (Roles role : rolesList) {
/* 208 */         Optional<Roles> rolesCheck = this.rolesRepository.findById(role.getId());
/* 209 */         if (!rolesCheck.isPresent()) {
/* 210 */           return this.apiError.getError("810", new String[] { role.getName() });
/*     */         }
/*     */       } 
/*     */       
/* 214 */       Set<Groups> grList = request.getGroups();
/* 215 */       for (Groups g : grList) {
/* 216 */         Optional<Groups> gC = this.groupRepository.findById(g.getId());
/* 217 */         if (!gC.isPresent()) {
/* 218 */           return this.apiError.getError("810", new String[] { g.getName() });
/*     */         }
/*     */       } 
/* 221 */       Users users1 = (Users)this.modelMapper.map(request, Users.class);
/* 222 */       String password = request.getPassword();
/* 223 */       password = this.jBcryptHelper.generatePasswordByHashPlantext(password);
/* 224 */       users1.setPassword(password);
/* 225 */       users1.setCreatedAt(new Date());
/* 226 */       users1.setUsername(username);
/* 227 */       Users result = (Users)this.userRepository.saveAndFlush(users1);
/*     */       
/* 229 */       this.modelHasRolesRepository.deleteAllByUsrUid(Integer.valueOf(Math.toIntExact(result.getId().intValue())));
/* 230 */       for (Roles role : rolesList) {
/* 231 */         this.modelHasRolesRepository.saveMHR(role.getId(), "App\\User", result.getId());
/*     */       }
/*     */       
/* 234 */       this.modelHasGroupRepository.deleteAllByUsrUid(Integer.valueOf(Math.toIntExact(result.getId().intValue())));
/* 235 */       for (Groups g : grList) {
/* 236 */         this.modelHasGroupRepository.saveMHR(g.getId(), "App\\Group", result.getId());
/*     */       }
/*     */       
/* 239 */       data.put("id", result.getId());
/* 240 */       rs.put("status", "OK");
/* 241 */       rs.put("responseCode", "00");
/* 242 */       rs.put("data", data);
/*     */     }
/* 244 */     catch (Exception e) {
/* 245 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 246 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 247 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 250 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/user/{id}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse updateBy(@PathVariable Integer id, @Valid @RequestBody UsersRequest request) {
/* 257 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 259 */       String username = request.getUsername().toLowerCase(Locale.ROOT);
/* 260 */       Optional<Users> users = this.userRepository.findById(id);
/* 261 */       if (!users.isPresent())
/* 262 */         return this.apiError.getError("805", new String[] { String.valueOf(id) }); 
/* 263 */       if (!username.equals(((Users)users.get()).getUsername())) {
/* 264 */         return this.apiError.getError("805", new String[] { username });
/*     */       }
/*     */       
/* 267 */       List<Roles> rolesList = request.getRoles();
/* 268 */       for (Roles role : rolesList) {
/* 269 */         Optional<Roles> rolesCheck = this.rolesRepository.findById(role.getId());
/* 270 */         if (!rolesCheck.isPresent()) {
/* 271 */           return this.apiError.getError("810", new String[] { role.getName() });
/*     */         }
/*     */       } 
/*     */       
/* 275 */       Set<Groups> grList = request.getGroups();
/* 276 */       for (Groups g : grList) {
/* 277 */         Optional<Groups> gC = this.groupRepository.findById(g.getId());
/* 278 */         if (!gC.isPresent()) {
/* 279 */           return this.apiError.getError("810", new String[] { g.getName() });
/*     */         }
/*     */       } 
/*     */       
/* 283 */       request.setId(id);
/* 284 */       request.setUpdatedAt(new Date());
/* 285 */       request.setPassword(((Users)users.get()).getPassword());
/* 286 */       request.setApiToken(((Users)users.get()).getApiToken());
/* 287 */       request.setRememberToken(((Users)users.get()).getRememberToken());
/* 288 */       Users users1 = (Users)this.modelMapper.map(request, Users.class);
/* 289 */       Users result = (Users)this.userRepository.save(users1);
/*     */       
/* 291 */       this.modelHasRolesRepository.deleteAllByUsrUid(Integer.valueOf(Math.toIntExact(result.getId().intValue())));
/* 292 */       for (Roles role : rolesList) {
/* 293 */         this.modelHasRolesRepository.saveMHR(role.getId(), "App\\User", result.getId());
/*     */       }
/*     */       
/* 296 */       this.modelHasGroupRepository.deleteAllByUsrUid(Integer.valueOf(Math.toIntExact(result.getId().intValue())));
/* 297 */       for (Groups g : grList) {
/* 298 */         this.modelHasGroupRepository.saveMHR(g.getId(), "App\\Group", result.getId());
/*     */       }
/*     */       
/* 301 */       rs.put("status", "OK");
/* 302 */       rs.put("responseCode", "00");
/*     */     }
/* 304 */     catch (Exception e) {
/* 305 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 306 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 307 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 310 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/user/password/{id}"})
/*     */   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, Throwable.class})
/*     */   public ApiResponse changePassword(@PathVariable Integer id, @RequestBody UserPassword request) {
/* 317 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 319 */       Optional<Users> usersOp = this.userRepository.findById(id);
/* 320 */       if (!usersOp.isPresent()) {
/* 321 */         return this.apiError.getError("805", new String[] { String.valueOf(id) });
/*     */       }
/* 323 */       Users users = usersOp.get();
/* 324 */       if (this.jBcryptHelper.checkBcryptPassword(request.getOldPassword(), users.getPassword()).booleanValue()) {
/* 325 */         users.setPassword(this.jBcryptHelper.generatePasswordByHashPlantext(request.getNewPassword()));
/* 326 */         users.setRememberToken(null);
/* 327 */         users.setApiToken(null);
/* 328 */         this.userRepository.save(users);
/*     */       } else {
/* 330 */         return this.apiError.getError("815", new String[0]);
/*     */       } 
/*     */       
/* 333 */       rs.put("status", "OK");
/* 334 */       rs.put("responseCode", "00");
/*     */     }
/* 336 */     catch (Exception e) {
/* 337 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 338 */       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/* 339 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 342 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/user/{id}"})
/*     */   public ApiResponse deleteBy(@PathVariable Integer id) {
/* 347 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 351 */       Optional<Users> users = this.userRepository.findById(id);
/* 352 */       if (!users.isPresent()) {
/* 353 */         return this.apiError.getError("805", new String[] { String.valueOf(id) });
/*     */       }
/*     */       
/* 356 */       this.userRepository.delete(users.get());
/*     */       
/* 358 */       rs.put("status", "OK");
/* 359 */       rs.put("responseCode", "00");
/*     */     
/*     */     }
/* 362 */     catch (Exception e) {
/* 363 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 364 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 367 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/user/status/{id}/{status}"})
/*     */   public ApiResponse updateStatususer(@PathVariable Integer id, @PathVariable Integer status) {
/* 373 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 377 */       Optional<Users> users = this.userRepository.findById(id);
/* 378 */       if (!users.isPresent()) {
/* 379 */         return this.apiError.getError("805", new String[] { "id" });
/*     */       }
/*     */       
/* 382 */       Users usersUpdate = users.get();
/* 383 */       usersUpdate.setStatus(status);
/* 384 */       this.userRepository.save(usersUpdate);
/*     */       
/* 386 */       rs.put("status", "OK");
/* 387 */       rs.put("responseCode", "00");
/* 388 */     } catch (Exception e) {
/* 389 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 390 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 393 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/user/getDoctor"})
/*     */   public ApiResponse getDoctor() {
/* 398 */     ApiResponse rs = new ApiResponse();
/* 399 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 402 */       List<Users> users = this.userRepository.findAllByGroups(Integer.valueOf(5)).orElse(new ArrayList<>());
/*     */       
/* 404 */       rs.put("status", "OK");
/* 405 */       rs.put("responseCode", "00");
/* 406 */       rs.put("data", users.stream().map(u -> (UserResponse)this.modelMapper.map(u, UserResponse.class)));
/*     */     }
/* 408 */     catch (Exception e) {
/* 409 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 410 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*     */     
/* 413 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Controller\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */