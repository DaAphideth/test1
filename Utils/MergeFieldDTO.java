/*     */ package nencer.app.Utils;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeFieldDTO
/*     */ {
/*     */   private String code;
/*     */   private Boolean isGroup;
/*     */   private Boolean isMultiple;
/*     */   private String startGroup;
/*     */   private String endGroup;
/*     */   private String value;
/*     */   private String mergeField;
/*  23 */   List<MergeFieldDTO> children = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCode() {
/*  28 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  32 */     this.code = code;
/*     */   }
/*     */   
/*     */   public Boolean getIsGroup() {
/*  36 */     return this.isGroup;
/*     */   }
/*     */   
/*     */   public void setIsGroup(Boolean isGroup) {
/*  40 */     this.isGroup = isGroup;
/*     */   }
/*     */   
/*     */   public Boolean getIsMultiple() {
/*  44 */     return this.isMultiple;
/*     */   }
/*     */   
/*     */   public void setIsMultiple(Boolean isMultiple) {
/*  48 */     this.isMultiple = isMultiple;
/*     */   }
/*     */   
/*     */   public String getStartGroup() {
/*  52 */     return this.startGroup;
/*     */   }
/*     */   
/*     */   public void setStartGroup(String startGroup) {
/*  56 */     this.startGroup = startGroup;
/*     */   }
/*     */   
/*     */   public String getEndGroup() {
/*  60 */     return this.endGroup;
/*     */   }
/*     */   
/*     */   public void setEndGroup(String endGroup) {
/*  64 */     this.endGroup = endGroup;
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  68 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(String value) {
/*  72 */     this.value = value;
/*     */   }
/*     */   
/*     */   public String getMergeField() {
/*  76 */     return this.mergeField;
/*     */   }
/*     */   
/*     */   public void setMergeField(String mergeField) {
/*  80 */     this.mergeField = mergeField;
/*     */   }
/*     */   
/*     */   public List<MergeFieldDTO> getChildren() {
/*  84 */     return this.children;
/*     */   }
/*     */   
/*     */   public void setChildren(List<MergeFieldDTO> children) {
/*  88 */     this.children = children;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  93 */     if (this == o) return true; 
/*  94 */     if (!(o instanceof MergeFieldDTO)) return false; 
/*  95 */     MergeFieldDTO dto = (MergeFieldDTO)o;
/*  96 */     return (Objects.equals(this.code, dto.code) && 
/*  97 */       Objects.equals(this.isGroup, dto.isGroup) && 
/*  98 */       Objects.equals(this.isMultiple, dto.isMultiple) && 
/*  99 */       Objects.equals(this.startGroup, dto.startGroup) && 
/* 100 */       Objects.equals(this.endGroup, dto.endGroup) && 
/* 101 */       Objects.equals(this.value, dto.value) && 
/* 102 */       Objects.equals(this.mergeField, dto.mergeField) && 
/* 103 */       Objects.equals(this.children, dto.children));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 108 */     return Objects.hash(new Object[] { this.code, this.isGroup, this.isMultiple, this.startGroup, this.endGroup, this.value, this.mergeField, this.children });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\MergeFieldDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */