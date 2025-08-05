package nencer.app.Modules.Customer.Repository;

import java.util.List;
import nencer.app.Modules.Customer.Entity.CustomerFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFamilyRepository extends JpaRepository<CustomerFamily, Integer> {
  List<CustomerFamily> findAllByCustomerId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Repository\CustomerFamilyRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */