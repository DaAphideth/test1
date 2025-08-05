/*     */ package nencer.app.Utils;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.text.DateFormat;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ public class ApiHelper
/*     */ {
/*     */   private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
/*  15 */   private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
/*  16 */   private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */   private static final String TIME_DATE_FORMAT = "HH:mm dd/MM/yyyy";
/*     */   private static final String FORMAT_DATE = " dd/MM/yyyy";
/*     */   private static final String TIME = "HH:mm";
/*     */   private static final String DAY = "dd";
/*     */   private static final String MONTH = "MM";
/*     */   private static final String YEAR = "yyyy";
/*     */   
/*     */   public static String dateToString(Date date) {
/*  25 */     if (date == null) return ""; 
/*  26 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
/*  27 */     return dateFormat.format(date);
/*     */   }
/*     */   
/*     */   public static String dateToString(Date date, String formatDate) {
/*  31 */     if (date == null) return ""; 
/*  32 */     DateFormat dateFormat = new SimpleDateFormat(formatDate);
/*  33 */     return dateFormat.format(date);
/*     */   }
/*     */   
/*     */   public static String dateToString1(Date date) {
/*  37 */     if (date == null) return ""; 
/*  38 */     DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
/*  39 */     return dateFormat.format(date);
/*     */   }
/*     */   
/*     */   public static String dateToString2(Date date) {
/*  43 */     if (date == null) return ""; 
/*  44 */     DateFormat dateFormat = new SimpleDateFormat(" dd/MM/yyyy");
/*  45 */     return dateFormat.format(date);
/*     */   }
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
/*     */   public static String formatDate(String format) {
/*  77 */     DateFormat dateFormat = new SimpleDateFormat(format);
/*  78 */     return dateFormat.format(new Date());
/*     */   }
/*     */   
/*     */   public static String formatDate() {
/*  82 */     DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
/*  83 */     return dateFormat.format(new Date());
/*     */   }
/*     */   
/*     */   private Date parseDate(String date) {
/*     */     try {
/*  88 */       return this.DATE_FORMAT.parse(date);
/*  89 */     } catch (ParseException e) {
/*  90 */       throw new IllegalArgumentException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Date parseTimestamp(String timestamp) {
/*     */     try {
/*  96 */       return this.DATE_TIME_FORMAT.parse(timestamp);
/*  97 */     } catch (ParseException e) {
/*  98 */       throw new IllegalArgumentException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String timeDate(Date date) {
/* 103 */     if (date == null) return ""; 
/* 104 */     DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
/* 105 */     return dateFormat.format(date);
/*     */   }
/*     */   
/*     */   private long getMinutes(Date input) {
/* 109 */     long date = (new Date()).getTime() - input.getTime();
/* 110 */     long diffMinutes = date / 60000L % 60L;
/* 111 */     return diffMinutes;
/*     */   }
/*     */   
/*     */   public static Integer getAge(String year) {
/* 115 */     if (StringUtils.isBlank(year)) {
/* 116 */       return Integer.valueOf(0);
/*     */     }
/* 118 */     Calendar cal = Calendar.getInstance();
/* 119 */     cal.setTime(new Date());
/* 120 */     Integer ag = Integer.valueOf(cal.get(1) - Integer.parseInt(year));
/* 121 */     return Integer.valueOf((ag.intValue() <= 0) ? 1 : ag.intValue());
/*     */   }
/*     */   
/*     */   public static Date addDay(Date date, int i) {
/* 125 */     Calendar cal = Calendar.getInstance();
/* 126 */     cal.setTime(date);
/* 127 */     cal.add(6, i);
/* 128 */     return cal.getTime();
/*     */   }
/*     */   
/*     */   public static Date addHoursToJavaUtilDate(Date date, int hours) {
/* 132 */     if (date == null) return null; 
/* 133 */     Calendar calendar = Calendar.getInstance();
/* 134 */     calendar.setTime(date);
/* 135 */     calendar.add(11, hours);
/* 136 */     return calendar.getTime();
/*     */   }
/*     */   
/*     */   public static String padLeftZeros(long inputString, int length) {
/* 140 */     return String.format("%1$" + length + "s", new Object[] { Long.valueOf(inputString) }).replace(' ', '0');
/*     */   }
/*     */   
/*     */   public static String padLeftZeros1(String inputString, int length) {
/* 144 */     return String.format("%1$" + length + "s", new Object[] { inputString }).replace(' ', '0');
/*     */   }
/*     */   
/*     */   public static String generatePartientNumber(Integer num) {
/* 148 */     return formatDate() + "-" + padLeftZeros(num.intValue(), 6);
/*     */   }
/*     */   
/*     */   public static String generateTakeNumber(Integer num, String key) {
/* 152 */     return key + formatDate() + padLeftZeros(num.intValue(), 6);
/*     */   }
/*     */   
/*     */   public static String generateBarCode(Integer num, Integer max) {
/* 156 */     return formatDate() + padLeftZeros(num.intValue(), max.intValue());
/*     */   }
/*     */   
/*     */   public static String getBarCode(Integer num, Integer max) {
/* 160 */     return padLeftZeros(num.intValue(), max.intValue());
/*     */   }
/*     */   
/*     */   public static String convertJsonObjectToString(Object value) {
/*     */     try {
/* 165 */       ObjectMapper mapper = new ObjectMapper();
/* 166 */       String jsonString = mapper.writeValueAsString(value);
/* 167 */       return jsonString;
/* 168 */     } catch (Exception var3) {
/* 169 */       return "";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String formatDecimal(Object number) {
/* 174 */     if (number == null) return "0"; 
/* 175 */     DecimalFormat formatter = new DecimalFormat("###,###,###");
/* 176 */     return formatter.format(number);
/*     */   }
/*     */   
/*     */   public static String limit2(String limit2) {
/* 180 */     String[] lm2 = limit2.split("\\.");
/* 181 */     StringBuilder str = new StringBuilder();
/* 182 */     if (lm2 != null && lm2.length > 0) {
/* 183 */       str.append(lm2[0] + ".");
/* 184 */       str.append(lm2[1].replace("2200", "2223") + ".");
/* 185 */       str.append(lm2[2]);
/*     */     } else {
/* 187 */       str.append(limit2);
/*     */     } 
/*     */     
/* 190 */     return str.toString();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 194 */     System.out.println(limit2("200022003.0002200.03"));
/* 195 */     System.out.println(limit2("20002200.0002200.01"));
/* 196 */     System.out.println(limit2("12000220015.0002200.01"));
/* 197 */     System.out.println(limit2("12000220015.0002200.99"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ApiHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */