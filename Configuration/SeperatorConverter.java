/*    */ package nencer.app.Configuration;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Stream;
/*    */ import javax.persistence.AttributeConverter;
/*    */ import javax.persistence.Converter;
/*    */ 
/*    */ 
/*    */ @Converter(autoApply = true)
/*    */ public class SeperatorConverter
/*    */   implements AttributeConverter<ApiFwConstants.Seperator, String>
/*    */ {
/*    */   public String convertToDatabaseColumn(ApiFwConstants.Seperator seperator) {
/* 14 */     if (seperator == null) {
/* 15 */       return null;
/*    */     }
/* 17 */     return seperator.getCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public ApiFwConstants.Seperator convertToEntityAttribute(String code) {
/* 22 */     if (code == null) {
/* 23 */       return null;
/*    */     }
/*    */     
/* 26 */     return (ApiFwConstants.Seperator)Stream.<ApiFwConstants.Seperator>of(ApiFwConstants.Seperator.values())
/* 27 */       .filter(c -> c.getCode().equals(code))
/* 28 */       .findFirst()
/* 29 */       .orElseThrow(IllegalArgumentException::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Configuration\SeperatorConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */