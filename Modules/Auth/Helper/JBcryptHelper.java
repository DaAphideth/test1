/*    */ package nencer.app.Modules.Auth.Helper;
/*    */ 
/*    */ import org.springframework.security.crypto.bcrypt.BCrypt;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class JBcryptHelper
/*    */ {
/*    */   private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
/*    */   
/*    */   public String generatePasswordByHashPlantext(String plainTextPassword) {
/* 13 */     return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(6));
/*    */   }
/*    */   
/*    */   public Boolean checkBcryptPassword(String plaintTextPassword, String criperTextPassword) {
/* 17 */     return Boolean.valueOf(BCrypt.checkpw(plaintTextPassword, criperTextPassword));
/*    */   }
/*    */   
/*    */   public String getHashString(String string) {
/* 21 */     return BCrypt.hashpw(string, BCrypt.gensalt(6));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 27 */     JBcryptHelper jBcryptHelper = new JBcryptHelper();
/* 28 */     String password = jBcryptHelper.getHashString("123456a@");
/* 29 */     System.out.println(password);
/* 30 */     System.out.println(jBcryptHelper.checkBcryptPassword("123456a@", password));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Auth\Helper\JBcryptHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */