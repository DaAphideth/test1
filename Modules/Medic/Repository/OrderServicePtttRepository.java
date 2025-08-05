package nencer.app.Modules.Medic.Repository;

import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServicesPttt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServicePtttRepository extends JpaRepository<MedicOrderServicesPttt, Integer> {
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicOrderServicesPttt u WHERE u.orderServiceId=:orderServiceId AND u.ticketId=:ticketId")
  void deleteByOrderService(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT u FROM MedicOrderServicesPttt u WHERE u.orderServiceId=:orderServiceId AND u.ticketId=:ticketId")
  Optional<MedicOrderServicesPttt> findByOrderAndTicketId(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\OrderServicePtttRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */