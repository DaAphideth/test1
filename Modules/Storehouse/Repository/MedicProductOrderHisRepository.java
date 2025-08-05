package nencer.app.Modules.Storehouse.Repository;

import java.util.List;
import nencer.app.Modules.Storehouse.Entity.MedicProductOrderHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductOrderHisRepository extends JpaRepository<MedicProductOrderHis, Integer>, JpaSpecificationExecutor<MedicProductOrderHis> {
  List<MedicProductOrderHis> findAllByFundLogId(int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductOrderHisRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */