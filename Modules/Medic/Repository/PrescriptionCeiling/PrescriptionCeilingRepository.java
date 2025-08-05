package nencer.app.Modules.Medic.Repository.PrescriptionCeiling;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.PrescriptionCeiling.MedicPrescriptionCeiling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionCeilingRepository extends JpaRepository<MedicPrescriptionCeiling, Integer> {
  Optional<MedicPrescriptionCeiling> findByDiagnosticCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\PrescriptionCeiling\PrescriptionCeilingRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */