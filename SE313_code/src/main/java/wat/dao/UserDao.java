package wat.dao;

import wat.entity.User;

import java.util.List;

/**
 * Created by P-OniSawa on 14/5/2558.
 */
public interface UserDao {
    User addUser(User user);
List<User> getUsers();
}
