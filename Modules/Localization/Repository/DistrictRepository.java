package nencer.app.Modules.Localization.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Localization.Entity.LocalDistricts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DistrictRepository extends JpaRepository<LocalDistricts, Integer>, JpaSpecificationExecutor<LocalDistricts> {
  Optional<List<LocalDistricts>> findByProvinceCode(String paramString);
  
  Optional<LocalDistricts> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update LocalDistricts s set s.status = 2 where s.id =:id")
  void updateDistrictsStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\DistrictRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */