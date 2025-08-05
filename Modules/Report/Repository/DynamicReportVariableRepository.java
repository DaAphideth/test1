package nencer.app.Modules.Report.Repository;

import java.util.List;
import javax.transaction.Transactional;
import nencer.app.Modules.Report.Entity.DynamicReportVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicReportVariableRepository extends JpaRepository<DynamicReportVariable, Integer> {
  List<DynamicReportVariable> getAllByRpId(Integer paramInteger);
  
  @Transactional
  @Modifying
  void deleteAllByRpId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Report\Repository\DynamicReportVariableRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */