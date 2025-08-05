/*    */ package nencer.app.Modules.Medic.Model.Treatment;
/*    */ 
/*    */ public class PatientProductTotalBuilder {
/*    */   private Integer productId;
/*    */   private Integer invenId;
/*    */   private String productCode;
/*    */   private String productName;
/*    */   private Integer requestQty;
/*    */   private Integer invenQty;
/*    */   private Integer qtyAvailable;
/*    */   private List<PatientProduct> patientProducts;
/*    */   
/* 13 */   public PatientProductTotalBuilder productId(Integer productId) { this.productId = productId; return this; } public PatientProductTotalBuilder invenId(Integer invenId) { this.invenId = invenId; return this; } public PatientProductTotalBuilder productCode(String productCode) { this.productCode = productCode; return this; } public PatientProductTotalBuilder productName(String productName) { this.productName = productName; return this; } public PatientProductTotalBuilder requestQty(Integer requestQty) { this.requestQty = requestQty; return this; } public PatientProductTotalBuilder invenQty(Integer invenQty) { this.invenQty = invenQty; return this; } public PatientProductTotalBuilder qtyAvailable(Integer qtyAvailable) { this.qtyAvailable = qtyAvailable; return this; } public PatientProductTotalBuilder patientProducts(List<PatientProduct> patientProducts) { this.patientProducts = patientProducts; return this; } public PatientProductTotal build() { return new PatientProductTotal(this.productId, this.invenId, this.productCode, this.productName, this.requestQty, this.invenQty, this.qtyAvailable, this.patientProducts); } public String toString() { return "PatientProductTotal.PatientProductTotalBuilder(productId=" + this.productId + ", invenId=" + this.invenId + ", productCode=" + this.productCode + ", productName=" + this.productName + ", requestQty=" + this.requestQty + ", invenQty=" + this.invenQty + ", qtyAvailable=" + this.qtyAvailable + ", patientProducts=" + this.patientProducts + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Treatment\PatientProductTotal$PatientProductTotalBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */