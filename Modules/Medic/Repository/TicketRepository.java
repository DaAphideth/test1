package nencer.app.Modules.Medic.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicket;
import nencer.app.Modules.Medic.Model.Ticket.TicketGroupResponseInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<MedicTicket, Integer>, JpaSpecificationExecutor<MedicTicket> {
  Optional<List<MedicTicket>> findAllByTicketTypeAndServiceGroupCodeAndMdIdOrderByCreatedAtDesc(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT u FROM MedicTicket u WHERE u.ticketType=:ticketType AND u.mdId=:mdId order by u.createdAt desc")
  Optional<List<MedicTicket>> findAllByTicketTypeAndMdId(String paramString, Integer paramInteger);
  
  @Query("SELECT u FROM MedicTicket u WHERE u.ticketType=:ticketType AND u.id=:id")
  Optional<MedicTicket> findByIdAndTicketType(Integer paramInteger, String paramString);
  
  @Query(value = "select q.service_group_code code,q.code_name name,COUNT(q.id) services from \n(select m1_0.service_group_code,m2_0.code_name,m1_0.id\nfrom medic_ticket m1_0 \njoin medic_service_groups m2_0 on m2_0.code=m1_0.service_group_code \nwhere m1_0.md_id=:mdId and m1_0.ticket_type=:ticketType\nUNION \nselect m1_0.service_group_code,m2_0.code_name,m1_0.id\nfrom medic_ticket m1_0 \njoin medic_service_groups m2_0 on m2_0.code=m1_0.service_group_code \nwhere m1_0.md_id=:mdId and m1_0.ticket_type=:ticketType)q\ngroup by q.service_group_code,q.code_name\norder by q.service_group_code", nativeQuery = true)
  List<TicketGroupResponseInterface> findBy(@Param("mdId") Integer paramInteger, @Param("ticketType") String paramString);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET u.roomHandleIds=:roomHandleIds, u.roomSampleIds=:roomSampleIds , u.roomSampleStatus=:roomSampleStatus , u.roomHandleStatus=:roomHandleStatus WHERE u.id=:id")
  void updateRoomHandlerSampleIds(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET  u.isShowSample=:status , u.status=:ticketStatus WHERE u.id=:id")
  void updateStatus(Integer paramInteger1, String paramString, Integer paramInteger2);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET  u.status=:ticketStatus WHERE u.id=:id")
  void updateStatus(Integer paramInteger, String paramString);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET u.roomHandleStatus=:status , u.roomHandleResultBy=:resultBy , u.roomHandleResultDate=:date , u.isDeleteHandle=:statusDelete WHERE u.id=:id")
  void updateRoomHandleStatus(Integer paramInteger1, String paramString1, String paramString2, Date paramDate, Integer paramInteger2);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET u.roomHandleStatus=:status WHERE u.id=:id")
  void updateRoomHanderStatus(Integer paramInteger, String paramString);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u set u.status=:ticketStatus WHERE u.id=:id")
  void updateStatusByOrder(Integer paramInteger, String paramString);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicTicket u SET u.parentTicketId = :ticketId, u.status = :status WHERE u.id in :ids")
  void updateParentTicketId(@Param("ticketId") Integer paramInteger, @Param("ids") Set<Integer> paramSet, @Param("status") String paramString);
  
  List<MedicTicket> findAllByIdIn(Set<Integer> paramSet);
  
  List<MedicTicket> findAllByIdInAndStatusNot(Set<Integer> paramSet, String paramString);
  
  @Query("SELECT COUNT(u) FROM MedicTicket u WHERE u.id=:id")
  Integer havingTicket(Integer paramInteger);
  
  @Query("SELECT u.id FROM MedicTicket u WHERE u.barCode=:barCode")
  Integer getByBarcode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TicketRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */