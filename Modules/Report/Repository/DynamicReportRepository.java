package nencer.app.Modules.Report.Repository;

import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Report.Entity.DynamicReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicReportRepository extends JpaRepository<DynamicReport, Integer> {
  Optional<DynamicReport> findByRpCode(String paramString);
  
  @Modifying
  @Transactional
  void deleteByRpCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Repository\DynamicReportRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */