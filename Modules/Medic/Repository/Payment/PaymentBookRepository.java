package nencer.app.Modules.Medic.Repository.Payment;

import nencer.app.Modules.Medic.Entity.Fund.PaymentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentBookRepository extends JpaRepository<PaymentBook, Integer>, JpaSpecificationExecutor<PaymentBook> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Payment\PaymentBookRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */