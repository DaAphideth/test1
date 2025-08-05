package nencer.app.Modules.Storehouse.Repository;

import nencer.app.Modules.Storehouse.Entity.MedicProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductSupplierRepository extends JpaRepository<MedicProductSupplier, Integer>, JpaSpecificationExecutor<MedicProductSupplier> {
  MedicProductSupplier findByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductSupplierRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */