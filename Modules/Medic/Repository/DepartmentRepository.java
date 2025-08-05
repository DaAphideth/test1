package nencer.app.Modules.Medic.Repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Medic.Entity.Department.MedicDepartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<MedicDepartments, Integer>, JpaSpecificationExecutor<MedicDepartments> {
  Optional<MedicDepartments> findByCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("update MedicDepartments s set s.status = 2 where s.id = :id ")
  void updateMedicDepartmentStatus(@Param("id") Integer paramInteger);
  
  @Query(value = "SELECT * FROM medic_departments a WHERE FIND_IN_SET(:userId ,a.allow_users) AND a.`status`='1'", nativeQuery = true)
  Optional<List<MedicDepartments>> findByAllowUserId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\DepartmentRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */