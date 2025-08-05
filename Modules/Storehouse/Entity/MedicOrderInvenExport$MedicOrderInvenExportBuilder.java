/*    */ package nencer.app.Modules.Storehouse.Entity;
/*    */ 
/*    */ public class MedicOrderInvenExportBuilder {
/*    */   private Integer invenOrderId;
/*    */   private Integer invenId;
/*    */   private Integer orderDetailId;
/*    */   private Integer qty;
/*    */   private String status;
/*    */   
/*    */   public MedicOrderInvenExportBuilder invenOrderId(Integer invenOrderId) {
/* 11 */     this.invenOrderId = invenOrderId; return this; } public MedicOrderInvenExportBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } public MedicOrderInvenExportBuilder orderDetailId(Integer orderDetailId) { this.orderDetailId = orderDetailId; return this; } public MedicOrderInvenExportBuilder qty(Integer qty) { this.qty = qty; return this; } public MedicOrderInvenExportBuilder status(String status) { this.status = status; return this; } public MedicOrderInvenExport build() { return new MedicOrderInvenExport(this.invenOrderId, this.invenId, this.orderDetailId, this.qty, this.status); } public String toString() { return "MedicOrderInvenExport.MedicOrderInvenExportBuilder(invenOrderId=" + this.invenOrderId + ", invenId=" + this.invenId + ", orderDetailId=" + this.orderDetailId + ", qty=" + this.qty + ", status=" + this.status + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicOrderInvenExport$MedicOrderInvenExportBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */