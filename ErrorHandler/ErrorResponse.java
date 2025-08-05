/*    */ package nencer.app.ErrorHandler;
/*    */ 
/*    */ public class ErrorResponse {
/*    */   private String status;
/*    */   private String code;
/*    */   private String desc;
/*    */   
/*    */   public void setStatus(String status) {
/*  9 */     this.status = status; } public void setCode(String code) { this.code = code; } public void setDesc(String desc) { this.desc = desc; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ErrorResponse)) return false;  ErrorResponse other = (ErrorResponse)o; if (!other.canEqual(this)) return false;  Object this$status = getStatus(), other$status = other.getStatus(); if ((this$status == null) ? (other$status != null) : !this$status.equals(other$status)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$desc = getDesc(), other$desc = other.getDesc(); return !((this$desc == null) ? (other$desc != null) : !this$desc.equals(other$desc)); } protected boolean canEqual(Object other) { return other instanceof ErrorResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $status = getStatus(); result = result * 59 + (($status == null) ? 43 : $status.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $desc = getDesc(); return result * 59 + (($desc == null) ? 43 : $desc.hashCode()); } public String toString() { return "ErrorResponse(status=" + getStatus() + ", code=" + getCode() + ", desc=" + getDesc() + ")"; }
/*    */    public ErrorResponse() {} public ErrorResponse(String status, String code, String desc) {
/* 11 */     this.status = status; this.code = code; this.desc = desc;
/*    */   }
/* 13 */   public String getStatus() { return this.status; }
/* 14 */   public String getCode() { return this.code; } public String getDesc() {
/* 15 */     return this.desc;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\ErrorHandler\ErrorResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */