package nencer.app.Modules.Medic.Repository.CustomerOrdinal;

import java.util.List;
import nencer.app.Modules.Medic.Entity.CustomerOrdinal.MedicOrdinalDoor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinalDoorRepository extends JpaRepository<MedicOrdinalDoor, Integer> {
  List<MedicOrdinalDoor> findAllByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\CustomerOrdinal\OrdinalDoorRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */