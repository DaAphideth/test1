/*    */ package nencer.app.Modules.Medic.Model.Treatment;@JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class PatientProduct { private Integer ticketId;
/*    */   private String ticketCode;
/*    */   private Integer patientId;
/*    */   private String patientName;
/*    */   private String productCode;
/*    */   private String productName;
/*    */   private Integer requestQty;
/*    */   
/* 10 */   public void setTicketId(Integer ticketId) { this.ticketId = ticketId; } public void setTicketCode(String ticketCode) { this.ticketCode = ticketCode; } public void setPatientId(Integer patientId) { this.patientId = patientId; } public void setPatientName(String patientName) { this.patientName = patientName; } public void setProductCode(String productCode) { this.productCode = productCode; } public void setProductName(String productName) { this.productName = productName; } public void setRequestQty(Integer requestQty) { this.requestQty = requestQty; } public PatientProduct(Integer ticketId, String ticketCode, Integer patientId, String patientName, String productCode, String productName, Integer requestQty) {
/* 11 */     this.ticketId = ticketId; this.ticketCode = ticketCode; this.patientId = patientId; this.patientName = patientName; this.productCode = productCode; this.productName = productName; this.requestQty = requestQty;
/*    */   } public PatientProduct() {}
/* 13 */   public static PatientProductBuilder builder() { return new PatientProductBuilder(); } public static class PatientProductBuilder { private Integer ticketId; private String ticketCode; private Integer patientId; public PatientProductBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } private String patientName; private String productCode; private String productName; private Integer requestQty; public PatientProductBuilder ticketCode(String ticketCode) { this.ticketCode = ticketCode; return this; } public PatientProductBuilder patientId(Integer patientId) { this.patientId = patientId; return this; } public PatientProductBuilder patientName(String patientName) { this.patientName = patientName; return this; } public PatientProductBuilder productCode(String productCode) { this.productCode = productCode; return this; } public PatientProductBuilder productName(String productName) { this.productName = productName; return this; } public PatientProductBuilder requestQty(Integer requestQty) { this.requestQty = requestQty; return this; } public PatientProduct build() { return new PatientProduct(this.ticketId, this.ticketCode, this.patientId, this.patientName, this.productCode, this.productName, this.requestQty); } public String toString() { return "PatientProduct.PatientProductBuilder(ticketId=" + this.ticketId + ", ticketCode=" + this.ticketCode + ", patientId=" + this.patientId + ", patientName=" + this.patientName + ", productCode=" + this.productCode + ", productName=" + this.productName + ", requestQty=" + this.requestQty + ")"; }
/*    */      }
/* 15 */   public Integer getTicketId() { return this.ticketId; }
/* 16 */   public String getTicketCode() { return this.ticketCode; }
/* 17 */   public Integer getPatientId() { return this.patientId; }
/* 18 */   public String getPatientName() { return this.patientName; }
/* 19 */   public String getProductCode() { return this.productCode; }
/* 20 */   public String getProductName() { return this.productName; } public Integer getRequestQty() {
/* 21 */     return this.requestQty;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\PatientProduct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */