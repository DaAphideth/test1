package nencer.app.Modules.Users.Repository;

import javax.transaction.Transactional;
import nencer.app.Modules.Users.Entity.User.UserHasRoles;
import nencer.app.Modules.Users.Entity.User.UserHasRolesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelHasRolesRepository extends JpaRepository<UserHasRoles, UserHasRolesPK> {
  @Transactional
  @Modifying
  @Query(value = "insert into user_has_roles (role_id,model_type,usr_uid) VALUES (:roleId,:modelType, :modelId)", nativeQuery = true)
  void saveMHR(@Param("roleId") Integer paramInteger1, @Param("modelType") String paramString, @Param("modelId") Integer paramInteger2);
  
  @Transactional
  @Modifying
  void deleteAllByUsrUid(@Param("usrUid") Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\ModelHasRolesRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */