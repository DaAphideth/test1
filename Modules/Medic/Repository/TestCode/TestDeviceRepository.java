package nencer.app.Modules.Medic.Repository.TestCode;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.TestCode.MedicTestDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TestDeviceRepository extends JpaRepository<MedicTestDevice, Integer> {
  Optional<List<MedicTestDevice>> findAllByStatus(String paramString);
  
  Optional<List<MedicTestDevice>> findByCodeAndStatus(String paramString1, String paramString2);
  
  Optional<MedicTestDevice> findByCode(String paramString);
  
  @Transactional
  @Modifying
  @Query("delete from MedicTestDevice a where a.id = :id")
  void deleteByTestDevice(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TestCode\TestDeviceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */