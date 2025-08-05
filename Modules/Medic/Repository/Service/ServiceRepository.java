package nencer.app.Modules.Medic.Repository.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Service.MedicServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<MedicServices, Integer>, JpaSpecificationExecutor<MedicServices> {
  Optional<List<MedicServices>> findAllByOrderBySort();
  
  Optional<MedicServices> findByName(String paramString);
  
  Optional<MedicServices> findByCode(String paramString);
  
  Optional<List<MedicServices>> findAllByServiceTypeId(Integer paramInteger);
  
  Optional<List<MedicServices>> findAllByStatus(Integer paramInteger);
  
  Optional<List<MedicServices>> findAllByServiceGroupIdAndStatus(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT u FROM MedicServices  u WHERE u.status=:status AND u.serviceGroupId=:serviceGroupId")
  Optional<List<MedicServices>> findByServiceGroupId(Integer paramInteger1, Integer paramInteger2);
  
  Optional<List<MedicServices>> findAllByParentIdAndStatus(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT COUNT(u) FROM MedicServices u WHERE u.serviceGroupId=:serviceGroupId")
  Integer findUsedServiceGroup(Integer paramInteger);
  
  @Query(value = "SELECT * FROM medic_services a WHERE a.room_handle_id like concat('%',:roomNumberId,'%') AND a.room_id=:roomId ORDER BY a.price DESC  LIMIT 1", nativeQuery = true)
  Optional<MedicServices> findByRoomIdAndRoomNumberId(@Param("roomNumberId") String paramString1, @Param("roomId") String paramString2);
  
  @Query("SELECT u.name,u.code,u.price FROM MedicServices u WHERE (u.name LIKE concat('%',:name,'%'))  ORDER BY u.price DESC")
  Optional<List<MedicServices>> findByCodeLikeOrderBySort(@Param("name") String paramString);
  
  @Modifying
  @Transactional
  @Query("update MedicServices s set s.status = 2 where s.id = :id ")
  void updateServiceStatus(@Param("id") Integer paramInteger);
  
  @Query("select u.id from MedicTicket u where u.mdId = :mdId")
  List<Integer> findTicketIdsByMdId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Service\ServiceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */