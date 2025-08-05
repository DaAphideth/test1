package nencer.app.Modules.Medic.Repository.TreatmentRegimen;

import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenDiagnosticPK;
import nencer.app.Modules.Medic.Entity.TreatmentRegimen.MedicRegimenService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegimenServiceRepository extends JpaRepository<MedicRegimenService, MedicRegimenDiagnosticPK> {
  @Modifying
  @Transactional
  @Query("delete from MedicRegimenService a where a.regimenId =:regimenId")
  void deleteRegimenId(@Param("regimenId") int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TreatmentRegimen\RegimenServiceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */