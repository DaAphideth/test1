package nencer.app.CacheRedis;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheDataRepository extends CrudRepository<CacheData, String> {
  @Modifying
  @Transactional
  void deleteById(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\CacheRedis\CacheDataRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */