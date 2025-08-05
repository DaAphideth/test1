/*     */ package nencer.app.Modules.Medic.Controller.TestCodeMapping;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.TestCode.MedicTestCode;
/*     */ import nencer.app.Modules.Medic.Entity.TestCode.MedicTestCodeMapping;
/*     */ import nencer.app.Modules.Medic.Model.Service.ServiceRequest;
/*     */ import nencer.app.Modules.Medic.Model.TestCode.TestCodeMappingModel;
/*     */ import nencer.app.Modules.Medic.Repository.TestCode.TestCodeMappingRepository;
/*     */ import nencer.app.Modules.Medic.Repository.TestCode.TestCodeRepository;
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
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class TestCodeMappingController extends BaseMedicController {
/*     */   @Autowired
/*     */   TestCodeRepository codeRepository;
/*     */   
/*     */   @PostMapping({"/test_code_mapping/create1"})
/*     */   public ApiResponse createTestCodeMapping1(@Valid @RequestBody List<TestCodeMappingModel> testCodeMappingModels) {
/*  37 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  40 */       if (testCodeMappingModels.size() > 0) {
/*  41 */         List<MedicTestCodeMapping> codeMappings = new ArrayList<>();
/*  42 */         testCodeMappingModels.forEach(c -> {
/*     */               this.codeMappingRepository.deleteAllByTestCode(c.getTestCode());
/*     */               codeMappings.add(this.modelMapper.map(c, MedicTestCodeMapping.class));
/*     */             });
/*  46 */         this.codeMappingRepository.saveAll(codeMappings);
/*     */       } 
/*     */       
/*  49 */       rs.put("status", "OK");
/*  50 */       rs.put("responseCode", "00");
/*     */     }
/*  52 */     catch (Exception e) {
/*  53 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  54 */       logger.error(exceptionAsString);
/*  55 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  57 */     return rs;
/*     */   } @Autowired
/*     */   TestCodeMappingRepository codeMappingRepository;
/*     */   @PostMapping({"/test_code_mapping/create"})
/*     */   public ApiResponse createTestCodeMapping(@RequestBody TestCodeMappingModel request) {
/*  62 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  65 */       MedicTestCodeMapping testCodeMapping = this.codeMappingRepository.findByTestCode(request.getTestCode()).orElse(null);
/*  66 */       if (Objects.nonNull(testCodeMapping)) {
/*  67 */         return this.apiError.getError("05");
/*     */       }
/*     */       
/*  70 */       MedicTestCodeMapping testCodeMapping1 = this.codeMappingRepository.findAllByServiceId(request.getServiceId());
/*  71 */       if (Objects.nonNull(testCodeMapping1)) {
/*  72 */         return this.apiError.getError("514", new String[] { testCodeMapping1.getTestCode() });
/*     */       }
/*     */       
/*  75 */       MedicTestCodeMapping codeMapping = (MedicTestCodeMapping)this.modelMapper.map(request, MedicTestCodeMapping.class);
/*  76 */       this.codeMappingRepository.save(codeMapping);
/*     */       
/*  78 */       rs.put("status", "OK");
/*  79 */       rs.put("responseCode", "00");
/*     */     }
/*  81 */     catch (Exception e) {
/*  82 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  83 */       logger.error(exceptionAsString);
/*  84 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  86 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/test_code_mapping/edit/{testCode}"})
/*     */   public ApiResponse createTestCodeMapping(@RequestBody TestCodeMappingModel request, @Valid @PathVariable String testCode) {
/*  91 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/*  94 */       MedicTestCodeMapping testCodeMapping = this.codeMappingRepository.findByTestCode(request.getTestCode()).orElse(null);
/*  95 */       if (Objects.isNull(testCodeMapping)) {
/*  96 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/*  99 */       MedicTestCodeMapping testCodeMapping1 = this.codeMappingRepository.findAllByServiceId(request.getServiceId());
/* 100 */       if (Objects.nonNull(testCodeMapping1) && 
/* 101 */         !testCodeMapping.getServiceId().equals(request.getServiceId())) {
/* 102 */         return this.apiError.getError("514", new String[] { testCodeMapping1.getTestCode() });
/*     */       }
/*     */       
/* 105 */       MedicTestCodeMapping codeMapping = (MedicTestCodeMapping)this.modelMapper.map(request, MedicTestCodeMapping.class);
/* 106 */       this.codeMappingRepository.save(codeMapping);
/*     */       
/* 108 */       rs.put("status", "OK");
/* 109 */       rs.put("responseCode", "00");
/*     */     }
/* 111 */     catch (Exception e) {
/* 112 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 113 */       logger.error(exceptionAsString);
/* 114 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 116 */     return rs;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/test_code_mapping/get"})
/*     */   public ApiResponse getPage(@RequestParam(required = false) String testCode, @RequestParam(required = false) String testDevice, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 148 */     ApiResponse rs = new ApiResponse();
/* 149 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 151 */       List<TestCodeMappingModel> medicTestDevice = this.medicService.sp_get_search_test_code_mapping(page, size, testCode, testDevice);
/*     */       
/* 153 */       data.put("testCode", medicTestDevice);
/* 154 */       data.put("totalItems", Integer.valueOf((medicTestDevice.size() > 0) ? ((TestCodeMappingModel)medicTestDevice.get(0)).getTotalRecord().intValue() : 0));
/*     */       
/* 156 */       rs.put("status", "OK");
/* 157 */       rs.put("responseCode", "00");
/* 158 */       rs.put("data", data);
/*     */     
/*     */     }
/* 161 */     catch (Exception e) {
/* 162 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 163 */       logger.error(exceptionAsString);
/* 164 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 166 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/test_code_mapping/delete"})
/*     */   public ApiResponse deleteTestCodeMapping(@Valid @RequestParam String testCode) {
/* 171 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 173 */       MedicTestCodeMapping testCodeMapping = this.codeMappingRepository.findByTestCode(testCode).orElse(null);
/*     */       
/* 175 */       if (Objects.isNull(testCodeMapping)) {
/* 176 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 179 */       this.codeMappingRepository.deleteAllByTestCode(testCode);
/*     */       
/* 181 */       rs.put("status", "OK");
/* 182 */       rs.put("responseCode", "00");
/*     */     }
/* 184 */     catch (Exception e) {
/* 185 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 186 */       logger.error(exceptionAsString);
/* 187 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 189 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_service/get_service"})
/*     */   public ApiResponse getService() {
/* 194 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 196 */       List<ServiceRequest> serviceRequests = this.medicService.spGetMedicService();
/*     */       
/* 198 */       rs.put("status", "OK");
/* 199 */       rs.put("responseCode", "00");
/* 200 */       rs.put("dataRes", serviceRequests);
/*     */     }
/* 202 */     catch (Exception e) {
/* 203 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 204 */       logger.error(exceptionAsString);
/* 205 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 207 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"test_code/get_all"})
/*     */   public ApiResponse getTestCode() {
/* 212 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 214 */       List<MedicTestCode> testCodes = this.codeRepository.findAll();
/*     */       
/* 216 */       rs.put("status", "OK");
/* 217 */       rs.put("responseCode", "00");
/* 218 */       rs.put("dataRes", testCodes);
/*     */     }
/* 220 */     catch (Exception e) {
/* 221 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 222 */       logger.error(exceptionAsString);
/* 223 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 225 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\TestCodeMapping\TestCodeMappingController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */