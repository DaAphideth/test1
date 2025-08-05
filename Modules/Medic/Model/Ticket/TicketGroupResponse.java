/*    */ package nencer.app.Modules.Medic.Model.Ticket;public class TicketGroupResponse { private Integer code;
/*    */   private String name;
/*    */   private Integer services;
/*    */   
/*  5 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TicketGroupResponse)) return false;  TicketGroupResponse other = (TicketGroupResponse)o; if (!other.canEqual(this)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$services = getServices(), other$services = other.getServices(); return !((this$services == null) ? (other$services != null) : !this$services.equals(other$services)); } protected boolean canEqual(Object other) { return other instanceof TicketGroupResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $services = getServices(); return result * 59 + (($services == null) ? 43 : $services.hashCode()); } public String toString() { return "TicketGroupResponse(code=" + getCode() + ", name=" + getName() + ", services=" + getServices() + ")"; }
/*  6 */   public static TicketGroupResponseBuilder builder() { return new TicketGroupResponseBuilder(); } public static class TicketGroupResponseBuilder { private Integer code; public TicketGroupResponseBuilder code(Integer code) { this.code = code; return this; } private String name; private Integer services; public TicketGroupResponseBuilder name(String name) { this.name = name; return this; } public TicketGroupResponseBuilder services(Integer services) { this.services = services; return this; } public TicketGroupResponse build() { return new TicketGroupResponse(this.code, this.name, this.services); } public String toString() { return "TicketGroupResponse.TicketGroupResponseBuilder(code=" + this.code + ", name=" + this.name + ", services=" + this.services + ")"; }
/*    */      }
/*  8 */   public void setCode(Integer code) { this.code = code; } public void setName(String name) { this.name = name; } public void setServices(Integer services) { this.services = services; }
/*    */   
/* 10 */   public Integer getCode() { return this.code; }
/* 11 */   public String getName() { return this.name; } public Integer getServices() {
/* 12 */     return this.services;
/*    */   }
/*    */   
/*    */   public TicketGroupResponse() {}
/*    */   
/*    */   public TicketGroupResponse(Integer code, String name, Integer services) {
/* 18 */     this.code = code;
/* 19 */     this.name = name;
/* 20 */     this.services = services;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Ticket\TicketGroupResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */