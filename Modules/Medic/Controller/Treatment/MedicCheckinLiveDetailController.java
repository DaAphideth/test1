/*     */ package nencer.app.Modules.Medic.Controller.Treatment;
/*     */ import java.awt.Color;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.UUID;
/*     */ import javax.validation.Valid;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinLiveDetail;
/*     */ import nencer.app.Modules.Medic.Repository.Treatment.MedicCheckinLiveDetailRepository;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.apache.poi.sl.usermodel.ShapeType;
/*     */ import org.apache.poi.xslf.usermodel.XMLSlideShow;
/*     */ import org.apache.poi.xslf.usermodel.XSLFAutoShape;
/*     */ import org.apache.poi.xslf.usermodel.XSLFConnectorShape;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlide;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class MedicCheckinLiveDetailController extends BaseMedicController {
/*  46 */   public static final Logger logger = LoggerFactory.getLogger(MedicCheckinLiveDetailController.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   MedicCheckinLiveDetailRepository medicCheckinLiveDetailRepository;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/medic_checkin_live"})
/*     */   public ApiResponse getInputPatient(@Valid @RequestParam int mdId, @Valid @RequestParam(required = false) String fromDate, @Valid @RequestParam(required = false) String toDate, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
/*  61 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  63 */       Date f = DataUtil.safeToDate2(fromDate);
/*  64 */       Date t = DataUtil.safeToDate2(toDate);
/*  65 */       List<MedicCheckinLiveDetail> medicCheckinLiveDetails = this.medicService.sp_get_search_checkin_live(page, size, Integer.valueOf(mdId), f, t);
/*  66 */       rs.put("status", "OK");
/*  67 */       rs.put("responseCode", "00");
/*  68 */       rs.put("data", medicCheckinLiveDetails);
/*     */     }
/*  70 */     catch (Exception e) {
/*  71 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  72 */       logger.error(exceptionAsString);
/*  73 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  75 */     return rs;
/*     */   }
/*     */   
/*     */   @PostMapping({"/medic_checkin_live/create"})
/*     */   public ApiResponse create(@RequestBody MedicCheckinLiveDetail request) {
/*  80 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/*  82 */       Optional<Integer> medicTestDevice = this.medicCheckinRecordRepository.findByMdId(request.getMdId());
/*  83 */       if (!medicTestDevice.isPresent()) {
/*  84 */         return this.apiError.getError("05", new String[0]);
/*     */       }
/*  86 */       if (request.getCreatedDate() == null) {
/*  87 */         request.setCreatedDate(new Date());
/*     */       }
/*  89 */       this.medicCheckinLiveDetailRepository.saveAndFlush(request);
/*  90 */       rs.put("status", "OK");
/*  91 */       rs.put("responseCode", "00");
/*  92 */       rs.put("data", "THANH CONG");
/*  93 */     } catch (Exception e) {
/*  94 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  95 */       logger.error(exceptionAsString);
/*  96 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  98 */     return rs;
/*     */   }
/*     */   
/*     */   @PutMapping({"/medic_checkin_live/edit/{id}"})
/*     */   public ApiResponse create(@PathVariable @Valid Integer id, @RequestBody MedicCheckinLiveDetail request) {
/* 103 */     ApiResponse rs = new ApiResponse();
/*     */     try {
/* 105 */       if (id == null) {
/* 106 */         return this.apiError.getError("02");
/*     */       }
/* 108 */       Optional<MedicCheckinLiveDetail> testDevice = this.medicCheckinLiveDetailRepository.findById(id);
/* 109 */       if (!testDevice.isPresent()) {
/* 110 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/* 112 */       this.medicCheckinLiveDetailRepository.saveAndFlush(request);
/*     */       
/* 114 */       rs.put("status", "OK");
/* 115 */       rs.put("responseCode", "00");
/* 116 */       rs.put("data", "THANH CONG");
/* 117 */     } catch (Exception e) {
/* 118 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 119 */       logger.error(exceptionAsString);
/* 120 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 122 */     return rs;
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/medic_checkin_live/delete/{id}"})
/*     */   public ApiResponse delete(@PathVariable @Valid Integer id) {
/* 127 */     ApiResponse rs = new ApiResponse();
/*     */     
/*     */     try {
/* 130 */       if (id == null) {
/* 131 */         return this.apiError.getError("02");
/*     */       }
/*     */       
/* 134 */       Optional<MedicCheckinLiveDetail> testDevice = this.medicCheckinLiveDetailRepository.findById(id);
/* 135 */       if (!testDevice.isPresent()) {
/* 136 */         return this.apiError.getError("02", new String[0]);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this.medicCheckinLiveDetailRepository.deleteById(id);
/*     */       
/* 142 */       rs.put("status", "OK");
/* 143 */       rs.put("responseCode", "00");
/*     */     }
/* 145 */     catch (Exception e) {
/* 146 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/* 147 */       logger.error(exceptionAsString);
/* 148 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/* 150 */     return rs;
/*     */   }
/*     */   
/*     */   private static XSLFConnectorShape createConnector(XSLFSlide slide, XSLFAutoShape shape1, XSLFAutoShape shape2) {
/* 154 */     XSLFConnectorShape connector = slide.createConnector();
/* 155 */     connector.setShapeType(ShapeType.CURVED_CONNECTOR_3);
/* 156 */     connector.setAnchor(new Rectangle2D.Double(shape1
/* 157 */           .getAnchor().getMaxX(), shape2
/* 158 */           .getAnchor().getCenterY(), shape2
/* 159 */           .getAnchor().getX() - shape1.getAnchor().getMaxX(), shape1
/* 160 */           .getAnchor().getCenterY() - shape2.getAnchor().getCenterY()));
/*     */     
/* 162 */     connector.setFlipVertical(true);
/*     */     
/* 164 */     CTConnector ctConnector = (CTConnector)connector.getXmlObject();
/* 165 */     CTNonVisualConnectorProperties cx = ctConnector.getNvCxnSpPr().getCNvCxnSpPr();
/* 166 */     CTConnection start = cx.addNewStCxn();
/* 167 */     start.setId(shape1.getShapeId());
/* 168 */     start.setIdx(3L);
/* 169 */     CTConnection end = cx.addNewEndCxn();
/* 170 */     end.setId(shape2.getShapeId());
/* 171 */     end.setIdx(1L);
/* 172 */     return connector;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) throws IOException {
/* 177 */     XMLSlideShow slideShow = new XMLSlideShow();
/*     */     
/* 179 */     XSLFSlide slide = slideShow.createSlide();
/*     */     
/* 181 */     XSLFAutoShape shape1 = slide.createAutoShape();
/* 182 */     shape1.setShapeType(ShapeType.RECT);
/* 183 */     shape1.setFillColor(Color.GREEN);
/* 184 */     shape1.setAnchor(new Rectangle(50, 150, 150, 100));
/*     */     
/* 186 */     XSLFAutoShape shape2 = slide.createAutoShape();
/* 187 */     shape2.setShapeType(ShapeType.RECT);
/* 188 */     shape2.setFillColor(Color.GREEN);
/* 189 */     shape2.setAnchor(new Rectangle(500, 50, 150, 100));
/*     */ 
/*     */     
/* 192 */     XSLFConnectorShape connector1 = createConnector(slide, shape1, shape2);
/* 193 */     CTConnector ctConnector = (CTConnector)connector1.getXmlObject();
/* 194 */     CTGeomGuideList ctGeomGuideList = ctConnector.getSpPr().getPrstGeom().getAvLst();
/* 195 */     CTGeomGuide ctGeomGuide = ctGeomGuideList.addNewGd();
/* 196 */     ctGeomGuide.setName("adj1");
/* 197 */     ctGeomGuide.setFmla("val 45000");
/*     */ 
/*     */     
/* 200 */     XSLFConnectorShape connector2 = createConnector(slide, shape1, shape2);
/* 201 */     ctConnector = (CTConnector)connector2.getXmlObject();
/* 202 */     ctGeomGuideList = ctConnector.getSpPr().getPrstGeom().getAvLst();
/* 203 */     ctGeomGuide = ctGeomGuideList.addNewGd();
/* 204 */     ctGeomGuide.setName("adj1");
/* 205 */     ctGeomGuide.setFmla("val 57365");
/*     */     
/* 207 */     FileOutputStream out = new FileOutputStream("C:\\Users\\dap.dv\\Downloads\\Telegram Desktop\\" + UUID.randomUUID().toString() + ".xlsx");
/* 208 */     slideShow.write(out);
/* 209 */     out.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Treatment\MedicCheckinLiveDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */