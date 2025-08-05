/*    */ package nencer.app.Utils;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.lang.reflect.Field;
/*    */ import java.sql.Clob;
/*    */ import java.sql.SQLException;
/*    */ import org.springframework.beans.BeanUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ObjectCommonUtils
/*    */ {
/*    */   public static Object getValueByField(Object object, String fieldName) {
/*    */     try {
/* 19 */       Field field = object.getClass().getDeclaredField(fieldName);
/* 20 */       field.setAccessible(true);
/* 21 */       return field.get(object);
/* 22 */     } catch (Exception e) {
/* 23 */       return null;
/*    */     } 
/*    */   }
/*    */   public static <T> T cloneObject(T source) {
/* 27 */     if (source == null) {
/* 28 */       return null;
/*    */     }
/* 30 */     Class<?> clzz = source.getClass();
/* 31 */     T target = null;
/*    */     
/* 33 */     try { target = (T)clzz.newInstance(); }
/* 34 */     catch (InstantiationException instantiationException) {  }
/* 35 */     catch (IllegalAccessException illegalAccessException) {}
/*    */ 
/*    */     
/* 38 */     BeanUtils.copyProperties(source, target);
/* 39 */     return target;
/*    */   }
/*    */   
/*    */   public static String getClobObject(Clob clob) throws IOException, SQLException {
/* 43 */     StringBuilder buffer = new StringBuilder();
/* 44 */     if (clob != null) {
/* 45 */       Reader r = clob.getCharacterStream();
/*    */       int ch;
/* 47 */       while ((ch = r.read()) != -1) {
/* 48 */         buffer.append((char)ch);
/*    */       }
/* 50 */       r.close();
/*    */     } 
/* 52 */     return buffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ObjectCommonUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */