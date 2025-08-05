/*    */ package nencer.app.Modules.Users.Entity.Group;
/*    */ 
/*    */ 
/*    */ public class GroupsBuilder {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   private String description;
/*    */   private int status;
/*    */   private int hideit;
/*    */   private Integer sort;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   
/* 15 */   public GroupsBuilder id(Integer id) { this.id = id; return this; } public GroupsBuilder name(String name) { this.name = name; return this; } public GroupsBuilder code(String code) { this.code = code; return this; } public GroupsBuilder description(String description) { this.description = description; return this; } public GroupsBuilder status(int status) { this.status = status; return this; } public GroupsBuilder hideit(int hideit) { this.hideit = hideit; return this; } public GroupsBuilder sort(Integer sort) { this.sort = sort; return this; } public GroupsBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public GroupsBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public Groups build() { return new Groups(this.id, this.name, this.code, this.description, this.status, this.hideit, this.sort, this.createdAt, this.updatedAt); } public String toString() { return "Groups.GroupsBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", description=" + this.description + ", status=" + this.status + ", hideit=" + this.hideit + ", sort=" + this.sort + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\Group\Groups$GroupsBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */