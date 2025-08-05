package nencer.app.Modules.Users.Repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import nencer.app.Modules.Users.Entity.User.Users;
import nencer.app.Modules.Users.Model.User.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
  @Query("SELECT u from Users u where u.username=:username")
  Optional<Users> findByUsername(@Param("username") String paramString);
  
  @Query("SELECT u from Users u where u.username=:username or u.email = :email")
  Optional<Users> findByUsernameOrEmail(@Param("username") String paramString1, @Param("email") String paramString2);
  
  @Query("SELECT u from Users u")
  List<UserResponse> getAllUserResponse();
  
  @Modifying
  @Transactional
  @Query("update Users u set u.apiToken = :accessToken, u.rememberToken = :rememberToken, u.lastLoginIp =:lastLoginIp where u.id = :id")
  void updateTokenById(@Param("id") Integer paramInteger, @Param("accessToken") String paramString1, @Param("rememberToken") String paramString2, @Param("lastLoginIp") String paramString3);
  
  Optional<Users> findByApiToken(String paramString);
  
  Optional<Users> findByRememberToken(String paramString);
  
  @Query(value = "SELECT * from users u where u.group=:group and u.status = 1", nativeQuery = true)
  Optional<List<Users>> findAllByGroups(@Param("group") Integer paramInteger);
  
  @Query("select u.name from Users u where u.id = :id ")
  String findNameById(Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\UserRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */