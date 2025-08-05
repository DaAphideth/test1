/*    */ package nencer.app.Modules.Medic.Model.TemplateService;
/*    */ 
/*    */ public class TemplateServiceResponse {
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   private String content;
/*    */   private String serviceId;
/*    */   
/* 10 */   public void setId(int id) { this.id = id; } private String creatorId; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public void setCode(String code) { this.code = code; } public void setName(String name) { this.name = name; } public void setContent(String content) { this.content = content; } public void setServiceId(String serviceId) { this.serviceId = serviceId; } public void setCreatorId(String creatorId) { this.creatorId = creatorId; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TemplateServiceResponse)) return false;  TemplateServiceResponse other = (TemplateServiceResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$content = getContent(), other$content = other.getContent(); if ((this$content == null) ? (other$content != null) : !this$content.equals(other$content)) return false;  Object this$serviceId = getServiceId(), other$serviceId = other.getServiceId(); if ((this$serviceId == null) ? (other$serviceId != null) : !this$serviceId.equals(other$serviceId)) return false;  Object this$creatorId = getCreatorId(), other$creatorId = other.getCreatorId(); if ((this$creatorId == null) ? (other$creatorId != null) : !this$creatorId.equals(other$creatorId)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof TemplateServiceResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $content = getContent(); result = result * 59 + (($content == null) ? 43 : $content.hashCode()); Object $serviceId = getServiceId(); result = result * 59 + (($serviceId == null) ? 43 : $serviceId.hashCode()); Object $creatorId = getCreatorId(); result = result * 59 + (($creatorId == null) ? 43 : $creatorId.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "TemplateServiceResponse(id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", content=" + getContent() + ", serviceId=" + getServiceId() + ", creatorId=" + getCreatorId() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; } public TemplateServiceResponse(int id, String code, String name, String content, String serviceId, String creatorId, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) {
/* 11 */     this.id = id; this.code = code; this.name = name; this.content = content; this.serviceId = serviceId; this.creatorId = creatorId; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis;
/*    */   }
/*    */   public TemplateServiceResponse() {}
/* 14 */   public int getId() { return this.id; }
/* 15 */   public String getCode() { return this.code; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getContent() { return this.content; }
/* 18 */   public String getServiceId() { return this.serviceId; }
/* 19 */   public String getCreatorId() { return this.creatorId; }
/* 20 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 21 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 26 */     if (this.updatedAt == null) return ""; 
/* 27 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 31 */     if (this.createdAt == null) return ""; 
/* 32 */     return ApiHelper.dateToString(this.createdAt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\TemplateService\TemplateServiceResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */