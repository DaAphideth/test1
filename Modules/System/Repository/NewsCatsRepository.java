package nencer.app.Modules.System.Repository;

import nencer.app.Modules.System.Entity.News.NewsCats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCatsRepository extends JpaRepository<NewsCats, Integer> {}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Repository\NewsCatsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */