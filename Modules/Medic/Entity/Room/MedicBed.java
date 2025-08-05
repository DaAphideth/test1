/*    */ package nencer.app.Modules.Medic.Entity.Room;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_bed")
/*    */ public class MedicBed {
/*    */   private Integer id;
/*    */   private String name;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public Integer getId() {
/* 20 */     return this.id;
/*    */   }
/*    */   private String code; private String codeBhyt; private Integer chamberId;
/*    */   public void setId(Integer id) {
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
/*    */   @Column(name = "code_bhyt")
/*    */   public String getCodeBhyt() {
/* 50 */     return this.codeBhyt;
/*    */   }
/*    */   
/*    */   public void setCodeBhyt(String codeBhyt) {
/* 54 */     this.codeBhyt = codeBhyt;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "chamber_id")
/*    */   public Integer getChamberId() {
/* 60 */     return this.chamberId;
/*    */   }
/*    */   
/*    */   public void setChamberId(Integer chamberId) {
/* 64 */     this.chamberId = chamberId;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicBed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */