/*    */ package nencer.app.Modules.Medic.Entity.Room;
/*    */ import java.util.Set;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "medic_chamber")
/*    */ public class MedicChamber {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   public Integer getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   private Integer roomId; private String roomName; private Set<MedicBed> medicBeds;
/*    */   public void setId(Integer id) {
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
/*    */   @Column(name = "room_id")
/*    */   public Integer getRoomId() {
/* 52 */     return this.roomId;
/*    */   }
/*    */   
/*    */   public void setRoomId(Integer roomId) {
/* 56 */     this.roomId = roomId;
/*    */   }
/*    */   
/*    */   @Basic
/*    */   @Column(name = "room_name")
/*    */   public String getRoomName() {
/* 62 */     return this.roomName;
/*    */   }
/*    */   
/*    */   public void setRoomName(String roomName) {
/* 66 */     this.roomName = roomName;
/*    */   }
/*    */   
/*    */   @OneToMany
/*    */   @JoinColumn(name = "chamber_id", updatable = false, insertable = false)
/*    */   public Set<MedicBed> getMedicBeds() {
/* 72 */     return this.medicBeds;
/*    */   }
/*    */   
/*    */   public void setMedicBeds(Set<MedicBed> medicBeds) {
/* 76 */     this.medicBeds = medicBeds;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicChamber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */