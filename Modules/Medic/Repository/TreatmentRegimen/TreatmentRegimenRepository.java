package nencer.app.Modules.Medic.Repository.TreatmentRegimen;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicTreatmentRegimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRegimenRepository extends JpaRepository<MedicTreatmentRegimen, Integer> {
  Optional<MedicTreatmentRegimen> findByRegimenName(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TreatmentRegimen\TreatmentRegimenRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */