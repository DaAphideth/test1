/*    */ package nencer.app.Modules.Medic.Model.EgwBHYT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DsLichSuKT2018
/*    */ {
/*    */   private String userKT;
/*    */   private String thoiGIanKT;
/*    */   private String thongBao;
/*    */   private String maLoi;
/*    */   
/*    */   public void setUserKT(String userKT) {
/* 43 */     this.userKT = userKT; } public void setThoiGIanKT(String thoiGIanKT) { this.thoiGIanKT = thoiGIanKT; } public void setThongBao(String thongBao) { this.thongBao = thongBao; } public void setMaLoi(String maLoi) { this.maLoi = maLoi; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DsLichSuKT2018)) return false;  DsLichSuKT2018 other = (DsLichSuKT2018)o; if (!other.canEqual(this)) return false;  Object this$userKT = getUserKT(), other$userKT = other.getUserKT(); if ((this$userKT == null) ? (other$userKT != null) : !this$userKT.equals(other$userKT)) return false;  Object this$thoiGIanKT = getThoiGIanKT(), other$thoiGIanKT = other.getThoiGIanKT(); if ((this$thoiGIanKT == null) ? (other$thoiGIanKT != null) : !this$thoiGIanKT.equals(other$thoiGIanKT)) return false;  Object this$thongBao = getThongBao(), other$thongBao = other.getThongBao(); if ((this$thongBao == null) ? (other$thongBao != null) : !this$thongBao.equals(other$thongBao)) return false;  Object this$maLoi = getMaLoi(), other$maLoi = other.getMaLoi(); return !((this$maLoi == null) ? (other$maLoi != null) : !this$maLoi.equals(other$maLoi)); } protected boolean canEqual(Object other) { return other instanceof DsLichSuKT2018; } public int hashCode() { int PRIME = 59; result = 1; Object $userKT = getUserKT(); result = result * 59 + (($userKT == null) ? 43 : $userKT.hashCode()); Object $thoiGIanKT = getThoiGIanKT(); result = result * 59 + (($thoiGIanKT == null) ? 43 : $thoiGIanKT.hashCode()); Object $thongBao = getThongBao(); result = result * 59 + (($thongBao == null) ? 43 : $thongBao.hashCode()); Object $maLoi = getMaLoi(); return result * 59 + (($maLoi == null) ? 43 : $maLoi.hashCode()); } public String toString() { return "NhanLichSuKCB2018.DsLichSuKT2018(userKT=" + getUserKT() + ", thoiGIanKT=" + getThoiGIanKT() + ", thongBao=" + getThongBao() + ", maLoi=" + getMaLoi() + ")"; }
/*    */   
/* 45 */   public String getUserKT() { return this.userKT; }
/* 46 */   public String getThoiGIanKT() { return this.thoiGIanKT; }
/* 47 */   public String getThongBao() { return this.thongBao; } public String getMaLoi() {
/* 48 */     return this.maLoi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\EgwBHYT\NhanLichSuKCB2018$DsLichSuKT2018.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */