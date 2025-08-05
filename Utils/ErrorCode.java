/*    */ package nencer.app.Utils;
/*    */ 
/*    */ public enum ErrorCode {
/*  4 */   UNHANDLED_ERROR("0001", "Ngoại lệ"),
/*  5 */   APPID_NOT_FOUND("0002", "AppId không tồn tại"),
/*  6 */   OBJECT_NOT_FOUND("0003", "Không tìm thấy object hoặc id đối tượng không tồn tại"),
/*  7 */   STORAGE_CREDENTIALS_FAILED("0004", "Xác thực storage thất bại"),
/*  8 */   STORAGE_GET_FILE_FAILED("0005", "Lấy file từ storage thất bại"),
/*  9 */   STORAGE_UPLOAD_FILE_FAILED("0006", "Upload file lên storage thất bại"),
/* 10 */   READ_DOCUMENT_FAILED("0007", "Không thể đọc document"),
/* 11 */   EXPORT_DOCUMENT_FAILED("0008", "Xuất document không thành công"),
/* 12 */   OBJECT_ALREADY_EXISTED("0009", "Đối tượng đã tồn tại");
/*    */   
/*    */   public String code;
/*    */   
/*    */   public String description;
/*    */ 
/*    */   
/*    */   ErrorCode(String code, String description) {
/* 20 */     this.code = code;
/* 21 */     this.description = description;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ErrorCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */