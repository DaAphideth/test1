/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class CustomerOrdinalResponse {
/*    */   private Integer number;
/*    */   private Integer callingNumber;
/*    */   private String doorCode;
/*    */   private String numberWindow;
/*    */   private String window;
/*    */   
/* 10 */   public void setNumber(Integer number) { this.number = number; } public void setCallingNumber(Integer callingNumber) { this.callingNumber = callingNumber; } public void setDoorCode(String doorCode) { this.doorCode = doorCode; } public void setNumberWindow(String numberWindow) { this.numberWindow = numberWindow; } public void setWindow(String window) { this.window = window; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CustomerOrdinalResponse)) return false;  CustomerOrdinalResponse other = (CustomerOrdinalResponse)o; if (!other.canEqual(this)) return false;  Object this$number = getNumber(), other$number = other.getNumber(); if ((this$number == null) ? (other$number != null) : !this$number.equals(other$number)) return false;  Object this$callingNumber = getCallingNumber(), other$callingNumber = other.getCallingNumber(); if ((this$callingNumber == null) ? (other$callingNumber != null) : !this$callingNumber.equals(other$callingNumber)) return false;  Object this$doorCode = getDoorCode(), other$doorCode = other.getDoorCode(); if ((this$doorCode == null) ? (other$doorCode != null) : !this$doorCode.equals(other$doorCode)) return false;  Object this$numberWindow = getNumberWindow(), other$numberWindow = other.getNumberWindow(); if ((this$numberWindow == null) ? (other$numberWindow != null) : !this$numberWindow.equals(other$numberWindow)) return false;  Object this$window = getWindow(), other$window = other.getWindow(); return !((this$window == null) ? (other$window != null) : !this$window.equals(other$window)); } protected boolean canEqual(Object other) { return other instanceof CustomerOrdinalResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $number = getNumber(); result = result * 59 + (($number == null) ? 43 : $number.hashCode()); Object $callingNumber = getCallingNumber(); result = result * 59 + (($callingNumber == null) ? 43 : $callingNumber.hashCode()); Object $doorCode = getDoorCode(); result = result * 59 + (($doorCode == null) ? 43 : $doorCode.hashCode()); Object $numberWindow = getNumberWindow(); result = result * 59 + (($numberWindow == null) ? 43 : $numberWindow.hashCode()); Object $window = getWindow(); return result * 59 + (($window == null) ? 43 : $window.hashCode()); } public String toString() { return "CustomerOrdinalResponse(number=" + getNumber() + ", callingNumber=" + getCallingNumber() + ", doorCode=" + getDoorCode() + ", numberWindow=" + getNumberWindow() + ", window=" + getWindow() + ")"; }
/*    */    public CustomerOrdinalResponse() {}
/* 12 */   public CustomerOrdinalResponse(Integer number, Integer callingNumber, String doorCode, String numberWindow, String window) { this.number = number; this.callingNumber = callingNumber; this.doorCode = doorCode; this.numberWindow = numberWindow; this.window = window; }
/* 13 */   public static CustomerOrdinalResponseBuilder builder() { return new CustomerOrdinalResponseBuilder(); } public static class CustomerOrdinalResponseBuilder { private Integer number; private Integer callingNumber; public CustomerOrdinalResponseBuilder number(Integer number) { this.number = number; return this; } private String doorCode; private String numberWindow; private String window; public CustomerOrdinalResponseBuilder callingNumber(Integer callingNumber) { this.callingNumber = callingNumber; return this; } public CustomerOrdinalResponseBuilder doorCode(String doorCode) { this.doorCode = doorCode; return this; } public CustomerOrdinalResponseBuilder numberWindow(String numberWindow) { this.numberWindow = numberWindow; return this; } public CustomerOrdinalResponseBuilder window(String window) { this.window = window; return this; } public CustomerOrdinalResponse build() { return new CustomerOrdinalResponse(this.number, this.callingNumber, this.doorCode, this.numberWindow, this.window); } public String toString() { return "CustomerOrdinalResponse.CustomerOrdinalResponseBuilder(number=" + this.number + ", callingNumber=" + this.callingNumber + ", doorCode=" + this.doorCode + ", numberWindow=" + this.numberWindow + ", window=" + this.window + ")"; }
/*    */      }
/*    */   
/* 16 */   public Integer getNumber() { return this.number; }
/* 17 */   public Integer getCallingNumber() { return this.callingNumber; }
/* 18 */   public String getDoorCode() { return this.doorCode; }
/* 19 */   public String getNumberWindow() { return this.numberWindow; } public String getWindow() {
/* 20 */     return this.window;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\CustomerOrdinalResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */