/*    */ package nencer.app.Modules.ComPort.Controller;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.validation.Valid;
/*    */ import nencer.app.Modules.ComPort.Service.SerialPortService;
/*    */ import nencer.app.Modules.Customer.Controller.CustomerController;
/*    */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class SerialPortController extends BaseMedicController {
/* 22 */   public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
/*    */   
/*    */   @Autowired
/*    */   SerialPortService serialPortService;
/*    */   
/*    */   @GetMapping({"/comport/startReading/{portName}"})
/*    */   public ApiResponse delete(@PathVariable @Valid String portName) {
/* 29 */     ApiResponse rs = new ApiResponse();
/* 30 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 32 */       this.serialPortService.readFromSerialPort(portName);
/*    */       
/* 34 */       rs.put("status", "OK");
/* 35 */       rs.put("responseCode", "00");
/* 36 */       rs.put("data", "Reading from COM port started");
/*    */     }
/* 38 */     catch (Exception e) {
/* 39 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 40 */       logger.error(exceptionAsString);
/* 41 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 43 */     return rs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\ComPort\Controller\SerialPortController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */