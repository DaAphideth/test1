package nencer.app.Modules.Medic.Repository.Examination;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Examination.MedicExaminationResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExaminationResultRepository extends JpaRepository<MedicExaminationResults, Integer> {
  Optional<MedicExaminationResults> findByMdId(Integer paramInteger);
  
  @Transactional
  @Modifying
  @Query("DELETE FROM MedicExaminationResults u WHERE u.mdId=:mdId")
  void deleteByMdId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Examination\ExaminationResultRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */