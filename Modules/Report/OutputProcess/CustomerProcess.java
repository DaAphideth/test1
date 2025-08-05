/*     */ package nencer.app.Modules.Report.OutputProcess;
/*     */ 
/*     */ import java.util.List;
/*     */ import nencer.app.Modules.Medic.Model.Checkin.CheckinPrintFormResponse;
/*     */ import nencer.app.Utils.ApiHelper;
/*     */ import nencer.app.Utils.MergeFieldDTO;
/*     */ import nencer.app.Utils.ObjectCommonUtils;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class CustomerProcess
/*     */ {
/*     */   public void getCustomer(CheckinPrintFormResponse re, List<MergeFieldDTO> fieldData, MergeFieldDTO mergeFieldDTO) {
/*  15 */     mergeFieldDTO.setCode("departmentHealth");
/*  16 */     mergeFieldDTO.setValue(re.getDepartmentHealth());
/*  17 */     mergeFieldDTO.setMergeField("departmentHealth");
/*  18 */     MergeFieldDTO mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  19 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  21 */     mergeFieldDTO.setCode("hospitalName");
/*  22 */     mergeFieldDTO.setValue(re.getHospitalName());
/*  23 */     mergeFieldDTO.setMergeField("hospitalName");
/*  24 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  25 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  27 */     mergeFieldDTO.setCode("addressHospital");
/*  28 */     mergeFieldDTO.setValue(re.getAddressHospital());
/*  29 */     mergeFieldDTO.setMergeField("addressHospital");
/*  30 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  31 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  33 */     mergeFieldDTO.setCode("number");
/*  34 */     mergeFieldDTO.setValue(re.getNumber());
/*  35 */     mergeFieldDTO.setMergeField("number");
/*  36 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  37 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  39 */     mergeFieldDTO.setCode("patientId");
/*  40 */     mergeFieldDTO.setValue(re.getPatientId());
/*  41 */     mergeFieldDTO.setMergeField("patientId");
/*  42 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  43 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  45 */     mergeFieldDTO.setCode("customerName");
/*  46 */     mergeFieldDTO.setValue(re.getName());
/*  47 */     mergeFieldDTO.setMergeField("customerName");
/*  48 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  49 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  51 */     mergeFieldDTO.setCode("yearBorn");
/*  52 */     mergeFieldDTO.setValue(((re.getDayBorn() != null) ? (re.getDayBorn() + "/") : "") + ((re.getMonthBorn() != null) ? (re.getMonthBorn() + "/") : "") + re.getYearBorn());
/*  53 */     mergeFieldDTO.setMergeField("yearBorn");
/*  54 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  55 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  57 */     mergeFieldDTO.setCode("roomName");
/*  58 */     mergeFieldDTO.setValue(re.getRoomName());
/*  59 */     mergeFieldDTO.setMergeField("roomName");
/*  60 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  61 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  63 */     mergeFieldDTO.setCode("age");
/*  64 */     mergeFieldDTO.setValue(String.valueOf(ApiHelper.getAge(re.getYearBorn())));
/*  65 */     mergeFieldDTO.setMergeField("age");
/*  66 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  67 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  69 */     mergeFieldDTO.setCode("gender");
/*  70 */     mergeFieldDTO.setValue(re.getGender());
/*  71 */     mergeFieldDTO.setMergeField("gender");
/*  72 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  73 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/*  76 */     mergeFieldDTO.setCode("phone");
/*  77 */     mergeFieldDTO.setValue(re.getPhone());
/*  78 */     mergeFieldDTO.setMergeField("phone");
/*  79 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  80 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  82 */     mergeFieldDTO.setCode("address");
/*  83 */     mergeFieldDTO.setValue(((re.getAddress() != null) ? (re.getAddress() + ", ") : " ") + ((re.getWardName() != null) ? (re.getWardName() + ", ") : " ") + ((re.getDistrictName() != null) ? (re.getDistrictName() + ", ") : " ") + ((re.getProvinceName() != null) ? re.getProvinceName() : ""));
/*  84 */     mergeFieldDTO.setMergeField("address");
/*  85 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  86 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  88 */     mergeFieldDTO.setCode("customerType");
/*  89 */     mergeFieldDTO.setValue(re.getCustomerType());
/*  90 */     mergeFieldDTO.setMergeField("customerType");
/*  91 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  92 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/*  94 */     mergeFieldDTO.setCode("date");
/*  95 */     mergeFieldDTO.setValue(ApiHelper.dateToString(re.getCreatedDate(), "dd"));
/*  96 */     mergeFieldDTO.setMergeField("date");
/*  97 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/*  98 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */ 
/*     */     
/* 102 */     mergeFieldDTO.setCode("createDate");
/* 103 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(re.getCreatedDate()));
/* 104 */     mergeFieldDTO.setMergeField("createDate");
/* 105 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 106 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 108 */     mergeFieldDTO.setCode("ngayKham");
/* 109 */     mergeFieldDTO.setValue(re.getDayExam());
/* 110 */     mergeFieldDTO.setMergeField("ngayKham");
/* 111 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 112 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 114 */     mergeFieldDTO.setCode("thangKham");
/* 115 */     mergeFieldDTO.setValue(re.getMonthExam());
/* 116 */     mergeFieldDTO.setMergeField("thangKham");
/* 117 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 118 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 120 */     mergeFieldDTO.setCode("namKham");
/* 121 */     mergeFieldDTO.setValue(re.getYearExam());
/* 122 */     mergeFieldDTO.setMergeField("namKham");
/* 123 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 124 */     fieldData.add(mergeFieldDTOClone);
/*     */ 
/*     */     
/* 127 */     mergeFieldDTO.setCode("createDate");
/* 128 */     mergeFieldDTO.setValue(ApiHelper.dateToString1(re.getCreatedDate()));
/* 129 */     mergeFieldDTO.setMergeField("createDate");
/* 130 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 131 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 133 */     mergeFieldDTO.setCode("nameDoctor");
/* 134 */     mergeFieldDTO.setValue(re.getNameDoctor());
/* 135 */     mergeFieldDTO.setMergeField("nameDoctor");
/* 136 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 137 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 139 */     mergeFieldDTO.setCode("serviceName");
/* 140 */     mergeFieldDTO.setValue(re.getServiceName());
/* 141 */     mergeFieldDTO.setMergeField("serviceName");
/* 142 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 143 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 145 */     mergeFieldDTO.setCode("bhyt");
/* 146 */     mergeFieldDTO.setValue(re.getBhyt());
/* 147 */     mergeFieldDTO.setMergeField("bhyt");
/* 148 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 149 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 151 */     mergeFieldDTO.setCode("insuranceFromDate");
/* 152 */     mergeFieldDTO.setValue(re.getInsuranceFromDate());
/* 153 */     mergeFieldDTO.setMergeField("insuranceFromDate");
/* 154 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 155 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 157 */     mergeFieldDTO.setCode("insuranceExpirationDate");
/* 158 */     mergeFieldDTO.setValue(re.getInsuranceExpirationDate());
/* 159 */     mergeFieldDTO.setMergeField("insuranceExpirationDate");
/* 160 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 161 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 163 */     mergeFieldDTO.setCode("country");
/* 164 */     mergeFieldDTO.setValue(re.getCountryName());
/* 165 */     mergeFieldDTO.setMergeField("country");
/* 166 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 167 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 169 */     mergeFieldDTO.setCode("jobTitle");
/* 170 */     mergeFieldDTO.setValue(re.getJobTitle());
/* 171 */     mergeFieldDTO.setMergeField("jobTitle");
/* 172 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 173 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 175 */     mergeFieldDTO.setCode("ethnic");
/* 176 */     mergeFieldDTO.setValue(re.getEthnic());
/* 177 */     mergeFieldDTO.setMergeField("ethnic");
/* 178 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 179 */     fieldData.add(mergeFieldDTOClone);
/*     */     
/* 181 */     mergeFieldDTO.setCode("reason");
/* 182 */     mergeFieldDTO.setValue(re.getReason());
/* 183 */     mergeFieldDTO.setMergeField("reason");
/* 184 */     mergeFieldDTOClone = (MergeFieldDTO)ObjectCommonUtils.cloneObject(mergeFieldDTO);
/* 185 */     fieldData.add(mergeFieldDTOClone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\OutputProcess\CustomerProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */