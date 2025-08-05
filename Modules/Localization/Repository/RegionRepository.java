package nencer.app.Modules.Localization.Repository;

import javax.transaction.Transactional;
import nencer.app.Modules.Localization.Entity.LocalRegions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<LocalRegions, Integer>, JpaSpecificationExecutor<LocalRegions> {
  @Modifying
  @Transactional
  @Query("update LocalRegions s set s.status = 2 where s.id =:id")
  void updateRegionsStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\RegionRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */