/*    */ package nencer.app.Modules.Medic.Controller.CustomerOrdinal;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*    */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*    */ import nencer.app.Modules.Medic.Model.CustomerOrdinal.OrdinalDoorResponse;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.apache.logging.log4j.util.Strings;
/*    */ import org.modelmapper.ModelMapper;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class OrdinalDoorController
/*    */   extends BaseMedicController
/*    */ {
/*    */   @Autowired
/*    */   ModelMapper modelMapper;
/*    */   
/*    */   @GetMapping({"/ordinal-door"})
/*    */   public ApiResponse generateNumber(@RequestParam String takeNumber) {
/* 36 */     ApiResponse rs = new ApiResponse();
/* 37 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 39 */       List<MedicMasterData> mdm = new ArrayList<>();
/* 40 */       if (Strings.isNotBlank(takeNumber)) {
/* 41 */         mdm = this.medicMasterDataRepository.findAllByMedicTypeAndDefaultValue("ordinal_door", takeNumber).orElse(new ArrayList<>());
/*    */       } else {
/* 43 */         mdm = this.medicMasterDataRepository.findAllByMedicType("ordinal_door");
/*    */       } 
/* 45 */       data.put("medicOrdinalDoor", mdm.stream()
/* 46 */           .map(mod -> OrdinalDoorResponse.builder().name(mod.getMedicName()).id(mod.getMedicCode()).code(mod.getDefaultValue()).build())
/*    */ 
/*    */ 
/*    */           
/* 50 */           .collect(Collectors.toList()));
/* 51 */       rs.put("status", "OK");
/* 52 */       rs.put("responseCode", "00");
/* 53 */       rs.put("data", data);
/* 54 */     } catch (Exception e) {
/* 55 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 56 */       logger.error(exceptionAsString);
/* 57 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 59 */     return rs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\CustomerOrdinal\OrdinalDoorController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */