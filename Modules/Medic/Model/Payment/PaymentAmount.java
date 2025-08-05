/*    */ package nencer.app.Modules.Medic.Model.Payment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PaymentAmount
/*    */ {
/*    */   private Integer checkinId;
/*    */   private Double totalAmount;
/*    */   private Double totalAmountPaid;
/*    */   private Double totalAmountOwed;
/*    */   private Double totalBHYTPaidAmount;
/*    */   
/*    */   public void setCheckinId(Integer checkinId) {
/* 17 */     this.checkinId = checkinId; } public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; } public void setTotalAmountPaid(Double totalAmountPaid) { this.totalAmountPaid = totalAmountPaid; } public void setTotalAmountOwed(Double totalAmountOwed) { this.totalAmountOwed = totalAmountOwed; } public void setTotalBHYTPaidAmount(Double totalBHYTPaidAmount) { this.totalBHYTPaidAmount = totalBHYTPaidAmount; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PaymentAmount)) return false;  PaymentAmount other = (PaymentAmount)o; if (!other.canEqual(this)) return false;  Object this$checkinId = getCheckinId(), other$checkinId = other.getCheckinId(); if ((this$checkinId == null) ? (other$checkinId != null) : !this$checkinId.equals(other$checkinId)) return false;  Object this$totalAmount = getTotalAmount(), other$totalAmount = other.getTotalAmount(); if ((this$totalAmount == null) ? (other$totalAmount != null) : !this$totalAmount.equals(other$totalAmount)) return false;  Object this$totalAmountPaid = getTotalAmountPaid(), other$totalAmountPaid = other.getTotalAmountPaid(); if ((this$totalAmountPaid == null) ? (other$totalAmountPaid != null) : !this$totalAmountPaid.equals(other$totalAmountPaid)) return false;  Object this$totalAmountOwed = getTotalAmountOwed(), other$totalAmountOwed = other.getTotalAmountOwed(); if ((this$totalAmountOwed == null) ? (other$totalAmountOwed != null) : !this$totalAmountOwed.equals(other$totalAmountOwed)) return false;  Object this$totalBHYTPaidAmount = getTotalBHYTPaidAmount(), other$totalBHYTPaidAmount = other.getTotalBHYTPaidAmount(); return !((this$totalBHYTPaidAmount == null) ? (other$totalBHYTPaidAmount != null) : !this$totalBHYTPaidAmount.equals(other$totalBHYTPaidAmount)); } protected boolean canEqual(Object other) { return other instanceof PaymentAmount; } public int hashCode() { int PRIME = 59; result = 1; Object $checkinId = getCheckinId(); result = result * 59 + (($checkinId == null) ? 43 : $checkinId.hashCode()); Object $totalAmount = getTotalAmount(); result = result * 59 + (($totalAmount == null) ? 43 : $totalAmount.hashCode()); Object $totalAmountPaid = getTotalAmountPaid(); result = result * 59 + (($totalAmountPaid == null) ? 43 : $totalAmountPaid.hashCode()); Object $totalAmountOwed = getTotalAmountOwed(); result = result * 59 + (($totalAmountOwed == null) ? 43 : $totalAmountOwed.hashCode()); Object $totalBHYTPaidAmount = getTotalBHYTPaidAmount(); return result * 59 + (($totalBHYTPaidAmount == null) ? 43 : $totalBHYTPaidAmount.hashCode()); } public String toString() { return "PaymentAmount(checkinId=" + getCheckinId() + ", totalAmount=" + getTotalAmount() + ", totalAmountPaid=" + getTotalAmountPaid() + ", totalAmountOwed=" + getTotalAmountOwed() + ", totalBHYTPaidAmount=" + getTotalBHYTPaidAmount() + ")"; }
/* 18 */   public static PaymentAmountBuilder builder() { return new PaymentAmountBuilder(); } public static class PaymentAmountBuilder { private Integer checkinId; private Double totalAmount; public PaymentAmountBuilder checkinId(Integer checkinId) { this.checkinId = checkinId; return this; } private Double totalAmountPaid; private Double totalAmountOwed; private Double totalBHYTPaidAmount; public PaymentAmountBuilder totalAmount(Double totalAmount) { this.totalAmount = totalAmount; return this; } public PaymentAmountBuilder totalAmountPaid(Double totalAmountPaid) { this.totalAmountPaid = totalAmountPaid; return this; } public PaymentAmountBuilder totalAmountOwed(Double totalAmountOwed) { this.totalAmountOwed = totalAmountOwed; return this; } public PaymentAmountBuilder totalBHYTPaidAmount(Double totalBHYTPaidAmount) { this.totalBHYTPaidAmount = totalBHYTPaidAmount; return this; } public PaymentAmount build() { return new PaymentAmount(this.checkinId, this.totalAmount, this.totalAmountPaid, this.totalAmountOwed, this.totalBHYTPaidAmount); } public String toString() { return "PaymentAmount.PaymentAmountBuilder(checkinId=" + this.checkinId + ", totalAmount=" + this.totalAmount + ", totalAmountPaid=" + this.totalAmountPaid + ", totalAmountOwed=" + this.totalAmountOwed + ", totalBHYTPaidAmount=" + this.totalBHYTPaidAmount + ")"; } } public PaymentAmount(Integer checkinId, Double totalAmount, Double totalAmountPaid, Double totalAmountOwed, Double totalBHYTPaidAmount) {
/* 19 */     this.checkinId = checkinId; this.totalAmount = totalAmount; this.totalAmountPaid = totalAmountPaid; this.totalAmountOwed = totalAmountOwed; this.totalBHYTPaidAmount = totalBHYTPaidAmount;
/*    */   }
/*    */   public PaymentAmount() {}
/* 22 */   public Integer getCheckinId() { return this.checkinId; }
/* 23 */   public Double getTotalAmount() { return this.totalAmount; }
/* 24 */   public Double getTotalAmountPaid() { return this.totalAmountPaid; }
/* 25 */   public Double getTotalAmountOwed() { return this.totalAmountOwed; } public Double getTotalBHYTPaidAmount() {
/* 26 */     return this.totalBHYTPaidAmount;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Payment\PaymentAmount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */