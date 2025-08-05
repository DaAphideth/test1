package nencer.app.Modules.System.Repository;

import java.util.Optional;
import nencer.app.Modules.System.Entity.Menu.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
  @Query("select u from Menu u where ( :language is null or u.language like concat('%',:language,'%'))")
  Page<Menu> page(Pageable paramPageable, @Param("language") String paramString);
  
  Optional<Menu> findByName(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Repository\MenuRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */