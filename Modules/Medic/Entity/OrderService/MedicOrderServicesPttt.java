/*    */ package nencer.app.Modules.Medic.Entity.OrderService;
/*    */ @Entity
/*    */ @Table(name = "medic_order_services_pttt")
/*    */ public class MedicOrderServicesPttt {
/*    */   private int id;
/*    */   private Integer orderServiceId;
/*    */   private Integer ticketId;
/*    */   private String ptttInfo;
/*    */   private String ptttExt;
/*    */   private Date createdAt;
/*    */   private String createdBy;
/*    */   
/* 13 */   public static MedicOrderServicesPtttBuilder builder() { return new MedicOrderServicesPtttBuilder(); } public static class MedicOrderServicesPtttBuilder { private int id; private Integer orderServiceId; private Integer ticketId; public MedicOrderServicesPtttBuilder id(int id) { this.id = id; return this; } private String ptttInfo; private String ptttExt; private Date createdAt; private String createdBy; public MedicOrderServicesPtttBuilder orderServiceId(Integer orderServiceId) { this.orderServiceId = orderServiceId; return this; } public MedicOrderServicesPtttBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public MedicOrderServicesPtttBuilder ptttInfo(String ptttInfo) { this.ptttInfo = ptttInfo; return this; } public MedicOrderServicesPtttBuilder ptttExt(String ptttExt) { this.ptttExt = ptttExt; return this; } public MedicOrderServicesPtttBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicOrderServicesPtttBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; } public MedicOrderServicesPttt build() { return new MedicOrderServicesPttt(this.id, this.orderServiceId, this.ticketId, this.ptttInfo, this.ptttExt, this.createdAt, this.createdBy); } public String toString() { return "MedicOrderServicesPttt.MedicOrderServicesPtttBuilder(id=" + this.id + ", orderServiceId=" + this.orderServiceId + ", ticketId=" + this.ticketId + ", ptttInfo=" + this.ptttInfo + ", ptttExt=" + this.ptttExt + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ")"; } } public MedicOrderServicesPttt(int id, Integer orderServiceId, Integer ticketId, String ptttInfo, String ptttExt, Date createdAt, String createdBy) {
/* 14 */     this.id = id; this.orderServiceId = orderServiceId; this.ticketId = ticketId; this.ptttInfo = ptttInfo; this.ptttExt = ptttExt; this.createdAt = createdAt; this.createdBy = createdBy;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MedicOrderServicesPttt() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "order_service_id")
/*    */   public Integer getOrderServiceId() {
/* 40 */     return this.orderServiceId;
/*    */   }
/*    */   
/*    */   public void setOrderServiceId(Integer orderServiceId) {
/* 44 */     this.orderServiceId = orderServiceId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "ticket_id")
/*    */   public Integer getTicketId() {
/* 50 */     return this.ticketId;
/*    */   }
/*    */   
/*    */   public void setTicketId(Integer ticketId) {
/* 54 */     this.ticketId = ticketId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "pttt_info")
/*    */   public String getPtttInfo() {
/* 60 */     return this.ptttInfo;
/*    */   }
/*    */   
/*    */   public void setPtttInfo(String ptttInfo) {
/* 64 */     this.ptttInfo = ptttInfo;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "pttt_ext")
/*    */   public String getPtttExt() {
/* 70 */     return this.ptttExt;
/*    */   }
/*    */   
/*    */   public void setPtttExt(String ptttExt) {
/* 74 */     this.ptttExt = ptttExt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 80 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 84 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_by")
/*    */   public String getCreatedBy() {
/* 90 */     return this.createdBy;
/*    */   }
/*    */   
/*    */   public void setCreatedBy(String createdBy) {
/* 94 */     this.createdBy = createdBy;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\OrderService\MedicOrderServicesPttt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */