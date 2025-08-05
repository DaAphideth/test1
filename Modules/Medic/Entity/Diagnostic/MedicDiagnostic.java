/*    */ package nencer.app.Modules.Medic.Entity.Diagnostic;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_diagnostic")
/*    */ public class MedicDiagnostic {
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   
/* 12 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicDiagnostic)) return false;  MedicDiagnostic other = (MedicDiagnostic)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$nameEn = getNameEn(), other$nameEn = other.getNameEn(); if ((this$nameEn == null) ? (other$nameEn != null) : !this$nameEn.equals(other$nameEn)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } private String nameEn; private Integer status; private Date createdAt; private Date updatedAt; protected boolean canEqual(Object other) { return other instanceof MedicDiagnostic; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $nameEn = getNameEn(); result = result * 59 + (($nameEn == null) ? 43 : $nameEn.hashCode()); Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "MedicDiagnostic(id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", nameEn=" + getNameEn() + ", status=" + getStatus() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; }
/*    */    public MedicDiagnostic() {} public MedicDiagnostic(int id, String code, String name, String nameEn, Integer status, Date createdAt, Date updatedAt) {
/* 14 */     this.id = id; this.code = code; this.name = name; this.nameEn = nameEn; this.status = status; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getStatus() {
/* 23 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Integer status) {
/* 27 */     this.status = status;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 38 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 42 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 48 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 52 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 58 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 62 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name_en")
/*    */   public String getNameEn() {
/* 68 */     return this.nameEn;
/*    */   }
/*    */   
/*    */   public void setNameEn(String nameEn) {
/* 72 */     this.nameEn = nameEn;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 78 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 82 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 88 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 92 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Diagnostic\MedicDiagnostic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */