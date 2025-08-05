/*    */ package nencer.app.Modules.Medic.Entity.Checkin;
/*    */ 
/*    */ 
/*    */ public class MedicCheckinSttBuilder {
/*    */   private int id;
/*    */   private Integer number;
/*    */   private Integer roomId;
/*    */   private Integer mdId;
/*    */   
/* 10 */   public MedicCheckinSttBuilder id(int id) { this.id = id; return this; } private String dateTime; private Date createdAt; private String status; private Integer callingNumber; public MedicCheckinSttBuilder number(Integer number) { this.number = number; return this; } public MedicCheckinSttBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicCheckinSttBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinSttBuilder dateTime(String dateTime) { this.dateTime = dateTime; return this; } public MedicCheckinSttBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicCheckinSttBuilder status(String status) { this.status = status; return this; } public MedicCheckinSttBuilder callingNumber(Integer callingNumber) { this.callingNumber = callingNumber; return this; } public MedicCheckinStt build() { return new MedicCheckinStt(this.id, this.number, this.roomId, this.mdId, this.dateTime, this.createdAt, this.status, this.callingNumber); } public String toString() { return "MedicCheckinStt.MedicCheckinSttBuilder(id=" + this.id + ", number=" + this.number + ", roomId=" + this.roomId + ", mdId=" + this.mdId + ", dateTime=" + this.dateTime + ", createdAt=" + this.createdAt + ", status=" + this.status + ", callingNumber=" + this.callingNumber + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckinStt$MedicCheckinSttBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */