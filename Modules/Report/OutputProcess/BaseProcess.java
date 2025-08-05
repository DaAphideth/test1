/*    */ package nencer.app.Modules.Report.OutputProcess;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import nencer.app.Modules.Medic.Controller.CheckinController;
/*    */ import nencer.app.Modules.Medic.Repository.Checkin.CommonTicketRepo;
/*    */ import nencer.app.Modules.Medic.Repository.Checkin.MedicCheckinRecordRepository;
/*    */ import nencer.app.Modules.Medic.Repository.Service.ServiceGroupRepository;
/*    */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
/*    */ import nencer.app.Modules.Report.Repository.CommonReportRepo;
/*    */ import nencer.app.Modules.Storehouse.Repository.CommonStoreHouseRepo;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class BaseProcess {
/* 18 */   public static final Logger logger = LoggerFactory.getLogger(CheckinController.class);
/*    */   @Autowired
/*    */   CommonReportRepo commonReportRepo;
/*    */   @Autowired
/*    */   ObjectMapper objectMapper;
/*    */   @Autowired
/*    */   CommonStoreHouseRepo commonStoreHouseRepo;
/*    */   @Autowired
/*    */   ServiceTypeRepository serviceTypeRepository;
/*    */   @Autowired
/*    */   CommonTicketRepo commonTicketRepo;
/*    */   @Autowired
/*    */   MedicCheckinRecordRepository medicCheckinRecordRepository;
/*    */   @Autowired
/*    */   ServiceGroupRepository serviceGroupRepository;
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\BaseProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */