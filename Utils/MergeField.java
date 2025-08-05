/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MergeField
/*    */ {
/*    */   private Integer index;
/*    */   private String name;
/*    */   private String fullName;
/*    */   private String value;
/*    */   
/*    */   public Integer getIndex() {
/* 17 */     return this.index;
/*    */   }
/*    */   
/*    */   public void setIndex(Integer index) {
/* 21 */     this.index = index;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 25 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 29 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getFullName() {
/* 33 */     return this.fullName;
/*    */   }
/*    */   
/*    */   public void setFullName(String fullName) {
/* 37 */     this.fullName = fullName;
/*    */   }
/*    */   
/*    */   public Integer getLengthFullName() {
/* 41 */     return Integer.valueOf(this.fullName.length());
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 49 */     this.value = value;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 54 */     if (this == o) return true; 
/* 55 */     if (!(o instanceof MergeField)) return false; 
/* 56 */     MergeField that = (MergeField)o;
/* 57 */     return (Objects.equals(this.index, that.index) && 
/* 58 */       Objects.equals(this.name, that.name) && 
/* 59 */       Objects.equals(this.fullName, that.fullName) && 
/* 60 */       Objects.equals(this.value, that.value));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     return Objects.hash(new Object[] { this.index, this.name, this.fullName, this.value });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\MergeField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */