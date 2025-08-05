/*     */ package nencer.app.Modules.Storehouse.Controller.Storehouse;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.MasterData.Entity.MedicMasterData;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductInvenCategory;
/*     */ import nencer.app.Modules.Storehouse.Model.StoreHouseCardModel;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicProductStorehouseInvenController extends BaseStorehoseController {
/*  29 */   public static final Logger logger = LoggerFactory.getLogger(MedicProductStorehouseInvenController.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse_inven/card"})
/*     */   public ApiResponse getPaging(@RequestParam Integer storehouseId, @RequestParam Integer productId, @RequestParam Date fromDate, @RequestParam Date toDate, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/*  46 */     ApiResponse rs = new ApiResponse();
/*  47 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  49 */       List<StoreHouseCardModel> pages = getInvenCard(storehouseId, productId, fromDate, toDate, fieldSort, direction, page, size);
/*  50 */       data.put("storehouseCard", pages);
/*  51 */       data.put("totalItems", Integer.valueOf((pages.size() > 0) ? ((StoreHouseCardModel)pages.get(0)).getTotalRecord().intValue() : 0));
/*  52 */       rs.put("status", "OK");
/*  53 */       rs.put("responseCode", "00");
/*  54 */       rs.put("data", data);
/*     */     }
/*  56 */     catch (Exception e) {
/*  57 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  58 */       logger.error(exceptionAsString);
/*  59 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  61 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse_inven/product"})
/*     */   public ApiResponse getProductInven(@RequestParam Integer storehouseId, @RequestParam(required = false) Integer orderDetailId, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(required = false) String productType) {
/*  70 */     ApiResponse rs = new ApiResponse();
/*  71 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  73 */       List<StoreHouseCardModel> pages = getProductInvenSp2(orderDetailId, storehouseId, productType, null, fieldSort, direction, null, null, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  81 */           Integer.valueOf(0));
/*     */       
/*  83 */       data.put("productInven", pages);
/*  84 */       rs.put("status", "OK");
/*  85 */       rs.put("responseCode", "00");
/*  86 */       rs.put("data", data);
/*     */     }
/*  88 */     catch (Exception e) {
/*  89 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  90 */       logger.error(exceptionAsString);
/*  91 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  93 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse_inven/product_resume"})
/*     */   public ApiResponse getProductInven(@RequestParam Integer storehouseId) {
/*  98 */     ApiResponse rs = new ApiResponse();
/*  99 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 101 */       List<StoreHouseCardModel> pages = getProductInvenResumeSp(storehouseId, null);
/*     */ 
/*     */ 
/*     */       
/* 105 */       data.put("productInven", pages);
/* 106 */       rs.put("status", "OK");
/* 107 */       rs.put("responseCode", "00");
/* 108 */       rs.put("data", data);
/*     */     }
/* 110 */     catch (Exception e) {
/* 111 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 112 */       logger.error(exceptionAsString);
/* 113 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 115 */     return rs;
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
/*     */   @GetMapping({"/medic_product_storehouse_inven2"})
/*     */   public ApiResponse getPaging2(@RequestParam(required = false) String searchValue, @RequestParam(required = false) String type, @RequestParam(required = false) String filter, @RequestParam(required = false) String qty, @RequestParam(required = false) Integer storehouseId, @RequestParam(required = false) String fieldSort, @RequestParam(required = false) String direction, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
/* 128 */     ApiResponse rs = new ApiResponse();
/* 129 */     Map<String, Object> data = new HashMap<>();
/*     */     
/*     */     try {
/* 132 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/*     */       
/* 134 */       if (!StringUtils.isEmpty(filter)) {
/* 135 */         ObjectMapper objectMapper = new ObjectMapper();
/* 136 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {
/*     */             
/*     */             });
/*     */       } 
/* 140 */       for (SearchCriteria searchCriteria : searchFilter) {
/* 141 */         if (searchCriteria.getField().equalsIgnoreCase("storehouseId") && storehouseId == null) {
/* 142 */           storehouseId = Integer.valueOf(Integer.parseInt(String.valueOf(searchCriteria.getValue())));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 147 */       List<StoreHouseCardModel> productInvenTotals = getProductInvenTotalSp(storehouseId, type, searchValue, fieldSort, direction, Integer.valueOf(page), Integer.valueOf(size), qty);
/* 148 */       for (StoreHouseCardModel productInvenTotal : productInvenTotals) {
/*     */         
/* 150 */         List<StoreHouseCardModel> storeHouseCardModels = getProductInvenDetailSp(productInvenTotal.getProductId(), productInvenTotal.getStorehouseId(), fieldSort, direction, Integer.valueOf(page), Integer.valueOf(size), qty);
/* 151 */         productInvenTotal.setChildren(storeHouseCardModels);
/*     */       } 
/* 153 */       data.put("medicProductStorehouseInven", productInvenTotals);
/* 154 */       data.put("totalItems", Integer.valueOf((productInvenTotals.size() > 0) ? ((StoreHouseCardModel)productInvenTotals.get(0)).getTotalRecord().intValue() : 0));
/* 155 */       rs.put("status", "OK");
/* 156 */       rs.put("responseCode", "00");
/* 157 */       rs.put("data", data);
/*     */     }
/* 159 */     catch (Exception e) {
/* 160 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 161 */       logger.error(exceptionAsString);
/* 162 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 164 */     return rs;
/*     */   }
/*     */   
/*     */   @GetMapping({"/medic_product_storehouse_inven2/category"})
/*     */   public ApiResponse getCategory2(@RequestParam(required = false) String filter) {
/* 169 */     ApiResponse rs = new ApiResponse();
/* 170 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/* 172 */       List<SearchCriteria> searchFilter = new ArrayList<>();
/* 173 */       if (!StringUtils.isEmpty(filter)) {
/* 174 */         ObjectMapper objectMapper = new ObjectMapper();
/* 175 */         searchFilter = (List<SearchCriteria>)objectMapper.readValue(filter, new TypeReference<List<SearchCriteria>>() {  }
/*     */           );
/*     */       } 
/* 178 */       Integer storehouseId = null;
/* 179 */       if (searchFilter.size() > 0) {
/*     */         
/* 181 */         SearchCriteria searchCriteria = searchFilter.stream().filter(e -> e.getField().equalsIgnoreCase("storehouseId")).findFirst().orElse(null);
/* 182 */         storehouseId = (searchCriteria != null) ? Integer.valueOf(Integer.parseInt(String.valueOf(searchCriteria.getValue()))) : null;
/*     */       } 
/* 184 */       List<MedicProductInvenCategory> medicProductInvenCategorys = new ArrayList<>();
/*     */       
/* 186 */       List<MedicMasterData> drugTypes = this.medicMasterDataRepository.findAllByMedicType("drugType");
/*     */       
/* 188 */       for (MedicMasterData drugType : drugTypes) {
/* 189 */         List<StoreHouseCardModel> pages = getProductInvenSp2(null, storehouseId, drugType.getMedicCode(), null, null, null, 
/* 190 */             Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
/* 191 */         if (pages.size() > 0) {
/* 192 */           medicProductInvenCategorys.add(MedicProductInvenCategory.builder()
/* 193 */               .totalRecord(Integer.valueOf(Math.toIntExact(((StoreHouseCardModel)pages.get(0)).getTotalRecord().intValue())))
/* 194 */               .type(drugType.getMedicCode())
/* 195 */               .storehouseId(((StoreHouseCardModel)pages.get(0)).getStorehouseId())
/* 196 */               .typeName(drugType.getMedicName())
/* 197 */               .build());
/*     */         }
/*     */       } 
/* 200 */       data.put("category", medicProductInvenCategorys);
/*     */       
/* 202 */       rs.put("status", "OK");
/* 203 */       rs.put("responseCode", "00");
/* 204 */       rs.put("data", data);
/*     */     }
/* 206 */     catch (Exception e) {
/* 207 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 208 */       logger.error(exceptionAsString);
/* 209 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 211 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\Storehouse\MedicProductStorehouseInvenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */