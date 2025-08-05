/*    */ package nencer.app.Modules.Users.Repository.specifications;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import javax.persistence.criteria.CriteriaBuilder;
/*    */ import javax.persistence.criteria.Expression;
/*    */ import javax.persistence.criteria.Predicate;
/*    */ import javax.persistence.criteria.Root;
/*    */ import nencer.app.Constant.QueryOperator;
/*    */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*    */ import nencer.app.Modules.Users.Entity.User.Users;
/*    */ 
/*    */ public class UserSpecification implements Specification<Users> {
/*    */   private List<SearchCriteria> criterias;
/*    */   
/* 17 */   public void setCriterias(List<SearchCriteria> criterias) { this.criterias = criterias; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof UserSpecification)) return false;  UserSpecification other = (UserSpecification)o; if (!other.canEqual(this)) return false;  Object<SearchCriteria> this$criterias = (Object<SearchCriteria>)getCriterias(), other$criterias = (Object<SearchCriteria>)other.getCriterias(); return !((this$criterias == null) ? (other$criterias != null) : !this$criterias.equals(other$criterias)); } protected boolean canEqual(Object other) { return other instanceof UserSpecification; } public int hashCode() { int PRIME = 59; result = 1; Object<SearchCriteria> $criterias = (Object<SearchCriteria>)getCriterias(); return result * 59 + (($criterias == null) ? 43 : $criterias.hashCode()); } public String toString() { return "UserSpecification(criterias=" + getCriterias() + ")"; } public UserSpecification(List<SearchCriteria> criterias) {
/* 18 */     this.criterias = criterias;
/*    */   }
/*    */   public List<SearchCriteria> getCriterias() {
/* 21 */     return this.criterias;
/*    */   }
/*    */   public UserSpecification() {
/* 24 */     this.criterias = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public void add(SearchCriteria criteria) {
/* 28 */     this.criterias.add(criteria);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
/* 35 */     List<Predicate> predicates = new ArrayList<>();
/* 36 */     if (this.criterias == null) return criteriaBuilder.and(predicates.<Predicate>toArray(new Predicate[0])); 
/* 37 */     for (SearchCriteria criteria : this.criterias) {
/* 38 */       switch (criteria.getOperator()) {
/*    */         case GREATER_THAN:
/* 40 */           predicates.add(criteriaBuilder
/* 41 */               .greaterThan((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*    */ 
/*    */ 
/*    */         
/*    */         case LESS_THAN:
/* 46 */           predicates.add(criteriaBuilder
/* 47 */               .lessThan((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*    */ 
/*    */         
/*    */         case LESS_THAN_EQUAL:
/* 51 */           predicates.add(criteriaBuilder
/* 52 */               .lessThanOrEqualTo((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*    */ 
/*    */         
/*    */         case GREATER_THAN_EQUAL:
/* 56 */           predicates.add(criteriaBuilder
/* 57 */               .greaterThanOrEqualTo((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*    */         
/*    */         case NOT_EQUALS:
/* 60 */           predicates.add(criteriaBuilder.notEqual((Expression)root.get(criteria.getField()), criteria.getValue()));
/*    */ 
/*    */         
/*    */         case EQUALS:
/* 64 */           predicates.add(criteriaBuilder.equal((Expression)root.get(criteria.getField()), criteria.getValue()));
/*    */ 
/*    */         
/*    */         case LIKE:
/* 68 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), "%" + criteria.getValue().toString().toUpperCase(Locale.ROOT) + "%"));
/*    */ 
/*    */         
/*    */         case LIKE_START:
/* 72 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), "%" + criteria.getValue().toString().toUpperCase(Locale.ROOT)));
/*    */ 
/*    */         
/*    */         case LIKE_END:
/* 76 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), criteria.getValue().toString().toUpperCase(Locale.ROOT) + "%"));
/*    */ 
/*    */         
/*    */         case IN:
/* 80 */           predicates.add(criteriaBuilder.in((Expression)root.get(criteria.getField())).value(criteria.getValue()));
/*    */ 
/*    */         
/*    */         case NOT_IN:
/* 84 */           predicates.add(criteriaBuilder.not((Expression)root.get(criteria.getField())).in(new Object[] { criteria.getValue() }));
/*    */       } 
/*    */ 
/*    */     
/*    */     } 
/* 89 */     return criteriaBuilder.and(predicates.<Predicate>toArray(new Predicate[0]));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\specifications\UserSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */