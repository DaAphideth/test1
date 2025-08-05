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
/*    */ @Table(name = "medic_sample_template")
/*    */ public class MedicSampleTemplate {
/*    */   private int id;
/*    */   private Integer serviceId;
/*    */   private String name;
/*    */   private String code;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 24 */     return this.id;
/*    */   }
/*    */   private String content; private Boolean status; private Date createdAt; private Date updatedAt;
/*    */   public void setId(int id) {
/* 28 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "service_id")
/*    */   public Integer getServiceId() {
/* 34 */     return this.serviceId;
/*    */   }
/*    */   
/*    */   public void setServiceId(Integer serviceId) {
/* 38 */     this.serviceId = serviceId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 44 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 48 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 54 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 58 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "content")
/*    */   public String getContent() {
/* 64 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 68 */     this.content = content;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "status")
/*    */   public Boolean getStatus() {
/* 74 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Boolean status) {
/* 78 */     this.status = status;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 84 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 88 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 94 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 98 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Sample\MedicSampleTemplate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */