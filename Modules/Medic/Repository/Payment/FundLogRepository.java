package nencer.app.Modules.Medic.Repository.Payment;

import nencer.app.Modules.Medic.Entity.Fund.FundLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FundLogRepository extends JpaRepository<FundLogs, Integer>, JpaSpecificationExecutor<FundLogs> {
  Page<FundLogs> findAllByCheckinIdAndStatusNot(Integer paramInteger, String paramString, PageRequest paramPageRequest);
  
  @Query("SELECT SUM(a.netAmount) FROM FundLogs a WHERE a.checkinId = :checkinId AND a.orderType= :type AND a.status <> 'CANCEL'")
  Double countReimbursement(Integer paramInteger, String paramString);
  
  Page<FundLogs> findAllByCheckinId(Integer paramInteger, PageRequest paramPageRequest);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Payment\FundLogRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */