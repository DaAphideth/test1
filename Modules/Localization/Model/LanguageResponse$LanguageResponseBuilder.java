/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ 
/*    */ public class LanguageResponseBuilder {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   private String flag;
/*    */   private String hreflang;
/*    */   private String charset;
/*    */   private int isDefault;
/*    */   
/* 13 */   public LanguageResponseBuilder id(Integer id) { this.id = id; return this; } private int status; private int installed; private int sort; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public LanguageResponseBuilder name(String name) { this.name = name; return this; } public LanguageResponseBuilder code(String code) { this.code = code; return this; } public LanguageResponseBuilder flag(String flag) { this.flag = flag; return this; } public LanguageResponseBuilder hreflang(String hreflang) { this.hreflang = hreflang; return this; } public LanguageResponseBuilder charset(String charset) { this.charset = charset; return this; } public LanguageResponseBuilder isDefault(int isDefault) { this.isDefault = isDefault; return this; } public LanguageResponseBuilder status(int status) { this.status = status; return this; } public LanguageResponseBuilder installed(int installed) { this.installed = installed; return this; } public LanguageResponseBuilder sort(int sort) { this.sort = sort; return this; } public LanguageResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LanguageResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LanguageResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public LanguageResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public LanguageResponse build() { return new LanguageResponse(this.id, this.name, this.code, this.flag, this.hreflang, this.charset, this.isDefault, this.status, this.installed, this.sort, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "LanguageResponse.LanguageResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", flag=" + this.flag + ", hreflang=" + this.hreflang + ", charset=" + this.charset + ", isDefault=" + this.isDefault + ", status=" + this.status + ", installed=" + this.installed + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\LanguageResponse$LanguageResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */