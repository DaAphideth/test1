/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MenuChildrenResponceBuilder {
/*    */   private int id;
/*    */   private String name;
/*    */   private String url;
/*    */   private String menuType;
/*    */   private Integer level;
/*    */   private Integer childrenCount;
/*    */   private Integer sortOrder;
/*    */   
/* 15 */   public MenuChildrenResponceBuilder id(int id) { this.id = id; return this; } private Integer status; private String language; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; private Set<MenuChildrenResponce> children; public MenuChildrenResponceBuilder name(String name) { this.name = name; return this; } public MenuChildrenResponceBuilder url(String url) { this.url = url; return this; } public MenuChildrenResponceBuilder menuType(String menuType) { this.menuType = menuType; return this; } public MenuChildrenResponceBuilder level(Integer level) { this.level = level; return this; } public MenuChildrenResponceBuilder childrenCount(Integer childrenCount) { this.childrenCount = childrenCount; return this; } public MenuChildrenResponceBuilder sortOrder(Integer sortOrder) { this.sortOrder = sortOrder; return this; } public MenuChildrenResponceBuilder status(Integer status) { this.status = status; return this; } public MenuChildrenResponceBuilder language(String language) { this.language = language; return this; } public MenuChildrenResponceBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MenuChildrenResponceBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MenuChildrenResponceBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public MenuChildrenResponceBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public MenuChildrenResponceBuilder children(Set<MenuChildrenResponce> children) { this.children = children; return this; } public MenuChildrenResponce build() { return new MenuChildrenResponce(this.id, this.name, this.url, this.menuType, this.level, this.childrenCount, this.sortOrder, this.status, this.language, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis, this.children); } public String toString() { return "MenuChildrenResponce.MenuChildrenResponceBuilder(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", menuType=" + this.menuType + ", level=" + this.level + ", childrenCount=" + this.childrenCount + ", sortOrder=" + this.sortOrder + ", status=" + this.status + ", language=" + this.language + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ", children=" + this.children + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\MenuChildrenResponce$MenuChildrenResponceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */