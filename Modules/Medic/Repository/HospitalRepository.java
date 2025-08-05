package nencer.app.Modules.Medic.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.Hospital.MedicHospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<MedicHospitals, Integer>, JpaSpecificationExecutor<MedicHospitals> {
  @Query("SELECT h FROM MedicHospitals h WHERE (h.code =:value OR h.name LIKE concat('%',:value,'%'))  ORDER BY h.name DESC")
  Optional<List<MedicHospitals>> findByValue(String paramString);
  
  Optional<MedicHospitals> findByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\HospitalRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */