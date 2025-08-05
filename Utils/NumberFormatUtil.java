/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ 
/*    */ public class NumberFormatUtil
/*    */ {
/*  7 */   public static String percent = "percent";
/*    */   
/*    */   public static String formatPercentNumber(Double amount) {
/* 10 */     String pattern = "###.## %";
/* 11 */     DecimalFormat formatter = new DecimalFormat(pattern);
/* 12 */     return formatter.format(amount);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\NumberFormatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */