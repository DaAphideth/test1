/*     */ package nencer.app.Modules.MasterData.Controller;
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.CacheRedis.CacheData;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.MasterData.Model.TypeMdm;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class MedicMasterDataController extends BaseStorehoseController {
/*  31 */   public static final Logger logger = LoggerFactory.getLogger(MedicMasterDataController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   MedicMasterDataRepository medicMasterDataRepository;
/*     */   
/*     */   @Autowired
/*     */   CacheDataRepository cacheDataRepository;
/*     */   
/*     */   public static final String MASTER_DATA = "masterData";
/*     */   
/*     */   @GetMapping({"/medic_mdm/get_all"})
/*     */   public ApiResponse getAll() {
/*  46 */     ApiResponse rs = new ApiResponse();
/*  47 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  50 */       List<MedicMasterData> medicMasterDatas = this.medicMasterDataRepository.findAll();
/*  51 */       data.put("medicMasterDatas", medicMasterDatas);
/*     */       
/*  53 */       rs.put("status", "OK");
/*  54 */       rs.put("responseCode", "00");
/*  55 */       rs.put("data", data);
/*     */     }
/*  57 */     catch (Exception e) {
/*  58 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  59 */       logger.error(exceptionAsString);
/*  60 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  62 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_mdm/type"})
/*     */   public ApiResponse getAllByType(@RequestParam(required = false) String type) {
/*  67 */     ApiResponse rs = new ApiResponse();
/*  68 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/*  71 */       List<MedicMasterData> medicMasterDatas = this.medicMasterDataRepository.findAllByMedicType(type);
/*  72 */       data.put("medicMasterDatas", medicMasterDatas);
/*     */       
/*  74 */       rs.put("status", "OK");
/*  75 */       rs.put("responseCode", "00");
/*  76 */       rs.put("data", data);
/*     */     }
/*  78 */     catch (Exception e) {
/*  79 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  80 */       logger.error(exceptionAsString);
/*  81 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  83 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_mdm_by_type"})
/*     */   public ApiResponse getMdmByType(@RequestParam(required = false) String type) {
/*  88 */     ApiResponse rs = new ApiResponse();
/*  89 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  91 */       List<MedicMasterData> dataList = new ArrayList<>();
/*  92 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("masterData" + type.toUpperCase());
/*  93 */       if (optionalCacheData.isPresent()) {
/*  94 */         String opCacheData = ((CacheData)optionalCacheData.get()).getValue();
/*  95 */         dataList = (List<MedicMasterData>)this.objectMapper.readValue(opCacheData, new TypeReference<List<MedicMasterData>>() {  }
/*     */           );
/*     */       } else {
/*  98 */         dataList = this.medicMasterDataRepository.findAllByMedicType(type);
/*  99 */         String masterDataJsonString = this.objectMapper.writeValueAsString(dataList);
/* 100 */         CacheData cacheData = new CacheData("masterData" + type.toUpperCase(), masterDataJsonString);
/* 101 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/* 103 */       data.put("medicMasterDatas", dataList);
/* 104 */       rs.put("status", "OK");
/* 105 */       rs.put("responseCode", "00");
/* 106 */       rs.put("data", data);
/*     */     }
/* 108 */     catch (Exception e) {
/* 109 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 110 */       logger.error(exceptionAsString);
/* 111 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 113 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_mdm/get_type"})
/*     */   public ApiResponse getAllType() {
/* 118 */     ApiResponse rs = new ApiResponse();
/* 119 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 121 */       List<MedicMasterData> types = new ArrayList<>();
/* 122 */       Optional<CacheData> optionalCacheData = this.cacheDataRepository.findById("masterData");
/* 123 */       if (optionalCacheData.isPresent()) {
/* 124 */         String opCacheData = ((CacheData)optionalCacheData.get()).getValue();
/* 125 */         types = (List<MedicMasterData>)this.objectMapper.readValue(opCacheData, new TypeReference<List<MedicMasterData>>() {  }
/*     */           );
/*     */       } else {
/* 128 */         List<TypeMdm> getTypeMdm = this.medicMasterDataRepository.getAllType();
/* 129 */         types = (List<MedicMasterData>)getTypeMdm.stream().map(x -> (MedicMasterData)this.modelMapper.map(x, MedicMasterData.class)).collect(Collectors.toList());
/* 130 */         String masterDataJsonString = this.objectMapper.writeValueAsString(types);
/* 131 */         CacheData cacheData = new CacheData("masterData", masterDataJsonString);
/* 132 */         this.cacheDataRepository.save(cacheData);
/*     */       } 
/* 134 */       data.put("types", types);
/*     */       
/* 136 */       rs.put("status", "OK");
/* 137 */       rs.put("responseCode", "00");
/* 138 */       rs.put("data", data);
/*     */     }
/* 140 */     catch (Exception e) {
/* 141 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 142 */       logger.error(exceptionAsString);
/* 143 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 145 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_mdm"})
/*     */   public ApiResponse create(@Valid @RequestBody MedicMasterData request) {
/* 150 */     ApiResponse rs = new ApiResponse();
/* 151 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 153 */       String code = request.getMedicCode();
/* 154 */       String type = request.getMedicType();
/*     */       
/* 156 */       if (StringUtils.isBlank(type) || StringUtils.isBlank(code)) {
/* 157 */         return this.apiError.getError("02");
/*     */       }
/* 159 */       Optional<MedicMasterData> g = this.medicMasterDataRepository.findByMedicTypeAndMedicCode(type, code);
/* 160 */       if (g.isPresent()) {
/* 161 */         return this.apiError.getError("203", new String[] { code });
/*     */       }
/* 163 */       MedicMasterData result = (MedicMasterData)this.medicMasterDataRepository.saveAndFlush(request);
/*     */       
/* 165 */       this.cacheDataRepository.deleteById("masterData" + type.toUpperCase());
/* 166 */       saveRedisMasterDataType(type);
/* 167 */       this.cacheDataRepository.deleteById("masterData");
/* 168 */       saveRedisMasterData();
/* 169 */       data.put("id", result.getMedicCode());
/* 170 */       rs.put("status", "OK");
/* 171 */       rs.put("responseCode", "00");
/* 172 */       rs.put("data", data);
/*     */     }
/* 174 */     catch (Exception e) {
/* 175 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 176 */       logger.error(exceptionAsString);
/* 177 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 179 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_mdm"})
/*     */   public ApiResponse edit(@Valid @RequestBody MedicMasterData request) {
/* 184 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 186 */       String code = request.getMedicCode();
/* 187 */       String type = request.getMedicType();
/*     */       
/* 189 */       if (StringUtils.isBlank(type) || StringUtils.isBlank(code)) {
/* 190 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 193 */       Optional<MedicMasterData> g = this.medicMasterDataRepository.findByMedicTypeAndMedicCode(type, code);
/* 194 */       if (!g.isPresent()) {
/* 195 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 198 */       this.medicMasterDataRepository.saveAndFlush(request);
/*     */ 
/*     */       
/* 201 */       this.cacheDataRepository.deleteById("masterData" + type.toUpperCase());
/* 202 */       saveRedisMasterDataType(type);
/* 203 */       this.cacheDataRepository.deleteById("masterData");
/* 204 */       saveRedisMasterData();
/* 205 */       rs.put("status", "OK");
/* 206 */       rs.put("responseCode", "00");
/* 207 */     } catch (Exception e) {
/* 208 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 209 */       logger.error(exceptionAsString);
/* 210 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 212 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/medic_mdm/{medicType}/{medicCode}"})
/*     */   public ApiResponse delete(@PathVariable @Valid String medicType, @PathVariable @Valid String medicCode) {
/* 218 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 221 */       if (StringUtils.isBlank(medicType) || StringUtils.isBlank(medicCode)) {
/* 222 */         return this.apiError.getError("804", new String[] { "medicCode hoặc medicType" });
/*     */       }
/*     */       
/* 225 */       Optional<MedicMasterData> g = this.medicMasterDataRepository.findByMedicTypeAndMedicCode(medicType, medicCode);
/* 226 */       if (!g.isPresent()) {
/* 227 */         return this.apiError.getError("202", new String[] { medicCode });
/*     */       }
/*     */ 
/*     */       
/* 231 */       this.medicMasterDataRepository.delete(g.get());
/*     */ 
/*     */       
/* 234 */       this.cacheDataRepository.deleteById("masterData" + medicType.toUpperCase());
/* 235 */       saveRedisMasterDataType(medicType);
/* 236 */       this.cacheDataRepository.deleteById("masterData");
/* 237 */       saveRedisMasterData();
/* 238 */       rs.put("status", "OK");
/* 239 */       rs.put("responseCode", "00");
/* 240 */     } catch (Exception e) {
/* 241 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 242 */       logger.error(exceptionAsString);
/* 243 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 245 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveRedisMasterDataType(String type) throws JsonProcessingException {
/* 250 */     List<MedicMasterData> dataList = this.medicMasterDataRepository.findAllByMedicType(type);
/* 251 */     if (CollectionUtils.isNotEmpty(dataList)) {
/* 252 */       String masterDataJsonString = this.objectMapper.writeValueAsString(dataList);
/* 253 */       CacheData cacheData = new CacheData("masterData" + type.toUpperCase(), masterDataJsonString);
/* 254 */       this.cacheDataRepository.save(cacheData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveRedisMasterData() throws JsonProcessingException {
/* 259 */     List<MedicMasterData> dataList = this.medicMasterDataRepository.findAll();
/* 260 */     if (CollectionUtils.isNotEmpty(dataList)) {
/* 261 */       String masterDataJsonString = this.objectMapper.writeValueAsString(dataList);
/* 262 */       CacheData cacheData = new CacheData("masterData", masterDataJsonString);
/* 263 */       this.cacheDataRepository.save(cacheData);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\MasterData\Controller\MedicMasterDataController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */