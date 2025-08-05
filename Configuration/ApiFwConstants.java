/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ public interface ApiFwConstants
/*    */ {
/*    */   public static abstract class Status
/*    */   {
/*    */     public static final String OK = "OK";
/*    */     public static final String FAILE = "FAILE";
/*    */     public static final String ERROR = "ERROR";
/*    */   }
/*    */   
/*    */   public static interface HIS_TEMPLATE
/*    */   {
/*    */     public static final String LAY_SO_TIEP_DON = "LAY_SO_TIEP_DON";
/*    */     public static final String DON_THUOC_BHYT = "DON_THUOC_BHYT";
/*    */     public static final String DON_THUOC_MUA_NGOAI = "DON_THUOC_MUA_NGOAI";
/*    */     public static final String DON_THUOC_THEO_KHO = "DON_THUOC_THEO_KHO";
/*    */     public static final String GIAY_CHUYEN_TUYEN = "GIAY_CHUYEN_TUYEN";
/*    */     public static final String PHIEU_DANG_KY_KHAM = "PHIEU_DANG_KY_KHAM";
/*    */     public static final String PHIEU_HEN_TAI_KHAM = "PHIEU_HEN_TAI_KHAM";
/*    */     public static final String PHIEU_HOAN_UNG = "PHIEU_HOAN_UNG";
/*    */     public static final String PHIEU_KET_QUA_CDHA_TDCN = "PHIEU_KET_QUA_CDHA_TDCN";
/*    */     public static final String PHIEU_KET_QUA_XET_NGHIEM = "PHIEU_KET_QUA_XET_NGHIEM";
/*    */     public static final String PHIEU_CHI_DINH_XN = "PHIEU_CHI_DINH_XN";
/*    */     public static final String PHIEU_CHI_DINH_DV = "PHIEU_CHI_DINH_DV";
/*    */     public static final String PHIEU_KET_QUA = "PHIEU_KET_QUA";
/*    */     public static final String PHIEU_CHI_DINH_CDHA = "PHIEU_CHI_DINH_CDHA";
/*    */     public static final String PHIEU_KHAM_VAO_VIEN = "PHIEU_KHAM_VAO_VIEN";
/*    */     public static final String PHIEU_TAM_UNG = "PHIEU_TAM_UNG";
/*    */     public static final String PHIEU_THU_TIEN = "PHIEU_THU_TIEN";
/*    */     public static final String DON_THUOC = "DON_THUOC";
/*    */     public static final String HEN_GIO_TRA_KET_QUA = "HEN_GIO_TRA_KET_QUA";
/*    */     public static final String MAU_BARCODE = "MAU_BARCODE";
/*    */     public static final String GIAY_RA_VIEN = "GIAY_RA_VIEN";
/*    */     public static final String PHIEU_THANH_TOAN = "PHIEU_THANH_TOAN";
/*    */     public static final String GIAY_CHUNG_NHAN_PTTT = "GIAY_CHUNG_NHAN_PTTT";
/*    */     public static final String PHIEU_THU_TIEN_KHO = "PHIEU_THU_TIEN_KHO";
/*    */     public static final String IN_NHAN_THUOC = "IN_NHAN_THUOC";
/*    */     public static final String IN_TAT_CA_NHAN_THUOC = "IN_TAT_CA_NHAN_THUOC";
/*    */     public static final String GIAY_CHUNG_TU = "GIAY_CHUNG_TU";
/*    */     public static final String PHIEU_DIEU_TRI = "PHIEU_DIEU_TRI";
/*    */     public static final String PHIEU_BENH_AN = "PHIEU_BENH_AN";
/*    */     public static final String DON_THUOC_KHACH_LE = "DON_THUOC_KHACH_LE";
/*    */     public static final String BANG_KE_THANH_TOAN = "BANG_KE_THANH_TOAN";
/*    */   }
/*    */   
/*    */   public static interface HIS_REPORT_TEMPLATE {
/*    */     public static final String BAO_CAO_KHAM_BENH = "BAO_CAO_KHAM_BENH";
/*    */     public static final String BAO_CAO_NHAP_XUAT_TON = "BAO_CAO_NHAP_XUAT_TON";
/*    */     public static final String BAO_CAO_PHIEU_NHAP_NHA_CUNG_CAP = "BAO_CAO_PHIEU_NHAP_NHA_CUNG_CAP";
/*    */     public static final String SO_KHAM_BENH = "SO_KHAM_BENH";
/*    */     public static final String SO_XET_NGHIEM = "SO_XET_NGHIEM";
/*    */     public static final String BAO_CAO_TAI_CHINH = "BAO_CAO_TAI_CHINH";
/*    */     public static final String SO_CHUAN_DOAN_HINH_ANH = "SO_CHUAN_DOAN_HINH_ANH";
/*    */     public static final String BAO_CAO_TIEP_DON = "BAO_CAO_TIEP_DON";
/*    */     public static final String BAO_CAO_TAI_CHINH_DOC = "BAO_CAO_TAI_CHINH_DOC";
/*    */     public static final String PHIEU_CHUC_NANG_SONG = "PHIEU_CHUC_NANG_SONG";
/*    */   }
/*    */   
/*    */   public enum Seperator {
/* 61 */     space("space"),
/* 62 */     comma("comma"),
/* 63 */     dot("dot");
/*    */     private String code;
/*    */     
/*    */     Seperator(String code) {
/* 67 */       this.code = code;
/*    */     }
/*    */     
/*    */     public String getCode() {
/* 71 */       return this.code;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\ApiFwConstants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */