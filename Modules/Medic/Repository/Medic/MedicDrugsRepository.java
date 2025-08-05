package nencer.app.Modules.Medic.Repository.Medic;

import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicDrugsRepository extends JpaRepository<MedicDrugs, Integer>, JpaSpecificationExecutor<MedicDrugs> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Medic\MedicDrugsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */