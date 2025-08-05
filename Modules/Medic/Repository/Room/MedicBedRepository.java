package nencer.app.Modules.Medic.Repository.Room;

import nencer.app.Modules.Medic.Entity.Room.MedicBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicBedRepository extends JpaRepository<MedicBed, Integer>, JpaSpecificationExecutor<MedicBed> {
  MedicBed findByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Room\MedicBedRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */