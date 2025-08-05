/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataUtil
/*    */ {
/* 13 */   private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);
/*    */   
/*    */   public static int safeToInt(Object obj, int output) {
/* 16 */     int result = output;
/* 17 */     if (obj != null) {
/*    */       try {
/* 19 */         result = Integer.parseInt(obj.toString());
/* 20 */       } catch (Exception e) {
/* 21 */         logger.error(e.getMessage(), e);
/*    */       } 
/*    */     }
/*    */     
/* 25 */     return result;
/*    */   }
/*    */   
/*    */   public static int safeToInt(Object obj, Integer output) {
/* 29 */     Integer result = output;
/* 30 */     if (obj != null) {
/*    */       try {
/* 32 */         result = Integer.valueOf(Integer.parseInt(obj.toString()));
/* 33 */       } catch (Exception e) {
/* 34 */         logger.error(e.getMessage(), e);
/*    */       } 
/*    */     }
/*    */     
/* 38 */     return result.intValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int safeToInt(Object obj) {
/* 43 */     return safeToInt(obj, 0);
/*    */   }
/*    */   
/*    */   public static String safeToString(Object obj, String output) {
/* 47 */     String result = output;
/* 48 */     if (obj != null && !obj.toString().trim().isEmpty()) {
/* 49 */       result = obj.toString();
/*    */     }
/* 51 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String safeToString(Object obj) {
/* 56 */     return safeToString(obj, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public static String safeToString2(Object obj) {
/* 61 */     return safeToString(obj, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Date safeToDate(String obj) {
/* 66 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
/* 67 */     Date result = null;
/* 68 */     if (StringUtils.isNotBlank(obj)) {
/*    */       try {
/* 70 */         result = simpleDateFormat.parse(obj);
/* 71 */       } catch (Exception exception) {}
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 76 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Date safeToDate2(String obj) {
/* 82 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
/* 83 */     Date result = null;
/* 84 */     if (StringUtils.isNotBlank(obj)) {
/*    */       try {
/* 86 */         result = simpleDateFormat.parse(obj);
/* 87 */       } catch (Exception exception) {}
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 92 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\DataUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */