/*     */ package nencer.app.Modules.Medic.Controller.Room;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ import nencer.app.Modules.Medic.Model.Room.RoomRequest;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class RoomController {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(RoomController.class);
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
/*     */   RoomRepository roomRepository;
/*     */   
/*     */   @Autowired
/*     */   RoomNumberRepository roomNumberRepository;
/*     */   
/*     */   @Autowired
/*     */   RoomTypeRepository roomTypeRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room"})
/*     */   public ApiResponse getPaging(@Valid @RequestParam(required = false) String filter, @RequestParam(defaultValue = "id", required = false) String fieldSort, @RequestParam(defaultValue = "DESC", required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  61 */     ApiResponse rs = new ApiResponse();
/*  62 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  65 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  66 */       if (!StringUtils.isEmpty(filter)) {
/*  67 */         ObjectMapper objectMapper = new ObjectMapper();
/*  68 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/*  71 */       PageRequest pageable = PageRequest.of(((page <= 0) ? 1 : page) - 1, size, direction.equalsIgnoreCase("desc") ? 
/*  72 */           Sort.by(new String[] { fieldSort }).descending() : Sort.by(new String[] { fieldSort }).ascending());
/*  73 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  75 */       Page<MedicRooms> pages = this.roomRepository.findAll((Specification)specifications, (Pageable)pageable);
/*  76 */       data.put("Rooms", pages.get());
/*  77 */       data.put("totalItems", Long.valueOf(pages.getTotalElements()));
/*  78 */       data.put("totalPages", Integer.valueOf(pages.getTotalPages()));
/*     */       
/*  80 */       rs.put("status", "OK");
/*  81 */       rs.put("responseCode", "00");
/*  82 */       rs.put("data", data);
/*     */     }
/*  84 */     catch (Exception e) {
/*  85 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  86 */       logger.error(exceptionAsString);
/*  87 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  89 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_room/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/*  94 */     ApiResponse rs = new ApiResponse();
/*  95 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  98 */       if (id == null) {
/*  99 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 102 */       Optional<MedicRooms> g = this.roomRepository.findById(id);
/* 103 */       if (!g.isPresent()) {
/* 104 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 107 */       rs.put("status", "OK");
/* 108 */       rs.put("responseCode", "00");
/* 109 */       rs.put("data", this.modelMapper.map(g.get(), RoomResponse.class));
/*     */     }
/* 111 */     catch (Exception e) {
/* 112 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 113 */       logger.error(exceptionAsString);
/* 114 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 116 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_room/create"})
/*     */   public ApiResponse create(@Valid @RequestBody RoomRequest request) {
/* 121 */     ApiResponse rs = new ApiResponse();
/* 122 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 124 */       MedicRooms roomName = this.roomRepository.findByName(request.getName()).orElse(null);
/* 125 */       if (Objects.nonNull(roomName)) {
/* 126 */         return this.apiError.getError("01");
/*     */       }
/* 128 */       MedicRooms roomCode = this.roomRepository.findByCode(request.getCode()).orElse(null);
/* 129 */       if (Objects.nonNull(roomCode)) {
/* 130 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 133 */       MedicRooms MedicRooms = (MedicRooms)this.modelMapper.map(request, MedicRooms.class);
/* 134 */       MedicRooms.setCreatedAt(new Date());
/* 135 */       MedicRooms.setPolyclinic(Integer.valueOf(1));
/* 136 */       MedicRooms.setBigClinic(Integer.valueOf(1));
/* 137 */       MedicRooms result = (MedicRooms)this.roomRepository.saveAndFlush(MedicRooms);
/*     */       
/* 139 */       data.put("id", Integer.valueOf(result.getId()));
/*     */       
/* 141 */       rs.put("status", "OK");
/* 142 */       rs.put("responseCode", "00");
/* 143 */       rs.put("data", data);
/*     */     }
/* 145 */     catch (Exception e) {
/* 146 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 147 */       logger.error(exceptionAsString);
/* 148 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 150 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_room/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody RoomRequest request) {
/* 155 */     ApiResponse rs = new ApiResponse();
/* 156 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 159 */       if (id == null) {
/* 160 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 163 */       Optional<MedicRooms> g = this.roomRepository.findById(id);
/* 164 */       if (!g.isPresent()) {
/* 165 */         return this.apiError.getError("02");
/*     */       }
/* 167 */       MedicRooms roomName = this.roomRepository.findByName(request.getName()).orElse(null);
/* 168 */       if (Objects.nonNull(roomName) && !((MedicRooms)g.get()).getName().equals(request.getName())) {
/* 169 */         return this.apiError.getError("01");
/*     */       }
/* 171 */       MedicRooms roomCode = this.roomRepository.findByCode(request.getCode()).orElse(null);
/* 172 */       if (Objects.nonNull(roomCode) && !((MedicRooms)g.get()).getCode().equals(request.getCode())) {
/* 173 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 176 */       MedicRooms MedicRooms = (MedicRooms)this.modelMapper.map(request, MedicRooms.class);
/* 177 */       MedicRooms.setId(id.intValue());
/* 178 */       MedicRooms.setPolyclinic(Integer.valueOf(1));
/* 179 */       MedicRooms.setBigClinic(Integer.valueOf(1));
/* 180 */       MedicRooms.setCreatedAt(((MedicRooms)g.get()).getCreatedAt());
/* 181 */       MedicRooms.setUpdatedAt(new Date());
/*     */       
/* 183 */       this.roomRepository.saveAndFlush(MedicRooms);
/*     */       
/* 185 */       rs.put("status", "OK");
/* 186 */       rs.put("responseCode", "00");
/* 187 */       rs.put("data", data);
/*     */     }
/* 189 */     catch (Exception e) {
/* 190 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 191 */       logger.error(exceptionAsString);
/* 192 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 194 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_room/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 199 */     ApiResponse rs = new ApiResponse();
/* 200 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 203 */       if (id == null) {
/* 204 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 207 */       Optional<MedicRooms> g = this.roomRepository.findById(id);
/* 208 */       if (!g.isPresent()) {
/* 209 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 218 */       this.roomRepository.updateRoomStatus(id);
/*     */       
/* 220 */       rs.put("status", "OK");
/* 221 */       rs.put("responseCode", "00");
/* 222 */       rs.put("data", data);
/*     */     }
/* 224 */     catch (Exception e) {
/* 225 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 226 */       logger.error(exceptionAsString);
/* 227 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 229 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room/getAll"})
/*     */   public ApiResponse getAll() {
/* 238 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 242 */       List<MedicRooms> medicRoomsList = this.roomRepository.findByStatusOrderBySort(Integer.valueOf(1), Arrays.asList(new String[] { "kham-benh" })).orElse(new ArrayList<>());
/*     */       
/* 244 */       rs.put("status", "OK");
/* 245 */       rs.put("responseCode", "00");
/* 246 */       rs.put("data", medicRoomsList);
/*     */     }
/* 248 */     catch (Exception e) {
/* 249 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 250 */       logger.error(exceptionAsString);
/* 251 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 253 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_room/getAllRoom"})
/*     */   public ApiResponse getAllRoom() {
/* 258 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 262 */       List<MedicRooms> medicRoomsList = this.roomRepository.findAllByStatus(Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       
/* 264 */       rs.put("status", "OK");
/* 265 */       rs.put("responseCode", "00");
/* 266 */       rs.put("data", medicRoomsList);
/*     */     }
/* 268 */     catch (Exception e) {
/* 269 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 270 */       logger.error(exceptionAsString);
/* 271 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 273 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room/getRoomNumberByRoomId/{roomId}"})
/*     */   public ApiResponse getRoomNumberByRoomId(@PathVariable @Valid String roomId) {
/* 281 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 287 */       if (StringUtils.isBlank(roomId) || roomId.equalsIgnoreCase("null")) {
/* 288 */         return this.apiError.getError("202", new String[] { roomId });
/*     */       }
/* 290 */       String[] roomIds = roomId.split("[,;]");
/* 291 */       List<Integer> ids = new ArrayList<>();
/* 292 */       for (String id : roomIds) {
/* 293 */         ids.add(Integer.valueOf(Integer.parseInt(id)));
/*     */       }
/* 295 */       Optional<List<MedicRooms>> medicRooms = this.roomRepository.findAllByIdIn(ids);
/* 296 */       if (!medicRooms.isPresent()) {
/* 297 */         return this.apiError.getError("202", new String[] { "Các phòng" });
/*     */       }
/*     */       
/* 300 */       rs.put("status", "OK");
/* 301 */       rs.put("responseCode", "00");
/* 302 */       rs.put("data", medicRooms.get());
/*     */     }
/* 304 */     catch (Exception e) {
/* 305 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 306 */       logger.error(exceptionAsString);
/* 307 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 309 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room/getAllRooms/{doctorId}/{roomType}"})
/*     */   public ApiResponse getAllRoomNumber(@PathVariable Integer doctorId, @PathVariable @Valid String roomType) {
/* 316 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 318 */       Optional<MedicRoomTypes> medicRoomTypes = this.roomTypeRepository.findByCode(roomType);
/* 319 */       if (!medicRoomTypes.isPresent()) {
/* 320 */         return this.apiError.getError("202", new String[] { roomType });
/*     */       }
/* 322 */       List<MedicRooms> roomNumbers = this.roomRepository.findAllByRoomTypeAndAllowUsers(Integer.valueOf(((MedicRoomTypes)medicRoomTypes.get()).getId()), doctorId.toString()).orElse(null);
/*     */       
/* 324 */       rs.put("status", "OK");
/* 325 */       rs.put("responseCode", "00");
/* 326 */       rs.put("data", roomNumbers);
/*     */     }
/* 328 */     catch (Exception e) {
/* 329 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 330 */       logger.error(exceptionAsString);
/* 331 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 333 */     return rs;
/*     */   }
/*     */   @GetMapping({"/medic_room/get-sample-handle"})
/*     */   public ApiResponse getSampleHandle(@RequestParam @Valid String roomType) {
/* 337 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 341 */       List<MedicRooms> medicRoomsList = this.roomRepository.findByStatusOrderBySort(Integer.valueOf(1), Collections.singletonList(roomType)).orElse(new ArrayList<>());
/*     */       
/* 343 */       rs.put("status", "OK");
/* 344 */       rs.put("responseCode", "00");
/* 345 */       rs.put("data", medicRoomsList);
/*     */     }
/* 347 */     catch (Exception e) {
/* 348 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 349 */       logger.error(exceptionAsString);
/* 350 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 352 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_room/getRoomInDepartment"})
/*     */   public ApiResponse getRoomInDepartment(@RequestParam Integer department) {
/* 360 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 364 */       List<MedicRooms> medicRoomsDepartment = this.roomRepository.findAllByDepartmentIdAndStatus(department, Integer.valueOf(1)).orElse(new ArrayList<>());
/*     */       
/* 366 */       rs.put("status", "OK");
/* 367 */       rs.put("responseCode", "00");
/* 368 */       rs.put("data", medicRoomsDepartment);
/*     */     }
/* 370 */     catch (Exception e) {
/* 371 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 372 */       logger.error(exceptionAsString);
/* 373 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 375 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Room\RoomController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */