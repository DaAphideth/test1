/*     */ package nencer.app.Modules.Localization.Entity;
/*     */ import java.io.Serializable;
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
/*     */ @Table(name = "medic_unit")
/*     */ public class MedicUnit implements Serializable {
/*     */   private int id;
/*     */   private String name;
/*     */   private String key;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  24 */     return this.id;
/*     */   }
/*     */   private String type; private String description; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  28 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`name`")
/*     */   public String getName() {
/*  34 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  38 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`key`")
/*     */   public String getKey() {
/*  44 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/*  48 */     this.key = key;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/*  54 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  58 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "description")
/*     */   public String getDescription() {
/*  64 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  68 */     this.description = description;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  74 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  78 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/*  84 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/*  88 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  93 */     if (this == o) return true; 
/*  94 */     if (o == null || getClass() != o.getClass()) return false; 
/*  95 */     MedicUnit that = (MedicUnit)o;
/*  96 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.key, that.key) && Objects.equals(this.type, that.type) && Objects.equals(this.description, that.description) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.key, this.type, this.description, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Entity\MedicUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */