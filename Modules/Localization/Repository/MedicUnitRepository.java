package nencer.app.Modules.Localization.Repository;

import java.util.Optional;
import nencer.app.Modules.Localization.Entity.MedicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicUnitRepository extends JpaRepository<MedicUnit, Integer>, JpaSpecificationExecutor<MedicUnit> {
  Optional<MedicUnit> findByKey(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\MedicUnitRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */