/*    */ package nencer.app.Modules.Users.Model.Group;
/*    */ 
/*    */ public class GroupResponseBuilder
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   private String description;
/*    */   private Integer status;
/*    */   private Integer hideit;
/*    */   private String createdAt;
/*    */   
/*    */   public GroupResponseBuilder id(Integer id) {
/* 14 */     this.id = id; return this; } public GroupResponseBuilder name(String name) { this.name = name; return this; } public GroupResponseBuilder code(String code) { this.code = code; return this; } public GroupResponseBuilder description(String description) { this.description = description; return this; } public GroupResponseBuilder status(Integer status) { this.status = status; return this; } public GroupResponseBuilder hideit(Integer hideit) { this.hideit = hideit; return this; } public GroupResponseBuilder createdAt(String createdAt) { this.createdAt = createdAt; return this; } public GroupResponse build() { return new GroupResponse(this.id, this.name, this.code, this.description, this.status, this.hideit, this.createdAt); } public String toString() { return "GroupResponse.GroupResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", description=" + this.description + ", status=" + this.status + ", hideit=" + this.hideit + ", createdAt=" + this.createdAt + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Group\GroupResponse$GroupResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */