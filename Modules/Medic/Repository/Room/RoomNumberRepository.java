package nencer.app.Modules.Medic.Repository.Room;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Room.MedicRoomNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomNumberRepository extends JpaRepository<MedicRoomNumbers, Integer>, JpaSpecificationExecutor<MedicRoomNumbers> {
  Optional<List<MedicRoomNumbers>> findByStatusAndRoomIdOrderByName(Integer paramInteger1, Integer paramInteger2);
  
  Optional<MedicRoomNumbers> findByNumber(String paramString);
  
  Optional<List<MedicRoomNumbers>> findAllByRoomId(Integer paramInteger);
  
  Optional<List<MedicRoomNumbers>> findAllByStatus(Integer paramInteger);
  
  @Query("SELECT u FROM MedicRoomNumbers u WHERE (u.allowUsers LIKE concat('%',:doctorId,'%'))  AND (u.roomTypeCode LIKE concat('%',:roomType,'%'))  AND u.status=1ORDER BY u.name DESC")
  Optional<List<MedicRoomNumbers>> findByDoctorId(Integer paramInteger, String paramString);
  
  @Query("SELECT u FROM MedicRoomNumbers u WHERE (u.allowUsers LIKE concat('%',:doctorId,'%'))  AND u.status=1 AND u.id=:roomNumberId ORDER BY u.name DESC")
  Optional<MedicRoomNumbers> findByRoomIdAndAllowUsersLike(Integer paramInteger, String paramString);
  
  @Query("SELECT u FROM MedicRoomNumbers u WHERE u.id IN (:ids)")
  Optional<List<MedicRoomNumbers>> findAllByIds(List<Integer> paramList);
  
  @Modifying
  @Transactional
  @Query("update MedicRoomNumbers s set s.status = 2 where s.id = :id ")
  void updateRoomNumberStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Room\RoomNumberRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */