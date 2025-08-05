/*     */ package nencer.app.Modules.Report.Entity;
/*     */ @Entity
/*     */ @Table(name = "dynamic_report")
/*     */ public class DynamicReport { private Integer rpId;
/*     */   private String rpCode;
/*     */   private String rpName;
/*     */   private String rpFileType;
/*     */   private String rpType;
/*     */   private String rpSql;
/*     */   private String rpNote;
/*     */   private String rpLang;
/*     */   
/*  13 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DynamicReport)) return false;  DynamicReport other = (DynamicReport)o; if (!other.canEqual(this)) return false;  Object this$rpId = getRpId(), other$rpId = other.getRpId(); if ((this$rpId == null) ? (other$rpId != null) : !this$rpId.equals(other$rpId)) return false;  Object this$rpCode = getRpCode(), other$rpCode = other.getRpCode(); if ((this$rpCode == null) ? (other$rpCode != null) : !this$rpCode.equals(other$rpCode)) return false;  Object this$rpName = getRpName(), other$rpName = other.getRpName(); if ((this$rpName == null) ? (other$rpName != null) : !this$rpName.equals(other$rpName)) return false;  Object this$rpFileType = getRpFileType(), other$rpFileType = other.getRpFileType(); if ((this$rpFileType == null) ? (other$rpFileType != null) : !this$rpFileType.equals(other$rpFileType)) return false;  Object this$rpType = getRpType(), other$rpType = other.getRpType(); if ((this$rpType == null) ? (other$rpType != null) : !this$rpType.equals(other$rpType)) return false;  Object this$rpSql = getRpSql(), other$rpSql = other.getRpSql(); if ((this$rpSql == null) ? (other$rpSql != null) : !this$rpSql.equals(other$rpSql)) return false;  Object this$rpNote = getRpNote(), other$rpNote = other.getRpNote(); if ((this$rpNote == null) ? (other$rpNote != null) : !this$rpNote.equals(other$rpNote)) return false;  Object this$rpLang = getRpLang(), other$rpLang = other.getRpLang(); if ((this$rpLang == null) ? (other$rpLang != null) : !this$rpLang.equals(other$rpLang)) return false;  Object this$rpFileName = getRpFileName(), other$rpFileName = other.getRpFileName(); if ((this$rpFileName == null) ? (other$rpFileName != null) : !this$rpFileName.equals(other$rpFileName)) return false;  Object this$rpFileStoreName = getRpFileStoreName(), other$rpFileStoreName = other.getRpFileStoreName(); if ((this$rpFileStoreName == null) ? (other$rpFileStoreName != null) : !this$rpFileStoreName.equals(other$rpFileStoreName)) return false;  Object this$rpStatus = getRpStatus(), other$rpStatus = other.getRpStatus(); if ((this$rpStatus == null) ? (other$rpStatus != null) : !this$rpStatus.equals(other$rpStatus)) return false;  Object this$rpCreateDate = getRpCreateDate(), other$rpCreateDate = other.getRpCreateDate(); if ((this$rpCreateDate == null) ? (other$rpCreateDate != null) : !this$rpCreateDate.equals(other$rpCreateDate)) return false;  Object this$rpUpdateDate = getRpUpdateDate(), other$rpUpdateDate = other.getRpUpdateDate(); if ((this$rpUpdateDate == null) ? (other$rpUpdateDate != null) : !this$rpUpdateDate.equals(other$rpUpdateDate)) return false;  Object this$rpCreatedBy = getRpCreatedBy(), other$rpCreatedBy = other.getRpCreatedBy(); if ((this$rpCreatedBy == null) ? (other$rpCreatedBy != null) : !this$rpCreatedBy.equals(other$rpCreatedBy)) return false;  Object this$rpUpdateBy = getRpUpdateBy(), other$rpUpdateBy = other.getRpUpdateBy(); if ((this$rpUpdateBy == null) ? (other$rpUpdateBy != null) : !this$rpUpdateBy.equals(other$rpUpdateBy)) return false;  Object this$allowGroup = getAllowGroup(), other$allowGroup = other.getAllowGroup(); if ((this$allowGroup == null) ? (other$allowGroup != null) : !this$allowGroup.equals(other$allowGroup)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } private String rpFileName; private String rpFileStoreName; private String rpStatus; private Date rpCreateDate; private Date rpUpdateDate; private String rpCreatedBy; private String rpUpdateBy; private String allowGroup; private Integer totalRecord; protected boolean canEqual(Object other) { return other instanceof DynamicReport; } public int hashCode() { int PRIME = 59; result = 1; Object $rpId = getRpId(); result = result * 59 + (($rpId == null) ? 43 : $rpId.hashCode()); Object $rpCode = getRpCode(); result = result * 59 + (($rpCode == null) ? 43 : $rpCode.hashCode()); Object $rpName = getRpName(); result = result * 59 + (($rpName == null) ? 43 : $rpName.hashCode()); Object $rpFileType = getRpFileType(); result = result * 59 + (($rpFileType == null) ? 43 : $rpFileType.hashCode()); Object $rpType = getRpType(); result = result * 59 + (($rpType == null) ? 43 : $rpType.hashCode()); Object $rpSql = getRpSql(); result = result * 59 + (($rpSql == null) ? 43 : $rpSql.hashCode()); Object $rpNote = getRpNote(); result = result * 59 + (($rpNote == null) ? 43 : $rpNote.hashCode()); Object $rpLang = getRpLang(); result = result * 59 + (($rpLang == null) ? 43 : $rpLang.hashCode()); Object $rpFileName = getRpFileName(); result = result * 59 + (($rpFileName == null) ? 43 : $rpFileName.hashCode()); Object $rpFileStoreName = getRpFileStoreName(); result = result * 59 + (($rpFileStoreName == null) ? 43 : $rpFileStoreName.hashCode()); Object $rpStatus = getRpStatus(); result = result * 59 + (($rpStatus == null) ? 43 : $rpStatus.hashCode()); Object $rpCreateDate = getRpCreateDate(); result = result * 59 + (($rpCreateDate == null) ? 43 : $rpCreateDate.hashCode()); Object $rpUpdateDate = getRpUpdateDate(); result = result * 59 + (($rpUpdateDate == null) ? 43 : $rpUpdateDate.hashCode()); Object $rpCreatedBy = getRpCreatedBy(); result = result * 59 + (($rpCreatedBy == null) ? 43 : $rpCreatedBy.hashCode()); Object $rpUpdateBy = getRpUpdateBy(); result = result * 59 + (($rpUpdateBy == null) ? 43 : $rpUpdateBy.hashCode()); Object $allowGroup = getAllowGroup(); result = result * 59 + (($allowGroup == null) ? 43 : $allowGroup.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "DynamicReport(rpId=" + getRpId() + ", rpCode=" + getRpCode() + ", rpName=" + getRpName() + ", rpFileType=" + getRpFileType() + ", rpType=" + getRpType() + ", rpSql=" + getRpSql() + ", rpNote=" + getRpNote() + ", rpLang=" + getRpLang() + ", rpFileName=" + getRpFileName() + ", rpFileStoreName=" + getRpFileStoreName() + ", rpStatus=" + getRpStatus() + ", rpCreateDate=" + getRpCreateDate() + ", rpUpdateDate=" + getRpUpdateDate() + ", rpCreatedBy=" + getRpCreatedBy() + ", rpUpdateBy=" + getRpUpdateBy() + ", allowGroup=" + getAllowGroup() + ", totalRecord=" + getTotalRecord() + ")"; }
/*     */    public DynamicReport() {} public DynamicReport(Integer rpId, String rpCode, String rpName, String rpFileType, String rpType, String rpSql, String rpNote, String rpLang, String rpFileName, String rpFileStoreName, String rpStatus, Date rpCreateDate, Date rpUpdateDate, String rpCreatedBy, String rpUpdateBy, String allowGroup, Integer totalRecord) {
/*  15 */     this.rpId = rpId; this.rpCode = rpCode; this.rpName = rpName; this.rpFileType = rpFileType; this.rpType = rpType; this.rpSql = rpSql; this.rpNote = rpNote; this.rpLang = rpLang; this.rpFileName = rpFileName; this.rpFileStoreName = rpFileStoreName; this.rpStatus = rpStatus; this.rpCreateDate = rpCreateDate; this.rpUpdateDate = rpUpdateDate; this.rpCreatedBy = rpCreatedBy; this.rpUpdateBy = rpUpdateBy; this.allowGroup = allowGroup; this.totalRecord = totalRecord;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "rp_id")
/*     */   public Integer getRpId() {
/*  40 */     return this.rpId;
/*     */   }
/*     */   
/*     */   public void setRpId(Integer rpId) {
/*  44 */     this.rpId = rpId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_code")
/*     */   public String getRpCode() {
/*  50 */     return this.rpCode;
/*     */   }
/*     */   
/*     */   public void setRpCode(String rpCode) {
/*  54 */     this.rpCode = rpCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_name")
/*     */   public String getRpName() {
/*  60 */     return this.rpName;
/*     */   }
/*     */   
/*     */   public void setRpName(String rpName) {
/*  64 */     this.rpName = rpName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_file_type")
/*     */   public String getRpFileType() {
/*  70 */     return this.rpFileType;
/*     */   }
/*     */   
/*     */   public void setRpFileType(String rpFileType) {
/*  74 */     this.rpFileType = rpFileType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_type")
/*     */   public String getRpType() {
/*  80 */     return this.rpType;
/*     */   }
/*     */   
/*     */   public void setRpType(String rpType) {
/*  84 */     this.rpType = rpType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_sql")
/*     */   public String getRpSql() {
/*  90 */     return this.rpSql;
/*     */   }
/*     */   
/*     */   public void setRpSql(String rpSql) {
/*  94 */     this.rpSql = rpSql;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_note")
/*     */   public String getRpNote() {
/* 100 */     return this.rpNote;
/*     */   }
/*     */   
/*     */   public void setRpNote(String rpNote) {
/* 104 */     this.rpNote = rpNote;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_lang")
/*     */   public String getRpLang() {
/* 110 */     return this.rpLang;
/*     */   }
/*     */   
/*     */   public void setRpLang(String rpLang) {
/* 114 */     this.rpLang = rpLang;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_file_name")
/*     */   public String getRpFileName() {
/* 120 */     return this.rpFileName;
/*     */   }
/*     */   
/*     */   public void setRpFileName(String rpFileName) {
/* 124 */     this.rpFileName = rpFileName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_file_store_name")
/*     */   public String getRpFileStoreName() {
/* 130 */     return this.rpFileStoreName;
/*     */   }
/*     */   
/*     */   public void setRpFileStoreName(String rpFileStoreName) {
/* 134 */     this.rpFileStoreName = rpFileStoreName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_status")
/*     */   public String getRpStatus() {
/* 140 */     return this.rpStatus;
/*     */   }
/*     */   
/*     */   public void setRpStatus(String rpStatus) {
/* 144 */     this.rpStatus = rpStatus;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_create_date")
/*     */   public Date getRpCreateDate() {
/* 150 */     return this.rpCreateDate;
/*     */   }
/*     */   
/*     */   public void setRpCreateDate(Date rpCreateDate) {
/* 154 */     this.rpCreateDate = rpCreateDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_update_date")
/*     */   public Date getRpUpdateDate() {
/* 160 */     return this.rpUpdateDate;
/*     */   }
/*     */   
/*     */   public void setRpUpdateDate(Date rpUpdateDate) {
/* 164 */     this.rpUpdateDate = rpUpdateDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_created_by")
/*     */   public String getRpCreatedBy() {
/* 170 */     return this.rpCreatedBy;
/*     */   }
/*     */   
/*     */   public void setRpCreatedBy(String rpCreatedBy) {
/* 174 */     this.rpCreatedBy = rpCreatedBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "rp_update_by")
/*     */   public String getRpUpdateBy() {
/* 180 */     return this.rpUpdateBy;
/*     */   }
/*     */   
/*     */   public void setRpUpdateBy(String rpUpdateBy) {
/* 184 */     this.rpUpdateBy = rpUpdateBy;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "allow_group")
/*     */   public String getAllowGroup() {
/* 190 */     return this.allowGroup;
/*     */   }
/*     */   
/*     */   public void setAllowGroup(String allowGroup) {
/* 194 */     this.allowGroup = allowGroup;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public Integer getTotalRecord() {
/* 199 */     return this.totalRecord;
/*     */   }
/*     */   
/*     */   public void setTotalRecord(Integer totalRecord) {
/* 203 */     this.totalRecord = totalRecord;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Entity\DynamicReport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */