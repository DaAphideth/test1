/*    */ package nencer.app.Modules.Medic.Model.LisRis;
/*    */ 
/*    */ import java.util.List;
/*    */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*    */ 
/*    */ public class LisRisDetailResponseBuilder
/*    */ {
/*    */   private MedicTicket medicTicket;
/*    */   private Integer roomId;
/*    */   private String roomName;
/*    */   private String roomHandleBy;
/*    */   private String roomHandleResultBy;
/*    */   private Integer orderServiceId;
/*    */   
/*    */   public LisRisDetailResponseBuilder medicTicket(MedicTicket medicTicket) {
/* 16 */     this.medicTicket = medicTicket; return this; } private String risResult; private String risFinish; private String risResultBy; private String risDevice; private String status; private String machine; private List<LisRisOrderResponse> orderServices; public LisRisDetailResponseBuilder roomId(Integer roomId) { this.roomId = roomId; return this; } public LisRisDetailResponseBuilder roomName(String roomName) { this.roomName = roomName; return this; } public LisRisDetailResponseBuilder roomHandleBy(String roomHandleBy) { this.roomHandleBy = roomHandleBy; return this; } public LisRisDetailResponseBuilder roomHandleResultBy(String roomHandleResultBy) { this.roomHandleResultBy = roomHandleResultBy; return this; } public LisRisDetailResponseBuilder orderServiceId(Integer orderServiceId) { this.orderServiceId = orderServiceId; return this; } public LisRisDetailResponseBuilder risResult(String risResult) { this.risResult = risResult; return this; } public LisRisDetailResponseBuilder risFinish(String risFinish) { this.risFinish = risFinish; return this; } public LisRisDetailResponseBuilder risResultBy(String risResultBy) { this.risResultBy = risResultBy; return this; } public LisRisDetailResponseBuilder risDevice(String risDevice) { this.risDevice = risDevice; return this; } public LisRisDetailResponseBuilder status(String status) { this.status = status; return this; } public LisRisDetailResponseBuilder machine(String machine) { this.machine = machine; return this; } public LisRisDetailResponseBuilder orderServices(List<LisRisOrderResponse> orderServices) { this.orderServices = orderServices; return this; } public LisRisDetailResponse build() { return new LisRisDetailResponse(this.medicTicket, this.roomId, this.roomName, this.roomHandleBy, this.roomHandleResultBy, this.orderServiceId, this.risResult, this.risFinish, this.risResultBy, this.risDevice, this.status, this.machine, this.orderServices); } public String toString() { return "LisRisDetailResponse.LisRisDetailResponseBuilder(medicTicket=" + this.medicTicket + ", roomId=" + this.roomId + ", roomName=" + this.roomName + ", roomHandleBy=" + this.roomHandleBy + ", roomHandleResultBy=" + this.roomHandleResultBy + ", orderServiceId=" + this.orderServiceId + ", risResult=" + this.risResult + ", risFinish=" + this.risFinish + ", risResultBy=" + this.risResultBy + ", risDevice=" + this.risDevice + ", status=" + this.status + ", machine=" + this.machine + ", orderServices=" + this.orderServices + ")"; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\LisRis\LisRisDetailResponse$LisRisDetailResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */