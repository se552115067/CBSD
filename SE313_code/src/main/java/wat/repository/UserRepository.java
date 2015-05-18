package wat.repository;

import wat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);


}