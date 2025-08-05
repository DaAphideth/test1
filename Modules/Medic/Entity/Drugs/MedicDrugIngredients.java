/*    */ package nencer.app.Modules.Medic.Entity.Drugs;
/*    */ import java.util.Date;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_drug_ingredients")
/*    */ public class MedicDrugIngredients {
/*    */   private int id;
/*    */   private String code;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   private String name; private Date createdAt; private Date updatedAt;
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 31 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 35 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 41 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 45 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 51 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 55 */     this.createdAt = createdAt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "updated_at")
/*    */   public Date getUpdatedAt() {
/* 61 */     return this.updatedAt;
/*    */   }
/*    */   
/*    */   public void setUpdatedAt(Date updatedAt) {
/* 65 */     this.updatedAt = updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 70 */     if (this == o) return true; 
/* 71 */     if (o == null || getClass() != o.getClass()) return false; 
/* 72 */     MedicDrugIngredients that = (MedicDrugIngredients)o;
/* 73 */     return (this.id == that.id && Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 78 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.code, this.name, this.createdAt, this.updatedAt });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Drugs\MedicDrugIngredients.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */