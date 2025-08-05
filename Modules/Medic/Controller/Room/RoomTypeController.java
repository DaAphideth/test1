/*     */ package nencer.app.Modules.Medic.Controller.Room;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRoomTypes;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Room.RoomTypeRequest;
/*     */ import nencer.app.Modules.Medic.Model.Room.RoomTypeResponse;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
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
/*     */ public class RoomTypeController {
/*  39 */   public static final Logger logger = LoggerFactory.getLogger(RoomTypeController.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomTypeRepository roomTypeRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   RoomRepository roomRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room_type"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  60 */     ApiResponse rs = new ApiResponse();
/*  61 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  63 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  64 */       if (!StringUtils.isEmpty(filter)) {
/*  65 */         ObjectMapper objectMapper = new ObjectMapper();
/*  66 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  69 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  70 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  71 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  73 */       Page<MedicRoomTypes> pages = this.roomTypeRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  74 */       data.put("medicProduct", pages.get());
/*  75 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  76 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  78 */       rs.put("status", "OK");
/*  79 */       rs.put("responseCode", "00");
/*  80 */       rs.put("data", data);
/*     */     }
/*  82 */     catch (Exception e) {
/*  83 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  84 */       logger.error(exceptionAsString);
/*  85 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  87 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room_type/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  93 */     ApiResponse rs = new ApiResponse();
/*  94 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  97 */       if (id == null) {
/*  98 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 101 */       Optional<MedicRoomTypes> g = this.roomTypeRepository.findById(id);
/* 102 */       if (!g.isPresent()) {
/* 103 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 106 */       rs.put("status", "OK");
/* 107 */       rs.put("responseCode", "00");
/* 108 */       rs.put("data", this.modelMapper.map(g.get(), RoomTypeResponse.class));
/*     */     }
/* 110 */     catch (Exception e) {
/* 111 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 112 */       logger.error(exceptionAsString);
/* 113 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 115 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_room_type/create"})
/*     */   public ApiResponse create(@Valid @RequestBody RoomTypeRequest request) {
/* 120 */     ApiResponse rs = new ApiResponse();
/* 121 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 123 */       MedicRoomTypes roomName = this.roomTypeRepository.findByName(request.getName()).orElse(null);
/* 124 */       if (Objects.nonNull(roomName)) {
/* 125 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 128 */       MedicRoomTypes roomCode = this.roomTypeRepository.findByCode(request.getCode()).orElse(null);
/* 129 */       if (Objects.nonNull(roomCode)) {
/* 130 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 133 */       MedicRoomTypes MedicRoomTypes = (MedicRoomTypes)this.modelMapper.map(request, MedicRoomTypes.class);
/* 134 */       MedicRoomTypes.setCreatedAt(new Date());
/* 135 */       MedicRoomTypes result = (MedicRoomTypes)this.roomTypeRepository.saveAndFlush(MedicRoomTypes);
/*     */       
/* 137 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 139 */       rs.put("status", "OK");
/* 140 */       rs.put("responseCode", "00");
/* 141 */       rs.put("data", data);
/*     */     }
/* 143 */     catch (Exception e) {
/* 144 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 145 */       logger.error(exceptionAsString);
/* 146 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 148 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_room_type/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody RoomTypeRequest request) {
/* 153 */     ApiResponse rs = new ApiResponse();
/* 154 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 157 */       if (id == null) {
/* 158 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 161 */       Optional<MedicRoomTypes> g = this.roomTypeRepository.findById(id);
/* 162 */       if (!g.isPresent()) {
/* 163 */         return this.apiError.getError("02");
/*     */       }
/* 165 */       MedicRoomTypes roomName = this.roomTypeRepository.findByName(request.getName()).orElse(null);
/* 166 */       if (Objects.nonNull(roomName) && !((MedicRoomTypes)g.get()).getName().equals(request.getName())) {
/* 167 */         return this.apiError.getError("01");
/*     */       }
/*     */       
/* 170 */       MedicRoomTypes roomCode = this.roomTypeRepository.findByCode(request.getCode()).orElse(null);
/* 171 */       if (Objects.nonNull(roomCode) && !((MedicRoomTypes)g.get()).getCode().equals(request.getCode())) {
/* 172 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 175 */       MedicRoomTypes MedicRoomTypes = (MedicRoomTypes)this.modelMapper.map(request, MedicRoomTypes.class);
/* 176 */       MedicRoomTypes.setId(id.intValue());
/* 177 */       MedicRoomTypes.setCreatedAt(((MedicRoomTypes)g.get()).getCreatedAt());
/* 178 */       MedicRoomTypes.setUpdatedAt(new Date());
/*     */ 
/*     */       
/* 181 */       this.roomTypeRepository.saveAndFlush(MedicRoomTypes);
/*     */       
/* 183 */       rs.put("status", "OK");
/* 184 */       rs.put("responseCode", "00");
/* 185 */       rs.put("data", data);
/*     */     }
/* 187 */     catch (Exception e) {
/* 188 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 189 */       logger.error(exceptionAsString);
/* 190 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 192 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_room_type/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 197 */     ApiResponse rs = new ApiResponse();
/* 198 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 201 */       if (id == null) {
/* 202 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 205 */       Optional<MedicRoomTypes> g = this.roomTypeRepository.findById(id);
/* 206 */       if (!g.isPresent()) {
/* 207 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 210 */       List<MedicRooms> medicRooms = this.roomRepository.findAllByRoomType(id).orElse(new ArrayList<>());
/* 211 */       if (CollectionUtils.isNotEmpty(medicRooms)) {
/* 212 */         return this.apiError.getError("507");
/*     */       }
/*     */ 
/*     */       
/* 216 */       this.roomTypeRepository.updateRoomTypeStatus(id);
/*     */       
/* 218 */       rs.put("status", "OK");
/* 219 */       rs.put("responseCode", "00");
/* 220 */       rs.put("data", data);
/*     */     }
/* 222 */     catch (Exception e) {
/* 223 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 224 */       logger.error(exceptionAsString);
/* 225 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 227 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_room_type/getAll"})
/*     */   public ApiResponse getAll() {
/* 231 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 234 */       List<MedicRoomTypes> medicRoomsList = this.roomTypeRepository.findAllByStatus(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       
/* 236 */       rs.put("status", "OK");
/* 237 */       rs.put("responseCode", "00");
/* 238 */       rs.put("data", medicRoomsList);
/*     */     }
/* 240 */     catch (Exception e) {
/* 241 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 242 */       logger.error(exceptionAsString);
/* 243 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 245 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Room\RoomTypeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */