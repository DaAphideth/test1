/*    */ package nencer.app.Modules.Medic.Repository.Specification;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.persistence.criteria.CriteriaBuilder;
/*    */ import javax.persistence.criteria.CriteriaQuery;
/*    */ import javax.persistence.criteria.Expression;
/*    */ import javax.persistence.criteria.Join;
/*    */ import javax.persistence.criteria.JoinType;
/*    */ import javax.persistence.criteria.Predicate;
/*    */ import javax.persistence.criteria.Root;
/*    */ import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
/*    */ import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
/*    */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*    */ import org.springframework.data.jpa.domain.Specification;
/*    */ 
/*    */ public final class MedicTicketSpecification {
/* 19 */   public boolean equals(Object o) { return (o == this) ? true : (!!(o instanceof MedicTicketSpecification)); } public int hashCode() { int result = 1; return 1; } public String toString() { return "MedicTicketSpecification()"; }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Specification<MedicTicket> search(String checkinType) {
/* 24 */     return (root, query, builder) -> {
/*    */         List<Predicate> predicates = new ArrayList<>();
/*    */         Join<MedicTicket, MedicCheckinRecord> storehouseJoin = root.join("medicCheckinRecord", JoinType.LEFT);
/*    */         predicates.add(builder.equal((Expression)storehouseJoin.get("mdType"), checkinType));
/*    */         predicates.add(builder.like((Expression)root.get("ticketType"), "%" + TicketType.MEDIC_.getTicketType() + "%"));
/*    */         return builder.or(predicates.<Predicate>toArray(new Predicate[0]));
/*    */       };
/*    */   }
/*    */   
/*    */   public static Specification<MedicTicket> searchDepartment(Integer departmentId) {
/* 34 */     return (root, query, builder) -> {
/*    */         List<Predicate> predicates = new ArrayList<>();
/*    */         if (departmentId == null) {
/*    */           return builder.and(predicates.<Predicate>toArray(new Predicate[0]));
/*    */         }
/*    */         Join<MedicTicket, MedicCheckinRecord> storehouseJoin = root.join("medicCheckinRecord", JoinType.LEFT);
/*    */         predicates.add(builder.equal((Expression)storehouseJoin.get("departmentId"), departmentId));
/*    */         return builder.or(predicates.<Predicate>toArray(new Predicate[0]));
/*    */       };
/*    */   }
/*    */   
/*    */   public static Specification<MedicTicket> searchChamberId(Integer chamberId) {
/* 46 */     return (root, query, builder) -> {
/*    */         List<Predicate> predicates = new ArrayList<>();
/*    */         if (chamberId == null) {
/*    */           return builder.and(predicates.<Predicate>toArray(new Predicate[0]));
/*    */         }
/*    */         Join<MedicTicket, MedicCheckinRecord> medicCheckinRecordJoin = root.join("medicCheckinRecord", JoinType.LEFT);
/*    */         predicates.add(builder.equal((Expression)medicCheckinRecordJoin.get("chamberId"), chamberId));
/*    */         return builder.or(predicates.<Predicate>toArray(new Predicate[0]));
/*    */       };
/*    */   }
/*    */   
/*    */   public static Specification<MedicTicket> searchStorehouseId(Integer storehouseId) {
/* 58 */     return (root, query, builder) -> {
/*    */         List<Predicate> predicates = new ArrayList<>();
/*    */         if (storehouseId == null)
/*    */           return builder.and(predicates.<Predicate>toArray(new Predicate[0])); 
/*    */         Join<MedicTicket, MedicProductOrder> medicTicketMedicProductOrderJoin = root.join("medicProductOrder", JoinType.INNER);
/*    */         predicates.add(builder.equal((Expression)medicTicketMedicProductOrderJoin.get("storehouseId"), storehouseId));
/*    */         return builder.or(predicates.<Predicate>toArray(new Predicate[0]));
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Specification\MedicTicketSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */