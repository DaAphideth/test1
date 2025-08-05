/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ 
/*    */ public class WardShortResponse
/*    */ {
/*    */   private String provinceCode;
/*    */   private String districtCode;
/*    */   private String wardCode;
/*    */   
/*    */   public void setProvinceCode(String provinceCode) {
/* 11 */     this.provinceCode = provinceCode; } public void setDistrictCode(String districtCode) { this.districtCode = districtCode; } public void setWardCode(String wardCode) { this.wardCode = wardCode; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof WardShortResponse)) return false;  WardShortResponse other = (WardShortResponse)o; if (!other.canEqual(this)) return false;  Object this$provinceCode = getProvinceCode(), other$provinceCode = other.getProvinceCode(); if ((this$provinceCode == null) ? (other$provinceCode != null) : !this$provinceCode.equals(other$provinceCode)) return false;  Object this$districtCode = getDistrictCode(), other$districtCode = other.getDistrictCode(); if ((this$districtCode == null) ? (other$districtCode != null) : !this$districtCode.equals(other$districtCode)) return false;  Object this$wardCode = getWardCode(), other$wardCode = other.getWardCode(); return !((this$wardCode == null) ? (other$wardCode != null) : !this$wardCode.equals(other$wardCode)); } protected boolean canEqual(Object other) { return other instanceof WardShortResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $provinceCode = getProvinceCode(); result = result * 59 + (($provinceCode == null) ? 43 : $provinceCode.hashCode()); Object $districtCode = getDistrictCode(); result = result * 59 + (($districtCode == null) ? 43 : $districtCode.hashCode()); Object $wardCode = getWardCode(); return result * 59 + (($wardCode == null) ? 43 : $wardCode.hashCode()); } public String toString() { return "WardShortResponse(provinceCode=" + getProvinceCode() + ", districtCode=" + getDistrictCode() + ", wardCode=" + getWardCode() + ")"; }
/* 12 */   public static WardShortResponseBuilder builder() { return new WardShortResponseBuilder(); } public static class WardShortResponseBuilder { private String provinceCode; public WardShortResponseBuilder provinceCode(String provinceCode) { this.provinceCode = provinceCode; return this; } private String districtCode; private String wardCode; public WardShortResponseBuilder districtCode(String districtCode) { this.districtCode = districtCode; return this; } public WardShortResponseBuilder wardCode(String wardCode) { this.wardCode = wardCode; return this; } public WardShortResponse build() { return new WardShortResponse(this.provinceCode, this.districtCode, this.wardCode); } public String toString() { return "WardShortResponse.WardShortResponseBuilder(provinceCode=" + this.provinceCode + ", districtCode=" + this.districtCode + ", wardCode=" + this.wardCode + ")"; }
/*    */      } public WardShortResponse() {} public WardShortResponse(String provinceCode, String districtCode, String wardCode) {
/* 14 */     this.provinceCode = provinceCode; this.districtCode = districtCode; this.wardCode = wardCode;
/*    */   }
/* 16 */   public String getProvinceCode() { return this.provinceCode; }
/* 17 */   public String getDistrictCode() { return this.districtCode; } public String getWardCode() {
/* 18 */     return this.wardCode;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\WardShortResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */