/*    */ package nencer.app.Modules.Users.Model.Group;
/*    */ public class GroupPagingRequest { @NotNull(message = "Field pageIndex is required")
/*    */   private int pageIndex; @NotNull(message = "Field pageIndex is required")
/*    */   private int pageSize;
/*    */   private String fieldSort;
/*    */   
/*  7 */   public void setPageIndex(int pageIndex) { this.pageIndex = pageIndex; } private String direction; private String name; private String description; public void setPageSize(int pageSize) { this.pageSize = pageSize; } public void setFieldSort(String fieldSort) { this.fieldSort = fieldSort; } public void setDirection(String direction) { this.direction = direction; } public void setName(String name) { this.name = name; } public void setDescription(String description) { this.description = description; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GroupPagingRequest)) return false;  GroupPagingRequest other = (GroupPagingRequest)o; if (!other.canEqual(this)) return false;  if (getPageIndex() != other.getPageIndex()) return false;  if (getPageSize() != other.getPageSize()) return false;  Object this$fieldSort = getFieldSort(), other$fieldSort = other.getFieldSort(); if ((this$fieldSort == null) ? (other$fieldSort != null) : !this$fieldSort.equals(other$fieldSort)) return false;  Object this$direction = getDirection(), other$direction = other.getDirection(); if ((this$direction == null) ? (other$direction != null) : !this$direction.equals(other$direction)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); return !((this$description == null) ? (other$description != null) : !this$description.equals(other$description)); } protected boolean canEqual(Object other) { return other instanceof GroupPagingRequest; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getPageIndex(); result = result * 59 + getPageSize(); Object $fieldSort = getFieldSort(); result = result * 59 + (($fieldSort == null) ? 43 : $fieldSort.hashCode()); Object $direction = getDirection(); result = result * 59 + (($direction == null) ? 43 : $direction.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $description = getDescription(); return result * 59 + (($description == null) ? 43 : $description.hashCode()); } public String toString() { return "GroupPagingRequest(pageIndex=" + getPageIndex() + ", pageSize=" + getPageSize() + ", fieldSort=" + getFieldSort() + ", direction=" + getDirection() + ", name=" + getName() + ", description=" + getDescription() + ")"; }
/*    */   
/*    */   public int getPageIndex() {
/* 10 */     return this.pageIndex;
/*    */   }
/* 12 */   public int getPageSize() { return this.pageSize; }
/* 13 */   public String getFieldSort() { return this.fieldSort; }
/* 14 */   public String getDirection() { return this.direction; }
/* 15 */   public String getName() { return this.name; } public String getDescription() {
/* 16 */     return this.description;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Model\Group\GroupPagingRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */