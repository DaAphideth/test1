/*    */ package nencer.app.Modules.Medic.Entity.Roche;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RocheDataBuilder {
/*    */   private int id;
/*    */   private Integer ticketId;
/*    */   private String fileName;
/*    */   
/*    */   public RocheDataBuilder id(int id) {
/* 11 */     this.id = id; return this; } private String filePath; private String fileData; private String direction; private Date createdAt; public RocheDataBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public RocheDataBuilder fileName(String fileName) { this.fileName = fileName; return this; } public RocheDataBuilder filePath(String filePath) { this.filePath = filePath; return this; } public RocheDataBuilder fileData(String fileData) { this.fileData = fileData; return this; } public RocheDataBuilder direction(String direction) { this.direction = direction; return this; } public RocheDataBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RocheData build() { return new RocheData(this.id, this.ticketId, this.fileName, this.filePath, this.fileData, this.direction, this.createdAt); } public String toString() { return "RocheData.RocheDataBuilder(id=" + this.id + ", ticketId=" + this.ticketId + ", fileName=" + this.fileName + ", filePath=" + this.filePath + ", fileData=" + this.fileData + ", direction=" + this.direction + ", createdAt=" + this.createdAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Roche\RocheData$RocheDataBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */