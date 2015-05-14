package wat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wat.entity.User;
import wat.repository.UserRepository;

/**
 * Created by P-OniSawa on 14/5/2558.
 */

@Repository
public class DbUserDao implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
