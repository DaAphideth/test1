/*     */ package nencer.app.Modules.Medic.Entity.TemplateService;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_template_service")
/*     */ public class MedicTemplateService
/*     */ {
/*     */   private int id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String content;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  26 */     return this.id;
/*     */   }
/*     */   private String serviceId; private String creatorId; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  30 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  36 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  40 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  46 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  50 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "content")
/*     */   public String getContent() {
/*  56 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/*  60 */     this.content = content;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_id")
/*     */   public String getServiceId() {
/*  66 */     return this.serviceId;
/*     */   }
/*     */   
/*     */   public void setServiceId(String serviceId) {
/*  70 */     this.serviceId = serviceId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "creator_id")
/*     */   public String getCreatorId() {
/*  76 */     return this.creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String creatorId) {
/*  80 */     this.creatorId = creatorId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  86 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  90 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/*  96 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 100 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 105 */     if (this == o) return true; 
/* 106 */     if (o == null || getClass() != o.getClass()) return false; 
/* 107 */     MedicTemplateService that = (MedicTemplateService)o;
/* 108 */     return (this.id == that.id && Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name) && Objects.equals(this.content, that.content) && Objects.equals(this.serviceId, that.serviceId) && Objects.equals(this.creatorId, that.creatorId) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.code, this.name, this.content, this.serviceId, this.creatorId, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TemplateService\MedicTemplateService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */