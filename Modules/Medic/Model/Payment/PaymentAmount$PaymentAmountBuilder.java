/*    */ package nencer.app.Modules.Medic.Model.Payment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PaymentAmountBuilder
/*    */ {
/*    */   private Integer checkinId;
/*    */   private Double totalAmount;
/*    */   private Double totalAmountPaid;
/*    */   private Double totalAmountOwed;
/*    */   private Double totalBHYTPaidAmount;
/*    */   
/*    */   public PaymentAmountBuilder checkinId(Integer checkinId) {
/* 18 */     this.checkinId = checkinId; return this; } public PaymentAmountBuilder totalAmount(Double totalAmount) { this.totalAmount = totalAmount; return this; } public PaymentAmountBuilder totalAmountPaid(Double totalAmountPaid) { this.totalAmountPaid = totalAmountPaid; return this; } public PaymentAmountBuilder totalAmountOwed(Double totalAmountOwed) { this.totalAmountOwed = totalAmountOwed; return this; } public PaymentAmountBuilder totalBHYTPaidAmount(Double totalBHYTPaidAmount) { this.totalBHYTPaidAmount = totalBHYTPaidAmount; return this; } public PaymentAmount build() { return new PaymentAmount(this.checkinId, this.totalAmount, this.totalAmountPaid, this.totalAmountOwed, this.totalBHYTPaidAmount); } public String toString() { return "PaymentAmount.PaymentAmountBuilder(checkinId=" + this.checkinId + ", totalAmount=" + this.totalAmount + ", totalAmountPaid=" + this.totalAmountPaid + ", totalAmountOwed=" + this.totalAmountOwed + ", totalBHYTPaidAmount=" + this.totalBHYTPaidAmount + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Payment\PaymentAmount$PaymentAmountBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */