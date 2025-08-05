/*    */ package nencer.app.Modules.Storehouse.Controller.Report;
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*    */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*    */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderReport;
/*    */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderRepository;
/*    */ import nencer.app.Utils.ApiError;
/*    */ import nencer.app.Utils.ApiResponse;
/*    */ import nencer.app.Utils.TSpecification;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.modelmapper.ModelMapper;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.jpa.domain.Specification;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*    */ @RequestMapping({"/api"})
/*    */ public class MedicProductOrderReportController {
/* 32 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductOrderReportController.class);
/*    */   
/*    */   @Autowired
/*    */   ApiError apiError;
/*    */   
/*    */   @Autowired
/*    */   ModelMapper modelMapper;
/*    */   
/*    */   @Autowired
/*    */   MedicProductOrderRepository medicProductOrderRepository;
/*    */   
/*    */   @GetMapping({"/medic_product_storehouse/inventory_report"})
/*    */   public ApiResponse getInventoryReport(@RequestParam(required = false) String filter) {
/* 45 */     ApiResponse rs = new ApiResponse();
/* 46 */     Map<String, Object> data = new HashMap<>();
/*    */     try {
/* 48 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 49 */       if (!StringUtils.isEmpty(filter)) {
/* 50 */         ObjectMapper objectMapper = new ObjectMapper();
/* 51 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*    */           );
/*    */       } 
/* 54 */       TSpecification specifications = new TSpecification(searchFilter);
/*    */       
/* 56 */       List<MedicProductOrder> medicProductOrders = this.medicProductOrderRepository.findAll((Specification)specifications);
/*    */ 
/*    */ 
/*    */       
/* 60 */       List<MedicProductOrderReport> medicProductOrderReports = (List<MedicProductOrderReport>)medicProductOrders.stream().map(m -> (MedicProductOrderReport)this.modelMapper.map(m, MedicProductOrderReport.class)).collect(Collectors.toList());
/*    */       
/* 62 */       data.put("medicProductStorehouse", medicProductOrderReports);
/* 63 */       rs.put("status", "OK");
/* 64 */       rs.put("responseCode", "00");
/* 65 */       rs.put("data", data);
/*    */     }
/* 67 */     catch (Exception e) {
/* 68 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 69 */       logger.error(exceptionAsString);
/* 70 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*    */     } 
/* 72 */     return rs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Report\MedicProductOrderReportController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */