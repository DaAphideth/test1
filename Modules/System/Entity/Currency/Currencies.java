/*     */ package nencer.app.Modules.System.Entity.Currency;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import nencer.app.Configuration.ApiFwConstants;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ public class Currencies
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String code;
/*     */   private double value;
/*     */   private Double valueSell;
/*     */   private String symbolLeft;
/*     */   private String symbolRight;
/*     */   private ApiFwConstants.Seperator seperator;
/*     */   private int decimal;
/*     */   private int status;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id")
/*     */   public int getId() {
/*  36 */     return this.id;
/*     */   }
/*     */   private int fiat; private int isDefault; private int homepage; private int wallet; private int isPrice; private double walletAdminBalance; private String checksum; private int sort; private Date createdAt; private Date updatedAt;
/*     */   public void setId(int id) {
/*  40 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "name")
/*     */   public String getName() {
/*  46 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  50 */     this.name = name;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "code")
/*     */   public String getCode() {
/*  56 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  60 */     this.code = code;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "value")
/*     */   public double getValue() {
/*  66 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(double value) {
/*  70 */     this.value = value;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "value_sell")
/*     */   public Double getValueSell() {
/*  76 */     return this.valueSell;
/*     */   }
/*     */   
/*     */   public void setValueSell(Double valueSell) {
/*  80 */     this.valueSell = valueSell;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "symbol_left")
/*     */   public String getSymbolLeft() {
/*  86 */     return this.symbolLeft;
/*     */   }
/*     */   
/*     */   public void setSymbolLeft(String symbolLeft) {
/*  90 */     this.symbolLeft = symbolLeft;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "symbol_right")
/*     */   public String getSymbolRight() {
/*  96 */     return this.symbolRight;
/*     */   }
/*     */   
/*     */   public void setSymbolRight(String symbolRight) {
/* 100 */     this.symbolRight = symbolRight;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "seperator")
/*     */   public ApiFwConstants.Seperator getSeperator() {
/* 106 */     return this.seperator;
/*     */   }
/*     */   
/*     */   public void setSeperator(ApiFwConstants.Seperator seperator) {
/* 110 */     this.seperator = seperator;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`decimal`")
/*     */   public int getDecimal() {
/* 116 */     return this.decimal;
/*     */   }
/*     */   
/*     */   public void setDecimal(int decimal) {
/* 120 */     this.decimal = decimal;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "status")
/*     */   public int getStatus() {
/* 126 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/* 130 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "fiat")
/*     */   public int getFiat() {
/* 136 */     return this.fiat;
/*     */   }
/*     */   
/*     */   public void setFiat(int fiat) {
/* 140 */     this.fiat = fiat;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "`default`")
/*     */   public int getIsDefault() {
/* 146 */     return this.isDefault;
/*     */   }
/*     */   
/*     */   public void setIsDefault(int isDefault) {
/* 150 */     this.isDefault = isDefault;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "homepage")
/*     */   public int getHomepage() {
/* 156 */     return this.homepage;
/*     */   }
/*     */   
/*     */   public void setHomepage(int homepage) {
/* 160 */     this.homepage = homepage;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "wallet")
/*     */   public int getWallet() {
/* 166 */     return this.wallet;
/*     */   }
/*     */   
/*     */   public void setWallet(int wallet) {
/* 170 */     this.wallet = wallet;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "is_price")
/*     */   public int getIsPrice() {
/* 176 */     return this.isPrice;
/*     */   }
/*     */   
/*     */   public void setIsPrice(int isPrice) {
/* 180 */     this.isPrice = isPrice;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "wallet_admin_balance")
/*     */   public double getWalletAdminBalance() {
/* 186 */     return this.walletAdminBalance;
/*     */   }
/*     */   
/*     */   public void setWalletAdminBalance(double walletAdminBalance) {
/* 190 */     this.walletAdminBalance = walletAdminBalance;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "checksum")
/*     */   public String getChecksum() {
/* 196 */     return this.checksum;
/*     */   }
/*     */   
/*     */   public void setChecksum(String checksum) {
/* 200 */     this.checksum = checksum;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "sort")
/*     */   public int getSort() {
/* 206 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(int sort) {
/* 210 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "created_at")
/*     */   public Date getCreatedAt() {
/* 216 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Date createdAt) {
/* 220 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   @Basic
/*     */   @Column(name = "updated_at")
/*     */   public Date getUpdatedAt() {
/* 226 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Date updatedAt) {
/* 230 */     this.updatedAt = updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 235 */     if (this == o) return true; 
/* 236 */     if (o == null || getClass() != o.getClass()) return false; 
/* 237 */     Currencies that = (Currencies)o;
/* 238 */     return (Double.compare(that.value, this.value) == 0 && this.decimal == that.decimal && this.status == that.status && this.fiat == that.fiat && this.isDefault == that.isDefault && this.homepage == that.homepage && this.wallet == that.wallet && this.isPrice == that.isPrice && Double.compare(that.walletAdminBalance, this.walletAdminBalance) == 0 && this.sort == that.sort && Objects.equals(Integer.valueOf(this.id), Integer.valueOf(that.id)) && Objects.equals(this.name, that.name) && Objects.equals(this.code, that.code) && Objects.equals(this.valueSell, that.valueSell) && Objects.equals(this.symbolLeft, that.symbolLeft) && Objects.equals(this.symbolRight, that.symbolRight) && Objects.equals(this.seperator, that.seperator) && Objects.equals(this.checksum, that.checksum) && Objects.equals(this.createdAt, that.createdAt) && Objects.equals(this.updatedAt, that.updatedAt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 243 */     return Objects.hash(new Object[] { Integer.valueOf(this.id), this.name, this.code, Double.valueOf(this.value), this.valueSell, this.symbolLeft, this.symbolRight, this.seperator, Integer.valueOf(this.decimal), Integer.valueOf(this.status), Integer.valueOf(this.fiat), Integer.valueOf(this.isDefault), Integer.valueOf(this.homepage), Integer.valueOf(this.wallet), Integer.valueOf(this.isPrice), Double.valueOf(this.walletAdminBalance), this.checksum, Integer.valueOf(this.sort), this.createdAt, this.updatedAt });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Entity\Currency\Currencies.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */