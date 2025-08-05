/*     */ package nencer.app.Modules.Medic.Entity.TreatmentDetail;
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_treatment_detail")
/*     */ public class MedicCheckinTreatmentDetail implements Serializable { private int id;
/*     */   private Integer mdId;
/*     */   private Date createdDate;
/*     */   private String createdBy;
/*     */   private Integer createdId;
/*     */   private Date ngayYLenh;
/*     */   private String dienBienBenh;
/*     */   private String yLenh;
/*     */   private String createdDateView;
/*     */   
/*  14 */   public static MedicCheckinTreatmentDetailBuilder builder() { return new MedicCheckinTreatmentDetailBuilder(); } public static class MedicCheckinTreatmentDetailBuilder { private int id; private Integer mdId; private Date createdDate; private String createdBy; public MedicCheckinTreatmentDetailBuilder id(int id) { this.id = id; return this; } private Integer createdId; private Date ngayYLenh; private String dienBienBenh; private String yLenh; private String createdDateView; public MedicCheckinTreatmentDetailBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinTreatmentDetailBuilder createdDate(Date createdDate) { this.createdDate = createdDate; return this; } public MedicCheckinTreatmentDetailBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicCheckinTreatmentDetailBuilder createdId(Integer createdId) { this.createdId = createdId; return this; } public MedicCheckinTreatmentDetailBuilder ngayYLenh(Date ngayYLenh) { this.ngayYLenh = ngayYLenh; return this; } public MedicCheckinTreatmentDetailBuilder dienBienBenh(String dienBienBenh) { this.dienBienBenh = dienBienBenh; return this; } public MedicCheckinTreatmentDetailBuilder yLenh(String yLenh) { this.yLenh = yLenh; return this; } public MedicCheckinTreatmentDetailBuilder createdDateView(String createdDateView) { this.createdDateView = createdDateView; return this; } public MedicCheckinTreatmentDetail build() { return new MedicCheckinTreatmentDetail(this.id, this.mdId, this.createdDate, this.createdBy, this.createdId, this.ngayYLenh, this.dienBienBenh, this.yLenh, this.createdDateView); } public String toString() { return "MedicCheckinTreatmentDetail.MedicCheckinTreatmentDetailBuilder(id=" + this.id + ", mdId=" + this.mdId + ", createdDate=" + this.createdDate + ", createdBy=" + this.createdBy + ", createdId=" + this.createdId + ", ngayYLenh=" + this.ngayYLenh + ", dienBienBenh=" + this.dienBienBenh + ", yLenh=" + this.yLenh + ", createdDateView=" + this.createdDateView + ")"; }
/*     */      } public MedicCheckinTreatmentDetail() {} public MedicCheckinTreatmentDetail(int id, Integer mdId, Date createdDate, String createdBy, Integer createdId, Date ngayYLenh, String dienBienBenh, String yLenh, String createdDateView) {
/*  16 */     this.id = id; this.mdId = mdId; this.createdDate = createdDate; this.createdBy = createdBy; this.createdId = createdId; this.ngayYLenh = ngayYLenh; this.dienBienBenh = dienBienBenh; this.yLenh = yLenh; this.createdDateView = createdDateView;
/*     */   }
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
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  34 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/*  44 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  48 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_date")
/*     */   public Date getCreatedDate() {
/*  54 */     return this.createdDate;
/*     */   }
/*     */   
/*     */   public void setCreatedDate(Date createdDate) {
/*  58 */     this.createdDate = createdDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_by")
/*     */   public String getCreatedBy() {
/*  64 */     return this.createdBy;
/*     */   }
/*     */   
/*     */   public void setCreatedBy(String createdBy) {
/*  68 */     this.createdBy = createdBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_id")
/*     */   public Integer getCreatedId() {
/*  74 */     return this.createdId;
/*     */   }
/*     */   
/*     */   public void setCreatedId(Integer createdId) {
/*  78 */     this.createdId = createdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ngay_y_lenh")
/*     */   public Date getNgayYLenh() {
/*  84 */     return this.ngayYLenh;
/*     */   }
/*     */   
/*     */   public void setNgayYLenh(Date ngayYLenh) {
/*  88 */     this.ngayYLenh = ngayYLenh;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "dien_bien_benh")
/*     */   public String getDienBienBenh() {
/*  94 */     return this.dienBienBenh;
/*     */   }
/*     */   
/*     */   public void setDienBienBenh(String dienBienBenh) {
/*  98 */     this.dienBienBenh = dienBienBenh;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "y_lenh")
/*     */   public String getyLenh() {
/* 104 */     return this.yLenh;
/*     */   }
/*     */   
/*     */   public void setyLenh(String yLenh) {
/* 108 */     this.yLenh = yLenh;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public String getCreatedDateView() {
/* 113 */     return this.createdDateView;
/*     */   }
/*     */   
/*     */   public void setCreatedDateView(String createdDateView) {
/* 117 */     this.createdDateView = createdDateView;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TreatmentDetail\MedicCheckinTreatmentDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */