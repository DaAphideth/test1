package nencer.app.Modules.Storehouse.Repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Storehouse.Entity.MedicProductStorehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductStorehouseRepository extends JpaRepository<MedicProductStorehouse, Integer>, JpaSpecificationExecutor<MedicProductStorehouse> {
  Optional<List<MedicProductStorehouse>> findAllByStatus(Integer paramInteger);
  
  List<MedicProductStorehouse> findAllByShType(String paramString);
  
  Optional<MedicProductStorehouse> findByCode(String paramString);
  
  Optional<MedicProductStorehouse> findByDepartmentId(Integer paramInteger);
  
  @Modifying
  @Transactional
  void deleteByDepartmentId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductStorehouseRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */