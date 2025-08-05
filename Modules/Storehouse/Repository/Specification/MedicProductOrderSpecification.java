/*    */ package nencer.app.Modules.Storehouse.Repository.Specification;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import java.util.List;
/*    */ import javax.persistence.criteria.CriteriaBuilder;
/*    */ import javax.persistence.criteria.Join;
/*    */ import javax.persistence.criteria.Predicate;
/*    */ import javax.persistence.criteria.Root;
/*    */ import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
/*    */ 
/*    */ public final class MedicProductOrderSpecification {
/* 12 */   public boolean equals(Object o) { return (o == this) ? true : (!!(o instanceof MedicProductOrderSpecification)); } public int hashCode() { int result = 1; return 1; } public String toString() { return "MedicProductOrderSpecification()"; }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Specification<MedicProductOrder> search(String searchValue) {
/* 17 */     return (root, query, builder) -> {
/*    */         List<Predicate> predicates = new ArrayList<>();
/*    */         Join<MedicProductOrder, MedicProductStorehouse> storehouseJoin = root.join("medicProductStorehouse");
/*    */         predicates.add(builder.like((Expression)root.get("code"), "%" + searchValue + "%"));
/*    */         predicates.add(builder.like((Expression)storehouseJoin.get("name"), "%" + searchValue + "%"));
/*    */         return builder.or(predicates.<Predicate>toArray(new Predicate[0]));
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\Specification\MedicProductOrderSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */