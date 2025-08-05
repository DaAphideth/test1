/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinMedicalRecord;
/*     */ import nencer.app.Modules.Report.Model.ExportModel;
/*     */ import nencer.app.Modules.Report.Model.ThongTinBenhAnModel;
/*     */ import nencer.app.Utils.MailMergeUtil;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class PhieuBenhAnProcess
/*     */   extends BaseProcess
/*     */ {
/*     */   public void getProcess(String fileTemplate, ExportModel exportModel, String barCode, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*     */     try {
/*  33 */       Path rootPath = Paths.get(fileTemplate, new String[0]);
/*  34 */       byte[] bytes = Files.readAllBytes(rootPath);
/*  35 */       WordprocessingMLPackage document = MailMergeUtil.convertFileToDocument(bytes);
/*  36 */       List<String> mapRes = MailMergeUtil.getAllFieldsToListString(document);
/*  37 */       Map<String, Object> phieuBAModel = this.commonReportRepo.getBenhAN(exportModel.getMdId());
/*  38 */       for (String str : mapRes) {
/*  39 */         mergeFieldDTO = new MergeFieldDTO();
/*  40 */         if (phieuBAModel.containsKey(str)) {
/*  41 */           mergeFieldDTO.setCode(str);
/*  42 */           String value = (String)phieuBAModel.get(str);
/*  43 */           mergeFieldDTO.setValue(value);
/*  44 */           mergeFieldDTO.setMergeField(str);
/*     */           
/*  46 */           fieldData.add(mergeFieldDTO);
/*     */         }
/*     */       
/*     */       }
/*     */     
/*  51 */     } catch (Exception ex) {
/*  52 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  53 */       logger.error(exceptionAsString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void process(MedicCheckinMedicalRecord model, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) throws JsonProcessingException {
/*  62 */     if (model != null && StringUtils.isNotBlank(model.getThongTinBenhAn())) {
/*  63 */       ThongTinBenhAnModel thongTinBenhAnModel = (ThongTinBenhAnModel)this.objectMapper.readValue(model.getThongTinBenhAn(), ThongTinBenhAnModel.class);
/*  64 */       if (thongTinBenhAnModel != null) {
/*  65 */         mergeFieldDTO.setCode("hoVaTen");
/*  66 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getFullName());
/*  67 */         mergeFieldDTO.setMergeField("hoVaTen");
/*  68 */         MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  69 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/*  71 */         mergeFieldDTO.setCode("tuoi");
/*  72 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getAge());
/*  73 */         mergeFieldDTO.setMergeField("tuoi");
/*  74 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  75 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/*  77 */         mergeFieldDTO.setCode("gioiTinh");
/*  78 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getGender());
/*  79 */         mergeFieldDTO.setMergeField("gioiTinh");
/*  80 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  81 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/*  83 */         mergeFieldDTO.setCode("nhiemVuPhuTrach");
/*  84 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getDutyHandle());
/*  85 */         mergeFieldDTO.setMergeField("nhiemVuPhuTrach");
/*  86 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  87 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/*  89 */         mergeFieldDTO.setCode("ngheNghiep");
/*  90 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getJobTitle());
/*  91 */         mergeFieldDTO.setMergeField("ngheNghiep");
/*  92 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  93 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/*  95 */         mergeFieldDTO.setCode("quocTich");
/*  96 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/*  97 */         mergeFieldDTO.setMergeField("quocTich");
/*  98 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  99 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 101 */         mergeFieldDTO.setCode("cmnd");
/* 102 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 103 */         mergeFieldDTO.setMergeField("cmnd");
/* 104 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 105 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 107 */         mergeFieldDTO.setCode("soTheBHYT");
/* 108 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 109 */         mergeFieldDTO.setMergeField("soTheBHYT");
/* 110 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 111 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 113 */         mergeFieldDTO.setCode("donVi");
/* 114 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 115 */         mergeFieldDTO.setMergeField("donVi");
/* 116 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 117 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 119 */         mergeFieldDTO.setCode("xa");
/* 120 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 121 */         mergeFieldDTO.setMergeField("xa");
/* 122 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 123 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 125 */         mergeFieldDTO.setCode("huyen");
/* 126 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 127 */         mergeFieldDTO.setMergeField("huyen");
/* 128 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 129 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 131 */         mergeFieldDTO.setCode("tinh");
/* 132 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 133 */         mergeFieldDTO.setMergeField("tinh");
/* 134 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 135 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 137 */         mergeFieldDTO.setCode("tenBo");
/* 138 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 139 */         mergeFieldDTO.setMergeField("tenBo");
/* 140 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 141 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 143 */         mergeFieldDTO.setCode("tenMe");
/* 144 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 145 */         mergeFieldDTO.setMergeField("tenMe");
/* 146 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 147 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 149 */         mergeFieldDTO.setCode("tenVoHoacChong");
/* 150 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 151 */         mergeFieldDTO.setMergeField("tenVoHoacChong");
/* 152 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 153 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 155 */         mergeFieldDTO.setCode("ngayVaoCM");
/* 156 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 157 */         mergeFieldDTO.setMergeField("ngayVaoCM");
/* 158 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 159 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 161 */         mergeFieldDTO.setCode("ngayVaoQD");
/* 162 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 163 */         mergeFieldDTO.setMergeField("ngayVaoQD");
/* 164 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 165 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 167 */         mergeFieldDTO.setCode("ngayBiBenh");
/* 168 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 169 */         mergeFieldDTO.setMergeField("ngayBiBenh");
/* 170 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 171 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 173 */         mergeFieldDTO.setCode("nguoiNhaMuonBaoTin");
/* 174 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 175 */         mergeFieldDTO.setMergeField("nguoiNhaMuonBaoTin");
/* 176 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 177 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 179 */         mergeFieldDTO.setCode("soDT");
/* 180 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 181 */         mergeFieldDTO.setMergeField("soDT");
/* 182 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 183 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 185 */         mergeFieldDTO.setCode("guiDenTuDonVi");
/* 186 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 187 */         mergeFieldDTO.setMergeField("guiDenTuDonVi");
/* 188 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 189 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 191 */         mergeFieldDTO.setCode("raVienDDT");
/* 192 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 193 */         mergeFieldDTO.setMergeField("raVienDDT");
/* 194 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 195 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 197 */         mergeFieldDTO.setCode("phuongTienVC");
/* 198 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 199 */         mergeFieldDTO.setMergeField("phuongTienVC");
/* 200 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 201 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 203 */         mergeFieldDTO.setCode("tongSoNNV");
/* 204 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 205 */         mergeFieldDTO.setMergeField("tongSoNNV");
/* 206 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 207 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 209 */         mergeFieldDTO.setCode("thoiGianVV");
/* 210 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 211 */         mergeFieldDTO.setMergeField("thoiGianVV");
/* 212 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 213 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 215 */         mergeFieldDTO.setCode("thoiGianRV");
/* 216 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 217 */         mergeFieldDTO.setMergeField("thoiGianRV");
/* 218 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 219 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 221 */         mergeFieldDTO.setCode("thoiGianVK");
/* 222 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 223 */         mergeFieldDTO.setMergeField("thoiGianVK");
/* 224 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 225 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 227 */         mergeFieldDTO.setCode("ketQuaDT");
/* 228 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 229 */         mergeFieldDTO.setMergeField("ketQuaDT");
/* 230 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 231 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 233 */         mergeFieldDTO.setCode("thoiGianCK");
/* 234 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 235 */         mergeFieldDTO.setMergeField("thoiGianCK");
/* 236 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 237 */         fieldData.add(mergeFieldDTOClone);
/*     */         
/* 239 */         mergeFieldDTO.setCode("nguoiDKVV");
/* 240 */         mergeFieldDTO.setValue(thongTinBenhAnModel.getNationality());
/* 241 */         mergeFieldDTO.setMergeField("nguoiDKVV");
/* 242 */         mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 243 */         fieldData.add(mergeFieldDTOClone);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\PhieuBenhAnProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */