/*    */ package nencer.app.Modules.Storehouse.Entity;
/*    */ @Entity
/*    */ @Table(name = "medic_order_inven_export")
/*    */ public class MedicOrderInvenExport {
/*    */   private Integer invenOrderId;
/*    */   private Integer invenId;
/*    */   private Integer orderDetailId;
/*    */   private Integer qty;
/*    */   private String status;
/*    */   
/* 11 */   public static MedicOrderInvenExportBuilder builder() { return new MedicOrderInvenExportBuilder(); } public static class MedicOrderInvenExportBuilder { private Integer invenOrderId; private Integer invenId; public MedicOrderInvenExportBuilder invenOrderId(Integer invenOrderId) { this.invenOrderId = invenOrderId; return this; } private Integer orderDetailId; private Integer qty; private String status; public MedicOrderInvenExportBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } public MedicOrderInvenExportBuilder orderDetailId(Integer orderDetailId) { this.orderDetailId = orderDetailId; return this; } public MedicOrderInvenExportBuilder qty(Integer qty) { this.qty = qty; return this; } public MedicOrderInvenExportBuilder status(String status) { this.status = status; return this; } public MedicOrderInvenExport build() { return new MedicOrderInvenExport(this.invenOrderId, this.invenId, this.orderDetailId, this.qty, this.status); } public String toString() { return "MedicOrderInvenExport.MedicOrderInvenExportBuilder(invenOrderId=" + this.invenOrderId + ", invenId=" + this.invenId + ", orderDetailId=" + this.orderDetailId + ", qty=" + this.qty + ", status=" + this.status + ")"; } } public MedicOrderInvenExport(Integer invenOrderId, Integer invenId, Integer orderDetailId, Integer qty, String status) {
/* 12 */     this.invenOrderId = invenOrderId; this.invenId = invenId; this.orderDetailId = orderDetailId; this.qty = qty; this.status = status;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MedicOrderInvenExport() {}
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "inven_order_id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public Integer getInvenOrderId() {
/* 25 */     return this.invenOrderId;
/*    */   }
/*    */   
/*    */   public void setInvenOrderId(Integer invenOrderId) {
/* 29 */     this.invenOrderId = invenOrderId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "inven_id")
/*    */   public Integer getInvenId() {
/* 35 */     return this.invenId;
/*    */   }
/*    */   
/*    */   public void setInvenId(Integer invenId) {
/* 39 */     this.invenId = invenId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "order_detail_id")
/*    */   public Integer getOrderDetailId() {
/* 45 */     return this.orderDetailId;
/*    */   }
/*    */   
/*    */   public void setOrderDetailId(Integer orderDetailId) {
/* 49 */     this.orderDetailId = orderDetailId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "qty")
/*    */   public Integer getQty() {
/* 55 */     return this.qty;
/*    */   }
/*    */   
/*    */   public void setQty(Integer qty) {
/* 59 */     this.qty = qty;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "status")
/*    */   public String getStatus() {
/* 65 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 69 */     this.status = status;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Entity\MedicOrderInvenExport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */