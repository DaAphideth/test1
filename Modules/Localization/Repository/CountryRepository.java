package nencer.app.Modules.Localization.Repository;

import java.util.Optional;
import nencer.app.Modules.Localization.Entity.LocalCountries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CountryRepository extends JpaRepository<LocalCountries, Integer>, JpaSpecificationExecutor<LocalCountries> {
  Optional<LocalCountries> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update LocalCountries c set c.status = 2 where c.id =:id")
  void updateCountriesStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\CountryRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */