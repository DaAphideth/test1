/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ public class LanguageTransRequest {
/*    */   private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private String langCode;
/*    */   private String langKey;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String filename; private String key; private String content; private String type; public void setLangCode(String langCode) { this.langCode = langCode; } public void setLangKey(String langKey) { this.langKey = langKey; } public void setFilename(String filename) { this.filename = filename; } public void setKey(String key) { this.key = key; } public void setContent(String content) { this.content = content; } public void setType(String type) { this.type = type; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LanguageTransRequest)) return false;  LanguageTransRequest other = (LanguageTransRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$langCode = getLangCode(), other$langCode = other.getLangCode(); if ((this$langCode == null) ? (other$langCode != null) : !this$langCode.equals(other$langCode)) return false;  Object this$langKey = getLangKey(), other$langKey = other.getLangKey(); if ((this$langKey == null) ? (other$langKey != null) : !this$langKey.equals(other$langKey)) return false;  Object this$filename = getFilename(), other$filename = other.getFilename(); if ((this$filename == null) ? (other$filename != null) : !this$filename.equals(other$filename)) return false;  Object this$key = getKey(), other$key = other.getKey(); if ((this$key == null) ? (other$key != null) : !this$key.equals(other$key)) return false;  Object this$content = getContent(), other$content = other.getContent(); if ((this$content == null) ? (other$content != null) : !this$content.equals(other$content)) return false;  Object this$type = getType(), other$type = other.getType(); return !((this$type == null) ? (other$type != null) : !this$type.equals(other$type)); } protected boolean canEqual(Object other) { return other instanceof LanguageTransRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $langCode = getLangCode(); result = result * 59 + (($langCode == null) ? 43 : $langCode.hashCode()); Object $langKey = getLangKey(); result = result * 59 + (($langKey == null) ? 43 : $langKey.hashCode()); Object $filename = getFilename(); result = result * 59 + (($filename == null) ? 43 : $filename.hashCode()); Object $key = getKey(); result = result * 59 + (($key == null) ? 43 : $key.hashCode()); Object $content = getContent(); result = result * 59 + (($content == null) ? 43 : $content.hashCode()); Object $type = getType(); return result * 59 + (($type == null) ? 43 : $type.hashCode()); } public String toString() { return "LanguageTransRequest(id=" + getId() + ", langCode=" + getLangCode() + ", langKey=" + getLangKey() + ", filename=" + getFilename() + ", key=" + getKey() + ", content=" + getContent() + ", type=" + getType() + ")"; }
/*    */    public LanguageTransRequest() {} public LanguageTransRequest(Integer id, String langCode, String langKey, String filename, String key, String content, String type) {
/* 11 */     this.id = id; this.langCode = langCode; this.langKey = langKey; this.filename = filename; this.key = key; this.content = content; this.type = type;
/*    */   } public Integer getId() {
/* 13 */     return this.id;
/*    */   }
/* 15 */   public String getLangCode() { return this.langCode; }
/* 16 */   public String getLangKey() { return this.langKey; }
/* 17 */   public String getFilename() { return this.filename; }
/* 18 */   public String getKey() { return this.key; }
/* 19 */   public String getContent() { return this.content; } public String getType() {
/* 20 */     return this.type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\LanguageTransRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */