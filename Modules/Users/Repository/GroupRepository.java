package nencer.app.Modules.Users.Repository;

import nencer.app.Modules.Users.Entity.Group.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Integer> {
  @Query("select count(u) from Groups u where u.code=:code")
  Integer checkExitCode(@Param("code") String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\GroupRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */