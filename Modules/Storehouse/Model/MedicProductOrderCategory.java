/*    */ package nencer.app.Modules.Storehouse.Model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import java.util.List;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicProductOrderCategory implements MedicProductOrderCategoryInterface {
/*    */   private String orderType;
/*    */   private String groupOrderType;
/*    */   private String orderTypeName;
/*    */   private Integer totalRecord;
/*    */   private List<MedicProductOrderCategory> subMedicProductOrderCategory;
/*    */   
/* 14 */   public void setOrderType(String orderType) { this.orderType = orderType; } public void setGroupOrderType(String groupOrderType) { this.groupOrderType = groupOrderType; } public void setOrderTypeName(String orderTypeName) { this.orderTypeName = orderTypeName; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public void setSubMedicProductOrderCategory(List<MedicProductOrderCategory> subMedicProductOrderCategory) { this.subMedicProductOrderCategory = subMedicProductOrderCategory; } public MedicProductOrderCategory(String orderType, String groupOrderType, String orderTypeName, Integer totalRecord, List<MedicProductOrderCategory> subMedicProductOrderCategory) {
/* 15 */     this.orderType = orderType; this.groupOrderType = groupOrderType; this.orderTypeName = orderTypeName; this.totalRecord = totalRecord; this.subMedicProductOrderCategory = subMedicProductOrderCategory;
/*    */   } public MedicProductOrderCategory() {}
/* 17 */   public static MedicProductOrderCategoryBuilder builder() { return new MedicProductOrderCategoryBuilder(); } public static class MedicProductOrderCategoryBuilder { private String orderType; private String groupOrderType; public MedicProductOrderCategoryBuilder orderType(String orderType) { this.orderType = orderType; return this; } private String orderTypeName; private Integer totalRecord; private List<MedicProductOrderCategory> subMedicProductOrderCategory; public MedicProductOrderCategoryBuilder groupOrderType(String groupOrderType) { this.groupOrderType = groupOrderType; return this; } public MedicProductOrderCategoryBuilder orderTypeName(String orderTypeName) { this.orderTypeName = orderTypeName; return this; } public MedicProductOrderCategoryBuilder totalRecord(Integer totalRecord) { this.totalRecord = totalRecord; return this; } public MedicProductOrderCategoryBuilder subMedicProductOrderCategory(List<MedicProductOrderCategory> subMedicProductOrderCategory) { this.subMedicProductOrderCategory = subMedicProductOrderCategory; return this; } public MedicProductOrderCategory build() { return new MedicProductOrderCategory(this.orderType, this.groupOrderType, this.orderTypeName, this.totalRecord, this.subMedicProductOrderCategory); } public String toString() { return "MedicProductOrderCategory.MedicProductOrderCategoryBuilder(orderType=" + this.orderType + ", groupOrderType=" + this.groupOrderType + ", orderTypeName=" + this.orderTypeName + ", totalRecord=" + this.totalRecord + ", subMedicProductOrderCategory=" + this.subMedicProductOrderCategory + ")"; }
/*    */      }
/* 19 */   public String getOrderType() { return this.orderType; }
/* 20 */   public String getGroupOrderType() { return this.groupOrderType; }
/* 21 */   public String getOrderTypeName() { return this.orderTypeName; } public Integer getTotalRecord() {
/* 22 */     return this.totalRecord;
/*    */   } public List<MedicProductOrderCategory> getSubMedicProductOrderCategory() {
/* 24 */     return this.subMedicProductOrderCategory;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Model\MedicProductOrderCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */