/*    */ package nencer.app.Modules.Report.Model;
/*    */ 
/*    */ public class PhieuKetQuaXetNghiem {
/*    */   private String BN_Ten;
/*    */   private String Logo;
/*    */   
/*  7 */   public void setBN_Ten(String BN_Ten) { this.BN_Ten = BN_Ten; } public void setLogo(String Logo) { this.Logo = Logo; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PhieuKetQuaXetNghiem)) return false;  PhieuKetQuaXetNghiem other = (PhieuKetQuaXetNghiem)o; if (!other.canEqual(this)) return false;  Object this$BN_Ten = getBN_Ten(), other$BN_Ten = other.getBN_Ten(); if ((this$BN_Ten == null) ? (other$BN_Ten != null) : !this$BN_Ten.equals(other$BN_Ten)) return false;  Object this$Logo = getLogo(), other$Logo = other.getLogo(); return !((this$Logo == null) ? (other$Logo != null) : !this$Logo.equals(other$Logo)); } protected boolean canEqual(Object other) { return other instanceof PhieuKetQuaXetNghiem; } public int hashCode() { int PRIME = 59; result = 1; Object $BN_Ten = getBN_Ten(); result = result * 59 + (($BN_Ten == null) ? 43 : $BN_Ten.hashCode()); Object $Logo = getLogo(); return result * 59 + (($Logo == null) ? 43 : $Logo.hashCode()); } public String toString() { return "PhieuKetQuaXetNghiem(BN_Ten=" + getBN_Ten() + ", Logo=" + getLogo() + ")"; } public PhieuKetQuaXetNghiem(String BN_Ten, String Logo) {
/*  8 */     this.BN_Ten = BN_Ten; this.Logo = Logo;
/*    */   }
/*    */   public PhieuKetQuaXetNghiem() {}
/* 11 */   public String getBN_Ten() { return this.BN_Ten; } public String getLogo() {
/* 12 */     return this.Logo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\PhieuKetQuaXetNghiem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */