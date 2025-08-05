package nencer.app.Modules.Users.Repository;

import java.util.Optional;
import nencer.app.Modules.Users.Entity.User.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Integer>, JpaSpecificationExecutor<Permissions> {
  @Query("select count(u) from Permissions u where u.perName=:name")
  boolean checkRolesUsePermissions(Long paramLong);
  
  Optional<Permissions> getRolesByPerCodeAndPerMenu(String paramString, Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\PermissionsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */