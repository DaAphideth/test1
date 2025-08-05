package nencer.app.Modules.Users.Repository;

import java.util.List;
import javax.transaction.Transactional;
import nencer.app.Modules.Users.Entity.Role.RoleHasPermissions;
import nencer.app.Modules.Users.Entity.Role.RoleHasPermissionsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleHasPermissionsRepository extends JpaRepository<RoleHasPermissions, RoleHasPermissionsPK> {
  @Transactional
  @Modifying
  @Query(value = "insert into role_has_permissions (per_id, role_id) VALUES (:perId, :roleId)", nativeQuery = true)
  void saveRHP(@Param("perId") Integer paramInteger1, @Param("roleId") Integer paramInteger2);
  
  @Transactional
  @Modifying
  @Query(value = "delete from role_has_permissions where role_id = :roleId", nativeQuery = true)
  void deleteAllByRoleId(@Param("roleId") Integer paramInteger);
  
  List<RoleHasPermissions> findAllByPerId(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\RoleHasPermissionsRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */