package nencer.app.Modules.Medic.Repository;

import nencer.app.Modules.Medic.Entity.Location.MedicLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<MedicLocations, Integer>, JpaSpecificationExecutor<MedicLocations> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\LocationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */