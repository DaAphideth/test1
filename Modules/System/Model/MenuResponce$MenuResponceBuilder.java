/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class MenuResponceBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String url;
/*    */   private String menuType;
/*    */   private Integer level;
/*    */   private Integer childrenCount;
/*    */   private Integer sortOrder;
/*    */   
/* 14 */   public MenuResponceBuilder id(int id) { this.id = id; return this; } private Integer status; private String language; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; private MenuResponce parentId; public MenuResponceBuilder name(String name) { this.name = name; return this; } public MenuResponceBuilder url(String url) { this.url = url; return this; } public MenuResponceBuilder menuType(String menuType) { this.menuType = menuType; return this; } public MenuResponceBuilder level(Integer level) { this.level = level; return this; } public MenuResponceBuilder childrenCount(Integer childrenCount) { this.childrenCount = childrenCount; return this; } public MenuResponceBuilder sortOrder(Integer sortOrder) { this.sortOrder = sortOrder; return this; } public MenuResponceBuilder status(Integer status) { this.status = status; return this; } public MenuResponceBuilder language(String language) { this.language = language; return this; } public MenuResponceBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MenuResponceBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MenuResponceBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public MenuResponceBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public MenuResponceBuilder parentId(MenuResponce parentId) { this.parentId = parentId; return this; } public MenuResponce build() { return new MenuResponce(this.id, this.name, this.url, this.menuType, this.level, this.childrenCount, this.sortOrder, this.status, this.language, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis, this.parentId); } public String toString() { return "MenuResponce.MenuResponceBuilder(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", menuType=" + this.menuType + ", level=" + this.level + ", childrenCount=" + this.childrenCount + ", sortOrder=" + this.sortOrder + ", status=" + this.status + ", language=" + this.language + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ", parentId=" + this.parentId + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\MenuResponce$MenuResponceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */