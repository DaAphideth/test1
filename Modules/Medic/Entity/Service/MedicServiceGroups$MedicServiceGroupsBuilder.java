/*    */ package nencer.app.Modules.Medic.Entity.Service;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MedicServiceGroupsBuilder
/*    */ {
/*    */   private int id;
/*    */   private Integer code;
/*    */   private String codeName;
/*    */   private String name;
/*    */   private Integer status;
/*    */   private Integer sort;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   
/*    */   public MedicServiceGroupsBuilder id(int id) {
/* 20 */     this.id = id; return this; } public MedicServiceGroupsBuilder code(Integer code) { this.code = code; return this; } public MedicServiceGroupsBuilder codeName(String codeName) { this.codeName = codeName; return this; } public MedicServiceGroupsBuilder name(String name) { this.name = name; return this; } public MedicServiceGroupsBuilder status(Integer status) { this.status = status; return this; } public MedicServiceGroupsBuilder sort(Integer sort) { this.sort = sort; return this; } public MedicServiceGroupsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MedicServiceGroupsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MedicServiceGroups build() { return new MedicServiceGroups(this.id, this.code, this.codeName, this.name, this.status, this.sort, this.createdAt, this.updatedAt); } public String toString() { return "MedicServiceGroups.MedicServiceGroupsBuilder(id=" + this.id + ", code=" + this.code + ", codeName=" + this.codeName + ", name=" + this.name + ", status=" + this.status + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Entity\Service\MedicServiceGroups$MedicServiceGroupsBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */