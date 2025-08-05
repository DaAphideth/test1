/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ReExaminationModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderDetailModel;
/*     */ import nencer.app.Modules.Storehouse.Model.MedicProductOrderModel;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class DonThuocMuaNgoaiProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(ExportModel exportModel, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*     */     try {
/*  25 */       MedicProductOrderModel medicProductOrderModel = this.commonStoreHouseRepo.getProductOrderExoprtSp(exportModel.getTicketId());
/*  26 */       if (medicProductOrderModel != null) {
/*     */         
/*  28 */         Set<MedicProductOrderDetailModel> medicProductOrderDetailModels = new HashSet<>(this.commonStoreHouseRepo.getExportProductOrderDetailSp(Integer.valueOf(medicProductOrderModel.getId())));
/*  29 */         medicProductOrderModel.setMedicProductOrderDetails(medicProductOrderDetailModels);
/*  30 */         process(medicProductOrderModel, mergeFieldDTO, fieldData);
/*     */       } 
/*  32 */     } catch (Exception ex) {
/*  33 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  34 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(MedicProductOrderModel medicProductOrderModels, MergeFieldDTO mergeFieldDTO, List<MergeFieldDTO> fieldData) {
/*  40 */     Calendar cal = Calendar.getInstance();
/*     */     
/*  42 */     mergeFieldDTO.setCode("soYte");
/*  43 */     mergeFieldDTO.setValue(medicProductOrderModels.getSoYte());
/*  44 */     mergeFieldDTO.setMergeField("soYte");
/*  45 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  46 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  48 */     mergeFieldDTO.setCode("hospitalName");
/*  49 */     mergeFieldDTO.setValue(medicProductOrderModels.getHospitalName());
/*  50 */     mergeFieldDTO.setMergeField("hospitalName");
/*  51 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  52 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  54 */     mergeFieldDTO.setCode("addressHospital");
/*  55 */     mergeFieldDTO.setValue(medicProductOrderModels.getAddressHospital());
/*  56 */     mergeFieldDTO.setMergeField("addressHospital");
/*  57 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  58 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  60 */     mergeFieldDTO.setCode("ticketId");
/*  61 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getTicketId()));
/*  62 */     mergeFieldDTO.setMergeField("ticketId");
/*  63 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  64 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  66 */     mergeFieldDTO.setCode("patientId");
/*  67 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getPatientId()));
/*  68 */     mergeFieldDTO.setMergeField("patientId");
/*  69 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  70 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  72 */     mergeFieldDTO.setCode("cusomerName");
/*  73 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerName());
/*  74 */     mergeFieldDTO.setMergeField("cusomerName");
/*  75 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  76 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  78 */     mergeFieldDTO.setCode("customerAge");
/*  79 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getCustomerAge()));
/*  80 */     mergeFieldDTO.setMergeField("customerAge");
/*  81 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  82 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  84 */     mergeFieldDTO.setCode("customerGender");
/*  85 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerGender());
/*  86 */     mergeFieldDTO.setMergeField("customerGender");
/*  87 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  88 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  90 */     mergeFieldDTO.setCode("customerAddress");
/*  91 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerAddress());
/*  92 */     mergeFieldDTO.setMergeField("customerAddress");
/*  93 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  94 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  96 */     mergeFieldDTO.setCode("customerType");
/*  97 */     mergeFieldDTO.setValue(medicProductOrderModels.getCustomerType());
/*  98 */     mergeFieldDTO.setMergeField("customerType");
/*  99 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 100 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 102 */     mergeFieldDTO.setCode("deparmentName");
/* 103 */     mergeFieldDTO.setValue(medicProductOrderModels.getDeparmentName());
/* 104 */     mergeFieldDTO.setMergeField("deparmentName");
/* 105 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 106 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 108 */     mergeFieldDTO.setCode("diagnostic");
/* 109 */     mergeFieldDTO.setMergeField("diagnostic");
/*     */     try {
/* 111 */       List<ReExaminationModel> reExam = (List<ReExaminationModel>)this.objectMapper.readValue(medicProductOrderModels.getDiagnostic(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */         );
/* 113 */       mergeFieldDTO.setValue(((ReExaminationModel)reExam.get(0)).getCode() + " - " + ((ReExaminationModel)reExam.get(0)).getName());
/* 114 */     } catch (Exception ex) {
/* 115 */       mergeFieldDTO.setValue("");
/*     */     } 
/* 117 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 118 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 120 */     mergeFieldDTO.setCode("subDiagnostic");
/*     */     try {
/* 122 */       List<ReExaminationModel> reExamSub = (List<ReExaminationModel>)this.objectMapper.readValue(medicProductOrderModels.getSubDiagnostic(), new TypeReference<List<ReExaminationModel>>() {  }
/*     */         );
/* 124 */       mergeFieldDTO.setValue((reExamSub.size() > 0) ? String.join("\n", new CharSequence[] { ((ReExaminationModel)reExamSub.get(0)).getCode() + " - " + ((ReExaminationModel)reExamSub.get(0)).getName() }) : "");
/* 125 */     } catch (Exception ex) {
/* 126 */       mergeFieldDTO.setValue("");
/*     */     } 
/* 128 */     mergeFieldDTO.setMergeField("subDiagnostic");
/* 129 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 130 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 132 */     mergeFieldDTO.setCode("storehouseName");
/* 133 */     mergeFieldDTO.setValue(medicProductOrderModels.getStorehouseName());
/* 134 */     mergeFieldDTO.setMergeField("storehouseName");
/* 135 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 136 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 138 */     mergeFieldDTO.setCode("doctorName");
/* 139 */     mergeFieldDTO.setValue(medicProductOrderModels.getDoctorName());
/* 140 */     mergeFieldDTO.setMergeField("doctorName");
/* 141 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 142 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 144 */     mergeFieldDTO.setCode("hour");
/* 145 */     mergeFieldDTO.setValue(cal.get(11) + ":" + cal.get(12));
/* 146 */     mergeFieldDTO.setMergeField("hour");
/* 147 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 148 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 150 */     mergeFieldDTO.setCode("day");
/* 151 */     mergeFieldDTO.setValue(String.valueOf(cal.get(5)));
/* 152 */     mergeFieldDTO.setMergeField("day");
/* 153 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 154 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 156 */     mergeFieldDTO.setCode("month");
/* 157 */     mergeFieldDTO.setValue(String.valueOf(cal.get(2)));
/* 158 */     mergeFieldDTO.setMergeField("month");
/* 159 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 160 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 162 */     mergeFieldDTO.setCode("year");
/* 163 */     mergeFieldDTO.setValue(String.valueOf(cal.get(1)));
/* 164 */     mergeFieldDTO.setMergeField("year");
/* 165 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 166 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 169 */     int stt = 0;
/* 170 */     Double p = Double.valueOf(0.0D);
/*     */     
/* 172 */     for (MedicProductOrderDetailModel osm : medicProductOrderModels.getMedicProductOrderDetails()) {
/* 173 */       stt++;
/* 174 */       MergeFieldDTO mfd = new MergeFieldDTO();
/* 175 */       mfd.setCode("«start»");
/* 176 */       mfd.setIsGroup(Boolean.valueOf(true));
/* 177 */       mfd.setIsMultiple(Boolean.valueOf(true));
/* 178 */       mfd.setStartGroup("«start»");
/* 179 */       mfd.setEndGroup("«end»");
/*     */       
/* 181 */       List<MergeFieldDTO> children = new ArrayList<>();
/* 182 */       MergeFieldDTO model = new MergeFieldDTO();
/* 183 */       model.setCode("stt");
/* 184 */       model.setValue(String.valueOf(stt));
/* 185 */       model.setMergeField("stt");
/* 186 */       MergeFieldDTO fieldDTO = model;
/* 187 */       children.add(fieldDTO);
/*     */       
/* 189 */       model = new MergeFieldDTO();
/* 190 */       model.setCode("productName");
/* 191 */       model.setValue(osm.getName());
/* 192 */       model.setMergeField("productName");
/* 193 */       fieldDTO = model;
/* 194 */       children.add(fieldDTO);
/*     */       
/* 196 */       model = new MergeFieldDTO();
/* 197 */       model.setCode("userGuide");
/* 198 */       model.setValue(osm.getUserGuide());
/* 199 */       model.setMergeField("userGuide");
/* 200 */       fieldDTO = model;
/* 201 */       children.add(fieldDTO);
/*     */       
/* 203 */       model = new MergeFieldDTO();
/* 204 */       model.setCode("qty");
/* 205 */       model.setValue(String.valueOf(osm.getQty()));
/* 206 */       model.setMergeField("qty");
/* 207 */       fieldDTO = model;
/* 208 */       children.add(fieldDTO);
/*     */       
/* 210 */       model = new MergeFieldDTO();
/* 211 */       model.setCode("unit");
/* 212 */       model.setValue(osm.getUnit());
/* 213 */       model.setMergeField("unit");
/* 214 */       fieldDTO = model;
/* 215 */       children.add(fieldDTO);
/*     */       
/* 217 */       model = new MergeFieldDTO();
/* 218 */       model.setCode("donGia");
/* 219 */       model.setIsGroup(Boolean.valueOf(false));
/* 220 */       model.setIsMultiple(Boolean.valueOf(false));
/* 221 */       model.setValue((osm.getPriceSelling() != null) ? ApiHelper.formatDecimal(osm.getPriceSelling()) : "");
/* 222 */       model.setMergeField("donGia");
/* 223 */       fieldDTO = model;
/* 224 */       children.add(fieldDTO);
/*     */       
/* 226 */       model = new MergeFieldDTO();
/* 227 */       model.setCode("thanhTien");
/* 228 */       model.setIsGroup(Boolean.valueOf(false));
/* 229 */       model.setIsMultiple(Boolean.valueOf(false));
/* 230 */       model.setValue((osm.getPayAmount() != null) ? ApiHelper.formatDecimal(osm.getPayAmount()) : "");
/* 231 */       model.setMergeField("thanhTien");
/* 232 */       fieldDTO = model;
/* 233 */       children.add(fieldDTO);
/*     */       
/* 235 */       mfd.setChildren(children);
/* 236 */       fieldData.add(mfd);
/*     */       
/* 238 */       mergeFieldDTO.setCode("doctorAdvice");
/* 239 */       mergeFieldDTO.setValue(osm.getDoctorAdvice());
/* 240 */       mergeFieldDTO.setMergeField("doctorAdvice");
/* 241 */       mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 242 */       fieldData.add(mergeFieldDTOClone);
/*     */       
/* 244 */       p = Double.valueOf(p.doubleValue() + ((osm.getPayAmount() == null) ? 0.0D : osm.getPayAmount().doubleValue()));
/*     */     } 
/*     */ 
/*     */     
/* 248 */     mergeFieldDTO.setCode("productSize");
/* 249 */     mergeFieldDTO.setValue(String.valueOf(medicProductOrderModels.getMedicProductOrderDetails().size()));
/* 250 */     mergeFieldDTO.setMergeField("productSize");
/* 251 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 252 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 254 */     mergeFieldDTO.setCode("doctorName");
/* 255 */     mergeFieldDTO.setValue(medicProductOrderModels.getDoctorName());
/* 256 */     mergeFieldDTO.setMergeField("doctorName");
/* 257 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 258 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 260 */     mergeFieldDTO.setCode("tongTien");
/* 261 */     mergeFieldDTO.setValue(ApiHelper.formatDecimal(p));
/* 262 */     mergeFieldDTO.setMergeField("tongTien");
/* 263 */     fieldData.add(mergeFieldDTO);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\DonThuocMuaNgoaiProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */