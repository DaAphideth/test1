/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UnitResponseBuilder {
/*    */   private Long id;
/*    */   private String fullName;
/*    */   private String fullNameEn;
/*    */   private String shortName;
/*    */   private String shortNameEn;
/*    */   
/* 12 */   public UnitResponseBuilder id(Long id) { this.id = id; return this; } private String codeName; private String codeNameEn; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public UnitResponseBuilder fullName(String fullName) { this.fullName = fullName; return this; } public UnitResponseBuilder fullNameEn(String fullNameEn) { this.fullNameEn = fullNameEn; return this; } public UnitResponseBuilder shortName(String shortName) { this.shortName = shortName; return this; } public UnitResponseBuilder shortNameEn(String shortNameEn) { this.shortNameEn = shortNameEn; return this; } public UnitResponseBuilder codeName(String codeName) { this.codeName = codeName; return this; } public UnitResponseBuilder codeNameEn(String codeNameEn) { this.codeNameEn = codeNameEn; return this; } public UnitResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public UnitResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public UnitResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public UnitResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public UnitResponse build() { return new UnitResponse(this.id, this.fullName, this.fullNameEn, this.shortName, this.shortNameEn, this.codeName, this.codeNameEn, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "UnitResponse.UnitResponseBuilder(id=" + this.id + ", fullName=" + this.fullName + ", fullNameEn=" + this.fullNameEn + ", shortName=" + this.shortName + ", shortNameEn=" + this.shortNameEn + ", codeName=" + this.codeName + ", codeNameEn=" + this.codeNameEn + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\UnitResponse$UnitResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */