/*     */ package nencer.app.Modules.Customer.Entity;
/*     */ @Entity
/*     */ @Table(name = "customers")
/*     */ public class Customers implements Serializable { private int id; private String name; private String phone;
/*     */   private String idCardType;
/*     */   private String patientNumber;
/*     */   private String idCard;
/*     */   private Date issueDate;
/*     */   private String email;
/*     */   private String type;
/*     */   private String gender;
/*     */   private String dayBorn;
/*     */   private String monthBorn;
/*     */   private String yearBorn;
/*     */   private Date birthday;
/*     */   private String lang;
/*     */   private String city;
/*     */   private String countryCode;
/*     */   private String nationality;
/*     */   
/*  21 */   public static CustomersBuilder builder() { return new CustomersBuilder(); } private String address; private String customerWards; private LocalWards localWards; private String customerDistrict; private LocalDistricts localDistricts; private String customerProvince; private LocalProvinces localProvinces; private String postCode; private String ethnic; private String detailObject; private String address2; private String jobTitle; private Integer userId; @CreatedDate private Date createdAt; @LastModifiedDate private Date updatedAt; private String checkinLevel; private String poisition; private String checkinUnit; public static class CustomersBuilder { private int id; private String name; private String phone; private String idCardType; private String patientNumber; private String idCard; private Date issueDate; private String email; private String type; private String gender; private String dayBorn; private String monthBorn; private String yearBorn; private Date birthday; private String lang; private String city; private String countryCode; private String nationality; private String address; private String customerWards; private LocalWards localWards; private String customerDistrict; private LocalDistricts localDistricts; private String customerProvince; private LocalProvinces localProvinces; private String postCode; private String ethnic; private String detailObject; private String address2; private String jobTitle; private Integer userId; private Date createdAt; private Date updatedAt; private String checkinLevel; private String poisition; private String checkinUnit; public CustomersBuilder id(int id) { this.id = id; return this; } public CustomersBuilder name(String name) { this.name = name; return this; } public CustomersBuilder phone(String phone) { this.phone = phone; return this; } public CustomersBuilder idCardType(String idCardType) { this.idCardType = idCardType; return this; } public CustomersBuilder patientNumber(String patientNumber) { this.patientNumber = patientNumber; return this; } public CustomersBuilder idCard(String idCard) { this.idCard = idCard; return this; } public CustomersBuilder issueDate(Date issueDate) { this.issueDate = issueDate; return this; } public CustomersBuilder email(String email) { this.email = email; return this; } public CustomersBuilder type(String type) { this.type = type; return this; } public CustomersBuilder gender(String gender) { this.gender = gender; return this; } public CustomersBuilder dayBorn(String dayBorn) { this.dayBorn = dayBorn; return this; } public CustomersBuilder monthBorn(String monthBorn) { this.monthBorn = monthBorn; return this; } public CustomersBuilder yearBorn(String yearBorn) { this.yearBorn = yearBorn; return this; } public CustomersBuilder birthday(Date birthday) { this.birthday = birthday; return this; } public CustomersBuilder lang(String lang) { this.lang = lang; return this; } public CustomersBuilder city(String city) { this.city = city; return this; } public CustomersBuilder countryCode(String countryCode) { this.countryCode = countryCode; return this; } public CustomersBuilder nationality(String nationality) { this.nationality = nationality; return this; } public CustomersBuilder address(String address) { this.address = address; return this; } public CustomersBuilder customerWards(String customerWards) { this.customerWards = customerWards; return this; } public CustomersBuilder localWards(LocalWards localWards) { this.localWards = localWards; return this; } public CustomersBuilder customerDistrict(String customerDistrict) { this.customerDistrict = customerDistrict; return this; } public CustomersBuilder localDistricts(LocalDistricts localDistricts) { this.localDistricts = localDistricts; return this; } public CustomersBuilder customerProvince(String customerProvince) { this.customerProvince = customerProvince; return this; } public CustomersBuilder localProvinces(LocalProvinces localProvinces) { this.localProvinces = localProvinces; return this; } public CustomersBuilder postCode(String postCode) { this.postCode = postCode; return this; } public CustomersBuilder ethnic(String ethnic) { this.ethnic = ethnic; return this; } public CustomersBuilder detailObject(String detailObject) { this.detailObject = detailObject; return this; } public CustomersBuilder address2(String address2) { this.address2 = address2; return this; } public CustomersBuilder jobTitle(String jobTitle) { this.jobTitle = jobTitle; return this; } public CustomersBuilder userId(Integer userId) { this.userId = userId; return this; } public CustomersBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public CustomersBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public CustomersBuilder checkinLevel(String checkinLevel) { this.checkinLevel = checkinLevel; return this; } public CustomersBuilder poisition(String poisition) { this.poisition = poisition; return this; } public CustomersBuilder checkinUnit(String checkinUnit) { this.checkinUnit = checkinUnit; return this; } public Customers build() { return new Customers(this.id, this.name, this.phone, this.idCardType, this.patientNumber, this.idCard, this.issueDate, this.email, this.type, this.gender, this.dayBorn, this.monthBorn, this.yearBorn, this.birthday, this.lang, this.city, this.countryCode, this.nationality, this.address, this.customerWards, this.localWards, this.customerDistrict, this.localDistricts, this.customerProvince, this.localProvinces, this.postCode, this.ethnic, this.detailObject, this.address2, this.jobTitle, this.userId, this.createdAt, this.updatedAt, this.checkinLevel, this.poisition, this.checkinUnit); } public String toString() { return "Customers.CustomersBuilder(id=" + this.id + ", name=" + this.name + ", phone=" + this.phone + ", idCardType=" + this.idCardType + ", patientNumber=" + this.patientNumber + ", idCard=" + this.idCard + ", issueDate=" + this.issueDate + ", email=" + this.email + ", type=" + this.type + ", gender=" + this.gender + ", dayBorn=" + this.dayBorn + ", monthBorn=" + this.monthBorn + ", yearBorn=" + this.yearBorn + ", birthday=" + this.birthday + ", lang=" + this.lang + ", city=" + this.city + ", countryCode=" + this.countryCode + ", nationality=" + this.nationality + ", address=" + this.address + ", customerWards=" + this.customerWards + ", localWards=" + this.localWards + ", customerDistrict=" + this.customerDistrict + ", localDistricts=" + this.localDistricts + ", customerProvince=" + this.customerProvince + ", localProvinces=" + this.localProvinces + ", postCode=" + this.postCode + ", ethnic=" + this.ethnic + ", detailObject=" + this.detailObject + ", address2=" + this.address2 + ", jobTitle=" + this.jobTitle + ", userId=" + this.userId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", checkinLevel=" + this.checkinLevel + ", poisition=" + this.poisition + ", checkinUnit=" + this.checkinUnit + ")"; } }
/*  22 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof Customers)) return false;  Customers other = (Customers)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$phone = getPhone(), other$phone = other.getPhone(); if ((this$phone == null) ? (other$phone != null) : !this$phone.equals(other$phone)) return false;  Object this$idCardType = getIdCardType(), other$idCardType = other.getIdCardType(); if ((this$idCardType == null) ? (other$idCardType != null) : !this$idCardType.equals(other$idCardType)) return false;  Object this$patientNumber = getPatientNumber(), other$patientNumber = other.getPatientNumber(); if ((this$patientNumber == null) ? (other$patientNumber != null) : !this$patientNumber.equals(other$patientNumber)) return false;  Object this$idCard = getIdCard(), other$idCard = other.getIdCard(); if ((this$idCard == null) ? (other$idCard != null) : !this$idCard.equals(other$idCard)) return false;  Object this$issueDate = getIssueDate(), other$issueDate = other.getIssueDate(); if ((this$issueDate == null) ? (other$issueDate != null) : !this$issueDate.equals(other$issueDate)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$type = getType(), other$type = other.getType(); if ((this$type == null) ? (other$type != null) : !this$type.equals(other$type)) return false;  Object this$gender = getGender(), other$gender = other.getGender(); if ((this$gender == null) ? (other$gender != null) : !this$gender.equals(other$gender)) return false;  Object this$dayBorn = getDayBorn(), other$dayBorn = other.getDayBorn(); if ((this$dayBorn == null) ? (other$dayBorn != null) : !this$dayBorn.equals(other$dayBorn)) return false;  Object this$monthBorn = getMonthBorn(), other$monthBorn = other.getMonthBorn(); if ((this$monthBorn == null) ? (other$monthBorn != null) : !this$monthBorn.equals(other$monthBorn)) return false;  Object this$yearBorn = getYearBorn(), other$yearBorn = other.getYearBorn(); if ((this$yearBorn == null) ? (other$yearBorn != null) : !this$yearBorn.equals(other$yearBorn)) return false;  Object this$birthday = getBirthday(), other$birthday = other.getBirthday(); if ((this$birthday == null) ? (other$birthday != null) : !this$birthday.equals(other$birthday)) return false;  Object this$lang = getLang(), other$lang = other.getLang(); if ((this$lang == null) ? (other$lang != null) : !this$lang.equals(other$lang)) return false;  Object this$city = getCity(), other$city = other.getCity(); if ((this$city == null) ? (other$city != null) : !this$city.equals(other$city)) return false;  Object this$countryCode = getCountryCode(), other$countryCode = other.getCountryCode(); if ((this$countryCode == null) ? (other$countryCode != null) : !this$countryCode.equals(other$countryCode)) return false;  Object this$nationality = getNationality(), other$nationality = other.getNationality(); if ((this$nationality == null) ? (other$nationality != null) : !this$nationality.equals(other$nationality)) return false;  Object this$address = getAddress(), other$address = other.getAddress(); if ((this$address == null) ? (other$address != null) : !this$address.equals(other$address)) return false;  Object this$customerWards = getCustomerWards(), other$customerWards = other.getCustomerWards(); if ((this$customerWards == null) ? (other$customerWards != null) : !this$customerWards.equals(other$customerWards)) return false;  Object this$localWards = getLocalWards(), other$localWards = other.getLocalWards(); if ((this$localWards == null) ? (other$localWards != null) : !this$localWards.equals(other$localWards)) return false;  Object this$customerDistrict = getCustomerDistrict(), other$customerDistrict = other.getCustomerDistrict(); if ((this$customerDistrict == null) ? (other$customerDistrict != null) : !this$customerDistrict.equals(other$customerDistrict)) return false;  Object this$localDistricts = getLocalDistricts(), other$localDistricts = other.getLocalDistricts(); if ((this$localDistricts == null) ? (other$localDistricts != null) : !this$localDistricts.equals(other$localDistricts)) return false;  Object this$customerProvince = getCustomerProvince(), other$customerProvince = other.getCustomerProvince(); if ((this$customerProvince == null) ? (other$customerProvince != null) : !this$customerProvince.equals(other$customerProvince)) return false;  Object this$localProvinces = getLocalProvinces(), other$localProvinces = other.getLocalProvinces(); if ((this$localProvinces == null) ? (other$localProvinces != null) : !this$localProvinces.equals(other$localProvinces)) return false;  Object this$postCode = getPostCode(), other$postCode = other.getPostCode(); if ((this$postCode == null) ? (other$postCode != null) : !this$postCode.equals(other$postCode)) return false;  Object this$ethnic = getEthnic(), other$ethnic = other.getEthnic(); if ((this$ethnic == null) ? (other$ethnic != null) : !this$ethnic.equals(other$ethnic)) return false;  Object this$detailObject = getDetailObject(), other$detailObject = other.getDetailObject(); if ((this$detailObject == null) ? (other$detailObject != null) : !this$detailObject.equals(other$detailObject)) return false;  Object this$address2 = getAddress2(), other$address2 = other.getAddress2(); if ((this$address2 == null) ? (other$address2 != null) : !this$address2.equals(other$address2)) return false;  Object this$jobTitle = getJobTitle(), other$jobTitle = other.getJobTitle(); if ((this$jobTitle == null) ? (other$jobTitle != null) : !this$jobTitle.equals(other$jobTitle)) return false;  Object this$userId = getUserId(), other$userId = other.getUserId(); if ((this$userId == null) ? (other$userId != null) : !this$userId.equals(other$userId)) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$checkinLevel = getCheckinLevel(), other$checkinLevel = other.getCheckinLevel(); if ((this$checkinLevel == null) ? (other$checkinLevel != null) : !this$checkinLevel.equals(other$checkinLevel)) return false;  Object this$poisition = getPoisition(), other$poisition = other.getPoisition(); if ((this$poisition == null) ? (other$poisition != null) : !this$poisition.equals(other$poisition)) return false;  Object this$checkinUnit = getCheckinUnit(), other$checkinUnit = other.getCheckinUnit(); return !((this$checkinUnit == null) ? (other$checkinUnit != null) : !this$checkinUnit.equals(other$checkinUnit)); } protected boolean canEqual(Object other) { return other instanceof Customers; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $phone = getPhone(); result = result * 59 + (($phone == null) ? 43 : $phone.hashCode()); Object $idCardType = getIdCardType(); result = result * 59 + (($idCardType == null) ? 43 : $idCardType.hashCode()); Object $patientNumber = getPatientNumber(); result = result * 59 + (($patientNumber == null) ? 43 : $patientNumber.hashCode()); Object $idCard = getIdCard(); result = result * 59 + (($idCard == null) ? 43 : $idCard.hashCode()); Object $issueDate = getIssueDate(); result = result * 59 + (($issueDate == null) ? 43 : $issueDate.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $type = getType(); result = result * 59 + (($type == null) ? 43 : $type.hashCode()); Object $gender = getGender(); result = result * 59 + (($gender == null) ? 43 : $gender.hashCode()); Object $dayBorn = getDayBorn(); result = result * 59 + (($dayBorn == null) ? 43 : $dayBorn.hashCode()); Object $monthBorn = getMonthBorn(); result = result * 59 + (($monthBorn == null) ? 43 : $monthBorn.hashCode()); Object $yearBorn = getYearBorn(); result = result * 59 + (($yearBorn == null) ? 43 : $yearBorn.hashCode()); Object $birthday = getBirthday(); result = result * 59 + (($birthday == null) ? 43 : $birthday.hashCode()); Object $lang = getLang(); result = result * 59 + (($lang == null) ? 43 : $lang.hashCode()); Object $city = getCity(); result = result * 59 + (($city == null) ? 43 : $city.hashCode()); Object $countryCode = getCountryCode(); result = result * 59 + (($countryCode == null) ? 43 : $countryCode.hashCode()); Object $nationality = getNationality(); result = result * 59 + (($nationality == null) ? 43 : $nationality.hashCode()); Object $address = getAddress(); result = result * 59 + (($address == null) ? 43 : $address.hashCode()); Object $customerWards = getCustomerWards(); result = result * 59 + (($customerWards == null) ? 43 : $customerWards.hashCode()); Object $localWards = getLocalWards(); result = result * 59 + (($localWards == null) ? 43 : $localWards.hashCode()); Object $customerDistrict = getCustomerDistrict(); result = result * 59 + (($customerDistrict == null) ? 43 : $customerDistrict.hashCode()); Object $localDistricts = getLocalDistricts(); result = result * 59 + (($localDistricts == null) ? 43 : $localDistricts.hashCode()); Object $customerProvince = getCustomerProvince(); result = result * 59 + (($customerProvince == null) ? 43 : $customerProvince.hashCode()); Object $localProvinces = getLocalProvinces(); result = result * 59 + (($localProvinces == null) ? 43 : $localProvinces.hashCode()); Object $postCode = getPostCode(); result = result * 59 + (($postCode == null) ? 43 : $postCode.hashCode()); Object $ethnic = getEthnic(); result = result * 59 + (($ethnic == null) ? 43 : $ethnic.hashCode()); Object $detailObject = getDetailObject(); result = result * 59 + (($detailObject == null) ? 43 : $detailObject.hashCode()); Object $address2 = getAddress2(); result = result * 59 + (($address2 == null) ? 43 : $address2.hashCode()); Object $jobTitle = getJobTitle(); result = result * 59 + (($jobTitle == null) ? 43 : $jobTitle.hashCode()); Object $userId = getUserId(); result = result * 59 + (($userId == null) ? 43 : $userId.hashCode()); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $checkinLevel = getCheckinLevel(); result = result * 59 + (($checkinLevel == null) ? 43 : $checkinLevel.hashCode()); Object $poisition = getPoisition(); result = result * 59 + (($poisition == null) ? 43 : $poisition.hashCode()); Object $checkinUnit = getCheckinUnit(); return result * 59 + (($checkinUnit == null) ? 43 : $checkinUnit.hashCode()); } public String toString() { return "Customers(id=" + getId() + ", name=" + getName() + ", phone=" + getPhone() + ", idCardType=" + getIdCardType() + ", patientNumber=" + getPatientNumber() + ", idCard=" + getIdCard() + ", issueDate=" + getIssueDate() + ", email=" + getEmail() + ", type=" + getType() + ", gender=" + getGender() + ", dayBorn=" + getDayBorn() + ", monthBorn=" + getMonthBorn() + ", yearBorn=" + getYearBorn() + ", birthday=" + getBirthday() + ", lang=" + getLang() + ", city=" + getCity() + ", countryCode=" + getCountryCode() + ", nationality=" + getNationality() + ", address=" + getAddress() + ", customerWards=" + getCustomerWards() + ", localWards=" + getLocalWards() + ", customerDistrict=" + getCustomerDistrict() + ", localDistricts=" + getLocalDistricts() + ", customerProvince=" + getCustomerProvince() + ", localProvinces=" + getLocalProvinces() + ", postCode=" + getPostCode() + ", ethnic=" + getEthnic() + ", detailObject=" + getDetailObject() + ", address2=" + getAddress2() + ", jobTitle=" + getJobTitle() + ", userId=" + getUserId() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", checkinLevel=" + getCheckinLevel() + ", poisition=" + getPoisition() + ", checkinUnit=" + getCheckinUnit() + ")"; }
/*     */    public Customers() {} public Customers(int id, String name, String phone, String idCardType, String patientNumber, String idCard, Date issueDate, String email, String type, String gender, String dayBorn, String monthBorn, String yearBorn, Date birthday, String lang, String city, String countryCode, String nationality, String address, String customerWards, LocalWards localWards, String customerDistrict, LocalDistricts localDistricts, String customerProvince, LocalProvinces localProvinces, String postCode, String ethnic, String detailObject, String address2, String jobTitle, Integer userId, Date createdAt, Date updatedAt, String checkinLevel, String poisition, String checkinUnit) {
/*  24 */     this.id = id; this.name = name; this.phone = phone; this.idCardType = idCardType; this.patientNumber = patientNumber; this.idCard = idCard; this.issueDate = issueDate; this.email = email; this.type = type; this.gender = gender; this.dayBorn = dayBorn; this.monthBorn = monthBorn; this.yearBorn = yearBorn; this.birthday = birthday; this.lang = lang; this.city = city; this.countryCode = countryCode; this.nationality = nationality; this.address = address; this.customerWards = customerWards; this.localWards = localWards; this.customerDistrict = customerDistrict; this.localDistricts = localDistricts; this.customerProvince = customerProvince; this.localProvinces = localProvinces; this.postCode = postCode; this.ethnic = ethnic; this.detailObject = detailObject; this.address2 = address2; this.jobTitle = jobTitle; this.userId = userId; this.createdAt = createdAt; this.updatedAt = updatedAt; this.checkinLevel = checkinLevel; this.poisition = poisition; this.checkinUnit = checkinUnit;
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
/*     */   @Id
/*     */   @Column(name = "id")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   public int getId() {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  75 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  81 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  85 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "phone")
/*     */   public String getPhone() {
/*  91 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  95 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "id_card_type")
/*     */   public String getIdCardType() {
/* 101 */     return this.idCardType;
/*     */   }
/*     */   
/*     */   public void setIdCardType(String idCardType) {
/* 105 */     this.idCardType = idCardType;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "patient_number")
/*     */   public String getPatientNumber() {
/* 111 */     return this.patientNumber;
/*     */   }
/*     */   
/*     */   public void setPatientNumber(String patientNumber) {
/* 115 */     this.patientNumber = patientNumber;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "id_card")
/*     */   public String getIdCard() {
/* 121 */     return this.idCard;
/*     */   }
/*     */   
/*     */   public void setIdCard(String idCard) {
/* 125 */     this.idCard = idCard;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "issue_date")
/*     */   public Date getIssueDate() {
/* 131 */     return this.issueDate;
/*     */   }
/*     */   
/*     */   public void setIssueDate(Date issueDate) {
/* 135 */     this.issueDate = issueDate;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "email")
/*     */   public String getEmail() {
/* 141 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 145 */     this.email = email;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "type")
/*     */   public String getType() {
/* 151 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 155 */     this.type = type;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "gender")
/*     */   public String getGender() {
/* 161 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 165 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "day_born")
/*     */   public String getDayBorn() {
/* 171 */     return this.dayBorn;
/*     */   }
/*     */   
/*     */   public void setDayBorn(String dayBorn) {
/* 175 */     this.dayBorn = dayBorn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "month_born")
/*     */   public String getMonthBorn() {
/* 181 */     return this.monthBorn;
/*     */   }
/*     */   
/*     */   public void setMonthBorn(String monthBorn) {
/* 185 */     this.monthBorn = monthBorn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "year_born")
/*     */   public String getYearBorn() {
/* 191 */     return this.yearBorn;
/*     */   }
/*     */   
/*     */   public void setYearBorn(String yearBorn) {
/* 195 */     this.yearBorn = yearBorn;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "birthday")
/*     */   public Date getBirthday() {
/* 201 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setBirthday(Date birthday) {
/* 205 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "lang")
/*     */   public String getLang() {
/* 211 */     return this.lang;
/*     */   }
/*     */   
/*     */   public void setLang(String lang) {
/* 215 */     this.lang = lang;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "city")
/*     */   public String getCity() {
/* 221 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/* 225 */     this.city = city;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "country_code")
/*     */   public String getCountryCode() {
/* 231 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode) {
/* 235 */     this.countryCode = countryCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "nationality")
/*     */   public String getNationality() {
/* 241 */     return this.nationality;
/*     */   }
/*     */   
/*     */   public void setNationality(String nationality) {
/* 245 */     this.nationality = nationality;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "post_code")
/*     */   public String getPostCode() {
/* 251 */     return this.postCode;
/*     */   }
/*     */   
/*     */   public void setPostCode(String postCode) {
/* 255 */     this.postCode = postCode;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address")
/*     */   public String getAddress() {
/* 261 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 265 */     this.address = address;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "user_id")
/*     */   public Integer getUserId() {
/* 271 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Integer userId) {
/* 275 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 281 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 285 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 291 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 295 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_wards")
/*     */   public String getCustomerWards() {
/* 301 */     return this.customerWards;
/*     */   }
/*     */   
/*     */   public void setCustomerWards(String customerWards) {
/* 305 */     this.customerWards = customerWards;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_district")
/*     */   public String getCustomerDistrict() {
/* 311 */     return this.customerDistrict;
/*     */   }
/*     */   
/*     */   public void setCustomerDistrict(String customerDistrict) {
/* 315 */     this.customerDistrict = customerDistrict;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "customer_province")
/*     */   public String getCustomerProvince() {
/* 321 */     return this.customerProvince;
/*     */   }
/*     */   
/*     */   public void setCustomerProvince(String customerProvince) {
/* 325 */     this.customerProvince = customerProvince;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "ethnic")
/*     */   public String getEthnic() {
/* 331 */     return this.ethnic;
/*     */   }
/*     */   
/*     */   public void setEthnic(String ethnic) {
/* 335 */     this.ethnic = ethnic;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "detail_object")
/*     */   public String getDetailObject() {
/* 342 */     return this.detailObject;
/*     */   }
/*     */   
/*     */   public void setDetailObject(String detailObject) {
/* 346 */     this.detailObject = detailObject;
/*     */   }
/*     */ 
/*     */   
/*     */   @Basic
/*     */   @Column(name = "address2")
/*     */   public String getAddress2() {
/* 353 */     return this.address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String address2) {
/* 357 */     this.address2 = address2;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "job_title")
/*     */   public String getJobTitle() {
/* 363 */     return this.jobTitle;
/*     */   }
/*     */   
/*     */   public void setJobTitle(String jobTitle) {
/* 367 */     this.jobTitle = jobTitle;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "customer_wards", referencedColumnName = "code", updatable = false, insertable = false)
/*     */   public LocalWards getLocalWards() {
/* 373 */     return this.localWards;
/*     */   }
/*     */   
/*     */   public void setLocalWards(LocalWards localWards) {
/* 377 */     this.localWards = localWards;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "customer_district", referencedColumnName = "code", updatable = false, insertable = false)
/*     */   public LocalDistricts getLocalDistricts() {
/* 383 */     return this.localDistricts;
/*     */   }
/*     */   
/*     */   public void setLocalDistricts(LocalDistricts localDistricts) {
/* 387 */     this.localDistricts = localDistricts;
/*     */   }
/*     */   
/*     */   @ManyToOne(optional = false)
/*     */   @JoinColumn(name = "customer_province", referencedColumnName = "code", updatable = false, insertable = false)
/*     */   public LocalProvinces getLocalProvinces() {
/* 393 */     return this.localProvinces;
/*     */   }
/*     */   
/*     */   public void setLocalProvinces(LocalProvinces localProvinces) {
/* 397 */     this.localProvinces = localProvinces;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_level")
/*     */   public String getCheckinLevel() {
/* 403 */     return this.checkinLevel;
/*     */   }
/*     */   
/*     */   public void setCheckinLevel(String checkinLevel) {
/* 407 */     this.checkinLevel = checkinLevel;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "poisition")
/*     */   public String getPoisition() {
/* 413 */     return this.poisition;
/*     */   }
/*     */   
/*     */   public void setPoisition(String poisition) {
/* 417 */     this.poisition = poisition;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checkin_unit")
/*     */   public String getCheckinUnit() {
/* 423 */     return this.checkinUnit;
/*     */   }
/*     */   
/*     */   public void setCheckinUnit(String checkinUnit) {
/* 427 */     this.checkinUnit = checkinUnit;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Entity\Customers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */