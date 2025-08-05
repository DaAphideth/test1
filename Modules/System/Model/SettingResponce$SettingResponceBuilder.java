/*    */ package nencer.app.Modules.System.Model;
/*    */ 
/*    */ public class SettingResponceBuilder {
/*    */   private int id;
/*    */   private String key;
/*    */   private String value;
/*    */   private String valueArr;
/*    */   private String tab;
/*    */   private Date createdAt;
/*    */   private Date updatedAt;
/*    */   private String updatedAtDis;
/*    */   private String createdAtDis;
/*    */   
/* 14 */   public SettingResponceBuilder id(int id) { this.id = id; return this; } public SettingResponceBuilder key(String key) { this.key = key; return this; } public SettingResponceBuilder value(String value) { this.value = value; return this; } public SettingResponceBuilder valueArr(String valueArr) { this.valueArr = valueArr; return this; } public SettingResponceBuilder tab(String tab) { this.tab = tab; return this; } public SettingResponceBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public SettingResponceBuilder updatedAt(Date updatedAt) { this.updatedAt = updatedAt; return this; } public SettingResponceBuilder updatedAtDis(String updatedAtDis) { this.updatedAtDis = updatedAtDis; return this; } public SettingResponceBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public SettingResponce build() { return new SettingResponce(this.id, this.key, this.value, this.valueArr, this.tab, this.createdAt, this.updatedAt, this.updatedAtDis, this.createdAtDis); } public String toString() { return "SettingResponce.SettingResponceBuilder(id=" + this.id + ", key=" + this.key + ", value=" + this.value + ", valueArr=" + this.valueArr + ", tab=" + this.tab + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", updatedAtDis=" + this.updatedAtDis + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Model\SettingResponce$SettingResponceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */