/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "languages_trans")
/*     */ public class LanguagesTrans
/*     */ {
/*     */   private int id;
/*     */   private String langCode;
/*     */   private String langKey;
/*     */   private String filename;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  23 */     return this.id;
/*     */   }
/*     */   private String key; private String content; private String type; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  27 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lang_code")
/*     */   public String getLangCode() {
/*  33 */     return this.langCode;
/*     */   }
/*     */   
/*     */   public void setLangCode(String langCode) {
/*  37 */     this.langCode = langCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lang_key")
/*     */   public String getLangKey() {
/*  43 */     return this.langKey;
/*     */   }
/*     */   
/*     */   public void setLangKey(String langKey) {
/*  47 */     this.langKey = langKey;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "filename")
/*     */   public String getFilename() {
/*  53 */     return this.filename;
/*     */   }
/*     */   
/*     */   public void setFilename(String filename) {
/*  57 */     this.filename = filename;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "key")
/*     */   public String getKey() {
/*  63 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/*  67 */     this.key = key;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "content")
/*     */   public String getContent() {
/*  73 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/*  77 */     this.content = content;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/*  83 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  87 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  93 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  97 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 103 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 107 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 112 */     if (this == o) return true; 
/* 113 */     if (o == null || getClass() != o.getClass()) return false; 
/* 114 */     LanguagesTrans that = (LanguagesTrans)o;
/* 115 */     return (this.id == that.id && Objects.equals(this.langCode, that.langCode) && Objects.equals(this.langKey, that.langKey) && Objects.equals(this.filename, that.filename) && Objects.equals(this.key, that.key) && Objects.equals(this.content, that.content) && Objects.equals(this.type, that.type) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.langCode, this.langKey, this.filename, this.key, this.content, this.type, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\LanguagesTrans.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */