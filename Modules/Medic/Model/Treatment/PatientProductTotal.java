/*    */ package nencer.app.Modules.Medic.Model.Treatment;@JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class PatientProductTotal { private Integer productId; private Integer invenId;
/*    */   private String productCode;
/*    */   private String productName;
/*    */   private Integer requestQty;
/*    */   private Integer invenQty;
/*    */   private Integer qtyAvailable;
/*    */   List<PatientProduct> patientProducts;
/*    */   
/* 10 */   public void setProductId(Integer productId) { this.productId = productId; } public void setInvenId(Integer invenId) { this.invenId = invenId; } public void setProductCode(String productCode) { this.productCode = productCode; } public void setProductName(String productName) { this.productName = productName; } public void setRequestQty(Integer requestQty) { this.requestQty = requestQty; } public void setInvenQty(Integer invenQty) { this.invenQty = invenQty; } public void setQtyAvailable(Integer qtyAvailable) { this.qtyAvailable = qtyAvailable; } public void setPatientProducts(List<PatientProduct> patientProducts) { this.patientProducts = patientProducts; } public PatientProductTotal(Integer productId, Integer invenId, String productCode, String productName, Integer requestQty, Integer invenQty, Integer qtyAvailable, List<PatientProduct> patientProducts) {
/* 11 */     this.productId = productId; this.invenId = invenId; this.productCode = productCode; this.productName = productName; this.requestQty = requestQty; this.invenQty = invenQty; this.qtyAvailable = qtyAvailable; this.patientProducts = patientProducts;
/*    */   } public PatientProductTotal() {}
/* 13 */   public static PatientProductTotalBuilder builder() { return new PatientProductTotalBuilder(); } public static class PatientProductTotalBuilder { private Integer productId; private Integer invenId; private String productCode; private String productName; public PatientProductTotalBuilder productId(Integer productId) { this.productId = productId; return this; } private Integer requestQty; private Integer invenQty; private Integer qtyAvailable; private List<PatientProduct> patientProducts; public PatientProductTotalBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } public PatientProductTotalBuilder productCode(String productCode) { this.productCode = productCode; return this; } public PatientProductTotalBuilder productName(String productName) { this.productName = productName; return this; } public PatientProductTotalBuilder requestQty(Integer requestQty) { this.requestQty = requestQty; return this; } public PatientProductTotalBuilder invenQty(Integer invenQty) { this.invenQty = invenQty; return this; } public PatientProductTotalBuilder qtyAvailable(Integer qtyAvailable) { this.qtyAvailable = qtyAvailable; return this; } public PatientProductTotalBuilder patientProducts(List<PatientProduct> patientProducts) { this.patientProducts = patientProducts; return this; } public PatientProductTotal build() { return new PatientProductTotal(this.productId, this.invenId, this.productCode, this.productName, this.requestQty, this.invenQty, this.qtyAvailable, this.patientProducts); } public String toString() { return "PatientProductTotal.PatientProductTotalBuilder(productId=" + this.productId + ", invenId=" + this.invenId + ", productCode=" + this.productCode + ", productName=" + this.productName + ", requestQty=" + this.requestQty + ", invenQty=" + this.invenQty + ", qtyAvailable=" + this.qtyAvailable + ", patientProducts=" + this.patientProducts + ")"; }
/*    */      }
/* 15 */   public Integer getProductId() { return this.productId; }
/* 16 */   public Integer getInvenId() { return this.invenId; }
/* 17 */   public String getProductCode() { return this.productCode; }
/* 18 */   public String getProductName() { return this.productName; }
/* 19 */   public Integer getRequestQty() { return this.requestQty; }
/* 20 */   public Integer getInvenQty() { return this.invenQty; }
/* 21 */   public Integer getQtyAvailable() { return this.qtyAvailable; } public List<PatientProduct> getPatientProducts() {
/* 22 */     return this.patientProducts;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\PatientProductTotal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */