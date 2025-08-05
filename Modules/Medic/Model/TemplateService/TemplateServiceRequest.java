/*    */ package nencer.app.Modules.Medic.Model.TemplateService;
/*    */ public class TemplateServiceRequest {
/*    */   private String accessToken;
/*    */   private int id;
/*    */   private String code;
/*    */   private String name;
/*    */   
/*  8 */   public void setAccessToken(String accessToken) { this.accessToken = accessToken; } private String content; private String serviceId; private String creatorId; private Date createdAt; private Date updatedAt; public void setId(int id) { this.id = id; } public void setCode(String code) { this.code = code; } public void setName(String name) { this.name = name; } public void setContent(String content) { this.content = content; } public void setServiceId(String serviceId) { this.serviceId = serviceId; } public void setCreatorId(String creatorId) { this.creatorId = creatorId; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TemplateServiceRequest)) return false;  TemplateServiceRequest other = (TemplateServiceRequest)o; if (!other.canEqual(this)) return false;  Object this$accessToken = getAccessToken(), other$accessToken = other.getAccessToken(); if ((this$accessToken == null) ? (other$accessToken != null) : !this$accessToken.equals(other$accessToken)) return false;  if (getId() != other.getId()) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$content = getContent(), other$content = other.getContent(); if ((this$content == null) ? (other$content != null) : !this$content.equals(other$content)) return false;  Object this$serviceId = getServiceId(), other$serviceId = other.getServiceId(); if ((this$serviceId == null) ? (other$serviceId != null) : !this$serviceId.equals(other$serviceId)) return false;  Object this$creatorId = getCreatorId(), other$creatorId = other.getCreatorId(); if ((this$creatorId == null) ? (other$creatorId != null) : !this$creatorId.equals(other$creatorId)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); return !((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)); } protected boolean canEqual(Object other) { return other instanceof TemplateServiceRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $accessToken = getAccessToken(); result = result * 59 + (($accessToken == null) ? 43 : $accessToken.hashCode()); result = result * 59 + getId(); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $content = getContent(); result = result * 59 + (($content == null) ? 43 : $content.hashCode()); Object $serviceId = getServiceId(); result = result * 59 + (($serviceId == null) ? 43 : $serviceId.hashCode()); Object $creatorId = getCreatorId(); result = result * 59 + (($creatorId == null) ? 43 : $creatorId.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); return result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); } public String toString() { return "TemplateServiceRequest(accessToken=" + getAccessToken() + ", id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", content=" + getContent() + ", serviceId=" + getServiceId() + ", creatorId=" + getCreatorId() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ")"; } public TemplateServiceRequest(String accessToken, int id, String code, String name, String content, String serviceId, String creatorId, Date createdAt, Date updatedAt) {
/*  9 */     this.accessToken = accessToken; this.id = id; this.code = code; this.name = name; this.content = content; this.serviceId = serviceId; this.creatorId = creatorId; this.createdAt = createdAt; this.updatedAt = updatedAt;
/*    */   }
/*    */   public TemplateServiceRequest() {}
/* 12 */   public String getAccessToken() { return this.accessToken; }
/* 13 */   public int getId() { return this.id; }
/* 14 */   public String getCode() { return this.code; }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getContent() { return this.content; }
/* 17 */   public String getServiceId() { return this.serviceId; }
/* 18 */   public String getCreatorId() { return this.creatorId; }
/* 19 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 20 */     return this.updatedAt;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\TemplateService\TemplateServiceRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */