/*    */ package nencer.app.Modules.Medic.Entity.TestCode;
/*    */ import java.util.Objects;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Transient;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_test_device")
/*    */ public class MedicTestDevice {
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   private String type; private String desc; private String status; private Integer totalRecord;
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
/*    */   @Column(name = "type")
/*    */   public String getType() {
/* 51 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 55 */     this.type = type;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "`desc`")
/*    */   public String getDesc() {
/* 61 */     return this.desc;
/*    */   }
/*    */   
/*    */   public void setDesc(String desc) {
/* 65 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "status")
/*    */   public String getStatus() {
/* 71 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 75 */     this.status = status;
/*    */   }
/*    */   
/*    */   @Transient
/*    */   public Integer getTotalRecord() {
/* 80 */     return this.totalRecord;
/*    */   }
/*    */   
/*    */   public void setTotalRecord(Integer totalRecord) {
/* 84 */     this.totalRecord = totalRecord;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 89 */     if (this == o) return true; 
/* 90 */     if (o == null || getClass() != o.getClass()) return false; 
/* 91 */     MedicTestDevice that = (MedicTestDevice)o;
/* 92 */     return (this.id == that.id && Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name) && Objects.equals(this.type, that.type) && Objects.equals(this.desc, that.desc) && Objects.equals(this.status, that.status));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 97 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.code, this.name, this.type, this.desc, this.status });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\TestCode\MedicTestDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */