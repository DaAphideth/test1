package nencer.app.Modules.Medic.Repository.TreatmentRegimen;

import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenDiagnostic;
import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenDiagnosticPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimenDiagnosticRepository extends JpaRepository<MedicRegimenDiagnostic, MedicRegimenDiagnosticPK> {
  @Modifying
  @Transactional
  @Query("delete from MedicRegimenDiagnostic a where a.regimenId =:regimenId")
  void deleteRegimenId(@Param("regimenId") int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TreatmentRegimen\RegimenDiagnosticRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */