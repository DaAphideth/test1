package nencer.app.Modules.Medic.Repository.Checkin;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends JpaRepository<MedicCheckin, Integer>, JpaSpecificationExecutor<MedicCheckin> {
  Optional<List<MedicCheckin>> findByPatientIdOrderByUpdatedAtDesc(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckin u set u.status = :status where u.id = :checkinId")
  void updateStatus(@Param("checkinId") Integer paramInteger, @Param("status") String paramString);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckin u set u.number = :number where u.id = :checkinId")
  void updateStt(@Param("checkinId") Integer paramInteger1, @Param("number") Integer paramInteger2);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckin u set u.roomId = :roomId, u.serviceId=:serviceId where u.id = :checkinId")
  void updateNewCheckinRecord(@Param("roomId") Integer paramInteger1, @Param("serviceId") Integer paramInteger2, @Param("checkinId") Integer paramInteger3);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckin u set u.paymentStatus = :status where u.id = :checkinId")
  void updatePaymentStatus(@Param("checkinId") Integer paramInteger, @Param("status") String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\CheckinRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */