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
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicBed;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicChamber;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Medic.Model.Room.MedicBedResponse;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicBedRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.MedicChamberRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.TSpecification;
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
/*     */ public class MedicBedController extends BaseMedicController {
/*  34 */   public static final Logger logger = LoggerFactory.getLogger(MedicBedController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   private MedicBedRepository medicBedRepository;
/*     */   @Autowired
/*     */   private MedicChamberRepository medicChamberRepository;
/*     */   
/*     */   @GetMapping({"/medic_bed/get_all"})
/*     */   public ApiResponse getAll(@RequestParam(required = false) String filter) {
/*  49 */     ApiResponse rs = new ApiResponse();
/*  50 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  52 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*  53 */       if (!StringUtils.isEmpty(filter)) {
/*  54 */         ObjectMapper objectMapper = new ObjectMapper();
/*  55 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/*  59 */       TSpecification specifications = new TSpecification(searchFilter);
/*     */       
/*  61 */       List<MedicBed> pages = this.medicBedRepository.findAll((Specification)specifications);
/*  62 */       data.put("MedicBed", pages);
/*     */       
/*  64 */       rs.put("status", "OK");
/*  65 */       rs.put("responseCode", "00");
/*  66 */       rs.put("data", data);
/*     */     }
/*  68 */     catch (Exception e) {
/*  69 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  70 */       logger.error(exceptionAsString);
/*  71 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  73 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_bed"})
/*     */   public ApiResponse getPaging(@RequestParam(required = false) String filter, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "id") String fieldSort, @RequestParam(defaultValue = "desc") String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  83 */     ApiResponse rs = new ApiResponse();
/*  84 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  86 */       List<MedicBedResponse> list = this.medicService.spGetSearchBed(page, size, searchValue, fieldSort, direction);
/*     */       
/*  88 */       data.put("dataRes", list);
/*  89 */       data.put("totalItems", Integer.valueOf((list.size() > 0) ? ((MedicBedResponse)list.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/*  91 */       rs.put("status", "OK");
/*  92 */       rs.put("responseCode", "00");
/*  93 */       rs.put("data", data);
/*     */     }
/*  95 */     catch (Exception e) {
/*  96 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  97 */       logger.error(exceptionAsString);
/*  98 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 100 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_bed/{id}"})
/*     */   public ApiResponse getById(@PathVariable @Valid Integer id) {
/* 105 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 108 */       if (id == null) {
/* 109 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 112 */       Optional<MedicBed> g = this.medicBedRepository.findById(id);
/* 113 */       if (!g.isPresent()) {
/* 114 */         return this.apiError.getError("02");
/*     */       }
/* 116 */       rs.put("status", "OK");
/* 117 */       rs.put("responseCode", "00");
/* 118 */       rs.put("data", g.get());
/*     */     }
/* 120 */     catch (Exception e) {
/* 121 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 122 */       logger.error(exceptionAsString);
/* 123 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 125 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_bed/create"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicBed request) {
/* 130 */     ApiResponse rs = new ApiResponse();
/* 131 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 133 */       MedicBed medicBed = this.medicBedRepository.findByCode(request.getCode());
/* 134 */       if (Objects.nonNull(medicBed)) {
/* 135 */         return this.apiError.getError("05");
/*     */       }
/* 137 */       MedicBed result = (MedicBed)this.medicBedRepository.saveAndFlush(request);
/*     */       
/* 139 */       data.put("id", result.getId());
/* 140 */       rs.put("status", "OK");
/* 141 */       rs.put("responseCode", "00");
/* 142 */       rs.put("data", data);
/*     */     }
/* 144 */     catch (Exception e) {
/* 145 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 146 */       logger.error(exceptionAsString);
/* 147 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 149 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping({"/medic_bed/edit/{id}"})
/*     */   public ApiResponse edit(@PathVariable @Valid Integer id, @Valid @RequestBody MedicBed request) {
/* 155 */     ApiResponse rs = new ApiResponse();
/* 156 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 159 */       if (id == null) {
/* 160 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 163 */       Optional<MedicBed> g = this.medicBedRepository.findById(id);
/* 164 */       if (!g.isPresent()) {
/* 165 */         return this.apiError.getError("02");
/*     */       }
/* 167 */       MedicBed medicBed = this.medicBedRepository.findByCode(request.getCode());
/* 168 */       if (Objects.nonNull(medicBed) && !((MedicBed)g.get()).getCode().equals(medicBed.getCode())) {
/* 169 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/* 172 */       request.setId(id);
/*     */ 
/*     */       
/* 175 */       this.medicBedRepository.saveAndFlush(request);
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
/*     */   @DeleteMapping({"/medic_bed/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 191 */     ApiResponse rs = new ApiResponse();
/* 192 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 195 */       if (id == null) {
/* 196 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 199 */       Optional<MedicBed> g = this.medicBedRepository.findById(id);
/* 200 */       if (!g.isPresent()) {
/* 201 */         return this.apiError.getError("02");
/*     */       }
/* 203 */       Optional<MedicChamber> medicChamber = this.medicChamberRepository.findById(((MedicBed)g.get()).getChamberId());
/* 204 */       if (medicChamber.isPresent()) {
/* 205 */         return this.apiError.getError("513");
/*     */       }
/*     */ 
/*     */       
/* 209 */       this.medicBedRepository.delete(g.get());
/* 210 */       rs.put("status", "OK");
/* 211 */       rs.put("responseCode", "00");
/* 212 */       rs.put("data", data);
/*     */     }
/* 214 */     catch (Exception e) {
/* 215 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 216 */       logger.error(exceptionAsString);
/* 217 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 219 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Room\MedicBedController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */