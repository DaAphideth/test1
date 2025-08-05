package nencer.app.Modules.Medic.Repository.Insurance;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Insurance.MedicInsuranceCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCardsRepository extends JpaRepository<MedicInsuranceCards, Integer>, JpaSpecificationExecutor<MedicInsuranceCards> {
  Optional<MedicInsuranceCards> findByInsuranceCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Insurance\InsuranceCardsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */