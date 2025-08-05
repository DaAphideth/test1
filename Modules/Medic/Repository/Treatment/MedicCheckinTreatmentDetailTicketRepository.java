package nencer.app.Modules.Medic.Repository.Treatment;

import java.util.List;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinTreatmentDetailTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicCheckinTreatmentDetailTicketRepository extends JpaRepository<MedicCheckinTreatmentDetailTicket, Integer> {
  @Transactional
  @Modifying
  @Query("DELETE FROM MedicCheckinTreatmentDetailTicket a where a.ticketId = :ticketId")
  void deleteByTicketId(Integer paramInteger);
  
  @Transactional
  @Modifying
  @Query("DELETE FROM MedicCheckinTreatmentDetailTicket a where a.treatmentId = :treatmentId")
  void deleteByTreatmentId(Integer paramInteger);
  
  @Transactional
  @Modifying
  @Query("DELETE FROM MedicCheckinTreatmentDetailTicket a where a.treatmentId = :treatmentId AND a.ticketId=:ticketId")
  void deleteByTreatmentIdAndTicketId(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT u FROM MedicCheckinTreatmentDetailTicket u where u.treatmentId=:treatmentId")
  List<MedicCheckinTreatmentDetailTicket> findAllByTreatmentId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Treatment\MedicCheckinTreatmentDetailTicketRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */