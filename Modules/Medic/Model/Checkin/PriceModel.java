/*    */ package nencer.app.Modules.Medic.Model.Checkin;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class PriceModel {
/*    */   private Double VND;
/*    */   private Double USD;
/*    */   
/*  9 */   public void setVND(Double VND) { this.VND = VND; } public void setUSD(Double USD) { this.USD = USD; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PriceModel)) return false;  PriceModel other = (PriceModel)o; if (!other.canEqual(this)) return false;  Object this$VND = getVND(), other$VND = other.getVND(); if ((this$VND == null) ? (other$VND != null) : !this$VND.equals(other$VND)) return false;  Object this$USD = getUSD(), other$USD = other.getUSD(); return !((this$USD == null) ? (other$USD != null) : !this$USD.equals(other$USD)); } protected boolean canEqual(Object other) { return other instanceof PriceModel; } public int hashCode() { int PRIME = 59; result = 1; Object $VND = getVND(); result = result * 59 + (($VND == null) ? 43 : $VND.hashCode()); Object $USD = getUSD(); return result * 59 + (($USD == null) ? 43 : $USD.hashCode()); } public String toString() { return "PriceModel(VND=" + getVND() + ", USD=" + getUSD() + ")"; }
/*    */    public PriceModel() {} public PriceModel(Double VND, Double USD) {
/* 11 */     this.VND = VND; this.USD = USD;
/*    */   }
/*    */   
/* 14 */   public Double getVND() { return this.VND; } public Double getUSD() {
/* 15 */     return this.USD;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Checkin\PriceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */