package nencer.app.Modules.Medic.Repository.Checkin;

import java.util.List;
import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinStt;
import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicCheckinSttRepository extends JpaRepository<MedicCheckinStt, Integer>, JpaSpecificationExecutor<MedicCheckinRecord> {
  @Query(value = "select co.id, co.number as number,  calling_number as callingNumber FROM( \nSELECT *   \nFROM medic_checkin_stt co   \nWHERE 1=1 \n-- AND co.date_time LIKE CONCAT('%', date_format(sysdate(), '%Y%m%d'),'%')\nAND co.calling_number IS NOT NULL  \nAND co.`status`=:status    \nAND co.room_id=:roomId \nORDER BY co.number DESC \nLIMIT 1\n)co", nativeQuery = true)
  CustomerOrdinal getCallingNumber1(Integer paramInteger, String paramString);
  
  @Query(value = " SELECT co.id, co.number as number, co.md_id as mdId,calling_number as callingNumber FROM medic_checkin_stt co\n where co.number = :callingNumber AND co.room_id=:roomId", nativeQuery = true)
  CustomerOrdinal findByNumberAndNameRoom(Integer paramInteger1, Integer paramInteger2);
  
  MedicCheckinStt findFirstByNumberAndRoomId(Integer paramInteger1, Integer paramInteger2);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicCheckinStt co SET co.callingNumber=:callingNumber, co.status='CALLED' where co.id=:id")
  void updateCallingNumber1(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT u FROM MedicCheckinStt u WHERE u.roomId=:roomId AND u.status='CALLED' ORDER BY u.callingNumber DESC")
  List<MedicCheckinStt> findByRoomId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\MedicCheckinSttRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */