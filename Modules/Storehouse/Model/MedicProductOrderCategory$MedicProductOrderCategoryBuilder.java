/*    */ package nencer.app.Modules.Storehouse.Model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedicProductOrderCategoryBuilder
/*    */ {
/*    */   private String orderType;
/*    */   private String groupOrderType;
/*    */   private String orderTypeName;
/*    */   private Integer totalRecord;
/*    */   private List<MedicProductOrderCategory> subMedicProductOrderCategory;
/*    */   
/*    */   public MedicProductOrderCategoryBuilder orderType(String orderType) {
/* 17 */     this.orderType = orderType; return this; } public MedicProductOrderCategoryBuilder groupOrderType(String groupOrderType) { this.groupOrderType = groupOrderType; return this; } public MedicProductOrderCategoryBuilder orderTypeName(String orderTypeName) { this.orderTypeName = orderTypeName; return this; } public MedicProductOrderCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public MedicProductOrderCategoryBuilder subMedicProductOrderCategory(List<MedicProductOrderCategory> subMedicProductOrderCategory) { this.subMedicProductOrderCategory = subMedicProductOrderCategory; return this; } public MedicProductOrderCategory build() { return new MedicProductOrderCategory(this.orderType, this.groupOrderType, this.orderTypeName, this.totalRecord, this.subMedicProductOrderCategory); } public String toString() { return "MedicProductOrderCategory.MedicProductOrderCategoryBuilder(orderType=" + this.orderType + ", groupOrderType=" + this.groupOrderType + ", orderTypeName=" + this.orderTypeName + ", totalRecord=" + this.totalRecord + ", subMedicProductOrderCategory=" + this.subMedicProductOrderCategory + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Model\MedicProductOrderCategory$MedicProductOrderCategoryBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */