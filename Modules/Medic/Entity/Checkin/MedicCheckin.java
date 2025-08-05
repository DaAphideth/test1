/*     */ package nencer.app.Modules.Medic.Entity.Checkin;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ import nencer.app.Modules.Customer.Entity.Customers;
/*     */ import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
/*     */ import org.springframework.data.annotation.CreatedDate;
/*     */ import org.springframework.data.annotation.LastModifiedDate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_checkin")
/*     */ public class MedicCheckin
/*     */ {
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
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  44 */     return this.roomId;
/*     */   } private String status; private String examinationType; private String paymentStatus; private Integer insuranceId; private Integer priority; private Integer creatorId; @CreatedDate
/*     */   private Date createdAt; @LastModifiedDate
/*     */   private Date updatedAt; private Integer isCreateInvoice; private Customers customers; private List<MedicOrderServices> medicOrderServices; public void setRoomId(Integer roomId) {
/*  48 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public Integer getServiceId() {
/*  54 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(Integer serviceId) {
/*  58 */     this.serviceId = serviceId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "payment_status")
/*     */   public String getPaymentStatus() {
/*  65 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */   public void setPaymentStatus(String paymentStatus) {
/*  69 */     this.paymentStatus = paymentStatus;
/*     */   }
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_id")
/*     */   public Integer getPatientId() {
/*  86 */     return this.patientId;
/*     */   }
/*     */   
/*     */   public void setPatientId(Integer patientId) {
/*  90 */     this.patientId = patientId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_number")
/*     */   public String getPatientNumber() {
/*  96 */     return this.patientNumber;
/*     */   }
/*     */   
/*     */   public void setPatientNumber(String patientNumber) {
/* 100 */     this.patientNumber = patientNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_type")
/*     */   public String getCustomerType() {
/* 106 */     return this.customerType;
/*     */   }
/*     */   
/*     */   public void setCustomerType(String customerType) {
/* 110 */     this.customerType = customerType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "reason")
/*     */   public String getReason() {
/* 116 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 120 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public Integer getNumber() {
/* 126 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/* 130 */     this.number = number;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "hospital_id")
/*     */   public Integer getHospitalId() {
/* 137 */     return this.hospitalId;
/*     */   }
/*     */   
/*     */   public void setHospitalId(Integer hospitalId) {
/* 141 */     this.hospitalId = hospitalId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/* 147 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 151 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/* 157 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 161 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "insurance_id")
/*     */   public Integer getInsuranceId() {
/* 167 */     return this.insuranceId;
/*     */   }
/*     */   
/*     */   public void setInsuranceId(Integer insuranceId) {
/* 171 */     this.insuranceId = insuranceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "priority")
/*     */   public Integer getPriority() {
/* 177 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer priority) {
/* 181 */     this.priority = priority;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public Integer getCreatorId() {
/* 187 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(Integer creatorId) {
/* 191 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 197 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 201 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 207 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 211 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "iscreate_invoice")
/*     */   public Integer getIsCreateInvoice() {
/* 217 */     return this.isCreateInvoice;
/*     */   }
/*     */   
/*     */   public void setIsCreateInvoice(Integer isCreateInvoice) {
/* 221 */     this.isCreateInvoice = isCreateInvoice;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "patient_id", referencedColumnName = "id", updatable = false, insertable = false)
/*     */   public Customers getCustomers() {
/* 227 */     return this.customers;
/*     */   }
/*     */   
/*     */   public void setCustomers(Customers customers) {
/* 231 */     this.customers = customers;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "examination_type")
/*     */   public String getExaminationType() {
/* 237 */     return this.examinationType;
/*     */   }
/*     */   
/*     */   public void setExaminationType(String examinationType) {
/* 241 */     this.examinationType = examinationType;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public List<MedicOrderServices> getMedicOrderServices() {
/* 246 */     return this.medicOrderServices;
/*     */   }
/*     */   
/*     */   public void setMedicOrderServices(List<MedicOrderServices> medicOrderServices) {
/* 250 */     this.medicOrderServices = medicOrderServices;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */