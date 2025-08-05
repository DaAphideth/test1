/*    */ package nencer.app.Modules.Report.Entity;@Entity @Table(name = "dynamic_report_his") @JsonIgnoreProperties(ignoreUnknown = true) public class DynamicReportHis { @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id; @Column(name = "rp_id") private Integer rpId; @Basic @Column(name = "rp_code")
/*    */   private String rpCode; @Basic
/*    */   @Column(name = "rp_name")
/*    */   private String rpName; @Basic
/*    */   @Column(name = "rp_file_type")
/*    */   private String rpFileType; @Basic
/*    */   @Column(name = "rp_type")
/*    */   private String rpType; @Basic
/*    */   @Column(name = "rp_sql")
/*    */   private String rpSql; @Basic
/*    */   @Column(name = "rp_note")
/*    */   private String rpNote; @Basic
/*    */   @Column(name = "rp_lang")
/* 14 */   private String rpLang; public void setId(Integer id) { this.id = id; } @Basic @Column(name = "rp_file_name") private String rpFileName; @Basic @Column(name = "rp_file_store_name") private String rpFileStoreName; @Basic @Column(name = "rp_status") private String rpStatus; @Basic @Column(name = "rp_create_date") private Date rpCreateDate; @Basic @Column(name = "rp_update_date") private Date rpUpdateDate; @Basic @Column(name = "created_date") private Date createdDate; @Basic @Column(name = "rp_created_by") private String rpCreatedBy; @Basic @Column(name = "rp_update_by") private String rpUpdateBy; @Basic @Column(name = "allow_group") private String allowGroup; public void setRpId(Integer rpId) { this.rpId = rpId; } public void setRpCode(String rpCode) { this.rpCode = rpCode; } public void setRpName(String rpName) { this.rpName = rpName; } public void setRpFileType(String rpFileType) { this.rpFileType = rpFileType; } public void setRpType(String rpType) { this.rpType = rpType; } public void setRpSql(String rpSql) { this.rpSql = rpSql; } public void setRpNote(String rpNote) { this.rpNote = rpNote; } public void setRpLang(String rpLang) { this.rpLang = rpLang; } public void setRpFileName(String rpFileName) { this.rpFileName = rpFileName; } public void setRpFileStoreName(String rpFileStoreName) { this.rpFileStoreName = rpFileStoreName; } public void setRpStatus(String rpStatus) { this.rpStatus = rpStatus; } public void setRpCreateDate(Date rpCreateDate) { this.rpCreateDate = rpCreateDate; } public void setRpUpdateDate(Date rpUpdateDate) { this.rpUpdateDate = rpUpdateDate; } public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; } public void setRpCreatedBy(String rpCreatedBy) { this.rpCreatedBy = rpCreatedBy; } public void setRpUpdateBy(String rpUpdateBy) { this.rpUpdateBy = rpUpdateBy; } public void setAllowGroup(String allowGroup) { this.allowGroup = allowGroup; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   public Integer getRpId() {
/* 25 */     return this.rpId;
/*    */   }
/*    */   public String getRpCode() {
/* 28 */     return this.rpCode;
/*    */   }
/*    */   public String getRpName() {
/* 31 */     return this.rpName;
/*    */   }
/*    */   public String getRpFileType() {
/* 34 */     return this.rpFileType;
/*    */   }
/*    */   public String getRpType() {
/* 37 */     return this.rpType;
/*    */   }
/*    */   public String getRpSql() {
/* 40 */     return this.rpSql;
/*    */   }
/*    */   public String getRpNote() {
/* 43 */     return this.rpNote;
/*    */   }
/*    */   public String getRpLang() {
/* 46 */     return this.rpLang;
/*    */   }
/*    */   public String getRpFileName() {
/* 49 */     return this.rpFileName;
/*    */   }
/*    */   public String getRpFileStoreName() {
/* 52 */     return this.rpFileStoreName;
/*    */   }
/*    */   public String getRpStatus() {
/* 55 */     return this.rpStatus;
/*    */   }
/*    */   public Date getRpCreateDate() {
/* 58 */     return this.rpCreateDate;
/*    */   }
/*    */   public Date getRpUpdateDate() {
/* 61 */     return this.rpUpdateDate;
/*    */   }
/*    */   public Date getCreatedDate() {
/* 64 */     return this.createdDate;
/*    */   }
/*    */   public String getRpCreatedBy() {
/* 67 */     return this.rpCreatedBy;
/*    */   }
/*    */   public String getRpUpdateBy() {
/* 70 */     return this.rpUpdateBy;
/*    */   }
/*    */   public String getAllowGroup() {
/* 73 */     return this.allowGroup;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Entity\DynamicReportHis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */