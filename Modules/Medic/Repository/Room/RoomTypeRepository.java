package nencer.app.Modules.Medic.Repository.Room;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Room.MedicRoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<MedicRoomTypes, Integer>, JpaSpecificationExecutor<MedicRoomTypes> {
  Optional<MedicRoomTypes> findByName(String paramString);
  
  Optional<MedicRoomTypes> findByCode(String paramString);
  
  Optional<List<MedicRoomTypes>> findAllByStatus(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("update MedicRoomTypes s set s.status = 2 where s.id = :id ")
  void updateRoomTypeStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Room\RoomTypeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */