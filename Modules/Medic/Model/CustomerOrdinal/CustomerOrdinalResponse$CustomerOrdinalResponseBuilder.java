/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ 
/*    */ 
/*    */ public class CustomerOrdinalResponseBuilder
/*    */ {
/*    */   private Integer number;
/*    */   private Integer callingNumber;
/*    */   private String doorCode;
/*    */   private String numberWindow;
/*    */   private String window;
/*    */   
/*    */   public CustomerOrdinalResponseBuilder number(Integer number) {
/* 13 */     this.number = number; return this; } public CustomerOrdinalResponseBuilder callingNumber(Integer callingNumber) { this.callingNumber = callingNumber; return this; } public CustomerOrdinalResponseBuilder doorCode(String doorCode) { this.doorCode = doorCode; return this; } public CustomerOrdinalResponseBuilder numberWindow(String numberWindow) { this.numberWindow = numberWindow; return this; } public CustomerOrdinalResponseBuilder window(String window) { this.window = window; return this; } public CustomerOrdinalResponse build() { return new CustomerOrdinalResponse(this.number, this.callingNumber, this.doorCode, this.numberWindow, this.window); } public String toString() { return "CustomerOrdinalResponse.CustomerOrdinalResponseBuilder(number=" + this.number + ", callingNumber=" + this.callingNumber + ", doorCode=" + this.doorCode + ", numberWindow=" + this.numberWindow + ", window=" + this.window + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\CustomerOrdinalResponse$CustomerOrdinalResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */