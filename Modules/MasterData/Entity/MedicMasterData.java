/*     */ package nencer.app.Modules.MasterData.Entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.IdClass;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_master_data")
/*     */ @IdClass(MedicMasterDataPK.class)
/*     */ @JsonIgnoreProperties(ignoreUnknown = true)
/*     */ public class MedicMasterData
/*     */ {
/*     */   private String medicCode;
/*     */   private String medicName;
/*     */   private String medicType;
/*     */   private String medicTypeName;
/*     */   private String medicDescription;
/*     */   
/*     */   @Id
/*     */   @Basic
/*     */   @Column(name = "medic_code")
/*     */   public String getMedicCode() {
/*  28 */     return this.medicCode;
/*     */   }
/*     */   private String medicNameArray; private String defaultValue; private Integer isEdit; private Integer status; private Integer startNumber; private Integer endNumber;
/*     */   public void setMedicCode(String medicCode) {
/*  32 */     this.medicCode = medicCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  38 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  42 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "medic_name")
/*     */   public String getMedicName() {
/*  48 */     return this.medicName;
/*     */   }
/*     */   
/*     */   public void setMedicName(String medicName) {
/*  52 */     this.medicName = medicName;
/*     */   }
/*     */   
/*     */   @Id
/*     */   @Basic
/*     */   @Column(name = "medic_type")
/*     */   public String getMedicType() {
/*  59 */     return this.medicType;
/*     */   }
/*     */   
/*     */   public void setMedicType(String medicType) {
/*  63 */     this.medicType = medicType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "medic_description")
/*     */   public String getMedicDescription() {
/*  69 */     return this.medicDescription;
/*     */   }
/*     */   
/*     */   public void setMedicDescription(String medicDescription) {
/*  73 */     this.medicDescription = medicDescription;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "medic_name_array")
/*     */   public String getMedicNameArray() {
/*  79 */     return this.medicNameArray;
/*     */   }
/*     */   
/*     */   public void setMedicNameArray(String medicNameArray) {
/*  83 */     this.medicNameArray = medicNameArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "medic_type_name")
/*     */   public String getMedicTypeName() {
/*  89 */     return this.medicTypeName;
/*     */   }
/*     */   
/*     */   public void setMedicTypeName(String medicTypeName) {
/*  93 */     this.medicTypeName = medicTypeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_edit")
/*     */   public Integer getIsEdit() {
/*  99 */     return this.isEdit;
/*     */   }
/*     */   
/*     */   public void setIsEdit(Integer isEdit) {
/* 103 */     this.isEdit = isEdit;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "default_value")
/*     */   public String getDefaultValue() {
/* 109 */     return this.defaultValue;
/*     */   }
/*     */   
/*     */   public void setDefaultValue(String defaultValue) {
/* 113 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\MasterData\Entity\MedicMasterData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */