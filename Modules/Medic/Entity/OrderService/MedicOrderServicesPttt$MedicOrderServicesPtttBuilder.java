/*    */ package nencer.app.Modules.Medic.Entity.OrderService;
/*    */ 
/*    */ 
/*    */ public class MedicOrderServicesPtttBuilder {
/*    */   private int id;
/*    */   private Integer orderServiceId;
/*    */   private Integer ticketId;
/*    */   private String ptttInfo;
/*    */   private String ptttExt;
/*    */   private Date createdAt;
/*    */   private String createdBy;
/*    */   
/* 13 */   public MedicOrderServicesPtttBuilder id(int id) { this.id = id; return this; } public MedicOrderServicesPtttBuilder orderServiceId(Integer orderServiceId) { this.orderServiceId = orderServiceId; return this; } public MedicOrderServicesPtttBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicOrderServicesPtttBuilder ptttInfo(String ptttInfo) { this.ptttInfo = ptttInfo; return this; } public MedicOrderServicesPtttBuilder ptttExt(String ptttExt) { this.ptttExt = ptttExt; return this; } public MedicOrderServicesPtttBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicOrderServicesPtttBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicOrderServicesPttt build() { return new MedicOrderServicesPttt(this.id, this.orderServiceId, this.ticketId, this.ptttInfo, this.ptttExt, this.createdAt, this.createdBy); } public String toString() { return "MedicOrderServicesPttt.MedicOrderServicesPtttBuilder(id=" + this.id + ", orderServiceId=" + this.orderServiceId + ", ticketId=" + this.ticketId + ", ptttInfo=" + this.ptttInfo + ", ptttExt=" + this.ptttExt + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderService\MedicOrderServicesPttt$MedicOrderServicesPtttBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */