package nencer.app.Modules.System.Repository;

import java.util.Date;
import nencer.app.Modules.System.Entity.News.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
  @Query("select u from News u where (:to is null or :to<=u.createdAt) and (:from is null or :from>=u.createdAt) and (:language is null or u.language=:language) and (:author is null or u.author=:author) and (:status is null or u.status=:status) and (:title is null or u.title like concat('%',:title,'%'))")
  Page<News> page(Pageable paramPageable, @Param("from") Date paramDate1, @Param("to") Date paramDate2, @Param("title") String paramString1, @Param("author") String paramString2, @Param("status") String paramString3, @Param("language") String paramString4);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\System\Repository\NewsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */