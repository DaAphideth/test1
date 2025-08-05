package nencer.app.Modules.Medic.Repository;

import java.util.Optional;
import nencer.app.Modules.Medic.Entity.TemplateService.MedicTemplateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateServiceRepository extends JpaRepository<MedicTemplateService, Integer>, JpaSpecificationExecutor<MedicTemplateService> {
  Optional<MedicTemplateService> findByName(String paramString);
  
  Optional<MedicTemplateService> findByCode(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\TemplateServiceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */