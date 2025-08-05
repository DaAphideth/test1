package nencer.app.Modules.Medic.Repository.TestCode;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.TestCode.MedicTestCodeMapping;
import nencer.app.Modules.Medic.Entity.TestCode.MedicTestCodeMappingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TestCodeMappingRepository extends JpaRepository<MedicTestCodeMapping, MedicTestCodeMappingPK> {
  Optional<MedicTestCodeMapping> findByTestCode(String paramString);
  
  MedicTestCodeMapping findAllByServiceId(Integer paramInteger);
  
  @Query("SELECT u.serviceId FROM MedicTestCodeMapping u WHERE u.testCode=:testCode")
  Integer findAllByTestCode2(String paramString);
  
  @Transactional
  @Modifying
  @Query("delete from MedicTestCodeMapping where testCode = :testCode")
  void deleteAllByTestCode(@Param("testCode") String paramString);
  
  List<MedicTestCodeMapping> findAllByTestCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TestCode\TestCodeMappingRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */