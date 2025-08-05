/*     */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_medical_record")
/*     */ public class MedicCheckinMedicalRecord
/*     */ {
/*     */   private Integer mdId;
/*     */   private String thongTinBenhAn;
/*     */   private String lichSuBenh;
/*     */   private String khamBenh;
/*     */   private String tongKet;
/*     */   
/*     */   @Id
/*     */   @Column(name = "md_id")
/*     */   public int getMdId() {
/*  24 */     return this.mdId.intValue();
/*     */   }
/*     */   private String createdBy; private String headOfId; private String headOfBy; private Integer createdId; private Date createdDate;
/*     */   public void setMdId(int mdId) {
/*  28 */     this.mdId = Integer.valueOf(mdId);
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "thong_tin_benh_an")
/*     */   public String getThongTinBenhAn() {
/*  34 */     return this.thongTinBenhAn;
/*     */   }
/*     */   
/*     */   public void setThongTinBenhAn(String thongTinBenhAn) {
/*  38 */     this.thongTinBenhAn = thongTinBenhAn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lich_su_benh")
/*     */   public String getLichSuBenh() {
/*  44 */     return this.lichSuBenh;
/*     */   }
/*     */   
/*     */   public void setLichSuBenh(String lichSuBenh) {
/*  48 */     this.lichSuBenh = lichSuBenh;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "kham_benh")
/*     */   public String getKhamBenh() {
/*  54 */     return this.khamBenh;
/*     */   }
/*     */   
/*     */   public void setKhamBenh(String khamBenh) {
/*  58 */     this.khamBenh = khamBenh;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "tong_ket")
/*     */   public String getTongKet() {
/*  64 */     return this.tongKet;
/*     */   }
/*     */   
/*     */   public void setTongKet(String tongKet) {
/*  68 */     this.tongKet = tongKet;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_by")
/*     */   public String getCreatedBy() {
/*  74 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  78 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "head_of_id")
/*     */   public String getHeadOfId() {
/*  84 */     return this.headOfId;
/*     */   }
/*     */   
/*     */   public void setHeadOfId(String headOfId) {
/*  88 */     this.headOfId = headOfId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "head_of_by")
/*     */   public String getHeadOfBy() {
/*  94 */     return this.headOfBy;
/*     */   }
/*     */   
/*     */   public void setHeadOfBy(String headOfBy) {
/*  98 */     this.headOfBy = headOfBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_id")
/*     */   public Integer getCreatedId() {
/* 104 */     return this.createdId;
/*     */   }
/*     */   
/*     */   public void setCreatedId(Integer createdId) {
/* 108 */     this.createdId = createdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_date")
/*     */   public Date getCreatedDate() {
/* 114 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Date createdDate) {
/* 118 */     this.createdDate = createdDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 123 */     if (this == o) return true; 
/* 124 */     if (o == null || getClass() != o.getClass()) return false; 
/* 125 */     MedicCheckinMedicalRecord that = (MedicCheckinMedicalRecord)o;
/* 126 */     return (this.mdId == that.mdId && Objects.equals(this.thongTinBenhAn, that.thongTinBenhAn) && Objects.equals(this.lichSuBenh, that.lichSuBenh) && Objects.equals(this.khamBenh, that.khamBenh) && Objects.equals(this.tongKet, that.tongKet) && Objects.equals(this.createdBy, that.createdBy) && Objects.equals(this.headOfId, that.headOfId) && Objects.equals(this.headOfBy, that.headOfBy) && Objects.equals(this.createdId, that.createdId) && Objects.equals(this.createdDate, that.createdDate));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return Objects.hash(new Object[] { this.mdId, this.thongTinBenhAn, this.lichSuBenh, this.khamBenh, this.tongKet, this.createdBy, this.headOfId, this.headOfBy, this.createdId, this.createdDate });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinMedicalRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */