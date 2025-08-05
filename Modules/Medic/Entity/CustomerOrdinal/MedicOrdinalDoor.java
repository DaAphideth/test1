/*    */ package nencer.app.Modules.Medic.Entity.CustomerOrdinal;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_ordinal_door")
/*    */ public class MedicOrdinalDoor {
/*    */   private int id;
/*    */   private String name;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   public int getId() {
/* 20 */     return this.id;
/*    */   }
/*    */   private String code; private Date createdAt;
/*    */   public void setId(int id) {
/* 24 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "name")
/*    */   public String getName() {
/* 30 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 34 */     this.name = name;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "code")
/*    */   public String getCode() {
/* 40 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 44 */     this.code = code;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "created_at")
/*    */   public Date getCreatedAt() {
/* 50 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(Date createdAt) {
/* 54 */     this.createdAt = createdAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 59 */     if (this == o) return true; 
/* 60 */     if (o == null || getClass() != o.getClass()) return false; 
/* 61 */     MedicOrdinalDoor that = (MedicOrdinalDoor)o;
/* 62 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.code, that.code) && Objects.equals(this.createdAt, that.createdAt));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 67 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, this.createdAt });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\CustomerOrdinal\MedicOrdinalDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */