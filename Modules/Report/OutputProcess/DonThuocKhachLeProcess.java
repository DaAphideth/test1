/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.ConvertCurrentcyToString;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class DonThuocKhachLeProcess extends BaseProcess {
/*     */   public void getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*     */     try {
/*  21 */       int id = ((exportModel.getTicketId() != null) ? exportModel.getTicketId() : exportModel.getCheckinId()).intValue();
/*  22 */       MedicProductOrderModel medicProductOrderModel = this.commonStoreHouseRepo.getProductOrderRetailSp(Integer.valueOf(id));
/*  23 */       if (medicProductOrderModel != null) {
/*     */         
/*  25 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  26 */         medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*     */         
/*  28 */         process(medicProductOrderModel, mergeFieldDTO, fieldData);
/*     */       } 
/*  30 */     } catch (Exception ex) {
/*  31 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  32 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(MedicProductOrderModel medicProductOrderModels, MergeFieldDTO mergeFieldDTO, List<MergeFieldDTO> fieldData) {
/*  38 */     Calendar cal = Calendar.getInstance();
/*     */ 
/*     */ 
/*     */     
/*  42 */     mergeFieldDTO.setCode("hospitalName");
/*  43 */     mergeFieldDTO.setValue(medicProductOrderModels.getHospitalName());
/*  44 */     mergeFieldDTO.setMergeField("hospitalName");
/*  45 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  46 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  48 */     mergeFieldDTO.setCode("soPhieu");
/*  49 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getId()));
/*  50 */     mergeFieldDTO.setMergeField("soPhieu");
/*  51 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  52 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  55 */     mergeFieldDTO.setCode("cusomerName");
/*  56 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerName());
/*  57 */     mergeFieldDTO.setMergeField("cusomerName");
/*  58 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  59 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  61 */     mergeFieldDTO.setCode("customerAge");
/*  62 */     mergeFieldDTO.setValue(DataUtil.safeToString(String.valueOf(medicProductOrderModels.getCustomerAge())));
/*  63 */     mergeFieldDTO.setMergeField("customerAge");
/*  64 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  65 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  67 */     mergeFieldDTO.setCode("customerGender");
/*  68 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerGender());
/*  69 */     mergeFieldDTO.setMergeField("customerGender");
/*  70 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  71 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  73 */     mergeFieldDTO.setCode("customerAddress");
/*  74 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerAddress());
/*  75 */     mergeFieldDTO.setMergeField("customerAddress");
/*  76 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  77 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  79 */     mergeFieldDTO.setCode("diagnostic");
/*  80 */     mergeFieldDTO.setMergeField("diagnostic");
/*     */     try {
/*  82 */       List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(medicProductOrderModels.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */         );
/*  84 */       mergeFieldDTO.setValue(((ReExaminationModel)reExam.get(0)).getCode() + " - " + ((ReExaminationModel)reExam.get(0)).getName());
/*  85 */     } catch (Exception ex) {
/*  86 */       mergeFieldDTO.setValue("");
/*     */     } 
/*  88 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  89 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  91 */     mergeFieldDTO.setCode("subDiagnostic");
/*     */     try {
/*  93 */       List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(medicProductOrderModels.getSubDiagnostic(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */         );
/*  95 */       mergeFieldDTO.setValue((reExamSub.size() > 0) ? String.join("\n", new CharSequence[] { ((ReExaminationModel)reExamSub.get(0)).getCode() + " - " + ((ReExaminationModel)reExamSub.get(0)).getName() }) : "");
/*  96 */     } catch (Exception ex) {
/*  97 */       mergeFieldDTO.setValue("");
/*     */     } 
/*  99 */     mergeFieldDTO.setMergeField("subDiagnostic");
/* 100 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 101 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 103 */     mergeFieldDTO.setCode("day");
/* 104 */     mergeFieldDTO.setValue(String.valueOf(cal.get(5)));
/* 105 */     mergeFieldDTO.setMergeField("day");
/* 106 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 107 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 109 */     mergeFieldDTO.setCode("month");
/* 110 */     mergeFieldDTO.setValue(String.valueOf(cal.get(2)));
/* 111 */     mergeFieldDTO.setMergeField("month");
/* 112 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 113 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 115 */     mergeFieldDTO.setCode("year");
/* 116 */     mergeFieldDTO.setValue(String.valueOf(cal.get(1)));
/* 117 */     mergeFieldDTO.setMergeField("year");
/* 118 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 119 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 122 */     int stt = 0;
/* 123 */     Double p = Double.valueOf(0.0D);
/*     */     
/* 125 */     for (MedicProductOrderDetailModel osm : medicProductOrderModels.getMedicProductOrderDetails()) {
/* 126 */       stt++;
/* 127 */       MergeFieldDTO mfd = new MergeFieldDTO();
/* 128 */       mfd.setCode("«start»");
/* 129 */       mfd.setIsGroup(Boolean.valueOf(true));
/* 130 */       mfd.setIsMultiple(Boolean.valueOf(true));
/* 131 */       mfd.setStartGroup("«start»");
/* 132 */       mfd.setEndGroup("«end»");
/*     */       
/* 134 */       List<MergeFieldDTO> children = new ArrayList<>();
/* 135 */       MergeFieldDTO model = new MergeFieldDTO();
/* 136 */       model.setCode("stt");
/* 137 */       model.setValue(String.valueOf(stt));
/* 138 */       model.setMergeField("stt");
/* 139 */       MergeFieldDTO fieldDTO = model;
/* 140 */       children.add(fieldDTO);
/*     */       
/* 142 */       model = new MergeFieldDTO();
/* 143 */       model.setCode("productName");
/* 144 */       model.setValue(osm.getName());
/* 145 */       model.setMergeField("productName");
/* 146 */       fieldDTO = model;
/* 147 */       children.add(fieldDTO);
/*     */       
/* 149 */       model = new MergeFieldDTO();
/* 150 */       model.setCode("productCode");
/* 151 */       model.setValue(osm.getCode());
/* 152 */       model.setMergeField("productCode");
/* 153 */       fieldDTO = model;
/* 154 */       children.add(fieldDTO);
/*     */       
/* 156 */       model = new MergeFieldDTO();
/* 157 */       model.setCode("hangSx");
/* 158 */       model.setValue(osm.getBrandCode());
/* 159 */       model.setMergeField("hangSx");
/* 160 */       fieldDTO = model;
/* 161 */       children.add(fieldDTO);
/*     */       
/* 163 */       model = new MergeFieldDTO();
/* 164 */       model.setCode("hamLuong");
/* 165 */       model.setValue(osm.getVolume());
/* 166 */       model.setMergeField("hamLuong");
/* 167 */       fieldDTO = model;
/* 168 */       children.add(fieldDTO);
/*     */       
/* 170 */       model = new MergeFieldDTO();
/* 171 */       model.setCode("batchNumber");
/* 172 */       model.setValue(osm.getBatchNumber());
/* 173 */       model.setMergeField("batchNumber");
/* 174 */       fieldDTO = model;
/* 175 */       children.add(fieldDTO);
/*     */       
/* 177 */       model = new MergeFieldDTO();
/* 178 */       model.setCode("qty");
/* 179 */       model.setValue(String.valueOf(osm.getQty()));
/* 180 */       model.setMergeField("qty");
/* 181 */       fieldDTO = model;
/* 182 */       children.add(fieldDTO);
/*     */       
/* 184 */       model = new MergeFieldDTO();
/* 185 */       model.setCode("unit");
/* 186 */       model.setValue(osm.getUnit());
/* 187 */       model.setMergeField("unit");
/* 188 */       fieldDTO = model;
/* 189 */       children.add(fieldDTO);
/*     */       
/* 191 */       model = new MergeFieldDTO();
/* 192 */       model.setCode("donGia");
/* 193 */       model.setIsGroup(Boolean.valueOf(false));
/* 194 */       model.setIsMultiple(Boolean.valueOf(false));
/* 195 */       model.setValue((osm.getPriceSelling() != null) ? ApiHelper.formatDecimal(osm.getPriceSelling()) : "");
/* 196 */       model.setMergeField("donGia");
/* 197 */       fieldDTO = model;
/* 198 */       children.add(fieldDTO);
/*     */       
/* 200 */       model = new MergeFieldDTO();
/* 201 */       model.setCode("thanhTien");
/* 202 */       model.setIsGroup(Boolean.valueOf(false));
/* 203 */       model.setIsMultiple(Boolean.valueOf(false));
/* 204 */       model.setValue((osm.getPayAmount() != null) ? ApiHelper.formatDecimal(osm.getPayAmount()) : "");
/* 205 */       model.setMergeField("thanhTien");
/* 206 */       fieldDTO = model;
/* 207 */       children.add(fieldDTO);
/*     */       
/* 209 */       mfd.setChildren(children);
/* 210 */       fieldData.add(mfd);
/*     */       
/* 212 */       p = Double.valueOf(p.doubleValue() + ((osm.getPayAmount() == null) ? 0.0D : osm.getPayAmount().doubleValue()));
/*     */     } 
/*     */ 
/*     */     
/* 216 */     mergeFieldDTO.setCode("tongTien");
/* 217 */     mergeFieldDTO.setValue(ApiHelper.formatDecimal(p));
/* 218 */     mergeFieldDTO.setMergeField("tongTien");
/* 219 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 220 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 223 */     mergeFieldDTO.setCode("writtenInLetters");
/* 224 */     mergeFieldDTO.setValue(ConvertCurrentcyToString.getCurrentName(ApiHelper.formatDecimal(p), null, null));
/* 225 */     mergeFieldDTO.setMergeField("writtenInLetters");
/* 226 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 227 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\DonThuocKhachLeProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */