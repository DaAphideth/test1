package nencer.app.Modules.Medic.Repository.Room;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Room.MedicRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<MedicRooms, Integer>, JpaSpecificationExecutor<MedicRooms> {
  @Query("SELECT a FROM MedicRooms a INNER JOIN MedicRoomTypes b ON b.id=a.roomType AND b.code IN (:code) WHERE a.status=:status ORDER BY a.sort ")
  Optional<List<MedicRooms>> findByStatusOrderBySort(Integer paramInteger, List<String> paramList);
  
  Optional<List<MedicRooms>> findAllByStatus(Integer paramInteger);
  
  Optional<MedicRooms> findByName(String paramString);
  
  Optional<MedicRooms> findByCode(String paramString);
  
  Optional<List<MedicRooms>> findAllByRoomType(Integer paramInteger);
  
  @Query("select u from MedicRooms u where u.roomType = :roomType and u.allowUsers like concat('%',:doctorId,'%')")
  Optional<List<MedicRooms>> findAllByRoomTypeAndAllowUsers(Integer paramInteger, String paramString);
  
  @Query("select u from MedicRooms u inner join MedicRoomTypes f on u.roomType = f.id where 1=1 and (u.allowUsers LIKE concat('%',:doctorId,'%'))  and u.status = 1 and  f.code = :roomType")
  Optional<List<MedicRooms>> findAllByRoomTypeStAndDocterId(String paramString, Integer paramInteger);
  
  @Query("SELECT a FROM MedicRooms a WHERE a.status=1 and a.id in :id ")
  Optional<List<MedicRooms>> findAllByIdIn(List<Integer> paramList);
  
  @Modifying
  @Transactional
  @Query("update MedicRooms s set s.status = 2 where s.id = :id ")
  void updateRoomStatus(@Param("id") Integer paramInteger);
  
  Optional<List<MedicRooms>> findAllByDepartmentIdAndStatus(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Room\RoomRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */