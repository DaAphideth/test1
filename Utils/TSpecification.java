/*     */ package nencer.app.Utils;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.persistence.criteria.CriteriaBuilder;
/*     */ import javax.persistence.criteria.CriteriaQuery;
/*     */ import javax.persistence.criteria.Expression;
/*     */ import javax.persistence.criteria.Predicate;
/*     */ import javax.persistence.criteria.Root;
/*     */ import nencer.app.Constant.QueryOperator;
/*     */ import nencer.app.Modules.Medic.Model.Fillter.SearchCriteria;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ 
/*     */ public class TSpecification<T> implements Specification<T> {
/*  18 */   public void setCriterias(List<SearchCriteria> criterias) { this.criterias = criterias; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof TSpecification)) return false;  TSpecification<?> other = (TSpecification)o; if (!other.canEqual(this)) return false;  Object<SearchCriteria> this$criterias = (Object<SearchCriteria>)getCriterias(), other$criterias = (Object<SearchCriteria>)other.getCriterias(); return !((this$criterias == null) ? (other$criterias != null) : !this$criterias.equals(other$criterias)); } protected boolean canEqual(Object other) { return other instanceof TSpecification; } public int hashCode() { int PRIME = 59; result = 1; Object<SearchCriteria> $criterias = (Object<SearchCriteria>)getCriterias(); return result * 59 + (($criterias == null) ? 43 : $criterias.hashCode()); } public String toString() { return "TSpecification(criterias=" + getCriterias() + ")"; }
/*     */ 
/*     */   
/*  21 */   private List<SearchCriteria> criterias = new ArrayList<>(); public List<SearchCriteria> getCriterias() { return this.criterias; }
/*     */   
/*     */   public TSpecification() {
/*  24 */     this.criterias = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public TSpecification(List<SearchCriteria> criterias) {
/*  28 */     this.criterias = (List<SearchCriteria>)criterias.stream().filter(f -> !ObjectUtils.isEmpty(f.getValue())).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public void add(SearchCriteria criteria) {
/*  32 */     this.criterias.add(criteria);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
/*  38 */     List<Predicate> predicates = new ArrayList<>();
/*     */     
/*  40 */     if (this.criterias == null) return criteriaBuilder.and(predicates.<Predicate>toArray(new Predicate[0])); 
/*  41 */     for (SearchCriteria criteria : this.criterias) {
/*  42 */       switch (criteria.getOperator()) {
/*     */         case GREATER_THAN:
/*  44 */           predicates.add(criteriaBuilder
/*  45 */               .greaterThan((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*     */ 
/*     */ 
/*     */         
/*     */         case LESS_THAN:
/*  50 */           predicates.add(criteriaBuilder
/*  51 */               .lessThan((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*     */ 
/*     */ 
/*     */         
/*     */         case LESS_THAN_EQUAL:
/*  56 */           predicates.add(criteriaBuilder
/*  57 */               .lessThanOrEqualTo((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*     */ 
/*     */         
/*     */         case GREATER_THAN_EQUAL:
/*  61 */           predicates.add(criteriaBuilder
/*  62 */               .greaterThanOrEqualTo((Expression)root.get(criteria.getField()), criteria.getValue().toString()));
/*     */         
/*     */         case NOT_EQUALS:
/*  65 */           predicates.add(criteriaBuilder.notEqual((Expression)root.get(criteria.getField()), criteria.getValue()));
/*     */ 
/*     */         
/*     */         case EQUALS:
/*  69 */           predicates.add(criteriaBuilder.equal((Expression)root.get(criteria.getField()), criteria.getValue()));
/*     */ 
/*     */         
/*     */         case LIKE:
/*  73 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), "%" + criteria.getValue().toString().toUpperCase(Locale.ROOT) + "%"));
/*     */ 
/*     */         
/*     */         case LIKE_START:
/*  77 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), "%" + criteria.getValue().toString().toUpperCase(Locale.ROOT)));
/*     */ 
/*     */         
/*     */         case LIKE_END:
/*  81 */           predicates.add(criteriaBuilder.like((Expression)root.get(criteria.getField()), criteria.getValue().toString().toUpperCase(Locale.ROOT) + "%"));
/*     */ 
/*     */         
/*     */         case IN:
/*  85 */           predicates.add(criteriaBuilder.in((Expression)root.get(criteria.getField())).value(criteria.getValue()));
/*     */ 
/*     */ 
/*     */         
/*     */         case NOT_IN:
/*  90 */           predicates.add(criteriaBuilder.not((Expression)criteriaBuilder.in((Expression)root.get(criteria.getField())).value(criteria.getValue())));
/*     */ 
/*     */         
/*     */         case IS_NOT_NULL:
/*  94 */           predicates.add(criteriaBuilder.isNotNull((Expression)root.get(criteria.getField())).in(new Object[] { criteria.getValue() }));
/*     */ 
/*     */         
/*     */         case IS_NULL:
/*  98 */           predicates.add(criteriaBuilder.isNull((Expression)root.get(criteria.getField())).in(new Object[] { criteria.getValue() }));
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 103 */     Predicate predicateAnd = criteriaBuilder.and(predicates.<Predicate>toArray(new Predicate[0]));
/* 104 */     return predicateAnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\TSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */