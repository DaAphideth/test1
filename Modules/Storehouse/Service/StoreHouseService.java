/*     */ package nencer.app.Modules.Storehouse.Service;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import nencer.app.Constant.MedicProductOrderType;
/*     */ import nencer.app.Constant.ProductOrderStatus;
/*     */ import nencer.app.Modules.Report.Ultil.BarcodeHelper;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicOrderInvenExport;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProduct;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
/*     */ import nencer.app.Modules.Storehouse.Entity.MedicStorehouseInven;
/*     */ import nencer.app.Modules.Storehouse.Repository.CommonStoreHouseRepo;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicOrderInvenExportRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderDetailRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductOrderRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicProductRepository;
/*     */ import nencer.app.Modules.Storehouse.Repository.MedicStorehouseInvenRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.IncorrectExportInvenException;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.scheduling.annotation.Async;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class StoreHouseService
/*     */ {
/*     */   @Autowired
/*     */   MedicStorehouseInvenRepository medicStorehouseInvenRepository;
/*     */   @Autowired
/*     */   MedicProductOrderDetailRepository medicProductOrderDetailRepository;
/*     */   @Autowired
/*     */   protected MedicProductOrderRepository medicProductOrderRepository;
/*     */   
/*     */   public void changeStoreHouseInven2(MedicProductOrder medicProductOrder, boolean isGiveBack) throws IncorrectExportInvenException {
/*  47 */     String orderStatus = medicProductOrder.getOrderStatus();
/*  48 */     if (orderStatus.equals(ProductOrderStatus.DNK.getProductOrderStatus()) || orderStatus
/*  49 */       .equals(ProductOrderStatus.DXK.getProductOrderStatus()) || isGiveBack) {
/*     */       
/*  51 */       List<MedicStorehouseInven> medicProductStorehouseInvens = getListNXK2(medicProductOrder.getMedicProductOrderDetails(), medicProductOrder
/*  52 */           .getStorehouseId(), medicProductOrder
/*  53 */           .getGroupOrderType(), isGiveBack);
/*     */ 
/*     */       
/*  56 */       boolean flagSafeInven = checkSaveInvens(medicProductStorehouseInvens);
/*  57 */       if (flagSafeInven) {
/*  58 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("619", new String[0]));
/*     */       }
/*  60 */       this.medicStorehouseInvenRepository.saveAll(medicProductStorehouseInvens);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   protected CommonStoreHouseRepo commonStoreHouseRepo;
/*     */   @Autowired
/*     */   protected MedicProductRepository medicProductRepository;
/*     */   
/*     */   private List<MedicStorehouseInven> getListNXK2(Set<MedicProductOrderDetail> medicProductOrderDetails, Integer storehouseId, String groupOrderType, boolean isGiveBack) throws IncorrectExportInvenException {
/*  71 */     List<MedicStorehouseInven> medicProductStorehouseInvens = new ArrayList<>();
/*  72 */     if ((groupOrderType.equals(MedicProductOrderType.XK.getMedicProductOrderType()) && !isGiveBack) || (groupOrderType
/*  73 */       .equals(MedicProductOrderType.NK.getMedicProductOrderType()) && isGiveBack)) {
/*  74 */       Set<MedicProductOrderDetail> productOrderDetails = getExistOrderToInven(medicProductOrderDetails);
/*  75 */       if (productOrderDetails.size() <= 0)
/*  76 */         productOrderDetails = sperateOrderToInven(medicProductOrderDetails, storehouseId); 
/*  77 */       for (MedicProductOrderDetail medicProductOrderDetail : productOrderDetails) {
/*     */         
/*  79 */         MedicStorehouseInven medicStorehouseInven = this.medicStorehouseInvenRepository.findByInvenIdAndStorehouseId(medicProductOrderDetail.getInvenId(), storehouseId).orElse(null);
/*  80 */         if (medicStorehouseInven == null) {
/*  81 */           medicStorehouseInven = this.medicStorehouseInvenRepository.findByUniqueConstraint(storehouseId, medicProductOrderDetail).orElse(null);
/*     */         }
/*  83 */         if (medicStorehouseInven == null && medicProductOrderDetail.getInvenId() != null) {
/*  84 */           MedicStorehouseInven medicStorehouseInvenOld = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/*  85 */           medicStorehouseInven = this.medicStorehouseInvenRepository.findByStorehouseIdAndUniqueConstraint(storehouseId, medicStorehouseInvenOld).orElse(null);
/*     */         } 
/*  87 */         if (medicStorehouseInven == null) {
/*  88 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */         }
/*  90 */         int qtyLock = (medicStorehouseInven.getQtyLock() == null) ? 0 : medicStorehouseInven.getQtyLock().intValue();
/*  91 */         int qtyAvailable = medicStorehouseInven.getQty().intValue() - qtyLock;
/*  92 */         if (qtyAvailable < medicProductOrderDetail.getApprovalQty().intValue()) {
/*  93 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("615", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */         }
/*  95 */         medicStorehouseInven.setQty(Integer.valueOf(medicStorehouseInven.getQty().intValue() - medicProductOrderDetail.getApprovalQty().intValue()));
/*  96 */         medicProductStorehouseInvens.add(medicStorehouseInven);
/*     */       } 
/*     */     } else {
/*     */       
/* 100 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */ 
/*     */         
/* 103 */         MedicStorehouseInven medicProductStorehouseInven = this.medicStorehouseInvenRepository.findByUniqueConstraint(storehouseId, medicProductOrderDetail).orElse(null);
/* 104 */         if (medicProductStorehouseInven == null && medicProductOrderDetail.getInvenId() != null) {
/* 105 */           MedicStorehouseInven medicStorehouseInvenOld = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/* 106 */           medicProductStorehouseInven = this.medicStorehouseInvenRepository.findByStorehouseIdAndUniqueConstraint(storehouseId, medicStorehouseInvenOld).orElse(null);
/* 107 */           if (medicProductStorehouseInven == null)
/* 108 */             medicProductStorehouseInven = this.medicStorehouseInvenRepository.findByInvenIdAndStorehouseId(medicProductOrderDetail.getInvenId(), storehouseId).orElse(null); 
/* 109 */           medicProductStorehouseInvens.addAll(buildListInven(storehouseId, medicProductStorehouseInven, medicProductOrderDetail)); continue;
/* 110 */         }  if (medicProductStorehouseInven == null) {
/* 111 */           Set<MedicProductOrderDetail> productOrderDetails = getExistOrderToInven(medicProductOrderDetails);
/* 112 */           if (productOrderDetails.size() > 0) {
/* 113 */             for (MedicProductOrderDetail productOrderDetail : productOrderDetails) {
/* 114 */               MedicStorehouseInven medicStorehouseInvenOld = this.medicStorehouseInvenRepository.findByInvenId(productOrderDetail.getInvenId()).orElse(null);
/* 115 */               medicProductStorehouseInven = this.medicStorehouseInvenRepository.findByStorehouseIdAndUniqueConstraint(storehouseId, medicStorehouseInvenOld).orElse(null);
/* 116 */               if (medicProductStorehouseInven == null)
/* 117 */                 medicProductStorehouseInven = this.medicStorehouseInvenRepository.findByInvenIdAndStorehouseId(productOrderDetail.getInvenId(), storehouseId).orElse(null); 
/* 118 */               medicProductStorehouseInvens.addAll(buildListInven(storehouseId, medicProductStorehouseInven, productOrderDetail));
/*     */             } 
/*     */             continue;
/*     */           } 
/* 122 */           medicProductStorehouseInvens.addAll(buildListInven(storehouseId, medicProductStorehouseInven, medicProductOrderDetail));
/*     */           
/*     */           continue;
/*     */         } 
/* 126 */         medicProductStorehouseInvens = buildListInven(storehouseId, medicProductStorehouseInven, medicProductOrderDetail);
/*     */       } 
/*     */     } 
/* 129 */     return medicProductStorehouseInvens;
/*     */   }
/*     */   @Autowired
/*     */   protected MedicOrderInvenExportRepository medicOrderInvenExportRepository; @Autowired
/*     */   private ApiError apiError;
/*     */   
/*     */   private List<MedicStorehouseInven> buildListInven(Integer storehouseId, MedicStorehouseInven medicProductStorehouseInven, MedicProductOrderDetail medicProductOrderDetail) {
/* 136 */     List<MedicStorehouseInven> medicProductStorehouseInvens = new ArrayList<>();
/* 137 */     if (medicProductStorehouseInven == null) {
/*     */       
/* 139 */       MedicStorehouseInven medicStorehouseInvenOld = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/* 140 */       if (medicStorehouseInvenOld != null) {
/* 141 */         MedicStorehouseInven medicStorehouseInvenOldClone = (MedicStorehouseInven)ObjectCommonUtils.cloneObject(medicStorehouseInvenOld);
/* 142 */         medicStorehouseInvenOldClone.setInvenId(null);
/* 143 */         medicStorehouseInvenOldClone.setStorehouseId(storehouseId);
/* 144 */         medicStorehouseInvenOldClone.setQty(medicProductOrderDetail.getApprovalQty());
/* 145 */         medicStorehouseInvenOldClone.setQtyLock(null);
/* 146 */         medicProductStorehouseInvens.add(medicStorehouseInvenOldClone);
/*     */       } else {
/* 148 */         medicProductStorehouseInvens.add(MedicStorehouseInven.builder()
/* 149 */             .storehouseId(storehouseId)
/* 150 */             .productId(medicProductOrderDetail.getProductId())
/* 151 */             .priceInput(medicProductOrderDetail.getPriceInput())
/* 152 */             .price(medicProductOrderDetail.getPrice())
/* 153 */             .priceIns(medicProductOrderDetail.getPriceIns())
/* 154 */             .priceFee(medicProductOrderDetail.getPriceFee())
/* 155 */             .priceHospital(medicProductOrderDetail.getPriceHospital())
/* 156 */             .priceRequest(medicProductOrderDetail.getPriceRequest())
/* 157 */             .priceIns(medicProductOrderDetail.getPriceIns())
/* 158 */             .batchNumber(medicProductOrderDetail.getBatchNumber())
/* 159 */             .vat(medicProductOrderDetail.getVat())
/* 160 */             .bidNumber(medicProductOrderDetail.getBidNumber())
/* 161 */             .bidGroup(medicProductOrderDetail.getBidGroup())
/* 162 */             .bidPackage(medicProductOrderDetail.getBidPackage())
/* 163 */             .bidYear(medicProductOrderDetail.getBidYear())
/* 164 */             .expirationDateFe(medicProductOrderDetail.getExpirationDateFe())
/* 165 */             .expirationDate(medicProductOrderDetail.getExpirationDate())
/* 166 */             .productionDate(medicProductOrderDetail.getProductionDate())
/* 167 */             .qty(medicProductOrderDetail.getApprovalQty())
/* 168 */             .priceSelling(medicProductOrderDetail.getPriceSelling())
/* 169 */             .orderDetailId(medicProductOrderDetail.getId())
/* 170 */             .createdDate(new Date())
/* 171 */             .updatedDate(new Date())
/* 172 */             .build());
/*     */       } 
/*     */     } else {
/* 175 */       medicProductStorehouseInven.setQty(Integer.valueOf(medicProductStorehouseInven.getQty().intValue() + medicProductOrderDetail.getApprovalQty().intValue()));
/* 176 */       medicProductStorehouseInven.setUpdatedDate(new Date());
/* 177 */       medicProductStorehouseInvens.add(medicProductStorehouseInven);
/*     */     } 
/* 179 */     return medicProductStorehouseInvens;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<MedicProductOrderDetail> sperateOrderToInven(Set<MedicProductOrderDetail> medicProductOrderDetails, Integer storehouseId) throws IncorrectExportInvenException {
/* 184 */     Set<MedicProductOrderDetail> medicProductOrderDetailRs = new HashSet<>();
/* 185 */     List<MedicOrderInvenExport> medicOrderInvenExports = new ArrayList<>();
/* 186 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */       
/* 188 */       this.medicOrderInvenExportRepository.deleteByDetailId(medicProductOrderDetail.getId());
/*     */ 
/*     */       
/* 191 */       List<MedicStorehouseInven> medicStorehouseInvens = null;
/* 192 */       if (medicProductOrderDetail.getInvenId() != null) {
/*     */ 
/*     */         
/* 195 */         Optional<MedicStorehouseInven> medicStorehouseInvenOp = this.medicStorehouseInvenRepository.findByInvenIdAndStorehouseId(medicProductOrderDetail.getInvenId(), storehouseId);
/*     */         
/* 197 */         if (medicStorehouseInvenOp.isPresent()) {
/* 198 */           medicStorehouseInvens = new ArrayList<>();
/* 199 */           medicStorehouseInvens.add(medicStorehouseInvenOp.get());
/*     */         } 
/*     */       } 
/*     */       
/* 203 */       if (medicStorehouseInvens == null)
/*     */       {
/* 205 */         medicStorehouseInvens = this.commonStoreHouseRepo.spGetInvenNotZeroOrderExpiration(medicProductOrderDetail
/* 206 */             .getProductId(), storehouseId);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 211 */       if (medicStorehouseInvens == null) {
/* 212 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/* 214 */       Integer exportQty = medicProductOrderDetail.getQty();
/* 215 */       for (MedicStorehouseInven medicStorehouseInven : medicStorehouseInvens) {
/* 216 */         int xlock = (medicStorehouseInven.getQtyLock() != null) ? medicStorehouseInven.getQtyLock().intValue() : 0;
/* 217 */         int invenQtyAvaiable = medicStorehouseInven.getQty().intValue() - xlock;
/* 218 */         int export = exportQty.intValue() - invenQtyAvaiable;
/*     */         
/* 220 */         if (export <= 0) {
/* 221 */           medicOrderInvenExports.add(MedicOrderInvenExport.builder()
/* 222 */               .invenId(medicStorehouseInven.getInvenId())
/* 223 */               .orderDetailId(medicProductOrderDetail.getId())
/* 224 */               .qty(exportQty)
/* 225 */               .build());
/*     */           
/* 227 */           MedicProductOrderDetail medicProductOrderDetail2 = (MedicProductOrderDetail)ObjectCommonUtils.cloneObject(medicProductOrderDetail);
/* 228 */           medicProductOrderDetail2.setQty(exportQty);
/* 229 */           medicProductOrderDetail2.setApprovalQty(exportQty);
/* 230 */           medicProductOrderDetail2.setInvenId(medicStorehouseInven.getInvenId());
/* 231 */           medicProductOrderDetailRs.add(medicProductOrderDetail2);
/*     */           
/* 233 */           exportQty = Integer.valueOf(0);
/*     */           
/*     */           break;
/*     */         } 
/* 237 */         medicOrderInvenExports.add(MedicOrderInvenExport.builder()
/* 238 */             .invenId(medicStorehouseInven.getInvenId())
/* 239 */             .orderDetailId(medicProductOrderDetail.getId())
/* 240 */             .qty(Integer.valueOf(invenQtyAvaiable))
/* 241 */             .build());
/*     */         
/* 243 */         MedicProductOrderDetail medicProductOrderDetail1 = (MedicProductOrderDetail)ObjectCommonUtils.cloneObject(medicProductOrderDetail);
/* 244 */         medicProductOrderDetail1.setQty(Integer.valueOf(invenQtyAvaiable));
/* 245 */         medicProductOrderDetail1.setApprovalQty(Integer.valueOf(invenQtyAvaiable));
/* 246 */         medicProductOrderDetail1.setInvenId(medicStorehouseInven.getInvenId());
/* 247 */         medicProductOrderDetailRs.add(medicProductOrderDetail1);
/*     */         
/* 249 */         exportQty = Integer.valueOf(export);
/*     */       } 
/*     */       
/* 252 */       if (exportQty.intValue() > 0) {
/* 253 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("615", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 259 */     this.medicOrderInvenExportRepository.saveAll(medicOrderInvenExports);
/*     */     
/* 261 */     return medicProductOrderDetailRs;
/*     */   }
/*     */   
/*     */   public Set<MedicProductOrderDetail> getExistOrderToInven(Set<MedicProductOrderDetail> medicProductOrderDetails) {
/* 265 */     Set<MedicProductOrderDetail> medicProductOrderDetailRs = new HashSet<>();
/* 266 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */       
/* 268 */       List<MedicOrderInvenExport> medicOrderInvenExports = this.medicOrderInvenExportRepository.getAllByOrderDetailId(medicProductOrderDetail.getId());
/* 269 */       for (MedicOrderInvenExport medicOrderInvenExport : medicOrderInvenExports) {
/* 270 */         MedicProductOrderDetail medicProductOrderDetail1 = (MedicProductOrderDetail)ObjectCommonUtils.cloneObject(medicProductOrderDetail);
/* 271 */         medicProductOrderDetail1.setQty(medicOrderInvenExport.getQty());
/* 272 */         medicProductOrderDetail1.setApprovalQty(medicOrderInvenExport.getQty());
/* 273 */         medicProductOrderDetail1.setInvenId(medicOrderInvenExport.getInvenId());
/* 274 */         medicProductOrderDetailRs.add(medicProductOrderDetail1);
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     return medicProductOrderDetailRs;
/*     */   }
/*     */   
/*     */   public void deleteExistOrderInven(Set<MedicProductOrderDetail> medicProductOrderDetailExist) {
/* 282 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetailExist) {
/* 283 */       this.medicOrderInvenExportRepository.deleteByDetailIdAndInvenId(medicProductOrderDetail.getId(), medicProductOrderDetail.getInvenId());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeStoreHouseInvenLook(MedicProductOrder medicProductOrder) throws IncorrectExportInvenException {
/* 289 */     List<MedicStorehouseInven> medicProductStorehouseInvens = new ArrayList<>();
/* 290 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 291 */       Set<MedicProductOrderDetail> medicProductOrderDetails = sperateOrderToInven(medicProductOrder.getMedicProductOrderDetails(), medicProductOrder.getStorehouseId());
/* 292 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */         
/* 294 */         MedicStorehouseInven medicStorehouseInven = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/* 295 */         MedicProduct medicProduct = this.medicProductRepository.findById(medicProductOrderDetail.getProductId()).orElse(null);
/* 296 */         if (medicStorehouseInven == null) {
/* 297 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { (medicProduct != null) ? medicProduct
/* 298 */                   .getName() : String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */         }
/* 300 */         int qtyLock = (medicStorehouseInven.getQtyLock() == null) ? 0 : medicStorehouseInven.getQtyLock().intValue();
/* 301 */         int qtyAvailable = medicStorehouseInven.getQty().intValue() - qtyLock;
/* 302 */         if (qtyAvailable < medicProductOrderDetail.getApprovalQty().intValue()) {
/* 303 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("615", new String[] { (medicProduct != null) ? medicProduct
/* 304 */                   .getName() : String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */         }
/* 306 */         qtyLock += medicProductOrderDetail.getApprovalQty().intValue();
/* 307 */         medicStorehouseInven.setQtyLock(Integer.valueOf(qtyLock));
/* 308 */         medicProductStorehouseInvens.add(medicStorehouseInven);
/*     */       } 
/*     */       
/* 311 */       boolean flagSafeInven = checkSaveInvens(medicProductStorehouseInvens);
/* 312 */       if (flagSafeInven) {
/* 313 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("619", new String[0]));
/*     */       }
/* 315 */       this.medicStorehouseInvenRepository.saveAll(medicProductStorehouseInvens);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void recoveryStoreHouseInvenLook(MedicProductOrder medicProductOrder) throws IncorrectExportInvenException {
/* 321 */     List<MedicStorehouseInven> medicProductStorehouseInvens = new ArrayList<>();
/* 322 */     if (medicProductOrder.getGroupOrderType().equalsIgnoreCase(MedicProductOrderType.XK.getMedicProductOrderType())) {
/* 323 */       Set<MedicProductOrderDetail> medicProductOrderDetails = getExistOrderToInven(medicProductOrder.getMedicProductOrderDetails());
/* 324 */       if (medicProductOrderDetails.size() <= 0)
/* 325 */         medicProductOrderDetails = medicProductOrder.getMedicProductOrderDetails(); 
/* 326 */       for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */         
/* 328 */         MedicStorehouseInven medicStorehouseInven = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/* 329 */         if (medicStorehouseInven == null)
/*     */         {
/* 331 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { medicProductOrderDetail.getMedicProduct().getName() }));
/*     */         }
/* 333 */         int qtyLook = (medicStorehouseInven.getQtyLock() == null) ? 0 : medicStorehouseInven.getQtyLock().intValue();
/* 334 */         if (qtyLook < medicProductOrderDetail.getApprovalQty().intValue())
/*     */         {
/* 336 */           throw new IncorrectExportInvenException(this.apiError.getErrorSt("616", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */         }
/* 338 */         medicStorehouseInven.setQtyLock(Integer.valueOf(qtyLook - medicProductOrderDetail.getApprovalQty().intValue()));
/* 339 */         medicProductStorehouseInvens.add(medicStorehouseInven);
/*     */       } 
/*     */       
/* 342 */       boolean flagSafeInven = checkSaveInvens(medicProductStorehouseInvens);
/* 343 */       if (flagSafeInven) {
/* 344 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("619", new String[0]));
/*     */       }
/* 346 */       this.medicStorehouseInvenRepository.saveAll(medicProductStorehouseInvens);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void recoveryStoreHouseInvenLook(MedicProductOrderDetail medicProductOrderDetail) throws IncorrectExportInvenException {
/* 352 */     Set<MedicProductOrderDetail> medicProductOrderDetails = getExistOrderToInven(Collections.singleton(medicProductOrderDetail));
/* 353 */     deleteExistOrderInven(medicProductOrderDetails);
/* 354 */     for (MedicProductOrderDetail productOrderDetail : medicProductOrderDetails) {
/*     */       
/* 356 */       MedicStorehouseInven medicStorehouseInven = this.medicStorehouseInvenRepository.findByInvenId(productOrderDetail.getInvenId()).orElse(null);
/* 357 */       if (medicStorehouseInven == null) {
/* 358 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/* 360 */       int qtyLook = (medicStorehouseInven.getQtyLock() == null) ? 0 : medicStorehouseInven.getQtyLock().intValue();
/* 361 */       if (qtyLook < productOrderDetail.getApprovalQty().intValue()) {
/* 362 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("616", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/* 364 */       medicStorehouseInven.setQtyLock(Integer.valueOf(qtyLook - productOrderDetail.getApprovalQty().intValue()));
/*     */       
/* 366 */       this.medicStorehouseInvenRepository.save(medicStorehouseInven);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addStoreHouseInvenLook(Set<MedicProductOrderDetail> medicProductOrderDetailInput, MedicProductOrder medicProductOrder) throws IncorrectExportInvenException {
/* 372 */     List<MedicStorehouseInven> medicProductStorehouseInvens = new ArrayList<>();
/* 373 */     Set<MedicProductOrderDetail> medicProductOrderDetails = sperateOrderToInven(medicProductOrderDetailInput, medicProductOrder.getStorehouseId());
/* 374 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/*     */       
/* 376 */       MedicStorehouseInven medicStorehouseInven = this.medicStorehouseInvenRepository.findByInvenId(medicProductOrderDetail.getInvenId()).orElse(null);
/*     */       
/* 378 */       if (medicStorehouseInven == null) {
/* 379 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("614", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/* 381 */       int qtyLock = (medicStorehouseInven.getQtyLock() == null) ? 0 : medicStorehouseInven.getQtyLock().intValue();
/* 382 */       int qtyAvailable = medicStorehouseInven.getQty().intValue() - qtyLock;
/* 383 */       if (qtyAvailable < medicProductOrderDetail.getApprovalQty().intValue()) {
/* 384 */         throw new IncorrectExportInvenException(this.apiError.getErrorSt("615", new String[] { String.valueOf(medicProductOrderDetail.getProductId()) }));
/*     */       }
/* 386 */       qtyLock += medicProductOrderDetail.getApprovalQty().intValue();
/* 387 */       medicStorehouseInven.setQtyLock(Integer.valueOf(qtyLock));
/* 388 */       medicProductStorehouseInvens.add(medicStorehouseInven);
/*     */     } 
/*     */     
/* 391 */     boolean flagSafeInven = checkSaveInvens(medicProductStorehouseInvens);
/* 392 */     if (flagSafeInven) {
/* 393 */       throw new IncorrectExportInvenException(this.apiError.getErrorSt("619", new String[0]));
/*     */     }
/* 395 */     this.medicStorehouseInvenRepository.saveAll(medicProductStorehouseInvens);
/*     */   }
/*     */   
/*     */   public Date getExDate(String[] exFeParts, String exFe) {
/* 399 */     Calendar c = Calendar.getInstance(); try {
/*     */       SimpleDateFormat simpleDateFormat;
/* 401 */       switch (exFeParts.length) {
/*     */         case 1:
/* 403 */           c.set(1, Integer.parseInt(exFeParts[0]) + 1);
/* 404 */           c.set(5, 1);
/* 405 */           c.set(2, 1);
/* 406 */           System.out.println(c.getTime());
/*     */           break;
/*     */         
/*     */         case 2:
/* 410 */           c.set(1, Integer.parseInt(exFeParts[1]));
/* 411 */           c.set(2, Integer.parseInt(exFeParts[0]) + 1);
/* 412 */           c.set(5, 1);
/* 413 */           System.out.println(c.getTime());
/*     */           break;
/*     */         
/*     */         case 3:
/* 417 */           simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
/* 418 */           return simpleDateFormat.parse(exFe);
/*     */       } 
/*     */     
/* 421 */     } catch (ParseException e) {
/* 422 */       return null;
/*     */     } 
/* 424 */     return c.getTime();
/*     */   }
/*     */   
/*     */   @Async
/*     */   public void saveBarcode(Set<MedicProductOrderDetail> medicProductOrderDetails, Integer orderId) throws IOException {
/* 429 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetails) {
/* 430 */       medicProductOrderDetail.setOrderId(orderId);
/* 431 */       String barcodeBase64 = BarcodeHelper.getBarCodeToBase64(String.valueOf(medicProductOrderDetail.getId()));
/* 432 */       medicProductOrderDetail.setBarcode(barcodeBase64);
/*     */     } 
/* 434 */     this.medicProductOrderDetailRepository.saveAll(medicProductOrderDetails);
/*     */   }
/*     */   
/*     */   public void copyProductExportSynthesis(List<MedicProductOrderDetail> medicProductOrderDetailsSyn, Set<MedicProductOrderDetail> medicProductOrderDetailOlds) {
/* 438 */     List<MedicOrderInvenExport> medicOrderInvenExportAll = new ArrayList<>();
/* 439 */     for (MedicProductOrderDetail medicProductOrderDetail : medicProductOrderDetailsSyn) {
/* 440 */       for (MedicProductOrderDetail medicProductOrderDetailOld : medicProductOrderDetailOlds) {
/* 441 */         if (medicProductOrderDetail.getProductId().equals(medicProductOrderDetailOld.getProductId())) {
/*     */           
/* 443 */           List<MedicOrderInvenExport> medicOrderInvenExports = this.medicOrderInvenExportRepository.getAllByOrderDetailId(medicProductOrderDetailOld.getId());
/* 444 */           for (MedicOrderInvenExport medicOrderInvenExport : medicOrderInvenExports) {
/* 445 */             MedicOrderInvenExport medicOrderInvenExport1 = (MedicOrderInvenExport)ObjectCommonUtils.cloneObject(medicOrderInvenExport);
/* 446 */             medicOrderInvenExport1.setQty(medicOrderInvenExport.getQty());
/* 447 */             medicOrderInvenExport1.setInvenId(medicOrderInvenExport.getInvenId());
/* 448 */             medicOrderInvenExport1.setOrderDetailId(medicProductOrderDetail.getId());
/* 449 */             medicOrderInvenExportAll.add(medicOrderInvenExport1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 454 */     this.medicOrderInvenExportRepository.saveAll(medicOrderInvenExportAll);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkSaveInvens(List<MedicStorehouseInven> medicProductStorehouseInvens) {
/* 459 */     for (MedicStorehouseInven medicProductStorehouseInven : medicProductStorehouseInvens) {
/* 460 */       if (medicProductStorehouseInven.getQtyLock() != null && medicProductStorehouseInven.getQty().intValue() < medicProductStorehouseInven.getQtyLock().intValue()) {
/* 461 */         return true;
/*     */       }
/*     */     } 
/* 464 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Service\StoreHouseService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */