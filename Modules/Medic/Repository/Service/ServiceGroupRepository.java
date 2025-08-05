package nencer.app.Modules.Medic.Repository.Service;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Service.MedicServiceGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceGroupRepository extends JpaRepository<MedicServiceGroups, Integer>, JpaSpecificationExecutor<MedicServiceGroups> {
  Optional<List<MedicServiceGroups>> findAlllByStatusOrderBySort(Integer paramInteger);
  
  @Query("SELECT COUNT(u) FROM MedicServiceGroups u WHERE u.code=:code and u.status=1 ")
  Integer findByCode(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Service\ServiceGroupRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */