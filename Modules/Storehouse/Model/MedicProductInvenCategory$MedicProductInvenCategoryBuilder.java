/*    */ package nencer.app.Modules.Storehouse.Model;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedicProductInvenCategoryBuilder
/*    */ {
/*    */   private String type;
/*    */   private String typeName;
/*    */   private Integer storehouseId;
/*    */   private Integer totalRecord;
/*    */   
/*    */   public MedicProductInvenCategoryBuilder type(String type) {
/* 13 */     this.type = type; return this; } public MedicProductInvenCategoryBuilder typeName(String typeName) { this.typeName = typeName; return this; } public MedicProductInvenCategoryBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicProductInvenCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public MedicProductInvenCategory build() { return new MedicProductInvenCategory(this.type, this.typeName, this.storehouseId, this.totalRecord); } public String toString() { return "MedicProductInvenCategory.MedicProductInvenCategoryBuilder(type=" + this.type + ", typeName=" + this.typeName + ", storehouseId=" + this.storehouseId + ", totalRecord=" + this.totalRecord + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Model\MedicProductInvenCategory$MedicProductInvenCategoryBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */