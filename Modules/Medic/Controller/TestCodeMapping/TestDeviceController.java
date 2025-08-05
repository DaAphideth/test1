/*     */ package nencer.app.Modules.Medic.Controller.TestCodeMapping;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.TestCode.MedicTestDevice;
/*     */ import nencer.app.Modules.Medic.Repository.TestCode.TestDeviceRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.logging.log4j.util.Strings;
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
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class TestDeviceController extends BaseMedicController {
/*     */   @GetMapping({"medic_test_device"})
/*     */   public ApiResponse getPage(@RequestParam(required = false) String name, @RequestParam(required = false) String code, @RequestParam(defaultValue = "1") String status, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  30 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  32 */       List<MedicTestDevice> medicTestDevice = this.medicService.sp_get_search_test_device(page, size, code, name, status);
/*     */       
/*  34 */       rs.put("status", "OK");
/*  35 */       rs.put("responseCode", "00");
/*  36 */       rs.put("data", medicTestDevice);
/*     */     }
/*  38 */     catch (Exception e) {
/*  39 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  40 */       logger.error(exceptionAsString);
/*  41 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  43 */     return rs;
/*     */   } @Autowired
/*     */   TestDeviceRepository testDeviceRepository; @GetMapping({"medic_test_device/getAll"})
/*     */   public ApiResponse getAll(@RequestParam String code) {
/*     */     List<MedicTestDevice> medicTestDevice;
/*  48 */     ApiResponse rs = new ApiResponse();
/*     */     
/*  50 */     if (Strings.isBlank(code)) {
/*  51 */       medicTestDevice = this.testDeviceRepository.findAllByStatus("1").orElse(new ArrayList<>());
/*     */     } else {
/*  53 */       medicTestDevice = this.testDeviceRepository.findByCodeAndStatus(code, "1").orElse(new ArrayList<>());
/*     */     } 
/*  55 */     rs.put("status", "OK");
/*  56 */     rs.put("responseCode", "00");
/*  57 */     rs.put("data", medicTestDevice);
/*     */ 
/*     */     
/*  60 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_test_device/create"})
/*     */   public ApiResponse create(@RequestBody MedicTestDevice request) {
/*  65 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  67 */       Optional<MedicTestDevice> medicTestDevice = this.testDeviceRepository.findByCode(request.getCode());
/*  68 */       if (medicTestDevice.isPresent()) {
/*  69 */         return this.apiError.getError("05", new String[0]);
/*     */       }
/*  71 */       this.testDeviceRepository.saveAndFlush(request);
/*  72 */       rs.put("status", "OK");
/*  73 */       rs.put("responseCode", "00");
/*  74 */       rs.put("data", request);
/*  75 */     } catch (Exception e) {
/*  76 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  77 */       logger.error(exceptionAsString);
/*  78 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  80 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_test_device/edit/{id}"})
/*     */   public ApiResponse create(@PathVariable @Valid Integer id, @RequestBody MedicTestDevice request) {
/*  85 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  87 */       if (id == null) {
/*  88 */         return this.apiError.getError("02");
/*     */       }
/*  90 */       Optional<MedicTestDevice> testDevice = this.testDeviceRepository.findById(id);
/*  91 */       if (!testDevice.isPresent()) {
/*  92 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/*  94 */       Optional<MedicTestDevice> medicTestDevice = this.testDeviceRepository.findByCode(request.getCode());
/*  95 */       if (medicTestDevice.isPresent() && !((MedicTestDevice)testDevice.get()).getCode().equals(request.getCode())) {
/*  96 */         return this.apiError.getError("05", new String[0]);
/*     */       }
/*     */       
/*  99 */       this.testDeviceRepository.saveAndFlush(request);
/* 100 */       rs.put("status", "OK");
/* 101 */       rs.put("responseCode", "00");
/* 102 */       rs.put("data", request);
/* 103 */     } catch (Exception e) {
/* 104 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 105 */       logger.error(exceptionAsString);
/* 106 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 108 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_test_device/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 113 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 116 */       if (id == null) {
/* 117 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 120 */       Optional<MedicTestDevice> g = this.testDeviceRepository.findById(id);
/* 121 */       if (!g.isPresent()) {
/* 122 */         return this.apiError.getError("02");
/*     */       }
/*     */ 
/*     */       
/* 126 */       this.testDeviceRepository.deleteByTestDevice(id);
/*     */       
/* 128 */       rs.put("status", "OK");
/* 129 */       rs.put("responseCode", "00");
/*     */     }
/* 131 */     catch (Exception e) {
/* 132 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 133 */       logger.error(exceptionAsString);
/* 134 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 136 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\TestCodeMapping\TestDeviceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */