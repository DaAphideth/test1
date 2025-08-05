package nencer.app.Modules.Medic.Repository.Examination;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Examination.MedicExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<MedicExamination, Integer> {
  Optional<MedicExamination> findByMdId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Examination\ExaminationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */