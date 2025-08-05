/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ public class PatientProductBuilder {
/*    */   private Integer ticketId;
/*    */   private String ticketCode;
/*    */   private Integer patientId;
/*    */   private String patientName;
/*    */   private String productCode;
/*    */   private String productName;
/*    */   private Integer requestQty;
/*    */   
/*    */   public PatientProductBuilder ticketId(Integer ticketId) {
/* 13 */     this.ticketId = ticketId; return this; } public PatientProductBuilder ticketCode(String ticketCode) { this.ticketCode = ticketCode; return this; } public PatientProductBuilder patientId(Integer patientId) { this.patientId = patientId; return this; } public PatientProductBuilder patientName(String patientName) { this.patientName = patientName; return this; } public PatientProductBuilder productCode(String productCode) { this.productCode = productCode; return this; } public PatientProductBuilder productName(String productName) { this.productName = productName; return this; } public PatientProductBuilder requestQty(Integer requestQty) { this.requestQty = requestQty; return this; } public PatientProduct build() { return new PatientProduct(this.ticketId, this.ticketCode, this.patientId, this.patientName, this.productCode, this.productName, this.requestQty); } public String toString() { return "PatientProduct.PatientProductBuilder(ticketId=" + this.ticketId + ", ticketCode=" + this.ticketCode + ", patientId=" + this.patientId + ", patientName=" + this.patientName + ", productCode=" + this.productCode + ", productName=" + this.productName + ", requestQty=" + this.requestQty + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\PatientProduct$PatientProductBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */