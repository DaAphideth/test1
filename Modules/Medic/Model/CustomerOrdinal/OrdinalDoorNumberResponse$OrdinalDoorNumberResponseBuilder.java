/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ 
/*    */ public class OrdinalDoorNumberResponseBuilder {
/*    */   private Integer number;
/*    */   private Integer callingNumber;
/*    */   private String doorCode;
/*    */   private String doorId;
/*    */   private String roomId;
/*    */   private String doorName;
/*    */   
/*    */   public OrdinalDoorNumberResponseBuilder number(Integer number) {
/* 12 */     this.number = number; return this; } private String roomName; private String doctorName; private String name; private String stt; private String patientName; private String yearBorn; public OrdinalDoorNumberResponseBuilder callingNumber(Integer callingNumber) { this.callingNumber = callingNumber; return this; } public OrdinalDoorNumberResponseBuilder doorCode(String doorCode) { this.doorCode = doorCode; return this; } public OrdinalDoorNumberResponseBuilder doorId(String doorId) { this.doorId = doorId; return this; } public OrdinalDoorNumberResponseBuilder roomId(String roomId) { this.roomId = roomId; return this; } public OrdinalDoorNumberResponseBuilder doorName(String doorName) { this.doorName = doorName; return this; } public OrdinalDoorNumberResponseBuilder roomName(String roomName) { this.roomName = roomName; return this; } public OrdinalDoorNumberResponseBuilder doctorName(String doctorName) { this.doctorName = doctorName; return this; } public OrdinalDoorNumberResponseBuilder name(String name) { this.name = name; return this; } public OrdinalDoorNumberResponseBuilder stt(String stt) { this.stt = stt; return this; } public OrdinalDoorNumberResponseBuilder patientName(String patientName) { this.patientName = patientName; return this; } public OrdinalDoorNumberResponseBuilder yearBorn(String yearBorn) { this.yearBorn = yearBorn; return this; } public OrdinalDoorNumberResponse build() { return new OrdinalDoorNumberResponse(this.number, this.callingNumber, this.doorCode, this.doorId, this.roomId, this.doorName, this.roomName, this.doctorName, this.name, this.stt, this.patientName, this.yearBorn); } public String toString() { return "OrdinalDoorNumberResponse.OrdinalDoorNumberResponseBuilder(number=" + this.number + ", callingNumber=" + this.callingNumber + ", doorCode=" + this.doorCode + ", doorId=" + this.doorId + ", roomId=" + this.roomId + ", doorName=" + this.doorName + ", roomName=" + this.roomName + ", doctorName=" + this.doctorName + ", name=" + this.name + ", stt=" + this.stt + ", patientName=" + this.patientName + ", yearBorn=" + this.yearBorn + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\OrdinalDoorNumberResponse$OrdinalDoorNumberResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */