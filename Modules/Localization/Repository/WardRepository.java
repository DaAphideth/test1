package nencer.app.Modules.Localization.Repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Localization.Entity.LocalWards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<LocalWards, Integer> {
  Optional<List<LocalWards>> findByDistrictCode(String paramString);
  
  Optional<LocalWards> findByCode(String paramString);
  
  Optional<List<LocalWards>> findAllByShortCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update LocalWards w set w.status = 2 where w.id =:id")
  void updateWardStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Localization\Repository\WardRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */