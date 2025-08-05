/*     */ package nencer.app.Modules.Medic.Controller.Room;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
/*     */ import nencer.app.Modules.Medic.Repository.Checkin.CheckinRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomNumberRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Room.RoomRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
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
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class RoomNumberController
/*     */ {
/*  43 */   public static final Logger logger = LoggerFactory.getLogger(RoomNumberController.class);
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
/*     */   @Autowired
/*     */   ApiError apiError;
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
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
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
/*     */   @Autowired
/*     */   RoomRepository roomRepository;
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
/*     */   @Autowired
/*     */   RoomNumberRepository roomNumberRepository;
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
/*     */   @Autowired
/*     */   CheckinRepository checkinRepository;
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
/*     */   @GetMapping({"/medic_room/getAllRoomNumber/{doctorId}/{roomType}"})
/*     */   public ApiResponse getAllRoomNumber(@PathVariable Integer doctorId, @PathVariable @Valid String roomType) {
/* 125 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/*     */     try {
/* 129 */       List<MedicRooms> roomNumbers = this.roomRepository.findAllByRoomTypeStAndDocterId(roomType, doctorId).orElse(null);
/*     */       
/* 131 */       rs.put("status", "OK");
/* 132 */       rs.put("responseCode", "00");
/* 133 */       rs.put("data", roomNumbers);
/*     */     }
/* 135 */     catch (Exception e) {
/* 136 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 137 */       logger.error(exceptionAsString);
/* 138 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 140 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Room\RoomNumberController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */