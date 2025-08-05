package nencer.app.Modules.Storehouse.Repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Storehouse.Entity.MedicProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicProductRepository extends JpaRepository<MedicProduct, Integer>, JpaSpecificationExecutor<MedicProduct> {
  Optional<List<MedicProduct>> findAllByStatus(Integer paramInteger);
  
  Optional<MedicProduct> findByCode(String paramString);
  
  Optional<List<MedicProduct>> findByActiveIngCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update MedicProduct s set s.status = 2 where s.id = :id ")
  void updateProductStatus(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */