/*    */ package nencer.app.Constant;
/*    */ 
/*    */ public enum MedicProductOrderType {
/*  4 */   NK_NCC("NK_NCC"),
/*  5 */   XK_HTKP("XK_HTKP"),
/*    */   
/*  7 */   NK_NBCSTT("NK_NBCSTT"),
/*  8 */   XK_XBCSTT("XK_XBCSTT"),
/*    */   
/* 10 */   NK_BSCKTT("NK_BSCKTT"),
/* 11 */   XK_HTCSTT("XK_HTCSTT"),
/*    */   
/* 13 */   NK_NCT("NK_NCT"),
/* 14 */   XK_CK("XK_CK"),
/* 15 */   NK_CK("NK_CK"),
/* 16 */   XK_KL("XK_KL"),
/* 17 */   NK_HT("NK_HT"),
/* 18 */   XK_KP("XK_KP"),
/* 19 */   XK_XH("XK_XH"),
/* 20 */   XK_HV("XK_HV"),
/* 21 */   XK_HH("XK_HH"),
/* 22 */   XK_KHAC("XK_KHAC"),
/* 23 */   XK_NCC("XK_NCC"),
/* 24 */   XK_THYL("XK_THYL"),
/* 25 */   NK_THHT("NK_THHT"),
/*    */   
/* 27 */   XK("XK"),
/* 28 */   NK("NK"),
/* 29 */   NCC("NCC");
/*    */   
/*    */   public String getMedicProductOrderType() {
/* 32 */     return this.orderType;
/*    */   }
/*    */   private String orderType;
/*    */   public void setMedicProductOrderType(String orderType) {
/* 36 */     this.orderType = orderType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   MedicProductOrderType(String type) {
/* 42 */     this.orderType = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Constant\MedicProductOrderType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */