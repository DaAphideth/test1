/*     */ package nencer.app.Utils;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConvertCurrentcyToString
/*     */ {
/*     */   public static final String KHONG = "ສູນ";
/*     */   public static final String MOT = "ໜື່ງ";
/*     */   public static final String HAI = "ສອງ";
/*     */   public static final String BA = "ສາມ";
/*     */   public static final String BON = "ສີ່";
/*     */   public static final String NAM = "ຫ້າ";
/*     */   public static final String SAU = "ຫົກ";
/*     */   public static final String BAY = "ເຈັດ";
/*     */   public static final String TAM = "ແປດ";
/*     */   public static final String CHIN = "ເກົ້າ";
/*     */   public static final String LAM = "lăm";
/*     */   public static final String LE = "lẻ";
/*     */   public static final String MUOI = "mươi";
/*     */   public static final String HAIMUOIF = "ຊາວ";
/*     */   public static final String MUOIF = "ສິບ";
/*     */   public static final String MOTS = "ແອັດ";
/*     */   public static final String TRAM = "ຮ້ອຍ";
/*     */   public static final String NGHIN = "ພັນ";
/*     */   public static final String TRAMNGHIN = "ແສນ";
/*     */   public static final String TRIEU = "ລ້ານ";
/*     */   public static final String TY = "ຕື້";
/*     */   public static final String CENT = "cent";
/*     */   public static final String AND = "và";
/*     */   public static final String USD = "ໂດລາ";
/*     */   public static final String KIP = "ກີບ";
/*  40 */   public static final String[] number = new String[] { "ສູນ", "ໜື່ງ", "ສອງ", "ສາມ", "ສີ່", "ຫ້າ", "ຫົກ", "ເຈັດ", "ແປດ", "ເກົ້າ" };
/*     */ 
/*     */   
/*     */   public static ArrayList<String> readNum(String a) {
/*  44 */     ArrayList<String> kq = new ArrayList<>();
/*     */ 
/*     */     
/*  47 */     ArrayList<String> List_Num = Split(a, 3);
/*     */     
/*  49 */     while (List_Num.size() != 0) {
/*     */       ArrayList<String> nghin, trieu;
/*  51 */       switch (List_Num.size() % 3) {
/*     */         
/*     */         case 1:
/*  54 */           kq.addAll(read_3num(List_Num.get(0)));
/*     */           break;
/*     */         
/*     */         case 2:
/*  58 */           nghin = read_3num(List_Num.get(0));
/*  59 */           if (!nghin.isEmpty()) {
/*  60 */             kq.addAll(nghin);
/*  61 */             kq.add("ພັນ");
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 0:
/*  66 */           trieu = read_3num(List_Num.get(0));
/*  67 */           if (!trieu.isEmpty()) {
/*  68 */             kq.addAll(trieu);
/*  69 */             kq.add("ລ້ານ");
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/*  75 */       if (List_Num.size() == List_Num.size() / 3 * 3 + 1 && List_Num.size() != 1) {
/*  76 */         kq.add("ຕື້");
/*     */       }
/*     */       
/*  79 */       List_Num.remove(0);
/*     */     } 
/*     */     
/*  82 */     return kq;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> read_3num(String a) {
/*  87 */     ArrayList<String> kq = new ArrayList<>();
/*  88 */     int num = -1;
/*     */     try {
/*  90 */       num = Integer.parseInt(a);
/*  91 */     } catch (Exception exception) {}
/*     */     
/*  93 */     if (num == 0) {
/*  94 */       return kq;
/*     */     }
/*  96 */     int hang_tram = -1;
/*     */     try {
/*  98 */       hang_tram = Integer.parseInt(a.substring(0, 1));
/*  99 */     } catch (Exception exception) {}
/*     */     
/* 101 */     int hang_chuc = -1;
/*     */     try {
/* 103 */       hang_chuc = Integer.parseInt(a.substring(1, 2));
/* 104 */     } catch (Exception exception) {}
/*     */     
/* 106 */     int hang_dv = -1;
/*     */     try {
/* 108 */       hang_dv = Integer.parseInt(a.substring(2, 3));
/* 109 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 113 */     if (hang_tram != -1) {
/* 114 */       kq.add(number[hang_tram]);
/* 115 */       kq.add("ຮ້ອຍ");
/*     */     } 
/*     */ 
/*     */     
/* 119 */     switch (hang_chuc) {
/*     */       case -1:
/*     */         break;
/*     */       case 1:
/* 123 */         kq.add("ສິບ");
/*     */         break;
/*     */       case 0:
/* 126 */         if (hang_dv != 0)
/* 127 */           kq.add("lẻ"); 
/*     */         break;
/*     */       default:
/* 130 */         kq.add(number[hang_chuc]);
/* 131 */         kq.add("mươi");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 136 */     switch (hang_dv)
/*     */     
/*     */     { 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1:
/* 159 */         return kq;
/*     */       case 1: if (hang_chuc != 0 && hang_chuc != 1 && hang_chuc != -1) { kq.add("ແອັດ"); } else { kq.add(number[hang_dv]); } 
/*     */       case 5: if (hang_chuc != 0 && hang_chuc != -1) { kq.add("lăm"); } else { kq.add(number[hang_dv]); } 
/*     */       case 0: if (kq.isEmpty())
/* 163 */           kq.add(number[hang_dv]);  }  kq.add(number[hang_dv]); } public static ArrayList<String> Split(String str, int chunkSize) { int du = str.length() % chunkSize;
/*     */ 
/*     */     
/* 166 */     if (du != 0)
/* 167 */       for (int i = 0; i < chunkSize - du; i++)
/* 168 */         str = "#" + str;  
/* 169 */     return splitStringEvery(str, chunkSize); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<String> splitStringEvery(String s, int interval) {
/* 174 */     ArrayList<String> arrList = new ArrayList<>();
/* 175 */     int arrayLength = (int)Math.ceil(s.length() / interval);
/* 176 */     String[] result = new String[arrayLength];
/* 177 */     int j = 0;
/* 178 */     int lastIndex = result.length - 1;
/* 179 */     for (int i = 0; i < lastIndex; i++) {
/* 180 */       result[i] = s.substring(j, j + interval);
/* 181 */       j += interval;
/*     */     } 
/* 183 */     result[lastIndex] = s.substring(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     arrList.addAll(Arrays.asList(result));
/* 191 */     return arrList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getCurrentName(String arg, Object beforeDecimal, Object afterDecimal) {
/* 196 */     beforeDecimal = "ກີບ";
/* 197 */     if (StringUtils.isEmpty(arg)) {
/* 198 */       return arg;
/*     */     }
/* 200 */     String cent = "";
/* 201 */     if (arg.lastIndexOf(",") != -1) {
/* 202 */       int lastIndex = arg.lastIndexOf(",");
/* 203 */       cent = arg.substring(lastIndex + 1);
/* 204 */       arg = arg.substring(0, lastIndex);
/*     */     } 
/* 206 */     arg = arg.replace(".", "");
/* 207 */     StringBuilder result = new StringBuilder();
/*     */ 
/*     */     
/* 210 */     ArrayList<String> kq = readNumLao(arg);
/* 211 */     for (String s : kq) {
/* 212 */       result.append(s).append(" ");
/*     */     }
/* 214 */     if (beforeDecimal != null) {
/* 215 */       result.append(beforeDecimal);
/*     */     }
/*     */     
/* 218 */     if (!StringUtils.isEmpty(cent) && Integer.parseInt(cent) > 0) {
/* 219 */       result.append(" ").append("ກີບ").append(" ");
/*     */ 
/*     */       
/* 222 */       kq = readNumLao(cent);
/* 223 */       for (String s : kq) {
/* 224 */         result.append(s).append(" ");
/*     */       }
/* 226 */       if (afterDecimal != null) {
/* 227 */         result.append(afterDecimal);
/*     */       }
/*     */     } 
/* 230 */     String string = result.toString();
/* 231 */     return string.substring(0, 1).toUpperCase() + string.substring(1);
/*     */   }
/*     */   
/*     */   public static String getUpperOneName(String arg, String beforeDecimal) {
/* 235 */     if (StringUtils.isEmpty(arg)) {
/* 236 */       return arg;
/*     */     }
/* 238 */     String val = arg + beforeDecimal;
/* 239 */     return val.substring(0, 1).toUpperCase() + val.substring(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> read_3numLao(String a, boolean isHangNghin, boolean isTramNghin) {
/* 244 */     ArrayList<String> kq = new ArrayList<>();
/* 245 */     int num = -1;
/*     */     try {
/* 247 */       num = Integer.parseInt(a);
/* 248 */     } catch (Exception exception) {}
/*     */     
/* 250 */     if (num == 0) {
/* 251 */       return kq;
/*     */     }
/* 253 */     int hang_tram = -1;
/*     */     try {
/* 255 */       hang_tram = Integer.parseInt(a.substring(0, 1));
/* 256 */     } catch (Exception exception) {}
/*     */     
/* 258 */     int hang_chuc = -1;
/*     */     try {
/* 260 */       hang_chuc = Integer.parseInt(a.substring(1, 2));
/* 261 */     } catch (Exception exception) {}
/*     */     
/* 263 */     int hang_dv = -1;
/*     */     try {
/* 265 */       hang_dv = Integer.parseInt(a.substring(2, 3));
/* 266 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     switch (hang_tram) {
/*     */       case -1:
/*     */       case 0:
/*     */         break;
/*     */       default:
/* 279 */         kq.add(number[hang_tram]);
/* 280 */         if (isHangNghin) {
/* 281 */           kq.add("ແສນ"); break;
/*     */         } 
/* 283 */         kq.add("ຮ້ອຍ");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 288 */     switch (hang_chuc) {
/*     */       case -1:
/*     */         break;
/*     */       case 1:
/* 292 */         kq.add("ສິບ");
/*     */         break;
/*     */       case 2:
/* 295 */         kq.add("ຊາວ");
/*     */         break;
/*     */       case 0:
/* 298 */         if (isTramNghin && hang_dv == 0 && hang_tram != 0) {
/* 299 */           kq.add("hangchuc");
/*     */         }
/*     */         break;
/*     */       
/*     */       default:
/* 304 */         kq.add(number[hang_chuc]);
/* 305 */         kq.add("ສິບ");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 310 */     switch (hang_dv)
/*     */     
/*     */     { 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1:
/* 333 */         return kq;
/*     */       case 1: if (hang_chuc != 0 && hang_chuc != -1) { kq.add("ແອັດ"); } else { kq.add(number[hang_dv]); } 
/*     */       case 5:
/*     */         kq.add(number[hang_dv]);
/*     */       case 0:
/*     */         if (kq.isEmpty())
/* 339 */           kq.add(number[hang_dv]);  }  kq.add(number[hang_dv]); } public static ArrayList<String> readNumLao(String a) { ArrayList<String> kq = new ArrayList<>();
/*     */ 
/*     */     
/* 342 */     ArrayList<String> List_Num = Split(a, 3);
/*     */     
/* 344 */     while (List_Num.size() != 0) {
/*     */       ArrayList<String> nghin; List<String> tramNghin; ArrayList<String> trieu;
/* 346 */       switch (List_Num.size() % 3) {
/*     */         
/*     */         case 1:
/* 349 */           kq.addAll(read_3numLao(List_Num.get(0), false, false));
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 354 */           nghin = read_3numLao(List_Num.get(0), true, true);
/* 355 */           tramNghin = (List<String>)nghin.stream().filter(x -> x.equals("hangchuc")).collect(Collectors.toList());
/* 356 */           if (!nghin.isEmpty() && tramNghin.isEmpty()) {
/* 357 */             kq.addAll(nghin);
/* 358 */             kq.add("ພັນ"); break;
/*     */           } 
/* 360 */           nghin.remove("hangchuc");
/* 361 */           kq.addAll(nghin);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 0:
/* 366 */           trieu = read_3numLao(List_Num.get(0), false, false);
/* 367 */           if (!trieu.isEmpty()) {
/* 368 */             kq.addAll(trieu);
/* 369 */             kq.add("ລ້ານ");
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 375 */       if (List_Num.size() == List_Num.size() / 3 * 3 + 1 && List_Num.size() != 1) {
/* 376 */         kq.add("ຕື້");
/*     */       }
/*     */       
/* 379 */       List_Num.remove(0);
/*     */     } 
/*     */     
/* 382 */     return kq; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ConvertCurrentcyToString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */