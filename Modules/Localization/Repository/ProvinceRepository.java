package nencer.app.Modules.Localization.Repository;

import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Localization.Entity.LocalProvinces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<LocalProvinces, Integer>, JpaSpecificationExecutor<LocalProvinces> {
  Optional<LocalProvinces> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update LocalProvinces p set p.status = 2 where p.id =:id")
  void updateProvincesStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\ProvinceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */