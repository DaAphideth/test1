package nencer.app.Modules.Medic.Repository.Checkin;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicCheckinRecordRepository extends JpaRepository<MedicCheckinRecord, Integer>, JpaSpecificationExecutor<MedicCheckinRecord> {
  @Query("SELECT u.mdId FROM MedicCheckinRecord u WHERE u.mdId=:mdId")
  Optional<Integer> findByMdId(Integer paramInteger);
  
  @Query("SELECT u FROM MedicCheckinRecord u WHERE u.checkinId=:checkinId ORDER BY u.createdAt DESC ")
  List<MedicCheckinRecord> findAllByCheckinId(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckinRecord u set u.status = :status where u.mdId = :mdId")
  void updateStatus(@Param("mdId") Integer paramInteger, @Param("status") String paramString);
  
  @Query("select u.mdId from MedicCheckinRecord u where u.checkinId = :checkinId")
  List<Integer> findIntergerAllByCheckinId(Integer paramInteger);
  
  Optional<List<MedicCheckinRecord>> findByCheckinIdAndStatusInAndMdTypeOrderByCreatedAtDesc(Integer paramInteger, List<String> paramList, String paramString);
  
  Optional<List<MedicCheckinRecord>> findByCheckinIdAndStatusAndMdTypeOrderByCreatedAtDesc(Integer paramInteger, String paramString1, String paramString2);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckinRecord u set u.paymentStatus = :status where u.mdId = :mdId")
  void updatePaymentStatus(@Param("mdId") Integer paramInteger, @Param("status") String paramString);
  
  List<MedicCheckinRecord> findAllByCheckinIdAndMdTypeAndStatusIn(Integer paramInteger, String paramString, List<String> paramList);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckinRecord u set u.number = :number where u.mdId = :mdId")
  void updateStt(@Param("mdId") Integer paramInteger1, @Param("number") Integer paramInteger2);
  
  @Transactional
  @Modifying
  @Query("delete from MedicCheckinRecord u where u.mdIdBefore = :mdId")
  void deleteHospitalize(@Param("mdId") Integer paramInteger);
  
  Optional<List<MedicCheckinRecord>> findAllByBedId(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("update MedicCheckinRecord u set u.paymentStatus = :paymentStatus where u.mdId = :mdId")
  void updatePayemntStatus(@Param("mdId") Integer paramInteger, @Param("paymentStatus") String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\MedicCheckinRecordRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */