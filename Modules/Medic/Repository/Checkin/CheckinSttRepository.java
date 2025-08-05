package nencer.app.Modules.Medic.Repository.Checkin;

import java.util.List;
import nencer.app.Modules.Medic.Entity.Checkin.MedicCheckinStt;
import nencer.app.Modules.Medic.Model.Checkin.CheckinSttInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinSttRepository extends JpaRepository<MedicCheckinStt, Integer>, JpaSpecificationExecutor<MedicCheckinStt> {
  @Query(value = "SELECT date_time as number FROM(\n\tSELECT MAX(CONVERT(substr(date_time,-:max,:max), SIGNED)) date_time from medic_checkin_stt  \n   where room_id=:roomId and date_time like CONCAT('%',date_format(sysdate(), '%Y%m%d'),'%')  \n   order by date_time desc\n) a", nativeQuery = true)
  List<CheckinSttInterface> getGenerateStt(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Checkin\CheckinSttRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */