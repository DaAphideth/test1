package nencer.app.Modules.Medic.Repository.Medic;

import java.util.List;
import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicDrugIngredientsRepository extends JpaRepository<MedicDrugIngredients, Integer>, JpaSpecificationExecutor<MedicDrugIngredients> {
  List<MedicDrugIngredients> findAllByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Medic\MedicDrugIngredientsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */