/*     */ package nencer.app.Modules.Localization.Entity;@Entity
/*     */ @Table(name = "local_admin_units")
/*     */ public class LocalAdminUnits implements Serializable { private int id;
/*     */   private String fullName;
/*     */   private String fullNameEn;
/*     */   private String shortName;
/*     */   private String shortNameEn;
/*     */   private String codeName;
/*     */   private String codeNameEn;
/*     */   private Date createdAt;
/*     */   private Date updatedAt;
/*     */   
/*     */   public LocalAdminUnits(int id, String fullName, String fullNameEn, String shortName, String shortNameEn, String codeName, String codeNameEn, Date createdAt, Date updatedAt) {
/*  14 */     this.id = id; this.fullName = fullName; this.fullNameEn = fullNameEn; this.shortName = shortName; this.shortNameEn = shortNameEn; this.codeName = codeName; this.codeNameEn = codeNameEn; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*     */   } public LocalAdminUnits() {}
/*  16 */   public static LocalAdminUnitsBuilder builder() { return new LocalAdminUnitsBuilder(); } public static class LocalAdminUnitsBuilder { private int id; private String fullName; private String fullNameEn; private String shortName; public LocalAdminUnitsBuilder id(int id) { this.id = id; return this; } private String shortNameEn; private String codeName; private String codeNameEn; private Date createdAt; private Date updatedAt; public LocalAdminUnitsBuilder fullName(String fullName) { this.fullName = fullName; return this; } public LocalAdminUnitsBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public LocalAdminUnitsBuilder shortName(String shortName) { this.shortName = shortName; return this; } public LocalAdminUnitsBuilder shortNameEn(String shortNameEn) { this.shortNameEn = shortNameEn; return this; } public LocalAdminUnitsBuilder codeName(String codeName) { this.codeName = codeName; return this; } public LocalAdminUnitsBuilder codeNameEn(String codeNameEn) { this.codeNameEn = codeNameEn; return this; } public LocalAdminUnitsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LocalAdminUnitsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LocalAdminUnits build() { return new LocalAdminUnits(this.id, this.fullName, this.fullNameEn, this.shortName, this.shortNameEn, this.codeName, this.codeNameEn, this.createdAt, this.updatedAt); } public String toString() { return "LocalAdminUnits.LocalAdminUnitsBuilder(id=" + this.id + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", shortName=" + this.shortName + ", shortNameEn=" + this.shortNameEn + ", codeName=" + this.codeName + ", codeNameEn=" + this.codeNameEn + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; } }
/*  17 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LocalAdminUnits)) return false;  LocalAdminUnits other = (LocalAdminUnits)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$fullName = getFullName(), other$fullName = other.getFullName(); if ((this$fullName == null) ? (other$fullName != null) : !this$fullName.equals(other$fullName)) return false;  Object this$fullNameEn = getFullNameEn(), other$fullNameEn = other.getFullNameEn(); if ((this$fullNameEn == null) ? (other$fullNameEn != null) : !this$fullNameEn.equals(other$fullNameEn)) return false;  Object this$shortName = getShortName(), other$shortName = other.getShortName(); if ((this$shortName == null) ? (other$shortName != null) : !this$shortName.equals(other$shortName)) return false;  Object this$shortNameEn = getShortNameEn(), other$shortNameEn = other.getShortNameEn(); if ((this$shortNameEn == null) ? (other$shortNameEn != null) : !this$shortNameEn.equals(other$shortNameEn)) return false;  Object this$codeName = getCodeName(), other$codeName = other.getCodeName(); if ((this$codeName == null) ? (other$codeName != null) : !this$codeName.equals(other$codeName)) return false;  Object this$codeNameEn = getCodeNameEn(), other$codeNameEn = other.getCodeNameEn(); if ((this$codeNameEn == null) ? (other$codeNameEn != null) : !this$codeNameEn.equals(other$codeNameEn)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof LocalAdminUnits; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $fullName = getFullName(); result = result * 59 + (($fullName == null) ? 43 : $fullName.hashCode()); Object $fullNameEn = getFullNameEn(); result = result * 59 + (($fullNameEn == null) ? 43 : $fullNameEn.hashCode()); Object $shortName = getShortName(); result = result * 59 + (($shortName == null) ? 43 : $shortName.hashCode()); Object $shortNameEn = getShortNameEn(); result = result * 59 + (($shortNameEn == null) ? 43 : $shortNameEn.hashCode()); Object $codeName = getCodeName(); result = result * 59 + (($codeName == null) ? 43 : $codeName.hashCode()); Object $codeNameEn = getCodeNameEn(); result = result * 59 + (($codeNameEn == null) ? 43 : $codeNameEn.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "LocalAdminUnits(id=" + getId() + ", fullName=" + getFullName() + ", fullNameEn=" + getFullNameEn() + ", shortName=" + getShortName() + ", shortNameEn=" + getShortNameEn() + ", codeName=" + getCodeName() + ", codeNameEn=" + getCodeNameEn() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
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
/*     */   public int getId() {
/*  33 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name")
/*     */   public String getFullName() {
/*  43 */     return this.fullName;
/*     */   }
/*     */   
/*     */   public void setFullName(String fullName) {
/*  47 */     this.fullName = fullName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "full_name_en")
/*     */   public String getFullNameEn() {
/*  53 */     return this.fullNameEn;
/*     */   }
/*     */   
/*     */   public void setFullNameEn(String fullNameEn) {
/*  57 */     this.fullNameEn = fullNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "short_name")
/*     */   public String getShortName() {
/*  63 */     return this.shortName;
/*     */   }
/*     */   
/*     */   public void setShortName(String shortName) {
/*  67 */     this.shortName = shortName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "short_name_en")
/*     */   public String getShortNameEn() {
/*  73 */     return this.shortNameEn;
/*     */   }
/*     */   
/*     */   public void setShortNameEn(String shortNameEn) {
/*  77 */     this.shortNameEn = shortNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name")
/*     */   public String getCodeName() {
/*  83 */     return this.codeName;
/*     */   }
/*     */   
/*     */   public void setCodeName(String codeName) {
/*  87 */     this.codeName = codeName;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_name_en")
/*     */   public String getCodeNameEn() {
/*  93 */     return this.codeNameEn;
/*     */   }
/*     */   
/*     */   public void setCodeNameEn(String codeNameEn) {
/*  97 */     this.codeNameEn = codeNameEn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 103 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 107 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 113 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 117 */     this.updatedAt = updatedAt;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalAdminUnits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */