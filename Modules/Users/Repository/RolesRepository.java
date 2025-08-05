package nencer.app.Modules.Users.Repository;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Users.Entity.Role.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>, JpaSpecificationExecutor<Roles> {
  Optional<Roles> getRolesByName(String paramString);
  
  @Query("select a.name from Roles a inner join UserHasRoles b on a.id = b.roleId where b.usrUid = :usrUid ")
  List<String> getRolesByUsers(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\RolesRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */