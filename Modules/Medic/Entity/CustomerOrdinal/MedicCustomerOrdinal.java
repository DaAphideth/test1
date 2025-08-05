/*    */ package nencer.app.Modules.Medic.Entity.CustomerOrdinal;
/*    */ import java.util.Date;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_customer_ordinal")
/*    */ public class MedicCustomerOrdinal {
/*    */   private int id;
/*    */   private Integer number;
/*    */   private String doorId;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   private Integer callingNumber; private String doorCode; private String dateTime; private Date createdAt;
/*    */   public void setId(int id) {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "number")
/*    */   public Integer getNumber() {
/* 33 */     return this.number;
/*    */   }
/*    */   
/*    */   public void setNumber(Integer number) {
/* 37 */     this.number = number;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "door_code")
/*    */   public String getDoorCode() {
/* 43 */     return this.doorCode;
/*    */   }
/*    */   
/*    */   public void setDoorCode(String doorCode) {
/* 47 */     this.doorCode = doorCode;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "door_id")
/*    */   public String getDoorId() {
/* 52 */     return this.doorId;
/*    */   }
/*    */   
/*    */   public void setDoorId(String checkinId) {
/* 56 */     this.doorId = this.doorId;
/*    */   }
/*    */   @Basic
/*    */   @Column(name = "calling_number")
/*    */   public Integer getCallingNumber() {
/* 61 */     return this.callingNumber;
/*    */   }
/*    */   
/*    */   public void setCallingNumber(Integer callingNumber) {
/* 65 */     this.callingNumber = callingNumber;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "date_time")
/*    */   public String getDateTime() {
/* 71 */     return this.dateTime;
/*    */   }
/*    */   
/*    */   public void setDateTime(String dateTime) {
/* 75 */     this.dateTime = dateTime;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 81 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 85 */     this.createdAt = createdAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 90 */     if (this == o) return true; 
/* 91 */     if (o == null || getClass() != o.getClass()) return false; 
/* 92 */     MedicCustomerOrdinal that = (MedicCustomerOrdinal)o;
/* 93 */     return (this.id == that.id && Objects.equals(this.number, that.number) && Objects.equals(this.doorId, that.doorId) && Objects.equals(this.dateTime, that.dateTime) && Objects.equals(this.createdAt, that.createdAt));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 98 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.number, this.doorId, this.dateTime, this.createdAt });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\CustomerOrdinal\MedicCustomerOrdinal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */