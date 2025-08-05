/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.LableMedicModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class PhieuInNhanThuocProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public Integer getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, Set<Integer> pdId) {
/*     */     try {
/*  23 */       LableMedicModel md = this.commonReportRepo.sp_get_medic_product_order_detail(exportModel.getMedicProductOrderDetailId());
/*  24 */       if (md != null) {
/*  25 */         process(md, fieldData, pdId);
/*  26 */         return Integer.valueOf((md.getNumberOfBarCode() != null) ? md.getNumberOfBarCode().intValue() : 3);
/*     */       } 
/*  28 */       return Integer.valueOf(3);
/*  29 */     } catch (Exception ex) {
/*  30 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  31 */       logger.error(exceptionAsString);
/*  32 */       return Integer.valueOf(3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getAllProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, Set<Integer> pdId) {
/*     */     try {
/*  39 */       Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(exportModel.getOrderServiceId()));
/*  40 */       Integer n = Integer.valueOf(3);
/*  41 */       if (medicProductOrderDetailModels != null)
/*     */       {
/*  43 */         for (MedicProductOrderDetailModel mdo : medicProductOrderDetailModels) {
/*     */           
/*  45 */           MergeFieldDTO mfd = new MergeFieldDTO();
/*  46 */           mfd.setCode("«start»");
/*  47 */           mfd.setIsGroup(Boolean.valueOf(true));
/*  48 */           mfd.setIsMultiple(Boolean.valueOf(true));
/*  49 */           mfd.setStartGroup("«start»");
/*  50 */           mfd.setEndGroup("«end»");
/*     */           
/*  52 */           List<MergeFieldDTO> children = new ArrayList<>();
/*  53 */           MergeFieldDTO model = new MergeFieldDTO();
/*     */           
/*  55 */           model.setCode("TenThuoc");
/*  56 */           model.setIsGroup(Boolean.valueOf(false));
/*  57 */           model.setIsMultiple(Boolean.valueOf(false));
/*  58 */           model.setValue(mdo.getName());
/*  59 */           model.setMergeField("TenThuoc");
/*  60 */           MergeFieldDTO fieldDTO = model;
/*  61 */           children.add(fieldDTO);
/*     */           
/*  63 */           model = new MergeFieldDTO();
/*  64 */           model.setCode("BV_TenUP");
/*  65 */           model.setValue(mdo.getTenBV());
/*  66 */           model.setMergeField("BV_TenUP");
/*  67 */           fieldDTO = model;
/*  68 */           children.add(fieldDTO);
/*     */           
/*  70 */           model = new MergeFieldDTO();
/*  71 */           model.setCode("P_ID");
/*  72 */           model.setValue(String.valueOf(mdo.getId()));
/*  73 */           model.setMergeField("P_ID");
/*  74 */           fieldDTO = model;
/*  75 */           children.add(fieldDTO);
/*     */           
/*  77 */           model = new MergeFieldDTO();
/*  78 */           model.setCode("GiaBan");
/*  79 */           model.setValue(ApiHelper.formatDecimal(mdo.getPriceSelling()));
/*  80 */           model.setMergeField("GiaBan");
/*  81 */           fieldDTO = model;
/*  82 */           children.add(fieldDTO);
/*     */           
/*  84 */           model = new MergeFieldDTO();
/*  85 */           model.setCode("DonVi");
/*  86 */           model.setValue(mdo.getUnit());
/*  87 */           model.setMergeField("DonVi");
/*  88 */           fieldDTO = model;
/*  89 */           children.add(fieldDTO);
/*     */           
/*  91 */           mfd.setChildren(children);
/*  92 */           fieldData.add(mfd);
/*     */           
/*  94 */           n = mdo.getNumberOfBarCode();
/*     */           
/*  96 */           pdId.add(Integer.valueOf(mdo.getId()));
/*     */         } 
/*     */       }
/*  99 */       return n;
/* 100 */     } catch (Exception ex) {
/* 101 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 102 */       logger.error(exceptionAsString);
/* 103 */       return Integer.valueOf(3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void process(LableMedicModel md, List<MergeFieldDTO> fieldData, Set<Integer> pdId) {
/* 109 */     MergeFieldDTO mf = new MergeFieldDTO();
/* 110 */     mf.setCode("TenThuoc");
/* 111 */     mf.setValue(md.getTenThuoc());
/* 112 */     mf.setMergeField("TenThuoc");
/* 113 */     fieldData.add(mf);
/*     */     
/* 115 */     mf = new MergeFieldDTO();
/* 116 */     mf.setCode("BV_TenUP");
/* 117 */     mf.setValue(md.getTenBV());
/* 118 */     mf.setMergeField("BV_TenUP");
/* 119 */     fieldData.add(mf);
/*     */     
/* 121 */     mf = new MergeFieldDTO();
/* 122 */     mf.setCode("P_ID");
/* 123 */     mf.setValue(String.valueOf(md.getId()));
/* 124 */     mf.setMergeField("P_ID");
/* 125 */     fieldData.add(mf);
/*     */     
/* 127 */     mf = new MergeFieldDTO();
/* 128 */     mf.setCode("GiaBan");
/* 129 */     mf.setValue(ApiHelper.formatDecimal(md.getGia()));
/* 130 */     mf.setMergeField("GiaBan");
/* 131 */     fieldData.add(mf);
/*     */     
/* 133 */     mf = new MergeFieldDTO();
/* 134 */     mf.setCode("DonVi");
/* 135 */     mf.setValue(md.getDonvi());
/* 136 */     mf.setMergeField("DonVi");
/* 137 */     fieldData.add(mf);
/*     */     
/* 139 */     pdId.add(md.getId());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuInNhanThuocProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */