/*    */ package nencer.app.Modules.Medic.Model.Location;
/*    */ public class LocationResponse { private int id;
/*    */   private String name;
/*    */   private String code;
/*    */   private String image;
/*    */   private String description;
/*    */   private String certificate;
/*    */   private String manager;
/*    */   
/* 10 */   public void setId(int id) { this.id = id; } private String address; private Integer cityId; private String countryCode; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setImage(String image) { this.image = image; } public void setDescription(String description) { this.description = description; } public void setCertificate(String certificate) { this.certificate = certificate; } public void setManager(String manager) { this.manager = manager; } public void setAddress(String address) { this.address = address; } public void setCityId(Integer cityId) { this.cityId = cityId; } public void setCountryCode(String countryCode) { this.countryCode = countryCode; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LocationResponse)) return false;  LocationResponse other = (LocationResponse)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$image = getImage(), other$image = other.getImage(); if ((this$image == null) ? (other$image != null) : !this$image.equals(other$image)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$certificate = getCertificate(), other$certificate = other.getCertificate(); if ((this$certificate == null) ? (other$certificate != null) : !this$certificate.equals(other$certificate)) return false;  Object this$manager = getManager(), other$manager = other.getManager(); if ((this$manager == null) ? (other$manager != null) : !this$manager.equals(other$manager)) return false;  Object this$address = getAddress(), other$address = other.getAddress(); if ((this$address == null) ? (other$address != null) : !this$address.equals(other$address)) return false;  Object this$cityId = getCityId(), other$cityId = other.getCityId(); if ((this$cityId == null) ? (other$cityId != null) : !this$cityId.equals(other$cityId)) return false;  Object this$countryCode = getCountryCode(), other$countryCode = other.getCountryCode(); if ((this$countryCode == null) ? (other$countryCode != null) : !this$countryCode.equals(other$countryCode)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof LocationResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $image = getImage(); result = result * 59 + (($image == null) ? 43 : $image.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $certificate = getCertificate(); result = result * 59 + (($certificate == null) ? 43 : $certificate.hashCode()); Object $manager = getManager(); result = result * 59 + (($manager == null) ? 43 : $manager.hashCode()); Object $address = getAddress(); result = result * 59 + (($address == null) ? 43 : $address.hashCode()); Object $cityId = getCityId(); result = result * 59 + (($cityId == null) ? 43 : $cityId.hashCode()); Object $countryCode = getCountryCode(); result = result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "LocationResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", image=" + getImage() + ", description=" + getDescription() + ", certificate=" + getCertificate() + ", manager=" + getManager() + ", address=" + getAddress() + ", cityId=" + getCityId() + ", countryCode=" + getCountryCode() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public LocationResponse() {} public LocationResponse(int id, String name, String code, String image, String description, String certificate, String manager, String address, Integer cityId, String countryCode, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) {
/* 12 */     this.id = id; this.name = name; this.code = code; this.image = image; this.description = description; this.certificate = certificate; this.manager = manager; this.address = address; this.cityId = cityId; this.countryCode = countryCode; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis;
/*    */   }
/* 14 */   public int getId() { return this.id; }
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getCode() { return this.code; }
/* 17 */   public String getImage() { return this.image; }
/* 18 */   public String getDescription() { return this.description; }
/* 19 */   public String getCertificate() { return this.certificate; }
/* 20 */   public String getManager() { return this.manager; }
/* 21 */   public String getAddress() { return this.address; }
/* 22 */   public Integer getCityId() { return this.cityId; }
/* 23 */   public String getCountryCode() { return this.countryCode; }
/* 24 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 25 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 30 */     if (this.updatedAt == null) return ""; 
/* 31 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 35 */     if (this.createdAt == null) return ""; 
/* 36 */     return ApiHelper.dateToString(this.createdAt);
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Location\LocationResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */