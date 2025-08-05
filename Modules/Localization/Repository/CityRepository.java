package nencer.app.Modules.Localization.Repository;

import java.util.Optional;
import nencer.app.Modules.Localization.Entity.LocalCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CityRepository extends JpaRepository<LocalCities, Integer>, JpaSpecificationExecutor<LocalCities> {
  Optional<LocalCities> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update LocalCities s set s.status = 2 where s.id =:id")
  void updateCityStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\CityRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */