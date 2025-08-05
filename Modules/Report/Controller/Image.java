/*    */ package nencer.app.Modules.Report.Controller;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.JAXBElement;
/*    */ import org.apache.poi.util.Units;
/*    */ import org.apache.poi.xwpf.usermodel.XWPFDocument;
/*    */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*    */ import org.apache.poi.xwpf.usermodel.XWPFRun;
/*    */ import org.docx4j.wml.ContentAccessor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Image
/*    */ {
/*    */   public static void main(String[] args) throws Exception {
/* 30 */     FileInputStream templateStream = new FileInputStream("C:\\Users\\dap.dv\\Downloads\\Telegram Desktop\\template.docx");
/* 31 */     XWPFDocument doc = new XWPFDocument(templateStream);
/* 32 */     templateStream.close();
/*    */ 
/*    */     
/* 35 */     String mergeFieldName = "Image";
/*    */ 
/*    */     
/* 38 */     String imageFilePath = "C:\\Users\\dap.dv\\Downloads\\5117d77d-3656-437d-8088-98ba4bf0215f.png";
/*    */ 
/*    */     
/* 41 */     List<XWPFParagraph> paragraphs = doc.getParagraphs();
/* 42 */     for (XWPFParagraph paragraph : paragraphs) {
/* 43 */       List<XWPFRun> runs = paragraph.getRuns();
/* 44 */       for (int i = 0; i < runs.size(); i++) {
/* 45 */         XWPFRun run = runs.get(i);
/* 46 */         String text = run.getText(0);
/* 47 */         if (text != null && text.contains(mergeFieldName)) {
/*    */           
/* 49 */           run.setText("", 0);
/*    */ 
/*    */           
/* 52 */           InputStream imageStream = new FileInputStream(imageFilePath);
/* 53 */           run.addPicture(imageStream, 5, imageFilePath, Units.toEMU(200.0D), Units.toEMU(100.0D));
/* 54 */           imageStream.close();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 60 */     FileOutputStream out = new FileOutputStream("document_with_image.docx");
/* 61 */     doc.write(out);
/* 62 */     out.close();
/*    */   }
/*    */   
/*    */   private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
/* 66 */     List<Object> result = new ArrayList();
/* 67 */     if (obj instanceof JAXBElement) obj = ((JAXBElement)obj).getValue();
/*    */     
/* 69 */     if (obj.getClass().equals(toSearch)) {
/* 70 */       result.add(obj);
/*    */     }
/*    */     
/* 73 */     if (obj instanceof ContentAccessor) {
/* 74 */       List<?> children = ((ContentAccessor)obj).getContent();
/* 75 */       for (Object child : children) {
/* 76 */         result.addAll(getAllElementFromObject(child, toSearch));
/*    */       }
/*    */     } 
/* 79 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Controller\Image.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */