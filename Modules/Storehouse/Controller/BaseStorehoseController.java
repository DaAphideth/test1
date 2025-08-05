/*     */ package nencer.app.Modules.Storehouse.Controller;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.MedicProductStorehouseType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Modules.Customer.Repository.CustomerRepository;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
/*     */ import nencer.app.Modules.Storehouse.Model.StoreHouseCardModel;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderDetailRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.JdbcTemplate;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*     */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*     */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*     */ import org.springframework.stereotype.Controller;
/*     */ 
/*     */ @Controller
/*     */ public class BaseStorehoseController {
/*  38 */   public static final Logger logger = LoggerFactory.getLogger(CheckinController.class);
/*     */   
/*     */   @Autowired
/*     */   public Environment env;
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductStorehouseRepository medicProductStorehouseRepository;
/*     */   
/*     */   @Autowired
/*     */   public ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   public ModelMapper modelMapper;
/*     */   
/*  52 */   public ObjectMapper objectMapper = new ObjectMapper();
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   public MedicMasterDataRepository medicMasterDataRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected JdbcTemplate jdbcTemplate;
/*     */ 
/*     */   
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicStorehouseInvenRepository medicStorehouseInvenRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductRepository medicProductRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductOrderRepository medicProductOrderRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected MedicProductOrderDetailRepository medicProductOrderDetailRepository;
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected TicketRepository ticketRepository;
/*     */   
/*     */   @Autowired
/*     */   protected CustomerRepository customerRepository;
/*     */   
/*     */   @Autowired
/*     */   protected CommonStoreHouseRepo commonStoreHouseRepo;
/*     */   
/*     */   @Autowired
/*     */   protected StoreHouseService storeHouseService;
/*     */   
/*     */   @Autowired
/*     */   protected MedicOrderInvenExportRepository medicOrderInvenExportRepository;
/*     */ 
/*     */   
/*     */   public List<StoreHouseCardModel> getInvenCard(Integer storehouseId, Integer productId, Date fromDate, Date toDate, String fieldSort, String direction, int page, int size) {
/*  99 */     this
/*     */ 
/*     */       
/* 102 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_store_house_car").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size)).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_ID", productId).addValue("P_FROM_DATE", fromDate).addValue("P_TO_DATE", toDate);
/*     */     
/* 114 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 115 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*     */     
/* 117 */     return list;
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
/*     */   public List<StoreHouseCardModel> getProductInvenDetailSp(Integer productId, Integer storehouseId, String fieldSort, String direction, Integer page, Integer size, String qty) {
/* 130 */     this
/*     */ 
/*     */       
/* 133 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_inven_detail").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_PRODUCT_ID", productId).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PAGE", page).addValue("P_SIZE", size).addValue("P_QTY", DataUtil.safeToString2(qty));
/*     */     
/* 144 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 145 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*     */     
/* 147 */     return list;
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
/*     */   public List<StoreHouseCardModel> getProductInvenSp2(Integer orderDetailId, Integer storehouseId, String productType, String searchValue, String fieldSort, String direction, Integer page, Integer size, Integer isViewZero) {
/* 161 */     this
/*     */ 
/*     */       
/* 164 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_inven2").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
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
/* 175 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_DETAIL_ID", orderDetailId).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_TYPE", productType).addValue("P_SEACH_VALUE", searchValue).addValue("P_IS_ZERO", isViewZero).addValue("P_PAGE", page).addValue("P_SIZE", size);
/*     */     
/* 177 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 178 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*     */     
/* 180 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<StoreHouseCardModel> getProductInvenResumeSp(Integer storehouseId, String searchValue) {
/* 187 */     this
/*     */ 
/*     */       
/* 190 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_inven_resume").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*     */ 
/*     */ 
/*     */     
/* 194 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_SEACH_VALUE", searchValue);
/*     */     
/* 196 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 197 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*     */     
/* 199 */     return list;
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
/*     */   public List<StoreHouseCardModel> getProductInvenTotalSp(Integer storehouseId, String productType, String searchValue, String fieldSort, String direction, Integer page, Integer size, String qty) {
/* 212 */     this
/*     */ 
/*     */       
/* 215 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_product_inven_total").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(StoreHouseCardModel.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_STORE_HOUSE_ID", storehouseId).addValue("P_PRODUCT_TYPE", DataUtil.safeToString2(productType)).addValue("P_SEACH_VALUE", searchValue).addValue("P_QTY", DataUtil.safeToString2(qty)).addValue("P_PAGE", page).addValue("P_SIZE", size);
/*     */     
/* 227 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 228 */     List<StoreHouseCardModel> list = (List<StoreHouseCardModel>)out.get("V_DATASET");
/*     */     
/* 230 */     return list;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductKhachLe(MedicProductOrder medicProductOrder) throws Exception {
/* 234 */     Map<String, Object> data = new HashMap<>();
/* 235 */     ApiResponse rs = new ApiResponse();
/* 236 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 237 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 238 */         String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 239 */         String[] exFeParts = expirationDateFe.split("/");
/* 240 */         Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 241 */         medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */       } 
/*     */     }
/* 244 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 245 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 248 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 251 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 252 */       this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(result));
/*     */     }
/* 254 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 255 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/* 257 */     data.put("id", result.getId());
/* 258 */     rs.put("status", "OK");
/* 259 */     rs.put("responseCode", "00");
/* 260 */     rs.put("data", data);
/* 261 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductNoiTru(MedicProductOrder medicProductOrder) throws Exception {
/* 265 */     Map<String, Object> data = new HashMap<>();
/* 266 */     ApiResponse rs = new ApiResponse();
/* 267 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 268 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 269 */         String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 270 */         String[] exFeParts = expirationDateFe.split("/");
/* 271 */         Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 272 */         medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */       } 
/*     */     }
/* 275 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 276 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 279 */     if (medicProductOrder.getStorehouseFromId() != null) {
/* 280 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(medicProductOrder.getStorehouseFromId()).orElse(null);
/* 281 */       if (medicProductStorehouse != null && medicProductStorehouse.getShType().equalsIgnoreCase(MedicProductStorehouseType.kho_khoa.toString())) {
/* 282 */         medicProductOrder.setDepartmentId(medicProductStorehouse.getDepartmentId());
/*     */       }
/*     */     } 
/*     */     
/* 286 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 289 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 290 */       this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(result));
/*     */     }
/* 292 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 293 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/* 295 */     data.put("id", result.getId());
/* 296 */     rs.put("status", "OK");
/* 297 */     rs.put("responseCode", "00");
/* 298 */     rs.put("data", data);
/* 299 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductTongHop(MedicProductOrder medicProductOrder) throws Exception {
/* 303 */     Map<String, Object> data = new HashMap<>();
/* 304 */     ApiResponse rs = new ApiResponse();
/* 305 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 306 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 307 */         String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 308 */         String[] exFeParts = expirationDateFe.split("/");
/* 309 */         Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 310 */         medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */       } 
/*     */     }
/* 313 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 314 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 317 */     if (medicProductOrder.getStorehouseFromId() != null) {
/* 318 */       MedicProductStorehouse medicProductStorehouse = this.medicProductStorehouseRepository.findById(medicProductOrder.getStorehouseFromId()).orElse(null);
/* 319 */       if (medicProductStorehouse != null && medicProductStorehouse.getShType().equalsIgnoreCase(MedicProductStorehouseType.kho_khoa.toString())) {
/* 320 */         medicProductOrder.setDepartmentId(medicProductStorehouse.getDepartmentId());
/*     */       }
/*     */     } 
/*     */     
/* 324 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 327 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 328 */       this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(result));
/*     */     }
/*     */     
/* 331 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 332 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/* 334 */     data.put("id", result.getId());
/* 335 */     rs.put("status", "OK");
/* 336 */     rs.put("responseCode", "00");
/* 337 */     rs.put("data", data);
/* 338 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductStatusTT(MedicProductOrder medicProductOrder) throws Exception {
/* 342 */     Map<String, Object> data = new HashMap<>();
/* 343 */     ApiResponse rs = new ApiResponse();
/*     */ 
/*     */     
/* 346 */     if (!medicProductOrder.getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNKDXK.getProductOrderStatus()) && 
/* 347 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType()) && 
/* 348 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType()))
/*     */     {
/* 350 */       medicProductOrder.setOrderStatus(ProductOrderStatus.DXK.getProductOrderStatus());
/*     */     }
/*     */     
/* 353 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 354 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 357 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */     
/* 359 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 360 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/*     */     
/* 363 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTCSTT.getMedicProductOrderType()) || medicProductOrder
/* 364 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType())) {
/*     */       
/* 366 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(result);
/* 367 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 368 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 369 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, false);
/* 370 */     } else if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType()) || medicProductOrder
/* 371 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType())) {
/*     */       
/* 373 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(result);
/* 374 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.XK.getMedicProductOrderType());
/* 375 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/*     */       
/* 377 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 382 */     this.storeHouseService.changeStoreHouseInven2(medicProductOrder, false);
/*     */     
/* 384 */     data.put("id", result.getId());
/* 385 */     rs.put("status", "OK");
/* 386 */     rs.put("responseCode", "00");
/* 387 */     rs.put("data", data);
/* 388 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse saveProductKhoa(MedicProductOrder medicProductOrder) throws Exception {
/* 392 */     Map<String, Object> data = new HashMap<>();
/* 393 */     ApiResponse rs = new ApiResponse();
/* 394 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 395 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 396 */         String expirationDateFe = medicProductOrderDetail.getExpirationDateFe();
/* 397 */         String[] exFeParts = expirationDateFe.split("/");
/* 398 */         Date expirationDate = this.storeHouseService.getExDate(exFeParts, expirationDateFe);
/* 399 */         medicProductOrderDetail.setExpirationDate(expirationDate);
/*     */       } 
/*     */     }
/* 402 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrder.getMedicProductOrderDetails()) {
/* 403 */       medicProductOrderDetail.setApprovalQty(medicProductOrderDetail.getQty());
/*     */     }
/*     */     
/* 406 */     MedicProductOrder result = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 409 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 410 */       this.storeHouseService.changeStoreHouseInvenLook((MedicProductOrder)ObjectCommonUtils.cloneObject(result));
/*     */     }
/* 412 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.NK.getMedicProductOrderType())) {
/* 413 */       this.storeHouseService.saveBarcode(result.getMedicProductOrderDetails(), result.getId());
/*     */     }
/* 415 */     data.put("id", result.getId());
/* 416 */     rs.put("status", "OK");
/* 417 */     rs.put("responseCode", "00");
/* 418 */     rs.put("data", data);
/* 419 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse changeStatusNgoaiTru(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 423 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 425 */     boolean isGiveBack = false;
/*     */     
/* 427 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 428 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 430 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 432 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 433 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 434 */       medicProductOrder.setApprovalDate(new Date());
/* 435 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 439 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 440 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 441 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 442 */     medicProductOrder.setUpdatedAt(new Date());
/* 443 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 446 */     if (medicProductOrder.getTicketId() != null) {
/* 447 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */     
/* 450 */     if (isGiveBack && !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 451 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 454 */     if (!isGiveBack && medicProductOrder
/* 455 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 457 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 458 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 459 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 462 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 463 */     } else if (isGiveBack && medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 465 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 466 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 469 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */     
/* 472 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 473 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 474 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 475 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 476 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 481 */     if (!isGiveBack || medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 482 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 485 */     rs.put("status", "OK");
/* 486 */     rs.put("responseCode", "00");
/* 487 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse changeStatusNoiTru(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 491 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 493 */     boolean isGiveBack = false;
/*     */     
/* 495 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 496 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 498 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 500 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 501 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 502 */       medicProductOrder.setApprovalDate(new Date());
/* 503 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 507 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 508 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 509 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 510 */     medicProductOrder.setUpdatedAt(new Date());
/* 511 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 514 */     if (medicProductOrder.getTicketId() != null) {
/* 515 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */     
/* 518 */     if (isGiveBack && 
/* 519 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) && 
/* 520 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) && 
/* 521 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType()))
/*     */     {
/* 523 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 526 */     if (!isGiveBack && medicProductOrder
/* 527 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 529 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 530 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 531 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 534 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 535 */     } else if (isGiveBack && medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 537 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 538 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 541 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */     
/* 544 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 545 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) || medicProductOrder
/* 546 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType())) {
/*     */       
/* 548 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 549 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 550 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 551 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 556 */     if (!isGiveBack || medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 557 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()))
/*     */     {
/* 559 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 562 */     rs.put("status", "OK");
/* 563 */     rs.put("responseCode", "00");
/* 564 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse changeStatusTongHop(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 568 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 570 */     boolean isGiveBack = false;
/*     */     
/* 572 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 573 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 575 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 577 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 578 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 579 */       medicProductOrder.setApprovalDate(new Date());
/* 580 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 584 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 585 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 586 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 587 */     medicProductOrder.setUpdatedAt(new Date());
/* 588 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 591 */     if (medicProductOrder.getTicketId() != null) {
/* 592 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */     
/* 595 */     if (isGiveBack && 
/* 596 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) && 
/* 597 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) && 
/* 598 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType()))
/*     */     {
/* 600 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 603 */     if (!isGiveBack && medicProductOrder
/* 604 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 606 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 607 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 608 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 611 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 612 */     } else if (isGiveBack && medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 614 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 615 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 618 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */     
/* 621 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 622 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) || medicProductOrder
/* 623 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType())) {
/*     */       
/* 625 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 626 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 627 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 628 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 633 */     if (!isGiveBack || medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 634 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()))
/*     */     {
/* 636 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 639 */     rs.put("status", "OK");
/* 640 */     rs.put("responseCode", "00");
/* 641 */     return rs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ApiResponse changeStatusKhachLe(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 646 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 648 */     boolean isGiveBack = false;
/*     */ 
/*     */     
/* 651 */     List<MedicProductOrder> medicProductOrderLe = this.commonStoreHouseRepo.getMedicProductPaidSp(medicProductOrder.getId());
/* 652 */     if (medicProductOrderLe.size() == 0 && medicProductOrder
/* 653 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/*     */       
/* 655 */       if (ProductOrderStatus.DNKDXK.getProductOrderStatus().contains(status))
/* 656 */         return this.apiError.getError("601", new String[0]); 
/* 657 */     } else if (medicProductOrderLe.size() > 0 && ProductOrderStatus.CD.getProductOrderStatus().equalsIgnoreCase(status)) {
/* 658 */       return this.apiError.getError("216", new String[0]);
/*     */     } 
/* 660 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 661 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 663 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 665 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 666 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 667 */       medicProductOrder.setApprovalDate(new Date());
/* 668 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 672 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 673 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 674 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 675 */     medicProductOrder.setUpdatedAt(new Date());
/* 676 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 679 */     if (medicProductOrder.getTicketId() != null) {
/* 680 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */     
/* 683 */     if (isGiveBack && !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 684 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 687 */     if (!isGiveBack && medicProductOrder
/* 688 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 690 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 691 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 692 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 695 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 696 */     } else if (isGiveBack && medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 698 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 699 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 702 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */     
/* 705 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 706 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 707 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 708 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 709 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */     
/* 713 */     if (!isGiveBack || medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType())) {
/* 714 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/* 716 */     rs.put("status", "OK");
/* 717 */     rs.put("responseCode", "00");
/* 718 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse changeStatusTT(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 722 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 724 */     boolean isGiveBack = false;
/*     */     
/* 726 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 727 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 729 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 731 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 732 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 733 */       medicProductOrder.setApprovalDate(new Date());
/* 734 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 738 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 739 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 740 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 741 */     medicProductOrder.setUpdatedAt(new Date());
/* 742 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 745 */     if (medicProductOrder.getTicketId() != null) {
/* 746 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 753 */     if (!isGiveBack && (medicProductOrder
/* 754 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTCSTT.getMedicProductOrderType()) || medicProductOrder
/* 755 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType())) && (medicProductOrder
/*     */       
/* 757 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 758 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 759 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 762 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 763 */     } else if (isGiveBack && (medicProductOrder
/* 764 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTCSTT.getMedicProductOrderType()) || medicProductOrder
/* 765 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType())) && (medicProductOrder
/*     */       
/* 767 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 768 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 771 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */ 
/*     */     
/* 775 */     if (!isGiveBack && (medicProductOrder
/* 776 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType()) || medicProductOrder
/* 777 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType())) && (medicProductOrder
/*     */       
/* 779 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 780 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 781 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 784 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 785 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.XK.getMedicProductOrderType());
/* 786 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 787 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder2);
/*     */     }
/* 789 */     else if (isGiveBack && (medicProductOrder
/* 790 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType()) || medicProductOrder
/* 791 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType())) && (medicProductOrder
/*     */       
/* 793 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 794 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 797 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 798 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.XK.getMedicProductOrderType());
/* 799 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 800 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder2);
/*     */     } 
/*     */ 
/*     */     
/* 804 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTCSTT.getMedicProductOrderType()) || medicProductOrder
/* 805 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType())) {
/*     */       
/* 807 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 808 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 809 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 810 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/* 811 */     } else if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType()) || medicProductOrder
/* 812 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType())) {
/*     */       
/* 814 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 815 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.XK.getMedicProductOrderType());
/* 816 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 817 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 822 */     if (!isGiveBack || medicProductOrder
/* 823 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_BSCKTT.getMedicProductOrderType()) || medicProductOrder
/* 824 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.NK_NBCSTT.getMedicProductOrderType()) || medicProductOrder
/* 825 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTCSTT.getMedicProductOrderType()) || medicProductOrder
/* 826 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_XBCSTT.getMedicProductOrderType()))
/*     */     {
/* 828 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 831 */     rs.put("status", "OK");
/* 832 */     rs.put("responseCode", "00");
/* 833 */     return rs;
/*     */   }
/*     */   
/*     */   protected ApiResponse changeStatusKhoa(MedicProductOrder medicProductOrder, String status) throws Exception {
/* 837 */     ApiResponse rs = new ApiResponse();
/*     */     
/* 839 */     boolean isGiveBack = false;
/*     */     
/* 841 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 842 */       .getOrderStatus().equals(ProductOrderStatus.DNK.getProductOrderStatus()))
/*     */     {
/* 844 */       isGiveBack = (status.equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()) || status.equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()));
/*     */     }
/* 846 */     if (medicProductOrder.getOrderStatus().equals(ProductOrderStatus.CD.getProductOrderStatus()) && status
/* 847 */       .equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus())) {
/* 848 */       medicProductOrder.setApprovalDate(new Date());
/* 849 */       medicProductOrder.setApprovalId(medicProductOrder.getCreatorId());
/*     */     } 
/*     */ 
/*     */     
/* 853 */     medicProductOrder.setExportDate(status.equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) ? new Date() : null);
/* 854 */     medicProductOrder.setImportDate(status.equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) ? new Date() : null);
/* 855 */     medicProductOrder.setOrderStatus(status.toUpperCase(Locale.ROOT));
/* 856 */     medicProductOrder.setUpdatedAt(new Date());
/* 857 */     medicProductOrder = (MedicProductOrder)this.medicProductOrderRepository.saveAndFlush(medicProductOrder);
/*     */ 
/*     */     
/* 860 */     if (medicProductOrder.getTicketId() != null) {
/* 861 */       this.ticketRepository.updateStatusByOrder(medicProductOrder.getTicketId(), status.toUpperCase(Locale.ROOT));
/*     */     }
/*     */     
/* 864 */     if (isGiveBack && 
/* 865 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) && 
/* 866 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) && 
/* 867 */       !medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType()))
/*     */     {
/* 869 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 872 */     if (!isGiveBack && medicProductOrder
/* 873 */       .getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 875 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DXK.getProductOrderStatus()) || medicProductOrder
/* 876 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DNK.getProductOrderStatus()) || medicProductOrder
/* 877 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 880 */       this.storeHouseService.recoveryStoreHouseInvenLook(medicProductOrder);
/* 881 */     } else if (isGiveBack && medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType()) && (medicProductOrder
/*     */       
/* 883 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.DD.getProductOrderStatus()) || medicProductOrder
/* 884 */       .getOrderStatus().equalsIgnoreCase(ProductOrderStatus.PH.getProductOrderStatus()))) {
/*     */ 
/*     */       
/* 887 */       this.storeHouseService.changeStoreHouseInvenLook(medicProductOrder);
/*     */     } 
/*     */     
/* 890 */     if (medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 891 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()) || medicProductOrder
/* 892 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_HTKP.getMedicProductOrderType())) {
/*     */       
/* 894 */       MedicProductOrder medicProductOrder2 = (MedicProductOrder)ObjectCommonUtils.cloneObject(medicProductOrder);
/* 895 */       medicProductOrder2.setGroupOrderType(MedicProductOrderType.NK.getMedicProductOrderType());
/* 896 */       medicProductOrder2.setStorehouseId(medicProductOrder2.getStorehouseFromId());
/* 897 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder2, isGiveBack);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 902 */     if (!isGiveBack || medicProductOrder.getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_CK.getMedicProductOrderType()) || medicProductOrder
/* 903 */       .getOrderType().equalsIgnoreCase(MedicProductOrderType.XK_KP.getMedicProductOrderType()))
/*     */     {
/* 905 */       this.storeHouseService.changeStoreHouseInven2(medicProductOrder, isGiveBack);
/*     */     }
/*     */     
/* 908 */     rs.put("status", "OK");
/* 909 */     rs.put("responseCode", "00");
/* 910 */     return rs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Controller\BaseStorehoseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */