package nencer.app.Modules.Medic.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<MedicOrderServices, Integer> {
  Optional<List<MedicOrderServices>> findByMdIdOrderByPrice(Integer paramInteger);
  
  Optional<List<MedicOrderServices>> findAllByMdIdInOrderByCreatedAtDesc(List<Integer> paramList);
  
  Optional<MedicOrderServices> findByIdAndStatus(Integer paramInteger, String paramString);
  
  Optional<MedicOrderServices> findByMdIdAndServiceIdAndTicketId(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  @Query("SELECT u.id FROM MedicOrderServices u WHERE u.serviceId=:serviceId AND u.ticketId=:ticketId")
  Integer findByServiceIdAndTicketId(Integer paramInteger1, Integer paramInteger2);
  
  Optional<List<MedicOrderServices>> findByMdIdAndTicketId(Integer paramInteger1, Integer paramInteger2);
  
  Optional<List<MedicOrderServices>> findAllByTicketIdAndStatus(Integer paramInteger, String paramString);
  
  Optional<List<MedicOrderServices>> findAllByMdId(Integer paramInteger);
  
  Optional<List<MedicOrderServices>> findAllByServiceId(Integer paramInteger);
  
  @Modifying
  @Transactional
  void deleteAllByTicketId(Integer paramInteger);
  
  Optional<MedicOrderServices> findFirstByMdId(Integer paramInteger);
  
  Optional<MedicOrderServices> findByIdAndTicketId(Integer paramInteger1, Integer paramInteger2);
  
  Optional<List<MedicOrderServices>> findAllByTicketId(Integer paramInteger);
  
  List<MedicOrderServices> findAllByFundLogId(Integer paramInteger);
  
  @Query("select u from MedicOrderServices u inner join MedicCheckinRecord c on u.mdId = c.mdId where c.checkinId = :checkinId")
  List<MedicOrderServices> findAllByCheckinId(Integer paramInteger);
  
  @Query("SELECT COUNT(u) FROM MedicOrderServices u WHERE u.mdId=:mdId and u.status=:status")
  Integer havingOrderServicePayment(Integer paramInteger, String paramString);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServices  m Set m.lisHandlerResult=:lisHandlerResult, m.lisDeviceResult=:lisDeviceResult WHERE m.id=:id")
  void updateLisResult(@Param("id") Integer paramInteger, @Param("lisHandlerResult") String paramString1, @Param("lisDeviceResult") String paramString2);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServices  m Set m.lisOriginal=:lisOriginal,m.lisHandlerResult=:lisDeviceResult, m.lisDeviceResult=:lisDeviceResult WHERE m.id=:id")
  void updateLisResultRoche(@Param("id") Integer paramInteger, @Param("lisDeviceResult") String paramString1, @Param("lisOriginal") String paramString2);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServices  m Set m.risResult=:risResult , m.risFinish=:risFinish , m.risDevice=:risDevice , m.risResultBy=:risResultBy , m.machine= :machine, m.risStatus=:status , m.risResultDate=:risResultDate  WHERE m.id=:id")
  void updateRisResult(@Param("id") Integer paramInteger, @Param("risResult") String paramString1, @Param("risDevice") String paramString2, @Param("risResultBy") String paramString3, @Param("risFinish") String paramString4, @Param("machine") String paramString5, @Param("status") String paramString6, @Param("risResultDate") Date paramDate);
  
  @Modifying
  @Transactional
  @Query("UPDATE MedicOrderServices  m Set m.risStatus=:status  WHERE m.id=:id")
  void updateStatusRisResult(@Param("id") Integer paramInteger, @Param("status") String paramString);
  
  @Query("select u from MedicOrderServices u where u.ticketId in :medicTicketIds")
  Optional<List<MedicOrderServices>> findAllByTicketIds(List<Integer> paramList);
  
  @Modifying
  @Transactional
  @Query("update MedicOrderServices set serviceObject = :serviceObjectCode where id = :id ")
  void updatePaymentObject(Integer paramInteger, String paramString);
  
  @Query(value = "select * from medic_order_services where id = :id", nativeQuery = true)
  Optional<MedicOrderServices> findByIdQuery(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\OrderServiceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */