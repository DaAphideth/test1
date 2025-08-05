/*    */ package nencer.app.Modules.Report.Model;
/*    */ public class LableMedicModel { private Integer id; private String tenThuoc;
/*    */   private String tenBV;
/*    */   
/*  5 */   public void setId(Integer id) { this.id = id; } private Double gia; private String donvi; private Integer numberOfBarCode; public void setTenThuoc(String tenThuoc) { this.tenThuoc = tenThuoc; } public void setTenBV(String tenBV) { this.tenBV = tenBV; } public void setGia(Double gia) { this.gia = gia; } public void setDonvi(String donvi) { this.donvi = donvi; } public void setNumberOfBarCode(Integer numberOfBarCode) { this.numberOfBarCode = numberOfBarCode; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LableMedicModel)) return false;  LableMedicModel other = (LableMedicModel)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$tenThuoc = getTenThuoc(), other$tenThuoc = other.getTenThuoc(); if ((this$tenThuoc == null) ? (other$tenThuoc != null) : !this$tenThuoc.equals(other$tenThuoc)) return false;  Object this$tenBV = getTenBV(), other$tenBV = other.getTenBV(); if ((this$tenBV == null) ? (other$tenBV != null) : !this$tenBV.equals(other$tenBV)) return false;  Object this$gia = getGia(), other$gia = other.getGia(); if ((this$gia == null) ? (other$gia != null) : !this$gia.equals(other$gia)) return false;  Object this$donvi = getDonvi(), other$donvi = other.getDonvi(); if ((this$donvi == null) ? (other$donvi != null) : !this$donvi.equals(other$donvi)) return false;  Object this$numberOfBarCode = getNumberOfBarCode(), other$numberOfBarCode = other.getNumberOfBarCode(); return !((this$numberOfBarCode == null) ? (other$numberOfBarCode != null) : !this$numberOfBarCode.equals(other$numberOfBarCode)); } protected boolean canEqual(Object other) { return other instanceof LableMedicModel; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $tenThuoc = getTenThuoc(); result = result * 59 + (($tenThuoc == null) ? 43 : $tenThuoc.hashCode()); Object $tenBV = getTenBV(); result = result * 59 + (($tenBV == null) ? 43 : $tenBV.hashCode()); Object $gia = getGia(); result = result * 59 + (($gia == null) ? 43 : $gia.hashCode()); Object $donvi = getDonvi(); result = result * 59 + (($donvi == null) ? 43 : $donvi.hashCode()); Object $numberOfBarCode = getNumberOfBarCode(); return result * 59 + (($numberOfBarCode == null) ? 43 : $numberOfBarCode.hashCode()); } public String toString() { return "LableMedicModel(id=" + getId() + ", tenThuoc=" + getTenThuoc() + ", tenBV=" + getTenBV() + ", gia=" + getGia() + ", donvi=" + getDonvi() + ", numberOfBarCode=" + getNumberOfBarCode() + ")"; }
/*    */   
/*  7 */   public Integer getId() { return this.id; }
/*  8 */   public String getTenThuoc() { return this.tenThuoc; }
/*  9 */   public String getTenBV() { return this.tenBV; }
/* 10 */   public Double getGia() { return this.gia; }
/* 11 */   public String getDonvi() { return this.donvi; } public Integer getNumberOfBarCode() {
/* 12 */     return this.numberOfBarCode;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Model\LableMedicModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */