/*    */ package nencer.app.Modules.Medic.Model.Location;
/*    */ public class LocationRequest {
/*    */   private Integer id;
/*    */   @NotNull(message = "804")
/*    */   private String name;
/*    */   private String code;
/*    */   private String image;
/*    */   private String description;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } private String certificate; private String manager; private String address; private Integer cityId; private String countryCode; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setImage(String image) { this.image = image; } public void setDescription(String description) { this.description = description; } public void setCertificate(String certificate) { this.certificate = certificate; } public void setManager(String manager) { this.manager = manager; } public void setAddress(String address) { this.address = address; } public void setCityId(Integer cityId) { this.cityId = cityId; } public void setCountryCode(String countryCode) { this.countryCode = countryCode; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof LocationRequest)) return false;  LocationRequest other = (LocationRequest)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$image = getImage(), other$image = other.getImage(); if ((this$image == null) ? (other$image != null) : !this$image.equals(other$image)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$certificate = getCertificate(), other$certificate = other.getCertificate(); if ((this$certificate == null) ? (other$certificate != null) : !this$certificate.equals(other$certificate)) return false;  Object this$manager = getManager(), other$manager = other.getManager(); if ((this$manager == null) ? (other$manager != null) : !this$manager.equals(other$manager)) return false;  Object this$address = getAddress(), other$address = other.getAddress(); if ((this$address == null) ? (other$address != null) : !this$address.equals(other$address)) return false;  Object this$cityId = getCityId(), other$cityId = other.getCityId(); if ((this$cityId == null) ? (other$cityId != null) : !this$cityId.equals(other$cityId)) return false;  Object this$countryCode = getCountryCode(), other$countryCode = other.getCountryCode(); return !((this$countryCode == null) ? (other$countryCode != null) : !this$countryCode.equals(other$countryCode)); } protected boolean canEqual(Object other) { return other instanceof LocationRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $image = getImage(); result = result * 59 + (($image == null) ? 43 : $image.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $certificate = getCertificate(); result = result * 59 + (($certificate == null) ? 43 : $certificate.hashCode()); Object $manager = getManager(); result = result * 59 + (($manager == null) ? 43 : $manager.hashCode()); Object $address = getAddress(); result = result * 59 + (($address == null) ? 43 : $address.hashCode()); Object $cityId = getCityId(); result = result * 59 + (($cityId == null) ? 43 : $cityId.hashCode()); Object $countryCode = getCountryCode(); return result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode()); } public String toString() { return "LocationRequest(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", image=" + getImage() + ", description=" + getDescription() + ", certificate=" + getCertificate() + ", manager=" + getManager() + ", address=" + getAddress() + ", cityId=" + getCityId() + ", countryCode=" + getCountryCode() + ")"; }
/*    */    public LocationRequest() {} public LocationRequest(Integer id, String name, String code, String image, String description, String certificate, String manager, String address, Integer cityId, String countryCode) {
/* 12 */     this.id = id; this.name = name; this.code = code; this.image = image; this.description = description; this.certificate = certificate; this.manager = manager; this.address = address; this.cityId = cityId; this.countryCode = countryCode;
/*    */   } public Integer getId() {
/* 14 */     return this.id;
/*    */   }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getCode() { return this.code; }
/* 18 */   public String getImage() { return this.image; }
/* 19 */   public String getDescription() { return this.description; }
/* 20 */   public String getCertificate() { return this.certificate; }
/* 21 */   public String getManager() { return this.manager; }
/* 22 */   public String getAddress() { return this.address; }
/* 23 */   public Integer getCityId() { return this.cityId; } public String getCountryCode() {
/* 24 */     return this.countryCode;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Location\LocationRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */