/*     */ package nencer.app.Modules.Medic.Controller.Room;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicChamber;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Room.MedicChamberResponse;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicChamberRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicChamberController extends BaseMedicController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(MedicChamberController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   private MedicChamberRepository medicChamberRepository;
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_chamber/get_all"})
/*     */   public ApiResponse getAll(@RequestParam(required = false) String filter) {
/*  48 */     ApiResponse rs = new ApiResponse();
/*  49 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  51 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  52 */       if (!StringUtils.isEmpty(filter)) {
/*  53 */         ObjectMapper objectMapper = new ObjectMapper();
/*  54 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  58 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  60 */       List<MedicChamber> pages = this.medicChamberRepository.findAll((Specification)specifications);
/*  61 */       data.put("medicChamber", pages);
/*     */       
/*  63 */       rs.put("status", "OK");
/*  64 */       rs.put("responseCode", "00");
/*  65 */       rs.put("data", data);
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  69 */       logger.error(exceptionAsString);
/*  70 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  72 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_chamber"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  82 */     ApiResponse rs = new ApiResponse();
/*  83 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  85 */       List<MedicChamberResponse> list = this.medicService.spGetSearchChamber(page, size, searchValue, fieldSort, direction);
/*     */       
/*  87 */       data.put("dataRes", list);
/*  88 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicChamberResponse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  90 */       rs.put("status", "OK");
/*  91 */       rs.put("responseCode", "00");
/*  92 */       rs.put("data", data);
/*     */     }
/*  94 */     catch (Exception e) {
/*  95 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  96 */       logger.error(exceptionAsString);
/*  97 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  99 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_chamber/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 104 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 107 */       if (id == null) {
/* 108 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 111 */       Optional<MedicChamber> g = this.medicChamberRepository.findById(id);
/* 112 */       if (!g.isPresent()) {
/* 113 */         return this.apiError.getError("02");
/*     */       }
/* 115 */       rs.put("status", "OK");
/* 116 */       rs.put("responseCode", "00");
/* 117 */       rs.put("data", g.get());
/*     */     }
/* 119 */     catch (Exception e) {
/* 120 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 121 */       logger.error(exceptionAsString);
/* 122 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 124 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_chamber/create"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicChamber request) {
/* 129 */     ApiResponse rs = new ApiResponse();
/* 130 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 132 */       MedicChamber medicChamber = this.medicChamberRepository.findByCode(request.getCode());
/* 133 */       if (Objects.nonNull(medicChamber)) {
/* 134 */         return this.apiError.getError("05");
/*     */       }
/* 136 */       MedicChamber result = (MedicChamber)this.medicChamberRepository.saveAndFlush(request);
/*     */       
/* 138 */       data.put("id", result.getId());
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
/*     */   
/*     */   @PutMapping({"/medic_chamber/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicChamber request) {
/* 154 */     ApiResponse rs = new ApiResponse();
/* 155 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 158 */       if (id == null) {
/* 159 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 162 */       Optional<MedicChamber> g = this.medicChamberRepository.findById(id);
/* 163 */       if (!g.isPresent()) {
/* 164 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 167 */       MedicChamber medicChamber = this.medicChamberRepository.findByCode(request.getCode());
/* 168 */       if (Objects.nonNull(medicChamber) && !((MedicChamber)g.get()).getCode().equals(medicChamber.getCode())) {
/* 169 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 172 */       request.setId(id);
/*     */ 
/*     */       
/* 175 */       this.medicChamberRepository.saveAndFlush(request);
/*     */       
/* 177 */       rs.put("status", "OK");
/* 178 */       rs.put("responseCode", "00");
/* 179 */       rs.put("data", data);
/*     */     }
/* 181 */     catch (Exception e) {
/* 182 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 183 */       logger.error(exceptionAsString);
/* 184 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 186 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_chamber/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 191 */     ApiResponse rs = new ApiResponse();
/* 192 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 195 */       if (id == null) {
/* 196 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 199 */       Optional<MedicChamber> g = this.medicChamberRepository.findById(id);
/* 200 */       if (!g.isPresent()) {
/* 201 */         return this.apiError.getError("02");
/*     */       }
/* 203 */       List<MedicCheckinRecord> checkinRecord = this.medicCheckinRecordRepository.findAllByBedId(((MedicChamber)g.get()).getId()).orElse(new ArrayList<>());
/* 204 */       if (CollectionUtils.isNotEmpty(checkinRecord)) {
/* 205 */         return this.apiError.getError("511");
/*     */       }
/*     */       
/* 208 */       this.medicChamberRepository.delete(g.get());
/* 209 */       rs.put("status", "OK");
/* 210 */       rs.put("responseCode", "00");
/* 211 */       rs.put("data", data);
/*     */     }
/* 213 */     catch (Exception e) {
/* 214 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 215 */       logger.error(exceptionAsString);
/* 216 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 218 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Room\MedicChamberController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */