/*     */ package nencer.app.Modules.Medic.Entity.Checkin;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import org.springframework.data.annotation.CreatedDate;
/*     */ import org.springframework.data.annotation.LastModifiedDate;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_his")
/*     */ public class MedicCheckinHis {
/*     */   private Integer id;
/*     */   private Integer patientId;
/*     */   private Integer roomId;
/*     */   private Integer serviceId;
/*     */   private String patientNumber;
/*     */   private String customerType;
/*     */   private String reason;
/*     */   private Integer number;
/*     */   private Integer hospitalId;
/*     */   private String note;
/*     */   private String status;
/*     */   private String examinationType;
/*     */   private String paymentStatus;
/*     */   private Integer insuranceId;
/*     */   private Integer priority;
/*     */   private Integer creatorId;
/*     */   @CreatedDate
/*     */   private Date createdAt;
/*     */   @LastModifiedDate
/*     */   private Date updatedAt;
/*     */   private Integer isCreateInvoice;
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  40 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/*  44 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public Integer getServiceId() {
/*  50 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/*  54 */     this.serviceId = serviceId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment_status")
/*     */   public String getPaymentStatus() {
/*  61 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */   public void setPaymentStatus(String paymentStatus) {
/*  65 */     this.paymentStatus = paymentStatus;
/*     */   }
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public Integer getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  75 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_id")
/*     */   public Integer getPatientId() {
/*  81 */     return this.patientId;
/*     */   }
/*     */   
/*     */   public void setPatientId(Integer patientId) {
/*  85 */     this.patientId = patientId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_number")
/*     */   public String getPatientNumber() {
/*  91 */     return this.patientNumber;
/*     */   }
/*     */   
/*     */   public void setPatientNumber(String patientNumber) {
/*  95 */     this.patientNumber = patientNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_type")
/*     */   public String getCustomerType() {
/* 101 */     return this.customerType;
/*     */   }
/*     */   
/*     */   public void setCustomerType(String customerType) {
/* 105 */     this.customerType = customerType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 111 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 115 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public Integer getNumber() {
/* 121 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/* 125 */     this.number = number;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_id")
/*     */   public Integer getHospitalId() {
/* 132 */     return this.hospitalId;
/*     */   }
/*     */   
/*     */   public void setHospitalId(Integer hospitalId) {
/* 136 */     this.hospitalId = hospitalId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/* 142 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 146 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 152 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 156 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_id")
/*     */   public Integer getInsuranceId() {
/* 162 */     return this.insuranceId;
/*     */   }
/*     */   
/*     */   public void setInsuranceId(Integer insuranceId) {
/* 166 */     this.insuranceId = insuranceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "priority")
/*     */   public Integer getPriority() {
/* 172 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer priority) {
/* 176 */     this.priority = priority;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 182 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 186 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 192 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 196 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 202 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 206 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "iscreate_invoice")
/*     */   public Integer getIsCreateInvoice() {
/* 212 */     return this.isCreateInvoice;
/*     */   }
/*     */   
/*     */   public void setIsCreateInvoice(Integer isCreateInvoice) {
/* 216 */     this.isCreateInvoice = isCreateInvoice;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "examination_type")
/*     */   public String getExaminationType() {
/* 223 */     return this.examinationType;
/*     */   }
/*     */   
/*     */   public void setExaminationType(String examinationType) {
/* 227 */     this.examinationType = examinationType;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckinHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */