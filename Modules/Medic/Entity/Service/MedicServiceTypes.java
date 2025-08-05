/*     */ package nencer.app.Modules.Medic.Entity.Service;
/*     */ import java.util.Date;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "medic_service_types")
/*     */ public class MedicServiceTypes implements Serializable {
/*     */   private int id;
/*     */   private String name;
/*     */   private String nameArray;
/*     */   private Integer serviceGroupId;
/*     */   private String code;
/*     */   
/*     */   public String toString() {
/*  14 */     return "MedicServiceTypes(id=" + getId() + ", name=" + getName() + ", nameArray=" + getNameArray() + ", serviceGroupId=" + getServiceGroupId() + ", code=" + getCode() + ", status=" + getStatus() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", serviceGroup=" + getServiceGroup() + ")";
/*     */   } private Integer status; private Integer sort; private Date createdAt; private Date updatedAt; public MedicServiceGroups serviceGroup; public MedicServiceTypes() {} public MedicServiceTypes(int id, String name, String nameArray, Integer serviceGroupId, String code, Integer status, Integer sort, Date createdAt, Date updatedAt, MedicServiceGroups serviceGroup) {
/*  16 */     this.id = id; this.name = name; this.nameArray = nameArray; this.serviceGroupId = serviceGroupId; this.code = code; this.status = status; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.serviceGroup = serviceGroup;
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
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  33 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  37 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  43 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  47 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name_array")
/*     */   public String getNameArray() {
/*  53 */     return this.nameArray;
/*     */   }
/*     */   
/*     */   public void setNameArray(String nameArray) {
/*  57 */     this.nameArray = nameArray;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "service_group_id")
/*     */   public Integer getServiceGroupId() {
/*  63 */     return this.serviceGroupId;
/*     */   }
/*     */   
/*     */   public void setServiceGroupId(Integer serviceGroupId) {
/*  67 */     this.serviceGroupId = serviceGroupId;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  74 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  78 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/*  84 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  88 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public Integer getSort() {
/*  94 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/*  98 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 104 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 108 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 114 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 118 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = true)
/*     */   @JoinColumn(name = "service_group_id", nullable = true, updatable = false, insertable = false)
/*     */   public MedicServiceGroups getServiceGroup() {
/* 124 */     return this.serviceGroup;
/*     */   }
/*     */   
/*     */   public void setServiceGroup(MedicServiceGroups serviceGroup) {
/* 128 */     this.serviceGroup = serviceGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 135 */     if (this == o) return true; 
/* 136 */     if (o == null || getClass() != o.getClass()) return false; 
/* 137 */     MedicServiceTypes that = (MedicServiceTypes)o;
/* 138 */     return (this.id == that.id && Objects.equals(this.name, that.name) && Objects.equals(this.nameArray, that.nameArray) && Objects.equals(this.serviceGroupId, that.serviceGroupId) && Objects.equals(this.code, that.code) && Objects.equals(this.status, that.status) && Objects.equals(this.sort, that.sort) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 143 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.nameArray, this.serviceGroupId, this.code, this.status, this.sort, this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicServiceTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */