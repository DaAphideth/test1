/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RegionResponseBuilder {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String nameEn;
/*    */   private String codeName;
/*    */   private String codeNameEn;
/*    */   
/*    */   public RegionResponseBuilder id(Integer id) {
/* 13 */     this.id = id; return this; } private Integer sort; private Integer status; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public RegionResponseBuilder name(String name) { this.name = name; return this; } public RegionResponseBuilder nameEn(String nameEn) { this.nameEn = nameEn; return this; } public RegionResponseBuilder codeName(String codeName) { this.codeName = codeName; return this; } public RegionResponseBuilder codeNameEn(String codeNameEn) { this.codeNameEn = codeNameEn; return this; } public RegionResponseBuilder sort(Integer sort) { this.sort = sort; return this; } public RegionResponseBuilder status(Integer status) { this.status = status; return this; } public RegionResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RegionResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public RegionResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public RegionResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public RegionResponse build() { return new RegionResponse(this.id, this.name, this.nameEn, this.codeName, this.codeNameEn, this.sort, this.status, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "RegionResponse.RegionResponseBuilder(id=" + this.id + ", name=" + this.name + ", nameEn=" + this.nameEn + ", codeName=" + this.codeName + ", codeNameEn=" + this.codeNameEn + ", sort=" + this.sort + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\RegionResponse$RegionResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */