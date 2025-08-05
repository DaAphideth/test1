/*   */ package nencer.app.Utils;
/*   */ 
/*   */ import com.fasterxml.jackson.annotation.JsonInclude;
/*   */ import java.util.TreeMap;
/*   */ 
/*   */ @JsonInclude(JsonInclude.Include.NON_NULL)
/*   */ public class ApiResponse extends TreeMap<String, Object> {
/* 8 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ApiResponse)) return false;  ApiResponse other = (ApiResponse)o; return !!other.canEqual(this); } protected boolean canEqual(Object other) { return other instanceof ApiResponse; } public int hashCode() { int result = 1; return 1; } public String toString() { return "ApiResponse()"; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\ApiResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */