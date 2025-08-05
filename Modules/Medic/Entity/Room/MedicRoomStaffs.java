/*     */ package nencer.app.Modules.Medic.Entity.Room;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_room_staffs", schema = "nencer_api", catalog = "")
/*     */ public class MedicRoomStaffs
/*     */ {
/*     */   private int id;
/*     */   private String jobType;
/*     */   private String name;
/*     */   private Integer userId;
/*     */   private Integer roomId;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  24 */     return this.id;
/*     */   }
/*     */   private String status; private Timestamp checkinAt; private Timestamp checkoutAt; private Timestamp createdAt; private Timestamp updatedAt;
/*     */   public void setId(int id) {
/*  28 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "job_type")
/*     */   public String getJobType() {
/*  34 */     return this.jobType;
/*     */   }
/*     */   
/*     */   public void setJobType(String jobType) {
/*  38 */     this.jobType = jobType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  44 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  48 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public Integer getUserId() {
/*  54 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Integer userId) {
/*  58 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "room_id")
/*     */   public Integer getRoomId() {
/*  64 */     return this.roomId;
/*     */   }
/*     */   
/*     */   public void setRoomId(Integer roomId) {
/*  68 */     this.roomId = roomId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public String getStatus() {
/*  74 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/*  78 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_at")
/*     */   public Timestamp getCheckinAt() {
/*  84 */     return this.checkinAt;
/*     */   }
/*     */   
/*     */   public void setCheckinAt(Timestamp checkinAt) {
/*  88 */     this.checkinAt = checkinAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkout_at")
/*     */   public Timestamp getCheckoutAt() {
/*  94 */     return this.checkoutAt;
/*     */   }
/*     */   
/*     */   public void setCheckoutAt(Timestamp checkoutAt) {
/*  98 */     this.checkoutAt = checkoutAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Timestamp getCreatedAt() {
/* 104 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Timestamp createdAt) {
/* 108 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Timestamp getUpdatedAt() {
/* 114 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Timestamp updatedAt) {
/* 118 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 123 */     if (this == o) return true; 
/* 124 */     if (o == null || getClass() != o.getClass()) return false; 
/* 125 */     MedicRoomStaffs that = (MedicRoomStaffs)o;
/* 126 */     return (this.id == that.id && Objects.equals(this.jobType, that.jobType) && Objects.equals(this.name, that.name) && Objects.equals(this.userId, that.userId) && Objects.equals(this.roomId, that.roomId) && Objects.equals(this.status, that.status) && Objects.equals(this.checkinAt, that.checkinAt) && Objects.equals(this.checkoutAt, that.checkoutAt) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.jobType, this.name, this.userId, this.roomId, this.status, this.checkinAt, this.checkoutAt, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicRoomStaffs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */