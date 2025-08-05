/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ public class CurrencyResponse {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String code;
/*    */   private double value;
/*    */   private Double valueSell;
/*    */   private String symbolLeft;
/*    */   private String symbolRight;
/*    */   private ApiFwConstants.Seperator seperator;
/*    */   private int decimal;
/*    */   private int status;
/*    */   private int fiat;
/*    */   
/* 16 */   public void setId(Integer id) { this.id = id; } private int isDefault; private int homepage; private int wallet; private int isPrice; private double walletAdminBalance; private String checksum; private int sort; private Date createdAt; private Date updatedAt; private String updatedAtDis; private String createdAtDis; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setValue(double value) { this.value = value; } public void setValueSell(Double valueSell) { this.valueSell = valueSell; } public void setSymbolLeft(String symbolLeft) { this.symbolLeft = symbolLeft; } public void setSymbolRight(String symbolRight) { this.symbolRight = symbolRight; } public void setSeperator(ApiFwConstants.Seperator seperator) { this.seperator = seperator; } public void setDecimal(int decimal) { this.decimal = decimal; } public void setStatus(int status) { this.status = status; } public void setFiat(int fiat) { this.fiat = fiat; } public void setIsDefault(int isDefault) { this.isDefault = isDefault; } public void setHomepage(int homepage) { this.homepage = homepage; } public void setWallet(int wallet) { this.wallet = wallet; } public void setIsPrice(int isPrice) { this.isPrice = isPrice; } public void setWalletAdminBalance(double walletAdminBalance) { this.walletAdminBalance = walletAdminBalance; } public void setChecksum(String checksum) { this.checksum = checksum; } public void setSort(int sort) { this.sort = sort; } public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } public void setUpdatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; } public void setCreatedAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CurrencyResponse)) return false;  CurrencyResponse other = (CurrencyResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  if (Double.compare(getValue(), other.getValue()) != 0) return false;  Object this$valueSell = getValueSell(), other$valueSell = other.getValueSell(); if ((this$valueSell == null) ? (other$valueSell != null) : !this$valueSell.equals(other$valueSell)) return false;  Object this$symbolLeft = getSymbolLeft(), other$symbolLeft = other.getSymbolLeft(); if ((this$symbolLeft == null) ? (other$symbolLeft != null) : !this$symbolLeft.equals(other$symbolLeft)) return false;  Object this$symbolRight = getSymbolRight(), other$symbolRight = other.getSymbolRight(); if ((this$symbolRight == null) ? (other$symbolRight != null) : !this$symbolRight.equals(other$symbolRight)) return false;  Object this$seperator = getSeperator(), other$seperator = other.getSeperator(); if ((this$seperator == null) ? (other$seperator != null) : !this$seperator.equals(other$seperator)) return false;  if (getDecimal() != other.getDecimal()) return false;  if (getStatus() != other.getStatus()) return false;  if (getFiat() != other.getFiat()) return false;  if (getIsDefault() != other.getIsDefault()) return false;  if (getHomepage() != other.getHomepage()) return false;  if (getWallet() != other.getWallet()) return false;  if (getIsPrice() != other.getIsPrice()) return false;  if (Double.compare(getWalletAdminBalance(), other.getWalletAdminBalance()) != 0) return false;  Object this$checksum = getChecksum(), other$checksum = other.getChecksum(); if ((this$checksum == null) ? (other$checksum != null) : !this$checksum.equals(other$checksum)) return false;  if (getSort() != other.getSort()) return false;  Object this$createdAt = getCreatedAt(), other$createdAt = other.getCreatedAt(); if ((this$createdAt == null) ? (other$createdAt != null) : !this$createdAt.equals(other$createdAt)) return false;  Object this$updatedAt = getUpdatedAt(), other$updatedAt = other.getUpdatedAt(); if ((this$updatedAt == null) ? (other$updatedAt != null) : !this$updatedAt.equals(other$updatedAt)) return false;  Object this$updatedAtDis = getUpdatedAtDis(), other$updatedAtDis = other.getUpdatedAtDis(); if ((this$updatedAtDis == null) ? (other$updatedAtDis != null) : !this$updatedAtDis.equals(other$updatedAtDis)) return false;  Object this$createdAtDis = getCreatedAtDis(), other$createdAtDis = other.getCreatedAtDis(); return !((this$createdAtDis == null) ? (other$createdAtDis != null) : !this$createdAtDis.equals(other$createdAtDis)); } protected boolean canEqual(Object other) { return other instanceof CurrencyResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); long $value = Double.doubleToLongBits(getValue()); result = result * 59 + (int)($value >>> 32L ^ $value); Object $valueSell = getValueSell(); result = result * 59 + (($valueSell == null) ? 43 : $valueSell.hashCode()); Object $symbolLeft = getSymbolLeft(); result = result * 59 + (($symbolLeft == null) ? 43 : $symbolLeft.hashCode()); Object $symbolRight = getSymbolRight(); result = result * 59 + (($symbolRight == null) ? 43 : $symbolRight.hashCode()); Object $seperator = getSeperator(); result = result * 59 + (($seperator == null) ? 43 : $seperator.hashCode()); result = result * 59 + getDecimal(); result = result * 59 + getStatus(); result = result * 59 + getFiat(); result = result * 59 + getIsDefault(); result = result * 59 + getHomepage(); result = result * 59 + getWallet(); result = result * 59 + getIsPrice(); long $walletAdminBalance = Double.doubleToLongBits(getWalletAdminBalance()); result = result * 59 + (int)($walletAdminBalance >>> 32L ^ $walletAdminBalance); Object $checksum = getChecksum(); result = result * 59 + (($checksum == null) ? 43 : $checksum.hashCode()); result = result * 59 + getSort(); Object $createdAt = getCreatedAt(); result = result * 59 + (($createdAt == null) ? 43 : $createdAt.hashCode()); Object $updatedAt = getUpdatedAt(); result = result * 59 + (($updatedAt == null) ? 43 : $updatedAt.hashCode()); Object $updatedAtDis = getUpdatedAtDis(); result = result * 59 + (($updatedAtDis == null) ? 43 : $updatedAtDis.hashCode()); Object $createdAtDis = getCreatedAtDis(); return result * 59 + (($createdAtDis == null) ? 43 : $createdAtDis.hashCode()); } public String toString() { return "CurrencyResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", value=" + getValue() + ", valueSell=" + getValueSell() + ", symbolLeft=" + getSymbolLeft() + ", symbolRight=" + getSymbolRight() + ", seperator=" + getSeperator() + ", decimal=" + getDecimal() + ", status=" + getStatus() + ", fiat=" + getFiat() + ", isDefault=" + getIsDefault() + ", homepage=" + getHomepage() + ", wallet=" + getWallet() + ", isPrice=" + getIsPrice() + ", walletAdminBalance=" + getWalletAdminBalance() + ", checksum=" + getChecksum() + ", sort=" + getSort() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", updatedAtDis=" + getUpdatedAtDis() + ", createdAtDis=" + getCreatedAtDis() + ")"; }
/*    */    public CurrencyResponse() {} public CurrencyResponse(Integer id, String name, String code, double value, Double valueSell, String symbolLeft, String symbolRight, ApiFwConstants.Seperator seperator, int decimal, int status, int fiat, int isDefault, int homepage, int wallet, int isPrice, double walletAdminBalance, String checksum, int sort, Date createdAt, Date updatedAt, String updatedAtDis, String createdAtDis) {
/* 18 */     this.id = id; this.name = name; this.code = code; this.value = value; this.valueSell = valueSell; this.symbolLeft = symbolLeft; this.symbolRight = symbolRight; this.seperator = seperator; this.decimal = decimal; this.status = status; this.fiat = fiat; this.isDefault = isDefault; this.homepage = homepage; this.wallet = wallet; this.isPrice = isPrice; this.walletAdminBalance = walletAdminBalance; this.checksum = checksum; this.sort = sort; this.createdAt = createdAt; this.updatedAt = updatedAt; this.updatedAtDis = updatedAtDis; this.createdAtDis = createdAtDis;
/*    */   }
/* 20 */   public Integer getId() { return this.id; }
/* 21 */   public String getName() { return this.name; }
/* 22 */   public String getCode() { return this.code; }
/* 23 */   public double getValue() { return this.value; }
/* 24 */   public Double getValueSell() { return this.valueSell; }
/* 25 */   public String getSymbolLeft() { return this.symbolLeft; }
/* 26 */   public String getSymbolRight() { return this.symbolRight; }
/* 27 */   public ApiFwConstants.Seperator getSeperator() { return this.seperator; }
/* 28 */   public int getDecimal() { return this.decimal; }
/* 29 */   public int getStatus() { return this.status; }
/* 30 */   public int getFiat() { return this.fiat; }
/* 31 */   public int getIsDefault() { return this.isDefault; }
/* 32 */   public int getHomepage() { return this.homepage; }
/* 33 */   public int getWallet() { return this.wallet; }
/* 34 */   public int getIsPrice() { return this.isPrice; }
/* 35 */   public double getWalletAdminBalance() { return this.walletAdminBalance; }
/* 36 */   public String getChecksum() { return this.checksum; }
/* 37 */   public int getSort() { return this.sort; }
/* 38 */   public Date getCreatedAt() { return this.createdAt; } public Date getUpdatedAt() {
/* 39 */     return this.updatedAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedAtDis() {
/* 44 */     if (this.updatedAt == null) return ""; 
/* 45 */     return ApiHelper.dateToString(this.updatedAt);
/*    */   }
/*    */   
/*    */   public String getCreatedAtDis() {
/* 49 */     if (this.createdAt == null) return ""; 
/* 50 */     return ApiHelper.dateToString(this.createdAt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\CurrencyResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */