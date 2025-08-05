/*     */ package nencer.app.Modules.Medic.Entity.Room;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_room_types")
/*     */ public class MedicRoomTypes {
/*     */   private int id;
/*     */   private String name;
/*     */   private String nameArray;
/*     */   private String code;
/*     */   
/*     */   public String toString() {
/*  12 */     return "MedicRoomTypes(id=" + getId() + ", name=" + getName() + ", nameArray=" + getNameArray() + ", code=" + getCode() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")";
/*     */   } private Integer status; private Integer sort; private Date createdAt; private Date updatedAt; public MedicRoomTypes() {} public MedicRoomTypes(int id, String name, String nameArray, String code, Integer status, Integer sort, Date createdAt, Date updatedAt) {
/*  14 */     this.id = id; this.name = name; this.nameArray = nameArray; this.code = code; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  30 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  34 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  40 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  44 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_array")
/*     */   public String getNameArray() {
/*  50 */     return this.nameArray;
/*     */   }
/*     */   
/*     */   public void setNameArray(String nameArray) {
/*  54 */     this.nameArray = nameArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  60 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  64 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  70 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  74 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  80 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  84 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/*  90 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/*  94 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 100 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 104 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 109 */     if (this == o) return true; 
/* 110 */     if (o == null || getClass() != o.getClass()) return false; 
/* 111 */     MedicRoomTypes that = (MedicRoomTypes)o;
/* 112 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.nameArray, that.nameArray) && Objects.equals(this.code, that.code) && Objects.equals(this.status, that.status) && Objects.equals(this.sort, that.sort) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 117 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.nameArray, this.code, this.status, this.sort, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Room\MedicRoomTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */