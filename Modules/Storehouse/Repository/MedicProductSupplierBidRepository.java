package nencer.app.Modules.Storehouse.Repository;

import nencer.app.Modules.Storehouse.Entity.MedicProductSupplierBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductSupplierBidRepository extends JpaRepository<MedicProductSupplierBid, Integer>, JpaSpecificationExecutor<MedicProductSupplierBid> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductSupplierBidRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */