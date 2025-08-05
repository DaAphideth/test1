/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class LanguageTransResponseBuilder {
/*    */   private Integer id;
/*    */   private String langCode;
/*    */   private String langKey;
/*    */   private String filename;
/*    */   private String key;
/*    */   
/*    */   public LanguageTransResponseBuilder id(Integer id) {
/* 13 */     this.id = id; return this; } private String content; private String type; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public LanguageTransResponseBuilder langCode(String langCode) { this.langCode = langCode; return this; } public LanguageTransResponseBuilder langKey(String langKey) { this.langKey = langKey; return this; } public LanguageTransResponseBuilder filename(String filename) { this.filename = filename; return this; } public LanguageTransResponseBuilder key(String key) { this.key = key; return this; } public LanguageTransResponseBuilder content(String content) { this.content = content; return this; } public LanguageTransResponseBuilder type(String type) { this.type = type; return this; } public LanguageTransResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public LanguageTransResponseBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public LanguageTransResponseBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public LanguageTransResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public LanguageTransResponse build() { return new LanguageTransResponse(this.id, this.langCode, this.langKey, this.filename, this.key, this.content, this.type, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "LanguageTransResponse.LanguageTransResponseBuilder(id=" + this.id + ", langCode=" + this.langCode + ", langKey=" + this.langKey + ", filename=" + this.filename + ", key=" + this.key + ", content=" + this.content + ", type=" + this.type + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\LanguageTransResponse$LanguageTransResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */