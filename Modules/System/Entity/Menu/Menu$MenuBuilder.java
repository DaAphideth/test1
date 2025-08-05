/*    */ package nencer.app.Modules.System.Entity.Menu;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MenuBuilder {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String url;
/*    */   private String menuType;
/*    */   private Integer level;
/*    */   private Integer childrenCount;
/*    */   
/* 14 */   public MenuBuilder id(Integer id) { this.id = id; return this; } private Integer sortOrder; private Integer status; private String language; private Date createdAt; private Date updatedAt; private Menu parentId; private Set<Menu> children; public MenuBuilder name(String name) { this.name = name; return this; } public MenuBuilder url(String url) { this.url = url; return this; } public MenuBuilder menuType(String menuType) { this.menuType = menuType; return this; } public MenuBuilder level(Integer level) { this.level = level; return this; } public MenuBuilder childrenCount(Integer childrenCount) { this.childrenCount = childrenCount; return this; } public MenuBuilder sortOrder(Integer sortOrder) { this.sortOrder = sortOrder; return this; } public MenuBuilder status(Integer status) { this.status = status; return this; } public MenuBuilder language(String language) { this.language = language; return this; } public MenuBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MenuBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MenuBuilder parentId(Menu parentId) { this.parentId = parentId; return this; } public MenuBuilder children(Set<Menu> children) { this.children = children; return this; } public Menu build() { return new Menu(this.id, this.name, this.url, this.menuType, this.level, this.childrenCount, this.sortOrder, this.status, this.language, this.createdAt, this.updatedAt, this.parentId, this.children); } public String toString() { return "Menu.MenuBuilder(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", menuType=" + this.menuType + ", level=" + this.level + ", childrenCount=" + this.childrenCount + ", sortOrder=" + this.sortOrder + ", status=" + this.status + ", language=" + this.language + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", parentId=" + this.parentId + ", children=" + this.children + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\Menu\Menu$MenuBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */