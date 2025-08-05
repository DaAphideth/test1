package nencer.app.Modules.Medic.Repository.Treatment;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.TreatmentDetail.MedicCheckinMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicCheckinMedicalRecordRepository extends JpaRepository<MedicCheckinMedicalRecord, Integer> {
  Optional<MedicCheckinMedicalRecord> findByMdId(int paramInt);
  
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicCheckinMedicalRecord s where s.mdId =:mdId")
  void deleteByMdId(@Param("mdId") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Treatment\MedicCheckinMedicalRecordRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */