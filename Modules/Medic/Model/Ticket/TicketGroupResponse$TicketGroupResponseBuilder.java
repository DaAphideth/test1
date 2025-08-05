/*   */ package nencer.app.Modules.Medic.Model.Ticket;
/*   */ public class TicketGroupResponseBuilder { private Integer code;
/*   */   private String name;
/*   */   private Integer services;
/*   */   
/* 6 */   public TicketGroupResponseBuilder code(Integer code) { this.code = code; return this; } public TicketGroupResponseBuilder name(String name) { this.name = name; return this; } public TicketGroupResponseBuilder services(Integer services) { this.services = services; return this; } public TicketGroupResponse build() { return new TicketGroupResponse(this.code, this.name, this.services); } public String toString() { return "TicketGroupResponse.TicketGroupResponseBuilder(code=" + this.code + ", name=" + this.name + ", services=" + this.services + ")"; }
/*   */    }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Ticket\TicketGroupResponse$TicketGroupResponseBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */