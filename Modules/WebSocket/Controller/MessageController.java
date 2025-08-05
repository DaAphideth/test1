/*    */ package nencer.app.Modules.WebSocket.Controller;
/*    */ 
/*    */ import java.util.Date;
/*    */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*    */ import nencer.app.Modules.Medic.Controller.CustomerOrdinal.CustomerOrdinalController;
/*    */ import nencer.app.Modules.Medic.Service.MedicService;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.messaging.handler.annotation.MessageMapping;
/*    */ import org.springframework.messaging.handler.annotation.Payload;
/*    */ import org.springframework.messaging.handler.annotation.SendTo;
/*    */ import org.springframework.messaging.simp.SimpMessagingTemplate;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ public class MessageController
/*    */   extends BaseMedicController
/*    */ {
/*    */   @Autowired
/*    */   private SimpMessagingTemplate template;
/*    */   @Autowired
/*    */   MedicService medicService;
/*    */   @Autowired
/*    */   CustomerOrdinalController customerOrdinalController;
/*    */   
/*    */   public void sendMessages() {
/* 50 */     this.template.convertAndSend("/api/topic/messages", "Hallo  at " + (new Date())
/* 51 */         .toString());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @MessageMapping({"/api/ws/checkin/window-calling-number"})
/*    */   @SendTo({"/api/topic/checkin/window-calling-number"})
/*    */   public ApiResponse sendCheckin(@Payload ApiResponse apiResponse) {
/* 61 */     return apiResponse;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @MessageMapping({"/api/ws/examination/window-calling-number"})
/*    */   @SendTo({"/api/topic/examination/window-calling-number"})
/*    */   public ApiResponse sendExamination(@Payload ApiResponse apiResponse) {
/* 70 */     return apiResponse;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 74 */     String a = "1;2;3;4;";
/* 75 */     System.out.println(StringUtils.chop(a));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\WebSocket\Controller\MessageController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */