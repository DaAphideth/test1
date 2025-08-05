/*     */ package nencer.app.Modules.Medic.Entity.Examination;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_examination")
/*     */ public class MedicExamination
/*     */   implements Serializable {
/*     */   private Integer id;
/*     */   private Integer doctorId;
/*     */   private String doctorName;
/*     */   private Integer mdId;
/*     */   private String examinationArray;
/*     */   private String diagnosticArray;
/*     */   private String diagnosticSubArray;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public Integer getId() {
/*  31 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  35 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_id")
/*     */   public Integer getDoctorId() {
/*  41 */     return this.doctorId;
/*     */   }
/*     */   
/*     */   public void setDoctorId(Integer doctorId) {
/*  45 */     this.doctorId = doctorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "doctor_name")
/*     */   public String getDoctorName() {
/*  51 */     return this.doctorName;
/*     */   }
/*     */   
/*     */   public void setDoctorName(String doctorName) {
/*  55 */     this.doctorName = doctorName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/*  61 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  65 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "examination_array")
/*     */   public String getExaminationArray() {
/*  71 */     return this.examinationArray;
/*     */   }
/*     */   
/*     */   public void setExaminationArray(String examinationArray) {
/*  75 */     this.examinationArray = examinationArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_array")
/*     */   public String getDiagnosticArray() {
/*  81 */     return this.diagnosticArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticArray(String diagnosticArray) {
/*  85 */     this.diagnosticArray = diagnosticArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "diagnostic_sub_array")
/*     */   public String getDiagnosticSubArray() {
/*  91 */     return this.diagnosticSubArray;
/*     */   }
/*     */   
/*     */   public void setDiagnosticSubArray(String diagnosticSubArray) {
/*  95 */     this.diagnosticSubArray = diagnosticSubArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 101 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 105 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 111 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 115 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Examination\MedicExamination.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */