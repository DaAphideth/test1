package nencer.app.Modules.System.Repository;

import nencer.app.Modules.System.Entity.Currency.CurrenciesCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyCodeRepository extends JpaRepository<CurrenciesCode, String> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Repository\CurrencyCodeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */