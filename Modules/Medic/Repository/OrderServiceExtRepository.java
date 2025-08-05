package nencer.app.Modules.Medic.Repository;

import java.util.List;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Service.MedicOrderServicesExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceExtRepository extends JpaRepository<MedicOrderServicesExt, Integer> {
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicOrderServicesExt u WHERE u.orderServiceId=:orderServiceId")
  void deleteByOrderService(Integer paramInteger);
  
  List<MedicOrderServicesExt> findAllByOrderServiceId(Integer paramInteger);
  
  @Query("SELECT u.id FROM MedicOrderServicesExt u WHERE u.serviceId=:serviceId and u.ticketId=:ticketId")
  Integer getByServiceIdAndTicketId(Integer paramInteger1, Integer paramInteger2);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServicesExt  m Set m.handlerResult=:handlerResult, m.deviceResult=:deviceResult WHERE m.id=:id")
  void updateResult(@Param("id") Integer paramInteger, @Param("handlerResult") String paramString1, @Param("deviceResult") String paramString2);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServicesExt  m Set m.originalResult=:lisOriginal,m.handlerResult=:deviceResult, m.deviceResult=:deviceResult WHERE m.id=:id")
  void updateResultRoche(@Param("id") Integer paramInteger, @Param("deviceResult") String paramString1, @Param("lisOriginal") String paramString2);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\OrderServiceExtRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */