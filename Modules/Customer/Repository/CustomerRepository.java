package nencer.app.Modules.Customer.Repository;

import java.util.Optional;
import nencer.app.Modules.Customer.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
  Optional<Customers> findByIdCardOrId(String paramString, Integer paramInteger);
  
  @Query("select u.name from Customers u where u.id = :id")
  String findNameById(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Customer\Repository\CustomerRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */