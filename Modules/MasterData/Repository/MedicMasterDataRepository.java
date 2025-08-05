package nencer.app.Modules.MasterData.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.MasterData.Entity.MedicMasterData;
import nencer.app.Modules.MasterData.Model.TypeMdm;
import nencer.app.Modules.Storehouse.Entity.MedicProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicMasterDataRepository extends JpaRepository<MedicMasterData, Integer>, JpaSpecificationExecutor<MedicProduct> {
  List<MedicMasterData> findAllByMedicType(String paramString);
  
  Optional<MedicMasterData> findByMedicCode(String paramString);
  
  Optional<List<MedicMasterData>> findAllByMedicTypeAndDefaultValue(String paramString1, String paramString2);
  
  Optional<MedicMasterData> findByMedicTypeAndMedicCode(String paramString1, String paramString2);
  
  @Query("SELECT u FROM MedicMasterData u where u.medicType = :medicType and u.medicCode like :medicCode%")
  List<MedicMasterData> findByMedicTypeAndMedicCodeLike(@Param("medicType") String paramString1, @Param("medicCode") String paramString2);
  
  @Query("select distinct u.medicType as medicType, u.medicTypeName as medicTypeName from MedicMasterData u where u.medicTypeName is not null")
  List<TypeMdm> getAllType();
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\MasterData\Repository\MedicMasterDataRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */