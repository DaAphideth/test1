package nencer.app.Modules.Medic.Repository.Medic;

import nencer.app.Modules.Medic.Entity.Drugs.MedicDrugVendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicDrugVendorsRepository extends JpaRepository<MedicDrugVendors, Integer>, JpaSpecificationExecutor<MedicDrugVendors> {
  MedicDrugVendors findByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Medic\MedicDrugVendorsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */