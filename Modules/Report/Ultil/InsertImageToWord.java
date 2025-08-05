/*     */ package nencer.app.Modules.Report.Ultil;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import org.docx4j.TraversalUtil;
/*     */ import org.docx4j.dml.wordprocessingDrawing.Inline;
/*     */ import org.docx4j.finders.RangeFinder;
/*     */ import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
/*     */ import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
/*     */ import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
/*     */ import org.docx4j.wml.Body;
/*     */ import org.docx4j.wml.CTBookmark;
/*     */ import org.docx4j.wml.Document;
/*     */ import org.docx4j.wml.Drawing;
/*     */ import org.docx4j.wml.ObjectFactory;
/*     */ import org.docx4j.wml.P;
/*     */ import org.docx4j.wml.R;
/*     */ import org.docx4j.wml.Tc;
/*     */ 
/*     */ @Component
/*     */ public class InsertImageToWord {
/*  23 */   private final Logger logger = LoggerFactory.getLogger(InsertImageToWord.class);
/*     */   
/*     */   private static final String bookmarkName = "signature";
/*     */   
/*     */   public void insertImageToWord(File template, File image, String destinationPath) throws Exception {
/*  28 */     WordprocessingMLPackage wPackage = WordprocessingMLPackage.load(template);
/*  29 */     MainDocumentPart mainDocumentPart = wPackage.getMainDocumentPart();
/*  30 */     Document wmlDoc = (Document)mainDocumentPart.getJaxbElement();
/*  31 */     Body body = wmlDoc.getBody();
/*     */     
/*  33 */     List<Object> paragraphs = body.getContent();
/*     */     
/*  35 */     RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
/*  36 */     new TraversalUtil(paragraphs, (TraversalUtil.Callback)rt);
/*     */     
/*  38 */     for (CTBookmark bm : rt.getStarts()) {
/*     */       
/*  40 */       if (bm.getName().equalsIgnoreCase("signature"))
/*     */       {
/*  42 */         try (InputStream is = new FileInputStream(image)) {
/*  43 */           byte[] bytes = IOUtils.toByteArray(is);
/*     */           
/*  45 */           BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);
/*  46 */           Inline inline = imagePart.createImageInline(null, null, 0, 1, false, 30000);
/*     */           
/*  48 */           ObjectFactory factory = new ObjectFactory();
/*     */           
/*  50 */           if (bm.getParent() instanceof P) {
/*  51 */             P p = (P)bm.getParent();
/*  52 */             R run = factory.createR();
/*  53 */             Drawing drawing = factory.createDrawing();
/*  54 */             drawing.getAnchorOrInline().add(inline);
/*  55 */             run.getContent().add(drawing);
/*  56 */             p.getContent().add(run);
/*  57 */           } else if (bm.getParent() instanceof Tc) {
/*  58 */             Tc tc = (Tc)bm.getParent();
/*  59 */             P run = factory.createP();
/*  60 */             Drawing drawing = factory.createDrawing();
/*  61 */             drawing.getAnchorOrInline().add(inline);
/*  62 */             run.getContent().add(drawing);
/*  63 */             tc.getContent().add(run);
/*     */           } else {
/*  65 */             this.logger.error("Không chèn được ảnh");
/*  66 */             throw new Exception("Không chèn được ảnh");
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  71 */     try (FileOutputStream os = new FileOutputStream(destinationPath)) {
/*  72 */       wPackage.save(os);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertMutipleImageToWord(File template, List<File> images, String destinationPath) throws Exception {
/*  77 */     WordprocessingMLPackage wPackage = WordprocessingMLPackage.load(template);
/*  78 */     MainDocumentPart mainDocumentPart = wPackage.getMainDocumentPart();
/*  79 */     Document wmlDoc = (Document)mainDocumentPart.getJaxbElement();
/*  80 */     Body body = wmlDoc.getBody();
/*     */     
/*  82 */     List<Object> paragraphs = body.getContent();
/*     */     
/*  84 */     RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
/*  85 */     new TraversalUtil(paragraphs, (TraversalUtil.Callback)rt);
/*     */     
/*  87 */     int i = 0;
/*  88 */     for (CTBookmark bm : rt.getStarts()) {
/*     */       
/*  90 */       if (bm.getName().equalsIgnoreCase("barCode")) {
/*  91 */         File f = images.get(i);
/*  92 */         if (f == null) f = images.get(0);
/*     */         
/*  94 */         try (InputStream is = new FileInputStream(f)) {
/*  95 */           byte[] bytes = IOUtils.toByteArray(is);
/*     */           
/*  97 */           BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);
/*  98 */           Inline inline = imagePart.createImageInline(null, null, 0, 1, false, 2000);
/*     */           
/* 100 */           ObjectFactory factory = new ObjectFactory();
/*     */           
/* 102 */           if (bm.getParent() instanceof P) {
/* 103 */             P p = (P)bm.getParent();
/* 104 */             R run = factory.createR();
/* 105 */             Drawing drawing = factory.createDrawing();
/* 106 */             drawing.getAnchorOrInline().add(inline);
/* 107 */             run.getContent().add(drawing);
/* 108 */             p.getContent().add(run);
/* 109 */           } else if (bm.getParent() instanceof Tc) {
/* 110 */             Tc tc = (Tc)bm.getParent();
/* 111 */             P run = factory.createP();
/* 112 */             Drawing drawing = factory.createDrawing();
/* 113 */             drawing.getAnchorOrInline().add(inline);
/* 114 */             run.getContent().add(drawing);
/* 115 */             tc.getContent().add(run);
/*     */           } else {
/* 117 */             this.logger.error("Không chèn được ảnh");
/* 118 */             throw new Exception("Không chèn được ảnh");
/*     */           } 
/*     */         } 
/* 121 */         i++; continue;
/* 122 */       }  if (bm.getName().equalsIgnoreCase("qrCode")) {
/* 123 */         File f = images.get(i);
/* 124 */         if (f == null) f = images.get(0);
/*     */         
/* 126 */         try (InputStream is = new FileInputStream(f)) {
/* 127 */           byte[] bytes = IOUtils.toByteArray(is);
/*     */           
/* 129 */           BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);
/* 130 */           Inline inline = imagePart.createImageInline(null, null, 0, 1, false, 2000);
/*     */           
/* 132 */           ObjectFactory factory = new ObjectFactory();
/*     */           
/* 134 */           if (bm.getParent() instanceof P) {
/* 135 */             P p = (P)bm.getParent();
/* 136 */             R run = factory.createR();
/* 137 */             Drawing drawing = factory.createDrawing();
/* 138 */             drawing.getAnchorOrInline().add(inline);
/* 139 */             run.getContent().add(drawing);
/* 140 */             p.getContent().add(run);
/* 141 */           } else if (bm.getParent() instanceof Tc) {
/* 142 */             Tc tc = (Tc)bm.getParent();
/* 143 */             P run = factory.createP();
/* 144 */             Drawing drawing = factory.createDrawing();
/* 145 */             drawing.getAnchorOrInline().add(inline);
/* 146 */             run.getContent().add(drawing);
/* 147 */             tc.getContent().add(run);
/*     */           } else {
/* 149 */             this.logger.error("Không chèn được ảnh");
/* 150 */             throw new Exception("Không chèn được ảnh");
/*     */           } 
/*     */         } 
/* 153 */         i++;
/*     */       } 
/*     */     } 
/* 156 */     try (FileOutputStream os = new FileOutputStream(destinationPath)) {
/* 157 */       wPackage.save(os);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertMutipleImageToWord2(File template, List<byte[]> images, String destinationPath) throws Exception {
/* 162 */     WordprocessingMLPackage wPackage = WordprocessingMLPackage.load(template);
/* 163 */     MainDocumentPart mainDocumentPart = wPackage.getMainDocumentPart();
/* 164 */     Document wmlDoc = (Document)mainDocumentPart.getJaxbElement();
/* 165 */     Body body = wmlDoc.getBody();
/*     */     
/* 167 */     List<Object> paragraphs = body.getContent();
/*     */     
/* 169 */     RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
/* 170 */     new TraversalUtil(paragraphs, (TraversalUtil.Callback)rt);
/*     */     
/* 172 */     int i = 0;
/* 173 */     for (CTBookmark bm : rt.getStarts()) {
/*     */       
/* 175 */       String bar = "barCode" + i;
/* 176 */       if (bm.getName().equalsIgnoreCase(bar.replace("barCode0", "barCode"))) {
/*     */         
/* 178 */         byte[] bytes = images.get(i);
/*     */         
/* 180 */         BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);
/* 181 */         Inline inline = imagePart.createImageInline(null, null, 0, 1, false, 2000);
/*     */         
/* 183 */         ObjectFactory factory = new ObjectFactory();
/*     */         
/* 185 */         if (bm.getParent() instanceof P) {
/* 186 */           P p = (P)bm.getParent();
/* 187 */           R run = factory.createR();
/* 188 */           Drawing drawing = factory.createDrawing();
/* 189 */           drawing.getAnchorOrInline().add(inline);
/* 190 */           run.getContent().add(drawing);
/* 191 */           p.getContent().add(run);
/* 192 */         } else if (bm.getParent() instanceof Tc) {
/* 193 */           Tc tc = (Tc)bm.getParent();
/* 194 */           P run = factory.createP();
/* 195 */           Drawing drawing = factory.createDrawing();
/* 196 */           drawing.getAnchorOrInline().add(inline);
/* 197 */           run.getContent().add(drawing);
/* 198 */           tc.getContent().add(run);
/*     */         } else {
/* 200 */           this.logger.error("Không chèn được ảnh");
/* 201 */           throw new Exception("Không chèn được ảnh");
/*     */         } 
/* 203 */         i++;
/*     */       } 
/* 205 */       bar = "qrCode" + i;
/* 206 */       if (bm.getName().equalsIgnoreCase(bar.replace("qrCode0", "qrCode"))) {
/*     */         
/* 208 */         byte[] bytes = images.get(i);
/*     */         
/* 210 */         BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);
/* 211 */         Inline inline = imagePart.createImageInline(null, null, 0, 1, false, 2000);
/*     */         
/* 213 */         ObjectFactory factory = new ObjectFactory();
/*     */         
/* 215 */         if (bm.getParent() instanceof P) {
/* 216 */           P p = (P)bm.getParent();
/* 217 */           R run = factory.createR();
/* 218 */           Drawing drawing = factory.createDrawing();
/* 219 */           drawing.getAnchorOrInline().add(inline);
/* 220 */           run.getContent().add(drawing);
/* 221 */           p.getContent().add(run);
/* 222 */         } else if (bm.getParent() instanceof Tc) {
/* 223 */           Tc tc = (Tc)bm.getParent();
/* 224 */           P run = factory.createP();
/* 225 */           Drawing drawing = factory.createDrawing();
/* 226 */           drawing.getAnchorOrInline().add(inline);
/* 227 */           run.getContent().add(drawing);
/* 228 */           tc.getContent().add(run);
/*     */         } else {
/* 230 */           this.logger.error("Không chèn được ảnh");
/* 231 */           throw new Exception("Không chèn được ảnh");
/*     */         } 
/* 233 */         i++;
/*     */       } 
/*     */     } 
/* 236 */     try (FileOutputStream os = new FileOutputStream(destinationPath)) {
/* 237 */       wPackage.save(os);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Ultil\InsertImageToWord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */