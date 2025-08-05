/*    */ package nencer.app.Modules.Storehouse.Model;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicProductInvenCategory {
/*    */   private String type;
/*    */   private String typeName;
/*    */   private Integer storehouseId;
/*    */   private Integer totalRecord;
/*    */   
/* 10 */   public void setType(String type) { this.type = type; } public void setTypeName(String typeName) { this.typeName = typeName; } public void setStorehouseId(Integer storehouseId) { this.storehouseId = storehouseId; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public MedicProductInvenCategory(String type, String typeName, Integer storehouseId, Integer totalRecord) {
/* 11 */     this.type = type; this.typeName = typeName; this.storehouseId = storehouseId; this.totalRecord = totalRecord;
/*    */   } public MedicProductInvenCategory() {}
/* 13 */   public static MedicProductInvenCategoryBuilder builder() { return new MedicProductInvenCategoryBuilder(); } public static class MedicProductInvenCategoryBuilder { private String type; private String typeName; public MedicProductInvenCategoryBuilder type(String type) { this.type = type; return this; } private Integer storehouseId; private Integer totalRecord; public MedicProductInvenCategoryBuilder typeName(String typeName) { this.typeName = typeName; return this; } public MedicProductInvenCategoryBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicProductInvenCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public MedicProductInvenCategory build() { return new MedicProductInvenCategory(this.type, this.typeName, this.storehouseId, this.totalRecord); } public String toString() { return "MedicProductInvenCategory.MedicProductInvenCategoryBuilder(type=" + this.type + ", typeName=" + this.typeName + ", storehouseId=" + this.storehouseId + ", totalRecord=" + this.totalRecord + ")"; }
/*    */      }
/* 15 */   public String getType() { return this.type; }
/* 16 */   public String getTypeName() { return this.typeName; }
/* 17 */   public Integer getStorehouseId() { return this.storehouseId; } public Integer getTotalRecord() {
/* 18 */     return this.totalRecord;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Model\MedicProductInvenCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */