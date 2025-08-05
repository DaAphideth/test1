package nencer.app.Modules.Medic.Repository.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Service.MedicServiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<MedicServiceTypes, Integer>, JpaSpecificationExecutor<MedicServiceTypes> {
  Optional<MedicServiceTypes> findByName(String paramString);
  
  Optional<List<MedicServiceTypes>> findAllByStatusOrderBySort(Integer paramInteger);
  
  Optional<List<MedicServiceTypes>> findAllByServiceGroupIdAndStatus(Integer paramInteger1, Integer paramInteger2);
  
  @Modifying
  @Transactional
  @Query("update MedicServiceTypes s set s.status = 2 where s.id = :id ")
  void updateServiceTypeStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Service\ServiceTypeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */