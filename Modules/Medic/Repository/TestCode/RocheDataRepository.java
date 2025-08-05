package nencer.app.Modules.Medic.Repository.TestCode;

import java.util.List;
import nencer.app.Modules.Medic.Entity.Roche.RocheData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RocheDataRepository extends JpaRepository<RocheData, Integer> {
  @Query("SELECT u FROM RocheData  u WHERE u.ticketId=:ticketId ORDER BY u.createdAt DESC ")
  List<RocheData> findByTicketId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TestCode\RocheDataRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */