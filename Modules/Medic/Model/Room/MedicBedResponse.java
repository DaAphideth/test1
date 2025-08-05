/*    */ package nencer.app.Modules.Medic.Model.Room;
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class MedicBedResponse { private Integer id; private String name;
/*    */   private String code;
/*    */   
/*  6 */   public void setId(Integer id) { this.id = id; } private String codeBhyt; private Integer chamberId; private String chamberName; private Integer totalRecord; public void setName(String name) { this.name = name; } public void setCode(String code) { this.code = code; } public void setCodeBhyt(String codeBhyt) { this.codeBhyt = codeBhyt; } public void setChamberId(Integer chamberId) { this.chamberId = chamberId; } public void setChamberName(String chamberName) { this.chamberName = chamberName; } public void setTotalRecord(Integer totalRecord) { this.totalRecord = totalRecord; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof MedicBedResponse)) return false;  MedicBedResponse other = (MedicBedResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$codeBhyt = getCodeBhyt(), other$codeBhyt = other.getCodeBhyt(); if ((this$codeBhyt == null) ? (other$codeBhyt != null) : !this$codeBhyt.equals(other$codeBhyt)) return false;  Object this$chamberId = getChamberId(), other$chamberId = other.getChamberId(); if ((this$chamberId == null) ? (other$chamberId != null) : !this$chamberId.equals(other$chamberId)) return false;  Object this$chamberName = getChamberName(), other$chamberName = other.getChamberName(); if ((this$chamberName == null) ? (other$chamberName != null) : !this$chamberName.equals(other$chamberName)) return false;  Object this$totalRecord = getTotalRecord(), other$totalRecord = other.getTotalRecord(); return !((this$totalRecord == null) ? (other$totalRecord != null) : !this$totalRecord.equals(other$totalRecord)); } protected boolean canEqual(Object other) { return other instanceof MedicBedResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $codeBhyt = getCodeBhyt(); result = result * 59 + (($codeBhyt == null) ? 43 : $codeBhyt.hashCode()); Object $chamberId = getChamberId(); result = result * 59 + (($chamberId == null) ? 43 : $chamberId.hashCode()); Object $chamberName = getChamberName(); result = result * 59 + (($chamberName == null) ? 43 : $chamberName.hashCode()); Object $totalRecord = getTotalRecord(); return result * 59 + (($totalRecord == null) ? 43 : $totalRecord.hashCode()); } public String toString() { return "MedicBedResponse(id=" + getId() + ", name=" + getName() + ", code=" + getCode() + ", codeBhyt=" + getCodeBhyt() + ", chamberId=" + getChamberId() + ", chamberName=" + getChamberName() + ", totalRecord=" + getTotalRecord() + ")"; }
/*    */ 
/*    */   
/*  9 */   public Integer getId() { return this.id; }
/* 10 */   public String getName() { return this.name; }
/* 11 */   public String getCode() { return this.code; }
/* 12 */   public String getCodeBhyt() { return this.codeBhyt; }
/* 13 */   public Integer getChamberId() { return this.chamberId; }
/* 14 */   public String getChamberName() { return this.chamberName; } public Integer getTotalRecord() {
/* 15 */     return this.totalRecord;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Model\Room\MedicBedResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */