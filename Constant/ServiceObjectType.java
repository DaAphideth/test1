/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum ServiceObjectType {
/*  4 */   request("request"),
/*  5 */   bhyt("bhyt"),
/*  6 */   free("free"),
/*  7 */   fee("fee");
/*    */   
/*    */   public String getServiceObjectType() {
/* 10 */     return this.serviceObjectType;
/*    */   }
/*    */   private String serviceObjectType;
/*    */   public void setServiceObjectType(String serviceObjectType) {
/* 14 */     this.serviceObjectType = serviceObjectType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   ServiceObjectType(String serviceObjectType) {
/* 20 */     this.serviceObjectType = serviceObjectType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\ServiceObjectType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */