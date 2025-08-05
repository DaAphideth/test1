package nencer.app.Modules.Medic.Repository;

import java.util.List;
import nencer.app.Modules.Medic.Entity.OrderService.MedicOrderServicesHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServicesHisRepository extends JpaRepository<MedicOrderServicesHis, Integer> {
  List<MedicOrderServicesHis> findAllByFundLogId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\OrderServicesHisRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */