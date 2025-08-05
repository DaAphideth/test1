package nencer.app.Modules.Users.Entity.User;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class UserHasRolesPK implements Serializable {
  @Column(name = "role_id")
  @Id
  private Integer roleId;
  
  @Column(name = "usr_uid")
  @Id
  private Integer usrUid;
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Entity\User\UserHasRolesPK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */