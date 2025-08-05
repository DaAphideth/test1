/*    */ package nencer.app.Modules.Medic.Entity.Service;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_service_ticket_group", schema = "nencer_api", catalog = "")
/*    */ public class MedicServiceTicketGroup
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private String code;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   public int getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   private Integer status; private Integer sort; private Timestamp createdAt; private Timestamp updatedAt;
/*    */   public void setId(int id) {
/* 26 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 32 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 36 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 42 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 46 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "status")
/*    */   public Integer getStatus() {
/* 52 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Integer status) {
/* 56 */     this.status = status;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "sort")
/*    */   public Integer getSort() {
/* 62 */     return this.sort;
/*    */   }
/*    */   
/*    */   public void setSort(Integer sort) {
/* 66 */     this.sort = sort;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Timestamp getCreatedAt() {
/* 72 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Timestamp createdAt) {
/* 76 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Timestamp getUpdatedAt() {
/* 82 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Timestamp updatedAt) {
/* 86 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicServiceTicketGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */