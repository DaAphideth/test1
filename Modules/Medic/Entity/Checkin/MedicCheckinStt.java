/*     */ package nencer.app.Modules.Medic.Entity.Checkin;
/*     */ @Entity
/*     */ @Table(name = "medic_checkin_stt")
/*     */ public class MedicCheckinStt {
/*     */   private int id;
/*     */   private Integer number;
/*     */   private Integer roomId;
/*     */   private Integer mdId;
/*     */   
/*  10 */   public static MedicCheckinSttBuilder builder() { return new MedicCheckinSttBuilder(); } private String dateTime; private Date createdAt; private String status; private Integer callingNumber; public static class MedicCheckinSttBuilder { private int id; private Integer number; private Integer roomId; private Integer mdId; private String dateTime; private Date createdAt; private String status; private Integer callingNumber; public MedicCheckinSttBuilder id(int id) { this.id = id; return this; } public MedicCheckinSttBuilder number(Integer number) { this.number = number; return this; } public MedicCheckinSttBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public MedicCheckinSttBuilder mdId(Integer mdId) { this.mdId = mdId; return this; } public MedicCheckinSttBuilder dateTime(String dateTime) { this.dateTime = dateTime; return this; } public MedicCheckinSttBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicCheckinSttBuilder status(String status) { this.status = status; return this; } public MedicCheckinSttBuilder callingNumber(Integer callingNumber) { this.callingNumber = callingNumber; return this; } public MedicCheckinStt build() { return new MedicCheckinStt(this.id, this.number, this.roomId, this.mdId, this.dateTime, this.createdAt, this.status, this.callingNumber); } public String toString() { return "MedicCheckinStt.MedicCheckinSttBuilder(id=" + this.id + ", number=" + this.number + ", roomId=" + this.roomId + ", mdId=" + this.mdId + ", dateTime=" + this.dateTime + ", createdAt=" + this.createdAt + ", status=" + this.status + ", callingNumber=" + this.callingNumber + ")"; } } public MedicCheckinStt(int id, Integer number, Integer roomId, Integer mdId, String dateTime, Date createdAt, String status, Integer callingNumber) {
/*  11 */     this.id = id; this.number = number; this.roomId = roomId; this.mdId = mdId; this.dateTime = dateTime; this.createdAt = createdAt; this.status = status; this.callingNumber = callingNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MedicCheckinStt() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  33 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "number")
/*     */   public Integer getNumber() {
/*  39 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/*  43 */     this.number = number;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  49 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/*  53 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "md_id")
/*     */   public Integer getMdId() {
/*  59 */     return this.mdId;
/*     */   }
/*     */   
/*     */   public void setMdId(Integer mdId) {
/*  63 */     this.mdId = mdId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "date_time")
/*     */   public String getDateTime() {
/*  69 */     return this.dateTime;
/*     */   }
/*     */   
/*     */   public void setDateTime(String dateTime) {
/*  73 */     this.dateTime = dateTime;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  79 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  83 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/*  89 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/*  93 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "calling_number")
/*     */   public Integer getCallingNumber() {
/*  99 */     return this.callingNumber;
/*     */   }
/*     */   
/*     */   public void setCallingNumber(Integer callingNumber) {
/* 103 */     this.callingNumber = callingNumber;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Checkin\MedicCheckinStt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */