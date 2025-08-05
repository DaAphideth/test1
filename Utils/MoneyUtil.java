/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.text.NumberFormat;
/*    */ import java.util.Locale;
/*    */ 
/*    */ public class MoneyUtil
/*    */ {
/*  8 */   public static String money = "money";
/*    */   
/*    */   public static String format(Long amount) {
/* 11 */     Locale locale = new Locale("vi", "VI");
/* 12 */     NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
/* 13 */     String s = numberFormat.format(amount);
/* 14 */     return s.split("USD ")[1].split(",")[0];
/*    */   }
/*    */   
/*    */   public static String format(Double amount) {
/* 18 */     Locale locale = new Locale("vi", "VI");
/* 19 */     NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
/* 20 */     String s = numberFormat.format(amount);
/* 21 */     return s.split("USD ")[1].split(",")[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\MoneyUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */