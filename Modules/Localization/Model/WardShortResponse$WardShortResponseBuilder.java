/*    */ package nencer.app.Modules.Localization.Model;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WardShortResponseBuilder
/*    */ {
/*    */   private String provinceCode;
/*    */   private String districtCode;
/*    */   private String wardCode;
/*    */   
/*    */   public WardShortResponseBuilder provinceCode(String provinceCode) {
/* 12 */     this.provinceCode = provinceCode; return this; } public WardShortResponseBuilder districtCode(String districtCode) { this.districtCode = districtCode; return this; } public WardShortResponseBuilder wardCode(String wardCode) { this.wardCode = wardCode; return this; } public WardShortResponse build() { return new WardShortResponse(this.provinceCode, this.districtCode, this.wardCode); } public String toString() { return "WardShortResponse.WardShortResponseBuilder(provinceCode=" + this.provinceCode + ", districtCode=" + this.districtCode + ", wardCode=" + this.wardCode + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Model\WardShortResponse$WardShortResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */