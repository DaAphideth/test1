/*    */ package nencer.app.Modules.Medic.Entity.Sample;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_sample_device")
/*    */ public class MedicSampleDevice {
/*    */   private int id;
/*    */   private Integer serviceId;
/*    */   private String name;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   private String code; private Boolean status; private Date createdAt; private Date updatedAt;
/*    */   public void setId(int id) {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "service_id")
/*    */   public Integer getServiceId() {
/* 33 */     return this.serviceId;
/*    */   }
/*    */   
/*    */   public void setServiceId(Integer serviceId) {
/* 37 */     this.serviceId = serviceId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 43 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 47 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 53 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 57 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "status")
/*    */   public Boolean getStatus() {
/* 63 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Boolean status) {
/* 67 */     this.status = status;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 73 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 77 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 83 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 87 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Sample\MedicSampleDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */