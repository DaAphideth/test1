/*    */ package nencer.app.Modules.Medic.Model.CustomerOrdinal;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class OrdinalDoorResponseBuilder {
/*    */   private String id;
/*    */   private String name;
/*    */   private String code;
/*    */   private Date createdAt;
/*    */   private String createdAtDis;
/*    */   
/*    */   public OrdinalDoorResponseBuilder id(String id) {
/* 13 */     this.id = id; return this; } public OrdinalDoorResponseBuilder name(String name) { this.name = name; return this; } public OrdinalDoorResponseBuilder code(String code) { this.code = code; return this; } public OrdinalDoorResponseBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; } public OrdinalDoorResponseBuilder createdAtDis(String createdAtDis) { this.createdAtDis = createdAtDis; return this; } public OrdinalDoorResponse build() { return new OrdinalDoorResponse(this.id, this.name, this.code, this.createdAt, this.createdAtDis); } public String toString() { return "OrdinalDoorResponse.OrdinalDoorResponseBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", createdAt=" + this.createdAt + ", createdAtDis=" + this.createdAtDis + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\CustomerOrdinal\OrdinalDoorResponse$OrdinalDoorResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */