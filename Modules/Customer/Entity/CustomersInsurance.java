/*     */ package nencer.app.Modules.Customer.Entity;@Entity
/*     */ @Table(name = "customers_insurance")
/*     */ public class CustomersInsurance { private Integer insuranceId; private Integer customerId; private String insuranceNumber; private String insuranceNumber1; private String insuranceNumber2; private String insuranceNumber3; private String insuranceNumber4; private String insuranceCskcb; private String insuranceCskcb1; private String insuranceCskcb2; private Date insuranceFromDate; private Date insuranceExpirationDate; private String insuranceAddress; private String insuranceLine; private String insuranceLive;
/*     */   private String status;
/*     */   private String note;
/*     */   private Integer creatorId;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   private Integer updatedId;
/*     */   private Integer benefitRate;
/*     */   
/*  12 */   public static CustomersInsuranceBuilder builder() { return new CustomersInsuranceBuilder(); } public static class CustomersInsuranceBuilder { private Integer insuranceId; private Integer customerId; private String insuranceNumber; private String insuranceNumber1; private String insuranceNumber2; private String insuranceNumber3; private String insuranceNumber4; private String insuranceCskcb; private String insuranceCskcb1; private String insuranceCskcb2; private Date insuranceFromDate; public CustomersInsuranceBuilder insuranceId(Integer insuranceId) { this.insuranceId = insuranceId; return this; } private Date insuranceExpirationDate; private String insuranceAddress; private String insuranceLine; private String insuranceLive; private String status; private String note; private Integer creatorId; private Date createdAt; private Date updatedAt; private Integer updatedId; private Integer benefitRate; public CustomersInsuranceBuilder customerId(Integer customerId) { this.customerId = customerId; return this; } public CustomersInsuranceBuilder insuranceNumber(String insuranceNumber) { this.insuranceNumber = insuranceNumber; return this; } public CustomersInsuranceBuilder insuranceNumber1(String insuranceNumber1) { this.insuranceNumber1 = insuranceNumber1; return this; } public CustomersInsuranceBuilder insuranceNumber2(String insuranceNumber2) { this.insuranceNumber2 = insuranceNumber2; return this; } public CustomersInsuranceBuilder insuranceNumber3(String insuranceNumber3) { this.insuranceNumber3 = insuranceNumber3; return this; } public CustomersInsuranceBuilder insuranceNumber4(String insuranceNumber4) { this.insuranceNumber4 = insuranceNumber4; return this; } public CustomersInsuranceBuilder insuranceCskcb(String insuranceCskcb) { this.insuranceCskcb = insuranceCskcb; return this; } public CustomersInsuranceBuilder insuranceCskcb1(String insuranceCskcb1) { this.insuranceCskcb1 = insuranceCskcb1; return this; } public CustomersInsuranceBuilder insuranceCskcb2(String insuranceCskcb2) { this.insuranceCskcb2 = insuranceCskcb2; return this; } public CustomersInsuranceBuilder insuranceFromDate(Date insuranceFromDate) { this.insuranceFromDate = insuranceFromDate; return this; } public CustomersInsuranceBuilder insuranceExpirationDate(Date insuranceExpirationDate) { this.insuranceExpirationDate = insuranceExpirationDate; return this; } public CustomersInsuranceBuilder insuranceAddress(String insuranceAddress) { this.insuranceAddress = insuranceAddress; return this; } public CustomersInsuranceBuilder insuranceLine(String insuranceLine) { this.insuranceLine = insuranceLine; return this; } public CustomersInsuranceBuilder insuranceLive(String insuranceLive) { this.insuranceLive = insuranceLive; return this; } public CustomersInsuranceBuilder status(String status) { this.status = status; return this; } public CustomersInsuranceBuilder note(String note) { this.note = note; return this; } public CustomersInsuranceBuilder creatorId(Integer creatorId) { this.creatorId = creatorId; return this; } public CustomersInsuranceBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public CustomersInsuranceBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public CustomersInsuranceBuilder updatedId(Integer updatedId) { this.updatedId = updatedId; return this; } public CustomersInsuranceBuilder benefitRate(Integer benefitRate) { this.benefitRate = benefitRate; return this; } public CustomersInsurance build() { return new CustomersInsurance(this.insuranceId, this.customerId, this.insuranceNumber, this.insuranceNumber1, this.insuranceNumber2, this.insuranceNumber3, this.insuranceNumber4, this.insuranceCskcb, this.insuranceCskcb1, this.insuranceCskcb2, this.insuranceFromDate, this.insuranceExpirationDate, this.insuranceAddress, this.insuranceLine, this.insuranceLive, this.status, this.note, this.creatorId, this.createdAt, this.updatedAt, this.updatedId, this.benefitRate); } public String toString() { return "CustomersInsurance.CustomersInsuranceBuilder(insuranceId=" + this.insuranceId + ", customerId=" + this.customerId + ", insuranceNumber=" + this.insuranceNumber + ", insuranceNumber1=" + this.insuranceNumber1 + ", insuranceNumber2=" + this.insuranceNumber2 + ", insuranceNumber3=" + this.insuranceNumber3 + ", insuranceNumber4=" + this.insuranceNumber4 + ", insuranceCskcb=" + this.insuranceCskcb + ", insuranceCskcb1=" + this.insuranceCskcb1 + ", insuranceCskcb2=" + this.insuranceCskcb2 + ", insuranceFromDate=" + this.insuranceFromDate + ", insuranceExpirationDate=" + this.insuranceExpirationDate + ", insuranceAddress=" + this.insuranceAddress + ", insuranceLine=" + this.insuranceLine + ", insuranceLive=" + this.insuranceLive + ", status=" + this.status + ", note=" + this.note + ", creatorId=" + this.creatorId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedId=" + this.updatedId + ", benefitRate=" + this.benefitRate + ")"; }
/*     */      } public CustomersInsurance() {}
/*  14 */   public CustomersInsurance(Integer insuranceId, Integer customerId, String insuranceNumber, String insuranceNumber1, String insuranceNumber2, String insuranceNumber3, String insuranceNumber4, String insuranceCskcb, String insuranceCskcb1, String insuranceCskcb2, Date insuranceFromDate, Date insuranceExpirationDate, String insuranceAddress, String insuranceLine, String insuranceLive, String status, String note, Integer creatorId, Date createdAt, Date updatedAt, Integer updatedId, Integer benefitRate) { this.insuranceId = insuranceId; this.customerId = customerId; this.insuranceNumber = insuranceNumber; this.insuranceNumber1 = insuranceNumber1; this.insuranceNumber2 = insuranceNumber2; this.insuranceNumber3 = insuranceNumber3; this.insuranceNumber4 = insuranceNumber4; this.insuranceCskcb = insuranceCskcb; this.insuranceCskcb1 = insuranceCskcb1; this.insuranceCskcb2 = insuranceCskcb2; this.insuranceFromDate = insuranceFromDate; this.insuranceExpirationDate = insuranceExpirationDate; this.insuranceAddress = insuranceAddress; this.insuranceLine = insuranceLine; this.insuranceLive = insuranceLive; this.status = status; this.note = note; this.creatorId = creatorId; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedId = updatedId; this.benefitRate = benefitRate; }
/*  15 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CustomersInsurance)) return false;  CustomersInsurance other = (CustomersInsurance)o; if (!other.canEqual(this)) return false;  Object this$insuranceId = getInsuranceId(), other$insuranceId = other.getInsuranceId(); if ((this$insuranceId == null) ? (other$insuranceId != null) : !this$insuranceId.equals(other$insuranceId)) return false;  Object this$customerId = getCustomerId(), other$customerId = other.getCustomerId(); if ((this$customerId == null) ? (other$customerId != null) : !this$customerId.equals(other$customerId)) return false;  Object this$insuranceNumber = getInsuranceNumber(), other$insuranceNumber = other.getInsuranceNumber(); if ((this$insuranceNumber == null) ? (other$insuranceNumber != null) : !this$insuranceNumber.equals(other$insuranceNumber)) return false;  Object this$insuranceNumber1 = getInsuranceNumber1(), other$insuranceNumber1 = other.getInsuranceNumber1(); if ((this$insuranceNumber1 == null) ? (other$insuranceNumber1 != null) : !this$insuranceNumber1.equals(other$insuranceNumber1)) return false;  Object this$insuranceNumber2 = getInsuranceNumber2(), other$insuranceNumber2 = other.getInsuranceNumber2(); if ((this$insuranceNumber2 == null) ? (other$insuranceNumber2 != null) : !this$insuranceNumber2.equals(other$insuranceNumber2)) return false;  Object this$insuranceNumber3 = getInsuranceNumber3(), other$insuranceNumber3 = other.getInsuranceNumber3(); if ((this$insuranceNumber3 == null) ? (other$insuranceNumber3 != null) : !this$insuranceNumber3.equals(other$insuranceNumber3)) return false;  Object this$insuranceNumber4 = getInsuranceNumber4(), other$insuranceNumber4 = other.getInsuranceNumber4(); if ((this$insuranceNumber4 == null) ? (other$insuranceNumber4 != null) : !this$insuranceNumber4.equals(other$insuranceNumber4)) return false;  Object this$insuranceCskcb = getInsuranceCskcb(), other$insuranceCskcb = other.getInsuranceCskcb(); if ((this$insuranceCskcb == null) ? (other$insuranceCskcb != null) : !this$insuranceCskcb.equals(other$insuranceCskcb)) return false;  Object this$insuranceCskcb1 = getInsuranceCskcb1(), other$insuranceCskcb1 = other.getInsuranceCskcb1(); if ((this$insuranceCskcb1 == null) ? (other$insuranceCskcb1 != null) : !this$insuranceCskcb1.equals(other$insuranceCskcb1)) return false;  Object this$insuranceCskcb2 = getInsuranceCskcb2(), other$insuranceCskcb2 = other.getInsuranceCskcb2(); if ((this$insuranceCskcb2 == null) ? (other$insuranceCskcb2 != null) : !this$insuranceCskcb2.equals(other$insuranceCskcb2)) return false;  Object this$insuranceFromDate = getInsuranceFromDate(), other$insuranceFromDate = other.getInsuranceFromDate(); if ((this$insuranceFromDate == null) ? (other$insuranceFromDate != null) : !this$insuranceFromDate.equals(other$insuranceFromDate)) return false;  Object this$insuranceExpirationDate = getInsuranceExpirationDate(), other$insuranceExpirationDate = other.getInsuranceExpirationDate(); if ((this$insuranceExpirationDate == null) ? (other$insuranceExpirationDate != null) : !this$insuranceExpirationDate.equals(other$insuranceExpirationDate)) return false;  Object this$insuranceAddress = getInsuranceAddress(), other$insuranceAddress = other.getInsuranceAddress(); if ((this$insuranceAddress == null) ? (other$insuranceAddress != null) : !this$insuranceAddress.equals(other$insuranceAddress)) return false;  Object this$insuranceLine = getInsuranceLine(), other$insuranceLine = other.getInsuranceLine(); if ((this$insuranceLine == null) ? (other$insuranceLine != null) : !this$insuranceLine.equals(other$insuranceLine)) return false;  Object this$insuranceLive = getInsuranceLive(), other$insuranceLive = other.getInsuranceLive(); if ((this$insuranceLive == null) ? (other$insuranceLive != null) : !this$insuranceLive.equals(other$insuranceLive)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$note = getNote(), other$note = other.getNote(); if ((this$note == null) ? (other$note != null) : !this$note.equals(other$note)) return false;  Object this$creatorId = getCreatorId(), other$creatorId = other.getCreatorId(); if ((this$creatorId == null) ? (other$creatorId != null) : !this$creatorId.equals(other$creatorId)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedId = getUpdatedId(), other$updatedId = other.getUpdatedId(); if ((this$updatedId == null) ? (other$updatedId != null) : !this$updatedId.equals(other$updatedId)) return false;  Object this$benefitRate = getBenefitRate(), other$benefitRate = other.getBenefitRate(); return !((this$benefitRate == null) ? (other$benefitRate != null) : !this$benefitRate.equals(other$benefitRate)); } protected boolean canEqual(Object other) { return other instanceof CustomersInsurance; } public int hashCode() { int PRIME = 59; result = 1; Object $insuranceId = getInsuranceId(); result = result * 59 + (($insuranceId == null) ? 43 : $insuranceId.hashCode()); Object $customerId = getCustomerId(); result = result * 59 + (($customerId == null) ? 43 : $customerId.hashCode()); Object $insuranceNumber = getInsuranceNumber(); result = result * 59 + (($insuranceNumber == null) ? 43 : $insuranceNumber.hashCode()); Object $insuranceNumber1 = getInsuranceNumber1(); result = result * 59 + (($insuranceNumber1 == null) ? 43 : $insuranceNumber1.hashCode()); Object $insuranceNumber2 = getInsuranceNumber2(); result = result * 59 + (($insuranceNumber2 == null) ? 43 : $insuranceNumber2.hashCode()); Object $insuranceNumber3 = getInsuranceNumber3(); result = result * 59 + (($insuranceNumber3 == null) ? 43 : $insuranceNumber3.hashCode()); Object $insuranceNumber4 = getInsuranceNumber4(); result = result * 59 + (($insuranceNumber4 == null) ? 43 : $insuranceNumber4.hashCode()); Object $insuranceCskcb = getInsuranceCskcb(); result = result * 59 + (($insuranceCskcb == null) ? 43 : $insuranceCskcb.hashCode()); Object $insuranceCskcb1 = getInsuranceCskcb1(); result = result * 59 + (($insuranceCskcb1 == null) ? 43 : $insuranceCskcb1.hashCode()); Object $insuranceCskcb2 = getInsuranceCskcb2(); result = result * 59 + (($insuranceCskcb2 == null) ? 43 : $insuranceCskcb2.hashCode()); Object $insuranceFromDate = getInsuranceFromDate(); result = result * 59 + (($insuranceFromDate == null) ? 43 : $insuranceFromDate.hashCode()); Object $insuranceExpirationDate = getInsuranceExpirationDate(); result = result * 59 + (($insuranceExpirationDate == null) ? 43 : $insuranceExpirationDate.hashCode()); Object $insuranceAddress = getInsuranceAddress(); result = result * 59 + (($insuranceAddress == null) ? 43 : $insuranceAddress.hashCode()); Object $insuranceLine = getInsuranceLine(); result = result * 59 + (($insuranceLine == null) ? 43 : $insuranceLine.hashCode()); Object $insuranceLive = getInsuranceLive(); result = result * 59 + (($insuranceLive == null) ? 43 : $insuranceLive.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $note = getNote(); result = result * 59 + (($note == null) ? 43 : $note.hashCode()); Object $creatorId = getCreatorId(); result = result * 59 + (($creatorId == null) ? 43 : $creatorId.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedId = getUpdatedId(); result = result * 59 + (($updatedId == null) ? 43 : $updatedId.hashCode()); Object $benefitRate = getBenefitRate(); return result * 59 + (($benefitRate == null) ? 43 : $benefitRate.hashCode()); } public String toString() { return "CustomersInsurance(insuranceId=" + getInsuranceId() + ", customerId=" + getCustomerId() + ", insuranceNumber=" + getInsuranceNumber() + ", insuranceNumber1=" + getInsuranceNumber1() + ", insuranceNumber2=" + getInsuranceNumber2() + ", insuranceNumber3=" + getInsuranceNumber3() + ", insuranceNumber4=" + getInsuranceNumber4() + ", insuranceCskcb=" + getInsuranceCskcb() + ", insuranceCskcb1=" + getInsuranceCskcb1() + ", insuranceCskcb2=" + getInsuranceCskcb2() + ", insuranceFromDate=" + getInsuranceFromDate() + ", insuranceExpirationDate=" + getInsuranceExpirationDate() + ", insuranceAddress=" + getInsuranceAddress() + ", insuranceLine=" + getInsuranceLine() + ", insuranceLive=" + getInsuranceLive() + ", status=" + getStatus() + ", note=" + getNote() + ", creatorId=" + getCreatorId() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedId=" + getUpdatedId() + ", benefitRate=" + getBenefitRate() + ")"; }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "insurance_id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getInsuranceId() {
/*  46 */     return this.insuranceId;
/*     */   }
/*     */   
/*     */   public void setInsuranceId(Integer insuranceId) {
/*  50 */     this.insuranceId = insuranceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_id")
/*     */   public Integer getCustomerId() {
/*  56 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Integer customerId) {
/*  60 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_number")
/*     */   public String getInsuranceNumber() {
/*  66 */     return this.insuranceNumber;
/*     */   }
/*     */   
/*     */   public void setInsuranceNumber(String insuranceNumber) {
/*  70 */     this.insuranceNumber = insuranceNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_cskcb")
/*     */   public String getInsuranceCskcb() {
/*  76 */     return this.insuranceCskcb;
/*     */   }
/*     */   
/*     */   public void setInsuranceCskcb(String insuranceCskcb) {
/*  80 */     this.insuranceCskcb = insuranceCskcb;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_expiration_date")
/*     */   public Date getInsuranceExpirationDate() {
/*  86 */     return this.insuranceExpirationDate;
/*     */   }
/*     */   
/*     */   public void setInsuranceExpirationDate(Date insuranceExpirationDate) {
/*  90 */     this.insuranceExpirationDate = insuranceExpirationDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_from_date")
/*     */   public Date getInsuranceFromDate() {
/*  96 */     return this.insuranceFromDate;
/*     */   }
/*     */   
/*     */   public void setInsuranceFromDate(Date insuranceFromDate) {
/* 100 */     this.insuranceFromDate = insuranceFromDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_address")
/*     */   public String getInsuranceAddress() {
/* 106 */     return this.insuranceAddress;
/*     */   }
/*     */   
/*     */   public void setInsuranceAddress(String insuranceAddress) {
/* 110 */     this.insuranceAddress = insuranceAddress;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_line")
/*     */   public String getInsuranceLine() {
/* 116 */     return this.insuranceLine;
/*     */   }
/*     */   
/*     */   public void setInsuranceLine(String insuranceLine) {
/* 120 */     this.insuranceLine = insuranceLine;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_live")
/*     */   public String getInsuranceLive() {
/* 126 */     return this.insuranceLive;
/*     */   }
/*     */   
/*     */   public void setInsuranceLive(String insuranceLive) {
/* 130 */     this.insuranceLive = insuranceLive;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 136 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 140 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/* 146 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 150 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 156 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 160 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 166 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 170 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 176 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 180 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_id")
/*     */   public Integer getUpdatedId() {
/* 186 */     return this.updatedId;
/*     */   }
/*     */   
/*     */   public void setUpdatedId(Integer updatedId) {
/* 190 */     this.updatedId = updatedId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_number_1")
/*     */   public String getInsuranceNumber1() {
/* 196 */     return this.insuranceNumber1;
/*     */   }
/*     */   
/*     */   public void setInsuranceNumber1(String insuranceNumber1) {
/* 200 */     this.insuranceNumber1 = insuranceNumber1;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_number_2")
/*     */   public String getInsuranceNumber2() {
/* 206 */     return this.insuranceNumber2;
/*     */   }
/*     */   
/*     */   public void setInsuranceNumber2(String insuranceNumber2) {
/* 210 */     this.insuranceNumber2 = insuranceNumber2;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_number_3")
/*     */   public String getInsuranceNumber3() {
/* 216 */     return this.insuranceNumber3;
/*     */   }
/*     */   
/*     */   public void setInsuranceNumber3(String insuranceNumber3) {
/* 220 */     this.insuranceNumber3 = insuranceNumber3;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_number_4")
/*     */   public String getInsuranceNumber4() {
/* 226 */     return this.insuranceNumber4;
/*     */   }
/*     */   
/*     */   public void setInsuranceNumber4(String insuranceNumber4) {
/* 230 */     this.insuranceNumber4 = insuranceNumber4;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_cskcb_1")
/*     */   public String getInsuranceCskcb1() {
/* 236 */     return this.insuranceCskcb1;
/*     */   }
/*     */   
/*     */   public void setInsuranceCskcb1(String insuranceCskcb1) {
/* 240 */     this.insuranceCskcb1 = insuranceCskcb1;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_cskcb_2")
/*     */   public String getInsuranceCskcb2() {
/* 246 */     return this.insuranceCskcb2;
/*     */   }
/*     */   
/*     */   public void setInsuranceCskcb2(String insuranceCskcb2) {
/* 250 */     this.insuranceCskcb2 = insuranceCskcb2;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "benefit_rate")
/*     */   public Integer getBenefitRate() {
/* 256 */     return this.benefitRate;
/*     */   }
/*     */   
/*     */   public void setBenefitRate(Integer benefitRate) {
/* 260 */     this.benefitRate = benefitRate;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Entity\CustomersInsurance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */