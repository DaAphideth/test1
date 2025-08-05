package nencer.app.Modules.Storehouse.Repository;

import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import nencer.app.Modules.Storehouse.Entity.MedicProductOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductOrderDetailRepository extends JpaRepository<MedicProductOrderDetail, Integer>, JpaSpecificationExecutor<MedicProductOrderDetail> {
  Optional<MedicProductOrderDetail> findByProductIdAndOrderId(Integer paramInteger1, Integer paramInteger2);
  
  Optional<MedicProductOrderDetail> findByInvenIdAndOrderId(Integer paramInteger1, Integer paramInteger2);
  
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicProductOrderDetail a WHERE a.orderId=:orderId AND a.productId=:productId")
  void deleteByOrderId(@Param("orderId") Integer paramInteger1, @Param("productId") Integer paramInteger2);
  
  Optional<Set<MedicProductOrderDetail>> findAllByOrderId(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("update MedicProductOrderDetail set serviceObject = :serviceObjectCode where id = :id ")
  void updatePaymentObject(Integer paramInteger, String paramString);
  
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicProductOrderDetail a WHERE a.id=:id")
  void deleteById(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductOrderDetailRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */