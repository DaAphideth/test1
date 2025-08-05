/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ 
/*    */ public class OrdinalDoorResponse {
/*    */   private String id;
/*    */   private String name;
/*    */   private String code;
/*    */   private Date createdAt;
/*    */   private String createdAtDis;
/*    */   
/* 10 */   public void setId(String id) { this.id = id; } public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof OrdinalDoorResponse)) return false;  OrdinalDoorResponse other = (OrdinalDoorResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof OrdinalDoorResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "OrdinalDoorResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", createdAt=" + getCreatedAt() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public OrdinalDoorResponse() {}
/* 12 */   public OrdinalDoorResponse(String id, String name, String code, Date createdAt, String createdAtDis) { this.id = id; this.name = name; this.code = code; this.createdAt = createdAt; this.createdAtDis = createdAtDis; }
/* 13 */   public static OrdinalDoorResponseBuilder builder() { return new OrdinalDoorResponseBuilder(); } public static class OrdinalDoorResponseBuilder { private String id; private String name; public OrdinalDoorResponseBuilder id(String id) { this.id = id; return this; } private String code; private Date createdAt; private String createdAtDis; public OrdinalDoorResponseBuilder name(String name) { this.name = name; return this; } public OrdinalDoorResponseBuilder code(String code) { this.code = code; return this; } public OrdinalDoorResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public OrdinalDoorResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public OrdinalDoorResponse build() { return new OrdinalDoorResponse(this.id, this.name, this.code, this.createdAt, this.createdAtDis); } public String toString() { return "OrdinalDoorResponse.OrdinalDoorResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", createdAt=" + this.createdAt + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */      }
/* 15 */   public String getId() { return this.id; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getCode() { return this.code; } public Date getCreatedAt() {
/* 18 */     return this.createdAt;
/*    */   }
/*    */   public String getCreatedAtDis() {
/* 21 */     if (this.createdAt == null) return ""; 
/* 22 */     return ApiHelper.dateToString(this.createdAt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\OrdinalDoorResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */