/*    */ package nencer.app.Modules.Localization.Entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class LocalAdminUnitsBuilder {
/*    */   private int id;
/*    */   private String fullName;
/*    */   private String fullNameEn;
/*    */   private String shortName;
/*    */   private String shortNameEn;
/*    */   private String codeName;
/*    */   private String codeNameEn;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   
/* 16 */   public LocalAdminUnitsBuilder id(int id) { this.id = id; return this; } public LocalAdminUnitsBuilder fullName(String fullName) { this.fullName = fullName; return this; } public LocalAdminUnitsBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public LocalAdminUnitsBuilder shortName(String shortName) { this.shortName = shortName; return this; } public LocalAdminUnitsBuilder shortNameEn(String shortNameEn) { this.shortNameEn = shortNameEn; return this; } public LocalAdminUnitsBuilder codeName(String codeName) { this.codeName = codeName; return this; } public LocalAdminUnitsBuilder codeNameEn(String codeNameEn) { this.codeNameEn = codeNameEn; return this; } public LocalAdminUnitsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LocalAdminUnitsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LocalAdminUnits build() { return new LocalAdminUnits(this.id, this.fullName, this.fullNameEn, this.shortName, this.shortNameEn, this.codeName, this.codeNameEn, this.createdAt, this.updatedAt); } public String toString() { return "LocalAdminUnits.LocalAdminUnitsBuilder(id=" + this.id + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", shortName=" + this.shortName + ", shortNameEn=" + this.shortNameEn + ", codeName=" + this.codeName + ", codeNameEn=" + this.codeNameEn + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LocalAdminUnits$LocalAdminUnitsBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */