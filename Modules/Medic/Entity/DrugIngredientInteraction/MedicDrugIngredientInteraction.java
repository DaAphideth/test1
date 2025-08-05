/*     */ package nencer.app.Modules.Medic.Entity.DrugIngredientInteraction;
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
/*     */ @Table(name = "medic_drug_ingredient_interaction")
/*     */ public class MedicDrugIngredientInteraction {
/*     */   private int id;
/*     */   private String codeIngredient;
/*     */   private String nameIngredient;
/*     */   private String degree;
/*     */   private String consequence;
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  25 */     return this.id;
/*     */   }
/*     */   private String handle; private String note; private String bibliography; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  29 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code_ingredient")
/*     */   public String getCodeIngredient() {
/*  35 */     return this.codeIngredient;
/*     */   }
/*     */   
/*     */   public void setCodeIngredient(String codeIngredient) {
/*  39 */     this.codeIngredient = codeIngredient;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_ingredient")
/*     */   public String getNameIngredient() {
/*  45 */     return this.nameIngredient;
/*     */   }
/*     */   
/*     */   public void setNameIngredient(String nameIngredient) {
/*  49 */     this.nameIngredient = nameIngredient;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "degree")
/*     */   public String getDegree() {
/*  55 */     return this.degree;
/*     */   }
/*     */   
/*     */   public void setDegree(String degree) {
/*  59 */     this.degree = degree;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "consequence")
/*     */   public String getConsequence() {
/*  65 */     return this.consequence;
/*     */   }
/*     */   
/*     */   public void setConsequence(String consequence) {
/*  69 */     this.consequence = consequence;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "handle")
/*     */   public String getHandle() {
/*  75 */     return this.handle;
/*     */   }
/*     */   
/*     */   public void setHandle(String handle) {
/*  79 */     this.handle = handle;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "note")
/*     */   public String getNote() {
/*  85 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/*  89 */     this.note = note;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "bibliography")
/*     */   public String getBibliography() {
/*  95 */     return this.bibliography;
/*     */   }
/*     */   
/*     */   public void setBibliography(String bibliography) {
/*  99 */     this.bibliography = bibliography;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 105 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 109 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 115 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 119 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 124 */     if (this == o) return true; 
/* 125 */     if (o == null || getClass() != o.getClass()) return false; 
/* 126 */     MedicDrugIngredientInteraction that = (MedicDrugIngredientInteraction)o;
/* 127 */     return (this.id == that.id && Objects.equals(this.codeIngredient, that.codeIngredient) && Objects.equals(this.nameIngredient, that.nameIngredient) && Objects.equals(this.degree, that.degree) && Objects.equals(this.consequence, that.consequence) && Objects.equals(this.handle, that.handle) && Objects.equals(this.note, that.note) && Objects.equals(this.bibliography, that.bibliography) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.codeIngredient, this.nameIngredient, this.degree, this.consequence, this.handle, this.note, this.bibliography, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\DrugIngredientInteraction\MedicDrugIngredientInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */