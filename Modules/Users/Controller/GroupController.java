/*     */ package nencer.app.Modules.Users.Controller;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Users.Entity.Group.Groups;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Model.Group.GroupRequest;
/*     */ import nencer.app.Modules.Users.Model.Group.GroupResponse;
/*     */ import nencer.app.Modules.Users.Repository.GroupRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class GroupController {
/*  32 */   public static final Logger logger = LoggerFactory.getLogger(GroupController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   private ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   GroupRepository groupRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   UserRepository userRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/groups"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "desc", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  54 */     ApiResponse rs = new ApiResponse();
/*  55 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  58 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  59 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*     */       
/*  61 */       Page<Groups> pages = this.groupRepository.findAll((Pageable)pageable);
/*  62 */       data.put("groups", pages.stream().map(group -> (GroupResponse)this.modelMapper.map(group, GroupResponse.class)).collect(Collectors.toList()));
/*  63 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  64 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  66 */       rs.put("status", "OK");
/*  67 */       rs.put("responseCode", "00");
/*  68 */       rs.put("data", data);
/*     */     }
/*  70 */     catch (Exception e) {
/*  71 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  72 */       logger.error(exceptionAsString);
/*  73 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  75 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/groups/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  81 */     ApiResponse rs = new ApiResponse();
/*  82 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  85 */       if (id == null) {
/*  86 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  89 */       Optional<Groups> g = this.groupRepository.findById(id);
/*  90 */       if (!g.isPresent()) {
/*  91 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  94 */       rs.put("status", "OK");
/*  95 */       rs.put("responseCode", "00");
/*  96 */       rs.put("data", this.modelMapper.map(g.get(), GroupResponse.class));
/*     */     }
/*  98 */     catch (Exception e) {
/*  99 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 100 */       logger.error(exceptionAsString);
/* 101 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 103 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/groups/create"})
/*     */   public ApiResponse create(@Valid @RequestBody GroupRequest request) {
/* 108 */     ApiResponse rs = new ApiResponse();
/* 109 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 112 */       boolean exitsName = (this.groupRepository.checkExitCode(request.getName()).intValue() > 0);
/* 113 */       if (exitsName) {
/* 114 */         return this.apiError.getError("01", null);
/*     */       }
/*     */       
/* 117 */       this.groupRepository.saveAndFlush(Groups.builder()
/* 118 */           .name(request.getName())
/* 119 */           .code(request.getCode())
/* 120 */           .description(request.getDescription())
/* 121 */           .status((request.getStatus() == null) ? 1 : request.getStatus().intValue())
/* 122 */           .createdAt(new Date())
/* 123 */           .sort(Integer.valueOf((request.getSort() == null) ? 1 : request.getSort().intValue()))
/* 124 */           .build());
/*     */       
/* 126 */       rs.put("status", "OK");
/* 127 */       rs.put("responseCode", "00");
/* 128 */       rs.put("data", data);
/*     */     }
/* 130 */     catch (Exception e) {
/* 131 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 132 */       logger.error(exceptionAsString);
/* 133 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 135 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/groups/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody GroupRequest request) {
/* 140 */     ApiResponse rs = new ApiResponse();
/* 141 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 144 */       if (id == null) {
/* 145 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 148 */       Optional<Groups> g = this.groupRepository.findById(id);
/* 149 */       if (!g.isPresent()) {
/* 150 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 153 */       boolean exitsName = (this.groupRepository.checkExitCode(request.getName()).intValue() > 0);
/* 154 */       if (exitsName) {
/* 155 */         return this.apiError.getError("01");
/*     */       }
/*     */ 
/*     */       
/* 159 */       this.groupRepository.saveAndFlush(Groups.builder()
/* 160 */           .id(((Groups)g.get()).getId())
/* 161 */           .name(request.getName())
/* 162 */           .code(request.getCode())
/* 163 */           .description(request.getDescription())
/* 164 */           .status((request.getStatus() == null) ? 1 : request.getStatus().intValue())
/* 165 */           .updatedAt(new Date())
/* 166 */           .sort(Integer.valueOf((request.getSort() == null) ? 1 : request.getSort().intValue()))
/* 167 */           .build());
/*     */       
/* 169 */       rs.put("status", "OK");
/* 170 */       rs.put("responseCode", "00");
/* 171 */       rs.put("data", data);
/*     */     }
/* 173 */     catch (Exception e) {
/* 174 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 175 */       logger.error(exceptionAsString);
/* 176 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 178 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/groups/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 183 */     ApiResponse rs = new ApiResponse();
/* 184 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 187 */       if (id == null) {
/* 188 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 191 */       Optional<Groups> g = this.groupRepository.findById(id);
/* 192 */       if (!g.isPresent()) {
/* 193 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 196 */       Optional<List<Users>> checkGroupInUser = this.userRepository.findAllByGroups(id);
/* 197 */       if (checkGroupInUser.isPresent()) {
/* 198 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 201 */       this.groupRepository.delete(g.get());
/*     */       
/* 203 */       rs.put("status", "OK");
/* 204 */       rs.put("responseCode", "00");
/* 205 */       rs.put("data", data);
/*     */     }
/* 207 */     catch (Exception e) {
/* 208 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 209 */       logger.error(exceptionAsString);
/* 210 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 212 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Controller\GroupController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */