/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Set;
/*    */ import nencer.app.Modules.Auth.Model.UserResponseInfo;
/*    */ 
/*    */ public class MedicTicketTotalBuilder {
/*    */   private Set<Integer> medicTickets;
/*    */   private UserResponseInfo user;
/*    */   private Integer roomId;
/*    */   private Date orderDateTo;
/*    */   private Date orderDateFrom;
/*    */   private String orderType;
/*    */   private Integer departmentId;
/*    */   private Integer chamberId;
/*    */   private Integer storehouseId;
/*    */   private Integer storehouseFromId;
/*    */   
/* 19 */   public MedicTicketTotalBuilder medicTickets(Set<Integer> medicTickets) { this.medicTickets = medicTickets; return this; } public MedicTicketTotalBuilder user(UserResponseInfo user) { this.user = user; return this; } public MedicTicketTotalBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicTicketTotalBuilder orderDateTo(Date orderDateTo) { this.orderDateTo = orderDateTo; return this; } public MedicTicketTotalBuilder orderDateFrom(Date orderDateFrom) { this.orderDateFrom = orderDateFrom; return this; } public MedicTicketTotalBuilder orderType(String orderType) { this.orderType = orderType; return this; } public MedicTicketTotalBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicTicketTotalBuilder chamberId(Integer chamberId) { this.chamberId = chamberId; return this; } public MedicTicketTotalBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicTicketTotalBuilder storehouseFromId(Integer storehouseFromId) { this.storehouseFromId = storehouseFromId; return this; } public MedicTicketTotal build() { return new MedicTicketTotal(this.medicTickets, this.user, this.roomId, this.orderDateTo, this.orderDateFrom, this.orderType, this.departmentId, this.chamberId, this.storehouseId, this.storehouseFromId); } public String toString() { return "MedicTicketTotal.MedicTicketTotalBuilder(medicTickets=" + this.medicTickets + ", user=" + this.user + ", roomId=" + this.roomId + ", orderDateTo=" + this.orderDateTo + ", orderDateFrom=" + this.orderDateFrom + ", orderType=" + this.orderType + ", departmentId=" + this.departmentId + ", chamberId=" + this.chamberId + ", storehouseId=" + this.storehouseId + ", storehouseFromId=" + this.storehouseFromId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicTicketTotal$MedicTicketTotalBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */