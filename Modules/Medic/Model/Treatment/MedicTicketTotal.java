/*    */ package nencer.app.Modules.Medic.Model.Treatment;@JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicTicketTotal { @NotNull(message = "804")
/*    */   @Size(min = 1, message = "803")
/*    */   private Set<Integer> medicTickets; @NotNull(message = "804")
/*    */   private UserResponseInfo user;
/*    */   private Integer roomId;
/*    */   private Date orderDateTo;
/*    */   private Date orderDateFrom;
/*    */   private String orderType;
/*    */   private Integer departmentId;
/*    */   private Integer chamberId;
/*    */   @NotNull(message = "804")
/*    */   private Integer storehouseId;
/*    */   private Integer storehouseFromId;
/*    */   
/* 16 */   public void setMedicTickets(Set<Integer> medicTickets) { this.medicTickets = medicTickets; } public void setUser(UserResponseInfo user) { this.user = user; } public void setRoomId(Integer roomId) { this.roomId = roomId; } public void setOrderDateTo(Date orderDateTo) { this.orderDateTo = orderDateTo; } public void setOrderDateFrom(Date orderDateFrom) { this.orderDateFrom = orderDateFrom; } public void setOrderType(String orderType) { this.orderType = orderType; } public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; } public void setChamberId(Integer chamberId) { this.chamberId = chamberId; } public void setStorehouseId(Integer storehouseId) { this.storehouseId = storehouseId; } public void setStorehouseFromId(Integer storehouseFromId) { this.storehouseFromId = storehouseFromId; } public MedicTicketTotal(Set<Integer> medicTickets, UserResponseInfo user, Integer roomId, Date orderDateTo, Date orderDateFrom, String orderType, Integer departmentId, Integer chamberId, Integer storehouseId, Integer storehouseFromId) {
/* 17 */     this.medicTickets = medicTickets; this.user = user; this.roomId = roomId; this.orderDateTo = orderDateTo; this.orderDateFrom = orderDateFrom; this.orderType = orderType; this.departmentId = departmentId; this.chamberId = chamberId; this.storehouseId = storehouseId; this.storehouseFromId = storehouseFromId;
/*    */   } public MedicTicketTotal() {}
/* 19 */   public static MedicTicketTotalBuilder builder() { return new MedicTicketTotalBuilder(); } public static class MedicTicketTotalBuilder { private Set<Integer> medicTickets; private UserResponseInfo user; private Integer roomId; private Date orderDateTo; private Date orderDateFrom; public MedicTicketTotalBuilder medicTickets(Set<Integer> medicTickets) { this.medicTickets = medicTickets; return this; } private String orderType; private Integer departmentId; private Integer chamberId; private Integer storehouseId; private Integer storehouseFromId; public MedicTicketTotalBuilder user(UserResponseInfo user) { this.user = user; return this; } public MedicTicketTotalBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicTicketTotalBuilder orderDateTo(Date orderDateTo) { this.orderDateTo = orderDateTo; return this; } public MedicTicketTotalBuilder orderDateFrom(Date orderDateFrom) { this.orderDateFrom = orderDateFrom; return this; } public MedicTicketTotalBuilder orderType(String orderType) { this.orderType = orderType; return this; } public MedicTicketTotalBuilder departmentId(Integer departmentId) { this.departmentId = departmentId; return this; } public MedicTicketTotalBuilder chamberId(Integer chamberId) { this.chamberId = chamberId; return this; } public MedicTicketTotalBuilder storehouseId(Integer storehouseId) { this.storehouseId = storehouseId; return this; } public MedicTicketTotalBuilder storehouseFromId(Integer storehouseFromId) { this.storehouseFromId = storehouseFromId; return this; } public MedicTicketTotal build() { return new MedicTicketTotal(this.medicTickets, this.user, this.roomId, this.orderDateTo, this.orderDateFrom, this.orderType, this.departmentId, this.chamberId, this.storehouseId, this.storehouseFromId); } public String toString() { return "MedicTicketTotal.MedicTicketTotalBuilder(medicTickets=" + this.medicTickets + ", user=" + this.user + ", roomId=" + this.roomId + ", orderDateTo=" + this.orderDateTo + ", orderDateFrom=" + this.orderDateFrom + ", orderType=" + this.orderType + ", departmentId=" + this.departmentId + ", chamberId=" + this.chamberId + ", storehouseId=" + this.storehouseId + ", storehouseFromId=" + this.storehouseFromId + ")"; }
/*    */      }
/*    */   
/*    */   public Set<Integer> getMedicTickets() {
/* 23 */     return this.medicTickets;
/*    */   }
/* 25 */   public UserResponseInfo getUser() { return this.user; }
/* 26 */   public Integer getRoomId() { return this.roomId; }
/* 27 */   public Date getOrderDateTo() { return this.orderDateTo; }
/* 28 */   public Date getOrderDateFrom() { return this.orderDateFrom; } public String getOrderType() {
/* 29 */     return this.orderType;
/*    */   }
/* 31 */   public Integer getDepartmentId() { return this.departmentId; } public Integer getChamberId() {
/* 32 */     return this.chamberId;
/*    */   } public Integer getStorehouseId() {
/* 34 */     return this.storehouseId;
/*    */   } public Integer getStorehouseFromId() {
/* 36 */     return this.storehouseFromId;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\MedicTicketTotal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */