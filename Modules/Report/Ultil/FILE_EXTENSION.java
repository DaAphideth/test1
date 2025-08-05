/*    */ package nencer.app.Modules.Report.Ultil;
/*    */ 
/*    */ public enum FILE_EXTENSION {
/*  4 */   PDF(".pdf"), DOCX(".docx"), PNG(".png"), JPG(".jpg"), JPEG(".jpeg"), BMP(".bmp");
/*    */   private String value;
/*    */   
/*    */   FILE_EXTENSION(String value) {
/*  8 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 12 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Ultil\FILE_EXTENSION.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */