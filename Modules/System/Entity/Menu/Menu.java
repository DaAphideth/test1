/*     */ package nencer.app.Modules.System.Entity.Menu;@Table(name = "menu")
/*     */ @Entity
/*     */ public class Menu implements Serializable {
/*     */   private Integer id;
/*     */   private String name;
/*     */   private String url;
/*     */   private String menuType;
/*     */   private Integer level;
/*     */   private Integer childrenCount;
/*     */   
/*     */   public Menu(Integer id, String name, String url, String menuType, Integer level, Integer childrenCount, Integer sortOrder, Integer status, String language, Date createdAt, Date updatedAt, Menu parentId, Set<Menu> children) {
/*  12 */     this.id = id; this.name = name; this.url = url; this.menuType = menuType; this.level = level; this.childrenCount = childrenCount; this.sortOrder = sortOrder; this.status = status; this.language = language; this.createdAt = createdAt; this.updatedAt = updatedAt; this.parentId = parentId; this.children = children;
/*     */   } private Integer sortOrder; private Integer status; private String language; private Date createdAt; private Date updatedAt; private Menu parentId; private Set<Menu> children; public Menu() {} public static MenuBuilder builder() {
/*  14 */     return new MenuBuilder(); } public static class MenuBuilder { private Integer id; private String name; private String url; private String menuType; private Integer level; private Integer childrenCount; private Integer sortOrder; private Integer status; private String language; private Date createdAt; private Date updatedAt; private Menu parentId; private Set<Menu> children; public MenuBuilder id(Integer id) { this.id = id; return this; } public MenuBuilder name(String name) { this.name = name; return this; } public MenuBuilder url(String url) { this.url = url; return this; } public MenuBuilder menuType(String menuType) { this.menuType = menuType; return this; } public MenuBuilder level(Integer level) { this.level = level; return this; } public MenuBuilder childrenCount(Integer childrenCount) { this.childrenCount = childrenCount; return this; } public MenuBuilder sortOrder(Integer sortOrder) { this.sortOrder = sortOrder; return this; } public MenuBuilder status(Integer status) { this.status = status; return this; } public MenuBuilder language(String language) { this.language = language; return this; } public MenuBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public MenuBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public MenuBuilder parentId(Menu parentId) { this.parentId = parentId; return this; } public MenuBuilder children(Set<Menu> children) { this.children = children; return this; } public Menu build() { return new Menu(this.id, this.name, this.url, this.menuType, this.level, this.childrenCount, this.sortOrder, this.status, this.language, this.createdAt, this.updatedAt, this.parentId, this.children); } public String toString() { return "Menu.MenuBuilder(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", menuType=" + this.menuType + ", level=" + this.level + ", childrenCount=" + this.childrenCount + ", sortOrder=" + this.sortOrder + ", status=" + this.status + ", language=" + this.language + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", parentId=" + this.parentId + ", children=" + this.children + ")"; }
/*     */      }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   public Integer getId() {
/*  35 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  39 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   @NotNull
/*     */   public String getName() {
/*  46 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  50 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "url")
/*     */   @NotNull
/*     */   public String getUrl() {
/*  57 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/*  61 */     this.url = url;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "menu_type")
/*     */   public String getMenuType() {
/*  67 */     return this.menuType;
/*     */   }
/*     */   
/*     */   public void setMenuType(String menuType) {
/*  71 */     this.menuType = menuType;
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
/*     */   @Basic
/*     */   @Column(name = "level")
/*     */   public Integer getLevel() {
/*  87 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(Integer level) {
/*  91 */     this.level = level;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "children_count")
/*     */   public Integer getChildrenCount() {
/*  97 */     return this.childrenCount;
/*     */   }
/*     */   
/*     */   public void setChildrenCount(Integer childrenCount) {
/* 101 */     this.childrenCount = childrenCount;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort_order")
/*     */   public Integer getSortOrder() {
/* 107 */     return this.sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer sortOrder) {
/* 111 */     this.sortOrder = sortOrder;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public Integer getStatus() {
/* 117 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 121 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "language")
/*     */   public String getLanguage() {
/* 127 */     return this.language;
/*     */   }
/*     */   
/*     */   public void setLanguage(String language) {
/* 131 */     this.language = language;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 137 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 141 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 147 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 151 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @OneToOne
/*     */   @JoinColumn(name = "`parent_id`")
/*     */   public Menu getParentId() {
/* 157 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(Menu parentId) {
/* 161 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   @OneToMany(mappedBy = "parentId", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
/*     */   public Set<Menu> getChildren() {
/* 166 */     return this.children;
/*     */   }
/*     */   
/*     */   public void setChildren(Set<Menu> children) {
/* 170 */     this.children = children;
/*     */   }
/*     */   
/*     */   public void addChild(Menu children) {
/* 174 */     this.children.add(children);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\Menu\Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */