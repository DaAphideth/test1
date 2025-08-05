/*     */ package nencer.app.Modules.Medic.Controller.Service;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Medic.Controller.BaseMedicController;
/*     */ import nencer.app.Modules.Medic.Model.EgwBHYT.NhanLichSuKCB2018;
/*     */ import nencer.app.Modules.Medic.Model.EgwBHYT.NhanThongTinCSKCB;
/*     */ import nencer.app.Modules.Medic.Model.EgwBHYT.TakeToken;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceRepository;
/*     */ import nencer.app.Modules.Medic.Repository.Service.ServiceTypeRepository;
/*     */ import nencer.app.Utils.ApiError;
/*     */ import nencer.app.Utils.ApiResponse;
/*     */ import nencer.app.Utils.MSClientUtil;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
/*     */ @RequestMapping({"/api"})
/*     */ public class BHYTGateWayController
/*     */   extends BaseMedicController
/*     */ {
/*  40 */   public static final Logger logger = LoggerFactory.getLogger(BHYTGateWayController.class);
/*     */   
/*     */   @Autowired
/*     */   ApiError apiError;
/*     */   
/*     */   @Autowired
/*     */   ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   ServiceTypeRepository serviceTypeRepository;
/*     */   
/*     */   @Autowired
/*     */   ServiceRepository serviceRepository;
/*     */   
/*     */   @Autowired
/*     */   MSClientUtil msClientUtil;
/*     */ 
/*     */   
/*     */   @GetMapping({"/egw/getToken"})
/*     */   public ApiResponse getToken() {
/*  60 */     ApiResponse rs = new ApiResponse();
/*  61 */     Map<String, Object> data = new HashMap<>();
/*     */     try {
/*  63 */       rs.put("status", "OK");
/*  64 */       rs.put("responseCode", "00");
/*  65 */       rs.put("data", takeToken("getToken", "26193_BV", "2739fff2ec86bd3a308fe543c945c623"));
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       String exceptionAsString = ExceptionUtils.getStackTrace(e);
/*  69 */       logger.error(exceptionAsString);
/*  70 */       return this.apiError.getError("999", new String[] { exceptionAsString });
/*     */     } 
/*  72 */     return rs;
/*     */   }
/*     */   
/*     */   private TakeToken takeToken(String prefixLog, String username, String passWord) {
/*  76 */     TakeToken t = null;
/*     */     try {
/*  78 */       Map<String, String> map = new HashMap<>();
/*  79 */       map.put("username", username);
/*  80 */       map.put("password", passWord);
/*  81 */       String res = this.msClientUtil.callRestAPISync(prefixLog, this.objectMapper.writeValueAsString(map), "https://egw.baohiemxahoi.gov.vn/api/token/take");
/*  82 */       TakeToken tt = (TakeToken)this.objectMapper.readValue(res, new TypeReference<TakeToken>() {  }
/*     */         );
/*  84 */       return tt;
/*  85 */     } catch (Exception ex) {
/*  86 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/*  87 */       logger.error(exceptionAsString);
/*  88 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private NhanThongTinCSKCB NhanThongTinCSKCB(String prefixLog, String username, String passWord, String token, String id_token, String macskcb) {
/*  93 */     NhanThongTinCSKCB t = null;
/*     */     try {
/*  95 */       Map<String, String> map = new HashMap<>();
/*  96 */       map.put("username", username);
/*  97 */       map.put("password", passWord);
/*  98 */       String url = "http://egw.baohiemxahoi.gov.vn/api/egw/NhanThongTinCSKCB";
/*  99 */       String uri = String.format(url + "?username=%s&password=%s&token=%s&id_token=%s&macskcb=%s", new Object[] { username, passWord, token, id_token, macskcb });
/* 100 */       String res = this.msClientUtil.callRestAPISync(prefixLog, this.objectMapper.writeValueAsString(map), uri);
/* 101 */       NhanThongTinCSKCB tt = (NhanThongTinCSKCB)this.objectMapper.readValue(res, new TypeReference<NhanThongTinCSKCB>() {  }
/*     */         );
/* 103 */       return tt;
/* 104 */     } catch (Exception ex) {
/* 105 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 106 */       logger.error(exceptionAsString);
/* 107 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private NhanLichSuKCB2018 NhanLichSuKCB2018(String prefixLog, String username, String passWord, String token, String id_token, String mathe, String hoTen, String ngaySinh) {
/* 112 */     NhanLichSuKCB2018 t = null;
/*     */     try {
/* 114 */       Map<String, String> map = new HashMap<>();
/* 115 */       map.put("mathe", mathe);
/* 116 */       map.put("hoTen", hoTen);
/* 117 */       map.put("ngaySinh", ngaySinh);
/* 118 */       String url = "http://egw.baohiemxahoi.gov.vn/api/egw/NhanLichSuKCB2018";
/* 119 */       String uri = String.format(url + "?username=%s&password=%s&token=%s&id_token=%s", new Object[] { username, passWord, token, id_token });
/* 120 */       String res = this.msClientUtil.callRestAPISync(prefixLog, this.objectMapper.writeValueAsString(map), uri);
/* 121 */       NhanLichSuKCB2018 tt = (NhanLichSuKCB2018)this.objectMapper.readValue(res, new TypeReference<NhanLichSuKCB2018>() {  }
/*     */         );
/* 123 */       return tt;
/* 124 */     } catch (Exception ex) {
/* 125 */       String exceptionAsString = ExceptionUtils.getStackTrace(ex);
/* 126 */       logger.error(exceptionAsString);
/* 127 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Controller\Service\BHYTGateWayController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */