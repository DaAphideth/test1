package nencer.app.Modules.Storehouse.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Drugs.MedicProductCats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductCatsRepository extends JpaRepository<MedicProductCats, Integer>, JpaSpecificationExecutor<MedicProductCats> {
  Optional<List<MedicProductCats>> findAllByStatus(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductCatsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */