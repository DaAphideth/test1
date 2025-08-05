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
/*    */ class DsLichSuKCB2018
/*    */ {
/*    */   private String maHoSo;
/*    */   private String maCSKCB;
/*    */   private String ngayVao;
/*    */   private String ngayRa;
/*    */   private String tenBenh;
/*    */   private String tinhTrang;
/*    */   private String kqDieuTri;
/*    */   
/*    */   public void setMaHoSo(String maHoSo) {
/* 32 */     this.maHoSo = maHoSo; } public void setMaCSKCB(String maCSKCB) { this.maCSKCB = maCSKCB; } public void setNgayVao(String ngayVao) { this.ngayVao = ngayVao; } public void setNgayRa(String ngayRa) { this.ngayRa = ngayRa; } public void setTenBenh(String tenBenh) { this.tenBenh = tenBenh; } public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; } public void setKqDieuTri(String kqDieuTri) { this.kqDieuTri = kqDieuTri; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof DsLichSuKCB2018)) return false;  DsLichSuKCB2018 other = (DsLichSuKCB2018)o; if (!other.canEqual(this)) return false;  Object this$maHoSo = getMaHoSo(), other$maHoSo = other.getMaHoSo(); if ((this$maHoSo == null) ? (other$maHoSo != null) : !this$maHoSo.equals(other$maHoSo)) return false;  Object this$maCSKCB = getMaCSKCB(), other$maCSKCB = other.getMaCSKCB(); if ((this$maCSKCB == null) ? (other$maCSKCB != null) : !this$maCSKCB.equals(other$maCSKCB)) return false;  Object this$ngayVao = getNgayVao(), other$ngayVao = other.getNgayVao(); if ((this$ngayVao == null) ? (other$ngayVao != null) : !this$ngayVao.equals(other$ngayVao)) return false;  Object this$ngayRa = getNgayRa(), other$ngayRa = other.getNgayRa(); if ((this$ngayRa == null) ? (other$ngayRa != null) : !this$ngayRa.equals(other$ngayRa)) return false;  Object this$tenBenh = getTenBenh(), other$tenBenh = other.getTenBenh(); if ((this$tenBenh == null) ? (other$tenBenh != null) : !this$tenBenh.equals(other$tenBenh)) return false;  Object this$tinhTrang = getTinhTrang(), other$tinhTrang = other.getTinhTrang(); if ((this$tinhTrang == null) ? (other$tinhTrang != null) : !this$tinhTrang.equals(other$tinhTrang)) return false;  Object this$kqDieuTri = getKqDieuTri(), other$kqDieuTri = other.getKqDieuTri(); return !((this$kqDieuTri == null) ? (other$kqDieuTri != null) : !this$kqDieuTri.equals(other$kqDieuTri)); } protected boolean canEqual(Object other) { return other instanceof DsLichSuKCB2018; } public int hashCode() { int PRIME = 59; result = 1; Object $maHoSo = getMaHoSo(); result = result * 59 + (($maHoSo == null) ? 43 : $maHoSo.hashCode()); Object $maCSKCB = getMaCSKCB(); result = result * 59 + (($maCSKCB == null) ? 43 : $maCSKCB.hashCode()); Object $ngayVao = getNgayVao(); result = result * 59 + (($ngayVao == null) ? 43 : $ngayVao.hashCode()); Object $ngayRa = getNgayRa(); result = result * 59 + (($ngayRa == null) ? 43 : $ngayRa.hashCode()); Object $tenBenh = getTenBenh(); result = result * 59 + (($tenBenh == null) ? 43 : $tenBenh.hashCode()); Object $tinhTrang = getTinhTrang(); result = result * 59 + (($tinhTrang == null) ? 43 : $tinhTrang.hashCode()); Object $kqDieuTri = getKqDieuTri(); return result * 59 + (($kqDieuTri == null) ? 43 : $kqDieuTri.hashCode()); } public String toString() { return "NhanLichSuKCB2018.DsLichSuKCB2018(maHoSo=" + getMaHoSo() + ", maCSKCB=" + getMaCSKCB() + ", ngayVao=" + getNgayVao() + ", ngayRa=" + getNgayRa() + ", tenBenh=" + getTenBenh() + ", tinhTrang=" + getTinhTrang() + ", kqDieuTri=" + getKqDieuTri() + ")"; }
/*    */   
/* 34 */   public String getMaHoSo() { return this.maHoSo; }
/* 35 */   public String getMaCSKCB() { return this.maCSKCB; }
/* 36 */   public String getNgayVao() { return this.ngayVao; }
/* 37 */   public String getNgayRa() { return this.ngayRa; }
/* 38 */   public String getTenBenh() { return this.tenBenh; }
/* 39 */   public String getTinhTrang() { return this.tinhTrang; } public String getKqDieuTri() {
/* 40 */     return this.kqDieuTri;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\EgwBHYT\NhanLichSuKCB2018$DsLichSuKCB2018.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */