/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class DonThuocTheoKhoProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*     */     try {
/*  27 */       MedicProductOrderModel medicProductOrderModel = this.commonStoreHouseRepo.getProductOrderExoprtSp1(exportModel.getCheckinId());
/*  28 */       if (medicProductOrderModel != null) {
/*     */         
/*  30 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  31 */         medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*  32 */         process(medicProductOrderModel, fieldData, mergeFieldDTO);
/*     */       } 
/*  34 */     } catch (Exception ex) {
/*  35 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  36 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void process(MedicProductOrderModel medicProductOrderModels, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*  42 */     Calendar cal = Calendar.getInstance();
/*     */     
/*  44 */     mergeFieldDTO.setCode("soYte");
/*  45 */     mergeFieldDTO.setValue(medicProductOrderModels.getSoYte());
/*  46 */     mergeFieldDTO.setMergeField("soYte");
/*  47 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  48 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  50 */     mergeFieldDTO.setCode("hospitalName");
/*  51 */     mergeFieldDTO.setValue(medicProductOrderModels.getHospitalName());
/*  52 */     mergeFieldDTO.setMergeField("hospitalName");
/*  53 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  54 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  56 */     mergeFieldDTO.setCode("addressHospital");
/*  57 */     mergeFieldDTO.setValue(medicProductOrderModels.getAddressHospital());
/*  58 */     mergeFieldDTO.setMergeField("addressHospital");
/*  59 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  60 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  62 */     mergeFieldDTO.setCode("storehouseName");
/*  63 */     mergeFieldDTO.setValue(medicProductOrderModels.getStorehouseName());
/*  64 */     mergeFieldDTO.setMergeField("storehouseName");
/*  65 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  66 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  68 */     mergeFieldDTO.setCode("hour");
/*  69 */     mergeFieldDTO.setValue(cal.get(11) + ":" + cal.get(12));
/*  70 */     mergeFieldDTO.setMergeField("hour");
/*  71 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  72 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  74 */     mergeFieldDTO.setCode("day");
/*  75 */     mergeFieldDTO.setValue(String.valueOf(cal.get(5)));
/*  76 */     mergeFieldDTO.setMergeField("day");
/*  77 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  78 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  80 */     mergeFieldDTO.setCode("month");
/*  81 */     mergeFieldDTO.setValue(String.valueOf(cal.get(2)));
/*  82 */     mergeFieldDTO.setMergeField("month");
/*  83 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  84 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  86 */     mergeFieldDTO.setCode("year");
/*  87 */     mergeFieldDTO.setValue(String.valueOf(cal.get(1)));
/*  88 */     mergeFieldDTO.setMergeField("year");
/*  89 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  90 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  93 */     mergeFieldDTO.setCode("soPhieu");
/*  94 */     mergeFieldDTO.setValue(medicProductOrderModels.getId() + "");
/*  95 */     mergeFieldDTO.setMergeField("soPhieu");
/*  96 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  97 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  99 */     mergeFieldDTO.setCode("ngayLap");
/* 100 */     mergeFieldDTO.setValue(ApiHelper.dateToString2(medicProductOrderModels.getCreatedAt()));
/* 101 */     mergeFieldDTO.setMergeField("ngayLap");
/* 102 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 103 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 105 */     mergeFieldDTO.setCode("tenKho");
/* 106 */     mergeFieldDTO.setValue(medicProductOrderModels.getOrderTypeName());
/* 107 */     mergeFieldDTO.setMergeField("tenKho");
/* 108 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 109 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 112 */     int stt = 0;
/* 113 */     Double p = Double.valueOf(0.0D);
/* 114 */     int qty = 0;
/*     */     
/* 116 */     for (MedicProductOrderDetailModel osm : medicProductOrderModels.getMedicProductOrderDetails()) {
/* 117 */       stt++;
/* 118 */       MergeFieldDTO mfd = new MergeFieldDTO();
/* 119 */       mfd.setCode("«start»");
/* 120 */       mfd.setIsGroup(Boolean.valueOf(true));
/* 121 */       mfd.setIsMultiple(Boolean.valueOf(true));
/* 122 */       mfd.setStartGroup("«start»");
/* 123 */       mfd.setEndGroup("«end»");
/*     */       
/* 125 */       List<MergeFieldDTO> children = new ArrayList<>();
/* 126 */       MergeFieldDTO model = new MergeFieldDTO();
/* 127 */       model.setCode("stt");
/* 128 */       model.setValue(String.valueOf(stt));
/* 129 */       model.setMergeField("stt");
/* 130 */       MergeFieldDTO fieldDTO = model;
/* 131 */       children.add(fieldDTO);
/*     */       
/* 133 */       model = new MergeFieldDTO();
/* 134 */       model.setCode("productName");
/* 135 */       model.setValue(osm.getName());
/* 136 */       model.setMergeField("productName");
/* 137 */       fieldDTO = model;
/* 138 */       children.add(fieldDTO);
/*     */       
/* 140 */       model = new MergeFieldDTO();
/* 141 */       model.setCode("userGuide");
/* 142 */       model.setValue(osm.getUserGuide());
/* 143 */       model.setMergeField("userGuide");
/* 144 */       fieldDTO = model;
/* 145 */       children.add(fieldDTO);
/*     */       
/* 147 */       model = new MergeFieldDTO();
/* 148 */       model.setCode("qty");
/* 149 */       model.setValue(String.valueOf(osm.getQty()));
/* 150 */       model.setMergeField("qty");
/* 151 */       fieldDTO = model;
/* 152 */       children.add(fieldDTO);
/*     */       
/* 154 */       model = new MergeFieldDTO();
/* 155 */       model.setCode("unit");
/* 156 */       model.setValue(osm.getUnit());
/* 157 */       model.setMergeField("unit");
/* 158 */       fieldDTO = model;
/* 159 */       children.add(fieldDTO);
/*     */       
/* 161 */       model = new MergeFieldDTO();
/* 162 */       model.setCode("donGia");
/* 163 */       model.setIsGroup(Boolean.valueOf(false));
/* 164 */       model.setIsMultiple(Boolean.valueOf(false));
/* 165 */       model.setValue((osm.getPriceSelling() != null) ? ApiHelper.formatDecimal(osm.getPriceSelling()) : "");
/* 166 */       model.setMergeField("donGia");
/* 167 */       fieldDTO = model;
/* 168 */       children.add(fieldDTO);
/*     */       
/* 170 */       model = new MergeFieldDTO();
/* 171 */       model.setCode("thanhTien");
/* 172 */       model.setIsGroup(Boolean.valueOf(false));
/* 173 */       model.setIsMultiple(Boolean.valueOf(false));
/* 174 */       model.setValue((osm.getPayAmount() != null) ? ApiHelper.formatDecimal(osm.getPayAmount()) : "");
/* 175 */       model.setMergeField("thanhTien");
/* 176 */       fieldDTO = model;
/* 177 */       children.add(fieldDTO);
/*     */ 
/*     */       
/* 180 */       model = new MergeFieldDTO();
/* 181 */       model.setCode("hamLuong");
/* 182 */       model.setIsGroup(Boolean.valueOf(false));
/* 183 */       model.setIsMultiple(Boolean.valueOf(false));
/* 184 */       model.setValue(osm.getVolume());
/* 185 */       model.setMergeField("hamLuong");
/* 186 */       fieldDTO = model;
/* 187 */       children.add(fieldDTO);
/*     */       
/* 189 */       model = new MergeFieldDTO();
/* 190 */       model.setCode("xuatSu");
/* 191 */       model.setIsGroup(Boolean.valueOf(false));
/* 192 */       model.setIsMultiple(Boolean.valueOf(false));
/* 193 */       model.setValue(osm.getProducer());
/* 194 */       model.setMergeField("xuatSu");
/* 195 */       fieldDTO = model;
/* 196 */       children.add(fieldDTO);
/*     */       
/* 198 */       model = new MergeFieldDTO();
/* 199 */       model.setCode("nuocSX");
/* 200 */       model.setIsGroup(Boolean.valueOf(false));
/* 201 */       model.setIsMultiple(Boolean.valueOf(false));
/* 202 */       model.setValue(osm.getCountryCode());
/* 203 */       model.setMergeField("nuocSX");
/* 204 */       fieldDTO = model;
/* 205 */       children.add(fieldDTO);
/*     */       
/* 207 */       mfd.setChildren(children);
/* 208 */       fieldData.add(mfd);
/*     */       
/* 210 */       mergeFieldDTO.setCode("doctorAdvice");
/* 211 */       mergeFieldDTO.setValue(osm.getDoctorAdvice());
/* 212 */       mergeFieldDTO.setMergeField("doctorAdvice");
/* 213 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 214 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 216 */       p = Double.valueOf(p.doubleValue() + ((osm.getTotalAmount() == null) ? 0.0D : osm.getTotalAmount().doubleValue()));
/*     */ 
/*     */       
/* 219 */       qty += (osm.getQty() == null) ? 0 : osm.getQty().intValue();
/*     */     } 
/*     */     
/* 222 */     mergeFieldDTO.setCode("productSize");
/* 223 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getMedicProductOrderDetails().size()));
/* 224 */     mergeFieldDTO.setMergeField("productSize");
/* 225 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 226 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 228 */     mergeFieldDTO.setCode("doctorName");
/* 229 */     mergeFieldDTO.setValue(medicProductOrderModels.getDoctorName());
/* 230 */     mergeFieldDTO.setMergeField("doctorName");
/* 231 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 232 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 234 */     mergeFieldDTO.setCode("tongTien");
/* 235 */     mergeFieldDTO.setValue(ApiHelper.formatDecimal(p));
/* 236 */     mergeFieldDTO.setMergeField("tongTien");
/* 237 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 238 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 241 */     mergeFieldDTO.setCode("tongCacKhoan");
/* 242 */     mergeFieldDTO.setValue(stt + "");
/* 243 */     mergeFieldDTO.setMergeField("tongCacKhoan");
/* 244 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 245 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 247 */     mergeFieldDTO.setCode("tongSoLuong");
/* 248 */     mergeFieldDTO.setValue(qty + "");
/* 249 */     mergeFieldDTO.setMergeField("tongSoLuong");
/* 250 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 251 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\DonThuocTheoKhoProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */