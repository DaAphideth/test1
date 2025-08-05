package nencer.app.Modules.Customer.Repository;

import java.util.Optional;
import nencer.app.Modules.Customer.Entity.CustomersInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersInsuranceRepository extends JpaRepository<CustomersInsurance, Integer> {
  Optional<CustomersInsurance> findByCustomerId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Repository\CustomersInsuranceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */