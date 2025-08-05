/*    */ package nencer.app.Modules.Medic.Entity.Roche;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_roche_data")
/*    */ public class RocheData {
/*    */   private int id;
/*    */   private Integer ticketId;
/*    */   private String fileName;
/*    */   
/* 11 */   public static RocheDataBuilder builder() { return new RocheDataBuilder(); } private String filePath; private String fileData; private String direction; private Date createdAt; public static class RocheDataBuilder { private int id; private Integer ticketId; private String fileName; private String filePath; private String fileData; private String direction; private Date createdAt; public RocheDataBuilder id(int id) { this.id = id; return this; } public RocheDataBuilder ticketId(Integer ticketId) { this.ticketId = ticketId; return this; } public RocheDataBuilder fileName(String fileName) { this.fileName = fileName; return this; } public RocheDataBuilder filePath(String filePath) { this.filePath = filePath; return this; } public RocheDataBuilder fileData(String fileData) { this.fileData = fileData; return this; } public RocheDataBuilder direction(String direction) { this.direction = direction; return this; } public RocheDataBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public RocheData build() { return new RocheData(this.id, this.ticketId, this.fileName, this.filePath, this.fileData, this.direction, this.createdAt); } public String toString() { return "RocheData.RocheDataBuilder(id=" + this.id + ", ticketId=" + this.ticketId + ", fileName=" + this.fileName + ", filePath=" + this.filePath + ", fileData=" + this.fileData + ", direction=" + this.direction + ", createdAt=" + this.createdAt + ")"; }
/*    */      } public RocheData() {} public RocheData(int id, Integer ticketId, String fileName, String filePath, String fileData, String direction, Date createdAt) {
/* 13 */     this.id = id; this.ticketId = ticketId; this.fileName = fileName; this.filePath = filePath; this.fileData = fileData; this.direction = direction; this.createdAt = createdAt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id")
/*    */   public int getId() {
/* 28 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 32 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Column(name = "ticket_id")
/*    */   public int getTicketId() {
/* 37 */     return this.ticketId.intValue();
/*    */   }
/*    */   
/*    */   public void setTicketId(int ticketId) {
/* 41 */     this.ticketId = Integer.valueOf(ticketId);
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "file_name")
/*    */   public String getFileName() {
/* 47 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public void setFileName(String fileName) {
/* 51 */     this.fileName = fileName;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "direction")
/*    */   public String getDirection() {
/* 57 */     return this.direction;
/*    */   }
/*    */   
/*    */   public void setDirection(String direction) {
/* 61 */     this.direction = direction;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "file_path")
/*    */   public String getFilePath() {
/* 67 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public void setFilePath(String fileName) {
/* 71 */     this.fileName = fileName;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "file_data")
/*    */   public String getFileData() {
/* 77 */     return this.fileData;
/*    */   }
/*    */   
/*    */   public void setFileData(String fileData) {
/* 81 */     this.fileData = fileData;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 87 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 91 */     this.createdAt = createdAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Roche\RocheData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */