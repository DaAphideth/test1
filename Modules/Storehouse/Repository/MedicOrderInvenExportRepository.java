package nencer.app.Modules.Storehouse.Repository;

import java.util.List;
import javax.transaction.Transactional;
import nencer.app.Modules.Storehouse.Entity.MedicOrderInvenExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicOrderInvenExportRepository extends JpaRepository<MedicOrderInvenExport, Integer>, JpaSpecificationExecutor<MedicOrderInvenExport> {
  List<MedicOrderInvenExport> getAllByOrderDetailId(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicOrderInvenExport u WHERE u.orderDetailId=:id and u.invenId = :invenId")
  void deleteByDetailIdAndInvenId(Integer paramInteger1, Integer paramInteger2);
  
  @Modifying
  @Transactional
  @Query("DELETE FROM MedicOrderInvenExport u WHERE u.orderDetailId=:id")
  void deleteByDetailId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicOrderInvenExportRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */