package nencer.app.Modules.Medic.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Diagnostic.MedicDiagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DiagnosticRepository extends JpaRepository<MedicDiagnostic, Integer>, JpaSpecificationExecutor<MedicDiagnostic> {
  @Query("SELECT u FROM MedicDiagnostic  u where u.status=1")
  Optional<List<MedicDiagnostic>> findAllByStatus();
  
  @Query("SELECT u FROM MedicDiagnostic u WHERE (u.code =:value OR u.name LIKE concat('%',:value,'%'))  AND  u.status=1 ORDER BY u.name DESC")
  Optional<List<MedicDiagnostic>> findByValue(String paramString);
  
  Optional<MedicDiagnostic> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update MedicDiagnostic d set d.status = 2 where d.id =:id")
  void updateMedicDiagnosticStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\DiagnosticRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */